import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { classApi, subjectApi, unitApi, chapterApi, missionApi, questionApi } from "../../api/client";
import "../../styles/admin.css";

// 7 Standard Academic Groups for State Board (Classes 11 & 12)
export const STATE_BOARD_GROUPS = [
  {
    id: "GROUP 1 – MATHS-BIOLOGY / BIO-MATHS",
    title: "Maths-Biology / Bio-Maths",
    code: "Group 1",
    badge: "Bio-Maths",
    subjects: ["Tamil", "English", "Physics", "Chemistry", "Mathematics", "Biology"],
  },
  {
    id: "GROUP 2 – MATHS + COMPUTER SCIENCE",
    title: "Maths + Computer Science",
    code: "Group 2",
    badge: "Maths + CS",
    subjects: ["Tamil", "English", "Physics", "Chemistry", "Mathematics", "Computer Science"],
  },
  {
    id: "GROUP 3 – PURE SCIENCE / BIOLOGY",
    title: "Pure Science / Biology",
    code: "Group 3",
    badge: "Pure Science",
    subjects: ["Tamil", "English", "Physics", "Chemistry", "Botany", "Zoology"],
  },
  {
    id: "GROUP 4 – COMMERCE",
    title: "Commerce",
    code: "Group 4",
    badge: "Commerce",
    subjects: ["Tamil", "English", "Statistics", "Economics", "Commerce", "Accountancy"],
  },
  {
    id: "GROUP 5 – COMMERCE + COMPUTER APPLICATIONS",
    title: "Commerce + Computer Applications",
    code: "Group 5",
    badge: "Commerce + CA",
    subjects: ["Tamil", "English", "Economics", "Commerce", "Accountancy", "Computer Applications"],
  },
  {
    id: "GROUP 6 – COMMERCE + BUSINESS MATHEMATICS",
    title: "Commerce + Business Mathematics",
    code: "Group 6",
    badge: "Commerce + BM",
    subjects: ["Tamil", "English", "Business Mathematics", "Economics", "Commerce", "Accountancy"],
  },
  {
    id: "GROUP 7 – ACCOUNTANCY + HISTORY",
    title: "Accountancy + History",
    code: "Group 7",
    badge: "Acc + History",
    subjects: ["Tamil", "English", "History", "Economics", "Commerce", "Accountancy"],
  },
];

// 7 Academic Combinations / Groups for CBSE (Classes 11 & 12)
export const CBSE_GROUPS = [
  {
    id: "GROUP 1 – MATHS-BIOLOGY / BIO-MATHS",
    title: "Maths-Biology / Bio-Maths",
    code: "Group 1",
    badge: "Bio-Maths",
    subjects: ["English", "Physics", "Chemistry", "Mathematics", "Biology"],
  },
  {
    id: "GROUP 2 – MATHS + COMPUTER SCIENCE",
    title: "Maths + Computer Science",
    code: "Group 2",
    badge: "Maths + CS",
    subjects: ["English", "Physics", "Chemistry", "Mathematics", "Computer Science"],
  },
  {
    id: "GROUP 3 – PURE SCIENCE / BIOLOGY",
    title: "Pure Science / Biology",
    code: "Group 3",
    badge: "Pure Science",
    subjects: ["English", "Physics", "Chemistry", "Biology"],
  },
  {
    id: "GROUP 4 – COMMERCE",
    title: "Commerce",
    code: "Group 4",
    badge: "Commerce",
    subjects: ["English", "Accountancy", "Business Studies", "Economics", "Mathematics"],
  },
  {
    id: "GROUP 5 – COMMERCE + COMPUTER APPLICATIONS",
    title: "Commerce + Computer Applications",
    code: "Group 5",
    badge: "Commerce + IP",
    subjects: ["English", "Accountancy", "Business Studies", "Economics", "Informatics Practices"],
  },
  {
    id: "GROUP 6 – COMMERCE + BUSINESS MATHEMATICS",
    title: "Commerce + Business Mathematics",
    code: "Group 6",
    badge: "Commerce + BM",
    subjects: ["English", "Accountancy", "Business Studies", "Economics", "Business Mathematics"],
  },
  {
    id: "GROUP 7 – ACCOUNTANCY + HISTORY",
    title: "Accountancy + History",
    code: "Group 7",
    badge: "Acc + History",
    subjects: ["English", "Accountancy", "History", "Economics", "Business Studies"],
  },
];

