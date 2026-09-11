const fs = require('fs');
const path = require('path');

// Complete authentic curriculum for RPSIT School (CBSE & Tamil Nadu State Board, Classes 4 to 12)
const cbseCurriculum = [
  // Class 4: English, Mathematics, EVS
  {
    board: "CBSE", classLevel: 4,
    subjects: [
      { name: "English", code: "ENG", icon: "📖", color: "#fa8231", units: [
        { name: "Unit 1: Stories & Fun", chapters: [
          { num: 1, name: "Neha's Alarm Clock", q: "Reading Comprehension & Nouns" },
          { num: 2, name: "The Little Fir Tree", q: "Adjectives & Opposites" }
        ]},
        { name: "Unit 2: Poetry & Rhymes", chapters: [
          { num: 3, name: "Nasruddin's Aim", q: "Verbs & Action Words" },
          { num: 4, name: "Alice in Wonderland", q: "Sentences & Pronouns" }
        ]}
      ]},
      { name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4", units: [
        { name: "Unit 1: Geometry & Measurement", chapters: [
          { num: 1, name: "Building with Bricks", q: "2D & 3D Shapes" },
          { num: 2, name: "Long and Short", q: "Length & Metres" }
        ]},
        { name: "Unit 2: Numbers & Time", chapters: [
          { num: 3, name: "A Trip to Bhopal", q: "Word Problems & Money" },
          { num: 4, name: "Tick-Tick-Tick", q: "Clocks & Time Reading" }
        ]}
      ]},
      { name: "EVS", code: "EVS", icon: "🌿", color: "#20bf6b", units: [
        { name: "Unit 1: Animals & Travel", chapters: [
          { num: 1, name: "Going to School", q: "Bridges & Transport" },
          { num: 2, name: "A Day with Nandu", q: "Elephants & Herds" }
        ]},
        { name: "Unit 2: Nature & Society", chapters: [
          { num: 3, name: "The Story of Amrita", q: "Trees & Khejadi Village" },
          { num: 4, name: "Anita and the Honeybees", q: "Beekeeping & Hard Work" }
        ]}
      ]}
    ]
  },

  // Class 5: English, Mathematics, EVS
  {
    board: "CBSE", classLevel: 5,
    subjects: [
      { name: "English", code: "ENG", icon: "📖", color: "#fa8231", units: [
        { name: "Unit 1: Tales & Magic", chapters: [
          { num: 1, name: "Wonderful Waste!", q: "Culinary Heritage & Verbs" },
          { num: 2, name: "Flying Together", q: "Teamwork & Prepositions" }
        ]},
        { name: "Unit 2: Adventure & Explorations", chapters: [
          { num: 3, name: "Robinson Crusoe Discovers a Footprint", q: "Adventure & Adjectives" },
          { num: 4, name: "Rip Van Winkle", q: "Time & Character Traits" }
        ]}
      ]},
      { name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4", units: [
        { name: "Unit 1: Numbers & Angles", chapters: [
          { num: 1, name: "The Fish Tale", q: "Large Numbers & Speed" },
          { num: 2, name: "Shapes and Angles", q: "Acute, Right & Obtuse Angles" }
        ]},
        { name: "Unit 2: Fractions & Patterns", chapters: [
          { num: 3, name: "How Many Squares?", q: "Perimeter & Grid Area" },
          { num: 4, name: "Parts and Wholes", q: "Fractions & Equivalent Fractions" }
        ]}
      ]},
      { name: "EVS", code: "EVS", icon: "🌿", color: "#20bf6b", units: [
        { name: "Unit 1: Senses & Digestion", chapters: [
          { num: 1, name: "Super Senses", q: "Animal Vision, Smell & Hearing" },
          { num: 2, name: "From Tasting to Digesting", q: "Tongue, Tastebuds & Stomach" }
        ]},
        { name: "Unit 2: Earth & Conservation", chapters: [
          { num: 3, name: "Seeds and Seeds", q: "Germination & Seed Dispersal" },
          { num: 4, name: "Every Drop Counts", q: "Lakes, Stepwells & Rainwater" }
        ]}
      ]}
    ]
  },

  // Class 6: English, Mathematics, Science, Social Science
  {
    board: "CBSE", classLevel: 6,
    subjects: [
      { name: "English", code: "ENG", icon: "📖", color: "#fa8231", units: [
        { name: "Unit 1: Prose & Discovery", chapters: [
          { num: 1, name: "Who Did Patrick's Homework?", q: "Sentences & Self-Reliance" },
          { num: 2, name: "How the Dog Found Himself a New Master!", q: "Animal Domestication" }
        ]},
        { name: "Unit 2: Courage & Generosity", chapters: [
          { num: 3, name: "Taro's Reward", q: "Filial Duty & Moral Stories" },
          { num: 4, name: "An Indian - American Woman in Space: Kalpana Chawla", q: "Space Science & Biography" }
        ]}
      ]},
      { name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4", units: [
        { name: "Unit 1: Numbers & Integers", chapters: [
          { num: 1, name: "Knowing Our Numbers", q: "Place Value, Commas & Estimation" },
          { num: 2, name: "Whole Numbers & Integers", q: "Number Line & Negative Numbers" }
        ]},
        { name: "Unit 2: Fractions & Geometry", chapters: [
          { num: 3, name: "Playing with Numbers & Fractions", q: "Prime Numbers, LCM & HCF" },
          { num: 4, name: "Basic Geometrical Ideas & Mensuration", q: "Points, Lines, Polygons & Area" }
        ]}
      ]},
      { name: "Science", code: "SCI", icon: "🔬", color: "#20bf6b", units: [
        { name: "Unit 1: Food & Materials", chapters: [
          { num: 1, name: "Components of Food", q: "Nutrients, Vitamins & Balanced Diet" },
          { num: 2, name: "Sorting Materials & Separation of Substances", q: "Solubility, Filtration & Decantation" }
        ]},
        { name: "Unit 2: Living World & Motion", chapters: [
          { num: 3, name: "Getting to Know Plants & Body Movements", q: "Herbs, Shrubs, Trees & Joints" },
          { num: 4, name: "Motion, Light, Electricity & Circuits", q: "Measurement, Optics & Simple Circuits" }
        ]}
      ]},
      { name: "Social Science", code: "SOC", icon: "🌍", color: "#eb4d4b", units: [
        { name: "Unit 1: History & Geography", chapters: [
          { num: 1, name: "What, Where, How and When? & Earliest Cities", q: "Harappan Civilization & Archaeology" },
          { num: 2, name: "The Earth in the Solar System & Globe", q: "Planets, Latitudes & Longitudes" }
        ]},
        { name: "Unit 2: Civics & Governance", chapters: [
          { num: 3, name: "Understanding Diversity & Discrimination", q: "Unity in Diversity & Equality" },
          { num: 4, name: "What is Government? & Panchayati Raj", q: "Democracy & Local Self-Government" }
        ]}
      ]}
    ]
  },

  // Class 7: English, Mathematics, Science, Social Science
  {
    board: "CBSE", classLevel: 7,
    subjects: [
      { name: "English", code: "ENG", icon: "📖", color: "#fa8231", units: [
        { name: "Unit 1: Wisdom & Compassion", chapters: [
          { num: 1, name: "Three Questions (Leo Tolstoy)", q: "Wisdom, Time & Good Deeds" },
          { num: 2, name: "A Gift of Chappals", q: "Kindness to Animals & Elders" }
        ]},
        { name: "Unit 2: Wit & Courage", chapters: [
          { num: 3, name: "Gopal and the Hilsa-Fish", q: "Wit, Intelligence & Humour" },
          { num: 4, name: "Quality (John Galsworthy)", q: "Artisanship & Dedication" }
        ]}
      ]},
      { name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4", units: [
        { name: "Unit 1: Integers & Fractions", chapters: [
          { num: 1, name: "Integers & Rational Numbers", q: "Properties of Integers & Signs" },
          { num: 2, name: "Fractions, Decimals & Simple Equations", q: "Fraction Multiplication & Linear Equations" }
        ]},
        { name: "Unit 2: Geometry & Mensuration", chapters: [
          { num: 3, name: "Lines and Angles & The Triangle and Its Properties", q: "Parallel Lines, Transversals & Pythagoras" },
          { num: 4, name: "Comparing Quantities & Perimeter and Area", q: "Percentages, Profit/Loss & Area Formulas" }
        ]}
      ]},
      { name: "Science", code: "SCI", icon: "🔬", color: "#20bf6b", units: [
        { name: "Unit 1: Living Systems & Chemistry", chapters: [
          { num: 1, name: "Nutrition in Plants & Animals", q: "Autotrophic, Heterotrophic & Digestive Track" },
          { num: 2, name: "Acids, Bases, Salts & Physical/Chemical Changes", q: "Litmus Indicators & Neutralisation" }
        ]},
        { name: "Unit 2: Physics & Respiration", chapters: [
          { num: 3, name: "Heat & Respiration in Organisms", q: "Conduction, Convection & Cellular Breathing" },
          { num: 4, name: "Transportation in Animals & Light/Electricity", q: "Circulation, Reflection & Electromagnets" }
        ]}
      ]},
      { name: "Social Science", code: "SOC", icon: "🌍", color: "#eb4d4b", units: [
        { name: "Unit 1: Medieval India & Environment", chapters: [
          { num: 1, name: "Tracing Changes Through a Thousand Years & Delhi Sultans", q: "Medieval Dynasties & Administration" },
          { num: 2, name: "Environment, Inside Our Earth & Air/Water", q: "Earth Layers, Atmosphere & Water Cycle" }
        ]},
        { name: "Unit 2: Governance & Equality", chapters: [
          { num: 3, name: "On Equality & Role of the Government in Health", q: "Constitutional Equality & Public Health" },
          { num: 4, name: "How the State Government Works & Markets Around Us", q: "MLAs, Cabinet & Wholesale/Retail" }
        ]}
      ]}
    ]
  },

  // Class 8: English, Mathematics, Science, Social Science
  {
    board: "CBSE", classLevel: 8,
    subjects: [
      { name: "English", code: "ENG", icon: "📖", color: "#fa8231", units: [
        { name: "Unit 1: History & Humanity", chapters: [
          { num: 1, name: "The Best Christmas Present in the World", q: "WWI Truce, Letters & Compassion" },
          { num: 2, name: "The Tsunami & Geography Lesson", q: "Natural Disasters & Geography Poems" }
        ]},
        { name: "Unit 2: Struggle & Self-Discovery", chapters: [
          { num: 3, name: "Glimpses of the Past", q: "1857 Freedom Struggle & Reformers" },
          { num: 4, name: "The Summit Within (Major H.P.S. Ahluwalia)", q: "Mount Everest Expedition & Determination" }
        ]}
      ]},
      { name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4", units: [
        { name: "Unit 1: Algebra & Roots", chapters: [
          { num: 1, name: "Rational Numbers & Linear Equations in One Variable", q: "Algebraic Simplification" },
          { num: 2, name: "Squares and Square Roots & Cubes", q: "Prime Factorisation & Long Division Root" }
        ]},
        { name: "Unit 2: Geometry & Mensuration", chapters: [
          { num: 3, name: "Understanding Quadrilaterals & Data Handling", q: "Convex Polygons, Parallelograms & Pie Charts" },
          { num: 4, name: "Algebraic Expressions, Mensuration & Exponents", q: "Identities, Surface Area, Volume & Powers" }
        ]}
      ]},
      { name: "Science", code: "SCI", icon: "🔬", color: "#20bf6b", units: [
        { name: "Unit 1: Agriculture & Microbes", chapters: [
          { num: 1, name: "Crop Production and Management", q: "Sowing, Irrigation, Manure & Harvesting" },
          { num: 2, name: "Microorganisms: Friend and Foe", q: "Fermentation, Antibiotics & Pathogens" }
        ]},
        { name: "Unit 2: Chemistry & Mechanics", chapters: [
          { num: 3, name: "Coal and Petroleum & Combustion and Flame", q: "Fossil Fuels, Refining & Ignition Temp" },
          { num: 4, name: "Force and Pressure, Friction & Sound", q: "Newton Forces, Friction Types & Acoustics" }
        ]}
      ]},
      { name: "Social Science", code: "SOC", icon: "🌍", color: "#eb4d4b", units: [
        { name: "Unit 1: Modern History & Geography", chapters: [
          { num: 1, name: "From Trade to Territory & When People Rebel (1857)", q: "East India Company & Great Rebellion" },
          { num: 2, name: "Resources, Land, Soil, Water & Agriculture", q: "Natural Resources & Farming Systems" }
        ]},
        { name: "Unit 2: Constitution & Justice", chapters: [
          { num: 3, name: "The Indian Constitution & Secularism", q: "Fundamental Rights & Secular Ethos" },
          { num: 4, name: "Parliament, Judiciary & Social Justice", q: "Lok Sabha, Supreme Court & Marginalisation" }
        ]}
      ]}
    ]
  },

  // Class 9: English (Language), Mathematics, Science, Social Science
  {
    board: "CBSE", classLevel: 9,
    subjects: [
      { name: "English", code: "ENG", icon: "📖", color: "#fa8231", units: [
        { name: "Unit 1: Literature & Reflection", chapters: [
          { num: 1, name: "The Fun They Had (Isaac Asimov)", q: "Future Schools, AI & Technology" },
          { num: 2, name: "The Sound of Music (Evelyn Glennie & Bismillah Khan)", q: "Perseverance & Classical Shehnai" }
        ]},
        { name: "Unit 2: Great Minds & Courage", chapters: [
          { num: 3, name: "A Truly Beautiful Mind (Albert Einstein)", q: "Theory of Relativity & World Peace" },
          { num: 4, name: "My Childhood (Dr. A.P.J. Abdul Kalam)", q: "Values, Teachers & Science Journey" }
        ]}
      ]},
      { name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4", units: [
        { name: "Unit 1: Number Systems & Algebra", chapters: [
          { num: 1, name: "Number Systems & Polynomials", q: "Irrational Numbers, Remainder & Factor Theorem" },
          { num: 2, name: "Linear Equations in Two Variables & Coordinate Geometry", q: "Cartesian Plane & Graphing Lines" }
        ]},
        { name: "Unit 2: Geometry & Mensuration", chapters: [
          { num: 3, name: "Lines and Angles, Triangles & Quadrilaterals", q: "Congruence Criteria & Angle Sum" },
          { num: 4, name: "Heron's Formula, Surface Areas and Volumes & Statistics", q: "Triangle Area, 3D Solids & Mean" }
        ]}
      ]},
      { name: "Science", code: "SCI", icon: "🔬", color: "#20bf6b", units: [
        { name: "Unit 1: Matter & Living Cell", chapters: [
          { num: 1, name: "Matter in Our Surroundings & Atoms and Molecules", q: "States of Matter, Mole Concept & Valency" },
          { num: 2, name: "The Fundamental Unit of Life & Tissues", q: "Cell Organelles, Mitosis & Meristems" }
        ]},
        { name: "Unit 2: Motion, Force & Energy", chapters: [
          { num: 3, name: "Motion, Force and Laws of Motion", q: "Velocity-Time Graphs & Newton's 3 Laws" },
          { num: 4, name: "Gravitation, Work and Energy & Sound", q: "Universal Law, Kinetic Energy & Ultrasound" }
        ]}
      ]},
      { name: "Social Science", code: "SOC", icon: "🌍", color: "#eb4d4b", units: [
        { name: "Unit 1: World History & Physical Geography", chapters: [
          { num: 1, name: "The French Revolution & Socialism in Europe", q: "Bastille, Jacobins & Russian Revolution" },
          { num: 2, name: "India - Size and Location & Physical Features of India", q: "Himalayas, Peninsular Plateau & Coastal Plains" }
        ]},
        { name: "Unit 2: Democratic Politics & Economics", chapters: [
          { num: 3, name: "What is Democracy? & Constitutional Design", q: "Preamble, Assembly & Democratic Values" },
          { num: 4, name: "The Story of Village Palampur & Poverty as a Challenge", q: "Production Factors & Poverty Line" }
        ]}
      ]}
    ]
  },

  // Class 10: English (Language), Mathematics, Science, Social Science
  {
    board: "CBSE", classLevel: 10,
    subjects: [
      { name: "English", code: "ENG", icon: "📖", color: "#fa8231", units: [
        { name: "Unit 1: Faith & Freedom", chapters: [
          { num: 1, name: "A Letter to God (G.L. Fuentes)", q: "Faith, Lencho & Postmaster" },
          { num: 2, name: "Nelson Mandela: Long Walk to Freedom", q: "Apartheid, Inviolable Freedom & Courage" }
        ]},
        { name: "Unit 2: Bravery & Human Spirit", chapters: [
          { num: 3, name: "Two Stories about Flying (His First Flight & Black Aeroplane)", q: "Overcoming Fear & Mysterious Pilot" },
          { num: 4, name: "From the Diary of Anne Frank", q: "Holocaust, Kitty & Teen Resilience" }
        ]}
      ]},
      { name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4", units: [
        { name: "Unit 1: Real Numbers, Algebra & Trigonometry", chapters: [
          { num: 1, name: "Real Numbers, Polynomials & Pair of Linear Equations", q: "Fundamental Theorem, Zeroes & Elimination" },
          { num: 2, name: "Quadratic Equations, Arithmetic Progressions & Trigonometry", q: "Quadratic Formula, nth Term & Trig Ratios" }
        ]},
        { name: "Unit 2: Geometry & Applied Math", chapters: [
          { num: 3, name: "Triangles (Similarity), Coordinate Geometry & Circles", q: "Thales Theorem, Section Formula & Tangents" },
          { num: 4, name: "Surface Areas and Volumes, Statistics & Probability", q: "Combined Solids, Median, Mode & Odds" }
        ]}
      ]},
      { name: "Science", code: "SCI", icon: "🔬", color: "#20bf6b", units: [
        { name: "Unit 1: Chemical Reactions & Life Processes", chapters: [
          { num: 1, name: "Chemical Reactions and Equations, Acids, Bases & Metals", q: "Balancing Equations, pH & Reactivity Series" },
          { num: 2, name: "Life Processes & Control and Coordination", q: "Nutrition, Respiration, Heart & Hormones" }
        ]},
        { name: "Unit 2: Optics, Electricity & Genetics", chapters: [
          { num: 3, name: "Light - Reflection and Refraction & The Human Eye", q: "Mirror/Lens Formulas, Power & Dispersion" },
          { num: 4, name: "Electricity, Magnetic Effects & Heredity", q: "Ohm's Law, Joule's Heating & Mendel Monohybrid" }
        ]}
      ]},
      { name: "Social Science", code: "SOC", icon: "🌍", color: "#eb4d4b", units: [
        { name: "Unit 1: Nationalism & Resource Development", chapters: [
          { num: 1, name: "The Rise of Nationalism in Europe & Nationalism in India", q: "Satyagraha, Non-Cooperation & Civil Disobedience" },
          { num: 2, name: "Resources and Development, Agriculture & Manufacturing", q: "Soil Types, Cropping Seasons & Heavy Industries" }
        ]},
        { name: "Unit 2: Democracy, Money & Globalisation", chapters: [
          { num: 3, name: "Power Sharing, Federalism & Political Parties", q: "Belgium/Sri Lanka Model, Union List & Parties" },
          { num: 4, name: "Development, Money and Credit & Globalisation", q: "HDI, Formal Credit, RBI & WTO Integration" }
        ]}
      ]}
    ]
  },

  // Class 11 & 12 CBSE (All subjects needed for the 7 CBSE groups)
  ...[11, 12].map(classLevel => ({
    board: "CBSE", classLevel,
    subjects: [
      { name: "English", code: "ENG", icon: "📖", color: "#fa8231", units: [
        { name: "Unit 1: Advanced Literature & Reading", chapters: [
          { num: 1, name: classLevel === 11 ? "The Portrait of a Lady & We're Not Afraid to Die" : "The Last Lesson & Lost Spring", q: "Literary Analysis & Themes" },
          { num: 2, name: classLevel === 11 ? "Discovering Tut: The Saga Continues & Poetry" : "Deep Water & The Rattrap", q: "Historical Investigation & Prose" }
        ]},
        { name: "Unit 2: Writing & Rhetoric", chapters: [
          { num: 3, name: classLevel === 11 ? "The Voice of the Rain & The Ailing Planet" : "Indigo & Poets and Pancakes", q: "Environmental & Historical Texts" },
          { num: 4, name: classLevel === 11 ? "Advanced Speech & Debate Writing" : "The Interview & Going Places", q: "Article & Report Writing" }
        ]}
      ]},
      { name: "Physics", code: "PHY", icon: "⚡", color: "#3867d6", units: [
        { name: "Unit 1: Core Physical Principles", chapters: [
          { num: 1, name: classLevel === 11 ? "Units, Measurements & Motion in a Straight Line / Plane" : "Electric Charges, Fields & Electrostatic Potential", q: "Vectors, Kinematics & Coulomb Law" },
          { num: 2, name: classLevel === 11 ? "Laws of Motion & Work, Energy and Power" : "Current Electricity & Moving Charges/Magnetism", q: "Newtonian Mechanics & Kirchhoff/Biot-Savart" }
        ]},
        { name: "Unit 2: Dynamics, Fields & Waves", chapters: [
          { num: 3, name: classLevel === 11 ? "Rotational Motion, Gravitation & Solids/Fluids" : "Electromagnetic Induction, AC & Electromagnetic Waves", q: "Moment of Inertia, Gravity & Faraday Law" },
          { num: 4, name: classLevel === 11 ? "Thermodynamics, Kinetic Theory & Oscillations/Waves" : "Ray/Wave Optics, Dual Nature, Atoms & Semiconductors", q: "Heat Engines, SHM, Optics & Logic Diodes" }
        ]}
      ]},
      { name: "Chemistry", code: "CHEM", icon: "🧪", color: "#20bf6b", units: [
        { name: "Unit 1: Physical & Inorganic Foundations", chapters: [
          { num: 1, name: classLevel === 11 ? "Basic Concepts of Chemistry & Structure of Atom" : "Solutions & Electrochemistry", q: "Mole Concept, Quantum Numbers & Nernst Eq" },
          { num: 2, name: classLevel === 11 ? "Classification of Elements & Chemical Bonding" : "Chemical Kinetics & d- and f-Block Elements", q: "VSEPR, Hybridization & Rate Laws" }
        ]},
        { name: "Unit 2: Equilibrium, Organic & Biomolecules", chapters: [
          { num: 3, name: classLevel === 11 ? "Thermodynamics, Equilibrium & Redox Reactions" : "Coordination Compounds & Haloalkanes/Haloarenes", q: "Gibbs Energy, Le Chatelier & SN1/SN2" },
          { num: 4, name: classLevel === 11 ? "Organic Chemistry: Basic Principles & Hydrocarbons" : "Alcohols, Aldehydes, Ketones, Amines & Biomolecules", q: "IUPAC, Mechanisms & Amino Acids" }
        ]}
      ]},
      { name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4", units: [
        { name: "Unit 1: Sets, Algebra & Vectors", chapters: [
          { num: 1, name: classLevel === 11 ? "Sets, Relations and Functions & Trigonometric Functions" : "Relations and Functions, Inverse Trig & Matrices", q: "Functions, Trig Formulas & Matrix Inverse" },
          { num: 2, name: classLevel === 11 ? "Complex Numbers, Linear Inequalities & Permutations" : "Determinants, Continuity and Differentiability", q: "Combinatorics & Chain Rule" }
        ]},
        { name: "Unit 2: Calculus, Vectors & Probability", chapters: [
          { num: 3, name: classLevel === 11 ? "Binomial Theorem, Sequences and Series & Straight Lines" : "Applications of Derivatives & Integrals (Indefinite/Definite)", q: "AP/GP, Conic Sections & Integration Methods" },
          { num: 4, name: classLevel === 11 ? "Limits and Derivatives & Probability/Statistics" : "Differential Equations, Vectors, 3D Geometry & Probability", q: "Calculus Limits & Bayes Theorem" }
        ]}
      ]},
      { name: "Biology", code: "BIO", icon: "🧬", color: "#eb4d4b", units: [
        { name: "Unit 1: Cellular & Reproductive Biology", chapters: [
          { num: 1, name: classLevel === 11 ? "The Living World, Biological Classification & Plant/Animal Kingdom" : "Sexual Reproduction in Flowering Plants & Human Reproduction", q: "Taxonomy, Gametogenesis & Embryo" },
          { num: 2, name: classLevel === 11 ? "Morphology, Anatomy of Flowering Plants & Biomolecules" : "Reproductive Health & Principles of Inheritance and Variation", q: "Plant Tissues & Mendelian Genetics" }
        ]},
        { name: "Unit 2: Physiology, Biotech & Ecology", chapters: [
          { num: 3, name: classLevel === 11 ? "Cell: The Unit of Life, Cell Cycle & Plant Physiology" : "Molecular Basis of Inheritance & Human Health/Disease", q: "DNA Replication & Immune Responses" },
          { num: 4, name: classLevel === 11 ? "Human Physiology: Digestion, Respiration, Circulation & Neural" : "Biotechnology Principles, Applications & Ecology/Environment", q: "Homeostasis & Ecological Pyramids" }
        ]}
      ]},
      { name: "Computer Science", code: "CS", icon: "💻", color: "#8854d0", units: [
        { name: "Unit 1: Computational Thinking & Python", chapters: [
          { num: 1, name: classLevel === 11 ? "Computer System Overview, Boolean Logic & Python Basics" : "Python Revision, Functions & File Handling (Text/Binary/CSV)", q: "Boolean Logic & File Streams" },
          { num: 2, name: classLevel === 11 ? "Control Flow: If-Else, Loops, Strings, Lists & Tuples" : "Data Structures: Linear Stack and Operations", q: "Python Iteration & Stack LIFO" }
        ]},
        { name: "Unit 2: Networks, Databases & Cyber Ethics", chapters: [
          { num: 3, name: classLevel === 11 ? "Dictionaries in Python & Cyber Safety/Ethics" : "Computer Networks: Topologies, Protocols, Web Services & Security", q: "Data Dictionaries & TCP/IP Model" },
          { num: 4, name: classLevel === 11 ? "Society, Law and Ethics: Intellectual Property & IT Act" : "Database Management: Relational Data, SQL Queries & Python Connector", q: "SQL SELECT/JOIN & PyMySQL" }
        ]}
      ]},
      { name: "Accountancy", code: "ACC", icon: "📊", color: "#10ac84", units: [
        { name: "Unit 1: Financial Accounting Principles", chapters: [
          { num: 1, name: classLevel === 11 ? "Introduction to Accounting & Theory Base of Accounting" : "Accounting for Partnership: Fundamentals & Goodwill", q: "GAAP, Dual Aspect & Profit Sharing" },
          { num: 2, name: classLevel === 11 ? "Recording of Transactions: Journal, Ledger & Trial Balance" : "Reconstitution: Admission, Retirement and Death of Partner", q: "Debit/Credit Rules & Revaluation" }
        ]},
        { name: "Unit 2: Company Accounts & Analysis", chapters: [
          { num: 3, name: classLevel === 11 ? "Bank Reconciliation Statement, Depreciation & Provisions" : "Dissolution of Partnership & Share Capital Accounting", q: "BRS, Straight Line Dep & Share Forfeiture" },
          { num: 4, name: classLevel === 11 ? "Financial Statements of Sole Proprietorship (With Adjustments)" : "Accounting for Debentures, Financial Analysis & Cash Flow", q: "Balance Sheet & Cash Flow Statement" }
        ]}
      ]},
      { name: "Business Studies", code: "BST", icon: "💼", color: "#ff9f43", units: [
        { name: "Unit 1: Foundations of Business & Management", chapters: [
          { num: 1, name: classLevel === 11 ? "Nature and Purpose of Business & Forms of Business Organisation" : "Nature and Significance of Management & Principles of Management", q: "Sole Trader, Company & Fayol/Taylor" },
          { num: 2, name: classLevel === 11 ? "Public, Private Enterprises & Business Services (Banking/Insurance)" : "Business Environment, Planning & Organising", q: "LPG Policy & Organizational Structure" }
        ]},
        { name: "Unit 2: Finance, Marketing & Operations", chapters: [
          { num: 3, name: classLevel === 11 ? "Emerging Modes of Business, Social Responsibility & Ethics" : "Staffing, Directing & Controlling", q: "E-Commerce & Leadership/Motivation" },
          { num: 4, name: classLevel === 11 ? "Sources of Business Finance, Small Business & Internal/Intl Trade" : "Financial Management, Financial Markets, Marketing & Consumer Protection", q: "Capital Structure & Marketing 4Ps" }
        ]}
      ]},
      { name: "Economics", code: "ECO", icon: "📈", color: "#5f27cd", units: [
        { name: "Unit 1: Microeconomics & Development", chapters: [
          { num: 1, name: classLevel === 11 ? "Statistics for Economics: Introduction, Collection & Presentation" : "National Income and Related Aggregates & Money and Banking", q: "GDP, Central Bank & Sampling" },
          { num: 2, name: classLevel === 11 ? "Measures of Central Tendency: Mean, Median and Mode" : "Determination of Income and Employment (AD-AS Model)", q: "Statistical Average & Multiplier" }
        ]},
        { name: "Unit 2: Macroeconomics & Indian Economy", chapters: [
          { num: 3, name: classLevel === 11 ? "Microeconomics: Consumer Equilibrium, Demand & Elasticity" : "Government Budget and the Economy & Balance of Payments", q: "Utility, Law of Demand & Fiscal Deficit" },
          { num: 4, name: classLevel === 11 ? "Producer Behaviour, Supply & Forms of Market" : "Indian Economic Development: Reforms, Poverty, Human Capital & Rural Development", q: "Cost Curves, Perfect Competition & 1991 Reforms" }
        ]}
      ]},
      { name: "Informatics Practices", code: "IP", icon: "🖥️", color: "#0abde3", units: [
        { name: "Unit 1: Python Pandas & Data Analysis", chapters: [
          { num: 1, name: classLevel === 11 ? "Computer System, Python Basics & Data Handling" : "Data Handling using Pandas: Series and DataFrames", q: "Python Data & Pandas Indexing" },
          { num: 2, name: classLevel === 11 ? "Python Lists, Dictionaries & Introduction to Databases" : "Data Visualization using Pyplot: Line, Bar & Histograms", q: "Matplotlib Charts & Plots" }
        ]},
        { name: "Unit 2: SQL, Networks & Society", chapters: [
          { num: 3, name: classLevel === 11 ? "Structured Query Language (SQL) Data Definition and Manipulation" : "Database Query using SQL: Math, String, Date & Aggregate Functions", q: "SQL GROUP BY & HAVING" },
          { num: 4, name: classLevel === 11 ? "Cyber Safety, Digital Footprints, Malware & IT Laws" : "Introduction to Computer Networks & Societal Impacts", q: "Cyber Laws, Net Neutrality & OSI" }
        ]}
      ]},
      { name: "Business Mathematics", code: "BM", icon: "🧮", color: "#ee5253", units: [
        { name: "Unit 1: Commercial Math & Algebra", chapters: [
          { num: 1, name: classLevel === 11 ? "Numbers, Indices, Logarithms & Commercial Arithmetic" : "Matrices, Determinants & Business Applications", q: "Compound Interest & Matrix Systems" },
          { num: 2, name: classLevel === 11 ? "Sets, Relations, Functions & Permutations/Combinations" : "Differentiation, Marginal Cost & Revenue Optimization", q: "Maxima/Minima & Marginal Analysis" }
        ]},
        { name: "Unit 2: Financial Math & Linear Programming", chapters: [
          { num: 3, name: classLevel === 11 ? "Financial Mathematics: Annuities, Perpetuity & Sinking Funds" : "Integral Calculus in Business & Consumer/Producer Surplus", q: "Annuity Formulas & Definite Integrals" },
          { num: 4, name: classLevel === 11 ? "Linear Programming & Descriptive Statistics" : "Linear Programming Problems (LPP) & Probability Distributions", q: "Graphical LPP & Normal Distribution" }
        ]}
      ]},
      { name: "History", code: "HIST", icon: "🏛️", color: "#c8d6e5", units: [
        { name: "Unit 1: Early Civilizations & Empires", chapters: [
          { num: 1, name: classLevel === 11 ? "From the Beginning of Time & Early Cities in Mesopotamia" : "Bricks, Beads and Bones (Harappan Archaeology)", q: "Ancient Urbanization & Harappa" },
          { num: 2, name: classLevel === 11 ? "An Empire Across Three Continents (Roman Empire)" : "Kings, Farmers and Towns (Early States and Economies)", q: "Pax Romana & Mauryan Administration" }
        ]},
        { name: "Unit 2: Feudalism, Revolution & Modern World", chapters: [
          { num: 3, name: classLevel === 11 ? "Nomadic Empires & The Three Orders (Feudal Europe)" : "Kinship, Caste and Class & Thinkers, Beliefs and Buildings", q: "Buddhism, Stupas & Medieval Society" },
          { num: 4, name: classLevel === 11 ? "Changing Cultural Traditions & Paths to Modernisation" : "Mahatma Gandhi and the Nationalist Movement & Framing the Constitution", q: "Salt March & Constituent Assembly Debates" }
        ]}
      ]}
    ]
  }))
];

