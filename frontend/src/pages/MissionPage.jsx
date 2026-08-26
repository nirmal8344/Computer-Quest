import React, { useEffect, useState } from "react";
import { useLocation, useNavigate, useParams } from "react-router-dom";
import { chapterApi, questionApi } from "../api/client";
import { useAuth } from "../context/AuthContext";
import TeacherGuide from "../components/TeacherGuide.jsx";
import Loader from "../components/Loader.jsx";
import SettingsModal from "../components/SettingsModal.jsx";
import {
  TrophyIcon,
  FailedIcon,
  MapIcon,
  HeartIcon,
  StarIcon,
  CheckIcon,
  ForwardArrowIcon,
  GearIcon,
} from "../components/GameIcons.jsx";
import mapBookBg from "../assets/images/map_book_bg.jpg";
import teacherImg from "../assets/images/teacher_adriane.jpg";
import "../styles/mission.css";
import "../styles/map.css";

const OPTION_KEYS = ["A", "B", "C", "D"];

export default function MissionPage() {
  const { user } = useAuth();
  const { chapterId, missionNumber } = useParams();
  const location = useLocation();
  const navigate = useNavigate();

  const [meta, setMeta] = useState(location.state || null);
  const [questions, setQuestions] = useState(null);
  const [index, setIndex] = useState(0);
  const [selected, setSelected] = useState(null);
  const [feedback, setFeedback] = useState(null); // { correct, xp, lives }
  const [outcome, setOutcome] = useState(null); // MISSION_COMPLETE | MISSION_FAILED
  const [stage, setStage] = useState("BRIEFING"); // BRIEFING -> PLAYING -> RESULT
  const [error, setError] = useState("");
  const [xp, setXp] = useState(null);
  const [lives, setLives] = useState(null);
  const [submitting, setSubmitting] = useState(false);
  const [showSettings, setShowSettings] = useState(false);
  const [showTeacherPopup, setShowTeacherPopup] = useState(false);

  // Resolve unit/chapterName if page loaded directly
  useEffect(() => {
    if (meta && meta.chapterId) return;
    chapterApi
      .getAll({ userId: user.id })
      .then((chapters) => {
        const ch = chapters.find((c) => String(c.id) === String(chapterId));
        if (!ch) throw new Error("Chapter not found.");
        setMeta((prev) => ({
          ...prev,
          unitId: prev?.unitId || 1,
          chapterId: ch.id,
          unit: ch.unit,
          chapterName: ch.chapterName,
          missionNumber: Number(missionNumber),
          gameType:
            prev?.gameType ||
            (Number(missionNumber) === 1 || Number(missionNumber) === 3
              ? "MCQ Quiz"
              : Number(missionNumber) === 2
              ? "Fill in the Blank"
              : "Scenario Challenge"),
        }));
      })
      .catch((err) => setError(err.message));
  }, [meta, chapterId, missionNumber, user.id]);

  const loadQuestions = () => {
    if (!meta) return;
    questionApi
      .getForMission(meta.unit, meta.chapterName, meta.missionNumber, { userId: user.id })
      .then((raw) => {
        const cleaned = raw.map(({ correctAnswer, ...rest }) => rest);
        setQuestions(cleaned);
      })
      .catch((err) => setError(err.message));
  };

  useEffect(() => {
    loadQuestions();
  }, [meta, user.id]);

  const current = questions?.[index];

  const handleSelect = (key) => {
    if (feedback) return;
    setSelected(key);
  };

  const handleSubmit = async () => {
    if ((selected === null || selected === "") || !current) return;
    setSubmitting(true);
    setError("");
    try {
      const res = await questionApi.submitAnswer(current.id, user.id, selected);
      setXp(res.xp);
      setLives(res.lives);

      if (res.result === "MISSION_COMPLETE" || res.result === "MISSION_FAILED") {
        setOutcome(res.result);
        setStage("RESULT");
        return;
      }

      setFeedback({ correct: res.result === "CORRECT" });
    } catch (err) {
      setError(err.message);
    } finally {
      setSubmitting(false);
    }
  };

  const handleNext = () => {
    setFeedback(null);
    setSelected(null);
    setIndex((i) => i + 1);
  };

  const handleBackToMap = () => {
    const uId = meta?.unitId || 1;
    const cId = meta?.chapterId || chapterId || 1;
    navigate(`/map?unitId=${uId}&chapterId=${cId}`);
  };

  // Shared Floating Top Bar Component
  const renderMapTopBar = () => (
    <div className="map-top-bar">
      <div className="lives-container">
        {[1, 2, 3].map((num) => (
          <HeartIcon key={num} size={28} filled={num <= (lives ?? 3)} />
        ))}
      </div>

      <div className="top-bar-right">
        <button className="icon-btn-round home-btn" onClick={handleBackToMap} title="Back to Missions">
          <span className="btn-glyph">⬅️</span>
        </button>

        <button
          className="icon-btn-round help-btn"
          onClick={() => setShowTeacherPopup(true)}
          title="Teacher Guidance"
        >
          <span className="btn-glyph">❓</span>
          <span className="btn-badge">4</span>
        </button>

        <button
          className="icon-btn-round settings-btn"
          onClick={() => setShowSettings(true)}
          title="Settings"
        >
          <GearIcon size={22} />
        </button>
      </div>
    </div>
  );

  if (error) {
    return (
      <div className="mission-game-screen" style={{ backgroundImage: `url(${mapBookBg})` }}>
        {renderMapTopBar()}
        <div className="mission-container">
          <div className="error-banner mission-error">{error}</div>
          <button className="btn btn-ghost" onClick={handleBackToMap}>
            <MapIcon size={20} />
            <span>Back to Missions</span>
          </button>
        </div>
        {showSettings && <SettingsModal onClose={() => setShowSettings(false)} />}
      </div>
    );
  }

  if (!meta || !questions) {
    return (
      <div className="mission-game-screen" style={{ backgroundImage: `url(${mapBookBg})` }}>
        {renderMapTopBar()}
        <Loader label="Loading game mission..." />
        {showSettings && <SettingsModal onClose={() => setShowSettings(false)} />}
      </div>
    );
  }

  // Stage 1: Pre-Mission Briefing - Teacher Adriane gives instructions
  if (stage === "BRIEFING") {
    return (
      <div className="mission-game-screen" style={{ backgroundImage: `url(${mapBookBg})` }}>
        {renderMapTopBar()}

        <div className="mission-container">
          <div className="briefing-card panel-parchment">
            <div className="briefing-header">
              <span className="briefing-tag">
                {(meta.gameType || "MISSION").toUpperCase()} — MISSION {meta.missionNumber}
              </span>
              <h2>{meta.chapterName} — Mission {meta.missionNumber}</h2>
            </div>

            <TeacherGuide
              title="Teacher Adriane"
              speech={`Explorer, welcome to Mission ${meta.missionNumber}! In this challenge, you must answer all 5 computer science questions correctly. Each correct answer earns +10 XP. Lose 3 lives and you must retry. Are you ready?`}
              mood="excited"
              actionText="Start Mission"
              onAction={() => setStage("PLAYING")}
            />
          </div>
        </div>

        {showTeacherPopup && (
          <div className="teacher-popup-backdrop" onClick={() => setShowTeacherPopup(false)}>
            <div className="teacher-popup-card" onClick={(e) => e.stopPropagation()}>
              <div className="teacher-avatar-box">
                <img src={teacherImg} alt="Teacher Adriane" className="teacher-avatar-img" />
              </div>

              <div className="teacher-speech-bubble">
                <p className="speech-text">
                  Explorer, welcome to Mission {meta.missionNumber}! Answer all 5 questions to earn 5 stars and unlock the next mission!
                </p>
                <button className="teacher-ok-btn" onClick={() => setShowTeacherPopup(false)}>
                  OK
                </button>
              </div>
            </div>
          </div>
        )}

        {showSettings && <SettingsModal onClose={() => setShowSettings(false)} />}
      </div>
    );
  }

  // Stage 3: Mission Outcome (MISSION_COMPLETE / MISSION_FAILED)
  if (stage === "RESULT" || outcome) {
    const isChapterComplete = outcome === "MISSION_COMPLETE" && Number(meta.missionNumber) === 4;

    return (
      <div className="mission-game-screen" style={{ backgroundImage: `url(${mapBookBg})` }}>
        {renderMapTopBar()}
        <div className="mission-container">
          <div className="outcome-card panel-parchment">
            {outcome === "MISSION_COMPLETE" ? (
              isChapterComplete ? (
                <>
                  <div className="outcome-badge-icon">
                    <TrophyIcon size={72} />
                  </div>
                  <h1 className="outcome-title-complete">CHAPTER COMPLETE!</h1>
                  <p className="outcome-sub">
                    Incredible job! You completed all 4 missions in <strong>{meta.chapterName}</strong> and earned 5 Stars! The next chapter has been unlocked!
                  </p>
                  <div className="outcome-stats-box">
                    <span className="stat-item"><StarIcon size={20} filled={true} /> 5 Stars Earned</span>
                    <span className="stat-item"><HeartIcon size={20} /> Remaining Lives: {lives ?? 3}</span>
                  </div>
                  <button className="btn btn-emerald btn-lg btn-block" onClick={handleBackToMap}>
                    <MapIcon size={22} />
                    <span>Return to Map & View Next Chapter</span>
                  </button>
                </>
              ) : (
                <>
                  <div className="outcome-badge-icon">
                    <TrophyIcon size={72} />
                  </div>
                  <h1 className="outcome-title-complete">MISSION COMPLETE!</h1>
                  <p className="outcome-sub">
                    Great work! You completed 5/5 questions in Mission {meta.missionNumber} and earned 5 Stars! The next mission is unlocked!
                  </p>
                  <div className="outcome-stats-box">
                    <span className="stat-item"><StarIcon size={20} filled={true} /> 5 Stars Earned</span>
                    <span className="stat-item"><HeartIcon size={20} /> Remaining Lives: {lives ?? 3}</span>
                  </div>
                  <button className="btn btn-emerald btn-lg btn-block" onClick={handleBackToMap}>
                    <MapIcon size={22} />
                    <span>Continue to Next Mission</span>
                  </button>
                </>
              )
            ) : (
              <>
                <div className="outcome-badge-icon">
                  <FailedIcon size={72} />
                </div>
                <h1 className="outcome-title-failed">MISSION FAILED</h1>
                <p className="outcome-sub">
                  You ran out of lives before completing all 5 questions! No stars were awarded. Your lives have been restored to 3. Try again!
                </p>
                <div className="outcome-actions">
                  <button
                    className="btn btn-amber btn-lg btn-block"
                    onClick={() => {
                      setOutcome(null);
                      setStage("BRIEFING");
                      setIndex(0);
                      setSelected(null);
                      setFeedback(null);
                      loadQuestions();
                    }}
                  >
                    <span>Retry Mission</span>
                  </button>
                  <button className="btn btn-ghost btn-block" onClick={handleBackToMap}>
                    <MapIcon size={20} />
                    <span>Return to Missions</span>
                  </button>
                </div>
              </>
            )}
          </div>
        </div>
        {showSettings && <SettingsModal onClose={() => setShowSettings(false)} />}
      </div>
    );
  }

  // Stage 2: Actual Gameplay (No Questions fallback)
  if (!current) {
    return (
      <div className="mission-game-screen" style={{ backgroundImage: `url(${mapBookBg})` }}>
        {renderMapTopBar()}
        <div className="mission-container">
          <div className="outcome-card panel-parchment">
            <h2>No Questions Available</h2>
            <p>This mission doesn't have any questions yet.</p>
            <button className="btn btn-emerald" onClick={handleBackToMap}>
              <MapIcon size={20} />
              <span>Back to Missions</span>
            </button>
          </div>
        </div>
        {showSettings && <SettingsModal onClose={() => setShowSettings(false)} />}
      </div>
    );
  }

  const options = OPTION_KEYS.map((key) => ({
    key,
    text: current[`option${key}`],
  })).filter((o) => o.text);

  // Check Game Type for Question Display
  const isFillInBlank = Number(meta.missionNumber) === 2 || current.questionType === "FILL_BLANK";
  const isScenario = Number(meta.missionNumber) === 4 || current.questionType === "SCENARIO" || current.questionType === "CODE_SQL" || current.questionType === "SCENARIO_CODE";

  return (
    <div className="mission-game-screen" style={{ backgroundImage: `url(${mapBookBg})` }}>
      {renderMapTopBar()}

      <div className="game-scene-container playing-mode">
        {/* Question Card & Game-Specific Answer Format */}
        <div className="question-game-card panel-parchment">
          <div className="question-bubble">
            <span className="q-number-chip">Q{index + 1}/5</span>
            <div className="question-meta-text">
              <span className="question-subject-title">
                [{meta.board || "CBSE"} Class {meta.classLevel || 11}] {meta.chapterName} (Mission {meta.missionNumber} — {meta.gameType || (isFillInBlank ? "Fill in the Blank" : isScenario ? "Scenario Challenge" : "MCQ Quiz")}):
              </span>
              <h2 className="question-text">{current.questionText}</h2>
            </div>
          </div>

          {/* Render ONLY the assigned game type */}
          {isFillInBlank ? (
            <div className="blank-input-box" style={{ padding: "16px 0" }}>
              <input
                type="text"
                className="fill-blank-input"
                placeholder="Type your answer here..."
                value={selected || ""}
                onChange={(e) => !feedback && setSelected(e.target.value)}
                disabled={!!feedback}
                style={{
                  width: "100%",
                  padding: "14px 18px",
                  fontSize: "1.1rem",
                  borderRadius: "8px",
                  border: "2px solid #cbd5e1",
                  outline: "none",
                }}
              />
            </div>
          ) : isScenario && (current.questionType === "CODE_SQL" || current.questionType === "SCENARIO_CODE" || current.codeLanguage) && options.length === 0 ? (
            <div className="code-editor-box" style={{ padding: "12px 0" }}>
              <div className="code-editor-header" style={{
                display: "flex",
                alignItems: "center",
                gap: "8px",
                marginBottom: "8px",
              }}>
                <span className="code-language-badge" style={{
                  display: "inline-block",
                  padding: "4px 12px",
                  borderRadius: "6px",
                  fontWeight: 700,
                  fontSize: "0.85rem",
                  letterSpacing: "0.5px",
                  textTransform: "uppercase",
                  backgroundColor:
                    current.codeLanguage === "Python" ? "#306998" :
                    current.codeLanguage === "C" ? "#555" :
                    current.codeLanguage === "Java" ? "#b07219" :
                    current.codeLanguage === "SQL" ? "#e38d13" : "#475569",
                  color: "#fff",
                }}>
                  {current.codeLanguage || "CODE"}
                </span>
                <span style={{ color: "#94a3b8", fontSize: "0.85rem" }}>Scenario Code Editor</span>
              </div>
              <textarea
                className="code-editor-input"
                rows="6"
                placeholder={
                  current.codeLanguage === "SQL" ? "Write your SQL query here..." :
                  current.codeLanguage === "Python" ? "# Write your Python code here..." :
                  current.codeLanguage === "C" ? "// Write your C code here..." :
                  current.codeLanguage === "Java" ? "// Write your Java code here..." :
                  "Write your answer here..."
                }
                value={selected !== null ? selected : (current.optionA || "")}
                onChange={(e) => !feedback && setSelected(e.target.value)}
                disabled={!!feedback}
                style={{
                  width: "100%",
                  padding: "14px 18px",
                  fontFamily: "Courier New, monospace",
                  fontSize: "1rem",
                  borderRadius: "8px",
                  border: "2px solid #334155",
                  backgroundColor: "#1e293b",
                  color: "#38bdf8",
                  outline: "none",
                }}
              />
            </div>
          ) : (
            /* MCQ / Scenario Choice Buttons */
            <div className="options-game-grid">
              {options.map((opt) => {
                const isSelected = selected === opt.key;
                const isCorrectFeedback = feedback && isSelected && feedback.correct;
                const isWrongFeedback = feedback && isSelected && !feedback.correct;

                return (
                  <button
                    key={opt.key}
                    className={`game-option-btn ${isSelected ? "selected" : ""} ${
                      isCorrectFeedback ? "correct" : ""
                    } ${isWrongFeedback ? "wrong" : ""}`}
                    onClick={() => handleSelect(opt.key)}
                    disabled={!!feedback}
                  >
                    <span className="option-badge">{opt.key}</span>
                    <span className="option-text">{opt.text}</span>
                  </button>
                );
              })}
            </div>
          )}

          {!feedback ? (
            <button
              className="btn-submit-answer"
              disabled={(selected === null || selected === "") || submitting}
              onClick={handleSubmit}
            >
              {submitting ? "SUBMITTING..." : "SUBMIT ANSWER"}
            </button>
          ) : (
            <div className={`feedback-card-banner ${feedback.correct ? "good" : "bad"}`}>
              <div className="feedback-message">
                {feedback.correct ? (
                  <>
                    <CheckIcon size={24} />
                    <span>Correct! +10 XP earned!</span>
                  </>
                ) : (
                  <>
                    <HeartIcon filled={false} size={24} />
                    <span>Not quite right! You lost 1 life.</span>
                  </>
                )}
              </div>

              <button className="btn btn-amber btn-next-q" onClick={handleNext}>
                <span>Next Question</span>
                <ForwardArrowIcon size={18} />
              </button>
            </div>
          )}
        </div>
      </div>

      {showTeacherPopup && (
        <div className="teacher-popup-backdrop" onClick={() => setShowTeacherPopup(false)}>
          <div className="teacher-popup-card" onClick={(e) => e.stopPropagation()}>
            <div className="teacher-avatar-box">
              <img src={teacherImg} alt="Teacher Adriane" className="teacher-avatar-img" />
            </div>

            <div className="teacher-speech-bubble">
              <p className="speech-text">
                Explorer, welcome to Mission {meta.missionNumber}! Complete all 5 questions to earn 5 stars and protect your lives. Good luck!
              </p>
              <button className="teacher-ok-btn" onClick={() => setShowTeacherPopup(false)}>
                OK
              </button>
            </div>
          </div>
        </div>
      )}

      {showSettings && <SettingsModal onClose={() => setShowSettings(false)} />}
    </div>
  );
}
