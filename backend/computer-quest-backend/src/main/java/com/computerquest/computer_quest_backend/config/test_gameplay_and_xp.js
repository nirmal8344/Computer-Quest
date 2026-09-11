const http = require('http');

function request(method, path, body = null) {
  return new Promise((resolve, reject) => {
    const data = body ? JSON.stringify(body) : null;
    const req = http.request({
      hostname: 'localhost',
      port: 8080,
      path: path,
      method: method,
      headers: {
        'Content-Type': 'application/json',
        ...(data ? { 'Content-Length': Buffer.byteLength(data) } : {})
      }
    }, (res) => {
      let resBody = '';
      res.on('data', (chunk) => resBody += chunk);
      res.on('end', () => {
        try {
          const parsed = resBody ? JSON.parse(resBody) : null;
          resolve({ status: res.statusCode, body: parsed });
        } catch (e) {
          resolve({ status: res.statusCode, body: resBody });
        }
      });
    });

    req.on('error', reject);
    if (data) req.write(data);
    req.end();
  });
}

async function testGameplay() {
  const ts = Date.now();
  console.log("=== Testing Student Gameplay, XP & Leaderboard Progression ===");

  // 1. Register Student
  const regRes = await request('POST', '/api/auth/register', {
    username: `gamer_student_${ts}`,
    password: 'password123',
    board: 'CBSE',
    classLevel: 6,
    schoolName: 'RPSIT School'
  });
  const student = regRes.body;
  console.log("Registered gamer student:", student.username, "School ID:", student.school?.id);

  // 2. Fetch Chapters for Class 6 Science
  const chapRes = await request('GET', `/api/chapters?board=CBSE&classLevel=6&subject=Science`);
  const firstChap = chapRes.body[0];
  console.log(`Fetched first chapter: Unit="${firstChap.unit}", Chapter="${firstChap.chapterName}"`);

  // Fetch Questions for Mission 1
  const qRes = await request('GET', `/api/questions?unit=${encodeURIComponent(firstChap.unit)}&chapter=${encodeURIComponent(firstChap.chapterName)}&mission=1&userId=${student.id}&subject=Science`);
  console.log(`Fetched ${qRes.body.length} questions for Mission 1`);

  // 3. Answer questions 1 through 5 correctly
  for (let i = 0; i < Math.min(5, qRes.body.length); i++) {
    const q = qRes.body[i];
    const ansRes = await request('POST', '/api/questions/answer', {
      questionId: q.id,
      userId: student.id,
      answer: q.correctAnswer,
      subject: "Science"
    });
    console.log(`Question ${i + 1} (${q.correctAnswer.substring(0, 20)}...): result = ${ansRes.body.result}, lives = ${ansRes.body.lives}, xp = ${ansRes.body.xp}, totalXp = ${ansRes.body.totalXp}`);
  }

  // 4. Fetch updated leaderboard
  const lbRes = await request('GET', `/api/leaderboard?schoolId=${student.school?.id}&board=CBSE&classLevel=6&userId=${student.id}`);
  console.log("\nUpdated Class 6 CBSE Leaderboard for RPSIT School:");
  console.log("Current user rank:", lbRes.body.currentUserRank, "Current user XP:", lbRes.body.currentUserXp);
  console.log("Top Rankings:", lbRes.body.rankings.map(r => `#${r.rank} ${r.username} (${r.xp} XP)`));
}

testGameplay().catch(console.error);
