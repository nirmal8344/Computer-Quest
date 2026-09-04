// =========================================================================
// CBSE CLASSES 6 & 7 (MULTI-UNIT OFFICIAL CURRICULA)
// NCERT / CBSE Guidelines - Number Systems, Excel, HTML5, Python 3
// =========================================================================

module.exports = [
  // -------------------------------------------------------------
  // CBSE CLASS 6 (Data Representation, Excel, Flowcharts, Cyber Ethics)
  // -------------------------------------------------------------
  {
    board: "CBSE",
    classLevel: 6,
    units: [
      {
        unitNumber: 1,
        unitName: "Unit 1 – Number Systems & Data Foundations",
        chapters: [
          {
            num: 1,
            name: "CBSE 6 - Number Systems (Binary, Decimal, Octal, Hexadecimal)",
            missions: [
              {
                mNum: 1,
                q: [
                  ["Which number system uses only two base digits (0 and 1) to represent data in computers?", "MCQ", "Binary Number System", "Decimal Number System", "Octal Number System", "Hexadecimal", "A"],
                  ["What is the base (radix) of the decimal number system used in daily mathematics?", "MCQ", "Base 10", "Base 2", "Base 8", "Base 16", "A"],
                  ["What is the base of the Octal number system?", "MCQ", "Base 8 (Digits 0 to 7)", "Base 2", "Base 10", "Base 16", "A"],
                  ["In Hexadecimal number system (Base 16), which letter represents the decimal number 10?", "MCQ", "A", "B", "C", "F", "A"],
                  ["What is the binary equivalent of the decimal number 2?", "MCQ", "10 in binary", "11 in binary", "100 in binary", "01 in binary", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["The base of the Binary number system is _______.", "FILL_BLANK", "2", "2, two", "", "", "2"],
                  ["The base of the Hexadecimal number system is _______.", "FILL_BLANK", "16", "16, sixteen", "", "", "16"],
                  ["In hexadecimal, decimal 15 is represented by the letter _______.", "FILL_BLANK", "F", "F", "", "", "F"],
                  ["Converting decimal 4 to binary gives _______.", "FILL_BLANK", "100", "100", "", "", "100"],
                  ["A binary digit (0 or 1) is called a _______.", "FILL_BLANK", "Bit", "Bit", "", "", "Bit"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["Why do electronic digital computers use binary numbers internally instead of decimal?", "MCQ", "Electronic circuits have two stable states: ON (1) and OFF (0)", "Because binary has more digits", "To make numbers harder", "Because monitors only show 2 colors", "A"],
                  ["What is the decimal equivalent of binary number `101`?", "MCQ", "5 (1*4 + 0*2 + 1*1 = 5)", "3", "7", "10", "A"],
                  ["Which number system uses digits from 0 to 9 and letters from A to F?", "MCQ", "Hexadecimal", "Octal", "Binary", "Roman", "A"],
                  ["How many bits are grouped together to form one Nibble?", "MCQ", "4 bits", "8 bits", "2 bits", "16 bits", "A"],
                  ["What is the binary equivalent of the decimal number 8?", "MCQ", "1000", "0100", "1111", "0011", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["A student converts decimal number 13 into binary. What is the correct binary result?", "MCQ", "1101 (8 + 4 + 0 + 1 = 13)", "1011", "1110", "1001", "A"],
                  ["What is the decimal value of binary `1111`?", "MCQ", "15 (8 + 4 + 2 + 1 = 15)", "14", "16", "10", "A"],
                  ["Why do programmers frequently use hexadecimal notation for memory addresses and HTML colors?", "MCQ", "Hexadecimal provides a compact, human-readable shorthand for long binary numbers", "Because computers understand hex directly", "To make text invisible", "Because binary cannot store colors", "A"],
                  ["Which symbol is used in Python to represent a binary literal?", "MCQ", "0b (e.g. 0b101)", "0x", "0o", "#bin", "A"],
                  ["In computer graphics, a pure white color represented in hexadecimal RGB is written as _______.", "MCQ", "#FFFFFF", "#000000", "#123456", "#FF0000", "A"]
                ]
              }
            ]
          },
          {
            num: 2,
            name: "CBSE 6 - Computer Language & System Software",
            missions: [
              {
                mNum: 1,
                q: [
                  ["Which low-level language written in binary code (0s and 1s) is directly executed by the CPU?", "MCQ", "Machine Language", "High-Level Language", "Assembly Language", "Natural Language", "A"],
                  ["Which translator program converts an entire High-Level Language program into machine code in one go?", "MCQ", "Compiler", "Interpreter", "Assembler", "Operating System", "A"],
                  ["Which translator converts High-Level Language program line-by-line?", "MCQ", "Interpreter", "Compiler", "Assembler", "Linker", "A"],
                  ["Assembly language uses short mnemonic codes (like ADD, SUB, MOV) and is translated by an _______.", "MCQ", "Assembler", "Compiler", "Interpreter", "Browser", "A"],
                  ["Which of the following is a modern High-Level Programming Language?", "MCQ", "Python", "Machine 01 Code", "Binary Switch", "Punch Card", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["A language translator that converts line-by-line is an _______.", "FILL_BLANK", "Interpreter", "Interpreter", "", "", "Interpreter"],
                  ["A translator that compiles the entire source code at once into an executable is a _______.", "FILL_BLANK", "Compiler", "Compiler", "", "", "Compiler"],
                  ["Mnemonic codes like ADD and MOV are used in _______ Language.", "FILL_BLANK", "Assembly", "Assembly", "", "", "Assembly"],
                  ["Software designed to maintain and protect the computer (like antivirus and disk cleanup) is _______ Software.", "FILL_BLANK", "Utility", "Utility, Utility Software", "", "", "Utility"],
                  ["Operating systems like Windows, Linux, and macOS are examples of _______ Software.", "FILL_BLANK", "System", "System, System Software", "", "", "System"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["Why are High-Level Languages (like Python and C++) preferred by human software developers?", "MCQ", "They use simple English-like words and are easy to read, write, and debug", "They only run on supercomputers", "They don't need any translation", "They use 0s and 1s only", "A"],
                  ["What is the primary difference between a Compiler and an Interpreter?", "MCQ", "Compiler translates whole code at once; Interpreter translates line-by-line", "Compiler is slower", "Interpreter creates .exe files", "Compiler only works on Mac", "A"],
                  ["Which software category includes word processors, spreadsheet tools, and games designed for end users?", "MCQ", "Application Software", "System Software", "Device Drivers", "BIOS Firmware", "A"],
                  ["What is a Device Driver?", "MCQ", "Special system software that enables the OS to communicate with specific hardware like printers", "A person who drives computer vans", "A hardware screw", "A cooling fan", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["You write a Python program that contains a syntax error on line 5. Why does an interpreter stop at line 5?", "MCQ", "Because Python translates and executes line-by-line until it encounters an error", "Because Python deletes line 5", "Because the CPU overheated", "Because the keyboard failed", "A"],
                  ["What does Open Source Software mean?", "MCQ", "Software whose source code is freely available for anyone to inspect, modify, and enhance", "Software that must be paid for every month", "Software that has no code", "Software that only works outdoors", "A"],
                  ["Which utility software reorganizes fragmented files on a mechanical hard drive to improve performance?", "MCQ", "Disk Defragmenter", "Antivirus", "Screen Saver", "Media Player", "A"],
                  ["Which system program permanently loads into memory to coordinate all computer processes upon bootup?", "MCQ", "Operating System Kernel", "Web Browser", "Game Console", "Paint File", "A"],
                  ["Why do different CPU architectures require different machine language instructions?", "MCQ", "Because each CPU model has its own unique internal hardware instruction set architecture (ISA)", "Because screen sizes differ", "Because electricity is different", "To confuse developers", "A"]
                ]
              }
            ]
          }
        ]
      },
      {
        unitNumber: 2,
        unitName: "Unit 2 – Electronic Spreadsheets & Data Analysis",
        chapters: [
          {
            num: 3,
            name: "CBSE 6 - Working with MS Excel Spreadsheets",
            missions: [
              {
                mNum: 1,
                q: [
                  ["Which application in Microsoft Office is designed for numeric calculations, formulas, and charts?", "MCQ", "Microsoft Excel", "Microsoft Word", "PowerPoint", "MS Paint", "A"],
                  ["A single electronic page or grid of rows and columns in an Excel workbook is called a _______.", "MCQ", "Worksheet", "Slide", "Document", "Frame", "A"],
                  ["How are columns labeled in an Excel worksheet?", "MCQ", "Alphabetical Letters (A, B, C, ...)", "Numbers (1, 2, 3, ...)", "Roman Numerals", "Symbols", "A"],
                  ["How are rows numbered in an Excel worksheet?", "MCQ", "Numbers (1, 2, 3, ...)", "Letters (A, B, C, ...)", "Colors", "Words", "A"],
                  ["What is the unique address of the cell at the intersection of column C and row 5?", "MCQ", "C5", "5C", "C:5", "#C5", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["Every formula in Microsoft Excel must always begin with the _______ (=) sign.", "FILL_BLANK", "=", "=, equals", "", "", "="],
                  ["The intersection of a row and a column in a spreadsheet is called a _______.", "FILL_BLANK", "Cell", "Cell", "", "", "Cell"],
                  ["The currently selected cell highlighted with a thick dark border is the _______ Cell.", "FILL_BLANK", "Active", "Active", "", "", "Active"],
                  ["The small box above column A displaying the active cell reference is the _______ Box.", "FILL_BLANK", "Name", "Name", "", "", "Name"],
                  ["The bar where you type or edit formulas and cell contents is the _______ Bar.", "FILL_BLANK", "Formula", "Formula", "", "", "Formula"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["Which keyboard shortcut selects the entire Excel worksheet?", "MCQ", "Ctrl + A", "Ctrl + S", "Ctrl + W", "Ctrl + E", "A"],
                  ["A group or continuous block of selected cells in Excel (e.g. A1 to A10) is called a Cell _______.", "MCQ", "Range (A1:A10)", "Group", "Block", "Cluster", "A"],
                  ["What small black square on the bottom-right corner of an active cell is used to copy formulas and auto-fill series?", "MCQ", "AutoFill Handle", "Cursor", "Scrollbar", "Ruler", "A"],
                  ["What happens when you type 'January' in cell A1 and drag the AutoFill handle down 5 cells?", "MCQ", "Excel automatically fills February, March, April, May, June", "It prints blank cells", "It shows an error message", "It deletes column A", "A"],
                  ["Which data type in Excel automatically aligns to the right side of the cell by default?", "MCQ", "Numbers / Numeric Data", "Text / Labels", "Pictures", "Shapes", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["A teacher wants to enter marks for 40 students across 5 subjects. Why is Excel much better than writing on paper?", "MCQ", "Excel automatically calculates totals, averages, percentages, and sorts rankings in seconds", "Excel makes the printer faster", "Excel uses no electricity", "Excel deletes failed marks", "A"],
                  ["You enter `=10+20*2` into cell B1. What result will Excel calculate following standard operator precedence?", "MCQ", "50 (since multiplication 20*2=40 is done before addition 10+40)", "60", "30", "200", "A"],
                  ["What does `###` displayed inside an Excel cell indicate?", "MCQ", "The column is too narrow to display the complete number; widen the column", "A fatal virus error", "The formula is deleted", "The computer is out of memory", "A"],
                  ["Which key combination moves the active cell cursor down to the cell directly below?", "MCQ", "Enter Key", "Tab Key", "Shift Key", "Esc Key", "A"],
                  ["Which file format extension is used for saving modern Microsoft Excel workbooks?", "MCQ", ".xlsx", ".docx", ".pptx", ".txt", "A"]
                ]
              }
            ]
          },
          {
            num: 4,
            name: "CBSE 6 - Formulas, Functions & Charts in Excel",
            missions: [
              {
                mNum: 1,
                q: [
                  ["Which built-in Excel function is used to calculate the sum total of numbers in a range?", "MCQ", "=SUM()", "=TOTAL()", "=ADD()", "=PLUS()", "A"],
                  ["Which Excel function calculates the arithmetic mean of a range of numbers?", "MCQ", "=AVERAGE()", "=MEAN()", "=MEDIAN()", "=SUMAVG()", "A"],
                  ["Which Excel function finds and returns the largest value in a selected range?", "MCQ", "=MAX()", "=HIGH()", "=LARGEST()", "=TOP()", "A"],
                  ["Which Excel function finds and returns the smallest value in a selected range?", "MCQ", "=MIN()", "=LOW()", "=LEAST()", "=BOTTOM()", "A"],
                  ["A visual graphical representation of numeric data in Excel is called a _______.", "MCQ", "Chart / Graph", "Watermark", "Header", "Hyperlink", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["To find the total of cells B1 through B10, the formula is =SUM(B1_______B10).", "FILL_BLANK", ":", ":, colon", "", "", ":"],
                  ["The function that counts how many cells in a range contain numbers is =_______().", "FILL_BLANK", "COUNT", "COUNT", "", "", "COUNT"],
                  ["A circular chart showing proportions of a whole divided into slices is a _______ Chart.", "FILL_BLANK", "Pie", "Pie, Pie Chart", "", "", "Pie"],
                  ["A chart showing data trends over continuous intervals using vertical bars is a _______ Chart.", "FILL_BLANK", "Column", "Column, Bar", "", "", "Column"],
                  ["The horizontal axis at the bottom of a chart is commonly called the _______ axis.", "FILL_BLANK", "X", "X, X-axis", "", "", "X"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["Which chart type in Excel is best suited for showing changes and trends in temperatures over days?", "MCQ", "Line Chart", "Pie Chart", "Scatter Chart", "Radar Chart", "A"],
                  ["What does the legend in an Excel chart explain?", "MCQ", "The colors, patterns, and symbols representing data series in the chart", "The file author name", "The date printed", "The formula used", "A"],
                  ["What is the result of `=AVERAGE(10, 20, 30)` in Excel?", "MCQ", "20", "60", "30", "10", "A"],
                  ["What is the result of `=COUNT(10, 20, \"Cat\", 40)`?", "MCQ", "3 (since only 3 items are numeric numbers)", "4", "2", "0", "A"],
                  ["Which ribbon tab in Excel contains the Charts group (Column, Line, Pie, Bar)?", "MCQ", "Insert Tab", "Page Layout Tab", "Formulas Tab", "Data Tab", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["A shopkeeper wants to show what percentage of monthly sales comes from Fruits, Vegetables, and Dairy. Which chart is ideal?", "MCQ", "Pie Chart (shows percentage breakdown of a whole)", "Scatter Plot", "Stock Chart", "Waterfall Chart", "A"],
                  ["A formula in cell C1 is `=A1+B1`. If copied to cell C2, Excel changes it to `=A2+B2`. What is this called?", "MCQ", "Relative Cell Referencing", "Absolute Referencing", "Circular Reference", "Static Reference", "A"],
                  ["You want to find the highest score in Math among 50 students in cells D2 to D51. What formula do you write?", "MCQ", "=MAX(D2:D51)", "=SUM(D2:D51)", "=TOP(D2:D51)", "=COUNT(D2:D51)", "A"],
                  ["What symbol is placed before a column letter and row number to create an Absolute Reference (e.g. `$A$1`) that never changes when copied?", "MCQ", "$ (Dollar Sign)", "#", "%", "@", "A"],
                  ["Why are charts widely used in business and science presentations?", "MCQ", "Charts allow human eyes to quickly spot trends, comparisons, and patterns in large datasets", "Charts make numbers smaller", "Charts make files invisible", "Charts only work offline", "A"]
                ]
              }
            ]
          }
        ]
      },
      {
        unitNumber: 3,
        unitName: "Unit 3 – Computational Thinking & Cyber Ethics",
        chapters: [
          {
            num: 5,
            name: "CBSE 6 - Flowcharts, Loops & Conditionals in Scratch",
            missions: [
              {
                mNum: 1,
                q: [
                  ["Which geometric shape is used to represent Start and Stop (Terminator) in a standard flowchart?", "MCQ", "Oval / Rounded Rectangle", "Rectangle", "Diamond", "Parallelogram", "A"],
                  ["Which flowchart symbol represents a Process or calculation step?", "MCQ", "Rectangle", "Diamond", "Oval", "Circle", "A"],
                  ["Which flowchart shape represents a Decision or Condition with Yes/No branches?", "MCQ", "Diamond / Rhombus", "Rectangle", "Oval", "Parallelogram", "A"],
                  ["Which flowchart symbol represents Input or Output operations (e.g. Read A, Print Sum)?", "MCQ", "Parallelogram", "Circle", "Square", "Hexagon", "A"],
                  ["What connects flowchart symbols and shows the exact flow of execution?", "MCQ", "Flowlines (Arrows)", "Dotted lines", "Wavy lines", "Curved arcs", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["The shape used for Decision making in a flowchart is a _______.", "FILL_BLANK", "Diamond", "Diamond, Rhombus", "", "", "Diamond"],
                  ["The shape used for Start and End is an _______.", "FILL_BLANK", "Oval", "Oval", "", "", "Oval"],
                  ["The shape used for calculations and processing is a _______.", "FILL_BLANK", "Rectangle", "Rectangle", "", "", "Rectangle"],
                  ["In Scratch, an 'if-else' block contains _______ branches of execution.", "FILL_BLANK", "2", "2, two", "", "", "2"],
                  ["Joining two strings of text in Scratch is done using the _______ block.", "FILL_BLANK", "Join", "Join", "", "", "Join"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["Which Scratch block tests whether a student's score is greater than 50?", "MCQ", "score > 50 (Operator Block)", "score = 0", "score < 10", "score + 50", "A"],
                  ["In Scratch, what does an `if <condition> then ... else ...` block do if the condition is FALSE?", "MCQ", "It executes the code placed inside the 'else' section", "It stops the whole project", "It deletes the variable", "It restarts from the green flag", "A"],
                  ["What is an infinite loop bug?", "MCQ", "A loop whose terminating condition is never met, causing it to run forever and freeze the program", "A loop that finishes in 0.1 sec", "A loop that changes sprite colors", "A music block", "A"],
                  ["Which block in Scratch stops all running scripts across all sprites?", "MCQ", "stop all", "hide stage", "wait 10 sec", "repeat 1", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["A flowchart determines if a number `N` is Even or Odd. What condition is placed in the diamond decision box?", "MCQ", "Is N % 2 == 0? (Remainder after division by 2 is 0)", "Is N > 100?", "Is N + 2 == 5?", "Is N == 0?", "A"],
                  ["You want a Scratch character to ask the user 'Enter password' and check if it equals 'quest123'. What block is used?", "MCQ", "ask [Enter password] and wait -> if <answer = quest123> then [say Welcome] else [say Access Denied]", "move 10 steps", "next backdrop", "turn 90 degrees", "A"],
                  ["Why is drawing a flowchart recommended before writing code in any programming language?", "MCQ", "It visually clarifies the problem logic and identifies flaws before coding", "It increases file size", "It replaces the CPU", "It makes typing unnecessary", "A"],
                  ["Which symbol is used in flowcharts to connect distant parts of a diagram without crossing lines?", "MCQ", "Circle Connector", "Square", "Star", "Arrowhead only", "A"],
                  ["What is modular programming in computational thinking?", "MCQ", "Dividing a complex system into independent reusable sub-tasks or functions", "Writing all code in one giant block", "Deleting comments", "Using only one variable", "A"]
                ]
              }
            ]
          },
          {
            num: 6,
            name: "CBSE 6 - Cyber Ethics, Netiquette & Digital Safety",
            missions: [
              {
                mNum: 1,
                q: [
                  ["The set of moral principles and good manners governing online behavior is called _______.", "MCQ", "Cyber Ethics & Netiquette", "Operating System", "Firewall", "Computer Language", "A"],
                  ["Stealing another person's creative work, text, or research and claiming it as your own without credit is _______.", "MCQ", "Plagiarism", "Copyright", "Fair Use", "Open Source", "A"],
                  ["Legal rights given to creators of original digital content (software, books, music) to protect against unauthorized copying are _______.", "MCQ", "Copyright / Intellectual Property Rights (IPR)", "Firewall", "Antivirus", "License Plate", "A"],
                  ["Unauthorized copying, illegal distribution, or commercial sale of copyrighted software is called _______.", "MCQ", "Software Piracy", "Open Source", "Freeware", "Backup", "A"],
                  ["What is Netiquette?", "MCQ", "Rules of polite, respectful, and responsible communication on the Internet", "A new computer game", "An internet cable", "A type of modem", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["Stealing someone's published work without giving proper credit is called _______.", "FILL_BLANK", "Plagiarism", "Plagiarism", "", "", "Plagiarism"],
                  ["Typing all messages in ALL CAPITAL LETTERS in chat or email is considered shouting and poor _______.", "FILL_BLANK", "Netiquette", "Netiquette", "", "", "Netiquette"],
                  ["A malicious software program designed to infect files and disrupt computer operations is a _______.", "FILL_BLANK", "Virus", "Virus, Computer Virus", "", "", "Virus"],
                  ["Software distributed freely for testing with some features locked until purchase is _______.", "FILL_BLANK", "Shareware", "Shareware", "", "", "Shareware"],
                  ["Software that is completely free to use without any cost or time restriction is _______.", "FILL_BLANK", "Freeware", "Freeware", "", "", "Freeware"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["What is Phishing in cyber security?", "MCQ", "Fraudulent emails and fake websites designed to trick users into revealing confidential passwords", "Catching real fish with internet cables", "Speeding up internet browsing", "Formatting a USB drive", "A"],
                  ["What is a strong password principle?", "MCQ", "At least 8-12 characters combining uppercase, lowercase, numbers, and special symbols (@, #, $)", "Your date of birth", "Your pet's name", "12345678", "A"],
                  ["Why is it unsafe to connect to open, unsecured public Wi-Fi networks without protection?", "MCQ", "Hackers on the same network can intercept unencrypted passwords and personal data", "It consumes too much battery", "It changes your screen wallpaper", "It turns off speakers", "A"],
                  ["What is Two-Factor Authentication (2FA)?", "MCQ", "A security process where a user verifies identity using password plus a temporary OTP code sent to their phone", "Entering password twice", "Having two accounts", "Using two monitors", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["You receive an email claiming 'Your account is suspended! Click this link to update your password immediately!'. What should you do?", "MCQ", "Do not click any link; verify directly on official website and report as phishing", "Click and type your secret password", "Forward to all friends", "Reply with credit card details", "A"],
                  ["You find an insightful paragraph on Wikipedia for your school essay. What is the ethical way to use it?", "MCQ", "Summarize in your own words and cite the reference source clearly", "Copy and paste and say you wrote it", "Delete Wikipedia", "Change the author's name to yours", "A"],
                  ["What should you do to protect your computer from virus infections via USB drives?", "MCQ", "Scan USB drives with updated Antivirus software before opening files", "Never shut down PC", "Open all .exe files immediately", "Format the monitor", "A"],
                  ["What does the Indian Information Technology (IT) Act do?", "MCQ", "Provides legal framework against cyber crimes, identity theft, unauthorized hacking, and electronic fraud in India", "Controls television channels", "Sets prices of laptops", "Manufactures computer chips", "A"],
                  ["Why should we practice good digital citizenship every day?", "MCQ", "To keep the digital world safe, respectful, collaborative, and ethical for all users", "To get 100 free computers", "To delete the internet", "To bypass school rules", "A"]
                ]
              }
            ]
          }
        ]
      }
    ]
  }
];
