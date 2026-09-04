import { useEffect, useMemo, useState } from "react";
import { useNavigate } from "react-router-dom";
import { leaderboardApi } from "../api/client";
import { useAuth } from "../context/AuthContext";
import Loader from "../components/Loader.jsx";
import {
  TrophyIcon,
  StarIcon,
  SchoolIcon,
  BackArrowIcon,
  GearIcon,
} from "../components/GameIcons.jsx";
import SettingsModal from "../components/SettingsModal.jsx";
import "../styles/leaderboard.css";

export default function LeaderboardPage() {
  const { user } = useAuth();
  const navigate = useNavigate();
  const [rows, setRows] = useState(null);
  const [error, setError] = useState("");
  const [showSettings, setShowSettings] = useState(false);

  useEffect(() => {
    let active = true;
    leaderboardApi
      .getLeaderboard(user?.id ? { userId: user.id } : {})
      .then((data) => active && setRows(data))
      .catch((err) => active && setError(err.message));
    return () => {
      active = false;
    };
  }, [user?.id]);

  const schoolRows = useMemo(() => {
    if (!rows) return null;
    let list = [...rows];
    if (user?.school?.id) {
      const filtered = list.filter((r) => r.user?.school?.id === user.school.id);
      if (filtered.length > 0) list = filtered;
    }
    list.sort((a, b) => (b.xp || 0) - (a.xp || 0));
    return list;
  }, [rows, user]);

  const schoolName = user?.school?.name;

  return (
    <div className="leaderboard-modern-screen">
      {/* Top Header */}
      <header className="leaderboard-top-bar">
        <button className="topbar-circle-btn" onClick={() => navigate("/lobby")} title="Back to Lobby">
          <BackArrowIcon size={18} />
        </button>

        <h2 className="leaderboard-nav-title">Rankings & Leaderboard</h2>

        <button className="topbar-circle-btn" onClick={() => setShowSettings(true)} title="Settings">
          <GearIcon size={18} />
        </button>
      </header>

      <div className="leaderboard-body-container">
        <div className="cq-card leaderboard-main-card">
          <div className="leaderboard-card-header">
            <div className="leaderboard-trophy-badge">
              <TrophyIcon size={42} />
            </div>
            <div>
              <h1 className="leaderboard-title">
                {schoolName ? `${schoolName} Standings` : "Explorer Leaderboard"}
              </h1>
              {schoolName && (
                <p className="school-sub-tag">
                  <SchoolIcon size={16} /> <span>{schoolName} Top Students</span>
                </p>
              )}
            </div>
          </div>

          {error && <div className="error-banner">{error}</div>}
          {!schoolRows && !error && <Loader label="Ranking top explorers..." />}

          {schoolRows && (
            <div className="leaderboard-items-list">
              {schoolRows.length === 0 && (
                <p className="leaderboard-empty-text">No rankings available yet.</p>
              )}

              {schoolRows.map((row, i) => {
                const isMe = row.user?.id === user.id;
                const rankNum = i + 1;
                return (
                  <div
                    key={row.id}
                    className={`leaderboard-player-row ${isMe ? "is-current-user" : ""} rank-${
                      rankNum <= 3 ? rankNum : "other"
                    }`}
                  >
                    <div className="rank-position-disc">
                      <span className="rank-number-text">{rankNum <= 3 ? (rankNum === 1 ? "🥇" : rankNum === 2 ? "🥈" : "🥉") : `#${rankNum}`}</span>
                    </div>

                    <div className="player-meta-group">
                      <span className="player-username-text">{row.user?.username ?? "Explorer"}</span>
                      <span className="player-progress-tag">
                        Ch {row.currentChapter || 1} · M{row.currentMission || 1}
                      </span>
                    </div>

                    <div className="player-xp-capsule">
                      <StarIcon size={16} filled={true} />
                      <span>{(row.xp ?? 0).toLocaleString()} XP</span>
                    </div>
                  </div>
                );
              })}
            </div>
          )}
        </div>
      </div>

      {showSettings && <SettingsModal onClose={() => setShowSettings(false)} />}
    </div>
  );
}
