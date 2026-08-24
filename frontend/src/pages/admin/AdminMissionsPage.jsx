import React, { useEffect, useState } from "react";
import { missionApi, chapterApi, adminApi } from "../../api/client";
import { useAuth } from "../../context/AuthContext";
import AdminLayout from "../../components/AdminLayout";
import Loader from "../../components/Loader";

export default function AdminMissionsPage() {
  const { adminUser } = useAuth();
  const [missions, setMissions] = useState(null);
  const [chapters, setChapters] = useState([]);
  const [error, setError] = useState("");
  const [modalOpen, setModalOpen] = useState(false);
  const [editingMission, setEditingMission] = useState(null);

  const [missionNumber, setMissionNumber] = useState(1);
  const [missionName, setMissionName] = useState("");
  const [gameType, setGameType] = useState("Quiz");
  const [chapterId, setChapterId] = useState("");
  const [saving, setSaving] = useState(false);

  const fetchMissions = () => {
    const params = { adminId: adminUser?.id };
    Promise.all([missionApi.getAll(params), chapterApi.getAll(params)])
      .then(([mList, cList]) => {
        setMissions(mList);
        setChapters(cList);
      })
      .catch((err) => setError(err.message));
  };

  useEffect(() => {
    fetchMissions();
  }, [adminUser?.id]);

  const openAdd = () => {
    setEditingMission(null);
    setMissionNumber(1);
    setMissionName("");
    setGameType("Quiz");
    setChapterId(chapters.length > 0 ? chapters[0].id : "");
    setModalOpen(true);
  };

  const openEdit = (m) => {
    setEditingMission(m);
    setMissionNumber(m.missionNumber || 1);
    setMissionName(m.missionName || "");
    setGameType(m.gameType || "Quiz");
    setChapterId(m.chapter?.id || (chapters.length > 0 ? chapters[0].id : ""));
    setModalOpen(true);
  };

  const handleDelete = async (id) => {
    if (!window.confirm("Are you sure you want to delete this mission?")) return;
    try {
      await adminApi.deleteMission(id);
      fetchMissions();
    } catch (err) {
      alert("Error deleting mission: " + err.message);
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setSaving(true);
    try {
      const selectedChapter = chapters.find((c) => String(c.id) === String(chapterId));
      const payload = {
        missionNumber: Number(missionNumber),
        missionName,
        gameType,
        chapter: selectedChapter ? { id: selectedChapter.id } : null,
        school: adminUser?.school,
        schoolId: adminUser?.school?.id,
      };
      if (editingMission) {
        await adminApi.updateMission(editingMission.id, payload);
      } else {
        await adminApi.createMission(payload);
      }
      setModalOpen(false);
      fetchMissions();
    } catch (err) {
      alert("Error saving mission: " + err.message);
    } finally {
      setSaving(false);
    }
  };

  return (
    <AdminLayout>
      <div className="admin-page-header">
        <div>
          <h1>Missions Management</h1>
          <p className="admin-page-sub">Configure mission numbers, game types, and assigned chapters</p>
        </div>
        <button className="btn btn-admin-primary" onClick={openAdd}>
          ➕ Add New Mission
        </button>
      </div>

      {error && <div className="error-banner">{error}</div>}
      {!missions && !error && <Loader label="Loading missions..." />}

      {missions && (
        <div className="admin-table-container">
          <table className="admin-table">
            <thead>
              <tr>
                <th>ID</th>
                <th>Mission #</th>
                <th>Mission Name</th>
                <th>Game Type</th>
                <th>Assigned Chapter</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {missions.length === 0 && (
                <tr>
                  <td colSpan="6" className="text-center">
                    No missions added yet.
                  </td>
                </tr>
              )}
              {missions.map((m) => (
                <tr key={m.id}>
                  <td>#{m.id}</td>
                  <td>Mission {m.missionNumber}</td>
                  <td>
                    <strong>{m.missionName || `Mission ${m.missionNumber}`}</strong>
                  </td>
                  <td>
                    <span className="badge-type">{m.gameType || "Quiz"}</span>
                  </td>
                  <td>{m.chapter?.chapterName ? `${m.chapter.chapterName} (Ch ${m.chapter.chapterNumber})` : "Unassigned"}</td>
                  <td>
                    <div className="table-actions">
                      <button className="btn-action edit" onClick={() => openEdit(m)}>
                        ✏️ Edit
                      </button>
                      <button className="btn-action delete" onClick={() => handleDelete(m.id)}>
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

      {modalOpen && (
        <div className="admin-modal-backdrop">
          <div className="admin-modal">
            <h2>{editingMission ? "Edit Mission" : "Add New Mission"}</h2>
            <form onSubmit={handleSubmit}>
              <div className="admin-field">
                <label>Mission Number (1 - 4)</label>
                <input
                  type="number"
                  min="1"
                  max="4"
                  value={missionNumber}
                  onChange={(e) => setMissionNumber(e.target.value)}
                  required
                />
              </div>

              <div className="admin-field">
                <label>Mission Name</label>
                <input
                  type="text"
                  value={missionName}
                  onChange={(e) => setMissionName(e.target.value)}
                  placeholder="e.g. CPU Basics Quest"
                />
              </div>

              <div className="admin-field">
                <label>Game Type</label>
                <select value={gameType} onChange={(e) => setGameType(e.target.value)}>
                  <option value="Quiz">Quiz</option>
                  <option value="Puzzle">Puzzle</option>
                  <option value="DragDrop">Drag & Drop</option>
                </select>
              </div>

              <div className="admin-field">
                <label>Assigned Chapter</label>
                <select value={chapterId} onChange={(e) => setChapterId(e.target.value)} required>
                  <option value="">-- Select Chapter --</option>
                  {chapters.map((c) => (
                    <option key={c.id} value={c.id}>
                      Chapter {c.chapterNumber}: {c.chapterName} ({c.unit})
                    </option>
                  ))}
                </select>
              </div>

              <div className="admin-modal-actions">
                <button type="button" className="btn btn-admin-secondary" onClick={() => setModalOpen(false)}>
                  Cancel
                </button>
                <button type="submit" className="btn btn-admin-primary" disabled={saving}>
                  {saving ? "Saving..." : "Save Mission"}
                </button>
              </div>
            </form>
          </div>
        </div>
      )}
    </AdminLayout>
  );
}
