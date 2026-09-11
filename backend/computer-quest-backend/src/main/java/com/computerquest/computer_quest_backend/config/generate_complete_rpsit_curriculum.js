const fs = require('fs');
const path = require('path');

// Complete Real 2026-27 Textbook Curriculum Matrix for RPSIT School

const cbseCurricula = [
  // Class 4 CBSE
  {
    board: "CBSE", classLevel: 4,
    subjects: [
      { name: "English", code: "ENG", icon: "📖", color: "#fa8231", units: [
        { name: "Unit 1: Wake Up & Neha's Alarm", chapters: [
          { num: 1, name: "Wake Up! (Poem)", q: "Morning Routine & Rhymes" },
          { num: 2, name: "Neha's Alarm Clock", q: "Time, Clocks & Body Watch" }
        ]},
        { name: "Unit 2: Noses & Little Fir Tree", chapters: [
          { num: 3, name: "Noses (Poem)", q: "Facial Features & Self Esteem" },
          { num: 4, name: "The Little Fir Tree", q: "Contentment & Nature Lessons" }
        ]},
        { name: "Unit 3: Run & Nasruddin", chapters: [
          { num: 5, name: "Run! (Poem)", q: "Outdoor Sports & Energy" },
          { num: 6, name: "Nasruddin's Aim", q: "Archery & Confidence" }
        ]},
        { name: "Unit 4: Why & Alice", chapters: [
          { num: 7, name: "Why? (Poem)", q: "Curiosity & Scientific Questions" },
          { num: 8, name: "Alice in Wonderland", q: "Fantasy, Rabbits & Exploration" }
        ]},
        { name: "Unit 5: Don't be Afraid & Helen Keller", chapters: [
          { num: 9, name: "Don't be Afraid of the Dark", q: "Night, Stars & Overcoming Fear" },
          { num: 10, name: "Helen Keller", q: "Perseverance & Braille Learning" }
        ]},
        { name: "Unit 6: Hiawatha & The Scholar's Mother Tongue", chapters: [
          { num: 11, name: "Hiawatha (Poem)", q: "Native Wildlife & Bird Whispers" },
          { num: 12, name: "The Scholar's Mother Tongue", q: "Birbal's Wit & Languages" }
        ]}
      ]},
      { name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4", units: [
        { name: "Unit 1: Geometry & Measurement", chapters: [
          { num: 1, name: "Building with Bricks", q: "Brick Patterns, Arches & 3D Faces" },
          { num: 2, name: "Long and Short", q: "Centimetres, Metres & Kilometres" },
          { num: 3, name: "A Trip to Bhopal", q: "Multi-digit Operations & Bus Capacity" },
          { num: 4, name: "Tick-Tick-Tick", q: "12-hour vs 24-hour Clocks & Calendars" }
        ]},
        { name: "Unit 2: Shapes, Money & Capacity", chapters: [
          { num: 5, name: "The Way The World Looks", q: "Top, Side & Front Perspectives" },
          { num: 6, name: "The Junk Seller", q: "Money, Rates, Profit & Cash Transactions" },
          { num: 7, name: "Jugs and Mugs", q: "Litres, Millilitres & Capacity" },
          { num: 8, name: "Carts and Wheels", q: "Circles, Radii, Diameters & Compass" }
        ]},
        { name: "Unit 3: Fractions, Patterns & Data", chapters: [
          { num: 9, name: "Halves and Quarters", q: "Fractions 1/2, 1/4 & 3/4" },
          { num: 10, name: "Play with Patterns", q: "Symmetry, Number Series & Secret Messages" },
          { num: 11, name: "Tables and Shares", q: "Multiplication Arrays & Division" },
          { num: 12, name: "How Heavy? How Light?", q: "Grams, Kilograms & Beam Balances" },
          { num: 13, name: "Fields and Fences", q: "Perimeter & Boundary Measurement" },
          { num: 14, name: "Smart Charts", q: "Tally Marks, Bar Graphs & Data Pictographs" }
        ]}
      ]},
      { name: "EVS", code: "EVS", icon: "🌿", color: "#20bf6b", units: [
        { name: "Unit 1: Going to School & Animals", chapters: [
          { num: 1, name: "Going to School", q: "Bamboo Bridges, Vallam & Trolleys" },
          { num: 2, name: "Ear to Ear", q: "Animal Ears, Skin Patterns & Feathers" },
          { num: 3, name: "A Day with Nandu", q: "Elephant Herds & Animal Habits" }
        ]},
        { name: "Unit 2: Plants & Communities", chapters: [
          { num: 4, name: "The Story of Amrita", q: "Khejadi Trees & Bishnoi Conservation" },
          { num: 5, name: "Anita and the Honeybees", q: "Girl Star, Beekeeping & Education" },
          { num: 6, name: "Omana's Journey", q: "Train Travel, Stations & Booking" }
        ]},
        { name: "Unit 3: Travel, Food & Shelters", chapters: [
          { num: 7, name: "From the Window", q: "Tunnels, Level Crossings & Bridges" },
          { num: 8, name: "Reaching Grandmother's House", q: "Ferry Rides & Kerala Backwaters" },
          { num: 9, name: "Changing Families", q: "Family Trees & Marriage Traditions" },
          { num: 10, name: "Hu Tu Tu, Hu Tu Tu", q: "Kabaddi Rules & Fair Play" }
        ]},
        { name: "Unit 4: Heritage & Environment", chapters: [
          { num: 11, name: "The Valley of Flowers", q: "Uttarakhand Flora & Madhubani Art" },
          { num: 12, name: "Changing Times", q: "Kaccha vs Pucca Houses Over Generations" },
          { num: 13, name: "A River's Tale", q: "Water Pollution & River Conservation" },
          { num: 14, name: "Basva's Farm", q: "Onion Cultivation, Khunti & Kurige" }
        ]}
      ]}
    ]
  },

  // Class 5 CBSE
  {
    board: "CBSE", classLevel: 5,
    subjects: [
      { name: "English", code: "ENG", icon: "📖", color: "#fa8231", units: [
        { name: "Unit 1: Ice-Cream Man & Wonderful Waste", chapters: [
          { num: 1, name: "Ice-Cream Man (Poem)", q: "Summer Treats & Rhyming Words" },
          { num: 2, name: "Wonderful Waste!", q: "Avial Recipe & Kitchen Recycling" }
        ]},
        { name: "Unit 2: Teamwork & Flying Together", chapters: [
          { num: 3, name: "Teamwork (Poem)", q: "Cooperation & Goal Achievement" },
          { num: 4, name: "Flying Together", q: "Geese Wisdom, Old Bird & Creeper" }
        ]},
        { name: "Unit 3: My Shadow & Robinson Crusoe", chapters: [
          { num: 5, name: "My Shadow (Poem)", q: "Light, Darkness & Silhouette" },
          { num: 6, name: "Robinson Crusoe Discovers a Footprint", q: "Island Survival & Mystery" }
        ]},
        { name: "Unit 4: Crying & My Elder Brother", chapters: [
          { num: 7, name: "Crying (Poem)", q: "Emotions & Joy" },
          { num: 8, name: "My Elder Brother", q: "Hard Work, Respect & Siblings" }
        ]},
        { name: "Unit 5: Rip Van Winkle & Talkative Barber", chapters: [
          { num: 9, name: "Rip Van Winkle", q: "Kaatskill Mountains & Sleeping 20 Years" },
          { num: 10, name: "The Talkative Barber", q: "Sultan, Baghdad & Humorous Wit" }
        ]},
        { name: "Unit 6: Topsy-Turvy Land & Gulliver's Travels", chapters: [
          { num: 11, name: "Topsy-Turvy Land", q: "Upside-Down Logic & Nonsense Verse" },
          { num: 12, name: "Gulliver's Travels", q: "Brobdingnag Giants & Adventure" }
        ]}
      ]},
      { name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4", units: [
        { name: "Unit 1: Numbers, Shapes & Angles", chapters: [
          { num: 1, name: "The Fish Tale", q: "Lakhs, Crores, Boat Speeds & Fish Drying Banks" },
          { num: 2, name: "Shapes and Angles", q: "Right, Acute, Obtuse Angles & Degree Clock" },
          { num: 3, name: "How Many Squares?", q: "Area & Perimeter on 1cm Square Grids" },
          { num: 4, name: "Parts and Wholes", q: "Fractions, Equivalent Parts & National Flags" }
        ]},
        { name: "Unit 2: Patterns & Symmetry", chapters: [
          { num: 5, name: "Does it Look the Same?", q: "Rotational Symmetry & Quarter Turns" },
          { num: 6, name: "Be My Multiple, I'll be Your Factor", q: "Multiples, Common Factors, LCM & HCF" },
          { num: 7, name: "Can You See the Pattern?", q: "Magic Squares, Palindromes & Number Tricks" },
          { num: 8, name: "Mapping Your Way", q: "India Gate Maps, Scale & Directions" }
        ]},
        { name: "Unit 3: Decimals, Area & Volume", chapters: [
          { num: 9, name: "Boxes and Sketches", q: "Nets of 3D Cubes, Cylinders & Floor Maps" },
          { num: 10, name: "Tenths and Hundredths", q: "Decimals (0.1, 0.01), Currencies & Measures" },
          { num: 11, name: "Area and its Boundary", q: "Rectangle/Square Area & Border Fencing" },
          { num: 12, name: "Smart Charts", q: "Tally Marks, Chapati Pie Charts & Family Trees" },
          { num: 13, name: "Ways to Multiply and Divide", q: "Column Multiplication & Division Word Problems" },
          { num: 14, name: "How Big? How Heavy?", q: "Volume of Cubes, Cuboids & Water Displacement" }
        ]}
      ]},
      { name: "EVS", code: "EVS", icon: "🌿", color: "#20bf6b", units: [
        { name: "Unit 1: Super Senses & Digestion", chapters: [
          { num: 1, name: "Super Senses", q: "Ant Chemical Trails, Eagle Vision & Tiger Whiskers" },
          { num: 2, name: "A Snake Charmer's Story", q: "Kalbeliyas, Been Music & Poisonous Fangs" },
          { num: 3, name: "From Tasting to Digesting", q: "Tongue Taste Zones, Saliva & Stomach Enzymes" }
        ]},
        { name: "Unit 2: Food & Seeds", chapters: [
          { num: 4, name: "Mangoes Round the Year", q: "Mamidi Tandra, Food Spoilage & Preservation" },
          { num: 5, name: "Seeds and Seeds", q: "Sprouting, Velcro Invention & Seed Dispersal" },
          { num: 6, name: "Every Drop Counts", q: "Ghadsisar Lake, Stepwells & Rainwater Harvesting" }
        ]},
        { name: "Unit 3: Experiments & Mountaineering", chapters: [
          { num: 7, name: "Experiments with Water", q: "Floating, Sinking, Salt Density & Dead Sea" },
          { num: 8, name: "A Treat for Mosquitoes", q: "Malaria Parasite, Ronald Ross & Anaemia" },
          { num: 9, name: "Up You Go!", q: "Bachendri Pal, Everest Summit & Rock Climbing" },
          { num: 10, name: "Walls Tell Stories", q: "Golconda Fort, Bastions & Mughal Cannons" }
        ]},
        { name: "Unit 4: Space, Earth & Energy", chapters: [
          { num: 11, name: "Sunita in Space", q: "Space Station, Zero Gravity & Earth from Orbit" },
          { num: 12, name: "What if it Finishes...?", q: "Petroleum, Crude Oil, CNG & Energy Conservation" },
          { num: 13, name: "A Shelter so High!", q: "Leh, Ladakh, Changpa Tribe & Pashmina Wool" },
          { num: 14, name: "When the Earth Shook!", q: "Bhuj Earthquake & Disaster Preparedness" }
        ]}
      ]}
    ]
  },

  // Class 6 to 10 CBSE will be added systematically
];

console.log('Building curriculum database generator...');
