const http = require('http');

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

async function verifyCounts() {
  console.log('--- Checking Live Database Curricula ---');
  const subs = await get('/api/subjects');
  console.log('Total Subjects in Database:', Array.isArray(subs.body) ? subs.body.length : 'Error');

  // Check some samples
  const cbse4 = subs.body.filter(s => s.board === 'CBSE' && s.classLevel === 4);
  console.log('CBSE Class 4 Subjects:', cbse4.map(s => s.subjectName));

  const tn11 = subs.body.filter(s => s.board === 'STATE_BOARD' && s.classLevel === 11);
  console.log('State Board Class 11 Subjects Count:', tn11.length);
  console.log('State Board Class 11 Subjects:', tn11.map(s => s.subjectName));

  const cbse12 = subs.body.filter(s => s.board === 'CBSE' && s.classLevel === 12);
  console.log('CBSE Class 12 Subjects Count:', cbse12.length);
  console.log('CBSE Class 12 Subjects:', cbse12.map(s => s.subjectName));
}

verifyCounts().catch(console.error);
