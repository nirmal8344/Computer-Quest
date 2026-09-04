// =========================================================================
// CBSE CLASSES 8, 9, 10 (MULTI-UNIT OFFICIAL CURRICULA)
// NCERT / CBSE IT (Code 402 & 165) Multi-Unit Structure & High-Level Questions
// =========================================================================

module.exports = [
  // -------------------------------------------------------------
  // CBSE CLASS 8 (Advanced Web, Python Loops, RDBMS, AI Intro)
  // -------------------------------------------------------------
  {
    board: "CBSE",
    classLevel: 8,
    units: [
      {
        unitNumber: 1,
        unitName: "Unit 1 – Advanced Web Development & CSS",
        chapters: [
          {
            num: 1,
            name: "CBSE 8 - HTML5 Lists, Tables and Images",
            missions: [
              {
                mNum: 1,
                q: [
                  ["Which HTML tag is used to create a numbered (Ordered) list?", "MCQ", "<ol>", "<ul>", "<li>", "<dl>", "A"],
                  ["Which HTML tag is used to create a bulleted (Unordered) list?", "MCQ", "<ul>", "<ol>", "<li>", "<list>", "A"],
                  ["Which tag defines an individual list item inside `<ol>` or `<ul>`?", "MCQ", "<li>", "<item>", "<dt>", "<dd>", "A"],
                  ["Which tag defines a table row in an HTML table?", "MCQ", "<tr>", "<td>", "<th>", "<table>", "A"],
                  ["Which tag defines a table header cell with bold centered text by default?", "MCQ", "<th>", "<td>", "<tr>", "<caption>", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["An unordered bulleted list is declared with the <_______> tag.", "FILL_BLANK", "ul", "ul", "", "", "ul"],
                  ["A numbered ordered list is declared with the <_______> tag.", "FILL_BLANK", "ol", "ol", "", "", "ol"],
                  ["A standard table data cell is defined using <_______>.", "FILL_BLANK", "td", "td", "", "", "td"],
                  ["The attribute used to merge two or more table columns horizontally is _______=\"2\".", "FILL_BLANK", "colspan", "colspan", "", "", "colspan"],
                  ["The attribute used to merge table rows vertically is _______=\"2\".", "FILL_BLANK", "rowspan", "rowspan", "", "", "rowspan"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["Which attribute of `<ol>` changes the numbering style to uppercase roman numerals (I, II, III)?", "MCQ", "type=\"I\"", "style=\"roman\"", "number=\"I\"", "start=\"I\"", "A"],
                  ["Which attribute of `<ol>` allows numbering to begin from a custom number like 10?", "MCQ", "start=\"10\"", "begin=\"10\"", "from=\"10\"", "offset=\"10\"", "A"],
                  ["What does CSS stand for in modern web development?", "MCQ", "Cascading Style Sheets", "Creative Style System", "Computer Sheet Styles", "Color Style Source", "A"],
                  ["Which tag defines a description / definition list in HTML?", "MCQ", "<dl>", "<ol>", "<ul>", "<list>", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["You want a table header cell 'Student Information' to span across 3 columns. What is the correct HTML?", "MCQ", "<th colspan=\"3\">Student Information</th>", "<th rowspan=\"3\">Student Information</th>", "<td span=\"3\">Student Information</td>", "<tr merge=\"3\">Student Information</tr>", "A"],
                  ["What is the difference between `<th>` and `<td>` in HTML tables?", "MCQ", "`<th>` is for bold centered header cells; `<td>` is for standard regular data cells", "`<th>` only holds pictures", "`<td>` creates a new row", "They are identical in every way", "A"],
                  ["How do you create a nested list in HTML?", "MCQ", "Place an entire `<ul>` or `<ol>` inside an `<li>` element", "Put tags in reverse order", "Close all browser windows", "Use a table instead", "A"],
                  ["Which tag adds an accessible caption title to an HTML table?", "MCQ", "<caption>", "<title>", "<header>", "<label>", "A"],
                  ["Why is separating HTML structure from CSS presentation considered an industry best practice?", "MCQ", "It makes websites cleaner, easier to maintain, faster to style globally, and responsive", "It makes HTML files 100 GB", "It compiles code into binary", "To confuse web crawlers", "A"]
                ]
              }
            ]
          },
          {
            num: 2,
            name: "CBSE 8 - Introduction to CSS & Styling",
            missions: [
              {
                mNum: 1,
                q: [
                  ["Which CSS property is used to change the background color of an element?", "MCQ", "background-color", "color", "bgcolor", "fill", "A"],
                  ["Which CSS property is used to change the text color of a heading or paragraph?", "MCQ", "color", "font-color", "text-color", "text-fill", "A"],
                  ["Which CSS property controls the size of text fonts (e.g. `24px` or `1.5rem`)?", "MCQ", "font-size", "text-size", "font-weight", "size", "A"],
                  ["Which CSS property is used to change the font face/family of text?", "MCQ", "font-family", "font-type", "typeface", "font-name", "A"],
                  ["Which method of CSS is written directly inside an HTML tag using the `style=\"...\"` attribute?", "MCQ", "Inline CSS", "Internal CSS", "External CSS", "Imported CSS", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["To center text horizontally in CSS, we use text-align: _______.", "FILL_BLANK", "center", "center", "", "", "center"],
                  ["Internal CSS is written inside the <_______> tag in the document `<head>` section.", "FILL_BLANK", "style", "style", "", "", "style"],
                  ["To make text bold in CSS, we set font-weight: _______.", "FILL_BLANK", "bold", "bold", "", "", "bold"],
                  ["External CSS files are saved with the ._______ file extension.", "FILL_BLANK", "css", "css", "", "", "css"],
                  ["The space between content and the border inside an element box is _______.", "FILL_BLANK", "padding", "padding", "", "", "padding"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["Which HTML tag in the `<head>` section connects an external stylesheet `.css` file to an HTML page?", "MCQ", "<link rel=\"stylesheet\" href=\"style.css\">", "<style src=\"style.css\">", "<css href=\"style.css\">", "<script link=\"style.css\">", "A"],
                  ["In CSS syntax `h1 { color: red; }`, what is `h1` called?", "MCQ", "Selector", "Property", "Value", "Declaration", "A"],
                  ["Which CSS selector targets an element by its unique `id` attribute?", "MCQ", "# (Hash Symbol, e.g. #header)", ". (Dot)", "$", "*", "A"],
                  ["Which CSS selector targets elements by their `class` attribute?", "MCQ", ". (Dot, e.g. .btn-primary)", "#", "&", "@", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["Why is External CSS preferred over Inline CSS for multi-page websites?", "MCQ", "A single external `.css` file can style thousands of web pages consistently with one edit", "Inline CSS is faster to download", "External CSS requires no browser", "To use more disk space", "A"],
                  ["In the CSS Box Model, what is the correct order from innermost content to outermost edge?", "MCQ", "Content -> Padding -> Border -> Margin", "Content -> Margin -> Border -> Padding", "Margin -> Border -> Padding -> Content", "Border -> Margin -> Padding -> Content", "A"],
                  ["What does `text-decoration: none;` do when applied to `<a>` hyperlink tags?", "MCQ", "Removes the default blue underline from the hyperlink text", "Deletes the link destination", "Makes text invisible", "Changes font to bold", "A"],
                  ["What is the universal selector in CSS that matches every element on the page?", "MCQ", "* (Asterisk)", "#all", ".universal", "body", "A"],
                  ["What CSS property adds smooth rounded corners to buttons and cards?", "MCQ", "border-radius", "border-curve", "corner-round", "box-radius", "A"]
                ]
              }
            ]
          }
        ]
      },
      {
        unitNumber: 2,
        unitName: "Unit 2 – Programming with Python (Loops & Iterations)",
        chapters: [
          {
            num: 3,
            name: "CBSE 8 - Iteration Statements in Python (for & while Loops)",
            missions: [
              {
                mNum: 1,
                q: [
                  ["Which built-in Python function generates a sequence of immutable numbers over a range?", "MCQ", "range()", "sequence()", "count()", "generate()", "A"],
                  ["What is the starting number generated by `range(5)` by default?", "MCQ", "0 (generates 0, 1, 2, 3, 4)", "1", "5", "-1", "A"],
                  ["What sequence of numbers does `range(1, 6)` produce in Python?", "MCQ", "1, 2, 3, 4, 5 (up to but excluding 6)", "1, 2, 3, 4, 5, 6", "0, 1, 2, 3, 4, 5", "6, 5, 4, 3, 2, 1", "A"],
                  ["Which loop in Python is typically used when the number of iterations is known in advance?", "MCQ", "for loop", "while loop", "if statement", "def block", "A"],
                  ["Which loop in Python continues repeating as long as a specified condition remains True?", "MCQ", "while loop", "for loop", "switch statement", "try block", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["The step argument in `range(1, 10, 2)` produces odd numbers with a jump of _______.", "FILL_BLANK", "2", "2, two", "", "", "2"],
                  ["To terminate and exit a loop immediately before its normal end, we use the _______ keyword.", "FILL_BLANK", "break", "break", "", "", "break"],
                  ["To skip the current iteration and jump to the next cycle of a loop, we use _______.", "FILL_BLANK", "continue", "continue", "", "", "continue"],
                  ["A loop placed completely inside the body of another loop is a _______ loop.", "FILL_BLANK", "nested", "nested", "", "", "nested"],
                  ["The operator that increments a variable `x` by 1 is `x _______= 1`.", "FILL_BLANK", "+", "+, +=", "", "", "+"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["What will the following code output?\n```python\nfor i in range(3):\n    print(i, end=\" \")\n```", "MCQ", "0 1 2", "1 2 3", "0 1 2 3", "3 2 1", "A", "python"],
                  ["What is the output of:\n```python\ncount = 1\nwhile count <= 3:\n    print(count, end=\" \")\n    count += 1\n```", "MCQ", "1 2 3", "0 1 2 3", "1 2", "Infinite loop", "A", "python"],
                  ["What happens if the loop increment `count += 1` is forgotten inside a `while count <= 10:` loop?", "MCQ", "It creates an infinite loop that runs forever because `count` never exceeds 10", "The loop terminates immediately", "Python crashes with syntax error", "The variable becomes negative", "A", "python"],
                  ["What will the following loop print?\n```python\nfor i in range(1, 6):\n    if i == 3:\n        break\n    print(i, end=\" \")\n```", "MCQ", "1 2", "1 2 3", "1 2 4 5", "3 4 5", "A", "python"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["What will the following code with `continue` output?\n```python\nfor i in range(1, 5):\n    if i == 3:\n        continue\n    print(i, end=\" \")\n```", "MCQ", "1 2 4", "1 2 3 4", "1 2", "3 4", "A", "python"],
                  ["What is the output of `list(range(10, 0, -2))`?", "MCQ", "[10, 8, 6, 4, 2]", "[10, 9, 8, 7, 6]", "[0, 2, 4, 6, 8, 10]", "[]", "A", "python"],
                  ["What will this nested loop print?\n```python\nfor r in range(2):\n    for c in range(2):\n        print(\"*\", end=\"\")\n    print()\n```", "MCQ", "** on two separate lines (2x2 grid of asterisks)", "**** on one line", "* on 4 lines", "Error", "A", "python"],
                  ["How many times will `for x in \"CODE\":` execute its loop body?", "MCQ", "4 times (once for each character: 'C', 'O', 'D', 'E')", "1 time", "0 times", "5 times", "A", "python"],
                  ["Why is looping one of the most powerful programming constructs in computational problem solving?", "MCQ", "It automates repetitive calculations, data processing, and batch tasks with minimal lines of code", "It removes the need for memory", "It makes CPUs run cooler", "It replaces the keyboard", "A"]
                ]
              }
            ]
          },
          {
            num: 4,
            name: "CBSE 8 - Python Jump Statements & Sequences",
            missions: [
              {
                mNum: 1,
                q: [
                  ["Which Python keyword acts as a placeholder doing nothing when syntax requires a statement?", "MCQ", "pass", "break", "continue", "skip", "A"],
                  ["Which built-in Python function returns the total number of characters in a string or items in a list?", "MCQ", "len()", "count()", "size()", "total()", "A"],
                  ["What is the index position of the very first character in any Python string or list?", "MCQ", "0 (Zero-based indexing)", "1", "-1", "None", "A"],
                  ["What does negative indexing `[-1]` access in a Python sequence?", "MCQ", "The last item in the sequence", "The first item", "A random item", "An error", "A"],
                  ["An ordered, mutable collection of items enclosed in square brackets `[1, 2, 3]` is a _______.", "MCQ", "List", "Tuple", "Dictionary", "Set", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["The null operation statement in Python is _______.", "FILL_BLANK", "pass", "pass", "", "", "pass"],
                  ["The length of string `\"PYTHON\"` returned by `len(\"PYTHON\")` is _______.", "FILL_BLANK", "6", "6", "", "", "6"],
                  ["In `text = \"QUEST\"`, `text[0]` is the letter _______.", "FILL_BLANK", "Q", "Q", "", "", "Q"],
                  ["In `text = \"QUEST\"`, `text[-1]` is the letter _______.", "FILL_BLANK", "T", "T", "", "", "T"],
                  ["To add a new item to the end of a list in Python, we call list._______(item).", "FILL_BLANK", "append", "append", "", "", "append"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["What is the output of:\n```python\nnums = [10, 20, 30]\nnums.append(40)\nprint(len(nums))\n```", "MCQ", "4", "3", "[10, 20, 30, 40]", "Error", "A", "python"],
                  ["What will `print(\"Hello\"[1:4])` output using Python string slicing?", "MCQ", "\"ell\" (characters at index 1, 2, 3)", "\"Hel\"", "\"Hell\"", "\"ello\"", "A", "python"],
                  ["What is the output of `print(\"Python\" * 2)`?", "MCQ", "\"PythonPython\"", "\"Python 2\"", "\"Python*2\"", "Error", "A", "python"],
                  ["Which membership operator in Python checks if an element exists inside a sequence?", "MCQ", "in (e.g. `\"a\" in \"apple\"`)", "has", "contains", "exists", "A", "python"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["What will the following code output?\n```python\ntotal = 0\nfor n in [5, 10, 15]:\n    total += n\nprint(total)\n```", "MCQ", "30", "15", "51015", "0", "A", "python"],
                  ["What is the result of `\"Python\".upper()`?", "MCQ", "\"PYTHON\"", "\"python\"", "\"Python\"", "Error", "A", "python"],
                  ["What is the result of `\"  code  \".strip()`?", "MCQ", "\"code\" (removes leading and trailing whitespace)", "\"  code  \"", "\"code  \"", "\"  code\"", "A", "python"],
                  ["What happens if you try to access `items[10]` on a list containing only 3 elements?", "MCQ", "Python raises an `IndexError: list index out of range`", "It returns None", "It expands the list automatically", "It returns 0", "A", "python"],
                  ["Why are Lists called 'Mutable' in Python?", "MCQ", "Because elements inside an existing list can be modified, replaced, added, or deleted in-place", "Because they can only store numbers", "Because they are immutable", "Because they run in threads", "A"]
                ]
              }
            ]
          }
        ]
      },
      {
        unitNumber: 3,
        unitName: "Unit 3 – Data Management & Emerging Tech",
        chapters: [
          {
            num: 5,
            name: "CBSE 8 - Relational Database Management System (RDBMS) Concepts",
            missions: [
              {
                mNum: 1,
                q: [
                  ["An organized collection of related, structured digital data stored electronically is a _______.", "MCQ", "Database", "Spreadsheet Sheet", "Word Doc", "Text File", "A"],
                  ["What does RDBMS stand for in computer science?", "MCQ", "Relational Database Management System", "Rapid Data Base Method System", "Real Data Backup Server", "Remote Data Base Multi System", "A"],
                  ["In a relational database table, what is a single horizontal row representing one complete record called?", "MCQ", "Tuple / Record", "Attribute / Column", "Domain", "Key", "A"],
                  ["In a relational database table, what is a vertical column representing a specific data property called?", "MCQ", "Attribute / Field", "Tuple", "Row", "Key", "A"],
                  ["A candidate field that uniquely identifies every single record in a database table without duplicates is the _______.", "MCQ", "Primary Key", "Foreign Key", "Composite Key", "Alternate Key", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["A horizontal row in a relational database table is called a _______.", "FILL_BLANK", "Tuple", "Tuple, Record", "", "", "Tuple"],
                  ["A vertical column in a relational table is called an _______.", "FILL_BLANK", "Attribute", "Attribute, Field", "", "", "Attribute"],
                  ["The unique identifier key in a table that cannot contain NULL values is the _______ Key.", "FILL_BLANK", "Primary", "Primary", "", "", "Primary"],
                  ["The total number of rows (records) in a database table is its _______.", "FILL_BLANK", "Cardinality", "Cardinality", "", "", "Cardinality"],
                  ["The total number of columns (attributes) in a database table is its _______.", "FILL_BLANK", "Degree", "Degree", "", "", "Degree"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["If a Student table has 5 columns and 100 student records, what are its Degree and Cardinality?", "MCQ", "Degree = 5, Cardinality = 100", "Degree = 100, Cardinality = 5", "Degree = 500, Cardinality = 5", "Degree = 20, Cardinality = 10", "A"],
                  ["Why is a Primary Key forbidden from having duplicate or NULL (empty) values?", "MCQ", "To guarantee that every entity record can be uniquely and reliably retrieved without ambiguity", "To save disk storage", "To make numbers positive", "To prevent typing", "A"],
                  ["Which of the following field is the most ideal choice for Primary Key in a school database?", "MCQ", "Admission_Number (Unique to each student)", "First_Name (Multiple students can have same name)", "Class_Grade", "City", "A"],
                  ["Which popular open-source database engine is widely used for web and enterprise applications?", "MCQ", "MySQL / PostgreSQL", "MS Paint", "Notepad", "Calculator", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["What is a Foreign Key in relational databases?", "MCQ", "An attribute in one table that references the Primary Key of another table to establish a relationship", "A key from another country", "A password for the database", "A deleted primary key", "A"],
                  ["What is Data Redundancy and why do databases aim to eliminate it?", "MCQ", "Unnecessary duplication of data across multiple files leading to inconsistency and wasted space", "High-speed searching", "Automatic backups", "Fast calculations", "A"],
                  ["What language is the standard universal query language used to interact with RDBMS databases?", "MCQ", "SQL (Structured Query Language)", "HTML", "CSS", "Assembly", "A"],
                  ["Which table property refers to the allowable set of valid data values for a specific column?", "MCQ", "Domain", "Degree", "Tuple", "Relation", "A"],
                  ["Why are RDBMS systems preferred over simple flat Excel spreadsheets for hospital or banking records?", "MCQ", "RDBMS provides ACID transaction security, multi-user concurrency, scalable relationships, and data integrity", "Spreadsheets are too expensive", "RDBMS runs without power", "RDBMS has no tables", "A"]
                ]
              }
            ]
          },
          {
            num: 6,
            name: "CBSE 8 - Computer Networks & Introduction to Artificial Intelligence",
            missions: [
              {
                mNum: 1,
                q: [
                  ["What is Artificial Intelligence (AI)?", "MCQ", "The branch of computer science focused on creating machines capable of performing tasks that require human intelligence", "A new computer game", "A mechanical robot arm only", "A fast internet cable", "A"],
                  ["Which domain of AI enables machines to understand, interpret, and generate human spoken and written languages?", "MCQ", "Natural Language Processing (NLP)", "Computer Vision (CV)", "Statistical Data", "Robotics Hardware", "A"],
                  ["Which domain of AI enables computers to identify, process, and analyze visual pictures and videos?", "MCQ", "Computer Vision (CV)", "NLP", "Audio Processing", "Spreadsheets", "A"],
                  ["Which domain of AI deals with numerical data, predictive analytics, and discovering patterns in big data?", "MCQ", "Data Science & Statistical AI", "Computer Vision", "NLP", "Game Controller", "A"],
                  ["Which protocol is the fundamental communication protocol of the global Internet?", "MCQ", "TCP/IP (Transmission Control Protocol / Internet Protocol)", "HTTP only", "FTP", "SMTP", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["AI stands for Artificial _______.", "FILL_BLANK", "Intelligence", "Intelligence", "", "", "Intelligence"],
                  ["NLP stands for Natural Language _______.", "FILL_BLANK", "Processing", "Processing", "", "", "Processing"],
                  ["The ability of a computer program to learn and improve from experience without being explicitly programmed is Machine _______ (ML).", "FILL_BLANK", "Learning", "Learning", "", "", "Learning"],
                  ["Self-driving autonomous cars use Computer _______ to detect pedestrians and traffic signs.", "FILL_BLANK", "Vision", "Vision", "", "", "Vision"],
                  ["The AI assistant on Apple devices is Siri, while Amazon's voice AI assistant is _______.", "FILL_BLANK", "Alexa", "Alexa", "", "", "Alexa"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["Which real-world application relies heavily on Natural Language Processing (NLP)?", "MCQ", "Google Translate and conversational Chatbots", "Facial recognition unlocking", "Color sorting robots", "Disk defragmenter", "A"],
                  ["Which application uses Computer Vision AI?", "MCQ", "Facial recognition phone unlocking and medical X-ray tumor detection", "Email spam filtering based on words", "Calculators", "Keyboard typing", "A"],
                  ["What is a Smart City in modern IoT and AI applications?", "MCQ", "An urban area using IoT sensors and AI algorithms to optimize traffic lights, energy, and waste management", "A city with free laptops", "A city painted blue", "A video game map", "A"],
                  ["What is the role of the DNS (Domain Name System) on the Internet?", "MCQ", "Translates human-friendly domain names (e.g. google.com) into numerical IP addresses (e.g. 142.250.190.46)", "Designs websites", "Controls keyboard lights", "Protects against viruses", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["Why is high-quality, unbiased training data crucial for machine learning models?", "MCQ", "Because AI models learn patterns strictly from their training datasets; biased data produces biased, incorrect decisions", "To make the file size 100 GB", "Because computers cannot store numbers", "To increase electricity usage", "A"],
                  ["What ethical concern is associated with Deepfake AI technology?", "MCQ", "Generating realistic fake video/audio impersonating real people to spread misinformation or scams", "Slowing down Wi-Fi", "Making monitors brighter", "Increasing RAM speed", "A"],
                  ["Which test was proposed by Alan Turing in 1950 to evaluate if a machine exhibits human-equivalent intelligence?", "MCQ", "Turing Test", "Speed Test", "Ping Test", "Memory Test", "A"],
                  ["What is the difference between Narrow (Weak) AI and General (Strong) AI?", "MCQ", "Narrow AI excels at a specific dedicated task (like chess or translation); General AI would match full human intellectual versatility across any field", "Narrow AI has no code", "General AI is a pocket calculator", "There is no difference", "A"],
                  ["Why should students learn AI literacy and computational ethics early?", "MCQ", "To understand emerging digital tools responsibly, critically evaluate automated systems, and prepare for future innovation", "To stop using computers", "To replace human teachers completely", "To memorize 1000 codes only", "A"]
                ]
              }
            ]
          }
        ]
      }
    ]
  }
];
