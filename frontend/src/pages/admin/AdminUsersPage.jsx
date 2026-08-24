import React, { useEffect, useState } from "react";
import { progressApi } from "../../api/client";
import AdminLayout from "../../components/AdminLayout";
import Loader from "../../components/Loader";

export default function AdminUsersPage() {
  const [progressList, setProgressList] = useState(null);
  const [error, setError] = useState("");

  useEffect(() => {
    progressApi
      .getAll()
      .then((data) => setProgressList(data))
      .catch((err) => setError(err.message));
  }, []);

  return (
    <AdminLayout>
      <div className="admin-page-header">
        <h1>Users & Player Progress</h1>
        <p className="admin-page-sub">Monitor student progress, XP levels, and lives</p>
      </div>

      {error && <div className="error-banner">{error}</div>}
      {!progressList && !error && <Loader label="Fetching user progress..." />}

      {progressList && (
        <div className="admin-table-container">
          <table className="admin-table">
            <thead>
              <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Current Chapter</th>
                <th>Current Mission</th>
                <th>XP</th>
                <th>Lives</th>
                <th>Answered Qs</th>
              </tr>
            </thead>
            <tbody>
              {progressList.length === 0 && (
                <tr>
                  <td colSpan="7" className="text-center">
                    No registered user progress records found.
                  </td>
                </tr>
              )}
              {progressList.map((row) => (
                <tr key={row.id}>
                  <td>#{row.id}</td>
                  <td>
                    <strong>{row.user?.username ?? "Unlinked User"}</strong>
                  </td>
                  <td>Chapter {row.currentChapter}</td>
                  <td>Mission {row.currentMission}</td>
                  <td>
                    <span className="badge-xp">⚡ {row.xp ?? 0} XP</span>
                  </td>
                  <td>
                    <span className="badge-lives">❤️ {row.lives ?? 3}</span>
                  </td>
                  <td>{row.answeredQuestions ?? 0} / 5</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </AdminLayout>
  );
}
