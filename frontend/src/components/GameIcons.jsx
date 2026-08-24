import React from "react";

export function HeartIcon({ filled = true, className = "", size = 24 }) {
  return (
    <svg className={`game-icon-svg ${className}`} viewBox="0 0 24 24" width={size} height={size}>
      <defs>
        <linearGradient id="heartGrad" x1="0%" y1="0%" x2="0%" y2="100%">
          <stop offset="0%" stopColor="#ff6b81" />
          <stop offset="40%" stopColor="#ee5253" />
          <stop offset="100%" stopColor="#b33939" />
        </linearGradient>
        <linearGradient id="heartEmptyGrad" x1="0%" y1="0%" x2="0%" y2="100%">
          <stop offset="0%" stopColor="#64748b" />
          <stop offset="100%" stopColor="#334155" />
        </linearGradient>
        <filter id="heartShadow" x="-20%" y="-20%" width="140%" height="140%">
          <feDropShadow dx="0" dy="2" stdDeviation="1" floodColor="#000000" floodOpacity="0.4" />
        </filter>
      </defs>
      <path
        d="M12 21.35l-1.45-1.32C5.4 15.36 2 12.28 2 8.5 2 5.42 4.42 3 7.5 3c1.74 0 3.41.81 4.5 2.09C13.09 3.81 14.76 3 16.5 3 19.58 3 22 5.42 22 8.5c0 3.78-3.4 6.86-8.55 11.54L12 21.35z"
        fill={filled ? "url(#heartGrad)" : "url(#heartEmptyGrad)"}
        stroke={filled ? "#ffdae0" : "#475569"}
        strokeWidth="1.5"
        filter="url(#heartShadow)"
      />
      {filled && (
        <ellipse cx="8.5" cy="7.5" rx="2.5" ry="1.5" fill="#ffffff" opacity="0.6" transform="rotate(-30 8.5 7.5)" />
      )}
    </svg>
  );
}

export function StarIcon({ className = "", size = 24 }) {
  return (
    <svg className={`game-icon-svg ${className}`} viewBox="0 0 24 24" width={size} height={size}>
      <defs>
        <linearGradient id="starGrad" x1="0%" y1="0%" x2="0%" y2="100%">
          <stop offset="0%" stopColor="#fff066" />
          <stop offset="50%" stopColor="#f59e0b" />
          <stop offset="100%" stopColor="#b45309" />
        </linearGradient>
        <filter id="starGlow">
          <feDropShadow dx="0" dy="2" stdDeviation="1.5" floodColor="#f59e0b" floodOpacity="0.5" />
        </filter>
      </defs>
      <path
        d="M12 2l3.09 6.26L22 9.27l-5 4.87 1.18 6.88L12 17.77l-6.18 3.25L7 14.14 2 9.27l6.91-1.01L12 2z"
        fill="url(#starGrad)"
        stroke="#fef08a"
        strokeWidth="1.5"
        filter="url(#starGlow)"
      />
      <polygon points="12,4 13.5,8 17.5,8.5 14.5,11.5 15,15.5 12,13.5" fill="#ffffff" opacity="0.4" />
    </svg>
  );
}

export function MagicPowerIcon({ className = "", size = 24 }) {
  return (
    <svg className={`game-icon-svg ${className}`} viewBox="0 0 24 24" width={size} height={size}>
      <defs>
        <linearGradient id="boltGrad" x1="0%" y1="0%" x2="0%" y2="100%">
          <stop offset="0%" stopColor="#ffffff" />
          <stop offset="50%" stopColor="#fef08a" />
          <stop offset="100%" stopColor="#eab308" />
        </linearGradient>
      </defs>
      <path
        d="M11 21l1-7H7l7-12-1 7h5l-7 12z"
        fill="url(#boltGrad)"
        stroke="#ca8a04"
        strokeWidth="1.2"
      />
    </svg>
  );
}

export function CoinIcon({ className = "", size = 24 }) {
  return (
    <svg className={`game-icon-svg ${className}`} viewBox="0 0 24 24" width={size} height={size}>
      <defs>
        <linearGradient id="coinGrad" x1="0%" y1="0%" x2="0%" y2="100%">
          <stop offset="0%" stopColor="#fde047" />
          <stop offset="100%" stopColor="#d97706" />
        </linearGradient>
      </defs>
      <circle cx="12" cy="12" r="9" fill="url(#coinGrad)" stroke="#78350f" strokeWidth="1.5" />
      <circle cx="12" cy="12" r="6.5" fill="none" stroke="#fef08a" strokeWidth="1" opacity="0.8" />
      <text x="12" y="15.5" fontSize="10" fontWeight="900" textAnchor="middle" fill="#78350f" fontFamily="sans-serif">
        $
      </text>
    </svg>
  );
}

