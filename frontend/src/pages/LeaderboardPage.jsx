import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { leaderboardApi, subjectApi } from "../api/client";
import { useAuth } from "../context/AuthContext";
import Loader from "../components/Loader.jsx";
import {
  TrophyIcon,
  StarIcon,
  SchoolIcon,
  BackArrowIcon,
  GearIcon,
  FlameIcon,
} from "../components/GameIcons.jsx";
import SettingsModal from "../components/SettingsModal.jsx";
import "../styles/leaderboard.css";

export default function LeaderboardPage() {
  const { user } = useAuth();
  const navigate = useNavigate();
  const [activeTab, setActiveTab] = useState("OVERALL");
  const [subjects, setSubjects] = useState([]);
  const [data, setData] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");
  const [showSettings, setShowSettings] = useState(false);

  // Load subjects for student
  useEffect(() => {
    if (!user?.id) return;
    subjectApi
      .getForStudent(user.id)
      .then((subs) => {
        if (Array.isArray(subs)) setSubjects(subs);
      })
      .catch((err) => console.error("Failed to load subjects for leaderboard:", err));
  }, [user?.id]);

  // Load leaderboard rankings whenever activeTab changes
  useEffect(() => {
    let active = true;
    setLoading(true);
    setError("");

    const subjectParam = activeTab === "OVERALL" ? null : activeTab;
    leaderboardApi
      .getRankings({
        userId: user?.id,
        subject: subjectParam,
        board: user?.board,
        classLevel: user?.classLevel,
        studentGroup: user?.studentGroup,
      })
      .then((res) => {
        if (active) {
          setData(res);
          setLoading(false);
        }
      })
      .catch((err) => {
        if (active) {
          setError(err.message);
          setLoading(false);
        }
      });

    return () => {
      active = false;
    };
  }, [user?.id, user?.board, user?.classLevel, user?.studentGroup, activeTab]);

  const schoolName = user?.school?.name || user?.schoolName || "RPSIT School";
  const rankings = data?.entries || data?.rankings || [];
  const currentRank = data?.currentUserRank ?? (rankings.findIndex((r) => r.userId === user?.id) + 1 || 1);
  const currentXp = data?.currentUserXp ?? user?.xp ?? 0;
  const xpToNext = data?.xpToNextRank;
  const nextRank = data?.nextRank;

  const formatGroupName = (grp) => {
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
        {/* Subject Navigation Tabs */}
        <div className="leaderboard-tabs-bar">
          <button
            className={`leaderboard-tab-pill ${activeTab === "OVERALL" ? "active" : ""}`}
            onClick={() => setActiveTab("OVERALL")}
          >
            🏆 Overall XP
          </button>
          {subjects.map((sub) => (
            <button
              key={sub.id}
              className={`leaderboard-tab-pill ${activeTab === sub.subjectName ? "active" : ""}`}
              onClick={() => setActiveTab(sub.subjectName)}
            >
              <span>{sub.icon || "📚"}</span>
              <span>{sub.subjectName}</span>
            </button>
          ))}
        </div>

        {/* Student's Rank Motivation Banner */}
        {user?.id && currentRank != null && (
          <div className="cq-card current-user-rank-card">
            <div className="user-rank-left">
              <div className="user-rank-badge">
                <span className="user-rank-hash">#</span>
                <span className="user-rank-number">{currentRank}</span>
              </div>
              <div className="user-rank-info">
                <span className="user-rank-title">Your Current Standing</span>
                <span className="user-rank-scope">
                  {activeTab === "OVERALL" ? "Overall Ranking" : `${activeTab} Ranking`} · {user.username}
                </span>
              </div>
            </div>

            <div className="user-rank-right">
              <div className="user-rank-xp-val">
                <StarIcon size={18} filled={true} />
                <span>{currentXp.toLocaleString()} XP</span>
              </div>
              {xpToNext != null && nextRank != null ? (
                <div className="user-rank-next-tip">
                  <FlameIcon size={14} />
                  <span>+{xpToNext} XP to reach Rank #{nextRank}!</span>
                </div>
              ) : currentRank === 1 ? (
                <div className="user-rank-next-tip is-champ">
                  <span>👑 Top of the Leaderboard!</span>
                </div>
              ) : null}
            </div>
          </div>
        )}

        {/* Main Leaderboard Table Card */}
        <div className="cq-card leaderboard-main-card">
          <div className="leaderboard-card-header">
            <div className="leaderboard-trophy-badge">
              <TrophyIcon size={40} />
            </div>
            <div>
              <h1 className="leaderboard-title">
                {activeTab === "OVERALL" ? "Global Explorers Standings" : `${activeTab} Top Champions`}
              </h1>
              <p className="school-sub-tag">
                <SchoolIcon size={16} /> <span>{schoolName}</span> ·{" "}
                <span>
                  {user?.board === "STATE_BOARD" ? "TN State Board" : "CBSE"} Class {user?.classLevel || "4"}
                  {Number(user?.classLevel) >= 11 && (user?.studentGroup || data?.studentGroup)
                    ? ` · ${formatGroupName(user?.studentGroup || data?.studentGroup)}`
                    : ""}
                </span>
              </p>
            </div>
          </div>

          {error && <div className="error-banner">{error}</div>}
          {loading && <Loader label="Fetching standings..." />}

          {!loading && (
            <div className="leaderboard-items-list">
              {rankings.length === 0 && (
                <p className="leaderboard-empty-text">No rankings available yet for this subject.</p>
              )}

              {rankings.map((row, i) => {
                const isMe = row.userId === user?.id;
                const rankNum = row.rank || i + 1;
                return (
                  <div
                    key={row.id || `${row.userId}-${i}`}
                    className={`leaderboard-player-row ${isMe ? "is-current-user" : ""} rank-${
                      rankNum <= 3 ? rankNum : "other"
                    }`}
                  >
                    <div className="rank-position-disc">
                      <span className="rank-number-text">
                        {rankNum === 1 ? "🥇" : rankNum === 2 ? "🥈" : rankNum === 3 ? "🥉" : `#${rankNum}`}
                      </span>
                    </div>

                    <div className="player-meta-group">
                      <div className="player-name-row">
                        <span className="player-username-text">{row.username || "Explorer"}</span>
                        {isMe && <span className="you-chip">YOU</span>}
                      </div>
                      <span className="player-progress-tag">
                        {row.board && row.classLevel ? `Class ${row.classLevel} · ` : ""}
                        {row.studentGroup ? `${formatGroupName(row.studentGroup)} · ` : ""}
                        {row.schoolName || "RPSIT School"}
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
