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
  BackArrowIcon,
  GearIcon,
} from "../components/GameIcons.jsx";
import teacherImg from "../assets/images/teacher_adriane.jpg";
import "../styles/mission.css";

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
  const [stage, setStage] = useState("PLAYING"); // Directly start in gameplay screen
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
      .getAll({ userId: user?.id })
      .then((chapters) => {
        if (!chapters || chapters.length === 0) throw new Error("No chapters available.");
        const ch =
          chapters.find(
            (c) =>
              String(c.id) === String(chapterId) ||
              String(c.chapterNumber) === String(chapterId)
          ) || chapters[0];
        setMeta((prev) => ({
          ...prev,
          unitId: prev?.unitId || ch.unitNumber || 1,
          chapterId: ch.id,
          unit: ch.unit || "Unit 1",
          chapterName: ch.chapterName,
          missionNumber: Number(missionNumber) || 1,
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
  }, [meta, chapterId, missionNumber, user?.id]);

  const loadQuestions = () => {
    if (!meta || !user?.id) return;
    questionApi
      .getForMission(meta.unit, meta.chapterName, meta.missionNumber, { userId: user?.id })
      .then((raw) => {
        const cleaned = raw.map(({ correctAnswer, ...rest }) => rest);
        setQuestions(cleaned);
      })
      .catch((err) => setError(err.message));
  };

  useEffect(() => {
    loadQuestions();
  }, [meta, user?.id]);

  const current = questions?.[index];

  const handleSelect = (key) => {
    if (feedback) return;
    setSelected(key);
  };

  const handleSubmit = async () => {
    if ((selected === null || selected === "") || !current || !user?.id) return;
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

  // Shared Top Controls Bar
  const renderMissionTopBar = () => (
    <header className="mission-top-bar">
      <div className="lives-container">
        {[1, 2, 3].map((num) => (
          <HeartIcon key={num} size={24} filled={num <= (lives ?? 3)} />
        ))}
        <span className="lives-count-text">{lives ?? 3} Lives</span>
      </div>

      <div className="top-bar-right">
        <button className="topbar-circle-btn" onClick={handleBackToMap} title="Back to Missions">
          <BackArrowIcon size={18} />
        </button>

        <button
          className="topbar-circle-btn help-btn"
          onClick={() => setShowTeacherPopup(true)}
          title="Teacher Guidance"
        >
          <span className="help-icon">👩‍🏫</span>
        </button>

        <button
          className="topbar-circle-btn"
          onClick={() => setShowSettings(true)}
          title="Settings"
        >
          <GearIcon size={18} />
        </button>
      </div>
    </header>
  );

  if (error) {
    return (
      <div className="mission-modern-screen">
        {renderMissionTopBar()}
        <div className="mission-content-box">
          <div className="error-banner">{error}</div>
          <button className="btn btn-primary" onClick={handleBackToMap}>
            <MapIcon size={18} />
            <span>Back to Missions</span>
          </button>
        </div>
        {showSettings && <SettingsModal onClose={() => setShowSettings(false)} />}
      </div>
    );
  }

  if (!meta || !questions) {
    return (
      <div className="mission-modern-screen">
        {renderMissionTopBar()}
        <Loader label="Loading mission questions..." />
        {showSettings && <SettingsModal onClose={() => setShowSettings(false)} />}
      </div>
    );
  }

  // Stage 1: Pre-Mission Briefing
  if (stage === "BRIEFING") {
    return (
      <div className="mission-modern-screen">
        {renderMissionTopBar()}

        <div className="mission-content-box">
          <div className="cq-card mission-briefing-card">
            <div className="briefing-header">
              <span className="briefing-badge">
                {(meta.gameType || "MISSION").toUpperCase()} · MISSION {meta.missionNumber}
              </span>
              <h2 className="briefing-title">{meta.chapterName}</h2>
              <p className="briefing-subtitle">Challenge Mission {meta.missionNumber}</p>
            </div>

            <TeacherGuide
              title="Teacher Adriane"
              speech={`Welcome, explorer! In this challenge, answer all 5 questions to earn 5 stars and +10 XP per question. Protect your 3 lives and complete the quest!`}
              mood="excited"
              actionText="Start Challenge"
              onAction={() => setStage("PLAYING")}
            />
          </div>
        </div>

        {showTeacherPopup && (
          <div className="modal-backdrop" onClick={() => setShowTeacherPopup(false)}>
            <div className="teacher-popup-card" onClick={(e) => e.stopPropagation()}>
              <div className="teacher-avatar-box">
                <img src={teacherImg} alt="Teacher Adriane" className="teacher-avatar-img" />
              </div>

              <div className="teacher-speech-bubble">
                <span className="teacher-badge-name">👩‍🏫 Teacher Adriane</span>
                <p className="speech-text">
                  Complete all 5 questions correctly to earn 5 stars and unlock the next mission!
                </p>
                <button className="btn btn-peach btn-sm-card" onClick={() => setShowTeacherPopup(false)}>
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

  // Stage 3: Mission Outcome
  if (stage === "RESULT" || outcome) {
    const isChapterComplete = outcome === "MISSION_COMPLETE" && Number(meta.missionNumber) === 4;

    return (
      <div className="mission-modern-screen">
        {renderMissionTopBar()}
        <div className="mission-content-box">
          <div className="cq-card outcome-result-card">
            {outcome === "MISSION_COMPLETE" ? (
              <>
                <div className="outcome-trophy-box">
                  <TrophyIcon size={64} />
                </div>
                <h2 className="outcome-headline success">
                  {isChapterComplete ? "CHAPTER COMPLETE!" : "MISSION COMPLETE!"}
                </h2>
                <p className="outcome-description">
                  {isChapterComplete
                    ? `Outstanding work! You completed all 4 missions in ${meta.chapterName} and earned 5 Stars! The next chapter has been unlocked!`
                    : `Great job! You answered all 5 questions correctly in Mission ${meta.missionNumber} and earned 5 Stars!`}
                </p>

                <div className="outcome-stats-row">
                  <div className="stat-pill-result">
                    <StarIcon size={18} filled={true} />
                    <span>5 Stars Earned</span>
                  </div>
                  <div className="stat-pill-result">
                    <HeartIcon size={18} />
                    <span>{lives ?? 3} Lives Left</span>
                  </div>
                </div>

                <button className="btn btn-peach btn-lg btn-block" onClick={handleBackToMap}>
                  <MapIcon size={20} />
                  <span>{isChapterComplete ? "View Next Chapter" : "Continue to Next Mission"}</span>
                </button>
              </>
            ) : (
              <>
                <div className="outcome-trophy-box">
                  <FailedIcon size={64} />
                </div>
                <h2 className="outcome-headline failed">MISSION FAILED</h2>
                <p className="outcome-description">
                  You ran out of lives before finishing all 5 questions. Your 3 lives have been restored. Try again!
                </p>

                <div className="outcome-actions-vertical">
                  <button
                    className="btn btn-peach btn-lg btn-block"
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
                    <MapIcon size={18} />
                    <span>Back to Missions</span>
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

  // Stage 2: Actual Gameplay
  if (!current) {
    return (
      <div className="mission-modern-screen">
        {renderMissionTopBar()}
        <div className="mission-content-box">
          <div className="cq-card outcome-result-card">
            <h2>No Questions Available</h2>
            <p>This mission doesn't have any questions yet.</p>
            <button className="btn btn-peach" onClick={handleBackToMap}>
              Back to Missions
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

  const isFillInBlank = Number(meta.missionNumber) === 2 || current.questionType === "FILL_BLANK";
  const isScenario = Number(meta.missionNumber) === 4 || current.questionType === "SCENARIO" || current.questionType === "CODE_SQL" || current.questionType === "SCENARIO_CODE";

  return (
    <div className="mission-modern-screen">
      {renderMissionTopBar()}

      <div className="mission-content-box">
        {/* Question Card */}
        <div className="cq-card question-play-card">
          {/* Progress Header */}
          <div className="question-card-header">
            <span className="question-step-chip">QUESTION {index + 1} OF 5</span>
            <div className="question-progress-dots">
              {[0, 1, 2, 3, 4].map((dotIdx) => (
                <span
                  key={dotIdx}
                  className={`dot-indicator ${dotIdx === index ? "current" : dotIdx < index ? "done" : ""}`}
                />
              ))}
            </div>
          </div>

          <div className="question-topic-sub">
            [{meta.board || "CBSE"} Class {meta.classLevel || 11}] {meta.chapterName}
          </div>

          <h2 className="question-headline-text">{current.questionText}</h2>

          {/* Interactive Answer Format */}
          {isFillInBlank ? (
            <div className="blank-input-wrapper">
              <input
                type="text"
                className="modern-blank-input"
                placeholder="Type your answer here..."
                value={selected || ""}
                onChange={(e) => !feedback && setSelected(e.target.value)}
                disabled={!!feedback}
              />
            </div>
          ) : isScenario && (current.questionType === "CODE_SQL" || current.questionType === "SCENARIO_CODE" || current.codeLanguage) && options.length === 0 ? (
            <div className="code-editor-box">
              <div className="code-editor-header">
                <span className="code-lang-pill">{current.codeLanguage || "CODE"}</span>
                <span className="code-hint-text">Scenario Code Editor</span>
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
              />
            </div>
          ) : (
            /* MCQ Option Buttons */
            <div className="mcq-options-grid">
              {options.map((opt) => {
                const isSelected = selected === opt.key;
                const isCorrectFeedback = feedback && isSelected && feedback.correct;
                const isWrongFeedback = feedback && isSelected && !feedback.correct;

                return (
                  <button
                    key={opt.key}
                    className={`mcq-option-pill ${isSelected ? "selected" : ""} ${
                      isCorrectFeedback ? "correct" : ""
                    } ${isWrongFeedback ? "wrong" : ""}`}
                    onClick={() => handleSelect(opt.key)}
                    disabled={!!feedback}
                  >
                    <span className="option-letter-badge">{opt.key}</span>
                    <span className="option-content-text">{opt.text}</span>
                  </button>
                );
              })}
            </div>
          )}

          {/* Submit / Feedback Button */}
          {!feedback ? (
            <button
              className="btn btn-peach btn-block btn-lg btn-submit-modern"
              disabled={(selected === null || selected === "") || submitting}
              onClick={handleSubmit}
            >
              {submitting ? "Checking..." : "Submit Answer"}
            </button>
          ) : (
            <div className={`feedback-banner-card ${feedback.correct ? "is-good" : "is-bad"}`}>
              <div className="feedback-text-content">
                {feedback.correct ? (
                  <>
                    <CheckIcon size={22} />
                    <span>Correct! +10 XP earned!</span>
                  </>
                ) : (
                  <>
                    <HeartIcon filled={false} size={22} />
                    <span>Incorrect! Lost 1 life.</span>
                  </>
                )}
              </div>

              <button className="btn btn-dark-pill btn-next-question" onClick={handleNext}>
                <span>Next Question</span>
                <ForwardArrowIcon size={16} />
              </button>
            </div>
          )}
        </div>
      </div>

      {showTeacherPopup && (
        <div className="modal-backdrop" onClick={() => setShowTeacherPopup(false)}>
          <div className="teacher-popup-card" onClick={(e) => e.stopPropagation()}>
            <div className="teacher-avatar-box">
              <img src={teacherImg} alt="Teacher Adriane" className="teacher-avatar-img" />
            </div>

            <div className="teacher-speech-bubble">
              <span className="teacher-badge-name">👩‍🏫 Teacher Adriane</span>
              <p className="speech-text">
                Answer carefully! You earn +10 XP for each correct answer and protect your 3 lives.
              </p>
              <button className="btn btn-peach btn-sm-card" onClick={() => setShowTeacherPopup(false)}>
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
