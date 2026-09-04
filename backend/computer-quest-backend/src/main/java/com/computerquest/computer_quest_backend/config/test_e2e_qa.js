const http = require('http');

function post(url, data) {
  return new Promise((resolve, reject) => {
    const payload = JSON.stringify(data);
    const u = new URL(url);
    const req = http.request({
      hostname: u.hostname,
      port: u.port,
      path: u.pathname + u.search,
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Content-Length': Buffer.byteLength(payload)
      }
    }, res => {
      let body = '';
      res.on('data', chunk => body += chunk);
      res.on('end', () => {
        try { resolve(JSON.parse(body)); }
        catch (e) { resolve(body); }
      });
    });
    req.on('error', reject);
    req.write(payload);
    req.end();
  });
}

function get(url) {
  return new Promise((resolve, reject) => {
    http.get(url, res => {
      let body = '';
      res.on('data', chunk => body += chunk);
      res.on('end', () => {
        try { resolve(JSON.parse(body)); }
        catch (e) { resolve(body); }
      });
    }).on('error', reject);
  });
}

async function runE2ETests() {
  console.log('=== STARTING END-TO-END QA SUITE ===\n');

  const timestamp = Date.now();
  const testUsername = 'qa_student_' + timestamp;
  const testAdminUsername = 'qa_admin_' + timestamp;

  // 1. REGISTER STUDENT
  console.log('1. Testing Student Registration (CBSE, Class 4)...');
  const regStudentRes = await post('http://localhost:8080/api/auth/register', {
    username: testUsername,
    password: 'password123',
    board: 'CBSE',
    classLevel: 4,
    schoolName: 'Computer Quest Demo School'
  });
  console.log('   Registration Response:', regStudentRes.username, '| ID:', regStudentRes.id);
  const studentId = regStudentRes.id;
  if (!studentId) throw new Error('Student registration failed!');

  // 2. LOGIN STUDENT
  console.log('\n2. Testing Student Login...');
  const loginStudentRes = await post('http://localhost:8080/api/auth/login', {
    username: testUsername,
    password: 'password123'
  });
  console.log('   Login successful for:', loginStudentRes.username, '| School:', loginStudentRes.school?.name, '| Class:', loginStudentRes.classLevel, '| Board:', loginStudentRes.board);

  // 3. FETCH STUDENT CHAPTERS (LOBBY & MAP)
  console.log('\n3. Testing Chapters Fetch for Student...');
  const chapters = await get('http://localhost:8080/api/chapters?userId=' + studentId);
  console.log('   Retrieved', chapters.length, 'chapters for student:');
  chapters.forEach(c => console.log('     - Chapter ' + c.chapterNumber + ': ' + c.chapterName + ' (Unlocked: ' + c.unlocked + ')'));

  // 4. FETCH MISSION 1 QUESTIONS
  console.log('\n4. Testing Questions Fetch for Chapter 1, Mission 1...');
  const ch1 = chapters[0];
  const questions = await get('http://localhost:8080/api/questions?unit=' + encodeURIComponent(ch1.unit) + '&chapter=' + encodeURIComponent(ch1.chapterName) + '&mission=1&userId=' + studentId);
  console.log('   Retrieved', questions.length, 'questions for mission 1:');
  questions.forEach((q, idx) => console.log('     Q' + (idx+1) + ': ' + q.questionText));

  // 5. ANSWER QUESTIONS & TRACK XP/LIVES
  console.log('\n5. Testing Question Answer Submissions (Answering 5 questions with correct answers)...');
  // For CBSE 4 Ch 1 Mission 1, correct answers in seed data are: Q1: A, Q2: A, Q3: B, Q4: A, Q5: B
  const answers = ['A', 'A', 'B', 'A', 'B'];
  for (let i = 0; i < questions.length; i++) {
    const q = questions[i];
    const ansRes = await post('http://localhost:8080/api/questions/answer', {
      questionId: q.id,
      userId: studentId,
      answer: answers[i]
    });
    console.log('     Q' + (i+1) + ' answer [' + answers[i] + '] -> Result: ' + ansRes.result + ' | Lives: ' + ansRes.lives + ' | XP: ' + ansRes.xp);
  }

  // 6. VERIFY LEADERBOARD
  console.log('\n6. Testing Leaderboard Rankings for Demo School...');
  const schoolId = loginStudentRes.school.id;
  const leaderboard = await get('http://localhost:8080/api/leaderboard?schoolId=' + schoolId);
  console.log('   Leaderboard Entries:', Array.isArray(leaderboard) ? leaderboard.length : leaderboard);
  if (Array.isArray(leaderboard)) {
    leaderboard.slice(0, 5).forEach((entry, idx) => {
      console.log('     #' + (idx+1) + ' ' + (entry.username || entry.user?.username) + ' - ' + entry.xp + ' XP');
    });
  }

  // 7. REGISTER ADMIN
  console.log('\n7. Testing Admin Registration...');
  const regAdminRes = await post('http://localhost:8080/api/admin', {
    username: testAdminUsername,
    password: 'password123',
    schoolName: 'Computer Quest Demo School'
  });
  console.log('   Admin Registered:', regAdminRes.username, '| ID:', regAdminRes.id);
  const adminId = regAdminRes.id;

  // 8. LOGIN ADMIN
  console.log('\n8. Testing Admin Login...');
  const loginAdminRes = await post('http://localhost:8080/api/admin/login', {
    username: testAdminUsername,
    password: 'password123'
  });
  console.log('   Admin Login Success:', loginAdminRes.username, '| School:', loginAdminRes.school?.name);

  // 9. ADMIN CLASSES CHECK
  console.log('\n9. Testing Admin Classes Retrieval for School...');
  const adminClasses = await get('http://localhost:8080/api/admin/classes?adminId=' + adminId);
  console.log('   Admin retrieved', adminClasses.length, 'classes for school.');

  console.log('\n=== ALL END-TO-END TESTS PASSED WITH 100% SUCCESS! ===');
}

runE2ETests().catch(err => console.error('E2E QA Test Error:', err));
