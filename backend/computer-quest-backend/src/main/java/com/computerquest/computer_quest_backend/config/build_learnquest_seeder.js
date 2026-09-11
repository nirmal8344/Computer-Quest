const fs = require('fs');
const path = require('path');

// Complete syllabus matrix for CBSE & Tamil Nadu State Board (Classes 4-12)
const syllabusMatrix = [
  // =========================================================================
  // CBSE CLASSES 4 TO 12
  // =========================================================================
  {
    board: "CBSE", classLevel: 4,
    subjects: [
      { name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4", units: [
        { name: "Unit 1: Numbers & Geometry", chapters: [
          { num: 1, name: "Building with Bricks & Shapes", q: "Geometry & 3D Shapes" },
          { num: 2, name: "Long and Short: Length Measurement", q: "Distance & Lengths" }
        ]},
        { name: "Unit 2: Operations & Data", chapters: [
          { num: 3, name: "A Trip to Bhopal: Money and Time", q: "Money & Calculation" },
          { num: 4, name: "Tick-Tick-Tick: Clocks & Calendar", q: "Time & Scheduling" }
        ]}
      ]},
      { name: "Science", code: "SCI", icon: "🔬", color: "#20bf6b", units: [
        { name: "Unit 1: Living Organisms & Habitats", chapters: [
          { num: 1, name: "Going to School & Animal Senses", q: "Animal Habitats & Senses" },
          { num: 2, name: "A Day with Nandu: Elephants & Herds", q: "Wildlife Behavior" }
        ]},
        { name: "Unit 2: Plants & Environment", chapters: [
          { num: 3, name: "The Story of Amrita: Trees and Forest", q: "Forest Conservation" },
          { num: 4, name: "Anita and the Honeybees: Insects", q: "Insects & Pollination" }
        ]}
      ]},
      { name: "Social Science", code: "SOC", icon: "🌍", color: "#eb4d4b", units: [
        { name: "Unit 1: Our Geography & Environment", chapters: [
          { num: 1, name: "Our Earth, Continents and Oceans", q: "Landforms & Water" },
          { num: 2, name: "Directions, Maps and Globes", q: "Cartography & Navigation" }
        ]},
        { name: "Unit 2: Community & Governance", chapters: [
          { num: 3, name: "Community Helpers & Public Services", q: "Civic Roles" },
          { num: 4, name: "National Symbols & Festivals of India", q: "National Heritage" }
        ]}
      ]},
      { name: "English", code: "ENG", icon: "📖", color: "#fa8231", units: [
        { name: "Unit 1: Stories & Grammar Basics", chapters: [
          { num: 1, name: "Neha's Alarm Clock & Nouns", q: "Reading & Nouns" },
          { num: 2, name: "The Little Fir Tree & Adjectives", q: "Descriptions & Grammar" }
        ]},
        { name: "Unit 2: Comprehension & Expression", chapters: [
          { num: 3, name: "Nasruddin's Aim & Verbs", q: "Action Words" },
          { num: 4, name: "Alice in Wonderland & Punctuation", q: "Sentences & Marks" }
        ]}
      ]},
      { name: "Computer Science", code: "CS", icon: "💻", color: "#0984e3", units: [
        { name: "Unit 1: Hardware & Storage", chapters: [
          { num: 1, name: "Evolution of Computers & Input Devices", q: "Hardware Devices" },
          { num: 2, name: "Computer Memory: RAM and Storage", q: "Bits & Bytes" }
        ]},
        { name: "Unit 2: Software & Creative Tools", chapters: [
          { num: 3, name: "Working with Windows Operating System", q: "Files & Folders" },
          { num: 4, name: "Introduction to MS Paint & Typing", q: "Digital Art & Typing" }
        ]}
      ]}
    ]
  },

  {
    board: "CBSE", classLevel: 5,
    subjects: [
      { name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4", units: [
        { name: "Unit 1: Arithmetic & Geometry", chapters: [
          { num: 1, name: "The Fish Tale: Large Numbers & Speed", q: "Large Numbers" },
          { num: 2, name: "Shapes and Angles: Geometry Basics", q: "Angles & Vertices" }
        ]},
        { name: "Unit 2: Fractions & Patterns", chapters: [
          { num: 3, name: "Parts and Wholes: Fractions", q: "Fractions & Decimals" },
          { num: 4, name: "Factors and Multiples: Number Theory", q: "LCM & HCF" }
        ]}
      ]},
      { name: "Science", code: "SCI", icon: "🔬", color: "#20bf6b", units: [
        { name: "Unit 1: Human Body & Nutrition", chapters: [
          { num: 1, name: "Super Senses: Vision, Smell & Hearing", q: "Animal Senses" },
          { num: 2, name: "From Tasting to Digesting: Digestion", q: "Digestive System" }
        ]},
        { name: "Unit 2: Ecology & Natural Resources", chapters: [
          { num: 3, name: "Seeds and Seeds: Plant Germination", q: "Plant Reproduction" },
          { num: 4, name: "Every Drop Counts: Water Conservation", q: "Water Cycle" }
        ]}
      ]},
      { name: "Social Science", code: "SOC", icon: "🌍", color: "#eb4d4b", units: [
        { name: "Unit 1: Natural Heritage & Disasters", chapters: [
          { num: 1, name: "Walls Tell Stories: Historical Monuments", q: "Archaeology" },
          { num: 2, name: "When the Earth Shook: Natural Calamities", q: "Earthquakes & Relief" }
        ]},
        { name: "Unit 2: Exploration & Environment", chapters: [
          { num: 3, name: "Sunita in Space: Space Exploration", q: "Astronomy & Gravity" },
          { num: 4, name: "Whose Forests: Tribal Culture & Trees", q: "Forest Ecosystems" }
        ]}
      ]},
      { name: "English", code: "ENG", icon: "📖", color: "#fa8231", units: [
        { name: "Unit 1: Literature & Tenses", chapters: [
          { num: 1, name: "Wonderful Waste & Verb Tenses", q: "Vocabulary & Tenses" },
          { num: 2, name: "Flying Together & Pronouns", q: "Grammar & Pronouns" }
        ]},
        { name: "Unit 2: Adventures & Syntax", chapters: [
          { num: 3, name: "Robinson Crusoe & Prepositions", q: "Prepositions" },
          { num: 4, name: "Rip Van Winkle & Conjunctions", q: "Conjunctions" }
        ]}
      ]},
      { name: "Computer Science", code: "CS", icon: "💻", color: "#0984e3", units: [
        { name: "Unit 1: Digital Media & Productivity", chapters: [
          { num: 1, name: "Generations of Computers & Architecture", q: "Computer Generations" },
          { num: 2, name: "Word Processing: Formatting Documents", q: "MS Word Tools" }
        ]},
        { name: "Unit 2: Multimedia & Internet", chapters: [
          { num: 3, name: "PowerPoint Presentations: Slides & Animation", q: "Presentations" },
          { num: 4, name: "Internet Browsing & Cyber Safety", q: "Web & Netiquette" }
        ]}
      ]}
    ]
  },

  {
    board: "CBSE", classLevel: 6,
    subjects: [
      { name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4", units: [
        { name: "Unit 1: Number Systems & Geometry", chapters: [
          { num: 1, name: "Knowing Our Numbers & Large Numbers", q: "Place Value & Rounding" },
          { num: 2, name: "Whole Numbers & Integers", q: "Properties of Integers" }
        ]},
        { name: "Unit 2: Algebra & Measurements", chapters: [
          { num: 3, name: "Fractions and Decimals", q: "Fraction Operations" },
          { num: 4, name: "Introduction to Algebra & Mensuration", q: "Variables & Perimeters" }
        ]}
      ]},
      { name: "Science", code: "SCI", icon: "🔬", color: "#20bf6b", units: [
        { name: "Unit 1: Food & Materials", chapters: [
          { num: 1, name: "Components of Food: Nutrients & Diet", q: "Carbs, Proteins & Fats" },
          { num: 2, name: "Sorting Materials & Separation of Substances", q: "Filtration & Solution" }
        ]},
        { name: "Unit 2: Living Organisms & Physics", chapters: [
          { num: 3, name: "Getting to Know Plants: Photosynthesis", q: "Roots, Stems & Leaves" },
          { num: 4, name: "Light, Shadows, Electricity and Circuits", q: "Circuits & Optics" }
        ]}
      ]},
      { name: "Social Science", code: "SOC", icon: "🌍", color: "#eb4d4b", units: [
        { name: "Unit 1: Ancient History & Solar System", chapters: [
          { num: 1, name: "From Hunting-Gathering to Earliest Cities", q: "Indus Valley" },
          { num: 2, name: "The Earth in the Solar System & Globe", q: "Latitudes & Longitudes" }
        ]},
        { name: "Unit 2: Government & Society", chapters: [
          { num: 3, name: "Understanding Diversity & Discrimination", q: "Equality & Law" },
          { num: 4, name: "What is Government & Panchayati Raj", q: "Democratic Governance" }
        ]}
      ]},
      { name: "English", code: "ENG", icon: "📖", color: "#fa8231", units: [
        { name: "Unit 1: Prose & Active Grammar", chapters: [
          { num: 1, name: "Who Did Patrick's Homework & Sentences", q: "Sentence Structure" },
          { num: 2, name: "How the Dog Found Himself a Master", q: "Adverbs & Vocabulary" }
        ]},
        { name: "Unit 2: Comprehension & Writing", chapters: [
          { num: 3, name: "Taro's Reward & Conjunctions", q: "Compound Sentences" },
          { num: 4, name: "Kalpana Chawla: In Space & Tenses", q: "Past Perfect Tense" }
        ]}
      ]},
      { name: "Computer Science", code: "CS", icon: "💻", color: "#0984e3", units: [
        { name: "Unit 1: Computer Systems & Software", chapters: [
          { num: 1, name: "Computer Fundamentals & Operating Systems", q: "OS Functions" },
          { num: 2, name: "Spreadsheet Basics: Rows, Columns & Formulas", q: "Excel Basics" }
        ]},
        { name: "Unit 2: Logic & Coding", chapters: [
          { num: 3, name: "Algorithms and Flowcharts", q: "Logical Sequencing" },
          { num: 4, name: "Introduction to Visual Coding & Scratch", q: "Scratch Blocks" }
        ]}
      ]}
    ]
  },

  {
    board: "CBSE", classLevel: 7,
    subjects: [
      { name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4", units: [
        { name: "Unit 1: Arithmetic & Algebra", chapters: [
          { num: 1, name: "Integers & Rational Numbers", q: "Signed Numbers" },
          { num: 2, name: "Fractions, Decimals & Simple Equations", q: "Linear Equations" }
        ]},
        { name: "Unit 2: Geometry & Exponents", chapters: [
          { num: 3, name: "Lines, Angles and Triangles", q: "Angle Properties" },
          { num: 4, name: "Exponents, Powers and Perimeter", q: "Indices & Areas" }
        ]}
      ]},
      { name: "Science", code: "SCI", icon: "🔬", color: "#20bf6b", units: [
        { name: "Unit 1: Life Processes & Chemistry", chapters: [
          { num: 1, name: "Nutrition in Plants and Animals", q: "Autotrophs & Heterotrophs" },
          { num: 2, name: "Acids, Bases, Salts and Physical Changes", q: "Chemical Indicators" }
        ]},
        { name: "Unit 2: Energy & Motion", chapters: [
          { num: 3, name: "Heat and Temperature Transfer", q: "Conduction & Radiation" },
          { num: 4, name: "Motion, Time, Electric Current and Effects", q: "Electromagnetism" }
        ]}
      ]},
      { name: "Social Science", code: "SOC", icon: "🌍", color: "#eb4d4b", units: [
        { name: "Unit 1: Medieval History & Environment", chapters: [
          { num: 1, name: "Kings and Kingdoms & Delhi Sultanate", q: "Medieval India" },
          { num: 2, name: "Our Changing Earth, Air and Water", q: "Atmosphere & Oceans" }
        ]},
        { name: "Unit 2: State Governance & Media", chapters: [
          { num: 3, name: "How the State Government Works", q: "Legislative Assembly" },
          { num: 4, name: "Understanding Media and Markets Around Us", q: "Consumer & Media" }
        ]}
      ]},
      { name: "English", code: "ENG", icon: "📖", color: "#fa8231", units: [
        { name: "Unit 1: Prose & Voice", chapters: [
          { num: 1, name: "Three Questions & Direct/Indirect Speech", q: "Reported Speech" },
          { num: 2, name: "A Gift of Chappals & Active/Passive Voice", q: "Passive Voice" }
        ]},
        { name: "Unit 2: Literature & Composition", chapters: [
          { num: 3, name: "Gopal and the Hilsa Fish & Clauses", q: "Relative Clauses" },
          { num: 4, name: "Quality & Essay Writing Skills", q: "Paragraph Structure" }
        ]}
      ]},
      { name: "Computer Science", code: "CS", icon: "💻", color: "#0984e3", units: [
        { name: "Unit 1: Computer Systems & Architecture", chapters: [
          { num: 1, name: "Hardware Components & Number Systems", q: "Binary System" },
          { num: 2, name: "Spreadsheet Formulas & Data Analysis", q: "Functions & Charts" }
        ]},
        { name: "Unit 2: Programming Fundamentals", chapters: [
          { num: 3, name: "Introduction to Python Programming", q: "Python Syntax" },
          { num: 4, name: "Cyber Ethics, Virus Protection & Netiquette", q: "Digital Safety" }
        ]}
      ]}
    ]
  },

  {
    board: "CBSE", classLevel: 8,
    subjects: [
      { name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4", units: [
        { name: "Unit 1: Number Systems & Algebra", chapters: [
          { num: 1, name: "Rational Numbers & Linear Equations", q: "Linear Expressions" },
          { num: 2, name: "Squares, Cubes & Roots", q: "Square & Cube Roots" }
        ]},
        { name: "Unit 2: Geometry & Mensuration", chapters: [
          { num: 3, name: "Understanding Quadrilaterals & Graphs", q: "Polygon Geometry" },
          { num: 4, name: "Mensuration: Surface Areas & Volumes", q: "3D Mensuration" }
        ]}
      ]},
      { name: "Science", code: "SCI", icon: "🔬", color: "#20bf6b", units: [
        { name: "Unit 1: Agriculture & Microorganisms", chapters: [
          { num: 1, name: "Crop Production and Management", q: "Irrigation & Harvest" },
          { num: 2, name: "Microorganisms: Friend and Foe", q: "Bacteria & Viruses" }
        ]},
        { name: "Unit 2: Physics & Chemistry", chapters: [
          { num: 3, name: "Coal, Petroleum, Combustion & Flame", q: "Fossil Fuels" },
          { num: 4, name: "Force, Pressure, Friction and Sound Waves", q: "Forces & Acoustics" }
        ]}
      ]},
      { name: "Social Science", code: "SOC", icon: "🌍", color: "#eb4d4b", units: [
        { name: "Unit 1: Modern History & Resources", chapters: [
          { num: 1, name: "From Trade to Territory & Revolt of 1857", q: "Colonial Rule" },
          { num: 2, name: "Land, Soil, Water and Mineral Resources", q: "Resource Management" }
        ]},
        { name: "Unit 2: Constitution & Law", chapters: [
          { num: 3, name: "The Indian Constitution & Secularism", q: "Fundamental Rights" },
          { num: 4, name: "Parliament, Judiciary & Social Justice", q: "Legal System" }
        ]}
      ]},
      { name: "English", code: "ENG", icon: "📖", color: "#fa8231", units: [
        { name: "Unit 1: Literature & Advanced Grammar", chapters: [
          { num: 1, name: "The Best Christmas Present & Modals", q: "Modal Auxiliaries" },
          { num: 2, name: "The Tsunami & Conditional Sentences", q: "Conditionals" }
        ]},
        { name: "Unit 2: Essays & Speeches", chapters: [
          { num: 3, name: "Glimpses of the Past & Participles", q: "Participles" },
          { num: 4, name: "The Summit Within & Formal Letters", q: "Formal Writing" }
        ]}
      ]},
      { name: "Computer Science", code: "CS", icon: "💻", color: "#0984e3", units: [
        { name: "Unit 1: Networking & Databases", chapters: [
          { num: 1, name: "Computer Networks & Internet Topologies", q: "LAN, WAN & Routers" },
          { num: 2, name: "Database Concepts & Microsoft Access / SQL", q: "Tables & Queries" }
        ]},
        { name: "Unit 2: Python & App Development", chapters: [
          { num: 3, name: "Python Control Structures: If-Else and Loops", q: "Iteration in Python" },
          { num: 4, name: "Mobile App Concepts & Cybersecurity", q: "Encryption & Privacy" }
        ]}
      ]}
    ]
  },

  {
    board: "CBSE", classLevel: 9,
    subjects: [
      { name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4", units: [
        { name: "Unit 1: Number Systems & Algebra", chapters: [
          { num: 1, name: "Real Numbers & Polynomials", q: "Factor Theorem" },
          { num: 2, name: "Linear Equations in Two Variables", q: "Graphing Lines" }
        ]},
        { name: "Unit 2: Geometry & Mensuration", chapters: [
          { num: 3, name: "Lines, Angles, Triangles & Quadrilaterals", q: "Congruence" },
          { num: 4, name: "Heron's Formula & Surface Areas / Volumes", q: "Geometric Mensuration" }
        ]}
      ]},
      { name: "Science", code: "SCI", icon: "🔬", color: "#20bf6b", units: [
        { name: "Unit 1: Matter & Cellular Biology", chapters: [
          { num: 1, name: "Matter in Our Surroundings & Atomic Structure", q: "Atomic Models" },
          { num: 2, name: "The Fundamental Unit of Life: Cell & Tissues", q: "Cell Organelles" }
        ]},
        { name: "Unit 2: Motion, Force & Energy", chapters: [
          { num: 3, name: "Motion, Force and Newton's Laws", q: "Kinematics & Inertia" },
          { num: 4, name: "Gravitation, Work, Energy and Sound", q: "Universal Gravity" }
        ]}
      ]},
      { name: "Social Science", code: "SOC", icon: "🌍", color: "#eb4d4b", units: [
        { name: "Unit 1: World History & Physical Geography", chapters: [
          { num: 1, name: "The French Revolution & Socialism in Europe", q: "Modern History" },
          { num: 2, name: "India: Size, Location & Physical Features", q: "Himalayas & Plains" }
        ]},
        { name: "Unit 2: Democratic Politics & Economics", chapters: [
          { num: 3, name: "What is Democracy & Constitutional Design", q: "Democratic Rights" },
          { num: 4, name: "People as Resource & Poverty in India", q: "Human Capital" }
        ]}
      ]},
      { name: "English", code: "ENG", icon: "📖", color: "#fa8231", units: [
        { name: "Unit 1: Literature & Analytical Reading", chapters: [
          { num: 1, name: "The Fun They Had & Clauses", q: "Noun & Adverb Clauses" },
          { num: 2, name: "The Sound of Music & Subject-Verb Agreement", q: "Syntax Agreement" }
        ]},
        { name: "Unit 2: Composition & Critical Thinking", chapters: [
          { num: 3, name: "A Truly Beautiful Mind: Einstein & Modals", q: "Complex Modals" },
          { num: 4, name: "The Snake and the Mirror & Reported Speech", q: "Indirect Speech" }
        ]}
      ]},
      { name: "Information Technology", code: "IT", icon: "💻", color: "#0984e3", units: [
        { name: "Unit 1: IT Fundamentals & Productivity", chapters: [
          { num: 1, name: "Computer Systems, Architecture & OS", q: "CPU & OS Architecture" },
          { num: 2, name: "Digital Documentation & Spreadsheets", q: "Advanced Formatting" }
        ]},
        { name: "Unit 2: Programming & Digital Safety", chapters: [
          { num: 3, name: "Python Programming Basics & Data Types", q: "Lists & Loops" },
          { num: 4, name: "Cyber Safety, IT Laws & Digital Literacy", q: "IT Act & Security" }
        ]}
      ]}
    ]
  },

  {
    board: "CBSE", classLevel: 10,
    subjects: [
      { name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4", units: [
        { name: "Unit 1: Algebra & Trigonometry", chapters: [
          { num: 1, name: "Real Numbers, Polynomials & Quadratic Equations", q: "Quadratic Formula" },
          { num: 2, name: "Arithmetic Progressions & Trigonometry", q: "Trigonometric Ratios" }
        ]},
        { name: "Unit 2: Coordinate Geometry & Mensuration", chapters: [
          { num: 3, name: "Coordinate Geometry, Triangles & Circles", q: "Section Formula" },
          { num: 4, name: "Surface Areas, Volumes, Statistics & Probability", q: "Probability & Volumes" }
        ]}
      ]},
      { name: "Science", code: "SCI", icon: "🔬", color: "#20bf6b", units: [
        { name: "Unit 1: Chemical Reactions & Life Processes", chapters: [
          { num: 1, name: "Chemical Reactions, Acids, Bases & Metals", q: "Redox & Neutralization" },
          { num: 2, name: "Life Processes: Nutrition, Respiration & Transport", q: "Circulation & Excretion" }
        ]},
        { name: "Unit 2: Physics & Genetics", chapters: [
          { num: 3, name: "Light: Reflection, Refraction & Human Eye", q: "Lens & Mirror Formulas" },
          { num: 4, name: "Electricity, Magnetism & Heredity", q: "Ohm's Law & Genetics" }
        ]}
      ]},
      { name: "Social Science", code: "SOC", icon: "🌍", color: "#eb4d4b", units: [
        { name: "Unit 1: Nationalism & Economic Resources", chapters: [
          { num: 1, name: "Rise of Nationalism in Europe & India", q: "Indian Independence" },
          { num: 2, name: "Resources, Agriculture & Manufacturing Industries", q: "Industrial Economy" }
        ]},
        { name: "Unit 2: Governance & Global Economy", chapters: [
          { num: 3, name: "Power Sharing, Federalism & Political Parties", q: "Federal Structure" },
          { num: 4, name: "Sectors of Economy, Money & Globalisation", q: "Monetary Systems" }
        ]}
      ]},
      { name: "English", code: "ENG", icon: "📖", color: "#fa8231", units: [
        { name: "Unit 1: Literature & Advanced Syntax", chapters: [
          { num: 1, name: "A Letter to God & Tenses Revision", q: "Advanced Tenses" },
          { num: 2, name: "Nelson Mandela: Long Walk to Freedom", q: "Rhetorical Devices" }
        ]},
        { name: "Unit 2: Critical Composition", chapters: [
          { num: 3, name: "Two Stories about Flying & Direct/Indirect", q: "Direct/Indirect" },
          { num: 4, name: "From the Diary of Anne Frank & Formal Reports", q: "Report Writing" }
        ]}
      ]},
      { name: "Information Technology", code: "IT", icon: "💻", color: "#0984e3", units: [
        { name: "Unit 1: Web Applications & Databases", chapters: [
          { num: 1, name: "Web Applications, HTML5 & CSS Basics", q: "Web Development" },
          { num: 2, name: "Relational Databases & SQL Queries", q: "SQL SELECT & JOIN" }
        ]},
        { name: "Unit 2: Python Programming & Cyber Ethics", chapters: [
          { num: 3, name: "Python Functions, Lists and Dictionaries", q: "Python Data Structures" },
          { num: 4, name: "Cyber Ethics, Netiquette & Data Protection", q: "Cyber Crimes & IP" }
        ]}
      ]}
    ]
  },

  {
    board: "CBSE", classLevel: 11,
    subjects: [
      { name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4", units: [
        { name: "Unit 1: Sets, Relations & Calculus", chapters: [
          { num: 1, name: "Sets, Relations, Functions & Trigonometry", q: "Set Operations" },
          { num: 2, name: "Complex Numbers, Quadratic Equations & Permutations", q: "Combinatorics" }
        ]},
        { name: "Unit 2: Coordinate Geometry & Limits", chapters: [
          { num: 3, name: "Binomial Theorem, Sequences & Straight Lines", q: "AP & GP Series" },
          { num: 4, name: "Limits, Derivatives & Statistics", q: "Calculus Limits" }
        ]}
      ]},
      { name: "Physics", code: "PHY", icon: "⚡", color: "#3867d6", units: [
        { name: "Unit 1: Mechanics & Kinematics", chapters: [
          { num: 1, name: "Units, Measurements & Motion in a Plane", q: "Vectors & Kinematics" },
          { num: 2, name: "Laws of Motion, Work, Energy & Power", q: "Newtonian Mechanics" }
        ]},
        { name: "Unit 2: Thermodynamics & Waves", chapters: [
          { num: 3, name: "System of Particles, Rotational Motion & Gravitation", q: "Moment of Inertia" },
          { num: 4, name: "Properties of Matter, Thermodynamics & Waves", q: "Heat Engines & Waves" }
        ]}
      ]},
      { name: "Chemistry", code: "CHEM", icon: "🧪", color: "#20bf6b", units: [
        { name: "Unit 1: Atomic Structure & Bonding", chapters: [
          { num: 1, name: "Basic Concepts of Chemistry & Atomic Structure", q: "Quantum Numbers" },
          { num: 2, name: "Periodic Classification & Chemical Bonding", q: "VSEPR Theory & Hybridization" }
        ]},
        { name: "Unit 2: Thermodynamics & Organic", chapters: [
          { num: 3, name: "Chemical Thermodynamics & Equilibrium", q: "Gibbs Free Energy" },
          { num: 4, name: "Redox Reactions, Organic Principles & Hydrocarbons", q: "IUPAC Nomenclature" }
        ]}
      ]},
      { name: "Biology", code: "BIO", icon: "🧬", color: "#eb4d4b", units: [
        { name: "Unit 1: Diversity & Structural Organisation", chapters: [
          { num: 1, name: "The Living World, Biological & Plant Kingdoms", q: "Taxonomy & Flora" },
          { num: 2, name: "Animal Kingdom & Morphology of Flowering Plants", q: "Anatomy & Tissues" }
        ]},
        { name: "Unit 2: Cell Biology & Physiology", chapters: [
          { num: 3, name: "Cell Structure, Biomolecules & Cell Division", q: "Mitosis & Meiosis" },
          { num: 4, name: "Plant Physiology & Human Systems", q: "Respiration & Neural Control" }
        ]}
      ]},
      { name: "Computer Science", code: "CS", icon: "💻", color: "#8854d0", units: [
        { name: "Unit 1: Computer Systems & Python Basics", chapters: [
          { num: 1, name: "Computer Systems Architecture & Boolean Logic", q: "Logic Gates & Memory" },
          { num: 2, name: "Computational Thinking & Python Basics", q: "Python Syntax & Flow" }
        ]},
        { name: "Unit 2: Advanced Python & Society", chapters: [
          { num: 3, name: "Strings, Lists, Tuples & Dictionaries in Python", q: "Data Manipulation" },
          { num: 4, name: "Cyber Safety, Digital Footprints & Ethics", q: "Cyber Law & Privacy" }
        ]}
      ]}
    ]
  },

  {
    board: "CBSE", classLevel: 12,
    subjects: [
      { name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4", units: [
        { name: "Unit 1: Relations, Matrices & Calculus", chapters: [
          { num: 1, name: "Relations, Functions & Matrices/Determinants", q: "Matrix Inverses" },
          { num: 2, name: "Continuity, Differentiability & Derivatives", q: "Chain Rule & Maxima" }
        ]},
        { name: "Unit 2: Integrals, Vectors & Probability", chapters: [
          { num: 3, name: "Integrals & Differential Equations", q: "Integration by Parts" },
          { num: 4, name: "Vectors, 3D Geometry & Probability Distribution", q: "Dot Product & Bayes Theorem" }
        ]}
      ]},
      { name: "Physics", code: "PHY", icon: "⚡", color: "#3867d6", units: [
        { name: "Unit 1: Electromagnetism & Optics", chapters: [
          { num: 1, name: "Electrostatics, Potential & Current Electricity", q: "Coulomb's Law & Circuits" },
          { num: 2, name: "Moving Charges, Magnetism & Induction", q: "Faraday's Law & AC" }
        ]},
        { name: "Unit 2: Modern Physics & Semiconductors", chapters: [
          { num: 3, name: "Ray Optics, Wave Optics & Electromagnetic Waves", q: "Interference & Lenses" },
          { num: 4, name: "Dual Nature, Atoms, Nuclei & Semiconductor Electronics", q: "Photoelectric & Diodes" }
        ]}
      ]},
      { name: "Chemistry", code: "CHEM", icon: "🧪", color: "#20bf6b", units: [
        { name: "Unit 1: Physical & Inorganic Chemistry", chapters: [
          { num: 1, name: "Solutions, Electrochemistry & Chemical Kinetics", q: "Nernst Equation & Rate Law" },
          { num: 2, name: "The d- and f-Block Elements & Coordination Compounds", q: "Crystal Field Theory" }
        ]},
        { name: "Unit 2: Organic Chemistry & Biomolecules", chapters: [
          { num: 3, name: "Haloalkanes, Alcohols, Phenols & Ethers", q: "SN1 & SN2 Mechanisms" },
          { num: 4, name: "Aldehydes, Ketones, Amines & Biomolecules", q: "Carboxylic Acids & Amino Acids" }
        ]}
      ]},
      { name: "Biology", code: "BIO", icon: "🧬", color: "#eb4d4b", units: [
        { name: "Unit 1: Reproduction & Genetics", chapters: [
          { num: 1, name: "Sexual Reproduction in Plants & Human Reproduction", q: "Gametes & Embryo" },
          { num: 2, name: "Principles of Inheritance & Molecular Basis of Genetics", q: "DNA Replication & Mendel" }
        ]},
        { name: "Unit 2: Biotechnology & Ecology", chapters: [
          { num: 3, name: "Biotechnology Principles & Genetic Engineering", q: "Recombinant DNA" },
          { num: 4, name: "Organisms, Populations, Ecosystem & Biodiversity", q: "Ecosystem Energy & Conservation" }
        ]}
      ]},
      { name: "Computer Science", code: "CS", icon: "💻", color: "#8854d0", units: [
        { name: "Unit 1: Advanced Python & Data Structures", chapters: [
          { num: 1, name: "Python Functions, File Handling & Exception Handling", q: "File I/O & Exceptions" },
          { num: 2, name: "Data Structures: Linear Stack and Queue", q: "Stack Operations" }
        ]},
        { name: "Unit 2: Computer Networks & SQL Interface", chapters: [
          { num: 3, name: "Computer Networks, Protocols & Security", q: "TCP/IP & OSI Model" },
          { num: 4, name: "Database Management with SQL & Python-SQL Connector", q: "SQL Joins & PyMySQL" }
        ]}
      ]}
    ]
  }
];

