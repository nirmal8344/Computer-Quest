import { Routes, Route, Navigate } from "react-router-dom";
import LoginPage from "./pages/LoginPage.jsx";
import RegisterPage from "./pages/RegisterPage.jsx";
import LobbyPage from "./pages/LobbyPage.jsx";
import MapPage from "./pages/MapPage.jsx";
import MissionPage from "./pages/MissionPage.jsx";
import LeaderboardPage from "./pages/LeaderboardPage.jsx";
import ProfilePage from "./pages/ProfilePage.jsx";
import ProtectedRoute from "./components/ProtectedRoute.jsx";

// Admin Pages
import AdminLoginPage from "./pages/admin/AdminLoginPage.jsx";
import AdminPage from "./pages/admin/AdminPage.jsx";

export default function App() {
  return (
    <div className="app-shell">
      <Routes>
        {/* Player Routes */}
        <Route path="/login" element={<LoginPage />} />
        <Route path="/register" element={<RegisterPage />} />
        <Route
          path="/lobby"
          element={
            <ProtectedRoute>
              <LobbyPage />
            </ProtectedRoute>
          }
        />
        <Route
          path="/map"
          element={
            <ProtectedRoute>
              <MapPage />
            </ProtectedRoute>
          }
        />
        <Route
          path="/mission/:chapterId/:missionNumber"
          element={
            <ProtectedRoute>
              <MissionPage />
            </ProtectedRoute>
          }
        />
        <Route
          path="/leaderboard"
          element={
            <ProtectedRoute>
              <LeaderboardPage />
            </ProtectedRoute>
          }
        />
        <Route
          path="/profile"
          element={
            <ProtectedRoute>
              <ProfilePage />
            </ProtectedRoute>
          }
        />

        {/* Admin Routes (Dashboard removed; defaults to AdminPage) */}
        <Route path="/admin/login" element={<AdminLoginPage />} />
        <Route path="/admin" element={<AdminPage />} />
        <Route path="/admin/classes" element={<AdminPage />} />
        <Route path="/admin/dashboard" element={<Navigate to="/admin" replace />} />
        <Route path="/admin/*" element={<AdminPage />} />

        {/* Fallback */}
        <Route path="/" element={<Navigate to="/login" replace />} />
        <Route path="*" element={<Navigate to="/login" replace />} />
      </Routes>
    </div>
  );
}
