const fs = require('fs');
const path = require('path');

// Complete Comprehensive 2026-27 Curriculum Generator for RPSIT School
const generatorScript = `
const fs = require('fs');
const path = require('path');

// Helper to generate chapter entries
function createSubject(name, code, icon, color, units) {
  return { name, code, icon, color, units };
}

// ---------------------------------------------------------
// CBSE CLASSES 4 TO 12
// ---------------------------------------------------------
const cbseCurricula = [
  // Class 4
  {
    board: "CBSE", classLevel: 4,
    subjects: [
      createSubject("English", "ENG", "📖", "#fa8231", [
        { name: "Unit 1: Stories & Daily Life", chapters: [
          { num: 1, name: "Neha's Alarm Clock", q: "Reading, Routine & Nouns" },
          { num: 2, name: "The Little Fir Tree", q: "Adjectives, Trees & Nature" },
          { num: 3, name: "Nasruddin's Aim", q: "Verbs, Action Words & Courage" }
        ]},
        { name: "Unit 2: Fantasy & Great Personalities", chapters: [
          { num: 4, name: "Alice in Wonderland", q: "Pronouns, Sentences & Fantasy" },
          { num: 5, name: "Helen Keller", q: "Determination, Braille & Compassion" },
          { num: 6, name: "The Giving Tree", q: "Selflessness, Environment & Vocabulary" }
        ]}
      ]),
      createSubject("Mathematics", "MATH", "📐", "#4834d4", [
        { name: "Unit 1: Shapes, Length & Journeys", chapters: [
          { num: 1, name: "Building with Bricks", q: "Bricks, 2D Wall Patterns & 3D Shapes" },
          { num: 2, name: "Long and Short", q: "Centimeters, Meters & Kilometers" },
          { num: 3, name: "A Trip to Bhopal", q: "Word Problems, Speed, Time & Money" },
          { num: 4, name: "Tick-Tick-Tick", q: "12/24 Hour Clocks & Calendar Dates" }
        ]},
        { name: "Unit 2: Fractions, Weight & Perimeter", chapters: [
          { num: 5, name: "The Junk Seller", q: "Currency Notes, Multiplication & Profit" },
          { num: 6, name: "Jugs and Mugs", q: "Volume, Litres & Millilitres" },
          { num: 7, name: "Halves and Quarters", q: "Fractions, Half & Quarter Shading" },
          { num: 8, name: "Fields and Fences", q: "Perimeter, Boundary Length & Area" }
        ]}
      ]),
      createSubject("EVS", "EVS", "🌿", "#20bf6b", [
        { name: "Unit 1: Animals, Travel & Forests", chapters: [
          { num: 1, name: "Going to School", q: "Bamboo Bridges, Trolleys & Transport" },
          { num: 2, name: "Ear to Ear", q: "Animal Ears, Skin Patterns & Habitats" },
          { num: 3, name: "A Day with Nandu", q: "Elephant Herds, Leaders & Behavior" },
          { num: 4, name: "The Story of Amrita", q: "Bishnoi Community, Khejadi Trees & Ecology" }
        ]},
        { name: "Unit 2: Insects, Journeys & Plants", chapters: [
          { num: 5, name: "Anita and the Honeybees", q: "Beehives, Queen Bee & Honey Collection" },
          { num: 6, name: "Omana's Journey", q: "Railway Stations, Trains & Food Culture" },
          { num: 7, name: "The Valley of Flowers", q: "Uttarakhand Flora, Madhubani & Perfumes" },
          { num: 8, name: "A River's Tale", q: "River Pollution, Aquatic Life & Water Care" }
        ]}
      ])
    ]
  },

  // Class 5
  {
    board: "CBSE", classLevel: 5,
    subjects: [
      createSubject("English", "ENG", "📖", "#fa8231", [
        { name: "Unit 1: Folklore, Teamwork & Wit", chapters: [
          { num: 1, name: "Wonderful Waste!", q: "Avial Recipe, Kerala Heritage & Recycling" },
          { num: 2, name: "Flying Together", q: "Wise Geese, Hunter & Teamwork" },
          { num: 3, name: "Robinson Crusoe Discovers a Footprint", q: "Island Exploration & Courage" }
        ]},
        { name: "Unit 2: Adventures & Global Journeys", chapters: [
          { num: 4, name: "My Elder Brother", q: "Hard Work, Respect & Timetables" },
          { num: 5, name: "Rip Van Winkle", q: "Twenty Year Sleep & Village Changes" },
          { num: 6, name: "Gulliver's Travels", q: "Lilliput, Giants & Perspective" }
        ]}
      ]),
      createSubject("Mathematics", "MATH", "📐", "#4834d4", [
        { name: "Unit 1: Numbers, Geometry & Angles", chapters: [
          { num: 1, name: "The Fish Tale", q: "Lakhs, Crores, Boat Speeds & Fish Catch" },
          { num: 2, name: "Shapes and Angles", q: "Angles: Right, Acute, Obtuse & Clock Hands" },
          { num: 3, name: "How Many Squares?", q: "Stamp Area, Grid Triangles & Perimeters" },
          { num: 4, name: "Parts and Wholes", q: "Fractions, Flags, Chocolate Division & LCM" }
        ]},
        { name: "Unit 2: Multiples, Maps & 3D Solids", chapters: [
          { num: 5, name: "Be My Multiple, I'll be Your Factor", q: "Multiples, Common Factors, Dice Games & HCF" },
          { num: 6, name: "Mapping Your Way", q: "India Gate Maps, Scale & Navigation" },
          { num: 7, name: "Boxes and Sketches", q: "Nets for Cubes, Open Boxes & Floor Maps" },
          { num: 8, name: "Tenths and Hundredths", q: "Decimals, Money Conversion & Thermometers" }
        ]}
      ]),
      createSubject("EVS", "EVS", "🌿", "#20bf6b", [
        { name: "Unit 1: Animal Senses & Digestion", chapters: [
          { num: 1, name: "Super Senses", q: "Ant Chemical Trails, Eagle Vision & Dog Hearing" },
          { num: 2, name: "A Snake Charmer's Story", q: "Kalbeliyas, Poisonous Fangs & Anti-venom" },
          { num: 3, name: "From Tasting to Digesting", q: "Taste Buds, Saliva & Dr. Beaumont Stomach Study" },
          { num: 4, name: "Mangoes Round the Year", q: "Mamidi Tandra, Food Spoilage & Preservation" }
        ]},
        { name: "Unit 2: Plants, Water & Space", chapters: [
          { num: 5, name: "Seeds and Seeds", q: "Sprouting, Velcro, Seed Dispersal by Wind/Water" },
          { num: 6, name: "Every Drop Counts", q: "Ghadsisar Lake, Jaisalmer & Johads" },
          { num: 7, name: "Experiments with Water", q: "Dead Sea, Floating Eggs & Dandi Salt March" },
          { num: 8, name: "Sunita in Space", q: "Zero Gravity, Astronauts & Earth Globe" }
        ]}
      ])
    ]
  },

  // Class 6
  {
    board: "CBSE", classLevel: 6,
    subjects: [
      createSubject("English", "ENG", "📖", "#fa8231", [
        { name: "Unit 1: Self-Reliance & Nature", chapters: [
          { num: 1, name: "Who Did Patrick's Homework?", q: "Self-Reliance, Homework & Sentences" },
          { num: 2, name: "How the Dog Found Himself a New Master!", q: "Canine Domestication & Loyalty" },
          { num: 3, name: "Taro's Reward", q: "Filial Respect, Magic Waterfall & Values" }
        ]},
        { name: "Unit 2: Great Achievers & Justice", chapters: [
          { num: 4, name: "An Indian - American Woman in Space: Kalpana Chawla", q: "Aeronautics, Shuttle Mission & Biography" },
          { num: 5, name: "A Different Kind of School", q: "Empathy, Blindfold Day & Inclusivity" },
          { num: 6, name: "Fair Play", q: "Panchayat Justice, Jumman & Algu" }
        ]}
      ]),
      createSubject("Mathematics", "MATH", "📐", "#4834d4", [
        { name: "Unit 1: Numbers & Integers", chapters: [
          { num: 1, name: "Knowing Our Numbers", q: "Large Numbers, Roman Numerals & Place Value" },
          { num: 2, name: "Whole Numbers", q: "Number Line Operations & Predecessor/Successor" },
          { num: 3, name: "Playing with Numbers", q: "Prime Numbers, Sieve of Eratosthenes & HCF/LCM" },
          { num: 4, name: "Integers", q: "Positive and Negative Integers & Real Contexts" }
        ]},
        { name: "Unit 2: Geometry & Algebra", chapters: [
          { num: 5, name: "Basic Geometrical Ideas", q: "Points, Segments, Rays, Curves & Polygons" },
          { num: 6, name: "Fractions and Decimals", q: "Equivalent Fractions, Mixed Numbers & Decimal Arithmetic" },
          { num: 7, name: "Mensuration", q: "Perimeter of Regular Polygons & Rectangle Area" },
          { num: 8, name: "Introduction to Algebra", q: "Variables, Matchstick Patterns & Expressions" }
        ]}
      ]),
      createSubject("Science", "SCI", "🔬", "#20bf6b", [
        { name: "Unit 1: Food & Materials", chapters: [
          { num: 1, name: "Components of Food", q: "Carbohydrates, Proteins, Iodine Test & Deficiency Diseases" },
          { num: 2, name: "Sorting Materials into Groups", q: "Lustre, Hardness, Transparency & Solubility" },
          { num: 3, name: "Separation of Substances", q: "Handpicking, Winnowing, Decantation & Evaporation" }
        ]},
        { name: "Unit 2: Plants, Animals & Electricity", chapters: [
          { num: 4, name: "Getting to Know Plants", q: "Taproots, Venation, Petals & Photosynthesis" },
          { num: 5, name: "Body Movements", q: "Ball-and-Socket Joint, Cartilage & Earthworm Locomotion" },
          { num: 6, name: "Electricity and Circuits", q: "Electric Cells, Switch, Filament & Conductors/Insulators" },
          { num: 7, name: "Fun with Magnets", q: "Magnetic Poles, Compass & Magnetisation Methods" }
        ]}
      ]),
      createSubject("Social Science", "SOC", "🌍", "#eb4d4b", [
        { name: "Unit 1: Early Civilizations & The Solar System", chapters: [
          { num: 1, name: "What, Where, How and When?", q: "Archaeology, Inscriptions & River Narmada Settlements" },
          { num: 2, name: "From Hunting-Gathering to Growing Food", q: "Mehrgarh, Paleolithic Tools & Domestication" },
          { num: 3, name: "In the Earliest Cities", q: "Harappan Citadel, Great Bath, Drains & Seal Crafts" },
          { num: 4, name: "The Earth in the Solar System", q: "Celestial Bodies, Planets, Sun & Moon Phases" }
        ]},
        { name: "Unit 2: Geography, Diversity & Panchayats", chapters: [
          { num: 5, name: "Globe: Latitudes and Longitudes", q: "Equator, Greenwich Prime Meridian & Time Zones" },
          { num: 6, name: "Major Domains of the Earth", q: "Lithosphere, Hydrosphere, Atmosphere & Biosphere" },
          { num: 7, name: "Understanding Diversity & Discrimination", q: "Ladakh, Kerala Diversity & Dr. Ambedkar Struggles" },
          { num: 8, name: "What is Government? & Panchayati Raj", q: "Gram Sabha, Sarpanch, Block Level & Democracy" }
        ]}
      ])
    ]
  },

  // Class 7
  {
    board: "CBSE", classLevel: 7,
    subjects: [
      createSubject("English", "ENG", "📖", "#fa8231", [
        { name: "Unit 1: Wisdom & Compassion", chapters: [
          { num: 1, name: "Three Questions (Leo Tolstoy)", q: "Hermit Wisdom, Crucial Time & Good Deeds" },
          { num: 2, name: "A Gift of Chappals", q: "Kindness, Stray Kitten & Music Master" },
          { num: 3, name: "Gopal and the Hilsa-Fish", q: "Royal Challenge, Wit & Courtiers" }
        ]},
        { name: "Unit 2: Values & Dedication", chapters: [
          { num: 4, name: "The Ashes That Made Trees Bloom", q: "Honest Old Couple, Pet Dog & Cherry Blossoms" },
          { num: 5, name: "Quality (John Galsworthy)", q: "Master Bootmaker, Gessler Brothers & True Art" },
          { num: 6, name: "Expert Detectives", q: "Nishad, Maya & Mr. Nath Mystery" }
        ]}
      ]),
      createSubject("Mathematics", "MATH", "📐", "#4834d4", [
        { name: "Unit 1: Integers & Fractions", chapters: [
          { num: 1, name: "Integers", q: "Multiplication Rules, Division of Integers & Distributive Law" },
          { num: 2, name: "Fractions and Decimals", q: "Reciprocals, Decimal Multiplication & Division" },
          { num: 3, name: "Data Handling", q: "Arithmetic Mean, Median, Mode & Bar Graphs" },
          { num: 4, name: "Simple Equations", q: "Forming Linear Equations, Transposition & Solving" }
        ]},
        { name: "Unit 2: Geometry & Quantities", chapters: [
          { num: 5, name: "Lines and Angles", q: "Complementary, Supplementary, Vertically Opposite Angles & Transversals" },
          { num: 6, name: "The Triangle and its Properties", q: "Medians, Altitudes, Exterior Angle & Pythagoras Theorem" },
          { num: 7, name: "Comparing Quantities", q: "Ratios, Percentages, Profit/Loss & Simple Interest" },
          { num: 8, name: "Perimeter and Area", q: "Parallelogram Area, Circle Circumference & Pi = 22/7" }
        ]}
      ]),
      createSubject("Science", "SCI", "🔬", "#20bf6b", [
        { name: "Unit 1: Nutrition & Matter", chapters: [
          { num: 1, name: "Nutrition in Plants", q: "Autotrophic, Chlorophyll, Stomata & Insectivorous Pitcher Plant" },
          { num: 2, name: "Nutrition in Animals", q: "Human Alimentary Canal, Ruminants & Amoeba Pseudopodia" },
          { num: 3, name: "Heat", q: "Clinical Thermometer, Conduction, Convection & Radiation" },
          { num: 4, name: "Acids, Bases and Salts", q: "Litmus Paper, Phenolphthalein & Neutralisation Reactions" }
        ]},
        { name: "Unit 2: Life Systems, Light & Electricity", chapters: [
          { num: 5, name: "Physical and Chemical Changes", q: "Rusting of Iron, Crystallisation & Magnesium Burning" },
          { num: 6, name: "Respiration in Organisms", q: "Aerobic/Anaerobic, Diaphragm & Inhalation/Exhalation" },
          { num: 7, name: "Transportation in Animals and Plants", q: "Heart Chambers, RBCs, Xylem/Phloem & Transpiration" },
          { num: 8, name: "Light and Electric Effects", q: "Spherical Mirrors, Lenses, Electromagnets & Fuses" }
        ]}
      ]),
      createSubject("Social Science", "SOC", "🌍", "#eb4d4b", [
        { name: "Unit 1: Medieval India & Our Earth", chapters: [
          { num: 1, name: "Tracing Changes Through a Thousand Years", q: "Cartography, Manuscripts, Terminology & Jatis" },
          { num: 2, name: "Kings and Kingdoms", q: "Prashastis, Tripartite Struggle & Chola Bronze Statues" },
          { num: 3, name: "Delhi: 12th to 15th Century", q: "Delhi Sultanate, Raziya Sultan, Alauddin Khalji & Taxes" },
          { num: 4, name: "Inside Our Earth & Our Changing Earth", q: "Crust, Mantle, Core, Igneous Rocks, Volcanoes & Earthquakes" }
        ]},
        { name: "Unit 2: Atmosphere, Healthcare & Governance", chapters: [
          { num: 5, name: "Air and Water", q: "Troposphere Layers, Greenhouse Effect, Waves & Tides" },
          { num: 6, name: "On Equality & Healthcare in India", q: "Universal Adult Suffrage, Midday Meals & Public Hospitals" },
          { num: 7, name: "How the State Government Works", q: "Legislative Assembly, MLAs, Majority Party & Debate" },
          { num: 8, name: "Markets Around Us", q: "Weekly Markets, Neighborhood Shops, Malls & Chain of Markets" }
        ]}
      ])
    ]
  },

  // Class 8
  {
    board: "CBSE", classLevel: 8,
    subjects: [
      createSubject("English", "ENG", "📖", "#fa8231", [
        { name: "Unit 1: Historical Glimpses & Courage", chapters: [
          { num: 1, name: "The Best Christmas Present in the World", q: "WWI Christmas Truce, Jim Macpherson & Connie" },
          { num: 2, name: "The Tsunami", q: "Andaman Disaster, Tilly Smith & Animal Warning Instincts" },
          { num: 3, name: "Glimpses of the Past", q: "Company Rule, Raja Ram Mohan Roy & 1857 Martyrs" }
        ]},
        { name: "Unit 2: Human Spirit & Nature", chapters: [
          { num: 4, name: "Bepin Choudhury's Lapse of Memory", q: "Ranchi Trip Mystery, Chunilal & Friendship Tricks" },
          { num: 5, name: "The Summit Within (Major H.P.S. Ahluwalia)", q: "Mount Everest Climbing & Conquering the Internal Mind" },
          { num: 6, name: "This is Jody's Fawn", q: "Compassion, Saving Orphaned Fawn & Mill-Wheel" }
        ]}
      ]),
      createSubject("Mathematics", "MATH", "📐", "#4834d4", [
        { name: "Unit 1: Algebra & Square Roots", chapters: [
          { num: 1, name: "Rational Numbers", q: "Closure, Commutative, Associative & Additive Inverse" },
          { num: 2, name: "Linear Equations in One Variable", q: "Solving Equations with Variables on Both Sides" },
          { num: 3, name: "Understanding Quadrilaterals", q: "Angle Sum Property, Parallelogram, Rhombus & Trapezium" },
          { num: 4, name: "Squares and Square Roots", q: "Pythagorean Triplets & Division Method Square Root" }
        ]},
        { name: "Unit 2: Mensuration, Exponents & Graphs", chapters: [
          { num: 5, name: "Cubes and Cube Roots", q: "Hardy-Ramanujan Number 1729 & Prime Factor Cube Root" },
          { num: 6, name: "Comparing Quantities", q: "Discount, Sales Tax, GST & Compound Interest Formulas" },
          { num: 7, name: "Mensuration", q: "Trapezium Area, Surface Area & Cylinder/Cuboid Volume" },
          { num: 8, name: "Exponents, Powers & Factorisation", q: "Laws of Indices, Standard Form & Common Factors" }
        ]}
      ]),
      createSubject("Science", "SCI", "🔬", "#20bf6b", [
        { name: "Unit 1: Agriculture, Microbes & Fuels", chapters: [
          { num: 1, name: "Crop Production and Management", q: "Kharif/Rabi, Seed Drills, Drip Irrigation & Silos" },
          { num: 2, name: "Microorganisms: Friend and Foe", q: "Lactobacillus, Penicillin, Pasteurisation & Viruses" },
          { num: 3, name: "Coal and Petroleum", q: "Fractional Distillation, Petroleum Gas & Fossil Fuels" },
          { num: 4, name: "Combustion and Flame", q: "Ignition Temperature, Fire Extinguishers & Flame Zones" }
        ]},
        { name: "Unit 2: Reproduction, Forces & Sound", chapters: [
          { num: 5, name: "Conservation of Plants and Animals", q: "Deforestation, Red Data Book, Sanctuaries & Endemic Species" },
          { num: 6, name: "Reproduction in Animals", q: "Zygote, Metamorphosis & Cloning of Dolly the Sheep" },
          { num: 7, name: "Force and Pressure & Friction", q: "Atmospheric Pressure, Net Force & Ball Bearings" },
          { num: 8, name: "Sound, Chemical Effects & Light", q: "Larynx, Frequency/Hertz, Electroplating & Periscope" }
        ]}
      ]),
      createSubject("Social Science", "SOC", "🌍", "#eb4d4b", [
        { name: "Unit 1: Freedom Rebellion & Resources", chapters: [
          { num: 1, name: "From Trade to Territory", q: "Battle of Plassey, Subsidiary Alliance & Doctrine of Lapse" },
          { num: 2, name: "When People Rebel: 1857 and After", q: "Mangal Pandey, Bahadur Shah Zafar & Queen Proclamation" },
          { num: 3, name: "Resources: Land, Soil, Water & Minerals", q: "Soil Profile, Rainwater Conservation & Hydroelectric Power" },
          { num: 4, name: "Agriculture and Industries", q: "Subsistence/Commercial Farming, Jamshedpur Steel & Silicon Valley" }
        ]},
        { name: "Unit 2: Constitution, Parliament & Judiciary", chapters: [
          { num: 5, name: "The Indian Constitution & Secularism", q: "Preamble, Fundamental Rights & Separation of Religion" },
          { num: 6, name: "Parliament and the Making of Laws", q: "Lok Sabha, Rajya Sabha, Bills to Acts & Representation" },
          { num: 7, name: "Judiciary and Criminal Justice System", q: "Supreme Court, FIR, Public Prosecutor & Fair Trial" },
          { num: 8, name: "Understanding Marginalisation", q: "Adivasis, Minorities, Affirmative Action & Article 15" }
        ]}
      ])
    ]
  },

  // Class 9
  {
    board: "CBSE", classLevel: 9,
    subjects: [
      createSubject("English", "ENG", "📖", "#fa8231", [
        { name: "Unit 1: AI, Music & Great Personalities", chapters: [
          { num: 1, name: "The Fun They Had (Isaac Asimov)", q: "Mechanical Teachers, Telebooks & Century 2157 Schools" },
          { num: 2, name: "The Sound of Music (Evelyn Glennie & Bismillah Khan)", q: "Percussion Mastery, Shehnai at Red Fort & Dedication" },
          { num: 3, name: "The Little Girl (Katherine Mansfield)", q: "Kezia, Strict Father, Pin-cushion & Real Compassion" }
        ]},
        { name: "Unit 2: Genius, Heritage & Comedy", chapters: [
          { num: 4, name: "A Truly Beautiful Mind (Albert Einstein)", q: "General Relativity, Nobel Prize & World Government Letter" },
          { num: 5, name: "My Childhood (Dr. A.P.J. Abdul Kalam)", q: "Rameswaram Roots, Sivasubramania Iyer & Secular Values" },
          { num: 6, name: "If I Were You (Douglas James)", q: "Gerrard, Intruding Burglar & Witty Escape" }
        ]}
      ]),
      createSubject("Mathematics", "MATH", "📐", "#4834d4", [
        { name: "Unit 1: Real Numbers & Linear Algebra", chapters: [
          { num: 1, name: "Number Systems", q: "Irrational Proofs, Rationalising Denominators & Real Number Line" },
          { num: 2, name: "Polynomials", q: "Degree, Remainder Theorem, Factor Theorem & Identities" },
          { num: 3, name: "Coordinate Geometry", q: "Cartesian Plane, Quadrants, Abscissa & Ordinate" },
          { num: 4, name: "Linear Equations in Two Variables", q: "Graphing ax + by + c = 0 & Solutions of Linear Equations" }
        ]},
        { name: "Unit 2: Geometry, Mensuration & Statistics", chapters: [
          { num: 5, name: "Lines and Angles & Triangles", q: "Axioms, SAS/ASA Congruence & Midpoint Theorem" },
          { num: 6, name: "Quadrilaterals & Circles", q: "Cyclic Quadrilaterals, Subtended Angles & Theorems" },
          { num: 7, name: "Heron's Formula & Surface Areas / Volumes", q: "Triangle Semi-Perimeter, Cones, Spheres & Hemispheres" },
          { num: 8, name: "Statistics", q: "Bar Graphs, Histograms & Frequency Polygons" }
        ]}
      ]),
      createSubject("Science", "SCI", "🔬", "#20bf6b", [
        { name: "Unit 1: Matter & Biological Systems", chapters: [
          { num: 1, name: "Matter in Our Surroundings", q: "Latent Heat, Evaporation, Kelvin Scale & Diffusion" },
          { num: 2, name: "Is Matter Around Us Pure", q: "Colloids, Tyndall Effect, Suspensions & Chromatography" },
          { num: 3, name: "Atoms, Molecules & Chemical Structure", q: "Law of Constant Proportions, Dalton Atomic Theory & Bohr Model" },
          { num: 4, name: "The Fundamental Unit of Life: Cell", q: "Plasma Membrane, Osmosis, Mitochondria & Golgi Apparatus" }
        ]},
        { name: "Unit 2: Mechanics, Energy & Acoustics", chapters: [
          { num: 5, name: "Tissues", q: "Meristematic, Xylem/Phloem, Epithelial & Striated Muscle" },
          { num: 6, name: "Motion & Force and Laws of Motion", q: "v = u + at, Momentum, F = ma & Action-Reaction Law" },
          { num: 7, name: "Gravitation & Work and Energy", q: "Universal Gravity G, Archimedes Principle & Kinetic/Potential Energy" },
          { num: 8, name: "Sound", q: "Longitudinal Waves, Echo, Ultrasound & Human Ear Structure" }
        ]}
      ]),
      createSubject("Social Science", "SOC", "🌍", "#eb4d4b", [
        { name: "Unit 1: World Revolutions & Indian Geography", chapters: [
          { num: 1, name: "The French Revolution", q: "Storming of Bastille, Jacobins, Robespierre & Declaration of Rights" },
          { num: 2, name: "Socialism in Europe & The Russian Revolution", q: "Tsar Nicholas II, Bolsheviks, Lenin April Theses & Soviets" },
          { num: 3, name: "India - Size, Location & Physical Features", q: "Himalayan Ranges, Northern Plains & Peninsular Plateaus" },
          { num: 4, name: "Drainage and Climate", q: "Himalayan vs Peninsular Rivers, Monsoon Mechanism & ITCZ" }
        ]},
        { name: "Unit 2: Democracy, Elections & Poverty", chapters: [
          { num: 5, name: "What is Democracy? Why Democracy?", q: "Major Decisions by Elected Leaders, Rule of Law & Arguments" },
          { num: 6, name: "Constitutional Design & Electoral Politics", q: "South Africa Apartheid, Indian Constituent Assembly & Election Commission" },
          { num: 7, name: "Working of Institutions", q: "Prime Minister Powers, Cabinet, President & Supreme Court Collegium" },
          { num: 8, name: "Poverty as a Challenge & Food Security", q: "Poverty Line Estimation, NREGA, Public Distribution System & Buffer Stock" }
        ]}
      ])
    ]
  },

  // Class 10
  {
    board: "CBSE", classLevel: 10,
    subjects: [
      createSubject("English", "ENG", "📖", "#fa8231", [
        { name: "Unit 1: Faith, Freedom & Courage", chapters: [
          { num: 1, name: "A Letter to God (G.L. Fuentes)", q: "Lencho, Hailstorm, 100 Pesos & Post Office Staff" },
          { num: 2, name: "Nelson Mandela: Long Walk to Freedom", q: "Inauguration Day, Apartheid Struggle & Meaning of Freedom" },
          { num: 3, name: "Two Stories about Flying", q: "Young Seagull First Flight & Mysterious Black Aeroplane" }
        ]},
        { name: "Unit 2: Human Compassion & Life Lessons", chapters: [
          { num: 4, name: "From the Diary of Anne Frank", q: "Kitty Diary, Secret Annex & Teen Inner Reflections" },
          { num: 5, name: "Glimpses of India (Goa, Coorg & Assam)", q: "Traditional Bakers, Coffee Plantations & Tea Gardens" },
          { num: 6, name: "The Sermon at Benares & The Proposal", q: "Lord Buddha, Kisa Gotami & Chekhov Drama Play" }
        ]}
      ]),
      createSubject("Mathematics", "MATH", "📐", "#4834d4", [
        { name: "Unit 1: Real Numbers, Algebra & AP", chapters: [
          { num: 1, name: "Real Numbers", q: "Fundamental Theorem of Arithmetic, Root 3 Irrationality & Prime Factorisation" },
          { num: 2, name: "Polynomials & Pair of Linear Equations", q: "Zeroes of Quadratic, Elimination & Cross Multiplication" },
          { num: 3, name: "Quadratic Equations", q: "Factoring, Quadratic Formula & Nature of Discriminant Roots" },
          { num: 4, name: "Arithmetic Progressions", q: "nth Term an = a + (n-1)d & Sum of First n Terms Sn" }
        ]},
        { name: "Unit 2: Trigonometry, Coordinate & Circles", chapters: [
          { num: 5, name: "Triangles & Coordinate Geometry", q: "Basic Proportionality Theorem, Section Formula & Distance Formula" },
          { num: 6, name: "Introduction to Trigonometry & Applications", q: "Trig Ratios, sin^2 + cos^2 = 1 & Heights and Distances" },
          { num: 7, name: "Circles & Areas Related to Circles", q: "Tangent Length Theorem, Sector Area & Segment Area" },
          { num: 8, name: "Surface Areas, Volumes, Statistics & Probability", q: "Combination Solids, Step-Deviation Mean, Median, Mode & Single Event Probability" }
        ]}
      ]),
      createSubject("Science", "SCI", "🔬", "#20bf6b", [
        { name: "Unit 1: Chemical Reactions, Acids & Carbon", chapters: [
          { num: 1, name: "Chemical Reactions and Equations", q: "Balancing Redox, Decomposition, Precipitation & Rancidity" },
          { num: 2, name: "Acids, Bases and Salts", q: "pH Scale, Bleaching Powder, Baking Soda & Plaster of Paris" },
          { num: 3, name: "Metals and Non-metals", q: "Reactivity Series, Ionic Bonds & Roasting/Calcination" },
          { num: 4, name: "Carbon and its Compounds", q: "Covalent Bonding, Saturated/Unsaturated, Ethanol & Soaps" }
        ]},
        { name: "Unit 2: Life Processes, Genetics, Optics & Electricity", chapters: [
          { num: 5, name: "Life Processes", q: "Photosynthesis Reactions, Nephron, Human Heart & Double Circulation" },
          { num: 6, name: "Control and Coordination & Heredity", q: "Neurons, Reflex Arc, Endocrine Glands & Mendel 9:3:3:1 Ratio" },
          { num: 7, name: "Light - Reflection and Refraction", q: "Mirror Formula, Lens Formula, Snell's Law & Power of Lens" },
          { num: 8, name: "Electricity, Magnetism & Our Environment", q: "Ohm's Law, Joule Heating, Right Hand Thumb Rule & Food Chains" }
        ]}
      ]),
      createSubject("Social Science", "SOC", "🌍", "#eb4d4b", [
        { name: "Unit 1: Nationalism, Agriculture & Industries", chapters: [
          { num: 1, name: "The Rise of Nationalism in Europe", q: "Frederic Sorrieu, Mazzini, German Unification & Marianne/Germania" },
          { num: 2, name: "Nationalism in India", q: "Rowlatt Act, Jallianwala Bagh, Non-Cooperation & Civil Disobedience" },
          { num: 3, name: "Resources and Development & Agriculture", q: "Soil Conservation, Rice/Wheat Seasons & Green Revolution" },
          { num: 4, name: "Manufacturing Industries & Lifelines", q: "Cotton Textile, Iron and Steel, Golden Quadrilateral & Ports" }
        ]},
        { name: "Unit 2: Power Sharing, Economy & Globalization", chapters: [
          { num: 5, name: "Power Sharing & Federalism", q: "Ethnic Composition in Belgium/Sri Lanka, Union/State/Concurrent Lists" },
          { num: 6, name: "Gender, Religion and Caste & Political Parties", q: "Feminist Movements, Secularism, National/State Parties & Anti-Defection" },
          { num: 7, name: "Development & Sectors of the Indian Economy", q: "Per Capita Income, HDI, Primary/Secondary/Tertiary & Disguised Unemployment" },
          { num: 8, name: "Money, Credit & Globalization", q: "Formal vs Informal Loans, Self-Help Groups (SHGs), MNCs & WTO Impact" }
        ]}
      ])
    ]
  },

  // Classes 11 & 12 CBSE (Full 12 Core Subjects for all 7 CBSE Groups)
  ...[11, 12].map(classLevel => ({
    board: "CBSE", classLevel,
    subjects: [
      createSubject("English", "ENG", "📖", "#fa8231", [
        { name: "Unit 1: Advanced Prose & Literary Critical Analysis", chapters: [
          { num: 1, name: classLevel === 11 ? "The Portrait of a Lady (Khushwant Singh)" : "The Last Lesson (Alphonse Daudet)", q: "Narrative Tone, Grandmothers & Linguistic Chauvinism" },
          { num: 2, name: classLevel === 11 ? "We're Not Afraid to Die... If We Can All Be Together" : "Lost Spring: Stories of Stolen Childhood (Anees Jung)", q: "Maritime Endurance & Slum Child Labour" },
          { num: 3, name: classLevel === 11 ? "Discovering Tut: The Saga Continues" : "Deep Water (William Douglas)", q: "CT Scan Archaeology & Overcoming Childhood Phobias" }
        ]},
        { name: "Unit 2: Poetry, Biographies & Rhetorical Writing", chapters: [
          { num: 4, name: classLevel === 11 ? "The Voice of the Rain & The Ailing Planet" : "The Rattrap (Selma Lagerlof)", q: "Metaphorical Rain Cycles & Human Essential Goodness" },
          { num: 5, name: classLevel === 11 ? "Silk Road (Nick Middleton)" : "Indigo (Louis Fischer - Champaran Satyagraha)", q: "Mount Kailash Pilgrimage & Peasant Emancipation" },
          { num: 6, name: classLevel === 11 ? "Advanced Debate, Speech & Notice Writing" : "Formal Reports, Invitations & Job Applications", q: "Analytical Persuasion & Corporate Format Syntax" }
        ]}
      ]),
      createSubject("Physics", "PHY", "⚡", "#3867d6", [
        { name: "Unit 1: Mechanics, Kinematics & Electromagnetism", chapters: [
          { num: 1, name: classLevel === 11 ? "Units and Measurements & Motion in a Straight Line" : "Electric Charges and Fields & Electrostatic Potential", q: "Dimensional Analysis, Free Fall, Coulomb Law & Gauss Theorem" },
          { num: 2, name: classLevel === 11 ? "Motion in a Plane & Laws of Motion" : "Current Electricity & Moving Charges and Magnetism", q: "Projectiles, Centripetal Force, Kirchhoff Rules & Cyclotrons" },
          { num: 3, name: classLevel === 11 ? "Work, Energy and Power & System of Particles" : "Magnetism, Matter & Electromagnetic Induction", q: "Elastic Collisions, Moment of Inertia, Eddy Currents & Lenz Law" }
        ]},
        { name: "Unit 2: Thermodynamics, Waves, Optics & Semiconductor Electronics", chapters: [
          { num: 4, name: classLevel === 11 ? "Gravitation & Mechanical Properties of Solids/Fluids" : "Alternating Current & Electromagnetic Waves", q: "Kepler Laws, Escape Velocity, Bernoulli Theorem & AC Transformers" },
          { num: 5, name: classLevel === 11 ? "Thermodynamics & Kinetic Theory of Gases" : "Ray Optics, Optical Instruments & Wave Optics", q: "Carnot Engine Efficiency, Equipartition & Young Double Slit" },
          { num: 6, name: classLevel === 11 ? "Oscillations and Waves" : "Dual Nature, Atoms, Nuclei & Semiconductor Diodes", q: "Simple Harmonic Motion, Doppler Effect, Photoelectric Effect & p-n Junctions" }
        ]}
      ]),
      createSubject("Chemistry", "CHEM", "🧪", "#20bf6b", [
        { name: "Unit 1: Physical Principles, Structure & Solutions", chapters: [
          { num: 1, name: classLevel === 11 ? "Some Basic Concepts of Chemistry & Structure of Atom" : "Solutions & Electrochemistry", q: "Molarity, Stoichiometry, Quantum Numbers, Raoult Law & Nernst Equation" },
          { num: 2, name: classLevel === 11 ? "Classification of Elements & Chemical Bonding" : "Chemical Kinetics & Surface Chemistry", q: "Ionisation Enthalpy, Hybridisation, Molecular Orbital & First Order Rate Laws" },
          { num: 3, name: classLevel === 11 ? "Chemical Thermodynamics & Equilibrium" : "The d- and f-Block Elements & Coordination Compounds", q: "Enthalpy, Hess Law, Le Chatelier Principle, Crystal Field Theory & Ligands" }
        ]},
        { name: "Unit 2: Organic Chemistry, Biomolecules & Polymers", chapters: [
          { num: 4, name: classLevel === 11 ? "Redox Reactions & Organic Principles" : "Haloalkanes and Haloarenes", q: "Oxidation Numbers, IUPAC Nomenclature & SN1/SN2 Substitution Mechanism" },
          { num: 5, name: classLevel === 11 ? "Hydrocarbons (Alkanes, Alkenes, Alkynes & Arenes)" : "Alcohols, Phenols and Ethers & Aldehydes and Ketones", q: "Markovnikov Addition, Benzene Resonance, Grignard & Aldol Condensation" },
          { num: 6, name: classLevel === 11 ? "Environmental Chemistry" : "Amines, Biomolecules (Carbohydrates & Proteins)", q: "Green Chemistry, Ozone Depletion, Amino Acids & DNA Helical Structure" }
        ]}
      ]),
      createSubject("Mathematics", "MATH", "📐", "#4834d4", [
        { name: "Unit 1: Relations, Algebra & Matrices", chapters: [
          { num: 1, name: classLevel === 11 ? "Sets, Relations and Functions" : "Relations and Functions & Inverse Trigonometric Functions", q: "Venn Diagrams, Cartesian Products, Injective/Surjective & Principal Value Branches" },
          { num: 2, name: classLevel === 11 ? "Trigonometric Functions & Complex Numbers" : "Matrices and Determinants", q: "Trig Addition Formulas, Modulus, Matrix Inversion & Cramer Rule" },
          { num: 3, name: classLevel === 11 ? "Linear Inequalities, Permutations and Combinations" : "Continuity, Differentiability & Derivatives", q: "Graphical Inequalities, nPr/nCr & Chain Rule/Implicit Differentiation" }
        ]},
        { name: "Unit 2: Calculus, Vectors & Probability", chapters: [
          { num: 4, name: classLevel === 11 ? "Binomial Theorem, Sequences and Series" : "Applications of Derivatives (Rate, Tangents, Maxima/Minima)", q: "General Term, AP/GP Sum & First/Second Derivative Tests" },
          { num: 5, name: classLevel === 11 ? "Straight Lines & Conic Sections (Parabola, Ellipse)" : "Integrals (Indefinite & Definite) & Differential Equations", q: "Slope, Standard Conics, Integration by Parts & Variable Separable" },
          { num: 6, name: classLevel === 11 ? "Limits and Derivatives & Probability" : "Vector Algebra, 3D Geometry & Bayes Theorem Probability", q: "First Principle Derivatives, Dot/Cross Product & Conditional Probability" }
        ]}
      ]),
      createSubject("Biology", "BIO", "🧬", "#eb4d4b", [
        { name: "Unit 1: Plant Diversity & Cellular Genetics", chapters: [
          { num: 1, name: classLevel === 11 ? "The Living World & Biological Classification" : "Sexual Reproduction in Flowering Plants", q: "Taxonomic Hierarchy, Monera, Fungi & Double Fertilization Pollen" },
          { num: 2, name: classLevel === 11 ? "Plant Kingdom & Animal Kingdom" : "Human Reproduction & Reproductive Health", q: "Pteridophytes, Chordate Phyla, Spermatogenesis & Contraceptive Methods" },
          { num: 3, name: classLevel === 11 ? "Morphology, Anatomy of Plants & Biomolecules" : "Principles of Inheritance and Variation", q: "Xylem Anatomy, Enzymes, Mendel Monohybrid & Chromosomal Disorders" }
        ]},
        { name: "Unit 2: Physiology, Biotechnology & Ecology", chapters: [
          { num: 4, name: classLevel === 11 ? "Cell: The Unit of Life & Cell Cycle (Mitosis/Meiosis)" : "Molecular Basis of Inheritance (DNA & Genetic Code)", q: "Organelles, Crossing Over, DNA Replication & Lac Operon Regulation" },
          { num: 5, name: classLevel === 11 ? "Plant Physiology (Photosynthesis & Respiration)" : "Biotechnology: Principles, Processes & Applications", q: "Calvin Cycle, Glycolysis, Restriction Enzymes & Recombinant Insulin" },
          { num: 6, name: classLevel === 11 ? "Human Physiology (Digestion, Neural & Endocrine)" : "Organisms, Populations, Ecosystem & Biodiversity Conservation", q: "Synaptic Transmission, Pituitary Hormones & Ecological Trophic Levels" }
        ]}
      ]),
      createSubject("Computer Science", "CS", "💻", "#8854d0", [
        { name: "Unit 1: Computational Thinking, Python & Data Structures", chapters: [
          { num: 1, name: classLevel === 11 ? "Computer Systems Architecture & Boolean Logic" : "Python Functions, Scope & File Handling (Text/Binary/CSV)", q: "De Morgan Laws, Memory Hierarchy, Pickle Module & CSV DictReader" },
          { num: 2, name: classLevel === 11 ? "Python Programming: Control Structures, Loops & Strings" : "Data Structures: Linear Stack and Queue Implementation", q: "String Slicing, While/For Loops, Stack Push/Pop & LIFO Algorithm" },
          { num: 3, name: classLevel === 11 ? "Python Lists, Tuples & Dictionaries" : "Algorithmic Complexity & Recursion in Python", q: "Dictionary Keys, Tuple Immutability & Recursive Factorial" }
        ]},
        { name: "Unit 2: Networks, Relational SQL & Cyber Laws", chapters: [
          { num: 4, name: classLevel === 11 ? "Cyber Safety, Netiquette & Digital Footprints" : "Computer Networks: Topologies, OSI/TCP Layers & Web Protocols", q: "Phishing Prevention, Digital Traces, Routers, DNS & HTTPS Handshake" },
          { num: 5, name: classLevel === 11 ? "Introduction to Relational Databases & SQL Basics" : "Database Management: MySQL Joins, Aggregate Functions & Python Connector", q: "Primary Key, Table Creation, SQL GROUP BY & PyMySQL Commit" },
          { num: 6, name: classLevel === 11 ? "Society, Law and Ethics & IT Act 2000" : "Cyber Law, Open Source Licenses & Cyber Security Defences", q: "Copyright, Creative Commons, Firewalls & Indian IT Act Offences" }
        ]}
      ]),
      createSubject("Accountancy", "ACC", "📊", "#10ac84", [
        { name: "Unit 1: Accounting Framework & Partnership Accounts", chapters: [
          { num: 1, name: classLevel === 11 ? "Introduction to Accounting, GAAP & Dual Aspect Concept" : "Accounting for Partnership: Fundamentals & Goodwill Valuation", q: "Accounting Principles, Profit and Loss Appropriation & Super Profit Method" },
          { num: 2, name: classLevel === 11 ? "Recording Transactions: Journal, Ledger & Cash Book" : "Admission, Retirement and Death of a Partner", q: "Triple Column Cash Book, Revaluation Account & Gaining Ratio" },
          { num: 3, name: classLevel === 11 ? "Trial Balance, Bank Reconciliation Statement & Depreciation" : "Dissolution of Partnership Firm & Realisation Account", q: "BRS Overdraft Adjustments, Written Down Value & Realisation Entries" }
        ]},
        { name: "Unit 2: Corporate Accounts, Financial Statements & Analysis", chapters: [
          { num: 4, name: classLevel === 11 ? "Provisions, Reserves & Accounting for Bills of Exchange" : "Accounting for Share Capital: Issue, Forfeiture & Re-issue", q: "General Reserves, Discounting Bills & Calls-in-Arrears" },
          { num: 5, name: classLevel === 11 ? "Financial Statements of Sole Proprietorship (Trading & P&L)" : "Issue and Redemption of Debentures & Financial Statements", q: "Closing Entries, Balance Sheet Grouping & Debenture Redemption Reserve" },
          { num: 6, name: classLevel === 11 ? "Accounts from Incomplete Records (Single Entry System)" : "Financial Statement Analysis, Accounting Ratios & Cash Flow Statement", q: "Statement of Affairs, Current Ratio, Debt-Equity & Operating Cash Flow" }
        ]}
      ]),
      createSubject("Business Studies", "BST", "💼", "#ff9f43", [
        { name: "Unit 1: Business Foundations, Organisation & Management", chapters: [
          { num: 1, name: classLevel === 11 ? "Nature and Purpose of Business & Forms of Business Organisation" : "Nature and Significance of Management & Principles (Fayol/Taylor)", q: "Sole Proprietorship, Joint Hindu Family & Unity of Command" },
          { num: 2, name: classLevel === 11 ? "Public, Private Enterprises & Business Services (Banking/Insurance)" : "Business Environment, Planning & Organising", q: "Privatisation, Principles of Indemnity, Strategic Planning & Decentralisation" },
          { num: 3, name: classLevel === 11 ? "Emerging Modes of Business & Social Responsibility" : "Staffing, Directing & Controlling", q: "BPO, E-Commerce Models, Leadership Styles & Management by Exception" }
        ]},
        { name: "Unit 2: Corporate Finance, Marketing & Consumer Protection", chapters: [
          { num: 4, name: classLevel === 11 ? "Sources of Business Finance (Equity, Debentures, Retained Earnings)" : "Financial Management & Capital Structure", q: "Cost of Capital, Working Capital Factors & Leverage" },
          { num: 5, name: classLevel === 11 ? "Small Business, Enterprises & Internal Trade (Wholesale/Retail)" : "Financial Markets (Capital Market, Money Market & SEBI)", q: "MSME Definitions, Departmental Stores, Treasury Bills & SEBI Regulations" },
          { num: 6, name: classLevel === 11 ? "International Trade (Export/Import Procedures & WTO)" : "Marketing Management (4Ps) & Consumer Protection Act 2019", q: "Letter of Credit, Bill of Lading, Product Mix & Redressal Commissions" }
        ]}
      ]),
      createSubject("Economics", "ECO", "📈", "#5f27cd", [
        { name: "Unit 1: Microeconomic Foundations & National Income", chapters: [
          { num: 1, name: classLevel === 11 ? "Statistics for Economics: Collection, Organisation & Presentation" : "National Income Accounting: GDP, GNP, NNP & Real vs Nominal", q: "Primary Data, Frequency Tables, Value Added & Expenditure Method" },
          { num: 2, name: classLevel === 11 ? "Measures of Central Tendency: Mean, Median and Mode" : "Money and Banking: Credit Creation by Commercial Banks & RBI Policy", q: "Step-Deviation Formula, Statutory Liquidity Ratio & Repo Rate" },
          { num: 3, name: classLevel === 11 ? "Consumer Equilibrium, Demand & Elasticity of Demand" : "Determination of Income, Employment & Keynesian Investment Multiplier", q: "Indifference Curves, Price Elasticity Percentage & Aggregate Demand" }
        ]},
        { name: "Unit 2: Producer Behaviour, Government Budget & Indian Reforms", chapters: [
          { num: 4, name: classLevel === 11 ? "Production Function, Cost Curves & Revenue Analysis" : "Government Budget and the Economy (Fiscal/Revenue Deficits)", q: "Law of Variable Proportions, Marginal Cost, Capital Budget & Direct Taxes" },
          { num: 5, name: classLevel === 11 ? "Producer Equilibrium & Market Forms (Perfect Competition)" : "Balance of Payments, Foreign Exchange Rate & Current Account", q: "MR = MC Condition, Free Entry/Exit, Flexible Exchange & Capital Account" },
          { num: 6, name: classLevel === 11 ? "Correlation, Index Numbers & Measures of Dispersion" : "Indian Economic Development: 1991 LPG Reforms, Poverty & NITI Aayog", q: "Karl Pearson Coefficient, CPI Inflation, Globalisation & Rural Credit" }
        ]}
      ]),
      createSubject("Informatics Practices", "IP", "🖥️", "#0abde3", [
        { name: "Unit 1: Python Data Science, Pandas & Matplotlib", chapters: [
          { num: 1, name: classLevel === 11 ? "Computer Systems, Python Basics & Data Types" : "Data Handling using Pandas - I: Series and DataFrames", q: "Python Syntax, Boolean Logic, Pandas loc/iloc & Column Slicing" },
          { num: 2, name: classLevel === 11 ? "Python Lists, Dictionaries & String Operations" : "Data Handling using Pandas - II: Descriptive Stats & CSV Export", q: "Dictionary Access, DataFrame describe(), dropna() & to_csv()" },
          { num: 3, name: classLevel === 11 ? "Introduction to Relational Databases & SQL Syntax" : "Data Visualization using Pyplot: Line, Bar & Histograms", q: "SQL SELECT, WHERE, Matplotlib plt.plot() & Custom Chart Titles" }
        ]},
        { name: "Unit 2: Advanced SQL, Web Networks & Cyber Safety", chapters: [
          { num: 4, name: classLevel === 11 ? "SQL Data Manipulation & Integrity Constraints" : "Database Query using SQL: Math, String & Date Functions", q: "Primary Key, Foreign Key, SQL ROUND(), SUBSTR() & NOW()" },
          { num: 5, name: classLevel === 11 ? "Cyber Safety, Identity Theft & Netiquette" : "SQL Aggregate Functions, GROUP BY, HAVING & ORDER BY", q: "Strong Passwords, Phishing, COUNT(), SUM() & Group Filtering" },
          { num: 6, name: classLevel === 11 ? "Societal Impacts, Digital Footprints & E-Waste Management" : "Introduction to Computer Networks, Web Security & IT Laws", q: "Carbon Footprint, E-Waste Recycling, Cookies, HTTPS & Cyber Law" }
        ]}
      ]),
      createSubject("Business Mathematics", "BM", "🧮", "#ee5253", [
        { name: "Unit 1: Business Algebra, Interest & Calculus Applications", chapters: [
          { num: 1, name: classLevel === 11 ? "Logarithms, Indices & Commercial Arithmetic" : "Matrices, Determinants & Input-Output Leontief Model", q: "Logarithm Rules, Compound Interest, Adjoint Matrix & Economy Equilibrium" },
          { num: 2, name: classLevel === 11 ? "Sets, Relations, Functions & Permutations" : "Differential Calculus in Business: Marginal Cost & Revenue", q: "Domain/Range, Combinatorics, Profit Maximisation & Elasticity" },
          { num: 3, name: classLevel === 11 ? "Commercial Algebra: Annuities, Sinking Fund & Perpetuity" : "Integral Calculus in Business: Consumer and Producer Surplus", q: "Present Value Annuity, Sinking Fund & Definite Integral Applications" }
        ]},
        { name: "Unit 2: Linear Programming, Probability & Forecasting", chapters: [
          { num: 4, name: classLevel === 11 ? "Analytical Geometry (Lines, Intercepts & Cost Lines)" : "Linear Programming Problems (LPP): Graphical Optimization", q: "Slope-Intercept Cost Line, Feasible Region & Corner Point Theorem" },
          { num: 5, name: classLevel === 11 ? "Differential Calculus Basics & Business Curves" : "Probability Distributions: Binomial, Poisson & Normal Curves", q: "Rate of Change, Tangent Slopes, Standard Normal z-Score & Bell Curve" },
          { num: 6, name: classLevel === 11 ? "Descriptive Statistics, Moving Averages & Trend Lines" : "Transportation and Assignment Problems (Operations Research)", q: "Time Series Secular Trend, North-West Corner & Hungarian Method" }
        ]}
      ]),
      createSubject("History", "HIST", "🏛️", "#c8d6e5", [
        { name: "Unit 1: Early Civilizations, Archaeology & Ancient Empires", chapters: [
          { num: 1, name: classLevel === 11 ? "From the Beginning of Time & Early Mesopotamian Cities" : "Bricks, Beads and Bones (Harappan Archaeology & Town Planning)", q: "Hominid Evolution, Cuneiform Script, Harappan Seals & Drainage Systems" },
          { num: 2, name: classLevel === 11 ? "An Empire Across Three Continents (Roman Empire)" : "Kings, Farmers and Towns (Early States, Inscriptions & Ashoka)", q: "Pax Romana, Senate, Epigraphy, Mauryan Administration & Brahmi Script" },
          { num: 3, name: classLevel === 11 ? "Nomadic Empires & The Mongol State (Genghis Khan)" : "Kinship, Caste and Class & Thinkers, Beliefs and Buildings", q: "Yasa Law Code, Mahabharata Kinship, Early Buddhism & Sanchi Stupa" }
        ]},
        { name: "Unit 2: Medieval Transformation, Imperial Regimes & Independence", chapters: [
          { num: 4, name: classLevel === 11 ? "The Three Orders: Feudal Society in Western Europe" : "An Imperial Capital: Vijayanagara (Hampi Architecture)", q: "Clergy, Nobility, Peasants, Krishnadevaraya & Virupaksha Temple" },
          { num: 5, name: classLevel === 11 ? "Changing Cultural Traditions & Scientific Revolution" : "Colonialism and the Countryside & 1857 Revolt in Northern India", q: "Renaissance Humanism, Galileo, Permanent Settlement & Rebel Proclamations" },
          { num: 6, name: classLevel === 11 ? "Paths to Modernisation (Japan, China & Industrial Revolution)" : "Mahatma Gandhi and the Nationalist Movement & Framing the Constitution", q: "Meiji Restoration, Long March, Salt Satyagraha & Constituent Assembly Debates" }
        ]}
      ])
    ]
  }))
];

console.log('Successfully structured complete CBSE Curricula for Classes 4 to 12.');
`;

fs.writeFileSync(path.join(__dirname, 'generate_comprehensive_curriculum.js'), generatorScript);
console.log('Created generate_comprehensive_curriculum.js');
