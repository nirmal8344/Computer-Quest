import React from "react";

export default function Loader({ label = "Loading..." }) {
  return (
    <div className="modern-loader-container">
      <div className="loader-spinner-disc" />
      <span className="loader-label-text">{label}</span>
    </div>
  );
}
