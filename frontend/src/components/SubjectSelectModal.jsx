import React from "react";
import { CloseIcon, StarIcon, ForwardArrowIcon } from "./GameIcons";
import "../styles/subjectModal.css";

export default function SubjectSelectModal({
  subjects = [],
  activeSubject = "",
  onSelectSubject,
  onClose,
}) {
  return (
    <div className="modal-backdrop" onClick={onClose}>
      <div
        className="modal-card subject-select-modal-box"
        onClick={(e) => e.stopPropagation()}
      >
        <div className="subject-modal-header">
          <div className="modal-header-title">
            <span className="header-subject-icon">📚</span>
            <div>
              <h2>Choose Your Subject</h2>
              <p className="subject-modal-sub">
                Select a curriculum subject to continue your learning adventure!
              </p>
            </div>
          </div>
          <button className="topbar-circle-btn" onClick={onClose} title="Close">
            <CloseIcon size={18} />
          </button>
        </div>

        <div className="subjects-grid-list">
          {subjects.map((sub) => {
            const isSelected =
              activeSubject &&
              sub.subjectName.toLowerCase() === activeSubject.toLowerCase();

            return (
              <div
                key={sub.subjectCode || sub.subjectName}
                className={`subject-choice-card ${isSelected ? "is-selected" : ""}`}
                style={{ "--subject-accent": sub.color || "#4834d4" }}
                onClick={() => {
                  onSelectSubject(sub);
                  onClose();
                }}
              >
                <div className="subject-icon-disc">
                  <span>{sub.icon || "📖"}</span>
                </div>

                <div className="subject-info-col">
                  <span className="subject-card-name">{sub.subjectName}</span>
                  <div className="subject-progress-stats">
                    <span className="subject-chapter-tag">
                      Chapter {sub.currentChapter || 1}
                    </span>
                    <span className="subject-xp-badge">
                      <StarIcon size={13} filled={true} />
                      {(sub.xp || 0).toLocaleString()} XP
                    </span>
                  </div>
                </div>

                <div className="subject-arrow-action">
                  <ForwardArrowIcon size={16} />
                </div>
              </div>
            );
          })}
        </div>
      </div>
    </div>
  );
}
