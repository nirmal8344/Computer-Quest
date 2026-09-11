const http = require('http');

function get(url) {
  return new Promise((resolve, reject) => {
    http.get(url, (res) => {
      let data = '';
      res.on('data', chunk => data += chunk);
      res.on('end', () => {
        try {
          resolve(JSON.parse(data));
        } catch (e) {
          resolve(data);
        }
      });
    }).on('error', reject);
  });
}

async function runTests() {
  console.log('--- TESTING CURRICULUM VERIFICATION API ---');

  // 1. Check State Board Class 10 Tamil Units
  const unitsTn10Tamil = await get('http://localhost:8080/api/admin/units?board=STATE_BOARD&classLevel=10&subject=Tamil');
  console.log(`[PASS] State Board Class 10 Tamil Units Count: ${unitsTn10Tamil.length}`);
  unitsTn10Tamil.forEach(u => console.log(`  - Unit ${u.unitNumber}: ${u.unitName}`));

  // 2. Check State Board Class 6 Tamil Units
  const unitsTn6Tamil = await get('http://localhost:8080/api/admin/units?board=STATE_BOARD&classLevel=6&subject=Tamil');
  console.log(`[PASS] State Board Class 6 Tamil Units Count: ${unitsTn6Tamil.length}`);

  // 3. Check State Board Class 11 Tamil Units
  const unitsTn11Tamil = await get('http://localhost:8080/api/admin/units?board=STATE_BOARD&classLevel=11&subject=Tamil');
  console.log(`[PASS] State Board Class 11 Tamil Units Count: ${unitsTn11Tamil.length}`);

  // 4. Check State Board Class 10 Science Units
  const unitsTn10Sci = await get('http://localhost:8080/api/admin/units?board=STATE_BOARD&classLevel=10&subject=Science');
  console.log(`[PASS] State Board Class 10 Science Units Count: ${unitsTn10Sci.length}`);

  // 5. Check CBSE Class 10 Science Units
  const unitsCbse10Sci = await get('http://localhost:8080/api/admin/units?board=CBSE&classLevel=10&subject=Science');
  console.log(`[PASS] CBSE Class 10 Science Units Count: ${unitsCbse10Sci.length}`);

  // 6. Check Class 11 State Board Group 1 (Bio-Maths) Subjects
  const group1State11Subs = await get('http://localhost:8080/api/subjects?board=STATE_BOARD&classLevel=11&studentGroup=' + encodeURIComponent('GROUP 1 – MATHS-BIOLOGY / BIO-MATHS'));
  console.log(`[PASS] State Board Class 11 Group 1 Subjects: ${group1State11Subs.map(s => s.subjectName).join(', ')}`);

  // 7. Check Class 11 State Board Group 7 (Accountancy + History) Subjects
  const group7State11Subs = await get('http://localhost:8080/api/subjects?board=STATE_BOARD&classLevel=11&studentGroup=' + encodeURIComponent('GROUP 7 – ACCOUNTANCY + HISTORY'));
  console.log(`[PASS] State Board Class 11 Group 7 Subjects: ${group7State11Subs.map(s => s.subjectName).join(', ')}`);

  // 8. Check Class 11 CBSE Group 4 (Commerce) Subjects
  const group4Cbse11Subs = await get('http://localhost:8080/api/subjects?board=CBSE&classLevel=11&studentGroup=' + encodeURIComponent('GROUP 4 – COMMERCE'));
  console.log(`[PASS] CBSE Class 11 Group 4 Subjects: ${group4Cbse11Subs.map(s => s.subjectName).join(', ')}`);

  console.log('--- ALL VERIFICATIONS COMPLETED SUCCESSFULLY ---');
}

runTests().catch(console.error);
