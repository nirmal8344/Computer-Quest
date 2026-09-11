import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { useAuth } from "../context/AuthContext";
import { SchoolIcon, LockIcon } from "../components/GameIcons.jsx";
import mascotImg from "../assets/images/pencil_girl_mascot.jpg";
import "../styles/auth.css";

export const TN_STATE_BOARD_GROUPS = [
  {
    id: "GROUP 1 – MATHS-BIOLOGY / BIO-MATHS",
    title: "Group 1 – Maths-Biology / Bio-Maths",
    badge: "Bio-Maths",
    subjects: ["Tamil", "English", "Physics", "Chemistry", "Mathematics", "Biology"]
  },
  {
    id: "GROUP 2 – MATHS + COMPUTER SCIENCE",
    title: "Group 2 – Maths + Computer Science",
    badge: "Maths + CS",
    subjects: ["Tamil", "English", "Physics", "Chemistry", "Mathematics", "Computer Science"]
  },
  {
    id: "GROUP 3 – PURE SCIENCE / BIOLOGY",
    title: "Group 3 – Pure Science / Biology",
    badge: "Pure Science",
    subjects: ["Tamil", "English", "Physics", "Chemistry", "Botany", "Zoology"]
  },
  {
    id: "GROUP 4 – COMMERCE",
    title: "Group 4 – Commerce",
    badge: "Commerce",
    subjects: ["Tamil", "English", "Statistics", "Economics", "Commerce", "Accountancy"]
  },
  {
    id: "GROUP 5 – COMMERCE + COMPUTER APPLICATIONS",
    title: "Group 5 – Commerce + Computer Applications",
    badge: "Commerce + CA",
    subjects: ["Tamil", "English", "Economics", "Commerce", "Accountancy", "Computer Applications"]
  },
  {
    id: "GROUP 6 – COMMERCE + BUSINESS MATHEMATICS",
    title: "Group 6 – Commerce + Business Mathematics",
    badge: "Commerce + BM",
    subjects: ["Tamil", "English", "Business Mathematics", "Economics", "Commerce", "Accountancy"]
  },
  {
    id: "GROUP 7 – ACCOUNTANCY + HISTORY",
    title: "Group 7 – Accountancy + History",
    badge: "Acc + History",
    subjects: ["Tamil", "English", "History", "Economics", "Commerce", "Accountancy"]
  }
];

export const CBSE_GROUPS = [
  {
    id: "GROUP 1 – MATHS-BIOLOGY / BIO-MATHS",
    title: "Group 1 – Maths-Biology / Bio-Maths",
    badge: "Bio-Maths",
    subjects: ["English", "Physics", "Chemistry", "Mathematics", "Biology"]
  },
  {
    id: "GROUP 2 – MATHS + COMPUTER SCIENCE",
    title: "Group 2 – Maths + Computer Science",
    badge: "Maths + CS",
    subjects: ["English", "Physics", "Chemistry", "Mathematics", "Computer Science"]
  },
  {
    id: "GROUP 3 – PURE SCIENCE / BIOLOGY",
    title: "Group 3 – Pure Science / Biology",
    badge: "Pure Science",
    subjects: ["English", "Physics", "Chemistry", "Biology"]
  },
  {
    id: "GROUP 4 – COMMERCE",
    title: "Group 4 – Commerce",
    badge: "Commerce",
    subjects: ["English", "Accountancy", "Business Studies", "Economics", "Mathematics"]
  },
  {
    id: "GROUP 5 – COMMERCE + COMPUTER APPLICATIONS",
    title: "Group 5 – Commerce + Computer Applications",
    badge: "Commerce + IP",
    subjects: ["English", "Accountancy", "Business Studies", "Economics", "Informatics Practices"]
  },
  {
    id: "GROUP 6 – COMMERCE + BUSINESS MATHEMATICS",
    title: "Group 6 – Commerce + Business Mathematics",
    badge: "Commerce + BM",
    subjects: ["English", "Accountancy", "Business Studies", "Economics", "Business Mathematics"]
  },
  {
    id: "GROUP 7 – ACCOUNTANCY + HISTORY",
    title: "Group 7 – Accountancy + History",
    badge: "Acc + History",
    subjects: ["English", "Accountancy", "History", "Economics", "Business Studies"]
  }
];

