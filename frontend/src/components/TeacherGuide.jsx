import React, { useEffect } from "react";
import teacherImg from "../assets/images/teacher_adriane.jpg";
import { ForwardArrowIcon } from "./GameIcons";
import { speakTeacherInstruction, stopTeacherInstruction } from "../utils/speechUtils";
import "../styles/teacher.css";

export default function TeacherGuide({
  title = "Teacher Adriane",
  speech = "Welcome, explorer! Ready for our next computer science mission?",
  mood = "happy",
  actionText = "Let's Go!",
  onAction,
  compact = false,
  autoPlayVoice = true,
}) {
  useEffect(() => {
    if (autoPlayVoice && speech) {
      speakTeacherInstruction(speech);
    }
    return () => {
      stopTeacherInstruction();
    };
  }, [speech, autoPlayVoice]);

  const handleReplayVoice = () => {
    speakTeacherInstruction(speech);
  };

  return (
    <div className={`teacher-card-container ${compact ? "teacher-compact" : ""}`}>
      <div className="teacher-avatar-frame">
        <div className={`teacher-portrait mood-${mood}`}>
          <img
            src={teacherImg}
            alt={title}
            className="teacher-avatar-real-img"
          />
        </div>
      </div>

      <div className="speech-bubble-wrapper">
        <div className="speech-bubble-tail" />
        <div className="speech-bubble-content">
          <div className="speech-header-row" style={{ display: "flex", alignItems: "center", justifyContent: "space-between", marginBottom: "4px" }}>
            <span className="teacher-title-badge" style={{ fontWeight: 800, fontSize: "0.85rem", color: "#d97706" }}>
              👩‍🏫 {title}
            </span>
            <button
              className="voice-replay-btn"
              onClick={handleReplayVoice}
              title="Replay Teacher Voice"
              type="button"
              style={{
                background: "rgba(245, 158, 11, 0.15)",
                border: "1px solid rgba(245, 158, 11, 0.4)",
                borderRadius: "50%",
                width: "28px",
                height: "28px",
                display: "flex",
                alignItems: "center",
                justifyContent: "center",
                cursor: "pointer",
                color: "#d97706",
                fontSize: "0.9rem",
              }}
            >
              🔊
            </button>
          </div>

          <p className="speech-text">{speech}</p>

          {onAction && (
            <button className="btn btn-emerald speech-action-btn" onClick={onAction}>
              <span>{actionText}</span>
              <ForwardArrowIcon size={18} />
            </button>
          )}
        </div>
      </div>
    </div>
  );
}