export function GearIcon({ className = "", size = 22 }) {
  return (
    <svg className={`game-icon-svg ${className}`} viewBox="0 0 24 24" width={size} height={size}>
      <defs>
        <linearGradient id="gearGrad" x1="0%" y1="0%" x2="0%" y2="100%">
          <stop offset="0%" stopColor="#fef08a" />
          <stop offset="100%" stopColor="#d97706" />
        </linearGradient>
      </defs>
      <path
        d="M19.14 12.94c.04-.3.06-.61.06-.94 0-.32-.02-.64-.07-.94l2.03-1.58c.18-.14.23-.41.12-.61l-1.92-3.32c-.12-.22-.37-.29-.59-.22l-2.39.96c-.5-.38-1.03-.7-1.62-.94l-.36-2.54c-.04-.24-.24-.41-.48-.41h-3.84c-.24 0-.43.17-.47.41l-.36 2.54c-.59.24-1.13.57-1.62.94l-2.39-.96c-.22-.08-.47 0-.59.22L2.74 8.87c-.12.21-.08.47.12.61l2.03 1.58c-.05.3-.09.63-.09.94s.02.64.07.94l-2.03 1.58c-.18.14-.23.41-.12.61l1.92 3.32c.12.22.37.29.59.22l2.39-.96c.5.38 1.03.7 1.62.94l.36 2.54c.05.24.24.41.48.41h3.84c.24 0 .44-.17.47-.41l.36-2.54c.59-.24 1.13-.56 1.62-.94l2.39.96c.22.08.47 0 .59-.22l1.92-3.32c.12-.22.07-.47-.12-.61l-2.01-1.58zM12 15.6c-1.98 0-3.6-1.62-3.6-3.6s1.62-3.6 3.6-3.6 3.6 1.62 3.6 3.6-1.62 3.6-3.6-3.6z"
        fill="url(#gearGrad)"
        stroke="#78350f"
        strokeWidth="1"
      />
    </svg>
  );
}

export function LockIcon({ className = "", size = 20 }) {
  return (
    <svg className={`game-icon-svg ${className}`} viewBox="0 0 24 24" width={size} height={size}>
      <defs>
        <linearGradient id="lockGrad" x1="0%" y1="0%" x2="0%" y2="100%">
          <stop offset="0%" stopColor="#fde047" />
          <stop offset="100%" stopColor="#ca8a04" />
        </linearGradient>
      </defs>
      <path
        d="M18 8h-1V6c0-2.76-2.24-5-5-5S7 3.24 7 6v2H6c-1.1 0-2 .9-2 2v10c0 1.1.9 2 2 2h12c1.1 0 2-.9 2-2V10c0-1.1-.9-2-2-2zm-6 9c-1.1 0-2-.9-2-2s.9-2 2-2 2 .9 2 2-.9 2-2 2zm3.1-9H8.9V6c0-1.71 1.39-3.1 3.1-3.1 1.71 0 3.1 1.39 3.1 3.1v2z"
        fill="url(#lockGrad)"
        stroke="#78350f"
        strokeWidth="1"
      />
    </svg>
  );
}

export function CheckIcon({ className = "", size = 20 }) {
  return (
    <svg className={`game-icon-svg ${className}`} viewBox="0 0 24 24" width={size} height={size}>
      <circle cx="12" cy="12" r="10" fill="#22c55e" stroke="#15803d" strokeWidth="1.5" />
      <path d="M9 16.17L4.83 12l-1.42 1.41L9 19 21 7l-1.41-1.41z" fill="#ffffff" />
    </svg>
  );
}

export function BackArrowIcon({ className = "", size = 22 }) {
  return (
    <svg className={`game-icon-svg ${className}`} viewBox="0 0 24 24" width={size} height={size}>
      <circle cx="12" cy="12" r="10" fill="#f59e0b" stroke="#78350f" strokeWidth="1.5" />
      <path d="M15 18l-6-6 6-6" fill="none" stroke="#ffffff" strokeWidth="3" strokeLinecap="round" strokeLinejoin="round" />
    </svg>
  );
}