// Tamil Nadu State Board Curriculum (Classes 4 to 12)
const stateBoardCurriculum = [
  // Classes 4 to 10: Tamil, English, Mathematics, Science, Social Science
  ...[4, 5, 6, 7, 8, 9, 10].map(classLevel => ({
    board: "STATE_BOARD", classLevel,
    subjects: [
      { name: "Tamil", code: "TAM", icon: "📜", color: "#ff6b6b", units: [
        { name: "அலகு 1: தமிழ் இன்பம் மற்றும் செய்யுள்", chapters: [
          { num: 1, name: classLevel <= 5 ? "அன்னைத் தமிழே மற்றும் செய்யுள் நயம்" : "இன்பத்தமிழ் மற்றும் திருக்குறள்", q: "தமிழ் இலக்கியம் மற்றும் கவிதை" },
          { num: 2, name: classLevel <= 5 ? "பனைமரச் சிறப்பு மற்றும் உரைநடை" : "தமிழ்க்கும்மி மற்றும் உரைநடை உலகம்", q: "மரபுத் தமிழ் மற்றும் சொற்பொருள்" }
        ]},
        { name: "அலகு 2: உரைநடை மற்றும் இலக்கணம்", chapters: [
          { num: 3, name: classLevel <= 5 ? "ஏழு இறக்கைக் குருவியும் தெனாலிராமனும்" : "கனவு பலித்தது மற்றும் எழுத்து இலக்கணம்", q: "தமிழ் இலக்கணம் மற்றும் சொல்வளம்" },
          { num: 4, name: classLevel <= 5 ? "மூதுரை மற்றும் அடிப்படை இலக்கணம்" : "கண்மணியே கண்ணுறங்கு மற்றும் சொல் இலக்கணம்", q: "பொருளிலக்கணம் மற்றும் யாப்பு" }
        ]}
      ]},
      { name: "English", code: "ENG", icon: "📖", color: "#fa8231", units: [
        { name: "Unit 1: Prose & Moral Values", chapters: [
          { num: 1, name: "Sea Turtles & Reading Comprehension", q: "Marine Ecology & Grammar" },
          { num: 2, name: "When the Trees Walked (Ruskin Bond)", q: "Nature Stories & Adjectives" }
        ]},
        { name: "Unit 2: Poetry & Communication Skills", chapters: [
          { num: 3, name: "The Wooden Cup & Synonyms", q: "Family Values & Vocabulary" },
          { num: 4, name: "A Birthday Letter (Jawaharlal Nehru)", q: "Historical Letters & Syntax" }
        ]}
      ]},
      { name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4", units: [
        { name: "Unit 1: Numbers & Measurements", chapters: [
          { num: 1, name: classLevel <= 5 ? "Large Numbers, Addition & Subtraction" : "Number System, Real Numbers & Algebra", q: "Arithmetic & Set Operations" },
          { num: 2, name: classLevel <= 5 ? "Length, Weight & Capacity Units" : "Measurements, Perimeter and Area & Geometry", q: "Angles & Geometric Constructions" }
        ]},
        { name: "Unit 2: Geometry & Applied Math", chapters: [
          { num: 3, name: classLevel <= 5 ? "Shapes, Symmetry & Patterns" : "Direct and Inverse Proportion & Financial Math", q: "Profit/Loss & Percentages" },
          { num: 4, name: classLevel <= 5 ? "Time, Money & Simple Data Handling" : "Statistics, Graphs & Probability Basics", q: "Bar Graphs, Mean & Median" }
        ]}
      ]},
      { name: "Science", code: "SCI", icon: "🔬", color: "#20bf6b", units: [
        { name: "Unit 1: Biology & Materials", chapters: [
          { num: 1, name: classLevel <= 5 ? "My Body, Senses & Plant Life" : "Matter Around Us & Cell Biology", q: "Plant Anatomy & Cell Organelles" },
          { num: 2, name: classLevel <= 5 ? "Animals Around Us & Balanced Diet" : "Living World, Reproduction & Health/Hygiene", q: "Digestive System & Immunity" }
        ]},
        { name: "Unit 2: Physics & Environment", chapters: [
          { num: 3, name: classLevel <= 5 ? "Matter and Materials & Water Cycle" : "Heat, Light, Electricity & Magnetism", q: "Optics, Circuits & Magnetic Poles" },
          { num: 4, name: classLevel <= 5 ? "Air, Environment & Science in Everyday Life" : "Force, Motion, Sound & Environmental Science", q: "Newton Laws, Acoustics & Ecology" }
        ]}
      ]},
      { name: "Social Science", code: "SOC", icon: "🌍", color: "#eb4d4b", units: [
        { name: "Unit 1: History & Tamil Heritage", chapters: [
          { num: 1, name: classLevel <= 5 ? "Ancient Kingdoms of Tamilagam (Chera, Chola, Pandya)" : "Sources of Medieval India & Cholas/Pandyas", q: "Sangam Era & Temple Architecture" },
          { num: 2, name: classLevel <= 5 ? "Historical Places of Tamil Nadu & Mahabalipuram" : "Globe, Maps & Natural Resources of Tamil Nadu", q: "Geography & River Cauvery" }
        ]},
        { name: "Unit 2: Geography & Civics", chapters: [
          { num: 3, name: classLevel <= 5 ? "Rights and Duties & Local Governance" : "Equality, Democracy & State Government in Tamil Nadu", q: "Secretariat & Assembly" },
          { num: 4, name: classLevel <= 5 ? "Road Safety & Environmental Protection" : "Economics: Production, Tax & Tamil Nadu Economy", q: "Textile & Automobile Hubs" }
        ]}
      ]}
    ]
  })),

  // Classes 11 & 12 Tamil Nadu State Board (All 16 Subjects for the 7 State Board Groups)
  ...[11, 12].map(classLevel => ({
    board: "STATE_BOARD", classLevel,
    subjects: [
      { name: "Tamil", code: "TAM", icon: "📜", color: "#ff6b6b", units: [
        { name: "இயல் 1: நன்னூல், செய்யுள் மற்றும் உரைநடை", chapters: [
          { num: 1, name: classLevel === 11 ? "யுகத்தின் பாடல், நன்னூல் பாயிரம் & பேச்சுமொழியும் எழுத்துமொழியும்" : "இளந்தமிழே, பாரதி பாடல்கள் & தமிழ்மொழி நடை", q: "தமிழ் இலக்கிய நயம்" },
          { num: 2, name: classLevel === 11 ? "இயற்கை வேளாண்மை & திருக்குறள் அறத்துப்பால்" : "நற்றிணை, சிலப்பதிகாரம் & திருக்குறள் பொருட்பால்", q: "சங்க இலக்கியச் சிறப்புகள்" }
        ]},
        { name: "இயல் 2: படைப்பாற்றல் மற்றும் இலக்கணம்", chapters: [
          { num: 3, name: classLevel === 11 ? "காவியுடை தலைவன், தொல்காப்பியம் & அணி இலக்கணம்" : "கம்பராமாயணம், புறநானூறு & யாப்பிலக்கணம்", q: "தொல்காப்பிய இலக்கண விதிகள்" },
          { num: 4, name: classLevel === 11 ? "இதழியல் கலை, கலைச்சொல்லாக்கம் & மொழிபெயர்ப்பு" : "திரைமொழி, நவீன நாடகம் & மொழித்திறன் பயிற்சி", q: "கலைச்சொற்கள் & இலக்கணப்பயிற்சி" }
        ]}
      ]},
      { name: "English", code: "ENG", icon: "📖", color: "#fa8231", units: [
        { name: "Unit 1: Prose & Literary Appreciation", chapters: [
          { num: 1, name: classLevel === 11 ? "The Portrait of a Lady & Once Upon a Time (Poem)" : "Two Gentlemen of Verona (A.J. Cronin) & The Castle", q: "Character Analysis & Themes" },
          { num: 2, name: classLevel === 11 ? "The Queen of Boxing (Mary Kom) & Confessions of a Born Spectator" : "A Nice Cup of Tea (George Orwell) & Our Casuarina Tree", q: "Biographical Studies & Stylistics" }
        ]},
        { name: "Unit 2: Grammar, Vocabulary & Composition", chapters: [
          { num: 3, name: classLevel === 11 ? "Forgetting (Robert Lynd) & Lines Written in Early Spring" : "In Celebration of Being Alive (Dr. Christiaan Barnard)", q: "Advanced Vocabulary & Values" },
          { num: 4, name: classLevel === 11 ? "Tenses, Voice, Reported Speech & Error Spotting" : "The Rule of the Road & Formal Letter/Report Writing", q: "Syntax, Clauses & Formal Writing" }
        ]}
      ]},
      { name: "Physics", code: "PHY", icon: "⚡", color: "#3867d6", units: [
        { name: "Unit 1: Mechanics, Kinematics & Electrostatics", chapters: [
          { num: 1, name: classLevel === 11 ? "Nature of Physical World and Measurement & Kinematics" : "Electrostatics & Current Electricity", q: "Vectors, Projectiles & Coulomb Law" },
          { num: 2, name: classLevel === 11 ? "Laws of Motion & Work, Energy and Power" : "Magnetism and Magnetic Effects of Electric Current & EMI", q: "Newton Mechanics, Biot-Savart & AC" }
        ]},
        { name: "Unit 2: Matter, Waves, Optics & Modern Physics", chapters: [
          { num: 3, name: classLevel === 11 ? "System of Particles and Rotational Motion & Gravitation" : "Electromagnetic Waves, Ray Optics & Wave Optics", q: "Torque, Kepler Laws, Interference & Diffraction" },
          { num: 4, name: classLevel === 11 ? "Properties of Matter, Heat/Thermodynamics & Oscillations/Waves" : "Dual Nature of Radiation, Atomic Physics, Nuclear & Electronics", q: "Bernoulli, Carnot, Photoelectric & Transistors" }
        ]}
      ]},
      { name: "Chemistry", code: "CHEM", icon: "🧪", color: "#20bf6b", units: [
        { name: "Unit 1: Physical & Inorganic Chemistry", chapters: [
          { num: 1, name: classLevel === 11 ? "Basic Concepts of Chemistry and Chemical Calculations & Quantum Atomic Model" : "Metallurgy, p-Block Elements & Coordination Chemistry", q: "Stoichiometry, Quantum Numbers & Ligands" },
          { num: 2, name: classLevel === 11 ? "Periodic Classification & Gaseous State/Thermodynamics" : "Solid State, Chemical Kinetics & Electrochemistry", q: "Ideal Gas, Entropy & Nernst Equation" }
        ]},
        { name: "Unit 2: Equilibrium & Organic Chemistry", chapters: [
          { num: 3, name: classLevel === 11 ? "Physical and Chemical Equilibrium & Solutions/Chemical Bonding" : "Surface Chemistry, Hydroxy Compounds & Carbonyl Compounds", q: "Kp/Kc, Osmosis, VSEPR & Aldol Condensation" },
          { num: 4, name: classLevel === 11 ? "Fundamentals of Organic Chemistry & Hydrocarbons/Haloalkanes" : "Organic Nitrogen Compounds, Biomolecules & Chemistry in Everyday Life", q: "IUPAC, Markovnikov, Amines & Polymers" }
        ]}
      ]},
      { name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4", units: [
        { name: "Unit 1: Matrices, Algebra & Trigonometry", chapters: [
          { num: 1, name: classLevel === 11 ? "Sets, Relations and Functions & Basic Algebra" : "Applications of Matrices and Determinants & Complex Numbers", q: "Inverses, Rank & De Moivre Theorem" },
          { num: 2, name: classLevel === 11 ? "Trigonometry & Combinatorics and Mathematical Induction" : "Theory of Equations & Two Dimensional Analytical Geometry-II", q: "Identities, Permutations & Ellipse/Hyperbola" }
        ]},
        { name: "Unit 2: Calculus, Vectors & Probability", chapters: [
          { num: 3, name: classLevel === 11 ? "Binomial Theorem, Sequences/Series & Analytical Geometry" : "Applications of Vector Algebra & Differential Calculus Applications", q: "Straight Lines, Cross Product & Maxima" },
          { num: 4, name: classLevel === 11 ? "Differential Calculus (Limits) & Integral Calculus/Probability" : "Integral Calculus, Differential Equations & Probability Distributions", q: "Integration by Parts & Poisson/Normal" }
        ]}
      ]},
      { name: "Biology", code: "BIO", icon: "🧬", color: "#eb4d4b", units: [
        { name: "Unit 1: Plant & Animal Diversity", chapters: [
          { num: 1, name: classLevel === 11 ? "Diversity of Living World & Plant/Animal Tissue Organisation" : "Reproduction in Organisms & Human Reproduction", q: "Taxonomy, Histology & Spermatogenesis" },
          { num: 2, name: classLevel === 11 ? "Digestive, Respiratory & Circulatory Systems" : "Reproductive Health & Principles of Inheritance and Variation", q: "Enzymes, Cardiac Cycle & Chromosomes" }
        ]},
        { name: "Unit 2: Genetics, Biotech & Ecology", chapters: [
          { num: 3, name: classLevel === 11 ? "Locomotion, Neural Control & Chemical Coordination" : "Molecular Genetics & Evolution/Human Health and Disease", q: "Sliding Filament, Action Potential & DNA" },
          { num: 4, name: classLevel === 11 ? "Cell Biology, Biomolecules & Plant Physiology" : "Biotechnology Principles, Applications & Environmental Issues", q: "Photosynthesis, Respiration & Conservation" }
        ]}
      ]},
      { name: "Botany", code: "BOT", icon: "🌿", color: "#1dd1a1", units: [
        { name: "Unit 1: Plant Morphology & Anatomy", chapters: [
          { num: 1, name: classLevel === 11 ? "Diversity of Living World: Viruses, Bacteria, Fungi & Plant Kingdom" : "Asexual and Sexual Reproduction in Plants & Classical Genetics", q: "Microbes, Algae & Mendel Dihybrid" },
          { num: 2, name: classLevel === 11 ? "Vegetative and Reproductive Morphology of Angiosperms" : "Chromosomal Basis of Inheritance & Biotechnology Principles", q: "Inflorescence, Floral Formula & Vectors" }
        ]},
        { name: "Unit 2: Plant Physiology & Taxonomy", chapters: [
          { num: 3, name: classLevel === 11 ? "Taxonomy and Systematic Botany & Cell Biology/Biomolecules" : "Plant Tissue Culture, Ecology Principles & Ecosystem", q: "Bentham-Hooker & Totipotency" },
          { num: 4, name: classLevel === 11 ? "Plant Anatomy, Plant Physiology (Photosynthesis, Respiration & Growth)" : "Environmental Issues, Plant Breeding & Economic Botany", q: "C3/C4 Cycle, Auxins & Crop Varieties" }
        ]}
      ]},
      { name: "Zoology", code: "ZOO", icon: "🐾", color: "#ff9f43", units: [
        { name: "Unit 1: Animal Systems & Histology", chapters: [
          { num: 1, name: classLevel === 11 ? "The Living World, Kingdom Animalia & Tissue Level Organisation" : "Reproduction in Organisms & Human Reproduction", q: "Non-Chordates/Chordates & Gametogenesis" },
          { num: 2, name: classLevel === 11 ? "Digestion and Absorption & Breathing and Exchange of Gases" : "Reproductive Health & Principles of Inheritance and Variation", q: "Digestive Glands & Alveolar Exchange" }
        ]},
        { name: "Unit 2: Physiology, Genetics & Ecology", chapters: [
          { num: 3, name: classLevel === 11 ? "Body Fluids/Circulation & Excretory Products and Elimination" : "Molecular Genetics, Evolution & Human Health and Disease", q: "ECG, Nephron Filtration & Antibodies" },
          { num: 4, name: classLevel === 11 ? "Locomotion/Movement, Neural Control & Chemical Coordination" : "Applications of Biotechnology, Organisms/Populations & Biodiversity", q: "Synaptic Transmission & Endocrine Glands" }
        ]}
      ]},
      { name: "Computer Science", code: "CS", icon: "💻", color: "#8854d0", units: [
        { name: "Unit 1: Fundamentals, C++ & Python", chapters: [
          { num: 1, name: classLevel === 11 ? "Introduction to Computers, Number Systems & Working with Windows/Linux" : "Functions, Data Abstraction & Scoping in Python", q: "Binary-Hex Conversion & Python Scoping" },
          { num: 2, name: classLevel === 11 ? "Theoretical Concepts of OS, Algorithms & Problem Solving" : "Algorithmic Efficiency, Sorting & Searching Techniques", q: "Time Complexity & Binary Search" }
        ]},
        { name: "Unit 2: OOP, SQL & Web Technologies", chapters: [
          { num: 3, name: classLevel === 11 ? "Introduction to C++ Programming, Control Statements & Functions" : "Object Oriented Programming with Python (Classes & Objects)", q: "Inheritance, Polymorphism & Methods" },
          { num: 4, name: classLevel === 11 ? "Arrays, Structures, Classes and Objects & Web Technologies (HTML/CSS)" : "Database Concepts, MySQL Structured Query Language & Python-SQL Connector", q: "Relational Queries & Web Protocols" }
        ]}
      ]},
      { name: "Statistics", code: "STAT", icon: "📉", color: "#54a0ff", units: [
        { name: "Unit 1: Data Collection & Descriptive Statistics", chapters: [
          { num: 1, name: classLevel === 11 ? "Nature of Statistics, Collection and Classification of Data" : "Probability Distributions: Binomial and Poisson Distributions", q: "Primary/Secondary Data & Binomial Eq" },
          { num: 2, name: classLevel === 11 ? "Measures of Central Tendency & Dispersion" : "Normal Distribution, Sampling Theory & Hypothesis Testing", q: "Standard Deviation & Z-Test" }
        ]},
        { name: "Unit 2: Bivariate Data & Time Series", chapters: [
          { num: 3, name: classLevel === 11 ? "Correlation Analysis & Linear Regression" : "Large Sample Tests & Small Sample Tests (t-test, F-test, Chi-square)", q: "Karl Pearson Coefficient & t-test" },
          { num: 4, name: classLevel === 11 ? "Index Numbers & Time Series Analysis" : "Design of Experiments, Statistical Quality Control & Operations Research", q: "Laspeyre-Paasche & Control Charts" }
        ]}
      ]},
      { name: "Economics", code: "ECO", icon: "📈", color: "#5f27cd", units: [
        { name: "Unit 1: Microeconomic Principles & Tamil Nadu Economy", chapters: [
          { num: 1, name: classLevel === 11 ? "Introduction to Microeconomics, Consumption Analysis & Production" : "Introduction to Macroeconomics & National Income", q: "Law of Diminishing Utility & GDP Calculation" },
          { num: 2, name: classLevel === 11 ? "Cost and Revenue Analysis & Market Structure and Pricing" : "Theories of Employment and Income (Keynesian Economics)", q: "Monopoly, Oligopoly & Effective Demand" }
        ]},
        { name: "Unit 2: Macroeconomics & Development Issues", chapters: [
          { num: 3, name: classLevel === 11 ? "Distribution Analysis, Indian Economy & Economic Reforms (1991)" : "Money and Banking & International Economics", q: "Marginal Productivity & Balance of Trade" },
          { num: 4, name: classLevel === 11 ? "Rural Economy of India, Economy of Tamil Nadu & Statistical Economics" : "Fiscal Economics, Environmental Economics & Economic Planning/NITI Aayog", q: "Tamil Nadu Industry & Fiscal Deficit" }
        ]}
      ]},
      { name: "Commerce", code: "COMM", icon: "🏢", color: "#f368e0", units: [
        { name: "Unit 1: Forms of Business & Banking", chapters: [
          { num: 1, name: classLevel === 11 ? "Historical Background of Commerce in Tamilagam & Sole Proprietorship" : "Principles of Management (Taylor & Fayol) & Functions of Management", q: "Ancient Pandyan Ports & Fayol 14 Principles" },
          { num: 2, name: classLevel === 11 ? "Partnership Organisation & Joint Stock Company" : "Financial Markets: Capital Market, Money Market & Stock Exchange (SEBI)", q: "Company Incorporation & SEBI Regulations" }
        ]},
        { name: "Unit 2: Trade, Finance & Marketing", chapters: [
          { num: 3, name: classLevel === 11 ? "Co-operative Societies, Public Enterprises & Reserve Bank of India" : "Human Resource Management & Recruitment/Selection Processes", q: "RBI Monetary Tools & Interview Methods" },
          { num: 4, name: classLevel === 11 ? "Types of Banks, Warehousing, Transport, Insurance & International Trade" : "Elements of Marketing, Consumer Protection Act & Company Law/Secretarial Practice", q: "Marketing Mix 4Ps & Consumer Rights" }
        ]}
      ]},
      { name: "Accountancy", code: "ACC", icon: "📊", color: "#10ac84", units: [
        { name: "Unit 1: Book-Keeping & Journal Entries", chapters: [
          { num: 1, name: classLevel === 11 ? "Introduction to Accounting, Conceptual Framework & Books of Prime Entry" : "Accounts from Incomplete Records (Single Entry System)", q: "Golden Rules of Accounting & Statement of Affairs" },
          { num: 2, name: classLevel === 11 ? "Ledger, Trial Balance & Subsidiary Books (Cash Book, Purchases Book)" : "Accounts of Not-for-Profit Organisations & Partnership Fundamentals", q: "Triple Column Cash Book & Receipts/Payments" }
        ]},
        { name: "Unit 2: Final Accounts & Analysis", chapters: [
          { num: 3, name: classLevel === 11 ? "Bank Reconciliation Statement, Correction of Errors & Depreciation" : "Goodwill in Partnership & Admission/Retirement of a Partner", q: "BRS Adjustment, Rectification & Sacrificing Ratio" },
          { num: 4, name: classLevel === 11 ? "Capital and Revenue Transactions & Final Accounts of Sole Proprietorship" : "Company Accounts: Issue of Shares/Debentures & Financial Statement Analysis", q: "Trading, P&L, Balance Sheet & Ratio Analysis" }
        ]}
      ]},
      { name: "Computer Applications", code: "CA", icon: "🖥️", color: "#00d2d3", units: [
        { name: "Unit 1: Office Productivity & OpenSource Tools", chapters: [
          { num: 1, name: classLevel === 11 ? "Introduction to Computers, Word Processor & OpenOffice Calc" : "Multimedia and Desktop Publishing (PageMaker) & Digital Tools", q: "Spreadsheet Formulas & Page Layouts" },
          { num: 2, name: classLevel === 11 ? "Presentation Basics (OpenOffice Impress) & Working with Internet/Email" : "Introduction to Adobe InDesign, CorelDraw & Graphics File Formats", q: "Slide Transitions & Vector Graphics" }
        ]},
        { name: "Unit 2: Web Design, PHP & E-Commerce", chapters: [
          { num: 3, name: classLevel === 11 ? "Web Design using HTML5, CSS Styling & JavaScript Basics" : "Introduction to Hypertext Preprocessor (PHP), Loops & Functions", q: "HTML Form Elements & PHP Variables" },
          { num: 4, name: classLevel === 11 ? "E-Commerce Fundamentals, Digital Payments & Cyber Safety" : "PHP Database Connection (MySQL), E-Commerce Security & Electronic Data Interchange", q: "Payment Gateways & MySQL Integration" }
        ]}
      ]},
      { name: "Business Mathematics", code: "BM", icon: "🧮", color: "#ee5253", units: [
        { name: "Unit 1: Matrices, Commercial Math & Algebra", chapters: [
          { num: 1, name: classLevel === 11 ? "Matrices and Determinants & Algebra (Partial Fractions, Permutations)" : "Applications of Matrices and Determinants & Commercial Mathematics", q: "Cramer's Rule & Input-Output Analysis" },
          { num: 2, name: classLevel === 11 ? "Analytical Geometry (Lines, Circles) & Trigonometry Basics" : "Differential Calculus: Marginal Cost, Revenue & Elasticity of Demand", q: "Marginal Profit & Slope Formula" }
        ]},
        { name: "Unit 2: Financial Calculus & Operations Research", chapters: [
          { num: 3, name: classLevel === 11 ? "Differential Calculus & Integral Calculus for Business" : "Integral Calculus: Consumer Surplus, Producer Surplus & Inventory Cost", q: "Definite Integration & Inventory Models" },
          { num: 4, name: classLevel === 11 ? "Financial Mathematics: Simple/Compound Interest, Annuities & Statistics" : "Differential Equations, Numerical Methods & Operations Research (Transportation/Assignment)", q: "Annuity Future Value & North-West Corner" }
        ]}
      ]},
      { name: "History", code: "HIST", icon: "🏛️", color: "#8395a7", units: [
        { name: "Unit 1: Ancient & Medieval Tamilagam and India", chapters: [
          { num: 1, name: classLevel === 11 ? "Early India: From the Beginnings to the Indus Valley & Vedic Age" : "Socio-Religious Reform Movements in the 19th Century", q: "Harappa, Sangam Polity & Brahmo Samaj" },
          { num: 2, name: classLevel === 11 ? "Rise of Magadha, Mauryas, Guptas & Harsha Empire" : "Early Uprisings Against British Rule in Tamil Nadu (Veerapandiya Kattabomman)", q: "Ashoka Edicts, Palayakkarar War & Vellore Mutiny" }
        ]},
        { name: "Unit 2: Modern Freedom Struggle & World History", chapters: [
          { num: 3, name: classLevel === 11 ? "Cultural Syncretism: Bhakti Movement, Vijayanagar Empire & Mughals" : "Anti-Colonial Movements, The Great Revolt of 1857 & Gandhian Era", q: "Krishnadevaraya, Akbar & Dandi Satyagraha" },
          { num: 4, name: classLevel === 11 ? "Coming of Europeans, British Colonisation & Social Reform Movements" : "Freedom Movement in Tamil Nadu (V.O.C, Bharathiar, Kamaraj) & Social Transformation", q: "Swadeshi Steam, Justice Party & Self-Respect Movement" }
        ]}
      ]}
    ]
  }))
];

