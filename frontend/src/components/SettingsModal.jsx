import React, { useState } from "react";
import { useAuth } from "../context/AuthContext";
import { useNavigate } from "react-router-dom";
import { GearIcon, CloseIcon, GitHubIcon } from "./GameIcons";
import "../styles/settings.css";

const GITHUB_REPO_URL = "https://github.com/nirmal8344/Computer-Quest";

export default function SettingsModal({ onClose }) {
  const { user, logout } = useAuth();
  const navigate = useNavigate();

  const [soundX, setSoundX] = useState(true);
  const [music, setMusic] = useState(true);
  const [volume, setVolume] = useState(80);

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
            <h2>Game Settings</h2>
          </div>
          <button className="topbar-circle-btn" onClick={onClose} title="Close">
            <CloseIcon size={18} />
          </button>
        </div>

        <div className="settings-controls-list">
          <div className="setting-control-row">
            <span className="setting-title-text">Sound Effects (SFX)</span>
            <button
              className={`modern-toggle-pill ${soundX ? "active" : ""}`}
              onClick={() => setSoundX(!soundX)}
            >
              {soundX ? "ON" : "OFF"}
            </button>
          </div>

          <div className="setting-control-row">
            <span className="setting-title-text">Background Music</span>
            <button
              className={`modern-toggle-pill ${music ? "active" : ""}`}
              onClick={() => setMusic(!music)}
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
              onChange={(e) => setVolume(e.target.value)}
              className="modern-volume-slider"
            />
          </div>
        </div>

        {/* GitHub Project Section */}
        <div className="settings-github-box">
          <div className="github-info-left">
            <GitHubIcon size={20} className="github-icon-accent" />
            <div className="github-text-col">
              <span className="github-title">Computer Quest on GitHub</span>
              <span className="github-sub">Open source educational quest</span>
            </div>
          </div>
          <a
            href={GITHUB_REPO_URL}
            target="_blank"
            rel="noopener noreferrer"
            className="btn-github-link"
          >
            Star Repo ⭐
          </a>
        </div>

        <div className="user-profile-badge-box">
          <p className="user-logged-info">
            Logged in as: <strong>{user?.username}</strong>
          </p>
          <span className="user-role-chip">{user?.role || "STUDENT"}</span>
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