export function ForwardArrowIcon({ className = "", size = 22 }) {
  return (
    <svg className={`game-icon-svg ${className}`} viewBox="0 0 24 24" width={size} height={size}>
      <circle cx="12" cy="12" r="10" fill="#f59e0b" stroke="#78350f" strokeWidth="1.5" />
      <path d="M9 6l6 6-6 6" fill="none" stroke="#ffffff" strokeWidth="3" strokeLinecap="round" strokeLinejoin="round" />
    </svg>
  );
}

export function TrophyIcon({ className = "", size = 32 }) {
  return (
    <svg className={`game-icon-svg ${className}`} viewBox="0 0 24 24" width={size} height={size}>
      <defs>
        <linearGradient id="trophyGrad" x1="0%" y1="0%" x2="0%" y2="100%">
          <stop offset="0%" stopColor="#fef08a" />
          <stop offset="50%" stopColor="#eab308" />
          <stop offset="100%" stopColor="#a16207" />
        </linearGradient>
      </defs>
      <path
        d="M19 5h-2V3H7v2H5c-1.1 0-2 .9-2 2v1c0 2.55 1.92 4.63 4.39 4.94A5.01 5.01 0 0011 15.9V18H8v2h8v-2h-3v-2.1c1.86-.4 3.32-1.87 3.61-3.74C19.08 11.63 21 9.55 21 7V5c0-1.1-.9-2-2-2zM5 8V7h2v3.82C5.84 10.4 5 9.3 5 8zm14 0c0 1.3-.84 2.4-2 2.82V7h2v1z"
        fill="url(#trophyGrad)"
        stroke="#78350f"
        strokeWidth="1"
      />
    </svg>
  );
}

export function FailedIcon({ className = "", size = 32 }) {
  return (
    <svg className={`game-icon-svg ${className}`} viewBox="0 0 24 24" width={size} height={size}>
      <circle cx="12" cy="12" r="10" fill="#ef4444" stroke="#7f1d1d" strokeWidth="1.5" />
      <path d="M15 9l-6 6M9 9l6 6" fill="none" stroke="#ffffff" strokeWidth="3" strokeLinecap="round" />
    </svg>
  );
}

export function DailyPuzzleIcon({ className = "", size = 36 }) {
  return (
    <svg className={`game-icon-svg ${className}`} viewBox="0 0 36 36" width={size} height={size}>
      <circle cx="18" cy="18" r="16" fill="#a855f7" stroke="#581c87" strokeWidth="2" />
      <rect x="11" y="11" width="14" height="14" rx="3" fill="#f472b6" />
      <circle cx="18" cy="11" r="3" fill="#a855f7" />
      <circle cx="25" cy="18" r="3" fill="#a855f7" />
    </svg>
  );
}

export function GiftBagIcon({ className = "", size = 36 }) {
  return (
    <svg className={`game-icon-svg ${className}`} viewBox="0 0 36 36" width={size} height={size}>
      <path d="M10 14h16v16a3 3 0 01-3 3H13a3 3 0 01-3-3V14z" fill="#d97706" stroke="#78350f" strokeWidth="2" />
      <path d="M12 14c0-4 3-7 6-7s6 3 6 7" fill="none" stroke="#fbbf24" strokeWidth="3" />
      <rect x="16" y="20" width="4" height="6" fill="#fef08a" />
    </svg>
  );
}

export function FreeHintsIcon({ className = "", size = 36 }) {
  return (
    <svg className={`game-icon-svg ${className}`} viewBox="0 0 36 36" width={size} height={size}>
      <path d="M8 10a4 4 0 014-4h12a4 4 0 014 4v16a4 4 0 01-4 4H12a4 4 0 01-4-4V10z" fill="#fef08a" stroke="#ca8a04" strokeWidth="2" />
      <line x1="12" y1="14" x2="24" y2="14" stroke="#854d0e" strokeWidth="2" strokeLinecap="round" />
      <line x1="12" y1="19" x2="22" y2="19" stroke="#854d0e" strokeWidth="2" strokeLinecap="round" />
      <line x1="12" y1="24" x2="18" y2="24" stroke="#854d0e" strokeWidth="2" strokeLinecap="round" />
    </svg>
  );
}

