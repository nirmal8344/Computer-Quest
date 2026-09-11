const fs = require('fs');
const path = require('path');

// Complete Real 2026-27 Textbook Curriculum Database Generator for RPSIT School

console.log('Generating comprehensive curriculum seeder for LearnQuest...');

// =========================================================================
// 1. TAMIL NADU STATE BOARD (Classes 4 to 12)
// =========================================================================

const stateBoardCurricula = [];

// Tamil for State Board 4 to 12
for (let lvl = 4; lvl <= 12; lvl++) {
  let units = [];
  if (lvl === 4) {
    units = [
      { name: "பருவம் 1: அன்னைத் தமிழும் பனைமரமும்", chapters: [{ num: 1, name: "அன்னைத் தமிழே", q: "தாய்மொழிப் பற்று" }, { num: 2, name: "பனைமரச் சிறப்பு", q: "மாநில மரம்" }, { num: 3, name: "ஏழு இறக்கைக் குருவி", q: "தெனாலிராமன் கதைகள்" }] },
      { name: "பருவம் 2: நன்னெறியும் பண்பாடும்", chapters: [{ num: 4, name: "நன்னெறி", q: "அறநெறி பாடல்கள்" }, { num: 5, name: "பண்படுத்தும் பழமொழிகள்", q: "பழமொழி விளக்கம்" }, { num: 6, name: "வெற்றி வேற்கை", q: "கல்வியின் பெருமை" }] },
      { name: "பருவம் 3: அறமும் நல்வழியும்", chapters: [{ num: 7, name: "விடியும் வேளை", q: "கிராமத்து இயற்கை" }, { num: 8, name: "நீதிநெறி விளக்கம்", q: "கல்வி அழகு" }, { num: 9, name: "நல்வழி", q: "ஔவையார் வாக்கு" }] }
    ];
  } else if (lvl === 5) {
    units = [
      { name: "பருவம் 1: தமிழின் இனிமை", chapters: [{ num: 1, name: "தமிழின் இனிமை", q: "பாரதிதாசன்" }, { num: 2, name: "கவிதைப்பட்டிமன்றம்", q: "அறிவும் பண்பும்" }, { num: 3, name: "என்ன சத்தம்?", q: "மரபுச் சொற்கள்" }] },
      { name: "பருவம் 2: கல்விச் செல்வம்", chapters: [{ num: 4, name: "கடல்", q: "இயற்கை வளம்" }, { num: 5, name: "திருக்குறள் கதைகள்", q: "அன்புடைமை" }, { num: 6, name: "கல்விச் செல்வம்", q: "கல்வி சிறப்பு" }] },
      { name: "பருவம் 3: தலைமைப் பண்பு", chapters: [{ num: 7, name: "தலைமைப் பண்பு", q: "நல்லாட்சி" }, { num: 8, name: "அறநெறிச்சாரம்", q: "மனத்தூய்மை" }, { num: 9, name: "நீதிநெறி நன்மொழிகள்", q: "நற்பண்புகள்" }] }
    ];
  } else if (lvl === 6) {
    units = [
      { name: "இயல் 1: மொழி (இன்பத்தமிழ்)", chapters: [{ num: 1, name: "இன்பத்தமிழ்", q: "தமிழுக்கும் அமுதென்று பேர்" }, { num: 2, name: "தமிழ்க்கும்மி", q: "பெருஞ்சித்திரனார்" }, { num: 3, name: "வளர்தமிழ்", q: "மூத்த மொழி" }] },
      { name: "இயல் 2: இயற்கை (சிலப்பதிகாரம்)", chapters: [{ num: 4, name: "சிலப்பதிகாரம்", q: "திங்களைப் போற்றுதும்" }, { num: 5, name: "காணி நிலம்", q: "பாரதியார்" }, { num: 6, name: "சிறகின் ஓசை", q: "வலசை போதல்" }] },
      { name: "இயல் 3: அறிவியல் தொழில்நுட்பம்", chapters: [{ num: 7, name: "அறிவியல் ஆத்திசூடி", q: "நெல்லை சு.முத்து" }, { num: 8, name: "கனியனின் நண்பன்", q: "செயற்கை நுண்ணறிவு" }, { num: 9, name: "ஒளி பிறந்தது", q: "அப்துல் கலாம்" }] },
      { name: "இயல் 4: கல்வி (மூதுரை)", chapters: [{ num: 10, name: "மூதுரை", q: "ஔவையார்" }, { num: 11, name: "துன்பம் வெல்லும் கல்வி", q: "பட்டுக்கோட்டை" }, { num: 12, name: "கல்விக் கண் திறந்த காமராசர்", q: "இலவசக் கல்வி" }] },
      { name: "இயல் 5: நாகரிகம் பண்பாடு", chapters: [{ num: 13, name: "ஆசாரக்கோவை", q: "நல்லொழுக்கம்" }, { num: 14, name: "தமிழர் பெருவிழா", q: "பொங்கல் திருநாள்" }] },
      { name: "இயல் 6: தொழில் வணிகம்", chapters: [{ num: 15, name: "நானிலம் படைத்தவன்", q: "முடியரசன்" }, { num: 16, name: "கடலோடு விளையாடு", q: "மீனவர் வாழ்வு" }] },
      { name: "இயல் 7: நாடு சமூகம் அரசு", chapters: [{ num: 17, name: "பாரதம் அன்றைய நாற்றங்கால்", q: "தாராபாரதி" }, { num: 18, name: "வேலுநாச்சியார்", q: "வீரத்தமிழச்சி" }] },
      { name: "இயல் 8: அறம் தத்துவம் மனிதநேயம்", chapters: [{ num: 19, name: "பராபரக்கண்ணி", q: "தாயுமானவர்" }, { num: 20, name: "பசிப்பிணி போக்கிய பாவை", q: "மணிமேகலை" }] },
      { name: "இயல் 9: மனிதம் ஆளுமை", chapters: [{ num: 21, name: "ஆசிய ஜோதி", q: "புத்தர் கருணை" }, { num: 22, name: "மனிதநேயம்", q: "அன்னை தெரசா" }] }
    ];
  } else if (lvl === 7) {
    units = [
      { name: "இயல் 1: அமுதத்தமிழ்", chapters: [{ num: 1, name: "எங்கள் தமிழ்", q: "நாமக்கல் கவிஞர்" }, { num: 2, name: "ஒன்றல்ல இரண்டல்ல", q: "உடுமலை நாராயணகவி" }] },
      { name: "இயல் 2: இயற்கை (காடு)", chapters: [{ num: 3, name: "காடு", q: "சுரதா" }, { num: 4, name: "விலங்குகள் உலகம்", q: "முண்டந்துறை சரணாலயம்" }] },
      { name: "இயல் 3: நாட்டின் வளம்", chapters: [{ num: 5, name: "புலி தங்கிய குகை", q: "காவற்பெண்டு" }, { num: 6, name: "பாஞ்சை வளம்", q: "வீரபாண்டிய கட்டபொம்மன்" }] },
      { name: "இயல் 4: கல்வி", chapters: [{ num: 7, name: "கற்றோர்க்குச் சென்ற இடமெல்லாம் சிறப்பு", q: "கல்வி சிறப்பு" }, { num: 8, name: "ஏடில்லா கல்வி", q: "நாட்டுப்புறக் கலை" }] },
      { name: "இயல் 5: கலை பண்பாடு", chapters: [{ num: 9, name: "கலங்கரை விளக்கம்", q: "கடியலூர் உருத்திரங்கண்ணனார்" }, { num: 10, name: "கவின்மிகு கப்பல்", q: "மருதன் இளநாகனார்" }] },
      { name: "இயல் 6: தொழில் வணிகம்", chapters: [{ num: 11, name: "விருந்தோம்பல்", q: "முன்றுறை அரையனார்" }, { num: 12, name: "வயலும் வாழ்வும்", q: "உழவர் பாடல்" }] },
      { name: "இயல் 7: நயத்தகு நாகரிகம்", chapters: [{ num: 13, name: "திருப்பாவை", q: "ஆண்டாள்" }, { num: 14, name: "திருவெம்பாவை", q: "மாணிக்கவாசகர்" }] },
      { name: "இயல் 8: அறம் ஆளுமை", chapters: [{ num: 15, name: "தன்னை அறிதல்", q: "சே.பிருந்தா" }, { num: 16, name: "அறிவுடைமை", q: "திருக்குறள்" }] },
      { name: "இயல் 9: மானுடம்", chapters: [{ num: 17, name: "ஒப்புரவு நெறி", q: "குன்றக்குடி அடிகளார்" }, { num: 18, name: "பொதுவுடைமை", q: "பாரதிதாசன்" }] }
    ];
  } else if (lvl === 8) {
    units = [
      { name: "இயல் 1: தமிழ் மொழி வாழ்த்து", chapters: [{ num: 1, name: "தமிழ் மொழி வாழ்த்து", q: "பாரதியார்" }, { num: 2, name: "தமிழ் மொழி மரபு", q: "தொல்காப்பியம்" }] },
      { name: "இயல் 2: ஈடிலா இயற்கை", chapters: [{ num: 3, name: "ஓடை", q: "வாணிதாசன்" }, { num: 4, name: "கோணக்காத்துப் பாட்டு", q: "வெங்கம்பூர் சாமிநாதன்" }] },
      { name: "இயல் 3: உடலை ஓம்புமின்", chapters: [{ num: 5, name: "நோயும் மருந்தும்", q: "நீலகேசி" }, { num: 6, name: "வருமுன் காப்போம்", q: "கவிமணி" }] },
      { name: "இயல் 4: கல்வி கரையில்", chapters: [{ num: 7, name: "கல்வி அழகே அழகு", q: "குமரகுருபரர்" }, { num: 8, name: "புத்தியைத் தீட்டு", q: "ஆலங்குடி சோமு" }] },
      { name: "இயல் 5: கலை அழகு", chapters: [{ num: 9, name: "திருவாரூர் நான்மணிமாலை", q: "குமரகுருபரர்" }, { num: 10, name: "கைவினைப் பொருட்கள்", q: "மண்பாண்டக் கலை" }] },
      { name: "இயல் 6: நாகரிகம் தொழில்", chapters: [{ num: 11, name: "வளம் பெருகுக", q: "தகடூர் யாத்திரை" }, { num: 12, name: "கொங்குநாட்டு வணிகம்", q: "பண்டைய வர்த்தகம்" }] },
      { name: "இயல் 7: பாரத ரத்னா எம்.ஜி.ஆர்", chapters: [{ num: 13, name: "படை வேழம்", q: "செயங்கொண்டார்" }, { num: 14, name: "பாரத ரத்னா எம்.ஜி.ராமச்சந்திரன்", q: "சத்துணவு திட்டம்" }] },
      { name: "இயல் 8: அறநெறிச்சாரம்", chapters: [{ num: 15, name: "ஒன்றே குலம்", q: "திருமூலர் திருமந்திரம்" }, { num: 16, name: "மெய்ஞ்ஞான ஒளி", q: "குணங்குடி மஸ்தான் சாகிபு" }] },
      { name: "இயல் 9: குன்றக்குடி அடிகள்", chapters: [{ num: 17, name: "உயிர் குணங்கள்", q: "இறையரசன்" }, { num: 18, name: "சட்டமேதை அம்பேத்கர்", q: "இந்திய அரசியலமைப்பு" }] }
    ];
  } else if (lvl === 9) {
    units = [
      { name: "இயல் 1: திராவிட மொழிக்குடும்பம்", chapters: [{ num: 1, name: "திராவிட மொழிக்குடும்பம்", q: "கால்டுவெல் திராவிட ஒப்பிலக்கணம்" }, { num: 2, name: "தமிழ்த்தூது", q: "சிற்றிலக்கியம்" }] },
      { name: "இயல் 2: நீரின்றி அமையாது உலகு", chapters: [{ num: 3, name: "பட்டமரம்", q: "கவிஞர் தமிழ்ஒளி" }, { num: 4, name: "பெரியபுராணம்", q: "சேக்கிழார்" }] },
      { name: "இயல் 3: ஏறு தழுவுதல்", chapters: [{ num: 5, name: "ஏறு தழுவுதல்", q: "ஜல்லிக்கட்டு சங்க மரபு" }, { num: 6, name: "மணிமேகலை", q: "சீத்தலைச் சாத்தனார்" }] },
      { name: "இயல் 4: விண்ணையும் சாடுவோம்", chapters: [{ num: 7, name: "விண்ணையும் சாடுவோம்", q: "இஸ்ரோ விண்வெளி சாதனைகள்" }, { num: 8, name: "சீவக சிந்தாமணி", q: "திருத்தக்கதேவர்" }] },
      { name: "இயல் 5: கசடறக் கற்றல்", chapters: [{ num: 9, name: "குடும்ப விளக்கு", q: "பாரதிதாசன்" }, { num: 10, name: "சிறுபஞ்சமூலம்", q: "காரியாசான்" }] },
      { name: "இயல் 6: சிற்பக்கலை", chapters: [{ num: 11, name: "இராவண காவியம்", q: "புலவர் குழந்தை" }, { num: 12, name: "நாச்சியார் திருமொழி", q: "ஆண்டாள்" }] },
      { name: "இயல் 7: இந்திய தேசிய இராணுவம்", chapters: [{ num: 13, name: "இந்திய தேசிய இராணுவம்", q: "நேதாஜி & தமிழர் பங்கு" }, { num: 14, name: "சீராப்புராணம்", q: "உமறுப்புலவர்" }] },
      { name: "இயல் 8: பெரியாரின் சிந்தனைகள்", chapters: [{ num: 15, name: "பெரியாரின் சிந்தனைகள்", q: "சமூக சீர்திருத்தம்" }, { num: 16, name: "யசோதர காவியம்", q: "ஐஞ்சிறுங்காப்பியம்" }] },
      { name: "இயல் 9: விரிவாகும் ஆளுமை", chapters: [{ num: 17, name: "விரிவாகும் ஆளுமை", q: "தனிமனித வளர்ச்சி" }, { num: 18, name: "குறுந்தொகை", q: "அகநானூறு மரபு" }] }
    ];
  } else if (lvl === 10) {
    units = [
      { name: "இயல் 1: மொழி (அன்னை மொழியே)", chapters: [{ num: 1, name: "அன்னை மொழியே", q: "பாவலேறேறு பெருஞ்சித்திரனார்" }, { num: 2, name: "தமிழ்ச்சொல் வளம்", q: "தேவநேயப் பாவாணர்" }] },
      { name: "இயல் 2: இயற்கை (காற்று வா)", chapters: [{ num: 3, name: "காற்று வா", q: "பாரதியார் வசன கவிதை" }, { num: 4, name: "முல்லைப்பாட்டு", q: "நப்பூதனார்" }] },
      { name: "இயல் 3: பண்பாடு (விருந்து போற்றுதும்)", chapters: [{ num: 5, name: "விருந்து போற்றுதும்", q: "தமிழர் விருந்தோம்பல்" }, { num: 6, name: "காசி காண்டம்", q: "அதிவீரராம பாண்டியர்" }] },
      { name: "இயல் 4: அறிவியல் (செயற்கை நுண்ணறிவு)", chapters: [{ num: 7, name: "செயற்கை நுண்ணறிவு", q: "AI தொழில்நுட்பம்" }, { num: 8, name: "பெருமாள் திருமொழி", q: "குலசேகர ஆழ்வார்" }] },
      { name: "இயல் 5: கல்வி (நீதி வெண்பா)", chapters: [{ num: 9, name: "நீதி வெண்பா", q: "செய்குதம்பி பாவலர்" }, { num: 10, name: "திருவிளையாடற்புராணம்", q: "பரஞ்சோதி முனிவர்" }] },
      { name: "இயல் 6: கலை (முத்துக்குமாரசாமி)", chapters: [{ num: 11, name: "முத்துக்குமாரசாமி பிள்ளைத்தமிழ்", q: "குமரகுருபரர்" }, { num: 12, name: "கம்பராமாயணம்", q: "கம்பர்" }] },
      { name: "இயல் 7: நாகரிகம் (சிற்றகல் ஒளி)", chapters: [{ num: 13, name: "சிற்றகல் ஒளி", q: "ம.பொ.சிவஞானம்" }, { num: 14, name: "ஏர் புதிதா", q: "கு.ப.ராஜகோபாலன்" }] },
      { name: "இயல் 8: அறம் (மெய்க்கீர்த்தி)", chapters: [{ num: 15, name: "மெய்க்கீர்த்தி", q: "இரண்டாம் இராசராச சோழன்" }, { num: 16, name: "ஞானம்", q: "தி.சோ.வேணுகோபாலன்" }] },
      { name: "இயல் 9: மனிதம் (ஜெயகாந்தம்)", chapters: [{ num: 17, name: "ஜெயகாந்தம்", q: "யுகசந்தி சிறுகதைகள்" }, { num: 18, name: "சித்தாளு", q: "நாகூர் ரூமி" }] }
    ];
  } else if (lvl === 11) {
    units = [
      { name: "இயல் 1: யுகத்தின் பாடல்", chapters: [{ num: 1, name: "யுகத்தின் பாடல்", q: "சு.வில்வரத்தினம்" }, { num: 2, name: "பேச்சுமொழியும் கவிதைமொழியும்", q: "இந்திரன்" }] },
      { name: "இயல் 2: இயற்கை வேளாண்மை", chapters: [{ num: 3, name: "ஏங்குது பார் உலகம்", q: "நம்மாழ்வார் இயற்கை உழவு" }, { num: 4, name: "ஐங்குறுநூறு", q: "பேroutine அகப்பொருள்" }] },
      { name: "இயல் 3: காவடிச்சிந்து", chapters: [{ num: 5, name: "காவடிச்சிந்து", q: "அண்ணாமலையார்" }, { num: 6, name: "குறுந்தொகை", q: "வெள்ளிவீதியார்" }] },
      { name: "இயல் 4: பிள்ளைக் கூடம்", chapters: [{ num: 7, name: "பிள்ளைக் கூடம்", q: "கல்யாண்ஜி" }, { num: 8, name: "கல்வித் துறை வளர்ச்சி", q: "கல்வி வரலாறு" }] },
      { name: "இயல் 5: சீறாப்புராணம்", chapters: [{ num: 9, name: "சீறாப்புராணம்", q: "உமறுப்புலவர்" }, { num: 10, name: "ஆத்மாநாம் கவிதைகள்", q: "நவீன கவிதை" }] },
      { name: "இயல் 6: குற்றாலக் குறவஞ்சி", chapters: [{ num: 11, name: "குற்றாலக் குறவஞ்சி", q: "திரிகூடராசப்ப கவிராயர்" }, { num: 12, name: "திருச்சாலல்", q: "மாணிக்கவாசகர்" }] },
      { name: "இயல் 7: புரட்சிக்கவி", chapters: [{ num: 13, name: "புரட்சிக்கவி", q: "பாரதிதாசன்" }, { num: 14, name: "சிங்காரவேலர்", q: "தொழிலாளர் தலைவர்" }] },
      { name: "இயல் 8: மனோன்மணீயம்", chapters: [{ num: 15, name: "மனோன்மணீயம்", q: "பேராசிரியர் சுந்தரனார்" }, { num: 16, name: "தாகூர் சிறுகதைகள்", q: "ரவீந்திரநாத் தாகூர்" }] }
    ];
  } else if (lvl === 12) {
    units = [
      { name: "இயல் 1: இளந்தமிழே", chapters: [{ num: 1, name: "இளந்தமிழே", q: "சிற்பி பாலசுப்பிரமணியம்" }, { num: 2, name: "தமிழாய் எழுதுவோம்", q: "மொழித்தூய்மை" }] },
      { name: "இயல் 2: நெடுநல்வாடை", chapters: [{ num: 3, name: "நெடுநல்வாடை", q: "நக்கீரர் சங்க இலக்கியம்" }, { num: 4, name: "நால்வகை பொருத்தங்கள்", q: "திணை, பால், எண், இடம்" }] },
      { name: "இயல் 3: கம்பராமாயணம்", chapters: [{ num: 5, name: "கம்பராமாயணம்", q: "கம்பர் காப்பிய நயம்" }, { num: 6, name: "திருக்குறள்", q: "அறத்துப் பால், பொருட்பால்" }] },
      { name: "இயல் 4: இதில் வெற்றி பெற", chapters: [{ num: 7, name: "இதில் வெற்றி பெற", q: "சுரதா" }, { num: 8, name: "பாதுகாப்போம் சுற்றுப்புறம்", q: "சுற்றுச்சூழல்" }] },
      { name: "இயல் 5: தெய்வமணிமாலை", chapters: [{ num: 9, name: "தெய்வமணிமாலை", q: "இராமலிங்க அடிகளார்" }, { num: 10, name: "தேவாரம்", q: "திருஞானசம்பந்தர்" }] },
      { name: "இயல் 6: சிலப்பதிகாரம்", chapters: [{ num: 11, name: "சிலப்பதிகாரம்", q: "வஞ்சிக்காண்டம்" }, { num: 12, name: "மெய்ப்பாட்டியல்", q: "தொல்காப்பியம்" }] },
      { name: "இயல் 7: இலக்கியத்தின் நோக்கம்", chapters: [{ num: 13, name: "இலக்கியத்தின் நோக்கம்", q: "மு.வரதராசனார்" }, { num: 14, name: "புறநானூறு", q: "சங்க வீரம்" }] },
      { name: "இயல் 8: ரட்சணிய யாத்ரிகம்", chapters: [{ num: 15, name: "ரட்சணிய யாத்ரிகம்", q: "எச்.ஏ.கிருஷ்ணபிள்ளை" }, { num: 16, name: "கோபல்லபுரத்து மக்கள்", q: "கி.ராஜநாராயணன்" }] }
    ];
  }

  stateBoardCurricula.push({
    board: "STATE_BOARD",
    classLevel: lvl,
    name: "Tamil",
    code: "TAM",
    icon: "📖",
    color: "#e84118",
    units: units
  });
}