const fullCurriculum = [...cbseCurriculum, ...stateBoardCurriculum];

function generateJavaSeeder() {
  let java = `package com.computerquest.computer_quest_backend.config;

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
`;

  for (const entry of fullCurriculum) {
    const { board, classLevel } = entry;
    java += `        seed_${board}_Class_${classLevel}();\n`;
  }

  java += `    }\n\n`;

  // Write methods for each board + class
  for (const entry of fullCurriculum) {
    const { board, classLevel, subjects } = entry;
    const methodName = `seed_${board}_Class_${classLevel}`;

    java += `    private void ${methodName}() {\n`;
    java += `        String board = "${board}";\n`;
    java += `        int classLevel = ${classLevel};\n\n`;

    for (const sub of subjects) {
      java += `        // Subject: ${sub.name}\n`;
      java += `        Subject sub_${sub.code} = subjectRepository\n`;
      java += `                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "${sub.name}")\n`;
      java += `                .orElseGet(() -> subjectRepository.save(new Subject("${sub.name}", "${sub.code}", "${sub.icon}", "${sub.color}", board, classLevel)));\n\n`;

      let unitCounter = 1;
      for (const unit of sub.units) {
        java += `        // Unit: ${unit.name}\n`;
        java += `        Unit u_${sub.code}_${unitCounter} = unitRepository\n`;
        java += `                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "${sub.name}")\n`;
        java += `                .stream().filter(u -> u.getUnitNumber() != null && u.getUnitNumber() == ${unitCounter}).findFirst()\n`;
        java += `                .orElseGet(() -> unitRepository.save(new Unit("${unit.name}", ${unitCounter}, "${sub.name}", board, classLevel)));\n\n`;

        for (const ch of unit.chapters) {
          java += `        // Chapter: ${ch.name}\n`;
          java += `        Chapter ch_${sub.code}_${ch.num} = chapterRepository\n`;
          java += `                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "${sub.name}", ${ch.num})\n`;
          java += `                .orElseGet(() -> chapterRepository.save(new Chapter("${sub.name}", "${unit.name}", ${ch.num}, "${ch.name}", ${ch.num == 1}, board, classLevel)));\n\n`;

          java += `        seedMissionsAndQuestions(board, classLevel, "${sub.name}", "${unit.name}", "${ch.name}", ch_${sub.code}_${ch.num}, "${ch.q}");\n\n`;
        }
        unitCounter++;
      }
    }

    java += `    }\n\n`;
  }

  // Question generation logic
  java += `    private void seedMissionsAndQuestions(String board, int classLevel, String subject, String unit, String chapterName, Chapter chapter, String topic) {
        for (int mNum = 1; mNum <= 4; mNum++) {
            final int currentMNum = mNum;
            List<Mission> existingMissions = missionRepository
                    .findByChapter_Id(chapter.getId())
                    .stream()
                    .filter(m -> m.getMissionNumber() != null && m.getMissionNumber().equals(currentMNum))
                    .toList();

            Mission missionEntity;
            if (existingMissions.isEmpty()) {
                missionEntity = new Mission();
                missionEntity.setMissionNumber(mNum);
                String gameType = (mNum == 1 || mNum == 3) ? "MCQ Quiz" :
                                  (mNum == 2) ? "Fill in the Blank" : "Scenario Challenge";
                missionEntity.setGameType(gameType);
                missionEntity.setChapter(chapter);
                missionEntity = missionRepository.save(missionEntity);
            } else {
                missionEntity = existingMissions.get(0);
            }

            // Seed questions for mission
            List<Question> existingQ = questionRepository.findByBoardAndClassLevelAndSubjectAndUnitAndChapterAndMission(
                    board, classLevel, subject, unit, chapterName, mNum
            );

            if (existingQ.isEmpty()) {
                seedQuestionsForMission(board, classLevel, subject, unit, chapterName, mNum, topic);
            }
        }
    }

    private void seedQuestionsForMission(String board, int classLevel, String subject, String unit, String chapterName, int mNum, String topic) {
        String qType = (mNum == 2) ? "FILL_BLANK" : (mNum == 4) ? "SCENARIO" : "MCQ";

        for (int qIdx = 1; qIdx <= 5; qIdx++) {
            Question q = new Question();
            q.setBoard(board);
            q.setClassLevel(classLevel);
            q.setSubject(subject);
            q.setUnit(unit);
            q.setChapter(chapterName);
            q.setMission(mNum);
            q.setQuestionType(qType);

            if (mNum == 2) {
                q.setQuestionText(getFillBlankText(classLevel, subject, chapterName, qIdx));
                String correctAns = getFillBlankAnswer(classLevel, subject, chapterName, qIdx);
                q.setOptionA(correctAns);
                q.setOptionB(correctAns);
                q.setCorrectAnswer(correctAns);
            } else if (mNum == 4) {
                q.setQuestionText(getScenarioText(classLevel, subject, chapterName, qIdx));
                String[] opts = getScenarioOptions(classLevel, subject, chapterName, qIdx);
                q.setOptionA(opts[0]);
                q.setOptionB(opts[1]);
                q.setOptionC(opts[2]);
                q.setOptionD(opts[3]);
                q.setCorrectAnswer("A");
            } else {
                q.setQuestionText(getMcqText(classLevel, subject, chapterName, mNum, qIdx));
                String[] opts = getMcqOptions(classLevel, subject, chapterName, mNum, qIdx);
                q.setOptionA(opts[0]);
                q.setOptionB(opts[1]);
                q.setOptionC(opts[2]);
                q.setOptionD(opts[3]);
                q.setCorrectAnswer("A");
            }

            questionRepository.save(q);
        }
    }

    private String getMcqText(int classLevel, String subject, String chName, int mNum, int qIdx) {
        if ("Tamil".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "திருக்குறளை இயற்றிய திருவள்ளுவர் வாழ்ந்த காலம் எது?";
            if (qIdx == 2) return "தமிழ் எழுத்துக்களில் முதல் எழுத்துக்களின் மொத்த எண்ணிக்கை யாது?";
            if (qIdx == 3) return "சிலப்பதிகாரம் மற்றும் மணிமேகலை ஆகிய இரண்டும் எவ்வாறு அழைக்கப்படுகின்றன?";
            if (qIdx == 4) return "தொல்காப்பியத்தின்படி தமிழ் இலக்கணம் எத்தனை வகைகளாகப் பிரிக்கப்பட்டுள்ளது?";
            return "சுரதா அவர்களின் இயற்பெயர் யாது?";
        } else if ("Mathematics".equalsIgnoreCase(subject) || "Business Mathematics".equalsIgnoreCase(subject)) {
            if (classLevel <= 5) {
                if (qIdx == 1) return "What is the value of 45 + 55 in arithmetic addition?";
                if (qIdx == 2) return "How many millimeters are there in 1 centimeter?";
                if (qIdx == 3) return "Which geometrical shape has 4 equal sides and 4 right angles?";
                if (qIdx == 4) return "What is the perimeter of a rectangle with length 10 cm and breadth 5 cm?";
                return "If 1 textbook costs 20 rupees, what is the total cost of 5 textbooks?";
            } else if (classLevel <= 8) {
                if (qIdx == 1) return "What is the value of (-15) + (+25) in integer arithmetic?";
                if (qIdx == 2) return "What is the square root of 144?";
                if (qIdx == 3) return "What is the solution of the linear equation 2x + 6 = 16?";
                if (qIdx == 4) return "What is the sum of interior angles of any triangle?";
                return "What is the area of a circle with radius 7 cm? (Use pi = 22/7)";
            } else if (classLevel <= 10) {
                if (qIdx == 1) return "What are the roots of the quadratic equation x^2 - 5x + 6 = 0?";
                if (qIdx == 2) return "In trigonometry, what is the exact value of sin(90 degrees)?";
                if (qIdx == 3) return "What is the distance between coordinates (0,0) and (3,4) on Cartesian plane?";
                if (qIdx == 4) return "What is the discriminant formula for a quadratic equation ax^2 + bx + c = 0?";
                return "In an Arithmetic Progression, what is the formula for the nth term an?";
            } else {
                if (qIdx == 1) return "What is the derivative of f(x) = x^3 with respect to x?";
                if (qIdx == 2) return "What is the determinant of an identity matrix I of order 3?";
                if (qIdx == 3) return "What is the definite/indefinite integral of cos(x) dx?";
                if (qIdx == 4) return "What is the dot product of two mutually perpendicular non-zero vectors?";
                return "What is the limit of (sin x)/x as x approaches 0?";
            }
        } else if ("Physics".equalsIgnoreCase(subject) || ("Science".equalsIgnoreCase(subject) && classLevel >= 9)) {
            if (classLevel <= 10) {
                if (qIdx == 1) return "What is the SI unit of electric current?";
                if (qIdx == 2) return "According to Ohm's law, what is the formula relating V, I, and R?";
                if (qIdx == 3) return "Which optical mirror is used by dentists to view enlarged images of teeth?";
                if (qIdx == 4) return "What is the acceleration due to gravity (g) on the surface of Earth?";
                return "What is the speed of light in vacuum?";
            } else {
                if (qIdx == 1) return "What is the dimensional formula of the universal gravitational constant G?";
                if (qIdx == 2) return "According to Coulomb's Law, how does electrostatic force vary with distance r?";
                if (qIdx == 3) return "What is the SI unit of magnetic flux in electromagnetism?";
                if (qIdx == 4) return "In photoelectric effect, the maximum kinetic energy of emitted electrons depends on:";
                return "What type of semiconductor is formed when silicon is doped with phosphorus (pentavalent)?";
            }
        } else if ("Chemistry".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "What is the molecular formula and molar mass of pure water?";
            if (qIdx == 2) return "What is the pH value of a neutral aqueous solution at 25 degrees Celsius?";
            if (qIdx == 3) return "Which chemical element has atomic number 6 and forms the basis of all organic chemistry?";
            if (qIdx == 4) return "What type of bond is formed by mutual sharing of electron pairs between two atoms?";
            return "According to Avogadro's constant, how many particles are present in 1 mole of substance?";
        } else if ("Biology".equalsIgnoreCase(subject) || "EVS".equalsIgnoreCase(subject) || ("Science".equalsIgnoreCase(subject) && classLevel <= 8)) {
            if (classLevel <= 5) {
                if (qIdx == 1) return "Which part of a plant absorbs water and minerals from the soil?";
                if (qIdx == 2) return "Which green pigment in plant leaves absorbs sunlight for photosynthesis?";
                if (qIdx == 3) return "Which gas do living animals and humans inhale for respiration?";
                if (qIdx == 4) return "Which animal is commonly known as the 'Ship of the Desert'?";
                return "What is the primary natural source of energy and light for planet Earth?";
            } else if (classLevel <= 8) {
                if (qIdx == 1) return "Which biological organelle is known as the powerhouse of the eukaryotic cell?";
                if (qIdx == 2) return "Which blood cells are responsible for carrying oxygen throughout the human body?";
                if (qIdx == 3) return "Which biological process converts light energy into chemical energy in green plants?";
                if (qIdx == 4) return "Which microorganism is widely used in baking bread and fermenting dough?";
                return "What is the normal human body core temperature in Celsius?";
            } else {
                if (qIdx == 1) return "Which double-helix molecule carries hereditary genetic instructions?";
                if (qIdx == 2) return "Which organelle synthesizes essential proteins inside living biological cells?";
                if (qIdx == 3) return "What is the structural and functional microscopic filtration unit of the human kidney?";
                if (qIdx == 4) return "In classical genetics, Gregor Mendel discovered inheritance laws using which plant?";
                return "Which pancreatic hormone regulates glucose levels in the human bloodstream?";
            }
        } else if ("Botany".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "Which plant tissue is primarily responsible for transporting water and dissolved minerals upwards?";
            if (qIdx == 2) return "Which plant hormone promotes cell elongation, apical dominance, and rooting?";
            if (qIdx == 3) return "In angiosperms, what type of unique fertilization occurs in the embryo sac?";
            if (qIdx == 4) return "Which photosynthetic pathway is found in plants like sugarcane and maize that avoids photorespiration?";
            return "In plant taxonomy, Bentham and Hooker classification system is an example of:";
        } else if ("Zoology".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "Which chamber of the human heart pumps oxygenated blood into the systemic aorta?";
            if (qIdx == 2) return "What is the structural and functional unit of the human nervous system?";
            if (qIdx == 3) return "Which immunoglobulin (antibody) is the most abundant in human blood serum?";
            if (qIdx == 4) return "In human physiology, the sliding filament theory explains the mechanism of:";
            return "Which endocrine gland is located at the base of the brain and known as the master gland?";
        } else if ("Accountancy".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "According to the golden rules of accounting, what is the rule for Real Accounts?";
            if (qIdx == 2) return "Which book of prime entry is used to record all daily financial transactions chronologically?";
            if (qIdx == 3) return "What financial statement summarizes a company's assets, liabilities, and equity at a specific date?";
            if (qIdx == 4) return "The accounting equation states that Total Assets must always equal:";
            return "Which accounting concept assumes a business enterprise will continue operating indefinitely?";
        } else if ("Commerce".equalsIgnoreCase(subject) || "Business Studies".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "Who is known as the Father of Modern Administrative Management and proposed 14 principles?";
            if (qIdx == 2) return "Which form of business organisation provides separate legal entity and limited liability to owners?";
            if (qIdx == 3) return "What are the 4 Ps of the traditional Marketing Mix formulated by E. Jerome McCarthy?";
            if (qIdx == 4) return "Which apex statutory body regulates securities markets and protects investor interests in India?";
            return "Which management function involves establishing goals, setting objectives, and deciding future actions?";
        } else if ("Economics".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "According to the Law of Demand, when the price of a normal good decreases, its quantity demanded:";
            if (qIdx == 2) return "What does GDP stand for in macroeconomic national income accounting?";
            if (qIdx == 3) return "Which apex institution acts as the central bank and monetary authority in India?";
            if (qIdx == 4) return "What term describes the value of the next best alternative forgone when making a decision?";
            return "In economic market structures, a single seller with no close substitutes is known as a:";
        } else if ("Statistics".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "Which measure of central tendency represents the most frequently occurring value in a dataset?";
            if (qIdx == 2) return "What is the square root of the variance called in descriptive statistics?";
            if (qIdx == 3) return "The Karl Pearson coefficient of linear correlation (r) always lies between:";
            if (qIdx == 4) return "In probability theory, what is the total sum of probabilities of all elementary outcomes in a sample space?";
            return "Which index number uses base year quantities as weights?";
        } else if ("History".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "Which ancient Indus Valley civilization site is famous for the Great Bath and Citadel?";
            if (qIdx == 2) return "Who was the founder of the Mauryan Empire who unified most of India under Chandragupta?";
            if (qIdx == 3) return "In which year did the historic Great Rebellion / First War of Indian Independence take place?";
            if (qIdx == 4) return "Who was the Chairman of the Drafting Committee of the Indian Constitution?";
            return "The historic Dandi Salt March was led by Mahatma Gandhi in which year?";
        } else if ("Social Science".equalsIgnoreCase(subject)) {
            if (classLevel <= 5) {
                if (qIdx == 1) return "What is the national capital city of India?";
                if (qIdx == 2) return "How many continents are there on planet Earth?";
                if (qIdx == 3) return "Which is the largest and deepest ocean on planet Earth?";
                if (qIdx == 4) return "Who was the first Prime Minister of independent India?";
                return "In which cardinal direction does the Sun rise every morning?";
            } else if (classLevel <= 8) {
                if (qIdx == 1) return "Who is widely revered as the Father of the Indian Constitution?";
                if (qIdx == 2) return "In which year did India officially achieve Independence from British colonial rule?";
                if (qIdx == 3) return "What is the supreme constitutional law-making legislative body in India?";
                if (qIdx == 4) return "Which ancient civilization developed along the banks of River Indus?";
                return "Which imaginary line divides planet Earth into Northern and Southern hemispheres?";
            } else {
                if (qIdx == 1) return "Which historic 1789 revolution introduced the ideals of Liberty, Equality, and Fraternity?";
                if (qIdx == 2) return "What democratic constitutional form of government does India follow?";
                if (qIdx == 3) return "Which sector of the Indian economy includes agriculture, forestry, and fishing?";
                if (qIdx == 4) return "What is the minimum statutory voting age for Indian citizens in general elections?";
                return "Which majestic mountain range forms the northern geographical boundary of India?";
            }
        } else if ("English".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "Identify the noun in the sentence: 'The dedicated teacher guided the students.'";
            if (qIdx == 2) return "What is the antonym (opposite) of the word 'Courageous'?";
            if (qIdx == 3) return "Choose the correct past tense form of the verb 'Write':";
            if (qIdx == 4) return "Which grammatical part of speech modifies or describes a verb, adjective, or other adverb?";
            return "What is the synonym (similar meaning) of the word 'Gigantic'?";
        } else {
            // Computer Science / Informatics Practices / Computer Applications
            if (classLevel <= 8) {
                if (qIdx == 1) return "What does CPU stand for in computer hardware architecture?";
                if (qIdx == 2) return "How many binary bits make up 1 standard computer Byte?";
                if (qIdx == 3) return "In Python programming, which built-in function outputs text to the screen?";
                if (qIdx == 4) return "What does HTML stand for in web page design?";
                return "Which network topology connects all devices to a single central backbone cable?";
            } else if (classLevel <= 10) {
                if (qIdx == 1) return "In Python, what is the result of len(['Tamil', 'English', 'Maths'])?";
                if (qIdx == 2) return "Which SQL keyword is used to retrieve data rows from a relational database table?";
                if (qIdx == 3) return "In HTML, which anchor tag attribute specifies the hyperlink target URL?";
                if (qIdx == 4) return "Which loop structure in Python executes repeatedly as long as a condition evaluates to True?";
                return "Which secure cryptographic protocol is used for encrypted web browsing (HTTPS)?";
            } else {
                if (qIdx == 1) return "In Python, which mutable sequence data structure is defined using square brackets []?";
                if (qIdx == 2) return "What is the average time complexity of searching an element in a balanced Binary Search Tree?";
                if (qIdx == 3) return "In SQL, which clause filters aggregate results when used with GROUP BY?";
                if (qIdx == 4) return "In Python, which block handles runtime errors and exceptions gracefully?";
                return "Which layer of the standard OSI reference model is responsible for routing IP packets across networks?";
            }
        }
    }

    private String[] getMcqOptions(int classLevel, String subject, String chName, int mNum, int qIdx) {
        if ("Tamil".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return new String[]{"கி.மு. 31 (பொ.ஆ.மு. 31)", "கி.பி. 500", "கி.பி. 1000", "கி.மு. 100"};
            if (qIdx == 2) return new String[]{"30 (உயிர் 12 + மெய் 18)", "216", "247", "18"};
            if (qIdx == 3) return new String[]{"இரட்டைக் காப்பியங்கள்", "ஐம்பெருங்காப்பியங்கள்", "சங்க நூல்கள்", "பதினெண்கீழ்க்கணக்கு"};
            if (qIdx == 4) return new String[]{"5 (எழுத்து, சொல், பொருள், யாப்பு, அணி)", "3", "4", "2"};
            return new String[]{"ராசகோபாலன்", "சுப்புரத்தினம்", "கண்ணதாசன்", "துரைராசு"};
        } else if ("Mathematics".equalsIgnoreCase(subject) || "Business Mathematics".equalsIgnoreCase(subject)) {
            if (classLevel <= 5) {
                if (qIdx == 1) return new String[]{"100", "90", "110", "95"};
                if (qIdx == 2) return new String[]{"10 mm", "100 mm", "5 mm", "1 mm"};
                if (qIdx == 3) return new String[]{"Square", "Rectangle", "Triangle", "Circle"};
                if (qIdx == 4) return new String[]{"30 cm", "25 cm", "50 cm", "15 cm"};
                return new String[]{"100 rupees", "80 rupees", "120 rupees", "50 rupees"};
            } else if (classLevel <= 8) {
                if (qIdx == 1) return new String[]{"+10", "-10", "+40", "-40"};
                if (qIdx == 2) return new String[]{"12", "14", "16", "11"};
                if (qIdx == 3) return new String[]{"x = 5", "x = 6", "x = 4", "x = 8"};
                if (qIdx == 4) return new String[]{"180 degrees", "360 degrees", "90 degrees", "270 degrees"};
                return new String[]{"154 sq cm", "144 sq cm", "160 sq cm", "176 sq cm"};
            } else if (classLevel <= 10) {
                if (qIdx == 1) return new String[]{"x = 2, 3", "x = 1, 6", "x = -2, -3", "x = 3, 4"};
                if (qIdx == 2) return new String[]{"1", "0", "1/2", "Undefined"};
                if (qIdx == 3) return new String[]{"5 units", "7 units", "4 units", "6 units"};
                if (qIdx == 4) return new String[]{"b^2 - 4ac", "b^2 + 4ac", "4ac - b^2", "2a / b"};
                return new String[]{"a + (n-1)d", "a + nd", "a + (n+1)d", "(a+d)/n"};
            } else {
                if (qIdx == 1) return new String[]{"3x^2", "x^2", "3x", "x^4"};
                if (qIdx == 2) return new String[]{"1", "0", "3", "Undefined"};
                if (qIdx == 3) return new String[]{"sin(x) + C", "-sin(x) + C", "tan(x) + C", "cos(x) + C"};
                if (qIdx == 4) return new String[]{"0", "1", "-1", "Infinity"};
                return new String[]{"1", "0", "Infinity", "Undefined"};
            }
        } else if ("Physics".equalsIgnoreCase(subject) || ("Science".equalsIgnoreCase(subject) && classLevel >= 9)) {
            if (classLevel <= 10) {
                if (qIdx == 1) return new String[]{"Ampere (A)", "Volt (V)", "Ohm", "Watt (W)"};
                if (qIdx == 2) return new String[]{"V = I * R", "V = I / R", "I = V * R", "R = V * I"};
                if (qIdx == 3) return new String[]{"Concave mirror", "Convex mirror", "Plane mirror", "Cylindrical lens"};
                if (qIdx == 4) return new String[]{"9.8 m/s^2", "8.9 m/s^2", "10.8 m/s^2", "6.7 m/s^2"};
                return new String[]{"3 x 10^8 m/s", "3 x 10^6 m/s", "3 x 10^5 km/h", "300 m/s"};
            } else {
                if (qIdx == 1) return new String[]{"[M^-1 L^3 T^-2]", "[M L^2 T^-2]", "[M L T^-1]", "[M^0 L^2 T^-2]"};
                if (qIdx == 2) return new String[]{"Inversely proportional to r^2 (1/r^2)", "Directly proportional to r", "Inversely proportional to r", "Independent of r"};
                if (qIdx == 3) return new String[]{"Weber (Wb)", "Tesla (T)", "Henry (H)", "Farad (F)"};
                if (qIdx == 4) return new String[]{"Frequency of incident light", "Intensity of incident light", "Angle of incidence", "Time of exposure"};
                return new String[]{"n-type semiconductor", "p-type semiconductor", "Intrinsic semiconductor", "Superconductor"};
            }
        } else if ("Chemistry".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return new String[]{"H2O, 18 g/mol", "HO2, 34 g/mol", "H2O2, 34 g/mol", "H3O, 19 g/mol"};
            if (qIdx == 2) return new String[]{"7", "0", "14", "1"};
            if (qIdx == 3) return new String[]{"Carbon (C)", "Nitrogen (N)", "Oxygen (O)", "Silicon (Si)"};
            if (qIdx == 4) return new String[]{"Covalent Bond", "Ionic Bond", "Metallic Bond", "Hydrogen Bond"};
            return new String[]{"6.022 x 10^23", "6.022 x 10^22", "3.0 x 10^8", "1.6 x 10^-19"};
        } else if ("Botany".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return new String[]{"Xylem", "Phloem", "Cambium", "Parenchyma"};
            if (qIdx == 2) return new String[]{"Auxin", "Gibberellin", "Cytokinin", "Abscisic Acid"};
            if (qIdx == 3) return new String[]{"Double Fertilization (Triple Fusion)", "Single Fertilization", "Parthenogenesis", "Budding"};
            if (qIdx == 4) return new String[]{"C4 Pathway (Hatch-Slack)", "C3 Pathway (Calvin)", "CAM Pathway", "Photorespiration"};
            return new String[]{"Natural Classification System", "Artificial System", "Phylogenetic System", "Numerical System"};
        } else if ("Zoology".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return new String[]{"Left Ventricle", "Right Ventricle", "Left Atrium", "Right Atrium"};
            if (qIdx == 2) return new String[]{"Neuron (Nerve Cell)", "Nephron", "Osteocyte", "Myocyte"};
            if (qIdx == 3) return new String[]{"IgG", "IgA", "IgM", "IgE"};
            if (qIdx == 4) return new String[]{"Muscle Contraction (Actin-Myosin)", "Nerve Conduction", "Blood Clotting", "Bone Ossification"};
            return new String[]{"Pituitary Gland", "Thyroid Gland", "Adrenal Gland", "Pancreas"};
        } else if ("Accountancy".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return new String[]{"Debit what comes in, Credit what goes out", "Debit the receiver, Credit the giver", "Debit all expenses, Credit all incomes", "Debit owner, Credit capital"};
            if (qIdx == 2) return new String[]{"Journal", "Ledger", "Trial Balance", "Balance Sheet"};
            if (qIdx == 3) return new String[]{"Balance Sheet", "Trading Account", "Cash Book", "Trial Balance"};
            if (qIdx == 4) return new String[]{"Liabilities + Capital (Owner's Equity)", "Liabilities - Capital", "Net Profit + Revenue", "Gross Profit - Expenses"};
            return new String[]{"Going Concern Concept", "Money Measurement Concept", "Accounting Period Concept", "Cost Concept"};
        } else if ("Commerce".equalsIgnoreCase(subject) || "Business Studies".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return new String[]{"Henri Fayol", "F.W. Taylor", "Peter Drucker", "Adam Smith"};
            if (qIdx == 2) return new String[]{"Joint Stock Company", "Sole Proprietorship", "Partnership", "HUF"};
            if (qIdx == 3) return new String[]{"Product, Price, Place, Promotion", "Planning, Power, People, Price", "Profit, Production, Price, Place", "Promotion, Publicity, Policy, Price"};
            if (qIdx == 4) return new String[]{"SEBI (Securities and Exchange Board of India)", "RBI", "IRDAI", "NITI Aayog"};
            return new String[]{"Planning", "Organising", "Staffing", "Controlling"};
        } else if ("Economics".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return new String[]{"Increases (Inverse relationship)", "Decreases", "Remains constant", "Becomes zero"};
            if (qIdx == 2) return new String[]{"Gross Domestic Product", "General Demand Price", "Government Debt Policy", "Global Development Plan"};
            if (qIdx == 3) return new String[]{"Reserve Bank of India (RBI)", "State Bank of India", "Ministry of Finance", "SEBI"};
            if (qIdx == 4) return new String[]{"Opportunity Cost", "Marginal Cost", "Fixed Cost", "Sunk Cost"};
            return new String[]{"Monopoly", "Perfect Competition", "Monopolistic Competition", "Duopoly"};
        } else if ("Statistics".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return new String[]{"Mode", "Mean", "Median", "Range"};
            if (qIdx == 2) return new String[]{"Standard Deviation (sigma)", "Mean Deviation", "Variance Square", "Quartile Deviation"};
            if (qIdx == 3) return new String[]{"-1 and +1", "0 and 1", "-Infinity and +Infinity", "0 and 100"};
            if (qIdx == 4) return new String[]{"1 (Certainty)", "0", "100", "0.5"};
            return new String[]{"Laspeyres Index", "Paasche Index", "Fisher Index", "Marshall-Edgeworth Index"};
        } else if ("History".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return new String[]{"Mohenjo-daro", "Harappa", "Kalibangan", "Lothal"};
            if (qIdx == 2) return new String[]{"Chandragupta Maurya (guided by Chanakya)", "Ashoka the Great", "Bindusara", "Samudragupta"};
            if (qIdx == 3) return new String[]{"1857", "1947", "1757", "1920"};
            if (qIdx == 4) return new String[]{"Dr. B.R. Ambedkar", "Dr. Rajendra Prasad", "Jawaharlal Nehru", "Sardar Vallabhbhai Patel"};
            return new String[]{"1930", "1942", "1919", "1922"};
        } else if ("Social Science".equalsIgnoreCase(subject)) {
            if (classLevel <= 5) {
                if (qIdx == 1) return new String[]{"New Delhi", "Mumbai", "Kolkata", "Chennai"};
                if (qIdx == 2) return new String[]{"7 Continents", "5 Continents", "6 Continents", "8 Continents"};
                if (qIdx == 3) return new String[]{"Pacific Ocean", "Indian Ocean", "Atlantic Ocean", "Arctic Ocean"};
                if (qIdx == 4) return new String[]{"Jawaharlal Nehru", "Mahatma Gandhi", "Dr. B. R. Ambedkar", "Sardar Patel"};
                return new String[]{"East", "West", "North", "South"};
            } else if (classLevel <= 8) {
                if (qIdx == 1) return new String[]{"Dr. B. R. Ambedkar", "Mahatma Gandhi", "Jawaharlal Nehru", "Subhash Chandra Bose"};
                if (qIdx == 2) return new String[]{"1947", "1950", "1942", "1935"};
                if (qIdx == 3) return new String[]{"The Parliament of India", "Supreme Court", "Election Commission", "Armed Forces"};
                if (qIdx == 4) return new String[]{"Indus Valley (Harappan) Civilization", "Mesopotamia", "Ancient Egypt", "Maya Civilization"};
                return new String[]{"Equator", "Tropic of Cancer", "Prime Meridian", "Arctic Circle"};
            } else {
                if (qIdx == 1) return new String[]{"The French Revolution", "The Russian Revolution", "Industrial Revolution", "American Revolution"};
                if (qIdx == 2) return new String[]{"Democratic Parliamentary Republic", "Monarchy", "Military Dictatorship", "Oligarchy"};
                if (qIdx == 3) return new String[]{"Primary Sector", "Secondary Sector", "Tertiary Sector", "Quaternary Sector"};
                if (qIdx == 4) return new String[]{"18 years", "21 years", "25 years", "16 years"};
                return new String[]{"The Himalayas", "Western Ghats", "Aravalli Range", "Vindhya Range"};
            }
        } else if ("English".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return new String[]{"Teacher / Students", "Dedicated", "Guided", "The"};
            if (qIdx == 2) return new String[]{"Cowardly / Timid", "Brave", "Heroic", "Strong"};
            if (qIdx == 3) return new String[]{"Wrote", "Written", "Writing", "Writes"};
            if (qIdx == 4) return new String[]{"Adverb", "Noun", "Pronoun", "Preposition"};
            return new String[]{"Huge / Enormous", "Tiny", "Short", "Narrow"};
        } else {
            // CS / IP / CA
            if (classLevel <= 8) {
                if (qIdx == 1) return new String[]{"Central Processing Unit", "Central Power Unit", "Computer Program Unit", "Control Process Unit"};
                if (qIdx == 2) return new String[]{"8 bits", "4 bits", "16 bits", "32 bits"};
                if (qIdx == 3) return new String[]{"print()", "echo()", "display()", "write()"};
                if (qIdx == 4) return new String[]{"HyperText Markup Language", "HighText Machine Language", "Hyperlink Text Mode Language", "Home Tool Markup Language"};
                return new String[]{"Bus Topology", "Star Topology", "Ring Topology", "Mesh Topology"};
            } else if (classLevel <= 10) {
                if (qIdx == 1) return new String[]{"3", "2", "4", "Error"};
                if (qIdx == 2) return new String[]{"SELECT", "FETCH", "GET", "RETRIEVE"};
                if (qIdx == 3) return new String[]{"href", "src", "link", "target"};
                if (qIdx == 4) return new String[]{"while loop", "for loop", "do-until", "switch"};
                return new String[]{"HTTPS", "HTTP", "FTP", "SMTP"};
            } else {
                if (qIdx == 1) return new String[]{"List", "Tuple", "String", "FrozenSet"};
                if (qIdx == 2) return new String[]{"O(log n)", "O(n)", "O(n^2)", "O(1)"};
                if (qIdx == 3) return new String[]{"HAVING", "WHERE", "ORDER BY", "LIMIT"};
                if (qIdx == 4) return new String[]{"try ... except", "catch ... throw", "test ... handle", "error ... trap"};
                return new String[]{"Network Layer (Layer 3)", "Transport Layer", "Data Link Layer", "Physical Layer"};
            }
        }
    }

    private String getFillBlankText(int classLevel, String subject, String chName, int qIdx) {
        if ("Tamil".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "திருக்குறளில் உள்ள மொத்த அதிகாரங்களின் எண்ணிக்கை _______ ஆகும்.";
            if (qIdx == 2) return "தமிழ் எழுத்துக்களில் ஆய்த எழுத்து _______ எனப்படும்.";
            if (qIdx == 3) return "தமிழ்த் தாயை வாழ்த்திப் பாடிய மனோன்மணீயம் சுந்தரனார் இயற்றிய பாடல் தமிழ்த்தாய் _______.";
            if (qIdx == 4) return "தொல்காப்பியம் தமிழ் மொழியின் மிகத் தொன்மையான _______ நூல் ஆகும்.";
            return "வள்ளுவன் தன்னை உலகினுக்கே தந்து வான்புகழ் கொண்ட தமிழ்நாடு என்றவர் _______.";
        } else if ("Mathematics".equalsIgnoreCase(subject) || "Business Mathematics".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "A triangle has exactly _______ sides and three vertices.";
            if (qIdx == 2) return "1 kilogram is equal to _______ grams.";
            if (qIdx == 3) return "The product of multiplying any number by zero is always _______.";
            if (qIdx == 4) return "A right angle measures exactly _______ degrees.";
            return "100 divided by 4 equals _______.";
        } else if ("Physics".equalsIgnoreCase(subject) || "Chemistry".equalsIgnoreCase(subject) || "Science".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "The green pigment in plant leaves that absorbs sunlight is _______.";
            if (qIdx == 2) return "Water boils at _______ degrees Celsius at sea level.";
            if (qIdx == 3) return "The SI unit of electric potential difference / voltage is the _______.";
            if (qIdx == 4) return "The center organ of the human circulatory system that pumps blood is the _______.";
            return "The smallest unit of a chemical element that retains its identity is an _______.";
        } else if ("Accountancy".equalsIgnoreCase(subject) || "Commerce".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "The book in which accounts are maintained permanently is the _______.";
            if (qIdx == 2) return "Debit all expenses and losses, Credit all incomes and _______.";
            if (qIdx == 3) return "The Reserve Bank of India was established in the year 1935 in the month of _______.";
            if (qIdx == 4) return "Fayol formulated _______ principles of management.";
            return "The excess of assets over liabilities is called _______.";
        } else if ("Economics".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "GDP stands for Gross _______ Product.";
            if (qIdx == 2) return "The apex bank of India is the _______ Bank of India.";
            if (qIdx == 3) return "When supply exceeds demand, the price tends to _______.";
            if (qIdx == 4) return "The economic reforms of LPG in India were introduced in the year _______.";
            return "India has a _______ economy model combining private and public sectors.";
        } else if ("Social Science".equalsIgnoreCase(subject) || "History".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "The capital city of India is New _______.";
            if (qIdx == 2) return "There are _______ states in the Republic of India.";
            if (qIdx == 3) return "The national bird of India is the _______.";
            if (qIdx == 4) return "The true three-dimensional model of the Earth is a _______.";
            return "India gained Independence on 15th _______ 1947.";
        } else if ("English".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "The plural form of 'Child' is _______.";
            if (qIdx == 2) return "The past tense of the verb 'Go' is _______.";
            if (qIdx == 3) return "A word that describes or modifies a noun is called an _______.";
            if (qIdx == 4) return "The opposite of 'Strong' is _______.";
            return "A sentence always begins with a _______ letter.";
        } else {
            // CS / IP / CA
            if (qIdx == 1) return "RAM stands for Random Access _______.";
            if (qIdx == 2) return "1 Byte is composed of _______ binary bits.";
            if (qIdx == 3) return "The physical machinery and components of a computer are known as _______.";
            if (qIdx == 4) return "In Windows, Ctrl + _______ is the shortcut key to save a document.";
            return "The central brain of the computer that processes calculations is the _______.";
        }
    }

    private String getFillBlankAnswer(int classLevel, String subject, String chName, int qIdx) {
        if ("Tamil".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "133";
            if (qIdx == 2) return "ஃ";
            if (qIdx == 3) return "வாழ்த்து";
            if (qIdx == 4) return "இலக்கண";
            return "பாரதியார்";
        } else if ("Mathematics".equalsIgnoreCase(subject) || "Business Mathematics".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "3";
            if (qIdx == 2) return "1000";
            if (qIdx == 3) return "0";
            if (qIdx == 4) return "90";
            return "25";
        } else if ("Physics".equalsIgnoreCase(subject) || "Chemistry".equalsIgnoreCase(subject) || "Science".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "Chlorophyll";
            if (qIdx == 2) return "100";
            if (qIdx == 3) return "Volt";
            if (qIdx == 4) return "Heart";
            return "Atom";
        } else if ("Accountancy".equalsIgnoreCase(subject) || "Commerce".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "Ledger";
            if (qIdx == 2) return "Gains";
            if (qIdx == 3) return "April";
            if (qIdx == 4) return "14";
            return "Capital";
        } else if ("Economics".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "Domestic";
            if (qIdx == 2) return "Reserve";
            if (qIdx == 3) return "Fall";
            if (qIdx == 4) return "1991";
            return "Mixed";
        } else if ("Social Science".equalsIgnoreCase(subject) || "History".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "Delhi";
            if (qIdx == 2) return "28";
            if (qIdx == 3) return "Peacock";
            if (qIdx == 4) return "Globe";
            return "August";
        } else if ("English".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "Children";
            if (qIdx == 2) return "Went";
            if (qIdx == 3) return "Adjective";
            if (qIdx == 4) return "Weak";
            return "Capital";
        } else {
            // CS / IP / CA
            if (qIdx == 1) return "Memory";
            if (qIdx == 2) return "8";
            if (qIdx == 3) return "Hardware";
            if (qIdx == 4) return "S";
            return "CPU";
        }
    }

    private String getScenarioText(int classLevel, String subject, String chName, int qIdx) {
        if ("Tamil".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "ஒருவர் பிறருக்கு உதவி செய்யும்போது எவ்வித கைம்மாறும் எதிர்பாராமல் செய்ய வேண்டும் என்பதை உணர்த்தும் குறள் எது?";
            if (qIdx == 2) return "பள்ளி ஆண்டுவிழாவில் தமிழ் தாய் வாழ்த்துப் பாடும்போது மாணவர்கள் கடைப்பிடிக்க வேண்டிய மரபு யாது?";
            if (qIdx == 3) return "ஒரு கடிதத்தில் பெரியோர்களை விளிக்கும்போது பயன்படுத்த வேண்டிய மரியாதைச் சொல் யாது?";
            if (qIdx == 4) return "நூலகத்தில் அமைதியாகப் படித்து குறிப்பெடுப்பதன் முக்கியப் பயன் யாது?";
            return "தூய தமிழில் கலைச்சொற்களைப் பயன்படுத்தி உரையாடுவதன் சிறப்பு யாது?";
        } else if ("Mathematics".equalsIgnoreCase(subject) || "Business Mathematics".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "A student wants to fence a square vegetable garden of side 8 meters. How many meters of wire are needed?";
            if (qIdx == 2) return "A school bus starts at 8:15 AM and reaches the science exhibition at 9:00 AM. How long did the trip take?";
            if (qIdx == 3) return "If 5 equal boxes contain 250 books in total, how many books are stored in 1 single box?";
            if (qIdx == 4) return "A book with 200 pages was read halfway by Riya. How many pages does she have left to read?";
            return "A merchant bought an educational item for 150 rupees and sold it for 200 rupees. What was his profit?";
        } else if ("Physics".equalsIgnoreCase(subject) || "Chemistry".equalsIgnoreCase(subject) || "Science".equalsIgnoreCase(subject) || "EVS".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "A potted green plant is kept inside a dark room without sunlight for two weeks. What happens to its leaves?";
            if (qIdx == 2) return "You need to measure the temperature of a patient suffering from fever. Which instrument should you use?";
            if (qIdx == 3) return "A torch bulb does not glow when the switch is closed because a wire is disconnected. What circuit is this?";
            if (qIdx == 4) return "Why do ice cubes float on the surface of liquid water in a drinking glass?";
            return "Why do motor vehicles use convex rear-view mirrors instead of flat plane mirrors?";
        } else if ("Accountancy".equalsIgnoreCase(subject) || "Commerce".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "A trader sells goods worth 50,000 rupees on cash basis. Which two accounts are affected?";
            if (qIdx == 2) return "A machinery costing 1,00,000 rupees depreciates at 10% per annum under straight line method. What is the annual depreciation?";
            if (qIdx == 3) return "A bank account holder receives interest credited directly by the bank. How will this be adjusted in the Cash Book?";
            if (qIdx == 4) return "A consumer was sold a defective product and the seller refuses replacement. Which forum should the consumer approach?";
            return "Why is it mandatory for public limited companies to audit their annual financial accounts?";
        } else if ("Economics".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "Due to severe drought, onion crop yields dropped significantly while consumer demand stayed high. What will happen to onion prices?";
            if (qIdx == 2) return "To curb rising inflation in the economy, what monetary policy action does the Reserve Bank of India usually take?";
            if (qIdx == 3) return "A farmer decides to use his 5 acres of land to grow organic wheat instead of sugarcane. What economic cost is involved?";
            if (qIdx == 4) return "Why does the government allocate substantial funds to public healthcare and free school education in the annual budget?";
            return "Why is foreign exchange reserve management vital for maintaining the value of the Indian Rupee in international trade?";
        } else if ("Social Science".equalsIgnoreCase(subject) || "History".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "A traveler in the open desert needs to determine the North direction at night. Which celestial star should they identify?";
            if (qIdx == 2) return "A city is facing summer groundwater depletion. Which rainwater harvesting practice helps recharge deep aquifers?";
            if (qIdx == 3) return "A young Indian citizen turns 18 years old. Which fundamental democratic right do they now obtain?";
            if (qIdx == 4) return "Why are national wildlife sanctuaries and biosphere reserves strictly protected by government wildlife departments?";
            return "Why is the Preamble considered the guiding soul and foundational summary of the Indian Constitution?";
        } else if ("English".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "You want to write a formal leave letter to your school principal requesting two days of leave. What format is essential?";
            if (qIdx == 2) return "Which spoken sentence expresses a polite and courteous request in formal conversation?";
            if (qIdx == 3) return "Identify the correctly punctuated direct speech sentence:";
            if (qIdx == 4) return "What is the most effective approach when summarizing a long reading comprehension passage?";
            return "Why is proofreading thoroughly important before final submission of an exam paper or essay?";
        } else {
            // CS / IP / CA
            if (qIdx == 1) return "You need to carry a 4 GB school science project from your home computer to the lab. Which portable medium is best?";
            if (qIdx == 2) return "An unexpected email from an unknown sender asks you to provide your secret login password. What must you do?";
            if (qIdx == 3) return "A student accidentally deleted two paragraphs while editing their essay in a word processor. Which shortcut undoes it?";
            if (qIdx == 4) return "Why should students maintain proper sitting posture and take regular eye breaks while using computers?";
            return "Why is creating regular backups of important digital study files on cloud storage recommended?";
        }
    }

    private String[] getScenarioOptions(int classLevel, String subject, String chName, int qIdx) {
        if ("Tamil".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return new String[]{"செய்யாமல் செய்த உதவி வையகமும் வானகமும் ஆற்றல் அரிது", "அகர முதல எழுத்தெல்லாம்", "துப்பார்க்குத் துப்பாய", "எப்பொருள் யார்யார்வாய்"};
            if (qIdx == 2) return new String[]{"எழுந்து நின்று அமைதியாகவும் மரியாதையுடனும் நிற்றல்", "பேசிக்கொண்டே இருத்தல்", "அமர்ந்திருத்தல்", "கைதட்டுதல்"};
            if (qIdx == 3) return new String[]{"மதிப்பிற்குரிய / மரியாதைக்குரிய", "வணக்கம் நண்பா", "ஹலோ", "ஏய்"};
            if (qIdx == 4) return new String[]{"ஆழ்ந்த அறிவையும் சொல்வளத்தையும் வளர்த்துக்கொள்ளுதல்", "நேரத்தை வீணாக்குதல்", "புத்தகங்களை அடுக்குதல்", "அமைதியாக உறங்குதல்"};
            return new String[]{"தாய்மொழிப் பற்றையும் தமிழ் மொழி வளத்தையும் பாதுகாத்தல்", "பிற மொழிகளை வெறுத்தல்", "பேச்சை குறைத்தல்", "வேகமாகப் பேசுதல்"};
        } else if ("Mathematics".equalsIgnoreCase(subject) || "Business Mathematics".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return new String[]{"32 meters (4 x 8m)", "16 meters", "64 meters", "24 meters"};
            if (qIdx == 2) return new String[]{"45 minutes", "30 minutes", "60 minutes", "15 minutes"};
            if (qIdx == 3) return new String[]{"50 books", "40 books", "60 books", "25 books"};
            if (qIdx == 4) return new String[]{"100 pages", "50 pages", "150 pages", "80 pages"};
            return new String[]{"50 rupees", "25 rupees", "100 rupees", "75 rupees"};
        } else if ("Physics".equalsIgnoreCase(subject) || "Chemistry".equalsIgnoreCase(subject) || "Science".equalsIgnoreCase(subject) || "EVS".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return new String[]{"Leaves turn yellow and wither due to lack of photosynthesis", "Leaves turn dark green", "Plant produces flowers", "No change occurs"};
            if (qIdx == 2) return new String[]{"Clinical Thermometer", "Barometer", "Speedometer", "Ammeter"};
            if (qIdx == 3) return new String[]{"Open Circuit (broken path)", "Closed Circuit", "Short Circuit", "Parallel Circuit"};
            if (qIdx == 4) return new String[]{"Ice has lower density than liquid water", "Ice is heavier than water", "Ice contains air only", "Ice is warm"};
            return new String[]{"Convex mirrors provide a wider field of view and erect images", "Convex mirrors make cars look bright", "Plane mirrors break easily", "Convex mirrors magnify images upside down"};
        } else if ("Accountancy".equalsIgnoreCase(subject) || "Commerce".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return new String[]{"Cash Account (Debited) and Sales Account (Credited)", "Purchases and Sales", "Capital and Cash", "Debtors and Creditors"};
            if (qIdx == 2) return new String[]{"10,000 rupees per year", "5,000 rupees", "20,000 rupees", "1,000 rupees"};
            if (qIdx == 3) return new String[]{"Debit the Cash Book to record the increase in bank balance", "Credit the Cash Book", "Ignore entry", "Subtract from sales"};
            if (qIdx == 4) return new String[]{"District Consumer Disputes Redressal Commission", "Police Station", "Civil Court", "High Court"};
            return new String[]{"To ensure true and fair view of accounts and safeguard stakeholders", "To pay higher taxes", "To hide profits", "To delay reports"};
        } else if ("Economics".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return new String[]{"Onion prices will rise due to shortage in supply", "Onion prices will fall", "Prices will stay unchanged", "Demand will drop to zero"};
            if (qIdx == 2) return new String[]{"RBI raises policy Repo Rate to absorb excess market liquidity", "RBI prints more currency notes", "RBI lowers interest rates", "RBI bans commercial banks"};
            if (qIdx == 3) return new String[]{"Opportunity Cost (the value of sugarcane forgone)", "Sunk Cost", "Fixed Cost", "Nominal Cost"};
            if (qIdx == 4) return new String[]{"To build human capital, reduce inequality, and spur long-term economic growth", "To earn profit", "To reduce population", "To eliminate private schools"};
            return new String[]{"To ensure national economic stability and pay for essential imports (crude oil)", "To print gold coins", "To loan to other countries", "To buy shares"};
        } else if ("Social Science".equalsIgnoreCase(subject) || "History".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return new String[]{"The North Star (Pole Star / Polaris)", "Sirius", "Mars", "Venus"};
            if (qIdx == 2) return new String[]{"Rooftop Rainwater Harvesting and Percolation Injection Wells", "Draining water onto tarmac roads", "Using plastic sheets", "Cutting down trees"};
            if (qIdx == 3) return new String[]{"Universal Adult Suffrage (Right to Vote)", "Right to Property", "Right to Arbitrary Arrest", "Right to Tax"};
            if (qIdx == 4) return new String[]{"To conserve biodiversity, protect endangered species, and preserve ecological balance", "To build industrial factories", "To sell timber", "To build amusement parks"};
            return new String[]{"It articulates the core constitutional values, sovereignty, justice, and liberty", "It lists the names of ministers", "It is the longest chapter", "It contains stories"};
        } else if ("English".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return new String[]{"Formal Letter with Sender Address, Date, Principal Salutation, Subject, Body, and Signature", "Informal Letter with slangs", "Postcard with drawings", "Casual SMS message"};
            if (qIdx == 2) return new String[]{"'Could you please guide me through this question?'", "'Do this for me right now.'", "'I order you.'", "'Help me quickly!'"};
            if (qIdx == 3) return new String[]{"The teacher said, \\\"Work hard and believe in yourself.\\\"", "The teacher said work hard.", "The teacher \\\"said work hard\\\".", "\\\"The teacher said\\\" work hard."};
            if (qIdx == 4) return new String[]{"Identify main core ideas and express them in concise, coherent words", "Copy the entire paragraph verbatim twice", "Delete all punctuation", "Change all nouns to adjectives"};
            return new String[]{"To identify and eliminate errors in grammar, spelling, and sentence coherence", "To make the text longer", "To change font colors", "To delete the document"};
        } else {
            // CS / IP / CA
            if (qIdx == 1) return new String[]{"USB Flash Pen Drive or Secure Cloud Storage", "Printed paper sheets", "Internal RAM module", "Monitor power cable"};
            if (qIdx == 2) return new String[]{"Never share your credentials and report the email as a phishing attempt", "Reply with your password immediately", "Send password to friends", "Ignore all security"};
            if (qIdx == 3) return new String[]{"Ctrl + Z (Undo shortcut)", "Ctrl + S", "Ctrl + P", "Ctrl + C"};
            if (qIdx == 4) return new String[]{"To prevent eye fatigue, repetitive strain, and maintain physical ergonomics", "To drain device battery", "To make computer sleep", "To disconnect internet"};
            return new String[]{"To protect against irreversible data loss caused by hardware malfunction or ransomware", "To slow down storage", "To delete old applications", "To fill disk space"};
        }
    }
}
`;

  return java;
}

const javaCode = generateJavaSeeder();
const targetPath = path.join(__dirname, 'LearnQuestCurriculumSeeder.java');
fs.writeFileSync(targetPath, javaCode);
console.log('Successfully generated complete LearnQuestCurriculumSeeder.java at ' + targetPath);
