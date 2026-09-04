const fs = require('fs');
const path = require('path');

// Complete curriculum definition with authentic topics for Classes 4-10
const classesData = [
  // ========================== CBSE ==========================
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
            questions: [
              { text: "Which ancient calculating tool uses beads on wooden rods?", type: "MCQ", a: "Abacus", b: "Calculator", c: "Keyboard", d: "Mouse", ans: "A" },
              { text: "Who is widely recognized as the 'Father of the Computer'?", type: "MCQ", a: "Charles Babbage", b: "Albert Einstein", c: "Thomas Edison", d: "Bill Gates", ans: "A" },
              { text: "Which type of computer is portable, lightweight, and operates on a rechargeable battery?", type: "MCQ", a: "Supercomputer", b: "Laptop", c: "Desktop PC", d: "Mainframe", ans: "B" },
              { text: "What does CPU stand for in computer systems?", type: "MCQ", a: "Central Processing Unit", b: "Central Power Unit", c: "Computer Program Unit", d: "Control Process Unit", ans: "A" },
              { text: "Which device is used to enter text, numbers, and commands into a computer?", type: "MCQ", a: "Monitor", b: "Keyboard", c: "Speaker", d: "Printer", ans: "B" }
            ]
          },
          {
            mNum: 2,
            questions: [
              { text: "A handheld computer with a touchscreen display is called a _______.", type: "FILL_BLANK", a: "Tablet", b: "Tablet, Tab, iPad", ans: "Tablet" },
              { text: "Early computers in the first generation used _______ tubes.", type: "FILL_BLANK", a: "Vacuum", b: "Vacuum, Vacuum tubes", ans: "Vacuum" },
              { text: "The output shown on a monitor screen is called _______ copy.", type: "FILL_BLANK", a: "Soft", b: "Soft, Soft copy", ans: "Soft" },
              { text: "Printed output on a sheet of paper is called _______ copy.", type: "FILL_BLANK", a: "Hard", b: "Hard, Hard copy", ans: "Hard" },
              { text: "The brain of the computer that performs all calculations is the _______.", type: "FILL_BLANK", a: "CPU", b: "CPU, Central Processing Unit", ans: "CPU" }
            ]
          },
          {
            mNum: 3,
            questions: [
              { text: "Which of the following is the world's fastest and most powerful type of computer?", type: "MCQ", a: "Microcomputer", b: "Supercomputer", c: "Tablet", d: "Desktop", ans: "B" },
              { text: "Which computer device produces sound output such as music and voice?", type: "MCQ", a: "Speakers", b: "Scanner", c: "Microphone", d: "Webcam", ans: "A" },
              { text: "Which device is used to capture photographs and send live video over the internet?", type: "MCQ", a: "Webcam", b: "Printer", c: "Plotter", d: "Hard Disk", ans: "A" },
              { text: "Which unit inside the CPU controls and coordinates all parts of the computer?", type: "MCQ", a: "ALU", b: "Control Unit", c: "Memory Unit", d: "Power Supply", ans: "B" },
              { text: "Which machine invented by Blaise Pascal in 1642 could add and subtract numbers?", type: "MCQ", a: "Pascaline", b: "Abacus", c: "ENIAC", d: "Analytical Engine", ans: "A" }
            ]
          },
          {
            mNum: 4,
            questions: [
              { text: "A scientist needs to calculate heavy weather forecast simulations across the globe. Which computer should they choose?", type: "MCQ", a: "Supercomputer", b: "Smart Watch", c: "Pocket Calculator", d: "Game Console", ans: "A" },
              { text: "A student wants to read an e-book and draw with a stylus while traveling. Which portable device is most suitable?", type: "MCQ", a: "Desktop Tower", b: "Tablet PC", c: "Mainframe Server", d: "Barcode Reader", ans: "B" },
              { text: "You need to convert a physical printed drawing into a digital picture on your computer screen. What device will you use?", type: "MCQ", a: "Scanner", b: "Speaker", c: "Projector", d: "Headphones", ans: "A" },
              { text: "Which cycle represents the basic working principle of all modern computer operations?", type: "MCQ", a: "Input - Process - Output", b: "Process - Output - Input", c: "Output - Input - Process", d: "Store - Delete - Print", ans: "A" },
              { text: "A cashier scans barcodes on grocery items at the supermarket checkout. Which device is used?", type: "MCQ", a: "Barcode Scanner", b: "Microphone", c: "Inkjet Printer", d: "Plotter", ans: "A" }
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
            questions: [
              { text: "What is the smallest unit of digital computer memory measurement?", type: "MCQ", a: "Bit", b: "Byte", c: "Kilobyte", d: "Megabyte", ans: "A" },
              { text: "How many bits are grouped together to form one Byte?", type: "MCQ", a: "4 bits", b: "8 bits", c: "16 bits", d: "32 bits", ans: "B" },
              { text: "Which computer memory is volatile and loses its stored content when the power is turned off?", type: "MCQ", a: "RAM", b: "ROM", c: "Hard Disk", d: "Pen Drive", ans: "A" },
              { text: "Which memory contains non-volatile, permanent startup instructions that cannot be easily modified?", type: "MCQ", a: "ROM", b: "RAM", c: "Cache", d: "Register", ans: "A" },
              { text: "Which portable secondary storage device plugs directly into a computer's USB port?", type: "MCQ", a: "Pen Drive / Flash Drive", b: "RAM Chip", c: "Internal ROM", d: "Motherboard", ans: "A" }
            ]
          },
          {
            mNum: 2,
            questions: [
              { text: "RAM stands for Random Access _______.", type: "FILL_BLANK", a: "Memory", b: "Memory", ans: "Memory" },
              { text: "ROM stands for Read _______ Memory.", type: "FILL_BLANK", a: "Only", b: "Only", ans: "Only" },
              { text: "1 Kilobyte (KB) is equal to _______ Bytes.", type: "FILL_BLANK", a: "1024", b: "1024, 1,024", ans: "1024" },
              { text: "1 Megabyte (MB) is equal to _______ Kilobytes.", type: "FILL_BLANK", a: "1024", b: "1024, 1,024", ans: "1024" },
              { text: "The main internal high-capacity magnetic storage disk inside a PC is called the _______ Disk.", type: "FILL_BLANK", a: "Hard", b: "Hard, Hard Disk", ans: "Hard" }
            ]
          },
          {
            mNum: 3,
            questions: [
              { text: "What does CD stand for in optical storage devices?", type: "MCQ", a: "Compact Disc", b: "Computer Data", c: "Central Disk", d: "Control Drive", ans: "A" },
              { text: "Which optical disc has greater storage capacity than a standard CD-ROM?", type: "MCQ", a: "DVD", b: "Floppy Disk", c: "Cassette", d: "Punched Card", ans: "A" },
              { text: "Which memory is used by the processor to temporarily hold active data while running an application?", type: "MCQ", a: "RAM", b: "DVD-R", c: "CD-RW", d: "Magnetic Tape", ans: "A" },
              { text: "Which device stores digital photos and videos inside digital cameras and smartphones?", type: "MCQ", a: "Memory Card / SD Card", b: "RAM stick", c: "Floppy drive", d: "ROM chip", ans: "A" },
              { text: "1 Gigabyte (GB) contains how many Megabytes (MB)?", type: "MCQ", a: "1024 MB", b: "500 MB", c: "100 MB", d: "10 MB", ans: "A" }
            ]
          },
          {
            mNum: 4,
            questions: [
              { text: "A student is working on a drawing, but the power suddenly goes out before saving. Why was the unsaved work lost?", type: "MCQ", a: "RAM is temporary and loses data without power", b: "ROM stopped working", c: "The monitor broke", d: "The keyboard deleted the file", ans: "A" },
              { text: "You need to transfer a 2 GB school project video from your home PC to your school computer lab. What should you use?", type: "MCQ", a: "Pen Drive (USB Flash Drive)", b: "RAM module", c: "CPU heat sink", d: "Keyboard cable", ans: "A" },
              { text: "Which storage unit order is arranged correctly from smallest to largest capacity?", type: "MCQ", a: "Byte < KB < MB < GB < TB", b: "TB < GB < MB < KB < Byte", c: "MB < KB < GB < Byte < TB", d: "Byte < MB < KB < TB < GB", ans: "A" },
              { text: "Where does a computer permanently store its operating system and installed software applications?", type: "MCQ", a: "Hard Disk Drive (HDD) or SSD", b: "RAM chip", c: "Printer queue", d: "Webcam memory", ans: "A" },
              { text: "Which secondary storage device uses blue-violet laser technology to store high-definition full-length movies?", type: "MCQ", a: "Blu-ray Disc", b: "Floppy Disk", c: "Magnetic Tape", d: "RAM Module", ans: "A" }
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
            questions: [
              { text: "What is the main software that manages all hardware and software operations on a computer?", type: "MCQ", a: "Operating System (OS)", b: "Paint Application", c: "Web Browser", d: "Calculator", ans: "A" },
              { text: "The background screen displayed immediately after logging into Windows is called the _______.", type: "MCQ", a: "Desktop", b: "Taskbar", c: "Control Panel", d: "Recycle Bin", ans: "A" },
              { text: "The horizontal bar located along the bottom of the Windows desktop screen is known as the _______.", type: "MCQ", a: "Taskbar", b: "Menu Bar", c: "Title Bar", d: "Scroll Bar", ans: "A" },
              { text: "Small graphical pictures or symbols on the desktop representing files or apps are called _______.", type: "MCQ", a: "Icons", b: "Folders", c: "Pointers", d: "Wallpapers", ans: "A" },
              { text: "Where do deleted files and folders go in Windows until permanently removed?", type: "MCQ", a: "Recycle Bin", b: "My Documents", c: "Control Panel", d: "Task Manager", ans: "A" }
            ]
          },
          {
            mNum: 2,
            questions: [
              { text: "A collection of related information stored under a specific name is called a _______.", type: "FILL_BLANK", a: "File", b: "File", ans: "File" },
              { text: "A digital container used to organize and store multiple files together is called a _______.", type: "FILL_BLANK", a: "Folder", b: "Folder, Directory", ans: "Folder" },
              { text: "The round or square button on the bottom-left corner used to open programs is the _______ Button.", type: "FILL_BLANK", a: "Start", b: "Start, Start button", ans: "Start" },
              { text: "The clock and system notification icons are located in the System _______ on the taskbar.", type: "FILL_BLANK", a: "Tray", b: "Tray, Notification Area", ans: "Tray" },
              { text: "To make an exact duplicate copy of a file, we use the shortcut Ctrl + _______ followed by Ctrl + V.", type: "FILL_BLANK", a: "C", b: "C", ans: "C" }
            ]
          },
          {
            mNum: 3,
            questions: [
              { text: "Which keyboard shortcut is used to paste copied text or files in Windows?", type: "MCQ", a: "Ctrl + V", b: "Ctrl + C", c: "Ctrl + X", d: "Ctrl + Z", ans: "A" },
              { text: "Which button on the top-right corner of a window reduces it down into a taskbar icon?", type: "MCQ", a: "Minimize", b: "Maximize", c: "Close", d: "Restore", ans: "A" },
              { text: "Which button on the top-right corner of an active window enlarges it to fill the full screen?", type: "MCQ", a: "Maximize", b: "Minimize", c: "Close", d: "Pin", ans: "A" },
              { text: "Which built-in Windows utility application is used to browse, organize, and view computer drives and files?", type: "MCQ", a: "File Explorer", b: "Notepad", c: "Paint", d: "Calculator", ans: "A" },
              { text: "Which button labeled with an 'X' closes the currently opened application window?", type: "MCQ", a: "Close Button", b: "Minimize Button", c: "Help Button", d: "Back Button", ans: "A" }
            ]
          },
          {
            mNum: 4,
            questions: [
              { text: "You accidentally deleted your homework document icon from the desktop. How can you restore it immediately?", type: "MCQ", a: "Open Recycle Bin, right-click the file and choose Restore", b: "Buy a new hard drive", c: "Restart the monitor", d: "Press Caps Lock", ans: "A" },
              { text: "You want to create a new folder named 'Science Project' on the desktop. What is the correct method?", type: "MCQ", a: "Right-click on desktop -> New -> Folder", b: "Left-click the power button", c: "Press Spacebar three times", d: "Turn off the printer", ans: "A" },
              { text: "You need to rename an existing folder from 'Notes' to 'Math Notes'. What is the fastest keyboard shortcut?", type: "MCQ", a: "Select folder and press F2", b: "Press Alt + F4", c: "Press Esc", d: "Press Backspace 10 times", ans: "A" },
              { text: "Which of the following is an example of a Graphical User Interface (GUI) Operating System?", type: "MCQ", a: "Microsoft Windows 11", b: "MS Word", c: "Google Chrome", d: "Adobe Photoshop", ans: "A" },
              { text: "What should you always do before unplugging the main power cord from your computer?", type: "MCQ", a: "Perform a proper Shut Down via the Start menu", b: "Directly pull out the wall switch", c: "Shake the CPU box", d: "Unplug the mouse first", ans: "A" }
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
            questions: [
              { text: "Which popular application software is used for creating, editing, and formatting text documents?", type: "MCQ", a: "Microsoft Word", b: "Calculator", c: "Paint", d: "Media Player", ans: "A" },
              { text: "What is the blinking vertical line on the document screen showing where typed text will appear?", type: "MCQ", a: "Cursor / Insertion Point", b: "Pointer", c: "Scrollbar", d: "Ruler", ans: "A" },
              { text: "Which formatting feature makes typed text appear darker and thicker?", type: "MCQ", a: "Bold (Ctrl + B)", b: "Italic (Ctrl + I)", c: "Underline (Ctrl + U)", d: "Strikethrough", ans: "A" },
              { text: "Which keyboard key moves the cursor down to the beginning of the next new line or paragraph?", type: "MCQ", a: "Enter Key", b: "Shift Key", c: "Caps Lock", d: "Escape Key", ans: "A" },
              { text: "Which key deletes the character present immediately to the left of the blinking cursor?", type: "MCQ", a: "Backspace", b: "Delete", c: "Spacebar", d: "Tab", ans: "A" }
            ]
          },
          {
            mNum: 2,
            questions: [
              { text: "A step-by-step set of instructions designed to solve a given problem is called an _______.", type: "FILL_BLANK", a: "Algorithm", b: "Algorithm", ans: "Algorithm" },
              { text: "To save a new document file in Word, we use the shortcut key Ctrl + _______.", type: "FILL_BLANK", a: "S", b: "S", ans: "S" },
              { text: "The longest key on the keyboard used to add blank spaces between words is the _______.", type: "FILL_BLANK", a: "Spacebar", b: "Spacebar, Space bar", ans: "Spacebar" },
              { text: "Slanted text formatting in Microsoft Word is called _______.", type: "FILL_BLANK", a: "Italic", b: "Italic, Italics", ans: "Italic" },
              { text: "To reverse or cancel the previous accidental action in Word, we use the _______ command (Ctrl + Z).", type: "FILL_BLANK", a: "Undo", b: "Undo", ans: "Undo" }
            ]
          },
          {
            mNum: 3,
            questions: [
              { text: "Which alignment option aligns text evenly along both the left and right margins of a document?", type: "MCQ", a: "Justify", b: "Align Left", c: "Align Right", d: "Center", ans: "A" },
              { text: "Which feature in MS Word automatically moves the cursor to the next line when text reaches the right edge?", type: "MCQ", a: "Word Wrap", b: "Spell Check", c: "Page Break", d: "Font Style", ans: "A" },
              { text: "What visual block-based coding environment uses colorful puzzle blocks to animate characters?", type: "MCQ", a: "Scratch", b: "Notepad", c: "Command Prompt", d: "BIOS", ans: "A" },
              { text: "In stepwise problem solving, what is the first logical step before writing instructions?", type: "MCQ", a: "Understanding and identifying the goal", b: "Executing random steps", c: "Shutting down the system", d: "Formatting fonts", ans: "A" },
              { text: "Which key deletes the character located to the right side of the cursor position?", type: "MCQ", a: "Delete Key", b: "Backspace Key", c: "Enter Key", d: "Shift Key", ans: "A" }
            ]
          },
          {
            mNum: 4,
            questions: [
              { text: "A student wants to create a step-by-step recipe algorithm for making a glass of lemonade. What is the correct sequence?", type: "MCQ", a: "Take water -> Squeeze lemon -> Add sugar -> Stir well -> Serve", b: "Serve -> Stir -> Squeeze lemon -> Add water", c: "Drink -> Stir -> Add lemon seeds -> Boil", d: "Freeze -> Throw -> Stir -> Squeeze", ans: "A" },
              { text: "You want to make the title of your English essay stand out in the middle of the top page. Which tool do you click?", type: "MCQ", a: "Center Alignment (Ctrl + E)", b: "Align Right", c: "Strikethrough", d: "Subscript", ans: "A" },
              { text: "You typed a sentence in lowercase and want to capitalize all letters. Which keyboard key toggles uppercase typing?", type: "MCQ", a: "Caps Lock", b: "Tab", c: "Scroll Lock", d: "Num Lock", ans: "A" },
              { text: "In Scratch block coding, which block category contains commands like 'move 10 steps' and 'turn 15 degrees'?", type: "MCQ", a: "Motion Blocks", b: "Looks Blocks", c: "Sound Blocks", d: "Sensing Blocks", ans: "A" },
              { text: "You made an error by deleting an important paragraph in your essay. How can you bring it back in one second?", type: "MCQ", a: "Press Ctrl + Z (Undo)", b: "Turn off monitor", c: "Press Ctrl + N", d: "Reinstall Windows", ans: "A" }
            ]
          }
        ]
      }
    ]
  }
];

console.log("Classes data definition created");
