import React from "react";
import { Navigate, useLocation, useNavigate } from "react-router-dom";
import { useAuth } from "../context/AuthContext";
import "../styles/admin.css";

export default function AdminLayout({ children }) {
  const { adminUser, adminLogout } = useAuth();
  const navigate = useNavigate();
  const location = useLocation();

  if (!adminUser) {
    return <Navigate to="/admin/login" replace />;
  }

  const handleLogout = () => {
    adminLogout();
    navigate("/admin/login");
  };

  const navItems = [
    { label: "Dashboard", path: "/admin/dashboard", icon: "📊" },
    { label: "Users & Progress", path: "/admin/users", icon: "👥" },
    { label: "Units", path: "/admin/units", icon: "📚" },
    { label: "Chapters", path: "/admin/chapters", icon: "📖" },
    { label: "Missions", path: "/admin/missions", icon: "🎯" },
    { label: "Questions", path: "/admin/questions", icon: "❓" },
  ];

  return (
    <div className="admin-shell">
      <aside className="admin-sidebar">
        <div className="admin-brand">
          <span className="brand-logo">⚡ CQ Admin</span>
          <span className="brand-badge">Control Center</span>
        </div>

        <nav className="admin-nav">
          {navItems.map((item) => {
            const isActive = location.pathname === item.path;
            return (
              <button
                key={item.path}
                className={`admin-nav-item ${isActive ? "active" : ""}`}
                onClick={() => navigate(item.path)}
              >
                <span className="nav-icon">{item.icon}</span>
                <span>{item.label}</span>
              </button>
            );
          })}
        </nav>

        <div className="admin-sidebar-footer">
          <div className="admin-user-pill">
            <span>👤 {adminUser.username}</span>
          </div>
          <button className="btn btn-admin-logout" onClick={handleLogout}>
            Logout
          </button>
        </div>
      </aside>

      <main className="admin-main">
        <header className="admin-topbar">
          <h2>Computer Quest Management</h2>
          <button className="btn btn-outline-game" onClick={() => navigate("/lobby")}>
            🎮 Launch Player Game UI
          </button>
        </header>
        <div className="admin-content">{children}</div>
      </main>
    </div>
  );
}
