import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { useAuth } from "../context/AuthContext";
import GameLogo from "../components/GameLogo.jsx";
import { SchoolIcon } from "../components/GameIcons.jsx";
import loginBgImg from "../assets/images/login_bg.jpg";
import "../styles/auth.css";

export default function RegisterPage() {
  const { register, registerAdmin } = useAuth();
  const navigate = useNavigate();

  // Wizard state: 1: ROLE -> 2: SCHOOL -> 3: DETAILS -> 4: CREDENTIALS
  const [role, setRole] = useState(null); // "STUDENT" | "ADMIN"
  const [step, setStep] = useState(1);

  // Form data
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [classLevel, setClassLevel] = useState(11);
  const [board, setBoard] = useState("CBSE");
  const [schoolName, setSchoolName] = useState("");

  const [error, setError] = useState("");
  const [busy, setBusy] = useState(false);

  const handleRoleSelect = (selectedRole) => {
    setRole(selectedRole);
    setError("");
    setStep(2); // Go to School step
  };

  const handleSchoolSubmit = (e) => {
    e.preventDefault();
    setError("");
    if (!schoolName.trim()) {
      setError("Please enter your school name.");
      return;
    }

    if (role === "STUDENT") {
      setStep(3); // Go to Board & Class step
    } else {
      setStep(4); // Admin skips Board & Class -> Go directly to Credentials
    }
  };

  const handleDetailsSubmit = (e) => {
    e.preventDefault();
    setStep(4); // Go to Credentials step
  };

  const handleFinalSubmit = async (e) => {
    e.preventDefault();
    setError("");
    setBusy(true);

    try {
      if (role === "STUDENT") {
        const payload = {
          username,
          password,
          classLevel: Number(classLevel),
          board,
          schoolName: schoolName.trim(),
        };
        await register(payload);
        navigate("/lobby");
      } else {
        const payload = {
          username,
          password,
          schoolName: schoolName.trim(),
        };
        await registerAdmin(payload);
        navigate("/admin");
      }
    } catch (err) {
      setError(err.message || "Couldn't create account. Try a different username.");
    } finally {
      setBusy(false);
    }
  };

  return (
    <div className="auth-game-screen" style={{ backgroundImage: `url(${loginBgImg})` }}>
      <div className="auth-landscape-frame">
        {/* Crisp COMPUTER QUEST Title Logo */}
        <div className="game-title-banner">
          <GameLogo size="medium" />
        </div>

        <div className="auth-card-game">
          {error && <div className="error-banner">{error}</div>}

          {/* STEP 1: SELECT ROLE (Student or Admin) */}
          {step === 1 && (
            <div className="wizard-step-container">
              <h2 className="step-heading-game">CREATE YOUR ACCOUNT</h2>
              <p className="step-subheading-game">Who is creating this account?</p>

              <div className="role-selection-grid">
                <button
                  type="button"
                  className="role-card-btn student-role"
                  onClick={() => handleRoleSelect("STUDENT")}
                >
                  <div className="role-icon">🎓</div>
                  <div className="role-title">STUDENT EXPLORER</div>
                  <div className="role-desc">Play quest missions, answer questions & level up!</div>
                </button>

                <button
                  type="button"
                  className="role-card-btn admin-role"
                  onClick={() => handleRoleSelect("ADMIN")}
                >
                  <div className="role-icon">👑</div>
                  <div className="role-title">SCHOOL ADMIN</div>
                  <div className="role-desc">Manage units, chapters, missions & student progress!</div>
                </button>
              </div>
            </div>
          )}

          {/* STEP 2: ENTER SCHOOL NAME */}
          {step === 2 && (
            <form onSubmit={handleSchoolSubmit} className="auth-form-game">
              <div className="step-badge">
                <span>{role === "STUDENT" ? "STUDENT REGISTER" : "ADMIN REGISTER"} — STEP 1 OF {role === "STUDENT" ? "3" : "2"}</span>
              </div>

              <div className="game-input-container">
                <label className="field-label-game" htmlFor="schoolName">
                  <SchoolIcon size={16} />
                  <span>Enter School Name</span>
                </label>

                <input
                  id="schoolName"
                  className="game-input"
                  value={schoolName}
                  onChange={(e) => setSchoolName(e.target.value)}
                  placeholder="Type your school name..."
                  required
                  autoFocus
                />
              </div>

              <div className="wizard-btn-row">
                <button
                  type="button"
                  className="btn btn-ghost btn-sm"
                  onClick={() => setStep(1)}
                >
                  ← Back
                </button>
                <button type="submit" className="btn btn-emerald btn-lg flex-1">
                  Next Step →
                </button>
              </div>
            </form>
          )}

          {/* STEP 3: BOARD & CLASS (Student Only) */}
          {step === 3 && role === "STUDENT" && (
            <form onSubmit={handleDetailsSubmit} className="auth-form-game">
              <div className="step-badge">
                <span>STUDENT REGISTER — STEP 2 OF 3</span>
              </div>

              <div className="game-input-container">
                <label className="field-label-game" htmlFor="board">
                  <span>Educational Board</span>
                </label>
                <select
                  id="board"
                  className="game-input game-select"
                  value={board}
                  onChange={(e) => setBoard(e.target.value)}
                >
                  <option value="CBSE">CBSE Board</option>
                  <option value="STATE_BOARD">State Board</option>
                </select>
              </div>

              <div className="game-input-container">
                <label className="field-label-game" htmlFor="classLevel">
                  <span>Class Level</span>
                </label>
                <select
                  id="classLevel"
                  className="game-input game-select"
                  value={classLevel}
                  onChange={(e) => setClassLevel(Number(e.target.value))}
                >
                  <option value={11}>Class 11th</option>
                  <option value={12}>Class 12th</option>
                </select>
              </div>

              <div className="wizard-btn-row">
                <button
                  type="button"
                  className="btn btn-ghost btn-sm"
                  onClick={() => setStep(2)}
                >
                  ← Back
                </button>
                <button type="submit" className="btn btn-emerald btn-lg flex-1">
                  Next Step →
                </button>
              </div>
            </form>
          )}

          {/* STEP 4: USERNAME & PASSWORD */}
          {step === 4 && (
            <form onSubmit={handleFinalSubmit} className="auth-form-game">
              <div className="step-badge">
                <span>{role === "STUDENT" ? "STUDENT REGISTER — STEP 3 OF 3" : "ADMIN REGISTER — STEP 2 OF 2"}</span>
              </div>

              <div className="game-input-container">
                <label className="field-label-game" htmlFor="username">
                  <span>Account Username</span>
                </label>
                <input
                  id="username"
                  className="game-input"
                  value={username}
                  onChange={(e) => setUsername(e.target.value)}
                  placeholder="Choose Username"
                  required
                />
              </div>

              <div className="game-input-container">
                <label className="field-label-game" htmlFor="password">
                  <span>Account Password</span>
                </label>
                <input
                  id="password"
                  type="password"
                  className="game-input"
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                  placeholder="Choose Password"
                  required
                />
              </div>

              <div className="wizard-btn-row">
                <button
                  type="button"
                  className="btn btn-ghost btn-sm"
                  onClick={() => setStep(role === "STUDENT" ? 3 : 2)}
                >
                  ← Back
                </button>
                <button
                  className="btn btn-emerald btn-lg flex-1"
                  type="submit"
                  disabled={busy}
                >
                  {busy ? "Creating Account…" : role === "STUDENT" ? "Create & Start Quest" : "Create Admin Account"}
                </button>
              </div>
            </form>
          )}

          <div className="auth-footer-links">
            <p className="auth-switch-game">
              Already have an account?{" "}
              <Link to="/login" className="highlight-link">
                Sign In
              </Link>
            </p>
          </div>
        </div>
      </div>
    </div>
  );
}
