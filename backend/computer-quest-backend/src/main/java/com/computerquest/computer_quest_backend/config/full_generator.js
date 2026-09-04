const fs = require('fs');
const path = require('path');

const targetFile = "c:\\Users\\ADMIN\\OneDrive\\Documents\\Computer-Quest\\backend\\computer-quest-backend\\src\\main\\java\\com\\computerquest\\computer_quest_backend\\config\\Class4To10SyllabusSeeder.java";

const allData = [
  // ==========================================
  // CBSE CLASS 4
  // ==========================================
  {
    board: "CBSE",
    classLevel: 4,
    unitName: "UNIT 1 – COMPUTERS AND DIGITAL EXPLORATION",
    chapters: [
      {
        num: 1,
        name: "CBSE 4 - Evolution of Computers & Computing Devices",
        missions: [
          {
            mNum: 1,
            q: [
              ["Which ancient calculating tool uses beads on wooden rods?", "MCQ", "Abacus", "Calculator", "Keyboard", "Mouse", "A"],
              ["Who is widely recognized as the 'Father of the Computer'?", "MCQ", "Charles Babbage", "Albert Einstein", "Thomas Edison", "Bill Gates", "A"],
              ["Which type of computer is portable, lightweight, and operates on a rechargeable battery?", "MCQ", "Supercomputer", "Laptop", "Desktop PC", "Mainframe", "B"],
              ["What does CPU stand for in computer systems?", "MCQ", "Central Processing Unit", "Central Power Unit", "Computer Program Unit", "Control Process Unit", "A"],
              ["Which device is used to enter text, numbers, and commands into a computer?", "MCQ", "Monitor", "Keyboard", "Speaker", "Printer", "B"]
            ]
          },
          {
            mNum: 2,
            q: [
              ["A handheld computer with a touchscreen display is called a _______.", "FILL_BLANK", "Tablet", "Tablet, Tab, iPad", "", "", "Tablet"],
              ["Early computers in the first generation used _______ tubes.", "FILL_BLANK", "Vacuum", "Vacuum, Vacuum tubes", "", "", "Vacuum"],
              ["The output shown on a monitor screen is called _______ copy.", "FILL_BLANK", "Soft", "Soft, Soft copy", "", "", "Soft"],
              ["Printed output on a sheet of paper is called _______ copy.", "FILL_BLANK", "Hard", "Hard, Hard copy", "", "", "Hard"],
              ["The brain of the computer that performs all calculations is the _______.", "FILL_BLANK", "CPU", "CPU, Central Processing Unit", "", "", "CPU"]
            ]
          },
          {
            mNum: 3,
            q: [
              ["Which of the following is the world's fastest and most powerful type of computer?", "MCQ", "Microcomputer", "Supercomputer", "Tablet", "Desktop", "B"],
              ["Which computer device produces sound output such as music and voice?", "MCQ", "Speakers", "Scanner", "Microphone", "Webcam", "A"],
              ["Which device is used to capture photographs and send live video over the internet?", "MCQ", "Webcam", "Printer", "Plotter", "Hard Disk", "A"],
              ["Which unit inside the CPU controls and coordinates all parts of the computer?", "MCQ", "ALU", "Control Unit", "Memory Unit", "Power Supply", "B"],
              ["Which machine invented by Blaise Pascal in 1642 could add and subtract numbers?", "MCQ", "Pascaline", "Abacus", "ENIAC", "Analytical Engine", "A"]
            ]
          },
          {
            mNum: 4,
            q: [
              ["A scientist needs to calculate heavy weather forecast simulations across the globe. Which computer should they choose?", "MCQ", "Supercomputer", "Smart Watch", "Pocket Calculator", "Game Console", "A"],
              ["A student wants to read an e-book and draw with a stylus while traveling. Which portable device is most suitable?", "MCQ", "Desktop Tower", "Tablet PC", "Mainframe Server", "Barcode Reader", "B"],
              ["You need to convert a physical printed drawing into a digital picture on your computer screen. What device will you use?", "MCQ", "Scanner", "Speaker", "Projector", "Headphones", "A"],
              ["Which cycle represents the basic working principle of all modern computer operations?", "MCQ", "Input - Process - Output", "Process - Output - Input", "Output - Input - Process", "Store - Delete - Print", "A"],
              ["A cashier scans barcodes on grocery items at the supermarket checkout. Which device is used?", "MCQ", "Barcode Scanner", "Microphone", "Inkjet Printer", "Plotter", "A"]
            ]
          }
        ]
      },
      {
        num: 2,
        name: "CBSE 4 - Computer Memory and Storage Devices",
        missions: [
          {
            mNum: 1,
            q: [
              ["What is the smallest unit of digital computer memory measurement?", "MCQ", "Bit", "Byte", "Kilobyte", "Megabyte", "A"],
              ["How many bits are grouped together to form one Byte?", "MCQ", "4 bits", "8 bits", "16 bits", "32 bits", "B"],
              ["Which computer memory is volatile and loses its stored content when the power is turned off?", "MCQ", "RAM", "ROM", "Hard Disk", "Pen Drive", "A"],
              ["Which memory contains non-volatile, permanent startup instructions that cannot be easily modified?", "MCQ", "ROM", "RAM", "Cache", "Register", "A"],
              ["Which portable secondary storage device plugs directly into a computer's USB port?", "MCQ", "Pen Drive / Flash Drive", "RAM Chip", "Internal ROM", "Motherboard", "A"]
            ]
          },
          {
            mNum: 2,
            q: [
              ["RAM stands for Random Access _______.", "FILL_BLANK", "Memory", "Memory", "", "", "Memory"],
              ["ROM stands for Read _______ Memory.", "FILL_BLANK", "Only", "Only", "", "", "Only"],
              ["1 Kilobyte (KB) is equal to _______ Bytes.", "FILL_BLANK", "1024", "1024, 1,024", "", "", "1024"],
              ["1 Megabyte (MB) is equal to _______ Kilobytes.", "FILL_BLANK", "1024", "1024, 1,024", "", "", "1024"],
              ["The main internal high-capacity magnetic storage disk inside a PC is called the _______ Disk.", "FILL_BLANK", "Hard", "Hard, Hard Disk", "", "", "Hard"]
            ]
          },
          {
            mNum: 3,
            q: [
              ["What does CD stand for in optical storage devices?", "MCQ", "Compact Disc", "Computer Data", "Central Disk", "Control Drive", "A"],
              ["Which optical disc has greater storage capacity than a standard CD-ROM?", "MCQ", "DVD", "Floppy Disk", "Cassette", "Punched Card", "A"],
              ["Which memory is used by the processor to temporarily hold active data while running an application?", "MCQ", "RAM", "DVD-R", "CD-RW", "Magnetic Tape", "A"],
              ["Which device stores digital photos and videos inside digital cameras and smartphones?", "MCQ", "Memory Card / SD Card", "RAM stick", "Floppy drive", "ROM chip", "A"],
              ["1 Gigabyte (GB) contains how many Megabytes (MB)?", "MCQ", "1024 MB", "500 MB", "100 MB", "10 MB", "A"]
            ]
          },
          {
            mNum: 4,
            q: [
              ["A student is working on a drawing, but the power suddenly goes out before saving. Why was the unsaved work lost?", "MCQ", "RAM is temporary and loses data without power", "ROM stopped working", "The monitor broke", "The keyboard deleted the file", "A"],
              ["You need to transfer a 2 GB school project video from your home PC to your school computer lab. What should you use?", "MCQ", "Pen Drive (USB Flash Drive)", "RAM module", "CPU heat sink", "Keyboard cable", "A"],
              ["Which storage unit order is arranged correctly from smallest to largest capacity?", "MCQ", "Byte < KB < MB < GB < TB", "TB < GB < MB < KB < Byte", "MB < KB < GB < Byte < TB", "Byte < MB < KB < TB < GB", "A"],
              ["Where does a computer permanently store its operating system and installed software applications?", "MCQ", "Hard Disk Drive (HDD) or SSD", "RAM chip", "Printer queue", "Webcam memory", "A"],
              ["Which secondary storage device uses blue-violet laser technology to store high-definition full-length movies?", "MCQ", "Blu-ray Disc", "Floppy Disk", "Magnetic Tape", "RAM Module", "A"]
            ]
          }
        ]
      },
      {
        num: 3,
        name: "CBSE 4 - Operating System and Windows Basics",
        missions: [
          {
            mNum: 1,
            q: [
              ["What is the main software that manages all hardware and software operations on a computer?", "MCQ", "Operating System (OS)", "Paint Application", "Web Browser", "Calculator", "A"],
              ["The background screen displayed immediately after logging into Windows is called the _______.", "MCQ", "Desktop", "Taskbar", "Control Panel", "Recycle Bin", "A"],
              ["The horizontal bar located along the bottom of the Windows desktop screen is known as the _______.", "MCQ", "Taskbar", "Menu Bar", "Title Bar", "Scroll Bar", "A"],
              ["Small graphical pictures or symbols on the desktop representing files or apps are called _______.", "MCQ", "Icons", "Folders", "Pointers", "Wallpapers", "A"],
              ["Where do deleted files and folders go in Windows until permanently removed?", "MCQ", "Recycle Bin", "My Documents", "Control Panel", "Task Manager", "A"]
            ]
          },
          {
            mNum: 2,
            q: [
              ["A collection of related information stored under a specific name is called a _______.", "FILL_BLANK", "File", "File", "", "", "File"],
              ["A digital container used to organize and store multiple files together is called a _______.", "FILL_BLANK", "Folder", "Folder, Directory", "", "", "Folder"],
              ["The round or square button on the bottom-left corner used to open programs is the _______ Button.", "FILL_BLANK", "Start", "Start, Start button", "", "", "Start"],
              ["The clock and system notification icons are located in the System _______ on the taskbar.", "FILL_BLANK", "Tray", "Tray, Notification Area", "", "", "Tray"],
              ["To make an exact duplicate copy of a file, we use the shortcut Ctrl + _______ followed by Ctrl + V.", "FILL_BLANK", "C", "C", "", "", "C"]
            ]
          },
          {
            mNum: 3,
            q: [
              ["Which keyboard shortcut is used to paste copied text or files in Windows?", "MCQ", "Ctrl + V", "Ctrl + C", "Ctrl + X", "Ctrl + Z", "A"],
              ["Which button on the top-right corner of a window reduces it down into a taskbar icon?", "MCQ", "Minimize", "Maximize", "Close", "Restore", "A"],
              ["Which button on the top-right corner of an active window enlarges it to fill the full screen?", "MCQ", "Maximize", "Minimize", "Close", "Pin", "A"],
              ["Which built-in Windows utility application is used to browse, organize, and view computer drives and files?", "MCQ", "File Explorer", "Notepad", "Paint", "Calculator", "A"],
              ["Which button labeled with an 'X' closes the currently opened application window?", "MCQ", "Close Button", "Minimize Button", "Help Button", "Back Button", "A"]
            ]
          },
          {
            mNum: 4,
            q: [
              ["You accidentally deleted your homework document icon from the desktop. How can you restore it immediately?", "MCQ", "Open Recycle Bin, right-click the file and choose Restore", "Buy a new hard drive", "Restart the monitor", "Press Caps Lock", "A"],
              ["You want to create a new folder named 'Science Project' on the desktop. What is the correct method?", "MCQ", "Right-click on desktop -> New -> Folder", "Left-click the power button", "Press Spacebar three times", "Turn off the printer", "A"],
              ["You need to rename an existing folder from 'Notes' to 'Math Notes'. What is the fastest keyboard shortcut?", "MCQ", "Select folder and press F2", "Press Alt + F4", "Press Esc", "Press Backspace 10 times", "A"],
              ["Which of the following is an example of a Graphical User Interface (GUI) Operating System?", "MCQ", "Microsoft Windows 11", "MS Word", "Google Chrome", "Adobe Photoshop", "A"],
              ["What should you always do before unplugging the main power cord from your computer?", "MCQ", "Perform a proper Shut Down via the Start menu", "Directly pull out the wall switch", "Shake the CPU box", "Unplug the mouse first", "A"]
            ]
          }
        ]
      },
      {
        num: 4,
        name: "CBSE 4 - Word Processing & Stepwise Problem Solving",
        missions: [
          {
            mNum: 1,
            q: [
              ["Which popular application software is used for creating, editing, and formatting text documents?", "MCQ", "Microsoft Word", "Calculator", "Paint", "Media Player", "A"],
              ["What is the blinking vertical line on the document screen showing where typed text will appear?", "MCQ", "Cursor / Insertion Point", "Pointer", "Scrollbar", "Ruler", "A"],
              ["Which formatting feature makes typed text appear darker and thicker?", "MCQ", "Bold (Ctrl + B)", "Italic (Ctrl + I)", "Underline (Ctrl + U)", "Strikethrough", "A"],
              ["Which keyboard key moves the cursor down to the beginning of the next new line or paragraph?", "MCQ", "Enter Key", "Shift Key", "Caps Lock", "Escape Key", "A"],
              ["Which key deletes the character present immediately to the left of the blinking cursor?", "MCQ", "Backspace", "Delete", "Spacebar", "Tab", "A"]
            ]
          },
          {
            mNum: 2,
            q: [
              ["A step-by-step set of instructions designed to solve a given problem is called an _______.", "FILL_BLANK", "Algorithm", "Algorithm", "", "", "Algorithm"],
              ["To save a new document file in Word, we use the shortcut key Ctrl + _______.", "FILL_BLANK", "S", "S", "", "", "S"],
              ["The longest key on the keyboard used to add blank spaces between words is the _______.", "FILL_BLANK", "Spacebar", "Spacebar, Space bar", "", "", "Spacebar"],
              ["Slanted text formatting in Microsoft Word is called _______.", "FILL_BLANK", "Italic", "Italic, Italics", "", "", "Italic"],
              ["To reverse or cancel the previous accidental action in Word, we use the _______ command (Ctrl + Z).", "FILL_BLANK", "Undo", "Undo", "", "", "Undo"]
            ]
          },
          {
            mNum: 3,
            q: [
              ["Which alignment option aligns text evenly along both the left and right margins of a document?", "MCQ", "Justify", "Align Left", "Align Right", "Center", "A"],
              ["Which feature in MS Word automatically moves the cursor to the next line when text reaches the right edge?", "MCQ", "Word Wrap", "Spell Check", "Page Break", "Font Style", "A"],
              ["What visual block-based coding environment uses colorful puzzle blocks to animate characters?", "MCQ", "Scratch", "Notepad", "Command Prompt", "BIOS", "A"],
              ["In stepwise problem solving, what is the first logical step before writing instructions?", "MCQ", "Understanding and identifying the goal", "Executing random steps", "Shutting down the system", "Formatting fonts", "A"],
              ["Which key deletes the character located to the right side of the cursor position?", "MCQ", "Delete Key", "Backspace Key", "Enter Key", "Shift Key", "A"]
            ]
          },
          {
            mNum: 4,
            q: [
              ["A student wants to create a step-by-step recipe algorithm for making a glass of lemonade. What is the correct sequence?", "MCQ", "Take water -> Squeeze lemon -> Add sugar -> Stir well -> Serve", "Serve -> Stir -> Squeeze lemon -> Add water", "Drink -> Stir -> Add lemon seeds -> Boil", "Freeze -> Throw -> Stir -> Squeeze", "A"],
              ["You want to make the title of your English essay stand out in the middle of the top page. Which tool do you click?", "MCQ", "Center Alignment (Ctrl + E)", "Align Right", "Strikethrough", "Subscript", "A"],
              ["You typed a sentence in lowercase and want to capitalize all letters. Which keyboard key toggles uppercase typing?", "MCQ", "Caps Lock", "Tab", "Scroll Lock", "Num Lock", "A"],
              ["In Scratch block coding, which block category contains commands like 'move 10 steps' and 'turn 15 degrees'?", "MCQ", "Motion Blocks", "Looks Blocks", "Sound Blocks", "Sensing Blocks", "A"],
              ["You made an error by deleting an important paragraph in your essay. How can you bring it back in one second?", "MCQ", "Press Ctrl + Z (Undo)", "Turn off monitor", "Press Ctrl + N", "Reinstall Windows", "A"]
            ]
          }
        ]
      }
    ]
  }
];

console.log("Generator module created with CBSE 4");
