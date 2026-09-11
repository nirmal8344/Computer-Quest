import React from "react";
import { CloseIcon, StarIcon, TrophyIcon } from "./GameIcons";
import "../styles/achievementsModal.css";

export default function AchievementsModal({ game, onClose }) {
  const totalXp = Number(game?.xp || game?.totalXp || 0);
  const streak = Number(game?.streakDays || 1);
  const completedSubjects =
    game?.subjects?.filter((s) => (s.xp || 0) >= 100).length || 0;

  const achievements = [
    {
      id: "first_quest",
      title: "First Adventure",
      desc: "Complete your first learning quest question",
      icon: "🎯",
      unlocked: totalXp >= 10,
      progress: Math.min(10, totalXp) + " / 10 XP",
    },
    {
      id: "star_collector",
      title: "Star Explorer",
      desc: "Accumulate 100 total learning XP across subjects",
      icon: "⭐",
      unlocked: totalXp >= 100,
      progress: Math.min(100, totalXp) + " / 100 XP",
    },
    {
      id: "streak_keeper",
      title: "Streak Keeper",
      desc: "Maintain a daily learning streak",
      icon: "🔥",
      unlocked: streak >= 2,
      progress: streak + " / 2 Days",
    },
    {
      id: "multi_scholar",
      title: "Multi-Subject Scholar",
      desc: "Earn XP across multiple subjects",
      icon: "📚",
      unlocked: completedSubjects >= 2,
      progress: completedSubjects + " / 2 Subjects",
    },
    {
      id: "quest_master",
      title: "Quest Champion",
      desc: "Reach 500 total XP and achieve Level 2",
      icon: "🏆",
      unlocked: totalXp >= 500,
      progress: Math.min(500, totalXp) + " / 500 XP",
    },
  ];

  return (
    <div className="modal-backdrop" onClick={onClose}>
      <div
        className="modal-card achievements-modal-box"
        onClick={(e) => e.stopPropagation()}
      >
        <div className="achievements-modal-header">
          <div className="modal-header-title">
            <span className="header-trophy-icon">🏆</span>
            <div>
              <h2>Explorer Achievements</h2>
              <p className="achievements-modal-sub">
                Track your milestone badges and learning accomplishments!
              </p>
            </div>
          </div>
          <button className="topbar-circle-btn" onClick={onClose} title="Close">
            <CloseIcon size={18} />
          </button>
        </div>

        <div className="achievements-list">
          {achievements.map((item) => (
            <div
              key={item.id}
              className={`achievement-card ${item.unlocked ? "is-unlocked" : "is-locked"}`}
            >
              <div className="achievement-icon-disc">
                <span>{item.icon}</span>
              </div>

              <div className="achievement-details">
                <span className="achievement-title-text">{item.title}</span>
                <span className="achievement-desc-text">{item.desc}</span>
              </div>

              <div className="achievement-status-badge">
                {item.unlocked ? (
                  <span className="badge-unlocked">Unlocked ✨</span>
                ) : (
                  <span className="badge-progress">{item.progress}</span>
                )}
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}
