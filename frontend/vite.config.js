import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";

export default defineConfig({
  plugins: [react()],

  server: {
    port: 5173,
    allowedHosts: ["computer-quest-frontend.onrender.com"],
  },

  preview: {
    allowedHosts: ["computer-quest-frontend.onrender.com"],
  },
});