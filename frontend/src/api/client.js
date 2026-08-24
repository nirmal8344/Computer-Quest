// Thin fetch wrapper mapped 1:1 to the existing Spring Boot endpoints.

const BASE_URL = import.meta.env.VITE_API_BASE_URL || "http://localhost:8080";

async function request(path, options = {}) {
  const res = await fetch(`${BASE_URL}${path}`, {
    headers: { "Content-Type": "application/json" },
    ...options,
  });

  const contentType = res.headers.get("content-type") || "";
  const isJson = contentType.includes("application/json");
  const body = isJson ? await res.json().catch(() => null) : await res.text();

  if (!res.ok) {
    const message =
      (isJson && body && (body.message || body.error)) ||
      (typeof body === "string" && body) ||
      `Request failed (${res.status})`;
    throw new Error(message);
  }

  return body;
}

// ----- Auth (/api/auth) -----
export const authApi = {
  register: (user) =>
    request("/api/auth/register", { method: "POST", body: JSON.stringify(user) }),
  login: (username, password) =>
    request("/api/auth/login", {
      method: "POST",
      body: JSON.stringify({ username, password }),
    }),
};

// ----- Schools (/api/schools) -----
export const schoolApi = {
  getAll: () => request("/api/schools"),
};

// ----- Game (/api/game) -----
export const gameApi = {
  getGameData: (userId) => request(`/api/game/${userId}`),
};

// ----- Profile (/api/profile) -----
export const profileApi = {
  getProfile: (userId) => request(`/api/profile/${userId}`),
};

// ----- Units (/api/admin/units) -----
export const unitApi = {
  getUnits: (params = {}) => {
    const query = new URLSearchParams(params).toString();
    return request(`/api/admin/units${query ? `?${query}` : ""}`);
  },
  createUnit: (unit) =>
    request("/api/admin/units", { method: "POST", body: JSON.stringify(unit) }),
  updateUnit: (id, unit) =>
    request(`/api/admin/units/${id}`, { method: "PUT", body: JSON.stringify(unit) }),
  deleteUnit: (id) =>
    request(`/api/admin/units/${id}`, { method: "DELETE" }),
};

// ----- Chapters (/api/chapters) -----
export const chapterApi = {
  getAll: (params = {}) => {
    const query = new URLSearchParams(params).toString();
    return request(`/api/chapters${query ? `?${query}` : ""}`);
  },
  createChapter: (chapter) =>
    request("/api/chapters", { method: "POST", body: JSON.stringify(chapter) }),
  updateChapter: (id, chapter) =>
    request(`/api/chapters/${id}`, { method: "PUT", body: JSON.stringify(chapter) }),
  deleteChapter: (id) =>
    request(`/api/chapters/${id}`, { method: "DELETE" }),
};

// ----- Missions (/api/missions) -----
export const missionApi = {
  getAll: (params = {}) => {
    const query = new URLSearchParams(params).toString();
    return request(`/api/missions${query ? `?${query}` : ""}`);
  },
  createMission: (mission) =>
    request("/api/missions", { method: "POST", body: JSON.stringify(mission) }),
  updateMission: (id, mission) =>
    request(`/api/missions/${id}`, { method: "PUT", body: JSON.stringify(mission) }),
  deleteMission: (id) =>
    request(`/api/missions/${id}`, { method: "DELETE" }),
};

// ----- Questions (/api/questions) -----
export const questionApi = {
  getForMission: (unit, chapter, mission, params = {}) => {
    const searchParams = new URLSearchParams({
      unit: unit || "",
      chapter: chapter || "",
      mission: mission || "",
      ...params,
    });
    return request(`/api/questions?${searchParams.toString()}`);
  },
  submitAnswer: (questionId, userId, answer) =>
    request("/api/questions/answer", {
      method: "POST",
      body: JSON.stringify({ questionId, userId, answer }),
    }),
  createQuestion: (question) =>
    request("/api/questions", { method: "POST", body: JSON.stringify(question) }),
  updateQuestion: (id, question) =>
    request(`/api/questions/${id}`, { method: "PUT", body: JSON.stringify(question) }),
  deleteQuestion: (id) =>
    request(`/api/questions/${id}`, { method: "DELETE" }),
};

// ----- Leaderboard (/api/leaderboard) -----
export const leaderboardApi = {
  getLeaderboard: (params = {}) => {
    const query = new URLSearchParams(params).toString();
    return request(`/api/leaderboard${query ? `?${query}` : ""}`);
  },
};

// ----- Player progress (/api/progress) -----
export const progressApi = {
  getAll: () => request("/api/progress"),
  create: (progress) =>
    request("/api/progress", { method: "POST", body: JSON.stringify(progress) }),
  linkUser: (progressId, userId) =>
    request(`/api/progress/${progressId}/user/${userId}`, { method: "PUT" }),
};

// ----- Admin Classes (/api/admin/classes) -----
export const classApi = {
  getClasses: (params = {}) => {
    const query = new URLSearchParams(params).toString();
    return request(`/api/admin/classes${query ? `?${query}` : ""}`);
  },
  createClass: (schoolClass) =>
    request("/api/admin/classes", { method: "POST", body: JSON.stringify(schoolClass) }),
  updateClass: (id, schoolClass) =>
    request(`/api/admin/classes/${id}`, { method: "PUT", body: JSON.stringify(schoolClass) }),
  deleteClass: (id) =>
    request(`/api/admin/classes/${id}`, { method: "DELETE" }),
};

// ----- Admin Combined Object -----
export const adminApi = {
  createAdmin: (admin) =>
    request("/api/admin", { method: "POST", body: JSON.stringify(admin) }),
  login: (username, password) =>
    request("/api/admin/login", {
      method: "POST",
      body: JSON.stringify({ username, password }),
    }),
  getClasses: classApi.getClasses,
  createClass: classApi.createClass,
  updateClass: classApi.updateClass,
  deleteClass: classApi.deleteClass,

  getUnits: unitApi.getUnits,
  createUnit: unitApi.createUnit,
  updateUnit: unitApi.updateUnit,
  deleteUnit: unitApi.deleteUnit,

  getChapters: chapterApi.getAll,
  createChapter: chapterApi.createChapter,
  updateChapter: chapterApi.updateChapter,
  deleteChapter: chapterApi.deleteChapter,

  getMissions: missionApi.getAll,
  createMission: missionApi.createMission,
  updateMission: missionApi.updateMission,
  deleteMission: missionApi.deleteMission,

  getQuestions: questionApi.getForMission,
  createQuestion: questionApi.createQuestion,
  updateQuestion: questionApi.updateQuestion,
  deleteQuestion: questionApi.deleteQuestion,
};
