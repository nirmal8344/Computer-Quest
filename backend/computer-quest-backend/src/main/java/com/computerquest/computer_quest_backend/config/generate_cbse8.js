const fs = require('fs');
const path = require('path');

const targetFile = "c:\\Users\\ADMIN\\OneDrive\\Documents\\Computer-Quest\\backend\\computer-quest-backend\\src\\main\\java\\com\\computerquest\\computer_quest_backend\\config\\Class4To10SyllabusSeeder.java";

// Read existing file up to seedCbse7_Ch4
let content = fs.readFileSync(targetFile, 'utf8');

// We will append CBSE Class 8, 9, 10 and State Board Class 4, 5, 6, 7, 8, 9, 10 before closing brace
let additionalCode = `
    // =========================================================================
    // CBSE CLASS 8
    // =========================================================================
    private void seedCbseClass8(School school) {
        String board = "CBSE";
        int lvl = 8;
        String u1 = "UNIT 1 – ADVANCED WEB, PYTHON LOOPS, DBMS AND AI";
        getOrCreateUnit(school, board, lvl, 1, u1);

        String ch1 = "CBSE 8 - Advanced HTML5 Lists, Tables and CSS Styling";
        getOrCreateChapter(school, board, lvl, u1, 1, ch1);
        seedCbse8_Ch1(school, board, lvl, u1, ch1);

        String ch2 = "CBSE 8 - Python Iterations, For Loops and While Loops";
        getOrCreateChapter(school, board, lvl, u1, 2, ch2);
        seedCbse8_Ch2(school, board, lvl, u1, ch2);

        String ch3 = "CBSE 8 - Relational Database Management System (RDBMS) Concepts";
        getOrCreateChapter(school, board, lvl, u1, 3, ch3);
        seedCbse8_Ch3(school, board, lvl, u1, ch3);

        String ch4 = "CBSE 8 - Computer Networks and Introduction to Artificial Intelligence";
        getOrCreateChapter(school, board, lvl, u1, 4, ch4);
        seedCbse8_Ch4(school, board, lvl, u1, ch4);
    }

    private void seedCbse8_Ch1(School s, String b, int lvl, String u, String ch) {
        // Mission 1: MCQ
        addQuestionIfMissing(s, b, lvl, u, ch, 1, "Which HTML tag creates a numbered ordered list?", "MCQ", "<ol>", "<ul>", "<li>", "<dl>", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 1, "Which HTML tag creates a bulleted unordered list?", "MCQ", "<ul>", "<ol>", "<list>", "<bullet>", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 1, "Which tag defines an individual item within an ordered or unordered list in HTML?", "MCQ", "<li>", "<item>", "<ul>", "<dt>", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 1, "What does CSS stand for in web styling?", "MCQ", "Cascading Style Sheets", "Creative Style System", "Computer Style Structure", "Colorful Sheet Styling", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 1, "Which HTML tag defines a table in a webpage?", "MCQ", "<table>", "<tab>", "<tr>", "<td>", "A", null);

        // Mission 2: Fill in the Blank
        addQuestionIfMissing(s, b, lvl, u, ch, 2, "In an HTML table, each horizontal table row is defined using the <_______> tag.", "FILL_BLANK", "tr", "tr, TR", null, null, "tr", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 2, "In an HTML table, a standard data cell is defined using the <_______> tag.", "FILL_BLANK", "td", "td, TD", null, null, "td", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 2, "In an HTML table, a bold centered header cell is defined using the <_______> tag.", "FILL_BLANK", "th", "th, TH", null, null, "th", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 2, "The CSS property used to change text color is _______.", "FILL_BLANK", "color", "color", null, null, "color", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 2, "The CSS property used to change page background color is _______-color.", "FILL_BLANK", "background", "background", null, null, "background", null);

        // Mission 3: MCQ
        addQuestionIfMissing(s, b, lvl, u, ch, 3, "Which CSS property specifies the font face family of text (e.g. Arial, Roboto)?", "MCQ", "font-family", "font-weight", "text-font", "font-style", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 3, "Which CSS property specifies the size of text (e.g. 16px, 1.2rem)?", "MCQ", "font-size", "text-size", "font-scale", "size", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 3, "Which HTML table attribute merges multiple adjacent columns into one wide cell?", "MCQ", "colspan=\"2\"", "rowspan=\"2\"", "cellmerge", "span", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 3, "Which HTML table attribute merges multiple adjacent rows into one tall cell?", "MCQ", "rowspan=\"2\"", "colspan=\"2\"", "rowmerge", "merge", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 3, "Which HTML tag is used to write internal CSS styles inside the <head> section?", "MCQ", "<style>", "<css>", "<script>", "<link>", "A", null);

        // Mission 4: Scenario Challenge
        addQuestionIfMissing(s, b, lvl, u, ch, 4, "A student writes CSS: h1 { color: #e74c3c; text-align: center; }. What will this rule do?", "MCQ", "Makes all <h1> headings red color and centered horizontally", "Deletes <h1> headings", "Makes headings italic and right-aligned", "Changes background to black", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 4, "You want to create a nested list of computer components with sub-bullets. Which structure is valid?", "MCQ", "<ul><li>Hardware<ul><li>CPU</li><li>RAM</li></ul></li></ul>", "<ol><list>Hardware</list></ol>", "<ul><ol><li>Hardware</li></ol></ul>", "<li><ul>Hardware</ul></li>", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 4, "How can you link an external CSS file named 'style.css' to your HTML document?", "MCQ", "<link rel=\"stylesheet\" href=\"style.css\">", "<style src=\"style.css\">", "<css link=\"style.css\">", "<script href=\"style.css\">", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 4, "Which CSS property adds empty breathing space inside the border of a box?", "MCQ", "padding", "margin", "border-width", "outline", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 4, "Which CSS property adds empty space outside around the border of an element?", "MCQ", "margin", "padding", "border-radius", "box-shadow", "A", null);
    }

    private void seedCbse8_Ch2(School s, String b, int lvl, String u, String ch) {
        // Mission 1: MCQ
        addQuestionIfMissing(s, b, lvl, u, ch, 1, "Which Python loop is used to iterate over a sequence of numbers or collection items?", "MCQ", "for loop", "switch loop", "repeat loop", "do loop", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 1, "Which built-in Python function generates a sequence of immutable integers (e.g. range(1, 6))?", "MCQ", "range()", "sequence()", "generate()", "numbers()", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 1, "What sequence of numbers does range(5) generate in Python?", "MCQ", "0, 1, 2, 3, 4 (5 is excluded)", "1, 2, 3, 4, 5", "0, 1, 2, 3, 4, 5", "5, 4, 3, 2, 1", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 1, "What sequence of numbers does range(2, 10, 2) generate in Python?", "MCQ", "2, 4, 6, 8 (Starts at 2, steps by 2, stops before 10)", "2, 3, 4, 5, 6, 7, 8, 9, 10", "2, 4, 6, 8, 10", "0, 2, 4, 6, 8", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 1, "Which Python keyword instantly terminates and breaks out of the innermost running loop?", "MCQ", "break", "continue", "pass", "exit", "A", null);

        // Mission 2: Fill in the Blank
        addQuestionIfMissing(s, b, lvl, u, ch, 2, "The keyword in Python used to skip the rest of the current iteration and jump to the next cycle is _______.", "FILL_BLANK", "continue", "continue, CONTINUE", null, null, "continue", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 2, "A loop that executes repeatedly as long as a specified condition remains True is a _______ loop.", "FILL_BLANK", "while", "while, While", null, null, "while", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 2, "A variable used inside a loop to accumulate and store running totals is called an _______.", "FILL_BLANK", "accumulator", "accumulator, Accumulator", null, null, "accumulator", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 2, "In range(start, stop, step), the parameter that specifies increment between numbers is _______.", "FILL_BLANK", "step", "step, Step", null, null, "step", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 2, "A loop placed entirely inside the body of another loop is called a _______ loop.", "FILL_BLANK", "nested", "nested, Nested", null, null, "nested", null);

        // Mission 3: MCQ
        addQuestionIfMissing(s, b, lvl, u, ch, 3, "What will be printed by: for i in range(1, 4): print(i * 2, end=' ')?", "MCQ", "2 4 6 ", "2 4 6 8 ", "1 2 3 ", "2 3 4 ", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 3, "What will be the value of total after: total = 0; for i in range(1, 5): total += i?", "MCQ", "10 (1+2+3+4 = 10)", "15", "5", "0", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 3, "How many times does this while loop execute: count = 0; while count < 3: count += 1?", "MCQ", "3 times", "4 times", "2 times", "Infinite times", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 3, "What happens if a while loop condition never becomes False (e.g. while True)?", "MCQ", "It results in an Infinite Loop and never terminates automatically", "It causes a syntax error", "It runs once and deletes the file", "It automatically stops in 10 seconds", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 3, "What will this code print: for x in [10, 20, 30]: if x == 20: break; print(x)?", "MCQ", "10", "10 20", "10 20 30", "Nothing", "A", null);

        // Mission 4: Scenario Challenge
        addQuestionIfMissing(s, b, lvl, u, ch, 4, "A student writes a Python script to print the multiplication table of 7 from 1 to 10. Which loop header is correct?", "MCQ", "for i in range(1, 11): print(7 * i)", "for i in range(1, 10): print(7 * i)", "while i < 10: print(7)", "for 7 in range(10): print(i)", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 4, "What will this code print: for i in range(1, 6): if i == 3: continue; print(i, end=' ')?", "MCQ", "1 2 4 5  (3 is skipped)", "1 2 3 4 5 ", "1 2 ", "3 4 5 ", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 4, "How to calculate the factorial of 5 (5! = 5*4*3*2*1) using a Python for loop?", "MCQ", "fact = 1; for i in range(1, 6): fact *= i", "fact = 0; for i in range(1, 6): fact += i", "fact = 5 * 5", "fact = range(5)", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 4, "In nested loops: for i in range(3): for j in range(2): print('*', end=''). How many asterisks are printed?", "MCQ", "6 asterisks (3 * 2 = 6)", "5 asterisks", "3 asterisks", "2 asterisks", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 4, "What is the key difference between a for loop and a while loop in Python?", "MCQ", "For loop iterates over a predetermined sequence; While loop continues based on a condition", "For loop cannot use variables", "While loop is only for text", "There is no difference", "A", null);
    }

    private void seedCbse8_Ch3(School s, String b, int lvl, String u, String ch) {
        // Mission 1: MCQ
        addQuestionIfMissing(s, b, lvl, u, ch, 1, "What does DBMS stand for in computer data management?", "MCQ", "Database Management System", "Data Binary Management Software", "Digital Business Memory Storage", "Direct Base Main System", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 1, "What is an organized collection of related data stored electronically in a structured format?", "MCQ", "Database", "Spreadsheet Macro", "Operating System", "Web Server", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 1, "In a relational database table (RDBMS), what is a single horizontal row representing an entity called?", "MCQ", "Record / Tuple", "Field / Attribute", "Key", "Schema", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 1, "In a database table, what is a single vertical column holding a specific data property called?", "MCQ", "Field / Attribute", "Tuple", "Record", "Index", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 1, "Which field in a database table uniquely identifies every record without any duplicates or NULLs?", "MCQ", "Primary Key", "Foreign Key", "Secondary Key", "Composite Key", "A", null);

        // Mission 2: Fill in the Blank
        addQuestionIfMissing(s, b, lvl, u, ch, 2, "A field in one table that links and refers to the Primary Key of another table is a _______ Key.", "FILL_BLANK", "Foreign", "Foreign, Foreign key", null, null, "Foreign", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 2, "Unnecessary and unwanted duplication of the same data across multiple files is called Data _______.", "FILL_BLANK", "Redundancy", "Redundancy", null, null, "Redundancy", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 2, "The state where multiple copies of data conflict and do not match each other is Data _______.", "FILL_BLANK", "Inconsistency", "Inconsistency", null, null, "Inconsistency", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 2, "The number of attributes (columns) in a relation/table is called the _______ of the relation.", "FILL_BLANK", "Degree", "Degree", null, null, "Degree", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 2, "The number of tuples (rows) in a relation/table is called the _______ of the relation.", "FILL_BLANK", "Cardinality", "Cardinality", null, null, "Cardinality", null);

        // Mission 3: MCQ
        addQuestionIfMissing(s, b, lvl, u, ch, 3, "Which of the following is a widely used Relational Database Management System (RDBMS)?", "MCQ", "MySQL / PostgreSQL", "MS Word", "Google Chrome", "Adobe Reader", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 3, "What language is the international standard used to query, insert, and manage relational databases?", "MCQ", "SQL (Structured Query Language)", "HTML", "CSS", "Assembly", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 3, "What does NULL represent when stored in a database field?", "MCQ", "Missing, unknown, or unassigned data value", "Zero (0)", "A blank space ' '", "Negative infinity", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 3, "If a table contains 5 columns and 20 rows, what is its Degree and Cardinality?", "MCQ", "Degree = 5, Cardinality = 20", "Degree = 20, Cardinality = 5", "Degree = 100, Cardinality = 1", "Degree = 1, Cardinality = 100", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 3, "Which candidate key is chosen by the database designer as the primary identifier for a table?", "MCQ", "Primary Key", "Alternate Key", "Foreign Key", "Foreign Index", "A", null);

        // Mission 4: Scenario Challenge
        addQuestionIfMissing(s, b, lvl, u, ch, 4, "A school database table 'Students' contains fields: RollNo, StudentName, Class, Phone. Which field is the best choice for Primary Key?", "MCQ", "RollNo (Unique for every student)", "StudentName (Two students can have the same name)", "Class (Many students share the same class)", "Phone (Siblings share phone number)", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 4, "Why is storing data in an RDBMS superior to maintaining separate paper ledgers or plain text files?", "MCQ", "Reduces data redundancy, ensures data consistency, provides fast search, and secures data", "Uses more paper", "Requires no computers", "Slows down operations", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 4, "In an e-commerce database, an 'Orders' table stores CustomerID to look up customer details in 'Customers' table. What role does CustomerID play in 'Orders'?", "MCQ", "Foreign Key", "Primary Key of Orders", "Redundant Column", "Index Only", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 4, "What constraint prevents entering duplicate values into a table column?", "MCQ", "UNIQUE Constraint / PRIMARY KEY", "NOT NULL only", "DEFAULT constraint", "CHECK constraint only", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 4, "A database designer needs to ensure an 'Age' column never accepts negative numbers. Which constraint accomplishes this?", "MCQ", "CHECK (Age >= 0)", "NOT NULL", "FOREIGN KEY", "PRIMARY KEY", "A", null);
    }

    private void seedCbse8_Ch4(School s, String b, int lvl, String u, String ch) {
        // Mission 1: MCQ
        addQuestionIfMissing(s, b, lvl, u, ch, 1, "What type of network connects computers within a small localized area like a single room, school, or office?", "MCQ", "LAN (Local Area Network)", "WAN (Wide Area Network)", "MAN (Metropolitan Area Network)", "PAN (Personal Area Network)", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 1, "What type of computer network spans across cities, countries, or the entire globe (e.g. the Internet)?", "MCQ", "WAN (Wide Area Network)", "LAN", "PAN", "WLAN", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 1, "In which network topology are all client nodes connected directly to a central hub or switch?", "MCQ", "Star Topology", "Bus Topology", "Ring Topology", "Mesh Topology", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 1, "In which network topology are all devices connected along a single continuous central backbone cable?", "MCQ", "Bus Topology", "Star Topology", "Tree Topology", "Ring Topology", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 1, "What does AI stand for in modern computing science?", "MCQ", "Artificial Intelligence", "Automated Information", "Advanced Internet", "Application Interface", "A", null);

        // Mission 2: Fill in the Blank
        addQuestionIfMissing(s, b, lvl, u, ch, 2, "A network connecting personal devices like a smartphone and smartwatch via Bluetooth is a _______ Area Network (PAN).", "FILL_BLANK", "Personal", "Personal, PAN", null, null, "Personal", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 2, "The hardware device that connects local networks to the external internet by routing packets is a _______.", "FILL_BLANK", "Router", "Router", null, null, "Router", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 2, "The domain of AI that enables computers to interpret, understand, and process human text and speech is _______ (Natural Language Processing).", "FILL_BLANK", "NLP", "NLP, Natural Language Processing", null, null, "NLP", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 2, "The domain of AI that enables machines to identify, process, and analyze visual images and video is Computer _______.", "FILL_BLANK", "Vision", "Vision", null, null, "Vision", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 2, "The branch of AI where machines learn and improve from experience and data without explicit programming is _______ Learning.", "FILL_BLANK", "Machine", "Machine, Machine Learning", null, null, "Machine", null);

        // Mission 3: MCQ
        addQuestionIfMissing(s, b, lvl, u, ch, 3, "What unique numerical 32-bit or 128-bit address identifies every device connected to the internet?", "MCQ", "IP Address (Internet Protocol Address)", "MAC Address", "Port Number", "URL", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 3, "What unique permanent hardware identifier is burned into every Network Interface Card (NIC)?", "MCQ", "MAC Address (Media Access Control)", "IP Address", "Subnet Mask", "DNS Name", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 3, "What server translates human-friendly domain names (like www.google.com) into numerical IP addresses?", "MCQ", "DNS Server (Domain Name System)", "DHCP Server", "FTP Server", "Proxy Server", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 3, "Which AI application recognizes faces in photos and unlocks modern smartphones securely?", "MCQ", "Computer Vision & Facial Recognition", "Speech Synthesizer", "Spell Checker", "Disk Defragmenter", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 3, "What virtual conversational AI agent communicates with users via text or voice in customer service?", "MCQ", "Chatbot / Conversational AI", "Firewall", "Operating System", "Compiler", "A", null);

        // Mission 4: Scenario Challenge
        addQuestionIfMissing(s, b, lvl, u, ch, 4, "A school is setting up a new computer lab with 30 computers. If one computer fails in a Star topology, what happens to the others?", "MCQ", "All other 29 computers continue operating normally without interruption", "The entire network crashes", "The server catches fire", "All cables must be replaced", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 4, "Autonomous self-driving cars use cameras, radar, and AI models to detect pedestrians and street signs in real time. Which AI domain is this?", "MCQ", "Computer Vision and Real-time Machine Learning", "Spreadsheet Macro", "Word Processor", "File Compression", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 4, "What ethical concern arises when training AI models on biased, non-representative historical datasets?", "MCQ", "AI model produces unfair, discriminatory, or biased decisions (Algorithmic Bias)", "The computer runs out of RAM", "The monitor color fades", "Internet speed drops", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 4, "Why is optical fiber cable superior to traditional copper twisted pair cable for high-speed internet backbones?", "MCQ", "Transmits data as pulses of light with ultra-high bandwidth and zero electromagnetic interference", "It uses radio waves", "It requires no cables", "It is made of wood", "A", null);
        addQuestionIfMissing(s, b, lvl, u, ch, 4, "How do smart spam filters use Machine Learning to keep unwanted emails out of your inbox?", "MCQ", "They analyze patterns and keywords from millions of known spam emails to classify incoming mail", "Humans read every single email manually", "They delete all emails with attachments", "They block the entire internet", "A", null);
    }
`;

fs.writeFileSync("c:\\Users\\ADMIN\\OneDrive\\Documents\\Computer-Quest\\backend\\computer-quest-backend\\src\\main\\java\\com\\computerquest\\computer_quest_backend\\config\\cbse8_patch.txt", additionalCode, 'utf8');
console.log("CBSE 8 patch written successfully");
