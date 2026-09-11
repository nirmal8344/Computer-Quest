import React, { useEffect, useMemo, useState } from "react";
import { useNavigate, useSearchParams } from "react-router-dom";
import { unitApi, chapterApi, missionApi, gameApi, subjectApi } from "../api/client";
import { useAuth } from "../context/AuthContext";
import SettingsModal from "../components/SettingsModal.jsx";
import SubjectSelectModal from "../components/SubjectSelectModal.jsx";
import Loader from "../components/Loader.jsx";
import {
  LockIcon,
  StarIcon,
  GearIcon,
  BackArrowIcon,
  ForwardArrowIcon,
  BookIcon,
} from "../components/GameIcons.jsx";
import teacherImg from "../assets/images/teacher_adriane.jpg";
import "../styles/map.css";

export default function MapPage() {
  const { user } = useAuth();
  const navigate = useNavigate();
  const [searchParams, setSearchParams] = useSearchParams();

  const subjectParam = searchParams.get("subject") || "";
  const unitIdParam = searchParams.get("unitId");
  const chapterIdParam = searchParams.get("chapterId");

  const [availableSubjects, setAvailableSubjects] = useState([]);
  const [activeSubject, setActiveSubject] = useState(subjectParam);
  const [unitsData, setUnitsData] = useState([]);
  const [chaptersData, setChaptersData] = useState([]);
  const [missionsData, setMissionsData] = useState([]);
  const [gameData, setGameData] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  const [showTeacherPopup, setShowTeacherPopup] = useState(false);
  const [showSettings, setShowSettings] = useState(false);
  const [showSubjectModal, setShowSubjectModal] = useState(false);
  const [pageIndex, setPageIndex] = useState(0);

  // 1. Initial Load: Fetch Subjects & Game Data
  useEffect(() => {
    let active = true;
    if (user?.id) {
      Promise.all([
        subjectApi.getSubjects({ userId: user.id }),
        gameApi.getGameData(user.id),
      ])
        .then(([subs, game]) => {
          if (!active) return;
          setAvailableSubjects(subs || []);
          setGameData(game);

          let initialSub = subjectParam;
          if (!initialSub && subs && subs.length > 0) {
            initialSub = subs[0].subjectName;
          }
          if (!initialSub) initialSub = "Mathematics";
          setActiveSubject(initialSub);
        })
        .catch((err) => {
          if (active) setError(err.message);
        });
    }
    return () => {
      active = false;
    };
  }, [user?.id, subjectParam]);

  // 2. Fetch Units & Chapters for the Active Subject
  useEffect(() => {
    if (!user?.id || !activeSubject) return;
    let active = true;
    setLoading(true);

    Promise.all([
      unitApi.getUnits({ userId: user.id, subject: activeSubject }).catch(() => []),
      chapterApi.getAll({ userId: user.id, subject: activeSubject }),
      missionApi.getAll({ userId: user.id }),
      gameApi.getGameData(user.id, { subject: activeSubject }),
    ])
      .then(([u, c, m, g]) => {
        if (!active) return;
        const sortedChapters = [...(c || [])].sort(
          (a, b) => (a.chapterNumber || 0) - (b.chapterNumber || 0)
        );
        const sortedMissions = [...(m || [])].sort(
          (a, b) => (a.missionNumber || 0) - (b.missionNumber || 0)
        );

        let parsedUnits = u;
        if (!parsedUnits || parsedUnits.length === 0) {
          const unitNames = [
            ...new Set(sortedChapters.map((ch) => ch.unit || "Unit 1")),
          ];
          parsedUnits = unitNames.map((name, idx) => ({
            id: idx + 1,
            unitName: name,
            unitNumber: idx + 1,
            subject: activeSubject,
          }));
        }
        const sortedUnits = [...(parsedUnits || [])].sort(
          (a, b) => (a.unitNumber || 0) - (b.unitNumber || 0)
        );

        setUnitsData(sortedUnits);
        setChaptersData(sortedChapters);
        setMissionsData(sortedMissions);
        setGameData(g);
        setLoading(false);
      })
      .catch((err) => {
        if (active) {
          setError(err.message);
          setLoading(false);
        }
      });

    return () => {
      active = false;
    };
  }, [user?.id, activeSubject]);

  // Derived selected Unit & Chapter based on URL search parameters
  const selectedUnit = useMemo(() => {
    if (!unitIdParam) return null;
    return (
      unitsData.find(
        (u) =>
          String(u.id) === String(unitIdParam) ||
          String(u.unitNumber) === String(unitIdParam)
      ) || null
    );
  }, [unitIdParam, unitsData]);

  const selectedChapter = useMemo(() => {
    if (!chapterIdParam) return null;
    return (
      chaptersData.find((ch) => String(ch.id) === String(chapterIdParam)) || null
    );
  }, [chapterIdParam, chaptersData]);

  // Map Stage derived strictly from selection
  const mapStage = useMemo(() => {
    if (selectedChapter) return "MISSIONS";
    if (selectedUnit) return "CHAPTERS";
    return "UNITS";
  }, [selectedChapter, selectedUnit]);

  // Current stage items calculation
  const currentStageItems = useMemo(() => {
    if (mapStage === "UNITS") {
      return unitsData;
    } else if (mapStage === "CHAPTERS") {
      if (!selectedUnit) return chaptersData;
      const uName = (selectedUnit.unitName || "").toLowerCase().trim();
      const uNumPrefix = `unit ${selectedUnit.unitNumber}`.toLowerCase();
      const romanNums = [
        "i",
        "ii",
        "iii",
        "iv",
        "v",
        "vi",
        "vii",
        "viii",
        "ix",
        "x",
      ];
      const uNumRomanPrefix = `unit ${
        romanNums[(selectedUnit.unitNumber || 1) - 1] || selectedUnit.unitNumber
      }`.toLowerCase();

      const filtered = chaptersData.filter((ch) => {
        if (!ch.unit) return false;
        const chUnit = ch.unit.toLowerCase().trim();
        return (
          chUnit === uName ||
          chUnit.startsWith(uNumPrefix) ||
          chUnit.startsWith(uNumRomanPrefix) ||
          ch.unit === selectedUnit.unitName
        );
      });
      return filtered.length > 0 ? filtered : chaptersData;
    } else if (mapStage === "MISSIONS") {
      if (!selectedChapter) return missionsData;
      return missionsData.filter((m) => m.chapter?.id === selectedChapter.id);
    }
    return [];
  }, [mapStage, selectedUnit, selectedChapter, unitsData, chaptersData, missionsData]);

  // Navigation pagination: 5 items per page
  const ITEMS_PER_PAGE = 5;
  const totalPages = Math.ceil(currentStageItems.length / ITEMS_PER_PAGE) || 1;
  const visibleItems = currentStageItems.slice(
    pageIndex * ITEMS_PER_PAGE,
    (pageIndex + 1) * ITEMS_PER_PAGE
  );

  // Back Navigation Action
  const handleNavBack = () => {
    if (mapStage === "MISSIONS") {
      setSearchParams({
        subject: activeSubject,
        unitId: selectedUnit?.id || selectedUnit?.unitNumber || 1,
      });
      setPageIndex(0);
    } else if (mapStage === "CHAPTERS") {
      setSearchParams({ subject: activeSubject });
      setPageIndex(0);
    } else {
      navigate("/lobby");
    }
  };

  // Node Click Handlers
  const handleUnitClick = (unit) => {
    setSearchParams({
      subject: activeSubject,
      unitId: unit.id || unit.unitNumber,
    });
    setPageIndex(0);
  };

  const handleChapterClick = (chapter) => {
    setSearchParams({
      subject: activeSubject,
      unitId: selectedUnit?.id || selectedUnit?.unitNumber || 1,
      chapterId: chapter.id,
    });
    setPageIndex(0);
  };

  const handleMissionClick = (mission) => {
    const gameType =
      mission.gameType ||
      (mission.missionNumber === 1 || mission.missionNumber === 3
        ? "MCQ Quiz"
        : mission.missionNumber === 2
        ? "Fill in the Blank"
        : "Scenario Challenge");

    navigate(`/mission/${selectedChapter?.id || 1}/${mission.missionNumber || 1}`, {
      state: {
        subject: activeSubject,
        unitId: selectedUnit?.id || selectedUnit?.unitNumber || 1,
        chapterId: selectedChapter?.id || 1,
        unit: selectedChapter?.unit || selectedUnit?.unitName || "Unit 1",
        chapterName: selectedChapter?.chapterName || "Chapter 1",
        missionNumber: mission.missionNumber || 1,
        gameType: gameType,
      },
    });
  };

  const handleSwitchSubject = (sub) => {
    setActiveSubject(sub.subjectName);
    setSearchParams({ subject: sub.subjectName });
    setPageIndex(0);
  };

  // Teacher Guidance Speech
  const getTeacherSpeech = () => {
    if (mapStage === "UNITS") {
      return `Welcome to ${activeSubject}! Explore each unit systematically to master core concepts and advance your quest.`;
    }
    if (mapStage === "CHAPTERS") {
      return `Explore ${activeSubject} Chapters! Select a chapter to discover its interactive quest missions.`;
    }
    return `Explore Missions! Answer all 5 questions in each mission to earn 5 stars and level up!`;
  };

  return (
    <div className="map-clean-screen">
      {/* Top Header Bar */}
      <header className="map-top-bar">
        <button className="topbar-circle-btn" onClick={handleNavBack} title="Back">
          <BackArrowIcon size={18} />
        </button>

        {/* Subject & Level Indicator */}
        <div
          className="map-header-subject-badge"
          onClick={() => setShowSubjectModal(true)}
          title="Click to Switch Subject"
        >
          <span className="badge-sub-icon">📚</span>
          <span className="badge-sub-title">{activeSubject}</span>
          <span className="badge-sub-switch">Change ▾</span>
        </div>

        <div className="map-header-center-pill">
          {mapStage === "UNITS" && (
            <span className="count-pill-badge">
              {unitsData.length} Units in {activeSubject}
            </span>
          )}
          {mapStage === "CHAPTERS" && (
            <span className="count-pill-badge">
              {currentStageItems.length} Chapters in {selectedUnit?.unitName || "Unit"}
            </span>
          )}
          {mapStage === "MISSIONS" && (
            <span className="count-pill-badge">
              {currentStageItems.length} Missions in Chapter {selectedChapter?.chapterNumber}
            </span>
          )}
        </div>

        <div className="top-bar-right">
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

      {error && (
        <div className="map-error-wrapper">
          <div className="error-banner">Couldn't load learning path: {error}</div>
        </div>
      )}

      {loading && <Loader label={`Opening ${activeSubject} learning path...`} />}

      {!loading && (
        <div className="map-content-container">
          {/* Main Title Header */}
          <div className="map-title-header">
            <h1 className="map-main-title">
              {mapStage === "UNITS" ? (
                <>
                  {activeSubject}: <span className="title-highlight">Learning Units</span>
                </>
              ) : mapStage === "CHAPTERS" ? (
                <>
                  <span className="title-highlight">
                    {selectedUnit?.unitName || "Chapters"}
                  </span>
                </>
              ) : (
                <>
                  Chapter {selectedChapter?.chapterNumber}:{" "}
                  <span className="title-highlight">
                    {selectedChapter?.chapterName || "Missions"}
                  </span>
                </>
              )}
            </h1>
          </div>

          {/* Cards List */}
          <div className="lesson-cards-list">
            {visibleItems.length === 0 && (
              <div className="empty-state-card">
                <p>No curriculum content found for this selection.</p>
                <button className="btn btn-primary" onClick={handleNavBack}>
                  Back to Previous Level
                </button>
              </div>
            )}

            {visibleItems.map((item, idx) => {
              let itemNumber = idx + 1 + pageIndex * ITEMS_PER_PAGE;
              let itemTitle = "";
              let itemSub = "";
              let isUnlocked = true;
              let isCompleted = false;
              let progressBadge = "0/5";
              let onClickHandler = () => {};

              if (mapStage === "UNITS") {
                itemNumber = item.unitNumber || idx + 1;
                const rawName = item.unitName || `Unit ${itemNumber}`;
                itemTitle = rawName;
                itemSub = `Prescribed curriculum unit for ${activeSubject}.`;
                isUnlocked =
                  itemNumber <=
                  (gameData?.currentChapter ? Math.ceil(gameData.currentChapter / 3) : 1);
                isCompleted =
                  itemNumber <
                  (gameData?.currentChapter ? Math.ceil(gameData.currentChapter / 3) : 1);
                progressBadge = isCompleted
                  ? "Completed"
                  : isUnlocked
                  ? "In Progress"
                  : "Locked";
                onClickHandler = () => isUnlocked && handleUnitClick(item);
              } else if (mapStage === "CHAPTERS") {
                itemTitle = `Chapter ${item.chapterNumber}: ${item.chapterName}`;
                itemSub =
                  item.description ||
                  `Core lessons and challenges in ${item.chapterName}.`;
                isUnlocked =
                  item.unlocked ||
                  item.chapterNumber <= (gameData?.currentChapter ?? 1);
                isCompleted =
                  item.chapterNumber < (gameData?.currentChapter ?? 1);
                progressBadge = isCompleted
                  ? "4/4"
                  : isUnlocked
                  ? "1/4"
                  : "0/4";
                onClickHandler = () => isUnlocked && handleChapterClick(item);
              } else if (mapStage === "MISSIONS") {
                itemNumber = item.missionNumber || idx + 1;
                itemTitle = `Mission ${itemNumber}: ${
                  item.missionNumber === 1 || item.missionNumber === 3
                    ? "MCQ Quiz"
                    : item.missionNumber === 2
                    ? "Fill in the Blank"
                    : "Scenario Challenge"
                }`;
                itemSub = "Complete 5 interactive questions to earn 5 stars!";
                isUnlocked =
                  selectedChapter?.chapterNumber < (gameData?.currentChapter ?? 1) ||
                  (selectedChapter?.chapterNumber === (gameData?.currentChapter ?? 1) &&
                    itemNumber <= (gameData?.currentMission ?? 1));
                isCompleted =
                  selectedChapter?.chapterNumber < (gameData?.currentChapter ?? 1) ||
                  (selectedChapter?.chapterNumber === (gameData?.currentChapter ?? 1) &&
                    itemNumber < (gameData?.currentMission ?? 1));
                progressBadge = isCompleted ? "5/5" : isUnlocked ? "0/5" : "Locked";
                onClickHandler = () => isUnlocked && handleMissionClick(item);
              }

              return (
                <div
                  key={item.id || idx}
                  className={`lesson-item-card ${!isUnlocked ? "is-locked" : ""} ${
                    isCompleted ? "is-completed" : ""
                  }`}
                  onClick={onClickHandler}
                >
                  <div className="card-main-details">
                    <div className="lesson-badge-tag">
                      <span>
                        {mapStage === "UNITS"
                          ? `UNIT ${itemNumber}`
                          : mapStage === "CHAPTERS"
                          ? `CHAPTER ${item.chapterNumber || itemNumber}`
                          : `MISSION ${itemNumber}`}
                      </span>
                    </div>

                    <h3 className="lesson-card-title">{itemTitle}</h3>
                    <p className="lesson-card-desc">{itemSub}</p>

                    <div className="lesson-action-row">
                      {isUnlocked ? (
                        <button className="btn btn-peach btn-sm-card">
                          <span>{isCompleted ? "Review" : "Start"}</span>
                        </button>
                      ) : (
                        <button className="btn btn-ghost btn-sm-card" disabled>
                          <LockIcon size={16} />
                          <span>Unlock</span>
                        </button>
                      )}

                      {/* 5 Stars for Completed Missions */}
                      {mapStage === "MISSIONS" && isCompleted && (
                        <div className="stars-earned-pill">
                          {[1, 2, 3, 4, 5].map((s) => (
                            <StarIcon key={s} size={14} filled={true} />
                          ))}
                        </div>
                      )}
                    </div>
                  </div>

                  <div className="card-side-progress">
                    <div
                      className={`progress-badge-circle ${
                        isCompleted ? "completed" : ""
                      }`}
                    >
                      <span>{progressBadge}</span>
                    </div>
                    <div className="card-mini-mascot">
                      <BookIcon size={34} />
                    </div>
                  </div>
                </div>
              );
            })}
          </div>

          {/* Pagination Controls */}
          {totalPages > 1 && (
            <div className="map-pagination-row">
              <button
                className="pagination-arrow-btn"
                disabled={pageIndex === 0}
                onClick={() => setPageIndex((p) => Math.max(0, p - 1))}
              >
                <BackArrowIcon size={18} />
              </button>
              <span className="pagination-text">
                Page {pageIndex + 1} of {totalPages}
              </span>
              <button
                className="pagination-arrow-btn"
                disabled={pageIndex >= totalPages - 1}
                onClick={() => setPageIndex((p) => Math.min(totalPages - 1, p + 1))}
              >
                <ForwardArrowIcon size={18} />
              </button>
            </div>
          )}
        </div>
      )}

      {/* Subject Selection Modal */}
      {showSubjectModal && (
        <SubjectSelectModal
          subjects={availableSubjects}
          activeSubject={activeSubject}
          onSelectSubject={handleSwitchSubject}
          onClose={() => setShowSubjectModal(false)}
        />
      )}

      {/* Teacher Instruction Popup */}
      {showTeacherPopup && (
        <div className="modal-backdrop" onClick={() => setShowTeacherPopup(false)}>
          <div className="teacher-popup-card" onClick={(e) => e.stopPropagation()}>
            <div className="teacher-avatar-box">
              <img src={teacherImg} alt="Teacher Adriane" className="teacher-avatar-img" />
            </div>

            <div className="teacher-speech-bubble">
              <span className="teacher-badge-name">👩‍🏫 Teacher Adriane</span>
              <p className="speech-text">{getTeacherSpeech()}</p>
              <button
                className="btn btn-peach btn-sm-card"
                onClick={() => setShowTeacherPopup(false)}
              >
                Got it!
              </button>
            </div>
          </div>
        </div>
      )}

      {showSettings && <SettingsModal onClose={() => setShowSettings(false)} />}
    </div>
  );
}
