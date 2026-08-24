# Computer Quest — Frontend

React + Vite frontend for the existing Computer Quest Spring Boot backend.
Every API call maps 1:1 to a controller that already exists in the backend —
see `src/api/client.js` for the full list; nothing was invented.

## 1. Backend change (one small, additive file)

Copy `backend-cors-fix/CorsConfig.java` into:

```
src/main/java/com/computerquest/computer_quest_backend/config/CorsConfig.java
```

This is the only backend change made — it enables CORS globally (several
controllers were missing `@CrossOrigin`, which would otherwise block login,
register, chapters, missions, game state, and question calls from the
frontend). It doesn't touch any existing logic.

If your frontend runs somewhere other than `http://localhost:5173`, update
`allowedOrigins(...)` in that file.

## 2. Run the frontend

```bash
npm install
cp .env.example .env   # edit VITE_API_BASE_URL if your backend isn't on :8080
npm run dev
```

Opens at `http://localhost:5173`.

## Known backend gaps (see full analysis in chat)

- **No PlayerProgress row is created on registration.** The frontend
  bootstraps one immediately after a successful `POST /api/auth/register`,
  via `POST /api/progress` + `PUT /api/progress/{id}/user/{userId}`, with
  chapter 1 / mission 1 / 3 lives / 0 xp.
- **`GET /api/questions` returns `correctAnswer`** in the JSON payload. The
  frontend strips it out of local state before rendering so it's never shown
  on screen, but it is still visible in the raw network response — that can
  only be fixed on the backend.
- **No auth token/session.** The frontend stores the `User` object returned
  by login/register in `localStorage` and passes `userId` in the URL for
  subsequent calls, since that's what the backend expects. There's nothing
  stopping someone from calling another user's endpoints directly.
- **Answer format assumption:** the frontend submits the selected option's
  letter (`A`/`B`/`C`/`D`) as the `answer` value to `POST /api/questions/answer`,
  matching the `optionA..D` / `correctAnswer` naming convention. If your
  seeded `correctAnswer` values are stored as full option text instead of a
  letter, answers will always come back wrong — worth checking your question
  data.
- **`Question.chapter` is a free-text string**, matched against
  `Chapter.chapterName` by the frontend when loading a mission's questions.
  Nothing in the backend enforces that these strings stay in sync — keep
  question data's `chapter` field spelled exactly like the chapter's name.

## Pages

- `/login`, `/register` — auth
- `/lobby` — home screen (`GET /api/game/{userId}`)
- `/map` — chapters + missions (`GET /api/chapters`, `GET /api/missions`)
- `/mission/:chapterId/:missionNumber` — quiz play (`GET /api/questions`,
  `POST /api/questions/answer`)
- `/leaderboard` — `GET /api/leaderboard`
- `/profile` — `GET /api/profile/{userId}`
