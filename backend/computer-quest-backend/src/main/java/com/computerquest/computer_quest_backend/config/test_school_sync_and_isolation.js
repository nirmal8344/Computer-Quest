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

async function runTests() {
  console.log("==================================================");
  console.log("   LEARNQUEST FULL MULTI-SCHOOL + CURRICULUM AUDIT");
  console.log("==================================================");

  const timestamp = Date.now();

  // 1. Register School A Admin (CBSE)
  console.log("\n[1] Registering School A CBSE Admin...");
  const adminA_CBSE = await request('POST', '/api/admin', {
    username: `admin_a_cbse_${timestamp}`,
    password: 'password123',
    board: 'CBSE',
    schoolName: 'RPSIT International School'
  });
  console.log("Admin A CBSE:", adminA_CBSE.status, adminA_CBSE.body.username, "School ID:", adminA_CBSE.body.school?.id);
  const schoolAId = adminA_CBSE.body.school?.id;
  const adminAId = adminA_CBSE.body.id;

  // 2. Register School B Admin (CBSE)
  console.log("\n[2] Registering School B CBSE Admin...");
  const adminB_CBSE = await request('POST', '/api/admin', {
    username: `admin_b_cbse_${timestamp}`,
    password: 'password123',
    board: 'CBSE',
    schoolName: 'Greenwood Valley School'
  });
  console.log("Admin B CBSE:", adminB_CBSE.status, adminB_CBSE.body.username, "School ID:", adminB_CBSE.body.school?.id);
  const schoolBId = adminB_CBSE.body.school?.id;
  const adminBId = adminB_CBSE.body.id;

  // 3. Register School A State Board Admin
  console.log("\n[3] Registering School A State Board Admin...");
  const adminA_State = await request('POST', '/api/admin', {
    username: `admin_a_state_${timestamp}`,
    password: 'password123',
    board: 'STATE_BOARD',
    schoolId: schoolAId
  });
  console.log("Admin A State Board:", adminA_State.status, adminA_State.body.username, "Board:", adminA_State.body.board);

  // 4. Register Students
  console.log("\n[4] Registering Students across schools and boards...");
  
  // Student A1: School A, CBSE, Class 8
  const studentA1 = await request('POST', '/api/auth/register', {
    username: `student_a_cbse8_${timestamp}`,
    password: 'password123',
    board: 'CBSE',
    classLevel: 8,
    schoolId: schoolAId
  });
  console.log("Student A1 (School A, CBSE, Class 8):", studentA1.status, studentA1.body.username, "ID:", studentA1.body.id);

  // Student B1: School B, CBSE, Class 8
  const studentB1 = await request('POST', '/api/auth/register', {
    username: `student_b_cbse8_${timestamp}`,
    password: 'password123',
    board: 'CBSE',
    classLevel: 8,
    schoolId: schoolBId
  });
  console.log("Student B1 (School B, CBSE, Class 8):", studentB1.status, studentB1.body.username, "ID:", studentB1.body.id);

  // Student A_State: School A, State Board, Class 8
  const studentA_State = await request('POST', '/api/auth/register', {
    username: `student_a_state8_${timestamp}`,
    password: 'password123',
    board: 'STATE_BOARD',
    classLevel: 8,
    schoolId: schoolAId
  });
  console.log("Student A State (School A, State Board, Class 8):", studentA_State.status, studentA_State.body.username, "ID:", studentA_State.body.id);

  // Student A_Bio: School A, CBSE, Class 11, Group 1
  const studentA_Bio = await request('POST', '/api/auth/register', {
    username: `student_a_bio11_${timestamp}`,
    password: 'password123',
    board: 'CBSE',
    classLevel: 11,
    studentGroup: 'GROUP 1 – MATHS-BIOLOGY / BIO-MATHS',
    schoolId: schoolAId
  });
  console.log("Student A Class 11 Group 1:", studentA_Bio.status, studentA_Bio.body.studentGroup);

  // Student A_CS: School A, CBSE, Class 11, Group 2
  const studentA_CS = await request('POST', '/api/auth/register', {
    username: `student_a_cs11_${timestamp}`,
    password: 'password123',
    board: 'CBSE',
    classLevel: 11,
    studentGroup: 'GROUP 2 – COMPUTER SCIENCE (MATHS-PHYSICS-CHEMISTRY-CS)',
    schoolId: schoolAId
  });
  console.log("Student A Class 11 Group 2:", studentA_CS.status, studentA_CS.body.studentGroup);

  // -------------------------------------------------------------
  // TEST A: School A CBSE Admin queries and creates customized question
  // -------------------------------------------------------------
  console.log("\n==================================================");
  console.log("TEST A: School A CBSE Admin Curriculum Sync");
  console.log("==================================================");
  
  // Get CBSE subjects for Class 8
  const cbse8Subjects = await request('GET', `/api/subjects?board=CBSE&classLevel=8&schoolId=${schoolAId}`);
  console.log("School A CBSE Class 8 Subjects:", cbse8Subjects.body.map(s => s.subjectName).join(', '));
  
  // Get chapters/units for Science
  const chapters = await request('GET', `/api/chapters?board=CBSE&classLevel=8&subject=Science&schoolId=${schoolAId}`);
  const firstChapter = chapters.body[0];
  const testUnitName = firstChapter?.unitName || "Unit 1: Food";
  const testChapterName = firstChapter?.chapterName || "Chapter 1: Crop Production and Management";
  const testMissionNumber = 1;

  console.log(`Testing with Unit: "${testUnitName}", Chapter: "${testChapterName}", Mission: ${testMissionNumber}`);

  // Admin A creates a custom question for School A
  const customQuestionText = `[RPSIT School A Custom Question ${timestamp}] What is crop rotation?`;
  const createdQuestion = await request('POST', '/api/questions', {
    unit: testUnitName,
    chapter: testChapterName,
    mission: testMissionNumber,
    questionText: customQuestionText,
    optionA: "Growing different crops alternately",
    optionB: "Spinning crops in circles",
    optionC: "Watering crops daily",
    optionD: "Burning old crops",
    correctAnswer: "Growing different crops alternately",
    explanation: "Crop rotation improves soil fertility by alternating legumes and cereals.",
    schoolId: schoolAId,
    adminId: adminAId,
    board: "CBSE",
    classLevel: 8,
    subject: "Science"
  });
  console.log("Admin A created custom question:", createdQuestion.status, "ID:", createdQuestion.body.id);

  // Student A1 queries questions for this mission
  const studentA1Questions = await request('GET', `/api/questions?unit=${encodeURIComponent(testUnitName)}&chapter=${encodeURIComponent(testChapterName)}&mission=${testMissionNumber}&userId=${studentA1.body.id}`);
  const studentA1HasQuestion = Array.isArray(studentA1Questions.body) && studentA1Questions.body.some(q => q.questionText === customQuestionText);
  console.log("Student A1 sees Admin A's new question:", studentA1HasQuestion ? "PASSED (YES)" : "FAILED (NO)");

  // -------------------------------------------------------------
  // TEST B: School B Student does NOT see School A's custom question
  // -------------------------------------------------------------
  console.log("\n==================================================");
  console.log("TEST B: School Isolation (School B vs School A)");
  console.log("==================================================");
  const studentB1Questions = await request('GET', `/api/questions?unit=${encodeURIComponent(testUnitName)}&chapter=${encodeURIComponent(testChapterName)}&mission=${testMissionNumber}&userId=${studentB1.body.id}`);
  const studentB1HasQuestion = Array.isArray(studentB1Questions.body) && studentB1Questions.body.some(q => q.questionText === customQuestionText);
  console.log("Student B1 does NOT see School A's custom question:", !studentB1HasQuestion ? "PASSED (ISOLATED)" : "FAILED (LEAKED)");

  // -------------------------------------------------------------
  // TEST C: School A State Board Student does NOT see CBSE question
  // -------------------------------------------------------------
  console.log("\n==================================================");
  console.log("TEST C: Board Isolation within Same School");
  console.log("==================================================");
  const state8Subjects = await request('GET', `/api/subjects?board=STATE_BOARD&classLevel=8&schoolId=${schoolAId}`);
  console.log("School A State Board Class 8 Subjects:", state8Subjects.body.map(s => s.subjectName).join(', '));
  const hasCbseOnlySubjects = state8Subjects.body.some(s => s.board !== 'STATE_BOARD');
  console.log("State Board subjects contain ONLY State Board:", !hasCbseOnlySubjects ? "PASSED (YES)" : "FAILED (NO)");

  // -------------------------------------------------------------
  // TEST D: Class 11 Group Isolation (Biology vs Computer Science)
  // -------------------------------------------------------------
  console.log("\n==================================================");
  console.log("TEST D: Class 11-12 Group Isolation");
  console.log("==================================================");
  const group1Subjects = await request('GET', `/api/subjects?board=CBSE&classLevel=11&studentGroup=${encodeURIComponent('GROUP 1 – MATHS-BIOLOGY / BIO-MATHS')}&schoolId=${schoolAId}`);
  const group1Names = group1Subjects.body.map(s => s.subjectName);
  console.log("Group 1 (Maths-Bio) Subjects:", group1Names.join(', '));

  const group2Subjects = await request('GET', `/api/subjects?board=CBSE&classLevel=11&studentGroup=${encodeURIComponent('GROUP 2 – COMPUTER SCIENCE (MATHS-PHYSICS-CHEMISTRY-CS)')}&schoolId=${schoolAId}`);
  const group2Names = group2Subjects.body.map(s => s.subjectName);
  console.log("Group 2 (CS) Subjects:", group2Names.join(', '));

  const bioInGroup1 = group1Names.includes('Biology');
  const csInGroup1 = group1Names.includes('Computer Science');
  const bioInGroup2 = group2Names.includes('Biology');
  const csInGroup2 = group2Names.includes('Computer Science');

  console.log("Group 1 has Biology & NO Computer Science:", (bioInGroup1 && !csInGroup1) ? "PASSED (YES)" : "FAILED");
  console.log("Group 2 has Computer Science & NO Biology:", (csInGroup2 && !bioInGroup2) ? "PASSED (YES)" : "FAILED");

  // -------------------------------------------------------------
  // TEST E: Cross-School Admin API Rejection (Security Check)
  // -------------------------------------------------------------
  console.log("\n==================================================");
  console.log("TEST E: Cross-School Admin Mutation Authorization");
  console.log("==================================================");
  // Admin B attempts to update School A's question
  const unauthorizedUpdate = await request('PUT', `/api/questions/${createdQuestion.body.id}`, {
    questionText: "Hacked Question By Admin B",
    optionA: "A", optionB: "B", optionC: "C", optionD: "D",
    correctAnswer: "A",
    adminId: adminBId
  });
  console.log("Admin B PUT on School A question:", (unauthorizedUpdate.status >= 400 || unauthorizedUpdate.body?.error) ? "PASSED (FORBIDDEN / REJECTED)" : `STATUS ${unauthorizedUpdate.status}`);

  // Admin B attempts to delete School A's question
  const unauthorizedDelete = await request('DELETE', `/api/questions/${createdQuestion.body.id}?adminId=${adminBId}`);
  console.log("Admin B DELETE on School A question:", (unauthorizedDelete.status >= 400 || unauthorizedDelete.body?.error) ? "PASSED (FORBIDDEN / REJECTED)" : `STATUS ${unauthorizedDelete.status}`);

  // -------------------------------------------------------------
  // TEST F: Leaderboard Four-Factor Isolation Check
  // -------------------------------------------------------------
  console.log("\n==================================================");
  console.log("TEST F: Leaderboard Four-Factor Isolation");
  console.log("==================================================");
  // Submit answers for studentA1 and studentB1
  const ansRes = await request('POST', '/api/questions/answer', {
    questionId: createdQuestion.body.id,
    userId: studentA1.body.id,
    answer: "Growing different crops alternately",
    subject: "Science"
  });
  console.log("Student A1 answered question correctly:", ansRes.body.correct, "Stars:", ansRes.body.starsEarned, "XP:", ansRes.body.xpEarned);

  const lbSchoolA = await request('GET', `/api/leaderboard?schoolId=${schoolAId}&board=CBSE&classLevel=8`);
  console.log("School A CBSE Class 8 Leaderboard:", Array.isArray(lbSchoolA.body) ? lbSchoolA.body.map(r => `${r.username} (${r.totalScore} XP)`).join(', ') : lbSchoolA.body);

  const lbSchoolB = await request('GET', `/api/leaderboard?schoolId=${schoolBId}&board=CBSE&classLevel=8`);
  console.log("School B CBSE Class 8 Leaderboard:", Array.isArray(lbSchoolB.body) ? lbSchoolB.body.map(r => `${r.username} (${r.totalScore} XP)`).join(', ') : lbSchoolB.body);

  const studentA1InSchoolB_LB = Array.isArray(lbSchoolB.body) && lbSchoolB.body.some(r => r.username === studentA1.body.username);
  console.log("Student A1 does NOT appear on School B Leaderboard:", !studentA1InSchoolB_LB ? "PASSED (ISOLATED)" : "FAILED");

  console.log("\n==================================================");
  console.log("            ALL AUDIT TESTS COMPLETED!           ");
  console.log("==================================================");
}

runTests().catch(console.error);
