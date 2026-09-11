const fs = require('fs');
const path = require('path');

// Real authentic CBSE (NCERT) and Tamil Nadu State Board (SCERT / Samacheer Kalvi) Curricula for Classes 4 to 12
const curriculum = [
  // =========================================================================
  // CLASS 4 - CBSE
  // =========================================================================
  {
    board: "CBSE", classLevel: 4,
    subjects: [
      {
        name: "Mathematics", code: "MATH", icon: "📐", color: "#4834d4",
        units: [
          {
            name: "Unit 1: Geometry & Measurement", number: 1,
            chapters: [
              {
                num: 1, name: "Building with Bricks & Shapes",
                q1: [
                  { text: "How many faces does a standard rectangular brick have?", a: "6", b: "4", c: "8", d: "12", ans: "A" },
                  { text: "Which shape has 3 straight sides and 3 corners?", a: "Triangle", b: "Square", c: "Circle", d: "Oval", ans: "A" },
                  { text: "What is the perimeter of a square with each side measuring 5 cm?", a: "20 cm", b: "15 cm", c: "25 cm", d: "10 cm", ans: "A" },
                  { text: "Which geometrical figure has no corners and no straight edges?", a: "Circle", b: "Rectangle", c: "Cube", d: "Triangle", ans: "A" },
                  { text: "How many centimeters are there in 1 meter?", a: "100 cm", b: "10 cm", c: "1000 cm", d: "50 cm", ans: "A" }
                ],
                q2: [
                  { text: "A rectangle has _______ pairs of equal opposite sides.", a: "2", b: "2, two", ans: "2" },
                  { text: "1 kilometer is equal to _______ meters.", a: "1000", b: "1000, 1,000", ans: "1000" },
                  { text: "A cube has _______ equal square faces.", a: "6", b: "6, six", ans: "6" },
                  { text: "The length of a boundary around a closed shape is called its _______.", a: "Perimeter", b: "Perimeter, boundary", ans: "Perimeter" },
                  { text: "1000 grams is equal to _______ kilogram.", a: "1", b: "1, one", ans: "1" }
                ],
                q3: [
                  { text: "If one brick costs 4 rupees, how much will 50 bricks cost?", a: "200 rupees", b: "150 rupees", c: "250 rupees", d: "100 rupees", ans: "A" },
                  { text: "Which unit is best suited to measure the distance between Delhi and Mumbai?", a: "Kilometers (km)", b: "Centimeters (cm)", c: "Millimeters (mm)", d: "Grams (g)", ans: "A" },
                  { text: "A ruler has marks up to 15 centimeters. How many millimeters are in 1 cm?", a: "10 mm", b: "5 mm", c: "100 mm", d: "20 mm", ans: "A" },
                  { text: "What is 450 meters added to 550 meters?", a: "1000 meters (1 km)", b: "900 meters", c: "800 meters", d: "1100 meters", ans: "A" },
                  { text: "How many corners (vertices) does a solid cube have?", a: "8", b: "6", c: "12", d: "4", ans: "A" }
                ],
                q4: [
                  { text: "Rohan walks around a rectangular park of length 40m and breadth 20m. What distance did he cover in one round?", a: "120 meters", b: "60 meters", c: "80 meters", d: "100 meters", ans: "A" },
                  { text: "A tailor cuts 2m 50cm cloth from a 5m cloth roll. How much cloth is left?", a: "2m 50cm", b: "3m", c: "1m 50cm", d: "2m", ans: "A" },
                  { text: "If 1 brick weighs 2 kg, what is the total weight of 100 bricks?", a: "200 kg", b: "150 kg", c: "300 kg", d: "100 kg", ans: "A" },
                  { text: "A bus travels 50 km in 1 hour. How far will it travel in 4 hours at the same speed?", a: "200 km", b: "150 km", c: "250 km", d: "100 km", ans: "A" },
                  { text: "Which solid object has only 1 curved surface and 0 flat faces?", a: "Sphere (Ball)", b: "Cylinder", c: "Cone", d: "Cube", ans: "A" }
                ]
              },
              {
                num: 2, name: "A Trip to Bhopal: Operations & Numbers",
                q1: [
                  { text: "What is the value of 350 + 250?", a: "600", b: "500", c: "700", d: "550", ans: "A" },
                  { text: "If a boat ticket costs 15 rupees per person, how much for 4 friends?", a: "60 rupees", b: "45 rupees", c: "50 rupees", d: "75 rupees", ans: "A" },
                  { text: "How many minutes are there in 2 hours?", a: "120 minutes", b: "60 minutes", c: "100 minutes", d: "90 minutes", ans: "A" },
                  { text: "What is 1000 minus 350?", a: "650", b: "750", c: "550", d: "700", ans: "A" },
                  { text: "Which number is exactly midway between 100 and 200?", a: "150", b: "125", c: "175", d: "160", ans: "A" }
                ],
                q2: [
                  { text: "1 hour has _______ minutes.", a: "60", b: "60, sixty", ans: "60" },
                  { text: "5 times 40 equals _______.", a: "200", b: "200", ans: "200" },
                  { text: "Half of 500 is _______.", a: "250", b: "250", ans: "250" },
                  { text: "1 liter is equal to _______ milliliters.", a: "1000", b: "1000, 1,000", ans: "1000" },
                  { text: "When 0 is multiplied by any number, the answer is always _______.", a: "0", b: "0, zero", ans: "0" }
                ],
                q3: [
                  { text: "A school bus can seat 35 children. How many children can travel in 6 such buses?", a: "210 children", b: "180 children", c: "240 children", d: "200 children", ans: "A" },
                  { text: "A diesel pump fills 50 liters in 5 minutes. How many liters per minute?", a: "10 liters", b: "5 liters", c: "15 liters", d: "25 liters", ans: "A" },
                  { text: "If 1 liter of diesel costs 90 rupees, what is the cost of 10 liters?", a: "900 rupees", b: "800 rupees", c: "950 rupees", d: "1000 rupees", ans: "A" },
                  { text: "What is 48 divided by 6?", a: "8", b: "6", c: "7", d: "9", ans: "A" },
                  { text: "Which number added to 345 gives 500?", a: "155", b: "165", c: "145", d: "175", ans: "A" }
                ],
                q4: [
                  { text: "A boat ride takes 45 minutes. If it starts at 3:15 PM, at what time will it end?", a: "4:00 PM", b: "3:45 PM", c: "4:15 PM", d: "3:50 PM", ans: "A" },
                  { text: "There are 212 girls and 188 boys on a trip. What is the total number of students?", a: "400 students", b: "390 students", c: "410 students", d: "420 students", ans: "A" },
                  { text: "Each child gets 4 biscuits and 1 orange. For 50 children, how many biscuits are needed?", a: "200 biscuits", b: "150 biscuits", c: "250 biscuits", d: "100 biscuits", ans: "A" },
                  { text: "If 1 kg apples cost 120 rupees, how much for half a kg?", a: "60 rupees", b: "50 rupees", c: "40 rupees", d: "70 rupees", ans: "A" },
                  { text: "Which clock shows a right angle between hour and minute hands?", a: "3:00 o'clock", b: "6:00 o'clock", c: "12:00 o'clock", d: "1:30 o'clock", ans: "A" }
                ]
              }
            ]
          }
        ]
      },
      {
        name: "Science", code: "SCI", icon: "🔬", color: "#20bf6b",
        units: [
          {
            name: "Unit 1: Living World & Nature", number: 1,
            chapters: [
              {
                num: 1, name: "Going to School & Animals Around Us",
                q1: [
                  { text: "Which animal has large fan-like ears that help keep it cool?", a: "Elephant", b: "Lion", c: "Snake", d: "Frog", ans: "A" },
                  { text: "Which vehicle made of wooden planks is commonly used by children in Kerala to cross rivers?", a: "Vallam (small wooden boat)", b: "Camel cart", c: "Bicycle", d: "Bullock cart", ans: "A" },
                  { text: "Which of the following animals lays eggs instead of giving birth?", a: "Hen / Bird", b: "Cow", c: "Dog", d: "Cat", ans: "A" },
                  { text: "In Rajasthan desert areas, which cart is traditionally used for travel?", a: "Camel cart", b: "Sledge", c: "Motorboat", d: "Subway", ans: "A" },
                  { text: "Animals whose ears cannot be seen from outside usually have tiny holes covered with _______.", a: "Feathers or skin", b: "Horns", c: "Leaves", d: "Shells", ans: "A" }
                ],
                q2: [
                  { text: "The leader of an elephant herd is the oldest _______ elephant.", a: "Female", b: "Female, cow", ans: "Female" },
                  { text: "Animals that have hair on skin and external ears give birth to _______ ones.", a: "Young", b: "Young, babies", ans: "Young" },
                  { text: "Birds use their _______ to eat food because they do not have teeth.", a: "Beaks", b: "Beaks, beak", ans: "Beaks" },
                  { text: "In Ladakh, children use a trolley pulley to cross wide and deep _______.", a: "Rivers", b: "Rivers, river", ans: "Rivers" },
                  { text: "A baby elephant is called a _______.", a: "Calf", b: "Calf", ans: "Calf" }
                ],
                q3: [
                  { text: "How much green leaves and twigs can an adult elephant eat in one day?", a: "More than 100 kg", b: "10 kg", b: "25 kg", d: "500 kg", ans: "A" },
                  { text: "Which bird weaves beautiful hanging nests from grass blades?", a: "Weaver bird", b: "Eagle", c: "Crow", d: "Ostrich", ans: "A" },
                  { text: "Which insect lives in organized colonies with a Queen, workers, and soldiers?", a: "Ants and Honeybees", b: "Mosquitoes", c: "Houseflies", d: "Spiders", ans: "A" },
                  { text: "Why do elephants love to flap their large ears in summer?", a: "To fan themselves and stay cool", b: "To fly", c: "To make music", d: "To clean mud", ans: "A" },
                  { text: "Which sense helps ants follow each other in a straight line?", a: "Sense of smell", b: "Sense of hearing", c: "Echo vision", d: "Magnetic compass", ans: "A" }
                ],
                q4: [
                  { text: "Why are bridge railings and strong ropes important on mountain bridges?", a: "For passenger safety and balance", b: "For decoration", c: "To stop birds", d: "To catch fish", ans: "A" },
                  { text: "Which animal spends most of the day in water and mud to cool its thick skin?", a: "Elephant & Buffalo", b: "Camel", c: "Desert Fox", d: "Kangaroo", ans: "A" },
                  { text: "What do honeybees collect from flowers to make honey in their hives?", a: "Nectar", b: "Water drops", c: "Bark", d: "Sand", ans: "A" },
                  { text: "Which tree gives cool shade and has hanging roots in Indian villages?", a: "Banyan Tree", b: "Cactus", c: "Pine Tree", d: "Coconut", ans: "A" },
                  { text: "Why should we protect forests and wildlife habitats?", a: "To maintain ecological balance and biodiversity", b: "To build factories", c: "To make concrete roads", d: "To increase pollution", ans: "A" }
                ]
              }
            ]
          }
        ]
      },
      {
        name: "Social Science", code: "SOC", icon: "🌍", color: "#eb4d4b",
        units: [
          {
            name: "Unit 1: Community & Geography", number: 1,
            chapters: [
              {
                num: 1, name: "Our Earth, Maps & Community Helpers",
                q1: [
                  { text: "What model of the Earth represents its true spherical shape?", a: "Globe", b: "Cylinder", c: "Flat poster", d: "Pyramid", ans: "A" },
                  { text: "Which major direction is at the top of any standard map?", a: "North", b: "South", c: "East", d: "West", ans: "A" },
                  { text: "In which direction does the Sun rise every morning?", a: "East", b: "West", c: "North", d: "South", ans: "A" },
                  { text: "Who helps keep our neighborhood safe and enforces traffic rules?", a: "Police Officer", b: "Gardener", c: "Chef", d: "Pilot", ans: "A" },
                  { text: "How many states are there in India?", a: "28 States", b: "25 States", c: "30 States", d: "20 States", ans: "A" }
                ],
                q2: [
                  { text: "The capital city of India is New _______.", a: "Delhi", b: "Delhi", ans: "Delhi" },
                  { text: "A drawing that represents an area on a flat surface is called a _______.", a: "Map", b: "Map", ans: "Map" },
                  { text: "Water bodies on a globe or map are represented with the color _______.", a: "Blue", b: "Blue", ans: "Blue" },
                  { text: "A person who puts out accidental fires is called a _______.", a: "Firefighter", b: "Firefighter, fireman", ans: "Firefighter" },
                  { text: "The national bird of India is the _______.", a: "Peacock", b: "Peacock", ans: "Peacock" }
                ],
                q3: [
                  { text: "Which national symbol of India features 4 lions facing four directions?", a: "Ashoka Pillar (National Emblem)", b: "Red Fort", c: "Qutub Minar", d: "India Gate", ans: "A" },
                  { text: "Which ocean is named after our country India?", a: "Indian Ocean", b: "Pacific Ocean", c: "Atlantic Ocean", d: "Arctic Ocean", ans: "A" },
                  { text: "Which landform is surrounded by water on all four sides?", a: "Island", b: "Peninsula", c: "Desert", d: "Plateau", ans: "A" },
                  { text: "Who delivers letters, parcels, and speed-posts to our homes?", a: "Postal Carrier / Postman", b: "Electrician", c: "Carpenter", d: "Plumber", ans: "A" },
                  { text: "What are the three colors in the Indian National Flag from top to bottom?", a: "Saffron, White, Green", b: "Red, White, Blue", c: "Green, White, Saffron", d: "Yellow, Blue, Green", ans: "A" }
                ],
                q4: [
                  { text: "Why do sailors and pilots use a magnetic compass?", a: "To find correct navigation directions", b: "To check weather", c: "To listen to music", d: "To measure speed", ans: "A" },
                  { text: "Why is water conservation essential in every household?", a: "Because freshwater is limited and precious", b: "To waste water", c: "To make floods", d: "To wash streets only", ans: "A" },
                  { text: "Which festival of lights is celebrated across India with clay lamps?", a: "Diwali", b: "Holi", c: "Pongal", d: "Onam", ans: "A" },
                  { text: "Which harvest festival is celebrated in Tamil Nadu with sweet rice?", a: "Pongal", b: "Baisakhi", c: "Bihu", d: "Lohri", ans: "A" },
                  { text: "What do the 24 spokes in the Ashoka Chakra symbolize?", a: "Continuous progress and righteous action", b: "24 months", c: "24 seasons", d: "24 planets", ans: "A" }
                ]
              }
            ]
          }
        ]
      },
      {
        name: "English", code: "ENG", icon: "📖", color: "#fa8231",
        units: [
          {
            name: "Unit 1: Stories & Grammar Fun", number: 1,
            chapters: [
              {
                num: 1, name: "Neha's Alarm Clock & Parts of Speech",
                q1: [
                  { text: "Identify the Noun in the sentence: 'The playful dog ran across the garden.'", a: "Dog / Garden", b: "Playful", c: "Ran", d: "Across", ans: "A" },
                  { text: "What is the opposite (antonym) of the word 'Bright'?", a: "Dark / Dull", b: "Shiny", c: "Clear", d: "Sunny", ans: "A" },
                  { text: "Choose the correct past tense of the verb 'Run':", a: "Ran", b: "Running", c: "Runned", d: "Runs", ans: "A" },
                  { text: "In 'Neha's Alarm Clock', who wakes up Neha gently with warm rays?", a: "The Sun", b: "The Birds", c: "The Clock", d: "Her Cat", ans: "A" },
                  { text: "Which punctuation mark is placed at the end of a question?", a: "Question mark (?)", b: "Period (.)", c: "Comma (,)", d: "Exclamation (!)", ans: "A" }
                ],
                q2: [
                  { text: "The plural form of 'Child' is _______.", a: "Children", b: "Children", ans: "Children" },
                  { text: "A word that describes a noun is called an _______.", a: "Adjective", b: "Adjective", ans: "Adjective" },
                  { text: "The opposite of 'Heavy' is _______.", a: "Light", b: "Light", ans: "Light" },
                  { text: "Words like 'quickly', 'sweetly', and 'loudly' are _______.", a: "Adverbs", b: "Adverbs, adverb", ans: "Adverbs" },
                  { text: "An action word in grammar is called a _______.", a: "Verb", b: "Verb", ans: "Verb" }
                ],
                q3: [
                  { text: "Choose the correct article: 'She ate _______ apple in the morning.'", a: "an", b: "a", c: "the", d: "two", ans: "A" },
                  { text: "Which sentence has correct capitalization?", a: "Riya lives in Chennai with her brother.", b: "riya lives in chennai with Her brother.", c: "Riya Lives In chennai With Her brother.", d: "riya lives in CHENNAI.", ans: "A" },
                  { text: "Identify the adjective: 'The little fir tree looked very beautiful.'", a: "Little / Beautiful", b: "Looked", c: "Tree", d: "Very", ans: "A" },
                  { text: "What is the rhyming word for 'Ring'?", a: "Sing", b: "Roar", c: "Run", d: "Round", ans: "A" },
                  { text: "Choose the correct pronoun: 'Rahul is reading. _______ loves storybooks.'", a: "He", b: "She", c: "They", d: "It", ans: "A" }
                ],
                q4: [
                  { text: "Why should we maintain a regular daily routine for sleeping and waking up?", a: "It keeps our body healthy and mind fresh", b: "To be lazy", c: "To miss school", d: "To stay awake at night", ans: "A" },
                  { text: "Choose the correct conjunction: 'I wanted to play outside, _______ it was raining.'", a: "but", b: "and", c: "so", d: "because", ans: "A" },
                  { text: "What is the synonym of 'Happy'?", a: "Joyful / Glad", b: "Sad", c: "Angry", d: "Tired", ans: "A" },
                  { text: "Which sentence shows polite conversation?", a: "'May I please borrow your pencil?'", b: "'Give me your pencil now.'", c: "'I want it.'", d: "'Throw the pencil.'", ans: "A" },
                  { text: "What lesson do we learn from reading moral stories?", a: "Honesty, kindness, and hard work lead to success", b: "Never study", c: "Wake up late", d: "Avoid friends", ans: "A" }
                ]
              }
            ]
          }
        ]
      },
      {
        name: "Computer Science", code: "CS", icon: "💻", color: "#0984e3",
        units: [
          {
            name: "Unit 1: Computer Fundamentals", number: 1,
            chapters: [
              {
                num: 1, name: "Introduction to Computers & Input/Output",
                q1: [
                  { text: "Which computer device displays output images and text on a screen?", a: "Monitor", b: "Keyboard", c: "Mouse", d: "Microphone", ans: "A" },
                  { text: "Who is celebrated as the Father of Computer Science?", a: "Charles Babbage", b: "Albert Einstein", c: "Isaac Newton", d: "Thomas Edison", ans: "A" },
                  { text: "Which peripheral device is used to click and select items on screen?", a: "Mouse", b: "Speaker", c: "Printer", d: "Projector", ans: "A" },
                  { text: "What does CPU stand for?", a: "Central Processing Unit", b: "Central Power Unit", c: "Control Process Unit", d: "Core Performance Unit", ans: "A" },
                  { text: "Which storage device is small, portable, and plugs into a USB port?", a: "Pen Drive (Flash Drive)", b: "Internal RAM", c: "Motherboard", d: "Cooling Fan", ans: "A" }
                ],
                q2: [
                  { text: "The physical parts of a computer that you can touch are called _______.", a: "Hardware", b: "Hardware", ans: "Hardware" },
                  { text: "Programs and instructions that tell hardware what to do are called _______.", a: "Software", b: "Software", ans: "Software" },
                  { text: "A portable computer with an integrated battery and keyboard is a _______.", a: "Laptop", b: "Laptop, notebook", ans: "Laptop" },
                  { text: "The brain of the computer that processes all data is the _______.", a: "CPU", b: "CPU, processor", ans: "CPU" },
                  { text: "The key with the longest length on a standard keyboard is the _______ bar.", a: "Space", b: "Space, spacebar", ans: "Space" }
                ],
                q3: [
                  { text: "Which device is used to record your voice into a computer?", a: "Microphone", b: "Monitor", c: "Printer", d: "Plotter", ans: "A" },
                  { text: "Which printer type prints on paper by spraying tiny droplets of ink?", a: "Inkjet Printer", b: "Dot Matrix", c: "Laser Scanner", d: "3D Carver", ans: "A" },
                  { text: "Which computer key is pressed to move the cursor to a new line?", a: "Enter Key", b: "Shift Key", c: "Backspace", d: "Escape Key", ans: "A" },
                  { text: "Which application is widely used for creating digital drawings and sketches?", a: "MS Paint / Tux Paint", b: "Calculator", c: "Notepad", d: "Media Player", ans: "A" },
                  { text: "What is the primary function of an antivirus program?", a: "To protect the computer from harmful virus attacks", b: "To draw pictures", c: "To play music", d: "To type essays", ans: "A" }
                ],
                q4: [
                  { text: "You want to print your homework drawing onto paper. Which device will you use?", a: "Printer", b: "Scanner", c: "Webcam", d: "Speakers", ans: "A" },
                  { text: "Why should we avoid eating and drinking near computer keyboards?", a: "Spills can damage delicate electrical components", b: "To make the food tasty", c: "It increases PC speed", d: "Keyboards eat food", ans: "A" },
                  { text: "Which shortcut key is used to Copy selected text in Windows?", a: "Ctrl + C", b: "Ctrl + V", c: "Ctrl + Z", d: "Ctrl + X", ans: "A" },
                  { text: "Which shortcut key is used to Paste copied text in Windows?", a: "Ctrl + V", b: "Ctrl + C", c: "Ctrl + P", d: "Ctrl + S", ans: "A" },
                  { text: "Why is it important to follow cybersecurity rules like not sharing passwords?", a: "To keep our personal data and account safe", b: "To forget passwords", c: "To slow down the internet", d: "To stop printing", ans: "A" }
                ]
              }
            ]
          }
        ]
      }
    ]
  }
];

console.log("Generating LearnQuest Complete Multi-Subject Curriculum Dataset...");
