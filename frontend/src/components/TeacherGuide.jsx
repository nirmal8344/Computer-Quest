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
        <div className="speech-header-row">
          <span className="teacher-title-badge">
            👩‍🏫 {title}
          </span>
          <button
            className="voice-replay-btn"
            onClick={handleReplayVoice}
            title="Replay Voice Guidance"
            type="button"
          >
            🔊
          </button>
        </div>

        <p className="speech-text">{speech}</p>

        {onAction && (
          <button className="btn btn-peach speech-action-btn" onClick={onAction}>
            <span>{actionText}</span>
            <ForwardArrowIcon size={16} />
          </button>
        )}
      </div>
    </div>
  );
}
