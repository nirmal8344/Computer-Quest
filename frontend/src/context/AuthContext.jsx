import { createContext, useContext, useState, useCallback } from "react";
import { authApi, progressApi, adminApi } from "../api/client";

const AuthContext = createContext(null);
const STORAGE_KEY = "cq_user";
const ADMIN_STORAGE_KEY = "cq_admin";

export function AuthProvider({ children }) {
  const [user, setUser] = useState(() => {
    const raw = localStorage.getItem(STORAGE_KEY);
    return raw ? JSON.parse(raw) : null;
  });

  const [adminUser, setAdminUser] = useState(() => {
    const raw = localStorage.getItem(ADMIN_STORAGE_KEY);
    return raw ? JSON.parse(raw) : null;
  });

  const persist = (u) => {
    setUser(u);
    if (u) localStorage.setItem(STORAGE_KEY, JSON.stringify(u));
    else localStorage.removeItem(STORAGE_KEY);
  };

  const persistAdmin = (a) => {
    setAdminUser(a);
    if (a) localStorage.setItem(ADMIN_STORAGE_KEY, JSON.stringify(a));
    else localStorage.removeItem(ADMIN_STORAGE_KEY);
  };

  const login = useCallback(async (username, password) => {
    const result = await authApi.login(username, password);
    if (!result || !result.id) {
      throw new Error("Invalid username or password.");
    }
    persist(result);
    return result;
  }, []);

  const register = useCallback(async ({ username, password, classLevel, board, schoolId, schoolName }) => {
    const payload = {
      username,
      password,
      role: "STUDENT",
      classLevel,
      board,
    };

    // Attach school info — prefer existing schoolId; fall back to schoolName for new schools
    if (schoolId) {
      payload.schoolId = schoolId;
    } else if (schoolName) {
      payload.schoolName = schoolName;
    }

    const newUser = await authApi.register(payload);
    persist(newUser);
    return newUser;
  }, []);

  const adminLogin = useCallback(async (username, password) => {
    const result = await adminApi.login(username, password);
    if (!result || !result.id) {
      throw new Error("Invalid admin credentials.");
    }
    persistAdmin(result);
    return result;
  }, []);

  const registerAdmin = useCallback(async ({ username, password, schoolId, schoolName }) => {
    const payload = { username, password };
    if (schoolId) payload.schoolId = schoolId;
    else if (schoolName) payload.schoolName = schoolName;

    const newAdmin = await adminApi.createAdmin(payload);
    persistAdmin(newAdmin);
    return newAdmin;
  }, []);

  const logout = useCallback(() => persist(null), []);
  const adminLogout = useCallback(() => persistAdmin(null), []);

  return (
    <AuthContext.Provider
      value={{
        user,
        adminUser,
        login,
        register,
        registerAdmin,
        logout,
        adminLogin,
        adminLogout,
      }}
    >
      {children}
    </AuthContext.Provider>
  );
}


export function useAuth() {
  const ctx = useContext(AuthContext);
  if (!ctx) throw new Error("useAuth must be used within AuthProvider");
  return ctx;
}
