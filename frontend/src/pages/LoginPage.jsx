import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { useAuth } from "../context/AuthContext";
import GameLogo from "../components/GameLogo.jsx";
import { LockIcon, CloseIcon } from "../components/GameIcons";
import loginBgImg from "../assets/images/login_bg.jpg";
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
    <div className="auth-game-screen" style={{ backgroundImage: `url(${loginBgImg})` }}>
      <div className="auth-landscape-frame">
        {/* Crisp COMPUTER QUEST Title Logo */}
        <div className="game-title-banner">
          <GameLogo size="large" />
        </div>

        <div className="auth-card-game">
          <h2 className="step-heading-game" style={{ textAlign: "center", marginBottom: "16px" }}>STUDENT SIGN IN</h2>

          <form onSubmit={handleSubmit} className="auth-form-game">
            {error && <div className="error-banner">{error}</div>}

            <div className="game-input-container">
              <label className="field-label-game">
                <span>Username</span>
              </label>
              <input
                id="username"
                className="game-input"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
                placeholder="Enter Username"
                required
              />
            </div>

            <div className="game-input-container">
              <label className="field-label-game">
                <span>Password</span>
              </label>
              <input
                id="password"
                type="password"
                className="game-input"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                placeholder="Enter Password"
                required
              />
            </div>

            <div className="button-help-row">
              <button
                className="btn btn-emerald btn-block btn-lg btn-signin-3d"
                type="submit"
                disabled={busy}
              >
                {busy ? "Signing In…" : "Sign In & Play"}
              </button>

              <button
                type="button"
                className="forgot-help-btn"
                onClick={() => setShowForgotModal(true)}
                title="Forgot Password / Help"
              >
                ?
              </button>
            </div>
          </form>

          <div className="auth-footer-links">
            <p className="auth-switch-game">
              Don't have an explorer account?{" "}
              <Link to="/register" className="highlight-link">
                Create Account
              </Link>
            </p>
            <div className="admin-portal-link">
              <Link to="/admin/login">
                <LockIcon size={16} /> Admin Portal Login
              </Link>
            </div>
          </div>
        </div>
      </div>

      {showForgotModal && (
        <div className="modal-backdrop" onClick={() => setShowForgotModal(false)}>
          <div className="modal-card panel-parchment" onClick={(e) => e.stopPropagation()}>
            <div className="modal-header">
              <h2>Account Help</h2>
              <button className="close-btn" onClick={() => setShowForgotModal(false)}>
                <CloseIcon size={20} />
              </button>
            </div>
            <div style={{ color: "#451a03", lineHeight: "1.6" }}>
              <p>
                If you have forgotten your password or need assistance with your Computer Quest account:
              </p>
              <ul>
                <li>Ask your teacher or course administrator to reset your account password.</li>
                <li>Ensure caps lock is turned off when entering your credentials.</li>
              </ul>
            </div>
            <div className="modal-actions" style={{ marginTop: "20px" }}>
              <button className="btn btn-amber btn-block" onClick={() => setShowForgotModal(false)}>
                Back to Sign In
              </button>
            </div>
          </div>
        </div>
      )}
    </div>
  );
}