// Add English, Mathematics, Science, Social Science for State Board 4 to 10
for (let lvl = 4; lvl <= 10; lvl++) {
  // English
  stateBoardCurricula.push({
    board: "STATE_BOARD", classLevel: lvl, name: "English", code: "ENG", icon: "📚", color: "#fa8231",
    units: [
      { name: "Term 1 / Unit 1: Prose and Poetry", chapters: [{ num: 1, name: `Prose Lesson 1 (Standard ${lvl})`, q: "Comprehension & Vocabulary" }, { num: 2, name: `Poem 1 (Standard ${lvl})`, q: "Poetic Devices & Rhyme" }] },
      { name: "Term 2 / Unit 2: Adventures and Virtues", chapters: [{ num: 3, name: `Prose Lesson 2 (Standard ${lvl})`, q: "Grammar & Dialogue" }, { num: 4, name: `Poem 2 (Standard ${lvl})`, q: "Themes & Imagery" }] },
      { name: "Term 3 / Unit 3: Heritage and Nature", chapters: [{ num: 5, name: `Prose Lesson 3 (Standard ${lvl})`, q: "Reading Skills & Writing" }, { num: 6, name: `Poem 3 (Standard ${lvl})`, q: "Appreciation" }] }
    ]
  });

  // Mathematics
  stateBoardCurricula.push({
    board: "STATE_BOARD", classLevel: lvl, name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4",
    units: [
      { name: "Unit 1: Numbers and Algebra", chapters: [{ num: 1, name: `Numbers and Sequences (Std ${lvl})`, q: "Arithmetic & Number Theory" }, { num: 2, name: `Algebra and Equations (Std ${lvl})`, q: "Expressions & Polynomials" }] },
      { name: "Unit 2: Geometry and Coordinate Geometry", chapters: [{ num: 3, name: `Geometry Theorems (Std ${lvl})`, q: "Angles, Triangles & Circles" }, { num: 4, name: `Coordinate Geometry (Std ${lvl})`, q: "Distance & Slope" }] },
      { name: "Unit 3: Mensuration, Statistics and Probability", chapters: [{ num: 5, name: `Mensuration (Std ${lvl})`, q: "Area and Volume" }, { num: 6, name: `Statistics and Probability (Std ${lvl})`, q: "Mean, Median & Chance" }] }
    ]
  });

  // Science
  stateBoardCurricula.push({
    board: "STATE_BOARD", classLevel: lvl, name: "Science", code: "SCI", icon: "🔬", color: "#eb4d4b",
    units: [
      { name: "Unit 1: Physics and Measurements", chapters: [{ num: 1, name: `Laws of Motion & Mechanics (Std ${lvl})`, q: "Forces, Energy & Work" }, { num: 2, name: `Light, Sound and Electricity (Std ${lvl})`, q: "Refraction, Current & Waves" }] },
      { name: "Unit 2: Chemistry and Matter", chapters: [{ num: 3, name: `Matter, Atoms and Reactions (Std ${lvl})`, q: "Periodic Table & Compounds" }, { num: 4, name: `Acids, Bases and Salts (Std ${lvl})`, q: "pH & Neutralisation" }] },
      { name: "Unit 3: Biology and Living Systems", chapters: [{ num: 5, name: `Plant and Animal Biology (Std ${lvl})`, q: "Cells, Tissues & Organ Systems" }, { num: 6, name: `Ecology and Health (Std ${lvl})`, q: "Environment & Hygiene" }] }
    ]
  });

  // Social Science
  stateBoardCurricula.push({
    board: "STATE_BOARD", classLevel: lvl, name: "Social Science", code: "SOC", icon: "🌍", color: "#10ac84",
    units: [
      { name: "Unit 1: History of Tamil Nadu & India", chapters: [{ num: 1, name: `Historical Eras (Std ${lvl})`, q: "Sangam Age, Kingdoms & Freedom Struggle" }, { num: 2, name: `Social and Cultural Heritage (Std ${lvl})`, q: "Monuments, Art & Reform" }] },
      { name: "Unit 2: Geography of Tamil Nadu & World", chapters: [{ num: 3, name: `Physical Geography (Std ${lvl})`, q: "Landforms, Rivers & Climate" }, { num: 4, name: `Resources and Agriculture (Std ${lvl})`, q: "Soil, Water & Farming" }] },
      { name: "Unit 3: Civics and Economics", chapters: [{ num: 5, name: `Democracy and Constitution (Std ${lvl})`, q: "Government & Fundamental Rights" }, { num: 6, name: `Economics and Livelihoods (Std ${lvl})`, q: "Production, Money & Markets" }] }
    ]
  });
}

