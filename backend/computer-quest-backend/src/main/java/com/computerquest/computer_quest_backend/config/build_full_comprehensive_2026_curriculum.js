const fs = require('fs');
const path = require('path');

// Complete Real 2026-27 Textbook Curriculum for RPSIT School
// Covers EVERY Class (4 to 12) for BOTH CBSE and Tamil Nadu State Board
// ALL Units, ALL Chapters, 4 Missions/Chapter, 5 Questions/Mission

const stateBoardCurriculum = [
  // STATE BOARD CLASS 4
  {
    board: "STATE_BOARD", classLevel: 4,
    subjects: [
      { name: "Tamil", code: "TAM", icon: "📖", color: "#e84118", units: [
        { name: "பருவம் 1: அன்னைத் தமிழும் பண்பாடும்", chapters: [
          { num: 1, name: "அன்னைத் தமிழே (பாடல்)", q: "தாய்மொழிப் பற்று, செய்யுள் நயம் & பொருள்" },
          { num: 2, name: "பனைமரச் சிறப்பு", q: "தமிழ்நாட்டின் மாநில மரம், பயன்கள் & நுங்கு" },
          { num: 3, name: "ஏழு இறக்கைக் குருவியும் தெனாலிராமனும்", q: "தெனாலிராமனின் சாதுரியம் & அரசவை கதைகள்" }
        ]},
        { name: "பருவம் 2: நன்னெறியும் அறிவும்", chapters: [
          { num: 4, name: "நன்னெறி (சிவப்பிரகாச சுவாமிகள்)", q: "அறநெறி பாடல்கள், நன்மொழி & இன்சொல்" },
          { num: 5, name: "பண்படுத்தும் பழமொழிகள்", q: "பழமொழிகளின் உண்மையான விளக்கம் & பொருள்" },
          { num: 6, name: "வெற்றி வேற்கை (அதிவீரராம பாண்டியர்)", q: "கல்வியின் பெருமை, உதவியின் பெருமை" }
        ]},
        { name: "பருவம் 3: ஒழுக்கமும் அறமும்", chapters: [
          { num: 7, name: "விடியும் வேளை", q: "கிராமத்து இயற்கை அழகு, காலை விடியல் நிகழ்வுகள்" },
          { num: 8, name: "நீதிநெறி விளக்கம் (குமரகுருபரர்)", q: "கல்வி கற்றோர்க்கு அழகு தருவது & செய்யுள்" },
          { num: 9, name: "நல்வழி (ஔவையார்)", q: "சாதி இரண்டொழிய வேறில்லை & அறவாழ்க்கை" }
        ]}
      ]},
      { name: "English", code: "ENG", icon: "📚", color: "#fa8231", units: [
        { name: "Term 1: A World with Robots", chapters: [
          { num: 1, name: "The Trick Robot", q: "Robotics, Inventions & Responsibility" },
          { num: 2, name: "My Robot (Poem)", q: "Mechanical Helpers & Rhyming Words" }
        ]},
        { name: "Term 2: Saving and Seasons", chapters: [
          { num: 3, name: "Anbu and the Fish", q: "Compassion for Creatures & Fishing Ethics" },
          { num: 4, name: "Beauty of Nature (Poem)", q: "Flora, Birds & Environmental Wonder" }
        ]},
        { name: "Term 3: Seven Hills & Stories", chapters: [
          { num: 5, name: "The Wooden Toy", q: "Traditional Crafts & Family Values" },
          { num: 6, name: "Rain, Rain, Everywhere (Poem)", q: "Monsoon Showers & Agriculture" }
        ]}
      ]},
      { name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4", units: [
        { name: "Unit 1: Geometry & 2D/3D Shapes", chapters: [
          { num: 1, name: "Properties of 2D and 3D Shapes", q: "Edges, Vertices, Faces, Cube, Cone, Cylinder" }
        ]},
        { name: "Unit 2: Numbers & Operations", chapters: [
          { num: 2, name: "Numbers up to 10,000", q: "Place Value, Comparison, Addition & Subtraction" },
          { num: 3, name: "Multiplication and Division", q: "Word Problems, Multiplication Tables & Division" }
        ]},
        { name: "Unit 3: Patterns & Measurements", chapters: [
          { num: 4, name: "Patterns and Symmetry", q: "Growing Patterns & Line Symmetry" },
          { num: 5, name: "Length, Weight & Capacity", q: "Centimetres, Metres, Grams, Kilograms & Litres" }
        ]},
        { name: "Unit 4: Time, Money & Information Processing", chapters: [
          { num: 6, name: "Time and Calendar", q: "Reading Clocks, Days, Months & Leap Years" },
          { num: 7, name: "Money & Fractional Parts", q: "Bills, Rupees, Paise, Halves & Quarters" },
          { num: 8, name: "Information Processing (Data)", q: "Tally Marks, Bar Charts & Data Interpretation" }
        ]}
      ]},
      { name: "Science", code: "SCI", icon: "🔬", color: "#eb4d4b", units: [
        { name: "Unit 1: My Body & Internal Organs", chapters: [
          { num: 1, name: "Internal Organs", q: "Brain, Heart, Lungs, Stomach, Kidneys & Bones" }
        ]},
        { name: "Unit 2: Matter and Materials", chapters: [
          { num: 2, name: "States of Matter", q: "Solids, Liquids, Gases, Melting & Freezing" }
        ]},
        { name: "Unit 3: Work and Energy", chapters: [
          { num: 3, name: "Work and Energy", q: "Push, Pull, Simple Machines, Solar & Wind Energy" }
        ]},
        { name: "Unit 4: Plants & Green World", chapters: [
          { num: 4, name: "Plants Life Cycle", q: "Photosynthesis, Root/Shoot Systems & Flower Parts" }
        ]},
        { name: "Unit 5: Animals & Water Conservation", chapters: [
          { num: 5, name: "Animals Habitats", q: "Terrestrial, Aquatic, Herbivores & Food Chain" },
          { num: 6, name: "Water Cycle and Conservation", q: "Evaporation, Condensation, Rainwater Harvesting" }
        ]}
      ]},
      { name: "Social Science", code: "SOC", icon: "🌍", color: "#10ac84", units: [
        { name: "Unit 1: Kingdoms of Rivers", chapters: [
          { num: 1, name: "Sangam Tamil Dynasties", q: "Cheras, Cholas, Pandyas, Pallavas & River Banks" }
        ]},
        { name: "Unit 2: Physical Features of Tamil Nadu", chapters: [
          { num: 2, name: "Landforms and Rivers of Tamil Nadu", q: "Mountains (Western Ghats), Cauvery, Vaigai & Plateaus" }
        ]},
        { name: "Unit 3: Municipalities and Corporations", chapters: [
          { num: 3, name: "Local Self Government", q: "Mayor, Municipal Commissioner & Civic Duties" }
        ]},
        { name: "Unit 4: Philanthropists & Transport", chapters: [
          { num: 4, name: "Seven Great Philanthropists (Kadai Ezhu Vallalgal)", q: "Pari, Pegan, Kari, Ay, Adhiyaman, Nalli, Ori" },
          { num: 5, name: "Rights and Duties of Children", q: "Right to Education, Health, Child Protection & Traffic Safety" }
        ]}
      ]}
    ]
  },

  // STATE BOARD CLASS 5
  {
    board: "STATE_BOARD", classLevel: 5,
    subjects: [
      { name: "Tamil", code: "TAM", icon: "📖", color: "#e84118", units: [
        { name: "பருவம் 1: தமிழின் இனிமையும் இயற்கையும்", chapters: [
          { num: 1, name: "தமிழின் இனிமை (பாரதிதாசன்)", q: "தமிழுக்கும் அமுதென்று பேர், பாடல் வரிகள் & பொருள்" },
          { num: 2, name: "கவிதைப்பட்டிமன்றம்", q: "அறிவா? பண்பா? பட்டிமன்ற விவாத கருத்துக்கள்" },
          { num: 3, name: "என்ன சத்தம்? (மரபுச் சொற்கள்)", q: "விலங்குகள், பறவைகளின் ஒலி மரபு & வினை மரபு" }
        ]},
        { name: "பருவம் 2: கல்விச் செல்வமும் நன்நெறியும்", chapters: [
          { num: 4, name: "விடியும் வேளை & கடல்", q: "கடலின் அலைகள், இயற்கை வளங்கள் & செய்யுள் நயம்" },
          { num: 5, name: "திருக்குறள் கதைகள்", q: "அன்புடைமை, விருந்தோம்பல், இனியவை கூறல்" },
          { num: 6, name: "கல்விச் செல்வமும் பொருட்செல்வமும்", q: "கல்வியின் நிலையான மதிப்பு & உலக அறிவு" }
        ]},
        { name: "பருவம் 3: தலைமைப் பண்பும் அறமும்", chapters: [
          { num: 7, name: "தலைமைப் பண்பு", q: "செம்பியன் கதைகள், நல்லாட்சி & தியாகம்" },
          { num: 8, name: "அறநெறிச்சாரம் (முனைப்பாடியார்)", q: "மனத்தூய்மை, நற்சிந்தனை & அறவழிகள்" },
          { num: 9, name: "நீதிநெறி நன்மொழிகள்", q: "பெரியோரை மதித்தல் & நற்பண்புகள்" }
        ]}
      ]},
      { name: "English", code: "ENG", icon: "📚", color: "#fa8231", units: [
        { name: "Term 1: Exploration & Gratitude", chapters: [
          { num: 1, name: "Explore Space", q: "Space Suits, Planets & Martian Colonisation" },
          { num: 2, name: "Beyond the Universe (Poem)", q: "Galaxies, Constellations & Cosmic Journey" }
        ]},
        { name: "Term 2: Hospitality & Bravery", chapters: [
          { num: 3, name: "The Gift", q: "Helping the Needy, Hospitality & Virtues" },
          { num: 4, name: "Mother Nature (Poem)", q: "Rivers, Forests & Global Conservation" }
        ]},
        { name: "Term 3: Patriotism & Duty", chapters: [
          { num: 5, name: "The Guard", q: "Indian Armed Forces, Soldiers & Bravery" },
          { num: 6, name: "The Patriot (Poem)", q: "Love for Motherland & Civic Duties" }
        ]}
      ]},
      { name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4", units: [
        { name: "Unit 1: Geometry & Angles", chapters: [
          { num: 1, name: "Lines, Rays and Angles", q: "Right Angle (90°), Acute, Obtuse & Protractor" }
        ]},
        { name: "Unit 2: Numbers & Operations", chapters: [
          { num: 2, name: "Numbers up to Lakhs", q: "Place Value System, Indian System, Roman Numerals" },
          { num: 3, name: "Four Basic Operations & Multiples", q: "Multiples, Factors, Prime Numbers, LCM & HCF" }
        ]},
        { name: "Unit 3: Fractions, Decimals & Measurement", chapters: [
          { num: 4, name: "Fractions and Decimals", q: "Equivalent Fractions, Decimal Conversions" },
          { num: 5, name: "Perimeter and Area", q: "Square (4a, a^2) & Rectangle (2(l+b), l*b)" },
          { num: 6, name: "Time, Weight and Capacity", q: "24-Hour Clock, Kilograms, Tonnes & Millilitres" }
        ]},
        { name: "Unit 4: Data Handling & Information Processing", chapters: [
          { num: 7, name: "Information Processing & Pie Charts", q: "Systematic Listing, Flowcharts & Pie Diagrams" }
        ]}
      ]},
      { name: "Science", code: "SCI", icon: "🔬", color: "#eb4d4b", units: [
        { name: "Unit 1: Organ Systems", chapters: [
          { num: 1, name: "Digestive and Respiratory Systems", q: "Alimentary Canal, Trachea, Lungs & Circulation" }
        ]},
        { name: "Unit 2: Matter and Materials", chapters: [
          { num: 2, name: "Types of Materials & Recycling", q: "Biodegradable, Non-biodegradable, 3R Principle" }
        ]},
        { name: "Unit 3: Energy & Daily Life Chemistry", chapters: [
          { num: 3, name: "Energy Forms and Conservation", q: "Mechanical, Electrical, Light, Heat & Law of Conservation" },
          { num: 4, name: "Science in Everyday Life", q: "Fermentation, Milk to Curd, Boiling & Medicine" }
        ]},
        { name: "Unit 5: Space, Safety & Environment", chapters: [
          { num: 5, name: "Safety and First Aid", q: "Burns, Cuts, Fire Safety & Traffic Rules" },
          { num: 6, name: "Environment & Ecosystem", q: "Producers, Consumers, Food Web & Forest Protection" }
        ]}
      ]},
      { name: "Social Science", code: "SOC", icon: "🌍", color: "#10ac84", units: [
        { name: "Unit 1: Our Earth & Continents", chapters: [
          { num: 1, name: "Globe and Maps", q: "Latitudes, Longitudes, Continents & Oceans" }
        ]},
        { name: "Unit 2: Towards History (Stone Age)", chapters: [
          { num: 2, name: "Palaeolithic, Mesolithic & Neolithic Ages", q: "Flint Tools, Cave Paintings & Discovery of Fire" }
        ]},
        { name: "Unit 3: Forts and Monuments of Tamil Nadu", chapters: [
          { num: 3, name: "Historic Forts of Tamil Nadu", q: "Gingee Fort, Vellore Fort, Thanjavur Brihadisvara Temple" }
        ]},
        { name: "Unit 4: Good Citizen & Agriculture", chapters: [
          { num: 4, name: "Good Citizen and Moral Values", q: "Civic Sense, Punctuality, Honesty & Fundamental Duties" },
          { num: 5, name: "Agriculture and Irrigation in Tamil Nadu", q: "Kallarani Dam, River Irrigation & Organic Farming" }
        ]}
      ]}
    ]
  },

  // STATE BOARD CLASS 6
  {
    board: "STATE_BOARD", classLevel: 6,
    subjects: [
      { name: "Tamil", code: "TAM", icon: "📖", color: "#e84118", units: [
        { name: "இயல் 1: மொழி (இன்பத்தமிழ்)", chapters: [
          { num: 1, name: "இன்பத்தமிழ் (பாரதிதாசன்)", q: "தமிழுக்கும் அமுதென்று பேர், தமிழ் எங்கள் உயர்வுக்கு வான்" },
          { num: 2, name: "தமிழ்க்கும்மி (பெருஞ்சித்திரனார்)", q: "கொட்டுங்கடி கும்மி கொட்டுங்கடி & தமிழ் பெருமை" },
          { num: 3, name: "வளர்தமிழ் (உரைநடை)", q: "மூத்த மொழி, எளிய மொழி, சீரிளமைத் தமிழ்" },
          { num: 4, name: "கனவு பலித்தது & தமிழ் எழுத்துகளின் வகை தொகை", q: "அறிவியல் கடிதம், முதலெழுத்து & சார்பெழுத்து" }
        ]},
        { name: "இயல் 2: இயற்கை (சிலப்பதிகாரம்)", chapters: [
          { num: 5, name: "சிலப்பதிகாரம் (திங்களைப் போற்றுதும்)", q: "இளங்கோவடிகள், ஞாயிறு, மாமழை போற்றுதும்" },
          { num: 6, name: "காணி நிலம் (பாரதியார்)", q: "காணி நிலம் வேண்டும் பராசக்தி & இயற்கை ஆசை" },
          { num: 7, name: "சிறகின் ஓசை (பறவைகள் வலசை போதல்)", q: "சலீம் அலி, வலசை போதல் காரணங்கள் & சிட்டுக்குருவி" },
          { num: 8, name: "கிழவனும் கடலும் & முதலெழுத்தும் சார்பெழுத்தும்", q: "நோபல் பரிசு புதினம், சாண்டியாகோ & இலக்கணம்" }
        ]},
        { name: "இயல் 3: அறிவியல் தொழில்நுட்பம்", chapters: [
          { num: 9, name: "அறிவியல் ஆத்திசூடி (நெல்லை சு.முத்து)", q: "அறிவியல் சிந்தனை கொள் & புதிய ஆத்திசூடி" },
          { num: 10, name: "அறிவியலால் ஆள்வோம் & கனியனின் நண்பன் (ரோபோ)", q: "செயற்கை நுண்ணறிவு, ரோபோக்கள் & விண்வெளி" },
          { num: 11, name: "ஒளி பிறந்தது & மொழிமுதல் இறுதி எழுத்துகள்", q: "அப்துல் கலாம் நேர்காணல் & இலக்கண விதிகள்" }
        ]},
        { name: "இயல் 4: கல்வி (மூதுரை)", chapters: [
          { num: 12, name: "மூதுரை (ஔவையார்)", q: "மன்னனும் மாசறக் கற்றோனும் & கல்வி சிறப்பு" },
          { num: 13, name: "துன்பம் வெல்லும் கல்வி (பட்டுக்கோட்டை கல்யாணசுந்தரம்)", q: "உழைப்பின் மேன்மை & மக்கள் கவிஞர் பாடல்" },
          { num: 14, name: "கல்விக் கண் திறந்த காமராசர் & நூலகம் நோக்கி", q: "இலவசக் கல்வி, மதிய உணவு & அண்ணா நூற்றாண்டு நூலகம்" },
          { num: 15, name: "இனவெழுத்துகள் (இலக்கணம்)", q: "வல்லினம், மெல்லினம், இடையினம் நட்பு எழுத்துகள்" }
        ]},
        { name: "இயல் 5: நாகரிகம் பண்பாடு (ஆசாரக்கோவை)", chapters: [
          { num: 16, name: "ஆசாரக்கோவை & கண்மணியே கண்ணுறங்கு", q: "பெருவாயின் முள்ளியார், நல்லொழுக்கம் & தாலாட்டு" },
          { num: 17, name: "தமிழர் பெருவிழா (பொங்கல்)", q: "போகி, உழவர் திருநாள், மாட்டுப் பொங்கல் & திருவள்ளுவர் நாள்" },
          { num: 18, name: "மயங்கொலிகள் (இலக்கணம்)", q: "ண-ன-ந, ர-ற, ல-ழ-ள உச்சரிப்பு வேறுபாடுகள்" }
        ]},
        { name: "இயல் 6: தொழில் வணிகம் (நானிலம் படைத்தவன்)", chapters: [
          { num: 19, name: "நானிலம் படைத்தவன் (முடியரசன்)", q: "குறிஞ்சி, முல்லை, மருதம், நெய்தல் & தமிழன் பெருமை" },
          { num: 20, name: "கடலோடு விளையாடு & வளரும் வணிகம்", q: "மீனவர் நாட்டுப்புறப் பாடல், பண்டமாற்று முறை & ஏற்றுமதி" },
          { num: 21, name: "சுட்டு எழுத்துகளும் வினா எழுத்துகளும்", q: "அ, இ, உ சுட்டெழுத்துகள் & எ, யா, ஆ, ஓ வினாக்கள்" }
        ]},
        { name: "இயல் 7: நாடு சமூகம் அரசு (பாரதம் அன்றைய நாற்றங்கால்)", chapters: [
          { num: 22, name: "பாரதம் அன்றைய நாற்றங்கால் (தாராபாரதி)", q: "கவிஞாயிறு, இந்திய ஒருமைப்பாடு & நதிநீர் இணைப்பு" },
          { num: 23, name: "தமிழ்நாட்டில் காந்தி & வேலுநாச்சியார்", q: "எளிமையின் வடிவம் காந்தி & வீரத்தமிழச்சி வேலுநாச்சியார்" },
          { num: 24, name: "நால்வகைச் சொற்கள் (இலக்கணம்)", q: "பெயர்ச்சொல், வினைச்சொல், இடைச்சொல், உரிச்சொல்" }
        ]},
        { name: "இயல் 8: அறம் தத்துவம் மனிதநேயம் (பராபரக்கண்ணி)", chapters: [
          { num: 25, name: "பராபரக்கண்ணி (தாயுமானவர்)", q: "அன்பர் பணி செய்ய எனை ஆளாக்கி விட்டுவிட்டால்" },
          { num: 26, name: "நீங்கள் நல்லவர் (கலீல் ஜிப்ரான்) & பசிப்பிணி போக்கிய பாவை", q: "மணிமேகலை, ஆபுத்திரன் அமுதசுரபி & அன்னதானம்" },
          { num: 27, name: "பெயர்ச்சொல் வகைகள்", q: "பொருட்பெயர், இடப்பெயர், காலப்பெயர், சினைப்பெயர், தொழிற்பெயர்" }
        ]},
        { name: "இயல் 9: மனிதம் ஆளுமை (ஆசிய ஜோதி)", chapters: [
          { num: 28, name: "ஆசிய ஜோதி (கவிமணி தேசிக விநாயகம் பிள்ளை)", q: "புத்தரின் கருணை, ஆட்டுக்குட்டிக்கு உயிர் காத்தல்" },
          { num: 29, name: "மனிதநேயம் (அன்னை தெரசா, கைலாஷ் சத்யார்த்தி)", q: "அமைதிக்கான நோபல் பரிசு, குழந்தைகளை பாதுகாப்போம்" },
          { num: 30, name: "அணி இலக்கணம்", q: "இயல்பு நவிற்சி அணி & உயர்வு நவிற்சி அணி" }
        ]}
      ]},
      { name: "English", code: "ENG", icon: "📚", color: "#fa8231", units: [
        { name: "Unit 1: Sea Turtles & Crocodile", chapters: [
          { num: 1, name: "Sea Turtles", q: "Olive Ridley Turtles, Nesting & Coastal Conservation" },
          { num: 2, name: "The Crocodile (Poem - Lewis Carroll)", q: "Nile Crocodile, Grin & Little Fishes" }
        ]},
        { name: "Unit 2: When the Trees Walked & Trees", chapters: [
          { num: 3, name: "When the Trees Walked (Ruskin Bond)", q: "Grandfather's Forest Love & Dehradun Valley" },
          { num: 4, name: "Trees (Poem - Sara Coleridge)", q: "Oak, Willow, Birch & Environmental Sanctuary" }
        ]},
        { name: "Unit 3: A Visitor from Distant Lands & Sports Stars", chapters: [
          { num: 5, name: "A Visitor from Distant Lands (Chilli Tale)", q: "Spices History, Vasco da Gama & Columbus" },
          { num: 6, name: "Sports Stars (Mithali Raj, P.V. Sindhu)", q: "Women Sports Icons, Hard Work & Olympic Glory" }
        ]},
        { name: "Unit 4: Trip to Ooty & Autumn", chapters: [
          { num: 7, name: "Trip to Ooty (Nilgiri Mountain Railway)", q: "Toy Train, Western Ghats & Heritage Tourism" },
          { num: 8, name: "Autumn (Poem)", q: "Golden Leaves, Harvest & Seasonal Shifts" }
        ]}
      ]},
      { name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4", units: [
        { name: "Unit 1: Numbers & Large Values", chapters: [
          { num: 1, name: "Numbers and Operations", q: "Successor, Predecessor, BIDMAS Rule & Estimation" },
          { num: 2, name: "Introduction to Algebra", q: "Variables, Algebraic Statements & Evaluating Equations" },
          { num: 3, name: "Ratio and Proportion", q: "Comparison of Ratios, Unitary Method & Applications" }
        ]},
        { name: "Unit 2: Geometry & Measurements", chapters: [
          { num: 4, name: "Geometry (Lines and Angles)", q: "Parallel, Intersecting, Perpendicular Lines & Transversals" },
          { num: 5, name: "Measurements & Conversions", q: "Metric Measurements, Elapsed Time & Speed" },
          { num: 6, name: "Bill, Profit and Loss", q: "Cost Price, Selling Price, Profit/Loss Percentage & Cash Bills" }
        ]},
        { name: "Unit 3: Fractions, Integers & Perimeter/Area", chapters: [
          { num: 7, name: "Fractions and Decimals", q: "Types of Fractions, Simplification & Decimal Addition" },
          { num: 8, name: "Integers (Negative Numbers)", q: "Number Line Representation & Integer Addition/Subtraction" },
          { num: 9, name: "Perimeter and Area", q: "Perimeter and Area of Combined 2D Shapes & Grid Area" }
        ]},
        { name: "Unit 4: Information Processing", chapters: [
          { num: 10, name: "Information Processing", q: "Tree Diagrams, Magic Triangles & Systematic Problem Solving" }
        ]}
      ]},
      { name: "Science", code: "SCI", icon: "🔬", color: "#eb4d4b", units: [
        { name: "Unit 1: Measurements & Motion", chapters: [
          { num: 1, name: "Measurements", q: "SI Units, Vernier Calliper, Volume of Irregular Solids" },
          { num: 2, name: "Force and Motion", q: "Push/Pull, Speed = Distance/Time, Periodic & Circular Motion" }
        ]},
        { name: "Unit 2: Matter Around Us & Living World", chapters: [
          { num: 3, name: "Matter Around Us", q: "Atoms, Molecules, Elements, Compounds & Chemical Symbols" },
          { num: 4, name: "The Living World of Plants", q: "Root System, Shoot System, Leaf Photosynthesis & Habitats" },
          { num: 5, name: "Living World of Animals", q: "Unicellular (Amoeba) vs Multicellular Adaptations" }
        ]},
        { name: "Unit 3: Health, Electricity & Chemistry", chapters: [
          { num: 6, name: "Health and Hygiene", q: "Nutrients, Balanced Diet, Personal Hygiene & Infectious Diseases" },
          { num: 7, name: "Computer - An Introduction", q: "Charles Babbage, Hardware, Software, Input/Output Units" },
          { num: 8, name: "Heat and Temperature", q: "Celsius, Fahrenheit, Kelvin Scales & Thermometers" },
          { num: 9, name: "Electricity", q: "Electric Circuit, Cell, Battery, Series & Parallel Connection" },
          { num: 10, name: "Changes Around Us", q: "Reversible, Irreversible, Slow, Fast, Physical & Chemical Changes" }
        ]},
        { name: "Unit 4: Human Organ Systems & Magnetism", chapters: [
          { num: 11, name: "Air and Atmosphere", q: "Composition of Air, Respiration, Photosynthesis & Burning" },
          { num: 12, name: "The Cell", q: "Plant Cell vs Animal Cell, Cell Wall, Nucleus & Chloroplast" },
          { num: 13, name: "Human Organ Systems", q: "Skeletal, Muscular, Digestive, Respiratory & Circulatory Systems" },
          { num: 14, name: "Magnetism", q: "Natural/Artificial Magnets, Magnetic Field & Compass" },
          { num: 15, name: "Water & Environmental Chemistry", q: "Water Cycle, Desalination, Rainwater Harvesting & Pollution" }
        ]}
      ]},
      { name: "Social Science", code: "SOC", icon: "🌍", color: "#10ac84", units: [
        { name: "Unit 1: History of Ancient Tamil Nadu & India", chapters: [
          { num: 1, name: "What is History?", q: "Archaeological Sources, Inscriptions, Coins & Palm Leaf Records" },
          { num: 2, name: "Human Evolution", q: "Homo Sapiens, Stone Age Tools, Fire & Hunting-Gathering" },
          { num: 3, name: "Indus Civilisation", q: "Harappa, Mohenjodaro, Great Bath, Dockyard at Lothal" },
          { num: 4, name: "Ancient Cities of Tamilagam", q: "Madurai, Kanchi, Poompuhar & Sangam Trade Links" },
          { num: 5, name: "Vedic Culture in North India and Megalithic Culture in South India", q: "Vedas, Iron Age Burials, Adichanallur & Keezhadi" },
          { num: 6, name: "Great Thinkers and New Faiths", q: "Jainism, Buddhism, Mahavira & Gautama Buddha" },
          { num: 7, name: "From Chiefdoms to Empires", q: "Mauryan Dynasty, Ashoka's Inscriptions & Kalinga War" },
          { num: 8, name: "Society and Culture in Ancient Tamizhagam (The Sangam Age)", q: "Muvendhar (Chera, Chola, Pandya), Patthupattu & Ettuthogai" }
        ]},
        { name: "Unit 2: Geography & Resources", chapters: [
          { num: 9, name: "The Universe and Solar System", q: "Milky Way, 8 Planets, Earth Rotation, Revolution & Seasons" },
          { num: 10, name: "Land and Oceans", q: "Continents, Plateaus, Plains, Pacific & Indian Oceans" },
          { num: 11, name: "Resources", q: "Renewable vs Non-Renewable Resources & Sustainable Development" },
          { num: 12, name: "Asia and Europe", q: "Physical Divisions, Climate, Major Rivers & Population" },
          { num: 13, name: "Globe and Maps", q: "Scale, Conventional Symbols & Grid Coordinates" }
        ]},
        { name: "Unit 3: Civics & Economics", chapters: [
          { num: 14, name: "Understanding Diversity", q: "Unity in Diversity, Religions, Languages & Folk Cultures" },
          { num: 15, name: "Achieving Equality", q: "Prejudice, Discrimination, Dr. B.R. Ambedkar & Fundamental Rights" },
          { num: 16, name: "National Symbols", q: "Tiranga National Flag, Emblem, Anthem, Tiger & Peacock" },
          { num: 17, name: "The Constitution of India", q: "Constituent Assembly, Preamble, Democracy & Sovereign Republic" },
          { num: 18, name: "Democracy & Local Bodies", q: "Direct vs Representative Democracy, Gram Panchayat & Mayor" },
          { num: 19, name: "Road Safety", q: "Traffic Signals, Zebra Crossings, Pedestrian Safety & Helmet Rules" },
          { num: 20, name: "Economics - An Introduction", q: "Primary, Secondary, Tertiary Activities, Barter System & Money" }
        ]}
      ]}
    ]
  }
];

console.log('State Board comprehensive classes defined:', stateBoardCurriculum.length);