export default function AdminPage() {
  const navigate = useNavigate();

  // Selected Board Context: "CBSE" | "STATE_BOARD" | null
  const [selectedBoard, setSelectedBoard] = useState(() => {
    return localStorage.getItem("cq_admin_board") || null;
  });
  const [showBoardSwitchModal, setShowBoardSwitchModal] = useState(false);

  // Navigation hierarchy: CLASSES -> GROUPS (if 11-12) -> SUBJECTS -> UNITS -> CHAPTERS -> MISSIONS -> QUESTION_FORM
  const [currentView, setCurrentView] = useState("CLASSES");

  // Selected hierarchy entities
  const [selectedClass, setSelectedClass] = useState(null);
  const [selectedGroup, setSelectedGroup] = useState(null);
  const [selectedSubject, setSelectedSubject] = useState(null);
  const [selectedUnit, setSelectedUnit] = useState(null);
  const [selectedChapter, setSelectedChapter] = useState(null);
  const [selectedMission, setSelectedMission] = useState(null);
  const [editingQuestion, setEditingQuestion] = useState(null);

  // Data state
  const [classes, setClasses] = useState([]);
  const [subjects, setSubjects] = useState([]);
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
  const [classBoardInput, setClassBoardInput] = useState("CBSE");
  const [classLevelInput, setClassLevelInput] = useState(10);

  const [showAddSubjectModal, setShowAddSubjectModal] = useState(false);
  const [editingSubjectItem, setEditingSubjectItem] = useState(null);
  const [subjectNameInput, setSubjectNameInput] = useState("");
  const [subjectCodeInput, setSubjectCodeInput] = useState("");
  const [subjectIconInput, setSubjectIconInput] = useState("📚");
  const [subjectColorInput, setSubjectColorInput] = useState("#ff7e5f");

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

  // Load Classes for the active board
  const loadClasses = async (boardToUse) => {
    setLoading(true);
    setError("");
    try {
      const activeBoard = boardToUse || selectedBoard || "CBSE";
      const admin = getAdminContext();
      const params = {
        board: activeBoard,
        ...(admin?.id ? { adminId: admin.id } : {}),
      };
      const res = await classApi.getClasses(params);
      const list = res || [];

      // Filter strictly by activeBoard and sort by classLevel ascending (4th -> 12th)
      const filtered = list.filter((c) => !c.board || c.board === activeBoard);
      const sorted = [...filtered].sort((a, b) => {
        const lvlA = a.classLevel || parseInt((a.className || "").replace(/\D+/g, ""), 10) || 0;
        const lvlB = b.classLevel || parseInt((b.className || "").replace(/\D+/g, ""), 10) || 0;
        return lvlA - lvlB;
      });

      setClasses(sorted);
    } catch (err) {
      setError(err.message || "Failed to load classes");
    } finally {
      setLoading(false);
    }
  };

  // Switch / Select Board
  const handleSelectBoardContext = (board) => {
    localStorage.setItem("cq_admin_board", board);
    setSelectedBoard(board);
    setShowBoardSwitchModal(false);
    // Reset selection hierarchy
    setSelectedClass(null);
    setSelectedGroup(null);
    setSelectedSubject(null);
    setSelectedUnit(null);
    setSelectedChapter(null);
    setSelectedMission(null);
    setCurrentView("CLASSES");
    loadClasses(board);
  };

  // Load Subjects for a Class, Board, and optional Group
  const loadSubjects = async (cls, groupObj = null) => {
    setLoading(true);
    setError("");
    try {
      const admin = getAdminContext();
      const activeGroup = groupObj || selectedGroup;
      const params = {
        classLevel: cls.classLevel || 10,
        board: cls.board || selectedBoard || "CBSE",
        ...(activeGroup?.id ? { studentGroup: activeGroup.id } : {}),
        ...(admin?.id ? { adminId: admin.id } : {}),
      };
      const res = await subjectApi.getSubjects(params);
      setSubjects(res || []);
    } catch (err) {
      setError(err.message || "Failed to load subjects");
    } finally {
      setLoading(false);
    }
  };

  // Load Units for a Subject & Class
  const loadUnits = async (subjObj, clsObj) => {
    setLoading(true);
    setError("");
    try {
      const targetClass = clsObj || selectedClass;
      const targetSubj = subjObj || selectedSubject;
      const admin = getAdminContext();
      const params = {
        classLevel: targetClass?.classLevel || 10,
        board: targetClass?.board || selectedBoard || "CBSE",
        subject: targetSubj?.subjectName || "Computer Science",
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

  // Load Chapters for a Unit & Subject
  const loadChapters = async (unitObj, subjObj, clsObj) => {
    setLoading(true);
    setError("");
    try {
      const targetClass = clsObj || selectedClass;
      const targetSubj = subjObj || selectedSubject;
      const admin = getAdminContext();
      const params = {
        classLevel: targetClass?.classLevel || 10,
        board: targetClass?.board || selectedBoard || "CBSE",
        subject: targetSubj?.subjectName || "Computer Science",
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
        classLevel: selectedClass?.classLevel || 10,
        board: selectedClass?.board || selectedBoard || "CBSE",
        subject: selectedSubject?.subjectName || "Computer Science",
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
        classLevel: selectedClass?.classLevel || 10,
        board: selectedClass?.board || selectedBoard || "CBSE",
        subject: selectedSubject?.subjectName || "Computer Science",
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
    if (selectedBoard) {
      loadClasses(selectedBoard);
    }
  }, [selectedBoard]);

  // Drill down: Class selection
  const handleSelectClass = (cls) => {
    setSelectedClass(cls);
    setSelectedGroup(null);
    setSelectedSubject(null);
    setSelectedUnit(null);
    setSelectedChapter(null);
    setSelectedMission(null);

    // Classes 11 & 12 MUST go through Groups view
    if (cls.classLevel === 11 || cls.classLevel === 12) {
      setCurrentView("GROUPS");
    } else {
      setCurrentView("SUBJECTS");
      loadSubjects(cls, null);
    }
  };

  // Drill down: Group selection (Classes 11 & 12)
  const handleSelectGroup = (groupObj) => {
    setSelectedGroup(groupObj);
    setCurrentView("SUBJECTS");
    loadSubjects(selectedClass, groupObj);
  };

  // Drill down: Subject selection
  const handleSelectSubject = (subj) => {
    setSelectedSubject(subj);
    setCurrentView("UNITS");
    loadUnits(subj, selectedClass);
  };

  // Drill down: Unit selection
  const handleSelectUnit = (uObj) => {
    setSelectedUnit(uObj);
    setCurrentView("CHAPTERS");
    loadChapters(uObj, selectedSubject, selectedClass);
  };

  // Drill down: Chapter selection
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
      const admin = getAdminContext();

      if (editingClass) {
        await classApi.updateClass(editingClass.id, {
          ...editingClass,
          className: classNameInput,
          classLevel: Number(classLevelInput),
          board: classBoardInput,
        });
      } else {
        await classApi.createClass({
          className: classNameInput,
          classLevel: Number(classLevelInput),
          board: classBoardInput,
          school: admin?.school || null,
          adminId: admin?.id || null,
        });
      }
      setShowAddClassModal(false);
      setEditingClass(null);
      setClassNameInput("");
      loadClasses(selectedBoard);
    } catch (err) {
      setError(err.message);
    }
  };

  // Save Subject CRUD
  const handleSaveSubject = async () => {
    if (!subjectNameInput.trim()) return;
    try {
      const admin = getAdminContext();
      if (editingSubjectItem) {
        await subjectApi.updateSubject(editingSubjectItem.id, {
          ...editingSubjectItem,
          subjectName: subjectNameInput.trim(),
          subjectCode: subjectCodeInput.trim() || subjectNameInput.trim().toUpperCase().slice(0, 4),
          icon: subjectIconInput || "📚",
          color: subjectColorInput || "#ff7e5f",
        });
      } else {
        await subjectApi.createSubject({
          subjectName: subjectNameInput.trim(),
          subjectCode: subjectCodeInput.trim() || subjectNameInput.trim().toUpperCase().slice(0, 4),
          icon: subjectIconInput || "📚",
          color: subjectColorInput || "#ff7e5f",
          board: selectedClass?.board || selectedBoard || "CBSE",
          classLevel: selectedClass?.classLevel || 10,
          school: admin?.school || null,
        });
      }
      setShowAddSubjectModal(false);
      setEditingSubjectItem(null);
      setSubjectNameInput("");
      setSubjectCodeInput("");
      loadSubjects(selectedClass, selectedGroup);
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
          board: selectedClass?.board || selectedBoard || "CBSE",
          classLevel: selectedClass?.classLevel || 10,
          subject: selectedSubject?.subjectName || "Computer Science",
          school: admin?.school || null,
          adminId: admin?.id || null,
        });
      }
      setShowAddUnitModal(false);
      setEditingUnitItem(null);
      setUnitNameInput("");
      loadUnits(selectedSubject, selectedClass);
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
          board: selectedClass?.board || selectedBoard || "CBSE",
          classLevel: selectedClass?.classLevel || 10,
          subject: selectedSubject?.subjectName || "Computer Science",
          school: admin?.school || null,
          adminId: admin?.id || null,
        });
      }
      setShowAddChapterModal(false);
      setEditingChapterItem(null);
      setChapterNameInput("");
      loadChapters(selectedUnit, selectedSubject, selectedClass);
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
      board: selectedClass?.board || selectedBoard || "CBSE",
      classLevel: selectedClass?.classLevel || 10,
      subject: selectedSubject?.subjectName || "Computer Science",
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
        loadClasses(selectedBoard);
      } else if (type === "SUBJECT") {
        await subjectApi.deleteSubject(id);
        loadSubjects(selectedClass, selectedGroup);
      } else if (type === "UNIT") {
        await unitApi.deleteUnit(id);
        loadUnits(selectedSubject, selectedClass);
      } else if (type === "CHAPTER") {
        await chapterApi.deleteChapter(id);
        loadChapters(selectedUnit, selectedSubject, selectedClass);
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

  const availableGroups = selectedBoard === "CBSE" ? CBSE_GROUPS : STATE_BOARD_GROUPS;

  return (
    <div className="admin-shell">
      {/* ========================================================
          BOARD SELECTION MODAL / OVERLAY (When none selected or switching)
          ======================================================== */}
      {(!selectedBoard || showBoardSwitchModal) && (
        <div className="admin-board-select-overlay">
          <div className="admin-board-select-card">
            <span className="board-select-top-badge">RPSIT SCHOOL • CURRICULUM ARCHITECTURE</span>
            <h2 className="board-select-heading">Which Board do you want to manage?</h2>
            <p className="board-select-desc">
              Select an academic board to manage its corresponding classes, groups, subjects, and curriculum.
            </p>

            <div className="board-select-options-grid">
              {/* Option 1: CBSE */}
              <button
                type="button"
                className={`board-option-card-btn ${selectedBoard === "CBSE" ? "active" : ""}`}
                onClick={() => handleSelectBoardContext("CBSE")}
              >
                <div>
                  <div className="board-opt-header">
                    <span className="board-opt-icon">🏛️</span>
                    <span className="board-opt-title">CBSE</span>
                  </div>
                  <p className="board-opt-info">
                    Manage CBSE Classes 4–12, 7 Elective Groups for 11–12, and NCERT curriculum databases.
                  </p>
                </div>
                <span className="board-opt-btn-pill">Manage CBSE →</span>
              </button>

              {/* Option 2: State Board */}
              <button
                type="button"
                className={`board-option-card-btn ${selectedBoard === "STATE_BOARD" ? "active" : ""}`}
                onClick={() => handleSelectBoardContext("STATE_BOARD")}
              >
                <div>
                  <div className="board-opt-header">
                    <span className="board-opt-icon">🌴</span>
                    <span className="board-opt-title">State Board</span>
                  </div>
                  <p className="board-opt-info">
                    Manage State Board Classes 4–12, 7 Prescribed Groups for 11–12, and SCERT curriculum databases.
                  </p>
                </div>
                <span className="board-opt-btn-pill">Manage State Board →</span>
              </button>
            </div>

            {showBoardSwitchModal && selectedBoard && (
              <button
                className="btn-modal-cancel mt-6"
                style={{ marginTop: "24px" }}
                onClick={() => setShowBoardSwitchModal(false)}
              >
                Cancel / Keep Current Board
              </button>
            )}
          </div>
        </div>
      )}

      {/* Navigation Sidebar */}
      <aside className="admin-sidebar">
        <div className="admin-brand">
          <div className="brand-logo-box">
            <span className="brand-icon">🎓</span>
            <span className="brand-logo">LearnQuest Admin</span>
          </div>
          <span className="brand-badge">RPSIT School</span>
        </div>

        <nav className="admin-nav">
          <button
            className={`admin-nav-item ${currentView === "CLASSES" ? "active" : ""}`}
            onClick={() => {
              setCurrentView("CLASSES");
              loadClasses(selectedBoard);
            }}
          >
            <span className="nav-icon">📂</span>
            <span>Curriculum Management</span>
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
        {/* Active Board Context Indicator Bar */}
        <div className="admin-board-context-bar">
          <div className="admin-board-context-left">
            <span className="admin-board-context-label">Managing:</span>
            <span className={`admin-board-badge-active ${selectedBoard === "STATE_BOARD" ? "state" : "cbse"}`}>
              {selectedBoard === "STATE_BOARD" ? "🌴 State Board" : "🏛️ CBSE"}
            </span>
          </div>
          <button
            type="button"
            className="btn-switch-board"
            onClick={() => setShowBoardSwitchModal(true)}
            title="Switch Board Context"
          >
            Switch Board ⇄
          </button>
        </div>

        {/* Top Breadcrumbs Bar */}
        <div className="admin-breadcrumbs-bar">
          <button
            className={`breadcrumb-node ${currentView === "CLASSES" ? "current" : ""}`}
            onClick={() => setCurrentView("CLASSES")}
          >
            🏫 Classes ({selectedBoard === "STATE_BOARD" ? "State Board" : "CBSE"})
          </button>

          {selectedClass && (
            <>
              <span className="breadcrumb-sep">/</span>
              <button
                className={`breadcrumb-node ${
                  currentView === "GROUPS" || (currentView === "SUBJECTS" && !selectedGroup) ? "current" : ""
                }`}
                onClick={() => {
                  if (selectedClass.classLevel === 11 || selectedClass.classLevel === 12) {
                    setCurrentView("GROUPS");
                  } else {
                    setCurrentView("SUBJECTS");
                    loadSubjects(selectedClass, null);
                  }
                }}
              >
                [{selectedBoard === "STATE_BOARD" ? "State Board" : "CBSE"}] {selectedClass.className}
              </button>
            </>
          )}

          {selectedGroup && (selectedClass?.classLevel === 11 || selectedClass?.classLevel === 12) && (
            <>
              <span className="breadcrumb-sep">/</span>
              <button
                className={`breadcrumb-node ${currentView === "SUBJECTS" ? "current" : ""}`}
                onClick={() => {
                  setCurrentView("SUBJECTS");
                  loadSubjects(selectedClass, selectedGroup);
                }}
              >
                🧪 {selectedGroup.title}
              </button>
            </>
          )}

          {selectedSubject && currentView !== "CLASSES" && currentView !== "GROUPS" && currentView !== "SUBJECTS" && (
            <>
              <span className="breadcrumb-sep">/</span>
              <button
                className={`breadcrumb-node ${currentView === "UNITS" ? "current" : ""}`}
                onClick={() => {
                  setCurrentView("UNITS");
                  loadUnits(selectedSubject, selectedClass);
                }}
              >
                {selectedSubject.icon || "📚"} {selectedSubject.subjectName}
              </button>
            </>
          )}

          {selectedUnit && currentView !== "CLASSES" && currentView !== "GROUPS" && currentView !== "SUBJECTS" && currentView !== "UNITS" && (
            <>
              <span className="breadcrumb-sep">/</span>
              <button
                className={`breadcrumb-node ${currentView === "CHAPTERS" ? "current" : ""}`}
                onClick={() => {
                  setCurrentView("CHAPTERS");
                  loadChapters(selectedUnit, selectedSubject, selectedClass);
                }}
              >
                {selectedUnit.unitName}
              </button>
            </>
          )}

          {selectedChapter && currentView !== "CLASSES" && currentView !== "GROUPS" && currentView !== "SUBJECTS" && currentView !== "UNITS" && currentView !== "CHAPTERS" && (
            <>
              <span className="breadcrumb-sep">/</span>
              <button
                className={`breadcrumb-node ${currentView === "MISSIONS" ? "current" : ""}`}
                onClick={() => {
                  setCurrentView("MISSIONS");
                  loadMissions(selectedChapter);
                }}
              >
                {selectedChapter.chapterName}
              </button>
            </>
          )}

          {selectedMission && currentView === "QUESTION_FORM" && (
            <>
              <span className="breadcrumb-sep">/</span>
              <span className="breadcrumb-node current">Mission {selectedMission.missionNumber}</span>
            </>
          )}
        </div>

        <div className="admin-content-card">
          {error && <div className="admin-error-banner">{error}</div>}

          {/* ========================================================
              SCREEN 1: CLASSES VIEW (Filtered strictly by selectedBoard)
              ======================================================== */}
          {currentView === "CLASSES" && (
            <div className="admin-view-container">
              <div className="admin-header-row">
                <div>
                  <h1 className="admin-page-title">
                    {selectedBoard === "STATE_BOARD" ? "State Board" : "CBSE"} · Classes
                  </h1>
                  <p className="admin-page-subtitle">
                    Select a class to manage its curriculum. Classes 4–10 proceed to Subjects; Classes 11–12 proceed to Groups.
                  </p>
                </div>
                <button
                  className="btn-admin-blue"
                  onClick={() => {
                    setEditingClass(null);
                    setClassNameInput("");
                    setClassBoardInput(selectedBoard || "CBSE");
                    setClassLevelInput(10);
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
                      <th>Board</th>
                      <th>Class Level</th>
                      <th>Curriculum Mode</th>
                      <th className="text-right">Actions</th>
                    </tr>
                  </thead>
                  <tbody>
                    {classes.map((cls) => {
                      const isSeniorSecondary = cls.classLevel === 11 || cls.classLevel === 12;
                      return (
                        <tr key={cls.id}>
                          <td className="clickable-cell font-semibold" onClick={() => handleSelectClass(cls)}>
                            {cls.className}
                          </td>
                          <td>
                            <span className={`board-badge ${selectedBoard === "STATE_BOARD" ? "state" : "cbse"}`}>
                              {selectedBoard === "STATE_BOARD" ? "State Board" : "CBSE"}
                            </span>
                          </td>
                          <td>
                            <span className="class-lvl-badge">Class {cls.classLevel || 10}</span>
                          </td>
                          <td>
                            {isSeniorSecondary ? (
                              <span style={{ fontSize: "0.82rem", fontWeight: 700, color: "#7c3aed" }}>
                                🧪 Academic Groups Required
                              </span>
                            ) : (
                              <span style={{ fontSize: "0.82rem", fontWeight: 600, color: "#059669" }}>
                                📚 Direct Subject Stream
                              </span>
                            )}
                          </td>
                          <td className="text-right">
                            <button
                              className="btn-link-green mr-2"
                              onClick={() => handleSelectClass(cls)}
                            >
                              {isSeniorSecondary ? "Manage Groups →" : "Manage Subjects →"}
                            </button>
                            <button
                              className="btn-link-edit"
                              onClick={(e) => {
                                e.stopPropagation();
                                setEditingClass(cls);
                                setClassNameInput(cls.className);
                                setClassBoardInput(cls.board || selectedBoard || "CBSE");
                                setClassLevelInput(cls.classLevel || 10);
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
                      );
                    })}
                    {classes.length === 0 && !loading && (
                      <tr>
                        <td colSpan="5" className="empty-row">
                          No classes found for {selectedBoard === "STATE_BOARD" ? "State Board" : "CBSE"}. Click "+ Add Class" to create one.
                        </td>
                      </tr>
                    )}
                  </tbody>
                </table>
              </div>
            </div>
          )}

          {/* ========================================================
              SCREEN 2: GROUPS VIEW (Mandatory for Classes 11 & 12)
              ======================================================== */}
          {currentView === "GROUPS" && (
            <div className="admin-view-container">
              <div className="admin-header-row">
                <div className="header-title-group">
                  <button className="btn-back-arrow" onClick={() => setCurrentView("CLASSES")}>
                    ←
                  </button>
                  <div>
                    <h1 className="admin-page-title">
                      {selectedClass?.className} · Academic Groups
                    </h1>
                    <span className="admin-page-subtitle">
                      Board: {selectedBoard === "STATE_BOARD" ? "State Board" : "CBSE"} | Class {selectedClass?.classLevel} — Select a group to manage its specific subjects
                    </span>
                  </div>
                </div>
              </div>

              <div className="admin-groups-grid">
                {availableGroups.map((grp) => (
                  <div key={grp.id} className="admin-group-card">
                    <div>
                      <div className="group-card-header">
                        <h3 className="group-card-title">{grp.title}</h3>
                        <span className="group-code-badge">{grp.code}</span>
                      </div>

                      <div className="group-subjects-preview">
                        {grp.subjects.map((subName) => (
                          <span key={subName} className="group-subj-pill">
                            {subName}
                          </span>
                        ))}
                      </div>
                    </div>

                    <button
                      type="button"
                      className="btn-manage-group-subjects"
                      onClick={() => handleSelectGroup(grp)}
                    >
                      <span>Manage Subjects →</span>
                    </button>
                  </div>
                ))}
              </div>
            </div>
          )}

          {/* ========================================================
              SCREEN 3: SUBJECTS VIEW
              ======================================================== */}
          {currentView === "SUBJECTS" && (
            <div className="admin-view-container">
              <div className="admin-header-row">
                <div className="header-title-group">
                  <button
                    className="btn-back-arrow"
                    onClick={() => {
                      if (selectedClass?.classLevel === 11 || selectedClass?.classLevel === 12) {
                        setCurrentView("GROUPS");
                      } else {
                        setCurrentView("CLASSES");
                      }
                    }}
                  >
                    ←
                  </button>
                  <div>
                    <h1 className="admin-page-title">
                      {selectedClass?.className}
                      {selectedGroup ? ` · ${selectedGroup.title}` : ""} · Subjects
                    </h1>
                    <span className="admin-page-subtitle">
                      Board: {selectedBoard === "STATE_BOARD" ? "State Board" : "CBSE"} | Class {selectedClass?.classLevel}
                      {selectedGroup ? ` | Group: ${selectedGroup.title}` : ""}
                    </span>
                  </div>
                </div>
                <button
                  className="btn-admin-blue"
                  onClick={() => {
                    setEditingSubjectItem(null);
                    setSubjectNameInput("");
                    setSubjectCodeInput("");
                    setSubjectIconInput("📚");
                    setSubjectColorInput("#ff7e5f");
                    setShowAddSubjectModal(true);
                  }}
                >
                  + Add Subject
                </button>
              </div>

              <div className="admin-table-wrapper">
                <table className="admin-table">
                  <thead>
                    <tr>
                      <th>Subject Name</th>
                      <th>Code</th>
                      <th>Icon</th>
                      <th className="text-right">Actions</th>
                    </tr>
                  </thead>
                  <tbody>
                    {subjects.map((subj) => (
                      <tr key={subj.id}>
                        <td className="clickable-cell font-semibold" onClick={() => handleSelectSubject(subj)}>
                          <span style={{ marginRight: "8px", fontSize: "1.2rem" }}>{subj.icon || "📚"}</span>
                          {subj.subjectName}
                        </td>
                        <td>
                          <span className="subject-code-tag">{subj.subjectCode || subj.subjectName}</span>
                        </td>
                        <td>
                          <span style={{ fontSize: "1.2rem" }}>{subj.icon || "📚"}</span>
                        </td>
                        <td className="text-right">
                          <button
                            className="btn-link-green mr-2"
                            onClick={() => handleSelectSubject(subj)}
                          >
                            Manage Units →
                          </button>
                          <button
                            className="btn-link-edit"
                            onClick={(e) => {
                              e.stopPropagation();
                              setEditingSubjectItem(subj);
                              setSubjectNameInput(subj.subjectName);
                              setSubjectCodeInput(subj.subjectCode || "");
                              setSubjectIconInput(subj.icon || "📚");
                              setSubjectColorInput(subj.color || "#ff7e5f");
                              setShowAddSubjectModal(true);
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
                                type: "SUBJECT",
                                id: subj.id,
                                name: subj.subjectName,
                              });
                            }}
                          >
                            Delete
                          </button>
                        </td>
                      </tr>
                    ))}
                    {subjects.length === 0 && !loading && (
                      <tr>
                        <td colSpan="4" className="empty-row">
                          No subjects found for this selection. Click "+ Add Subject" to create one.
                        </td>
                      </tr>
                    )}
                  </tbody>
                </table>
              </div>
            </div>
          )}

          {/* ========================================================
              SCREEN 4: UNITS VIEW
              ======================================================== */}
          {currentView === "UNITS" && (
            <div className="admin-view-container">
              <div className="admin-header-row">
                <div className="header-title-group">
                  <button className="btn-back-arrow" onClick={() => setCurrentView("SUBJECTS")}>
                    ←
                  </button>
                  <div>
                    <h1 className="admin-page-title">
                      {selectedSubject?.icon || "📚"} {selectedSubject?.subjectName} · Units
                    </h1>
                    <span className="admin-page-subtitle">
                      {selectedBoard === "STATE_BOARD" ? "State Board" : "CBSE"} · {selectedClass?.className}
                      {selectedGroup ? ` · ${selectedGroup.title}` : ""}
                    </span>
                  </div>
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
                        <td className="clickable-cell font-semibold" onClick={() => handleSelectUnit(u)}>
                          {u.unitName}
                        </td>
                        <td className="text-right">
                          <button
                            className="btn-link-green mr-2"
                            onClick={() => handleSelectUnit(u)}
                          >
                            Manage Chapters →
                          </button>
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
                          No units found in this subject. Click "+ Add Unit" to create one.
                        </td>
                      </tr>
                    )}
                  </tbody>
                </table>
              </div>
            </div>
          )}

          {/* ========================================================
              SCREEN 5: CHAPTERS VIEW
              ======================================================== */}
          {currentView === "CHAPTERS" && (
            <div className="admin-view-container">
              <div className="admin-header-row">
                <div className="header-title-group">
                  <button className="btn-back-arrow" onClick={() => setCurrentView("UNITS")}>
                    ←
                  </button>
                  <div>
                    <h1 className="admin-page-title">{selectedUnit?.unitName || "Unit 1"} · Chapters</h1>
                    <span className="admin-page-subtitle">
                      Subject: {selectedSubject?.subjectName} | {selectedClass?.className}
                      {selectedGroup ? ` | ${selectedGroup.title}` : ""}
                    </span>
                  </div>
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
                        <td className="clickable-cell font-semibold" onClick={() => handleSelectChapter(ch)}>
                          {ch.chapterName}
                        </td>
                        <td className="text-right">
                          <button
                            className="btn-link-green mr-2"
                            onClick={() => handleSelectChapter(ch)}
                          >
                            Manage Missions →
                          </button>
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

          {/* ========================================================
              SCREEN 6: MISSIONS VIEW
              ======================================================== */}
          {currentView === "MISSIONS" && (
            <div className="admin-view-container">
              <div className="admin-header-row">
                <div className="header-title-group">
                  <button className="btn-back-arrow" onClick={() => setCurrentView("CHAPTERS")}>
                    ←
                  </button>
                  <div>
                    <h1 className="admin-page-title">
                      {selectedChapter?.chapterName || "Chapter"} · 4 Missions
                    </h1>
                    <span className="admin-page-subtitle">
                      {selectedSubject?.subjectName} · {selectedUnit?.unitName}
                      {selectedGroup ? ` · ${selectedGroup.title}` : ""}
                    </span>
                  </div>
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

          {/* ========================================================
              SCREEN 7: ADD / EDIT QUESTION FORM
              ======================================================== */}
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

                  <div>
                    <h1 className="admin-page-title">
                      Mission {selectedMission?.missionNumber || 1} – {selectedMission?.gameType || "MCQ Quiz"}
                    </h1>
                    <span className="admin-page-subtitle">
                      Board: {selectedBoard === "STATE_BOARD" ? "State Board" : "CBSE"} · Class {selectedClass?.classLevel}
                      {selectedGroup ? ` · ${selectedGroup.title}` : ""} · Subject: {selectedSubject?.subjectName} · {selectedChapter?.chapterName}
                    </span>
                  </div>
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
                              placeholder="What is the concept/formula/answer?"
                              value={qForm.questionText}
                              onChange={(e) => setQForm({ ...qForm, questionText: e.target.value })}
                              required
                            />
                          </div>

                          <div className="form-group">
                            <label>Option A</label>
                            <input
                              type="text"
                              placeholder="Option A text"
                              value={qForm.optionA}
                              onChange={(e) => setQForm({ ...qForm, optionA: e.target.value })}
                              required
                            />
                          </div>

                          <div className="form-group">
                            <label>Option B</label>
                            <input
                              type="text"
                              placeholder="Option B text"
                              value={qForm.optionB}
                              onChange={(e) => setQForm({ ...qForm, optionB: e.target.value })}
                              required
                            />
                          </div>

                          <div className="form-group">
                            <label>Option C</label>
                            <input
                              type="text"
                              placeholder="Option C text"
                              value={qForm.optionC}
                              onChange={(e) => setQForm({ ...qForm, optionC: e.target.value })}
                              required
                            />
                          </div>

                          <div className="form-group">
                            <label>Option D</label>
                            <input
                              type="text"
                              placeholder="Option D text"
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
                              placeholder="____ is the primary property/element."
                              value={qForm.questionText}
                              onChange={(e) => setQForm({ ...qForm, questionText: e.target.value })}
                              required
                            />
                          </div>

                          <div className="form-group">
                            <label>Correct Answer</label>
                            <input
                              type="text"
                              placeholder="Correct keyword"
                              value={qForm.correctAnswer}
                              onChange={(e) => setQForm({ ...qForm, correctAnswer: e.target.value })}
                              required
                            />
                          </div>

                          <div className="form-group">
                            <label>Accepted Answers (optional)</label>
                            <input
                              type="text"
                              placeholder="e.g. synonym1, synonym2"
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
                                  placeholder="Describe the application, case study, or problem scenario..."
                                  value={qForm.questionText}
                                  onChange={(e) => setQForm({ ...qForm, questionText: e.target.value })}
                                  required
                                />
                              </div>

                              <div className="form-group">
                                <label>Option A</label>
                                <input
                                  type="text"
                                  placeholder="Option A"
                                  value={qForm.optionA}
                                  onChange={(e) => setQForm({ ...qForm, optionA: e.target.value })}
                                  required
                                />
                              </div>

                              <div className="form-group">
                                <label>Option B</label>
                                <input
                                  type="text"
                                  placeholder="Option B"
                                  value={qForm.optionB}
                                  onChange={(e) => setQForm({ ...qForm, optionB: e.target.value })}
                                  required
                                />
                              </div>

                              <div className="form-group">
                                <label>Option C</label>
                                <input
                                  type="text"
                                  placeholder="Option C"
                                  value={qForm.optionC}
                                  onChange={(e) => setQForm({ ...qForm, optionC: e.target.value })}
                                  required
                                />
                              </div>

                              <div className="form-group">
                                <label>Option D</label>
                                <input
                                  type="text"
                                  placeholder="Option D"
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
                                  placeholder="Write a program/function/query to solve this problem."
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
                  <h3 className="info-card-title">Curriculum Hierarchy</h3>
                  <ul className="info-check-list">
                    <li>
                      <span className="check-icon">✓</span>
                      <span>
                        {selectedClass?.classLevel >= 11
                          ? "Board → Class → Group → Subject → Unit → Chapter → Mission → Question"
                          : "Board → Class → Subject → Unit → Chapter → Mission → Question"}
                      </span>
                    </li>
                    <li>
                      <span className="check-icon">✓</span>
                      <span>Board Context: {selectedBoard === "STATE_BOARD" ? "State Board" : "CBSE"}</span>
                    </li>
                    {selectedGroup && (
                      <li>
                        <span className="check-icon">✓</span>
                        <span>Active Group: {selectedGroup.title}</span>
                      </li>
                    )}
                    <li>
                      <span className="check-icon">✓</span>
                      <span>4 Missions per chapter with custom game types</span>
                    </li>
                    <li>
                      <span className="check-icon">✓</span>
                      <span>5 Questions per Mission (MCQ, Fill in blank, Scenario)</span>
                    </li>
                    <li>
                      <span className="check-icon">✓</span>
                      <span>Zero cross-contamination between boards and groups</span>
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
                placeholder="e.g. 10th Standard"
                value={classNameInput}
                onChange={(e) => setClassNameInput(e.target.value)}
                autoFocus
              />
            </div>
            <div className="modal-form-group">
              <label>Board</label>
              <select
                value={classBoardInput}
                onChange={(e) => setClassBoardInput(e.target.value)}
                className="admin-select-dropdown w-full"
              >
                <option value="STATE_BOARD">State Board</option>
                <option value="CBSE">CBSE</option>
              </select>
            </div>
            <div className="modal-form-group">
              <label>Class Level (4 - 12)</label>
              <input
                type="number"
                min="4"
                max="12"
                value={classLevelInput}
                onChange={(e) => setClassLevelInput(Number(e.target.value))}
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

      {/* MODAL: ADD / EDIT SUBJECT */}
      {showAddSubjectModal && (
        <div className="modal-backdrop" onClick={() => setShowAddSubjectModal(false)}>
          <div className="modal-card" onClick={(e) => e.stopPropagation()}>
            <h2>{editingSubjectItem ? "Edit Subject" : "Add Subject"}</h2>
            <div className="modal-form-group">
              <label>Subject Name</label>
              <input
                type="text"
                placeholder="e.g. Mathematics"
                value={subjectNameInput}
                onChange={(e) => setSubjectNameInput(e.target.value)}
                autoFocus
              />
            </div>
            <div className="modal-form-group">
              <label>Subject Code</label>
              <input
                type="text"
                placeholder="e.g. MATH"
                value={subjectCodeInput}
                onChange={(e) => setSubjectCodeInput(e.target.value)}
              />
            </div>
            <div className="modal-form-group">
              <label>Icon Emoji</label>
              <input
                type="text"
                placeholder="e.g. 📐"
                value={subjectIconInput}
                onChange={(e) => setSubjectIconInput(e.target.value)}
              />
            </div>
            <div className="modal-form-group">
              <label>Accent Color</label>
              <input
                type="color"
                value={subjectColorInput}
                onChange={(e) => setSubjectColorInput(e.target.value)}
                style={{ height: "40px", cursor: "pointer" }}
              />
            </div>
            <div className="modal-actions">
              <button className="btn-modal-cancel" onClick={() => setShowAddSubjectModal(false)}>
                Cancel
              </button>
              <button className="btn-admin-blue" onClick={handleSaveSubject}>
                Save Subject
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
                Save Unit
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
                placeholder="e.g. Chapter 1 - Real Numbers"
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
                Save Chapter
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
