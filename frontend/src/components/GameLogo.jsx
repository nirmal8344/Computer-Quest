import React from "react";
import "./GameLogo.css";

export default function GameLogo({ size = "large", className = "" }) {
  return (
    <div className={`cq-logo-wrapper ${size} ${className}`}>
      {/* 3 Golden Stars on top */}
      <div className="cq-stars-row">
        <span className="star side">⭐</span>
        <span className="star center">⭐</span>
        <span className="star side">⭐</span>
      </div>

      {/* Main Logo Container with 3D Graduation Cap on Left */}
      <div className="cq-logo-main-row">
        <div className="cq-grad-cap-box">
          <span className="cq-grad-cap-icon">🎓</span>
        </div>

        <div className="cq-text-stack">
          <div className="cq-text-line-1">COMPUTER</div>
          <div className="cq-text-line-2">QUEST</div>
        </div>
      </div>

      {/* White Pill Badge: EDUCATIONAL ADVENTURE */}
      <div className="cq-ribbon-sub">
        <span>EDUCATIONAL ADVENTURE</span>
      </div>
    </div>
  );
}