export function HintShopIcon({ className = "", size = 36 }) {
  return (
    <svg className={`game-icon-svg ${className}`} viewBox="0 0 36 36" width={size} height={size}>
      <path d="M14 8h8l2 6v14a3 3 0 01-3 3H15a3 3 0 01-3-3V14l2-6z" fill="#06b6d4" stroke="#155e75" strokeWidth="2" />
      <path d="M14 8h8" stroke="#38bdf8" strokeWidth="3" strokeLinecap="round" />
      <circle cx="18" cy="22" r="4" fill="#a5f3fc" opacity="0.7" />
    </svg>
  );
}

export function CloseIcon({ className = "", size = 20 }) {
  return (
    <svg className={`game-icon-svg ${className}`} viewBox="0 0 24 24" width={size} height={size}>
      <circle cx="12" cy="12" r="10" fill="#dc2626" stroke="#7f1d1d" strokeWidth="1.5" />
      <path d="M15 9l-6 6M9 9l6 6" fill="none" stroke="#ffffff" strokeWidth="2.5" strokeLinecap="round" />
    </svg>
  );
}

export function MapIcon({ className = "", size = 24 }) {
  return (
    <svg className={`game-icon-svg ${className}`} viewBox="0 0 24 24" width={size} height={size}>
      <path
        d="M20.5 3l-.16.03L15 5.1 9 3 3.36 4.9c-.21.07-.36.25-.36.48V20.5c0 .28.22.5.5.5l.16-.03L9 18.9l6 2.1 5.64-1.9c.21-.07.36-.25.36-.48V3.5c0-.28-.22-.5-.5-.5zM15 19l-6-2.11V5l6 2.11V19z"
        fill="#4ade80"
        stroke="#14532d"
        strokeWidth="1.2"
      />
    </svg>
  );
}

export function ProfileIcon({ className = "", size = 24 }) {
  return (
    <svg className={`game-icon-svg ${className}`} viewBox="0 0 24 24" width={size} height={size}>
      <path
        d="M12 12c2.21 0 4-1.79 4-4s-1.79-4-4-4-4 1.79-4 4 1.79 4 4 4zm0 2c-2.67 0-8 1.34-8 4v2h16v-2c0-2.66-5.33-4-8-4z"
        fill="#38bdf8"
        stroke="#075985"
        strokeWidth="1.2"
      />
    </svg>
  );
}

export function SchoolIcon({ className = "", size = 20 }) {
  return (
    <svg className={`game-icon-svg ${className}`} viewBox="0 0 24 24" width={size} height={size}>
      <defs>
        <linearGradient id="schoolGrad" x1="0%" y1="0%" x2="0%" y2="100%">
          <stop offset="0%" stopColor="#fef08a" />
          <stop offset="100%" stopColor="#d97706" />
        </linearGradient>
      </defs>
      <path
        d="M5 13.18v4L12 21l7-3.82v-4L12 17l-7-3.82zM12 3L1 9l11 6 9-4.91V17h2V9L12 3z"
        fill="url(#schoolGrad)"
        stroke="#78350f"
        strokeWidth="1"
      />
    </svg>
  );
}

