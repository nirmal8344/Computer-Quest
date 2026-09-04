// =========================================================================
// CBSE CLASS 10 (MULTI-UNIT OFFICIAL CURRICULA)
// CBSE IT Code 402 / Computer Applications Code 165 / NCERT
// Units: Networking, Web Technologies, Database SQL, Python Programming, AI Project Cycle
// =========================================================================

module.exports = [
  {
    board: "CBSE",
    classLevel: 10,
    units: [
      {
        unitNumber: 1,
        unitName: "Unit 1 – Networking, Web Technologies & Cyber Safety",
        chapters: [
          {
            num: 1,
            name: "CBSE 10 - Internet Architecture, Protocols & Web Standards",
            missions: [
              {
                mNum: 1,
                q: [
                  ["Which core protocol is responsible for packetizing, routing, and reliable delivery across the Internet?", "MCQ", "TCP/IP (Transmission Control Protocol / Internet Protocol)", "FTP / SMTP", "DHCP / DNS", "HTTP / POP3", "A"],
                  ["Which transport protocol is connectionless, faster than TCP, and used in video streaming and online gaming?", "MCQ", "UDP (User Datagram Protocol)", "TCP", "BGP", "SSH", "A"],
                  ["What is the fundamental role of DNS (Domain Name System)?", "MCQ", "Translating human-readable domain names (e.g., example.com) into numeric IP addresses (e.g., 93.184.216.34)", "Formatting web pages with CSS", "Managing computer battery power", "Blocking email attachments", "A"],
                  ["Which protocol encrypts web traffic using SSL/TLS cryptographic certificates?", "MCQ", "HTTPS (Hypertext Transfer Protocol Secure)", "HTTP", "Telnet", "FTP", "A"],
                  ["An IPv4 address consists of _______ bits separated into 4 octets, while IPv6 consists of _______ bits.", "MCQ", "32 bits, 128 bits", "16 bits, 64 bits", "64 bits, 256 bits", "8 bits, 32 bits", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["The protocol translating human domain names to numeric IP addresses is _______.", "FILL_BLANK", "DNS", "DNS, Domain Name System", "", "", "DNS"],
                  ["Secure encrypted HTTP protocol using SSL/TLS is known as _______.", "FILL_BLANK", "HTTPS", "HTTPS, HyperText Transfer Protocol Secure", "", "", "HTTPS"],
                  ["IPv4 addresses use _______ bits in total.", "FILL_BLANK", "32", "32, 32-bit", "", "", "32"],
                  ["The network hardware that forwards data packets between different IP subnets is a _______.", "FILL_BLANK", "Router", "Router, Gateway", "", "", "Router"],
                  ["The unique 48-bit hardware identifier burned into a Network Interface Card is the _______ address.", "FILL_BLANK", "MAC", "MAC, MAC address", "", "", "MAC"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["How does a Packet Switching network transmit large multimedia files over the Internet?", "MCQ", "Splitting data into discrete indexed packets that travel independently across optimal routes and reassemble at the destination", "Sending one continuous uninterrupted electrical stream", "Printing out papers and scanning them", "Compressing everything into a single 1-byte file", "A"],
                  ["What is the key difference between a MAC address and an IP address?", "MCQ", "MAC address is permanent physical hardware identifier (Data Link Layer); IP address is dynamic logical address (Network Layer)", "MAC address changes on every reboot", "IP address is burned into the motherboard", "Both are identical 16-bit numbers", "A"],
                  ["Which network security system monitors and filters incoming and outgoing network traffic based on predetermined security rules?", "MCQ", "Firewall", "Web Browser", "Screen Saver", "Defragmenter", "A"],
                  ["What type of cyberattack floods a target web server with excessive traffic requests from compromised botnets to make it unavailable?", "MCQ", "DDoS (Distributed Denial of Service) Attack", "Phishing Scam", "SQL Injection", "Keylogger", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["A company wants to secure its remote employees' communication over public Wi-Fi networks. Which technology creates an encrypted private tunnel over the public internet?", "MCQ", "VPN (Virtual Private Network)", "Dial-up Modem", "Telnet Terminal", "Public FTP Server", "A"],
                  ["What is Man-in-the-Middle (MitM) cyber attack and how does HTTPS with SSL/TLS prevent it?", "MCQ", "Attacker intercepts and eavesdrops or alters communication between two parties; HTTPS encrypts data and validates server certificates preventing tampering", "Attacker physically steals the keyboard", "Attacker turns off the power grid", "Attacker deletes local desktop shortcuts", "A"],
                  ["Which authentication mechanism requires two or more distinct verification factors before granting access to a student portal?", "MCQ", "MFA / 2FA (Multi-Factor Authentication)", "Single Plaintext Password", "Guest Login", "Auto-fill without password", "A"],
                  ["What is the purpose of HTTP Status Code 404 vs HTTP Status Code 500?", "MCQ", "404 means Resource Not Found on server; 500 means Internal Server Error occurred during request processing", "404 is successful; 500 is redirect", "404 means page printed; 500 means sound on", "Both mean internet disconnected", "A"],
                  ["Under the Information Technology (IT) Act in India, which section deals with computer hacking and cyber offenses?", "MCQ", "Section 66 (and 43) of IT Act 2000", "Section 10 of Traffic Act", "Section 302 of IPC only", "Section 5 of Electricity Code", "A"]
                ]
              }
            ]
          }
        ]
      },
      {
        unitNumber: 2,
        unitName: "Unit 2 – Advanced HTML5 & CSS Web Development",
        chapters: [
          {
            num: 2,
            name: "CBSE 10 - Semantic Web, Tables, Forms & CSS Box Model",
            missions: [
              {
                mNum: 1,
                q: [
                  ["Which HTML5 semantic element is specifically designed for major navigational links across web pages?", "MCQ", "<nav>", "<navigation>", "<links>", "<menu-bar>", "A"],
                  ["Which HTML attribute on table cells merges two or more horizontal columns into a single cell?", "MCQ", "colspan", "rowspan", "colmerge", "spanwidth", "A"],
                  ["Which HTML form input type restricts user entry to valid email addresses with built-in browser validation?", "MCQ", '<input type=\"email\">', '<input type=\"mail\">', '<input type=\"text-email\">', '<input type=\"address\">', "A"],
                  ["The CSS Box Model consists of which four concentric rectangular layers from inside to outside?", "MCQ", "Content → Padding → Border → Margin", "Margin → Border → Padding → Content", "Content → Border → Padding → Margin", "Border → Margin → Content → Padding", "A"],
                  ["Which CSS property controls how elements are positioned in a responsive 1D flex container?", "MCQ", "display: flex; and justify-content", "display: table-cell;", "float: center;", "align: absolute;", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["The HTML attribute used to merge vertical rows across a table is _______.", "FILL_BLANK", "rowspan", "rowspan", "", "", "rowspan"],
                  ["The outer transparent clearing space outside an element's border is _______.", "FILL_BLANK", "margin", "margin, margin area", "", "", "margin"],
                  ["The inner space between element content and its border is _______.", "FILL_BLANK", "padding", "padding", "", "", "padding"],
                  ["HTML form element used to create multi-line text input is <_______>.", "FILL_BLANK", "textarea", "textarea", "", "", "textarea"],
                  ["The HTML tag used to define table header cells (bold & centered by default) is <_______>.", "FILL_BLANK", "th", "th", "", "", "th"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["What is the difference between GET and POST form submission methods in HTTP/HTML?", "MCQ", "GET appends form data in URL parameters (visible, cached, size-limited); POST sends data in the HTTP request body (secure, hidden, handles large payloads)", "GET is for images only", "POST cannot submit text", "GET requires JavaScript to work", "A"],
                  ["How does CSS 'box-sizing: border-box;' affect element width and height calculation?", "MCQ", "It includes padding and border within the specified width and height, preventing layout breakage", "It doubles margin sizes", "It deletes background colors", "It makes all fonts bold", "A"],
                  ["Which HTML5 tag is used to embed audio files with standard play/pause/volume controls?", "MCQ", '<audio controls><source src=\"track.mp3\" type=\"audio/mpeg\"></audio>', '<sound play=\"track.mp3\">', '<music file=\"track.mp3\">', '<embed-audio=\"track.mp3\">', "A"],
                  ["What is the difference between 'display: none;' and 'visibility: hidden;' in CSS?", "MCQ", "'display: none;' removes the element completely from document layout flow; 'visibility: hidden;' hides the element but preserves its layout space", "Both do the exact same thing", "'visibility: hidden;' deletes the DOM node", "'display: none;' turns the text blue", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["A developer writes `<form action=\"/submit\" method=\"POST\"><input type=\"password\" required minlength=\"8\"><button type=\"submit\">Register</button></form>`. What occurs when a user clicks submit with 4 characters?", "MCQ", "The browser prevents form submission and displays built-in client-side validation error requiring at least 8 characters", "The server crashes immediately", "The password is saved in plaintext on Google", "The page reloads and logs out the user", "A"],
                  ["How do CSS Media Queries enable responsive web design across mobile, tablet, and desktop viewports?", "MCQ", "They apply specific CSS rules conditionally based on device characteristics like screen width (`@media (max-width: 768px)`)", "They translate web pages to different human languages", "They increase Wi-Fi internet bandwidth", "They compress database tables", "A"],
                  ["Why are semantic HTML tags (`<header>`, `<main>`, `<article>`, `<footer>`) essential over generic `<div>` tags?", "MCQ", "They provide accessibility for screen readers, enhance search engine SEO indexing, and improve maintainability", "They execute faster Python code", "They prevent CSS from running", "They require less electricity", "A"],
                  ["Which CSS layout model provides 2-dimensional grid-based layout systems with rows and columns simultaneously?", "MCQ", "CSS Grid Layout (`display: grid;`)", "Float Left and Right", "Inline-Block alignment", "HTML Frame tags", "A"],
                  ["What is the purpose of the 'alt' attribute in `<img>` tags?", "MCQ", "Provides alternative textual description for visually impaired users using screen readers and displays when image fails to load", "Changes image hue and saturation", "Specifies image download URL", "Rotates image by 90 degrees", "A"]
                ]
              }
            ]
          }
        ]
      },
      {
        unitNumber: 3,
        unitName: "Unit 3 – Database Management Systems & SQL",
        chapters: [
          {
            num: 3,
            name: "CBSE 10 - Relational Database Concepts & Structured Query Language",
            missions: [
              {
                mNum: 1,
                q: [
                  ["In a Relational Database Management System (RDBMS), a table is also known mathematically as a _______.", "MCQ", "Relation", "Tuple", "Attribute", "Domain", "A"],
                  ["What is a Primary Key in a relational database table?", "MCQ", "A column or set of columns uniquely identifying every record in the table, having non-null unique values", "A key that unlocks the hard drive", "A password for admin login", "A temporary index file", "A"],
                  ["A column in a table that links to and references the Primary Key of another table is called a _______.", "MCQ", "Foreign Key", "Candidate Key", "Alternate Key", "Composite Key", "A"],
                  ["Which SQL command is used to retrieve specific columns from a database table?", "MCQ", "SELECT", "RETRIEVE", "FETCH", "EXTRACT", "A"],
                  ["Which SQL clause is used to filter records that satisfy a specific Boolean condition?", "MCQ", "WHERE", "HAVING", "FILTER", "WHEN", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["The SQL command used to retrieve records from tables is _______.", "FILL_BLANK", "SELECT", "SELECT", "", "", "SELECT"],
                  ["The SQL clause used to filter table rows conditionally is _______.", "FILL_BLANK", "WHERE", "WHERE", "", "", "WHERE"],
                  ["In RDBMS terminology, a single row in a table is called a _______.", "FILL_BLANK", "Tuple", "Tuple, Record", "", "", "Tuple"],
                  ["In RDBMS terminology, a single column in a table is called an _______.", "FILL_BLANK", "Attribute", "Attribute, Field", "", "", "Attribute"],
                  ["The SQL keyword used to sort query result sets in ascending or descending sequence is _______ BY.", "FILL_BLANK", "ORDER", "ORDER", "", "", "ORDER"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["What is the fundamental difference between DDL (Data Definition Language) and DML (Data Manipulation Language) commands in SQL?", "MCQ", "DDL (CREATE, ALTER, DROP) modifies schema structure; DML (INSERT, UPDATE, DELETE, SELECT) manipulates table data records", "DDL is for numbers; DML is for text", "DDL is Python; DML is Java", "DDL deletes databases; DML creates networks", "A"],
                  ["Given query `SELECT student_name, marks FROM Students WHERE marks >= 85 ORDER BY marks DESC;`, what does this return?", "MCQ", "Student names and marks scoring 85 or above, sorted from highest marks to lowest", "All students scoring under 85 sorted alphabetically", "Random 85 students", "Calculates the average of all marks", "A"],
                  ["Which SQL aggregate function computes the total number of rows matching criteria?", "MCQ", "COUNT()", "SUM()", "TOTAL()", "ROWS()", "A"],
                  ["What does the 'UPDATE' statement do in SQL?", "MCQ", "Modifies existing data values in one or more records in a table", "Creates a brand new table", "Deletes all columns permanently", "Upgrades MySQL server version", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["A school database has table `Students (RollNo INT PRIMARY KEY, Name VARCHAR(50), Marks INT, City VARCHAR(30))`. Which query finds students from 'Chennai' with marks > 90?", "MCQ", "SELECT * FROM Students WHERE City = 'Chennai' AND Marks > 90;", "SELECT ALL Students IN 'Chennai' IF Marks > 90;", "FIND Students WHERE City IS 'Chennai' AND Marks > 90;", "FILTER Students ON City='Chennai' AND Marks > 90;", "A"],
                  ["What is Referential Integrity in relational database design?", "MCQ", "A database rule ensuring Foreign Key values in child tables must match valid existing Primary Key values in parent tables", "Encrypting database hard drives", "Preventing duplicate user passwords", "Backing up data to cloud daily", "A"],
                  ["How does the SQL `GROUP BY` clause work in conjunction with aggregate functions?", "MCQ", "It groups rows having identical values in specified columns into summary rows (e.g., finding total marks per department)", "It deletes duplicate rows from the table", "It sorts records alphabetically only", "It merges two SQL databases into one", "A"],
                  ["What is the purpose of the `DROP TABLE` vs `DELETE FROM table;` commands in SQL?", "MCQ", "`DROP TABLE` destroys the entire table structure and data permanently; `DELETE` removes rows while preserving table schema", "Both commands do the exact same thing", "`DROP TABLE` empties rows; `DELETE` removes the database", "`DROP` is a DML statement", "A"],
                  ["Which SQL constraint ensures that all values in a column are distinct and cannot have duplicates?", "MCQ", "UNIQUE", "NOT NULL", "CHECK", "DEFAULT", "A"]
                ]
              }
            ]
          }
        ]
      },
      {
        unitNumber: 4,
        unitName: "Unit 4 – Python Programming & Algorithmic Problem Solving",
        chapters: [
          {
            num: 4,
            name: "CBSE 10 - Functions, Data Structures & Algorithmic Logic",
            missions: [
              {
                mNum: 1,
                q: [
                  ["Which Python keyword is used to declare a user-defined reusable function?", "MCQ", "def", "function", "fn", "define", "A"],
                  ["What is the output of `len([10, 20, 30, [40, 50]])` in Python?", "MCQ", "4", "5", "6", "3", "A"],
                  ["Which Python data collection type is ordered, mutable, and enclosed in square brackets `[]`?", "MCQ", "List", "Tuple", "Dictionary", "Set", "A"],
                  ["Which Python built-in data type stores key-value pairs enclosed in curly braces `{}`?", "MCQ", "Dictionary (dict)", "List", "Tuple", "String", "A"],
                  ["What value is returned by `17 // 4` and `17 % 4` in Python?", "MCQ", "4 and 1", "4.25 and 1", "4 and 0", "3 and 5", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["The Python keyword used to define a function is _______.", "FILL_BLANK", "def", "def", "", "", "def"],
                  ["The Python function used to get user keyboard input as a string is _______().", "FILL_BLANK", "input", "input", "", "", "input"],
                  ["The keyword used to return an output value from a Python function is _______.", "FILL_BLANK", "return", "return", "", "", "return"],
                  ["To append an element to the end of a list in Python, we call the ._______() method.", "FILL_BLANK", "append", "append", "", "", "append"],
                  ["The built-in Python function that returns the number of items in a list or sequence is _______().", "FILL_BLANK", "len", "len", "", "", "len"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["Consider Python code: `def calc_bill(price, tax=0.05): return price + (price * tax)`. What is `calc_bill(100)`?", "MCQ", "105.0", "100.0", "150.0", "TypeError: missing tax argument", "A"],
                  ["What is the difference between Python's `break` and `continue` loop control statements?", "MCQ", "`break` terminates loop execution immediately; `continue` skips the rest of current iteration and moves to next cycle", "`break` pauses for 5 seconds", "`continue` exits the entire script", "Both statements are identical", "A"],
                  ["What is the result of slicing expression `\"ComputerQuest\"[0:8]`?", "MCQ", "\"Computer\"", "\"ComputerQ\"", "\"Quest\"", "\"omputer\"", "A"],
                  ["What is the key difference between a Python List `[1, 2]` and a Python Tuple `(1, 2)`?", "MCQ", "Lists are mutable (can add/modify/delete items); Tuples are immutable (read-only after creation)", "Tuples cannot hold numbers", "Lists cannot be printed", "Tuples are only used in SQL", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["What is the output of the following Python program?\n```python\nnums = [1, 2, 3, 4, 5]\nres = [x * 2 for x in nums if x % 2 != 0]\nprint(res)\n```", "MCQ", "[2, 6, 10]", "[4, 8]", "[1, 3, 5]", "[2, 4, 6, 8, 10]", "A"],
                  ["What is recursion in computer programming?", "MCQ", "A programming technique where a function calls itself directly or indirectly to solve smaller subproblems until reaching a base condition", "Running an infinite loop by accident", "Importing external libraries", "Compiling code to machine language", "A"],
                  ["Consider Python code:\n```python\nstudent = {'name': 'Arun', 'score': 92}\nstudent['grade'] = 'A'\nprint(len(student))\n```\nWhat is printed?", "MCQ", "3", "2", "6", "TypeError", "A"],
                  ["What is Linear Search vs Binary Search time complexity efficiency on a sorted array of 1,000,000 elements?", "MCQ", "Linear Search checks up to 1,000,000 items (O(N)); Binary Search divides in half and checks at most ~20 comparisons (O(log N))", "Linear Search is always faster", "Binary Search requires 1,000,000 steps", "Both take exactly 500,000 steps", "A"],
                  ["How does Python handle runtime exceptions using `try-except` blocks?", "MCQ", "Code inside `try` is executed; if an exception occurs, flow jumps to `except` preventing program crash", "It deletes corrupted files automatically", "It ignores all syntax errors", "It restarts the operating system", "A"]
                ]
              }
            ]
          }
        ]
      },
      {
        unitNumber: 5,
        unitName: "Unit 5 – Artificial Intelligence Project Cycle & Ethics",
        chapters: [
          {
            num: 5,
            name: "CBSE 10 - AI Project Cycle, Machine Learning & Ethical AI",
            missions: [
              {
                mNum: 1,
                q: [
                  ["What are the 5 official stages of the CBSE Artificial Intelligence Project Cycle in order?", "MCQ", "Problem Scoping → Data Acquisition → Data Exploration → Modelling → Evaluation", "Coding → Testing → Marketing → Selling → Debugging", "Data Collection → Deep Learning → Robotics → Neural Networks → AI", "Problem Definition → Database Design → SQL → Python → Deployment", "A"],
                  ["In AI Problem Scoping, which framework is used to structure the problem statement using 4 Ws?", "MCQ", "4Ws Canvas (Who, What, Where, Why)", "5S Framework", "SWOT Analysis", "Eisenhower Matrix", "A"],
                  ["Which domain of Artificial Intelligence deals with processing and understanding human spoken and written text?", "MCQ", "Natural Language Processing (NLP)", "Computer Vision (CV)", "Data Sciences", "Quantum Computing", "A"],
                  ["Which AI domain empowers machines to identify, process, and analyze visual information from digital images and videos?", "MCQ", "Computer Vision (CV)", "Natural Language Processing", "Voice Synthesis", "Relational Database", "A"],
                  ["What is the fundamental difference between Rule-Based AI and Learning-Based (Machine Learning) AI?", "MCQ", "Rule-based systems follow explicit developer-coded IF-ELSE rules; Learning-based systems discover patterns directly from training data", "Rule-based AI uses neural networks", "Learning-based AI requires no data", "Rule-based AI is conscious", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["The first stage of the AI Project Cycle is Problem _______.", "FILL_BLANK", "Scoping", "Scoping", "", "", "Scoping"],
                  ["AI systems analyzing human text and spoken language belong to the _______ domain.", "FILL_BLANK", "NLP", "NLP, Natural Language Processing", "", "", "NLP"],
                  ["AI systems identifying objects in digital photos and video feeds belong to Computer _______.", "FILL_BLANK", "Vision", "Vision, CV", "", "", "Vision"],
                  ["The stage where dataset patterns and statistical trends are visualized using charts is Data _______.", "FILL_BLANK", "Exploration", "Exploration", "", "", "Exploration"],
                  ["Algorithmic prejudice resulting from unrepresentative training datasets is known as AI _______.", "FILL_BLANK", "Bias", "Bias, Algorithmic Bias", "", "", "Bias"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["In Machine Learning, what is Supervised Learning vs Unsupervised Learning?", "MCQ", "Supervised Learning trains on labeled input-output dataset pairs; Unsupervised Learning finds hidden patterns/clusters in unlabeled data", "Supervised Learning requires a human watching the screen 24/7", "Unsupervised Learning uses no computers", "Supervised Learning is only for robotics", "A"],
                  ["What is a Confusion Matrix used for in AI Model Evaluation?", "MCQ", "A performance measurement table containing True Positives, True Negatives, False Positives, and False Negatives", "A screen to confuse hackers", "A mathematical puzzle for students", "A database sorting algorithm", "A"],
                  ["What does the Precision evaluation metric measure in classification models?", "MCQ", "The percentage of true positive predictions out of all positive predictions made by the model", "The speed of model training in seconds", "The total size of the dataset in megabytes", "The number of lines of Python code", "A"],
                  ["What is Data Privacy and Algorithmic Bias in Artificial Intelligence systems?", "MCQ", "Protecting individual personal data from unauthorized use and ensuring AI models do not perpetuate human prejudices or discrimination", "Making all data public to everyone", "Increasing GPU overclocking speeds", "Enforcing copyright on open source code", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["A medical diagnostic AI model identifies 95 out of 100 cancer cases correctly, but mistakenly diagnoses 5 healthy patients as having cancer. What are these 5 mistaken diagnoses called in AI evaluation?", "MCQ", "False Positives (Type I Error)", "True Positives", "True Negatives", "False Negatives (Type II Error)", "A"],
                  ["Why is an AI model's training accuracy of 99% misleading if the model is tested on the exact same dataset it trained on (Overfitting)?", "MCQ", "The model memorized training data noise instead of learning generalizable patterns, causing it to fail on unseen real-world test data", "The computer CPU was overheated", "Python does not support 99% accuracy", "Higher accuracy always causes hardware damage", "A"],
                  ["Which ethical AI guideline ensures that automated decisions made by AI systems can be explained and justified in transparent human terms?", "MCQ", "Explainability and Transparency (XAI)", "Black-Box Obfuscation", "Proprietary Secrecy", "Automated Disregard", "A"],
                  ["What is Deep Learning and how does it relate to Machine Learning and Artificial Intelligence?", "MCQ", "Deep Learning is a subset of Machine Learning utilizing multi-layered Artificial Neural Networks inspired by biological brain structures", "Deep Learning is a replacement for operating systems", "Deep Learning is only used for typing games", "Machine Learning is a subset of Deep Learning", "A"],
                  ["Which smart city application utilizes Computer Vision and IoT sensors for automated traffic management and license plate recognition?", "MCQ", "Intelligent Transportation Systems (ITS)", "Spreadsheet Data Entry", "Offline Word Processor", "BIOS Firmware Bootloader", "A"]
                ]
              }
            ]
          }
        ]
      }
    ]
  }
];
