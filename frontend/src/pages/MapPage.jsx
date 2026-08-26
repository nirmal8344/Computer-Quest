import React, { useEffect, useMemo, useState } from "react";
import { useNavigate, useSearchParams } from "react-router-dom";
import { unitApi, chapterApi, missionApi, gameApi } from "../api/client";
import { useAuth } from "../context/AuthContext";
import SettingsModal from "../components/SettingsModal.jsx";
import Loader from "../components/Loader.jsx";
import {
  HeartIcon,
  LockIcon,
  StarIcon,
  GearIcon,
  BackArrowIcon,
  ForwardArrowIcon,
} from "../components/GameIcons.jsx";
import mapBookBgImg from "../assets/images/map_book_bg.jpg";
import teacherImg from "../assets/images/teacher_adriane.jpg";
import "../styles/map.css";

// Map Flow Stages:
// 1. 'UNITS'    -> Units Map (Start Adventure)
// 2. 'CHAPTERS' -> Chapters Map (Unit Selected via URL param ?unitId=X)
// 3. 'MISSIONS' -> Missions Map (Chapter Selected via URL param ?unitId=X&chapterId=Y)

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
    }
    if (mapStage === "CHAPTERS") {
      if (!selectedUnit) return chaptersData;
      return chaptersData.filter((ch) => {
        const uName = selectedUnit.unitName || `Unit ${selectedUnit.unitNumber}`;
        return ch.unit === uName || ch.unit === selectedUnit.unitName;
      });
    }
    if (mapStage === "MISSIONS") {
      if (!selectedChapter) return missionsData;
      return missionsData.filter((m) => m.chapter?.id === selectedChapter.id);
    }
    return [];
  }, [mapStage, selectedUnit, selectedChapter, unitsData, chaptersData, missionsData]);

  // Navigation pagination: show arrows ONLY if items exceed 5 per screen
  const ITEMS_PER_PAGE = 5;
  const totalPages = Math.ceil(currentStageItems.length / ITEMS_PER_PAGE) || 1;
  const visibleItems = currentStageItems.slice(
    pageIndex * ITEMS_PER_PAGE,
    (pageIndex + 1) * ITEMS_PER_PAGE
  );

  // Back Navigation Action: returns 1 level up in the hierarchy
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

  // Breadcrumb Title Generation
  const getBreadcrumbTitle = () => {
    if (mapStage === "UNITS") return "Explore Units Map";
    if (mapStage === "CHAPTERS") {
      return selectedUnit?.unitName || `Unit ${selectedUnit?.unitNumber || 1}`;
    }
    if (mapStage === "MISSIONS") {
      const uName = selectedUnit?.unitName || `Unit ${selectedUnit?.unitNumber || 1}`;
      return `${uName} > Chapter ${selectedChapter?.chapterNumber || 1}`;
    }
    return "Map";
  };

  // Sub-Banner Config
  const getBannerConfig = () => {
    if (mapStage === "UNITS") {
      return { title: "Explore Units", subtitle: "Complete units to unlock the next" };
    }
    if (mapStage === "CHAPTERS") {
      return { title: "Explore Chapters", subtitle: "Complete chapters to unlock the next" };
    }
    return { title: "Explore Missions", subtitle: "Complete 5 questions to earn 5 stars & unlock next mission" };
  };

  // Teacher Speech Text
  const getTeacherSpeech = () => {
    if (mapStage === "UNITS") {
      return `Welcome, Explorer! You are entering Unit 1. In this unit, you will learn the basic concepts. Complete all chapters to move forward!`;
    }
    if (mapStage === "CHAPTERS") {
      return `Explore Chapters! Select a chapter to discover its missions.`;
    }
    return `Explore Missions! Complete all 5 questions in a mission to earn 5 stars and unlock the next mission!`;
  };

  const banner = getBannerConfig();

  return (
    <div className="map-game-screen" style={{ backgroundImage: `url(${mapBookBgImg})` }}>
      {/* Top Controls Bar matching Reference Diagram */}
      <div className="map-top-bar">
        <div className="lives-container">
          {[1, 2, 3].map((num) => (
            <HeartIcon key={num} size={28} filled={num <= (gameData?.lives ?? 3)} />
          ))}
        </div>

        <div className="top-bar-right">
          <button className="icon-btn-round home-btn" onClick={handleNavBack} title="Back">
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

      {error && <div className="error-banner map-error">Couldn't load map: {error}</div>}
      {loading && <Loader label="Opening the Quest Tome..." />}

      {!loading && (
        <div className="map-stage-wrapper">
          {/* Main Book Component with Optional Page Navigation Arrows */}
          <div className="tome-book-outer">
            {/* Show Left Arrow ONLY if totalPages > 1 and pageIndex > 0 */}
            {totalPages > 1 && pageIndex > 0 && (
              <button
                className="side-page-arrow arrow-left"
                onClick={() => setPageIndex((p) => Math.max(0, p - 1))}
              >
                <BackArrowIcon size={32} />
              </button>
            )}

            {/* Open Tome Parchment Book */}
            <div className="open-tome-book">
              {/* Top-Left Breadcrumb Ribbon */}
              <div className="breadcrumb-ribbon">
                <span>{getBreadcrumbTitle()}</span>
              </div>

              {/* Connected Pathway SVG Line */}
              <div className="pathway-container">
                <svg className="path-svg" viewBox="0 0 800 400">
                  <path
                    d="M 120 180 Q 260 100 400 200 T 680 180"
                    fill="none"
                    stroke="#ca8a04"
                    strokeWidth="8"
                    strokeDasharray="12,8"
                  />
                </svg>

                {/* Render Dynamic Nodes returned by Backend */}
                <div className="nodes-layer">
                  {visibleItems.length === 0 && (
                    <div className="empty-nodes-msg">No items available for this level.</div>
                  )}

                  {visibleItems.map((item, idx) => {
                    let nodeNumber = idx + 1 + pageIndex * ITEMS_PER_PAGE;
                    let nodeLabel = "";
                    let isUnlocked = true;
                    let isCompleted = false;
                    let onClickHandler = () => {};

                    if (mapStage === "UNITS") {
                      nodeNumber = item.unitNumber || idx + 1;
                      const rawName = item.unitName || `Unit ${nodeNumber}`;
                      nodeLabel = rawName.includes("–") ? rawName.split("–")[0].trim() : rawName;
                      isUnlocked = nodeNumber <= (gameData?.currentChapter ? Math.ceil(gameData.currentChapter / 3) : 1);
                      isCompleted = nodeNumber < (gameData?.currentChapter ? Math.ceil(gameData.currentChapter / 3) : 1);
                      onClickHandler = () => isUnlocked && handleUnitClick(item);
                    } else if (mapStage === "CHAPTERS") {
                      nodeLabel = `${selectedUnit?.unitNumber || 1}.${item.chapterNumber || idx + 1}`;
                      isUnlocked = item.unlocked || item.chapterNumber <= (gameData?.currentChapter ?? 1);
                      isCompleted = item.chapterNumber < (gameData?.currentChapter ?? 1);
                      onClickHandler = () => isUnlocked && handleChapterClick(item);
                    } else if (mapStage === "MISSIONS") {
                      nodeNumber = item.missionNumber || idx + 1;
                      nodeLabel = `Mission ${nodeNumber}`;
                      isUnlocked =
                        selectedChapter?.chapterNumber < (gameData?.currentChapter ?? 1) ||
                        (selectedChapter?.chapterNumber === (gameData?.currentChapter ?? 1) &&
                          nodeNumber <= (gameData?.currentMission ?? 1));
                      isCompleted =
                        selectedChapter?.chapterNumber < (gameData?.currentChapter ?? 1) ||
                        (selectedChapter?.chapterNumber === (gameData?.currentChapter ?? 1) &&
                          nodeNumber < (gameData?.currentMission ?? 1));
                      onClickHandler = () => isUnlocked && handleMissionClick(item);
                    }

                    return (
                      <div
                        key={item.id || idx}
                        className={`map-node-anchor node-slot-${idx + 1}`}
                      >
                        {/* 5 Golden Stars on top of COMPLETED missions ONLY */}
                        {mapStage === "MISSIONS" && isCompleted && (
                          <div className="node-stars-row">
                            {[1, 2, 3, 4, 5].map((num) => (
                              <StarIcon key={num} size={14} filled={true} />
                            ))}
                          </div>
                        )}

                        {/* Circular Node Button */}
                        <button
                          className={`circle-node-btn ${!isUnlocked ? "locked" : ""} ${
                            isCompleted ? "completed" : ""
                          } stage-${mapStage.toLowerCase()}`}
                          onClick={onClickHandler}
                          disabled={!isUnlocked}
                        >
                          <span className="node-text">
                            {mapStage === "CHAPTERS"
                              ? `${selectedUnit?.unitNumber || 1}.${item.chapterNumber || idx + 1}`
                              : nodeNumber}
                          </span>

                          {!isUnlocked && (
                            <div className="node-lock-badge">
                              <LockIcon size={18} />
                            </div>
                          )}
                        </button>

                        {/* Node Label Below */}
                        <div className="node-title-badge">
                          <span>{nodeLabel}</span>
                        </div>
                      </div>
                    );
                  })}
                </div>
              </div>

              {/* Bottom Sub-Banner matching Reference Image */}
              <div className="tome-bottom-banner">
                <h4 className="banner-title">{banner.title}</h4>
                <p className="banner-subtitle">{banner.subtitle}</p>
              </div>
            </div>

            {/* Show Right Arrow ONLY if totalPages > 1 and pageIndex < totalPages - 1 */}
            {totalPages > 1 && pageIndex < totalPages - 1 && (
              <button
                className="side-page-arrow arrow-right"
                onClick={() => setPageIndex((p) => Math.min(totalPages - 1, p + 1))}
              >
                <ForwardArrowIcon size={32} />
              </button>
            )}
          </div>
        </div>
      )}

      {/* Teacher Instruction Popup (Dialog) matching Reference Image */}
      {showTeacherPopup && (
        <div className="teacher-popup-backdrop" onClick={() => setShowTeacherPopup(false)}>
          <div className="teacher-popup-card" onClick={(e) => e.stopPropagation()}>
            <div className="teacher-avatar-box">
              <img src={teacherImg} alt="Teacher Adriane" className="teacher-avatar-img" />
            </div>

            <div className="teacher-speech-bubble">
              <p className="speech-text">{getTeacherSpeech()}</p>
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