export function BoyAvatarIcon({ className = "", size = 56 }) {
  return (
    <svg className={`boy-avatar-svg ${className}`} viewBox="0 0 100 100" width={size} height={size}>
      <defs>
        <linearGradient id="avatarBgGrad" x1="0%" y1="0%" x2="100%" y2="100%">
          <stop offset="0%" stopColor="#38bdf8" />
          <stop offset="100%" stopColor="#0284c7" />
        </linearGradient>
        <linearGradient id="shirtGrad" x1="0%" y1="0%" x2="0%" y2="100%">
          <stop offset="0%" stopColor="#0ea5e9" />
          <stop offset="100%" stopColor="#0369a1" />
        </linearGradient>
      </defs>
      {/* Background Circle */}
      <circle cx="50" cy="50" r="48" fill="url(#avatarBgGrad)" stroke="#7dd3fc" strokeWidth="3" />
      {/* Shirt */}
      <path d="M 20 92 C 20 72, 35 68, 50 68 C 65 68, 80 72, 80 92 Z" fill="url(#shirtGrad)" />
      {/* Neck */}
      <rect x="42" y="52" width="16" height="18" fill="#fbcfe8" rx="4" />
      {/* Head */}
      <ellipse cx="50" cy="42" rx="22" ry="24" fill="#fde047" opacity="0.1" />
      <ellipse cx="50" cy="42" rx="20" ry="22" fill="#ffd1a4" />
      {/* Hair */}
      <path d="M 28 38 C 28 20, 40 14, 50 14 C 64 14, 72 20, 72 38 C 72 32, 68 22, 50 22 C 34 22, 28 32, 28 38 Z" fill="#451a03" />
      <path d="M 32 24 Q 45 12 58 20 Q 68 14 70 24 Q 60 18 50 18 Q 40 18 32 24 Z" fill="#78350f" />
      {/* Eyes */}
      <circle cx="42" cy="42" r="3" fill="#1e293b" />
      <circle cx="58" cy="42" r="3" fill="#1e293b" />
      <circle cx="43" cy="41" r="1" fill="#ffffff" />
      <circle cx="59" cy="41" r="1" fill="#ffffff" />
      {/* Smile */}
      <path d="M 43 50 Q 50 56 57 50" fill="none" stroke="#78350f" strokeWidth="2.5" strokeLinecap="round" />
      {/* Rosy Cheeks */}
      <ellipse cx="37" cy="46" rx="3" ry="2" fill="#f43f5e" opacity="0.3" />
      <ellipse cx="63" cy="46" rx="3" ry="2" fill="#f43f5e" opacity="0.3" />
    </svg>
  );
}

export function McqTypeIcon({ size = 28 }) {
  return (
    <svg viewBox="0 0 24 24" width={size} height={size} fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round">
      <rect x="3" y="3" width="18" height="18" rx="4" fill="#fef08a" stroke="#ca8a04" />
      <line x1="7" y1="8" x2="17" y2="8" stroke="#854d0e" strokeWidth="2" />
      <line x1="7" y1="12" x2="17" y2="12" stroke="#854d0e" strokeWidth="2" />
      <line x1="7" y1="16" x2="13" y2="16" stroke="#854d0e" strokeWidth="2" />
    </svg>
  );
}

export function FillBlankTypeIcon({ size = 28 }) {
  return (
    <svg viewBox="0 0 24 24" width={size} height={size} fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round">
      <path d="M12 20h9" stroke="#d97706" strokeWidth="2.5" />
      <path d="M16.5 3.5a2.121 2.121 0 0 1 3 3L7 19l-4 1 1-4L16.5 3.5z" fill="#fef08a" stroke="#b45309" />
    </svg>
  );
}

export function TrueFalseTypeIcon({ size = 28 }) {
  return (
    <svg viewBox="0 0 24 24" width={size} height={size}>
      <circle cx="8" cy="12" r="6" fill="#22c55e" stroke="#15803d" strokeWidth="1.5" />
      <path d="M6 12l1.5 1.5 3-3" stroke="#ffffff" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round" fill="none" />
      <circle cx="16" cy="12" r="6" fill="#ef4444" stroke="#b91c1c" strokeWidth="1.5" />
      <path d="M14 10l4 4m0-4l-4 4" stroke="#ffffff" strokeWidth="2" strokeLinecap="round" fill="none" />
    </svg>
  );
}

export function MatchingTypeIcon({ size = 28 }) {
  return (
    <svg viewBox="0 0 24 24" width={size} height={size}>
      <rect x="4" y="4" width="7" height="7" rx="2" fill="#a855f7" stroke="#6b21a8" strokeWidth="1.5" />
      <rect x="13" y="13" width="7" height="7" rx="2" fill="#38bdf8" stroke="#0284c7" strokeWidth="1.5" />
      <path d="M11 7.5h3.5v5.5" stroke="#f59e0b" strokeWidth="2.5" strokeDasharray="3,3" fill="none" />
    </svg>
  );
}

export function ShortAnswerTypeIcon({ size = 28 }) {
  return (
    <svg viewBox="0 0 24 24" width={size} height={size}>
      <path d="M21 15a2 2 0 0 1-2 2H7l-4 4V5a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2z" fill="#fde047" stroke="#ca8a04" strokeWidth="1.5" />
      <circle cx="9" cy="10" r="1" fill="#78350f" />
      <circle cx="12" cy="10" r="1" fill="#78350f" />
      <circle cx="15" cy="10" r="1" fill="#78350f" />
    </svg>
  );
}


