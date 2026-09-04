import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { profileApi } from "../api/client";
import { useAuth } from "../context/AuthContext";
import TopBar from "../components/TopBar.jsx";
import Loader from "../components/Loader.jsx";
import {
  StarIcon,
  HeartIcon,
  MapIcon,
  TrophyIcon,
  CheckIcon,
  SchoolIcon,
} from "../components/GameIcons.jsx";
import SettingsModal from "../components/SettingsModal.jsx";
import "../styles/profile.css";

export default function ProfilePage() {
  const { user } = useAuth();
  const navigate = useNavigate();
  const [profile, setProfile] = useState(null);
  const [error, setError] = useState("");
  const [showSettings, setShowSettings] = useState(false);

  useEffect(() => {
    let active = true;
    profileApi
      .getProfile(user.id)
      .then((data) => active && setProfile(data))
      .catch((err) => active && setError(err.message));
    return () => {
      active = false;
    };
  }, [user.id]);

  return (
    <div className="profile-modern-screen">
      <TopBar xp={profile?.xp} lives={profile?.lives} />

      <div className="profile-body-wrapper">
        {error && <div className="error-banner">{error}</div>}
        {!profile && !error && <Loader label="Loading explorer profile..." />}

        {profile && (
          <div className="cq-card profile-info-card">
            {/* Avatar Header */}
            <div className="profile-avatar-disc">
              {profile.username?.[0]?.toUpperCase() ?? "P"}
            </div>

            <h1 className="profile-display-name">{profile.username}</h1>

            <div className="profile-academic-sub">
              {profile.school?.name && (
                <span className="profile-school-tag">
                  <SchoolIcon size={16} />
                  <span>{profile.school.name}</span>
                  <span className="dot-divider">·</span>
                </span>
              )}
              <span>{profile.board} Board</span>
              <span className="dot-divider">·</span>
              <span>Class {profile.classLevel}th</span>
            </div>

            {/* Statistic Cards Grid */}
            <div className="profile-stats-grid">
              <div className="profile-stat-tile bg-gold">
                <StarIcon size={26} filled={true} />
                <span className="stat-tile-value">{(profile.xp ?? 0).toLocaleString()}</span>
                <span className="stat-tile-label">Total XP</span>
              </div>

              <div className="profile-stat-tile bg-coral">
                <HeartIcon size={26} />
                <span className="stat-tile-value">{profile.lives ?? 3} / 3</span>
                <span className="stat-tile-label">Lives</span>
              </div>

              <div className="profile-stat-tile bg-purple">
                <MapIcon size={26} />
                <span className="stat-tile-value">Level {profile.chapter ?? 1}</span>
                <span className="stat-tile-label">Current Chapter</span>
              </div>

              <div className="profile-stat-tile bg-blue">
                <TrophyIcon size={26} />
                <span className="stat-tile-value">Mission {profile.mission ?? 1}</span>
                <span className="stat-tile-label">Current Mission</span>
              </div>

              <div className="profile-stat-tile bg-green">
                <CheckIcon size={26} />
                <span className="stat-tile-value">{profile.answeredQuestions ?? 0}</span>
                <span className="stat-tile-label">Solved Questions</span>
              </div>
            </div>

            {/* Quick Actions */}
            <div className="profile-action-buttons">
              <button className="btn btn-peach btn-block" onClick={() => navigate("/map")}>
                <span>Continue Quest Adventure</span>
              </button>
              <button className="btn btn-ghost btn-block" onClick={() => setShowSettings(true)}>
                <span>Account Settings</span>
              </button>
            </div>
          </div>
        )}
      </div>

      {showSettings && <SettingsModal onClose={() => setShowSettings(false)} />}
    </div>
  );
}
