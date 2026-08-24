import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { useAuth } from "../../context/AuthContext";
import GameLogo from "../../components/GameLogo.jsx";
import "../../styles/admin.css";

export default function AdminLoginPage() {
  const { adminLogin } = useAuth();
  const navigate = useNavigate();
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const [busy, setBusy] = useState(false);

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError("");
    setBusy(true);
    try {
      await adminLogin(username, password);
      navigate("/admin");
    } catch (err) {
      setError(err.message || "Invalid admin credentials.");
    } finally {
      setBusy(false);
    }
  };

  return (
    <div className="admin-login-screen">
      <div className="admin-login-card">
        <div className="admin-login-brand">
          <GameLogo size="medium" />
          <span className="admin-subtitle" style={{ marginTop: "8px", display: "inline-block" }}>
            ADMINISTRATOR CONTROL PORTAL
          </span>
        </div>

        <form onSubmit={handleSubmit} className="admin-login-form">
          {error && <div className="error-banner">{error}</div>}

          <div className="admin-field">
            <label htmlFor="username">Admin Username</label>
            <input
              id="username"
              type="text"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
              placeholder="Enter admin username"
              required
            />
          </div>

          <div className="admin-field">
            <label htmlFor="password">Admin Password</label>
            <input
              id="password"
              type="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              placeholder="Enter admin password"
              required
            />
          </div>

          <button className="btn btn-admin-primary" type="submit" disabled={busy}>
            {busy ? "Authenticating…" : "Login to Control Panel"}
          </button>
        </form>

        <div className="admin-login-footer" style={{ display: "flex", flexDirection: "column", gap: "10px", marginTop: "20px" }}>
          <Link to="/register" style={{ color: "#38bdf8", fontWeight: "700", textDecoration: "none", fontSize: "0.9rem" }}>
            Create new Admin / School Account
          </Link>
          <button className="btn-link-player" onClick={() => navigate("/login")}>
            🎮 Switch to Student Game Login
          </button>
        </div>
      </div>
    </div>
  );
}
