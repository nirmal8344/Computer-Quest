import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../context/AuthContext";
import { gameApi } from "../api/client";
import SettingsModal from "../components/SettingsModal.jsx";
import SubjectSelectModal from "../components/SubjectSelectModal.jsx";
import studentAvatarImg from "../assets/images/student_avatar.jpg";
import mascotGirlImg from "../assets/images/lobby_girl_mascot.jpg";
import "../styles/lobby.css";

export default function LobbyPage() {
  const { user, logout } = useAuth();
  const navigate = useNavigate();
  const [game, setGame] = useState(null);
  const [error, setError] = useState("");
  const [showSettings, setShowSettings] = useState(false);
  const [showSubjectModal, setShowSubjectModal] = useState(false);
  const [selectedSubject, setSelectedSubject] = useState(null);

  // Fetch real-time game progress from backend
  useEffect(() => {
    let active = true;
    if (user?.id) {
      gameApi
        .getGameData(user.id)
        .then((data) => {
          if (active) {
            setGame(data);
          }
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
  const classLevel = game?.classLevel || user?.classLevel || 4;
  const studentGroup = game?.studentGroup || user?.studentGroup || "";
  const schoolName = game?.school?.name || user?.schoolName || "RPSIT School";
  const totalXp = Number(game?.totalXp ?? game?.xp ?? user?.xp ?? 0);

  const formatGroupDisplay = (grp) => {
    if (!grp) return "";
    if (grp.includes("GROUP 1") || grp.includes("BIO")) return "Bio-Maths";
    if (grp.includes("GROUP 2") || grp.includes("COMPUTER")) return "Maths + CS";
    if (grp.includes("GROUP 3") || grp.includes("PURE")) return "Pure Science";
    if (grp.includes("GROUP 7") || grp.includes("HISTORY")) return "Acc + History";
    if (grp.includes("GROUP 5") || grp.includes("APPLICATION")) return "Commerce + CA";
    if (grp.includes("GROUP 6") || grp.includes("BUSINESS")) return "Commerce + BM";
    if (grp.includes("GROUP 4") || grp.includes("COMMERCE")) return "Commerce";
    return grp;
  };

  // START ADVENTURE: Opens subject selector for intentional subject choice
  const handleStartAdventure = () => {
    setShowSubjectModal(true);
  };

  const handleSelectSubject = (sub) => {
    setSelectedSubject(sub);
    setShowSubjectModal(false);
    navigate(`/map?subject=${encodeURIComponent(sub.subjectName)}`);
  };

  return (
    <div className="lobby-game-viewport">
      {/* Background Soft Glow Bubbles */}
      <div className="lobby-ambient-bubble bubble-1" />
      <div className="lobby-ambient-bubble bubble-2" />
      <div className="lobby-ambient-bubble bubble-3" />

      {/* ========================================================
          TOP BAR: Student Profile Card + Logout
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
              {schoolName} • {boardName === "STATE_BOARD" ? "State Board" : "CBSE"} • Class {classLevel}th{Number(classLevel) >= 11 && studentGroup ? ` • ${formatGroupDisplay(studentGroup)}` : ""}
            </span>
            <div className="profile-xp-row">
              <span className="xp-star-icon">⭐</span>
              <span className="xp-counter-text">
                {totalXp.toLocaleString()} Total XP
              </span>
            </div>
          </div>
        </div>

        {/* Top-Right Header Actions: Logout only */}
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
              width="20"
              height="20"
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
          CENTER HERO: Mascot Character + Clean Logo + Start Button
          ======================================================== */}
      <main className="lobby-hero-center">
        {/* Mascot Character Illustration */}
        <div className="lobby-mascot-pod">
          <img
            src={mascotGirlImg}
            alt="Learning Mascot"
            className="lobby-mascot-img"
          />
        </div>

        {/* Clean, Decent LearnQuest Title */}
        <div className="brand-logo-pod">
          <div className="clean-brand-header">
            <div className="clean-cap-badge">
              <span>🎓</span>
            </div>
            <h1 className="clean-game-title">
              <span className="title-learn">Learn</span>
              <span className="title-quest">Quest</span>
            </h1>
            <div className="clean-subtitle-pill">
              <span className="subtitle-dot" />
              <span className="subtitle-text">LEARNING ADVENTURE</span>
            </div>
          </div>
        </div>

        {/* Big Emerald Green START ADVENTURE Button */}
        <button
          className="btn-start-adventure-hero"
          onClick={handleStartAdventure}
        >
          <svg
            className="play-triangle-svg"
            width="22"
            height="22"
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
          BOTTOM ROW (3 Action Cards: Choose Subject, Leaderboard, Settings)
          ======================================================== */}
      <footer className="lobby-cards-row three-cards">
        {/* 1. CHOOSE SUBJECT (Sky Blue) */}
        <button
          className="bottom-action-tile tile-blue"
          onClick={() => setShowSubjectModal(true)}
        >
          <div className="tile-icon-box">
            <svg width="28" height="28" viewBox="0 0 48 48" fill="none">
              <path
                d="M8 8H20C22.2 8 24 9.8 24 12V38C24 36.3 22.2 35 20 35H8V8Z"
                fill="#ffffff"
              />
              <path
                d="M40 8H28C25.8 8 24 9.8 24 12V38C24 36.3 25.8 35 28 35H40V8Z"
                fill="#ffffff"
                opacity="0.9"
              />
              <path
                d="M24 12V38"
                stroke="#0984e3"
                strokeWidth="3"
                strokeLinecap="round"
              />
              <line x1="12" y1="16" x2="18" y2="16" stroke="#74b9ff" strokeWidth="2.5" strokeLinecap="round" />
              <line x1="12" y1="22" x2="18" y2="22" stroke="#74b9ff" strokeWidth="2.5" strokeLinecap="round" />
              <line x1="30" y1="16" x2="36" y2="16" stroke="#74b9ff" strokeWidth="2.5" strokeLinecap="round" />
              <line x1="30" y1="22" x2="36" y2="22" stroke="#74b9ff" strokeWidth="2.5" strokeLinecap="round" />
            </svg>
          </div>
          <span className="tile-title-text">CHOOSE SUBJECT</span>
        </button>

        {/* 2. LEADERBOARD (Royal Purple) */}
        <button
          className="bottom-action-tile tile-purple"
          onClick={() => navigate("/leaderboard")}
        >
          <div className="tile-icon-box">
            <svg width="28" height="28" viewBox="0 0 48 48" fill="none">
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
            <svg width="28" height="28" viewBox="0 0 48 48" fill="none">
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
            </svg>
          </div>
          <span className="tile-title-text">SETTINGS</span>
        </button>
      </footer>

      {/* Subject Selection Modal */}
      {showSubjectModal && (
        <SubjectSelectModal
          subjects={game?.subjects || []}
          activeSubject={selectedSubject?.subjectName || ""}
          onSelectSubject={handleSelectSubject}
          onClose={() => setShowSubjectModal(false)}
        />
      )}

      {/* Settings Modal */}
      {showSettings && <SettingsModal onClose={() => setShowSettings(false)} />}
    </div>
  );
}
