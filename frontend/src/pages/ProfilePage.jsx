import { useEffect, useState } from "react";
import { profileApi } from "../api/client";
import { useAuth } from "../context/AuthContext";
import TopBar from "../components/TopBar.jsx";
import Loader from "../components/Loader.jsx";
import { StarIcon, HeartIcon, MapIcon, TrophyIcon, CheckIcon, SchoolIcon } from "../components/GameIcons.jsx";
import mapBookBg from "../assets/images/map_book_bg.jpg";
import "../styles/profile.css";

export default function ProfilePage() {
  const { user } = useAuth();
  const [profile, setProfile] = useState(null);
  const [error, setError] = useState("");

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
    <div className="profile-screen" style={{ backgroundImage: `url(${mapBookBg})` }}>
      <TopBar xp={profile?.xp} lives={profile?.lives} />
      <div className="profile-body">
        {error && <div className="error-banner">{error}</div>}
        {!profile && !error && <Loader label="Loading profile..." />}

        {profile && (
          <div className="panel-parchment profile-card">
            <div className="avatar-glyph profile-avatar">
              {profile.username?.[0]?.toUpperCase() ?? "P"}
            </div>
            <h2 className="profile-username">{profile.username}</h2>
            <p className="profile-sub">
              {profile.school?.name && (
                <span className="profile-school-inline">
                  <SchoolIcon size={16} />
                  <span>{profile.school.name}</span>
                  <span> · </span>
                </span>
              )}
              {profile.board} · Class {profile.classLevel}th
            </p>

            <div className="profile-stats">
              <div className="profile-stat-box">
                <StarIcon size={24} />
                <span className="profile-stat-value">{profile.xp ?? 0}</span>
                <span className="profile-stat-label">Total XP</span>
              </div>
              <div className="profile-stat-box">
                <HeartIcon size={24} />
                <span className="profile-stat-value">{profile.lives ?? 0}</span>
                <span className="profile-stat-label">Lives</span>
              </div>
              <div className="profile-stat-box">
                <MapIcon size={24} />
                <span className="profile-stat-value">{profile.chapter ?? 1}</span>
                <span className="profile-stat-label">Chapter</span>
              </div>
              <div className="profile-stat-box">
                <TrophyIcon size={24} />
                <span className="profile-stat-value">{profile.mission ?? 1}</span>
                <span className="profile-stat-label">Mission</span>
              </div>
              <div className="profile-stat-box">
                <CheckIcon size={24} />
                <span className="profile-stat-value">{profile.answeredQuestions ?? 0}</span>
                <span className="profile-stat-label">Answered</span>
              </div>
            </div>
          </div>
        )}
      </div>
    </div>
  );
}

