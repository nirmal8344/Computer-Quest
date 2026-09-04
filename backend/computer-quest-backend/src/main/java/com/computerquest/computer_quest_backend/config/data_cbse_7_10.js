module.exports = [
  // ========================== CBSE CLASS 7 ==========================
  {
    board: "CBSE",
    classLevel: 7,
    unitName: "UNIT 1 – WEB TECHNOLOGIES AND PYTHON PROGRAMMING",
    chapters: [
      {
        num: 1,
        name: "CBSE 7 - Advanced Excel Functions & Data Visualization",
        missions: [
          {
            mNum: 1,
            q: [
              ["Which Excel logical function evaluates a condition and returns one value if True and another if False?", "MCQ", "=IF(condition, value_if_true, value_if_false)", "=SUM(range)", "=MAX(range)", "=COUNT(range)", "A"],
              ["Which Excel function counts only the cells that satisfy a given criteria or condition?", "MCQ", "=COUNTIF(range, criteria)", "=SUM(range)", "=AVERAGE(range)", "=COUNTA(range)", "A"],
              ["What feature in Excel reorganizes data in ascending (A to Z) or descending (Z to A) order?", "MCQ", "Sort Data", "Filter Data", "Wrap Text", "Merge Cells", "A"],
              ["What feature in Excel displays only the specific rows that meet defined criteria while hiding other rows?", "MCQ", "Filter (AutoFilter)", "Sort", "Formula Auditing", "Spell Check", "A"],
              ["Which chart type in Excel displays vertical rectangular columns to compare quantities across categories?", "MCQ", "Column Chart", "Pie Chart", "Line Chart", "Radar Chart", "A"]
            ]
          },
          {
            mNum: 2,
            q: [
              ["The function =IF(B2>=40, \"Pass\", \"Fail\") returns _______ when B2 is 75.", "FILL_BLANK", "Pass", "Pass", "", "", "Pass"],
              ["In Excel, cell reference $A$1 that does not change when copied is called an _______ cell reference.", "FILL_BLANK", "Absolute", "Absolute, Absolute reference", "", "", "Absolute"],
              ["The chart component that identifies the colors and data series names is called the Chart _______.", "FILL_BLANK", "Legend", "Legend", "", "", "Legend"],
              ["The horizontal axis in a 2D column chart is called the X-Axis or _______ Axis.", "FILL_BLANK", "Category", "Category, Category axis", "", "", "Category"],
              ["The vertical axis representing numerical values in a chart is the Y-Axis or _______ Axis.", "FILL_BLANK", "Value", "Value, Value axis", "", "", "Value"]
            ]
          },
          {
            mNum: 3,
            q: [
              ["What Excel formatting rule automatically changes a cell's background color to green if value > 90?", "MCQ", "Conditional Formatting", "AutoSum", "Cell Merging", "Word Wrap", "A"],
              ["Which function in Excel adds up only the numbers in a range that meet a specific criteria?", "MCQ", "=SUMIF(range, criteria, [sum_range])", "=TOTAL(range)", "=COUNT(range)", "=IFSUM(range)", "A"],
              ["What is the cell reference type 'A1' that automatically adjusts when copied across rows or columns?", "MCQ", "Relative Reference", "Absolute Reference", "Mixed Reference", "Circular Reference", "A"],
              ["Which function counts all non-empty cells including text, numbers, and symbols in a range?", "MCQ", "=COUNTA(range)", "=COUNT(range)", "=COUNTBLANK(range)", "=SUM(range)", "A"],
              ["Which function counts the number of empty/blank cells within a specified range?", "MCQ", "=COUNTBLANK(range)", "=COUNT(range)", "=COUNTA(range)", "=BLANK(range)", "A"]
            ]
          },
          {
            mNum: 4,
            q: [
              ["A student enters =IF(A1>50, A1*2, A1+10). If A1 contains 60, what value is returned?", "MCQ", "120 (Condition 60>50 is True -> 60*2=120)", "70", "100", "50", "A"],
              ["You have a list of 500 sales records and want to see only sales from the 'North' region. Which tool should you use?", "MCQ", "Filter -> Select 'North'", "Sort Z to A", "Delete all rows", "Change font color", "A"],
              ["What formula correctly checks if a student score in cell M2 has passed (>=35) with 'Passed' else 'Failed'?", "MCQ", "=IF(M2>=35, \"Passed\", \"Failed\")", "=IF(M2<35, \"Passed\", \"Failed\")", "=CHECK(M2, 35)", "=PASS(M2)", "A"],
              ["What chart type is best suited to display quarterly company profit comparisons side-by-side?", "MCQ", "Clustered Column Chart", "Scatter Plot", "Pie Chart with 50 slices", "Bubble Chart", "A"],
              ["Why does copying formula =$A$1*B2 to the next row result in =$A$1*B3?", "MCQ", "$A$1 is absolute and remains fixed, while B2 is relative and adjusts to B3", "Excel made an error", "Both cells are absolute", "Both cells are relative", "A"]
            ]
          }
        ]
      },
      {
        num: 2,
        name: "CBSE 7 - Web Fundamentals & HTML5 Structure",
        missions: [
          {
            mNum: 1,
            q: [
              ["What does HTML stand for in web technologies?", "MCQ", "HyperText Markup Language", "Hyperlink Text Management Language", "High-level Text Machine Language", "Home Tool Markup Language", "A"],
              ["What is the root container tag that encloses all elements of an HTML web document?", "MCQ", "<html> ... </html>", "<head> ... </head>", "<body> ... </body>", "<main> ... </main>", "A"],
              ["Which HTML tag section contains metadata, scripts, and the document <title> shown in browser tabs?", "MCQ", "<head> ... </head>", "<body> ... </body>", "<p> ... </p>", "<footer>", "A"],
              ["Which HTML section holds all the visible content (headings, paragraphs, images) displayed on a web page?", "MCQ", "<body> ... </body>", "<head> ... </head>", "<title> ... </title>", "<meta>", "A"],
              ["Which HTML heading tag creates the largest, most prominent main heading?", "MCQ", "<h1>", "<h6>", "<head>", "<header>", "A"]
            ]
          },
          {
            mNum: 2,
            q: [
              ["The tag used to define a regular text paragraph in HTML is <_______>.", "FILL_BLANK", "p", "p, P", "", "", "p"],
              ["The empty tag used to insert a single line break in HTML without closing tag is <_______>.", "FILL_BLANK", "br", "br, BR", "", "", "br"],
              ["The empty tag used to draw a horizontal dividing rule across a web page is <_______>.", "FILL_BLANK", "hr", "hr, HR", "", "", "hr"],
              ["The anchor tag used to create hyperlinks connecting web pages in HTML is <_______>.", "FILL_BLANK", "a", "a, A", "", "", "a"],
              ["The attribute in the anchor tag <a> that specifies destination webpage URL is _______.", "FILL_BLANK", "href", "href, HREF", "", "", "href"]
            ]
          },
          {
            mNum: 3,
            q: [
              ["Which tag is used to embed pictures and images into an HTML webpage?", "MCQ", "<img>", "<picture>", "<src>", "<image>", "A"],
              ["Which attribute in the <img> tag specifies the file path or URL location of the image file?", "MCQ", "src=\"image.jpg\"", "href=\"image.jpg\"", "alt=\"image.jpg\"", "link=\"image.jpg\"", "A"],
              ["Which attribute in the <img> tag provides alternative descriptive text if the image fails to load?", "MCQ", "alt=\"description\"", "src=\"description\"", "title=\"description\"", "id=\"description\"", "A"],
              ["Which HTML tag renders enclosed text in bold weight?", "MCQ", "<b> or <strong>", "<i>", "<u>", "<p>", "A"],
              ["Which HTML heading tag produces the smallest heading size among standard headers?", "MCQ", "<h6>", "<h1>", "<h3>", "<h4>", "A"]
            ]
          },
          {
            mNum: 4,
            q: [
              ["A student writes: <a href=\"https://cbse.nic.in\">Visit CBSE</a>. What happens when the user clicks this text in a browser?", "MCQ", "The browser navigates directly to the CBSE official website", "The page is deleted", "The browser closes", "A video downloads", "A"],
              ["Which code snippet correctly displays an image named 'logo.png' with a width of 200 pixels?", "MCQ", "<img src=\"logo.png\" width=\"200\" alt=\"Logo\">", "<image href=\"logo.png\" size=\"200\">", "<pic src=\"logo.png\">", "<img link=\"logo.png\">", "A"],
              ["What file extension must be used when saving an HTML file in Notepad to open it in a web browser?", "MCQ", ".html or .htm", ".docx", ".xlsx", ".pptx", "A"],
              ["What is the correct structural hierarchy of an essential HTML5 webpage document?", "MCQ", "<!DOCTYPE html> -> <html> -> <head> & <body> -> </html>", "<body> -> <head> -> <html>", "<html> -> <body> -> <head>", "<title> -> <html> -> <body>", "A"],
              ["Which HTML element specifies the text displayed in the browser window title tab?", "MCQ", "<title>My School Page</title> placed inside <head>", "<h1>My School Page</h1>", "<meta title=\"My School Page\">", "<p>Title</p>", "A"]
            ]
          }
        ]
      },
      {
        num: 3,
        name: "CBSE 7 - Introduction to Python Programming & Variables",
        missions: [
          {
            mNum: 1,
            q: [
              ["Who created the Python programming language in 1991 at CWI in the Netherlands?", "MCQ", "Guido van Rossum", "James Gosling", "Dennis Ritchie", "Bjarne Stroustrup", "A"],
              ["Which built-in Python function is used to output text and variable values to the console screen?", "MCQ", "print()", "echo()", "display()", "write()", "A"],
              ["Which built-in Python function is used to accept keyboard user input from the console as a string?", "MCQ", "input()", "read()", "scan()", "get()", "A"],
              ["What character symbol is used to write single-line explanatory comments in Python code?", "MCQ", "# (Hash symbol)", "// (Double Slash)", "/* (Slash Star)", "-- (Double Dash)", "A"],
              ["Which data type in Python represents whole positive or negative numbers without decimals (e.g. 42, -5)?", "MCQ", "int (Integer)", "float", "str (String)", "bool (Boolean)", "A"]
            ]
          },
          {
            mNum: 2,
            q: [
              ["The data type in Python used for numbers with decimal fractions (e.g. 3.14) is _______.", "FILL_BLANK", "float", "float, Float", "", "", "float"],
              ["Text enclosed inside single or double quotation marks in Python has the data type _______ (str).", "FILL_BLANK", "string", "string, str", "", "", "string"],
              ["The arithmetic operator in Python used for exponentiation (power, e.g. 2 ** 3 = 8) is _______.", "FILL_BLANK", "**", "**", "", "", "**"],
              ["The arithmetic operator in Python that calculates the integer remainder of division is _______ (%).", "FILL_BLANK", "%", "%", "", "", "%"],
              ["The function used to convert a string of digits like '25' into an integer in Python is _______().", "FILL_BLANK", "int", "int, int()", "", "", "int"]
            ]
          },
          {
            mNum: 3,
            q: [
              ["What will be the output of the Python statement: print(10 + 20 * 2)?", "MCQ", "50 (Multiplication evaluated before addition)", "60", "40", "10202", "A"],
              ["What will be the output of: print(\"Hello \" * 3) in Python?", "MCQ", "Hello Hello Hello ", "Hello 3", "Error", "Hello * 3", "A"],
              ["What is the result of integer floor division: 17 // 5 in Python?", "MCQ", "3", "3.4", "2", "3.0", "A"],
              ["What is the result of modulus remainder operation: 14 % 4 in Python?", "MCQ", "2", "3", "3.5", "0", "A"],
              ["Which of the following is a valid variable name according to Python identifier rules?", "MCQ", "student_age", "2student", "student age", "class", "A"]
            ]
          },
          {
            mNum: 4,
            q: [
              ["A student writes: a = \"10\", b = \"20\", print(a + b). What will Python display?", "MCQ", "1020 (String concatenation)", "30", "Error", "10+20", "A"],
              ["To calculate the area of a circle in Python: r = 7, area = 3.14 * (r ** 2). What does (r ** 2) calculate?", "MCQ", "7 squared (7 * 7 = 49)", "7 multiplied by 2 (14)", "7 plus 2 (9)", "Square root of 7", "A"],
              ["Why does Python produce a ValueError if you run: int(\"apple\")?", "MCQ", "The string 'apple' does not contain numeric digits that can be converted to an integer", "Python does not support words", "int requires floating points", "Strings cannot be passed to functions", "A"],
              ["What function outputs the data type of an object in Python (e.g. type(5.5))?", "MCQ", "type() -> returns <class 'float'>", "typeof()", "datatype()", "check()", "A"],
              ["Write Python code to take a user's age as integer input. Which line is correct?", "MCQ", "age = int(input(\"Enter age: \"))", "age = input(int(\"Enter age: \"))", "age = read(\"Enter age\")", "age = scan(int)", "A"]
            ]
          }
        ]
      },
      {
        num: 4,
        name: "CBSE 7 - Python Conditionals & Cyber Threats Defense",
        missions: [
          {
            mNum: 1,
            q: [
              ["Which Python keyword begins a conditional decision-making branch statement?", "MCQ", "if", "check", "when", "loop", "A"],
              ["Which comparison operator checks whether two values are exactly equal in Python?", "MCQ", "== (Double Equals)", "= (Single Equals)", "!= (Not Equals)", "<=", "A"],
              ["Which comparison operator checks whether two values are NOT equal in Python?", "MCQ", "!=", "<>", "==", "=", "A"],
              ["What punctuation character MUST be placed at the end of an if/elif/else line in Python?", "MCQ", ": (Colon)", "; (Semicolon)", ". (Period)", "-> (Arrow)", "A"],
              ["What formatting mechanism does Python use to define a block of statements under an if condition?", "MCQ", "Indentation (leading whitespace/tab)", "Curly braces { }", "Parentheses ( )", "Square brackets [ ]", "A"]
            ]
          },
          {
            mNum: 2,
            q: [
              ["In Python, the multi-branch condition keyword between if and else is _______.", "FILL_BLANK", "elif", "elif, ELIF", "", "", "elif"],
              ["The logical operator in Python that returns True only if BOTH conditions are True is _______.", "FILL_BLANK", "and", "and, AND", "", "", "and"],
              ["The logical operator in Python that returns True if AT LEAST ONE condition is True is _______.", "FILL_BLANK", "or", "or, OR", "", "", "or"],
              ["Malware that disguises itself as legitimate useful software while secretly doing harm is a _______ Horse.", "FILL_BLANK", "Trojan", "Trojan, Trojan Horse", "", "", "Trojan"],
              ["Malware that self-replicates and spreads automatically across networks without human action is a computer _______.", "FILL_BLANK", "Worm", "Worm", "", "", "Worm"]
            ]
          },
          {
            mNum: 3,
            q: [
              ["What is the output of: x = 15; if x > 10: print(\"High\") else: print(\"Low\")?", "MCQ", "High", "Low", "15", "Error", "A"],
              ["What is the output of: print(5 > 3 and 10 < 4) in Python?", "MCQ", "False (Because 10 < 4 is False)", "True", "None", "Error", "A"],
              ["What is the output of: print(5 > 3 or 10 < 4) in Python?", "MCQ", "True (Because 5 > 3 is True)", "False", "None", "Error", "A"],
              ["What type of malware secretly monitors user keystrokes, passwords, and browsing habits to send to attackers?", "MCQ", "Spyware / Keylogger", "Adware", "Screen Saver", "Device Driver", "A"],
              ["What destructive malware encrypts victim files and demands ransom money to decrypt them?", "MCQ", "Ransomware", "Worm", "Cookie", "Firewall", "A"]
            ]
          },
          {
            mNum: 4,
            q: [
              ["A student writes Python code to check if a number is even or odd: if num % 2 == 0: print(\"Even\"). What does num % 2 calculate?", "MCQ", "The remainder when divided by 2 (0 indicates even numbers)", "Half of the number", "num multiplied by 2", "num squared", "A"],
              ["What will this code print: marks = 85; if marks >= 90: print('A') elif marks >= 80: print('B') else: print('C')?", "MCQ", "B", "A", "C", "A and B", "A"],
              ["Why is an indentation error (IndentationError) triggered in Python?", "MCQ", "Inconsistent or missing whitespace spaces inside a code block", "Using too many variables", "Printing numbers", "Using comments", "A"],
              ["How can computer users protect their systems against emerging zero-day malware threats?", "MCQ", "Keep OS and Antivirus updated, avoid downloading pirated software, enable firewall", "Turn off password security", "Click all email attachments", "Disable antivirus", "A"],
              ["What is the legal offense of creating fake social media profiles to defame and intimidate someone called?", "MCQ", "Cyber Impersonation / Cyberbullying (IT Act Violations)", "Fair Use", "Creative Commons", "Open Source", "A"]
            ]
          }
        ]
      }
    ]
  },

  // ========================== CBSE CLASS 8 ==========================
  {
    board: "CBSE",
    classLevel: 8,
    unitName: "UNIT 1 – ADVANCED WEB, PYTHON LOOPS, DBMS AND AI",
    chapters: [
      {
        num: 1,
        name: "CBSE 8 - Advanced HTML5 Lists, Tables and CSS Styling",
        missions: [
          {
            mNum: 1,
            q: [
              ["Which HTML tag creates a numbered ordered list?", "MCQ", "<ol>", "<ul>", "<li>", "<dl>", "A"],
              ["Which HTML tag creates a bulleted unordered list?", "MCQ", "<ul>", "<ol>", "<list>", "<bullet>", "A"],
              ["Which tag defines an individual item within an ordered or unordered list in HTML?", "MCQ", "<li>", "<item>", "<ul>", "<dt>", "A"],
              ["What does CSS stand for in web styling?", "MCQ", "Cascading Style Sheets", "Creative Style System", "Computer Style Structure", "Colorful Sheet Styling", "A"],
              ["Which HTML tag defines a table in a webpage?", "MCQ", "<table>", "<tab>", "<tr>", "<td>", "A"]
            ]
          },
          {
            mNum: 2,
            q: [
              ["In an HTML table, each horizontal table row is defined using the <_______> tag.", "FILL_BLANK", "tr", "tr, TR", "", "", "tr"],
              ["In an HTML table, a standard data cell is defined using the <_______> tag.", "FILL_BLANK", "td", "td, TD", "", "", "td"],
              ["In an HTML table, a bold centered header cell is defined using the <_______> tag.", "FILL_BLANK", "th", "th, TH", "", "", "th"],
              ["The CSS property used to change text color is _______.", "FILL_BLANK", "color", "color", "", "", "color"],
              ["The CSS property used to change page background color is _______-color.", "FILL_BLANK", "background", "background", "", "", "background"]
            ]
          },
          {
            mNum: 3,
            q: [
              ["Which CSS property specifies the font face family of text (e.g. Arial, Roboto)?", "MCQ", "font-family", "font-weight", "text-font", "font-style", "A"],
              ["Which CSS property specifies the size of text (e.g. 16px, 1.2rem)?", "MCQ", "font-size", "text-size", "font-scale", "size", "A"],
              ["Which HTML table attribute merges multiple adjacent columns into one wide cell?", "MCQ", "colspan=\"2\"", "rowspan=\"2\"", "cellmerge", "span", "A"],
              ["Which HTML table attribute merges multiple adjacent rows into one tall cell?", "MCQ", "rowspan=\"2\"", "colspan=\"2\"", "rowmerge", "merge", "A"],
              ["Which HTML tag is used to write internal CSS styles inside the <head> section?", "MCQ", "<style>", "<css>", "<script>", "<link>", "A"]
            ]
          },
          {
            mNum: 4,
            q: [
              ["A student writes CSS: h1 { color: #e74c3c; text-align: center; }. What will this rule do?", "MCQ", "Makes all <h1> headings red color and centered horizontally", "Deletes <h1> headings", "Makes headings italic and right-aligned", "Changes background to black", "A"],
              ["You want to create a nested list of computer components with sub-bullets. Which structure is valid?", "MCQ", "<ul><li>Hardware<ul><li>CPU</li><li>RAM</li></ul></li></ul>", "<ol><list>Hardware</list></ol>", "<ul><ol><li>Hardware</li></ol></ul>", "<li><ul>Hardware</ul></li>", "A"],
              ["How can you link an external CSS file named 'style.css' to your HTML document?", "MCQ", "<link rel=\"stylesheet\" href=\"style.css\">", "<style src=\"style.css\">", "<css link=\"style.css\">", "<script href=\"style.css\">", "A"],
              ["Which CSS property adds empty breathing space inside the border of a box?", "MCQ", "padding", "margin", "border-width", "outline", "A"],
              ["Which CSS property adds empty space outside around the border of an element?", "MCQ", "margin", "padding", "border-radius", "box-shadow", "A"]
            ]
          }
        ]
      },
      {
        num: 2,
        name: "CBSE 8 - Python Iterations, For Loops and While Loops",
        missions: [
          {
            mNum: 1,
            q: [
              ["Which Python loop is used to iterate over a sequence of numbers or collection items?", "MCQ", "for loop", "switch loop", "repeat loop", "do loop", "A"],
              ["Which built-in Python function generates a sequence of immutable integers (e.g. range(1, 6))?", "MCQ", "range()", "sequence()", "generate()", "numbers()", "A"],
              ["What sequence of numbers does range(5) generate in Python?", "MCQ", "0, 1, 2, 3, 4 (5 is excluded)", "1, 2, 3, 4, 5", "0, 1, 2, 3, 4, 5", "5, 4, 3, 2, 1", "A"],
              ["What sequence of numbers does range(2, 10, 2) generate in Python?", "MCQ", "2, 4, 6, 8 (Starts at 2, steps by 2, stops before 10)", "2, 3, 4, 5, 6, 7, 8, 9, 10", "2, 4, 6, 8, 10", "0, 2, 4, 6, 8", "A"],
              ["Which Python keyword instantly terminates and breaks out of the innermost running loop?", "MCQ", "break", "continue", "pass", "exit", "A"]
            ]
          },
          {
            mNum: 2,
            q: [
              ["The keyword in Python used to skip the rest of the current iteration and jump to the next cycle is _______.", "FILL_BLANK", "continue", "continue, CONTINUE", "", "", "continue"],
              ["A loop that executes repeatedly as long as a specified condition remains True is a _______ loop.", "FILL_BLANK", "while", "while, While", "", "", "while"],
              ["A variable used inside a loop to accumulate and store running totals is called an _______.", "FILL_BLANK", "accumulator", "accumulator, Accumulator", "", "", "accumulator"],
              ["In range(start, stop, step), the parameter that specifies increment between numbers is _______.", "FILL_BLANK", "step", "step, Step", "", "", "step"],
              ["A loop placed entirely inside the body of another loop is called a _______ loop.", "FILL_BLANK", "nested", "nested, Nested", "", "", "nested"]
            ]
          },
          {
            mNum: 3,
            q: [
              ["What will be printed by: for i in range(1, 4): print(i * 2, end=' ')?", "MCQ", "2 4 6 ", "2 4 6 8 ", "1 2 3 ", "2 3 4 ", "A"],
              ["What will be the value of total after: total = 0; for i in range(1, 5): total += i?", "MCQ", "10 (1+2+3+4 = 10)", "15", "5", "0", "A"],
              ["How many times does this while loop execute: count = 0; while count < 3: count += 1?", "MCQ", "3 times", "4 times", "2 times", "Infinite times", "A"],
              ["What happens if a while loop condition never becomes False (e.g. while True)?", "MCQ", "It results in an Infinite Loop and never terminates automatically", "It causes a syntax error", "It runs once and deletes the file", "It automatically stops in 10 seconds", "A"],
              ["What will this code print: for x in [10, 20, 30]: if x == 20: break; print(x)?", "MCQ", "10", "10 20", "10 20 30", "Nothing", "A"]
            ]
          },
          {
            mNum: 4,
            q: [
              ["A student writes a Python script to print the multiplication table of 7 from 1 to 10. Which loop header is correct?", "MCQ", "for i in range(1, 11): print(7 * i)", "for i in range(1, 10): print(7 * i)", "while i < 10: print(7)", "for 7 in range(10): print(i)", "A"],
              ["What will this code print: for i in range(1, 6): if i == 3: continue; print(i, end=' ')?", "MCQ", "1 2 4 5  (3 is skipped)", "1 2 3 4 5 ", "1 2 ", "3 4 5 ", "A"],
              ["How to calculate the factorial of 5 (5! = 5*4*3*2*1) using a Python for loop?", "MCQ", "fact = 1; for i in range(1, 6): fact *= i", "fact = 0; for i in range(1, 6): fact += i", "fact = 5 * 5", "fact = range(5)", "A"],
              ["In nested loops: for i in range(3): for j in range(2): print('*', end=''). How many asterisks are printed?", "MCQ", "6 asterisks (3 * 2 = 6)", "5 asterisks", "3 asterisks", "2 asterisks", "A"],
              ["What is the key difference between a for loop and a while loop in Python?", "MCQ", "For loop iterates over a predetermined sequence; While loop continues based on a condition", "For loop cannot use variables", "While loop is only for text", "There is no difference", "A"]
            ]
          }
        ]
      },
      {
        num: 3,
        name: "CBSE 8 - Relational Database Management System (RDBMS) Concepts",
        missions: [
          {
            mNum: 1,
            q: [
              ["What does DBMS stand for in computer data management?", "MCQ", "Database Management System", "Data Binary Management Software", "Digital Business Memory Storage", "Direct Base Main System", "A"],
              ["What is an organized collection of related data stored electronically in a structured format?", "MCQ", "Database", "Spreadsheet Macro", "Operating System", "Web Server", "A"],
              ["In a relational database table (RDBMS), what is a single horizontal row representing an entity called?", "MCQ", "Record / Tuple", "Field / Attribute", "Key", "Schema", "A"],
              ["In a database table, what is a single vertical column holding a specific data property called?", "MCQ", "Field / Attribute", "Tuple", "Record", "Index", "A"],
              ["Which field in a database table uniquely identifies every record without any duplicates or NULLs?", "MCQ", "Primary Key", "Foreign Key", "Secondary Key", "Composite Key", "A"]
            ]
          },
          {
            mNum: 2,
            q: [
              ["A field in one table that links and refers to the Primary Key of another table is a _______ Key.", "FILL_BLANK", "Foreign", "Foreign, Foreign key", "", "", "Foreign"],
              ["Unnecessary and unwanted duplication of the same data across multiple files is called Data _______.", "FILL_BLANK", "Redundancy", "Redundancy", "", "", "Redundancy"],
              ["The state where multiple copies of data conflict and do not match each other is Data _______.", "FILL_BLANK", "Inconsistency", "Inconsistency", "", "", "Inconsistency"],
              ["The number of attributes (columns) in a relation/table is called the _______ of the relation.", "FILL_BLANK", "Degree", "Degree", "", "", "Degree"],
              ["The number of tuples (rows) in a relation/table is called the _______ of the relation.", "FILL_BLANK", "Cardinality", "Cardinality", "", "", "Cardinality"]
            ]
          },
          {
            mNum: 3,
            q: [
              ["Which of the following is a widely used Relational Database Management System (RDBMS)?", "MCQ", "MySQL / PostgreSQL", "MS Word", "Google Chrome", "Adobe Reader", "A"],
              ["What language is the international standard used to query, insert, and manage relational databases?", "MCQ", "SQL (Structured Query Language)", "HTML", "CSS", "Assembly", "A"],
              ["What does NULL represent when stored in a database field?", "MCQ", "Missing, unknown, or unassigned data value", "Zero (0)", "A blank space ' '", "Negative infinity", "A"],
              ["If a table contains 5 columns and 20 rows, what is its Degree and Cardinality?", "MCQ", "Degree = 5, Cardinality = 20", "Degree = 20, Cardinality = 5", "Degree = 100, Cardinality = 1", "Degree = 1, Cardinality = 100", "A"],
              ["Which candidate key is chosen by the database designer as the primary identifier for a table?", "MCQ", "Primary Key", "Alternate Key", "Foreign Key", "Foreign Index", "A"]
            ]
          },
          {
            mNum: 4,
            q: [
              ["A school database table 'Students' contains fields: RollNo, StudentName, Class, Phone. Which field is the best choice for Primary Key?", "MCQ", "RollNo (Unique for every student)", "StudentName (Two students can have the same name)", "Class (Many students share the same class)", "Phone (Siblings share phone number)", "A"],
              ["Why is storing data in an RDBMS superior to maintaining separate paper ledgers or plain text files?", "MCQ", "Reduces data redundancy, ensures data consistency, provides fast search, and secures data", "Uses more paper", "Requires no computers", "Slows down operations", "A"],
              ["In an e-commerce database, an 'Orders' table stores CustomerID to look up customer details in 'Customers' table. What role does CustomerID play in 'Orders'?", "MCQ", "Foreign Key", "Primary Key of Orders", "Redundant Column", "Index Only", "A"],
              ["What constraint prevents entering duplicate values into a table column?", "MCQ", "UNIQUE Constraint / PRIMARY KEY", "NOT NULL only", "DEFAULT constraint", "CHECK constraint only", "A"],
              ["A database designer needs to ensure an 'Age' column never accepts negative numbers. Which constraint accomplishes this?", "MCQ", "CHECK (Age >= 0)", "NOT NULL", "FOREIGN KEY", "PRIMARY KEY", "A"]
            ]
          }
        ]
      },
      {
        num: 4,
        name: "CBSE 8 - Computer Networks and Introduction to Artificial Intelligence",
        missions: [
          {
            mNum: 1,
            q: [
              ["What type of network connects computers within a small localized area like a single room, school, or office?", "MCQ", "LAN (Local Area Network)", "WAN (Wide Area Network)", "MAN (Metropolitan Area Network)", "PAN (Personal Area Network)", "A"],
              ["What type of computer network spans across cities, countries, or the entire globe (e.g. the Internet)?", "MCQ", "WAN (Wide Area Network)", "LAN", "PAN", "WLAN", "A"],
              ["In which network topology are all client nodes connected directly to a central hub or switch?", "MCQ", "Star Topology", "Bus Topology", "Ring Topology", "Mesh Topology", "A"],
              ["In which network topology are all devices connected along a single continuous central backbone cable?", "MCQ", "Bus Topology", "Star Topology", "Tree Topology", "Ring Topology", "A"],
              ["What does AI stand for in modern computing science?", "MCQ", "Artificial Intelligence", "Automated Information", "Advanced Internet", "Application Interface", "A"]
            ]
          },
          {
            mNum: 2,
            q: [
              ["A network connecting personal devices like a smartphone and smartwatch via Bluetooth is a _______ Area Network (PAN).", "FILL_BLANK", "Personal", "Personal, PAN", "", "", "Personal"],
              ["The hardware device that connects local networks to the external internet by routing packets is a _______.", "FILL_BLANK", "Router", "Router", "", "", "Router"],
              ["The domain of AI that enables computers to interpret, understand, and process human text and speech is _______ (Natural Language Processing).", "FILL_BLANK", "NLP", "NLP, Natural Language Processing", "", "", "NLP"],
              ["The domain of AI that enables machines to identify, process, and analyze visual images and video is Computer _______.", "FILL_BLANK", "Vision", "Vision", "", "", "Vision"],
              ["The branch of AI where machines learn and improve from experience and data without explicit programming is _______ Learning.", "FILL_BLANK", "Machine", "Machine, Machine Learning", "", "", "Machine"]
            ]
          },
          {
            mNum: 3,
            q: [
              ["What unique numerical 32-bit or 128-bit address identifies every device connected to the internet?", "MCQ", "IP Address (Internet Protocol Address)", "MAC Address", "Port Number", "URL", "A"],
              ["What unique permanent hardware identifier is burned into every Network Interface Card (NIC)?", "MCQ", "MAC Address (Media Access Control)", "IP Address", "Subnet Mask", "DNS Name", "A"],
              ["What server translates human-friendly domain names (like www.google.com) into numerical IP addresses?", "MCQ", "DNS Server (Domain Name System)", "DHCP Server", "FTP Server", "Proxy Server", "A"],
              ["Which AI application recognizes faces in photos and unlocks modern smartphones securely?", "MCQ", "Computer Vision & Facial Recognition", "Speech Synthesizer", "Spell Checker", "Disk Defragmenter", "A"],
              ["What virtual conversational AI agent communicates with users via text or voice in customer service?", "MCQ", "Chatbot / Conversational AI", "Firewall", "Operating System", "Compiler", "A"]
            ]
          },
          {
            mNum: 4,
            q: [
              ["A school is setting up a new computer lab with 30 computers. If one computer fails in a Star topology, what happens to the others?", "MCQ", "All other 29 computers continue operating normally without interruption", "The entire network crashes", "The server catches fire", "All cables must be replaced", "A"],
              ["Autonomous self-driving cars use cameras, radar, and AI models to detect pedestrians and street signs in real time. Which AI domain is this?", "MCQ", "Computer Vision and Real-time Machine Learning", "Spreadsheet Macro", "Word Processor", "File Compression", "A"],
              ["What ethical concern arises when training AI models on biased, non-representative historical datasets?", "MCQ", "AI model produces unfair, discriminatory, or biased decisions (Algorithmic Bias)", "The computer runs out of RAM", "The monitor color fades", "Internet speed drops", "A"],
              ["Why is optical fiber cable superior to traditional copper twisted pair cable for high-speed internet backbones?", "MCQ", "Transmits data as pulses of light with ultra-high bandwidth and zero electromagnetic interference", "It uses radio waves", "It requires no cables", "It is made of wood", "A"],
              ["How do smart spam filters use Machine Learning to keep unwanted emails out of your inbox?", "MCQ", "They analyze patterns and keywords from millions of known spam emails to classify incoming mail", "Humans read every single email manually", "They delete all emails with attachments", "They block the entire internet", "A"]
            ]
          }
        ]
      }
    ]
  },

  // ========================== CBSE CLASS 9 ==========================
  {
    board: "CBSE",
    classLevel: 9,
    unitName: "UNIT 1 – INFORMATION TECHNOLOGY & PROGRAMMING FOUNDATIONS",
    chapters: [
      {
        num: 1,
        name: "CBSE 9 - Computer Systems Architecture and Memory Hierarchy",
        missions: [
          {
            mNum: 1,
            q: [
              ["Which computer architecture model describes CPU, memory, and I/O linked via shared system buses?", "MCQ", "Von Neumann Architecture", "Harvard Architecture", "Turing Machine", "Babbage Engine", "A"],
              ["What are the fastest internal storage locations located directly inside the CPU chip?", "MCQ", "Registers", "Cache Memory", "RAM", "Hard Disk", "A"],
              ["What high-speed buffer memory bridges the speed gap between the fast CPU and slower main RAM?", "MCQ", "Cache Memory", "Virtual Memory", "ROM", "Flash Drive", "A"],
              ["Which software acts as an intermediary interface between computer hardware and end-user programs?", "MCQ", "Operating System", "Compiler", "Device Driver", "Word Processor", "A"],
              ["Which type of software is designed to perform specific user tasks like creating presentations or editing photos?", "MCQ", "Application Software", "System Software", "Utility Software", "Firmware", "A"]
            ]
          },
          {
            mNum: 2,
            q: [
              ["The unit inside CPU that performs all arithmetic (+, -, *, /) and logical comparisons is the _______.", "FILL_BLANK", "ALU", "ALU, Arithmetic Logic Unit", "", "", "ALU"],
              ["The unit inside CPU that directs instruction fetch, decode, and execution flow is the _______ Unit.", "FILL_BLANK", "Control", "Control, Control Unit", "", "", "Control"],
              ["Software that translates high-level source code into machine code all at once before execution is a _______.", "FILL_BLANK", "Compiler", "Compiler", "", "", "Compiler"],
              ["Software that translates and executes high-level source code line-by-line is an _______.", "FILL_BLANK", "Interpreter", "Interpreter", "", "", "Interpreter"],
              ["Memory that simulated on the hard disk to extend available RAM capacity when physical RAM is full is _______ Memory.", "FILL_BLANK", "Virtual", "Virtual, Virtual memory", "", "", "Virtual"]
            ]
          },
          {
            mNum: 3,
            q: [
              ["Which open-source operating system kernel was created by Linus Torvalds in 1991?", "MCQ", "Linux", "Windows", "macOS", "MS-DOS", "A"],
              ["Which bus carries memory address pointers from the CPU to system components?", "MCQ", "Address Bus", "Data Bus", "Control Bus", "Power Bus", "A"],
              ["Which bus transmits actual data values bidirectionally between CPU, memory, and peripherals?", "MCQ", "Data Bus", "Address Bus", "Control Bus", "Clock Bus", "A"],
              ["What utility program rearranges fragmented non-contiguous file blocks on a hard disk to speed up read access?", "MCQ", "Disk Defragmenter", "Disk Cleanup", "Backup Utility", "Antivirus", "A"],
              ["What is permanent low-level firmware burned into hardware ROM chips called?", "MCQ", "Firmware", "Shareware", "Freeware", "Malware", "A"]
            ]
          },
          {
            mNum: 4,
            q: [
              ["A computer starts lagging severely when 15 heavy apps are opened simultaneously. What bottleneck is occurring?", "MCQ", "Physical RAM is exhausted, causing heavy swapping to slow Virtual Memory on disk (Thrashing)", "Monitor resolution is too high", "Keyboard buffer is full", "Speaker wire is loose", "A"],
              ["Why is Python classified as an Interpreted programming language?", "MCQ", "Python source code is translated and executed line-by-line at runtime by the Python Virtual Machine (PVM)", "It compiles directly to hardware circuits", "It only runs on supercomputers", "It has no syntax rules", "A"],
              ["What is the correct hierarchy of memory speed from fastest to slowest?", "MCQ", "Registers > L1/L2 Cache > RAM > SSD / HDD", "HDD > RAM > Cache > Registers", "RAM > Registers > HDD > Cache", "Cache > HDD > RAM > Registers", "A"],
              ["What open-source software license allows users to freely study, modify, and distribute software source code?", "MCQ", "GNU General Public License (GPL) / MIT License", "Proprietary Commercial License", "Copyright Restricted EULA", "Trialware License", "A"],
              ["Why does SSD (Solid State Drive) outperform traditional HDD (Hard Disk Drive) in boot speeds?", "MCQ", "SSDs use flash memory chips with zero moving mechanical parts and instant random access", "SSDs use magnetic spinning platters", "SSDs require cooling water", "SSDs have more cables", "A"]
            ]
          }
        ]
      },
      {
        num: 2,
        name: "CBSE 9 - Cyber Safety, Privacy & Digital Citizenship",
        missions: [
          {
            mNum: 1,
            q: [
              ["What is the total trail of data, posts, search queries, and photos left behind on the internet by an individual?", "MCQ", "Digital Footprint", "Browser Cache", "IP Address", "Cookie", "A"],
              ["What is a digital footprint created intentionally by posting photos, blogs, and public messages online called?", "MCQ", "Active Digital Footprint", "Passive Digital Footprint", "Ghost Footprint", "Anonymous Trail", "A"],
              ["What is a digital footprint created unintentionally through IP logs, cookies, and website tracking called?", "MCQ", "Passive Digital Footprint", "Active Digital Footprint", "Malware Footprint", "Public Profile", "A"],
              ["What legal Indian act enacted in 2000 governs cyber law, electronic commerce, and cyber crimes in India?", "MCQ", "Information Technology Act 2000 (IT Act 2000)", "Indian Penal Code 1860", "Companies Act", "Consumer Protection Act", "A"],
              ["What is the practice of repeatedly stalking, threatening, or harassing someone using digital devices called?", "MCQ", "Cyberstalking", "Netiquette", "Ethical Hacking", "Cloud Computing", "A"]
            ]
          },
          {
            mNum: 2,
            q: [
              ["Small text files stored on your computer by websites to remember user preferences and session data are _______.", "FILL_BLANK", "Cookies", "Cookies, Cookie", "", "", "Cookies"],
              ["The legal right granted to an author, artist, or programmer protecting original creations is called _______.", "FILL_BLANK", "Copyright", "Copyright", "", "", "Copyright"],
              ["A distinct symbol, word, or logo legally registered to represent a company or product brand is a _______.", "FILL_BLANK", "Trademark", "Trademark", "", "", "Trademark"],
              ["The practice of gaining unauthorized access to computer systems and private networks is called _______.", "FILL_BLANK", "Hacking", "Hacking", "", "", "Hacking"],
              ["A security expert who hacks systems with legal permission to find vulnerabilities and fix them is an _______ Hacker.", "FILL_BLANK", "Ethical", "Ethical, Ethical hacker", "", "", "Ethical"]
            ]
          },
          {
            mNum: 3,
            q: [
              ["Which of the following is an example of strong, positive digital citizenship?", "MCQ", "Respecting copyright, protecting privacy, being kind online, and reporting cyber harassment", "Sharing pirated movie links", "Posting hurtful rumors anonymously", "Using simple passwords", "A"],
              ["What is the legal doctrine allowing limited use of copyrighted material without permission for education or news commentary?", "MCQ", "Fair Use / Fair Dealing", "Plagiarism", "Patent Infringement", "Piracy", "A"],
              ["What Indian government portal enables citizens to report cyber crimes, cyber fraud, and online abuse online?", "MCQ", "cybercrime.gov.in", "incometax.gov.in", "cbse.nic.in", "uidai.gov.in", "A"],
              ["What protocol encrypts sensitive payment transactions across web connections?", "MCQ", "TLS / HTTPS", "Plain HTTP", "FTP", "Telnet", "A"],
              ["What should you do before downloading and using an image found on Google for your published website?", "MCQ", "Check licensing rights or use Creative Commons / royalty-free verified sources with attribution", "Copy image without checking", "Claim you drew the image", "Delete copyright watermark", "A"]
            ]
          },
          {
            mNum: 4,
            q: [
              ["A student copies three entire paragraphs from Wikipedia into their science project without quotes or citations. What academic offense is this?", "MCQ", "Plagiarism (Intellectual Property Violation)", "Fair Use", "Creative Commons attribution", "Original research", "A"],
              ["You receive a message on social media from an unknown user asking you to share a one-time OTP sent to your phone. What should you do?", "MCQ", "Never share OTP with anyone under any circumstances", "Share OTP immediately", "Post OTP publicly", "Forward message to all friends", "A"],
              ["Why do companies collect browsing cookies across multiple websites?", "MCQ", "To build behavioral profiles for targeted digital advertising and analytics", "To speed up your CPU clock", "To format your hard drive", "To download software updates", "A"],
              ["Which password choice provides the highest resistance against brute-force dictionary attacks?", "MCQ", "K9#mQ!98$xLp2v#", "password2024", "Nirmal123", "qwertyuiop", "A"],
              ["Under Section 66D of the Indian IT Act 2000, what is the penalty for cheating by personation using a computer resource?", "MCQ", "Imprisonment up to 3 years and fine up to 1 Lakh Rupees", "No penalty", "Suspension of email only", "Warning letter", "A"]
            ]
          }
        ]
      },
      {
        num: 3,
        name: "CBSE 9 - Digital Documentation & Electronic Spreadsheets",
        missions: [
          {
            mNum: 1,
            q: [
              ["What feature in word processors allows sending personalized letters or invitations to hundreds of recipients using a single template?", "MCQ", "Mail Merge", "WordArt", "Track Changes", "Spell Check", "A"],
              ["In Mail Merge, what document holds the main letter text that remains identical for all recipients?", "MCQ", "Main Document", "Data Source", "Merged Document", "Envelope Template", "A"],
              ["In Mail Merge, what file contains the list of recipient names, addresses, and phone numbers?", "MCQ", "Data Source", "Main Document", "Form Letter", "Word Template", "A"],
              ["What placeholders in the main document receive dynamic values from the data source during Mail Merge?", "MCQ", "Merge Fields (e.g. «FirstName»)", "Hyperlinks", "Footnotes", "Bookmarks", "A"],
              ["What feature in MS Word automatically generates a formatted list of chapter headings with page numbers?", "MCQ", "Table of Contents (TOC)", "Header and Footer", "Footnote List", "Index Marker", "A"]
            ]
          },
          {
            mNum: 2,
            q: [
              ["A set of predefined formatting styles (font, size, color) applied with one click in Word is a _______.", "FILL_BLANK", "Style", "Style, Styles", "", "", "Style"],
              ["The tool in word processors that tracks all edits, insertions, and deletions made by editors is _______ Changes.", "FILL_BLANK", "Track", "Track, Track Changes", "", "", "Track"],
              ["An electronic spreadsheet formula that links to cells on another worksheet uses 3D Cell _______.", "FILL_BLANK", "Reference", "Reference, Referencing", "", "", "Reference"],
              ["In Excel, the analysis tool used to find the exact input value required to achieve a target goal is Goal _______.", "FILL_BLANK", "Seek", "Seek, Goal Seek", "", "", "Seek"],
              ["To lock the top row of an Excel spreadsheet so it stays visible while scrolling down, use _______ Panes.", "FILL_BLANK", "Freeze", "Freeze, Freeze Panes", "", "", "Freeze"]
            ]
          },
          {
            mNum: 3,
            q: [
              ["Which Excel feature allows consolidating data from multiple sheets into one summary worksheet?", "MCQ", "Consolidate Data", "AutoFill", "Merge Cells", "Conditional Formatting", "A"],
              ["What dialog box in Excel allows creating custom 'What-If' scenarios with variable assumptions?", "MCQ", "Scenario Manager", "Formula Bar", "Data Validation", "Sort & Filter", "A"],
              ["Which feature in Excel restricts user cell input to specific valid values (e.g. integer between 1 and 100)?", "MCQ", "Data Validation", "Conditional Formatting", "AutoCorrect", "Goal Seek", "A"],
              ["What error message appears in an Excel cell when a formula divides a number by zero?", "MCQ", "#DIV/0!", "#VALUE!", "#REF!", "#NAME?", "A"],
              ["What error message appears when a formula references a cell that has been deleted?", "MCQ", "#REF!", "#NULL!", "#N/A", "#NUM!", "A"]
            ]
          },
          {
            mNum: 4,
            q: [
              ["A school principal needs to print report cards for 1,200 students with individual marks and remarks. Which tool accomplishes this efficiently?", "MCQ", "Mail Merge combining Word template with Excel marks data source", "Typing all 1,200 cards manually one by one", "Copying and pasting 1,200 times", "Using MS Paint", "A"],
              ["A business manager wants to determine what unit price they must set in cell B1 to achieve a target profit of 5,00,000 in cell C10. Which Excel tool should they run?", "MCQ", "Goal Seek (What-If Analysis)", "Spell Check", "Freeze Panes", "AutoSum", "A"],
              ["Why should document authors use Heading 1, Heading 2 styles instead of manually increasing font sizes?", "MCQ", "Enables automatic Table of Contents generation, navigation pane indexing, and accessibility", "Makes the file size smaller", "Increases printer speed", "Changes language to French", "A"],
              ["What Excel formula correctly sums range B2:B10 only if corresponding cell in range A2:A10 equals 'Electronics'?", "MCQ", "=SUMIF(A2:A10, \"Electronics\", B2:B10)", "=IFSUM(A2:A10=\"Electronics\", B2:B10)", "=SUM(A2:A10, B2:B10)", "=COUNTIF(A2:A10, \"Electronics\")", "A"],
              ["How can an organization ensure form respondents enter only valid 10-digit mobile phone numbers in an Excel column?", "MCQ", "Apply Data Validation: Allow Whole Number -> Text Length equal to 10", "Use red font color", "Merge all cells", "Protect worksheet without password", "A"]
            ]
          }
        ]
      },
      {
        num: 4,
        name: "CBSE 9 - Python Sequences & List Data Structures",
        missions: [
          {
            mNum: 1,
            q: [
              ["What data structure in Python is an ordered, mutable collection enclosed in square brackets [ ]?", "MCQ", "List", "Tuple", "Set", "Dictionary", "A"],
              ["What is the index of the very first element in a Python list (e.g. fruits = [\"apple\", \"banana\"])?", "MCQ", "0 (Zero-indexed)", "1", "-1", "First", "A"],
              ["What index in Python accesses the last element of a list using negative indexing?", "MCQ", "-1", "0", "-0", "last", "A"],
              ["Which built-in Python function returns the total number of items in a list or characters in a string?", "MCQ", "len()", "count()", "size()", "length()", "A"],
              ["Which list method appends a new item to the end of an existing Python list?", "MCQ", "list.append(item)", "list.add(item)", "list.insert(item)", "list.push(item)", "A"]
            ]
          },
          {
            mNum: 2,
            q: [
              ["The list method used to insert an item at a specific index position is list._______(index, item).", "FILL_BLANK", "insert", "insert", "", "", "insert"],
              ["The list method that removes and returns the last item (or item at index) is list._______().", "FILL_BLANK", "pop", "pop", "", "", "pop"],
              ["The list method used to sort elements in ascending alphabetical or numerical order in-place is list._______().", "FILL_BLANK", "sort", "sort", "", "", "sort"],
              ["Extracting a sub-portion of a list using index syntax list[start:stop] is called list _______.", "FILL_BLANK", "slicing", "slicing, Slicing", "", "", "slicing"],
              ["Checking whether an element exists inside a list uses the membership operator _______.", "FILL_BLANK", "in", "in, IN", "", "", "in"]
            ]
          },
          {
            mNum: 3,
            q: [
              ["What is the output of: nums = [10, 20, 30, 40, 50]; print(nums[1:4]) in Python?", "MCQ", "[20, 30, 40] (Index 1 to 3; index 4 excluded)", "[10, 20, 30, 40]", "[20, 30, 40, 50]", "[10, 20, 30]", "A"],
              ["What is the output of: items = [1, 2, 3]; items.append(4); print(items)?", "MCQ", "[1, 2, 3, 4]", "[4, 1, 2, 3]", "[1, 2, 3]", "Error", "A"],
              ["What is the result of string replication: print(\"Python\" * 2)?", "MCQ", "PythonPython", "Python 2", "Python*2", "Error", "A"],
              ["What will be printed by: print(\"c\" in \"cbse\")?", "MCQ", "True", "False", "None", "Error", "A"],
              ["What is the output of: a = [1, 2]; b = [3, 4]; print(a + b)?", "MCQ", "[1, 2, 3, 4] (List concatenation)", "[4, 6]", "[[1,2],[3,4]]", "Error", "A"]
            ]
          },
          {
            mNum: 4,
            q: [
              ["A student writes Python code to calculate the sum of all elements in a list: scores = [80, 90, 70]. What function calculates this directly?", "MCQ", "sum(scores) -> returns 240", "total(scores)", "add(scores)", "count(scores)", "A"],
              ["What will this code output: numbers = [5, 2, 9, 1]; numbers.sort(); print(numbers)?", "MCQ", "[1, 2, 5, 9]", "[9, 5, 2, 1]", "[5, 2, 9, 1]", "Error", "A"],
              ["How to iterate over every item in a list and print it: fruits = [\"apple\", \"banana\", \"cherry\"]?", "MCQ", "for fruit in fruits: print(fruit)", "for i in fruits: print(fruits)", "while fruits: print()", "loop fruits -> print", "A"],
              ["What is the output of: text = \"Computer\"; print(text[-1])?", "MCQ", "'r'", "'C'", "'e'", "'t'", "A"],
              ["Why does attempting to modify a character in a string (e.g. s = 'hello'; s[0] = 'H') produce a TypeError?", "MCQ", "Strings are immutable data types in Python and cannot be altered in-place", "Strings do not support indexing", "Square brackets are only for lists", "Python has no string type", "A"]
            ]
          }
        ]
      }
    ]
  },

  // ========================== CBSE CLASS 10 ==========================
  {
    board: "CBSE",
    classLevel: 10,
    unitName: "UNIT 1 – ADVANCED WEB, RDBMS, SQL AND ARTIFICIAL INTELLIGENCE",
    chapters: [
      {
        num: 1,
        name: "CBSE 10 - Advanced Web Development: HTML5 Forms & CSS Box Model",
        missions: [
          {
            mNum: 1,
            q: [
              ["Which HTML5 tag is used to create interactive user input forms for collecting registration and feedback data?", "MCQ", "<form> ... </form>", "<input>", "<fieldset>", "<textbox>", "A"],
              ["Which <input> type attribute renders a masked single-line field hiding entered characters with dots?", "MCQ", "type=\"password\"", "type=\"text\"", "type=\"hidden\"", "type=\"mask\"", "A"],
              ["Which <input> type allows users to select ONLY ONE option from a mutually exclusive group of choices?", "MCQ", "type=\"radio\"", "type=\"checkbox\"", "type=\"select\"", "type=\"button\"", "A"],
              ["Which <input> type allows users to select multiple independent options simultaneously?", "MCQ", "type=\"checkbox\"", "type=\"radio\"", "type=\"toggle\"", "type=\"option\"", "A"],
              ["Which HTML tag creates a drop-down selection list menu in an interactive form?", "MCQ", "<select> with <option> tags", "<dropdown>", "<menu>", "<list>", "A"]
            ]
          },
          {
            mNum: 2,
            q: [
              ["The multi-line text input field used for comments and messages in an HTML form is <_______>.", "FILL_BLANK", "textarea", "textarea, TEXTAREA", "", "", "textarea"],
              ["The form attribute that specifies where submitted form data should be sent is _______=\"process.php\".", "FILL_BLANK", "action", "action", "", "", "action"],
              ["The HTTP method used to submit sensitive form data securely in the request body is method=\"_______\" (POST/GET).", "FILL_BLANK", "POST", "POST, post", "", "", "POST"],
              ["The HTML5 form validation attribute that forces a user to fill in an input before submission is _______.", "FILL_BLANK", "required", "required", "", "", "required"],
              ["In the CSS Box Model, the innermost area containing text and images is the _______ area.", "FILL_BLANK", "content", "content", "", "", "content"]
            ]
          },
          {
            mNum: 3,
            q: [
              ["What are the four concentric layers of the CSS Box Model from inside to outside?", "MCQ", "Content -> Padding -> Border -> Margin", "Margin -> Border -> Padding -> Content", "Content -> Border -> Padding -> Margin", "Padding -> Content -> Margin -> Border", "A"],
              ["Which CSS property is used to round the sharp corners of a box or button?", "MCQ", "border-radius", "border-corner", "box-round", "corner-radius", "A"],
              ["Which CSS property adds a drop-shadow elevation effect behind a card container?", "MCQ", "box-shadow", "text-shadow", "drop-shadow", "elevation", "A"],
              ["Which CSS display property creates modern responsive 1-dimensional flexbox layouts?", "MCQ", "display: flex;", "display: block;", "display: inline;", "display: table;", "A"],
              ["Which <input> type displays a clickable submit button that transmits form data to the server?", "MCQ", "type=\"submit\"", "type=\"button\"", "type=\"send\"", "type=\"go\"", "A"]
            ]
          },
          {
            mNum: 4,
            q: [
              ["A developer creates two radio buttons for Gender: <input type=\"radio\" name=\"gender\" value=\"M\"> and <input type=\"radio\" name=\"gender\" value=\"F\">. Why must both have the same 'name' attribute?", "MCQ", "Grouped name attribute ensures only ONE radio button can be selected at a time", "It makes the radio buttons circular", "It changes their color", "It sends both values at once", "A"],
              ["A web designer sets CSS: .card { width: 300px; padding: 20px; border: 5px solid black; box-sizing: border-box; }. What is the total rendered outer width of the card?", "MCQ", "300px (border-box includes padding and border within the declared width)", "350px", "325px", "260px", "A"],
              ["How to create an email input field in HTML5 that automatically validates valid '@' and domain formats?", "MCQ", "<input type=\"email\" name=\"usermail\" required>", "<input type=\"text\" format=\"email\">", "<input email=\"true\">", "<textbox type=\"mail\">", "A"],
              ["Which CSS rule centers a block-level container horizontally within its parent window?", "MCQ", "margin: 0 auto;", "padding: center;", "align: middle;", "float: center;", "A"],
              ["What is the purpose of the <label for=\"username\"> tag in web form accessibility?", "MCQ", "Links descriptive label text to the input field, expanding the clickable target area for users", "Styles the form in bold", "Submits the form automatically", "Encrypts the username", "A"]
            ]
          }
        ]
      },
      {
        num: 2,
        name: "CBSE 10 - Cyber Ethics, Open Source & Indian IT Act 2000",
        missions: [
          {
            mNum: 1,
            q: [
              ["What legal framework protects creations of the human mind such as inventions, software code, and literary works?", "MCQ", "Intellectual Property Rights (IPR)", "Criminal Procedure Code", "Consumer Rights", "Traffic Regulations", "A"],
              ["What exclusive legal right is granted to an inventor by the government to prevent others from commercially exploiting an invention for a set period?", "MCQ", "Patent", "Copyright", "Trademark", "Trade Secret", "A"],
              ["What open-source software license model allows software to be freely used, modified, and shared by anyone?", "MCQ", "FOSS (Free and Open Source Software)", "Proprietary Commercial EULA", "Shareware", "Adware", "A"],
              ["Which organization provides standardized public copyright licenses (CC BY, CC BY-SA) allowing flexible sharing of creative works?", "MCQ", "Creative Commons (CC)", "W3C", "IEEE", "ISO", "A"],
              ["What is commercial software whose source code is kept secret and copyrighted by a vendor called?", "MCQ", "Proprietary Software (e.g. MS Windows)", "Open Source Software", "Public Domain Software", "Freeware", "A"]
            ]
          },
          {
            mNum: 2,
            q: [
              ["Section _______ of the Indian IT Act 2000 penalizes hacking and unauthorized computer system tampering.", "FILL_BLANK", "66", "66, Section 66", "", "", "66"],
              ["Section 66E of the Indian IT Act 2000 prescribes severe punishment for the violation of individual _______.", "FILL_BLANK", "privacy", "privacy, Privacy", "", "", "privacy"],
              ["Cybersecurity principles ensuring confidentiality, integrity, and availability are known as the _______ Triad.", "FILL_BLANK", "CIA", "CIA, CIA Triad", "", "", "CIA"],
              ["The unauthorized copying, piracy, and distribution of copyrighted commercial software is Software _______.", "FILL_BLANK", "Piracy", "Piracy, piracy", "", "", "Piracy"],
              ["A computer program that appears genuine but secretly installs a backdoor for remote control is a _______.", "FILL_BLANK", "Trojan", "Trojan, Trojan Horse", "", "", "Trojan"]
            ]
          },
          {
            mNum: 3,
            q: [
              ["What is the practice of ethically disclosing security flaws to software vendors before public release called?", "MCQ", "Responsible Disclosure", "Zero-Day Exploit", "Black Hat Hacking", "DDoS Attack", "A"],
              ["What Indian government agency acts as the national agency for responding to computer security incidents?", "MCQ", "CERT-In (Indian Computer Emergency Response Team)", "ISRO", "NITI Aayog", "TRAI", "A"],
              ["What cyber attack overloads a targeted web server with millions of fake traffic requests to knock it offline?", "MCQ", "DDoS (Distributed Denial of Service) Attack", "Phishing", "Man-in-the-Middle", "SQL Injection", "A"],
              ["Which license allows sharing and adapting a work provided credit is given to the original creator?", "MCQ", "CC BY (Creative Commons Attribution)", "All Rights Reserved", "Commercial Patent", "Trade Secret", "A"],
              ["What security mechanism verifies digital document authenticity and sender identity using public key cryptography?", "MCQ", "Digital Signature", "Handwritten Signature", "Watermark", "Barcode", "A"]
            ]
          },
          {
            mNum: 4,
            q: [
              ["A developer wants to release their Python library so that any programmer can use, modify, and integrate it freely even into commercial apps. Which license should they choose?", "MCQ", "MIT License or Apache 2.0 License", "Closed Proprietary License", "Commercial Royalty License", "Trialware License", "A"],
              ["An employee secretly copies their company's proprietary client database and sells it to a competitor. What legal violations have been committed?", "MCQ", "Theft of Trade Secrets, Breach of Confidentiality, and Section 43/66 IT Act violations", "Fair Use", "Creative Commons sharing", "Open source distribution", "A"],
              ["How can websites protect user login sessions against Man-in-the-Middle (MITM) eavesdropping attacks?", "MCQ", "Enforce HTTPS encryption using valid SSL/TLS certificates across all routes", "Use plain text HTTP", "Disable passwords", "Enable public FTP", "A"],
              ["What is the primary objective of Digital Rights Management (DRM) technologies?", "MCQ", "To restrict unauthorized copying, redistribution, and playback of digital media and software", "To speed up video streaming", "To format computer memory", "To compress audio files", "A"],
              ["Why is downloading cracked software and games from torrent sites extremely dangerous for personal computers?", "MCQ", "Cracked binaries frequently contain hidden rootkits, cryptominers, and info-stealing Trojans", "It increases hard disk capacity", "It improves gaming speed", "It updates the BIOS", "A"]
            ]
          }
        ]
      },
      {
        num: 3,
        name: "CBSE 10 - Database Management System & SQL Queries",
        missions: [
          {
            mNum: 1,
            q: [
              ["Which category of SQL commands (like CREATE, ALTER, DROP) defines and modifies database structure/schema?", "MCQ", "DDL (Data Definition Language)", "DML (Data Manipulation Language)", "DCL (Data Control Language)", "TCL (Transaction Control Language)", "A"],
              ["Which category of SQL commands (like SELECT, INSERT, UPDATE, DELETE) manipulates and queries data records?", "MCQ", "DML (Data Manipulation Language)", "DDL (Data Definition Language)", "DCL (Data Control Language)", "VDL (View Definition Language)", "A"],
              ["Which SQL command is used to retrieve data records from one or more database tables?", "MCQ", "SELECT", "GET", "RETRIEVE", "FETCH", "A"],
              ["Which SQL clause is used to filter records and return only those that meet a specific boolean condition?", "MCQ", "WHERE", "HAVING", "FILTER", "CONDITION", "A"],
              ["Which SQL clause is used to sort the retrieved query result set in ascending or descending order?", "MCQ", "ORDER BY", "GROUP BY", "SORT BY", "ARRANGE BY", "A"]
            ]
          },
          {
            mNum: 2,
            q: [
              ["The SQL command used to insert a brand new row of data into a table is _______ INTO.", "FILL_BLANK", "INSERT", "INSERT, insert", "", "", "INSERT"],
              ["The SQL command used to modify existing data values in table records is _______.", "FILL_BLANK", "UPDATE", "UPDATE, update", "", "", "UPDATE"],
              ["The SQL command used to delete specific existing rows from a table is _______ FROM.", "FILL_BLANK", "DELETE", "DELETE, delete", "", "", "DELETE"],
              ["The SQL command used to create a brand new database table with specified columns and datatypes is _______ TABLE.", "FILL_BLANK", "CREATE", "CREATE, create", "", "", "CREATE"],
              ["The SQL keyword used to return only unique, non-duplicate values in a SELECT query is _______.", "FILL_BLANK", "DISTINCT", "DISTINCT, distinct", "", "", "DISTINCT"]
            ]
          },
          {
            mNum: 3,
            q: [
              ["Which SQL wildcard character represents zero, one, or multiple characters in a LIKE pattern match (e.g. 'A%')?", "MCQ", "% (Percent symbol)", "_ (Underscore)", "* (Asterisk)", "? (Question mark)", "A"],
              ["Which SQL wildcard character represents exactly ONE single character in a LIKE condition (e.g. '_a%')?", "MCQ", "_ (Underscore)", "% (Percent symbol)", "# (Hash)", "@ (At sign)", "A"],
              ["Which SQL keyword sorts result records from highest to lowest in an ORDER BY clause?", "MCQ", "DESC (Descending)", "ASC (Ascending)", "TOP", "DOWN", "A"],
              ["Which aggregate function in SQL calculates the arithmetic mean of numeric values in a column?", "MCQ", "AVG(column_name)", "MEAN(column_name)", "AVERAGE(column_name)", "SUM(column_name)", "A"],
              ["Which SQL clause groups rows having the same values into summary rows (e.g. find total salary per department)?", "MCQ", "GROUP BY", "ORDER BY", "COLLECT BY", "PARTITION", "A"]
            ]
          },
          {
            mNum: 4,
            q: [
              ["Write an SQL query to retrieve all columns for students who scored greater than 90 marks from table 'Student'. Which query is correct?", "MCQ", "SELECT * FROM Student WHERE Marks > 90;", "SELECT ALL Student WHERE Marks > 90;", "GET * FROM Student IF Marks > 90;", "FIND Student WHERE Marks > 90;", "A"],
              ["Write an SQL query to increase the fee by 500 for student with RollNo = 101. Which query is correct?", "MCQ", "UPDATE Student SET Fee = Fee + 500 WHERE RollNo = 101;", "MODIFY Student Fee = Fee + 500 WHERE RollNo = 101;", "CHANGE Student SET Fee = 500;", "INSERT INTO Student (Fee) VALUES (500);", "A"],
              ["What query deletes student record with RollNo = 105 from table 'Student'?", "MCQ", "DELETE FROM Student WHERE RollNo = 105;", "REMOVE Student WHERE RollNo = 105;", "DROP Student WHERE RollNo = 105;", "DELETE RollNo = 105 FROM Student;", "A"],
              ["What is the output of: SELECT COUNT(*) FROM Student WHERE Marks IS NULL;?", "MCQ", "Returns the total number of students whose marks are not recorded (NULL)", "Returns 0 always", "Causes a syntax error", "Deletes all NULL records", "A"],
              ["Why is omitting the WHERE clause in an UPDATE or DELETE statement dangerous in SQL?", "MCQ", "Without a WHERE clause, the command modifies or deletes EVERY single row in the entire table", "It locks the database permanently", "It causes a compile error", "It creates duplicate tables", "A"]
            ]
          }
        ]
      },
      {
        num: 4,
        name: "CBSE 10 - Python Functions & AI Project Cycle",
        missions: [
          {
            mNum: 1,
            q: [
              ["Which keyword is used to define a user-defined reusable function in Python?", "MCQ", "def", "function", "func", "define", "A"],
              ["What keyword is used inside a Python function to send back a computed result to the caller?", "MCQ", "return", "send", "give", "output", "A"],
              ["What are the 5 structured stages of the official AI Project Cycle in order?", "MCQ", "Problem Scoping -> Data Acquisition -> Data Exploration -> Modelling -> Evaluation", "Coding -> Testing -> Debugging -> Deploying -> Marketing", "Input -> Process -> Output -> Store -> Delete", "Data -> Model -> Code -> Game -> App", "A"],
              ["In the AI Project Cycle, which stage involves identifying the problem statement using the 4Ws canvas (Who, What, Where, Why)?", "MCQ", "Problem Scoping", "Data Acquisition", "Modelling", "Evaluation", "A"],
              ["In the AI Project Cycle, which stage involves collecting relevant, accurate datasets from reliable sources?", "MCQ", "Data Acquisition", "Data Exploration", "Problem Scoping", "Evaluation", "A"]
            ]
          },
          {
            mNum: 2,
            q: [
              ["In the AI Project Cycle, visualizing data with graphs and cleaning missing values is Data _______.", "FILL_BLANK", "Exploration", "Exploration", "", "", "Exploration"],
              ["A variable defined inside a Python function that exists only within that function has _______ scope.", "FILL_BLANK", "local", "local, Local", "", "", "local"],
              ["A variable defined outside all functions accessible throughout the whole Python file has _______ scope.", "FILL_BLANK", "global", "global, Global", "", "", "global"],
              ["In Machine Learning, learning from labeled training data containing both inputs and correct answers is _______ Learning.", "FILL_BLANK", "Supervised", "Supervised, supervised", "", "", "Supervised"],
              ["In Machine Learning, finding hidden patterns and clusters in unlabeled data without target answers is _______ Learning.", "FILL_BLANK", "Unsupervised", "Unsupervised, unsupervised", "", "", "Unsupervised"]
            ]
          },
          {
            mNum: 3,
            q: [
              ["What will be the output of: def square(n): return n * n; print(square(6))?", "MCQ", "36", "12", "6", "None", "A"],
              ["What is the output of a Python function that finishes executing without an explicit return statement?", "MCQ", "None", "0", "False", "Error", "A"],
              ["Which Machine Learning evaluation metric measures the proportion of total correct predictions out of all predictions?", "MCQ", "Accuracy", "Precision", "Recall", "F1 Score", "A"],
              ["What AI domain deals with recognizing handwritten characters, medical MRI scans, and autonomous driving scenes?", "MCQ", "Computer Vision (CV)", "Natural Language Processing", "Data Science", "Spreadsheets", "A"],
              ["What AI domain powers sentiment analysis, language translation, and voice assistants?", "MCQ", "Natural Language Processing (NLP)", "Computer Vision", "Automated Robotics", "Signal Processing", "A"]
            ]
          },
          {
            mNum: 4,
            q: [
              ["Write a Python function 'is_even(num)' that returns True if num is even else False. Which implementation is correct?", "MCQ", "def is_even(num): return num % 2 == 0", "def is_even(num): return num / 2", "function is_even(num) { return num % 2 == 0; }", "def is_even: if num % 2 == 0", "A"],
              ["A smart hospital AI model predicts whether a patient has a severe illness. Why is high 'Recall' critical in medical diagnosis?", "MCQ", "High Recall minimizes False Negatives (ensures critical sick patients are not mistakenly classified as healthy)", "High Recall saves battery", "High Recall uses fewer doctors", "High Recall avoids taking X-rays", "A"],
              ["In Python, what is the value of result after: def calc(a, b=5): return a + b; result = calc(10)?", "MCQ", "15 (Default argument b=5 is used: 10 + 5 = 15)", "10", "5", "Error", "A"],
              ["During the Data Exploration stage of an AI project, why are histograms and scatter plots created?", "MCQ", "To spot trends, identify outliers, understand data distribution, and discover correlations", "To print posters for school", "To decorate the user interface", "To delete the dataset", "A"],
              ["What is Overfitting in Machine Learning model training?", "MCQ", "When a model memorizes training data noise too closely and fails to generalize on new real-world test data", "When the model runs too fast", "When the computer runs out of memory", "When the dataset is too small", "A"]
            ]
          }
        ]
      }
    ]
  }
];
