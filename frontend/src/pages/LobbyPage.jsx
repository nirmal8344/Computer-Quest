import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../context/AuthContext";
import { gameApi } from "../api/client";
import {
  TrophyIcon,
  GearIcon,
} from "../components/GameIcons.jsx";
import SettingsModal from "../components/SettingsModal.jsx";
import Loader from "../components/Loader.jsx";
import GameLogo from "../components/GameLogo.jsx";
import lobbyBgImg from "../assets/images/lobby_bg.jpg";
import studentAvatarImg from "../assets/images/student_avatar.jpg";
import "../styles/lobby.css";

export default function LobbyPage() {
  const { user, logout } = useAuth();
  const navigate = useNavigate();
  const [game, setGame] = useState(null);
  const [error, setError] = useState("");
  const [showSettings, setShowSettings] = useState(false);

  useEffect(() => {
    let active = true;
    gameApi
      .getGameData(user?.id)
      .then((data) => active && setGame(data))
      .catch((err) => active && setError(err.message));
    return () => {
      active = false;
    };
  }, [user?.id]);

  const boardName = game?.board || user?.board || "CBSE";
  const classLevel = game?.classLevel || user?.classLevel || 11;
  const currentChapter = game?.currentChapter ?? 1;
  const xp = game?.xp ?? 0;

  return (
    <div className="lobby-game-screen" style={{ backgroundImage: `url(${lobbyBgImg})` }}>
      {error && (
        <div className="lobby-error error-banner">
          Couldn't load your game data: {error}
        </div>
      )}

      {!game && !error && <Loader label="Loading game lobby..." />}

      {game && (
        <div className="lobby-stage">
          {/* Top-Left Floating Profile Card matching Reference Image */}
          <div className="lobby-profile-card">
            <div className="avatar-wrapper">
              <img src={studentAvatarImg} alt="Student Avatar" className="student-avatar-img" />
            </div>
            <div className="profile-details">
              <h3 className="profile-username">{game.username || user?.username || "kumar001"}</h3>

              <div className="profile-meta-row">
                <span className="book-icon">📘</span>
                <span>{boardName} • Class {classLevel}th</span>
              </div>

              <div className="profile-xp-section">
                <div className="xp-label-row">
                  <span className="level-text">⭐ Level {currentChapter}</span>
                  <span className="xp-val-text">{Number(xp).toLocaleString()} / 500 XP</span>
                </div>
                <div className="xp-progress-bar">
                  <div className="xp-progress-fill" style={{ width: `${Math.min(100, Math.max(10, xp > 0 ? (xp % 100) || 100 : 10))}%` }} />
                </div>
              </div>
            </div>
          </div>

          {/* Top-Right Quick Action Icons (Bell & Logout) matching Reference Image */}
          <div className="lobby-top-right">
            <button className="top-icon-btn top-bell-btn" title="Notifications">
              <svg width="22" height="22" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2.2" strokeLinecap="round" strokeLinejoin="round">
                <path d="M18 8A6 6 0 0 0 6 8c0 7-3 9-3 9h18s-3-2-3-9" />
                <path d="M13.73 21a2 2 0 0 1-3.46 0" />
              </svg>
            </button>

            <button
              className="top-icon-btn top-logout-btn"
              title="Logout"
              onClick={() => {
                logout();
                navigate("/login");
              }}
            >
              <svg width="22" height="22" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2.2" strokeLinecap="round" strokeLinejoin="round">
                <path d="M9 21H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h4" />
                <polyline points="16 17 21 12 16 7" />
                <line x1="21" y1="12" x2="9" y2="12" />
              </svg>
            </button>
          </div>

          {/* Centered Main Game Section */}
          <div className="lobby-center-content">
            {/* Centered COMPUTER QUEST 3D Title with Graduation Cap */}
            <div className="lobby-logo-wrapper">
              <GameLogo size="large" />
            </div>

            {/* Main Action Button: START ADVENTURE */}
            <button
              className="btn-start-adventure"
              onClick={() => navigate("/map")}
            >
              <span className="play-icon-triangle">▶</span>
              <span className="start-btn-text">START ADVENTURE</span>
            </button>

            {/* 4 Extra Large Action Buttons marked in Red */}
            <div className="lobby-secondary-grid">
              <button
                className="secondary-btn btn-view-map"
                onClick={() => navigate("/map")}
              >
                <div className="sec-btn-icon map-icon-box">
                  <svg viewBox="0 0 24 24" width="52" height="52" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round">
                    <polygon points="1 6 1 22 8 18 16 22 23 18 23 2 16 6 8 2 1 6" fill="rgba(255,255,255,0.2)" />
                    <line x1="8" y1="2" x2="8" y2="18" />
                    <line x1="16" y1="6" x2="16" y2="22" />
                    <circle cx="12" cy="11" r="3" fill="#ef4444" stroke="#ffffff" strokeWidth="1.5" />
                  </svg>
                </div>
                <span className="sec-btn-label">VIEW MAP</span>
              </button>

              <button
                className="secondary-btn btn-leaderboard"
                onClick={() => navigate("/leaderboard")}
              >
                <div className="sec-btn-icon trophy-icon-box">
                  <TrophyIcon size={52} />
                </div>
                <span className="sec-btn-label">LEADERBOARD</span>
              </button>

              <button
                className="secondary-btn btn-settings"
                onClick={() => setShowSettings(true)}
              >
                <div className="sec-btn-icon gear-icon-box">
                  <GearIcon size={52} />
                </div>
                <span className="sec-btn-label">SETTINGS</span>
              </button>
            </div>
          </div>
        </div>
      )}

      {showSettings && <SettingsModal onClose={() => setShowSettings(false)} />}
    </div>
  );
}
