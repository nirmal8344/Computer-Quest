// =========================================================================
// CBSE CLASSES 9 & 10 (MULTI-UNIT OFFICIAL CURRICULA)
// CBSE IT Code 402 / Computer Applications Code 165 / NCERT
// High-Level Problem Solving, SQL, Python, AI Project Cycle
// =========================================================================

module.exports = [
  // -------------------------------------------------------------
  // CBSE CLASS 9 (IT Code 402 / Code 165)
  // -------------------------------------------------------------
  {
    board: "CBSE",
    classLevel: 9,
    units: [
      {
        unitNumber: 1,
        unitName: "Unit 1 – Basics of Information Technology",
        chapters: [
          {
            num: 1,
            name: "CBSE 9 - Computer Systems Architecture & Memory Hierarchy",
            missions: [
              {
                mNum: 1,
                q: [
                  ["Which classic architectural model consists of CPU (Control Unit, ALU), Memory Unit, and I/O mechanisms?", "MCQ", "Von Neumann Architecture", "Harvard Architecture", "Turing Engine", "Pascal Architecture", "A"],
                  ["Which ultra-fast static RAM cache level is built directly inside the CPU processor core?", "MCQ", "L1 Cache", "L2 Cache", "L3 Cache", "Virtual Memory", "A"],
                  ["What does EEPROM stand for in permanent semiconductor memory?", "MCQ", "Electrically Erasable Programmable Read-Only Memory", "Electronic Enhanced Programmable ROM", "Easy Erasable Primary ROM", "Extended Electronic Processor ROM", "A"],
                  ["The system bus that carries memory location addresses from the CPU to RAM is the _______.", "MCQ", "Address Bus", "Data Bus", "Control Bus", "Power Bus", "A"],
                  ["What is the role of the System Clock in a microprocessor?", "MCQ", "Generates electrical clock pulses to synchronize all CPU internal operations (measured in GHz)", "Shows the real time on screen", "Saves battery life", "Cools down the heatsink", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["The internal bus width determining how much data CPU can transfer at once is the _______ Bus.", "FILL_BLANK", "Data", "Data", "", "", "Data"],
                  ["Memory managed by the OS on secondary storage when RAM is exhausted is _______ Memory.", "FILL_BLANK", "Virtual", "Virtual", "", "", "Virtual"],
                  ["The CPU clock frequency speed is measured in Giga_______ (GHz).", "FILL_BLANK", "Hertz", "Hertz", "", "", "Hertz"],
                  ["Non-volatile firmware holding initial boot instructions on the motherboard is the _______.", "FILL_BLANK", "BIOS", "BIOS, UEFI", "", "", "BIOS"],
                  ["The temporary storage registers located inside the CPU ALU are called _______.", "FILL_BLANK", "Registers", "Registers, Accumulators", "", "", "Registers"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["What is the difference between Static RAM (SRAM) and Dynamic RAM (DRAM)?", "MCQ", "SRAM uses flip-flops, is faster, and needs no periodic refresh; DRAM uses capacitors and needs constant refreshing", "SRAM is magnetic", "DRAM is read-only", "SRAM holds 100 TB", "A"],
                  ["What does POST (Power-On Self-Test) perform during computer startup?", "MCQ", "Diagnostic testing by BIOS to verify memory, keyboard, and essential hardware before loading OS", "Clears browser cookies", "Deletes temporary files", "Formats the hard drive", "A"],
                  ["Which high-speed expansion bus standard is used for connecting graphics cards and NVMe SSDs to the motherboard?", "MCQ", "PCIe (PCI Express)", "VGA", "SATA 1", "USB 1.1", "A"],
                  ["What is DMA (Direct Memory Access)?", "MCQ", "A hardware feature allowing I/O devices to transfer data directly to/from RAM without loading the CPU", "A CPU cooling paste", "A display port", "An antivirus tool", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["A system has 8 GB of physical RAM. While running heavy 3D rendering, total memory demand reaches 12 GB. How does the OS handle this?", "MCQ", "The OS allocates 4 GB of Virtual Memory on the SSD as Paging File / Swap Space", "The computer immediately explodes", "The CPU deletes the project", "The monitor switches off", "A"],
                  ["What is Thrashing in operating systems memory management?", "MCQ", "A performance state where the OS spends more time swapping pages between RAM and disk than executing real work", "Deleting files rapidly", "A network virus", "CPU overclocking", "A"],
                  ["Why are 64-bit microprocessors superior to older 32-bit processors?", "MCQ", "64-bit CPUs can address over 16 Exabytes of RAM and process larger 64-bit integer values in single clock cycles", "64-bit uses 64 monitors", "64-bit requires no electricity", "32-bit has no keyboard support", "A"],
                  ["Which memory type is used in USB flash drives and modern NVMe SSDs?", "MCQ", "NAND Flash Memory", "Magnetic Core", "Dynamic RAM", "Punched Tape", "A"],
                  ["What is the fundamental difference between RISC and CISC processor architectures?", "MCQ", "RISC uses simple single-cycle instructions; CISC uses complex multi-clock instructions with richer addressing modes", "RISC is for printers only", "CISC has no ALU", "RISC uses vacuum tubes", "A"]
                ]
              }
            ]
          },
          {
            num: 2,
            name: "CBSE 9 - Operating Systems & Device Drivers",
            missions: [
              {
                mNum: 1,
                q: [
                  ["What core component of an Operating System remains resident in main memory and manages hardware resources?", "MCQ", "Kernel", "Shell", "GUI Window", "Compiler", "A"],
                  ["Which OS type allows multiple users to access and run processes simultaneously on a central server?", "MCQ", "Multi-User Operating System", "Single-User OS", "Batch System", "Real-Time OS", "A"],
                  ["Which Command Line Interface (CLI) terminal is standard on Linux and macOS systems?", "MCQ", "Bash Shell", "Windows Explorer", "Finder", "Control Panel", "A"],
                  ["What is Spooling (Simultaneous Peripheral Operations On-Line) in OS print management?", "MCQ", "Buffering print jobs on disk in a queue so applications can continue working without waiting for the slow printer", "Formatting the hard disk", "Compressing photos", "Deleting print jobs", "A"],
                  ["Which file system is standard on modern Microsoft Windows installations?", "MCQ", "NTFS (New Technology File System)", "FAT16", "Ext4", "APFS", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["The interface between user and the OS kernel in command line mode is the _______.", "FILL_BLANK", "Shell", "Shell", "", "", "Shell"],
                  ["A program in active execution loaded into memory is called a _______.", "FILL_BLANK", "Process", "Process", "", "", "Process"],
                  ["The scheduling technique that allocates equal time slices (quantum) to each process is Round _______.", "FILL_BLANK", "Robin", "Robin", "", "", "Robin"],
                  ["A condition where two processes are permanently waiting for resources held by each other is a _______.", "FILL_BLANK", "Deadlock", "Deadlock", "", "", "Deadlock"],
                  ["The Linux command used to list files in the current working directory is _______.", "FILL_BLANK", "ls", "ls", "", "", "ls"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["What is the difference between Preemptive and Non-Preemptive process scheduling?", "MCQ", "In Preemptive scheduling, the OS can interrupt and context-switch a running process; in Non-preemptive, the process runs until completion or I/O wait", "Preemptive runs with no clock", "Non-preemptive is for mobile only", "They are the same", "A"],
                  ["Which Linux terminal command is used to display the current working directory path?", "MCQ", "pwd (Print Working Directory)", "cd", "mkdir", "rm", "A"],
                  ["Which command in Linux creates a new directory/folder?", "MCQ", "mkdir", "rmdir", "touch", "cat", "A"],
                  ["What is a Device Driver in OS architecture?", "MCQ", "A specialized software module that translates generic OS I/O calls into hardware-specific controller signals", "A hardware cable", "A graphics card", "A user manual", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["Why is a dual-mode operation (User Mode vs Kernel Mode) critical in modern operating systems?", "MCQ", "It prevents user programs from directly corrupting hardware memory or crashing the core OS", "It allows two users to type simultaneously", "It saves battery life on laptops", "It disables internet access", "A"],
                  ["What is a Context Switch in CPU multitasking?", "MCQ", "Saving the state of the currently running process and loading the state of the next scheduled process into CPU registers", "Turning off the monitor", "Changing the user password", "Unplugging the keyboard", "A"],
                  ["What is the role of the Buffer Cache in operating system I/O?", "MCQ", "Temporarily holding data in fast RAM to bridge the speed mismatch between fast CPU and slow storage drives", "Deleting old files", "Encrypting passwords", "Generating 3D graphics", "A"],
                  ["Which Linux command displays real-time CPU usage, memory stats, and running processes?", "MCQ", "top or htop", "cat", "echo", "pwd", "A"],
                  ["What is an Interrupt in computer system architecture?", "MCQ", "An asynchronous signal from hardware or software alerting the CPU to immediately suspend current execution and handle an event", "A power failure", "A broken monitor screen", "A deleted file", "A"]
                ]
              }
            ]
          }
        ]
      },
      {
        unitNumber: 2,
        unitName: "Unit 2 – Cyber Safety, Privacy & Digital Citizenship",
        chapters: [
          {
            num: 3,
            name: "CBSE 9 - Cyber Safety, Privacy & Indian Cyber Laws",
            missions: [
              {
                mNum: 1,
                q: [
                  ["Which Indian law enacted in 2000 provides the legal framework for electronic governance, cyber crime penalties, and digital signatures?", "MCQ", "Information Technology Act, 2000 (IT Act 2000)", "Indian Penal Code 1860", "Telecom Act 1995", "Digital Media Rule 2010", "A"],
                  ["Section 66C of the Indian IT Act 2000 prescribes punishment for which specific offense?", "MCQ", "Identity Theft and fraudulently using another person's password/digital signature", "Spelling errors in email", "Playing online games", "Slow Wi-Fi speed", "A"],
                  ["Section 66D of the IT Act 2000 deals with punishment for _______.", "MCQ", "Cheating by personation using computer resource (Online Impersonation Fraud)", "Downloading songs", "Formatting a USB", "Creating a website", "A"],
                  ["What is Cyberstalking?", "MCQ", "Repeatedly harassing, threatening, or tracking an individual online using electronic communications", "A new computer game", "A video editing tool", "A cloud server", "A"],
                  ["Small text files stored by websites on your browser to track user preferences and session states are called _______.", "MCQ", "Cookies", "Viruses", "Applets", "Tokens", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["The primary cyber legislation in India is the Information Technology Act, _______.", "FILL_BLANK", "2000", "2000", "", "", "2000"],
                  ["Secretly recording every keystroke typed by a user on a keyboard is done by a _______.", "FILL_BLANK", "Keylogger", "Keylogger", "", "", "Keylogger"],
                  ["The official national portal for reporting cyber crimes in India is cybercrime.gov._______.", "FILL_BLANK", "in", "in", "", "", "in"],
                  ["A deceptive attack where an attacker creates a fake login page to capture credentials is _______.", "FILL_BLANK", "Phishing", "Phishing", "", "", "Phishing"],
                  ["The legal right of creators over original literary, artistic, and software works is _______.", "FILL_BLANK", "Copyright", "Copyright, IPR", "", "", "Copyright"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["What is a Denial of Service (DoS) attack?", "MCQ", "Flooding a web server with fake traffic requests to overwhelm it and deny access to legitimate users", "Formatting a local drive", "Deleting browser history", "Changing screen brightness", "A"],
                  ["What does a Botnet refer to in cyber security?", "MCQ", "A network of infected private computers (zombies) controlled remotely by a hacker to launch coordinated attacks", "A robotics laboratory", "A group of AI assistants", "A classroom of tablets", "A"],
                  ["What is End-to-End Encryption (E2EE)?", "MCQ", "A communication system where only the communicating users can read messages, preventing ISPs, servers, and hackers from eavesdropping", "Encrypting files on a DVD", "Using a password with 4 digits", "Deleting sent messages", "A"],
                  ["What is Digital Footprint and why should teens manage it carefully?", "MCQ", "The permanent trail of data left online (posts, comments, search history) which future universities and employers can audit", "A footprint on computer glass", "A downloaded game", "A printer scan", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["A student receives an SMS saying 'Your bank account will be blocked unless you verify your PAN card by clicking this bit.ly link'. What attack is this?", "MCQ", "Smishing (SMS Phishing) scam aimed at credential harvesting", "Legitimate bank notification", "A system update", "A network speed test", "A"],
                  ["Why should software licenses (like MIT, Apache, GNU GPL, Proprietary) be respected?", "MCQ", "Licenses define the legal terms under which creators permit use, redistribution, and modification of their intellectual property", "To make files smaller", "Because computers stop working without internet", "To increase CPU clock speed", "A"],
                  ["What is a Man-in-the-Middle (MitM) attack and how does HTTPS protect against it?", "MCQ", "An attacker intercepts communications between user and server; HTTPS uses TLS encryption and digital certificates to prevent snooping and tampering", "A virus that deletes half your files", "A physical cable cut", "A screen recording software", "A"],
                  ["What is Creative Commons (CC) licensing in digital content sharing?", "MCQ", "A standardized public copyright license granting permission to freely share and use creative work under specified creator conditions", "A commercial software store", "A paid antivirus tool", "A cloud backup protocol", "A"],
                  ["Under Indian IT Act Section 66E, capturing, publishing, or transmitting images of a private area of any person without consent is punishable with _______.", "MCQ", "Imprisonment up to 3 years or fine up to ₹2 lakh, or both", "A verbal warning only", "No punishment", "Community service for 1 hour", "A"]
                ]
              }
            ]
          }
        ]
      },
      {
        unitNumber: 3,
        unitName: "Unit 3 – Digital Documentation & Electronic Spreadsheets",
        chapters: [
          {
            num: 4,
            name: "CBSE 9 - Advanced Digital Documentation & Formatting",
            missions: [
              {
                mNum: 1,
                q: [
                  ["Which powerful feature in word processors allows sending personalized letters or certificates to hundreds of recipients using a database?", "MCQ", "Mail Merge", "Format Painter", "AutoCorrect", "Spell Check", "A"],
                  ["What are the two essential files required to execute a Mail Merge operation?", "MCQ", "Main Document (Letter Template) and Data Source (Recipient List)", "Two image files", "A PDF and a Word file", "An audio clip and a video", "A"],
                  ["What is a Table of Contents (TOC) in a professional report?", "MCQ", "An automated list of document headings with hyperlinked page numbers", "A list of food recipes", "A summary table with numbers", "A photo gallery", "A"],
                  ["Which feature in word processors applies consistent pre-defined formatting (Heading 1, Heading 2, Body) across a 100-page document?", "MCQ", "Styles (Paragraph Styles)", "Format Painter", "Watermark", "Drop Cap", "A"],
                  ["What does a Drop Cap formatting effect do to the first letter of a paragraph?", "MCQ", "Enlarges the first letter so that it drops down across several lines of text like a magazine article", "Underlines all vowels", "Deletes the first sentence", "Changes text to lowercase", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["The process of creating customized batch letters from a spreadsheet list is Mail _______.", "FILL_BLANK", "Merge", "Merge", "", "", "Merge"],
                  ["The file containing recipient names and addresses in a mail merge is the Data _______.", "FILL_BLANK", "Source", "Source", "", "", "Source"],
                  ["Placeholders in the main document where personalized data is inserted are Merge _______.", "FILL_BLANK", "Fields", "Fields, Field", "", "", "Fields"],
                  ["Dividing a document into distinct sections with different headers, footers, or margins uses Section _______.", "FILL_BLANK", "Breaks", "Breaks, Break", "", "", "Breaks"],
                  ["A large decorative capital letter at the start of a paragraph is a Drop _______.", "FILL_BLANK", "Cap", "Cap", "", "", "Cap"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["Which ribbon tab in Microsoft Word contains the Mail Merge wizard and Insert Merge Field tools?", "MCQ", "Mailings Tab", "Insert Tab", "References Tab", "View Tab", "A"],
                  ["How does Microsoft Word generate an automatic Table of Contents?", "MCQ", "By scanning the document for text formatted with heading styles (Heading 1, Heading 2, Heading 3)", "By counting words", "By scanning images", "By reading the file name", "A"],
                  ["What is the difference between a Page Break (Ctrl + Enter) and a Section Break?", "MCQ", "Page Break moves text to next page within same layout; Section Break allows changing headers, footers, margins, and page orientation independently", "Page Break deletes text", "Section Break is for tables only", "There is no difference", "A"],
                  ["Which feature allows multiple authors to review a document, suggest edits, and view changes in redline margin bubbles?", "MCQ", "Track Changes (Review Tab)", "Mail Merge", "WordArt", "Watermark", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["A school needs to issue 1500 report cards with unique student names, roll numbers, and marks. How should this be created efficiently?", "MCQ", "Design one Report Card template and execute Mail Merge linked to an Excel marksheet data source", "Type 1500 individual files manually", "Copy and paste into Notepad", "Print 1500 blank papers", "A"],
                  ["You are writing a 50-page thesis. Chapter 1 needs portrait mode, but Chapter 2 has a wide 10-column table needing landscape mode. How is this achieved?", "MCQ", "Insert a 'Section Break (Next Page)' before and after Chapter 2 and set Chapter 2 orientation to Landscape", "Rotate the monitor physically", "Convert whole document to PDF", "Delete Chapter 2", "A"],
                  ["What is a Document Template (`.dotx` / `.ott`)?", "MCQ", "A pre-designed master blueprint document with predefined styles, headers, and layouts used to spawn new uniform documents", "A completed homework file", "An image editor", "A database table", "A"],
                  ["What happens when you accept a tracked change in Word's Review tab?", "MCQ", "The proposed modification is permanently incorporated into the document text and the markup highlight is removed", "The document is deleted", "The file is printed immediately", "The font turns red", "A"],
                  ["Why is maintaining strict Heading Style hierarchy (H1 -> H2 -> H3) essential for digital document accessibility?", "MCQ", "Screen readers and document navigation panes use heading levels to generate accessible document structure for visually impaired users", "It increases printing speed", "It saves toner ink", "It prevents file copying", "A"]
                ]
              }
            ]
          },
          {
            num: 5,
            name: "CBSE 9 - Electronic Spreadsheets & Advanced Data Analysis",
            missions: [
              {
                mNum: 1,
                q: [
                  ["Which feature in Excel summarizes, aggregates, groups, and pivots thousands of data rows interactively into a clean summary table?", "MCQ", "PivotTable", "AutoSum", "Goal Seek", "Conditional Format", "A"],
                  ["What is the purpose of Goal Seek in Excel's What-If Analysis tools?", "MCQ", "Finds the specific input value needed to achieve a desired target result in a formula", "Sorts data alphabetically", "Draws pie charts", "Protects cells with password", "A"],
                  ["Which formula creates a mixed cell reference where the column `A` is locked with `$` but row `1` changes when copied?", "MCQ", "=$A1", "=$A$1", "=A$1", "=A1", "A"],
                  ["What is the result of `=COUNTBLANK(A1:A10)` in Excel?", "MCQ", "Returns the number of empty/blank cells in the range A1:A10", "Returns the sum of blank cells", "Fills blank cells with zeros", "Deletes blank cells", "A"],
                  ["Which logical function in Excel returns TRUE only if ALL specified conditions evaluate to TRUE?", "MCQ", "=AND()", "=OR()", "=NOT()", "=XOR()", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["An interactive multi-dimensional data summary table in Excel is a _______Table.", "FILL_BLANK", "Pivot", "Pivot", "", "", "Pivot"],
                  ["The What-If Analysis tool used to back-calculate an input for a target goal is _______ Seek.", "FILL_BLANK", "Goal", "Goal", "", "", "Goal"],
                  ["The formula that returns the current system date and time dynamically is =_______().", "FILL_BLANK", "NOW", "NOW", "", "", "NOW"],
                  ["The formula that calculates the mathematical square root of a number is =_______().", "FILL_BLANK", "SQRT", "SQRT", "", "", "SQRT"],
                  ["Locking both row and column with `$A$1` creates an _______ Cell Reference.", "FILL_BLANK", "Absolute", "Absolute", "", "", "Absolute"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["What is the result of `=IF(AND(70 >= 50, 80 >= 75), \"Distinction\", \"Pass\")` in Excel?", "MCQ", "\"Distinction\" (since both conditions are TRUE)", "\"Pass\"", "FALSE", "Error", "A"],
                  ["What error code appears in an Excel formula when a calculation attempts to divide a number by 0?", "MCQ", "#DIV/0!", "#NAME?", "#VALUE!", "#REF!", "A"],
                  ["What does the `#REF!` error in Excel signify?", "MCQ", "A cell reference in the formula is invalid (e.g. the referenced row or column was deleted)", "Spelling error in function name", "Empty cell", "Number is too large", "A"],
                  ["Which Excel tool allows combining multiple worksheet data sets from different branches into a single consolidated summary sheet?", "MCQ", "Consolidate Data (Data Tab)", "Mail Merge", "Format Painter", "AutoCorrect", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["A sales dataset has 10,000 transactions across 20 cities. Management wants a report of Total Sales by Region and Category in 30 seconds. What tool is used?", "MCQ", "Insert a PivotTable with Region in Rows, Category in Columns, and Sum of Sales in Values", "Calculate each city manually with a pocket calculator", "Draw 20 individual line charts", "Write 10,000 IF formulas", "A"],
                  ["A student has scored 72 in Math and 68 in Science. The passing average required across 3 subjects is 75. How can they find the needed English score in Excel?", "MCQ", "Use Goal Seek: Set Average cell to 75 by changing the English mark cell", "Use Conditional Formatting", "Sort marks in descending order", "Freeze Panes", "A"],
                  ["What formula counts how many employees in column B earn more than 50,000?", "MCQ", "=COUNTIF(B2:B500, \">50000\")", "=SUMIF(B2:B500, \">50000\")", "=COUNT(B2:B500, \">50000\")", "=IF(B2:B500>50000)", "A"],
                  ["Why is protecting worksheets with sheet passwords important in financial models?", "MCQ", "To prevent accidental deletion or unauthorized tampering with proprietary formula cells while allowing input in designated fields", "To make Excel files run on TV", "To reduce file size by 90%", "To convert formulas into pictures", "A"],
                  ["What is a Macro in Microsoft Excel?", "MCQ", "A recorded sequence of automated keystrokes and VBA code used to execute repetitive multi-step tasks with a single click or shortcut", "A large display chart", "A type of font", "A high-capacity hard disk", "A"]
                ]
              }
            ]
          }
        ]
      },
      {
        unitNumber: 4,
        unitName: "Unit 4 – Python Sequences & String Algorithms",
        chapters: [
          {
            num: 6,
            name: "CBSE 9 - Python Sequences, Lists & Data Structures",
            missions: [
              {
                mNum: 1,
                q: [
                  ["What is the output of the following Python list code?\n```python\nnums = [10, 20, 30, 40, 50]\nprint(nums[1:4])\n```", "MCQ", "[20, 30, 40] (Slice from index 1 up to 3)", "[10, 20, 30]", "[20, 30, 40, 50]", "[10, 20, 30, 40]", "A", "python"],
                  ["Which built-in Python list method removes and returns the last element from a list?", "MCQ", "list.pop()", "list.remove()", "list.delete()", "list.clear()", "A", "python"],
                  ["What is the output of `min([45, 12, 89, 3, 67])` in Python?", "MCQ", "3", "89", "12", "45", "A", "python"],
                  ["Which list method inserts an element at a specific index position `list.insert(index, element)`?", "MCQ", "list.insert()", "list.append()", "list.push()", "list.add()", "A", "python"],
                  ["How do you sort a Python list `nums` in descending order in-place?", "MCQ", "nums.sort(reverse=True)", "nums.reverse_sort()", "sort(nums, desc)", "nums.desc()", "A", "python"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["The method used to add an element at the end of a list is list._______().", "FILL_BLANK", "append", "append", "", "", "append"],
                  ["The method that returns the index of the first occurrence of an item in a list is list._______().", "FILL_BLANK", "index", "index", "", "", "index"],
                  ["The method that counts how many times an element appears in a list is list._______().", "FILL_BLANK", "count", "count", "", "", "count"],
                  ["The function that returns the sum of all numeric items in a list is _______().", "FILL_BLANK", "sum", "sum", "", "", "sum"],
                  ["An immutable sequence enclosed in parentheses `(1, 2, 3)` in Python is a _______.", "FILL_BLANK", "tuple", "tuple", "", "", "tuple"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["What is the output of:\n```python\na = [1, 2]\nb = [3, 4]\nprint(a + b)\n```", "MCQ", "[1, 2, 3, 4] (List concatenation)", "[4, 6]", "[[1, 2], [3, 4]]", "Error", "A", "python"],
                  ["What is the output of `print([0] * 4)` in Python?", "MCQ", "[0, 0, 0, 0] (List replication)", "[0, 4]", "0", "[0000]", "A", "python"],
                  ["What is the fundamental difference between a Python List and a Tuple?", "MCQ", "Lists are mutable (can be changed); Tuples are immutable (cannot be modified after creation)", "Tuples can only hold numbers", "Lists cannot be printed", "Tuples have no index", "A", "python"],
                  ["What will `del nums[0]` do to a non-empty list `nums`?", "MCQ", "Permanently deletes the first element at index 0 from the list", "Clears the entire list", "Sets index 0 to None", "Raises syntax error", "A", "python"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["What will the following code print?\n```python\nscores = [80, 95, 70, 95, 60]\nprint(scores.count(95))\n```", "MCQ", "2", "1", "95", "5", "A", "python"],
                  ["What is the output of:\n```python\nvals = [10, 20, 30]\nvals.extend([40, 50])\nprint(len(vals))\n```", "MCQ", "5", "4", "3", "Error", "A", "python"],
                  ["A student writes:\n```python\ntup = (10, 20, 30)\ntup[0] = 99\n```\nWhat happens when this code is executed?", "MCQ", "Python raises `TypeError: 'tuple' object does not support item assignment`", "tup becomes (99, 20, 30)", "tup becomes [99, 20, 30]", "Python deletes the variable", "A", "python"],
                  ["How do you create a copy of a list `original` without creating a linked reference?", "MCQ", "copied = original.copy() or original[:]", "copied = original", "copied = new list", "copied == original", "A", "python"],
                  ["Why are Tuples used instead of Lists for sensitive data like database configuration credentials or geographic coordinates?", "MCQ", "Immutability guarantees data integrity and prevents accidental modification by unauthorized functions", "Tuples run without RAM", "Tuples are faster to print on paper", "Lists cannot hold strings", "A", "python"]
                ]
              }
            ]
          },
          {
            num: 7,
            name: "CBSE 9 - String Manipulation & Pattern Processing in Python",
            missions: [
              {
                mNum: 1,
                q: [
                  ["What will `\"computer\".capitalize()` return in Python?", "MCQ", "\"Computer\"", "\"COMPUTER\"", "\"computer\"", "\"C\"", "A", "python"],
                  ["What is the output of `\"Hello World\".split()` in Python?", "MCQ", "['Hello', 'World'] (List of words split by whitespace)", "('Hello', 'World')", "\"HelloWorld\"", "['H', 'e', 'l', 'l', 'o']", "A", "python"],
                  ["Which string method tests if all characters in a string are alphabetical letters (A-Z, a-z)?", "MCQ", "str.isalpha()", "str.isdigit()", "str.isalnum()", "str.isnumeric()", "A", "python"],
                  ["Which string method tests if all characters in a string are numeric digits (0-9)?", "MCQ", "str.isdigit()", "str.isalpha()", "str.isspace()", "str.isupper()", "A", "python"],
                  ["What is the output of `\"Python\".find(\"th\")` in Python?", "MCQ", "2 (Index position where 'th' starts)", "3", "True", "-1", "A", "python"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["The method that joins a list of strings into a single string with a separator is separator._______(list).", "FILL_BLANK", "join", "join", "", "", "join"],
                  ["The method that replaces all occurrences of a substring with another is str._______(old, new).", "FILL_BLANK", "replace", "replace", "", "", "replace"],
                  ["If `str.find(sub)` does not find the substring in the string, it returns _______.", "FILL_BLANK", "-1", "-1", "", "", "-1"],
                  ["The method that checks if a string begins with a specified prefix is str._______(prefix).", "FILL_BLANK", "startswith", "startswith", "", "", "startswith"],
                  ["The method that checks if a string ends with a specified suffix is str._______(suffix).", "FILL_BLANK", "endswith", "endswith", "", "", "endswith"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["What is the output of `print(\"-\".join([\"2026\", \"09\", \"04\"]))`?", "MCQ", "\"2026-09-04\"", "\"20260904-\"", "[\"2026-09-04\"]", "Error", "A", "python"],
                  ["What will `\"Banana\".replace(\"a\", \"o\")` return in Python?", "MCQ", "\"Bonono\"", "\"Bonana\"", "\"Banana\"", "Error", "A", "python"],
                  ["What does string slicing `text[::-1]` accomplish on any string `text` in Python?", "MCQ", "Reverses the entire string", "Prints every even letter", "Deletes the string", "Capitalizes all letters", "A", "python"],
                  ["What is the output of `\"Python\".lower().islower()`?", "MCQ", "True", "False", "None", "Error", "A", "python"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["A program checks if a word is a Palindrome (reads same backwards e.g. 'madam'). What is the fastest Python expression?", "MCQ", "word == word[::-1]", "word.reverse()", "word.islower()", "word.palindrome()", "A", "python"],
                  ["What will the following code output?\n```python\ntext = \"CBSE Class 9\"\nprint(len(text))\n```", "MCQ", "12 (including spaces)", "10", "11", "9", "A", "python"],
                  ["What is the output of `\"  Science  \".strip()`?", "MCQ", "\"Science\" (whitespace removed)", "\"  Science  \"", "\"Science  \"", "\"  Science\"", "A", "python"],
                  ["Why are strings called 'Immutable' in Python?", "MCQ", "Individual characters inside an existing string cannot be changed or assigned in-place (`str[0] = 'X'` fails)", "Strings cannot be printed", "Strings have no length", "Strings cannot contain numbers", "A", "python"],
                  ["What does formatted string literal (f-string) `f\"Student: {name}, Score: {score}\"` provide in modern Python?", "MCQ", "A clean, highly readable, efficient syntax for inline string interpolation and variable formatting", "Encrypted string data", "A database query", "A cloud upload", "A", "python"]
                ]
              }
            ]
          }
        ]
      }
    ]
  }
];
