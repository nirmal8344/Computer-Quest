import React from "react";
import "./GameLogo.css";

export default function GameLogo({ size = "large", className = "" }) {
  return (
    <div className={`cq-logo-wrapper ${size} ${className}`}>
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
  );
}
