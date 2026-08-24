// Web Speech API utility for female teacher voice instructions

let voicesCache = [];

function loadVoices() {
  if (typeof window !== "undefined" && "speechSynthesis" in window) {
    voicesCache = window.speechSynthesis.getVoices();
  }
}

if (typeof window !== "undefined" && "speechSynthesis" in window) {
  loadVoices();
  if (window.speechSynthesis.onvoiceschanged !== undefined) {
    window.speechSynthesis.onvoiceschanged = loadVoices;
  }
}

export function speakTeacherInstruction(text) {
  if (typeof window === "undefined" || !("speechSynthesis" in window)) return;

  try {
    window.speechSynthesis.cancel(); // Stop any ongoing speech

    const utterance = new SpeechSynthesisUtterance(text);
    utterance.rate = 0.95; // Slightly natural pace
    utterance.pitch = 1.15; // Slightly higher pitch for female teacher tone

    if (voicesCache.length === 0) {
      voicesCache = window.speechSynthesis.getVoices();
    }

    // Try to find a female English voice
    const femaleVoice = voicesCache.find(
      (v) =>
        v.lang.startsWith("en") &&
        (v.name.includes("Female") ||
          v.name.includes("Zira") ||
          v.name.includes("Samantha") ||
          v.name.includes("Victoria") ||
          v.name.includes("Google US English") ||
          v.name.includes("Karen") ||
          v.name.includes("Fiona") ||
          v.name.includes("Jenny") ||
          v.name.includes("Aria"))
    );

    if (femaleVoice) {
      utterance.voice = femaleVoice;
    }

    window.speechSynthesis.speak(utterance);
  } catch (err) {
    console.warn("Speech synthesis error:", err);
  }
}

export function stopTeacherInstruction() {
  if (typeof window !== "undefined" && "speechSynthesis" in window) {
    window.speechSynthesis.cancel();
  }
}
