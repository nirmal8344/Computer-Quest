import React, { useEffect, useState } from "react";
import { chapterApi, adminApi } from "../../api/client";
import { useAuth } from "../../context/AuthContext";
import AdminLayout from "../../components/AdminLayout";
import Loader from "../../components/Loader";

export default function AdminChaptersPage() {
  const { adminUser } = useAuth();
  const [chapters, setChapters] = useState(null);
  const [error, setError] = useState("");
  const [modalOpen, setModalOpen] = useState(false);
  const [editingChapter, setEditingChapter] = useState(null);

  const [chapterName, setChapterName] = useState("");
  const [chapterNumber, setChapterNumber] = useState(1);
  const [unit, setUnit] = useState("Unit 1");
  const [unlocked, setUnlocked] = useState(false);
  const [saving, setSaving] = useState(false);

  const fetchChapters = () => {
    chapterApi
      .getAll({ adminId: adminUser?.id })
      .then((data) => setChapters(data))
      .catch((err) => setError(err.message));
  };

  useEffect(() => {
    fetchChapters();
  }, [adminUser?.id]);

  const openAdd = () => {
    setEditingChapter(null);
    setChapterName("");
    setChapterNumber(chapters ? chapters.length + 1 : 1);
    setUnit("Unit 1");
    setUnlocked(false);
    setModalOpen(true);
  };

  const openEdit = (c) => {
    setEditingChapter(c);
    setChapterName(c.chapterName || "");
    setChapterNumber(c.chapterNumber || 1);
    setUnit(c.unit || "Unit 1");
    setUnlocked(!!c.unlocked);
    setModalOpen(true);
  };

  const handleDelete = async (id) => {
    if (!window.confirm("Are you sure you want to delete this chapter?")) return;
    try {
      await adminApi.deleteChapter(id);
      fetchChapters();
    } catch (err) {
      alert("Error deleting chapter: " + err.message);
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setSaving(true);
    try {
      const payload = {
        chapterName,
        chapterNumber: Number(chapterNumber),
        unit,
        unlocked,
        school: adminUser?.school,
        schoolId: adminUser?.school?.id,
      };
      if (editingChapter) {
        await adminApi.updateChapter(editingChapter.id, payload);
      } else {
        await adminApi.createChapter(payload);
      }
      setModalOpen(false);
      fetchChapters();
    } catch (err) {
      alert("Error saving chapter: " + err.message);
    } finally {
      setSaving(false);
    }
  };

  return (
    <AdminLayout>
      <div className="admin-page-header">
        <div>
          <h1>Chapters Management</h1>
          <p className="admin-page-sub">Manage chapters, numbers, units, and unlock states</p>
        </div>
        <button className="btn btn-admin-primary" onClick={openAdd}>
          ➕ Add New Chapter
        </button>
      </div>

      {error && <div className="error-banner">{error}</div>}
      {!chapters && !error && <Loader label="Loading chapters..." />}

      {chapters && (
        <div className="admin-table-container">
          <table className="admin-table">
            <thead>
              <tr>
                <th>ID</th>
                <th>Ch #</th>
                <th>Chapter Name</th>
                <th>Unit</th>
                <th>Unlocked</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {chapters.length === 0 && (
                <tr>
                  <td colSpan="6" className="text-center">
                    No chapters added yet.
                  </td>
                </tr>
              )}
              {chapters.map((c) => (
                <tr key={c.id}>
                  <td>#{c.id}</td>
                  <td>Chapter {c.chapterNumber}</td>
                  <td>
                    <strong>{c.chapterName}</strong>
                  </td>
                  <td>{c.unit || "N/A"}</td>
                  <td>
                    <span className={`status-pill ${c.unlocked ? "unlocked" : "locked"}`}>
                      {c.unlocked ? "🔓 Unlocked" : "🔒 Locked"}
                    </span>
                  </td>
                  <td>
                    <div className="table-actions">
                      <button className="btn-action edit" onClick={() => openEdit(c)}>
                        ✏️ Edit
                      </button>
                      <button className="btn-action delete" onClick={() => handleDelete(c.id)}>
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
            <h2>{editingChapter ? "Edit Chapter" : "Add New Chapter"}</h2>
            <form onSubmit={handleSubmit}>
              <div className="admin-field">
                <label>Chapter Number</label>
                <input
                  type="number"
                  value={chapterNumber}
                  onChange={(e) => setChapterNumber(e.target.value)}
                  required
                />
              </div>

              <div className="admin-field">
                <label>Chapter Name</label>
                <input
                  type="text"
                  value={chapterName}
                  onChange={(e) => setChapterName(e.target.value)}
                  placeholder="e.g. Intro to Computer Hardware"
                  required
                />
              </div>

              <div className="admin-field">
                <label>Unit Name</label>
                <input
                  type="text"
                  value={unit}
                  onChange={(e) => setUnit(e.target.value)}
                  placeholder="e.g. Unit 1"
                  required
                />
              </div>

              <div className="admin-checkbox-field">
                <label>
                  <input
                    type="checkbox"
                    checked={unlocked}
                    onChange={(e) => setUnlocked(e.target.checked)}
                  />
                  <span>Unlocked by Default</span>
                </label>
              </div>

              <div className="admin-modal-actions">
                <button type="button" className="btn btn-admin-secondary" onClick={() => setModalOpen(false)}>
                  Cancel
                </button>
                <button type="submit" className="btn btn-admin-primary" disabled={saving}>
                  {saving ? "Saving..." : "Save Chapter"}
                </button>
              </div>
            </form>
          </div>
        </div>
      )}
    </AdminLayout>
  );
}
