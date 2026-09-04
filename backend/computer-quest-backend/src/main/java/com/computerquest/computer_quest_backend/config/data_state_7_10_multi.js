// =========================================================================
// TAMIL NADU STATE BOARD (SAMACHEER KALVI) - CLASSES 7, 8, 9, 10
// Official Multi-Unit Curricula
// Classes 7 & 8 (Term 1, 2, 3), Class 9 (4 Units), Class 10 (5 Units)
// =========================================================================

module.exports = [
  // -------------------------------------------------------------
  // STATE BOARD CLASS 7 (Samacheer Kalvi Term 1, 2, 3)
  // -------------------------------------------------------------
  {
    board: "STATE_BOARD",
    classLevel: 7,
    units: [
      {
        unitNumber: 1,
        unitName: "Unit 1 – Term 1: Spreadsheet Analysis with LibreOffice Calc",
        chapters: [
          {
            num: 1,
            name: "TN 7 - Worksheets, Cells, Formulas & Data Visualization",
            missions: [
              {
                mNum: 1,
                q: [
                  ["Which application in LibreOffice is used for tabular calculations and numerical analysis?", "MCQ", "LibreOffice Calc", "LibreOffice Writer", "LibreOffice Impress", "LibreOffice Base", "A"],
                  ["The intersection of a vertical column and a horizontal row in a worksheet is called a _______.", "MCQ", "Cell", "Block", "Grid", "Table", "A"],
                  ["What must every formula or calculation in LibreOffice Calc begin with?", "MCQ", "Equal sign (=)", "Plus sign (+)", "Hash sign (#)", "Colon (:)", "A"],
                  ["Which built-in function calculates the total sum of numeric values across a cell range?", "MCQ", "=SUM(A1:A10)", "=ADD(A1:A10)", "=TOTAL(A1:A10)", "=COUNT(A1:A10)", "A"],
                  ["What is the standard file extension for spreadsheets saved in LibreOffice Calc?", "MCQ", ".ods (OpenDocument Spreadsheet)", ".xlsx", ".odt", ".pdf", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["The spreadsheet application in LibreOffice is LibreOffice _______.", "FILL_BLANK", "Calc", "Calc", "", "", "Calc"],
                  ["The intersection of a row and column is called a _______.", "FILL_BLANK", "Cell", "Cell", "", "", "Cell"],
                  ["All formulas in Calc must start with the _______ symbol.", "FILL_BLANK", "=", "=", "", "", "="],
                  ["The function used to find the highest number in a range is =_______().", "FILL_BLANK", "MAX", "MAX, max", "", "", "MAX"],
                  ["Calc spreadsheet files are saved with the extension ._______.", "FILL_BLANK", "ods", "ods, .ods", "", "", "ods"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["What does the cell reference 'C5' specify in a Calc spreadsheet?", "MCQ", "Column C and Row 5", "Column 5 and Row C", "3rd sheet 5th page", "Cell coordinate C minus 5", "A"],
                  ["Which function calculates the arithmetic average of numeric values in range B1 to B5?", "MCQ", "=AVERAGE(B1:B5)", "=MEAN(B1:B5)", "=AVG(B1:B5)", "=SUM_DIVIDE(B1:B5)", "A"],
                  ["What is the function of the AutoFill handle (small black square at cell bottom-right)?", "MCQ", "Quickly copies formulas or fills sequential series (e.g., 1, 2, 3 or Jan, Feb, Mar) across adjacent cells", "Formats font color", "Deletes cell content", "Locks the worksheet with password", "A"],
                  ["Which chart type in Calc is ideal for comparing percentages and proportions of a whole?", "MCQ", "Pie Chart", "Line Chart", "Scatter Plot", "Radar Chart", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["A teacher has marks in cells D1 to D50. Which formula calculates how many students took the test (count of numbers)?", "MCQ", "=COUNT(D1:D50)", "=TOTAL(D1:D50)", "=LENGTH(D1:D50)", "=ROWS(D1:D50)", "A"],
                  ["What happens when you copy formula `=A1+B1` from cell C1 down into cell C2 (Relative Referencing)?", "MCQ", "It automatically adjusts to `=A2+B2`", "It remains fixed as `=A1+B1`", "It shows #ERROR!", "It deletes column C", "A"],
                  ["How do you make a cell reference Absolute (fixed) so it does not change when copied?", "MCQ", "Add dollar signs (e.g. `$A$1`)", "Add exclamation marks (`!A!1`)", "Add brackets `[A1]`", "Add quotes `\"A1\"`", "A"],
                  ["Which menu path in LibreOffice Calc allows you to insert column or bar charts from selected tabular data?", "MCQ", "Insert Menu → Chart", "Data Menu → Sort", "Format Menu → Cells", "Tools Menu → Macros", "A"],
                  ["What does the error value `###` displayed inside a Calc cell indicate?", "MCQ", "The column is too narrow to display the complete number; widening the column fixes it", "The formula has a syntax error", "The file is corrupted", "The cell is deleted", "A"]
                ]
              }
            ]
          }
        ]
      },
      {
        unitNumber: 2,
        unitName: "Unit 2 – Term 2: Interactive Logic & Variables in Scratch",
        chapters: [
          {
            num: 2,
            name: "TN 7 - Conditional Decisions, Scoring & Game Mechanics",
            missions: [
              {
                mNum: 1,
                q: [
                  ["Which Scratch block evaluates a Boolean condition and executes branch code only if true?", "MCQ", "if <condition> then (Control)", "repeat 10", "forever", "wait 1 secs", "A"],
                  ["Which block enables dual-branch decision making: executing one block if condition is true, and another if false?", "MCQ", "if <condition> then ... else ...", "forever", "repeat until", "wait until", "A"],
                  ["To keep track of a player's score or lives during game play, which Scratch feature is used?", "MCQ", "Variables (Make a Variable)", "Costumes", "Backdrops", "Sound effects", "A"],
                  ["Which block in the Sensing category detects if a specific keyboard key (like Space or Up Arrow) is currently pressed?", "MCQ", "key [space] pressed?", "touching mouse-pointer?", "mouse down?", "timer", "A"],
                  ["Which block changes the numeric value of an existing variable by a specified amount (e.g., +10)?", "MCQ", "change [score] by (10)", "set [score] to (0)", "show variable [score]", "hide variable [score]", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["The Scratch control block used for single conditional branching is if <_______> then.", "FILL_BLANK", "condition", "condition, Boolean", "", "", "condition"],
                  ["To store changing numeric game score, we create a _______.", "FILL_BLANK", "Variable", "Variable", "", "", "Variable"],
                  ["To test equality between two numbers in Scratch, we use the (=) _______ block.", "FILL_BLANK", "Operator", "Operator, Operators", "", "", "Operator"],
                  ["The block that resets a variable to zero at the start of a game is set [score] to _______.", "FILL_BLANK", "0", "0, zero", "", "", "0"],
                  ["To stop all running scripts across the entire Scratch project, we use the stop [_______] block.", "FILL_BLANK", "all", "all", "", "", "all"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["How do you create a collision reaction when a Sprite touches a Danger Sprite in Scratch?", "MCQ", "Place `if <touching [DangerSprite]?> then { change [lives] by -1; play sound [Hit] }` inside a forever loop", "Delete the stage backdrop", "Increase screen resolution", "Disconnect the mouse", "A"],
                  ["What does the 'pick random (1) to (10)' Operator block do in Scratch?", "MCQ", "Generates an unpredictable integer between 1 and 10 on each execution", "Counts the number of sprites", "Picks random sound tracks", "Selects a random student name", "A"],
                  ["How does a 'repeat until <condition>' loop operate in Scratch?", "MCQ", "Executes the enclosed blocks continuously until the specified condition evaluates to True, then exits", "Runs exactly 5 times only", "Never stops running", "Runs backwards", "A"],
                  ["What is the purpose of broadcasting messages between sprites in Scratch game design?", "MCQ", "Allows one sprite to trigger events in other sprites (e.g., broadcasting 'Game Over' to show game over screen)", "Sends text messages to mobile phones", "Connects to online multiplayer servers", "Saves project to PDF", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["A student codes: `when green flag clicked → set score to 0 → forever → if <touching [Coin]?> then { change score by 1; broadcast [Collected] }`. What happens when the player sprite hits a coin?", "MCQ", "The score variable increases by 1 and a broadcast message is fired to hide or reset the coin", "The computer restarts", "The coin turns into text", "The score decreases by 100", "A"],
                  ["Which Scratch block makes a sprite follow the movement of the mouse pointer smoothly across the stage?", "MCQ", "forever { go to [mouse-pointer] }", "move 10 steps", "turn right 90 degrees", "point in direction 90", "A"],
                  ["How can you create a countdown timer variable in Scratch?", "MCQ", "set timer to 60 → repeat 60 { wait 1 secs; change timer by -1 } → broadcast [TimeUp]", "Type timer on keyboard", "Draw a clock costume", "Use the print block", "A"],
                  ["What is the purpose of the 'hide' and 'show' blocks in the Looks category for game sprites?", "MCQ", "Controls whether the sprite is visible on the stage or completely hidden from view", "Adjusts brightness", "Changes costume color", "Mutes sprite sounds", "A"],
                  ["What does the 'distance to [mouse-pointer]' sensing block return?", "MCQ", "The exact numerical distance in pixels from the sprite center to the current cursor position", "The monitor screen size", "The internet speed in Mbps", "The file size in KB", "A"]
                ]
              }
            ]
          }
        ]
      },
      {
        unitNumber: 3,
        unitName: "Unit 3 – Term 3: Introduction to Web Designing with HTML",
        chapters: [
          {
            num: 3,
            name: "TN 7 - Web Basics, HTML Tags, Formatting & Hyperlinks",
            missions: [
              {
                mNum: 1,
                q: [
                  ["What does HTML stand for in website authoring?", "MCQ", "HyperText Markup Language", "Hyperlink Text Multi Language", "High Tech Modern Language", "Home Tool Markup Language", "A"],
                  ["Which tag is the root container tag enclosing all other elements of an HTML web page?", "MCQ", "<html> ... </html>", "<head>", "<body>", "<title>", "A"],
                  ["Which tag contains the visible webpage content displayed inside the browser viewport window?", "MCQ", "<body> ... </body>", "<head>", "<title>", "<meta>", "A"],
                  ["Which HTML heading tag renders the largest and most prominent heading?", "MCQ", "<h1>", "<h6>", "<heading>", "<head1>", "A"],
                  ["Which tag is used to create a clickable hyperlink that navigates to another webpage?", "MCQ", '<a href=\"url\">Click Here</a>', '<link url=\"url\">', '<href to=\"url\">', '<jump site=\"url\">', "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["HTML stands for HyperText Markup _______.", "FILL_BLANK", "Language", "Language", "", "", "Language"],
                  ["The visible content of a web page is placed inside the <_______> tag.", "FILL_BLANK", "body", "body", "", "", "body"],
                  ["The largest heading tag in HTML is <_______>.", "FILL_BLANK", "h1", "h1", "", "", "h1"],
                  ["The smallest standard heading tag in HTML is <_______>.", "FILL_BLANK", "h6", "h6", "", "", "h6"],
                  ["To insert a line break without starting a new paragraph, use the <_______> tag.", "FILL_BLANK", "br", "br, br/", "", "", "br"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["What is the difference between a Container (Paired) tag and an Empty (Void) tag in HTML?", "MCQ", "Container tags have both opening and closing tags (e.g. `<p>...</p>`); Empty tags have no closing tag (e.g. `<br>`, `<img>`)", "Empty tags cannot be used in web pages", "Container tags are only for images", "They are identical", "A"],
                  ["Which attribute in the `<a>` anchor tag specifies the destination web address (URL) of the hyperlink?", "MCQ", "href (Hypertext Reference)", "src", "link", "target", "A"],
                  ["Which tag is used to embed an image onto an HTML web page?", "MCQ", '<img src=\"picture.jpg\" alt=\"Scenery\">', '<image href=\"picture.jpg\">', '<picture source=\"picture.jpg\">', '<photo src=\"picture.jpg\">', "A"],
                  ["What does the `<title>` tag inside the `<head>` section of an HTML document do?", "MCQ", "Sets the text displayed on the web browser tab header", "Prints a large heading in the middle of page", "Sets the font size", "Changes background color", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["A student writes `<p>Welcome to <b>Computer</b> <i>Quest</i></p>`. How does this render in the web browser?", "MCQ", "'Welcome to' in normal font, 'Computer' in bold, and 'Quest' in italic", "All words in bold red", "All words underlined", "It throws a syntax error", "A"],
                  ["Which tag creates a horizontal separating dividing line across the webpage?", "MCQ", "<hr> (Horizontal Rule)", "<line>", "<break>", "<divider>", "A"],
                  ["What is the role of the 'src' and 'alt' attributes in the `<img>` tag?", "MCQ", "'src' provides the image file path; 'alt' provides alternative text description for screen readers and failed loads", "'src' sets sound; 'alt' sets background", "'src' changes screen size; 'alt' rotates image", "Both attributes specify image width", "A"],
                  ["Which tag is used to define a regular text paragraph in HTML?", "MCQ", "<p> ... </p>", "<para>", "<text>", "<block>", "A"],
                  ["Which background color attribute is used on the body tag in basic HTML (e.g., `<body bgcolor=\"lightblue\">`)?", "MCQ", "bgcolor", "background-color", "color", "tint", "A"]
                ]
              }
            ]
          }
        ]
      }
    ]
  },

  // -------------------------------------------------------------
  // STATE BOARD CLASS 8 (Samacheer Kalvi Term 1, 2, 3)
  // -------------------------------------------------------------
  {
    board: "STATE_BOARD",
    classLevel: 8,
    units: [
      {
        unitNumber: 1,
        unitName: "Unit 1 – Term 1: HTML Lists, Tables & Form Design",
        chapters: [
          {
            num: 1,
            name: "TN 8 - Structured Web Layouts, Tables & Input Forms",
            missions: [
              {
                mNum: 1,
                q: [
                  ["Which HTML tag creates a numbered ordered list (1, 2, 3...)?", "MCQ", "<ol>", "<ul>", "<dl>", "<list>", "A"],
                  ["Which HTML tag creates a bulleted unordered list?", "MCQ", "<ul>", "<ol>", "<li>", "<menu>", "A"],
                  ["Which tag is used to define individual list items inside `<ol>` or `<ul>`?", "MCQ", "<li>", "<item>", "<dt>", "<list-item>", "A"],
                  ["Which tag is used to create a data table structure in HTML?", "MCQ", "<table>", "<tab>", "<grid>", "<matrix>", "A"],
                  ["Which tag defines a table row inside an HTML table?", "MCQ", "<tr>", "<td>", "<th>", "<row>", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["The HTML tag for an ordered numbered list is <_______>.", "FILL_BLANK", "ol", "ol", "", "", "ol"],
                  ["The HTML tag for a bulleted list is <_______>.", "FILL_BLANK", "ul", "ul", "", "", "ul"],
                  ["Each item in an HTML list is created using the <_______> tag.", "FILL_BLANK", "li", "li", "", "", "li"],
                  ["A standard data cell in an HTML table is defined with <_______>.", "FILL_BLANK", "td", "td", "", "", "td"],
                  ["The tag used to create an interactive web form for user input is <_______>.", "FILL_BLANK", "form", "form", "", "", "form"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["What is the difference between `<th>` and `<td>` tags in an HTML table?", "MCQ", "`<th>` defines table header cells (bold and centered by default); `<td>` defines regular data cells (normal font, left-aligned)", "`<th>` is for images; `<td>` is for text", "`<th>` creates rows; `<td>` creates columns", "There is no difference", "A"],
                  ["Which attribute on table cells merges two or more adjacent horizontal columns into one cell?", "MCQ", "colspan", "rowspan", "colmerge", "width", "A"],
                  ["Which form input control allows a user to select only ONE choice from a mutually exclusive list of options?", "MCQ", '<input type=\"radio\">', '<input type=\"checkbox\">', '<input type=\"text\">', '<textarea>', "A"],
                  ["Which form input control allows a user to select multiple independent choices simultaneously?", "MCQ", '<input type=\"checkbox\">', '<input type=\"radio\">', '<input type=\"password\">', '<input type=\"submit\">', "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["A student writes `<table border=\"1\"><tr><th>Name</th><th>Marks</th></tr><tr><td>Akash</td><td>95</td></tr></table>`. What does this render?", "MCQ", "A bordered table with 2 columns, header row (Name, Marks), and one data row (Akash, 95)", "A numbered list of students", "A bulleted paragraph", "A blue box with errors", "A"],
                  ["Which HTML tag creates a dropdown selection menu in a web form?", "MCQ", "<select> with <option> tags", "<dropdown>", "<menu>", "<choice>", "A"],
                  ["Which form element is used to accept multi-line comments and feedback text?", "MCQ", "<textarea> ... </textarea>", '<input type=\"text\">', "<paragraph>", "<input type=\"box\">", "A"],
                  ["Which input type creates a submit button that sends form data to the server for processing?", "MCQ", '<input type=\"submit\" value=\"Send\">', '<input type=\"button\">', '<button type=\"reset\">', '<input type=\"push\">', "A"],
                  ["What does the 'action' attribute in the `<form action=\"save.php\" method=\"POST\">` tag specify?", "MCQ", "The server-side script or URL that will receive and process the submitted form data", "The font styling of form inputs", "The background animation of the form", "The time limit to fill the form", "A"]
                ]
              }
            ]
          }
        ]
      },
      {
        unitNumber: 2,
        unitName: "Unit 2 – Term 2: Python 3 Algorithmic Coding",
        chapters: [
          {
            num: 2,
            name: "TN 8 - Variables, Data Types, Operators & Simple Programs",
            missions: [
              {
                mNum: 1,
                q: [
                  ["Who created the Python programming language in 1991?", "MCQ", "Guido van Rossum", "Dennis Ritchie", "James Gosling", "Bjarne Stroustrup", "A"],
                  ["Which built-in Python function is used to output text and variable values to the console screen?", "MCQ", "print()", "echo()", "display()", "write()", "A"],
                  ["Which function in Python is used to accept input from the user via the keyboard?", "MCQ", "input()", "read()", "scan()", "get()", "A"],
                  ["Which symbol is used to write single-line explanatory comments in Python scripts?", "MCQ", "# (Hash)", "// (Double Slash)", "/* ... */", "-- (Double Dash)", "A"],
                  ["What is the data type of the value `98.5` in Python 3?", "MCQ", "float", "int", "str", "bool", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["The Python function used to display messages on screen is _______().", "FILL_BLANK", "print", "print", "", "", "print"],
                  ["The Python function used to read keyboard input is _______().", "FILL_BLANK", "input", "input", "", "", "input"],
                  ["In Python, whole integer numbers have the data type _______.", "FILL_BLANK", "int", "int", "", "", "int"],
                  ["In Python, decimal fractional numbers have the data type _______.", "FILL_BLANK", "float", "float", "", "", "float"],
                  ["To convert a string to an integer in Python, we use the _______() function.", "FILL_BLANK", "int", "int", "", "", "int"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["What is the difference between Interactive Mode (Python Shell `>>>`) and Script Mode in Python IDLE?", "MCQ", "Interactive Mode executes statements line-by-line immediately; Script Mode saves complete programs in `.py` files to execute as a whole", "Interactive mode is for games only", "Script mode cannot use variables", "They are identical", "A"],
                  ["What is the output of the Python expression `print(10 + 5 * 2)` following operator precedence (BODMAS)?", "MCQ", "20", "30", "17", "100", "A"],
                  ["What does the exponentiation operator `**` calculate in Python (e.g. `2 ** 3`)?", "MCQ", "8 (2 raised to the power 3)", "6 (2 multiplied by 3)", "5 (2 plus 3)", "23", "A"],
                  ["What does the string concatenation operator `+` do when used between two text strings: `\"Hello \" + \"World\"`?", "MCQ", "Joins them together to produce \"Hello World\"", "Calculates word count", "Throws a TypeError", "Converts to uppercase", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["A student writes:\n```python\na = int(input('Enter A: '))\nb = int(input('Enter B: '))\nprint('Sum is:', a + b)\n```\nIf user enters 15 and 25, what is the output?", "MCQ", "Sum is: 40", "Sum is: 1525", "Sum is: 15 + 25", "SyntaxError", "A"],
                  ["What happens if you omit the `int()` wrapper: `a = input()` and `b = input()` then `print(a + b)` with inputs '10' and '20'?", "MCQ", "It concatenates them as strings resulting in '1020'", "It calculates 30", "It crashes with an error", "It outputs 200", "A"],
                  ["Which variable name below is INVALID according to Python identifier naming rules?", "MCQ", "2nd_student (starts with a digit)", "student_name", "marks_1", "totalScore", "A"],
                  ["What is the Boolean data type in Python and what values can it hold?", "MCQ", "bool data type representing logical truth values: True or False", "Any number from 1 to 100", "Text strings in Tamil", "Hexadecimal color codes", "A"],
                  ["Which operator computes the integer remainder of a division in Python?", "MCQ", "% (Modulus Operator, e.g. 10 % 3 = 1)", "// (Floor Division)", "/ (Float Division)", "** (Exponent)", "A"]
                ]
              }
            ]
          }
        ]
      },
      {
        unitNumber: 3,
        unitName: "Unit 3 – Term 3: Cyber Security & Digital Safety",
        chapters: [
          {
            num: 3,
            name: "TN 8 - Malware, Safe Computing & Digital Ethics",
            missions: [
              {
                mNum: 1,
                q: [
                  ["What is the umbrella term for malicious software designed to harm, disrupt, or gain unauthorized access to computers?", "MCQ", "Malware", "Hardware", "Freeware", "Shareware", "A"],
                  ["Which type of malware attaches itself to clean files and replicates itself across systems when infected programs run?", "MCQ", "Computer Virus", "Web Browser", "Firewall", "Operating System", "A"],
                  ["What is a Trojan Horse in cyber security?", "MCQ", "Malware disguised as useful legitimate software to trick users into installing it", "A fast computer processor", "A gaming graphics card", "An encryption tool", "A"],
                  ["Which software program scans, detects, quarantines, and removes viruses and malware from storage drives?", "MCQ", "Antivirus Software", "Word Processor", "Media Player", "Compiler", "A"],
                  ["Which practice ensures you don't lose vital school work in case of hard disk failure or virus infection?", "MCQ", "Regular Data Backup to external drive / cloud", "Clearing browser history", "Closing all windows", "Changing desktop wallpaper", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["Harmful software designed to damage computers is called _______.", "FILL_BLANK", "Malware", "Malware", "", "", "Malware"],
                  ["Programs that scan and eliminate viruses are called _______ software.", "FILL_BLANK", "Antivirus", "Antivirus, Anti-virus", "", "", "Antivirus"],
                  ["Fraudulent emails sent to steal passwords and bank credentials are known as _______.", "FILL_BLANK", "Phishing", "Phishing, Phishing scams", "", "", "Phishing"],
                  ["Malware that locks user files and demands ransom money to decrypt them is _______.", "FILL_BLANK", "Ransomware", "Ransomware", "", "", "Ransomware"],
                  ["The digital trail of data left behind when using the internet is your Digital _______.", "FILL_BLANK", "Footprint", "Footprint", "", "", "Footprint"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["What makes a strong, secure password for protecting online student accounts?", "MCQ", "A mix of uppercase letters, lowercase letters, numbers, and special symbols (at least 8-12 characters long)", "Using your birth date only", "Using '123456' or 'password'", "Using your school name only", "A"],
                  ["What is Phishing and how do cyber criminals execute it?", "MCQ", "Sending deceptive emails or fake login pages mimicking trusted organizations to trick users into revealing sensitive passwords and OTPs", "Catching fish in the river using computers", "Installing RAM into motherboards", "Writing open-source Python programs", "A"],
                  ["What is Spyware in computer malware terminology?", "MCQ", "Software that secretly spies on user activities, keystrokes, and browsing habits and transmits them to third parties without consent", "Software used to design 3D animations", "A program to calibrate monitors", "A tool to defragment disks", "A"],
                  ["What is Cyberbullying and how should students respond to it?", "MCQ", "Harassing, threatening, or mocking someone using digital platforms; report and block the bully immediately and inform parents/teachers", "Bullying back with harsher comments", "Sharing private messages publicly", "Ignoring safety rules", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["A popup message appears claiming 'Your computer is infected with 50 viruses! Click here immediately to clean!'. What is this?", "MCQ", "Rogue security scareware / phishing ad designed to trick you into downloading malware; close the tab immediately", "An official Windows alert", "A free system upgrade", "A hardware test", "A"],
                  ["Why should you never connect unknown found USB pen drives into your school or home computer?", "MCQ", "They may contain autorun malware, keyloggers, or hardware-damaging circuitry (BadUSB)", "Because pen drives only work on one computer", "Because they erase the monitor screen", "Because they use too much internet", "A"],
                  ["What is Two-Factor Authentication (2FA) and why is it recommended for email and social accounts?", "MCQ", "An extra layer of security requiring both a password and a dynamic verification OTP code sent to your phone before login", "Typing the password twice on screen", "Having two separate computers", "Logging in with two different names", "A"],
                  ["What is Intellectual Property (IP) and Plagiarism in digital ethics?", "MCQ", "Plagiarism is copying and submitting someone else's digital work, code, or ideas as your own without proper credit; respecting copyright is essential", "Downloading open-source Linux", "Writing your own original poem", "Sharing free public domain photos", "A"],
                  ["What is the purpose of software updates and security patches released regularly for operating systems?", "MCQ", "They fix newly discovered security vulnerabilities and bugs to prevent cyber hackers from exploiting the system", "They make computer icons smaller", "They delete all user files", "They increase electricity consumption", "A"]
                ]
              }
            ]
          }
        ]
      }
    ]
  },

  // -------------------------------------------------------------
  // STATE BOARD CLASS 9 (4 Units Official Curriculum)
  // -------------------------------------------------------------
  {
    board: "STATE_BOARD",
    classLevel: 9,
    units: [
      {
        unitNumber: 1,
        unitName: "Unit 1 – Computer Systems & BOSS Linux Administration",
        chapters: [
          {
            num: 1,
            name: "TN 9 - Operating System Architecture & Open Source Software",
            missions: [
              {
                mNum: 1,
                q: [
                  ["What is the core central component of an operating system managing CPU, memory, and hardware communication?", "MCQ", "Kernel", "Shell", "GUI", "Compiler", "A"],
                  ["Which free and open-source operating system distribution is developed by CDAC for educational institutions across India?", "MCQ", "BOSS Linux (Bharat Operating System Solutions)", "MS-DOS", "macOS", "Windows XP", "A"],
                  ["In Linux file system hierarchy, what is the top-level root directory represented as?", "MCQ", "/ (Forward Slash)", "C:\\", "root:\\", "~", "A"],
                  ["Which Linux terminal command is used to list all files and subdirectories in the current working directory?", "MCQ", "ls", "dir", "show", "list", "A"],
                  ["Which command changes the current working directory in the Linux terminal shell?", "MCQ", "cd", "pwd", "mkdir", "mv", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["The core component of an Operating System is the _______.", "FILL_BLANK", "Kernel", "Kernel", "", "", "Kernel"],
                  ["The command-line interpreter interface in Linux is called the _______.", "FILL_BLANK", "Shell", "Shell, Terminal", "", "", "Shell"],
                  ["In Linux, the command to print the working directory path is _______.", "FILL_BLANK", "pwd", "pwd", "", "", "pwd"],
                  ["The command used to create a new directory in Linux is _______.", "FILL_BLANK", "mkdir", "mkdir", "", "", "mkdir"],
                  ["Free and Open Source Software is commonly abbreviated as _______.", "FILL_BLANK", "FOSS", "FOSS", "", "", "FOSS"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["What is the fundamental difference between Proprietary Software and Free & Open Source Software (FOSS)?", "MCQ", "Proprietary software has closed source code and restrictive licenses; FOSS provides source code freely for modification and sharing", "Proprietary software is free", "FOSS cannot run on computers", "Both have identical licenses", "A"],
                  ["Which Linux command displays the content of a text file directly in the terminal?", "MCQ", "cat (concatenate)", "echo", "touch", "rm", "A"],
                  ["What is the function of the `sudo` command prefix in Linux terminal administration?", "MCQ", "SuperUser DO: executes administrative commands with root privileges", "Shuts down the computer", "Deletes user accounts", "Shows disk memory", "A"],
                  ["In Linux file permissions `rwxr-xr--`, what do the three permission groups represent in order?", "MCQ", "Owner permissions, Group permissions, and Others permissions", "Read, Write, Execute for everyone", "Admins, Guests, Network", "Public, Private, Secret", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["A Linux administrator wants to copy file `notes.txt` to `/home/student/docs/`. Which command executes this?", "MCQ", "cp notes.txt /home/student/docs/", "mv notes.txt /home/student/docs/", "rm notes.txt", "ls notes.txt", "A"],
                  ["What does the `grep` command do in Linux command line?", "MCQ", "Searches for matching text patterns or regular expressions inside files", "Compresses image files", "Installs graphics drivers", "Formates hard disks", "A"],
                  ["What is the role of Device Drivers in operating systems?", "MCQ", "Specialized system software allowing the OS kernel to communicate with specific hardware peripherals (e.g. printers, graphics cards)", "Chauffeurs driving computers", "Cooling fans inside CPU", "Battery management chips", "A"],
                  ["What is Multitasking vs Multiprocessing in modern Operating Systems?", "MCQ", "Multitasking allows executing multiple applications concurrently by CPU time-sharing; Multiprocessing utilizes two or more physical CPU cores simultaneously", "Multitasking is for printers only", "Multiprocessing uses single CPU", "They are obsolete terms", "A"],
                  ["Which command in Linux removes (deletes) a file permanently?", "MCQ", "rm filename", "del filename", "erase filename", "kill filename", "A"]
                ]
              }
            ]
          }
        ]
      },
      {
        unitNumber: 2,
        unitName: "Unit 2 – Algorithmic Problem Solving & Flowcharts",
        chapters: [
          {
            num: 2,
            name: "TN 9 - Logic Design, Flowchart Symbols & Pseudocode",
            missions: [
              {
                mNum: 1,
                q: [
                  ["What is a step-by-step finite sequence of logical instructions written in plain language to solve a specific problem called?", "MCQ", "Algorithm", "Flowchart", "Program", "Compiler", "A"],
                  ["A graphical diagrammatic representation of an algorithm using standard geometric symbols is called a _______.", "MCQ", "Flowchart", "Blueprint", "Wireframe", "Data Map", "A"],
                  ["In standard flowchart conventions, which geometric symbol represents Start / Stop (Terminal)?", "MCQ", "Oval / Rounded Rectangle", "Rectangle", "Parallelogram", "Diamond", "A"],
                  ["Which flowchart symbol represents Input / Output operations (e.g., Read A, Print B)?", "MCQ", "Parallelogram", "Rectangle", "Diamond", "Circle", "A"],
                  ["Which flowchart symbol represents processing computations (e.g., `Sum = A + B`)?", "MCQ", "Rectangle", "Diamond", "Oval", "Parallelogram", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["A step-by-step procedure to solve a problem is an _______.", "FILL_BLANK", "Algorithm", "Algorithm", "", "", "Algorithm"],
                  ["The graphical representation of an algorithm is a _______.", "FILL_BLANK", "Flowchart", "Flowchart", "", "", "Flowchart"],
                  ["In a flowchart, the Start and Stop symbol is an _______.", "FILL_BLANK", "Oval", "Oval, Rounded Rectangle", "", "", "Oval"],
                  ["The flowchart symbol used for decision making is a _______.", "FILL_BLANK", "Diamond", "Diamond, Rhombus", "", "", "Diamond"],
                  ["Processing calculation steps in a flowchart are drawn inside a _______.", "FILL_BLANK", "Rectangle", "Rectangle", "", "", "Rectangle"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["Which flowchart symbol is used for conditional branching and decision making (with True/False exit branches)?", "MCQ", "Diamond (Rhombus)", "Circle", "Rectangle", "Parallelogram", "A"],
                  ["What is the purpose of small circular Connector symbols in complex flowcharts?", "MCQ", "Connects flowchart segments spanning across different sections or pages without crossing flowlines", "Shows mathematical addition", "Indicates sound output", "Terminates the program", "A"],
                  ["What are the three fundamental algorithmic control structures in computer science?", "MCQ", "Sequence, Selection (Branching), and Iteration (Looping)", "Input, Output, Storage", "Hardware, Software, Firmware", "Addition, Subtraction, Multiplication", "A"],
                  ["What is Pseudocode in software engineering?", "MCQ", "An informal high-level description of an algorithm combining natural language and programming syntax structures", "Binary machine code", "An encrypted computer virus", "An assembly language dialect", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["Which algorithmic control structure executes instructions sequentially one after another in linear order?", "MCQ", "Sequential Control Structure", "Selection Structure", "Looping Structure", "Recursive Structure", "A"],
                  ["In an algorithm to find the largest of two numbers A and B, which logical step determines the result?", "MCQ", "If A > B then Print 'A is larger' Else Print 'B is larger'", "Compute Sum = A + B", "Multiply A and B", "Read A only", "A"],
                  ["What is an Infinite Loop error in algorithm design and how does it occur?", "MCQ", "A loop whose termination condition is never satisfied, causing it to repeat indefinitely", "A loop that finishes in 0 seconds", "A syntax error detected by compiler", "A calculation with negative numbers", "A"],
                  ["Why is designing an algorithm and flowchart essential BEFORE writing code in Python or C++?", "MCQ", "It clarifies logical flow, identifies errors early, and reduces debugging time during actual implementation", "It automatically generates binary code", "It speeds up computer RAM", "It is required by the computer monitor", "A"],
                  ["What does DRY principle stand for in algorithmic logic design?", "MCQ", "Don't Repeat Yourself (reusing logic and avoiding redundant code blocks)", "Data Retrieval Yield", "Digital Read Only", "Dynamic Routing Yield", "A"]
                ]
              }
            ]
          }
        ]
      },
      {
        unitNumber: 3,
        unitName: "Unit 3 – Python 3 Programming & Control Structures",
        chapters: [
          {
            num: 3,
            name: "TN 9 - Decision Making, Iterations & Data Collections",
            missions: [
              {
                mNum: 1,
                q: [
                  ["Which Python conditional statement checks multi-way conditions sequentially?", "MCQ", "if ... elif ... else", "switch ... case", "choose ... when", "check ... option", "A"],
                  ["What is the output of `range(1, 6)` when converted to a list in Python?", "MCQ", "[1, 2, 3, 4, 5]", "[1, 2, 3, 4, 5, 6]", "[0, 1, 2, 3, 4, 5]", "[2, 3, 4, 5, 6]", "A"],
                  ["Which Python loop is typically used when the exact number of iterations is known beforehand?", "MCQ", "for loop", "while loop", "do-while loop", "repeat loop", "A"],
                  ["Which Python loop repeats a block of statements as long as a Boolean condition remains True?", "MCQ", "while loop", "for loop", "if statement", "def statement", "A"],
                  ["How is code block structuring and nesting defined in Python (instead of curly braces `{}`)?", "MCQ", "Indentation (whitespace / 4 spaces)", "Semicolons (;)", "Parentheses ()", "Square brackets []", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["In Python, multi-condition branching uses if ... _______ ... else.", "FILL_BLANK", "elif", "elif", "", "", "elif"],
                  ["The function generating arithmetic progressions of numbers is _______().", "FILL_BLANK", "range", "range", "", "", "range"],
                  ["Code blocks in Python are defined by consistent _______.", "FILL_BLANK", "Indentation", "Indentation, whitespace", "", "", "Indentation"],
                  ["To immediately break out of a loop in Python, use the _______ statement.", "FILL_BLANK", "break", "break", "", "", "break"],
                  ["To skip the current loop iteration and continue to the next cycle, use _______.", "FILL_BLANK", "continue", "continue", "", "", "continue"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["Consider Python code:\n```python\nfor i in range(1, 10, 2):\n    print(i, end=' ')\n```\nWhat is the output?", "MCQ", "1 3 5 7 9", "1 2 3 4 5 6 7 8 9", "2 4 6 8 10", "1 10 2", "A"],
                  ["What will be the output of:\n```python\nn = 5\nfact = 1\nfor i in range(1, n + 1):\n    fact *= i\nprint(fact)\n```", "MCQ", "120 (5 factorial)", "24", "15", "5", "A"],
                  ["What is the result of Python expression `\"Apple\" in [\"Apple\", \"Banana\", \"Cherry\"]`?", "MCQ", "True", "False", "TypeError", "None", "A"],
                  ["How do you create an empty list in Python?", "MCQ", "`my_list = []` or `my_list = list()`", "`my_list = {}`", "`my_list = ()`", "`my_list = set()`", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["What is the output of the following Python code snippet?\n```python\ncount = 0\nwhile count < 3:\n    count += 1\nprint(count)\n```", "MCQ", "3", "2", "4", "0", "A"],
                  ["What is list indexing in Python? If `scores = [80, 90, 100]`, what is `scores[-1]`?", "MCQ", "100 (Negative index -1 accesses the last element)", "80", "90", "IndexError", "A"],
                  ["What does the `.pop()` method do on a Python list?", "MCQ", "Removes and returns the last element (or element at specified index) from the list", "Adds a new element", "Sorts the list alphabetically", "Reverses the list", "A"],
                  ["What happens if an unexpected user input triggers a division by zero error in Python?", "MCQ", "Python raises a `ZeroDivisionError` exception which can be caught using `try-except`", "The computer restarts", "The answer becomes infinity automatically", "The program ignores the line", "A"],
                  ["What is the output of `[x**2 for x in range(4)]` in Python (List Comprehension)?", "MCQ", "[0, 1, 4, 9]", "[1, 4, 9, 16]", "[0, 2, 4, 6]", "[0, 1, 2, 3]", "A"]
                ]
              }
            ]
          }
        ]
      },
      {
        unitNumber: 4,
        unitName: "Unit 4 – Database Concepts & OpenOffice Base / MySQL",
        chapters: [
          {
            num: 4,
            name: "TN 9 - Relational Databases, Tables & Structured Queries",
            missions: [
              {
                mNum: 1,
                q: [
                  ["What is an organized digital collection of related data stored and accessed electronically called?", "MCQ", "Database", "Spreadsheet", "Word Document", "Slide Show", "A"],
                  ["What does DBMS stand for in computer science?", "MCQ", "Database Management System", "Digital Binary Management System", "Data Block Memory System", "Direct Business Model System", "A"],
                  ["In a relational database table, a single horizontal row containing complete information for an entity is a _______.", "MCQ", "Record (Tuple)", "Field (Attribute)", "Key", "Domain", "A"],
                  ["A vertical column in a database table representing a specific property or data item is a _______.", "MCQ", "Field (Attribute)", "Record (Tuple)", "File", "Table", "A"],
                  ["Which field in a table uniquely identifies every record without duplicates?", "MCQ", "Primary Key", "Foreign Key", "Composite Key", "Alternate Key", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["DBMS stands for Database Management _______.", "FILL_BLANK", "System", "System", "", "", "System"],
                  ["A horizontal row in a database table is called a _______.", "FILL_BLANK", "Record", "Record, Tuple", "", "", "Record"],
                  ["A vertical column in a database table is called a _______.", "FILL_BLANK", "Field", "Field, Attribute", "", "", "Field"],
                  ["The unique identifying column in a database table is the _______ Key.", "FILL_BLANK", "Primary", "Primary, Primary Key", "", "", "Primary"],
                  ["The standard query language used across relational databases is _______.", "FILL_BLANK", "SQL", "SQL", "", "", "SQL"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["What is the major advantage of using a Relational Database over maintaining manual paper files or simple flat files?", "MCQ", "Reduces data redundancy (duplication), ensures data integrity, provides high security, and allows fast searching across millions of records", "Paper files are faster", "Databases require no electricity", "Databases use no storage space", "A"],
                  ["Which SQL command creates a new table structure with column definitions and data types?", "MCQ", "CREATE TABLE", "MAKE TABLE", "NEW TABLE", "BUILD TABLE", "A"],
                  ["Which SQL command adds a new record row into an existing table?", "MCQ", "INSERT INTO", "ADD ROW", "APPEND TO", "PUT INTO", "A"],
                  ["What does the SQL command `SELECT * FROM Students;` perform?", "MCQ", "Retrieves and displays all columns and all records from the Students table", "Deletes the Students table", "Sorts the Students table", "Renames the table", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["Given query: `SELECT Name, Marks FROM Students WHERE Marks >= 75 ORDER BY Marks DESC;`, what does this return?", "MCQ", "Names and marks of students scoring 75 or above, ordered from highest marks to lowest", "All students scoring under 75", "Students whose names begin with 75", "Calculates total marks of all students", "A"],
                  ["What is a Foreign Key and what relationship does it establish between two tables?", "MCQ", "A field in a child table referring to the Primary Key of a parent table, establishing relational linkage and referential integrity", "A password to open foreign databases", "A key that translates Tamil to English", "A temporary backup index", "A"],
                  ["Which SQL command modifies existing column values in specific table rows?", "MCQ", "UPDATE table_name SET col = val WHERE condition;", "MODIFY ROW", "CHANGE DATA", "ALTER ROW", "A"],
                  ["What is the difference between `DROP TABLE` and `DELETE FROM table;` in SQL?", "MCQ", "`DROP TABLE` removes both table structure and data permanently; `DELETE FROM` deletes rows while keeping table schema intact", "Both commands do identical actions", "`DROP` is for single cells only", "`DELETE` deletes the database server", "A"],
                  ["Which open-source database management tool is part of the LibreOffice suite?", "MCQ", "LibreOffice Base", "LibreOffice Calc", "LibreOffice Impress", "LibreOffice Draw", "A"]
                ]
              }
            ]
          }
        ]
      }
    ]
  },

  // -------------------------------------------------------------
  // STATE BOARD CLASS 10 (5 Units Official Curriculum)
  // -------------------------------------------------------------
  {
    board: "STATE_BOARD",
    classLevel: 10,
    units: [
      {
        unitNumber: 1,
        unitName: "Unit 1 – Computer Networks, Topologies & Cyber Laws",
        chapters: [
          {
            num: 1,
            name: "TN 10 - Networking Infrastructure, Protocols & IT Act",
            missions: [
              {
                mNum: 1,
                q: [
                  ["Which network type spans a localized geographical area such as a school computer lab or single building?", "MCQ", "LAN (Local Area Network)", "WAN (Wide Area Network)", "MAN (Metropolitan Area Network)", "PAN (Personal Area Network)", "A"],
                  ["Which global network type connects computers across countries and continents worldwide?", "MCQ", "WAN (Wide Area Network - e.g. The Internet)", "LAN", "PAN", "CAN", "A"],
                  ["In which physical network topology are all client nodes connected to a central switch/hub device?", "MCQ", "Star Topology", "Bus Topology", "Ring Topology", "Mesh Topology", "A"],
                  ["Which transmission medium uses thin strands of glass to transmit data at the speed of light pulses with minimum interference?", "MCQ", "Optical Fiber Cable (OFC)", "Twisted Pair Copper Cable", "Coaxial Cable", "Infrared Beam", "A"],
                  ["What is the fundamental suite of communication protocols governing Internet transmission?", "MCQ", "TCP/IP (Transmission Control Protocol / Internet Protocol)", "HTTP / HTML", "FTP / SMTP", "DNS / DHCP", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["A localized network within a single school building is a _______.", "FILL_BLANK", "LAN", "LAN, Local Area Network", "", "", "LAN"],
                  ["The largest worldwide computer network is the _______.", "FILL_BLANK", "Internet", "Internet, WAN", "", "", "Internet"],
                  ["Network topology connecting all nodes to a central hub is _______ topology.", "FILL_BLANK", "Star", "Star, Star topology", "", "", "Star"],
                  ["Cables using light pulses through glass strands are Optical _______ cables.", "FILL_BLANK", "Fiber", "Fiber, Fibre", "", "", "Fiber"],
                  ["The unique numerical identifier assigned to every device on a TCP/IP network is its _______ address.", "FILL_BLANK", "IP", "IP, IP address", "", "", "IP"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["What is the main advantage of Star network topology over Bus topology?", "MCQ", "If one cable/node fails in Star topology, other connected computers continue working unaffected", "Star topology requires no cables", "Bus topology is 100x faster", "Star topology uses no electricity", "A"],
                  ["What is the difference between a Network Hub and a Network Switch?", "MCQ", "Hub broadcasts incoming data to all connected ports blindly; Switch inspects MAC addresses and forwards data packets only to intended destination port", "Hub is wireless; Switch uses fiber", "Switch operates without power", "They are identical devices", "A"],
                  ["What does DNS (Domain Name System) do on the Internet?", "MCQ", "Translates human-friendly domain names (e.g. tngov.in) to numerical machine IP addresses (e.g. 104.21.56.89)", "Encrypts Wi-Fi passwords", "Designs website graphics", "Manages printer queues", "A"],
                  ["Which wireless standard enables high-speed local area wireless networking in homes and schools?", "MCQ", "Wi-Fi (IEEE 802.11 standards)", "Bluetooth only", "Infrared", "NFC only", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["Which Indian legislation provides legal recognition for electronic transactions, e-commerce, digital signatures, and cybercrime prevention?", "MCQ", "Information Technology (IT) Act, 2000 (and amendments)", "Indian Penal Code 1860 only", "Consumer Protection Act", "Companies Act", "A"],
                  ["Under Section 66 of the IT Act 2000, what is the penalty for unauthorized computer hacking and data tampering?", "MCQ", "Imprisonment up to 3 years and/or fine up to ₹5 lakh", "A verbal warning only", "No punishment", "Revocation of driver license only", "A"],
                  ["What is a Firewall and how does it protect a school network infrastructure?", "MCQ", "A hardware/software security barrier that monitors and filters incoming and outgoing network traffic based on predefined security rules", "A fire extinguisher in the server room", "A high-speed graphics processor", "A tool to cool down server CPUs", "A"],
                  ["What is Phishing and how do modern cyber laws in India categorize it?", "MCQ", "A punishable cyber offense involving fraudulent creation of deceptive electronic communication to deceive victims and steal credentials", "A legal way to test passwords", "A recreational online hobby", "A standard banking service", "A"],
                  ["What is 5G Mobile Technology compared to 4G LTE?", "MCQ", "Fifth generation cellular network offering multi-Gbps peak data speeds, ultra-low latency (<1ms), and massive IoT device connectivity", "5G removes the need for antennas", "5G only works for phone calls", "4G is faster than 5G", "A"]
                ]
              }
            ]
          }
        ]
      },
      {
        unitNumber: 2,
        unitName: "Unit 2 – HTML5, CSS Styling & Web Publishing",
        chapters: [
          {
            num: 2,
            name: "TN 10 - Web Standards, Responsive CSS & Box Model",
            missions: [
              {
                mNum: 1,
                q: [
                  ["Which HTML5 semantic element is used to define the introductory header section of a webpage?", "MCQ", "<header>", "<head>", "<top>", "<heading>", "A"],
                  ["Which HTML5 element represents self-contained independent content such as a blog post or news story?", "MCQ", "<article>", "<section>", "<div>", "<aside>", "A"],
                  ["What does CSS stand for in web page design?", "MCQ", "Cascading Style Sheets", "Computer Style Syntax", "Creative Styling System", "Colorful Standard Sheets", "A"],
                  ["Which CSS method links a separate `.css` file to an HTML document inside the `<head>` tag?", "MCQ", '<link rel=\"stylesheet\" href=\"styles.css\">', '<style src=\"styles.css\">', '<css link=\"styles.css\">', '<import file=\"styles.css\">', "A"],
                  ["In CSS syntax `h1 { color: navy; font-size: 24px; }`, what is `h1` called?", "MCQ", "Selector", "Property", "Value", "Declaration", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["CSS stands for Cascading Style _______.", "FILL_BLANK", "Sheets", "Sheets", "", "", "Sheets"],
                  ["The HTML5 tag for main site navigation links is <_______>.", "FILL_BLANK", "nav", "nav", "", "", "nav"],
                  ["The HTML5 tag for footer copyright information is <_______>.", "FILL_BLANK", "footer", "footer", "", "", "footer"],
                  ["The CSS property used to change the background color of an element is _______-color.", "FILL_BLANK", "background", "background", "", "", "background"],
                  ["In the CSS Box Model, the innermost layer containing text and images is the _______.", "FILL_BLANK", "Content", "Content", "", "", "Content"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["What are the three ways to apply CSS styles to an HTML document?", "MCQ", "Inline styles (style attribute), Internal stylesheets (`<style>` tag), and External stylesheets (`.css` file)", "Upper, Lower, Middle", "Text, Image, Sound", "Local, Regional, Global", "A"],
                  ["What are the four components of the CSS Box Model from center outwards?", "MCQ", "Content → Padding → Border → Margin", "Margin → Border → Padding → Content", "Content → Margin → Border → Padding", "Border → Padding → Margin → Content", "A"],
                  ["How does the CSS `padding` property differ from `margin`?", "MCQ", "`padding` creates space inside the border around content; `margin` creates transparent clearance space outside the border", "`padding` is outside; `margin` is inside", "`padding` is for fonts; `margin` is for colors", "They are identical properties", "A"],
                  ["Which CSS selector targets an element with a unique `id=\"main-nav\"`?", "MCQ", "#main-nav", ".main-nav", "main-nav", "*main-nav", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["Which CSS selector targets all elements sharing the class name `class=\"card-btn\"`?", "MCQ", ".card-btn", "#card-btn", "$card-btn", "&card-btn", "A"],
                  ["How do CSS Media Queries enable responsive mobile-friendly web design?", "MCQ", "They apply specific CSS rules conditionally based on device screen width (`@media (max-width: 600px)`)", "They translate HTML to Tamil", "They speed up website download bandwidth", "They compress database images", "A"],
                  ["Which HTML5 tag is used to embed video clips directly without third-party plugins?", "MCQ", '<video controls><source src=\"movie.mp4\" type=\"video/mp4\"></video>', '<movie src=\"movie.mp4\">', '<embed-video=\"movie.mp4\">', '<media play=\"movie.mp4\">', "A"],
                  ["What is Web Hosting and Domain Name Registration in web publishing?", "MCQ", "Domain name is your registered web address (e.g. myschool.com); Web hosting is server storage space where site files are served 24/7 to the public", "Domain is the computer monitor; Hosting is the keyboard", "Hosting is downloading files to USB", "They are both free email services", "A"],
                  ["What is the purpose of FTP (File Transfer Protocol) in web publishing?", "MCQ", "To upload website HTML, CSS, and image files from a local computer to the remote web hosting server", "To browse social media websites", "To compile Python scripts", "To format hard drives", "A"]
                ]
              }
            ]
          }
        ]
      },
      {
        unitNumber: 3,
        unitName: "Unit 3 – Python Functions, Modules & String Algorithms",
        chapters: [
          {
            num: 3,
            name: "TN 10 - Modular Programming, Built-in Modules & String Methods",
            missions: [
              {
                mNum: 1,
                q: [
                  ["Which Python keyword is used to define a reusable user-defined function?", "MCQ", "def", "function", "fn", "procedure", "A"],
                  ["What keyword is used to send a computed value back from a function to its caller?", "MCQ", "return", "send", "give", "output", "A"],
                  ["Which Python statement is used to include external built-in modules (such as `math` or `random`)?", "MCQ", "import", "include", "require", "using", "A"],
                  ["Which function in Python's `math` module computes the square root of a number?", "MCQ", "math.sqrt(x)", "math.root(x)", "math.sq(x)", "math.power(x, 0.5)", "A"],
                  ["What is the output of `\"Tamil Nadu\".upper()` in Python?", "MCQ", "\"TAMIL NADU\"", "\"tamil nadu\"", "\"Tamil Nadu\"", "\"Tamil nadu\"", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["The Python keyword used to define a function is _______.", "FILL_BLANK", "def", "def", "", "", "def"],
                  ["To return a value from a function, we use the _______ statement.", "FILL_BLANK", "return", "return", "", "", "return"],
                  ["To use math and random functions, we _______ the module.", "FILL_BLANK", "import", "import", "", "", "import"],
                  ["The string method to convert text to lowercase is ._______().", "FILL_BLANK", "lower", "lower", "", "", "lower"],
                  ["The string method that checks if a string contains only numeric digits is ._______().", "FILL_BLANK", "isdigit", "isdigit", "", "", "isdigit"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["Consider Python function:\n```python\ndef find_max(a, b):\n    if a > b:\n        return a\n    else:\n        return b\nprint(find_max(25, 40))\n```\nWhat is printed?", "MCQ", "40", "25", "None", "TypeError", "A"],
                  ["What is the difference between Local Scope and Global Scope variables in Python?", "MCQ", "Local variables are defined inside a function and accessible only within it; Global variables are defined outside and accessible throughout the module", "Local variables are faster", "Global variables cannot hold numbers", "They are identical", "A"],
                  ["What does `random.randint(1, 6)` return in Python?", "MCQ", "A pseudo-random integer between 1 and 6 (inclusive), simulating a 6-sided dice roll", "Always 1", "Always 6", "A floating number like 3.14", "A"],
                  ["What is string slicing in Python? What is the output of `text = \"ComputerQuest\"; print(text[0:4])`?", "MCQ", "\"Comp\"", "\"Comput\"", "\"Computer\"", "\"Quest\"", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["What is a recursive function in Python programming?", "MCQ", "A function that calls itself directly or indirectly to solve a problem divided into smaller subproblems with a base condition", "A function that runs forever", "A function with no arguments", "A function imported from C++", "A"],
                  ["What is the output of the following Python program?\n```python\ndef is_palindrome(s):\n    return s == s[::-1]\nprint(is_palindrome(\"madam\"))\n```", "MCQ", "True", "False", "None", "SyntaxError", "A"],
                  ["What does the `.split()` method on a string do in Python (e.g. `\"Chennai Salem Madurai\".split()`)?", "MCQ", "Splits the string by whitespace into a list of substrings: `['Chennai', 'Salem', 'Madurai']`", "Combines words into one", "Reverses word order", "Deletes all vowels", "A"],
                  ["What is the purpose of the `math.pi` and `math.factorial(n)` functions in Python's math module?", "MCQ", "`math.pi` gives the mathematical constant π (3.14159...); `math.factorial(n)` computes n!", "They generate random numbers", "They draw circles on screen", "They format text strings", "A"],
                  ["What is Default Parameter Value in a Python function (e.g., `def greet(name, msg=\"Good Morning\"):`)?", "MCQ", "A parameter value automatically used if the caller does not pass an explicit argument for it during the function call", "A mandatory parameter that cannot be changed", "A global variable only", "An encrypted parameter", "A"]
                ]
              }
            ]
          }
        ]
      },
      {
        unitNumber: 4,
        unitName: "Unit 4 – Relational Databases & Structured Query Language (MySQL)",
        chapters: [
          {
            num: 4,
            name: "TN 10 - MySQL Schema Design, CRUD Operations & Aggregate Functions",
            missions: [
              {
                mNum: 1,
                q: [
                  ["Which open-source Relational Database Management System (RDBMS) is widely used in Tamil Nadu schools and web applications?", "MCQ", "MySQL", "MS Paint", "Notepad", "VLC Media Player", "A"],
                  ["Which SQL sub-language category contains commands for defining database structure (CREATE, ALTER, DROP)?", "MCQ", "DDL (Data Definition Language)", "DML (Data Manipulation Language)", "DCL (Data Control Language)", "TCL (Transaction Control Language)", "A"],
                  ["Which SQL command modifies existing column values in a database table?", "MCQ", "UPDATE", "MODIFY", "CHANGE", "REPLACE", "A"],
                  ["Which SQL clause filters records based on specified search conditions in a SELECT query?", "MCQ", "WHERE", "HAVING", "ORDER BY", "GROUP BY", "A"],
                  ["Which SQL aggregate function computes the mathematical average of a numeric column?", "MCQ", "AVG()", "AVERAGE()", "MEAN()", "SUM_AVG()", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["DDL stands for Data _______ Language in SQL.", "FILL_BLANK", "Definition", "Definition", "", "", "Definition"],
                  ["DML stands for Data _______ Language in SQL.", "FILL_BLANK", "Manipulation", "Manipulation", "", "", "Manipulation"],
                  ["The SQL command used to remove rows from a table conditionally is _______ FROM.", "FILL_BLANK", "DELETE", "DELETE", "", "", "DELETE"],
                  ["The SQL clause used to arrange query results in ascending or descending sequence is _______ BY.", "FILL_BLANK", "ORDER", "ORDER", "", "", "ORDER"],
                  ["The SQL aggregate function returning the total count of matching rows is _______().", "FILL_BLANK", "COUNT", "COUNT", "", "", "COUNT"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["What is the difference between `CHAR(n)` and `VARCHAR(n)` data types in MySQL?", "MCQ", "`CHAR(n)` allocates fixed storage length padding with spaces; `VARCHAR(n)` allocates variable storage length matching actual string length", "`CHAR` is for numbers; `VARCHAR` is for dates", "`VARCHAR` cannot store letters", "They are 100% identical", "A"],
                  ["What does the SQL command `SELECT DISTINCT City FROM Students;` do?", "MCQ", "Retrieves all unique city names from the Students table, eliminating duplicate occurrences", "Deletes all cities except one", "Sorts cities in reverse", "Counts total students per city", "A"],
                  ["Which SQL command adds a new column `Email VARCHAR(50)` to an existing `Students` table?", "MCQ", "ALTER TABLE Students ADD Email VARCHAR(50);", "UPDATE TABLE Students ADD Email;", "CREATE COLUMN Email IN Students;", "INSERT INTO Students (Email);", "A"],
                  ["How does the SQL `LIKE` operator work with wildcards `%` and `_`?", "MCQ", "`%` matches zero or more characters; `_` matches exactly one single character (e.g. `WHERE Name LIKE 'A%'`)", "`%` divides numbers; `_` creates spaces", "`%` is for integers; `_` is for strings", "Both symbols do identical matching", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["A school table `Marks (RollNo INT, Sub VARCHAR(20), Score INT)` needs total marks scored per subject. Which SQL query accomplishes this?", "MCQ", "SELECT Sub, SUM(Score) FROM Marks GROUP BY Sub;", "SELECT Sub, Score FROM Marks ORDER BY Sub;", "SELECT ALL Marks WHERE Sub = Score;", "SELECT COUNT(Score) FROM Marks;", "A"],
                  ["What is the purpose of the `HAVING` clause in SQL?", "MCQ", "Filters grouped records created by `GROUP BY` using aggregate conditions (e.g. `HAVING AVG(Score) >= 60`)", "Replaces the WHERE clause everywhere", "Sorts table columns alphabetically", "Creates a new database user", "A"],
                  ["What is database normalization in relational design?", "MCQ", "The systematic process of organizing tables to eliminate data redundancy and prevent insert/update/delete anomalies", "Converting database to uppercase", "Deleting old student records", "Backing up database to DVD", "A"],
                  ["What does the `PRIMARY KEY` constraint enforce on a table column in MySQL?", "MCQ", "Enforces that values must be unique across all rows and cannot contain `NULL` (empty) values", "Encrypts the column with passwords", "Converts values to Roman numerals", "Allows duplicate values", "A"],
                  ["Which command displays the schema structure (column names, types, keys) of a table in MySQL?", "MCQ", "DESCRIBE table_name; (or DESC table_name;)", "SHOW TABLE DATA;", "SELECT STRUCTURE;", "VIEW SCHEMA;", "A"]
                ]
              }
            ]
          }
        ]
      },
      {
        unitNumber: 5,
        unitName: "Unit 5 – Tamil Computing, Unicode & e-Governance Services",
        chapters: [
          {
            num: 5,
            name: "TN 10 - Unicode Standards, Tamil Keyboards & e-Governance Portals",
            missions: [
              {
                mNum: 1,
                q: [
                  ["What is the universal character encoding standard that assigns a unique number to every character across all human languages, including Tamil?", "MCQ", "Unicode Standard (UTF-8)", "ASCII Standard", "BCD Code", "Morse Code", "A"],
                  ["Which Tamil keyboard layout developed by the Tamil Nadu Government maps Tamil phonetic sounds directly to English keys (e.g., typing 'amma' produces 'அம்மா')?", "MCQ", "Tamil Phonetic Layout (e.g. Murasu Anjal / NHM Writer)", "Tamil Typewriter Layout", "Tamil Inscript Layout", "English QWERTY Layout", "A"],
                  ["Which official portal provided by the Tamil Nadu Government allows citizens to access government certificates and services online?", "MCQ", "TNeGA e-Sevai Portal (tnesevai.tn.gov.in)", "Wikipedia", "Google Drive", "YouTube TN", "A"],
                  ["Which search engine tool or Tamil optical character recognition (OCR) helps index and search digital Tamil literature?", "MCQ", "Tamil Search Engines & Tamil OCR Tools", "Paint", "Notepad", "Calculator", "A"],
                  ["What is the digital educational initiative by the Tamil Nadu School Education Department providing e-textbooks, video lessons, and digital resources?", "MCQ", "TN Kalvi Tholaikkatchi & EMIS Portal", "TNSOFT", "TN-GAME", "TN-MUSIC", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["The universal character encoding standard supporting Tamil is _______.", "FILL_BLANK", "Unicode", "Unicode, UTF-8", "", "", "Unicode"],
                  ["Tamil typing tool mapping English sounds to Tamil letters is Tamil _______ typing.", "FILL_BLANK", "Phonetic", "Phonetic, Transliteration", "", "", "Phonetic"],
                  ["Tamil Nadu e-Governance Agency is abbreviated as _______.", "FILL_BLANK", "TNeGA", "TNeGA", "", "", "TNeGA"],
                  ["The student information management system used across Tamil Nadu schools is _______.", "FILL_BLANK", "EMIS", "EMIS, TN-EMIS", "", "", "EMIS"],
                  ["Tamil Virtual Academy preserving Tamil digital heritage is _______.", "FILL_BLANK", "TVA", "TVA, Tamil Virtual Academy", "", "", "TVA"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["What was the limitation of older proprietary Tamil non-Unicode fonts (like Vanavil, Bamini) compared to modern Unicode Tamil?", "MCQ", "Non-Unicode fonts required specific font installation to read, could not be searched by Google, and broke across different devices; Unicode works seamlessly worldwide", "Non-Unicode fonts were colorful", "Unicode works only on paper", "There was no difference", "A"],
                  ["What services does the Tamil Nadu e-Sevai portal provide to students and families?", "MCQ", "Online application and download of Community Certificates, Income Certificates, Nativity Certificates, and First Graduate Certificates", "Free computer hardware repair", "Online video gaming tournaments", "Downloading movie trailers", "A"],
                  ["What is the InScript Tamil Keyboard layout standard recognized by the Government of India?", "MCQ", "A standardized keyboard layout for Indian scripts where vowels are arranged on the left side and consonants on the right side of the keyboard", "A layout with no keys", "A layout only for typing numbers", "A layout used only on phones", "A"],
                  ["What is Tamil NLP (Natural Language Processing) and why is it important?", "MCQ", "Computer technologies enabling automated Tamil spell-checking, grammar analysis, machine translation, voice recognition, and text-to-speech synthesis", "Translating computer code into binary", "Formatting tables in Calc", "Building computer motherboards", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["A citizen needs an official Community Certificate for college admission in Tamil Nadu. How does e-Governance streamline this process?", "MCQ", "Citizen applies online via e-Sevai / TNeGA portal; Village Administrative Officer (VAO) and Tahsildar verify digitally, and an authentic QR-coded certificate is issued online without physical office queues", "Citizen must travel to Delhi", "Citizen writes a letter by post", "Citizen posts on social media", "A"],
                  ["What is the Tamil Virtual Academy (TVA) established by the Government of Tamil Nadu?", "MCQ", "An autonomous institution dedicated to teaching Tamil language worldwide online and digitizing rare Tamil manuscripts, encyclopedias, and literature into digital libraries", "A private video game company", "A hardware manufacturing factory", "A television channel", "A"],
                  ["How does Open Source Tamil Computing benefit Tamil Nadu schools and government departments?", "MCQ", "Provides localized Tamil user interfaces in BOSS Linux, LibreOffice, and typing tools at zero licensing cost, promoting digital literacy in mother tongue", "Increases computer hardware prices", "Prevents internet usage", "Restricts software to only one school", "A"],
                  ["What is Digital Signature (e-Sign) in government online service verification?", "MCQ", "A cryptographic mathematical mechanism that validates the authenticity, integrity, and non-repudiation of digital government documents and certificates", "A scanned photo of a handwritten signature only", "A typed name in bold font", "An email subject line", "A"],
                  ["What is the purpose of Mobile Seva and UMANG / TN e-Governance mobile apps?", "MCQ", "Delivering accessible government citizen services directly through smartphones anywhere, anytime", "Streaming music albums", "Playing mobile games", "Selling computer hardware", "A"]
                ]
              }
            ]
          }
        ]
      }
    ]
  }
];
