const http = require('http');

function get(url) {
  return new Promise((resolve, reject) => {
    http.get(url, (res) => {
      let data = '';
      res.on('data', chunk => data += chunk);
      res.on('end', () => {
        try {
          resolve({ status: res.statusCode, data: JSON.parse(data) });
        } catch (e) {
          resolve({ status: res.statusCode, data: data });
        }
      });
    }).on('error', reject);
  });
}

async function runTests() {
  console.log('Testing multi-unit syllabus API endpoints...\n');

  // 1. Check Demo School ID
  let schoolsRes = await get('http://localhost:8080/api/schools');
  let schoolId = null;
  if (Array.isArray(schoolsRes.data)) {
    const demo = schoolsRes.data.find(s => s.name === 'Computer Quest Demo School');
    if (demo) schoolId = demo.id;
  }
  console.log(`Demo School ID: ${schoolId}`);

  const boards = ['CBSE', 'STATE_BOARD'];
  const classes = [4, 5, 6, 7, 8, 9, 10, 11, 12];

  let allPassed = true;

  for (const board of boards) {
    console.log(`\n========================================`);
    console.log(`BOARD: ${board}`);
    console.log(`========================================`);

    for (const cl of classes) {
      let unitsUrl = `http://localhost:8080/api/admin/units?board=${board}&classLevel=${cl}`;
      if (schoolId) unitsUrl += `&schoolId=${schoolId}`;

      let chaptersUrl = `http://localhost:8080/api/chapters?board=${board}&classLevel=${cl}`;

      const [uRes, chRes] = await Promise.all([get(unitsUrl), get(chaptersUrl)]);

      const unitList = Array.isArray(uRes.data) ? uRes.data : [];
      const chapterList = Array.isArray(chRes.data) ? chRes.data : [];

      console.log(`Class ${cl.toString().padEnd(2)}: ${unitList.length} Units, ${chapterList.length} Chapters`);
      unitList.forEach(u => {
        console.log(`   - Unit ${u.unitNumber}: ${u.unitName}`);
      });

      if (unitList.length === 0 || chapterList.length === 0) {
        console.error(`❌ ERROR: Class ${cl} ${board} missing units or chapters!`);
        allPassed = false;
      }
    }
  }

  // Check sample questions from Class 4 and Class 10
  console.log(`\nChecking sample mission questions...`);
  const sampleChRes = await get(`http://localhost:8080/api/chapters?board=CBSE&classLevel=4`);
  if (Array.isArray(sampleChRes.data) && sampleChRes.data.length > 0) {
    const firstCh = sampleChRes.data[0];
    const missionsRes = await get(`http://localhost:8080/api/missions/chapter/${firstCh.id}`);
    const missions = Array.isArray(missionsRes.data) ? missionsRes.data : [];
    console.log(`CBSE Class 4 Chapter 1 has ${missions.length} Missions`);
    for (const m of missions) {
      const qRes = await get(`http://localhost:8080/api/questions?chapterId=${firstCh.id}&missionId=${m.id}`);
      const qList = Array.isArray(qRes.data) ? qRes.data : [];
      console.log(`   - Mission ${m.missionNumber} (${m.gameType}): ${qList.length} Questions`);
    }
  }

  console.log(`\n========================================`);
  if (allPassed) {
    console.log(`✅ ALL TESTS PASSED: Multi-Unit Curricula for Classes 4–10 & Classes 11–12 intact!`);
  } else {
    console.log(`❌ SOME TESTS FAILED`);
  }
  console.log(`========================================`);
}

// Retry loop until backend is ready
async function waitForBackend(retries = 20) {
  for (let i = 0; i < retries; i++) {
    try {
      const res = await get('http://localhost:8080/api/chapters');
      if (res.status === 200) {
        console.log('Backend is UP and responding!');
        return runTests();
      }
    } catch (e) {
      console.log(`Waiting for backend to start... (${i+1}/${retries})`);
      await new Promise(r => setTimeout(r, 2000));
    }
  }
  console.error('Backend failed to start within timeout.');
}

waitForBackend();
