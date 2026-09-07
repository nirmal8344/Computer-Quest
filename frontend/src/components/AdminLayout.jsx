import React, { useState } from "react";
import { Navigate, useLocation, useNavigate } from "react-router-dom";
import { useAuth } from "../context/AuthContext";
import { GitHubIcon } from "./GameIcons";
import "../styles/admin.css";

const GITHUB_REPO_URL = "https://github.com/nirmal8344/Computer-Quest";

export default function AdminLayout({ children }) {
  const { adminUser, adminLogout } = useAuth();
  const navigate = useNavigate();
  const location = useLocation();
  const [mobileMenuOpen, setMobileMenuOpen] = useState(false);

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
      {/* Mobile Header Bar */}
      <div className="admin-mobile-header">
        <div className="admin-brand-mobile">
          <span className="brand-logo">⚡ CQ Admin</span>
        </div>
        <div className="admin-mobile-actions">
          <a
            href={GITHUB_REPO_URL}
            target="_blank"
            rel="noopener noreferrer"
            className="btn-admin-github-mobile"
            title="GitHub Repository"
          >
            <GitHubIcon size={18} />
          </a>
          <button
            className="btn-admin-hamburger"
            onClick={() => setMobileMenuOpen(!mobileMenuOpen)}
            aria-label="Toggle navigation menu"
          >
            {mobileMenuOpen ? "✕" : "☰"}
          </button>
        </div>
      </div>

      <aside className={`admin-sidebar ${mobileMenuOpen ? "is-open-mobile" : ""}`}>
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
                onClick={() => {
                  navigate(item.path);
                  setMobileMenuOpen(false);
                }}
              >
                <span className="nav-icon">{item.icon}</span>
                <span>{item.label}</span>
              </button>
            );
          })}
        </nav>

        <div className="admin-sidebar-footer">
          <a
            href={GITHUB_REPO_URL}
            target="_blank"
            rel="noopener noreferrer"
            className="admin-sidebar-github"
          >
            <GitHubIcon size={18} />
            <span>GitHub Repository</span>
          </a>

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
          <div className="admin-topbar-actions">
            <a
              href={GITHUB_REPO_URL}
              target="_blank"
              rel="noopener noreferrer"
              className="btn-admin-github"
              title="View on GitHub"
            >
              <GitHubIcon size={18} />
              <span>GitHub</span>
            </a>
            <button className="btn btn-outline-game" onClick={() => navigate("/lobby")}>
              🎮 Player Game
            </button>
          </div>
        </header>
        <div className="admin-content">{children}</div>
      </main>
    </div>
  );
}
