import React, { useEffect, useState } from "react";
import { adminApi } from "../../api/client";
import { useAuth } from "../../context/AuthContext";
import AdminLayout from "../../components/AdminLayout";
import Loader from "../../components/Loader";

export default function AdminUnitsPage() {
  const { adminUser } = useAuth();
  const [units, setUnits] = useState(null);
  const [error, setError] = useState("");
  const [modalOpen, setModalOpen] = useState(false);
  const [editingUnit, setEditingUnit] = useState(null);

  const [unitName, setUnitName] = useState("");
  const [unitNumber, setUnitNumber] = useState(1);
  const [saving, setSaving] = useState(false);

  const fetchUnits = () => {
    adminApi
      .getUnits({ adminId: adminUser?.id })
      .then((data) => {
        const sorted = (data || []).sort((a, b) => (a.unitNumber || 0) - (b.unitNumber || 0));
        setUnits(sorted);
      })
      .catch((err) => setError(err.message));
  };

  useEffect(() => {
    fetchUnits();
  }, [adminUser?.id]);

  const openAdd = () => {
    setEditingUnit(null);
    setUnitName("");
    setUnitNumber(units ? units.length + 1 : 1);
    setModalOpen(true);
  };

  const openEdit = (u) => {
    setEditingUnit(u);
    setUnitName(u.unitName || "");
    setUnitNumber(u.unitNumber || 1);
    setModalOpen(true);
  };

  const handleDelete = async (id) => {
    if (!window.confirm("Are you sure you want to delete this unit?")) return;
    try {
      await adminApi.deleteUnit(id);
      fetchUnits();
    } catch (err) {
      alert("Error deleting unit: " + err.message);
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setSaving(true);
    try {
      const payload = {
        unitName,
        unitNumber: Number(unitNumber),
        school: adminUser?.school,
        schoolId: adminUser?.school?.id,
      };
      if (editingUnit) {
        await adminApi.updateUnit(editingUnit.id, payload);
      } else {
        await adminApi.createUnit(payload);
      }
      setModalOpen(false);
      fetchUnits();
    } catch (err) {
      alert("Error saving unit: " + err.message);
    } finally {
      setSaving(false);
    }
  };

  return (
    <AdminLayout>
      <div className="admin-page-header">
        <div>
          <h1>Units Management</h1>
          <p className="admin-page-sub">Create, edit, or remove curriculum units</p>
        </div>
        <button className="btn btn-admin-primary" onClick={openAdd}>
          ➕ Add New Unit
        </button>
      </div>

      {error && <div className="error-banner">{error}</div>}
      {!units && !error && <Loader label="Loading units..." />}

      {units && (
        <div className="admin-table-container">
          <table className="admin-table">
            <thead>
              <tr>
                <th>ID</th>
                <th>Unit Number</th>
                <th>Unit Name</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {units.length === 0 && (
                <tr>
                  <td colSpan="4" className="text-center">
                    No units added yet.
                  </td>
                </tr>
              )}
              {units.map((u) => (
                <tr key={u.id}>
                  <td>#{u.id}</td>
                  <td>Unit {u.unitNumber}</td>
                  <td>
                    <strong>{u.unitName}</strong>
                  </td>
                  <td>
                    <div className="table-actions">
                      <button className="btn-action edit" onClick={() => openEdit(u)}>
                        ✏️ Edit
                      </button>
                      <button className="btn-action delete" onClick={() => handleDelete(u.id)}>
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
            <h2>{editingUnit ? "Edit Unit" : "Add New Unit"}</h2>
            <form onSubmit={handleSubmit}>
              <div className="admin-field">
                <label>Unit Number</label>
                <input
                  type="number"
                  value={unitNumber}
                  onChange={(e) => setUnitNumber(e.target.value)}
                  required
                />
              </div>

              <div className="admin-field">
                <label>Unit Name</label>
                <input
                  type="text"
                  value={unitName}
                  onChange={(e) => setUnitName(e.target.value)}
                  placeholder="e.g. Introduction to Computer Systems"
                  required
                />
              </div>

              <div className="admin-modal-actions">
                <button type="button" className="btn btn-admin-secondary" onClick={() => setModalOpen(false)}>
                  Cancel
                </button>
                <button type="submit" className="btn btn-admin-primary" disabled={saving}>
                  {saving ? "Saving..." : "Save Unit"}
                </button>
              </div>
            </form>
          </div>
        </div>
      )}
    </AdminLayout>
  );
}
