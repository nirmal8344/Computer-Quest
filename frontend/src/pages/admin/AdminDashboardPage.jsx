import React, { useEffect, useState } from "react";
import { adminApi } from "../../api/client";
import { useAuth } from "../../context/AuthContext";
import AdminLayout from "../../components/AdminLayout";
import Loader from "../../components/Loader";

export default function AdminDashboardPage() {
  const { adminUser } = useAuth();
  const [stats, setStats] = useState(null);
  const [error, setError] = useState("");

  useEffect(() => {
    adminApi
      .getDashboard({ adminId: adminUser?.id })
      .then((data) => setStats(data))
      .catch((err) => setError(err.message));
  }, [adminUser?.id]);

  return (
    <AdminLayout>
      <div className="admin-page-header">
        <h1>Dashboard Overview</h1>
        <p className="admin-page-sub">Live game metrics and content statistics</p>
      </div>

      {error && <div className="error-banner">{error}</div>}
      {!stats && !error && <Loader label="Loading system dashboard..." />}

      {stats && (
        <div className="admin-dashboard-grid">
          <div className="stat-card">
            <div className="stat-card-header">
              <span className="stat-icon">👥</span>
              <span className="stat-title">Total Users</span>
            </div>
            <div className="stat-value">{stats.users ?? stats.totalUsers ?? 0}</div>
            <div className="stat-footer">Active Explorers</div>
          </div>

          <div className="stat-card">
            <div className="stat-card-header">
              <span className="stat-icon">📚</span>
              <span className="stat-title">Units</span>
            </div>
            <div className="stat-value">{stats.units ?? stats.totalUnits ?? 0}</div>
            <div className="stat-footer">Curriculum Units</div>
          </div>

          <div className="stat-card">
            <div className="stat-card-header">
              <span className="stat-icon">📖</span>
              <span className="stat-title">Chapters</span>
            </div>
            <div className="stat-value">{stats.chapters ?? stats.totalChapters ?? 0}</div>
            <div className="stat-footer">Educational Chapters</div>
          </div>

          <div className="stat-card">
            <div className="stat-card-header">
              <span className="stat-icon">🎯</span>
              <span className="stat-title">Missions</span>
            </div>
            <div className="stat-value">{stats.missions ?? stats.totalMissions ?? 0}</div>
            <div className="stat-footer">Interactive Missions</div>
          </div>

          <div className="stat-card">
            <div className="stat-card-header">
              <span className="stat-icon">❓</span>
              <span className="stat-title">Questions</span>
            </div>
            <div className="stat-value">{stats.questions ?? stats.totalQuestions ?? 0}</div>
            <div className="stat-footer">Seeded Questions</div>
          </div>
        </div>
      )}
    </AdminLayout>
  );
}