export default function RegisterPage() {
  const { register, registerAdmin } = useAuth();
  const navigate = useNavigate();

  // Selected Role: "STUDENT" | "ADMIN"
  const [role, setRole] = useState("STUDENT");
  // Steps for STUDENT: 1 (School) -> 2 (Board) -> 3 (Class) -> 4 (Group if 11-12) -> 5 (Username/Pass)
  // Steps for ADMIN:   1 (School) -> 5 (Username/Pass)
  const [step, setStep] = useState(1);

  // Form Fields
  const [schoolName, setSchoolName] = useState("RPSIT School");
  const [board, setBoard] = useState("STATE_BOARD");
  const [classLevel, setClassLevel] = useState(4);
  const [studentGroup, setStudentGroup] = useState("GROUP 1 – MATHS-BIOLOGY / BIO-MATHS");
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const [error, setError] = useState("");
  const [busy, setBusy] = useState(false);

  const availableGroups = board === "CBSE" ? CBSE_GROUPS : TN_STATE_BOARD_GROUPS;

  // Step 1: School Name -> Next
  const handleStep1Submit = (e) => {
    e.preventDefault();
    setError("");
    if (!schoolName.trim()) {
      setError("Please enter your school name.");
      return;
    }
    setStep(2);
  };

  // Step 2: Choose Board -> Next
  const handleStep2Submit = (e) => {
    e.preventDefault();
    setError("");
    if (role === "ADMIN") {
      setStep(5);
    } else {
      setStep(3);
    }
  };

  // Step 3: Choose Standard -> Next (If 11 or 12, go to Step 4 Group; else Step 5)
  const handleStep3Submit = (e) => {
    e.preventDefault();
    setError("");
    if (Number(classLevel) >= 11) {
      setStep(4);
    } else {
      setStep(5);
    }
  };

  // Step 4: Choose Group (Class 11 & 12 only) -> Next
  const handleStep4Submit = (e) => {
    e.preventDefault();
    setError("");
    setStep(5);
  };

  // Step 5: Final Submit (Username & Password)
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
          schoolName: schoolName.trim() || "RPSIT School",
          studentGroup: Number(classLevel) >= 11 ? studentGroup : null,
        };
        await register(payload);
        navigate("/lobby");
      } else {
        localStorage.setItem("cq_admin_board", board);
        const payload = {
          username: username.trim(),
          password,
          board,
          schoolName: schoolName.trim() || "RPSIT School",
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

      {/* Main Container Card */}
      <div className="login-modal-wrapper">
        {/* LEFT PANEL: Clean White Form Card */}
        <div className="login-form-card-container">
          <div className="login-form-card">
            {/* Top Green Rounded Corner Accent Notch */}
            <div className="card-top-green-accent" />

            <h1 className="login-heading-title">Create an Account</h1>
            <p style={{ margin: "-8px 0 16px 0", fontSize: "13px", color: "#636e72", fontWeight: 600 }}>
              {role === "STUDENT" ? "RPSIT School • Student Portal" : "RPSIT School • Admin Portal"}
            </p>

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
                    placeholder="Enter School Name (e.g. RPSIT School)"
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
                STEP 2: CHOOSE BOARD (CBSE / Tamil Nadu State Board)
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
                    <option value="STATE_BOARD">State Board</option>
                    <option value="CBSE">CBSE</option>
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
                STEP 3: CHOOSE STANDARD / CLASS (Class 4 to 12)
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
                    <option value={4}>Standard: Class 4th</option>
                    <option value={5}>Standard: Class 5th</option>
                    <option value={6}>Standard: Class 6th</option>
                    <option value={7}>Standard: Class 7th</option>
                    <option value={8}>Standard: Class 8th</option>
                    <option value={9}>Standard: Class 9th</option>
                    <option value={10}>Standard: Class 10th</option>
                    <option value={11}>Standard: Class 11th (Higher Secondary)</option>
                    <option value={12}>Standard: Class 12th (Higher Secondary)</option>
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
                STEP 4: SELECT GROUP (Class 11 & 12 ONLY)
                ======================================================== */}
            {step === 4 && (
              <form onSubmit={handleStep4Submit} className="login-form-elements">
                <div style={{ marginBottom: "10px" }}>
                  <label style={{ fontSize: "12px", fontWeight: 700, color: "#2d3436", textTransform: "uppercase", letterSpacing: "0.5px" }}>
                    Select Class {classLevel} Group / Stream:
                  </label>
                </div>

                <div className="ref-input-group">
                  <span className="ref-input-icon">
                    <svg width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2.2">
                      <path d="M12 2L2 7l10 5 10-5-10-5z" />
                      <path d="M2 17l10 5 10-5" />
                      <path d="M2 12l10 5 10-5" />
                    </svg>
                  </span>
                  <select
                    id="studentGroup"
                    className="ref-input-control"
                    value={studentGroup}
                    onChange={(e) => setStudentGroup(e.target.value)}
                    style={{ cursor: "pointer", fontSize: "13px" }}
                    autoFocus
                  >
                    {availableGroups.map((g) => (
                      <option key={g.id} value={g.id}>
                        {g.title}
                      </option>
                    ))}
                  </select>
                </div>

                {/* Group Subjects Preview */}
                <div style={{ background: "#f1f2f6", borderRadius: "10px", padding: "10px 12px", marginBottom: "14px", border: "1px solid #dfe4ea" }}>
                  <div style={{ fontSize: "11px", fontWeight: 700, color: "#747d8c", textTransform: "uppercase", marginBottom: "6px" }}>
                    Included Core Subjects:
                  </div>
                  <div style={{ display: "flex", flexWrap: "wrap", gap: "6px" }}>
                    {availableGroups.find((g) => g.id === studentGroup)?.subjects.map((sub, idx) => (
                      <span
                        key={idx}
                        style={{
                          background: "#ffffff",
                          color: "#2f3542",
                          fontSize: "11px",
                          fontWeight: 700,
                          padding: "3px 8px",
                          borderRadius: "6px",
                          border: "1px solid #ced6e0",
                          boxShadow: "0 1px 2px rgba(0,0,0,0.05)"
                        }}
                      >
                        {sub}
                      </span>
                    ))}
                  </div>
                </div>

                <div style={{ display: "flex", gap: "10px", marginTop: "4px" }}>
                  <button
                    type="button"
                    className="btn btn-ghost-pill"
                    style={{ flex: "0 0 80px", height: "46px" }}
                    onClick={() => setStep(3)}
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
                STEP 5: USERNAME & PASSWORD -> CREATE ACCOUNT
                ======================================================== */}
            {step === 5 && (
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
                    onClick={() => {
                      if (role === "ADMIN") setStep(1);
                      else if (Number(classLevel) >= 11) setStep(4);
                      else setStep(3);
                    }}
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
              alt="LearnQuest RPSIT School Learning Mascot"
              className="mascot-raster-img"
            />
          </div>
        </div>
      </div>
    </div>
  );
}
