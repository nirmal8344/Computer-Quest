// =========================================================================
// OFFICIAL CBSE CURRICULUM (CLASSES 4 TO 10)
// Authentic NCERT / CBSE IT (Code 402 & 165) Multi-Unit Structure
// =========================================================================

module.exports = [
  // -------------------------------------------------------------
  // CBSE CLASS 4 (Primary - Visual recognition & Basic concepts)
  // -------------------------------------------------------------
  {
    board: "CBSE",
    classLevel: 4,
    units: [
      {
        unitNumber: 1,
        unitName: "Unit 1 – Computer Hardware & System Architecture",
        chapters: [
          {
            num: 1,
            name: "CBSE 4 - Evolution of Computers & Calculating Devices",
            missions: [
              {
                mNum: 1,
                q: [
                  ["Which ancient counting device uses beads on rods to count?", "MCQ", "Abacus", "Mouse", "Keyboard", "Speaker", "A"],
                  ["Who designed the Analytical Engine and is known as the Father of Computers?", "MCQ", "Charles Babbage", "Bill Gates", "Isaac Newton", "Albert Einstein", "A"],
                  ["Which computer is lightweight, portable, and sits easily on your lap?", "MCQ", "Laptop", "Supercomputer", "Server", "Mainframe", "A"],
                  ["Which cycle shows how every computer accepts data, works on it, and gives results?", "MCQ", "Input - Process - Output (IPO)", "Stop - Run - Delete", "Print - Save - Cut", "Click - Drag - Drop", "A"],
                  ["What does CPU stand for?", "MCQ", "Central Processing Unit", "Computer Print Unit", "Central Power Unit", "Copy Paste Unit", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["The physical components of a computer that you can touch are called _______.", "FILL_BLANK", "Hardware", "Hardware", "", "", "Hardware"],
                  ["The first calculating tool invented in China is the _______.", "FILL_BLANK", "Abacus", "Abacus", "", "", "Abacus"],
                  ["The brain of the computer that does all calculations is the _______.", "FILL_BLANK", "CPU", "CPU", "", "", "CPU"],
                  ["A desktop computer usually rests on a _______.", "FILL_BLANK", "Desk", "Desk, Table", "", "", "Desk"],
                  ["A small computer worn on your wrist is called a Smart _______.", "FILL_BLANK", "Watch", "Watch", "", "", "Watch"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["Which computer device is used to record your voice into a computer?", "MCQ", "Microphone", "Monitor", "Printer", "Plotter", "A"],
                  ["Which of these is the largest and most powerful computer in the world?", "MCQ", "Supercomputer", "Tablet", "Pocket PC", "Laptop", "A"],
                  ["Which machine was invented by Blaise Pascal in 1642 to add numbers?", "MCQ", "Pascaline", "Abacus", "ENIAC", "Tablet", "A"],
                  ["Which part of the CPU is responsible for mathematical calculations?", "MCQ", "ALU (Arithmetic Logic Unit)", "Monitor", "Webcam", "Speaker", "A"],
                  ["Which device displays pictures, text, and games on its screen?", "MCQ", "Monitor", "Mouse", "Microphone", "CPU Fan", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["A scientist is studying monsoon weather changes worldwide. Which computer will they use?", "MCQ", "Supercomputer", "Smart Watch", "Calculator", "Desktop Toy", "A"],
                  ["You want to scan a printed picture from your textbook into your computer. What device should you use?", "MCQ", "Scanner", "Speaker", "Headphone", "Joystick", "A"],
                  ["Which device points, clicks, and drags items on the computer monitor?", "MCQ", "Mouse", "Keyboard", "Printer", "Scanner", "A"],
                  ["Which part connects the computer to electricity and distributes power inside?", "MCQ", "Power Supply Unit (SMPS)", "Keyboard", "Mouse Pad", "Microphone", "A"],
                  ["A handheld tablet computer has a screen that responds to touch called a _______.", "MCQ", "Touchscreen", "CRT Screen", "Glass Mirror", "Paper Board", "A"]
                ]
              }
            ]
          },
          {
            num: 2,
            name: "CBSE 4 - Input, Output and Storage Devices",
            missions: [
              {
                mNum: 1,
                q: [
                  ["Which device is used to enter letters, numbers, and symbols into a computer?", "MCQ", "Keyboard", "Monitor", "Speaker", "Projector", "A"],
                  ["Which device gives printed output on a paper sheet?", "MCQ", "Printer", "Keyboard", "Mouse", "Microphone", "A"],
                  ["What is the smallest unit of digital memory storage in a computer?", "MCQ", "Bit", "Byte", "Kilobyte", "Megabyte", "A"],
                  ["How many bits make one Byte?", "MCQ", "8 bits", "4 bits", "2 bits", "16 bits", "A"],
                  ["Which memory loses its data immediately when computer power is switched off?", "MCQ", "RAM (Random Access Memory)", "Hard Disk", "Pen Drive", "DVD", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["RAM stands for Random Access _______.", "FILL_BLANK", "Memory", "Memory", "", "", "Memory"],
                  ["A small portable USB secondary storage device is called a _______ Drive.", "FILL_BLANK", "Pen", "Pen, Flash, Thumb", "", "", "Pen"],
                  ["Output shown on a monitor screen is called _______ copy.", "FILL_BLANK", "Soft", "Soft", "", "", "Soft"],
                  ["Printed output on a sheet of paper is called _______ copy.", "FILL_BLANK", "Hard", "Hard", "", "", "Hard"],
                  ["1 Kilobyte (KB) is equal to _______ Bytes.", "FILL_BLANK", "1024", "1024, 1,024", "", "", "1024"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["Which optical disc is shiny, round, and can store photos, music, and software?", "MCQ", "Compact Disc (CD)", "Hard Disk", "RAM Stick", "Microchip", "A"],
                  ["Which permanent storage disk is fixed safely inside the computer CPU cabinet?", "MCQ", "Hard Disk Drive", "RAM", "Cache", "Webcam", "A"],
                  ["What does ROM stand for?", "MCQ", "Read Only Memory", "Run Once Memory", "Real Output Memory", "Random Only Memory", "A"],
                  ["Which device produces music and sound effects from your computer?", "MCQ", "Speakers", "Scanner", "Barcode Reader", "Keyboard", "A"],
                  ["Which memory card is commonly inserted inside digital cameras and smartphones?", "MCQ", "SD Card / Memory Card", "CD-ROM", "Floppy Disk", "Cassette", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["You are typing an essay and the electricity suddenly goes off before saving. Where was the unsaved work lost from?", "MCQ", "RAM (Volatile temporary memory)", "ROM", "Hard Disk", "Monitor Screen", "A"],
                  ["You need to take your science project slides to school to show your teacher. What portable device should you carry?", "MCQ", "Pen Drive (USB Flash Drive)", "CPU Cabinet", "Desktop Monitor", "Power Cable", "A"],
                  ["Which device is used by cashiers in supermarkets to read barcodes on food packets?", "MCQ", "Barcode Scanner", "Microphone", "Webcam", "Stylus", "A"],
                  ["Which storage device has the largest capacity among these?", "MCQ", "1 Terabyte (TB) Hard Disk", "1 Megabyte (MB) File", "1 Kilobyte (KB) Text", "1 Byte", "A"],
                  ["Which output device projects videos onto a large white wall or cinema screen?", "MCQ", "Projector", "Scanner", "Mouse", "Barcode Reader", "A"]
                ]
              }
            ]
          }
        ]
      },
      {
        unitNumber: 2,
        unitName: "Unit 2 – Operating Systems & Digital Workspace",
        chapters: [
          {
            num: 3,
            name: "CBSE 4 - GUI Operating System & Windows Desktop",
            missions: [
              {
                mNum: 1,
                q: [
                  ["What main system software manages all hardware and programs on a computer?", "MCQ", "Operating System (OS)", "MS Paint", "Calculator", "WordPad", "A"],
                  ["What is the main screen that appears after turning on and logging into Windows?", "MCQ", "Desktop", "Taskbar", "Control Panel", "Recycle Bin", "A"],
                  ["What are the small pictures or symbols on the desktop representing programs and files?", "MCQ", "Icons", "Folders", "Wallpapers", "Pointers", "A"],
                  ["The long horizontal bar at the bottom of the Windows desktop is called the _______.", "MCQ", "Taskbar", "Menu Bar", "Title Bar", "Scroll Bar", "A"],
                  ["Where do files deleted from the computer go until permanently removed?", "MCQ", "Recycle Bin", "Desktop", "My Documents", "Control Panel", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["A picture set as the background on your desktop screen is called _______.", "FILL_BLANK", "Wallpaper", "Wallpaper, Background", "", "", "Wallpaper"],
                  ["The button on the bottom-left corner used to access all apps is the _______ button.", "FILL_BLANK", "Start", "Start", "", "", "Start"],
                  ["The clock and volume icons are found in the System _______ on the taskbar.", "FILL_BLANK", "Tray", "Tray, Notification Area", "", "", "Tray"],
                  ["To open an icon on the desktop, you must _______-click it with your mouse.", "FILL_BLANK", "Double", "Double", "", "", "Double"],
                  ["The top bar of an open window displaying its program name is the _______ Bar.", "FILL_BLANK", "Title", "Title", "", "", "Title"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["Which button on the top-right corner of a window reduces it down into a taskbar icon?", "MCQ", "Minimize", "Maximize", "Close", "Restore", "A"],
                  ["Which button enlarges an active window to occupy the entire screen?", "MCQ", "Maximize", "Minimize", "Close", "Help", "A"],
                  ["Which button with an 'X' closes the currently opened application window?", "MCQ", "Close Button", "Minimize Button", "Start Button", "Scroll Bar", "A"],
                  ["What appears on the screen when a computer is left untouched for a few minutes?", "MCQ", "Screen Saver", "Wall Clock", "Printer Dialog", "File Explorer", "A"],
                  ["Which Windows built-in tool is used to browse, organize, and view all computer drives?", "MCQ", "File Explorer", "MS Paint", "Calculator", "Media Player", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["You accidentally deleted your homework file. How do you recover it right away?", "MCQ", "Open Recycle Bin and click Restore", "Restart computer", "Buy a new keyboard", "Press Caps Lock", "A"],
                  ["You want to change your desktop wallpaper. Where do you right-click?", "MCQ", "On an empty area of the Desktop -> Personalize", "Inside the Recycle Bin", "On the power cord", "On the speaker icon", "A"],
                  ["Which key on the keyboard can be pressed to quickly open the Start menu?", "MCQ", "Windows Logo Key", "Spacebar", "Escape Key", "Shift Key", "A"],
                  ["Which is a popular Graphical User Interface (GUI) operating system?", "MCQ", "Microsoft Windows 11", "MS Word", "Google Chrome", "Adobe Reader", "A"],
                  ["What should you always do before switching off the main power switch of a computer?", "MCQ", "Shut Down properly via the Start menu", "Pull out the power plug directly", "Turn off the monitor only", "Shake the CPU box", "A"]
                ]
              }
            ]
          },
          {
            num: 4,
            name: "CBSE 4 - Managing Files and Folders",
            missions: [
              {
                mNum: 1,
                q: [
                  ["A collection of related data stored under a specific name on a computer is a _______.", "MCQ", "File", "Keyboard", "Icon", "Cable", "A"],
                  ["A digital container used to organize and store multiple files together is a _______.", "MCQ", "Folder", "Cursor", "Scrollbar", "Printer", "A"],
                  ["Which shortcut key is used to copy selected files or text?", "MCQ", "Ctrl + C", "Ctrl + V", "Ctrl + X", "Ctrl + Z", "A"],
                  ["Which shortcut key is used to paste copied or cut files?", "MCQ", "Ctrl + V", "Ctrl + C", "Ctrl + S", "Ctrl + P", "A"],
                  ["Which shortcut key is used to cut (move) a file from one place to another?", "MCQ", "Ctrl + X", "Ctrl + C", "Ctrl + V", "Ctrl + A", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["A folder inside another folder is called a _______ folder.", "FILL_BLANK", "Sub", "Sub, Subfolder", "", "", "Sub"],
                  ["To select all items inside a folder, press Ctrl + _______.", "FILL_BLANK", "A", "A", "", "", "A"],
                  ["To undo your last mistake in Windows, press Ctrl + _______.", "FILL_BLANK", "Z", "Z", "", "", "Z"],
                  ["The shortcut key to quickly rename a selected folder is F_______.", "FILL_BLANK", "2", "2, F2", "", "", "2"],
                  ["To delete a file permanently without sending it to Recycle Bin, press Shift + _______.", "FILL_BLANK", "Delete", "Delete, Del", "", "", "Delete"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["How do you create a new folder on the Windows desktop?", "MCQ", "Right-click on desktop -> New -> Folder", "Left-click on speaker", "Press Enter 5 times", "Turn off monitor", "A"],
                  ["Which character is NOT allowed in Windows file names?", "MCQ", "Slash (/ or \\)", "Letters (A-Z)", "Numbers (0-9)", "Underscore (_)", "A"],
                  ["What does the file extension `.docx` indicate?", "MCQ", "Word Processing Document", "Music Audio File", "Video Movie", "System BIOS", "A"],
                  ["What does the file extension `.jpg` or `.png` indicate?", "MCQ", "Picture / Image File", "Audio Sound", "Word Document", "Spreadsheet", "A"],
                  ["Which view in File Explorer shows file size, type, and date modified in columns?", "MCQ", "Details View", "Extra Large Icons", "Tiles View", "List View", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["You have 10 drawings scattered on your desktop. What is the best way to organize them?", "MCQ", "Create a folder named 'My Drawings' and move all drawings inside", "Delete all of them", "Hide them in Recycle Bin", "Change desktop wallpaper", "A"],
                  ["You want to duplicate a homework document from folder A to folder B. Which actions do you take?", "MCQ", "Copy from A (Ctrl+C) and Paste in B (Ctrl+V)", "Delete A and recreate", "Rename folder B", "Minimize window", "A"],
                  ["You made a spelling mistake in a folder name. How can you edit the name?", "MCQ", "Right-click the folder and select Rename", "Click Close button", "Drag it to taskbar", "Format the hard disk", "A"],
                  ["You want to find a file named 'Science Notes' on your computer quickly. What tool will you use?", "MCQ", "Search box in File Explorer", "Recycle Bin", "Calculator", "Notepad", "A"],
                  ["Why should we always organize files into properly named folders?", "MCQ", "To find and manage our work quickly and easily", "To make computer run slower", "To use more electricity", "To fill the screen with icons", "A"]
                ]
              }
            ]
          }
        ]
      },
      {
        unitNumber: 3,
        unitName: "Unit 3 – Digital Documentation & Creative Logic",
        chapters: [
          {
            num: 5,
            name: "CBSE 4 - Word Processing Basics with MS Word",
            missions: [
              {
                mNum: 1,
                q: [
                  ["Which software application is used to write and format stories, letters, and essays?", "MCQ", "Microsoft Word", "Calculator", "Paint", "Media Player", "A"],
                  ["What is the blinking vertical line on the document page where typed letters appear?", "MCQ", "Cursor / Insertion Point", "Pointer", "Ruler", "Scrollbar", "A"],
                  ["Which formatting tool makes typed text appear darker and thicker?", "MCQ", "Bold (Ctrl + B)", "Italic (Ctrl + I)", "Underline (Ctrl + U)", "Strikethrough", "A"],
                  ["Which key on the keyboard moves the cursor down to the next new line or paragraph?", "MCQ", "Enter Key", "Shift Key", "Caps Lock", "Escape Key", "A"],
                  ["Which key erases the character present immediately to the left of the cursor?", "MCQ", "Backspace Key", "Delete Key", "Spacebar", "Tab Key", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["To save a new document in Word, we use the shortcut Ctrl + _______.", "FILL_BLANK", "S", "S", "", "", "S"],
                  ["The longest key on the keyboard used to add blank spaces between words is the _______.", "FILL_BLANK", "Spacebar", "Spacebar", "", "", "Spacebar"],
                  ["Slanted text formatting in Microsoft Word is called _______.", "FILL_BLANK", "Italic", "Italic", "", "", "Italic"],
                  ["To put a line underneath selected text, we use _______ (Ctrl + U).", "FILL_BLANK", "Underline", "Underline", "", "", "Underline"],
                  ["To print a written document on paper, we use the shortcut Ctrl + _______.", "FILL_BLANK", "P", "P", "", "", "P"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["Which alignment puts the selected title text neatly in the exact center of the page?", "MCQ", "Center Alignment (Ctrl + E)", "Left Alignment", "Right Alignment", "Justify", "A"],
                  ["Which tool in Word checks your document for spelling mistakes with red wavy lines?", "MCQ", "Spelling & Grammar Check", "WordArt", "Shapes", "Font Color", "A"],
                  ["What is the default text color in a blank new document in MS Word?", "MCQ", "Black", "Red", "Blue", "Green", "A"],
                  ["Which key deletes the letter or space located to the right side of the cursor?", "MCQ", "Delete Key", "Backspace Key", "Enter Key", "Spacebar", "A"],
                  ["Which feature in Word automatically moves text to a new line when reaching the right margin?", "MCQ", "Word Wrap", "Spell Check", "Page Break", "Header", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["You want your story title 'The Brave Lion' to be big, bold, and centered. What tools do you apply?", "MCQ", "Increase Font Size, click Bold, and click Center Align", "Click Minimize and Close", "Press Backspace 10 times", "Turn off monitor", "A"],
                  ["You want to type capital letters continuously for an entire heading. Which key should you turn on?", "MCQ", "Caps Lock Key", "Tab Key", "Scroll Lock", "Num Lock", "A"],
                  ["You accidentally deleted your whole paragraph. How do you bring it back in one second?", "MCQ", "Press Ctrl + Z (Undo)", "Reboot the PC", "Buy a new keyboard", "Click Save As", "A"],
                  ["You want to add bullet points (•) for your grocery list items. Which tool do you click on the ribbon?", "MCQ", "Bullets List Tool", "Italic Tool", "Page Number", "Table Border", "A"],
                  ["Which ribbon tab in Microsoft Word contains Font, Paragraph, and Clipboard tools?", "MCQ", "Home Tab", "View Tab", "Help Tab", "Review Tab", "A"]
                ]
              }
            ]
          },
          {
            num: 6,
            name: "CBSE 4 - Stepwise Problem Solving & Algorithmic Thinking",
            missions: [
              {
                mNum: 1,
                q: [
                  ["A step-by-step set of clear instructions to complete a task or solve a problem is an _______.", "MCQ", "Algorithm", "Operating System", "Hard Disk", "Icon", "A"],
                  ["In stepwise problem solving, what is the very first thing you must do?", "MCQ", "Understand and identify the goal", "Perform random actions", "Shut down the computer", "Print results", "A"],
                  ["Which coding platform uses colorful interlocking blocks to create fun stories and games?", "MCQ", "Scratch", "Notepad", "Command Prompt", "BIOS", "A"],
                  ["In Scratch, the character that moves and performs actions on stage is called a _______.", "MCQ", "Sprite", "Icon", "Pixel", "Ruler", "A"],
                  ["Which block in Scratch starts a program when the green flag is clicked?", "MCQ", "When Green Flag Clicked (Events Block)", "Stop All", "Delete Sprite", "Hide Stage", "A"]
                ]
              },
              {
                mNum: 2,
                q: [
                  ["Step-by-step instructions in simple language are called an _______.", "FILL_BLANK", "Algorithm", "Algorithm", "", "", "Algorithm"],
                  ["In Scratch, the background area where sprites move and animate is the _______.", "FILL_BLANK", "Stage", "Stage", "", "", "Stage"],
                  ["To make a sprite take steps in Scratch, we use the _______ block.", "FILL_BLANK", "Move", "Move, Motion", "", "", "Move"],
                  ["Breaking down a big complex problem into smaller easy steps is called _______.", "FILL_BLANK", "Decomposition", "Decomposition", "", "", "Decomposition"],
                  ["The orange cat in Scratch is the default _______.", "FILL_BLANK", "Sprite", "Sprite", "", "", "Sprite"]
                ]
              },
              {
                mNum: 3,
                q: [
                  ["What is the correct algorithm sequence for brushing your teeth in the morning?", "MCQ", "Take brush -> Apply paste -> Brush teeth -> Rinse mouth", "Rinse mouth -> Apply paste -> Sleep -> Take brush", "Brush teeth -> Wash hands -> Buy paste -> Rinse", "Spit -> Eat -> Brush -> Sleep", "A"],
                  ["Which block category in Scratch contains blocks to turn and move sprites?", "MCQ", "Motion Blocks (Blue)", "Looks Blocks (Purple)", "Sound Blocks (Pink)", "Variables (Orange)", "A"],
                  ["Which block category in Scratch makes a sprite say 'Hello!' in a speech bubble?", "MCQ", "Looks Blocks", "Motion Blocks", "Sensing Blocks", "Operators", "A"],
                  ["Why must algorithm steps always be written in the exact correct order?", "MCQ", "Because computer follows instructions strictly step-by-step", "Because computers can guess our thoughts", "To make the file size larger", "To use more colors", "A"],
                  ["What happens if an essential step is missing from an algorithm?", "MCQ", "The task will produce wrong results or fail", "The task will finish faster", "Computer will become supercomputer", "The monitor will turn red", "A"]
                ]
              },
              {
                mNum: 4,
                q: [
                  ["A student creates an algorithm to make a glass of lemonade. What is the correct sequence?", "MCQ", "Take glass of water -> Squeeze lemon -> Add sugar -> Stir well -> Serve", "Serve -> Squeeze lemon -> Take glass -> Add water", "Drink -> Stir -> Add ice -> Squeeze lemon", "Freeze -> Boil -> Throw -> Drink", "A"],
                  ["You want your Scratch cat sprite to walk 50 steps and meow. Which two blocks do you connect?", "MCQ", "move 50 steps + play sound Meow until done", "hide + stop all", "turn 180 degrees + delete sprite", "change color + quit", "A"],
                  ["A robot is programmed to walk from the classroom to the library. If step 2 is wrong, what happens?", "MCQ", "The robot gets lost or goes in the wrong direction", "The robot flies into space", "The library moves closer", "The battery multiplies", "A"],
                  ["Which visual diagram uses geometric shapes connected by arrows to show steps?", "MCQ", "Flowchart", "Bar Graph", "Pie Chart", "Wallpaper", "A"],
                  ["Why is learning stepwise thinking helpful for young students?", "MCQ", "It builds logical thinking, problem solving, and coding skills", "It makes typing unnecessary", "It turns computers into TVs", "It saves internet data only", "A"]
                ]
              }
            ]
          }
        ]
      }
    ]
  }
];
