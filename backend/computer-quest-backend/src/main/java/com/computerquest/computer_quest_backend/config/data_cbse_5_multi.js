// =========================================================================
// CBSE CLASSES 5, 6, 7 (MULTI-UNIT OFFICIAL CURRICULA)
// Age-Appropriate Progressive Questions (NCERT / CBSE Guidelines)
// =========================================================================

module.exports = [
  // -------------------------------------------------------------
  // CBSE CLASS 5 (Foundational logic, productivity & Scratch 3.0)
  // -------------------------------------------------------------
  {
    board: "CBSE",
    classLevel: 5,
    units: [
      {
        unitNumber: 1,
        unitName: "Unit 1 – Advanced Computing Systems & Generations",
        chapters: [
          {
            num: 1,
            name: "CBSE 5 - Computer Generations and Hardware Architecture",
            missions: [
              {
                mNum: 1,
                q: [
                  ["Which main electronic component was used inside First Generation computers (1940-1956)?", "MCQ", "Vacuum Tubes", "Transistors", "Integrated Circuits", "Microprocessors", "A"],
                  ["Second generation computers replaced bulky vacuum tubes with smaller, faster _______.", "MCQ", "Transistors", "Vacuum Tubes", "Floppy Disks", "Microchips", "A"],
                  ["Which generation of computers introduced Integrated Circuits (ICs) on silicon chips?", "MCQ", "Third Generation", "First Generation", "Second Generation", "Fifth Generation", "A"],
                  ["Fourth generation computers are powered by which modern electronic brain component?", "MCQ", "Microprocessors (VLSI)", "Vacuum Tubes", "Magnetic Valves", "Punched Cards", "A"],
                  ["Fifth generation computing is focused on developing which advanced technology?", "MCQ", "Artificial Intelligence (AI)", "Vacuum Tubes", "Mechanical Gears", "Punch Paper", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["First generation computers used _______ tubes for circuitry.", "FILL_BLANK", "Vacuum", "Vacuum, Vacuum tubes", "", "", "Vacuum"],
                  ["The physical socket where peripherals like mouse and keyboard plug in is a _______.", "FILL_BLANK", "Port", "Port, USB Port", "", "", "Port"],
                  ["Integrated Circuits (ICs) are manufactured on small chips made of _______.", "FILL_BLANK", "Silicon", "Silicon", "", "", "Silicon"],
                  ["The main circuit board inside a computer that connects all parts is the _______.", "FILL_BLANK", "Motherboard", "Motherboard", "", "", "Motherboard"],
                  ["Fifth generation computers aim to mimic human intelligence using _______.", "FILL_BLANK", "AI", "AI, Artificial Intelligence", "", "", "AI"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["Which early electronic digital computer occupied an entire room and was built in 1946?", "MCQ", "ENIAC", "MacBook", "iPad", "iPhone", "A"],
                  ["Which port is the universal rectangular port used to connect pendrives, keyboards, and mice?", "MCQ", "USB Port", "VGA Port", "Audio Jack", "Power Socket", "A"],
                  ["Which high-definition port transmits both digital video and audio to modern monitors?", "MCQ", "HDMI Port", "Serial Port", "Parallel Port", "PS/2 Port", "A"],
                  ["What protects internal computer components from sudden electrical surges?", "MCQ", "UPS (Uninterruptible Power Supply)", "Mouse Pad", "Webcam Cover", "USB Hub", "A"],
                  ["Which type of software tells computer hardware how to operate (e.g. Windows, macOS, Linux)?", "MCQ", "System Software", "Application Game", "Paint Drawing", "Word File", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["Why were first-generation computers placed in specially cooled rooms?", "MCQ", "They contained thousands of vacuum tubes that generated immense heat", "They needed rain water", "To keep keyboards dry", "To save paper", "A"],
                  ["A desktop PC loses power instantly when electricity cuts out. What device provides backup battery power for 20 minutes?", "MCQ", "UPS", "Scanner", "Printer", "Modem", "A"],
                  ["How did microprocessors revolutionize personal computing in the fourth generation?", "MCQ", "They packed millions of transistors onto one small chip, making PCs compact and affordable", "They made computers heavier", "They required more electricity", "They replaced monitors", "A"],
                  ["Which unit inside the CPU manages the flow of data between memory, ALU, and devices?", "MCQ", "Control Unit (CU)", "Cooling Fan", "Power Cable", "Speaker", "A"],
                  ["Smart voice assistants like Siri and Google Assistant are early examples of which computer generation?", "MCQ", "Fifth Generation (AI)", "First Generation", "Second Generation", "Third Generation", "A"]
                ]
              }
            ]
          },
          {
            num: 2,
            name: "CBSE 5 - Memory Hierarchy & Secondary Storage",
            missions: [
              {
                mNum: 1,
                q: [
                  ["Which storage device uses flash memory with no moving mechanical parts for super-fast speeds?", "MCQ", "Solid State Drive (SSD)", "Floppy Disk", "Magnetic Tape", "Punched Tape", "A"],
                  ["How many Megabytes (MB) make exactly 1 Gigabyte (GB)?", "MCQ", "1024 MB", "100 MB", "500 MB", "10 MB", "A"],
                  ["Which memory holds the computer's basic startup program called BIOS?", "MCQ", "ROM (Read Only Memory)", "RAM", "Cache", "Pen Drive", "A"],
                  ["1 Terabyte (TB) of digital storage is equal to how many Gigabytes (GB)?", "MCQ", "1024 GB", "100 GB", "10 GB", "512 GB", "A"],
                  ["Which optical disc has a larger storage capacity than a standard DVD (up to 25 GB or 50 GB)?", "MCQ", "Blu-ray Disc", "CD-ROM", "Floppy Disk", "Cassette", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["1 Gigabyte (GB) = _______ Megabytes (MB).", "FILL_BLANK", "1024", "1024", "", "", "1024"],
                  ["Fast non-mechanical flash storage replacing traditional HDDs is called _______.", "FILL_BLANK", "SSD", "SSD, Solid State Drive", "", "", "SSD"],
                  ["The high-speed memory placed between CPU and RAM to speed up processing is _______ memory.", "FILL_BLANK", "Cache", "Cache", "", "", "Cache"],
                  ["Storing your files safely on remote internet servers is called _______ Storage.", "FILL_BLANK", "Cloud", "Cloud, Cloud Storage", "", "", "Cloud"],
                  ["1 Terabyte (TB) = _______ Gigabytes (GB).", "FILL_BLANK", "1024", "1024", "", "", "1024"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["Which of the following is a popular free cloud storage service by Google?", "MCQ", "Google Drive", "MS Paint", "Notepad", "VLC Player", "A"],
                  ["Why is secondary storage necessary in addition to primary memory (RAM)?", "MCQ", "Because RAM is volatile and loses all files when power turns off", "Because RAM has no speed", "Because monitors need it", "Because printers cannot read RAM", "A"],
                  ["Which memory hierarchy level is the fastest and closest to the CPU core?", "MCQ", "CPU Registers and Cache", "Hard Disk", "Pen Drive", "Cloud Server", "A"],
                  ["Which storage device uses magnetic platters spinning at 7200 RPM to store data?", "MCQ", "Hard Disk Drive (HDD)", "RAM Stick", "Memory Card", "Flash ROM", "A"],
                  ["Which unit order is correctly arranged from smallest to largest capacity?", "MCQ", "Bit < Byte < KB < MB < GB < TB", "TB < GB < MB < KB < Byte < Bit", "MB < KB < GB < Byte < TB", "Byte < MB < KB < TB < GB", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["A student wants to back up their school project so they can access it from home, school, and mobile. What is best?", "MCQ", "Save to Cloud Storage (e.g. Google Drive or OneDrive)", "Write it down on paper only", "Leave it in temporary RAM", "Disconnect internet", "A"],
                  ["A video file has a size of 2048 MB. How many Gigabytes (GB) is that?", "MCQ", "2 GB (since 1024 MB = 1 GB)", "10 GB", "20 GB", "0.5 GB", "A"],
                  ["Why does a computer with an SSD boot up in 10 seconds while an older HDD takes 1 minute?", "MCQ", "SSDs use electronic flash chips with zero moving parts and ultra-high read speeds", "SSDs have smaller screens", "SSDs use more electricity", "SSDs delete old files", "A"],
                  ["Which type of optical media allows you to write, erase, and rewrite data multiple times?", "MCQ", "CD-RW / DVD-RW", "CD-R (Recordable only once)", "ROM Chip", "Vinyl Record", "A"],
                  ["What happens if your computer runs out of available RAM while multiple heavy apps are open?", "MCQ", "The system slows down and uses Virtual Memory on the storage drive", "The computer explodes", "The keyboard stops typing numbers", "The monitor turns off permanently", "A"]
                ]
              }
            ]
          }
        ]
      },
      {
        unitNumber: 2,
        unitName: "Unit 2 – Digital Productivity & Visual Presentations",
        chapters: [
          {
            num: 3,
            name: "CBSE 5 - Advanced Document Formatting & Tables in Word",
            missions: [
              {
                mNum: 1,
                q: [
                  ["In Microsoft Word, repeated text appearing at the very top of every page is called a _______.", "MCQ", "Header", "Footer", "Watermark", "Hyperlink", "A"],
                  ["Repeated text or page numbers appearing at the very bottom of every page is called a _______.", "MCQ", "Footer", "Header", "Title", "Margin", "A"],
                  ["A grid of horizontal rows and vertical columns used to organize data is a _______.", "MCQ", "Table", "Paragraph", "Shape", "ClipArt", "A"],
                  ["The small rectangular box formed by the intersection of a row and a column in a table is a _______.", "MCQ", "Cell", "Block", "Margin", "Bullet", "A"],
                  ["Which feature in Word copies formatting from one piece of text and applies it to another?", "MCQ", "Format Painter", "Cut and Paste", "Spell Check", "WordArt", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["The blank white space left around the edges of a printed page is the _______.", "FILL_BLANK", "Margin", "Margin, Margins", "", "", "Margin"],
                  ["Text that appears at the top of every page is the _______.", "FILL_BLANK", "Header", "Header", "", "", "Header"],
                  ["Text that appears at the bottom of every page is the _______.", "FILL_BLANK", "Footer", "Footer", "", "", "Footer"],
                  ["Combining two or more table cells into a single larger cell is called _______ cells.", "FILL_BLANK", "Merging", "Merging, Merge", "", "", "Merging"],
                  ["A faint, ghosted text or image printed behind the page content is a _______.", "FILL_BLANK", "Watermark", "Watermark", "", "", "Watermark"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["Which ribbon tab in MS Word is used to insert Tables, Shapes, Headers, and Page Numbers?", "MCQ", "Insert Tab", "View Tab", "Help Tab", "File Tab", "A"],
                  ["Which orientation makes the printed page wider than it is tall (horizontal layout)?", "MCQ", "Landscape Orientation", "Portrait Orientation", "Square Orientation", "Column Orientation", "A"],
                  ["Which page orientation is taller than it is wide (standard vertical book page)?", "MCQ", "Portrait Orientation", "Landscape Orientation", "Diagonal", "Wide", "A"],
                  ["What does the 'Find and Replace' feature (Ctrl + H) do in Microsoft Word?", "MCQ", "Locates a specific word and replaces it with another word throughout the document", "Deletes all pictures", "Changes font color to green", "Prints 10 copies", "A"],
                  ["Which tool in Word allows you to decorative 3D stylized text with shadows and outlines?", "MCQ", "WordArt", "Format Painter", "Page Break", "Header", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["You are creating a school test paper and want your school's name at the top of all 5 pages automatically. What should you use?", "MCQ", "Insert a Header with the school name", "Type it manually on every line", "Change document margins", "Use Landscape mode", "A"],
                  ["You need to present a weekly class timetable (Monday to Friday, Periods 1 to 8). What is the best Word element?", "MCQ", "A Table with 6 columns and 9 rows", "A single paragraph", "A bulleted list", "A watermark", "A"],
                  ["You typed the word 'computer' as 'computr' 25 times in a report. How can you correct all 25 mistakes instantly?", "MCQ", "Use 'Replace All' (Ctrl + H) to replace 'computr' with 'computer'", "Delete the document and start again", "Reboot Windows", "Print and use a pen", "A"],
                  ["You want to mark your science notes with a diagonal faint word 'CONFIDENTIAL' across the background. What tool is used?", "MCQ", "Watermark", "Format Painter", "Page Border", "Drop Cap", "A"],
                  ["Which tool splits a single table cell into multiple smaller cells?", "MCQ", "Split Cells", "Merge Cells", "Delete Table", "Format Painter", "A"]
                ]
              }
            ]
          },
          {
            num: 4,
            name: "CBSE 5 - Presentation Design & Slide Masters in PowerPoint",
            missions: [
              {
                mNum: 1,
                q: [
                  ["Which Microsoft Office application is designed specifically for creating multimedia slide presentations?", "MCQ", "Microsoft PowerPoint", "Microsoft Excel", "Notepad", "Paint", "A"],
                  ["An individual page in a PowerPoint presentation containing text, pictures, or charts is called a _______.", "MCQ", "Slide", "Sheet", "Document", "Cell", "A"],
                  ["Which keyboard function key is pressed to start a full-screen Slide Show from the beginning?", "MCQ", "F5 Key", "F1 Key", "F2 Key", "F12 Key", "A"],
                  ["The visual motion effect that occurs when moving from one slide to the next slide is called a _______.", "MCQ", "Slide Transition", "Animation", "Hyperlink", "Master Layout", "A"],
                  ["Visual motion and sound effects applied to individual text or objects on a single slide are called _______.", "MCQ", "Custom Animations", "Slide Transitions", "Themes", "Watermarks", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["A single page of a presentation is called a _______.", "FILL_BLANK", "Slide", "Slide", "", "", "Slide"],
                  ["The shortcut key to start a slide show from the current slide is Shift + F_______.", "FILL_BLANK", "5", "5, F5", "", "", "5"],
                  ["Visual movement applied to text or pictures on a slide is an _______.", "FILL_BLANK", "Animation", "Animation", "", "", "Animation"],
                  ["The top slide in a presentation hierarchy that controls the theme and layout for all slides is the Slide _______.", "FILL_BLANK", "Master", "Master", "", "", "Master"],
                  ["The default file extension for PowerPoint 2016/2019/365 presentations is ._______.", "FILL_BLANK", "pptx", "pptx, PPTX", "", "", "pptx"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["Which view in PowerPoint displays thumbnail miniatures of all slides for easy reordering?", "MCQ", "Slide Sorter View", "Normal View", "Reading View", "Slide Show View", "A"],
                  ["What are the pre-designed color palettes, fonts, and background styles in PowerPoint called?", "MCQ", "Themes", "Templates", "Animations", "Transitions", "A"],
                  ["Which ribbon tab contains tools to insert audio clips, videos, and screen recordings into slides?", "MCQ", "Insert Tab", "Design Tab", "Transitions Tab", "Review Tab", "A"],
                  ["Which animation category makes an object appear onto the slide during presentation?", "MCQ", "Entrance Animation", "Exit Animation", "Emphasis Animation", "Motion Path", "A"],
                  ["Which key on the keyboard immediately exits and stops an active full-screen Slide Show?", "MCQ", "Esc (Escape) Key", "Spacebar", "Enter Key", "Tab Key", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["A student is giving a seminar on 'Solar System'. How can they make the planets glide smoothly into view?", "MCQ", "Apply Entrance Motion Animations to each planet image", "Delete the slide", "Use Word Wrap", "Change font to bold", "A"],
                  ["You want your company's logo to automatically appear on the exact same bottom-right corner of all 50 slides. How should you do it?", "MCQ", "Add the logo once onto the Slide Master", "Paste it manually 50 times", "Put it in Recycle Bin", "Change slide orientation", "A"],
                  ["You want your audience to see a dramatic 'Dissolve' effect when advancing to the conclusion slide. What should you apply?", "MCQ", "A Slide Transition effect to the conclusion slide", "A font style change", "A bullet point", "A page number", "A"],
                  ["Which view is used by speakers to see current slide, upcoming slide, and private speaker notes simultaneously?", "MCQ", "Presenter View", "Slide Sorter View", "Notes Master", "Reading View", "A"],
                  ["Why are bullet points and pictures preferred over long heavy paragraphs on PowerPoint slides?", "MCQ", "Slides are meant for visual impact and quick audience understanding", "Because PowerPoint cannot type paragraphs", "To make the file 100 GB", "To print faster", "A"]
                ]
              }
            ]
          }
        ]
      },
      {
        unitNumber: 3,
        unitName: "Unit 3 – Coding Logic & Internet Awareness",
        chapters: [
          {
            num: 5,
            name: "CBSE 5 - Visual Block Programming with Scratch 3.0",
            missions: [
              {
                mNum: 1,
                q: [
                  ["In Scratch 3.0, which block category contains blocks like 'repeat 10' and 'forever' loops?", "MCQ", "Control Blocks (Yellow/Gold)", "Motion Blocks", "Looks Blocks", "Sound Blocks", "A"],
                  ["A programming structure that repeats a block of instructions multiple times is a _______.", "MCQ", "Loop / Iteration", "Variable", "Costume", "Stage", "A"],
                  ["In Scratch, which block makes a sprite bounce back when it hits the edge of the stage?", "MCQ", "if on edge, bounce", "stop all", "hide", "glide to random", "A"],
                  ["Which block makes a sprite wait for a specified number of seconds before taking the next step?", "MCQ", "wait 1 seconds (Control Block)", "move 10 steps", "turn 15 degrees", "say Hello", "A"],
                  ["The different visual appearances or poses of a single sprite in Scratch are called _______.", "MCQ", "Costumes", "Backdrops", "Variables", "Sounds", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["A loop in Scratch that repeats instructions endlessly without stopping is the _______ loop.", "FILL_BLANK", "Forever", "Forever", "", "", "Forever"],
                  ["Different visual outfits or poses of a sprite are called _______.", "FILL_BLANK", "Costumes", "Costumes", "", "", "Costumes"],
                  ["To store a changing number like a game score in Scratch, we create a _______.", "FILL_BLANK", "Variable", "Variable", "", "", "Variable"],
                  ["The background picture of the Scratch stage is called a _______.", "FILL_BLANK", "Backdrop", "Backdrop", "", "", "Backdrop"],
                  ["Blocks that check conditions like 'touching mouse pointer?' belong to the _______ category.", "FILL_BLANK", "Sensing", "Sensing", "", "", "Sensing"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["Which Scratch block block evaluates a condition and executes code only if that condition is true?", "MCQ", "if <condition> then (Conditional Block)", "forever", "repeat until", "wait 1 sec", "A"],
                  ["In Scratch coordinates, what is the (X, Y) coordinate position of the exact center of the stage?", "MCQ", "X: 0, Y: 0", "X: 100, Y: 100", "X: -240, Y: 180", "X: 240, Y: -180", "A"],
                  ["Which block category (Green) contains mathematical blocks for addition (+), subtraction (-), and pick random?", "MCQ", "Operators Blocks", "Sensing Blocks", "Variables", "Control Blocks", "A"],
                  ["What tool in Scratch allows you to draw and design your own custom sprites and backdrops?", "MCQ", "Paint Editor", "Sound Editor", "Code Workspace", "File Menu", "A"],
                  ["What does the 'broadcast message' block do in Scratch?", "MCQ", "Sends a secret signal to other sprites to trigger scripts simultaneously", "Deletes the project", "Turns off speakers", "Saves the file to pen drive", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["You want a bird sprite to flap its wings continuously while moving forward across the stage. What code loop is needed?", "MCQ", "forever -> [ move 10 steps -> next costume -> wait 0.1 secs -> if on edge, bounce ]", "stop all", "say Hello once", "hide sprite", "A"],
                  ["You are creating a coin collection game. When the player sprite touches a gold coin sprite, what should happen?", "MCQ", "if touching Player? -> change score by 1 and play sound Coin", "delete player", "turn screen black", "close Scratch", "A"],
                  ["What is the advantage of using a 'repeat 4' loop when drawing a square instead of writing 4 duplicate blocks?", "MCQ", "It makes the code concise, efficient, and easier to modify", "It uses more disk space", "It slows down the animation", "It makes the square circular", "A"],
                  ["Which block allows a sprite to smoothly glide to a specific position over a given time?", "MCQ", "glide 1 secs to x: y:", "move 10 steps", "turn 90 degrees", "point in direction", "A"],
                  ["Why is testing and running your Scratch script step-by-step important?", "MCQ", "To find and fix errors (bugs) in the game logic", "To make the sprite heavier", "To change the monitor colors", "To disconnect the mouse", "A"]
                ]
              }
            ]
          },
          {
            num: 6,
            name: "CBSE 5 - Internet Exploration, Search Engines & Safe Browsing",
            missions: [
              {
                mNum: 1,
                q: [
                  ["A massive global network connecting millions of computers worldwide is called the _______.", "MCQ", "Internet", "Intranet", "LAN", "Bluetooth", "A"],
                  ["What software application is used to access, view, and navigate websites on the Internet?", "MCQ", "Web Browser (e.g. Google Chrome, Edge)", "MS Excel", "Calculator", "Notepad", "A"],
                  ["What does WWW stand for in website addresses?", "MCQ", "World Wide Web", "World Wild Web", "World Wide Window", "Web World Wide", "A"],
                  ["The unique website address used to open a web page (e.g. https://www.google.com) is called a _______.", "MCQ", "URL (Uniform Resource Locator)", "CPU", "RAM", "BIOS", "A"],
                  ["Which website tool helps you find information, articles, and pictures by typing keywords?", "MCQ", "Search Engine (e.g. Google, Bing)", "Recycle Bin", "Paint", "File Explorer", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["WWW stands for World Wide _______.", "FILL_BLANK", "Web", "Web", "", "", "Web"],
                  ["The first introductory page displayed when opening any website is its _______ Page.", "FILL_BLANK", "Home", "Home", "", "", "Home"],
                  ["A clickable highlighted link that takes you from one web page to another is a _______.", "FILL_BLANK", "Hyperlink", "Hyperlink, Link", "", "", "Hyperlink"],
                  ["The padlock icon (🔒) in a browser address bar indicates that the website connection is _______.", "FILL_BLANK", "Secure", "Secure, Safe, Encrypted", "", "", "Secure"],
                  ["Never share your secret account _______ with strangers on the internet.", "FILL_BLANK", "Password", "Password", "", "", "Password"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["Which protocol prefix in a web address indicates secure, encrypted communication?", "MCQ", "https://", "http://", "ftp://", "file://", "A"],
                  ["What is a 'Digital Footprint'?", "MCQ", "The trail of data and online activity you leave behind when using the internet", "A shoe print near your computer", "A mouse click sound", "A printed page", "A"],
                  ["Which of the following is a strong, secure password practice?", "MCQ", "Using a combination of uppercase, lowercase letters, numbers, and symbols", "Using '123456' or 'password'", "Using your own nickname only", "Sharing password on social media", "A"],
                  ["What should you do if an unknown stranger online asks for your home address or school name?", "MCQ", "Never share personal details and immediately inform your parents or teacher", "Give full address and phone number", "Invite them home", "Send your photo", "A"],
                  ["What is downloading?", "MCQ", "Copying a file or image from the internet onto your local computer storage", "Sending a file to the web", "Deleting a file from desktop", "Shutting down the PC", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["You are researching 'Indian National Parks' for your science project. What is the most effective search query?", "MCQ", "Indian National Parks list wildlife facts", "give me everything now please", "parks", "animals", "A"],
                  ["A flashy pop-up on an unknown website claims 'Congratulations! You won a free iPhone! Click here to claim!'. What should you do?", "MCQ", "Close the suspicious pop-up immediately; it is likely a phishing scam or malware", "Click it and enter credit card info", "Share with 50 friends", "Download the unknown file", "A"],
                  ["Why should you never download software or game cheats from unauthorized, shady websites?", "MCQ", "They may contain computer viruses and malware that steal data and damage your system", "They make computer too fast", "They clean your hard disk", "They change your mouse color", "A"],
                  ["Which browser feature allows you to save your favorite learning website for instant access later?", "MCQ", "Bookmarks / Favorites (Ctrl + D)", "Clear History", "Close Tab", "Inspect Element", "A"],
                  ["What is 'Cyberbullying' and what is the proper action if you experience it?", "MCQ", "Using digital messages to tease, threaten, or harass someone; report it to trusted adults immediately", "A video game level", "A high-speed internet cable", "A type of keyboard shortcut", "A"]
                ]
              }
            ]
          }
        ]
      }
    ]
  }
];
