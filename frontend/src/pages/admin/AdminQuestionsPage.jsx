import React, { useEffect, useState } from "react";
import { questionApi, chapterApi, unitApi, adminApi } from "../../api/client";
import { useAuth } from "../../context/AuthContext";
import AdminLayout from "../../components/AdminLayout";
import Loader from "../../components/Loader";

export default function AdminQuestionsPage() {
  const { adminUser } = useAuth();
  const [units, setUnits] = useState([]);
  const [chapters, setChapters] = useState([]);
  
  const [selectedBoard, setSelectedBoard] = useState("CBSE");
  const [selectedClass, setSelectedClass] = useState(11);
  const [selectedUnit, setSelectedUnit] = useState("CBSE Class 11 CS");
  const [selectedChapter, setSelectedChapter] = useState("");
  const [selectedMission, setSelectedMission] = useState(1);

  const [questions, setQuestions] = useState(null);
  const [error, setError] = useState("");
  const [modalOpen, setModalOpen] = useState(false);
  const [editingQuestion, setEditingQuestion] = useState(null);

  // Form states for creation hierarchy: School -> Board -> Class -> Unit -> Chapter -> Mission -> Question
  const [formBoard, setFormBoard] = useState("CBSE");
  const [formClass, setFormClass] = useState(11);
  const [formUnit, setFormUnit] = useState("");
  const [formChapter, setFormChapter] = useState("");
  const [formMission, setFormMission] = useState(1);
  const [questionText, setQuestionText] = useState("");
  const [optionA, setOptionA] = useState("");
  const [optionB, setOptionB] = useState("");
  const [optionC, setOptionC] = useState("");
  const [optionD, setOptionD] = useState("");
  const [correctAnswer, setCorrectAnswer] = useState("A");
  const [saving, setSaving] = useState(false);

  useEffect(() => {
    const params = { adminId: adminUser?.id };
    Promise.all([unitApi.getUnits(params), chapterApi.getAll(params)])
      .then(([uList, cList]) => {
        setUnits(uList || []);
        setChapters(cList || []);
        if (cList && cList.length > 0) {
          setSelectedUnit(cList[0].unit || "Unit 1");
          setSelectedChapter(cList[0].chapterName);
        }
      })
      .catch((err) => setError(err.message));
  }, [adminUser?.id]);

  const fetchQuestions = () => {
    if (!selectedChapter) return;
    questionApi
      .getForMission(selectedUnit, selectedChapter, selectedMission, {
        adminId: adminUser?.id,
        board: selectedBoard,
        classLevel: selectedClass,
      })
      .then((data) => setQuestions(data))
      .catch((err) => setError(err.message));
  };

  useEffect(() => {
    fetchQuestions();
  }, [selectedBoard, selectedClass, selectedUnit, selectedChapter, selectedMission, adminUser?.id]);

  const openAdd = () => {
    setEditingQuestion(null);
    setFormBoard(selectedBoard);
    setFormClass(selectedClass);
    setFormUnit(selectedUnit || (units.length > 0 ? units[0].unitName : "Unit 1"));
    setFormChapter(selectedChapter || (chapters.length > 0 ? chapters[0].chapterName : "Chapter 1"));
    setFormMission(selectedMission || 1);
    setQuestionText("");
    setOptionA("");
    setOptionB("");
    setOptionC("");
    setOptionD("");
    setCorrectAnswer("A");
    setModalOpen(true);
  };

  const openEdit = (q) => {
    setEditingQuestion(q);
    setFormBoard(q.board || selectedBoard);
    setFormClass(q.classLevel || selectedClass);
    setFormUnit(q.unit || selectedUnit);
    setFormChapter(q.chapter || selectedChapter);
    setFormMission(q.mission || selectedMission);
    setQuestionText(q.questionText || "");
    setOptionA(q.optionA || "");
    setOptionB(q.optionB || "");
    setOptionC(q.optionC || "");
    setOptionD(q.optionD || "");
    setCorrectAnswer(q.correctAnswer || "A");
    setModalOpen(true);
  };

  const handleDelete = async (id) => {
    if (!window.confirm("Are you sure you want to delete this question?")) return;
    try {
      await adminApi.deleteQuestion(id);
      fetchQuestions();
    } catch (err) {
      alert("Error deleting question: " + err.message);
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setSaving(true);
    try {
      const payload = {
        board: formBoard,
        classLevel: Number(formClass),
        unit: formUnit,
        chapter: formChapter,
        mission: Number(formMission),
        questionText,
        optionA,
        optionB,
        optionC,
        optionD,
        correctAnswer,
        school: adminUser?.school,
        schoolId: adminUser?.school?.id,
      };

      if (editingQuestion) {
        await adminApi.updateQuestion(editingQuestion.id, payload);
      } else {
        await adminApi.createQuestion(payload);
      }
      setModalOpen(false);
      fetchQuestions();
    } catch (err) {
      alert("Error saving question: " + err.message);
    } finally {
      setSaving(false);
    }
  };

  return (
    <AdminLayout>
      <div className="admin-page-header">
        <div>
          <h1>Questions Bank</h1>
          <p className="admin-page-sub">
            School: <strong>{adminUser?.school?.name || "My School"}</strong> — Hierarchy: School → Board → Class → Unit → Chapter → Mission → Question
          </p>
        </div>
        <button className="btn btn-admin-primary" onClick={openAdd} disabled={!selectedChapter}>
          ➕ Add New Question
        </button>
      </div>

      {/* Hierarchy Filter Bar */}
      <div className="admin-filter-bar" style={{ display: "flex", flexWrap: "wrap", gap: "12px" }}>
        <div className="admin-field">
          <label>Board</label>
          <select value={selectedBoard} onChange={(e) => setSelectedBoard(e.target.value)}>
            <option value="CBSE">CBSE</option>
            <option value="STATE_BOARD">State Board</option>
          </select>
        </div>

        <div className="admin-field">
          <label>Class</label>
          <select value={selectedClass} onChange={(e) => setSelectedClass(Number(e.target.value))}>
            <option value={11}>Class 11</option>
            <option value={12}>Class 12</option>
          </select>
        </div>

        <div className="admin-field">
          <label>Filter Chapter</label>
          <select
            value={selectedChapter}
            onChange={(e) => {
              const ch = chapters.find((c) => c.chapterName === e.target.value);
              if (ch) {
                setSelectedChapter(ch.chapterName);
                setSelectedUnit(ch.unit);
              }
            }}
          >
            {chapters.map((c) => (
              <option key={c.id} value={c.chapterName}>
                Ch {c.chapterNumber}: {c.chapterName} ({c.unit})
              </option>
            ))}
          </select>
        </div>

        <div className="admin-field">
          <label>Filter Mission</label>
          <select
            value={selectedMission}
            onChange={(e) => setSelectedMission(Number(e.target.value))}
          >
            <option value={1}>Mission 1</option>
            <option value={2}>Mission 2</option>
            <option value={3}>Mission 3</option>
            <option value={4}>Mission 4</option>
          </select>
        </div>
      </div>

      {error && <div className="error-banner">{error}</div>}
      {!questions && !error && <Loader label="Loading school questions..." />}

      {questions && (
        <div className="admin-table-container">
          <table className="admin-table">
            <thead>
              <tr>
                <th>ID</th>
                <th>Question Text</th>
                <th>Option A</th>
                <th>Option B</th>
                <th>Option C</th>
                <th>Option D</th>
                <th>Answer</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {questions.length === 0 && (
                <tr>
                  <td colSpan="8" className="text-center">
                    No questions found for {selectedChapter} - Mission {selectedMission}.
                  </td>
                </tr>
              )}
              {questions.map((q) => (
                <tr key={q.id}>
                  <td>#{q.id}</td>
                  <td>
                    <strong>{q.questionText}</strong>
                  </td>
                  <td>{q.optionA}</td>
                  <td>{q.optionB}</td>
                  <td>{q.optionC}</td>
                  <td>{q.optionD}</td>
                  <td>
                    <span className="badge-correct-ans">Option {q.correctAnswer}</span>
                  </td>
                  <td>
                    <div className="table-actions">
                      <button className="btn-action edit" onClick={() => openEdit(q)}>
                        ✏️ Edit
                      </button>
                      <button className="btn-action delete" onClick={() => handleDelete(q.id)}>
                        🗑️ Delete
                      </button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}

      {/* Creation Modal enforcing School -> Board -> Class -> Unit -> Chapter -> Mission -> Question */}
      {modalOpen && (
        <div className="admin-modal-backdrop">
          <div className="admin-modal large">
            <h2>{editingQuestion ? "Edit Question" : "Add New Question"}</h2>
            <form onSubmit={handleSubmit}>
              <div style={{ background: "rgba(245,158,11,0.15)", padding: "12px 16px", borderRadius: "10px", marginBottom: "16px", border: "1px solid #f59e0b" }}>
                <strong>Target School:</strong> {adminUser?.school?.name || "My School"}
              </div>

              <div style={{ display: "grid", gridTemplateColumns: "1fr 1fr 1fr", gap: "12px" }}>
                <div className="admin-field">
                  <label>Board</label>
                  <select value={formBoard} onChange={(e) => setFormBoard(e.target.value)} required>
                    <option value="CBSE">CBSE</option>
                    <option value="STATE_BOARD">State Board</option>
                  </select>
                </div>

                <div className="admin-field">
                  <label>Class</label>
                  <select value={formClass} onChange={(e) => setFormClass(Number(e.target.value))} required>
                    <option value={11}>Class 11</option>
                    <option value={12}>Class 12</option>
                  </select>
                </div>

                <div className="admin-field">
                  <label>Mission</label>
                  <select value={formMission} onChange={(e) => setFormMission(Number(e.target.value))} required>
                    <option value={1}>Mission 1</option>
                    <option value={2}>Mission 2</option>
                    <option value={3}>Mission 3</option>
                    <option value={4}>Mission 4</option>
                  </select>
                </div>
              </div>

              <div style={{ display: "grid", gridTemplateColumns: "1fr 1fr", gap: "12px", marginTop: "12px" }}>
                <div className="admin-field">
                  <label>Unit</label>
                  <input
                    type="text"
                    value={formUnit}
                    onChange={(e) => setFormUnit(e.target.value)}
                    placeholder="e.g. Unit 1"
                    required
                  />
                </div>

                <div className="admin-field">
                  <label>Chapter</label>
                  <input
                    type="text"
                    value={formChapter}
                    onChange={(e) => setFormChapter(e.target.value)}
                    placeholder="e.g. Computer Systems"
                    required
                  />
                </div>
              </div>

              <div className="admin-field" style={{ marginTop: "12px" }}>
                <label>Question Prompt / Text</label>
                <textarea
                  rows="3"
                  value={questionText}
                  onChange={(e) => setQuestionText(e.target.value)}
                  placeholder="Enter the question text..."
                  required
                />
              </div>

              <div className="admin-options-grid">
                <div className="admin-field">
                  <label>Option A</label>
                  <input
                    type="text"
                    value={optionA}
                    onChange={(e) => setOptionA(e.target.value)}
                    required
                  />
                </div>

                <div className="admin-field">
                  <label>Option B</label>
                  <input
                    type="text"
                    value={optionB}
                    onChange={(e) => setOptionB(e.target.value)}
                    required
                  />
                </div>

                <div className="admin-field">
                  <label>Option C</label>
                  <input
                    type="text"
                    value={optionC}
                    onChange={(e) => setOptionC(e.target.value)}
                    required
                  />
                </div>

                <div className="admin-field">
                  <label>Option D</label>
                  <input
                    type="text"
                    value={optionD}
                    onChange={(e) => setOptionD(e.target.value)}
                    required
                  />
                </div>
              </div>

              <div className="admin-field">
                <label>Correct Answer Letter</label>
                <select
                  value={correctAnswer}
                  onChange={(e) => setCorrectAnswer(e.target.value)}
                  required
                >
                  <option value="A">Option A</option>
                  <option value="B">Option B</option>
                  <option value="C">Option C</option>
                  <option value="D">Option D</option>
                </select>
              </div>

              <div className="admin-modal-actions">
                <button type="button" className="btn btn-admin-secondary" onClick={() => setModalOpen(false)}>
                  Cancel
                </button>
                <button type="submit" className="btn btn-admin-primary" disabled={saving}>
                  {saving ? "Saving..." : "Save Question"}
                </button>
              </div>
            </form>
          </div>
        </div>
      )}
    </AdminLayout>
  );
}
