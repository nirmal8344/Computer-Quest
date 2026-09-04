import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { useAuth } from "../context/AuthContext";
import { LockIcon, CloseIcon } from "../components/GameIcons";
import mascotImg from "../assets/images/pencil_girl_mascot.jpg";
import "../styles/auth.css";

export default function LoginPage() {
  const { login } = useAuth();
  const navigate = useNavigate();
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const [busy, setBusy] = useState(false);
  const [showForgotModal, setShowForgotModal] = useState(false);

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError("");
    setBusy(true);
    try {
      await login(username, password);
      navigate("/lobby");
    } catch (err) {
      setError(err.message || "Couldn't sign in. Check your username and password.");
    } finally {
      setBusy(false);
    }
  };

  return (
    <div className="login-viewport-screen">
      {/* Decorative Floral / Petal Corner Accents from Reference */}
      <div className="corner-deco top-left-deco" aria-hidden="true">
        <svg viewBox="0 0 160 160" width="160" height="160" fill="none">
          <path d="M 0 0 C 45 10 75 45 80 80 C 45 75 10 45 0 0 Z" fill="#d980fa" opacity="0.8" />
          <path d="M 80 80 C 85 45 115 10 160 0 C 150 45 115 75 80 80 Z" fill="#e056fd" opacity="0.75" />
          <path d="M 0 160 C 10 115 45 85 80 80 C 75 115 45 150 0 160 Z" fill="#be2edd" opacity="0.65" />
          <path d="M 80 80 C 115 85 150 115 160 160 C 115 150 85 115 80 80 Z" fill="#d980fa" opacity="0.8" />
        </svg>
      </div>

      <div className="corner-deco bottom-right-deco" aria-hidden="true">
        <svg viewBox="0 0 160 160" width="160" height="160" fill="none">
          <path d="M 0 0 C 45 10 75 45 80 80 C 45 75 10 45 0 0 Z" fill="#d980fa" opacity="0.8" />
          <path d="M 80 80 C 85 45 115 10 160 0 C 150 45 115 75 80 80 Z" fill="#e056fd" opacity="0.75" />
          <path d="M 0 160 C 10 115 45 85 80 80 C 75 115 45 150 0 160 Z" fill="#be2edd" opacity="0.65" />
          <path d="M 80 80 C 115 85 150 115 160 160 C 115 150 85 115 80 80 Z" fill="#d980fa" opacity="0.8" />
        </svg>
      </div>

      {/* Main Container Card matching Reference Layout */}
      <div className="login-modal-wrapper">
        {/* LEFT PANEL: Clean White Form Card */}
        <div className="login-form-card-container">
          <div className="login-form-card">
            {/* Top Green Rounded Corner Accent Notch */}
            <div className="card-top-green-accent" />

            <h1 className="login-heading-title">Log In</h1>

            {/* Clean Form: Only Username & Password */}
            <form onSubmit={handleSubmit} className="login-form-elements">
              {error && <div className="error-banner">{error}</div>}

              {/* Username Input with Icon */}
              <div className="ref-input-group">
                <span className="ref-input-icon">
                  <svg width="19" height="19" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2.2" strokeLinecap="round" strokeLinejoin="round">
                    <path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2" />
                    <circle cx="12" cy="7" r="4" />
                  </svg>
                </span>
                <input
                  id="username"
                  className="ref-input-control"
                  value={username}
                  onChange={(e) => setUsername(e.target.value)}
                  placeholder="Username"
                  required
                  autoComplete="username"
                />
              </div>

              {/* Password Input with Lock Icon */}
              <div className="ref-input-group">
                <span className="ref-input-icon">
                  <LockIcon size={19} />
                </span>
                <input
                  id="password"
                  type="password"
                  className="ref-input-control"
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                  placeholder="Password"
                  required
                  autoComplete="current-password"
                />
              </div>

              {/* Main Lime Green Action Button from Reference */}
              <button
                className="btn-lime-submit"
                type="submit"
                disabled={busy}
              >
                <span>{busy ? "Signing In…" : "Log In"}</span>
                <span className="btn-accent-notch" />
              </button>
            </form>

            {/* Bottom Navigation Links */}
            <div className="login-card-footer">
              <span className="footer-subtext">
                Don't have an account?{" "}
                <Link to="/register" className="footer-link-highlight">
                  Sign Up
                </Link>
              </span>

              <button
                type="button"
                className="footer-help-btn"
                onClick={() => setShowForgotModal(true)}
              >
                Need Help?
              </button>
            </div>
          </div>
        </div>

        {/* RIGHT PANEL: Joyful Character Illustration Area */}
        <div className="login-illustration-panel">
          <div className="illustration-swoop-bg" />

          {/* Clouds */}
          <div className="cloud-shape cloud-top-left">
            <svg viewBox="0 0 130 55" width="120" height="50" fill="#ffffff">
              <path d="M15 40 a16 16 0 0 1 12-28 a22 22 0 0 1 38-6 a24 24 0 0 1 42 14 a18 18 0 0 1 8 20 z" />
            </svg>
          </div>

          <div className="cloud-shape cloud-bottom-right">
            <svg viewBox="0 0 150 65" width="135" height="56" fill="#ffffff">
              <path d="M20 46 a20 20 0 0 1 15-34 a26 26 0 0 1 46-7 a28 28 0 0 1 50 16 a21 21 0 0 1 11 25 z" />
            </svg>
          </div>

          {/* Prominent High-Fidelity Character Mascot Image */}
          <div className="hero-mascot-container">
            <img
              src={mascotImg}
              alt="Computer Quest Learning Mascot"
              className="mascot-raster-img"
            />
          </div>
        </div>
      </div>

      {/* Account Help Modal */}
      {showForgotModal && (
        <div className="modal-backdrop" onClick={() => setShowForgotModal(false)}>
          <div className="modal-card" onClick={(e) => e.stopPropagation()} style={{ padding: "26px" }}>
            <div style={{ display: "flex", alignItems: "center", justifyContent: "space-between", marginBottom: "14px" }}>
              <h2 style={{ fontSize: "1.2rem", margin: 0 }}>Explorer Account Assistance</h2>
              <button className="topbar-circle-btn" onClick={() => setShowForgotModal(false)}>
                <CloseIcon size={16} />
              </button>
            </div>
            <div style={{ color: "var(--text-muted)", fontSize: "0.92rem", lineHeight: "1.6" }}>
              <p>Need help logging into your Computer Quest account?</p>
              <ul style={{ paddingLeft: "20px", marginTop: "8px" }}>
                <li>Ask your teacher or school administrator to check or reset your explorer username/password.</li>
                <li>Make sure caps lock is disabled when typing your password.</li>
                <li>To create a new student or admin account, click <strong>Sign Up</strong>.</li>
              </ul>
            </div>
            <div style={{ marginTop: "20px" }}>
              <button className="btn btn-peach btn-block" onClick={() => setShowForgotModal(false)}>
                Got it, Back to Login
              </button>
            </div>
          </div>
        </div>
      )}
    </div>
  );
}
