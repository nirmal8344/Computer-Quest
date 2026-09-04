import React, { useEffect, useMemo, useState } from "react";
import { useNavigate, useSearchParams } from "react-router-dom";
import { unitApi, chapterApi, missionApi, gameApi } from "../api/client";
import { useAuth } from "../context/AuthContext";
import SettingsModal from "../components/SettingsModal.jsx";
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

  const unitIdParam = searchParams.get("unitId");
  const chapterIdParam = searchParams.get("chapterId");

  const [unitsData, setUnitsData] = useState([]);
  const [chaptersData, setChaptersData] = useState([]);
  const [missionsData, setMissionsData] = useState([]);
  const [gameData, setGameData] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  const [showTeacherPopup, setShowTeacherPopup] = useState(false);
  const [showSettings, setShowSettings] = useState(false);
  const [pageIndex, setPageIndex] = useState(0);

  useEffect(() => {
    let active = true;
    Promise.all([
      unitApi.getUnits({ userId: user.id }).catch(() => []),
      chapterApi.getAll({ userId: user.id }),
      missionApi.getAll({ userId: user.id }),
      gameApi.getGameData(user.id),
    ])
      .then(([u, c, m, g]) => {
        if (!active) return;
        const sortedChapters = [...c].sort((a, b) => a.chapterNumber - b.chapterNumber);

        let parsedUnits = u;
        if (!parsedUnits || parsedUnits.length === 0) {
          const unitNames = [...new Set(sortedChapters.map((ch) => ch.unit || "Unit 1"))];
          parsedUnits = unitNames.map((name, idx) => ({
            id: idx + 1,
            unitName: name,
            unitNumber: idx + 1,
          }));
        }

        setUnitsData(parsedUnits);
        setChaptersData(sortedChapters);
        setMissionsData(m);
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
  }, [user.id]);

  // Derived selected Unit & Chapter based on URL search parameters
  const selectedUnit = useMemo(() => {
    if (!unitIdParam) return null;
    return (
      unitsData.find(
        (u) => String(u.id) === String(unitIdParam) || String(u.unitNumber) === String(unitIdParam)
      ) || null
    );
  }, [unitIdParam, unitsData]);

  const selectedChapter = useMemo(() => {
    if (!chapterIdParam) return null;
    return chaptersData.find((ch) => String(ch.id) === String(chapterIdParam)) || null;
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
      const uName = selectedUnit.unitName || `Unit ${selectedUnit.unitNumber}`;
      return chaptersData.filter((ch) => ch.unit === uName || ch.unit === selectedUnit.unitName);
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
      setSearchParams({ unitId: selectedUnit?.id || selectedUnit?.unitNumber || 1 });
      setPageIndex(0);
    } else if (mapStage === "CHAPTERS") {
      setSearchParams({});
      setPageIndex(0);
    } else {
      navigate("/lobby");
    }
  };

  // Node Click Handlers
  const handleUnitClick = (unit) => {
    setSearchParams({ unitId: unit.id || unit.unitNumber });
    setPageIndex(0);
  };

  const handleChapterClick = (chapter) => {
    setSearchParams({
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
        unitId: selectedUnit?.id || selectedUnit?.unitNumber || 1,
        chapterId: selectedChapter?.id || 1,
        unit: selectedChapter?.unit || selectedUnit?.unitName || "Unit 1",
        chapterName: selectedChapter?.chapterName || "Chapter 1",
        missionNumber: mission.missionNumber || 1,
        gameType: gameType,
      },
    });
  };

  // Teacher Speech Text
  const getTeacherSpeech = () => {
    if (mapStage === "UNITS") {
      return `Welcome, Explorer! In this section, you will learn the core fundamentals of Computer Science. Complete each unit to advance!`;
    }
    if (mapStage === "CHAPTERS") {
      return `Explore Chapters! Select a chapter to discover its quest missions.`;
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

        <div className="map-header-center-pill">
          {mapStage === "UNITS" && (
            <span className="count-pill-badge">{unitsData.length} Units Available</span>
          )}
          {mapStage === "CHAPTERS" && (
            <span className="count-pill-badge">{currentStageItems.length} Chapters in {selectedUnit?.unitName || "Unit"}</span>
          )}
          {mapStage === "MISSIONS" && (
            <span className="count-pill-badge">{currentStageItems.length} Missions in Chapter {selectedChapter?.chapterNumber}</span>
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
          <div className="error-banner">Couldn't load map: {error}</div>
        </div>
      )}

      {loading && <Loader label="Opening your learning path..." />}

      {!loading && (
        <div className="map-content-container">
          {/* Main Title Header */}
          <div className="map-title-header">
            <h1 className="map-main-title">
              {mapStage === "UNITS" ? (
                <>Learning <span className="title-highlight">Units</span></>
              ) : mapStage === "CHAPTERS" ? (
                <><span className="title-highlight">{selectedUnit?.unitName || "Chapters"}</span></>
              ) : (
                <>Chapter {selectedChapter?.chapterNumber}: <span className="title-highlight">{selectedChapter?.chapterName || "Missions"}</span></>
              )}
            </h1>
          </div>

          {/* Cards List */}
          <div className="lesson-cards-list">
            {visibleItems.length === 0 && (
              <div className="empty-state-card">
                <p>No items found for this selection.</p>
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
                itemSub = "Core computer science foundation and problem solving.";
                isUnlocked = itemNumber <= (gameData?.currentChapter ? Math.ceil(gameData.currentChapter / 3) : 1);
                isCompleted = itemNumber < (gameData?.currentChapter ? Math.ceil(gameData.currentChapter / 3) : 1);
                progressBadge = isCompleted ? "Completed" : isUnlocked ? "In Progress" : "Locked";
                onClickHandler = () => isUnlocked && handleUnitClick(item);
              } else if (mapStage === "CHAPTERS") {
                itemTitle = `Chapter ${item.chapterNumber}: ${item.chapterName}`;
                itemSub = item.description || "Learn core computational concepts and mission challenges.";
                isUnlocked = item.unlocked || item.chapterNumber <= (gameData?.currentChapter ?? 1);
                isCompleted = item.chapterNumber < (gameData?.currentChapter ?? 1);
                progressBadge = isCompleted ? "4/4" : isUnlocked ? "1/4" : "0/4";
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
                      <span>{mapStage === "UNITS" ? `UNIT ${itemNumber}` : mapStage === "CHAPTERS" ? `CHAPTER ${item.chapterNumber || itemNumber}` : `MISSION ${itemNumber}`}</span>
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
                    <div className={`progress-badge-circle ${isCompleted ? "completed" : ""}`}>
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
              <button className="btn btn-peach btn-sm-card" onClick={() => setShowTeacherPopup(false)}>
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
