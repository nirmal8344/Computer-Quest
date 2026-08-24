import { useEffect, useMemo, useState } from "react";
import { useNavigate } from "react-router-dom";
import { leaderboardApi } from "../api/client";
import { useAuth } from "../context/AuthContext";
import Loader from "../components/Loader.jsx";
import { TrophyIcon, StarIcon, SchoolIcon } from "../components/GameIcons.jsx";
import mapBookBg from "../assets/images/map_book_bg.jpg";
import "../styles/leaderboard.css";

export default function LeaderboardPage() {
  const { user } = useAuth();
  const navigate = useNavigate();
  const [rows, setRows] = useState(null);
  const [error, setError] = useState("");

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
    // Rank strictly by highest XP descending
    list.sort((a, b) => (b.xp || 0) - (a.xp || 0));
    return list;
  }, [rows, user]);

  const schoolName = user?.school?.name;

  return (
    <div className="leaderboard-screen" style={{ backgroundImage: `url(${mapBookBg})` }}>
      {/* Floating Back to Lobby Button */}
      <button className="leaderboard-back-btn" onClick={() => navigate("/lobby")}>
        <span>⬅</span> BACK TO LOBBY
      </button>

      <div className="leaderboard-body">
        <div className="panel-parchment leaderboard-card">
          <div className="leaderboard-header">
            <TrophyIcon size={44} />
            <div>
              <h2>{schoolName ? `${schoolName.toUpperCase()} LEADERBOARD` : "EXPLORER LEADERBOARD"}</h2>
              {schoolName && (
                <p className="school-sub-header">
                  <SchoolIcon size={16} /> <span>{schoolName} Standings</span>
                </p>
              )}
            </div>
          </div>

          {error && <div className="error-banner">{error}</div>}
          {!schoolRows && !error && <Loader label="Ranking explorers..." />}

          {schoolRows && (
            <div className="leaderboard-list">
              {schoolRows.length === 0 && <p className="leaderboard-empty">No rankings yet for your school.</p>}
              {schoolRows.map((row, i) => {
                const isMe = row.user?.id === user.id;
                const rankNum = i + 1;
                return (
                  <div
                    key={row.id}
                    className={`leaderboard-row ${isMe ? "me" : ""} rank-${rankNum <= 3 ? rankNum : "other"}`}
                  >
                    <div className="rank-badge-box">
                      <span className="rank-text">#{rankNum}</span>
                    </div>

                    <span className="lb-name">{row.user?.username ?? "Unknown"}</span>

                    <span className="lb-meta">
                      Ch {row.currentChapter} · M{row.currentMission}
                    </span>

                    <div className="lb-xp-pill">
                      <StarIcon size={18} />
                      <span>{(row.xp ?? 0).toLocaleString()} XP</span>
                    </div>
                  </div>
                );
              })}
            </div>
          )}
        </div>
      </div>
    </div>
  );
}
