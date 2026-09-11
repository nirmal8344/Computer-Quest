const fs = require('fs');
const path = require('path');

// Complete Real 2026-27 Textbook Curriculum Matrix for RPSIT School

const cbseSubjects = [
  // Class 4
  { board: "CBSE", classLevel: 4, name: "English", code: "ENG", icon: "📖", color: "#fa8231", units: [
    { name: "Unit 1: Wake Up & Alarm", chapters: [{ num: 1, name: "Wake Up!", q: "Morning Routine & Rhymes" }, { num: 2, name: "Neha's Alarm Clock", q: "Time & Clocks" }] },
    { name: "Unit 2: Noses & Little Fir Tree", chapters: [{ num: 3, name: "Noses", q: "Facial Features" }, { num: 4, name: "The Little Fir Tree", q: "Nature Lessons" }] },
    { name: "Unit 3: Run & Nasruddin", chapters: [{ num: 5, name: "Run!", q: "Sports & Energy" }, { num: 6, name: "Nasruddin's Aim", q: "Archery" }] },
    { name: "Unit 4: Why & Alice", chapters: [{ num: 7, name: "Why?", q: "Scientific Questions" }, { num: 8, name: "Alice in Wonderland", q: "Exploration" }] },
    { name: "Unit 5: Don't be Afraid", chapters: [{ num: 9, name: "Don't be Afraid of the Dark", q: "Night & Stars" }, { num: 10, name: "Helen Keller", q: "Braille & Perseverance" }] },
    { name: "Unit 6: Hiawatha & Mother Tongue", chapters: [{ num: 11, name: "Hiawatha", q: "Wildlife" }, { num: 12, name: "The Scholar's Mother Tongue", q: "Birbal Wit" }] }
  ]},
  { board: "CBSE", classLevel: 4, name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4", units: [
    { name: "Unit 1: Numbers & Geometry", chapters: [{ num: 1, name: "Building with Bricks", q: "Brick Patterns" }, { num: 2, name: "Long and Short", q: "Metres & Kilometres" }] },
    { name: "Unit 2: Operations & Clocks", chapters: [{ num: 3, name: "A Trip to Bhopal", q: "Multi-digit Operations" }, { num: 4, name: "Tick-Tick-Tick", q: "Clocks & Calendars" }] },
    { name: "Unit 3: Perspective & Money", chapters: [{ num: 5, name: "The Way The World Looks", q: "Top/Side Perspectives" }, { num: 6, name: "The Junk Seller", q: "Money & Rates" }] },
    { name: "Unit 4: Measurement & Fractions", chapters: [{ num: 7, name: "Jugs and Mugs", q: "Litres & Millilitres" }, { num: 8, name: "Carts and Wheels", q: "Circles & Radii" }, { num: 9, name: "Halves and Quarters", q: "Fractions" }] },
    { name: "Unit 5: Patterns, Division & Area", chapters: [{ num: 10, name: "Play with Patterns", q: "Symmetry" }, { num: 11, name: "Tables and Shares", q: "Division" }, { num: 12, name: "How Heavy? How Light?", q: "Kilograms & Grams" }, { num: 13, name: "Fields and Fences", q: "Perimeter" }, { num: 14, name: "Smart Charts", q: "Tally Marks" }] }
  ]},
  { board: "CBSE", classLevel: 4, name: "EVS", code: "EVS", icon: "🌿", color: "#20bf6b", units: [
    { name: "Unit 1: Animals & Travel", chapters: [{ num: 1, name: "Going to School", q: "Bridges & Transport" }, { num: 2, name: "Ear to Ear", q: "Animal Ears" }, { num: 3, name: "A Day with Nandu", q: "Elephant Herds" }] },
    { name: "Unit 2: Plants & Communities", chapters: [{ num: 4, name: "The Story of Amrita", q: "Khejadi Trees" }, { num: 5, name: "Anita and the Honeybees", q: "Beekeeping" }, { num: 6, name: "Omana's Journey", q: "Train Travel" }] },
    { name: "Unit 3: Shelters & Trades", chapters: [{ num: 7, name: "From the Window", q: "Tunnels & Bridges" }, { num: 8, name: "Reaching Grandmother's House", q: "Ferry Rides" }, { num: 9, name: "Changing Families", q: "Family Traditions" }, { num: 10, name: "Hu Tu Tu, Hu Tu Tu", q: "Kabaddi" }] },
    { name: "Unit 4: Heritage & Nature", chapters: [{ num: 11, name: "The Valley of Flowers", q: "Flora & Art" }, { num: 12, name: "Changing Times", q: "Houses" }, { num: 13, name: "A River's Tale", q: "Water Pollution" }, { num: 14, name: "Basva's Farm", q: "Agriculture" }] }
  ]},

  // Class 5
  { board: "CBSE", classLevel: 5, name: "English", code: "ENG", icon: "📖", color: "#fa8231", units: [
    { name: "Unit 1: Ice-Cream Man & Wonderful Waste", chapters: [{ num: 1, name: "Ice-Cream Man", q: "Summer Treats" }, { num: 2, name: "Wonderful Waste!", q: "Avial Recipe" }] },
    { name: "Unit 2: Teamwork & Flying Together", chapters: [{ num: 3, name: "Teamwork", q: "Cooperation" }, { num: 4, name: "Flying Together", q: "Geese Wisdom" }] },
    { name: "Unit 3: My Shadow & Robinson Crusoe", chapters: [{ num: 5, name: "My Shadow", q: "Light & Shadows" }, { num: 6, name: "Robinson Crusoe", q: "Island Survival" }] },
    { name: "Unit 4: Crying & My Elder Brother", chapters: [{ num: 7, name: "Crying", q: "Emotions" }, { num: 8, name: "My Elder Brother", q: "Respect & Siblings" }] },
    { name: "Unit 5: Rip Van Winkle & Barber", chapters: [{ num: 9, name: "Rip Van Winkle", q: "Sleeping 20 Years" }, { num: 10, name: "The Talkative Barber", q: "Baghdad Wit" }] },
    { name: "Unit 6: Topsy-Turvy & Gulliver", chapters: [{ num: 11, name: "Topsy-Turvy Land", q: "Nonsense Verse" }, { num: 12, name: "Gulliver's Travels", q: "Brobdingnag Giants" }] }
  ]},
  { board: "CBSE", classLevel: 5, name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4", units: [
    { name: "Unit 1: Numbers & Angles", chapters: [{ num: 1, name: "The Fish Tale", q: "Large Numbers" }, { num: 2, name: "Shapes and Angles", q: "Right & Acute Angles" }, { num: 3, name: "How Many Squares?", q: "Grid Area" }, { num: 4, name: "Parts and Wholes", q: "Fractions" }] },
    { name: "Unit 2: Symmetry & Multiples", chapters: [{ num: 5, name: "Does it Look the Same?", q: "Rotational Symmetry" }, { num: 6, name: "Be My Multiple, I'll be Your Factor", q: "LCM & HCF" }, { num: 7, name: "Can You See the Pattern?", q: "Magic Squares" }, { num: 8, name: "Mapping Your Way", q: "Map Scales" }] },
    { name: "Unit 3: Decimals & Volume", chapters: [{ num: 9, name: "Boxes and Sketches", q: "3D Nets" }, { num: 10, name: "Tenths and Hundredths", q: "Decimals" }, { num: 11, name: "Area and its Boundary", q: "Perimeter & Area" }, { num: 12, name: "Smart Charts", q: "Pie Charts" }, { num: 13, name: "Ways to Multiply and Divide", q: "Division Operations" }, { num: 14, name: "How Big? How Heavy?", q: "Volume of Cubes" }] }
  ]},
  { board: "CBSE", classLevel: 5, name: "EVS", code: "EVS", icon: "🌿", color: "#20bf6b", units: [
    { name: "Unit 1: Senses & Food", chapters: [{ num: 1, name: "Super Senses", q: "Animal Senses" }, { num: 2, name: "A Snake Charmer's Story", q: "Kalbeliyas" }, { num: 3, name: "From Tasting to Digesting", q: "Digestive System" }] },
    { name: "Unit 2: Food & Seeds", chapters: [{ num: 4, name: "Mangoes Round the Year", q: "Food Preservation" }, { num: 5, name: "Seeds and Seeds", q: "Seed Dispersal" }, { num: 6, name: "Every Drop Counts", q: "Stepwells" }] },
    { name: "Unit 3: Water & Mountains", chapters: [{ num: 7, name: "Experiments with Water", q: "Density & Floating" }, { num: 8, name: "A Treat for Mosquitoes", q: "Malaria" }, { num: 9, name: "Up You Go!", q: "Bachendri Pal" }, { num: 10, name: "Walls Tell Stories", q: "Golconda Fort" }] },
    { name: "Unit 4: Space & Earth", chapters: [{ num: 11, name: "Sunita in Space", q: "Space Station" }, { num: 12, name: "What if it Finishes...?", q: "Fossil Fuels" }, { num: 13, name: "A Shelter so High!", q: "Ladakh & Pashmina" }, { num: 14, name: "When the Earth Shook!", q: "Earthquake Safety" }] }
  ]},

  // Class 6 to 10
  { board: "CBSE", classLevel: 6, name: "English", code: "ENG", icon: "📖", color: "#fa8231", units: [
    { name: "Unit 1: Patrick & Dog", chapters: [{ num: 1, name: "Who Did Patrick's Homework?", q: "Self Study" }, { num: 2, name: "How the Dog Found a Master", q: "Domestication" }] },
    { name: "Unit 2: Taro & Kalpana", chapters: [{ num: 3, name: "Taro's Reward", q: "Devotion" }, { num: 4, name: "An Indian - American Woman in Space", q: "Kalpana Chawla" }] },
    { name: "Unit 3: School & Talents", chapters: [{ num: 5, name: "A Different Kind of School", q: "Empathy" }, { num: 6, name: "Who I Am", q: "Diversity" }] },
    { name: "Unit 4: Fair Play & Banyan Tree", chapters: [{ num: 7, name: "Fair Play", q: "Panchayat" }, { num: 8, name: "The Banyan Tree", q: "Nature Memories" }] }
  ]},
  { board: "CBSE", classLevel: 6, name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4", units: [
    { name: "Unit 1: Numbers & Operations", chapters: [{ num: 1, name: "Knowing Our Numbers", q: "Place Value" }, { num: 2, name: "Whole Numbers", q: "Number Line" }, { num: 3, name: "Playing with Numbers", q: "Prime Numbers & HCF" }] },
    { name: "Unit 2: Geometry", chapters: [{ num: 4, name: "Basic Geometrical Ideas", q: "Points & Rays" }, { num: 5, name: "Understanding Elementary Shapes", q: "Angles & Polygons" }] },
    { name: "Unit 3: Integers & Fractions", chapters: [{ num: 6, name: "Integers", q: "Negative Numbers" }, { num: 7, name: "Fractions", q: "Proper/Improper Fractions" }, { num: 8, name: "Decimals", q: "Decimal Operations" }] },
    { name: "Unit 4: Data & Mensuration", chapters: [{ num: 9, name: "Data Handling", q: "Bar Graphs" }, { num: 10, name: "Mensuration", q: "Perimeter & Area" }, { num: 11, name: "Algebra", q: "Variables" }, { num: 12, name: "Ratio and Proportion", q: "Unitary Method" }] }
  ]},
  { board: "CBSE", classLevel: 6, name: "Science", code: "SCI", icon: "🔬", color: "#eb4d4b", units: [
    { name: "Unit 1: Food & Materials", chapters: [{ num: 1, name: "Components of Food", q: "Nutrients" }, { num: 2, name: "Sorting Materials into Groups", q: "Material Properties" }, { num: 3, name: "Separation of Substances", q: "Filtration & Decantation" }] },
    { name: "Unit 2: Living World", chapters: [{ num: 4, name: "Getting to Know Plants", q: "Herbs & Trees" }, { num: 5, name: "Body Movements", q: "Joints & Skeleton" }, { num: 6, name: "The Living Organisms — Characteristics & Habitats", q: "Adaptations" }] },
    { name: "Unit 3: Physical World", chapters: [{ num: 7, name: "Motion and Measurement of Distances", q: "Standard Units" }, { num: 8, name: "Light, Shadows and Reflections", q: "Pinhole Camera" }, { num: 9, name: "Electricity and Circuits", q: "Electric Cells" }, { num: 10, name: "Fun with Magnets", q: "Poles & Compass" }, { num: 11, name: "Air Around Us", q: "Atmospheric Gases" }] }
  ]},
  { board: "CBSE", classLevel: 6, name: "Social Science", code: "SOC", icon: "🌍", color: "#10ac84", units: [
    { name: "Unit 1: History (Our Pasts - I)", chapters: [{ num: 1, name: "What, Where, How and When?", q: "Manuscripts" }, { num: 2, name: "From Hunting-Gathering to Growing Food", q: "Stone Age" }, { num: 3, name: "In the Earliest Cities", q: "Harappan Civilization" }, { num: 4, name: "What Books and Burials Tell Us", q: "Vedas" }, { num: 5, name: "Kingdoms, Kings & Early Republic", q: "Mahajanapadas" }, { num: 6, name: "Ashoka: The Emperor Who Gave Up War", q: "Mauryan Empire" }] },
    { name: "Unit 2: Geography (The Earth Our Habitat)", chapters: [{ num: 7, name: "The Earth in the Solar System", q: "Planets" }, { num: 8, name: "Globe: Latitudes and Longitudes", q: "Equator & Meridian" }, { num: 9, name: "Motions of the Earth", q: "Rotation & Seasons" }, { num: 10, name: "Maps", q: "Scale & Symbols" }, { num: 11, name: "Major Domains of the Earth", q: "Lithosphere & Biosphere" }, { num: 12, name: "Our Country - India", q: "Physical Divisions" }] },
    { name: "Unit 3: Civics (Social and Political Life - I)", chapters: [{ num: 13, name: "Understanding Diversity", q: "Cultural Plurality" }, { num: 14, name: "Diversity and Discrimination", q: "Equality" }, { num: 15, name: "What is Government?", q: "Democracy" }, { num: 16, name: "Panchayati Raj", q: "Gram Panchayat" }, { num: 17, name: "Rural & Urban Administration", q: "Municipalities" }] }
  ]},

  // Class 7 to 10 CBSE will follow identical rich pattern
  { board: "CBSE", classLevel: 7, name: "English", code: "ENG", icon: "📖", color: "#fa8231", units: [
    { name: "Unit 1: Three Questions & Chappals", chapters: [{ num: 1, name: "Three Questions", q: "Leo Tolstoy" }, { num: 2, name: "A Gift of Chappals", q: "Compassion" }] },
    { name: "Unit 2: Gopal & The Ashes", chapters: [{ num: 3, name: "Gopal and the Hilsa Fish", q: "Court Wit" }, { num: 4, name: "The Ashes That Made Trees Bloom", q: "Japanese Tale" }] },
    { name: "Unit 3: Quality & Detectives", chapters: [{ num: 5, name: "Quality", q: "Craftsmanship" }, { num: 6, name: "Expert Detectives", q: "Mystery Investigation" }] }
  ]},
  { board: "CBSE", classLevel: 7, name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4", units: [
    { name: "Unit 1: Numbers & Equations", chapters: [{ num: 1, name: "Integers", q: "Multiplication Rules" }, { num: 2, name: "Fractions and Decimals", q: "Division" }, { num: 3, name: "Simple Equations", q: "Linear Equations" }] },
    { name: "Unit 2: Geometry & Triangles", chapters: [{ num: 4, name: "Lines and Angles", q: "Transversals" }, { num: 5, name: "The Triangle and its Properties", q: "Pythagoras Theorem" }, { num: 6, name: "Comparing Quantities", q: "Percentages & Interest" }] },
    { name: "Unit 3: Algebra & Mensuration", chapters: [{ num: 7, name: "Rational Numbers", q: "Standard Form" }, { num: 8, name: "Perimeter and Area", q: "Parallelogram & Circle Area" }, { num: 9, name: "Algebraic Expressions", q: "Polynomials" }, { num: 10, name: "Exponents and Powers", q: "Scientific Notation" }, { num: 11, name: "Data Handling", q: "Mean, Median & Mode" }] }
  ]},
  { board: "CBSE", classLevel: 7, name: "Science", code: "SCI", icon: "🔬", color: "#eb4d4b", units: [
    { name: "Unit 1: Nutrition & Heat", chapters: [{ num: 1, name: "Nutrition in Plants", q: "Photosynthesis" }, { num: 2, name: "Nutrition in Animals", q: "Alimentary Canal" }, { num: 3, name: "Heat", q: "Conduction & Convection" }] },
    { name: "Unit 2: Chemistry & Biology", chapters: [{ num: 4, name: "Acids, Bases and Salts", q: "pH & Neutralisation" }, { num: 5, name: "Physical and Chemical Changes", q: "Rusting" }, { num: 6, name: "Respiration in Organisms", q: "Cellular Respiration" }, { num: 7, name: "Transportation in Animals and Plants", q: "Circulation & Xylem" }] },
    { name: "Unit 3: Physics & Ecology", chapters: [{ num: 8, name: "Reproduction in Plants", q: "Pollination" }, { num: 9, name: "Motion and Time", q: "Speed & Pendulums" }, { num: 10, name: "Electric Current and its Effects", q: "Electromagnets" }, { num: 11, name: "Light", q: "Lenses & Mirrors" }, { num: 12, name: "Forests: Our Lifeline", q: "Canopy & Decomposers" }, { num: 13, name: "Wastewater Story", q: "Sewage Treatment" }] }
  ]},
  { board: "CBSE", classLevel: 7, name: "Social Science", code: "SOC", icon: "🌍", color: "#10ac84", units: [
    { name: "Unit 1: History (Our Pasts - II)", chapters: [{ num: 1, name: "Tracing Changes Through a Thousand Years", q: "Medieval Sources" }, { num: 2, name: "Kings and Kingdoms", q: "Cholas" }, { num: 3, name: "Delhi: 12th to 15th Century", q: "Delhi Sultanate" }, { num: 4, name: "The Mughals", q: "Akbar & Mansabdari" }, { num: 5, name: "Devotional Paths to the Divine", q: "Bhakti & Sufi" }] },
    { name: "Unit 2: Geography (Our Environment)", chapters: [{ num: 6, name: "Environment", q: "Ecosystem" }, { num: 7, name: "Inside Our Earth", q: "Crust & Rocks" }, { num: 8, name: "Our Changing Earth", q: "Volcanoes & Earthquakes" }, { num: 9, name: "Air", q: "Atmospheric Layers" }, { num: 10, name: "Water", q: "Ocean Currents & Tides" }] },
    { name: "Unit 3: Civics (Social and Political Life - II)", chapters: [{ num: 11, name: "On Equality", q: "Universal Franchise" }, { num: 12, name: "Role of Government in Health", q: "Public Healthcare" }, { num: 13, name: "How the State Government Works", q: "MLA Elections" }, { num: 14, name: "Women Change the World", q: "Gender & Education" }, { num: 15, name: "Markets Around Us", q: "Supply Chains" }] }
  ]},

  // Class 8 to 10 CBSE
  { board: "CBSE", classLevel: 8, name: "English", code: "ENG", icon: "📖", color: "#fa8231", units: [
    { name: "Unit 1: The Best Christmas Present", chapters: [{ num: 1, name: "The Best Christmas Present in the World", q: "WWI Truce" }, { num: 2, name: "The Tsunami", q: "2004 Tsunami" }] },
    { name: "Unit 2: Glimpses of Past & Bepin Choudhury", chapters: [{ num: 3, name: "Glimpses of the Past", q: "1857 Rebellion" }, { num: 4, name: "Bepin Choudhury's Lapse of Memory", q: "Satyajit Ray" }] },
    { name: "Unit 3: The Summit Within", chapters: [{ num: 5, name: "The Summit Within", q: "Everest Expedition" }, { num: 6, name: "This is Jody's Fawn", q: "Compassion" }] },
    { name: "Unit 4: A Visit to Cambridge", chapters: [{ num: 7, name: "A Visit to Cambridge", q: "Stephen Hawking" }, { num: 8, name: "A Short Monsoon Diary", q: "Ruskin Bond" }] }
  ]},
  { board: "CBSE", classLevel: 8, name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4", units: [
    { name: "Unit 1: Numbers & Equations", chapters: [{ num: 1, name: "Rational Numbers", q: "Commutative Properties" }, { num: 2, name: "Linear Equations in One Variable", q: "Transposition" }] },
    { name: "Unit 2: Geometry & Data", chapters: [{ num: 3, name: "Understanding Quadrilaterals", q: "Parallelograms" }, { num: 4, name: "Data Handling", q: "Histograms & Probability" }] },
    { name: "Unit 3: Squares, Cubes & Commercial Math", chapters: [{ num: 5, name: "Squares and Square Roots", q: "Pythagorean Triplets" }, { num: 6, name: "Cubes and Cube Roots", q: "Hardy Ramanujan" }, { num: 7, name: "Comparing Quantities", q: "Compound Interest" }] },
    { name: "Unit 4: Algebra, Mensuration & Graphs", chapters: [{ num: 8, name: "Algebraic Expressions and Identities", q: "Identities" }, { num: 9, name: "Mensuration", q: "Surface Area & Volume" }, { num: 10, name: "Exponents and Powers", q: "Negative Powers" }, { num: 11, name: "Direct and Inverse Proportions", q: "Proportions" }, { num: 12, name: "Factorisation", q: "Splitting Middle Term" }, { num: 13, name: "Introduction to Graphs", q: "Cartesian Plane" }] }
  ]},
  { board: "CBSE", classLevel: 8, name: "Science", code: "SCI", icon: "🔬", color: "#eb4d4b", units: [
    { name: "Unit 1: Agriculture & Microbes", chapters: [{ num: 1, name: "Crop Production and Management", q: "Ploughing & Harvesting" }, { num: 2, name: "Microorganisms: Friend and Foe", q: "Antibiotics & Fungi" }] },
    { name: "Unit 2: Fuels, Combustion & Conservation", chapters: [{ num: 3, name: "Coal and Petroleum", q: "Fossil Fuels" }, { num: 4, name: "Combustion and Flame", q: "Ignition Temperature" }, { num: 5, name: "Conservation of Plants and Animals", q: "Red Data Book" }] },
    { name: "Unit 3: Reproduction & Adolescence", chapters: [{ num: 6, name: "Reproduction in Animals", q: "Zygote & Fertilisation" }, { num: 7, name: "Reaching the Age of Adolescence", q: "Hormones" }] },
    { name: "Unit 4: Physics & Electricity", chapters: [{ num: 8, name: "Force and Pressure", q: "Atmospheric Pressure" }, { num: 9, name: "Friction", q: "Rolling vs Sliding Friction" }, { num: 10, name: "Sound", q: "Frequency & Amplitude" }, { num: 11, name: "Chemical Effects of Electric Current", q: "Electroplating" }, { num: 12, name: "Some Natural Phenomena", q: "Lightning Conductor" }, { num: 13, name: "Light", q: "Laws of Reflection" }] }
  ]},
  { board: "CBSE", classLevel: 8, name: "Social Science", code: "SOC", icon: "🌍", color: "#10ac84", units: [
    { name: "Unit 1: History (Our Pasts - III)", chapters: [{ num: 1, name: "How, When and Where", q: "Colonial Periodisation" }, { num: 2, name: "From Trade to Territory", q: "Battle of Plassey" }, { num: 3, name: "Ruling the Countryside", q: "Permanent Settlement" }, { num: 4, name: "Tribals, Dikus & Golden Age", q: "Birsa Munda" }, { num: 5, name: "When People Rebel: 1857 and After", q: "Sepoy Mutiny" }, { num: 6, name: "Civilising the Native, Educating the Nation", q: "Wood Despatch" }, { num: 7, name: "Women, Caste and Reform", q: "Raja Ram Mohan Roy" }, { num: 8, name: "The Making of the National Movement: 1870s-1947", q: "Indian National Congress" }] },
    { name: "Unit 2: Geography (Resources & Development)", chapters: [{ num: 9, name: "Resources", q: "Sustainable Development" }, { num: 10, name: "Land, Soil, Water & Wildlife", q: "Soil Erosion" }, { num: 11, name: "Agriculture", q: "Commercial Farming" }, { num: 12, name: "Industries", q: "Iron and Steel" }, { num: 13, name: "Human Resources", q: "Population Density" }] },
    { name: "Unit 3: Civics (Social and Political Life - III)", chapters: [{ num: 14, name: "The Indian Constitution", q: "Fundamental Rights" }, { num: 15, name: "Understanding Secularism", q: "Constitutional Guarantees" }, { num: 16, name: "Parliament and the Making of Laws", q: "Lok Sabha & Rajya Sabha" }, { num: 17, name: "Judiciary", q: "Supreme Court & PIL" }, { num: 18, name: "Understanding Marginalisation", q: "Adivasis" }, { num: 19, name: "Confronting Marginalisation", q: "Article 17" }, { num: 20, name: "Public Facilities & Social Justice", q: "Water & Article 21" }] }
  ]},

  // Class 9 & 10 CBSE
  { board: "CBSE", classLevel: 9, name: "English", code: "ENG", icon: "📖", color: "#fa8231", units: [
    { name: "Unit 1: Prose & Poetry (Beehive)", chapters: [{ num: 1, name: "The Fun They Had", q: "Isaac Asimov" }, { num: 2, name: "The Road Not Taken", q: "Robert Frost" }, { num: 3, name: "The Sound of Music", q: "Evelyn Glennie" }, { num: 4, name: "The Little Girl", q: "Kezia" }, { num: 5, name: "A Truly Beautiful Mind", q: "Albert Einstein" }, { num: 6, name: "My Childhood", q: "Dr. A.P.J. Abdul Kalam" }, { num: 7, name: "Reach for the Top", q: "Santosh Yadav" }, { num: 8, name: "Kathmandu & If I Were You", q: "Pashupatinath Temple" }] }
  ]},
  { board: "CBSE", classLevel: 9, name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4", units: [
    { name: "Unit 1: Number Systems & Polynomials", chapters: [{ num: 1, name: "Number Systems", q: "Irrational Numbers" }, { num: 2, name: "Polynomials", q: "Factor Theorem" }, { num: 3, name: "Linear Equations in Two Variables", q: "ax + by + c = 0" }] },
    { name: "Unit 2: Geometry", chapters: [{ num: 4, name: "Coordinate Geometry", q: "Cartesian Plane" }, { num: 5, name: "Introduction to Euclid's Geometry", q: "Axioms & Postulates" }, { num: 6, name: "Lines and Angles", q: "Alternate Angles" }, { num: 7, name: "Triangles", q: "Congruence Criteria" }, { num: 8, name: "Quadrilaterals", q: "Mid-Point Theorem" }, { num: 9, name: "Circles", q: "Cyclic Quadrilaterals" }] },
    { name: "Unit 3: Mensuration & Statistics", chapters: [{ num: 10, name: "Heron's Formula", q: "Area Calculation" }, { num: 11, name: "Surface Areas and Volumes", q: "Cones & Spheres" }, { num: 12, name: "Statistics", q: "Histograms & Mean" }] }
  ]},
  { board: "CBSE", classLevel: 9, name: "Science", code: "SCI", icon: "🔬", color: "#eb4d4b", units: [
    { name: "Unit 1: Matter & Chemical Substances", chapters: [{ num: 1, name: "Matter in Our Surroundings", q: "States & Latent Heat" }, { num: 2, name: "Is Matter Around Us Pure?", q: "Colloids & Solutions" }, { num: 3, name: "Atoms and Molecules", q: "Mole Concept" }, { num: 4, name: "Structure of the Atom", q: "Bohr Model & Valency" }] },
    { name: "Unit 2: Biology & Cell Biology", chapters: [{ num: 5, name: "The Fundamental Unit of Life", q: "Cell Organelles" }, { num: 6, name: "Tissues", q: "Meristematic & Epithelial" }] },
    { name: "Unit 3: Physics & Energy", chapters: [{ num: 7, name: "Motion", q: "Equations of Motion" }, { num: 8, name: "Force and Laws of Motion", q: "Newton's 3 Laws" }, { num: 9, name: "Gravitation", q: "Universal Gravitation" }, { num: 10, name: "Work and Energy", q: "Conservation of Energy" }, { num: 11, name: "Sound", q: "Ultrasound & Echo" }, { num: 12, name: "Improvement in Food Resources", q: "Hybridisation" }] }
  ]},
  { board: "CBSE", classLevel: 9, name: "Social Science", code: "SOC", icon: "🌍", color: "#10ac84", units: [
    { name: "Unit 1: History (Contemporary World - I)", chapters: [{ num: 1, name: "The French Revolution", q: "Bastille & Estates" }, { num: 2, name: "Socialism in Europe & Russian Revolution", q: "Bolsheviks & Lenin" }, { num: 3, name: "Nazism and the Rise of Hitler", q: "Weimar Republic" }, { num: 4, name: "Forest Society & Pastoralists", q: "Forest Laws" }] },
    { name: "Unit 2: Geography (Contemporary India - I)", chapters: [{ num: 5, name: "India - Size and Location", q: "Standard Meridian" }, { num: 6, name: "Physical Features of India", q: "Himalayas & Plains" }, { num: 7, name: "Drainage", q: "River Systems" }, { num: 8, name: "Climate", q: "Monsoon Mechanism" }, { num: 9, name: "Natural Vegetation & Population", q: "Tropical Forests" }] },
    { name: "Unit 3: Civics & Economics", chapters: [{ num: 10, name: "What is Democracy? Why Democracy?", q: "Rule of Law" }, { num: 11, name: "Constitutional Design", q: "Constitution Drafting" }, { num: 12, name: "Electoral Politics", q: "Election Commission" }, { num: 13, name: "Working of Institutions", q: "Parliament & Judiciary" }, { num: 14, name: "Democratic Rights", q: "Fundamental Rights" }, { num: 15, name: "Economics (Palampur, Poverty & Food Security)", q: "PDS & Human Capital" }] }
  ]},

  // Class 10 CBSE
  { board: "CBSE", classLevel: 10, name: "English", code: "ENG", icon: "📖", color: "#fa8231", units: [
    { name: "Unit 1: First Flight - Prose & Poetry", chapters: [{ num: 1, name: "A Letter to God", q: "Lencho's Faith" }, { num: 2, name: "Nelson Mandela: Long Walk to Freedom", q: "Apartheid" }, { num: 3, name: "Two Stories about Flying", q: "Seagull First Flight" }, { num: 4, name: "From the Diary of Anne Frank", q: "Secret Annex" }, { num: 5, name: "Glimpses of India", q: "Goa, Coorg & Assam" }, { num: 6, name: "Mijbil the Otter", q: "Otter Behaviour" }, { num: 7, name: "Madam Rides the Bus", q: "Valli" }, { num: 8, name: "The Sermon at Benares", q: "Buddha & Kisa Gotami" }, { num: 9, name: "The Proposal", q: "Anton Chekhov" }] }
  ]},
  { board: "CBSE", classLevel: 10, name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4", units: [
    { name: "Unit 1: Number Systems & Algebra", chapters: [{ num: 1, name: "Real Numbers", q: "Fundamental Theorem of Arithmetic" }, { num: 2, name: "Polynomials", q: "Zeroes & Coefficients" }, { num: 3, name: "Pair of Linear Equations in Two Variables", q: "Substitution & Elimination" }, { num: 4, name: "Quadratic Equations", q: "Discriminant & Roots" }, { num: 5, name: "Arithmetic Progressions", q: "nth Term & Sum Sn" }] },
    { name: "Unit 2: Geometry & Coordinate Geometry", chapters: [{ num: 6, name: "Triangles", q: "Similarity & Thales Theorem" }, { num: 7, name: "Coordinate Geometry", q: "Distance & Section Formula" }, { num: 8, name: "Circles", q: "Tangents from External Point" }] },
    { name: "Unit 3: Trigonometry & Mensuration", chapters: [{ num: 9, name: "Introduction to Trigonometry", q: "Trigonometric Identities" }, { num: 10, name: "Some Applications of Trigonometry", q: "Heights & Distances" }, { num: 11, name: "Areas Related to Circles", q: "Sector & Segment" }, { num: 12, name: "Surface Areas and Volumes", q: "Combined 3D Solids" }, { num: 13, name: "Statistics", q: "Mean, Median & Mode" }, { num: 14, name: "Probability", q: "Theoretical Probability" }] }
  ]},
  { board: "CBSE", classLevel: 10, name: "Science", code: "SCI", icon: "🔬", color: "#eb4d4b", units: [
    { name: "Unit 1: Chemical Substances", chapters: [{ num: 1, name: "Chemical Reactions and Equations", q: "Balancing & Redox" }, { num: 2, name: "Acids, Bases and Salts", q: "Chlor-Alkali & Plaster of Paris" }, { num: 3, name: "Metals and Non-metals", q: "Reactivity Series & Ionic Bonds" }, { num: 4, name: "Carbon and its Compounds", q: "Covalent Bonds & Saponification" }] },
    { name: "Unit 2: World of Living", chapters: [{ num: 5, name: "Life Processes", q: "Nutrition & Circulation" }, { num: 6, name: "Control and Coordination", q: "Brain & Plant Tropisms" }, { num: 7, name: "How do Organisms Reproduce?", q: "Reproductive Systems" }, { num: 8, name: "Heredity", q: "Mendel Crosses & Sex Determination" }] },
    { name: "Unit 3: Natural Phenomena & Current", chapters: [{ num: 9, name: "Light - Reflection and Refraction", q: "Mirror & Lens Formula" }, { num: 10, name: "The Human Eye and Colourful World", q: "Refraction & Defects" }, { num: 11, name: "Electricity", q: "Ohm's Law & Joule's Heating" }, { num: 12, name: "Magnetic Effects of Electric Current", q: "Solenoid & AC/DC" }, { num: 13, name: "Our Environment", q: "Food Webs & Ozone Layer" }] }
  ]},
  { board: "CBSE", classLevel: 10, name: "Social Science", code: "SOC", icon: "🌍", color: "#10ac84", units: [
    { name: "Unit 1: History (Contemporary World - II)", chapters: [{ num: 1, name: "The Rise of Nationalism in Europe", q: "Mazzini & Bismarck" }, { num: 2, name: "Nationalism in India", q: "Non-Cooperation & Dandi" }, { num: 3, name: "The Making of a Global World", q: "Great Depression" }, { num: 4, name: "The Age of Industrialisation", q: "Factories in India" }, { num: 5, name: "Print Culture and Modern World", q: "Gutenberg Press" }] },
    { name: "Unit 2: Geography (Contemporary India - II)", chapters: [{ num: 6, name: "Resources and Development", q: "Soil Classification" }, { num: 7, name: "Forest and Wildlife Resources", q: "Project Tiger" }, { num: 8, name: "Water Resources", q: "Multi-Purpose Dams" }, { num: 9, name: "Agriculture", q: "Commercial Crops" }, { num: 10, name: "Minerals and Energy Resources", q: "Ferrous Minerals & Solar" }, { num: 11, name: "Manufacturing Industries & Lifelines", q: "Iron & Steel, Golden Quadrilateral" }] },
    { name: "Unit 3: Civics & Economics", chapters: [{ num: 12, name: "Power Sharing & Federalism", q: "Belgium Model & 3 Lists" }, { num: 13, name: "Gender, Religion and Caste", q: "Feminist Movements" }, { num: 14, name: "Political Parties", q: "Party Functions & Reforms" }, { num: 15, name: "Outcomes of Democracy", q: "Accountable Governance" }, { num: 16, name: "Economics (Development, Sectors, Money & Globalisation)", q: "HDI, SHGs & WTO" }] }
  ]}
];

console.log('Total CBSE subject packages defined:', cbseSubjects.length);
