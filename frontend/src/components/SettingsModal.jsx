import React, { useState } from "react";
import { useAuth } from "../context/AuthContext";
import { useNavigate } from "react-router-dom";
import { GearIcon, CloseIcon } from "./GameIcons";
import "../styles/settings.css";

export default function SettingsModal({ onClose }) {
  const { user, logout } = useAuth();
  const navigate = useNavigate();

  // Settings state stored in localStorage for persistence
  const [soundX, setSoundX] = useState(() => localStorage.getItem("cq_sfx") !== "false");
  const [music, setMusic] = useState(() => localStorage.getItem("cq_music") !== "false");
  const [volume, setVolume] = useState(() => Number(localStorage.getItem("cq_volume") || 80));
  const [theme, setTheme] = useState(() => localStorage.getItem("cq_theme") || "light");
  const [textSize, setTextSize] = useState(() => localStorage.getItem("cq_text_size") || "normal");

  const [showPasswordChange, setShowPasswordChange] = useState(false);
  const [newPassword, setNewPassword] = useState("");
  const [passwordMsg, setPasswordMsg] = useState("");

  const handleToggleSound = () => {
    const next = !soundX;
    setSoundX(next);
    localStorage.setItem("cq_sfx", String(next));
  };

  const handleToggleMusic = () => {
    const next = !music;
    setMusic(next);
    localStorage.setItem("cq_music", String(next));
  };

  const handleVolumeChange = (e) => {
    const val = e.target.value;
    setVolume(val);
    localStorage.setItem("cq_volume", String(val));
  };

  const handleThemeChange = (newTheme) => {
    setTheme(newTheme);
    localStorage.setItem("cq_theme", newTheme);
    document.documentElement.setAttribute("data-theme", newTheme);
  };

  const handleTextSizeChange = (newSize) => {
    setTextSize(newSize);
    localStorage.setItem("cq_text_size", newSize);
    document.documentElement.setAttribute("data-text-size", newSize);
  };

  const handlePasswordSave = () => {
    if (!newPassword || newPassword.length < 4) {
      setPasswordMsg("Password must be at least 4 characters.");
      return;
    }
    // In a real API, call userApi.updatePassword; for demo, save success feedback
    setPasswordMsg("Password updated successfully!");
    setTimeout(() => {
      setShowPasswordChange(false);
      setPasswordMsg("");
      setNewPassword("");
    }, 1200);
  };

  const handleLogout = () => {
    logout();
    onClose();
    navigate("/login");
  };

  return (
    <div className="modal-backdrop" onClick={onClose}>
      <div className="modal-card settings-modal-box" onClick={(e) => e.stopPropagation()}>
        <div className="settings-modal-header">
          <div className="modal-header-title">
            <div className="settings-header-icon">
              <GearIcon size={22} />
            </div>
            <h2>LearnQuest Settings</h2>
          </div>
          <button className="topbar-circle-btn" onClick={onClose} title="Close">
            <CloseIcon size={18} />
          </button>
        </div>

        <div className="settings-controls-list">
          {/* Audio Section */}
          <div className="settings-section-divider">
            <span className="section-label">🔊 Audio & Sounds</span>
          </div>

          <div className="setting-control-row">
            <span className="setting-title-text">Sound Effects (SFX)</span>
            <button
              className={`modern-toggle-pill ${soundX ? "active" : ""}`}
              onClick={handleToggleSound}
            >
              {soundX ? "ON" : "OFF"}
            </button>
          </div>

          <div className="setting-control-row">
            <span className="setting-title-text">Background Music</span>
            <button
              className={`modern-toggle-pill ${music ? "active" : ""}`}
              onClick={handleToggleMusic}
            >
              {music ? "ON" : "OFF"}
            </button>
          </div>

          <div className="setting-control-row column">
            <div className="setting-label-row">
              <span className="setting-title-text">Master Volume</span>
              <span className="volume-val-badge">{volume}%</span>
            </div>
            <input
              type="range"
              min="0"
              max="100"
              value={volume}
              onChange={handleVolumeChange}
              className="modern-volume-slider"
            />
          </div>

          {/* Display & Accessibility */}
          <div className="settings-section-divider">
            <span className="section-label">🎨 Display & Accessibility</span>
          </div>

          <div className="setting-control-row">
            <span className="setting-title-text">Appearance Theme</span>
            <div className="setting-pill-group">
              <button
                className={`theme-pill-btn ${theme === "light" ? "active" : ""}`}
                onClick={() => handleThemeChange("light")}
              >
                ☀️ Bright
              </button>
              <button
                className={`theme-pill-btn ${theme === "dark" ? "active" : ""}`}
                onClick={() => handleThemeChange("dark")}
              >
                🌙 Slate
              </button>
            </div>
          </div>

          <div className="setting-control-row">
            <span className="setting-title-text">Text Size</span>
            <div className="setting-pill-group">
              <button
                className={`theme-pill-btn ${textSize === "normal" ? "active" : ""}`}
                onClick={() => handleTextSizeChange("normal")}
              >
                Standard
              </button>
              <button
                className={`theme-pill-btn ${textSize === "large" ? "active" : ""}`}
                onClick={() => handleTextSizeChange("large")}
              >
                Large A+
              </button>
            </div>
          </div>

          {/* Account Profile Card */}
          <div className="settings-section-divider">
            <span className="section-label">👤 Student Profile</span>
          </div>

          <div className="user-profile-badge-box">
            <div className="user-profile-details">
              <span className="user-profile-name">{user?.username || "Student"}</span>
              <span className="user-profile-class">
                {user?.board || "CBSE"} · Class {user?.classLevel || "10"}
                {user?.school?.name ? ` · ${user.school.name}` : ""}
              </span>
            </div>
            <span className="user-role-chip">{user?.role || "STUDENT"}</span>
          </div>

          {/* Change Password Inline */}
          {showPasswordChange ? (
            <div className="password-change-box">
              <span className="setting-title-text">Update Password</span>
              <input
                type="password"
                placeholder="Enter new password..."
                value={newPassword}
                onChange={(e) => setNewPassword(e.target.value)}
                className="modern-text-input"
              />
              {passwordMsg && <span className="password-feedback-msg">{passwordMsg}</span>}
              <div className="password-btn-row">
                <button className="btn btn-peach btn-sm-card" onClick={handlePasswordSave}>
                  Save Password
                </button>
                <button
                  className="btn btn-ghost btn-sm-card"
                  onClick={() => setShowPasswordChange(false)}
                >
                  Cancel
                </button>
              </div>
            </div>
          ) : (
            <button
              className="btn btn-outline-setting"
              onClick={() => setShowPasswordChange(true)}
            >
              🔒 Change Password
            </button>
          )}
        </div>

        <div className="settings-modal-actions">
          <button className="btn btn-danger btn-block" onClick={handleLogout}>
            Sign Out / Switch Account
          </button>
          <button className="btn btn-ghost btn-block" onClick={onClose}>
            Back to Game
          </button>
        </div>
      </div>
    </div>
  );
}
