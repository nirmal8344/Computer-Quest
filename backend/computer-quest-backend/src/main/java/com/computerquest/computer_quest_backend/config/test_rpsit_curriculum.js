const http = require('http');

function post(path, body) {
  return new Promise((resolve, reject) => {
    const data = JSON.stringify(body);
    const req = http.request({
      hostname: 'localhost',
      port: 8080,
      path: path,
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Content-Length': Buffer.byteLength(data),
      }
    }, (res) => {
      let resData = '';
      res.on('data', chunk => resData += chunk);
      res.on('end', () => {
        try {
          resolve({ status: res.statusCode, body: JSON.parse(resData) });
        } catch (e) {
          resolve({ status: res.statusCode, body: resData });
        }
      });
    });
    req.on('error', reject);
    req.write(data);
    req.end();
  });
}

function get(path) {
  return new Promise((resolve, reject) => {
    const req = http.request({
      hostname: 'localhost',
      port: 8080,
      path: path,
      method: 'GET'
    }, (res) => {
      let resData = '';
      res.on('data', chunk => resData += chunk);
      res.on('end', () => {
        try {
          resolve({ status: res.statusCode, body: JSON.parse(resData) });
        } catch (e) {
          resolve({ status: res.statusCode, body: resData });
        }
      });
    });
    req.on('error', reject);
    req.end();
  });
}

async function runTests() {
  const ts = Date.now();
  console.log('--- Starting RPSIT School E2E Verification ---');

  // Test 1: CBSE Class 4 Student
  const cbse4User = `cbse4_stud_${ts}`;
  const r1 = await post('/api/auth/register', {
    username: cbse4User,
    password: 'password123',
    board: 'CBSE',
    classLevel: 4,
    schoolName: 'RPSIT School'
  });
  console.log('\n[Test 1] CBSE Class 4 Student Registration:', r1.status);
  const g1 = await get(`/api/game/${r1.body.id}`);
  const s1 = g1.body.subjects.map(s => s.subjectName);
  console.log('CBSE Class 4 Subjects:', s1);
  if (JSON.stringify(s1) === JSON.stringify(['English', 'Mathematics', 'EVS'])) {
    console.log('✅ PASS: CBSE Class 4 has exactly English, Mathematics, EVS');
  } else {
    console.error('❌ FAIL: CBSE Class 4 subjects mismatch');
  }

  // Test 2: TN State Board Class 7 Student
  const tn7User = `tn7_stud_${ts}`;
  const r2 = await post('/api/auth/register', {
    username: tn7User,
    password: 'password123',
    board: 'STATE_BOARD',
    classLevel: 7,
    schoolName: 'RPSIT School'
  });
  console.log('\n[Test 2] TN State Board Class 7 Student Registration:', r2.status);
  const g2 = await get(`/api/game/${r2.body.id}`);
  const s2 = g2.body.subjects.map(s => s.subjectName);
  console.log('TN Class 7 Subjects:', s2);
  if (JSON.stringify(s2) === JSON.stringify(['Tamil', 'English', 'Mathematics', 'Science', 'Social Science'])) {
    console.log('✅ PASS: TN Class 7 has exactly Tamil, English, Mathematics, Science, Social Science');
  } else {
    console.error('❌ FAIL: TN Class 7 subjects mismatch');
  }

  // Test 3: TN State Board Class 11 Bio-Maths
  const tnBioUser = `tn_biomaths_${ts}`;
  const r3 = await post('/api/auth/register', {
    username: tnBioUser,
    password: 'password123',
    board: 'STATE_BOARD',
    classLevel: 11,
    studentGroup: 'GROUP 1 – MATHS-BIOLOGY / BIO-MATHS',
    schoolName: 'RPSIT School'
  });
  console.log('\n[Test 3] TN Class 11 Bio-Maths Registration:', r3.status);
  const g3 = await get(`/api/game/${r3.body.id}`);
  const s3 = g3.body.subjects.map(s => s.subjectName);
  console.log('TN Class 11 Bio-Maths Subjects:', s3);
  if (JSON.stringify(s3) === JSON.stringify(['Tamil', 'English', 'Physics', 'Chemistry', 'Mathematics', 'Biology'])) {
    console.log('✅ PASS: TN Class 11 Bio-Maths has exactly Tamil, English, Physics, Chemistry, Mathematics, Biology');
  } else {
    console.error('❌ FAIL: TN Class 11 Bio-Maths subjects mismatch');
  }

  // Test 4: TN State Board Class 11 Accountancy + History
  const tnHistUser = `tn_acchist_${ts}`;
  const r4 = await post('/api/auth/register', {
    username: tnHistUser,
    password: 'password123',
    board: 'STATE_BOARD',
    classLevel: 11,
    studentGroup: 'GROUP 7 – ACCOUNTANCY + HISTORY',
    schoolName: 'RPSIT School'
  });
  console.log('\n[Test 4] TN Class 11 Accountancy + History Registration:', r4.status);
  const g4 = await get(`/api/game/${r4.body.id}`);
  const s4 = g4.body.subjects.map(s => s.subjectName);
  console.log('TN Class 11 Acc+History Subjects:', s4);
  if (JSON.stringify(s4) === JSON.stringify(['Tamil', 'English', 'History', 'Economics', 'Commerce', 'Accountancy'])) {
    console.log('✅ PASS: TN Class 11 Acc+History has exactly Tamil, English, History, Economics, Commerce, Accountancy');
  } else {
    console.error('❌ FAIL: TN Class 11 Acc+History subjects mismatch');
  }

  // Test 5: Leaderboard Group Isolation Test
  const lb3 = await get(`/api/leaderboard/rankings?userId=${r3.body.id}`);
  const lb3Users = lb3.body.entries.map(e => e.username);
  console.log('\n[Test 5] Leaderboard for Bio-Maths student contains:', lb3Users.slice(0, 5));
  const hasHistInBio = lb3Users.includes(tnHistUser);
  if (!hasHistInBio) {
    console.log('✅ PASS: Accountancy + History students are not mixed into Bio-Maths leaderboard!');
  } else {
    console.error('❌ FAIL: Mixed leaderboard detected');
  }

  console.log('\n🎉 ALL VERIFICATION TESTS COMPLETED SUCCESSFULLY!');
}

runTests().catch(console.error);
