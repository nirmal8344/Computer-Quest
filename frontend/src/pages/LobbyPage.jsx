import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../context/AuthContext";
import { gameApi } from "../api/client";
import SettingsModal from "../components/SettingsModal.jsx";
import studentAvatarImg from "../assets/images/student_avatar.jpg";
import "../styles/lobby.css";

export default function LobbyPage() {
  const { user, logout } = useAuth();
  const navigate = useNavigate();
  const [game, setGame] = useState(null);
  const [error, setError] = useState("");
  const [showSettings, setShowSettings] = useState(false);

  // Fetch real-time game progress from backend
  useEffect(() => {
    let active = true;
    if (user?.id) {
      gameApi
        .getGameData(user.id)
        .then((data) => {
          if (active) setGame(data);
        })
        .catch((err) => {
          if (active) setError(err.message);
        });
    }
    return () => {
      active = false;
    };
  }, [user?.id]);

  const username = game?.username || user?.username || "Explorer";
  const boardName = game?.board || user?.board || "STATE_BOARD";
  const classLevel = game?.classLevel || user?.classLevel || 11;

  // Dynamic XP & Level calculations connected directly to backend data
  const totalXp = Number(game?.xp ?? user?.xp ?? 0);
  const currentChapter = game?.currentChapter ?? 1;
  const currentMission = game?.currentMission ?? 1;
  const level = Math.max(1, currentChapter);
  const currentLevelXp = totalXp % 500;
  const targetXp = 500;
  const xpProgressPercent = Math.min(100, Math.max(0, (currentLevelXp / targetXp) * 100));

  // START ADVENTURE: Directly opens Game Units / available learning units screen
  const handleStartAdventure = () => {
    navigate("/map");
  };

  return (
    <div className="lobby-game-viewport">
      {/* ========================================================
          TOP BAR (Profile Card on Left + Logout on Right)
          ======================================================== */}
      <header className="lobby-top-bar">
        {/* Profile Card with Real Dynamic Backend Data */}
        <div className="lobby-profile-card">
          <div className="avatar-circle">
            <img src={studentAvatarImg} alt={username} className="avatar-img" />
          </div>
          <div className="profile-details-col">
            <span className="profile-username">{username}</span>
            <span className="profile-meta-sub">
              {boardName} • Class {classLevel}th
            </span>
            <div className="profile-xp-row">
              <span className="xp-star-icon">⭐</span>
              <span className="xp-level-label">Level {level}</span>
              <div className="xp-progress-track">
                <div
                  className="xp-progress-fill"
                  style={{ width: `${xpProgressPercent}%` }}
                />
              </div>
              <span className="xp-counter-text">
                {currentLevelXp} / {targetXp} XP
              </span>
            </div>
          </div>
        </div>

        {/* Top-Right Logout Button (No Notification Icon) */}
        <div className="lobby-header-actions">
          <button
            className="btn-lobby-logout"
            title="Sign Out"
            onClick={() => {
              logout();
              navigate("/login");
            }}
          >
            <svg
              width="22"
              height="22"
              viewBox="0 0 24 24"
              fill="none"
              stroke="currentColor"
              strokeWidth="2.4"
              strokeLinecap="round"
              strokeLinejoin="round"
            >
              <path d="M9 21H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h4" />
              <polyline points="16 17 21 12 16 7" />
              <line x1="21" y1="12" x2="9" y2="12" />
            </svg>
          </button>
        </div>
      </header>

      {/* ========================================================
          CENTER HERO: 3D Logo + Main Play Button
          ======================================================== */}
      <main className="lobby-hero-center">
        {/* 3D Computer Quest Brand Logo */}
        <div className="brand-logo-pod">
          <div className="cap-stars-group">
            {/* 3D Graduation Cap */}
            <div className="grad-cap-box">
              <svg width="68" height="52" viewBox="0 0 68 52" fill="none">
                <polygon
                  points="34 4 66 18 34 32 2 18"
                  fill="#2c3e50"
                  stroke="#1a252f"
                  strokeWidth="2"
                />
                <polygon points="34 8 60 18 34 28 8 18" fill="#34495e" />
                <path
                  d="M16 25v12c0 8 8 12 18 12s18-4 18-12V25"
                  fill="#2c3e50"
                  stroke="#1a252f"
                  strokeWidth="2"
                />
                <path
                  d="M18 26v10c0 6 7 10 16 10s16-4 16-10V26"
                  fill="#34495e"
                />
                <path
                  d="M22 36c4 3 8 4 12 4s8-1 12-4"
                  stroke="#f1c40f"
                  strokeWidth="2.5"
                  fill="none"
                />
                <circle cx="34" cy="18" r="3" fill="#f1c40f" />
                <path
                  d="M34 18 C30 24 22 28 14 34"
                  stroke="#f1c40f"
                  strokeWidth="2.5"
                  fill="none"
                />
                <rect x="11" y="33" width="6" height="10" rx="2" fill="#f39c12" />
              </svg>
            </div>
            {/* 3 Glowing Golden Stars */}
            <div className="golden-stars-trio">
              <span className="star-trio star-left">⭐</span>
              <span className="star-trio star-center">⭐</span>
              <span className="star-trio star-right">⭐</span>
            </div>
          </div>

          {/* 3D Bubble Text Stack */}
          <div className="bubble-title-stack">
            <h1 className="bubble-text-computer">COMPUTER</h1>
            <h2 className="bubble-text-quest">QUEST</h2>
          </div>

          {/* Learning Adventure Capsule Pill */}
          <div className="learning-adventure-pill">
            <span className="pill-dot-orange" />
            <span className="pill-text-label">LEARNING ADVENTURE</span>
          </div>
        </div>

        {/* Big Emerald Green START ADVENTURE Button (Directly opens Game/Play screen) */}
        <button
          className="btn-start-adventure-hero"
          onClick={handleStartAdventure}
        >
          <svg
            className="play-triangle-svg"
            width="24"
            height="24"
            viewBox="0 0 24 24"
            fill="#ffffff"
          >
            <polygon points="5 3 19 12 5 21 5 3" />
          </svg>
          <span>START ADVENTURE</span>
          <span className="hero-btn-notch" />
        </button>
      </main>

      {/* ========================================================
          BOTTOM ROW (3 Action Cards: View Map, Leaderboard, Settings)
          ======================================================== */}
      <footer className="lobby-cards-row">
        {/* 1. VIEW MAP (Sky Blue) */}
        <button
          className="bottom-action-tile tile-blue"
          onClick={() => navigate("/map")}
        >
          <div className="tile-icon-box">
            <svg width="34" height="34" viewBox="0 0 48 48" fill="none">
              <path
                d="M6 10L18 6L30 10L42 6V38L30 42L18 38L6 42V10Z"
                fill="#ffffff"
                stroke="#ffffff"
                strokeWidth="2"
                strokeLinejoin="round"
              />
              <path
                d="M18 6V38"
                stroke="#74b9ff"
                strokeWidth="2.5"
                strokeDasharray="3 3"
              />
              <path
                d="M30 10V42"
                stroke="#74b9ff"
                strokeWidth="2.5"
                strokeDasharray="3 3"
              />
              <path
                d="M8 20H16M20 28H28M32 18H40"
                stroke="#a0e7ff"
                strokeWidth="2"
                strokeLinecap="round"
              />
              <circle
                cx="24"
                cy="20"
                r="6"
                fill="#eb4d4b"
                stroke="#ffffff"
                strokeWidth="2"
              />
              <circle cx="24" cy="20" r="2.5" fill="#ffffff" />
            </svg>
          </div>
          <span className="tile-title-text">VIEW MAP</span>
        </button>

        {/* 2. LEADERBOARD (Royal Purple) */}
        <button
          className="bottom-action-tile tile-purple"
          onClick={() => navigate("/leaderboard")}
        >
          <div className="tile-icon-box">
            <svg width="36" height="36" viewBox="0 0 48 48" fill="none">
              <circle cx="24" cy="24" r="16" fill="rgba(255,255,255,0.18)" />
              <path
                d="M16 12H32V24C32 28.4 28.4 32 24 32C19.6 32 16 28.4 16 24V12Z"
                fill="#fed330"
                stroke="#f7b731"
                strokeWidth="1.5"
              />
              <path
                d="M16 15H11C9.3 15 8 16.3 8 18V19C8 22.3 10.7 25 14 25H16"
                stroke="#fed330"
                strokeWidth="3"
                strokeLinecap="round"
              />
              <path
                d="M32 15H37C38.7 15 40 16.3 40 18V19C40 22.3 37.3 25 34 25H32"
                stroke="#fed330"
                strokeWidth="3"
                strokeLinecap="round"
              />
              <path
                d="M24 32V38M18 38H30"
                stroke="#fed330"
                strokeWidth="4"
                strokeLinecap="round"
              />
              <path
                d="M20 16H28"
                stroke="#ffffff"
                strokeWidth="2"
                strokeLinecap="round"
                opacity="0.8"
              />
            </svg>
          </div>
          <span className="tile-title-text">LEADERBOARD</span>
        </button>

        {/* 3. SETTINGS (Warm Amber/Orange) */}
        <button
          className="bottom-action-tile tile-orange"
          onClick={() => setShowSettings(true)}
        >
          <div className="tile-icon-box">
            <svg width="34" height="34" viewBox="0 0 48 48" fill="none">
              <circle
                cx="24"
                cy="24"
                r="7"
                fill="#ffa801"
                stroke="#ffffff"
                strokeWidth="2.5"
              />
              <path
                d="M24 6V11M24 37V42M6 24H11M37 24H42M11.3 11.3L14.8 14.8M33.2 33.2L36.7 36.7M11.3 36.7L14.8 33.2M33.2 14.8L36.7 11.3"
                stroke="#fed330"
                strokeWidth="4.5"
                strokeLinecap="round"
              />
              <circle cx="24" cy="24" r="13" stroke="#fed330" strokeWidth="4" />
              <circle cx="24" cy="24" r="5" fill="#f7b731" />
            </svg>
          </div>
          <span className="tile-title-text">SETTINGS</span>
        </button>
      </footer>

      {/* Settings Modal */}
      {showSettings && <SettingsModal onClose={() => setShowSettings(false)} />}
    </div>
  );
}
