import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { useAuth } from "../context/AuthContext";
import { SchoolIcon, LockIcon } from "../components/GameIcons.jsx";
import mascotImg from "../assets/images/pencil_girl_mascot.jpg";
import "../styles/auth.css";

export default function RegisterPage() {
  const { register, registerAdmin } = useAuth();
  const navigate = useNavigate();

  // Selected Role: "STUDENT" | "ADMIN"
  const [role, setRole] = useState("STUDENT");
  // Steps for STUDENT: 1 (School Name) -> 2 (Board) -> 3 (Standard) -> 4 (Username & Password)
  // Steps for ADMIN:   1 (School Name) -> 4 (Username & Password)
  const [step, setStep] = useState(1);

  // Form Fields
  const [schoolName, setSchoolName] = useState("");
  const [board, setBoard] = useState("CBSE");
  const [classLevel, setClassLevel] = useState(4);
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const [error, setError] = useState("");
  const [busy, setBusy] = useState(false);

  // Step 1: School Name -> Next (goes to Step 2 for Student, or Step 4 for Admin)
  const handleStep1Submit = (e) => {
    e.preventDefault();
    setError("");
    if (!schoolName.trim()) {
      setError("Please enter your school name.");
      return;
    }
    if (role === "STUDENT") {
      setStep(2);
    } else {
      setStep(4);
    }
  };

  // Step 2: Choose Board -> Next (Student only)
  const handleStep2Submit = (e) => {
    e.preventDefault();
    setError("");
    setStep(3);
  };

  // Step 3: Choose Standard -> Next (Student only)
  const handleStep3Submit = (e) => {
    e.preventDefault();
    setError("");
    setStep(4);
  };

  // Step 4: Final Submit (Username & Password)
  const handleFinalSubmit = async (e) => {
    e.preventDefault();
    setError("");
    setBusy(true);

    try {
      if (role === "STUDENT") {
        const payload = {
          username: username.trim(),
          password,
          classLevel: Number(classLevel),
          board,
          schoolName: schoolName.trim(),
        };
        await register(payload);
        navigate("/lobby");
      } else {
        const payload = {
          username: username.trim(),
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

            <h1 className="login-heading-title">Create an Account</h1>

            {error && <div className="error-banner">{error}</div>}

            {/* ========================================================
                STEP 1: SELECT ROLE & ENTER SCHOOL NAME
                ======================================================== */}
            {step === 1 && (
              <form onSubmit={handleStep1Submit} className="login-form-elements">
                <div className="role-switcher-row">
                  <button
                    type="button"
                    className={`role-switcher-pill ${role === "STUDENT" ? "active-purple" : ""}`}
                    onClick={() => setRole("STUDENT")}
                  >
                    <div className="role-icon-graphic">
                      <svg width="32" height="32" viewBox="0 0 32 32" fill="none">
                        <circle cx="11" cy="11" r="5" fill="#f8a5c2" />
                        <path d="M4 25c0-4 3.5-7 7-7s7 3 7 7" fill="#74b9ff" />
                        <circle cx="21" cy="12" r="4.5" fill="#f7d794" />
                        <path d="M16 25c0-3.5 2.5-6 5-6s5 2.5 5 6" fill="#ff7675" />
                      </svg>
                    </div>
                    <span className="role-label-text">Student</span>
                  </button>

                  <button
                    type="button"
                    className={`role-switcher-pill ${role === "ADMIN" ? "active-purple" : ""}`}
                    onClick={() => setRole("ADMIN")}
                  >
                    <div className="role-icon-graphic">
                      <svg width="32" height="32" viewBox="0 0 32 32" fill="none">
                        <circle cx="11" cy="11" r="5" fill="#95afc0" />
                        <path d="M4 25c0-4 3.5-7 7-7s7 3 7 7" fill="#535c68" />
                        <circle cx="21" cy="12" r="4.5" fill="#95afc0" />
                        <path d="M16 25c0-3.5 2.5-6 5-6s5 2.5 5 6" fill="#535c68" />
                      </svg>
                    </div>
                    <span className="role-label-text">Admin</span>
                  </button>
                </div>

                <div className="ref-input-group">
                  <span className="ref-input-icon">
                    <SchoolIcon size={18} />
                  </span>
                  <input
                    id="schoolName"
                    className="ref-input-control"
                    value={schoolName}
                    onChange={(e) => setSchoolName(e.target.value)}
                    placeholder="Enter School Name"
                    required
                    autoFocus
                  />
                </div>

                <button className="btn-lime-submit" type="submit">
                  <span>Next</span>
                  <span className="btn-accent-notch" />
                </button>
              </form>
            )}

            {/* ========================================================
                STEP 2: CHOOSE BOARD (CBSE / State Board)
                ======================================================== */}
            {step === 2 && (
              <form onSubmit={handleStep2Submit} className="login-form-elements">
                <div className="ref-input-group">
                  <span className="ref-input-icon">
                    <svg width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2.2">
                      <polygon points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2" />
                    </svg>
                  </span>
                  <select
                    id="board"
                    className="ref-input-control"
                    value={board}
                    onChange={(e) => setBoard(e.target.value)}
                    style={{ cursor: "pointer" }}
                    autoFocus
                  >
                    <option value="CBSE">Choose Board: CBSE</option>
                    <option value="STATE_BOARD">Choose Board: State Board</option>
                  </select>
                </div>

                <div style={{ display: "flex", gap: "10px", marginTop: "4px" }}>
                  <button
                    type="button"
                    className="btn btn-ghost-pill"
                    style={{ flex: "0 0 80px", height: "46px" }}
                    onClick={() => setStep(1)}
                  >
                    Back
                  </button>
                  <button type="submit" className="btn-lime-submit" style={{ flex: 1 }}>
                    <span>Next</span>
                    <span className="btn-accent-notch" />
                  </button>
                </div>
              </form>
            )}

            {/* ========================================================
                STEP 3: CHOOSE STANDARD / CLASS
                ======================================================== */}
            {step === 3 && (
              <form onSubmit={handleStep3Submit} className="login-form-elements">
                <div className="ref-input-group">
                  <span className="ref-input-icon">
                    <svg width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2.2">
                      <line x1="8" y1="6" x2="21" y2="6" />
                      <line x1="8" y1="12" x2="21" y2="12" />
                      <line x1="8" y1="18" x2="21" y2="18" />
                    </svg>
                  </span>
                  <select
                    id="classLevel"
                    className="ref-input-control"
                    value={classLevel}
                    onChange={(e) => setClassLevel(Number(e.target.value))}
                    style={{ cursor: "pointer" }}
                    autoFocus
                  >
                    <option value={4}>Choose Standard: Class 4th</option>
                    <option value={5}>Choose Standard: Class 5th</option>
                    <option value={6}>Choose Standard: Class 6th</option>
                    <option value={7}>Choose Standard: Class 7th</option>
                    <option value={8}>Choose Standard: Class 8th</option>
                    <option value={9}>Choose Standard: Class 9th</option>
                    <option value={10}>Choose Standard: Class 10th</option>
                    <option value={11}>Choose Standard: Class 11th</option>
                    <option value={12}>Choose Standard: Class 12th</option>
                  </select>
                </div>

                <div style={{ display: "flex", gap: "10px", marginTop: "4px" }}>
                  <button
                    type="button"
                    className="btn btn-ghost-pill"
                    style={{ flex: "0 0 80px", height: "46px" }}
                    onClick={() => setStep(2)}
                  >
                    Back
                  </button>
                  <button type="submit" className="btn-lime-submit" style={{ flex: 1 }}>
                    <span>Next</span>
                    <span className="btn-accent-notch" />
                  </button>
                </div>
              </form>
            )}

            {/* ========================================================
                STEP 4: USERNAME & PASSWORD -> CREATE ACCOUNT
                ======================================================== */}
            {step === 4 && (
              <form onSubmit={handleFinalSubmit} className="login-form-elements">
                <div className="ref-input-group">
                  <span className="ref-input-icon">
                    <svg width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2.2">
                      <path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2" />
                      <circle cx="12" cy="7" r="4" />
                    </svg>
                  </span>
                  <input
                    id="username"
                    className="ref-input-control"
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                    placeholder="Enter Username"
                    required
                    autoFocus
                  />
                </div>

                <div className="ref-input-group">
                  <span className="ref-input-icon">
                    <LockIcon size={18} />
                  </span>
                  <input
                    id="password"
                    type="password"
                    className="ref-input-control"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    placeholder="Enter Password"
                    required
                  />
                </div>

                <div style={{ display: "flex", gap: "10px", marginTop: "4px" }}>
                  <button
                    type="button"
                    className="btn btn-ghost-pill"
                    style={{ flex: "0 0 80px", height: "46px" }}
                    onClick={() => (role === "STUDENT" ? setStep(3) : setStep(1))}
                  >
                    Back
                  </button>
                  <button
                    className="btn-lime-submit"
                    type="submit"
                    disabled={busy}
                    style={{ flex: 1 }}
                  >
                    <span>{busy ? "Creating…" : "Create Account"}</span>
                    <span className="btn-accent-notch" />
                  </button>
                </div>
              </form>
            )}

            {/* Bottom Links */}
            <div className="login-card-footer">
              <span className="footer-subtext">
                Already have an account?{" "}
                <Link to="/login" className="footer-link-highlight">
                  Log In
                </Link>
              </span>
            </div>
          </div>
        </div>

        {/* RIGHT PANEL: Character Illustration Area */}
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
    </div>
  );
}