// Replicate CBSE structure for Tamil Nadu State Board with State Board specifics
const stateBoardCurriculum = syllabusMatrix.map(entry => {
  return {
    ...entry,
    board: "STATE_BOARD"
  };
});

const fullCurriculum = [...syllabusMatrix, ...stateBoardCurriculum];

// Generate Java code
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

  // Write dedicated method for each board + class
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

  // Common mission & question helper
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
        if ("Mathematics".equalsIgnoreCase(subject)) {
            if (classLevel <= 5) {
                if (qIdx == 1) return "What is the value of 45 + 55 in arithmetic calculation?";
                if (qIdx == 2) return "How many millimeters are there in 1 centimeter?";
                if (qIdx == 3) return "Which geometrical shape has 4 equal straight sides and 4 right angles?";
                if (qIdx == 4) return "What is the perimeter of a rectangle of length 10 cm and breadth 5 cm?";
                return "If 1 notebook costs 20 rupees, what is the cost of 5 notebooks?";
            } else if (classLevel <= 8) {
                if (qIdx == 1) return "What is the value of (-15) + (+25) in integer arithmetic?";
                if (qIdx == 2) return "What is the square root of 144?";
                if (qIdx == 3) return "What is the solution of the linear equation 2x + 6 = 16?";
                if (qIdx == 4) return "What is the sum of interior angles of any triangle?";
                return "What is the area of a circle with radius 7 cm? (Use pi = 22/7)";
            } else if (classLevel <= 10) {
                if (qIdx == 1) return "What are the roots of the quadratic equation x^2 - 5x + 6 = 0?";
                if (qIdx == 2) return "In trigonometry, what is the value of sin(90 degrees)?";
                if (qIdx == 3) return "What is the distance between points (0,0) and (3,4) in coordinate geometry?";
                if (qIdx == 4) return "What is the discriminant formula for a quadratic equation ax^2 + bx + c = 0?";
                return "In an Arithmetic Progression, what is the formula for the nth term an?";
            } else {
                if (qIdx == 1) return "What is the derivative of f(x) = x^3 with respect to x?";
                if (qIdx == 2) return "What is the determinant of identity matrix I of order 3?";
                if (qIdx == 3) return "What is the value of the integral of cos(x) dx?";
                if (qIdx == 4) return "What is the dot product of two mutually perpendicular non-zero vectors?";
                return "What is the limit of (sin x)/x as x approaches 0?";
            }
        } else if ("Physics".equalsIgnoreCase(subject) || ("Science".equalsIgnoreCase(subject) && classLevel >= 9)) {
            if (classLevel <= 10) {
                if (qIdx == 1) return "What is the SI unit of electric current?";
                if (qIdx == 2) return "According to Ohm's law, what is the formula relating V, I, and R?";
                if (qIdx == 3) return "Which mirror is used by dentists to view enlarged images of teeth?";
                if (qIdx == 4) return "What is the acceleration due to gravity on the surface of Earth?";
                return "What is the speed of light in vacuum?";
            } else {
                if (qIdx == 1) return "What is the dimensional formula of gravitational constant G?";
                if (qIdx == 2) return "According to Coulomb's Law, how does electrostatic force vary with distance r?";
                if (qIdx == 3) return "What is the SI unit of magnetic flux?";
                if (qIdx == 4) return "In photoelectric effect, maximum kinetic energy of emitted electron depends on:";
                return "What type of semiconductor is formed when silicon is doped with phosphorus (pentavalent)?";
            }
        } else if ("Chemistry".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "What is the molecular formula of water and its molar mass?";
            if (qIdx == 2) return "What is the pH of a neutral aqueous solution at 25 degrees Celsius?";
            if (qIdx == 3) return "Which element has atomic number 6 and forms organic compounds?";
            if (qIdx == 4) return "What type of bond is formed by sharing of electron pairs between atoms?";
            return "According to Avogadro's number, how many particles are in 1 mole of substance?";
        } else if ("Biology".equalsIgnoreCase(subject) || ("Science".equalsIgnoreCase(subject) && classLevel <= 8)) {
            if (classLevel <= 5) {
                if (qIdx == 1) return "Which part of a plant absorbs water and minerals from the soil?";
                if (qIdx == 2) return "Which green pigment in plant leaves absorbs sunlight for photosynthesis?";
                if (qIdx == 3) return "Which gas do humans inhale for respiration and animals release?";
                if (qIdx == 4) return "Which animal is known as the Ship of the Desert?";
                return "What is the primary natural source of light and energy for Earth?";
            } else if (classLevel <= 8) {
                if (qIdx == 1) return "What is the powerhouse organelle of the biological cell?";
                if (qIdx == 2) return "Which blood cells are responsible for carrying oxygen throughout the human body?";
                if (qIdx == 3) return "Which process converts light energy into chemical energy in green plants?";
                if (qIdx == 4) return "Which microorganism is used in baking bread and fermenting dough?";
                return "What is the normal human body temperature in Celsius?";
            } else {
                if (qIdx == 1) return "Which molecule carries genetic information across generations?";
                if (qIdx == 2) return "Which organelle synthesizes proteins inside living cells?";
                if (qIdx == 3) return "What is the structural and functional unit of the human kidney?";
                if (qIdx == 4) return "In genetics, Gregor Mendel discovered laws of inheritance using which plant?";
                return "Which hormone regulates glucose level in the human bloodstream?";
            }
        } else if ("Social Science".equalsIgnoreCase(subject)) {
            if (classLevel <= 5) {
                if (qIdx == 1) return "What is the capital city of India?";
                if (qIdx == 2) return "How many continents are there on planet Earth?";
                if (qIdx == 3) return "Which is the largest ocean on planet Earth?";
                if (qIdx == 4) return "Who was the first Prime Minister of independent India?";
                return "In which direction does the Sun rise every morning?";
            } else if (classLevel <= 8) {
                if (qIdx == 1) return "Who is known as the Father of the Indian Constitution?";
                if (qIdx == 2) return "In which year did India achieve Independence from British rule?";
                if (qIdx == 3) return "What is the supreme law-making body in India?";
                if (qIdx == 4) return "Which ancient civilization developed along the banks of River Indus?";
                return "Which imaginary line divides the Earth into Northern and Southern hemispheres?";
            } else {
                if (qIdx == 1) return "Which revolution in 1789 introduced Liberty, Equality, and Fraternity?";
                if (qIdx == 2) return "What type of government system does India follow?";
                if (qIdx == 3) return "Which sector of Indian economy includes agriculture and farming?";
                if (qIdx == 4) return "What is the minimum voting age for Indian citizens in general elections?";
                return "Which mountain range forms the northern boundary of India?";
            }
        } else if ("English".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "Identify the noun in the sentence: 'The teacher praised the honest student.'";
            if (qIdx == 2) return "What is the antonym (opposite) of the word 'Courageous'?";
            if (qIdx == 3) return "Choose the correct past tense of the verb 'Write':";
            if (qIdx == 4) return "Which part of speech describes or modifies a verb or adjective?";
            return "What is the synonym of the word 'Gigantic'?";
        } else {
            // Computer Science / IT
            if (classLevel <= 5) {
                if (qIdx == 1) return "What does CPU stand for in computer systems?";
                if (qIdx == 2) return "Which device is used to enter text and numbers into a PC?";
                if (qIdx == 3) return "Which device displays the visual output of a computer?";
                if (qIdx == 4) return "What is the shortcut key to Copy selected text in Windows?";
                return "Which memory is volatile and temporarily stores running programs?";
            } else if (classLevel <= 8) {
                if (qIdx == 1) return "How many bits are there in one Byte?";
                if (qIdx == 2) return "What does URL stand for in computer networking?";
                if (qIdx == 3) return "In Python, which function is used to display output on screen?";
                if (qIdx == 4) return "What does HTML stand for in web development?";
                return "Which network topology connects all devices to a single central cable?";
            } else if (classLevel <= 10) {
                if (qIdx == 1) return "In Python, what is the output of len(['apple', 'banana', 'cherry'])?";
                if (qIdx == 2) return "Which SQL command is used to retrieve data from a database table?";
                if (qIdx == 3) return "In HTML, which tag is used to create a hyperlink?";
                if (qIdx == 4) return "What type of loop in Python repeats as long as a condition remains True?";
                return "Which protocol is used for secure web browsing over the internet?";
            } else {
                if (qIdx == 1) return "In Python, which data structure is mutable and defined with square brackets []?";
                if (qIdx == 2) return "What is the time complexity of searching an element in a binary search tree (average)?";
                if (qIdx == 3) return "In SQL, which clause is used to filter records in an aggregate GROUP BY query?";
                if (qIdx == 4) return "In Python, which keyword is used to handle exceptions?";
                return "Which layer of the OSI reference model is responsible for routing data packets?";
            }
        }
    }

    private String[] getMcqOptions(int classLevel, String subject, String chName, int mNum, int qIdx) {
        if ("Mathematics".equalsIgnoreCase(subject)) {
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
        } else if ("Biology".equalsIgnoreCase(subject) || ("Science".equalsIgnoreCase(subject) && classLevel <= 8)) {
            if (classLevel <= 5) {
                if (qIdx == 1) return new String[]{"Roots", "Leaves", "Flowers", "Stem"};
                if (qIdx == 2) return new String[]{"Chlorophyll", "Hemoglobin", "Melanin", "Carotene"};
                if (qIdx == 3) return new String[]{"Oxygen (O2)", "Carbon Dioxide", "Nitrogen", "Methane"};
                if (qIdx == 4) return new String[]{"Camel", "Horse", "Elephant", "Tiger"};
                return new String[]{"The Sun", "The Moon", "The Ocean", "Volcanoes"};
            } else if (classLevel <= 8) {
                if (qIdx == 1) return new String[]{"Mitochondria", "Ribosome", "Nucleus", "Golgi apparatus"};
                if (qIdx == 2) return new String[]{"Red Blood Cells (RBCs)", "White Blood Cells", "Platelets", "Plasma"};
                if (qIdx == 3) return new String[]{"Photosynthesis", "Transpiration", "Fermentation", "Digestion"};
                if (qIdx == 4) return new String[]{"Yeast (Fungi)", "Amoeba", "Paramecium", "Algae"};
                return new String[]{"37 degrees Celsius (98.6 F)", "40 degrees Celsius", "35 degrees Celsius", "32 degrees Celsius"};
            } else {
                if (qIdx == 1) return new String[]{"DNA (Deoxyribonucleic Acid)", "ATP", "Hemoglobin", "Glycogen"};
                if (qIdx == 2) return new String[]{"Ribosomes", "Mitochondria", "Lysosomes", "Vacuoles"};
                if (qIdx == 3) return new String[]{"Nephron", "Neuron", "Alveoli", "Villi"};
                if (qIdx == 4) return new String[]{"Pea Plant (Pisum sativum)", "Rose Plant", "Wheat", "Sunflower"};
                return new String[]{"Insulin", "Adrenaline", "Thyroxine", "Estrogen"};
            }
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
            if (qIdx == 1) return new String[]{"Teacher / Student", "Praised", "Honest", "The"};
            if (qIdx == 2) return new String[]{"Cowardly / Timid", "Brave", "Heroic", "Strong"};
            if (qIdx == 3) return new String[]{"Wrote", "Written", "Writing", "Writes"};
            if (qIdx == 4) return new String[]{"Adverb", "Noun", "Pronoun", "Preposition"};
            return new String[]{"Huge / Enormous", "Tiny", "Short", "Narrow"};
        } else {
            // CS
            if (classLevel <= 5) {
                if (qIdx == 1) return new String[]{"Central Processing Unit", "Central Power Unit", "Computer Program Unit", "Control Process Unit"};
                if (qIdx == 2) return new String[]{"Keyboard", "Monitor", "Speaker", "Printer"};
                if (qIdx == 3) return new String[]{"Monitor", "Keyboard", "Mouse", "Microphone"};
                if (qIdx == 4) return new String[]{"Ctrl + C", "Ctrl + V", "Ctrl + Z", "Ctrl + X"};
                return new String[]{"RAM (Random Access Memory)", "ROM", "Hard Disk", "Pen Drive"};
            } else if (classLevel <= 8) {
                if (qIdx == 1) return new String[]{"8 bits", "4 bits", "16 bits", "32 bits"};
                if (qIdx == 2) return new String[]{"Uniform Resource Locator", "Universal Record Link", "Unified Routing Logic", "User Response Layer"};
                if (qIdx == 3) return new String[]{"print()", "echo()", "display()", "write()"};
                if (qIdx == 4) return new String[]{"HyperText Markup Language", "HighText Machine Language", "Hyperlink Text Mode Language", "Home Tool Markup Language"};
                return new String[]{"Bus Topology", "Star Topology", "Ring Topology", "Mesh Topology"};
            } else if (classLevel <= 10) {
                if (qIdx == 1) return new String[]{"3", "2", "4", "Error"};
                if (qIdx == 2) return new String[]{"SELECT", "FETCH", "GET", "RETRIEVE"};
                if (qIdx == 3) return new String[]{"<a>", "<link>", "<href>", "<url>"};
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
        if ("Mathematics".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "A triangle has exactly _______ sides and three vertices.";
            if (qIdx == 2) return "1 kilogram is equal to _______ grams.";
            if (qIdx == 3) return "The result of multiplying any number by zero is always _______.";
            if (qIdx == 4) return "A right angle measures exactly _______ degrees.";
            return "100 divided by 4 equals _______.";
        } else if ("Physics".equalsIgnoreCase(subject) || "Science".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "The green pigment in plant leaves that absorbs sunlight is _______.";
            if (qIdx == 2) return "Water boils at _______ degrees Celsius at sea level.";
            if (qIdx == 3) return "The SI unit of electric force / potential difference is the _______.";
            if (qIdx == 4) return "The center organ of the human circulatory system that pumps blood is the _______.";
            return "The smallest particle of a chemical element that retains its identity is an _______.";
        } else if ("Social Science".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "The capital of India is New _______.";
            if (qIdx == 2) return "There are _______ states in the Republic of India.";
            if (qIdx == 3) return "The national bird of India is the _______.";
            if (qIdx == 4) return "The model of the Earth representing its true spherical shape is a _______.";
            return "India gained Independence on 15th _______ 1947.";
        } else if ("English".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "The plural of 'Child' is _______.";
            if (qIdx == 2) return "The past tense of the verb 'Go' is _______.";
            if (qIdx == 3) return "A word that describes or modifies a noun is called an _______.";
            if (qIdx == 4) return "The opposite of 'Strong' is _______.";
            return "A sentence always begins with a _______ letter.";
        } else {
            // CS
            if (qIdx == 1) return "RAM stands for Random Access _______.";
            if (qIdx == 2) return "1 Byte is made up of _______ bits.";
            if (qIdx == 3) return "The physical parts of a computer are known as _______.";
            if (qIdx == 4) return "In Windows, Ctrl + _______ is the shortcut to save a document.";
            return "The main brain of the computer that executes instructions is the _______.";
        }
    }

    private String getFillBlankAnswer(int classLevel, String subject, String chName, int qIdx) {
        if ("Mathematics".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "3";
            if (qIdx == 2) return "1000";
            if (qIdx == 3) return "0";
            if (qIdx == 4) return "90";
            return "25";
        } else if ("Physics".equalsIgnoreCase(subject) || "Science".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "Chlorophyll";
            if (qIdx == 2) return "100";
            if (qIdx == 3) return "Volt";
            if (qIdx == 4) return "Heart";
            return "Atom";
        } else if ("Social Science".equalsIgnoreCase(subject)) {
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
            // CS
            if (qIdx == 1) return "Memory";
            if (qIdx == 2) return "8";
            if (qIdx == 3) return "Hardware";
            if (qIdx == 4) return "S";
            return "CPU";
        }
    }

    private String getScenarioText(int classLevel, String subject, String chName, int qIdx) {
        if ("Mathematics".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "A student wants to fence a square vegetable garden of side 8 meters. How many meters of wire are needed?";
            if (qIdx == 2) return "A school bus starts at 8:15 AM and reaches the science museum at 9:00 AM. How long did the trip take?";
            if (qIdx == 3) return "If 5 boxes contain 250 apples in total, how many apples are in 1 single box?";
            if (qIdx == 4) return "A book with 200 pages was read halfway by Riya. How many pages does she have left to read?";
            return "A merchant bought an item for 150 rupees and sold it for 200 rupees. What was his profit?";
        } else if ("Physics".equalsIgnoreCase(subject) || "Science".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "A plant is kept inside a dark cupboard without sunlight for two weeks. What will happen to its leaves?";
            if (qIdx == 2) return "You need to measure the temperature of a patient suffering from fever. Which instrument will you use?";
            if (qIdx == 3) return "A torch bulb does not glow when the switch is closed because a wire is cut. What type of circuit is this?";
            if (qIdx == 4) return "Why do ice cubes float on the surface of liquid water in a drinking glass?";
            return "Why do vehicles have rear-view convex mirrors instead of plane flat mirrors?";
        } else if ("Social Science".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "A lost traveler in the desert needs to determine the North direction at night. Which star should they spot?";
            if (qIdx == 2) return "A town is facing water shortages in summer. Which sustainable rainwater harvesting practice helps recharge groundwater?";
            if (qIdx == 3) return "A citizen wants to choose their local legislative representative. Which constitutional democratic right do they exercise?";
            if (qIdx == 4) return "Why are national wildlife sanctuaries and national parks established by government authorities?";
            return "Why is the Preamble of the Indian Constitution referred to as the soul of the Constitution?";
        } else if ("English".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return "You want to write a letter to your school principal requesting two days of medical leave. What letter format should you follow?";
            if (qIdx == 2) return "Which sentence expresses a polite and courteous request in a conversation?";
            if (qIdx == 3) return "Identify the correctly punctuated dialogue sentence:";
            if (qIdx == 4) return "What is the best way to summarize a long story paragraph effectively?";
            return "Why is proofreading important before submitting an essay or exam paper?";
        } else {
            // CS
            if (qIdx == 1) return "You need to transfer a 4 GB video project from home to your school computer lab. Which portable medium is best?";
            if (qIdx == 2) return "An unexpected email from an unknown sender asks you for your account password. What should you do?";
            if (qIdx == 3) return "A computer user accidentally deleted a line of text while writing an essay. Which shortcut key undoes the action?";
            if (qIdx == 4) return "Why should computer users take regular short breaks and maintain proper sitting posture while using a screen?";
            return "Why is it important to regularly create backup copies of critical school files on cloud storage or external drives?";
        }
    }

    private String[] getScenarioOptions(int classLevel, String subject, String chName, int qIdx) {
        if ("Mathematics".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return new String[]{"32 meters", "16 meters", "64 meters", "24 meters"};
            if (qIdx == 2) return new String[]{"45 minutes", "30 minutes", "60 minutes", "15 minutes"};
            if (qIdx == 3) return new String[]{"50 apples", "40 apples", "60 apples", "25 apples"};
            if (qIdx == 4) return new String[]{"100 pages", "50 pages", "150 pages", "80 pages"};
            return new String[]{"50 rupees", "25 rupees", "100 rupees", "75 rupees"};
        } else if ("Physics".equalsIgnoreCase(subject) || "Science".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return new String[]{"Leaves turn pale yellow due to lack of photosynthesis", "Leaves grow bigger", "Plant produces flowers", "No change occurs"};
            if (qIdx == 2) return new String[]{"Clinical Thermometer", "Barometer", "Speedometer", "Ammeter"};
            if (qIdx == 3) return new String[]{"Open Circuit", "Closed Circuit", "Short Circuit", "Parallel Circuit"};
            if (qIdx == 4) return new String[]{"Ice is less dense than liquid water", "Ice is heavier than water", "Ice contains air bubbles only", "Ice is warm"};
            return new String[]{"Convex mirrors provide a wider field of view and upright images", "Convex mirrors make cars look red", "Plane mirrors break easily", "Convex mirrors produce upside down images"};
        } else if ("Social Science".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return new String[]{"The North Star (Pole Star / Polaris)", "Sirius", "Mars", "Venus"};
            if (qIdx == 2) return new String[]{"Rooftop Rainwater Harvesting and Percolation Pits", "Draining water to roads", "Using plastic bags", "Cutting trees"};
            if (qIdx == 3) return new String[]{"Right to Vote (Universal Adult Suffrage)", "Right to Property", "Right to Strike", "Right to Tax"};
            if (qIdx == 4) return new String[]{"To protect endangered species and maintain ecological balance", "To build factories", "To sell timber", "To build highways"};
            return new String[]{"It states the core values, principles and objectives of the nation", "It lists the names of ministers", "It has stories", "It is the longest chapter"};
        } else if ("English".equalsIgnoreCase(subject)) {
            if (qIdx == 1) return new String[]{"Formal Letter with Subject, Salutation, Body, and Signature", "Informal Letter with slangs", "Postcard with drawing", "SMS text"};
            if (qIdx == 2) return new String[]{"'Could you please help me with this problem?'", "'Do this for me right now.'", "'I order you.'", "'Help me quickly!'"};
            if (qIdx == 3) return new String[]{"The teacher said, \\\"Work hard and believe in yourself.\\\"", "The teacher said work hard.", "The teacher \\\"said work hard\\\".", "\\\"The teacher said\\\" work hard."};
            if (qIdx == 4) return new String[]{"Identify main points and write them in your own concise words", "Copy the entire paragraph twice", "Delete all punctuation", "Change all nouns"};
            return new String[]{"To identify and correct spelling, grammar, and punctuation mistakes", "To make the text longer", "To change the font color", "To delete the document"};
        } else {
            // CS
            if (qIdx == 1) return new String[]{"USB Pen Drive (Flash Drive) or Secure Cloud Storage", "Printed paper sheets", "Internal RAM stick", "Monitor cable"};
            if (qIdx == 2) return new String[]{"Never share your password and report it as a phishing attempt", "Reply with your password immediately", "Share it with friends", "Ignore security"};
            if (qIdx == 3) return new String[]{"Ctrl + Z (Undo)", "Ctrl + S", "Ctrl + P", "Ctrl + C"};
            if (qIdx == 4) return new String[]{"To prevent eye strain and physical fatigue (Ergonomics)", "To drain battery", "To make computer sleep", "To disconnect internet"};
            return new String[]{"To prevent irreversible data loss in case of hardware failure or virus attack", "To slow down storage", "To delete old apps", "To fill disk space"};
        }
    }
}
`;

  return java;
}

const javaCode = generateJavaSeeder();
const targetPath = path.join(__dirname, 'LearnQuestCurriculumSeeder.java');
fs.writeFileSync(targetPath, javaCode);
console.log('Successfully generated LearnQuestCurriculumSeeder.java at ' + targetPath);