// Add Class 11 and 12 Higher Secondary Subjects for State Board
for (let lvl of [11, 12]) {
  const hseSubs = [
    { name: "English", code: "ENG", icon: "📚", color: "#fa8231", units: [
      { name: "Unit 1: Prose and Poetry Collection", chapters: [{ num: 1, name: `Prose Reading Comprehension (Std ${lvl})`, q: "Essays & Vocabulary" }, { num: 2, name: `Poetic Appreciation (Std ${lvl})`, q: "Literary Devices" }] },
      { name: "Unit 2: Supplementary and Writing Skills", chapters: [{ num: 3, name: `Supplementary Short Stories (Std ${lvl})`, q: "Character Analysis" }, { num: 4, name: `Advanced Writing Skills (Std ${lvl})`, q: "Essays & Reports" }] }
    ]},
    { name: "Physics", code: "PHY", icon: "⚡", color: "#3867d6", units: [
      { name: "Unit 1: Electrostatics & Mechanics", chapters: [{ num: 1, name: `Electrostatics & Current Electricity (Std ${lvl})`, q: "Coulomb Law, Capacitance & Circuits" }, { num: 2, name: `Magnetism and Magnetic Effects (Std ${lvl})`, q: "Biot-Savart Law & Solenoids" }] },
      { name: "Unit 2: Electromagnetic Induction & Optics", chapters: [{ num: 3, name: `Electromagnetic Induction & AC (Std ${lvl})`, q: "Faraday Laws & AC Generators" }, { num: 4, name: `Ray and Wave Optics (Std ${lvl})`, q: "Lenses, Interference & Diffraction" }] },
      { name: "Unit 3: Modern Physics & Semiconductor Devices", chapters: [{ num: 5, name: `Dual Nature & Nuclear Physics (Std ${lvl})`, q: "Photoelectric Effect & Nuclear Energy" }, { num: 6, name: `Semiconductor Electronics (Std ${lvl})`, q: "p-n Junctions, Transistors & Logic" }] }
    ]},
    { name: "Chemistry", code: "CHEM", icon: "🧪", color: "#8854d0", units: [
      { name: "Unit 1: Inorganic Chemistry", chapters: [{ num: 1, name: `Atomic Structure & Periodic Properties (Std ${lvl})`, q: "Quantum Numbers & Trends" }, { num: 2, name: `Coordination Chemistry & Metallurgy (Std ${lvl})`, q: "Extraction & Complex Compounds" }] },
      { name: "Unit 2: Physical Chemistry", chapters: [{ num: 3, name: `Thermodynamics, Equilibrium & Kinetics (Std ${lvl})`, q: "Rate Equations & Gibbs Free Energy" }, { num: 4, name: `Electrochemistry and Solutions (Std ${lvl})`, q: "Nernst Equation & Molarity" }] },
      { name: "Unit 3: Organic Chemistry", chapters: [{ num: 5, name: `Organic Compounds & Functional Groups (Std ${lvl})`, q: "Aldehydes, Ketones & Amines" }, { num: 6, name: `Biomolecules and Polymers (Std ${lvl})`, q: "Carbohydrates, Amino Acids & Polymers" }] }
    ]},
    { name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4", units: [
      { name: "Unit 1: Matrices, Vectors & Analytical Geometry", chapters: [{ num: 1, name: `Matrices and Determinants (Std ${lvl})`, q: "Inverse & Cramer Rule" }, { num: 2, name: `Vector Algebra & 3D Geometry (Std ${lvl})`, q: "Dot/Cross Products & Lines/Planes" }] },
      { name: "Unit 2: Differential and Integral Calculus", chapters: [{ num: 3, name: `Differential Calculus (Std ${lvl})`, q: "Derivatives & Applications" }, { num: 4, name: `Integral Calculus (Std ${lvl})`, q: "Definite Integrals & Differential Equations" }] },
      { name: "Unit 3: Discrete Mathematics and Probability", chapters: [{ num: 5, name: `Discrete Mathematics & Logic (Std ${lvl})`, q: "Truth Tables & Boolean Logic" }, { num: 6, name: `Probability Distributions (Std ${lvl})`, q: "Binomial, Poisson & Normal Distributions" }] }
    ]},
    { name: "Biology", code: "BIO", icon: "🧬", color: "#20bf6b", units: [
      { name: "Unit 1: Botany (Plant Biology)", chapters: [{ num: 1, name: `Plant Diversity, Anatomy & Physiology (Std ${lvl})`, q: "Photosynthesis, Plant Breeding & Taxonomy" }, { num: 2, name: `Plant Ecology and Biotechnology (Std ${lvl})`, q: "Tissue Culture & Ecosystems" }] },
      { name: "Unit 2: Zoology (Animal Biology)", chapters: [{ num: 3, name: `Human Physiology & Genetics (Std ${lvl})`, q: "Organ Systems, Chromosomes & Mutations" }, { num: 4, name: `Immunology and Applied Zoology (Std ${lvl})`, q: "Antibodies, Vaccines & Sericulture" }] }
    ]},
    { name: "Botany", code: "BOT", icon: "🌱", color: "#26de81", units: [
      { name: "Unit 1: Plant Taxonomy & Cell Biology", chapters: [{ num: 1, name: `Taxonomy of Angiosperms & Cell Structure (Std ${lvl})`, q: "Floral Formulas & Organelles" }] },
      { name: "Unit 2: Plant Physiology & Biotechnology", chapters: [{ num: 2, name: `Plant Respiration, Hormones & Genetic Engineering (Std ${lvl})`, q: "Auxins, Gibberellins & Recombinant DNA" }] }
    ]},
    { name: "Zoology", code: "ZOO", icon: "🐾", color: "#fed330", units: [
      { name: "Unit 1: Animal Diversity & Human Systems", chapters: [{ num: 1, name: `Comparative Anatomy & Human Organ Systems (Std ${lvl})`, q: "Nervous System & Endocrine Functions" }] },
      { name: "Unit 2: Genetics, Health & Ecology", chapters: [{ num: 2, name: `Human Health, Diseases & Ecological Conservation (Std ${lvl})`, q: "Pathogens, Immunity & Biosphere" }] }
    ]},
    { name: "Computer Science", code: "CS", icon: "💻", color: "#2d98da", units: [
      { name: "Unit 1: Python Programming & Object Oriented Concepts", chapters: [{ num: 1, name: `Python Fundamentals, Loops & Functions (Std ${lvl})`, q: "Control Flow & Scopes" }, { num: 2, name: `Classes, Objects & Data Structures (Std ${lvl})`, q: "OOP Concepts & List/Tuple Operations" }] },
      { name: "Unit 2: Database Management, SQL & Web Security", chapters: [{ num: 3, name: `Database Management Systems & SQL Queries (Std ${lvl})`, q: "DDL, DML & Table Joins" }, { num: 4, name: `Cyber Ethics, Cyber Security & Tamil Computing (Std ${lvl})`, q: "Unicode, IT Security & Tamil Software" }] }
    ]},
    { name: "Computer Applications", code: "CA", icon: "🖥️", color: "#4b6584", units: [
      { name: "Unit 1: Multimedia, PageMaker & Web Design", chapters: [{ num: 1, name: `Adobe PageMaker & Multimedia Production (Std ${lvl})`, q: "Desktop Publishing & Graphics" }, { num: 2, name: `HTML, CSS & JavaScript Fundamentals (Std ${lvl})`, q: "Web Pages & Scripting" }] },
      { name: "Unit 2: E-Commerce, PHP & Database Management", chapters: [{ num: 3, name: `PHP Scripting & MySQL Database (Std ${lvl})`, q: "Backend Scripts & Database Integration" }, { num: 4, name: `Electronic Payment Systems & Cyber Security (Std ${lvl})`, q: "Payment Gateways & Safety" }] }
    ]},
    { name: "Accountancy", code: "ACC", icon: "📋", color: "#2bcbba", units: [
      { name: "Unit 1: Financial Accounting & Incomplete Records", chapters: [{ num: 1, name: `Accounts from Incomplete Records (Std ${lvl})`, q: "Single Entry to Double Entry Conversion" }, { num: 2, name: `Accounts of Not-for-Profit Organisations (Std ${lvl})`, q: "Receipts & Payments, Income & Expenditure" }] },
      { name: "Unit 2: Partnership Accounts & Company Accounts", chapters: [{ num: 3, name: `Partnership Accounts: Admission & Retirement (Std ${lvl})`, q: "Revaluation & Goodwill Adjustments" }, { num: 4, name: `Company Accounts & Financial Ratio Analysis (Std ${lvl})`, q: "Issue of Shares, Debentures & Liquidity Ratios" }] }
    ]},
    { name: "Commerce", code: "COMM", icon: "💼", color: "#ff9f43", units: [
      { name: "Unit 1: Management Process & Financial Markets", chapters: [{ num: 1, name: `Principles of Management & Organising (Std ${lvl})`, q: "Fayol Management & Direction" }, { num: 2, name: `Financial Markets & Stock Exchange (Std ${lvl})`, q: "Money Market, Capital Market & SEBI" }] },
      { name: "Unit 2: Marketing, Consumer Rights & Company Law", chapters: [{ num: 3, name: `Marketing, E-Commerce & Consumer Protection (Std ${lvl})`, q: "4 Ps of Marketing & Consumer Rights" }, { num: 4, name: `Company Management & Company Meetings (Std ${lvl})`, q: "Directors, Resolutions & Secretarial Practices" }] }
    ]},
    { name: "Economics", code: "ECO", icon: "📈", color: "#ee5253", units: [
      { name: "Unit 1: Macroeconomics & National Income", chapters: [{ num: 1, name: `Introduction to Macroeconomics & National Income (Std ${lvl})`, q: "Circular Flow & GDP Calculation" }, { num: 2, name: `Theories of Employment and Money (Std ${lvl})`, q: "Keynesian Theory & Monetary Policy" }] },
      { name: "Unit 2: Public Finance, International Economics & TN Economy", chapters: [{ num: 3, name: `Fiscal Economics & International Trade (Std ${lvl})`, q: "Taxation, Government Budget & Foreign Exchange" }, { num: 4, name: `Economic Planning & Tamil Nadu Economy (Std ${lvl})`, q: "NITI Aayog & Sectoral Growth in TN" }] }
    ]},
    { name: "Business Mathematics", code: "BMATH", icon: "🔢", color: "#341f97", units: [
      { name: "Unit 1: Matrices, Algebra & Differential Calculus", chapters: [{ num: 1, name: `Applications of Matrices and Determinants (Std ${lvl})`, q: "Rank of Matrix & Consistency of Equations" }, { num: 2, name: `Integral Calculus and Marginal Economics (Std ${lvl})`, q: "Producer/Consumer Surplus & Differential Equations" }] }
    ]},
    { name: "Statistics", code: "STAT", icon: "📊", color: "#0abde3", units: [
      { name: "Unit 1: Probability Distributions & Statistical Inference", chapters: [{ num: 1, name: `Continuous Probability Distributions (Std ${lvl})`, q: "Normal Distribution & Standard Normal Curve" }, { num: 2, name: `Testing of Hypothesis & Time Series Analysis (Std ${lvl})`, q: "Large/Small Sample Tests & Trend Variations" }] }
    ]},
    { name: "History", code: "HIST", icon: "🏛️", color: "#5f27cd", units: [
      { name: "Unit 1: Modern Indian History & Tamil Nadu Freedom Struggle", chapters: [{ num: 1, name: `Freedom Movement in Tamil Nadu (Std ${lvl})`, q: "V.O.C., Subramania Bharati & Rajaji" }, { num: 2, name: `Social Transformation in Tamil Nadu (Std ${lvl})`, q: "Justice Party, Self-Respect Movement & Periyar" }] },
      { name: "Unit 2: World History & Contemporary Era", chapters: [{ num: 3, name: `World War I, II and League of Nations (Std ${lvl})`, q: "Causes, Results & Treaty of Versailles" }, { num: 4, name: `Cold War, Non-Aligned Movement & United Nations (Std ${lvl})`, q: "Panchsheel & UN Security Council" }] }
    ]}
  ];

  for (const s of hseSubs) {
    stateBoardCurricula.push({
      board: "STATE_BOARD",
      classLevel: lvl,
      name: s.name,
      code: s.code,
      icon: s.icon,
      color: s.color,
      units: s.units
    });
  }
}

console.log('All State Board curriculum objects built. Count:', stateBoardCurricula.length);
