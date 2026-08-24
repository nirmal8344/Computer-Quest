import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { useAuth } from "../context/AuthContext";
import SettingsModal from "./SettingsModal";
import {
  HeartIcon,
  StarIcon,
  MagicPowerIcon,
  CoinIcon,
  GearIcon,
  BackArrowIcon,
  CheckIcon,
} from "./GameIcons";
import GameLogo from "./GameLogo.jsx";
import "../styles/topbar.css";

export default function TopBar({ xp, lives, showNav = true }) {
  const { user } = useAuth();
  const navigate = useNavigate();
  const [showSettings, setShowSettings] = useState(false);

  const renderHearts = (count) => {
    const total = 3;
    const current = typeof count === "number" ? count : 3;
    const hearts = [];
    for (let i = 0; i < total; i++) {
      hearts.push(
        <HeartIcon key={i} filled={i < current} size={20} className="heart-svg-badge" />
      );
    }
    return hearts;
  };

  return (
    <>
      <header className="game-topbar">
        <div className="topbar-left-actions">
          {showNav && (
            <>
              <button className="topbar-action-btn" onClick={() => navigate(-1)} title="Go Back">
                <BackArrowIcon size={20} />
              </button>
              <button className="topbar-action-btn" onClick={() => navigate("/map")} title="Check Map">
                <CheckIcon size={20} />
              </button>
            </>
          )}

          <Link to="/lobby" className="game-logo-brand">
            <GameLogo size="small" />
          </Link>
        </div>

        <div className="game-stats-cluster">
          {/* Green 3D Magic Power Badge matching reference header */}
          <div className="stat-badge magic-power-badge">
            <MagicPowerIcon size={20} />
            <span className="badge-value">{xp ?? 334} MAGIC POWER</span>
          </div>

          {typeof lives === "number" && (
            <div className="stat-badge lives-badge">
              <div className="hearts-flex">{renderHearts(lives)}</div>
            </div>
          )}

          <div className="stat-badge coin-badge">
            <CoinIcon size={20} />
            <span className="badge-value">1</span>
          </div>
        </div>

        <div className="game-topbar-right">
          <button
            className="player-btn"
            onClick={() => navigate("/profile")}
            title="View Profile"
          >
            <span className="player-avatar-circle">{user?.username?.[0]?.toUpperCase() ?? "P"}</span>
            <span className="player-name-text">{user?.username}</span>
          </button>

          <button
            className="settings-gear-btn"
            onClick={() => setShowSettings(true)}
            title="Settings"
          >
            <GearIcon size={22} />
          </button>
        </div>
      </header>

      {showSettings && <SettingsModal onClose={() => setShowSettings(false)} />}
    </>
  );
}

