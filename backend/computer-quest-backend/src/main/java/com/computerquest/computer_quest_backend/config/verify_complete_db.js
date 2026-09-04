const http = require('http');

function get(url) {
  return new Promise((resolve) => {
    http.get(url, res => {
      let d = ''; res.on('data', c => d += c);
      res.on('end', () => {
        try { resolve({ status: res.statusCode, data: JSON.parse(d) }); }
        catch(e) { resolve({ status: res.statusCode, data: [] }); }
      });
    }).on('error', () => resolve({ status: 500, data: [] }));
  });
}

async function runAudit() {
  console.log('===============================================================');
  console.log('COMPREHENSIVE CURRICULUM HIERARCHY & DATABASE AUDIT');
  console.log('===============================================================');

  const boards = ['CBSE', 'STATE_BOARD'];
  const classes = [4, 5, 6, 7, 8, 9, 10];

  let totalUnits = 0;
  let totalChapters = 0;
  let totalMissions = 0;
  let totalQuestions = 0;
  let hasErrors = false;

  for (const board of boards) {
    console.log(`\n===============================================================`);
    console.log(`BOARD: ${board}`);
    console.log(`===============================================================`);

    for (const cl of classes) {
      const uRes = await get(`http://localhost:8080/api/admin/units?board=${board}&classLevel=${cl}&schoolId=5`);
      const chRes = await get(`http://localhost:8080/api/chapters?board=${board}&classLevel=${cl}&schoolId=5`);

      const units = Array.isArray(uRes.data) ? uRes.data : [];
      const chapters = Array.isArray(chRes.data) ? chRes.data : [];

      console.log(`\n>>> CLASS ${cl} (${board}): ${units.length} Units, ${chapters.length} Chapters`);

      if (units.length === 0) {
        console.error(`❌ CRITICAL: Class ${cl} ${board} has 0 Units!`);
        hasErrors = true;
      }
      if (chapters.length === 0) {
        console.error(`❌ CRITICAL: Class ${cl} ${board} has 0 Chapters!`);
        hasErrors = true;
      }

      totalUnits += units.length;
      totalChapters += chapters.length;

      for (const u of units) {
        // Robust chapter matching exactly matching frontend MapPage logic
        const uName = (u.unitName || "").toLowerCase().trim();
        const uNumPrefix = `unit ${u.unitNumber}`.toLowerCase();
        const romanNums = ["i", "ii", "iii", "iv", "v", "vi", "vii", "viii", "ix", "x"];
        const uNumRomanPrefix = `unit ${romanNums[(u.unitNumber || 1) - 1] || u.unitNumber}`.toLowerCase();

        const uChapters = chapters.filter((ch) => {
          if (!ch.unit) return false;
          const chUnit = ch.unit.toLowerCase().trim();
          return (
            chUnit === uName ||
            chUnit.startsWith(uNumPrefix) ||
            chUnit.startsWith(uNumRomanPrefix) ||
            ch.unit === u.unitName
          );
        });

        console.log(`   📂 Unit ${u.unitNumber}: "${u.unitName}" -> [${uChapters.length} Chapters]`);

        if (uChapters.length === 0) {
          console.error(`      ❌ ERROR: Unit ${u.unitNumber} "${u.unitName}" has 0 MATCHING CHAPTERS!`);
          hasErrors = true;
        }

        for (const ch of uChapters) {
          const mRes = await get(`http://localhost:8080/api/missions?board=${board}&classLevel=${cl}&schoolId=5`);
          const allMissions = Array.isArray(mRes.data) ? mRes.data : [];
          const chMissions = allMissions.filter(m => m.chapter && m.chapter.id === ch.id);

          console.log(`      📖 Ch ${ch.chapterNumber}: "${ch.chapterName}" -> [${chMissions.length} Missions]`);

          if (chMissions.length === 0) {
            console.error(`         ❌ ERROR: Chapter ${ch.id} has 0 MISSIONS!`);
            hasErrors = true;
          }
          totalMissions += chMissions.length;

          for (const m of chMissions) {
            const qRes = await get(`http://localhost:8080/api/questions?board=${board}&classLevel=${cl}&schoolId=5&unit=${encodeURIComponent(u.unitName)}&chapter=${encodeURIComponent(ch.chapterName)}&mission=${m.missionNumber}`);
            const qList = Array.isArray(qRes.data) ? qRes.data : [];
            totalQuestions += qList.length;

            if (qList.length === 0) {
              console.error(`            ❌ ERROR: Mission ${m.missionNumber} has 0 QUESTIONS!`);
              hasErrors = true;
            }
          }
        }
      }
    }
  }

  // Check Class 11 and 12 integrity
  console.log(`\n===============================================================`);
  console.log(`VERIFYING UNTOUCHED CLASS 11 & 12 DATA INTEGRITY`);
  console.log(`===============================================================`);
  for (const b of boards) {
    for (const cl of [11, 12]) {
      const uRes = await get(`http://localhost:8080/api/admin/units?board=${b}&classLevel=${cl}`);
      const chRes = await get(`http://localhost:8080/api/chapters?board=${b}&classLevel=${cl}`);
      const units = Array.isArray(uRes.data) ? uRes.data : [];
      const chapters = Array.isArray(chRes.data) ? chRes.data : [];
      console.log(`Class ${cl} (${b}): ${units.length} Units, ${chapters.length} Chapters`);
      if (units.length === 0 || chapters.length === 0) {
        console.error(`❌ ERROR: Class ${cl} ${b} data compromised!`);
        hasErrors = true;
      }
    }
  }

  console.log(`\n===============================================================`);
  console.log(`AUDIT SUMMARY:`);
  console.log(`Total Units across Classes 4–10: ${totalUnits}`);
  console.log(`Total Chapters across Classes 4–10: ${totalChapters}`);
  console.log(`Total Missions across Classes 4–10: ${totalMissions}`);
  console.log(`Total Questions across Classes 4–10: ${totalQuestions}`);
  if (!hasErrors) {
    console.log(`\n✅ 100% AUDIT SUCCESS: ZERO empty units, ZERO empty chapters, ZERO empty missions, ZERO empty questions!`);
  } else {
    console.error(`\n❌ AUDIT FAILED: Errors found in hierarchy!`);
  }
  console.log(`===============================================================`);
}

// Retry loop until backend is ready
async function start() {
  for (let i = 0; i < 20; i++) {
    const res = await get('http://localhost:8080/api/chapters');
    if (res.status === 200) {
      console.log('Backend server is alive. Starting audit...\n');
      return runAudit();
    }
    console.log(`Waiting for backend server to boot... (${i+1}/20)`);
    await new Promise(r => setTimeout(r, 2000));
  }
  console.error('Backend server failed to respond.');
}

start();
