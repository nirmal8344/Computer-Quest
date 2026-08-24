import React, { useState } from "react";
import { useAuth } from "../context/AuthContext";
import { useNavigate } from "react-router-dom";
import { GearIcon, CloseIcon } from "./GameIcons";
import "../styles/settings.css";

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
      <div className="modal-card panel-parchment" onClick={(e) => e.stopPropagation()}>
        <div className="modal-header">
          <div className="modal-header-title">
            <GearIcon size={28} />
            <h2>GAME SETTINGS</h2>
          </div>
          <button className="close-btn" onClick={onClose} title="Close">
            <CloseIcon size={22} />
          </button>
        </div>

        <div className="settings-section">
          <div className="setting-row">
            <span>Sound Effects (SFX)</span>
            <button
              className={`toggle-btn ${soundX ? "active" : ""}`}
              onClick={() => setSoundX(!soundX)}
            >
              {soundX ? "ON" : "OFF"}
            </button>
          </div>

          <div className="setting-row">
            <span>Background Music</span>
            <button
              className={`toggle-btn ${music ? "active" : ""}`}
              onClick={() => setMusic(!music)}
            >
              {music ? "ON" : "OFF"}
            </button>
          </div>

          <div className="setting-row column">
            <div className="setting-label-row">
              <span>Master Volume</span>
              <span>{volume}%</span>
            </div>
            <input
              type="range"
              min="0"
              max="100"
              value={volume}
              onChange={(e) => setVolume(e.target.value)}
              className="volume-slider"
            />
          </div>
        </div>

        <div className="user-info-box">
          <p>
            Logged in as: <strong>{user?.username}</strong>
          </p>
          <p className="role-tag">Role: {user?.role || "STUDENT"}</p>
        </div>

        <div className="modal-actions">
          <button className="btn btn-red btn-block" onClick={handleLogout}>
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

