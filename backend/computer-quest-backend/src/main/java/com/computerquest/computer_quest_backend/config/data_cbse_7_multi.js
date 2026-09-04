// =========================================================================
// CBSE CLASSES 7 & 8 (MULTI-UNIT OFFICIAL CURRICULA)
// NCERT / CBSE Guidelines - Excel Advanced, HTML5, CSS, Python 3, RDBMS, AI
// =========================================================================

module.exports = [
  // -------------------------------------------------------------
  // CBSE CLASS 7 (Advanced Excel, Web Fundamentals, Python 3)
  // -------------------------------------------------------------
  {
    board: "CBSE",
    classLevel: 7,
    units: [
      {
        unitNumber: 1,
        unitName: "Unit 1 – Advanced Data Management & Networks",
        chapters: [
          {
            num: 1,
            name: "CBSE 7 - Advanced Excel Functions & Data Sorting/Filtering",
            missions: [
              {
                mNum: 1,
                q: [
                  ["Which Excel logical function returns one value if a condition is true and another if false?", "MCQ", "=IF()", "=AND()", "=OR()", "=NOT()", "A"],
                  ["Which function in Excel looks up a value in the leftmost column of a table and returns a corresponding value from another column?", "MCQ", "=VLOOKUP()", "=HLOOKUP()", "=INDEX()", "=MATCH()", "A"],
                  ["Reorganizing records alphabetically (A to Z) or numerically (Lowest to Highest) in Excel is called _______.", "MCQ", "Sorting", "Filtering", "Merging", "Conditional Formatting", "A"],
                  ["Displaying only the rows in a dataset that meet specific criteria while temporarily hiding the rest is called _______.", "MCQ", "Filtering (AutoFilter)", "Sorting", "Deleting", "Wrapping", "A"],
                  ["Which Excel feature highlights cells with specific background colors based on rules (e.g., marks < 40 in red)?", "MCQ", "Conditional Formatting", "Format Painter", "AutoSum", "Cell Styles", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["The formula `=IF(A1>=40, \"Pass\", \"Fail\")` returns _______ if A1 is 75.", "FILL_BLANK", "Pass", "Pass", "", "", "Pass"],
                  ["Arranging data from Z to A or Largest to Smallest is _______ order.", "FILL_BLANK", "Descending", "Descending", "", "", "Descending"],
                  ["The function that calculates the sum of cells matching a specific condition is =_______().", "FILL_BLANK", "SUMIF", "SUMIF", "", "", "SUMIF"],
                  ["The function that counts cells matching a specific condition is =_______().", "FILL_BLANK", "COUNTIF", "COUNTIF", "", "", "COUNTIF"],
                  ["In `=VLOOKUP(lookup_value, table_array, col_index, FALSE)`, FALSE indicates an _______ match.", "FILL_BLANK", "Exact", "Exact", "", "", "Exact"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["What is the output of `=IF(10 > 20, \"True\", \"False\")`?", "MCQ", "\"False\"", "\"True\"", "10", "20", "A"],
                  ["Which shortcut key toggles the AutoFilter drop-down arrows on an Excel table?", "MCQ", "Ctrl + Shift + L", "Ctrl + F", "Ctrl + Alt + V", "Ctrl + Shift + F", "A"],
                  ["What formula counts how many students in column C (grades) scored an \"A\"?", "MCQ", "=COUNTIF(C2:C50, \"A\")", "=SUM(C2:C50, \"A\")", "=COUNT(C2:C50)", "=IF(C2:C50=\"A\")", "A"],
                  ["What does the `#N/A` error in an Excel VLOOKUP formula mean?", "MCQ", "The lookup value was not found in the target table range", "The formula has a spelling error", "Division by zero", "The cell is too small", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["A principal wants to calculate total fees collected only from Class 7 students in a 500-student spreadsheet. What function is best?", "MCQ", "=SUMIF(Class_Range, \"Class 7\", Fee_Range)", "=SUM(Fee_Range)", "=AVERAGE(Fee_Range)", "=COUNT(Class_Range)", "A"],
                  ["Why is Conditional Formatting helpful for school teachers grading exam sheets?", "MCQ", "It visually highlights failing grades in red and top distinctions in green automatically", "It prints 100 extra copies", "It deletes failed students", "It shuts down the PC", "A"],
                  ["You want to freeze row 1 (the table header) so it stays visible while scrolling down 1000 rows. What tool do you click?", "MCQ", "Freeze Panes -> Freeze Top Row", "Split Table", "Delete Row 1", "Format Painter", "A"],
                  ["What is the result of `=OR(5 > 10, 8 < 12)` in Excel?", "MCQ", "TRUE (since at least one condition `8 < 12` is true)", "FALSE", "5", "8", "A"],
                  ["What is a Data Validation rule used for in Excel?", "MCQ", "Restricting what type of data or values users can enter into a cell (e.g. age between 5 and 18 only)", "Encrypting the hard drive", "Changing screen brightness", "Translating into French", "A"]
                ]
              }
            ]
          },
          {
            num: 2,
            name: "CBSE 7 - Computer Network Basics & Topologies",
            missions: [
              {
                mNum: 1,
                q: [
                  ["A group of two or more computers connected together to share resources, data, and hardware is a _______.", "MCQ", "Computer Network", "Operating System", "Single PC", "Microprocessor", "A"],
                  ["Which type of network spans a small localized area like a school computer lab, office room, or home?", "MCQ", "Local Area Network (LAN)", "Wide Area Network (WAN)", "Metropolitan Area Network (MAN)", "Global Network", "A"],
                  ["Which network covers an entire country or spans across the globe (e.g. the Internet)?", "MCQ", "Wide Area Network (WAN)", "LAN", "PAN", "SAN", "A"],
                  ["A small personal network connecting devices around a single person within 10 meters (via Bluetooth) is a _______.", "MCQ", "Personal Area Network (PAN)", "WAN", "MAN", "LAN", "A"],
                  ["The physical or logical layout arrangement of connected nodes and cables in a network is called Network _______.", "MCQ", "Topology", "Protocol", "Bandwidth", "IP Address", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["LAN stands for Local Area _______.", "FILL_BLANK", "Network", "Network", "", "", "Network"],
                  ["WAN stands for Wide Area _______.", "FILL_BLANK", "Network", "Network", "", "", "Network"],
                  ["The central connecting device in a Star topology is a Switch or _______.", "FILL_BLANK", "Hub", "Hub, Switch", "", "", "Hub"],
                  ["The network hardware card inside a computer used to connect an Ethernet cable is the _______ Card.", "FILL_BLANK", "NIC", "NIC, Network Interface", "", "", "NIC"],
                  ["The largest example of a WAN in the world is the _______.", "FILL_BLANK", "Internet", "Internet", "", "", "Internet"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["In which network topology are all computers connected to a single central backbone cable with terminators at both ends?", "MCQ", "Bus Topology", "Star Topology", "Ring Topology", "Mesh Topology", "A"],
                  ["In which topology is every node connected directly to a central Hub or Switch?", "MCQ", "Star Topology", "Bus Topology", "Ring Topology", "Linear Topology", "A"],
                  ["What is the main advantage of a Star Topology over a Bus Topology?", "MCQ", "If one computer cable fails, only that single node is disconnected while the rest of the network stays online", "It requires no cables", "It has no speed limit", "It doesn't need electricity", "A"],
                  ["Which networking device converts digital computer signals to analog signals for transmission over phone lines and vice-versa?", "MCQ", "Modem (Modulator-Demodulator)", "Printer", "Scanner", "CPU Fan", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["A school wants to connect 30 computers in their computer lab to share one high-speed laser printer and internet. What network should they set up?", "MCQ", "A Star-Topology LAN with a central Switch", "A WAN connecting to NASA", "A PAN using infrared", "A standalone disconnected setup", "A"],
                  ["What happens in a Bus Topology if the main backbone cable breaks in the middle?", "MCQ", "The entire network stops functioning completely", "Only one computer stops", "The computers switch to battery", "The screen turns green", "A"],
                  ["What is a Router in computer networking?", "MCQ", "An intelligent device that routes data packets between different networks (e.g. connecting home LAN to Internet WAN)", "A device that cools the CPU", "A wireless mouse", "A video card", "A"],
                  ["What is the unique hardware address permanently assigned to every Network Interface Card (NIC)?", "MCQ", "MAC Address (Media Access Control)", "IP Address", "URL", "Port Number", "A"],
                  ["Why is wireless networking (Wi-Fi) widely preferred over physical wired cabling in modern mobile classrooms?", "MCQ", "Allows flexibility, mobility of laptops/tablets, and eliminates messy cable clutter", "Wi-Fi is 1000x cheaper than electricity", "Wi-Fi works underwater only", "Cables are illegal", "A"]
                ]
              }
            ]
          }
        ]
      },
      {
        unitNumber: 2,
        unitName: "Unit 2 – Web Page Authoring with HTML5",
        chapters: [
          {
            num: 3,
            name: "CBSE 7 - Introduction to HTML5 & Web Structure",
            missions: [
              {
                mNum: 1,
                q: [
                  ["What does HTML stand for in web development?", "MCQ", "HyperText Markup Language", "HighText Machine Language", "Hyper Tool Multi Language", "Home Text Markup Language", "A"],
                  ["What is the basic building block of an HTML document enclosed within angle brackets (e.g. `<p>`) called?", "MCQ", "HTML Tag", "Variable", "Loop", "Function", "A"],
                  ["Which HTML tag is the container for all visible content displayed on a web page?", "MCQ", "<body>", "<head>", "<title>", "<meta>", "A"],
                  ["Which HTML heading tag creates the largest, most prominent top-level heading?", "MCQ", "<h1>", "<h6>", "<head>", "<header>", "A"],
                  ["Which HTML tag is used to create a new paragraph of text?", "MCQ", "<p>", "<para>", "<text>", "<br>", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["The root top-level tag of every web page is <_______>.", "FILL_BLANK", "html", "html", "", "", "html"],
                  ["The closing tag of `<p>` in HTML is </_______>.", "FILL_BLANK", "p", "p", "", "", "p"],
                  ["The smallest and least prominent HTML heading tag is <h_______>.", "FILL_BLANK", "6", "6", "", "", "6"],
                  ["An empty tag that inserts a single line break with no closing tag is <_______>.", "FILL_BLANK", "br", "br, br/", "", "", "br"],
                  ["The tag used to display text in the browser window tab title is <_______>.", "FILL_BLANK", "title", "title", "", "", "title"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["What is an 'Empty Tag' in HTML?", "MCQ", "A tag that has no closing tag and cannot contain inner text (e.g. `<br>`, `<img>`, `<hr>`)", "A tag with no letters", "A deleted tag", "A tag with 0 size", "A"],
                  ["Which tag inserts a horizontal thematic divider line across the web page?", "MCQ", "<hr>", "<br>", "<line>", "<rule>", "A"],
                  ["Which HTML tag is used to format text in bold strongly?", "MCQ", "<b> or <strong>", "<i>", "<u>", "<mark>", "A"],
                  ["Which HTML tag is used to display italicized text?", "MCQ", "<i> or <em>", "<b>", "<s>", "<small>", "A"],
                  ["What file extension must be used when saving an HTML file in Notepad or VS Code?", "MCQ", ".html or .htm", ".docx", ".txt", ".exe", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["A student creates `myfirstpage.html` with: `<html><head><title>My School</title></head><body><h1>Welcome</h1></body></html>`. Where does 'My School' appear?", "MCQ", "On the top title tab of the web browser window", "Inside the main web page body", "On the printer", "As a footer", "A"],
                  ["What is the correct declaration placed on the very first line of modern HTML5 documents?", "MCQ", "<!DOCTYPE html>", "<HTML5>", "<DOCTYPE>", "<xml>", "A"],
                  ["What provides additional information or settings inside the opening tag of an HTML element (e.g. `align=\"center\"`)?", "MCQ", "HTML Attribute", "Variable", "Comment", "Tag Name", "A"],
                  ["How do you write a comment in HTML that is ignored by web browsers?", "MCQ", "<!-- This is a comment -->", "// This is a comment", "/* This is a comment */", "# This is a comment", "A"],
                  ["Why is HTML called a 'Markup Language' rather than a programming language?", "MCQ", "It uses tags to structure, annotate, and format text content rather than executing algorithmic computation", "Because it has no tags", "Because it is compiled into binary", "To make it harder to learn", "A"]
                ]
              }
            ]
          },
          {
            num: 4,
            name: "CBSE 7 - Formatting, Colors & Hyperlinks in HTML",
            missions: [
              {
                mNum: 1,
                q: [
                  ["Which HTML tag is used to create a hyperlink that navigates to another web page?", "MCQ", "<a> (Anchor Tag)", "<link>", "<href>", "<nav>", "A"],
                  ["Which essential attribute of the `<a>` anchor tag specifies the destination URL address?", "MCQ", "href (Hypertext Reference)", "src", "target", "alt", "A"],
                  ["Which HTML tag is used to embed and display an image on a web page?", "MCQ", "<img>", "<picture>", "<image>", "<photo>", "A"],
                  ["Which attribute of the `<img>` tag specifies the path or URL of the image file?", "MCQ", "src (Source)", "href", "alt", "link", "A"],
                  ["Which attribute of the `<img>` tag provides alternate descriptive text if the image fails to load?", "MCQ", "alt (Alternate text)", "title", "name", "desc", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["The anchor tag for creating hyperlinks is <_______>.", "FILL_BLANK", "a", "a", "", "", "a"],
                  ["The image source attribute in `<img>` is _______=\"photo.jpg\".", "FILL_BLANK", "src", "src", "", "", "src"],
                  ["To make a hyperlink open in a brand new browser tab, we use target=\"_______blank\".", "FILL_BLANK", "_", "_, _blank", "", "", "_"],
                  ["To highlight text with yellow background in HTML5, we use the <_______> tag.", "FILL_BLANK", "mark", "mark", "", "", "mark"],
                  ["To display chemical formulas like H2O with lowered text, we use <_______>.", "FILL_BLANK", "sub", "sub, subscript", "", "", "sub"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["How do you create a link to Google in HTML?", "MCQ", "<a href=\"https://www.google.com\">Visit Google</a>", "<link src=\"https://www.google.com\">Google</link>", "<a url=\"google.com\">Google</a>", "<hyperlink>google.com</hyperlink>", "A"],
                  ["Which tag is used to display mathematical exponents like X² with raised text?", "MCQ", "<sup> (Superscript)", "<sub> (Subscript)", "<exp>", "<power>", "A"],
                  ["Which tag displays deleted text with a strikethrough line across it?", "MCQ", "<del> or <s>", "<mark>", "<u>", "<small>", "A"],
                  ["Which attribute sets the width of an embedded image in pixels?", "MCQ", "width=\"300\"", "size=\"300\"", "scale=\"300\"", "px=\"300\"", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["You want an image `logo.png` to act as a clickable button leading to `home.html`. What is the correct HTML code?", "MCQ", "<a href=\"home.html\"><img src=\"logo.png\" alt=\"Logo\"></a>", "<img href=\"home.html\" src=\"logo.png\">", "<link url=\"home.html\" src=\"logo.png\">", "<a src=\"logo.png\">home.html</a>", "A"],
                  ["Why is adding the `alt` attribute to every `<img>` tag considered an essential web accessibility best practice?", "MCQ", "Screen readers for visually impaired users read the alt text aloud, and it shows if the image is missing", "It increases image resolution", "It makes images load in 3D", "It translates text to German", "A"],
                  ["Which tag is used to display pre-formatted text preserving exact spaces and line breaks?", "MCQ", "<pre>", "<p>", "<code>", "<text>", "A"],
                  ["How can you set a background color of light blue on an HTML body using inline CSS style?", "MCQ", "<body style=\"background-color: lightblue;\">", "<body color=\"blue\">", "<body bg=\"blue\">", "<background color=\"blue\">", "A"],
                  ["What is an internal hyperlink bookmark in HTML?", "MCQ", "A link using `#sectionId` that jumps directly to a specific section on the same web page", "A link to an external website", "A broken link", "A download button", "A"]
                ]
              }
            ]
          }
        ]
      },
      {
        unitNumber: 3,
        unitName: "Unit 3 – Python Programming & Cyber Defense",
        chapters: [
          {
            num: 5,
            name: "CBSE 7 - Introduction to Python 3 (Variables, Keywords, Input/Output)",
            missions: [
              {
                mNum: 1,
                q: [
                  ["Who created the Python programming language in 1991?", "MCQ", "Guido van Rossum", "Dennis Ritchie", "James Gosling", "Bjarne Stroustrup", "A"],
                  ["Which built-in Python function is used to display text or output on the console screen?", "MCQ", "print()", "echo()", "display()", "write()", "A"],
                  ["Which built-in function is used to take user input typed from the keyboard in Python?", "MCQ", "input()", "read()", "scan()", "get()", "A"],
                  ["What symbol is used to start a single-line comment in Python?", "MCQ", "# (Hash Symbol)", "//", "/*", "--", "A"],
                  ["What is a Variable in Python?", "MCQ", "A named container or memory location used to store data values", "A hardware screw", "A cooling fan", "A monitor cable", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["The function used to print output in Python is _______().", "FILL_BLANK", "print", "print", "", "", "print"],
                  ["The function used to take string input from user in Python is _______().", "FILL_BLANK", "input", "input", "", "", "input"],
                  ["To convert a string into an integer number in Python, we use _______().", "FILL_BLANK", "int", "int", "", "", "int"],
                  ["In Python, decimal floating-point numbers (e.g. 3.14) belong to the data type _______.", "FILL_BLANK", "float", "float", "", "", "float"],
                  ["A sequence of characters enclosed in quotes (e.g. \"Hello\") is a _______ (str).", "FILL_BLANK", "string", "string, str", "", "", "string"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["What is the output of `print(10 + 20)` in Python?", "MCQ", "30", "\"10+20\"", "1020", "Error", "A"],
                  ["What is the output of `print(\"10\" + \"20\")` in Python?", "MCQ", "1020 (String Concatenation)", "30", "\"10 20\"", "Error", "A"],
                  ["Which of the following is a valid variable name in Python?", "MCQ", "student_age", "2ndStudent", "student-name", "class", "A"],
                  ["Why is `class` invalid as a user variable name in Python?", "MCQ", "Because `class` is a reserved Python Keyword", "Because it is too short", "Because it has no numbers", "Because it is uppercase", "A"],
                  ["What does the exponentiation power operator in Python look like?", "MCQ", "** (e.g. 2**3 = 8)", "^", "pow", "^^", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["A student writes:\n```python\nnum = int(input(\"Enter a number: \"))\nprint(num * 2)\n```\nIf user enters `5`, what is printed?", "MCQ", "10", "55", "\"5*2\"", "Error", "A", "python"],
                  ["What is the output of `print(17 // 5)` using Python's Floor Division operator?", "MCQ", "3 (Integer quotient without decimal)", "3.4", "2", "0", "A", "python"],
                  ["What is the output of `print(17 % 5)` using Python's Modulus remainder operator?", "MCQ", "2 (Remainder when 17 is divided by 5)", "3", "3.4", "0", "A", "python"],
                  ["What will `type(25.5)` return in Python?", "MCQ", "<class 'float'>", "<class 'int'>", "<class 'str'>", "<class 'bool'>", "A", "python"],
                  ["Why is Python widely recommended as the best first programming language for middle school students?", "MCQ", "It features clean English-like syntax, excellent readability, and massive real-world use in AI/Web", "It requires no CPU", "It only runs on tablets", "It has no data types", "A"]
                ]
              }
            ]
          },
          {
            num: 6,
            name: "CBSE 7 - Python Conditionals & Cyber Threats Defense",
            missions: [
              {
                mNum: 1,
                q: [
                  ["Which statement in Python is used for decision making based on conditions?", "MCQ", "if-elif-else", "for loop", "while loop", "def", "A"],
                  ["Which relational operator in Python tests if two values are equal?", "MCQ", "== (Double Equals)", "=", "!=", "<>", "A"],
                  ["Which relational operator tests if two values are NOT equal?", "MCQ", "!=", "<>", "not equal", "==", "A"],
                  ["What character must always be placed at the end of an `if` or `else` line in Python?", "MCQ", ": (Colon)", ";", ".", ",", "A"],
                  ["How does Python determine which lines of code belong inside an `if` block?", "MCQ", "Indentation (Leading spaces/tabs)", "Curly Brackets {}", "Semicolons ;", "Parentheses ()", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["In Python, the 'else if' condition statement is written as _______.", "FILL_BLANK", "elif", "elif", "", "", "elif"],
                  ["The boolean data type in Python has only two values: True and _______.", "FILL_BLANK", "False", "False", "", "", "False"],
                  ["The logical operator that returns True only if BOTH conditions are true is _______.", "FILL_BLANK", "and", "and", "", "", "and"],
                  ["The logical operator that returns True if AT LEAST ONE condition is true is _______.", "FILL_BLANK", "or", "or", "", "", "or"],
                  ["Leading whitespace spaces used to define a block of code in Python are called _______.", "FILL_BLANK", "Indentation", "Indentation, Indent", "", "", "Indentation"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["What is the output of the following Python snippet?\n```python\nx = 15\nif x >= 18:\n    print(\"Eligible\")\nelse:\n    print(\"Minor\")\n```", "MCQ", "Minor", "Eligible", "15", "Error", "A", "python"],
                  ["What is Ransomware in cyber threats?", "MCQ", "Malware that encrypts your personal files and demands money/ransom to restore them", "Free antivirus software", "A fast web browser", "A search engine", "A"],
                  ["What is Spyware?", "MCQ", "Covert malware that secretely monitors and logs your keystrokes and internet activity without consent", "An online multiplayer game", "A video editor", "A cloud drive", "A"],
                  ["What is a Firewall in computer security?", "MCQ", "A network security system that monitors and filters incoming and outgoing network traffic based on security rules", "A physical wall made of fire", "A damaged cooling fan", "A burning CPU", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["What will the following Python code print?\n```python\nscore = 85\nif score >= 90:\n    print(\"A+\")\nelif score >= 80:\n    print(\"A\")\nelse:\n    print(\"B\")\n```", "MCQ", "A", "A+", "B", "85", "A", "python"],
                  ["Why does Python raise an `IndentationError`?", "MCQ", "When lines inside code blocks (if, loops) are not properly aligned with consistent spaces", "When the computer is unplugged", "When a variable is too large", "When numbers are negative", "A"],
                  ["What is the purpose of the logical `not` operator in Python?", "MCQ", "It reverses the boolean truth value (turns True to False and False to True)", "It deletes a variable", "It adds two numbers", "It prints a blank line", "A"],
                  ["Which security practice is most effective against destructive Ransomware attacks?", "MCQ", "Maintaining regular offline backups of critical data on external drives or secure cloud", "Turning off monitor brightness", "Using no passwords", "Opening unknown email attachments", "A"],
                  ["What is the national cybercrime reporting helpline number in India for reporting online fraud and harassment?", "MCQ", "1930 (Cyber Crime Helpline)", "100", "101", "108", "A"]
                ]
              }
            ]
          }
        ]
      }
    ]
  }
];
