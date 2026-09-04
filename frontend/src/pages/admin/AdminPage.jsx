import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { classApi, unitApi, chapterApi, missionApi, questionApi } from "../../api/client";
import "../../styles/admin.css";

export default function AdminPage() {
  const navigate = useNavigate();

  // Navigation hierarchy: CLASSES -> UNITS -> CHAPTERS -> MISSIONS -> QUESTION_FORM
  const [currentView, setCurrentView] = useState("CLASSES");

  // Selected hierarchy entities
  const [selectedClass, setSelectedClass] = useState(null);
  const [selectedUnit, setSelectedUnit] = useState(null);
  const [selectedChapter, setSelectedChapter] = useState(null);
  const [selectedMission, setSelectedMission] = useState(null);
  const [editingQuestion, setEditingQuestion] = useState(null);

  // Data state
  const [classes, setClasses] = useState([]);
  const [units, setUnits] = useState([]);
  const [chapters, setChapters] = useState([]);
  const [missions, setMissions] = useState([]);
  const [questions, setQuestions] = useState([]);

  // UI State
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");
  const [savedQuestionSuccess, setSavedQuestionSuccess] = useState(false);

  // Modals state
  const [showAddClassModal, setShowAddClassModal] = useState(false);
  const [editingClass, setEditingClass] = useState(null);
  const [classNameInput, setClassNameInput] = useState("");

  const [showAddUnitModal, setShowAddUnitModal] = useState(false);
  const [editingUnitItem, setEditingUnitItem] = useState(null);
  const [unitNameInput, setUnitNameInput] = useState("");

  const [showAddChapterModal, setShowAddChapterModal] = useState(false);
  const [editingChapterItem, setEditingChapterItem] = useState(null);
  const [chapterNameInput, setChapterNameInput] = useState("");

  const [deleteModal, setDeleteModal] = useState({ open: false, type: null, id: null, name: "" });

  // Question Form state
  const [qForm, setQForm] = useState({
    questionText: "",
    optionA: "",
    optionB: "",
    optionC: "",
    optionD: "",
    correctAnswer: "Option A",
    acceptedAnswers: "",
    scenarioType: "MCQ",
    codeLanguage: "Python",
    xp: 10,
  });

  const getAdminContext = () => {
    try {
      const stored = localStorage.getItem("cq_admin");
      return stored ? JSON.parse(stored) : null;
    } catch {
      return null;
    }
  };

  // Load Classes
  const loadClasses = async () => {
    setLoading(true);
    setError("");
    try {
      const admin = getAdminContext();
      const params = admin ? { adminId: admin.id } : {};
      const res = await classApi.getClasses(params);
      const list = res || [];
      // Deduplicate by classLevel and sort ascending (4th -> 12th)
      const seen = new Set();
      const distinct = [];
      for (const cls of list) {
        const lvl = cls.classLevel || parseInt((cls.className || "").replace(/\D+/g, ""), 10) || 0;
        if (!seen.has(lvl)) {
          seen.add(lvl);
          distinct.push({ ...cls, classLevel: lvl });
        }
      }
      distinct.sort((a, b) => a.classLevel - b.classLevel);
      setClasses(distinct);
    } catch (err) {
      setError(err.message || "Failed to load classes");
    } finally {
      setLoading(false);
    }
  };

  // Load Units for a Class
  const loadUnits = async (cls) => {
    setLoading(true);
    setError("");
    try {
      const admin = getAdminContext();
      const params = {
        classLevel: cls.classLevel || 11,
        board: cls.board || "CBSE",
        ...(admin?.id ? { adminId: admin.id } : {}),
      };
      const res = await unitApi.getUnits(params);
      const list = res || [];
      const distinctUnits = [];
      const seenUnits = new Set();
      for (const u of list) {
        const uNum = u.unitNumber || 0;
        if (!seenUnits.has(uNum)) {
          seenUnits.add(uNum);
          distinctUnits.push(u);
        }
      }
      distinctUnits.sort((a, b) => (a.unitNumber || 0) - (b.unitNumber || 0));
      setUnits(distinctUnits);
    } catch (err) {
      setError(err.message || "Failed to load units");
    } finally {
      setLoading(false);
    }
  };

  // Load Chapters for a Unit
  const loadChapters = async (unitObj) => {
    setLoading(true);
    setError("");
    try {
      const admin = getAdminContext();
      const params = {
        classLevel: selectedClass?.classLevel || 11,
        board: selectedClass?.board || "CBSE",
        ...(admin?.id ? { adminId: admin.id } : {}),
      };
      const allChapters = await chapterApi.getAll(params);
      const uName = (unitObj.unitName || "").toLowerCase().trim();
      const uNumPrefix = `unit ${unitObj.unitNumber}`.toLowerCase();
      const romanNums = ["i", "ii", "iii", "iv", "v", "vi", "vii", "viii", "ix", "x"];
      const uNumRomanPrefix = `unit ${romanNums[(unitObj.unitNumber || 1) - 1] || unitObj.unitNumber}`.toLowerCase();

      const filtered = (allChapters || []).filter(
        (c) =>
          c.unit === unitObj.unitName ||
          (c.unit && (
            c.unit.toLowerCase().trim() === uName ||
            c.unit.toLowerCase().startsWith(uNumPrefix) ||
            c.unit.toLowerCase().startsWith(uNumRomanPrefix)
          ))
      );
      const targetList = filtered.length > 0 ? filtered : allChapters;
      const seenCh = new Set();
      const distinctCh = [];
      for (const ch of targetList) {
        const chNum = ch.chapterNumber || 0;
        if (!seenCh.has(chNum)) {
          seenCh.add(chNum);
          distinctCh.push(ch);
        }
      }
      distinctCh.sort((a, b) => (a.chapterNumber || 0) - (b.chapterNumber || 0));
      setChapters(distinctCh);
    } catch (err) {
      setError(err.message || "Failed to load chapters");
    } finally {
      setLoading(false);
    }
  };

  // Load Missions for a Chapter
  const loadMissions = async (chObj) => {
    setLoading(true);
    setError("");
    try {
      const admin = getAdminContext();
      const params = {
        classLevel: selectedClass?.classLevel || 11,
        board: selectedClass?.board || "CBSE",
        ...(admin?.id ? { adminId: admin.id } : {}),
      };
      const allMissions = await missionApi.getAll(params);
      const filtered = (allMissions || []).filter(
        (m) => m.chapter && String(m.chapter.id) === String(chObj.id)
      );

      let loadedMissions = filtered;
      if (loadedMissions.length === 0) {
        loadedMissions = [1, 2, 3, 4].map((num) => ({
          id: num,
          missionNumber: num,
          gameType: num === 2 ? "Fill in the Blank" : num === 3 ? "Scenario Challenge" : "MCQ Quiz",
          chapter: chObj,
        }));
      }

      // Fetch questions count for each mission
      const updatedMissions = await Promise.all(
        loadedMissions.map(async (m) => {
          try {
            const qList = await questionApi.getForMission(
              selectedUnit?.unitName || chObj.unit || "Unit 1",
              chObj.chapterName,
              m.missionNumber,
              params
            );
            return { ...m, questionCount: (qList || []).length };
          } catch {
            return { ...m, questionCount: 0 };
          }
        })
      );

      updatedMissions.sort((a, b) => (a.missionNumber || 0) - (b.missionNumber || 0));
      setMissions(updatedMissions);
    } catch (err) {
      setError(err.message || "Failed to load missions");
    } finally {
      setLoading(false);
    }
  };

  // Load Questions for a Mission
  const loadQuestions = async (mObj) => {
    setLoading(true);
    setError("");
    try {
      const admin = getAdminContext();
      const params = {
        classLevel: selectedClass?.classLevel || 11,
        board: selectedClass?.board || "CBSE",
        ...(admin?.id ? { adminId: admin.id } : {}),
      };
      const res = await questionApi.getForMission(
        selectedUnit?.unitName || selectedChapter?.unit || "Unit 1",
        selectedChapter?.chapterName,
        mObj.missionNumber,
        params
      );
      setQuestions(res || []);
    } catch (err) {
      setError(err.message || "Failed to load questions");
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    loadClasses();
  }, []);

  // Drill down handlers
  const handleSelectClass = (cls) => {
    setSelectedClass(cls);
    setCurrentView("UNITS");
    loadUnits(cls);
  };

  const handleSelectUnit = (uObj) => {
    setSelectedUnit(uObj);
    setCurrentView("CHAPTERS");
    loadChapters(uObj);
  };

  const handleSelectChapter = (chObj) => {
    setSelectedChapter(chObj);
    setCurrentView("MISSIONS");
    loadMissions(chObj);
  };

  const handleOpenAddQuestion = (mObj) => {
    setSelectedMission(mObj);
    setEditingQuestion(null);
    setSavedQuestionSuccess(false);

    const defaultAnswer = mObj.gameType === "Fill in the Blank" ? "" : "Option A";
    setQForm({
      questionText: "",
      optionA: "",
      optionB: "",
      optionC: "",
      optionD: "",
      correctAnswer: defaultAnswer,
      acceptedAnswers: "",
      scenarioType: "MCQ",
      codeLanguage: "Python",
      xp: 10,
    });
    setCurrentView("QUESTION_FORM");
    loadQuestions(mObj);
  };

  const handleEditQuestionObj = (qObj) => {
    setEditingQuestion(qObj);
    setSavedQuestionSuccess(false);
    const isCodeScenario = qObj.questionType === "CODE_SQL" || qObj.questionType === "SCENARIO_CODE";
    setQForm({
      questionText: qObj.questionText || "",
      optionA: qObj.optionA || "",
      optionB: qObj.optionB || "",
      optionC: qObj.optionC || "",
      optionD: qObj.optionD || "",
      correctAnswer: qObj.correctAnswer
        ? qObj.correctAnswer.startsWith("Option ")
          ? qObj.correctAnswer
          : `Option ${qObj.correctAnswer}`
        : "Option A",
      acceptedAnswers: qObj.optionB || "",
      scenarioType: isCodeScenario ? "CODE_SQL" : "MCQ",
      codeLanguage: qObj.codeLanguage || "Python",
      xp: 10,
    });
    setCurrentView("QUESTION_FORM");
  };

  // Mission Game Type Change
  const handleGameTypeChange = async (missionObj, newType) => {
    try {
      if (missionObj.id && typeof missionObj.id === "number" && missionObj.chapter) {
        await missionApi.updateMission(missionObj.id, {
          ...missionObj,
          gameType: newType,
        });
      } else {
        const admin = getAdminContext();
        await missionApi.createMission({
          missionNumber: missionObj.missionNumber,
          gameType: newType,
          chapter: selectedChapter,
          school: admin?.school || null,
        });
      }
      setMissions((prev) =>
        prev.map((m) => (m.missionNumber === missionObj.missionNumber ? { ...m, gameType: newType } : m))
      );
    } catch (err) {
      setError("Failed to update mission game type: " + err.message);
    }
  };

  // Save Class CRUD
  const handleSaveClass = async () => {
    if (!classNameInput.trim()) return;
    try {
      const digits = classNameInput.replaceAll(/\D+/g, "");
      const classLevel = digits ? parseInt(digits, 10) : 11;
      const admin = getAdminContext();

      if (editingClass) {
        await classApi.updateClass(editingClass.id, {
          ...editingClass,
          className: classNameInput,
          classLevel,
        });
      } else {
        await classApi.createClass({
          className: classNameInput,
          classLevel,
          board: "CBSE",
          school: admin?.school || null,
          adminId: admin?.id || null,
        });
      }
      setShowAddClassModal(false);
      setEditingClass(null);
      setClassNameInput("");
      loadClasses();
    } catch (err) {
      setError(err.message);
    }
  };

  // Save Unit CRUD
  const handleSaveUnit = async () => {
    if (!unitNameInput.trim()) return;
    try {
      const admin = getAdminContext();
      if (editingUnitItem) {
        await unitApi.updateUnit(editingUnitItem.id, {
          ...editingUnitItem,
          unitName: unitNameInput,
        });
      } else {
        const nextNum = units.length + 1;
        await unitApi.createUnit({
          unitName: unitNameInput,
          unitNumber: nextNum,
          board: selectedClass?.board || "CBSE",
          classLevel: selectedClass?.classLevel || 11,
          school: admin?.school || null,
          adminId: admin?.id || null,
        });
      }
      setShowAddUnitModal(false);
      setEditingUnitItem(null);
      setUnitNameInput("");
      loadUnits(selectedClass);
    } catch (err) {
      setError(err.message);
    }
  };

  // Save Chapter CRUD
  const handleSaveChapter = async () => {
    if (!chapterNameInput.trim()) return;
    try {
      const admin = getAdminContext();
      if (editingChapterItem) {
        await chapterApi.updateChapter(editingChapterItem.id, {
          ...editingChapterItem,
          chapterName: chapterNameInput,
        });
      } else {
        const nextNum = chapters.length + 1;
        await chapterApi.createChapter({
          chapterName: chapterNameInput,
          chapterNumber: nextNum,
          unit: selectedUnit?.unitName || "Unit 1",
          unlocked: nextNum === 1,
          board: selectedClass?.board || "CBSE",
          classLevel: selectedClass?.classLevel || 11,
          school: admin?.school || null,
          adminId: admin?.id || null,
        });
      }
      setShowAddChapterModal(false);
      setEditingChapterItem(null);
      setChapterNameInput("");
      loadChapters(selectedUnit);
    } catch (err) {
      setError(err.message);
    }
  };

  // Save Question Submission
  const handleSaveQuestionSubmit = async (e) => {
    e.preventDefault();
    if (!qForm.questionText.trim()) {
      setError("Please enter the question/scenario text.");
      return;
    }

    if (questions.length >= 5 && !editingQuestion) {
      setError("Maximum limit of 5 questions per mission reached.");
      return;
    }

    const gameType = selectedMission?.gameType || "MCQ Quiz";
    const admin = getAdminContext();

    let questionType = "MCQ";
    let optionA = qForm.optionA;
    let optionB = qForm.optionB;
    let optionC = qForm.optionC;
    let optionD = qForm.optionD;
    let correctAnswer = qForm.correctAnswer;

    if (gameType === "Fill in the Blank") {
      questionType = "FILL_BLANK";
      correctAnswer = qForm.correctAnswer;
      optionB = qForm.acceptedAnswers;
    } else if (gameType === "Scenario Challenge") {
      if (qForm.scenarioType === "CODE_SQL") {
        questionType = "CODE_SQL";
        optionA = qForm.optionA;
        optionB = qForm.acceptedAnswers;
        correctAnswer = qForm.correctAnswer;
      } else {
        questionType = "SCENARIO";
        correctAnswer = qForm.correctAnswer.replace("Option ", "");
      }
    } else {
      questionType = "MCQ";
      correctAnswer = qForm.correctAnswer.replace("Option ", "");
    }

    const payload = {
      unit: selectedUnit?.unitName || selectedChapter?.unit || "Unit 1",
      chapter: selectedChapter?.chapterName,
      mission: selectedMission?.missionNumber || 1,
      questionType,
      questionText: qForm.questionText,
      optionA,
      optionB,
      optionC,
      optionD,
      correctAnswer,
      codeLanguage: questionType === "CODE_SQL" ? (qForm.codeLanguage || "Python") : null,
      board: selectedClass?.board || "CBSE",
      classLevel: selectedClass?.classLevel || 11,
      school: admin?.school || null,
      adminId: admin?.id || null,
      schoolId: admin?.school?.id || null,
    };

    try {
      if (editingQuestion) {
        await questionApi.updateQuestion(editingQuestion.id, payload);
      } else {
        await questionApi.createQuestion(payload);
      }
      setSavedQuestionSuccess(true);
      setError("");
      loadQuestions(selectedMission);
      if (selectedChapter) loadMissions(selectedChapter);
    } catch (err) {
      setError(err.message || "Failed to save question");
    }
  };

  // Confirm Delete Handler
  const executeDelete = async () => {
    const { type, id } = deleteModal;
    if (!id) return;
    try {
      if (type === "CLASS") {
        await classApi.deleteClass(id);
        loadClasses();
      } else if (type === "UNIT") {
        await unitApi.deleteUnit(id);
        loadUnits(selectedClass);
      } else if (type === "CHAPTER") {
        await chapterApi.deleteChapter(id);
        loadChapters(selectedUnit);
      } else if (type === "MISSION") {
        await missionApi.deleteMission(id);
        loadMissions(selectedChapter);
      } else if (type === "QUESTION") {
        await questionApi.deleteQuestion(id);
        if (editingQuestion && editingQuestion.id === id) {
          setEditingQuestion(null);
        }
        loadQuestions(selectedMission);
        if (selectedChapter) loadMissions(selectedChapter);
      }
      setDeleteModal({ open: false, type: null, id: null, name: "" });
    } catch (err) {
      setError("Failed to delete: " + err.message);
    }
  };

  const handleLogout = () => {
    localStorage.removeItem("cq_admin");
    navigate("/admin/login");
  };

  return (
    <div className="admin-shell">
      {/* Navigation Sidebar */}
      <aside className="admin-sidebar">
        <div className="admin-brand">
          <div className="brand-logo-box">
            <span className="brand-icon">🎓</span>
            <span className="brand-logo">Admin</span>
          </div>
        </div>

        <nav className="admin-nav">
          <button
            className={`admin-nav-item ${currentView === "CLASSES" ? "active" : ""}`}
            onClick={() => {
              setCurrentView("CLASSES");
              loadClasses();
            }}
          >
            <span className="nav-icon">📂</span>
            <span>Classes</span>
          </button>
        </nav>

        <div className="admin-sidebar-footer">
          <button className="admin-nav-item logout-btn" onClick={handleLogout}>
            <span className="nav-icon">🚪</span>
            <span>Logout</span>
          </button>
        </div>
      </aside>

      {/* Main Admin Workspace Area */}
      <main className="admin-main">
        <div className="admin-content-card">
          {error && <div className="admin-error-banner">{error}</div>}

          {/* SCREEN 1: CLASSES VIEW */}
          {currentView === "CLASSES" && (
            <div className="admin-view-container">
              <div className="admin-header-row">
                <h1 className="admin-page-title">Classes</h1>
                <button
                  className="btn-admin-blue"
                  onClick={() => {
                    setEditingClass(null);
                    setClassNameInput("");
                    setShowAddClassModal(true);
                  }}
                >
                  + Add Class
                </button>
              </div>

              <div className="admin-table-wrapper">
                <table className="admin-table">
                  <thead>
                    <tr>
                      <th>Class Name</th>
                      <th className="text-right">Actions</th>
                    </tr>
                  </thead>
                  <tbody>
                    {classes.map((cls) => (
                      <tr key={cls.id}>
                        <td className="clickable-cell" onClick={() => handleSelectClass(cls)}>
                          {cls.className}
                        </td>
                        <td className="text-right">
                          <button
                            className="btn-link-edit"
                            onClick={(e) => {
                              e.stopPropagation();
                              setEditingClass(cls);
                              setClassNameInput(cls.className);
                              setShowAddClassModal(true);
                            }}
                          >
                            Edit
                          </button>
                          <button
                            className="btn-link-delete"
                            onClick={(e) => {
                              e.stopPropagation();
                              setDeleteModal({
                                open: true,
                                type: "CLASS",
                                id: cls.id,
                                name: cls.className,
                              });
                            }}
                          >
                            Delete
                          </button>
                        </td>
                      </tr>
                    ))}
                    {classes.length === 0 && !loading && (
                      <tr>
                        <td colSpan="2" className="empty-row">
                          No classes found. Click "+ Add Class" to create one.
                        </td>
                      </tr>
                    )}
                  </tbody>
                </table>
              </div>
            </div>
          )}

          {/* SCREEN 2: UNITS VIEW */}
          {currentView === "UNITS" && (
            <div className="admin-view-container">
              <div className="admin-header-row">
                <div className="header-title-group">
                  <button className="btn-back-arrow" onClick={() => setCurrentView("CLASSES")}>
                    ←
                  </button>
                  <h1 className="admin-page-title">{selectedClass?.className || "11th Standard"}</h1>
                </div>
                <button
                  className="btn-admin-blue"
                  onClick={() => {
                    setEditingUnitItem(null);
                    setUnitNameInput("");
                    setShowAddUnitModal(true);
                  }}
                >
                  + Add Unit
                </button>
              </div>

              <div className="admin-table-wrapper">
                <table className="admin-table">
                  <thead>
                    <tr>
                      <th>Unit Name</th>
                      <th className="text-right">Actions</th>
                    </tr>
                  </thead>
                  <tbody>
                    {units.map((u) => (
                      <tr key={u.id}>
                        <td className="clickable-cell" onClick={() => handleSelectUnit(u)}>
                          {u.unitName}
                        </td>
                        <td className="text-right">
                          <button
                            className="btn-link-edit"
                            onClick={(e) => {
                              e.stopPropagation();
                              setEditingUnitItem(u);
                              setUnitNameInput(u.unitName);
                              setShowAddUnitModal(true);
                            }}
                          >
                            Edit
                          </button>
                          <button
                            className="btn-link-delete"
                            onClick={(e) => {
                              e.stopPropagation();
                              setDeleteModal({
                                open: true,
                                type: "UNIT",
                                id: u.id,
                                name: u.unitName,
                              });
                            }}
                          >
                            Delete
                          </button>
                        </td>
                      </tr>
                    ))}
                    {units.length === 0 && !loading && (
                      <tr>
                        <td colSpan="2" className="empty-row">
                          No units found in this class. Click "+ Add Unit" to create one.
                        </td>
                      </tr>
                    )}
                  </tbody>
                </table>
              </div>
            </div>
          )}

          {/* SCREEN 3: CHAPTERS VIEW */}
          {currentView === "CHAPTERS" && (
            <div className="admin-view-container">
              <div className="admin-header-row">
                <div className="header-title-group">
                  <button className="btn-back-arrow" onClick={() => setCurrentView("UNITS")}>
                    ←
                  </button>
                  <h1 className="admin-page-title">{selectedUnit?.unitName || "Unit 1"}</h1>
                </div>
                <button
                  className="btn-admin-blue"
                  onClick={() => {
                    setEditingChapterItem(null);
                    setChapterNameInput("");
                    setShowAddChapterModal(true);
                  }}
                >
                  + Add Chapter
                </button>
              </div>

              <div className="admin-table-wrapper">
                <table className="admin-table">
                  <thead>
                    <tr>
                      <th>Chapter Name</th>
                      <th className="text-right">Actions</th>
                    </tr>
                  </thead>
                  <tbody>
                    {chapters.map((ch) => (
                      <tr key={ch.id}>
                        <td className="clickable-cell" onClick={() => handleSelectChapter(ch)}>
                          {ch.chapterName}
                        </td>
                        <td className="text-right">
                          <button
                            className="btn-link-edit"
                            onClick={(e) => {
                              e.stopPropagation();
                              setEditingChapterItem(ch);
                              setChapterNameInput(ch.chapterName);
                              setShowAddChapterModal(true);
                            }}
                          >
                            Edit
                          </button>
                          <button
                            className="btn-link-delete"
                            onClick={(e) => {
                              e.stopPropagation();
                              setDeleteModal({
                                open: true,
                                type: "CHAPTER",
                                id: ch.id,
                                name: ch.chapterName,
                              });
                            }}
                          >
                            Delete
                          </button>
                        </td>
                      </tr>
                    ))}
                    {chapters.length === 0 && !loading && (
                      <tr>
                        <td colSpan="2" className="empty-row">
                          No chapters found in this unit. Click "+ Add Chapter" to create one.
                        </td>
                      </tr>
                    )}
                  </tbody>
                </table>
              </div>
            </div>
          )}

          {/* SCREEN 4: MISSIONS VIEW - Exactly matching: Mission name | Game Type | Questions | Add Questions */}
          {currentView === "MISSIONS" && (
            <div className="admin-view-container">
              <div className="admin-header-row">
                <div className="header-title-group">
                  <button className="btn-back-arrow" onClick={() => setCurrentView("CHAPTERS")}>
                    ←
                  </button>
                  <h1 className="admin-page-title">
                    {selectedChapter?.chapterName || "Chapter 1 - Computer Basics"}
                  </h1>
                </div>
              </div>

              <div className="admin-table-wrapper">
                <table className="admin-table">
                  <thead>
                    <tr>
                      <th>Mission name</th>
                      <th>Game Type</th>
                      <th>Questions</th>
                      <th className="text-right">Add Questions</th>
                    </tr>
                  </thead>
                  <tbody>
                    {missions.map((m, idx) => {
                      const qCount = m.questionCount ?? 0;
                      const isMaxReached = qCount >= 5;
                      return (
                        <tr key={m.id || idx}>
                          <td className="font-semibold">Mission {m.missionNumber || idx + 1}</td>
                          <td>
                            <select
                              className="admin-select-dropdown"
                              value={m.gameType || "MCQ Quiz"}
                              onChange={(e) => handleGameTypeChange(m, e.target.value)}
                            >
                              <option value="MCQ Quiz">MCQ Quiz</option>
                              <option value="Fill in the Blank">Fill in the Blank</option>
                              <option value="Scenario Challenge">Scenario Challenge</option>
                            </select>
                          </td>
                          <td>
                            <span className="badge-question-count">
                              {qCount}/5
                            </span>
                          </td>
                          <td className="text-right">
                            <button
                              className="btn-link-green"
                              onClick={() => handleOpenAddQuestion(m)}
                              disabled={isMaxReached}
                              style={isMaxReached ? { opacity: 0.6, cursor: "not-allowed", backgroundColor: "#cbd5e1", color: "#475569", borderColor: "#cbd5e1" } : {}}
                            >
                              {isMaxReached ? "5/5 Max" : "Add Questions"}
                            </button>
                          </td>
                        </tr>
                      );
                    })}
                  </tbody>
                </table>
              </div>
            </div>
          )}

          {/* SCREEN 5 & 6: ADD / EDIT QUESTION FORM */}
          {currentView === "QUESTION_FORM" && (
            <div className="admin-view-container layout-split">
              <div className="admin-form-left-col">
                <div className="header-title-group mb-6">
                  <button
                    className="btn-back-arrow"
                    onClick={() => {
                      setEditingQuestion(null);
                      setCurrentView("MISSIONS");
                    }}
                  >
                    ←
                  </button>

                  <h1 className="admin-page-title">
                    Mission {selectedMission?.missionNumber || 1} – {selectedMission?.gameType || "MCQ Quiz"}
                  </h1>
                </div>

                {savedQuestionSuccess ? (
                  /* Success Confirmation Card */
                  <div className="success-confirmation-card">
                    <div className="success-icon-circle">
                      <span>✓</span>
                    </div>
                    <h2>Question Saved Successfully!</h2>
                    <button
                      className="btn-admin-blue mt-4"
                      onClick={() => {
                        setSavedQuestionSuccess(false);
                        setEditingQuestion(null);
                        const defaultAnswer = selectedMission?.gameType === "Fill in the Blank" ? "" : "Option A";
                        setQForm({
                          questionText: "",
                          optionA: "",
                          optionB: "",
                          optionC: "",
                          optionD: "",
                          correctAnswer: defaultAnswer,
                          acceptedAnswers: "",
                          scenarioType: "MCQ",
                          xp: 10,
                        });
                      }}
                    >
                      Add Next Question
                    </button>
                  </div>
                ) : (
                  /* Question Form Card */
                  <div className="admin-form-card">
                    <div className="form-card-header">
                      <h2>
                        {editingQuestion ? "Edit Question" : "Add Question"}{" "}
                        <span className="q-count-sub">({questions.length} / 5)</span>
                      </h2>
                      {editingQuestion && (
                        <button
                          className="btn-form-cancel"
                          onClick={() => {
                            setEditingQuestion(null);
                            const defaultAnswer = selectedMission?.gameType === "Fill in the Blank" ? "" : "Option A";
                            setQForm({
                              questionText: "",
                              optionA: "",
                              optionB: "",
                              optionC: "",
                              optionD: "",
                              correctAnswer: defaultAnswer,
                              acceptedAnswers: "",
                              scenarioType: "MCQ",
                              xp: 10,
                            });
                          }}
                        >
                          Cancel Edit
                        </button>
                      )}
                    </div>

                    <form onSubmit={handleSaveQuestionSubmit} className="admin-question-form">
                      {/* DYNAMIC FORM TYPE 1: MCQ / QUIZ */}
                      {(!selectedMission?.gameType ||
                        selectedMission.gameType === "MCQ Quiz" ||
                        selectedMission.gameType === "Quiz" ||
                        selectedMission.gameType === "MCQ" ||
                        (!selectedMission.gameType.includes("Fill") && !selectedMission.gameType.includes("Scenario"))) && (
                        <>
                          <div className="form-group">
                            <label>Question</label>
                            <input
                              type="text"
                              placeholder="What is the full form of CPU?"
                              value={qForm.questionText}
                              onChange={(e) => setQForm({ ...qForm, questionText: e.target.value })}
                              required
                            />
                          </div>

                          <div className="form-group">
                            <label>Option A</label>
                            <input
                              type="text"
                              placeholder="Central Processing Unit"
                              value={qForm.optionA}
                              onChange={(e) => setQForm({ ...qForm, optionA: e.target.value })}
                              required
                            />
                          </div>

                          <div className="form-group">
                            <label>Option B</label>
                            <input
                              type="text"
                              placeholder="Computer Personal Unit"
                              value={qForm.optionB}
                              onChange={(e) => setQForm({ ...qForm, optionB: e.target.value })}
                              required
                            />
                          </div>

                          <div className="form-group">
                            <label>Option C</label>
                            <input
                              type="text"
                              placeholder="Control Processing Unit"
                              value={qForm.optionC}
                              onChange={(e) => setQForm({ ...qForm, optionC: e.target.value })}
                              required
                            />
                          </div>

                          <div className="form-group">
                            <label>Option D</label>
                            <input
                              type="text"
                              placeholder="Central Program Unit"
                              value={qForm.optionD}
                              onChange={(e) => setQForm({ ...qForm, optionD: e.target.value })}
                              required
                            />
                          </div>

                          <div className="form-group">
                            <label>Correct Answer</label>
                            <select
                              value={qForm.correctAnswer}
                              onChange={(e) => setQForm({ ...qForm, correctAnswer: e.target.value })}
                            >
                              <option value="Option A">Option A</option>
                              <option value="Option B">Option B</option>
                              <option value="Option C">Option C</option>
                              <option value="Option D">Option D</option>
                            </select>
                          </div>
                        </>
                      )}

                      {/* DYNAMIC FORM TYPE 2: FILL IN THE BLANK */}
                      {selectedMission?.gameType && selectedMission.gameType.includes("Fill") && (
                        <>
                          <div className="form-group">
                            <label>Question</label>
                            <input
                              type="text"
                              placeholder="____ is the primary memory of a computer."
                              value={qForm.questionText}
                              onChange={(e) => setQForm({ ...qForm, questionText: e.target.value })}
                              required
                            />
                          </div>

                          <div className="form-group">
                            <label>Correct Answer</label>
                            <input
                              type="text"
                              placeholder="RAM"
                              value={qForm.correctAnswer}
                              onChange={(e) => setQForm({ ...qForm, correctAnswer: e.target.value })}
                              required
                            />
                          </div>

                          <div className="form-group">
                            <label>Accepted Answers (optional)</label>
                            <input
                              type="text"
                              placeholder="e.g. ram, Random Access Memory"
                              value={qForm.acceptedAnswers}
                              onChange={(e) => setQForm({ ...qForm, acceptedAnswers: e.target.value })}
                            />
                            <span className="field-hint">(Use comma to add multiple answers)</span>
                          </div>
                        </>
                      )}

                      {/* DYNAMIC FORM TYPE 3: SCENARIO CHALLENGE */}
                      {selectedMission?.gameType && selectedMission.gameType.includes("Scenario") && (
                        <>
                          <div className="scenario-toggle-bar">
                            <label className="toggle-label">
                              <input
                                type="radio"
                                name="scenarioType"
                                value="MCQ"
                                checked={qForm.scenarioType === "MCQ"}
                                onChange={() => setQForm({ ...qForm, scenarioType: "MCQ" })}
                              />
                              <span>Normal Scenario (MCQ)</span>
                            </label>
                            <label className="toggle-label">
                              <input
                                type="radio"
                                name="scenarioType"
                                value="CODE_SQL"
                                checked={qForm.scenarioType === "CODE_SQL"}
                                onChange={() => setQForm({ ...qForm, scenarioType: "CODE_SQL" })}
                              />
                              <span>Code / SQL Scenario</span>
                            </label>
                          </div>

                          {qForm.scenarioType === "MCQ" ? (
                            <>
                              <div className="form-group">
                                <label>Scenario</label>
                                <textarea
                                  rows="3"
                                  placeholder="A computer is running slow when multiple programs are opened. Which of the following is the most possible reason?"
                                  value={qForm.questionText}
                                  onChange={(e) => setQForm({ ...qForm, questionText: e.target.value })}
                                  required
                                />
                              </div>

                              <div className="form-group">
                                <label>Option A</label>
                                <input
                                  type="text"
                                  placeholder="Low RAM"
                                  value={qForm.optionA}
                                  onChange={(e) => setQForm({ ...qForm, optionA: e.target.value })}
                                  required
                                />
                              </div>

                              <div className="form-group">
                                <label>Option B</label>
                                <input
                                  type="text"
                                  placeholder="Large Monitor"
                                  value={qForm.optionB}
                                  onChange={(e) => setQForm({ ...qForm, optionB: e.target.value })}
                                  required
                                />
                              </div>

                              <div className="form-group">
                                <label>Option C</label>
                                <input
                                  type="text"
                                  placeholder="More Hard Disk Space"
                                  value={qForm.optionC}
                                  onChange={(e) => setQForm({ ...qForm, optionC: e.target.value })}
                                  required
                                />
                              </div>

                              <div className="form-group">
                                <label>Option D</label>
                                <input
                                  type="text"
                                  placeholder="High Internet Speed"
                                  value={qForm.optionD}
                                  onChange={(e) => setQForm({ ...qForm, optionD: e.target.value })}
                                  required
                                />
                              </div>

                              <div className="form-group">
                                <label>Correct Answer</label>
                                <select
                                  value={qForm.correctAnswer}
                                  onChange={(e) => setQForm({ ...qForm, correctAnswer: e.target.value })}
                                >
                                  <option value="Option A">Option A</option>
                                  <option value="Option B">Option B</option>
                                  <option value="Option C">Option C</option>
                                  <option value="Option D">Option D</option>
                                </select>
                              </div>
                            </>
                          ) : (
                            /* Code Problem Scenario Fields */
                            <>
                              <div className="form-group">
                                <label>Scenario / Problem</label>
                                <textarea
                                  rows="3"
                                  placeholder="Write a program/function to solve this problem."
                                  value={qForm.questionText}
                                  onChange={(e) => setQForm({ ...qForm, questionText: e.target.value })}
                                  required
                                />
                              </div>

                              <div className="form-group">
                                <label>Language</label>
                                <select
                                  value={qForm.codeLanguage || "Python"}
                                  onChange={(e) => setQForm({ ...qForm, codeLanguage: e.target.value })}
                                >
                                  <option value="Python">Python</option>
                                  <option value="C">C</option>
                                  <option value="Java">Java</option>
                                  <option value="SQL">SQL</option>
                                </select>
                              </div>

                              <div className="form-group">
                                <label>Starter Code (optional)</label>
                                <textarea
                                  rows="2"
                                  placeholder="def solve():&#10;    # Write code here"
                                  value={qForm.optionA}
                                  onChange={(e) => setQForm({ ...qForm, optionA: e.target.value })}
                                />
                              </div>

                              <div className="form-group">
                                <label>Expected Output / Correct Answer</label>
                                <textarea
                                  rows="2"
                                  placeholder="Expected code output or query result"
                                  value={qForm.correctAnswer}
                                  onChange={(e) => setQForm({ ...qForm, correctAnswer: e.target.value })}
                                  required
                                />
                              </div>

                              <div className="form-group">
                                <label>Accepted Answers (optional)</label>
                                <input
                                  type="text"
                                  placeholder="Alternative outputs or answers separated by commas"
                                  value={qForm.acceptedAnswers}
                                  onChange={(e) => setQForm({ ...qForm, acceptedAnswers: e.target.value })}
                                />
                                <span className="field-hint">(Use comma to add multiple accepted answers)</span>
                              </div>
                            </>
                          )}
                        </>
                      )}

                      <div className="form-group">
                        <label>XP Points</label>
                        <input
                          type="number"
                          value={qForm.xp}
                          onChange={(e) => setQForm({ ...qForm, xp: parseInt(e.target.value, 10) || 10 })}
                        />
                      </div>

                      <button
                        type="submit"
                        className="btn-admin-blue w-full btn-save-question"
                        disabled={questions.length >= 5 && !editingQuestion}
                      >
                        {editingQuestion ? "Update Question" : "Save Question"}
                      </button>
                    </form>
                  </div>
                )}

                {/* Existing Questions List */}
                {questions.length > 0 && (
                  <div className="existing-questions-card mt-6">
                    <h3 className="card-subtitle">Existing Questions ({questions.length} / 5)</h3>
                    <div className="q-items-list">
                      {questions.map((q, qIdx) => (
                        <div key={q.id || qIdx} className="q-item-row">
                          <div className="q-item-info">
                            <span className="q-item-num">Q{qIdx + 1}.</span>
                            <span className="q-item-text">{q.questionText}</span>
                            <span className="q-item-badge">{q.questionType}</span>
                          </div>
                          <div className="q-item-actions">
                            <button className="btn-link-edit" onClick={() => handleEditQuestionObj(q)}>
                              Edit
                            </button>
                            <button
                              className="btn-link-delete"
                              onClick={() =>
                                setDeleteModal({
                                  open: true,
                                  type: "QUESTION",
                                  id: q.id,
                                  name: `Q${qIdx + 1}`,
                                })
                              }
                            >
                              Delete
                            </button>
                          </div>
                        </div>
                      ))}
                    </div>
                  </div>
                )}
              </div>

              {/* Right Column Info Box */}
              <div className="admin-form-right-col">
                <div className="info-card-blue">
                  <h3 className="info-card-title">What Admin Can Do</h3>
                  <ul className="info-check-list">
                    <li>
                      <span className="check-icon">✓</span>
                      <span>Add / Edit / Delete Class, Unit, Chapter</span>
                    </li>
                    <li>
                      <span className="check-icon">✓</span>
                      <span>4 Missions are created automatically for every chapter</span>
                    </li>
                    <li>
                      <span className="check-icon">✓</span>
                      <span>Select Game Type for each Mission</span>
                    </li>
                    <li>
                      <span className="check-icon">✓</span>
                      <span>Add up to 5 Questions in each Mission</span>
                    </li>
                    <li>
                      <span className="check-icon">✓</span>
                      <span>Edit or Delete Questions anytime</span>
                    </li>
                  </ul>
                </div>
              </div>
            </div>
          )}
        </div>
      </main>

      {/* MODAL: ADD / EDIT CLASS */}
      {showAddClassModal && (
        <div className="modal-backdrop" onClick={() => setShowAddClassModal(false)}>
          <div className="modal-card" onClick={(e) => e.stopPropagation()}>
            <h2>{editingClass ? "Edit Class" : "Add Class"}</h2>
            <div className="modal-form-group">
              <label>Class Name</label>
              <input
                type="text"
                placeholder="e.g. 11th Standard"
                value={classNameInput}
                onChange={(e) => setClassNameInput(e.target.value)}
                autoFocus
              />
            </div>
            <div className="modal-actions">
              <button className="btn-modal-cancel" onClick={() => setShowAddClassModal(false)}>
                Cancel
              </button>
              <button className="btn-admin-blue" onClick={handleSaveClass}>
                Save
              </button>
            </div>
          </div>
        </div>
      )}

      {/* MODAL: ADD / EDIT UNIT */}
      {showAddUnitModal && (
        <div className="modal-backdrop" onClick={() => setShowAddUnitModal(false)}>
          <div className="modal-card" onClick={(e) => e.stopPropagation()}>
            <h2>{editingUnitItem ? "Edit Unit" : "Add Unit"}</h2>
            <div className="modal-form-group">
              <label>Unit Name</label>
              <input
                type="text"
                placeholder="e.g. Unit 1"
                value={unitNameInput}
                onChange={(e) => setUnitNameInput(e.target.value)}
                autoFocus
              />
            </div>
            <div className="modal-actions">
              <button className="btn-modal-cancel" onClick={() => setShowAddUnitModal(false)}>
                Cancel
              </button>
              <button className="btn-admin-blue" onClick={handleSaveUnit}>
                Save
              </button>
            </div>
          </div>
        </div>
      )}

      {/* MODAL: ADD / EDIT CHAPTER */}
      {showAddChapterModal && (
        <div className="modal-backdrop" onClick={() => setShowAddChapterModal(false)}>
          <div className="modal-card" onClick={(e) => e.stopPropagation()}>
            <h2>{editingChapterItem ? "Edit Chapter" : "Add Chapter"}</h2>
            <div className="modal-form-group">
              <label>Chapter Name</label>
              <input
                type="text"
                placeholder="e.g. Chapter 1 - Computer Basics"
                value={chapterNameInput}
                onChange={(e) => setChapterNameInput(e.target.value)}
                autoFocus
              />
            </div>
            <div className="modal-actions">
              <button className="btn-modal-cancel" onClick={() => setShowAddChapterModal(false)}>
                Cancel
              </button>
              <button className="btn-admin-blue" onClick={handleSaveChapter}>
                Save
              </button>
            </div>
          </div>
        </div>
      )}

      {/* MODAL: DELETE CONFIRMATION */}
      {deleteModal.open && (
        <div className="modal-backdrop">
          <div className="delete-modal-card">
            <div className="warning-icon-circle">
              <span>!</span>
            </div>
            <h2 className="delete-modal-title">Delete this {deleteModal.type?.toLowerCase()}?</h2>
            <p className="delete-modal-sub">This action cannot be undone.</p>
            <div className="delete-modal-actions">
              <button
                className="btn-modal-cancel"
                onClick={() => setDeleteModal({ open: false, type: null, id: null, name: "" })}
              >
                Cancel
              </button>
              <button className="btn-modal-delete" onClick={executeDelete}>
                Delete
              </button>
            </div>
          </div>
        </div>
      )}
    </div>
  );
}
