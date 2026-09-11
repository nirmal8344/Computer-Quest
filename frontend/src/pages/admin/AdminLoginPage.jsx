import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { useAuth } from "../../context/AuthContext";
import GameLogo from "../../components/GameLogo.jsx";
import "../../styles/admin.css";

export default function AdminLoginPage() {
  const { adminLogin } = useAuth();
  const navigate = useNavigate();
  const [schoolName, setSchoolName] = useState("RPSIT School");
  const [board, setBoard] = useState("CBSE");
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const [busy, setBusy] = useState(false);

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError("");
    setBusy(true);
    try {
      localStorage.setItem("cq_admin_board", board);
      await adminLogin(username, password, board, schoolName);
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
            <label htmlFor="schoolName">School Name</label>
            <input
              id="schoolName"
              type="text"
              value={schoolName}
              onChange={(e) => setSchoolName(e.target.value)}
              placeholder="e.g. RPSIT School"
              required
            />
          </div>

          <div className="admin-field">
            <label htmlFor="board">Board</label>
            <select
              id="board"
              value={board}
              onChange={(e) => setBoard(e.target.value)}
              style={{
                width: "100%",
                padding: "12px 14px",
                background: "rgba(15, 23, 42, 0.8)",
                border: "1px solid rgba(255, 255, 255, 0.15)",
                borderRadius: "8px",
                color: "#fff",
                fontSize: "1rem",
                fontWeight: "600"
              }}
            >
              <option value="CBSE">CBSE</option>
              <option value="STATE_BOARD">State Board</option>
            </select>
          </div>

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
