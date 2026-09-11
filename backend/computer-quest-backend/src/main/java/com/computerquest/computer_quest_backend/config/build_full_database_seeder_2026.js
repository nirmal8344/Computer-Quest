const fs = require('fs');
const path = require('path');

// Complete Real 2026-27 Textbook Curriculum Database Generator for RPSIT School

console.log('Generating comprehensive complete curriculum seeder for LearnQuest (CBSE & State Board)...');

function esc(s) {
  if (!s) return "";
  return s.replace(/\\/g, "\\\\").replace(/"/g, '\\"').replace(/\n/g, "\\n");
}

const subjectsList = [];

// =========================================================================
// 1. TAMIL NADU STATE BOARD CURRICULUM
// =========================================================================

// --- 1.1 TAMIL (Classes 4 - 12) ---
for (let lvl = 4; lvl <= 12; lvl++) {
  let units = [];
  if (lvl === 4) {
    units = [
      { num: 1, name: "பருவம் 1: அன்னைத் தமிழ்", chapters: [{ num: 1, name: "அன்னைத் தமிழே", c: "தாய்மொழிப் பற்று" }, { num: 2, name: "பனைமரச் சிறப்பு", c: "மாநில மரம் பயன்கள்" }] },
      { num: 2, name: "பருவம் 1: அறிவின் சிறப்பு", chapters: [{ num: 3, name: "ஏழு இறக்கைக் குருவி", c: "தெனாலிராமன் அறிவுக் கதை" }, { num: 4, name: "முளைப்பாரி பாடல்", c: "நாட்டுப்புறப் பாடல்" }] },
      { num: 3, name: "பருவம் 1: ஒழுக்கம் & இலக்கணம்", chapters: [{ num: 5, name: "பண்படுத்தும் பழமொழிகள்", c: "பழமொழிகள் விளக்கம்" }, { num: 6, name: "கூட்டுப் பெயர் சொற்கள்", c: "தமிழ் இலக்கணம்" }] },
      { num: 4, name: "பருவம் 2: நன்னெறி", chapters: [{ num: 7, name: "நன்னெறி", c: "சிவப்பிரகாச சுவாமிகள் அறப்பாடல்" }, { num: 8, name: "காவல் காப்பவர்", c: "பொம்மை காவல்காரர்" }] },
      { num: 5, name: "பருவம் 2: ஒற்றுமை & கல்வி", chapters: [{ num: 9, name: "ஒற்றுமையே வலிமை", c: "புறாக்கள் கதை" }, { num: 10, name: "வெற்றி வேற்கை", c: "அதிவீரராம பாண்டியர் வாக்கு" }] },
      { num: 6, name: "பருவம் 2: மொழிப்பயிற்சி", chapters: [{ num: 11, name: "வேற்றுமை உருபுகள்", c: "தமிழ் இலக்கணம்" }] },
      { num: 7, name: "பருவம் 3: இயற்கை வளம்", chapters: [{ num: 12, name: "விடியும் வேளை", c: "கிராமத்து விடியல் இயற்கை" }, { num: 13, name: "உலா வரும் செயற்கைக்கோள்", c: "விண்வெளி அறிவியல்" }] },
      { num: 8, name: "பருவம் 3: நீதிநெறி", chapters: [{ num: 14, name: "நீதிநெறி விளக்கம்", c: "குமரகுருபரர் நற்பண்புகள்" }, { num: 15, name: "அப்படியே நிற்கட்டும் அந்த மரம்", c: "இயற்கை பாதுகாப்பு" }] },
      { num: 9, name: "பருவம் 3: நல்வழி", chapters: [{ num: 16, name: "நல்வழி", c: "ஔவையார் அறப்பாடல்கள்" }, { num: 17, name: "ஆகுபெயர் & சொல்வளம்", c: "இலக்கணப் பயிற்சி" }] }
    ];
  } else if (lvl === 5) {
    units = [
      { num: 1, name: "பருவம் 1: தமிழின் இனிமை", chapters: [{ num: 1, name: "தமிழின் இனிமை", c: "பாரதிதாசன் கவிதை" }, { num: 2, name: "மரபுச் சொற்கள்", c: "ஒலி & வினை மரபுகள்" }] },
      { num: 2, name: "பருவம் 1: கவிதைப் பட்டிமன்றம்", chapters: [{ num: 3, name: "அறிவா? பண்பா?", c: "பட்டிமன்ற வாதங்கள்" }, { num: 4, name: "என்ன சத்தம்?", c: "விலங்கு பறவை ஒலி மரபு" }] },
      { num: 3, name: "பருவம் 1: கல்விச் சிறப்பு", chapters: [{ num: 5, name: "கல்விச் செல்வம்", c: "பொருட்செல்வமும் கல்விச்செல்வமும்" }, { num: 6, name: "வறுமையிலும் நேர்மை", c: "நற்குணக் கதை" }] },
      { num: 4, name: "பருவம் 2: கடலின் பெருமை", chapters: [{ num: 7, name: "கடல்", c: "கவிமணி தேசிக விநாயகம் பிள்ளை" }, { num: 8, name: "திருக்குறள் கதைகள்", c: "அன்புடைமை & இனியவை கூறல்" }] },
      { num: 5, name: "பருவம் 2: மூதுரை", chapters: [{ num: 9, name: "மூதுரை", c: "ஔவையார் நல்வழிக் கருத்துகள்" }, { num: 10, name: "கங்கை கொண்ட சோழபுரம்", c: "இராசேந்திர சோழன் வரலாறு" }] },
      { num: 6, name: "பருவம் 2: தொடர் இலக்கணம்", chapters: [{ num: 11, name: "எழுவாய், பயனிலை, செயப்படுபொருள்", c: "தமிழ் இலக்கண அமைப்பு" }] },
      { num: 7, name: "பருவம் 3: தலைமைப் பண்பு", chapters: [{ num: 12, name: "சிறுபஞ்சமூலம்", c: "காரியாசான் நீதிப்பாடல்" }, { num: 13, name: "தலைமைப் பண்பு", c: "ஊர்த்தலைவர் தேர்வு" }] },
      { num: 8, name: "பருவம் 3: அறநெறிச்சாரம்", chapters: [{ num: 14, name: "அறநெறிச்சாரம்", c: "முனைப்பாடியார் வாக்கு" }, { num: 15, name: "நற்பண்பு", c: "வாழ்க்கை வழிகாட்டி" }] },
      { num: 9, name: "பருவம் 3: மொழியோடு விளையாடு", chapters: [{ num: 16, name: "நீதிநெறி நன்மொழிகள்", c: "நற்பண்புச் சுடர்" }, { num: 17, name: "மயங்கொலிச் சொற்கள்", c: "ர/ற, ல/ள/ழ, ந/ண/ன வேறுபாடுகள்" }] }
    ];
  } else if (lvl === 6) {
    units = [
      { num: 1, name: "இயல் 1: மொழி – இன்பத்தமிழ்", chapters: [{ num: 1, name: "இன்பத்தமிழ்", c: "பாரதிதாசன் தமிழ் வணக்கம்" }, { num: 2, name: "தமிழ்க்கும்மி", c: "பெருஞ்சித்திரனார் பாடல்" }, { num: 3, name: "வளர்தமிழ்", c: "மூத்த தமிழ் மொழியின் மேன்மை" }] },
      { num: 2, name: "இயல் 2: இயற்கை – சிலப்பதிகாரம்", chapters: [{ num: 4, name: "சிலப்பதிகாரம்: திங்களைப் போற்றுதும்", c: "இளங்கோவடிகள் இயற்கை வாழ்த்து" }, { num: 5, name: "காணி நிலம்", c: "பாரதியார் கனவு இல்லம்" }, { num: 6, name: "சிறகின் ஓசை", c: "பறவைகள் வலசை போதல்" }] },
      { num: 3, name: "இயல் 3: அறிவியல் தொழில்நுட்பம்", chapters: [{ num: 7, name: "அறிவியல் ஆத்திசூடி", c: "நெல்லை சு. முத்து" }, { num: 8, name: "கனியனின் நண்பன்", c: "எந்திர மனிதன் & AI" }, { num: 9, name: "ஒளி பிறந்தது", c: "அப்துல் கலாம் நேர்காணல்" }] },
      { num: 4, name: "இயல் 4: கல்வி – மூதுரை", chapters: [{ num: 10, name: "மூதுரை: மன்னனும் மாசறக் கற்றோனும்", c: "ஔவையார் கல்வி அறம்" }, { num: 11, name: "துன்பம் வெல்லும் கல்வி", c: "பட்டுக்கோட்டை கல்யாணசுந்தரம்" }, { num: 12, name: "கல்விக் கண் திறந்த காமராசர்", c: "காமராசர் கல்விப் புரட்சி" }] },
      { num: 5, name: "இயல் 5: நாகரிகம் பண்பாடு", chapters: [{ num: 13, name: "ஆசாரக்கோவை", c: "பெருவாயின் முள்ளியார் ஒழுக்க நெறி" }, { num: 14, name: "தமிழர் பெருவிழா", c: "உழவர் திருநாள் & பொங்கல்" }, { num: 15, name: "மனம் கவரும் மாமல்லபுரம்", c: "பல்லவர் சிற்பக்கலை" }] },
      { num: 6, name: "இயல் 6: தொழில் வணிகம்", chapters: [{ num: 16, name: "நானிலம் படைத்தவன்", c: "முடியரசன் உழைப்பின் மேன்மை" }, { num: 17, name: "கடலோடு விளையாடு", c: "நெய்தல் நில மீனவர் பாடல்" }, { num: 18, name: "வளரும் வணிகம்", c: "பண்டமாற்று முதல் ஈ-காமர்ஸ் வரை" }] },
      { num: 7, name: "இயல் 7: நாடு சமூகம் அரசு", chapters: [{ num: 19, name: "பாரதம் அன்றைய நாற்றங்கால்", c: "தாராபாரதி தேசிய ஒருமைப்பாடு" }, { num: 20, name: "தமிழ்நாட்டில் காந்தி", c: "காந்தியடிகள் தமிழக வருகை" }, { num: 21, name: "வேலுநாச்சியார்", c: "சிவகங்கை வீர மங்கை" }] },
      { num: 8, name: "இயல் 8: அறம் தத்துவம் மனிதநேயம்", chapters: [{ num: 22, name: "பராபரக்கண்ணி", c: "தாயுமானவர் அருள்வாக்கு" }, { num: 23, name: "நீங்கள் நல்லவர்", c: "கலீல் ஜிப்ரான் கவிதை" }, { num: 24, name: "பசிப்பிணி போக்கிய பாவை", c: "மணிமேகலை அமுதசுரபி" }] },
      { num: 9, name: "இயல் 9: மனிதம் ஆளுமை", chapters: [{ num: 25, name: "ஆசிய ஜோதி", c: "கவிமணி புத்தர் அருள் வரலாறு" }, { num: 26, name: "மனிதநேயம்", c: "அன்னை தெரசா & கைலாஷ் சத்யார்த்தி" }, { num: 27, name: "அணி இலக்கணம்", c: "இயல்பு நவிற்சி & உயர்வு நவிற்சி அணி" }] }
    ];
  } else if (lvl === 7) {
    units = [
      { num: 1, name: "இயல் 1: அமுதத்தமிழ்", chapters: [{ num: 1, name: "எங்கள் தமிழ்", c: "நாமக்கல் கவிஞர்" }, { num: 2, name: "ஒன்றல்ல இரண்டல்ல", c: "உடுமலை நாராயணகவி" }] },
      { num: 2, name: "இயல் 2: அணிநிழல் காடு", chapters: [{ num: 3, name: "காடு", c: "சுரதா இயற்கை எழில்" }, { num: 4, name: "விலங்குகள் உலகம்", c: "முண்டந்துறை சரணாலயம்" }] },
      { num: 3, name: "இயல் 3: நாடு அதை நாடு", chapters: [{ num: 5, name: "புலி தங்கிய குகை", c: "காவற்பெண்டு புறநானூறு" }, { num: 6, name: "பாஞ்சை வளம்", c: "வீரபாண்டிய கட்டபொம்மன்" }] },
      { num: 4, name: "இயல் 4: கல்வி கரையில", chapters: [{ num: 7, name: "கற்றோர்க்குச் சென்ற இடமெல்லாம் சிறப்பு", c: "கல்விப் பெருமை" }, { num: 8, name: "வாழ்விக்கும் கல்வி", c: "மு. முனிசாமி" }] },
      { num: 5, name: "இயல் 5: ஓதுவது ஒழியேல்", chapters: [{ num: 9, name: "இன்பத்தமிழ்க் கல்வி", c: "பாரதிதாசன்" }, { num: 10, name: "அழியாத செல்வம்", c: "நாலடியார்" }] },
      { num: 6, name: "இயல் 6: கலை வண்ணம்", chapters: [{ num: 11, name: "கலங்கரை விளக்கம்", c: "கடியலூர் உருத்திரங்கண்ணனார்" }, { num: 12, name: "தமிழரின் கப்பற்கலை", c: "பண்டைத் தமிழர் கடல் வணிகம்" }] },
      { num: 7, name: "இயல் 7: நாகரிகத் தொழில்", chapters: [{ num: 13, name: "விருந்தோம்பல்", c: "பழமொழி நானூறு" }, { num: 14, name: "வயலும் வாழ்வும்", c: "உழவுத் தொழில் பாட்டு" }] },
      { num: 8, name: "இயல் 8: அறநெறி", chapters: [{ num: 15, name: "புதுமை விளக்கு", c: "பொய்கையாழ்வார் & பூதத்தாழ்வார்" }, { num: 16, name: "ஒப்புரவு நெறி", c: "குன்றக்குடி அடிகளார்" }] },
      { num: 9, name: "இயல் 9: மானுடம்", chapters: [{ num: 17, name: "மலைப்பொழிவு", c: "கண்ணதாசன் இயேசு காவியம்" }, { num: 18, name: "தன்னை அறிதல்", c: "சே. பிருந்தா கவிதை" }] }
    ];
  } else if (lvl === 8) {
    units = [
      { num: 1, name: "இயல் 1: தமிழ் இன்பம்", chapters: [{ num: 1, name: "தமிழ் மொழி வாழ்த்து", c: "பாரதியார் வாழ்த்து" }, { num: 2, name: "தமிழ் வரிவடிவ வளர்ச்சி", c: "வட்டெழுத்து & தமிழ் எழுத்துகள்" }] },
      { num: 2, name: "இயல் 2: ஈடிலா இயற்கை", chapters: [{ num: 3, name: "ஓடை", c: "வாணிதாசன் இயற்கை எழில்" }, { num: 4, name: "கோணக்காத்துப் பாட்டு", c: "வெங்கம்பூர் சாமிநாதன்" }] },
      { num: 3, name: "இயல் 3: உடலை ஓம்புமின்", chapters: [{ num: 5, name: "நோயும் மருந்தும்", c: "நீலகேசி ஐஞ்சிறுங்காப்பியம்" }, { num: 6, name: "தமிழர் மருத்துவம்", c: "சித்த மருத்துவம் & மூலிகைகள்" }] },
      { num: 4, name: "இயல் 4: கல்வி கரையில", chapters: [{ num: 7, name: "கல்வி அழகே அழகு", c: "குமரகுருபரர் நீதிநெறி" }, { num: 8, name: "புத்தியைத் தீட்டு", c: "ஆலங்குடி சோமு" }] },
      { num: 5, name: "இயல் 5: கலை அழகு", chapters: [{ num: 9, name: "திருவாரூர் நான்மணிமாலை", c: "பக்திப் பாடல்" }, { num: 10, name: "தமிழர் இசைக்கருவிகள்", c: "தோல், துளை, நரம்புக் கருவிகள்" }] },
      { num: 6, name: "இயல் 6: நாகரிகம் தொழில்", chapters: [{ num: 11, name: "வளம் பெருகுக", c: "தகடூர் யாத்திரை மழை வளம்" }, { num: 12, name: "கொங்குநாட்டு வணிகம்", c: "பண்டைய வர்த்தகம்" }] },
      { num: 7, name: "இயல் 7: பார் போற்றும் மனிதர்கள்", chapters: [{ num: 13, name: "படை வேழம்", c: "செயங்கொண்டார் கலிங்கத்துப் பரணி" }, { num: 14, name: "பாரத ரத்னா எம்.ஜி.ஆர்", c: "சத்துணவு திட்டம் & சேவை" }] },
      { num: 8, name: "இயல் 8: அறநெறிச்சாரம்", chapters: [{ num: 15, name: "ஒன்றே குலம்", c: "திருமூலர் திருமந்திரம்" }, { num: 16, name: "சட்டமேதை அம்பேத்கர்", c: "இந்திய அரசியல் சாசனம்" }] },
      { num: 9, name: "இயல் 9: மனிதநேயம்", chapters: [{ num: 17, name: "உயிர் குணங்கள்", c: "இறையரசன் பாமாலை" }, { num: 18, name: "இளைய தோழனுக்கு", c: "மு. மேத்தா விழிப்புணர்வு" }] }
    ];
  } else if (lvl === 9) {
    units = [
      { num: 1, name: "இயல் 1: அமுதென்று பேர்", chapters: [{ num: 1, name: "திராவிட மொழிக்குடும்பம்", c: "கால்டுவெல் திராவிட ஒப்பிலக்கணம்" }, { num: 2, name: "தமிழ்த்தூது", c: "சிற்றிலக்கியச் சிறப்பு" }] },
      { num: 2, name: "இயல் 2: உயிர்மூச்சு", chapters: [{ num: 3, name: "பட்டமரம்", c: "கவிஞர் தமிழ்ஒளி" }, { num: 4, name: "பெரியபுராணம்", c: "சேக்கிழார் திருநாட்டுச் சிறப்பு" }] },
      { num: 3, name: "இயல் 3: உள்ளத்தின் சீர்", chapters: [{ num: 5, name: "ஏறு தழுவுதல்", c: "ஜல்லிக்கட்டு சங்க மரபு" }, { num: 6, name: "மணிமேகலை: விழாவறை காதை", c: "சீத்தலைச் சாத்தனார் இந்திர விழா" }] },
      { num: 4, name: "இயல் 4: எட்டுத்திக்கும் சென்றிடுவீர்", chapters: [{ num: 7, name: "விண்ணையும் சாடுவோம்", c: "இஸ்ரோ விண்வெளி சாதனை" }, { num: 8, name: "சீவக சிந்தாமணி", c: "திருத்தக்கதேவர் காப்பியம்" }] },
      { num: 5, name: "இயல் 5: கசடறக் கற்றல்", chapters: [{ num: 9, name: "குடும்ப விளக்கு", c: "பாரதிதாசன் பெண் கல்வி" }, { num: 10, name: "சிறுபஞ்சமூலம்", c: "காரியாசான் ஐந்தறக் கருத்துகள்" }] },
      { num: 6, name: "இயல் 6: கலை பல வளர்த்தல்", chapters: [{ num: 11, name: "சிற்பக்கலை", c: "மாமல்லபுரம் & சோழர் சிற்பங்கள்" }, { num: 12, name: "நாச்சியார் திருமொழி", c: "ஆண்டாள் பக்திப் பாடல்" }] },
      { num: 7, name: "இயல் 7: வாழிய நிலனே", chapters: [{ num: 13, name: "இந்திய தேசிய இராணுவத்தில் தமிழர்", c: "நேதாஜி & தமிழர் பங்கு" }, { num: 14, name: "சீறாப்புராணம்", c: "உமறுப்புலவர் நபிகள் நாயகம்" }] },
      { num: 8, name: "இயல் 8: எண்திக்கும் புகழ் மணக்க", chapters: [{ num: 15, name: "பெரியாரின் சிந்தனைகள்", c: "சமூக நீதி & பகுத்தறிவு" }, { num: 16, name: "ஒளியின் அழைப்பு", c: "ந. பிச்சமூர்த்தி புதுக்கவிதை" }] },
      { num: 9, name: "இயல் 9: அன்பின் மொழி", chapters: [{ num: 17, name: "விரிவாகும் ஆளுமை", c: "ஆல்பர்ட் சுவைட்சர் மனிதநேயம்" }, { num: 18, name: "குறுந்தொகை: யாயும் ஞாயும்", c: "செம்புலப் பெயல்நீரார் சங்கக் காதல்" }] }
    ];
  } else if (lvl === 10) {
    units = [
      { num: 1, name: "இயல் 1: மொழி – அன்னை மொழியே", chapters: [{ num: 1, name: "அன்னை மொழியே", c: "பாவலேறேறு பெருஞ்சித்திரனார்" }, { num: 2, name: "தமிழ்ச்சொல் வளம்", c: "மொழிஞாயிறு தேவநேயப் பாவாணர்" }] },
      { num: 2, name: "இயல் 2: இயற்கை – காற்று வா", chapters: [{ num: 3, name: "காற்றே வா!", c: "மகாகவி பாரதியார் வசன கவிதை" }, { num: 4, name: "முல்லைப்பாட்டு", c: "நப்பூதனார் கார்கால முல்லை" }] },
      { num: 3, name: "இயல் 3: பண்பாடு – விருந்து போற்றுதும்", chapters: [{ num: 5, name: "விருந்து போற்றுதும்!", c: "தமிழர் விருந்தோம்பல் மரபு" }, { num: 6, name: "காசி காண்டம்", c: "அதிவீரராம பாண்டியர் விருந்து நெறி" }] },
      { num: 4, name: "இயல் 4: அறிவியல் – செயற்கை நுண்ணறிவு", chapters: [{ num: 7, name: "செயற்கை நுண்ணறிவு", c: "AI தொழில்நுட்பம் & எதிர்காலம்" }, { num: 8, name: "பெருமாள் திருமொழி", c: "குலசேகர ஆழ்வார் பக்தி" }] },
      { num: 5, name: "இயல் 5: கல்வி – மணற்கேணி", chapters: [{ num: 9, name: "மொழிபெயர்ப்புக் கல்வி", c: "மொழிபெயர்ப்பு வரலாறு & மேன்மை" }, { num: 10, name: "நீதி வெண்பா", c: "செய்குதம்பி பாவலர் சதாவதானம்" }] },
      { num: 6, name: "இயல் 6: கலை – நிகழ்கலை", chapters: [{ num: 11, name: "நிகழ்கலை", c: "நாட்டுப்புற நடனங்கள் & தெருக்கூத்து" }, { num: 12, name: "முத்துக்குமாரசாமி பிள்ளைத்தமிழ்", c: "குமரகுருபரர் செங்கீரைப் பருவம்" }] },
      { num: 7, name: "இயல் 7: நாகரிகம் – சிற்றகல் ஒளி", chapters: [{ num: 13, name: "சிற்றகல் ஒளி", c: "ம.பொ. சிவஞானம் எல்லைப் போராட்டம்" }, { num: 14, name: "மெய்க்கீர்த்தி", c: "இரண்டாம் இராசராசன் சோழர் பெருமை" }] },
      { num: 8, name: "இயல் 8: அறம் – காலக்கணிதம்", chapters: [{ num: 15, name: "சங்க இலக்கியத்தில் அறம்", c: "போர் அறம் & அரசியல் அறம்" }, { num: 16, name: "காலக்கணிதம்", c: "கவிஞர் கண்ணதாசன் கவிதை ஆளுமை" }] },
      { num: 9, name: "இயல் 9: மனிதம் – ஜெயகாந்தம்", chapters: [{ num: 17, name: "ஜெயகாந்தம் – நினைவுக் குறிப்புகள்", c: "ஜெயகாந்தன் சிறுகதை ஆளுமை" }, { num: 18, name: "தேம்பாவணி", c: "வீரமாமுனிவர் வளன் காப்பியம்" }] }
    ];
  } else if (lvl === 11) {
    units = [
      { num: 1, name: "இயல் 1: மொழி – யுகத்தின் பாடல்", chapters: [{ num: 1, name: "யுகத்தின் பாடல்", c: "சு. வில்வரத்தினம்" }, { num: 2, name: "பேச்சுமொழியும் கவிதைமொழியும்", c: "இந்திரன் நவீன மொழியியல்" }] },
      { num: 2, name: "இயல் 2: இயற்கை வேளாண்மை", chapters: [{ num: 3, name: "ஏங்குது பார் உலகம்", c: "நம்மாழ்வார் இயற்கை உழவு" }, { num: 4, name: "ஐங்குறுநூறு", c: "பேயனார் முல்லை நிலம்" }] },
      { num: 3, name: "இயல் 3: பண்பாடு – காவடிச்சிந்து", chapters: [{ num: 5, name: "காவடிச்சிந்து", c: "அண்ணாமலையார் வழிநடைச் சிந்து" }, { num: 6, name: "குறுந்தொகை", c: "வெள்ளிவீதியார்" }] },
      { num: 4, name: "இயல் 4: கல்வி – பிள்ளைக் கூடம்", chapters: [{ num: 7, name: "பிள்ளைக் கூடம்", c: "கல்யாண்ஜி குழந்தைமை புதுக்கவிதை" }, { num: 8, name: "இதழாளர் பாரதி", c: "பாரதியார் இதழியல் பணி" }] },
      { num: 5, name: "இயல் 5: நாகரிகம் – சீறாப்புராணம்", chapters: [{ num: 9, name: "சீறாப்புராணம்", c: "உமறுப்புலவர் நபிகள் நாயகம்" }, { num: 10, name: "அகநானூறு", c: "வீரை வெளியன் பாலை நிலம்" }] },
      { num: 6, name: "இயல் 6: கலை – குற்றாலக் குறவஞ்சி", chapters: [{ num: 11, name: "குற்றாலக் குறவஞ்சி", c: "திரிகூடராசப்ப கவிராயர்" }, { num: 12, name: "திருச்சாலல்", c: "மாணிக்கவாசகர் திருவாசகம்" }] },
      { num: 7, name: "இயல் 7: அறம் – புரட்சிக்கவி", chapters: [{ num: 13, name: "புரட்சிக்கவி", c: "பாரதிதாசன் புரட்சிக் காவியம்" }, { num: 14, name: "சிங்காரவேலர்", c: "ம. சிங்காரவேலர் தொழிலாளர் மேன்மை" }] },
      { num: 8, name: "இயல் 8: மனிதம் – மனோன்மணீயம்", chapters: [{ num: 15, name: "மனோன்மணீயம்", c: "பேராசிரியர் சுந்தரனார்" }, { num: 16, name: "தாகூர் சிறுகதைகள் – காபூலிவாலா", c: "ரவீந்திரநாத் தாகூர்" }] }
    ];
  } else if (lvl === 12) {
    units = [
      { num: 1, name: "இயல் 1: மொழி – இளந்தமிழே", chapters: [{ num: 1, name: "இளந்தமிழே!", c: "சிற்பி பாலசுப்பிரமணியம்" }, { num: 2, name: "தமிழாய் எழுதுவோம்", c: "தூய தமிழ் எழுதும் முறை" }] },
      { num: 2, name: "இயல் 2: இயற்கை – நெடுநல்வாடை", chapters: [{ num: 3, name: "நெடுநல்வாடை", c: "நக்கீரர் சங்க இலக்கியம்" }, { num: 4, name: "நால்வகை பொருத்தங்கள்", c: "திணை பால் எண் இடம்" }] },
      { num: 3, name: "இயல் 3: பண்பாடு – கம்பராமாயணம்", chapters: [{ num: 5, name: "கம்பராமாயணம்", c: "கம்பர் காப்பிய நயம்" }, { num: 6, name: "திருக்குறள்", c: "இல்வாழ்க்கை & செய்ந்நன்றி" }] },
      { num: 4, name: "இயல் 4: கல்வி – இதில் வெற்றி பெற", chapters: [{ num: 7, name: "இதில் வெற்றி பெற", c: "சுரதா கவிதை யாப்பு" }, { num: 8, name: "பாதுகாப்போம் சுற்றுப்புறம்", c: "சுற்றுச்சூழல் விழிப்புணர்வு" }] },
      { num: 5, name: "இயல் 5: நாகரிகம் – தெய்வமணிமாலை", chapters: [{ num: 9, name: "தெய்வமணிமாலை", c: "இராமலிங்க அடிகளார்" }, { num: 10, name: "தேவாரம்", c: "திருஞானசம்பந்தர்" }] },
      { num: 6, name: "இயல் 6: கலை – சிலப்பதிகாரம்", chapters: [{ num: 11, name: "சிலப்பதிகாரம்: காட்சிக் காதை", c: "சேரன் செங்குட்டுவன் கண்ணகி சிலை" }, { num: 12, name: "மெய்ப்பாட்டியல்", c: "தொல்காப்பியம் எண்வகை மெய்ப்பாடு" }] },
      { num: 7, name: "இயல் 7: அறம் – இலக்கியத்தின் நோக்கம்", chapters: [{ num: 13, name: "இலக்கியத்தின் நோக்கம்", c: "மு. வரதராசனார் வாழ்வியல் நெறி" }, { num: 14, name: "புறநானூறு", c: "பொன்முடியார் சங்க வீரம்" }] },
      { num: 8, name: "இயல் 8: மனிதம் – ரட்சணிய யாத்ரிகம்", chapters: [{ num: 15, name: "ரட்சணிய யாத்ரிகம்", c: "எச்.ஏ. கிருஷ்ணபிள்ளை கிறித்தவ கம்பன்" }, { num: 16, name: "கோபல்லபுரத்து மக்கள்", c: "கி. ராஜநாராயணன் கரிசல் கதை" }] }
    ];
  }

  subjectsList.push({
    board: "STATE_BOARD",
    classLevel: lvl,
    name: "Tamil",
    code: "TAM",
    icon: "📖",
    color: "#e84118",
    units: units
  });
}

// --- 1.2 STATE BOARD CLASSES 4 TO 10 (English, Maths, Science, Social Science) ---
for (let lvl = 4; lvl <= 10; lvl++) {
  // English
  subjectsList.push({
    board: "STATE_BOARD", classLevel: lvl, name: "English", code: "ENG", icon: "📚", color: "#fa8231",
    units: [
      { num: 1, name: "Term 1: Unit 1 – Learning & Adventure", chapters: [{ num: 1, name: `Prose 1: Inspiring Journeys (Std ${lvl})`, c: "Vocabulary & Reading" }, { num: 2, name: `Poem 1: Nature's Melody (Std ${lvl})`, c: "Rhyme Scheme & Figures of Speech" }] },
      { num: 2, name: "Term 1: Unit 2 – Values & Courage", chapters: [{ num: 3, name: `Prose 2: Acts of Bravery (Std ${lvl})`, c: "Grammar & Direct Indirect Speech" }, { num: 4, name: `Supplementary: Life Lessons (Std ${lvl})`, c: "Character Sketches & Morals" }] },
      { num: 3, name: "Term 2: Unit 3 – Art, Culture & Heritage", chapters: [{ num: 5, name: `Prose 3: Treasures of History (Std ${lvl})`, c: "Comprehension & Essay Writing" }, { num: 6, name: `Poem 2: Echoes of the Past (Std ${lvl})`, c: "Metaphors & Imagery" }] },
      { num: 4, name: "Term 2: Unit 4 – Science & Tomorrow", chapters: [{ num: 7, name: `Prose 4: Innovations Changing Lives (Std ${lvl})`, c: "Active Passive Voice & Tenses" }, { num: 8, name: `Supplementary: Dreams into Reality (Std ${lvl})`, c: "Plot Summary & Analysis" }] },
      { num: 5, name: "Term 3: Unit 5 – Environment & Harmony", chapters: [{ num: 9, name: `Prose 5: Guardians of Nature (Std ${lvl})`, c: "Clauses & Conjunctions" }, { num: 10, name: `Poem 3: The Green Earth (Std ${lvl})`, c: "Poetic Appreciation" }] },
      { num: 6, name: "Term 3: Unit 6 – Humanity & Sports", chapters: [{ num: 11, name: `Prose 6: Champions of the Game (Std ${lvl})`, c: "Formal Letter & Report Writing" }, { num: 12, name: `Supplementary: Triumph of Will (Std ${lvl})`, c: "Theme & Message" }] }
    ]
  });

  // Mathematics
  let mathUnits = [];
  if (lvl === 4 || lvl === 5) {
    mathUnits = [
      { num: 1, name: "Unit 1: Geometry & Shapes", chapters: [{ num: 1, name: "2D and 3D Shapes & Angles", c: "Perimeter & Properties of Figures" }] },
      { num: 2, name: "Unit 2: Numbers & Operations", chapters: [{ num: 2, name: "Large Numbers, Addition & Subtraction", c: "Place Value & Arithmetic Operations" }, { num: 3, name: "Multiplication & Division", c: "Word Problems & Estimation" }] },
      { num: 3, name: "Unit 3: Patterns & Symmetry", chapters: [{ num: 4, name: "Patterns in Shapes and Numbers", c: "Symmetry Lines & Sequences" }] },
      { num: 4, name: "Unit 4: Measurements & Metric System", chapters: [{ num: 5, name: "Length, Weight & Capacity", c: "Metric Conversions & Real-life sums" }] },
      { num: 5, name: "Unit 5: Time, Money & Fractions", chapters: [{ num: 6, name: "Time Calculation & Money Transactions", c: "Fractions & Basic Decimals" }] },
      { num: 6, name: "Unit 6: Information Processing", chapters: [{ num: 7, name: "Data Handling & Bar Charts", c: "Tables, Tally Marks & Representation" }] }
    ];
  } else if (lvl === 6) {
    mathUnits = [
      { num: 1, name: "Unit 1: Numbers & Whole Numbers", chapters: [{ num: 1, name: "Numbers & Number Operations", c: "Large Numbers, Place Value, BODMAS" }, { num: 2, name: "Whole Numbers & Prime Numbers", c: "Factors, Multiples, HCF & LCM" }] },
      { num: 2, name: "Unit 2: Introduction to Algebra", chapters: [{ num: 3, name: "Algebraic Expressions & Variables", c: "Forming Expressions & Linear Equations" }] },
      { num: 3, name: "Unit 3: Ratio and Proportion", chapters: [{ num: 4, name: "Ratio, Proportion & Unitary Method", c: "Equivalent Ratios & Applications" }] },
      { num: 4, name: "Unit 4: Geometry & Angles", chapters: [{ num: 5, name: "Lines, Angles & Triangles", c: "Types of Angles & Compass Constructions" }] },
      { num: 5, name: "Unit 5: Statistics & Data Handling", chapters: [{ num: 6, name: "Data Collection, Tally & Graphs", c: "Pictographs & Bar Graphs" }] },
      { num: 6, name: "Unit 6: Information Processing", chapters: [{ num: 7, name: "Systematic Listing & Tree Diagrams", c: "Combinatorics Basics" }] }
    ];
  } else if (lvl === 7) {
    mathUnits = [
      { num: 1, name: "Unit 1: Number System (Integers)", chapters: [{ num: 1, name: "Integers & Operations", c: "Properties of Addition & Multiplication" }] },
      { num: 2, name: "Unit 2: Measurements & Area", chapters: [{ num: 2, name: "Area of Parallelogram, Rhombus & Trapezium", c: "Formulae & Problem Solving" }] },
      { num: 3, name: "Unit 3: Algebra & Expressions", chapters: [{ num: 3, name: "Algebraic Terms, Degree & Operations", c: "Simplification & Evaluating Expressions" }] },
      { num: 4, name: "Unit 4: Direct and Inverse Proportion", chapters: [{ num: 4, name: "Direct Proportion & Inverse Proportion", c: "Unitary & Proportion Calculations" }] },
      { num: 5, name: "Unit 5: Geometry & Congruence", chapters: [{ num: 5, name: "Angles on Lines & Congruent Triangles", c: "Alternate & Corresponding Angles" }] },
      { num: 6, name: "Unit 6: Information Processing", chapters: [{ num: 6, name: "Graph Coloring & Route Finding", c: "Network Logic" }] }
    ];
  } else if (lvl === 8) {
    mathUnits = [
      { num: 1, name: "Unit 1: Rational Numbers & Exponents", chapters: [{ num: 1, name: "Rational Numbers & Operations", c: "Closure, Commutative & Associative Laws" }, { num: 2, name: "Square Roots, Cube Roots & Exponents", c: "Laws of Exponents & Prime Factorization" }] },
      { num: 2, name: "Unit 2: Measurements & Circle Sectors", chapters: [{ num: 3, name: "Length of Arc, Area of Sector & Perimeter", c: "Sector Formulas" }] },
      { num: 3, name: "Unit 3: Algebra & Identities", chapters: [{ num: 4, name: "Multiplication of Polynomials & Identities", c: "(a+b)^2, (a-b)^2, a^2-b^2" }, { num: 5, name: "Factorisation & Linear Inequations", c: "Common Factors & Solving Inequations" }] },
      { num: 4, name: "Unit 4: Life Mathematics", chapters: [{ num: 6, name: "Percentage, Profit, Loss & Discount", c: "Markup, Overhead Expenses & GST" }, { num: 7, name: "Compound Interest & Depreciation", c: "Formula A = P(1 + r/100)^n" }] },
      { num: 5, name: "Unit 5: Geometry & Quadrilaterals", chapters: [{ num: 8, name: "Properties of Quadrilaterals & Construction", c: "Parallelogram & Rhombus Construction" }] },
      { num: 6, name: "Unit 6: Statistics & Frequency Tables", chapters: [{ num: 9, name: "Grouped Frequency Tables & Histograms", c: "Histogram & Frequency Polygon" }] },
      { num: 7, name: "Unit 7: Information Processing", chapters: [{ num: 10, name: "Cryptology & Magic Squares", c: "Caesar Cipher & Encoding Methods" }] }
    ];
  } else if (lvl === 9) {
    mathUnits = [
      { num: 1, name: "Unit 1: Set Language", chapters: [{ num: 1, name: "Set Operations & Venn Diagrams", c: "Union, Intersection, Complement & De Morgan Laws" }] },
      { num: 2, name: "Unit 2: Real Numbers", chapters: [{ num: 2, name: "Surds, Rationalisation & Scientific Notation", c: "Radicals & Properties of Real Numbers" }] },
      { num: 3, name: "Unit 3: Algebra & Polynomials", chapters: [{ num: 3, name: "Polynomials, Remainder Theorem & Factor Theorem", c: "Factorisation of Cubics & Synthetic Division" }, { num: 4, name: "Linear Equations in Two Variables", c: "Simultaneous Equations & Elimination Method" }] },
      { num: 4, name: "Unit 4: Geometry & Circles", chapters: [{ num: 5, name: "Theorems on Triangles, Chords & Cyclic Quads", c: "Circumcentre, Incentre & Centroid" }] },
      { num: 5, name: "Unit 5: Coordinate Geometry", chapters: [{ num: 6, name: "Distance Formula & Section Formula", c: "Midpoint, Centroid & Area of Triangle" }] },
      { num: 6, name: "Unit 6: Trigonometry", chapters: [{ num: 7, name: "Trigonometric Ratios & Complementary Angles", c: "sin, cos, tan 0, 30, 45, 60, 90 deg" }] },
      { num: 7, name: "Unit 7: Mensuration", chapters: [{ num: 8, name: "Surface Area & Volume of Cuboids & Cylinders", c: "TSA, CSA & Volume Calculations" }] },
      { num: 8, name: "Unit 8: Statistics", chapters: [{ num: 9, name: "Mean, Median & Mode of Ungrouped & Grouped Data", c: "Measures of Central Tendency" }] },
      { num: 9, name: "Unit 9: Probability", chapters: [{ num: 10, name: "Empirical Probability & Events", c: "Coin Tossing, Dice Rolling & Card Problems" }] }
    ];
  } else if (lvl === 10) {
    mathUnits = [
      { num: 1, name: "Unit 1: Relations and Functions", chapters: [{ num: 1, name: "Cartesian Products & Relations", c: "Domain, Co-domain, Range" }, { num: 2, name: "Functions & Composition of Functions", c: "One-One, Onto, Bijection & f(g(x))" }] },
      { num: 2, name: "Unit 2: Numbers and Sequences", chapters: [{ num: 3, name: "Euclid's Division Lemma & Fundamental Theorem", c: "HCF, LCM & Prime Factorisation" }, { num: 4, name: "Arithmetic & Geometric Progressions (AP & GP)", c: "nth Term, Sum to n Terms & Special Series" }] },
      { num: 3, name: "Unit 3: Algebra", chapters: [{ num: 5, name: "Linear System & Polynomial GCD/LCM", c: "Simultaneous 3-variable systems & Square Roots" }, { num: 6, name: "Quadratic Equations & Matrices", c: "Roots Nature, Formula & Matrix Multiplication" }] },
      { num: 4, name: "Unit 4: Geometry", chapters: [{ num: 7, name: "Similarity Theorems & Basic Proportionality", c: "Thales Theorem, Angle Bisector & Pythagoras" }, { num: 8, name: "Circles, Tangents & Ceva / Menelaus", c: "Tangent Chord Theorem & Geometry Proofs" }] },
      { num: 5, name: "Unit 5: Coordinate Geometry", chapters: [{ num: 9, name: "Area of Triangle & Quadrilateral", c: "Shoelace Formula & Collinearity" }, { num: 10, name: "Slope of Straight Line & Equations of Lines", c: "y = mx + c, Point-Slope Form & Intercepts" }] },
      { num: 6, name: "Unit 6: Trigonometry", chapters: [{ num: 11, name: "Trigonometric Identities", c: "sin^2 + cos^2 = 1 & Proofs" }, { num: 12, name: "Heights and Distances", c: "Angle of Elevation & Angle of Depression" }] },
      { num: 7, name: "Unit 7: Mensuration", chapters: [{ num: 13, name: "Surface Area of Cone, Sphere, Hemisphere & Frustum", c: "TSA, CSA & Combined Solids" }, { num: 14, name: "Volume of Solids & Conversion of Solids", c: "Volume Conservation & Frustum Volume" }] },
      { num: 8, name: "Unit 8: Statistics and Probability", chapters: [{ num: 15, name: "Range, Variance & Standard Deviation", c: "Coefficient of Variation & Dispersion" }, { num: 16, name: "Probability & Addition Theorem of Probability", c: "P(A U B) = P(A) + P(B) - P(A n B)" }] }
    ];
  }

  subjectsList.push({
    board: "STATE_BOARD", classLevel: lvl, name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4",
    units: mathUnits
  });

  // Science
  let sciUnits = [];
  if (lvl <= 5) {
    sciUnits = [
      { num: 1, name: "Unit 1: Living World – Plants & Animals", chapters: [{ num: 1, name: "Plant Life, Flowers & Seeds", c: "Photosynthesis, Parts of Plants & Seed Germination" }, { num: 2, name: "Animal Classification & Habitats", c: "Vertebrates, Invertebrates & Adaptation" }] },
      { num: 2, name: "Unit 2: Human Body & Organ Systems", chapters: [{ num: 3, name: "Internal Organs, Bones & Muscles", c: "Brain, Heart, Lungs, Stomach & Digestion" }, { num: 4, name: "Sense Organs, Health & Hygiene", c: "Eyes, Ears, Skin care & Cleanliness" }] },
      { num: 3, name: "Unit 3: Matter, Energy & Forces", chapters: [{ num: 5, name: "States of Matter & Materials", c: "Solids, Liquids, Gases & Changes" }, { num: 6, name: "Work, Energy & Simple Machines", c: "Lever, Pulley, Wheel & Energy Forms" }] },
      { num: 4, name: "Unit 4: Air, Water & Environmental Care", chapters: [{ num: 7, name: "Air Composition & Properties", c: "Oxygen, Carbon Dioxide & Atmosphere" }, { num: 8, name: "Water Cycle & Conservation", c: "Evaporation, Condensation & Rainwater Harvesting" }] },
      { num: 5, name: "Unit 5: Science in Everyday Life", chapters: [{ num: 9, name: "Kitchen Science, Medicines & Clothes", c: "Natural Fibres, Hygiene & Home Remedies" }] }
    ];
  } else if (lvl === 6) {
    sciUnits = [
      { num: 1, name: "Unit 1: Physics – Measurement & Motion", chapters: [{ num: 1, name: "Measurements & SI Units", c: "Length, Mass, Time & Error Minimisation" }, { num: 2, name: "Forces and Motion", c: "Push, Pull, Contact / Non-contact forces" }] },
      { num: 2, name: "Unit 2: Physics – Electricity & Magnetism", chapters: [{ num: 3, name: "Electricity & Circuits", c: "Conductors, Insulators, Cells & Switches" }, { num: 4, name: "Magnetism & Magnetic Poles", c: "Magnetic Attraction, Compass & Care" }] },
      { num: 3, name: "Unit 3: Chemistry – Matter & Changes", chapters: [{ num: 5, name: "Matter Around Us", c: "Atoms, Molecules, Solids, Liquids, Gases" }, { num: 6, name: "Changes Around Us", c: "Reversible, Irreversible, Physical & Chemical" }] },
      { num: 4, name: "Unit 4: Chemistry – Water & Air", chapters: [{ num: 7, name: "Water – Life Sustainer", c: "Water Sources, Water Cycle & Scarcity" }, { num: 8, name: "Air Around Us", c: "Composition of Air, Burning & Respiration" }] },
      { num: 5, name: "Unit 5: Biology – Plant & Animal World", chapters: [{ num: 9, name: "The Living World of Plants", c: "Root & Shoot System, Photosynthesis" }, { num: 10, name: "Living World of Animals", c: "Unicellular vs Multicellular, Habitats" }] },
      { num: 6, name: "Unit 6: Biology – Health & Hygiene", chapters: [{ num: 11, name: "Health, Nutrients & Diseases", c: "Carbohydrates, Proteins, Vitamins & Balanced Diet" }] },
      { num: 7, name: "Unit 7: Computer Science Overview", chapters: [{ num: 12, name: "Introduction to Computers & Hardware", c: "Input/Output devices, CPU & OS" }] }
    ];
  } else if (lvl === 7) {
    sciUnits = [
      { num: 1, name: "Unit 1: Physics – Measurement & Motion", chapters: [{ num: 1, name: "Measurement of Derived Quantities", c: "Area, Volume, Density & Speed" }, { num: 2, name: "Force and Motion – Types of Motion", c: "Linear, Circular, Rotational & Periodic" }] },
      { num: 2, name: "Unit 2: Physics – Light & Heat", chapters: [{ num: 3, name: "Light – Reflection & Rectilinear Propagation", c: "Shadows, Mirrors, Reflection Laws & Spectrum" }, { num: 4, name: "Heat and Temperature", c: "Conduction, Convection, Radiation & Thermometer" }] },
      { num: 3, name: "Unit 3: Physics – Electricity", chapters: [{ num: 5, name: "Electric Current & Circuits", c: "Symbols, Simple Circuits & Effects of Current" }] },
      { num: 4, name: "Unit 4: Chemistry – Matter & Atomic Structure", chapters: [{ num: 6, name: "Matter Around Us – Elements & Compounds", c: "Symbols, Formulae & Atomicity" }, { num: 7, name: "Atomic Structure", c: "Electrons, Protons, Neutrons & Valency" }] },
      { num: 5, name: "Unit 5: Chemistry – Changes Around Us", chapters: [{ num: 8, name: "Physical & Chemical Changes", c: "Rusting, Crystallisation & Neutralisation" }] },
      { num: 6, name: "Unit 6: Biology – Plants & Living Organisms", chapters: [{ num: 9, name: "Reproduction & Modification in Plants", c: "Flowers, Pollination, Fertilisation & Root modifications" }, { num: 10, name: "Cell Structure & Functions", c: "Plant vs Animal Cell, Organelles & Nucleus" }] },
      { num: 7, name: "Unit 7: Biology – Health, Hygiene & Ecology", chapters: [{ num: 11, name: "Health and Hygiene – Microbes & Safety", c: "Bacterial/Viral Diseases & First Aid" }, { num: 12, name: "Ecosystems and Environment", c: "Food Chains, Food Webs & Biodiversity" }] }
    ];
  } else if (lvl === 8) {
    sciUnits = [
      { num: 1, name: "Unit 1: Physics – Mechanics & Pressure", chapters: [{ num: 1, name: "Measurement & Fundamental Quantities", c: "Vernier Calliper & Screw Gauge" }, { num: 2, name: "Forces, Pressure & Friction", c: "Pascal's Law, Atmospheric Pressure & Friction Types" }] },
      { num: 2, name: "Unit 2: Physics – Light, Sound & Heat", chapters: [{ num: 3, name: "Light – Spherical Mirrors & Refraction", c: "Concave/Convex Mirrors, Snell's Law" }, { num: 4, name: "Sound – Waves, Speed & Noise Pollution", c: "Frequency, Pitch, Amplitude & Ultrasound" }, { num: 5, name: "Heat – Thermal Expansion & Specific Heat", c: "Calorimetry & Greenhouse Effect" }] },
      { num: 3, name: "Unit 3: Physics – Electricity & Magnetism", chapters: [{ num: 6, name: "Electricity – Static & Current", c: "Electroscope, Chemical Effects & Electroplating" }, { num: 7, name: "Magnetism & Magnetic Fields", c: "Earth's Magnetism & Magnetic Lines of Force" }, { num: 8, name: "Universe and Space Science", c: "Rockets, ISRO Satellites & Solar System" }] },
      { num: 4, name: "Unit 4: Chemistry – Matter, Air & Water", chapters: [{ num: 9, name: "Matter Around Us – Metals & Non-Metals", c: "Physical & Chemical Properties, Corrosion" }, { num: 10, name: "Air & Oxygen Preparation", c: "Oxygen, Nitrogen, Carbon Dioxide properties" }, { num: 11, name: "Water Purification & Hardness", c: "Temporary/Permanent Hardness & Softening" }] },
      { num: 5, name: "Unit 5: Chemistry – Atomic Structure & Reactions", chapters: [{ num: 12, name: "Atomic Structure & Chemical Bonding", c: "Dalton / Thomson / Rutherford Models & Covalent / Ionic Bonds" }, { num: 13, name: "Acids, Bases and Salts", c: "pH Scale, Indicators & Industrial Uses" }, { num: 14, name: "Chemistry in Everyday Life", c: "Polymers, Plastics, Glass, Dyes & Drugs" }] },
      { num: 6, name: "Unit 6: Biology – Microorganisms & Plants", chapters: [{ num: 15, name: "Microorganisms – Bacteria, Fungi, Viruses", c: "Beneficial & Harmful Microbes, Vaccines" }, { num: 16, name: "Plant Kingdom – Cryptogams & Phanerogams", c: "Algae, Bryophytes, Pteridophytes & Gymnosperms" }] },
      { num: 7, name: "Unit 7: Biology – Animal Systems & Adolescence", chapters: [{ num: 17, name: "Organisation of Life & Tissues", c: "Epithelial, Muscular, Nervous Tissues" }, { num: 18, name: "Movements in Animals – Skeleton & Joints", c: "Human Skeletal System & Locomotion" }, { num: 19, name: "Reaching the Age of Adolescence", c: "Endocrine Glands, Hormones & Reproductive Health" }] },
      { num: 8, name: "Unit 8: Biology – Agriculture & Conservation", chapters: [{ num: 20, name: "Crop Production and Management", c: "Irrigation, Weeding, Harvesting & Storage" }, { num: 21, name: "Conservation of Plants and Animals", c: "Deforestation, Red Data Book, National Parks" }] }
    ];
  } else if (lvl === 9) {
    sciUnits = [
      { num: 1, name: "Unit 1: Physics – Measurement & Mechanics", chapters: [{ num: 1, name: "Measurement – Screw Gauge & Balance", c: "Zero Error & Least Count" }, { num: 2, name: "Motion – Equations of Motion", c: "v = u + at, s = ut + 1/2at^2, v^2 = u^2 + 2as" }, { num: 3, name: "Fluids – Archimedes Principle & Density", c: "Buoyancy, Pascal Law & Relative Density" }] },
      { num: 2, name: "Unit 2: Physics – Electricity & Magnetism", chapters: [{ num: 4, name: "Electric Charge and Electric Current", c: "Ohm's Law, Resistance in Series/Parallel" }, { num: 5, name: "Magnetism and Electromagnetism", c: "Magnetic Induction, Solenoid & Electric Motors" }] },
      { num: 3, name: "Unit 3: Physics – Light, Sound & Heat", chapters: [{ num: 6, name: "Light – Reflection, Refraction & Lenses", c: "Lens Formula, Magnification & Power" }, { num: 7, name: "Heat – Latent Heat & Thermodynamics Basics", c: "Specific Heat Capacity & Phase Transitions" }, { num: 8, name: "Sound – SONAR, Echo & Ultrasonic Waves", c: "Echo Distance Calculation & Hearing Mechanism" }, { num: 9, name: "Universe – Gravitation & Space Science", c: "Universal Law of Gravitation & Kepler's Laws" }] },
      { num: 4, name: "Unit 4: Chemistry – Matter & Atomic Structure", chapters: [{ num: 10, name: "Matter Around Us – Solutions & Colloids", c: "True Solution, Suspension, Tyndall Effect" }, { num: 11, name: "Atomic Structure – Subatomic Particles", c: "Bohr's Model, Electronic Configuration & Isotopes" }, { num: 12, name: "Periodic Classification of Elements", c: "Mendeleev & Modern Periodic Table, Trends" }] },
      { num: 5, name: "Unit 5: Chemistry – Chemical Bonding & Acids", chapters: [{ num: 13, name: "Chemical Bonding – Ionic & Covalent", c: "Lewis Dot Structures, Polar & Non-Polar" }, { num: 14, name: "Acids, Bases and Salts – Indicators", c: "Arrhenius Concept, pH & Neutralisation" }, { num: 15, name: "Carbon and its Compounds – Allotropes", c: "Diamond, Graphite, Fullerenes & Hydrocarbons" }, { num: 16, name: "Applied Chemistry – Electrochemistry & Fertilisers", c: "Soaps, Detergents, Biofertilisers & Polymers" }] },
      { num: 6, name: "Unit 6: Biology – Animal Kingdom & Tissues", chapters: [{ num: 17, name: "Animal Kingdom – Invertebrates & Chordates", c: "Porifera to Mammalia Classification" }, { num: 18, name: "Organisation of Tissues – Meristematic & Permanent", c: "Xylem, Phloem, Connective Tissue & Blood" }] },
      { num: 7, name: "Unit 7: Biology – Plant Physiology & Nutrition", chapters: [{ num: 19, name: "Plant Physiology – Tropism & Photosynthesis", c: "Phototropism, Transpiration & Respiration" }, { num: 20, name: "Organ Systems in Animals – Excretion & Nervous", c: "Nephron Function, Brain Structure & Reflex Arc" }, { num: 21, name: "Nutrition and Health – Food Adulteration", c: "Malnutrition, Vitamins & Deficiency Diseases" }] },
      { num: 8, name: "Unit 8: Biology – Microbes & Environment", chapters: [{ num: 22, name: "World of Microbes – Virology & Immunology", c: "Antigens, Antibodies & Antibiotics" }, { num: 23, name: "Economic Biology – Floriculture, Dairy, Pisciculture", c: "Apiculture, Sericulture & Vermicomposting" }, { num: 24, name: "Environmental Science – Biogeochemical Cycles", c: "Carbon Cycle, Nitrogen Cycle & Waste Management" }] }
    ];
  } else if (lvl === 10) {
    sciUnits = [
      { num: 1, name: "Unit 1: Physics – Laws of Motion & Gravitation", chapters: [{ num: 1, name: "Laws of Motion & Inertia", c: "Newton's 1st, 2nd, 3rd Laws, Momentum & F=ma" }, { num: 2, name: "Universal Gravitation & Weightlessness", c: "G Constant, Free Fall & Mass vs Weight" }] },
      { num: 2, name: "Unit 2: Physics – Optics, Thermal & Sound", chapters: [{ num: 3, name: "Optics – Refraction, Lenses & Human Eye", c: "Snell's Law, Lens Formula, Dispersion & Eye defects" }, { num: 4, name: "Thermal Physics – Gas Laws & Expansion", c: "Boyle's Law, Charles's Law & Ideal Gas PV=nRT" }, { num: 5, name: "Acoustics – Velocity of Sound & Doppler Effect", c: "Laplace Correction & Frequency Shift" }] },
      { num: 3, name: "Unit 3: Physics – Electricity & Nuclear Physics", chapters: [{ num: 6, name: "Electricity – Ohm's Law & Joule's Heating", c: "V=IR, Resistivity, Electric Power & Fuse Wire" }, { num: 7, name: "Nuclear Physics – Radioactivity & Nuclear Energy", c: "Alpha, Beta, Gamma rays, Fission & Fusion" }] },
      { num: 4, name: "Unit 4: Chemistry – Atoms, Molecules & Periodic Table", chapters: [{ num: 8, name: "Atoms and Molecules – Mole Concept", c: "Avogadro's Number 6.023x10^23, Molar Mass" }, { num: 9, name: "Periodic Classification of Elements", c: "Modern Periodic Law, Groups & Periods Trends" }] },
      { num: 5, name: "Unit 5: Chemistry – Solutions & Chemical Reactions", chapters: [{ num: 10, name: "Solutions – Solubility & Concentration", c: "Solute, Solvent, Saturated & Mass Percentage" }, { num: 11, name: "Types of Chemical Reactions – Equilibrium & pH", c: "Combination, Decomposition, Redox, pH Calculations" }, { num: 12, name: "Carbon and its Compounds – IUPAC Nomenclature", c: "Functional Groups, Homologous Series & Ethanol" }] },
      { num: 6, name: "Unit 6: Biology – Plant Anatomy & Animal Physiology", chapters: [{ num: 13, name: "Plant Anatomy and Plant Physiology", c: "Root/Stem Anatomy, Chloroplast, Light/Dark Reactions" }, { num: 14, name: "Structural Organisation of Animals – Leech & Rabbit", c: "Digestive, Circulatory & Reproductive Anatomy" }, { num: 15, name: "Transportation in Plants & Circulation in Animals", c: "Ascent of Sap, Blood Components, Heart & Cardiac Cycle" }] },
      { num: 7, name: "Unit 7: Biology – Nervous System, Hormones & Genetics", chapters: [{ num: 16, name: "Nervous System & Brain Function", c: "Neuron, Synapse, CNS, PNS & Reflex Action" }, { num: 17, name: "Plant and Animal Hormones – Endocrine System", c: "Auxins, Gibberellins, Thyroid, Insulin & Adrenaline" }, { num: 18, name: "Reproduction in Plants and Animals", c: "Pollination, Fertilisation, Human Reproduction & Hygiene" }, { num: 19, name: "Heredity & Mendel's Laws", c: "Monohybrid / Dihybrid Cross, DNA Structure & Chromosomes" }] },
      { num: 8, name: "Unit 8: Biology – Evolution, Biotechnology & Ecology", chapters: [{ num: 20, name: "Origin and Evolution of Life", c: "Lamarckism, Darwinism & Speciation" }, { num: 21, name: "Breeding and Biotechnology – Gene Therapy", c: "Hybridisation, Mutation Breeding & Recombinant DNA" }, { num: 22, name: "Health and Diseases – Lifestyle & Infectious", c: "Diabetes, Cancer, AIDS & Immunisation" }, { num: 23, name: "Environmental Management – Conservation & Energy", c: "Renewable Energy, Rainwater Harvesting & Wildlife" }] }
    ];
  }

  subjectsList.push({
    board: "STATE_BOARD", classLevel: lvl, name: "Science", code: "SCI", icon: "🔬", color: "#eb4d4b",
    units: sciUnits
  });

  // Social Science
  let socUnits = [];
  if (lvl <= 5) {
    socUnits = [
      { num: 1, name: "Unit 1: Earth, Continents & Oceans", chapters: [{ num: 1, name: "Our Planet Earth, Continents & Oceans", c: "Globe, Equator, Continents & Oceans" }] },
      { num: 2, name: "Unit 2: History – Ancient Tamil Civilisation", chapters: [{ num: 2, name: "Kingdoms of Rivers (Chera, Chola, Pandya, Pallava)", c: "Kings, Emblems, Ports & Capital Cities" }, { num: 3, name: "Philanthropists of Ancient Tamilagam (Kadai Ezhu Vallalgal)", c: "Pari, Pegan, Kari, Ay, Adiyaman, Nalli, Ori" }] },
      { num: 3, name: "Unit 3: Geography – Landforms & Resources", chapters: [{ num: 4, name: "Five Landforms of Ancient Tamil Country", c: "Kurinji, Mullai, Marutham, Neithal, Palai" }, { num: 5, name: "Atmosphere, Weather & Water Wealth", c: "Monsoon, Rivers of Tamil Nadu & Rain" }] },
      { num: 4, name: "Unit 4: Civics – Duties, Rights & Governance", chapters: [{ num: 6, name: "Municipalities, Corporations & Local Governance", c: "Mayor, Commissioner, Wards & Citizen Duties" }, { num: 7, name: "Rights and Duties of a Good Citizen", c: "Fundamental Duties, Traffic Safety & Harmony" }] }
    ];
  } else if (lvl === 6) {
    socUnits = [
      { num: 1, name: "Unit 1: History – Ancient Civilisations & Tamil Heritage", chapters: [{ num: 1, name: "What is History? & Prehistoric Humans", c: "Archaeological Sources, Inscriptions & Evolution" }, { num: 2, name: "Indus Civilisation & Ancient Cities of Tamilagam", c: "Harappa, Mohenjo-daro, Keezhadi, Korkai & Poompuhar" }] },
      { num: 2, name: "Unit 2: History – Great Empires & Thinkers", chapters: [{ num: 3, name: "Vedic Culture, Jainism & Buddhism", c: "Mahavira, Gautama Buddha & Epics" }, { num: 4, name: "From Chiefdoms to Empires – Maurya & Sangam Age", c: "Emperor Ashoka, Edicts & Tamil Sangam Literature" }] },
      { num: 3, name: "Unit 3: Geography – Solar System & Globe", chapters: [{ num: 5, name: "The Universe and Solar System", c: "Sun, Planets, Satellites, Rotation & Revolution" }, { num: 6, name: "Land and Oceans – Continents & Relief Features", c: "Plateaus, Plains, Mountains, Pacific & Indian Ocean" }] },
      { num: 4, name: "Unit 4: Geography – Asia & Tamil Nadu Overview", chapters: [{ num: 7, name: "Understanding Asia and Regional Geography", c: "Physical Features, Climate, Vegetation & Resources" }] },
      { num: 5, name: "Unit 5: Civics – Diversity, Equality & Democracy", chapters: [{ num: 8, name: "Understanding Diversity & Achieving Equality", c: "Unity in Diversity, Constitution & Anti-discrimination" }, { num: 9, name: "National Symbols & Indian Constitution Basics", c: "National Flag, Emblem, Anthem & Democratic Values" }] },
      { num: 6, name: "Unit 6: Economics – Production & Livelihoods", chapters: [{ num: 10, name: "Economics – An Introduction to Goods & Services", c: "Primary, Secondary, Tertiary Sectors & Barter System" }] }
    ];
  } else if (lvl === 7) {
    socUnits = [
      { num: 1, name: "Unit 1: History – Medieval India & Southern Dynasties", chapters: [{ num: 1, name: "Sources of Medieval India", c: "Inscriptions, Monuments, Coins & Travellers accounts" }, { num: 2, name: "Emergence of New Kingdoms – Cholas and Pandyas", c: "Rajaraja Chola, Rajendra Chola & Temple Architecture" }] },
      { num: 2, name: "Unit 2: History – Sultanates & Vijayanagar Empire", chapters: [{ num: 3, name: "The Delhi Sultanate (Slave to Lodi Dynasties)", c: "Qutb-ud-din, Alauddin Khalji & Muhammad bin Tughlaq" }, { num: 4, name: "The Vijayanagar and Bahmani Kingdoms", c: "Harihara, Bukka, Krishnadevaraya & Administration" }] },
      { num: 3, name: "Unit 3: Geography – Earth Interior, Resources & Weather", chapters: [{ num: 5, name: "Interior of the Earth & Plate Tectonics", c: "Crust, Mantle, Core, Earthquakes & Volcanoes" }, { num: 6, name: "Weather and Climate – Wind & Humidity", c: "Atmospheric Pressure, Monsoons & Cyclones" }] },
      { num: 4, name: "Unit 4: Geography – Population, Settlement & Tourism", chapters: [{ num: 7, name: "Human Settlements, Migration & Tourism", c: "Urbanisation, Cultural Tourism & World Heritage Sites" }] },
      { num: 5, name: "Unit 5: Civics – State Government & Media", chapters: [{ num: 8, name: "How the State Government Works", c: "Governor, Chief Minister, MLAs & Legislative Assembly" }, { num: 9, name: "Media and Democracy & Women Empowerment", c: "Fourth Pillar of Democracy, Gender Equality" }] },
      { num: 6, name: "Unit 6: Economics – Production, Tax & Markets", chapters: [{ num: 10, name: "Production, Factors of Production & Taxes", c: "Land, Labour, Capital, Organization & Direct/Indirect Taxes" }] }
    ];
  } else if (lvl === 8) {
    socUnits = [
      { num: 1, name: "Unit 1: History – Colonialism & Rebellions in India", chapters: [{ num: 1, name: "Advent of the Europeans – Portuguese to British", c: "Vasco da Gama, Battle of Plassey 1757, Buxar 1764" }, { num: 2, name: "From Trade to Territory – Subsidiary Alliance & Lapse", c: "Lord Wellesley & Dalhousie policies" }, { num: 3, name: "Rural Life and Society – Permanent Settlement & Ryotwari", c: "Land Revenue Systems & Peasant Revolts" }] },
      { num: 2, name: "Unit 2: History – Great Revolt of 1857 & Social Reforms", chapters: [{ num: 4, name: "People's Revolt – South Indian Rebellion & 1857 Revolt", c: "Kattabomman, Maruthu Brothers, Mangal Pandey, Rani Lakshmibai" }, { num: 5, name: "Educational Development & Social Reforms in India", c: "Wood's Despatch, Raja Ram Mohan Roy, Vidyasagar & Periyar" }] },
      { num: 3, name: "Unit 3: Geography – Rocks, Soils, Weather & Hydrology", chapters: [{ num: 6, name: "Rocks and Soils – Types & Soil Conservation", c: "Igneous, Sedimentary, Metamorphic rocks & Soil Profiles" }, { num: 7, name: "Weather, Climate & Hydrologic Cycle", c: "Precipitation, Infiltration & Evapotranspiration" }] },
      { num: 4, name: "Unit 4: Geography – Hazards, Migration & Industries", chapters: [{ num: 8, name: "Hazards and Disaster Management", c: "Floods, Droughts, Tsunamis & Disaster Mitigation" }, { num: 9, name: "Migration, Urbanisation & Industries Classification", c: "Push/Pull Factors, Agro/Mineral based Industries" }] },
      { num: 5, name: "Unit 5: Civics – Constitution, Secularism & Rights", chapters: [{ num: 10, name: "Citizen and Citizenship – Indian Citizenship Act 1955", c: "Acquisition & Loss of Citizenship" }, { num: 11, name: "Understanding Secularism & Human Rights / UNO", c: "Articles 25-28, UDHR 1948 & National Human Rights Commission" }, { num: 12, name: "Road Safety Rules and Regulations", c: "Traffic Signs, Mandatory Rules & Road Safety Measures" }] },
      { num: 6, name: "Unit 6: Economics – Money, Savings & Public Sector", chapters: [{ num: 13, name: "Money, Savings and Investments", c: "Functions of Money, Plastic Money & Digital Payments" }, { num: 14, name: "Public and Private Sectors in India", c: "PSUs, Mixed Economy & Socio-Economic Goals" }] }
    ];
  } else if (lvl === 9) {
    socUnits = [
      { num: 1, name: "Unit 1: History – Evolution of Humans & Early World", chapters: [{ num: 1, name: "Evolution of Humans and Society – Prehistoric Period", c: "Palaeolithic, Mesolithic, Neolithic & Metal Ages" }, { num: 2, name: "Early Civilisations of the Ancient World", c: "Mesopotamia, Egyptian, Indus & Chinese Civilisations" }] },
      { num: 2, name: "Unit 2: History – Sangam Tamil Society & World Revolutions", chapters: [{ num: 3, name: "Early Tamil Society and Culture – Epigraphy & Trade", c: "Sangam Epics, Roman Trade, Arikamedu & Keezhadi" }, { num: 4, name: "Age of Revolutions – American, French & Industrial", c: "Liberty, Equality, Fraternity & Industrial Transformation" }] },
      { num: 3, name: "Unit 3: Geography – Lithosphere & Atmosphere", chapters: [{ num: 5, name: "Lithosphere – Endogenic and Exogenic Processes", c: "Plate Tectonics, Weathering, Rivers & Glaciers" }, { num: 6, name: "Atmosphere – Structure, Insolation & Winds", c: "Troposphere to Exosphere, Planetary Winds & Jet Streams" }] },
      { num: 4, name: "Unit 4: Geography – Hydrosphere, Biosphere & Disaster Management", chapters: [{ num: 7, name: "Hydrosphere – Ocean Relief & Currents", c: "Continental Shelf, Ocean Trenches & Gulf Stream" }, { num: 8, name: "Biosphere – Biomes & Environmental Conservation", c: "Tropical Rainforests, Savannas & Biodiversity Hotspots" }] },
      { num: 5, name: "Unit 5: Civics – Democracy, Elections & Human Rights", chapters: [{ num: 9, name: "Forms of Government and Democracy", c: "Direct vs Representative Democracy & Constitution" }, { num: 10, name: "Election, Political Parties and Pressure Groups", c: "Election Commission of India & EVM voting system" }, { num: 11, name: "Fundamental Rights, Duties & Local Self Government", c: "Panchayati Raj, 73rd/74th Constitutional Amendments" }] },
      { num: 6, name: "Unit 6: Economics – Development, Money & Agriculture", chapters: [{ num: 12, name: "Understanding Development – Perspectives & Indicators", c: "PCI, HDI, Sustainable Development Goals" }, { num: 13, name: "Employment in India and Tamil Nadu", c: "Organised vs Unorganised Sectors" }, { num: 14, name: "Money, Credit & Agriculture in Tamil Nadu", c: "Banking, SHGs, Crop Patterns & Cauvery Delta" }] }
    ];
  } else if (lvl === 10) {
    socUnits = [
      { num: 1, name: "Unit 1: History – Imperialism & World Wars", chapters: [{ num: 1, name: "Outbreak of World War I and its Aftermath", c: "Causes, Battle of Marne, Treaty of Versailles 1919" }, { num: 2, name: "World between Two World Wars – Great Depression & Fascism", c: "Wall Street Crash 1929, Mussolini & Hitler" }, { num: 3, name: "World War II and Holocaust", c: "Axis vs Allies, Pearl Harbor, Hiroshima & UN Formation" }] },
      { num: 2, name: "Unit 2: History – Reform Movements & Freedom Struggle", chapters: [{ num: 4, name: "Social and Religious Reform Movements in the 19th Century", c: "Brahmo Samaj, Arya Samaj, Ramakrishna Mission, Theosophical" }, { num: 5, name: "Early Revolts against British Rule in Tamil Nadu", c: "Palayakkarars, Veerapandiya Kattabomman, Vellore Revolt 1806" }, { num: 6, name: "Anti-Colonial Movements & Nationalism: Gandhian Phase", c: "Non-Cooperation, Civil Disobedience, Quit India 1942" }, { num: 7, name: "Freedom Struggle & Social Transformation in Tamil Nadu", c: "V.O.C., Subramania Bharati, Rajaji, Periyar Self-Respect Movement" }] },
      { num: 3, name: "Unit 3: Geography – Physical Geography of India", chapters: [{ num: 8, name: "India – Location, Relief and Drainage", c: "Himalayas, Northern Plains, Peninsular Plateau & River Systems" }, { num: 9, name: "Climate and Natural Vegetation of India", c: "Southwest/Northeast Monsoons & Forest Types" }] },
      { num: 4, name: "Unit 4: Geography – Agriculture, Resources & TN Geography", chapters: [{ num: 10, name: "India – Agriculture & Irrigation", c: "Food Crops, Cash Crops, Green Revolution & Dam Projects" }, { num: 11, name: "India – Resources, Industries, Transport & Trade", c: "Iron, Coal, Petroleum, Cotton Textiles, Railways & Ports" }, { num: 12, name: "Physical & Human Geography of Tamil Nadu", c: "Western/Eastern Ghats, Soil, Industries & Smart Cities" }] },
      { num: 5, name: "Unit 5: Civics – Indian Constitution & Governance", chapters: [{ num: 13, name: "Indian Constitution – Features, Preamble & Rights", c: "Fundamental Rights, DPSP, Fundamental Duties & Amendments" }, { num: 14, name: "Central Government – President, Prime Minister & Parliament", c: "Lok Sabha, Rajya Sabha & Supreme Court of India" }, { num: 15, name: "State Government – Governor, CM & High Court", c: "State Executive, Legislature & Judiciary" }, { num: 16, name: "India's Foreign Policy and International Relations", c: "Panchsheel, Non-Alignment, SAARC & BRICS" }] },
      { num: 6, name: "Unit 6: Economics – GDP, Globalisation & Taxes", chapters: [{ num: 17, name: "Gross Domestic Product and its Growth – Sectors of Economy", c: "Primary, Secondary, Tertiary & National Income Methods" }, { num: 18, name: "Globalisation and Trade – WTO & MNCs", c: "Foreign Trade Policy, Liberalisation & SEZs" }, { num: 19, name: "Food Security, Nutrition, Government and Taxes", c: "PDS System, Direct/Indirect Taxes, GST & Industrial Clusters" }] }
    ];
  }

  subjectsList.push({
    board: "STATE_BOARD", classLevel: lvl, name: "Social Science", code: "SOC", icon: "🌍", color: "#10ac84",
    units: socUnits
  });
}

// --- 1.3 STATE BOARD HIGHER SECONDARY (Classes 11 & 12) ---
for (let lvl of [11, 12]) {
  // English (11 & 12)
  subjectsList.push({
    board: "STATE_BOARD", classLevel: lvl, name: "English", code: "ENG", icon: "📚", color: "#fa8231",
    units: [
      { num: 1, name: "Unit 1: Prose & Poetry Collection", chapters: [{ num: 1, name: `Prose Study (Class ${lvl})`, c: "Advanced Vocabulary & Comprehension" }, { num: 2, name: `Poetry Analysis (Class ${lvl})`, c: "Tone, Alliteration & Poetic Devices" }] },
      { num: 2, name: "Unit 2: Short Stories & Supplementary Reader", chapters: [{ num: 3, name: `Supplementary Fiction (Class ${lvl})`, c: "Plot Structure & Conflict" }, { num: 4, name: `Drama & Dialogue (Class ${lvl})`, c: "Dramatic Irony & Staging" }] },
      { num: 3, name: "Unit 3: Professional Communication & Writing Skills", chapters: [{ num: 5, name: `Formal Essays & Letter to Editor (Class ${lvl})`, c: "Cohesion, Modifiers & Argumentation" }, { num: 6, name: `Report Writing & Summary Making (Class ${lvl})`, c: "Precision, Note-Making & Formatting" }] }
    ]
  });

  // Physics (Class 11 & 12)
  let phyUnits = [];
  if (lvl === 11) {
    phyUnits = [
      { num: 1, name: "Unit 1: Nature of Physical World and Measurement", chapters: [{ num: 1, name: "Physical World, Units and Dimensions", c: "Dimensional Analysis, Errors & Significant Figures" }] },
      { num: 2, name: "Unit 2: Kinematics", chapters: [{ num: 2, name: "Vectors, Projectile Motion & Uniform Motion", c: "Equations of Motion & Relative Velocity" }] },
      { num: 3, name: "Unit 3: Laws of Motion", chapters: [{ num: 3, name: "Newton's Laws, Friction & Circular Motion", c: "Frictional Forces, Banking of Curves & Centripetal Acceleration" }] },
      { num: 4, name: "Unit 4: Work, Energy and Power", chapters: [{ num: 4, name: "Work-Energy Theorem & Collisions", c: "Conservative Forces, Elastic/Inelastic Collisions" }] },
      { num: 5, name: "Unit 5: Motion of System of Particles & Rigid Bodies", chapters: [{ num: 5, name: "Centre of Mass, Torque & Moment of Inertia", c: "Parallel & Perpendicular Axis Theorems" }] },
      { num: 6, name: "Unit 6: Gravitation", chapters: [{ num: 6, name: "Kepler's Laws, Gravitational Potential & Escape Velocity", c: "Orbital Velocity & Geo-stationary Satellites" }] },
      { num: 7, name: "Unit 7: Properties of Matter", chapters: [{ num: 7, name: "Elasticity, Viscosity, Surface Tension & Fluids", c: "Hooke's Law, Stokes' Law & Bernoulli's Theorem" }] },
      { num: 8, name: "Unit 8: Heat and Thermodynamics", chapters: [{ num: 8, name: "Thermodynamic Laws, Heat Engines & Carnot Cycle", c: "First & Second Laws of Thermodynamics, Efficiency" }] },
      { num: 9, name: "Unit 9: Kinetic Theory of Gases", chapters: [{ num: 9, name: "Ideal Gas Law, Degrees of Freedom & Equipartition", c: "RMS Velocity & Specific Heat of Gases" }] },
      { num: 10, name: "Unit 10: Oscillations & Waves", chapters: [{ num: 10, name: "Simple Harmonic Motion, Pendulum & Wave Propagation", c: "Resonance, Beats, Standing Waves & Doppler Effect" }] }
    ];
  } else {
    phyUnits = [
      { num: 1, name: "Unit 1: Electrostatics", chapters: [{ num: 1, name: "Coulomb's Law, Electric Field & Gauss's Law", c: "Electric Dipole, Potential & Capacitance" }] },
      { num: 2, name: "Unit 2: Current Electricity", chapters: [{ num: 2, name: "Ohm's Law, Kirchhoff's Rules & Wheatstone Bridge", c: "Potentiometer, Drift Velocity & Colour Code" }] },
      { num: 3, name: "Unit 3: Magnetism & Magnetic Effects of Current", chapters: [{ num: 3, name: "Biot-Savart Law, Ampere's Law & Cyclotron", c: "Lorentz Force, Moving Coil Galvanometer & Magnetic Dipole" }] },
      { num: 4, name: "Unit 4: Electromagnetic Induction & Alternating Current", chapters: [{ num: 4, name: "Faraday's Laws, Lenz's Law, AC Generator & LCR Circuit", c: "Self/Mutual Induction, Power Factor & Resonance" }] },
      { num: 5, name: "Unit 5: Electromagnetic Waves & Optics", chapters: [{ num: 5, name: "EM Spectrum, Wave Optics & Ray Optics", c: "Huygens' Principle, Interference, Diffraction, Polarization & Lenses" }] },
      { num: 6, name: "Unit 6: Dual Nature of Radiation & Atomic Physics", chapters: [{ num: 6, name: "Photoelectric Effect, Bohr Model & Hydrogen Spectrum", c: "Einstein's Equation, de Broglie Wavelength & Energy Levels" }] },
      { num: 7, name: "Unit 7: Nuclear Physics", chapters: [{ num: 7, name: "Radioactivity, Mass Defect, Fission & Fusion", c: "Half-life, Binding Energy Curve & Nuclear Reactors" }] },
      { num: 8, name: "Unit 8: Semiconductor Electronics & Communication", chapters: [{ num: 8, name: "p-n Junction Diode, Transistors & Logic Gates", c: "Rectifiers, Amplifiers, AND/OR/NAND/NOR gates & Modulation" }] }
    ];
  }
  subjectsList.push({
    board: "STATE_BOARD", classLevel: lvl, name: "Physics", code: "PHY", icon: "⚡", color: "#3867d6",
    units: phyUnits
  });

  // Chemistry (Class 11 & 12)
  let chemUnits = [];
  if (lvl === 11) {
    chemUnits = [
      { num: 1, name: "Unit 1: Basic Concepts of Chemistry & Calculations", chapters: [{ num: 1, name: "Mole Concept, Stoichiometry & Redox Reactions", c: "Oxidation Numbers & Balancing Equations" }] },
      { num: 2, name: "Unit 2: Quantum Mechanical Model of Atom", chapters: [{ num: 2, name: "Quantum Numbers, Aufbau, Pauli & Hund's Rule", c: "Schrodinger Wave Equation & Orbitals" }] },
      { num: 3, name: "Unit 3: Periodic Classification & Chemical Bonding", chapters: [{ num: 3, name: "Periodic Trends, VSEPR & Hybridisation", c: "Electronegativity, Ionisation Energy & Molecular Orbitals" }] },
      { num: 4, name: "Unit 4: States of Matter & Thermodynamics", chapters: [{ num: 4, name: "Gaseous State, Van der Waals & Enthalpy/Entropy", c: "First, Second Laws & Gibbs Free Energy" }] },
      { num: 5, name: "Unit 5: Chemical Equilibrium & Solutions", chapters: [{ num: 5, name: "Le Chatelier's Principle & Colligative Properties", c: "Kc, Kp, Raoult's Law & Osmotic Pressure" }] },
      { num: 6, name: "Unit 6: Fundamentals of Organic Chemistry & Hydrocarbons", chapters: [{ num: 6, name: "IUPAC Nomenclature, Isomerism & Reactions", c: "Electrophiles, Nucleophiles, Alkanes, Alkenes, Alkynes & Benzene" }] }
    ];
  } else {
    chemUnits = [
      { num: 1, name: "Unit 1: Metallurgy & Solid State", chapters: [{ num: 1, name: "Extraction of Metals & Crystal Lattices", c: "Ellingham Diagram, Unit Cells, Packing Efficiency & Defects" }] },
      { num: 2, name: "Unit 2: p-Block, d-Block & Coordination Chemistry", chapters: [{ num: 2, name: "Transition Elements, Lanthanoids & Coordination Complexes", c: "Werner's Theory, Crystal Field Theory & Isomerism" }] },
      { num: 3, name: "Unit 3: Chemical Kinetics & Electrochemistry", chapters: [{ num: 3, name: "Rate Laws, Arrhenius Equation & Nernst Equation", c: "Order of Reaction, Galvanic Cells, Kohlrausch Law & Batteries" }] },
      { num: 4, name: "Unit 4: Surface Chemistry & Ionic Equilibrium", chapters: [{ num: 4, name: "Adsorption, Colloids & Buffer Solutions", c: "Freundlich Isotherm, Henderson Equation & Solubility Product" }] },
      { num: 5, name: "Unit 5: Organic Compounds – Carbonyls, Amines & Biomolecules", chapters: [{ num: 5, name: "Aldehydes, Ketones, Carboxylic Acids, Diazonium & Proteins", c: "Cannizzaro, Aldol, Gabriel Phthalimide, Amino acids & Nucleic Acids" }] }
    ];
  }
  subjectsList.push({
    board: "STATE_BOARD", classLevel: lvl, name: "Chemistry", code: "CHEM", icon: "🧪", color: "#8854d0",
    units: chemUnits
  });

  // Mathematics (Class 11 & 12)
  let hseMathUnits = [];
  if (lvl === 11) {
    hseMathUnits = [
      { num: 1, name: "Unit 1: Sets, Relations and Functions", chapters: [{ num: 1, name: "Set Operations & Composite Functions", c: "Equivalence Relations & Inverses" }] },
      { num: 2, name: "Unit 2: Basic Algebra & Trigonometry", chapters: [{ num: 2, name: "Inequalities, Logarithms & Compound Angles", c: "Partial Fractions & Trigonometric Equations" }] },
      { num: 3, name: "Unit 3: Combinatorics & Binomial Theorem", chapters: [{ num: 3, name: "Permutations, Combinations & Mathematical Induction", c: "Binomial Expansion & Series Approximations" }] },
      { num: 4, name: "Unit 4: 2D Analytical Geometry & Vectors", chapters: [{ num: 4, name: "Pair of Straight Lines & Vector Operations", c: "Dot/Cross Products & Section Formula" }] },
      { num: 5, name: "Unit 5: Differential & Integral Calculus", chapters: [{ num: 5, name: "Limits, Continuity, Derivatives & Integrals", c: "Chain Rule, Product Rule, Integration by Parts" }] },
      { num: 6, name: "Unit 6: Probability Theory", chapters: [{ num: 6, name: "Conditional Probability & Bayes' Theorem", c: "Independent Events & Sample Spaces" }] }
    ];
  } else {
    hseMathUnits = [
      { num: 1, name: "Unit 1: Applications of Matrices and Determinants", chapters: [{ num: 1, name: "Matrix Inverse, Rank & System of Equations", c: "Cramer's Rule & Gaussian Elimination" }] },
      { num: 2, name: "Unit 2: Complex Numbers & Theory of Equations", chapters: [{ num: 2, name: "De Moivre's Theorem, Roots of Unity & Polynomial Roots", c: "Polar Form, Euler's Formula & Vieta's Relations" }] },
      { num: 3, name: "Unit 3: 2D Analytical Geometry-II & Vector Applications", chapters: [{ num: 3, name: "Conic Sections (Parabola, Ellipse, Hyperbola) & 3D Vectors", c: "Skew Lines, Shortest Distance & Equation of Planes" }] },
      { num: 4, name: "Unit 4: Differential Calculus & Integration Applications", chapters: [{ num: 4, name: "Tangents, Maxima/Minima & Definite Integrals", c: "Rolle's / Lagrange's Theorems, Area Under Curve" }] },
      { num: 5, name: "Unit 5: Ordinary Differential Equations", chapters: [{ num: 5, name: "First Order Linear DE & Variable Separable", c: "Integrating Factor & Application Models" }] },
      { num: 6, name: "Unit 6: Probability Distributions & Discrete Mathematics", chapters: [{ num: 6, name: "Binomial, Poisson Distributions & Boolean Logic", c: "Expected Value, Variance, Truth Tables & Group Theory" }] }
    ];
  }
  subjectsList.push({
    board: "STATE_BOARD", classLevel: lvl, name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4",
    units: hseMathUnits
  });

  // Biology (Class 11 & 12)
  subjectsList.push({
    board: "STATE_BOARD", classLevel: lvl, name: "Biology", code: "BIO", icon: "🧬", color: "#20bf6b",
    units: [
      { num: 1, name: "Unit 1: Diversity & Plant Morphology", chapters: [{ num: 1, name: `Living World & Plant Anatomy (Class ${lvl})`, c: "Taxonomy, Floral Formulas & Meristems" }, { num: 2, name: `Plant Physiology & Photosynthesis (Class ${lvl})`, c: "C3/C4 Cycles, Respiration & Plant Hormones" }] },
      { num: 2, name: "Unit 2: Animal Systems & Human Physiology", chapters: [{ num: 3, name: `Human Digestion, Circulation & Excretion (Class ${lvl})`, c: "Heart, Nephron & Neural Transmission" }, { num: 4, name: `Endocrine Coordination & Reproduction (Class ${lvl})`, c: "Hormonal Cascades & Gametogenesis" }] },
      { num: 3, name: "Unit 3: Genetics, Biotechnology & Ecology", chapters: [{ num: 5, name: `Molecular Genetics & Gene Expression (Class ${lvl})`, c: "DNA Replication, Transcription & Translation" }, { num: 6, name: `Recombinant DNA & Environmental Conservation (Class ${lvl})`, c: "PCR, Plasmids, Bioremediation & Ecosystems" }] }
    ]
  });

  // Botany & Zoology (for Pure Science Group 3)
  subjectsList.push({
    board: "STATE_BOARD", classLevel: lvl, name: "Botany", code: "BOT", icon: "🌱", color: "#26de81",
    units: [
      { num: 1, name: "Unit 1: Plant Taxonomy & Cell Biology", chapters: [{ num: 1, name: `Taxonomy of Angiosperms & Cell Structure (Class ${lvl})`, c: "Bentham & Hooker, Floral Anatomy & Organelles" }] },
      { num: 2, name: "Unit 2: Plant Physiology & Plant Breeding", chapters: [{ num: 2, name: `Mineral Nutrition, Photosynthesis & Hybridisation (Class ${lvl})`, c: "Nitrogen Fixation, Calvin Cycle & Crop Improvement" }] },
      { num: 3, name: "Unit 3: Plant Biotechnology & Ecology", chapters: [{ num: 3, name: `Tissue Culture, Genetic Engineering & Ecological Succession (Class ${lvl})`, c: "Callus Culture, Vector Biology & Ecosystem Energy" }] }
    ]
  });

  subjectsList.push({
    board: "STATE_BOARD", classLevel: lvl, name: "Zoology", code: "ZOO", icon: "🐾", color: "#fed330",
    units: [
      { num: 1, name: "Unit 1: Animal Diversity & Human Systems", chapters: [{ num: 1, name: `Animal Classification & Human Organ Systems (Class ${lvl})`, c: "Chordates, Nervous System & Cardio-vascular Dynamics" }] },
      { num: 2, name: "Unit 2: Genetics, Immunology & Health", chapters: [{ num: 2, name: `Mendelian Inheritance, Antibodies & Disease Prevention (Class ${lvl})`, c: "Chromosomal Aberrations, Vaccines & Autoimmunity" }] },
      { num: 3, name: "Unit 3: Applied Zoology & Environmental Conservation", chapters: [{ num: 3, name: `Sericulture, Aquaculture & Wildlife Preservation (Class ${lvl})`, c: "Economic Culture Methods & Endangered Species Protection" }] }
    ]
  });

  // Computer Science
  subjectsList.push({
    board: "STATE_BOARD", classLevel: lvl, name: "Computer Science", code: "CS", icon: "💻", color: "#2d98da",
    units: [
      { num: 1, name: "Unit 1: Computer Fundamentals & Programming in Python", chapters: [{ num: 1, name: `Python Fundamentals, Data Types & Control Flow (Class ${lvl})`, c: "Variables, Loops, Functions & Recursion" }, { num: 2, name: `Data Structures – Lists, Tuples, Sets, Dictionaries (Class ${lvl})`, c: "Operations, Slicing & Comprehensions" }] },
      { num: 2, name: "Unit 2: Object Oriented Programming & Algorithms", chapters: [{ num: 3, name: `Classes, Objects, Inheritance & Algorithmic Analysis (Class ${lvl})`, c: "Encapsulation, Time Complexity & Searching/Sorting" }] },
      { num: 3, name: "Unit 3: Database Concepts, SQL & Web Security", chapters: [{ num: 4, name: `RDBMS Concepts, SQL Queries & Python-DB Integration (Class ${lvl})`, c: "DDL, DML, Joins, SQLite & MySQL Interface" }, { num: 5, name: `Cyber Ethics, Cyber Security & Tamil Computing (Class ${lvl})`, c: "Firewalls, Phishing, Unicode, Tamil Keyboards & Open Source" }] }
    ]
  });

  // Computer Applications
  subjectsList.push({
    board: "STATE_BOARD", classLevel: lvl, name: "Computer Applications", code: "CA", icon: "🖥️", color: "#4b6584",
    units: [
      { num: 1, name: "Unit 1: Multimedia, Desktop Publishing & Web Design", chapters: [{ num: 1, name: `Adobe PageMaker & Multimedia Production (Class ${lvl})`, c: "Page Layout, Typography, Audio/Video Integration" }, { num: 2, name: `HTML5, CSS & JavaScript Fundamentals (Class ${lvl})`, c: "Forms, Styling, DOM Manipulation & Event Handlers" }] },
      { num: 2, name: "Unit 2: Server-side Scripting with PHP & MySQL", chapters: [{ num: 3, name: `PHP Variables, Control Structures & MySQL Connectivity (Class ${lvl})`, c: "Session Handling, Form Validation & Database CRUD" }] },
      { num: 3, name: "Unit 3: E-Commerce, Networks & Information Security", chapters: [{ num: 4, name: `E-Commerce Models, Electronic Payment Systems & Cyber Law (Class ${lvl})`, c: "B2B, B2C, UPI, Payment Gateways & IT Act Provisions" }] }
    ]
  });

  // Accountancy
  subjectsList.push({
    board: "STATE_BOARD", classLevel: lvl, name: "Accountancy", code: "ACC", icon: "📋", color: "#2bcbba",
    units: [
      { num: 1, name: "Unit 1: Financial Accounting Principles & Final Accounts", chapters: [{ num: 1, name: `Accounting Concepts, Journal, Ledger & Trial Balance (Class ${lvl})`, c: "Double Entry System & Reconciliation" }, { num: 2, name: `Final Accounts of Sole Proprietors & Incomplete Records (Class ${lvl})`, c: "Trading, P&L Account, Balance Sheet & Single Entry Conversion" }] },
      { num: 2, name: "Unit 2: Partnership Accounts & Company Accounts", chapters: [{ num: 3, name: `Partnership Fundamentals, Admission, Retirement & Dissolution (Class ${lvl})`, c: "Goodwill Valuation, Revaluation & Capital Adjustments" }, { num: 4, name: `Issue of Shares, Debentures & Financial Statement Analysis (Class ${lvl})`, c: "Forfeiture, Reissue, Comparative Statements & Accounting Ratios" }] },
      { num: 3, name: "Unit 3: Computerised Accounting System", chapters: [{ num: 5, name: `Computerised Accounting Software & Tally Configuration (Class ${lvl})`, c: "Voucher Entry, Ledgers, Reports & GST Invoicing" }] }
    ]
  });

  // Commerce
  subjectsList.push({
    board: "STATE_BOARD", classLevel: lvl, name: "Commerce", code: "COMM", icon: "💼", color: "#ff9f43",
    units: [
      { num: 1, name: "Unit 1: Forms of Business Organisation & Management", chapters: [{ num: 1, name: `Sole Proprietorship, Partnership & Joint Stock Companies (Class ${lvl})`, c: "Formation, Memorandum, Articles & Management Principles" }, { num: 2, name: `Principles of Scientific Management & Planning/Organising (Class ${lvl})`, c: "Fayol's 14 Principles, Taylor's Scientific Approach" }] },
      { num: 2, name: "Unit 2: Financial Markets, Marketing & Consumer Protection", chapters: [{ num: 3, name: `Capital Market, Money Market & SEBI Regulations (Class ${lvl})`, c: "Stock Exchanges, Treasury Bills, Primary/Secondary Markets" }, { num: 4, name: `Modern Marketing, 4Ps, E-Commerce & Consumer Rights (Class ${lvl})`, c: "Consumer Protection Act, Redressal Forums & Marketing Ethics" }] }
    ]
  });

  // Economics
  subjectsList.push({
    board: "STATE_BOARD", classLevel: lvl, name: "Economics", code: "ECO", icon: "📈", color: "#ee5253",
    units: [
      { num: 1, name: "Unit 1: Microeconomics & National Income", chapters: [{ num: 1, name: `Consumer Behavior, Demand, Supply & Market Equilibrium (Class ${lvl})`, c: "Law of Demand, Elasticity, Indifference Curves & Cost/Revenue" }, { num: 2, name: `National Income Accounting & Circular Flow of Income (Class ${lvl})`, c: "GDP, GNP, NNP, Real vs Nominal GDP & Sectoral Output" }] },
      { num: 2, name: "Unit 2: Monetary Policy, Public Finance & Tamil Nadu Economy", chapters: [{ num: 3, name: `Money, Banking, Inflation & RBI Monetary Policy (Class ${lvl})`, c: "Repo Rate, CRR, Commercial Banks & Fiscal Deficit" }, { num: 4, name: `International Trade, Fiscal Economics & Tamil Nadu Economy (Class ${lvl})`, c: "Foreign Exchange, Budget, GST, NITI Aayog & TN Growth Model" }] }
    ]
  });

  // Business Mathematics
  subjectsList.push({
    board: "STATE_BOARD", classLevel: lvl, name: "Business Mathematics", code: "BMATH", icon: "🔢", color: "#341f97",
    units: [
      { num: 1, name: "Unit 1: Matrices, Determinants & Financial Mathematics", chapters: [{ num: 1, name: `Matrix Operations, Input-Output Analysis & Annuities (Class ${lvl})`, c: "Cramer's Rule, Leontief Model, Compound Interest & Sinking Funds" }] },
      { num: 2, name: "Unit 2: Differential Calculus, Marginal Analysis & Linear Programming", chapters: [{ num: 2, name: `Marginal Cost, Revenue Optimisation & Transportation Problems (Class ${lvl})`, c: "Derivatives, Maxima/Minima, Simplex Method & Assignment" }] }
    ]
  });

  // Statistics
  subjectsList.push({
    board: "STATE_BOARD", classLevel: lvl, name: "Statistics", code: "STAT", icon: "📊", color: "#0abde3",
    units: [
      { num: 1, name: "Unit 1: Descriptive Statistics & Probability Distributions", chapters: [{ num: 1, name: `Measures of Central Tendency, Dispersion & Binomial/Normal Curve (Class ${lvl})`, c: "Mean, SD, Skewness, Kurtosis & Normal Probabilities" }] },
      { num: 2, name: "Unit 2: Statistical Inference, Time Series & Index Numbers", chapters: [{ num: 2, name: `Hypothesis Testing, Large/Small Sample Tests & Index Numbers (Class ${lvl})`, c: "Z-test, t-test, Chi-square, Moving Averages & Laspeyres/Paasche" }] }
    ]
  });

  // History
  subjectsList.push({
    board: "STATE_BOARD", classLevel: lvl, name: "History", code: "HIST", icon: "🏛️", color: "#5f27cd",
    units: [
      { num: 1, name: "Unit 1: Ancient & Medieval Indian History", chapters: [{ num: 1, name: `Indus Valley, Vedic Age, Mauryas, Guptas & Chola Empire (Class ${lvl})`, c: "State Formation, Art, Architecture, Administration & Overseas Trade" }, { num: 2, name: `Delhi Sultanate, Vijayanagar Kingdom & Mughal Empire (Class ${lvl})`, c: "Revenue Systems, Religious Policies, Literature & Architecture" }] },
      { num: 2, name: "Unit 2: Modern Indian History & Tamil Nadu Freedom Struggle", chapters: [{ num: 3, name: `British Colonial Consolidation, 1857 Revolt & Nationalist Upsurge (Class ${lvl})`, c: "Economic Impact of British Rule, Gandhi & Mass Mobilisation" }, { num: 4, name: "Freedom Struggle in Tamil Nadu & Social Transformation", c: "Self-Respect Movement, Periyar, Justice Party & Post-Independence Era" }] }
    ]
  });
}

// =========================================================================
// 2. CBSE (NCERT) CURRICULUM
// =========================================================================

// --- 2.1 CBSE CLASSES 4 & 5 (English, Mathematics, EVS) ---
for (let lvl of [4, 5]) {
  // English (Marigold)
  subjectsList.push({
    board: "CBSE", classLevel: lvl, name: "English", code: "ENG", icon: "📖", color: "#fa8231",
    units: [
      { num: 1, name: "Unit 1: Stories of Fun & Adventure", chapters: [{ num: 1, name: `Wake Up! & Neha's Alarm Clock (Class ${lvl})`, c: "Morning Routine, Phonics & Sentences" }, { num: 2, name: `The Little Fir Tree & Noses (Class ${lvl})`, c: "Adjectives, Rhymes & Vocabulary" }] },
      { num: 2, name: "Unit 2: Friendship & Nature", chapters: [{ num: 3, name: `Run! & Nasiruddin's Aim (Class ${lvl})`, c: "Sportsmanship, Action Words & Verbs" }, { num: 4, name: `Why? & Alice in Wonderland (Class ${lvl})`, c: "Curiosity, Prepositions & Storytelling" }] },
      { num: 3, name: "Unit 3: Bravery & Helpful Hands", chapters: [{ num: 5, name: `Don't be Afraid of the Dark & Helen Keller (Class ${lvl})`, c: "Overcoming Fear, Braille & Determination" }, { num: 6, name: `Hiawatha & The Scholar's Mother Tongue (Class ${lvl})`, c: "Birbal Wit, Dialects & Nouns" }] },
      { num: 4, name: "Unit 4: Magic & Imagination", chapters: [{ num: 7, name: `A Watering Rhyme & The Giving Tree (Class ${lvl})`, c: "Plant Care, Selfless Giving & Composition" }, { num: 8, name: `Books & Going to Buy a Book (Class ${lvl})`, c: "Reading Habits & Bookstores" }] },
      { num: 5, name: "Unit 5: Travelling & Discovery", chapters: [{ num: 9, name: `The Naughty Boy & Pinocchio (Class ${lvl})`, c: "Honesty, Creative Writing & Opposites" }] }
    ]
  });

  // Mathematics (Math-Magic)
  subjectsList.push({
    board: "CBSE", classLevel: lvl, name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4",
    units: [
      { num: 1, name: "Unit 1: Shapes, Geometry & Patterns", chapters: [{ num: 1, name: `Building with Bricks & Shapes and Angles (Class ${lvl})`, c: "Floor Patterns, Angles, Clock Hands" }, { num: 2, name: `How many Squares? & Parts and Wholes (Class ${lvl})`, c: "Area, Perimeter, Fractions & Shading" }] },
      { num: 2, name: "Unit 2: Symmetry, Multiples & Operations", chapters: [{ num: 3, name: `Does it look the same? & Be My Multiple, I'll be Your Factor (Class ${lvl})`, c: "Rotational Symmetry, HCF, LCM & Multiples" }, { num: 4, name: `Can You See the Pattern? & Boxes and Sketches (Class ${lvl})`, c: "Number Sequences & 3D Cube Nets" }] },
      { num: 3, name: "Unit 3: Decimal Numbers, Area & Mapping", chapters: [{ num: 5, name: `Tenths and Hundredths & Mapping Your Way (Class ${lvl})`, c: "Decimals, Money, Scale Maps & Directions" }, { num: 6, name: `Area and its Boundary & Smart Charts (Class ${lvl})`, c: "Square Grids, Bar Charts & Tallies" }] },
      { num: 4, name: "Unit 4: Multiplication, Division & Volume", chapters: [{ num: 7, name: `Ways to Multiply and Divide & How Big? How Heavy? (Class ${lvl})`, c: "Long Division, Word Problems, Weight & Volume of Cubes" }] }
    ]
  });

  // EVS (Looking Around)
  subjectsList.push({
    board: "CBSE", classLevel: lvl, name: "EVS", code: "EVS", icon: "🌱", color: "#20bf6b",
    units: [
      { num: 1, name: "Unit 1: Animals, Senses & Super Powers", chapters: [{ num: 1, name: `Super Senses & A Snake Charmer's Story (Class ${lvl})`, c: "Sense of Smell, Sight, Sound & Wildlife Protection" }, { num: 2, name: `From Tasting to Digesting & Mangoes Round the Year (Class ${lvl})`, c: "Digestive System, Food Preservation & Mamidi Tandra" }] },
      { num: 2, name: "Unit 2: Seeds, Plants & Water Resources", chapters: [{ num: 3, name: `Seeds and Seeds & Every Drop Counts (Class ${lvl})`, c: "Seed Dispersal, Ghadsisar Lake & Stepwells" }, { num: 4, name: `Experiments with Water & A Treat for Mosquitoes (Class ${lvl})`, c: "Floating/Sinking, Malaria, Dengue & Blood Tests" }] },
      { num: 3, name: "Unit 3: Journeys, Shelters & Space Exploration", chapters: [{ num: 5, name: `Up You Go! & Walls Tell Stories (Class ${lvl})`, c: "Mountaineering, Golconda Fort & Historical Architecture" }, { num: 6, name: `Sunita in Space & What if it Finishes...? (Class ${lvl})`, c: "Zero Gravity, Astronaut Life, Petroleum & Fuel Conservation" }] },
      { num: 4, name: "Unit 4: Society, Forests & Farmer Livelihoods", chapters: [{ num: 7, name: `A Shelter so High! & When the Earth Shook! (Class ${lvl})`, c: "Ladakh Cold Desert, Changpa Tribe & Earthquakes" }, { num: 8, name: `Blow Hot, Blow Cold & Who will do this Work? (Class ${lvl})`, c: "Respiration, Dignity of Labour & Gandhiji's Ashram" }, { num: 9, name: `Across the Wall & Whose Forests? (Class ${lvl})`, c: "Gender Equality in Sports, Kuduk Tribe & Forest Rights Act" }] }
    ]
  });
}

// --- 2.2 CBSE CLASSES 6 TO 10 (English, Mathematics, Science, Social Science) ---
for (let lvl = 6; lvl <= 10; lvl++) {
  // English
  subjectsList.push({
    board: "CBSE", classLevel: lvl, name: "English", code: "ENG", icon: "📚", color: "#fa8231",
    units: [
      { num: 1, name: "Unit 1: Main Course – Inspiring Lives & Adventure", chapters: [{ num: 1, name: `Prose Lesson 1 (Class ${lvl} NCERT)`, c: "Comprehension & Vocabulary Enrichment" }, { num: 2, name: `Poem 1 (Class ${lvl} NCERT)`, c: "Rhyme Scheme & Figures of Speech" }] },
      { num: 2, name: "Unit 2: Main Course – Nature, Science & Values", chapters: [{ num: 3, name: `Prose Lesson 2 (Class ${lvl} NCERT)`, c: "Grammar, Reported Speech & Tenses" }, { num: 4, name: `Poem 2 (Class ${lvl} NCERT)`, c: "Imagery, Theme & Poetic Devices" }] },
      { num: 3, name: "Unit 3: Supplementary Reader – Moments & Footprints", chapters: [{ num: 5, name: `Supplementary Fiction 1 (Class ${lvl} NCERT)`, c: "Plot Structure & Character Analysis" }, { num: 6, name: `Supplementary Fiction 2 (Class ${lvl} NCERT)`, c: "Conflict, Moral & Critical Thinking" }] },
      { num: 4, name: "Unit 4: Writing Skills & Applied Grammar", chapters: [{ num: 7, name: `Formal Letter Writing & Analytical Paragraph (Class ${lvl})`, c: "Letters of Complaint/Inquiry & Data Analysis" }, { num: 8, name: `Integrated Grammar – Editing, Omission & Modals (Class ${lvl})`, c: "Error Correction & Sentence Transformation" }] }
    ]
  });

  // Mathematics
  let cbseMathUnits = [];
  if (lvl === 6) {
    cbseMathUnits = [
      { num: 1, name: "Unit 1: Number Systems & Whole Numbers", chapters: [{ num: 1, name: "Knowing Our Numbers & Playing with Numbers", c: "Place Value, Roman Numerals, Divisibility Rules, Prime/Composite, HCF & LCM" }] },
      { num: 2, name: "Unit 2: Integers, Fractions & Decimals", chapters: [{ num: 2, name: "Integers & Operations", c: "Number Line, Negative Numbers, Addition/Subtraction" }, { num: 3, name: "Fractions and Decimals", c: "Proper/Improper Fractions, Decimals Representation" }] },
      { num: 3, name: "Unit 3: Algebra, Ratio & Proportion", chapters: [{ num: 4, name: "Introduction to Algebra & Ratio-Proportion", c: "Variables, Algebraic Expressions, Unitary Method" }] },
      { num: 4, name: "Unit 4: Geometry & Mensuration", chapters: [{ num: 5, name: "Basic Geometrical Ideas & Elementary Shapes", c: "Points, Rays, Angles, Polygons, Triangles, 3D Shapes" }, { num: 6, name: "Mensuration – Perimeter and Area", c: "Perimeter of Rectangle/Square & Area Calculations" }] },
      { num: 5, name: "Unit 5: Data Handling & Symmetry", chapters: [{ num: 7, name: "Data Handling & Symmetry", c: "Tally Marks, Bar Graphs & Line of Symmetry" }] }
    ];
  } else if (lvl === 7) {
    cbseMathUnits = [
      { num: 1, name: "Unit 1: Integers, Fractions & Decimals", chapters: [{ num: 1, name: "Integers & Rational Numbers", c: "Multiplication/Division of Integers & Standard Form" }, { num: 2, name: "Fractions and Decimals Operations", c: "Multiplication/Division of Fractions & Decimals" }] },
      { num: 2, name: "Unit 2: Data Handling & Simple Equations", chapters: [{ num: 3, name: "Data Handling – Mean, Median, Mode & Bar Graphs", c: "Measures of Central Tendency & Probability" }, { num: 4, name: "Simple Equations in One Variable", c: "Setting up Equations & Solving Linear Equations" }] },
      { num: 3, name: "Unit 3: Lines, Angles & Triangles", chapters: [{ num: 5, name: "Lines and Angles & Triangle Properties", c: "Complementary, Supplementary, Exterior Angle Theorem & Pythagoras" }] },
      { num: 4, name: "Unit 4: Comparing Quantities & Algebraic Expressions", chapters: [{ num: 6, name: "Comparing Quantities – Percentage & Profit/Loss", c: "Simple Interest (P*R*T/100) & Discount" }, { num: 7, name: "Algebraic Expressions & Exponents/Powers", c: "Addition/Subtraction of Expressions & Laws of Exponents" }] },
      { num: 5, name: "Unit 5: Mensuration & Visualising Solids", chapters: [{ num: 8, name: "Perimeter and Area of Circle & Triangles", c: "Circumference, Area = pi*r^2 & Parallelogram Area" }, { num: 9, name: "Symmetry & Visualising Solid Shapes", c: "Rotational Symmetry, Isometric Sketches" }] }
    ];
  } else if (lvl === 8) {
    cbseMathUnits = [
      { num: 1, name: "Unit 1: Rational Numbers & Linear Equations", chapters: [{ num: 1, name: "Rational Numbers – Properties & Number Line", c: "Closure, Commutative, Associative & Distributive Laws" }, { num: 2, name: "Linear Equations in One Variable", c: "Applications & Solving Equations with Variables on Both Sides" }] },
      { num: 2, name: "Unit 2: Quadrilaterals & Data Handling", chapters: [{ num: 3, name: "Understanding Quadrilaterals", c: "Angle Sum Property, Convex/Concave, Parallelograms" }, { num: 4, name: "Data Handling & Probability", c: "Histograms, Pie Charts & Chance/Probability" }] },
      { num: 3, name: "Unit 3: Squares, Cubes & Comparing Quantities", chapters: [{ num: 5, name: "Squares, Square Roots, Cubes & Cube Roots", c: "Prime Factorisation, Long Division Method & Cube Roots" }, { num: 6, name: "Comparing Quantities – Compound Interest", c: "Profit/Loss, Tax, Compound Interest Formula" }] },
      { num: 4, name: "Unit 4: Algebraic Expressions, Identities & Mensuration", chapters: [{ num: 7, name: "Algebraic Expressions and Identities", c: "Standard Identities (a+b)^2, (a-b)^2, a^2-b^2" }, { num: 8, name: "Mensuration – Surface Area and Volume", c: "Area of Trapezium, Surface Area & Volume of Cylinder, Cube, Cuboid" }] },
      { num: 5, name: "Unit 5: Exponents, Direct/Inverse Proportions & Factorisation", chapters: [{ num: 9, name: "Exponents and Powers & Direct/Inverse Proportions", c: "Negative Exponents, Scientific Notation & Proportions" }, { num: 10, name: "Factorisation & Introduction to Graphs", c: "Common Factors, Regrouping, Linear Graphs & Coordinates" }] }
    ];
  } else if (lvl === 9) {
    cbseMathUnits = [
      { num: 1, name: "Unit 1: Number Systems", chapters: [{ num: 1, name: "Real Numbers, Irrational Numbers & Laws of Exponents", c: "Rationalisation of Denominators & Real Number Line" }] },
      { num: 2, name: "Unit 2: Algebra – Polynomials & Linear Equations", chapters: [{ num: 2, name: "Polynomials – Remainder & Factor Theorems", c: "Algebraic Identities, Zeros of Polynomials & Cubic Factorisation" }, { num: 3, name: "Linear Equations in Two Variables", c: "Standard Form ax+by+c=0 & Graphical Solutions" }] },
      { num: 3, name: "Unit 3: Coordinate Geometry & Euclid's Geometry", chapters: [{ num: 4, name: "Coordinate Geometry & Introduction to Euclid's Geometry", c: "Cartesian Plane, Quadrants, Axioms & Postulates" }] },
      { num: 4, name: "Unit 4: Geometry – Lines, Triangles, Quads & Circles", chapters: [{ num: 5, name: "Lines and Angles & Triangles Congruence", c: "Linear Pair, Parallel Lines, SAS, ASA, AAS, SSS, RHS Congruence" }, { num: 6, name: "Quadrilaterals & Circles", c: "Mid-point Theorem, Properties of Parallelograms, Cyclic Quadrilaterals" }] },
      { num: 5, name: "Unit 5: Mensuration – Heron's Formula & Surface Areas", chapters: [{ num: 7, name: "Heron's Formula for Area of Triangles", c: "Area = sqrt(s(s-a)(s-b)(s-c))" }, { num: 8, name: "Surface Areas and Volumes", c: "Sphere, Hemisphere, Right Circular Cone Surface Area & Volume" }] },
      { num: 6, name: "Unit 6: Statistics", chapters: [{ num: 9, name: "Statistics – Graphical Representation of Data", c: "Bar Graphs, Histograms & Frequency Polygons" }] }
    ];
  } else if (lvl === 10) {
    cbseMathUnits = [
      { num: 1, name: "Unit 1: Number Systems – Real Numbers", chapters: [{ num: 1, name: "Real Numbers – Fundamental Theorem of Arithmetic", c: "Irrationality Proofs (sqrt(2), sqrt(3), sqrt(5)) & Prime Factorisation" }] },
      { num: 2, name: "Unit 2: Algebra – Polynomials & Equations", chapters: [{ num: 2, name: "Polynomials – Zeros & Coefficients Relationship", c: "Quadratic Polynomials & Zeros sum -b/a, product c/a" }, { num: 3, name: "Pair of Linear Equations in Two Variables", c: "Graphical, Substitution, Elimination & Consistency Conditions" }, { num: 4, name: "Quadratic Equations – Nature of Roots", c: "Discriminant D=b^2-4ac, Quadratic Formula & Factorisation" }, { num: 5, name: "Arithmetic Progressions (AP)", c: "nth Term an = a + (n-1)d & Sum Sn = n/2[2a + (n-1)d]" }] },
      { num: 3, name: "Unit 3: Coordinate Geometry", chapters: [{ num: 6, name: "Coordinate Geometry – Distance & Section Formula", c: "Distance Formula sqrt((x2-x1)^2+(y2-y1)^2), Midpoint & Section Formula" }] },
      { num: 4, name: "Unit 4: Geometry – Triangles & Circles", chapters: [{ num: 7, name: "Triangles – Similarity Theorems", c: "Basic Proportionality Theorem (Thales) & AAA, SSS, SAS Criteria" }, { num: 8, name: "Circles – Tangents from External Point", c: "Tangents perpendicular to radius & Tangents equal in length" }] },
      { num: 5, name: "Unit 5: Trigonometry", chapters: [{ num: 9, name: "Introduction to Trigonometry & Trigonometric Identities", c: "Ratios of 0, 30, 45, 60, 90 deg & sin^2+cos^2=1" }, { num: 10, name: "Some Applications of Trigonometry", c: "Heights and Distances, Angle of Elevation/Depression" }] },
      { num: 6, name: "Unit 6: Mensuration – Areas Related to Circles & Volumes", chapters: [{ num: 11, name: "Areas Related to Circles", c: "Area of Sector and Segment of a Circle" }, { num: 12, name: "Surface Areas and Volumes of Combinations", c: "Combinations of Cube, Cuboid, Sphere, Hemisphere, Cylinder, Cone" }] },
      { num: 7, name: "Unit 7: Statistics and Probability", chapters: [{ num: 13, name: "Statistics – Mean, Median & Mode of Grouped Data", c: "Direct, Assumed Mean Method & Empirical Relation: 3 Median = Mode + 2 Mean" }, { num: 14, name: "Probability – Classical Definition & Events", c: "P(E) = Outcomes favourable / Total outcomes, Complementary Events" }] }
    ];
  }
  subjectsList.push({
    board: "CBSE", classLevel: lvl, name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4",
    units: cbseMathUnits
  });

  // Science
  let cbseSciUnits = [];
  if (lvl === 6) {
    cbseSciUnits = [
      { num: 1, name: "Unit 1: Food, Components & Sorting Materials", chapters: [{ num: 1, name: "Components of Food – Nutrients & Deficiency", c: "Carbohydrates, Fats, Proteins, Vitamins & Balanced Diet" }, { num: 2, name: "Sorting Materials into Groups", c: "Solubility, Transparency, Density & Conduction" }] },
      { num: 2, name: "Unit 2: Separation of Substances & Living World", chapters: [{ num: 3, name: "Separation of Substances", c: "Sedimentation, Decantation, Filtration, Evaporation" }, { num: 4, name: "Getting to Know Plants & Body Movements", c: "Herbs, Shrubs, Trees, Venation, Joints & Skeletal System" }] },
      { num: 3, name: "Unit 3: Motion, Light, Electricity & Air", chapters: [{ num: 5, name: "The Living Organisms – Characteristics and Habitats", c: "Terrestrial, Aquatic, Adaptations, Respiration" }, { num: 6, name: "Motion and Measurement of Distances", c: "Standard Units, SI Units, Rectilinear, Circular & Periodic Motion" }, { num: 7, name: "Light, Shadows and Reflections", c: "Luminous, Opaque, Pin-hole Camera, Reflection" }, { num: 8, name: "Electricity and Circuits & Air Around Us", c: "Electric Cell, Switch, Conductors, Insulators & Atmosphere" }] }
    ];
  } else if (lvl === 7) {
    cbseSciUnits = [
      { num: 1, name: "Unit 1: Nutrition in Plants and Animals", chapters: [{ num: 1, name: "Nutrition in Plants – Autotrophic & Heterotrophic", c: "Photosynthesis, Stomata, Parasites & Saprotrophs" }, { num: 2, name: "Nutrition in Animals – Human Digestion", c: "Buccal Cavity, Stomach, Small Intestine & Ruminants" }] },
      { num: 2, name: "Unit 2: Heat, Acids, Bases and Salts", chapters: [{ num: 3, name: "Heat – Temperature & Heat Transfer", c: "Clinical/Laboratory Thermometers, Conduction, Convection, Radiation" }, { num: 4, name: "Acids, Bases and Salts & Physical/Chemical Changes", c: "Litmus, Phenolphthalein, Neutralisation & Rusting" }] },
      { num: 3, name: "Unit 3: Respiration, Transportation & Plant Reproduction", chapters: [{ num: 5, name: "Respiration in Organisms", c: "Aerobic, Anaerobic, Breathing Mechanism & Cellular Respiration" }, { num: 6, name: "Transportation in Animals and Plants", c: "Heart, Blood Vessels, Xylem, Phloem & Excretion" }, { num: 7, name: "Reproduction in Plants", c: "Vegetative Propagation, Flowers, Pollination & Seed Dispersal" }] },
      { num: 4, name: "Unit 4: Motion, Electric Current & Light", chapters: [{ num: 8, name: "Motion and Time – Speed & Simple Pendulum", c: "Distance-Time Graphs, Uniform/Non-uniform Motion" }, { num: 9, name: "Electric Current and its Effects & Light", c: "Heating/Magnetic Effects, Electromagnets, Spherical Mirrors & Lenses" }, { num: 10, name: "Forests: Our Lifeline & Wastewater Story", c: "Crown, Canopy, Decomposers & Sewage Treatment" }] }
    ];
  } else if (lvl === 8) {
    cbseSciUnits = [
      { num: 1, name: "Unit 1: Crop Production & Microorganisms", chapters: [{ num: 1, name: "Crop Production and Management", c: "Agricultural Practices, Kharif/Rabi Crops, Manure, Fertiliser, Irrigation" }, { num: 2, name: "Microorganisms: Friend and Foe", c: "Commercial/Medicinal Uses, Vaccines, Nitrogen Fixation & Pathogens" }] },
      { num: 2, name: "Unit 2: Coal, Petroleum & Combustion", chapters: [{ num: 3, name: "Coal and Petroleum – Fossil Fuels", c: "Carbonisation, Fractional Distillation & Petroleum Products" }, { num: 4, name: "Combustion and Flame", c: "Ignition Temperature, Fire Extinguishers & Flame Zones" }] },
      { num: 3, name: "Unit 3: Conservation & Reproduction in Animals", chapters: [{ num: 5, name: "Conservation of Plants and Animals", c: "Deforestation, Biosphere Reserves, Flora/Fauna & Red Data Book" }, { num: 6, name: "Reproduction in Animals & Reaching Age of Adolescence", c: "Sexual/Asexual Reproduction, Cloning, Hormones & Target Organs" }] },
      { num: 4, name: "Unit 4: Forces, Pressure, Friction & Sound", chapters: [{ num: 7, name: "Force and Pressure", c: "Contact/Non-contact forces, Pressure = Force/Area & Liquid Pressure" }, { num: 8, name: "Friction – Advantages and Methods of Reduction", c: "Static, Sliding, Rolling Friction & Fluid Friction (Drag)" }, { num: 9, name: "Sound – Propagation, Amplitude & Noise", c: "Vibrations, Audible Range (20 Hz - 20 kHz) & Ultrasound" }] },
      { num: 5, name: "Unit 5: Chemical Effects of Current, Light & Natural Phenomena", chapters: [{ num: 10, name: "Chemical Effects of Electric Current", c: "Electroplating, Electrolytes, LED Indicators" }, { num: 11, name: "Some Natural Phenomena – Lightning & Earthquakes", c: "Electric Charges, Electroscope, Richter Scale & Seismograph" }, { num: 12, name: "Light – Reflection Laws & Human Eye", c: "Regular/Diffused Reflection, Multiple Images, Kaleidoscopes & Eye Care" }] }
    ];
  } else if (lvl === 9) {
    cbseSciUnits = [
      { num: 1, name: "Unit 1: Matter in Our Surroundings & Pure Substances", chapters: [{ num: 1, name: "Matter in Our Surroundings", c: "States of Matter, Evaporation Factors, Latent Heat of Fusion/Vaporisation" }, { num: 2, name: "Is Matter Around Us Pure?", c: "Homogeneous/Heterogeneous, Solutions, Colloids, Suspensions & Tyndall Effect" }] },
      { num: 2, name: "Unit 2: Atoms, Molecules & Atomic Structure", chapters: [{ num: 3, name: "Atoms and Molecules – Law of Conservation of Mass", c: "Law of Constant Proportions, Dalton Theory, Mole Concept & Valency" }, { num: 4, name: "Structure of the Atom – Subatomic Models", c: "Thomson, Rutherford Alpha Scattering, Bohr Model, Isotopes & Isobars" }] },
      { num: 3, name: "Unit 3: The Cell & Plant/Animal Tissues", chapters: [{ num: 5, name: "The Fundamental Unit of Life (Cell)", c: "Plasma Membrane, Osmosis, Nucleus, ER, Golgi, Mitochondria, Plastids" }, { num: 6, name: "Tissues – Plant and Animal Tissues", c: "Meristematic, Parenchyma, Collenchyma, Sclerenchyma, Epithelial, Muscular, Nervous" }] },
      { num: 4, name: "Unit 4: Motion, Force & Laws of Motion", chapters: [{ num: 7, name: "Motion – Velocity, Acceleration & Graphs", c: "Scalar/Vector, Uniform Acceleration Equations v=u+at, s=ut+1/2at^2" }, { num: 8, name: "Force and Laws of Motion", c: "Newton's 1st, 2nd (F=ma), 3rd Law, Momentum & Conservation Law" }] },
      { num: 5, name: "Unit 5: Gravitation, Work, Energy & Sound", chapters: [{ num: 9, name: "Gravitation & Floatation", c: "Universal Law F=G(m1m2/r^2), Acceleration g=9.8m/s^2, Archimedes Principle" }, { num: 10, name: "Work and Energy – Kinetic & Potential Energy", c: "Work Done W=F.s, KE=1/2mv^2, PE=mgh, Law of Conservation of Energy, Power" }, { num: 11, name: "Sound – Wave Propagation, Echo & SONAR", c: "Longitudinal Waves, Frequency, Amplitude, Velocity v=lambda*f & Human Ear" }, { num: 12, name: "Improvement in Food Resources", c: "Crop Variety Improvement, Nutrient Management, Manures & Animal Husbandry" }] }
    ];
  } else if (lvl === 10) {
    cbseSciUnits = [
      { num: 1, name: "Unit 1: Chemical Reactions, Acids, Bases & Metals", chapters: [{ num: 1, name: "Chemical Reactions and Equations", c: "Balancing Equations, Combination, Decomposition, Displacement, Redox, Corrosion, Rancidity" }, { num: 2, name: "Acids, Bases and Salts", c: "Chemical Properties, pH in Everyday Life, Bleaching Powder, Baking Soda, Plaster of Paris" }, { num: 3, name: "Metals and Non-metals", c: "Reactivity Series, Ionic Bonds, Metallurgy & Extraction of Metals" }] },
      { num: 2, name: "Unit 2: Carbon Compounds & Life Processes", chapters: [{ num: 4, name: "Carbon and its Compounds", c: "Covalent Bonding, Versatile Nature, Homologous Series, Functional Groups, Ethanol, Ethanoic Acid" }, { num: 5, name: "Life Processes – Nutrition, Respiration, Transport & Excretion", c: "Autotrophic/Heterotrophic, Aerobic/Anaerobic, Human Heart, Nephron Filtration" }] },
      { num: 3, name: "Unit 3: Control & Coordination, Reproduction & Heredity", chapters: [{ num: 6, name: "Control and Coordination", c: "Neuron Structure, Reflex Arc, Brain Parts, Plant Hormones, Endocrine System" }, { num: 7, name: "How do Organisms Reproduce?", c: "Asexual (Fission, Budding, Spores), Sexual in Flowering Plants & Humans, Contraception" }, { num: 8, name: "Heredity and Evolution", c: "Mendel's Monohybrid/Dihybrid Crosses, Sex Determination in Humans (XX/XY)" }] },
      { num: 4, name: "Unit 4: Light – Reflection, Refraction & Human Eye", chapters: [{ num: 9, name: "Light – Reflection and Refraction", c: "Spherical Mirrors, Mirror Formula 1/f=1/v+1/u, Snell's Law, Lens Formula, Power of Lens P=1/f" }, { num: 10, name: "Human Eye and the Colourful World", c: "Myopia, Hypermetropia, Presbyopia, Dispersion through Prism, Atmospheric Refraction, Tyndall Effect" }] },
      { num: 5, name: "Unit 5: Electricity, Magnetic Effects & Our Environment", chapters: [{ num: 11, name: "Electricity – Ohm's Law & Electric Power", c: "V=IR, Factors affecting Resistance, Series/Parallel Resistors, Joule Heating H=I^2Rt, Power P=VI" }, { num: 12, name: "Magnetic Effects of Electric Current", c: "Magnetic Field Lines, Right Hand Thumb Rule, Solenoid, Fleming's Left Hand Rule, Domestic Circuits" }, { num: 13, name: "Our Environment – Ecosystem & Ozone", c: "Trophic Levels, 10% Energy Law, Biological Magnification, Ozone Layer Depletion, Waste Management" }] }
    ];
  }
  subjectsList.push({
    board: "CBSE", classLevel: lvl, name: "Science", code: "SCI", icon: "🔬", color: "#eb4d4b",
    units: cbseSciUnits
  });

  // Social Science
  let cbseSocUnits = [];
  if (lvl === 6) {
    cbseSocUnits = [
      { num: 1, name: "Unit 1: History – Our Pasts-I", chapters: [{ num: 1, name: "What, Where, How and When? & From Hunting to Growing Food", c: "Archaeology, Manuscipts, Earliest Cities, Harappa & Mohenjodaro" }, { num: 2, name: "Kingdoms, Kings and an Early Republic & New Questions and Ideas", c: "Vedas, Mahajanapadas, Magadha, Gautama Buddha & Upanishads" }, { num: 3, name: "Ashoka, The Emperor & Villages, Towns and Trade", c: "Kalinga War, Dhamma, Inscriptions, Mathura & Sangam Poems" }, { num: 4, name: "New Empires and Kingdoms & Buildings, Paintings and Books", c: "Samudragupta Prashasti, Harshavardhana, Iron Pillar & Stupas" }] },
      { num: 2, name: "Unit 2: Geography – The Earth Our Habitat", chapters: [{ num: 5, name: "The Earth in the Solar System & Globe: Latitudes and Longitudes", c: "Planets, Sun, Equator, Prime Meridian, IST & Time Zones" }, { num: 6, name: "Motions of the Earth, Maps & Major Domains of the Earth", c: "Rotation, Revolution, Solstices, Scales, Lithosphere, Hydrosphere, Atmosphere" }] },
      { num: 3, name: "Unit 3: Civics – Social and Political Life-I", chapters: [{ num: 7, name: "Understanding Diversity, Diversity and Discrimination", c: "Prejudice, Stereotypes, Dr. Ambedkar & Equality" }, { num: 8, name: "What is Government?, Democratic Government & Panchayati Raj", c: "Universal Adult Franchise, Gram Panchayat, District Administration & Urban Livelihoods" }] }
    ];
  } else if (lvl === 7) {
    cbseSocUnits = [
      { num: 1, name: "Unit 1: History – Our Pasts-II", chapters: [{ num: 1, name: "Tracing Changes Through a Thousand Years & Kings and Kingdoms", c: "Cartography, Cholas, Prashastis, Land Grants & Tripartite Struggle" }, { num: 2, name: "The Delhi Sultans & The Mughal Empire", c: "Iltutmish, Raziyya, Alauddin, Akbar, Mansabdars, Sulh-i Kul" }, { num: 3, name: "Tribes, Nomads and Settled Communities & Devotional Paths", c: "Ahom, Gonds, Bhakti Movement, Sufism, Kabir, Guru Nanak" }, { num: 4, name: "The Making of Regional Cultures & 18th-Century Political Formations", c: "Kathak, Miniature Paintings, Marathas, Shivaji & Peshwas" }] },
      { num: 2, name: "Unit 2: Geography – Our Environment", chapters: [{ num: 5, name: "Environment, Inside Our Earth & Our Changing Earth", c: "Abiotic/Biotic, Crust/Mantle/Core, Igneous/Sedimentary, Plate Tectonics & Erosion" }, { num: 6, name: "Air, Water, Human Environment & Life in the Deserts", c: "Atmosphere Layers, Ocean Currents, Amazon Basin, Sahara & Ladakh" }] },
      { num: 3, name: "Unit 3: Civics – Social and Political Life-II", chapters: [{ num: 7, name: "On Equality & Role of the Government in Health", c: "Article 15, Midday Meal Scheme, Public vs Private Healthcare" }, { num: 8, name: "How the State Government Works & Growing up as Boys and Girls", c: "MLAs, Cabinet, Gender Roles & Domestic Work Recognition" }, { num: 9, name: "Media, Advertising & Markets Around Us", c: "Media Censorship, Weekly Markets, Supply Chains & A Shirt in the Market" }] }
    ];
  } else if (lvl === 8) {
    cbseSocUnits = [
      { num: 1, name: "Unit 1: History – Our Pasts-III", chapters: [{ num: 1, name: "How, When and Where & From Trade to Territory", c: "Periodisation, East India Company, Battle of Plassey 1757, Buxar & Doctrine of Lapse" }, { num: 2, name: "Ruling the Countryside & Tribals, Dikus and the Golden Age", c: "Indigo Revolt, Permanent Settlement, Birsa Munda & Tribal Revolts" }, { num: 3, name: "When People Rebel 1857 and After & Civilising the \"Native\"", c: "Mangal Pandey, Bahadur Shah Zafar, Queen's Proclamation, Macaulay Minute, Wood's Despatch" }, { num: 4, name: "Women, Caste and Reform & The Making of the National Movement (1870s-1947)", c: "Sati Abolition, Widow Remarriage, Jyotirao Phule, Non-Cooperation, Salt Satyagraha, Quit India" }] },
      { num: 2, name: "Unit 2: Geography – Resources and Development", chapters: [{ num: 5, name: "Resources – Natural, Human-made and Human Resources", c: "Renewable/Non-renewable, Ubiquitous/Localised, Sustainable Development" }, { num: 6, name: "Land, Soil, Water, Natural Vegetation and Wildlife Resources", c: "Soil Degradation, Multipurpose Projects, Rainwater Harvesting, CITES" }, { num: 7, name: "Agriculture & Industries & Human Resources", c: "Subsistence/Commercial Farming, Iron & Steel (Jamshedpur/Pittsburgh), IT (Bengaluru/Silicon Valley), Population Pyramid" }] },
      { num: 3, name: "Unit 3: Civics – Social and Political Life-III", chapters: [{ num: 8, name: "The Indian Constitution & Understanding Secularism", c: "Federalism, Separation of Powers, Fundamental Rights, Secular State" }, { num: 9, name: "Parliament and the Making of Laws & Judiciary", c: "Lok Sabha, Rajya Sabha, Role of MP, Judicial Review, Public Interest Litigation (PIL)" }, { num: 10, name: "Understanding Marginalisation & Public Facilities / Law and Social Justice", c: "Adivasis, Minorities, Right to Water/Health, Bhopal Gas Tragedy & Enforcement of Labor Laws" }] }
    ];
  } else if (lvl === 9) {
    cbseSocUnits = [
      { num: 1, name: "Unit 1: History – India and the Contemporary World-I", chapters: [{ num: 1, name: "The French Revolution", c: "Estate System, Storming of Bastille, Jacobins, Robespierre Reign of Terror, Declaration of Rights" }, { num: 2, name: "Socialism in Europe and the Russian Revolution", c: "Liberals/Radicals, Tsar Nicholas II, Bolsheviks, Vladimir Lenin, October Revolution 1917, Stalin Collectivisation" }, { num: 3, name: "Nazism and the Rise of Hitler", c: "Weimar Republic, Hyperinflation, Hitler's Rise, Holocaust, Youth in Nazi Germany" }] },
      { num: 2, name: "Unit 2: Geography – Contemporary India-I", chapters: [{ num: 4, name: "India – Size and Location & Physical Features of India", c: "82°30'E Standard Meridian, Northern Mountains, Northern Plains, Peninsular Plateau, Thar Desert, Coastal Plains, Islands" }, { num: 5, name: "Drainage – Himalayan and Peninsular Rivers", c: "Indus, Ganga, Brahmaputra, Narmada, Tapi, Godavari, Krishna, Mahanadi, Kaveri" }, { num: 6, name: "Climate & Natural Vegetation and Wildlife", c: "Monsoon Mechanism, Factors controlling climate, Tropical Evergreen, Deciduous, Mangroves" }] },
      { num: 3, name: "Unit 3: Political Science – Democratic Politics-I", chapters: [{ num: 7, name: "What is Democracy? Why Democracy? & Constitutional Design", c: "Free & Fair Elections, Rule of Law, Nelson Mandela Apartheid, Drafting Indian Constitution" }, { num: 8, name: "Electoral Politics & Working of Institutions", c: "Voter List, Universal Adult Suffrage, Model Code of Conduct, Parliament, Prime Minister & Supreme Court" }, { num: 9, name: "Democratic Rights", c: "Right to Equality, Freedom, Religious Freedom, Cultural Rights, Constitutional Remedies Article 32" }] },
      { num: 4, name: "Unit 4: Economics – Understanding Economic Development", chapters: [{ num: 10, name: "The Story of Village Palampur & People as Resource", c: "Factors of Production (Land, Labor, Capital), Human Capital Formation, Health, Education, Unemployment Types" }, { num: 11, name: "Poverty as a Challenge & Food Security in India", c: "Poverty Line, Causes, Anti-Poverty Programmes, Buffer Stock, Public Distribution System (PDS)" }] }
    ];
  } else if (lvl === 10) {
    cbseSocUnits = [
      { num: 1, name: "Unit 1: History – India and the Contemporary World-II", chapters: [{ num: 1, name: "The Rise of Nationalism in Europe", c: "Frederic Sorrieu Vision, French Revolution Legacy, Mazzini, Cavour, Garibaldi, German & Italian Unification" }, { num: 2, name: "Nationalism in India", c: "First World War Impact, Rowlatt Act, Jallianwala Bagh, Non-Cooperation, Civil Disobedience, Salt March, Poona Pact" }, { num: 3, name: "The Making of a Global World & The Age of Industrialisation", c: "Silk Routes, Rinderpest, Great Depression 1929, Bretton Woods Institutions, Proto-industrialisation, Steam Power" }, { num: 4, name: "Print Culture and the Modern World", c: "Gutenberg Press, Reformation, Print Revolution, Censorship & Vernacular Press Act" }] },
      { num: 2, name: "Unit 2: Geography – Contemporary India-II", chapters: [{ num: 5, name: "Resources and Development & Forest and Wildlife Resources", c: "Resource Planning, Land Degradation, Sustainable Development, Sacred Groves, Project Tiger, Joint Forest Management" }, { num: 6, name: "Water Resources & Agriculture", c: "Multipurpose Projects, Rainwater Harvesting, Kharif/Rabi/Zaid, Rice, Wheat, Cotton, Tea, Coffee, Bhoodan-Gramdan" }, { num: 7, name: "Minerals, Energy Resources & Manufacturing Industries", c: "Metallic/Non-metallic minerals, Thermal/Hydro/Solar power, Textile, Iron-Steel, Chemical industries, Pollution Control" }, { num: 8, name: "Lifelines of National Economy", c: "Golden Quadrilateral, Railways, Pipelines, Major Sea Ports, Air Transport & Communication" }] },
      { num: 3, name: "Unit 3: Political Science – Democratic Politics-II", chapters: [{ num: 9, name: "Power Sharing & Federalism", c: "Belgium vs Sri Lanka models, Majoritarianism, Horizontal/Vertical Sharing, Union/State/Concurrent Lists, Decentralisation" }, { num: 10, name: "Gender, Religion and Caste & Political Parties", c: "Feminist Movements, Secular State, Caste in Politics, National vs State Parties, Challenges to Parties & Electoral Reforms" }, { num: 11, name: "Outcomes of Democracy", c: "Accountable, Responsive, Legitimate Government, Economic Growth, Reduction of Inequality & Dignity of Citizens" }] },
      { num: 4, name: "Unit 4: Economics – Understanding Economic Development", chapters: [{ num: 12, name: "Development & Sectors of the Indian Economy", c: "Per Capita Income, Human Development Index (HDI), Primary/Secondary/Tertiary Sectors, Disguised Unemployment, MGNREGA" }, { num: 13, name: "Money and Credit & Globalisation and the Indian Economy", c: "Barter System, Modern Currency Forms, Formal vs Informal Credit, SHGs, MNCs, Foreign Investment, WTO Impact" }, { num: 14, name: "Consumer Rights", c: "Consumer Exploitation, COPRA 1986, Right to Information (RTI), Consumer Protection Councils & Forums" }] }
    ];
  }
  subjectsList.push({
    board: "CBSE", classLevel: lvl, name: "Social Science", code: "SOC", icon: "🌍", color: "#10ac84",
    units: cbseSocUnits
  });
}

// --- 2.3 CBSE HIGHER SECONDARY (Classes 11 & 12) ---
for (let lvl of [11, 12]) {
  // English Core (Hornbill / Snapshots / Flamingo / Vistas)
  subjectsList.push({
    board: "CBSE", classLevel: lvl, name: "English", code: "ENG", icon: "📚", color: "#fa8231",
    units: [
      { num: 1, name: "Unit 1: Reading Comprehension & Analytical Essays", chapters: [{ num: 1, name: `Unseen Passage Comprehension & Note Making (Class ${lvl})`, c: "Inference, Vocabulary, Title & Sub-headings" }] },
      { num: 2, name: "Unit 2: Advanced Writing Skills & Creative Composition", chapters: [{ num: 2, name: `Notice, Invitations, Formal Letters & Article Writing (Class ${lvl})`, c: "Official Correspondence, Job Applications & Editor Letters" }] },
      { num: 3, name: "Unit 3: Literature Core Prose & Poetry", chapters: [{ num: 3, name: `Prescribed Prose Masterpieces (Class ${lvl} NCERT)`, c: "Themes, Characterisation & Literary Irony" }, { num: 4, name: `Prescribed Poetry & Poetic Devices (Class ${lvl} NCERT)`, c: "Metaphors, Rhyme Scheme & Aesthetic Appreciation" }] },
      { num: 4, name: "Unit 4: Supplementary Reader", chapters: [{ num: 5, name: `Supplementary Masterpieces (Class ${lvl} NCERT)`, c: "Plot Development, Themes & Philosophical Motifs" }] }
    ]
  });

  // Physics
  let cbsePhyUnits = [];
  if (lvl === 11) {
    cbsePhyUnits = [
      { num: 1, name: "Unit 1: Units, Measurements & Kinematics", chapters: [{ num: 1, name: "Units and Measurements", c: "SI Base Units, Dimensional Analysis & Significant Figures" }, { num: 2, name: "Motion in a Straight Line & Motion in a Plane", c: "Vectors, Relative Velocity, Uniform Acceleration & Projectile Motion" }] },
      { num: 2, name: "Unit 2: Laws of Motion, Work, Energy & Power", chapters: [{ num: 3, name: "Laws of Motion & Friction", c: "Newton's Laws, Inertia, Momentum, Static/Kinetic Friction & Circular Dynamics" }, { num: 4, name: "Work, Energy and Power & System of Particles", c: "Work-Energy Theorem, Collisions, Center of Mass, Torque & Rotational Inertia" }] },
      { num: 3, name: "Unit 3: Gravitation & Mechanical Properties of Matter", chapters: [{ num: 5, name: "Gravitation – Kepler's Laws & Escape Speed", c: "Universal Gravitation, Acceleration due to Gravity & Satellite Orbits" }, { num: 6, name: "Mechanical Properties of Solids & Fluids", c: "Hooke's Law, Young's Modulus, Pascal's Principle, Bernoulli's Equation & Viscosity" }] },
      { num: 4, name: "Unit 4: Thermodynamics, Kinetic Theory & Oscillations", chapters: [{ num: 7, name: "Thermal Properties & Thermodynamics", c: "Specific Heat, Latent Heat, First & Second Laws of Thermodynamics" }, { num: 8, name: "Kinetic Theory, Oscillations and Waves", c: "RMS Speed, Degrees of Freedom, SHM, Simple Pendulum, Wave Equation & Doppler Effect" }] }
    ];
  } else {
    cbsePhyUnits = [
      { num: 1, name: "Unit 1: Electrostatics & Current Electricity", chapters: [{ num: 1, name: "Electric Charges, Fields & Gauss's Law", c: "Coulomb's Law, Dipole, Flux & Field Calculations" }, { num: 2, name: "Electrostatic Potential, Capacitance & Current Electricity", c: "Equipotential Surfaces, Capacitors in Series/Parallel, Ohm's Law, Kirchhoff's Rules & Potentiometer" }] },
      { num: 2, name: "Unit 2: Magnetic Effects of Current & Magnetism", chapters: [{ num: 3, name: "Moving Charges, Magnetism and Matter", c: "Biot-Savart Law, Ampere's Law, Lorentz Force, Cyclotron & Magnetic Dipole" }] },
      { num: 3, name: "Unit 3: Electromagnetic Induction, AC & EM Waves", chapters: [{ num: 4, name: "Electromagnetic Induction & Alternating Currents", c: "Faraday's Law, Lenz's Law, Mutual Inductance, LCR Series Circuit & Transformers" }, { num: 5, name: "Electromagnetic Waves", c: "Displacement Current & EM Spectrum Characteristics" }] },
      { num: 4, name: "Unit 4: Optics & Modern Physics", chapters: [{ num: 6, name: "Ray Optics and Wave Optics", c: "Reflection, Refraction, Lens Maker Formula, Microscope, Telescope, Huygens' Principle, Interference & Diffraction" }, { num: 7, name: "Dual Nature of Radiation, Atoms & Nuclei", c: "Photoelectric Equation, de Broglie, Bohr Atom, Mass Defect, Radioactivity, Fission & Fusion" }] },
      { num: 5, name: "Unit 5: Semiconductor Devices", chapters: [{ num: 8, name: "Semiconductor Electronics – Materials, Devices and Simple Circuits", c: "Intrinsic/Extrinsic Semiconductors, p-n Junction, Rectifiers, Zener Diode & Logic Gates" }] }
    ];
  }
  subjectsList.push({
    board: "CBSE", classLevel: lvl, name: "Physics", code: "PHY", icon: "⚡", color: "#3867d6",
    units: cbsePhyUnits
  });

  // Chemistry
  let cbseChemUnits = [];
  if (lvl === 11) {
    cbseChemUnits = [
      { num: 1, name: "Unit 1: Basic Concepts, Structure of Atom & Classification", chapters: [{ num: 1, name: "Some Basic Concepts of Chemistry", c: "Mole Concept, Empirical Formula, Stoichiometry" }, { num: 2, name: "Structure of Atom", c: "Quantum Numbers, Orbitals, Aufbau, Pauli & Hund's Rule" }, { num: 3, name: "Classification of Elements and Periodicity in Properties", c: "Periodic Trends in Radii, Ionization Enthalpy & Electronegativity" }] },
      { num: 2, name: "Unit 2: Chemical Bonding, Thermodynamics & Equilibrium", chapters: [{ num: 4, name: "Chemical Bonding and Molecular Structure", c: "VSEPR Theory, Hybridisation (sp, sp2, sp3), MO Theory & Hydrogen Bond" }, { num: 5, name: "Chemical Thermodynamics", c: "State Functions, First Law, Enthalpy of Reactions, Hess's Law, Entropy, Gibbs Energy" }, { num: 6, name: "Equilibrium & Redox Reactions", c: "Le Chatelier Principle, pH, Buffer Solutions, Solubility Product & Oxidation Numbers" }] },
      { num: 3, name: "Unit 3: Organic Chemistry Principles & Hydrocarbons", chapters: [{ num: 7, name: "Organic Chemistry – Some Basic Principles and Techniques", c: "IUPAC Nomenclature, Electronic Displacements, Inductive, Resonance, Hyperconjugation" }, { num: 8, name: "Hydrocarbons", c: "Alkanes, Alkenes, Alkynes, Benzene Aromaticity, Electrophilic Substitution" }] }
    ];
  } else {
    cbseChemUnits = [
      { num: 1, name: "Unit 1: Solutions, Electrochemistry & Chemical Kinetics", chapters: [{ num: 1, name: "Solutions", c: "Henry's Law, Raoult's Law, Colligative Properties, Van't Hoff Factor" }, { num: 2, name: "Electrochemistry", c: "Nernst Equation, Kohlrausch Law, Fuel Cells, Corrosion" }, { num: 3, name: "Chemical Kinetics", c: "Rate Law, Integrated Rate Equations, Arrhenius Equation, Activation Energy" }] },
      { num: 2, name: "Unit 2: Inorganic Chemistry – d-Block, f-Block & Coordination", chapters: [{ num: 4, name: "The d- and f-Block Elements", c: "Lanthanoid Contraction, Magnetic Properties, Catalytic Behavior" }, { num: 5, name: "Coordination Compounds", c: "Werner's Theory, IUPAC Naming, Crystal Field Theory, Isomerism" }] },
      { num: 3, name: "Unit 3: Organic Chemistry – Haloalkanes, Alcohols, Carbonyls & Amines", chapters: [{ num: 6, name: "Haloalkanes and Haloarenes & Alcohols, Phenols and Ethers", c: "SN1/SN2 Mechanisms, Kolbe Reaction, Reimer-Tiemann, Williamson Synthesis" }, { num: 7, name: "Aldehydes, Ketones, Carboxylic Acids & Amines", c: "Nucleophilic Addition, Aldol, Cannizzaro, Gabriel Phthalimide, Diazonium Salts" }, { num: 8, name: "Biomolecules", c: "Carbohydrates, Amino Acids, Peptide Bond, DNA/RNA Structure & Vitamins" }] }
    ];
  }
  subjectsList.push({
    board: "CBSE", classLevel: lvl, name: "Chemistry", code: "CHEM", icon: "🧪", color: "#8854d0",
    units: cbseChemUnits
  });

  // Mathematics
  let cbseHseMath = [];
  if (lvl === 11) {
    cbseHseMath = [
      { num: 1, name: "Unit 1: Sets, Relations, Functions & Trigonometry", chapters: [{ num: 1, name: "Sets and Relations and Functions", c: "Cartesian Products, Injective/Surjective, Domain, Range" }, { num: 2, name: "Trigonometric Functions", c: "Compound Angles, Multiple Angles & General Solutions" }] },
      { num: 2, name: "Unit 2: Complex Numbers, Inequalities, Permutations & Binomial", chapters: [{ num: 3, name: "Complex Numbers, Quadratic Equations & Linear Inequalities", c: "Argand Plane, Modulus, Conjugate & Graphical Inequalities" }, { num: 4, name: "Permutations, Combinations & Binomial Theorem", c: "Fundamental Principle of Counting, nPr, nCr & General Term Expansion" }, { num: 5, name: "Sequences and Series (AP, GP)", c: "Arithmetic Mean, Geometric Mean & Infinite GP Sum" }] },
      { num: 3, name: "Unit 3: Coordinate Geometry & 3D Geometry", chapters: [{ num: 6, name: "Straight Lines & Conic Sections", c: "Slope, Normal Form, Parabola, Ellipse, Hyperbola Standard Equations" }, { num: 7, name: "Introduction to Three Dimensional Geometry", c: "Coordinates in 3D, Distance Formula, Section Formula in Space" }] },
      { num: 4, name: "Unit 4: Calculus, Statistics & Probability", chapters: [{ num: 8, name: "Limits and Derivatives", c: "Standard Limits, First Principle Differentiation & Derivative Rules" }, { num: 9, name: "Statistics and Probability", c: "Mean Deviation, Variance, Standard Deviation & Axiomatic Probability" }] }
    ];
  } else {
    cbseHseMath = [
      { num: 1, name: "Unit 1: Relations, Functions & Inverse Trigonometry", chapters: [{ num: 1, name: "Relations and Functions & Inverse Trigonometric Functions", c: "Reflexive, Symmetric, Transitive, Principal Value Branches & Graph Properties" }] },
      { num: 2, name: "Unit 2: Matrices and Determinants", chapters: [{ num: 2, name: "Matrices and Determinants", c: "Matrix Multiplication, Inverse, Adjoint, Area of Triangle, Matrix Method for System of Equations" }] },
      { num: 3, name: "Unit 3: Calculus – Continuity, Differentiability, Integrals & Differential Equations", chapters: [{ num: 3, name: "Continuity, Differentiability & Applications of Derivatives", c: "Chain Rule, Logarithmic Differentiation, Rate of Change, Increasing/Decreasing, Maxima/Minima" }, { num: 4, name: "Integrals & Applications of Integrals", c: "Substitution, Partial Fractions, By Parts, Definite Integral Properties, Area under Curves" }, { num: 5, name: "Differential Equations", c: "Order, Degree, General Solution, Variable Separable, Homogeneous & Linear DEs" }] },
      { num: 4, name: "Unit 4: Vectors, Three-Dimensional Geometry & Linear Programming", chapters: [{ num: 6, name: "Vectors and Three Dimensional Geometry", c: "Dot/Cross Product, Direction Cosines, Equation of Line, Shortest Distance between Skew Lines" }, { num: 7, name: "Linear Programming & Probability", c: "Graphical Optimization, Corner Point Method, Conditional Probability, Bayes' Theorem & Random Variables" }] }
    ];
  }
  subjectsList.push({
    board: "CBSE", classLevel: lvl, name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4",
    units: cbseHseMath
  });

  // Biology
  subjectsList.push({
    board: "CBSE", classLevel: lvl, name: "Biology", code: "BIO", icon: "🧬", color: "#20bf6b",
    units: [
      { num: 1, name: "Unit 1: Diversity & Structural Organisation in Organisms", chapters: [{ num: 1, name: `Biological Classification & Plant/Animal Kingdom (Class ${lvl})`, c: "Five Kingdom Classification, Gymnosperms, Angiosperms & Chordates" }, { num: 2, name: `Morphology & Anatomy of Flowering Plants (Class ${lvl})`, c: "Root, Stem, Leaf modifications, Tissues & Secondary Growth" }] },
      { num: 2, name: "Unit 2: Cell Biology, Biomolecules & Human Physiology", chapters: [{ num: 3, name: `Cell Cycle, Mitosis, Meiosis & Biomolecules (Class ${lvl})`, c: "Chromosomes, Enzymes, Activation Energy & Cell Division Stages" }, { num: 4, name: `Human Respiration, Circulation & Neural Control (Class ${lvl})`, c: "Gas Exchange, ECG, Cardiac Cycle, Action Potential & Synapse" }] },
      { num: 3, name: "Unit 3: Genetics, Evolution, Biotechnology & Ecology", chapters: [{ num: 5, name: `Mendelian Genetics, DNA Replication & Human Evolution (Class ${lvl})`, c: "Pedigree Analysis, Lac Operon, Genetic Code & Hardy-Weinberg Equilibrium" }, { num: 6, name: `Biotechnology Principles, Applications & Ecosystems (Class ${lvl})`, c: "Restriction Enzymes, Gel Electrophoresis, Bt Crops, Bioreactors & Nutrient Cycling" }] }
    ]
  });

  // Computer Science
  subjectsList.push({
    board: "CBSE", classLevel: lvl, name: "Computer Science", code: "CS", icon: "💻", color: "#2d98da",
    units: [
      { num: 1, name: "Unit 1: Computational Thinking and Programming (Python)", chapters: [{ num: 1, name: `Python Syntax, Flow Control, Functions & Recursion (Class ${lvl})`, c: "Mutable vs Immutable, Scope, Default Parameters, Modules" }, { num: 2, name: `File Handling, Text, Binary & CSV Files in Python (Class ${lvl})`, c: "open(), read(), write(), pickle module, csv.reader/writer" }, { num: 3, name: `Data Structures – Stack Implementation (Class ${lvl})`, c: "LIFO, Push, Pop, Peak using Python Lists" }] },
      { num: 2, name: "Unit 2: Computer Networks & Database Management (SQL)", chapters: [{ num: 4, name: `Computer Networks – Topologies, Protocols & Network Devices (Class ${lvl})`, c: "LAN/WAN, TCP/IP, DNS, HTTP/HTTPS, Router, Switch, Gateway" }, { num: 5, name: `Relational Database Concepts, SQL Queries & Python-SQL Connectivity (Class ${lvl})`, c: "Aggregate Functions, GROUP BY, HAVING, ORDER BY, Joins & mysql.connector" }, { num: 6, name: `Societal Impacts, Cyber Crime & Cyber Ethics (Class ${lvl})`, c: "Digital Footprint, Phishing, Ransomware, IT Act & Intellectual Property" }] }
    ]
  });

  // Informatics Practices
  subjectsList.push({
    board: "CBSE", classLevel: lvl, name: "Informatics Practices", code: "IP", icon: "💻", color: "#3867d6",
    units: [
      { num: 1, name: "Unit 1: Data Handling using Pandas and Matplotlib", chapters: [{ num: 1, name: `Python Pandas – Series, DataFrames & Data Analysis (Class ${lvl})`, c: "Creation, Slicing, Filtering, loc, iloc, Sorting & Aggregation" }, { num: 2, name: `Data Visualisation using Pyplot (Class ${lvl})`, c: "Line plots, Bar charts, Histograms, Customization & Legends" }] },
      { num: 2, name: "Unit 2: Database Query using SQL & Societal Impacts", chapters: [{ num: 3, name: `Advanced SQL Functions & Table Joins (Class ${lvl})`, c: "Math, String, Date Functions, Group By & Natural Join" }, { num: 4, name: `Emerging Trends, E-Waste Management & Cyber Law (Class ${lvl})`, c: "AI, IoT, Cloud, E-Waste Recycling, Net Etiquettes & Data Privacy" }] }
    ]
  });

  // Accountancy
  subjectsList.push({
    board: "CBSE", classLevel: lvl, name: "Accountancy", code: "ACC", icon: "📋", color: "#2bcbba",
    units: [
      { num: 1, name: "Unit 1: Financial Accounting – Principles & Final Accounts", chapters: [{ num: 1, name: `Theoretical Framework, Accounting Standards & GST (Class ${lvl})`, c: "Accrual Concept, Matching Principle, Dual Aspect & CGST/SGST/IGST" }, { num: 2, name: `Recording Transactions, BRS, Depreciation & Trial Balance (Class ${lvl})`, c: "Cash Book, Journal, Bank Reconciliation, SLM vs WDV Depreciation" }] },
      { num: 2, name: "Unit 2: Accounting for Partnership Firms & Companies", chapters: [{ num: 3, name: `Partnership Fundamentals, Goodwill, Admission & Dissolution (Class ${lvl})`, c: "P&L Appropriation, Fluctuating/Fixed Capital, Revaluation & Realisation Account" }, { num: 4, name: `Accounting for Share Capital & Issue of Debentures (Class ${lvl})`, c: "Calls in Arrears, Forfeiture, Reissue, Pro-rata Allotment & Debenture Redemption" }] },
      { num: 3, name: "Unit 3: Financial Statement Analysis & Cash Flow", chapters: [{ num: 5, name: `Comparative Statements, Common Size & Accounting Ratios (Class ${lvl})`, c: "Liquidity, Solvency, Activity & Profitability Ratios" }, { num: 6, name: `Cash Flow Statement (AS-3 Revised) (Class ${lvl})`, c: "Operating, Investing & Financing Activities" }] }
    ]
  });

  // Business Studies
  subjectsList.push({
    board: "CBSE", classLevel: lvl, name: "Business Studies", code: "BST", icon: "💼", color: "#ff9f43",
    units: [
      { num: 1, name: "Unit 1: Foundations of Business & Principles of Management", chapters: [{ num: 1, name: `Nature and Purpose of Business & Forms of Organisation (Class ${lvl})`, c: "Business vs Profession, Sole Proprietorship, Partnership, Company Incorporation" }, { num: 2, name: `Principles and Functions of Management (Class ${lvl})`, c: "Fayol's Principles, Taylor's Scientific Management, Planning & Organising" }] },
      { num: 2, name: "Unit 2: Corporate Finance, Marketing & Consumer Protection", chapters: [{ num: 3, name: `Financial Management, Financial Markets & Sources of Finance (Class ${lvl})`, c: "Capital Structure, Working Capital, Money Market, Capital Market & SEBI" }, { num: 4, name: `Marketing Management, 4Ps & Consumer Protection Act 2019 (Class ${lvl})`, c: "Product, Price, Place, Promotion, Consumer Rights & Three-Tier Redressal" }] }
    ]
  });

  // Economics
  subjectsList.push({
    board: "CBSE", classLevel: lvl, name: "Economics", code: "ECO", icon: "📈", color: "#ee5253",
    units: [
      { num: 1, name: "Unit 1: Microeconomics & Introductory Macroeconomics", chapters: [{ num: 1, name: `Consumer Equilibrium, Demand, Cost & Revenue (Class ${lvl})`, c: "Marginal Utility, Law of Demand, Elasticity & Production Function" }, { num: 2, name: `National Income Accounting, Money and Banking (Class ${lvl})`, c: "GDP, GNP, Real/Nominal GDP, Money Creation, Central Bank Functions" }] },
      { num: 2, name: "Unit 2: Government Budget & Indian Economic Development", chapters: [{ num: 3, name: `Determination of Income, Government Budget & Balance of Payments (Class ${lvl})`, c: "Aggregate Demand, Multiplier, Fiscal Deficit, Foreign Exchange Rates" }, { num: 4, name: `Indian Economy on Eve of Independence & Economic Reforms 1991 (Class ${lvl})`, c: "LPG Policies, Rural Development, Human Capital, Sustainable Development" }] }
    ]
  });

  // History
  subjectsList.push({
    board: "CBSE", classLevel: lvl, name: "History", code: "HIST", icon: "🏛️", color: "#5f27cd",
    units: [
      { num: 1, name: "Unit 1: Themes in Indian History – Part I (Ancient)", chapters: [{ num: 1, name: `Bricks, Beads and Bones (The Harappan Civilisation) (Class ${lvl})`, c: "Town Planning, Citadel, Great Bath, Seals, Script & Craft Production" }, { num: 2, name: `Kings, Farmers and Towns & Kinship, Caste and Class (Class ${lvl})`, c: "Early States, 16 Mahajanapadas, Mauryan Empire, Mahabharata Social Patterns" }, { num: 3, name: `Thinkers, Beliefs and Buildings (Cultural Developments) (Class ${lvl})`, c: "Vedic Traditions, Sanchi Stupa, Jainism, Buddhism & Temple Architecture" }] },
      { num: 2, name: "Unit 2: Themes in Indian History – Part II & III (Medieval & Modern)", chapters: [{ num: 4, name: `Through the Eyes of Travellers & Bhakti-Sufi Traditions (Class ${lvl})`, c: "Al-Biruni, Ibn Battuta, Francois Bernier, Kabir, Mirabai, Sufi Silsilas" }, { num: 5, name: `An Imperial Capital: Vijayanagara & Peasants, Zamindars and State (Class ${lvl})`, c: "Hampi, Mahanavami Dibba, Ain-i-Akbari, Mughal Agrarian Relations" }, { num: 6, name: `Colonialism, 1857 Revolt & Mahatma Gandhi and Nationalist Movement (Class ${lvl})`, c: "Santhal Rebellion, 1857 Revolt, Non-Cooperation, Salt March, Quit India & Partition" }, { num: 7, name: `Framing the Constitution (The Beginning of a New Era) (Class ${lvl})`, c: "Constituent Assembly Debates, Drafting Committee & Preamble Objectives" }] }
    ]
  });
}

console.log(`Curriculum build configured total subjects: ${subjectsList.length}`);

// Generate LearnQuestCurriculumSeeder.java
let javaCode = `package com.computerquest.computer_quest_backend.config;

import com.computerquest.computer_quest_backend.entity.Chapter;
import com.computerquest.computer_quest_backend.entity.Mission;
import com.computerquest.computer_quest_backend.entity.Question;
import com.computerquest.computer_quest_backend.entity.Subject;
import com.computerquest.computer_quest_backend.entity.Unit;
import com.computerquest.computer_quest_backend.repository.ChapterRepository;
import com.computerquest.computer_quest_backend.repository.MissionRepository;
import com.computerquest.computer_quest_backend.repository.QuestionRepository;
import com.computerquest.computer_quest_backend.repository.SubjectRepository;
import com.computerquest.computer_quest_backend.repository.UnitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(1)
public class LearnQuestCurriculumSeeder implements CommandLineRunner {

    private final SubjectRepository subjectRepository;
    private final UnitRepository unitRepository;
    private final ChapterRepository chapterRepository;
    private final MissionRepository missionRepository;
    private final QuestionRepository questionRepository;

    public LearnQuestCurriculumSeeder(
            SubjectRepository subjectRepository,
            UnitRepository unitRepository,
            ChapterRepository chapterRepository,
            MissionRepository missionRepository,
            QuestionRepository questionRepository) {
        this.subjectRepository = subjectRepository;
        this.unitRepository = unitRepository;
        this.chapterRepository = chapterRepository;
        this.missionRepository = missionRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public void run(String... args) {
        seedAllCurricula();
    }

    public void seedAllCurricula() {
        clearExistingDefaultCurricula();
`;

// Call seed methods for each board and grade
for (let lvl = 4; lvl <= 12; lvl++) {
  javaCode += `        seed_CBSE_Class_${lvl}();\n`;
}
for (let lvl = 4; lvl <= 12; lvl++) {
  javaCode += `        seed_STATE_BOARD_Class_${lvl}();\n`;
}

javaCode += `    }\n\n`;

javaCode += `    private void clearExistingDefaultCurricula() {
        try {
            questionRepository.deleteAll(questionRepository.findBySchoolIsNull());
            missionRepository.deleteAll(missionRepository.findBySchoolIsNull());
            chapterRepository.deleteAll(chapterRepository.findBySchoolIsNull());
            unitRepository.deleteAll(unitRepository.findBySchoolIsNull());
            subjectRepository.deleteAll(subjectRepository.findBySchoolIsNull());
        } catch (Exception e) {
            System.err.println("Note on clearing default curricula: " + e.getMessage());
        }
    }\n\n`;

// Generate individual seed methods
for (let b of ["CBSE", "STATE_BOARD"]) {
  for (let lvl = 4; lvl <= 12; lvl++) {
    const subsForClass = subjectsList.filter(s => s.board === b && s.classLevel === lvl);
    javaCode += `    private void seed_${b}_Class_${lvl}() {\n`;
    javaCode += `        String board = "${b}";\n`;
    javaCode += `        int classLevel = ${lvl};\n\n`;

    let subIdx = 0;
    for (const sub of subsForClass) {
      subIdx++;
      const sVar = `sub_${sub.code}_${lvl}_${subIdx}`;
      javaCode += `        // Subject: ${sub.name}\n`;
      javaCode += `        Subject ${sVar} = subjectRepository\n`;
      javaCode += `                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "${esc(sub.name)}")\n`;
      javaCode += `                .orElseGet(() -> subjectRepository.save(new Subject("${esc(sub.name)}", "${esc(sub.code)}", "${esc(sub.icon)}", "${esc(sub.color)}", board, classLevel)));\n\n`;

      let uIdx = 0;
      for (const u of sub.units) {
        uIdx++;
        const uVar = `u_${sub.code}_${lvl}_${subIdx}_${uIdx}`;
        javaCode += `        // Unit: ${u.name}\n`;
        javaCode += `        Unit ${uVar} = unitRepository\n`;
        javaCode += `                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "${esc(sub.name)}")\n`;
        javaCode += `                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == ${u.num}).findFirst()\n`;
        javaCode += `                .orElseGet(() -> unitRepository.save(new Unit("${esc(u.name)}", ${u.num}, "${esc(sub.name)}", board, classLevel)));\n\n`;

        for (const ch of u.chapters) {
          const chVar = `ch_${sub.code}_${lvl}_${subIdx}_${uIdx}_${ch.num}`;
          javaCode += `        // Chapter: ${ch.name}\n`;
          javaCode += `        Chapter ${chVar} = chapterRepository\n`;
          javaCode += `                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "${esc(sub.name)}", ${ch.num})\n`;
          javaCode += `                .orElseGet(() -> chapterRepository.save(new Chapter("${esc(sub.name)}", "${esc(u.name)}", ${ch.num}, "${esc(ch.name)}", ${ch.num === 1}, board, classLevel)));\n`;
          javaCode += `        seedMissionsAndQuestions(board, classLevel, "${esc(sub.name)}", "${esc(u.name)}", "${esc(ch.name)}", ${chVar}, "${esc(ch.c || ch.concept || ch.name)}");\n\n`;
        }
      }
    }
    javaCode += `    }\n\n`;
  }
}

// Generate the question builder helpers in Java
javaCode += `    private void seedMissionsAndQuestions(String board, int classLevel, String subject, String unitName, String chapterName, Chapter chapter, String concept) {
        List<Mission> existingMissions = missionRepository.findByChapter_Id(chapter.getId());
        if (!existingMissions.isEmpty()) {
            return;
        }

        String[] mTypes = {"CONCEPT", "MCQ", "FILL_BLANK", "PROBLEM", "SCENARIO"};

        for (int m = 1; m <= 5; m++) {
            Mission mission = new Mission();
            mission.setChapter(chapter);
            mission.setMissionNumber(m);
            mission.setGameType(m == 3 ? "FILL_BLANK" : mTypes[m - 1]);
            mission = missionRepository.save(mission);

            for (int q = 1; q <= 5; q++) {
                Question question = new Question();
                question.setBoard(board);
                question.setClassLevel(classLevel);
                question.setSubject(subject);
                question.setUnit(unitName);
                question.setChapter(chapterName);
                question.setMission(m);
                question.setQuestionType(m == 3 ? "FILL_BLANK" : "MCQ");
                question.setQuestionText(generateQuestionText(board, classLevel, subject, chapterName, concept, m, q));
                
                String[] opts = generateOptions(board, classLevel, subject, chapterName, concept, m, q);
                question.setOptionA(opts[0]);
                question.setOptionB(opts[1]);
                question.setOptionC(opts[2]);
                question.setOptionD(opts[3]);
                question.setCorrectAnswer(m == 3 ? opts[0] : "A");
                questionRepository.save(question);
            }
        }
    }

    private String generateQuestionText(String board, int classLevel, String subject, String chapterName, String concept, int m, int q) {
        if ("Tamil".equalsIgnoreCase(subject)) {
            if (m == 1) return "'" + chapterName + "' பாடப்பகுதியில் சுட்டப்படும் முதன்மைக் கருத்து யாது? (வினா எண் " + q + ")";
            if (m == 2) return "'" + chapterName + "' பற்றிய பின்வரும் கூற்றுகளில் சரியானது எது? (வினா எண் " + q + ")";
            if (m == 3) return "'" + chapterName + "' பாடலில் இடம்பெற்றுள்ள மையச் சொல் _______ ஆகும்.";
            if (m == 4) return "'" + chapterName + "' உணர்த்தும் வாழ்வியல் அறநெறி மற்றும் இலக்கிய நயம் யாது?";
            return "'" + chapterName + "' பாடக்கருத்தை இன்றைய அன்றாட வாழ்வில் எவ்வாறு பின்பற்றலாம்?";
        }
        if (m == 1) return "In " + subject + " (" + board + " Class " + classLevel + "), what is the fundamental principle established in '" + chapterName + "'?";
        if (m == 2) return "Which of the following statements is scientifically and textually accurate regarding '" + chapterName + "'?";
        if (m == 3) return "In the study of '" + chapterName + "', the core concept governing " + concept + " is _______.";
        if (m == 4) return "Analyze the key relationship and problem-solving formulation in '" + chapterName + "' regarding " + concept + ":";
        return "How does the principle of '" + chapterName + "' apply to real-world practical scenarios?";
    }

    private String[] generateOptions(String board, int classLevel, String subject, String chapterName, String concept, int m, int q) {
        if ("Tamil".equalsIgnoreCase(subject)) {
            return new String[]{
                concept + " பற்றிய பாடநூல் சார்ந்த சரியான விளக்கம்",
                "பொருத்தமற்ற அல்லது பிழையான கருத்து",
                "பாடப்பகுதிக்குத் தொடர்பில்லாத கூற்று",
                "பொதுவான தவறான விடை"
            };
        }
        return new String[]{
            "Accurate textbook principle of " + concept + " for " + chapterName,
            "Opposing incorrect theoretical statement",
            "Alternative invalid mathematical or scientific misconception",
            "None of the above"
        };
    }
}
`;

fs.writeFileSync(path.join(__dirname, 'LearnQuestCurriculumSeeder.java'), javaCode, 'utf8');
console.log('Successfully wrote LearnQuestCurriculumSeeder.java!');
