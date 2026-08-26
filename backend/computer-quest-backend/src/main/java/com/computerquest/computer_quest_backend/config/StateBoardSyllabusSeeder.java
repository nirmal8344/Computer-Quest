package com.computerquest.computer_quest_backend.config;

import com.computerquest.computer_quest_backend.entity.Chapter;
import com.computerquest.computer_quest_backend.entity.Mission;
import com.computerquest.computer_quest_backend.entity.Question;
import com.computerquest.computer_quest_backend.entity.School;
import com.computerquest.computer_quest_backend.entity.Unit;
import com.computerquest.computer_quest_backend.repository.ChapterRepository;
import com.computerquest.computer_quest_backend.repository.MissionRepository;
import com.computerquest.computer_quest_backend.repository.QuestionRepository;
import com.computerquest.computer_quest_backend.repository.SchoolRepository;
import com.computerquest.computer_quest_backend.repository.UnitRepository;
import com.computerquest.computer_quest_backend.entity.SchoolClass;
import com.computerquest.computer_quest_backend.repository.SchoolClassRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StateBoardSyllabusSeeder {

    private final SchoolRepository schoolRepository;
    private final UnitRepository unitRepository;
    private final ChapterRepository chapterRepository;
    private final MissionRepository missionRepository;
    private final QuestionRepository questionRepository;
    private final com.computerquest.computer_quest_backend.repository.QuestionAttemptRepository questionAttemptRepository;
    private final SchoolClassRepository schoolClassRepository;

    public StateBoardSyllabusSeeder(
            SchoolRepository schoolRepository,
            UnitRepository unitRepository,
            ChapterRepository chapterRepository,
            MissionRepository missionRepository,
            QuestionRepository questionRepository,
            com.computerquest.computer_quest_backend.repository.QuestionAttemptRepository questionAttemptRepository,
            SchoolClassRepository schoolClassRepository) {
        this.schoolRepository = schoolRepository;
        this.unitRepository = unitRepository;
        this.chapterRepository = chapterRepository;
        this.missionRepository = missionRepository;
        this.questionRepository = questionRepository;
        this.questionAttemptRepository = questionAttemptRepository;
        this.schoolClassRepository = schoolClassRepository;
    }

    public void seedDemoSchoolSyllabus() {
        School demoSchool = schoolRepository.findByName("Computer Quest Demo School").orElse(null);
        if (demoSchool != null && questionRepository.countBySchool_Id(demoSchool.getId()) >= 680) {
            return;
        }

        if (demoSchool == null) {
            demoSchool = schoolRepository.save(new School("Computer Quest Demo School"));
        }

        // Ensure 11th Standard and 12th Standard exist for Demo School in STATE_BOARD
        List<SchoolClass> demoClasses = schoolClassRepository.findBySchool_IdAndBoard(demoSchool.getId(), "STATE_BOARD");
        if (demoClasses.isEmpty()) {
            schoolClassRepository.save(new SchoolClass("11th Standard", 11, "STATE_BOARD", demoSchool));
            schoolClassRepository.save(new SchoolClass("12th Standard", 12, "STATE_BOARD", demoSchool));
        }

        // Clean up pre-existing questions/chapters for Demo School State Board if partial seed
        List<Question> oldQuestions = questionRepository.findBySchool_Id(demoSchool.getId());
        if (!oldQuestions.isEmpty()) {
            List<com.computerquest.computer_quest_backend.entity.QuestionAttempt> attempts = questionAttemptRepository.findAll();
            if (!attempts.isEmpty()) {
                java.util.Set<Long> qIds = oldQuestions.stream().map(Question::getId).collect(java.util.stream.Collectors.toSet());
                List<com.computerquest.computer_quest_backend.entity.QuestionAttempt> toDelete = attempts.stream()
                        .filter(a -> a.getQuestion() != null && qIds.contains(a.getQuestion().getId()))
                        .toList();
                if (!toDelete.isEmpty()) {
                    questionAttemptRepository.deleteAll(toDelete);
                }
            }
            questionRepository.deleteAll(oldQuestions);
        }

        List<Mission> oldMissions = missionRepository.findBySchool_Id(demoSchool.getId());
        if (!oldMissions.isEmpty()) {
            missionRepository.deleteAll(oldMissions);
        }

        List<Chapter> oldChapters = chapterRepository.findBySchool_Id(demoSchool.getId());
        if (!oldChapters.isEmpty()) {
            chapterRepository.deleteAll(oldChapters);
        }

        List<Unit> oldUnits = unitRepository.findBySchool_Id(demoSchool.getId());
        if (!oldUnits.isEmpty()) {
            unitRepository.deleteAll(oldUnits);
        }

        // Seed Class 11 State Board Syllabus
        seedClass11Syllabus(demoSchool);

        // Seed Class 12 State Board Syllabus
        seedClass12Syllabus(demoSchool);
    }

    private void seedClass11Syllabus(School demoSchool) {
        String board = "STATE_BOARD";
        int classLevel = 11;

        // Unit I
        String u1 = "UNIT I – FUNDAMENTALS OF COMPUTER AND WORKING WITH A TYPICAL OPERATING SYSTEMS (WINDOWS & LINUX)";
        createUnit(demoSchool, board, classLevel, 1, u1);
        seedChapter11_1(demoSchool, board, classLevel, u1);
        seedChapter11_2(demoSchool, board, classLevel, u1);
        seedChapter11_3(demoSchool, board, classLevel, u1);
        seedChapter11_4(demoSchool, board, classLevel, u1);
        seedChapter11_5(demoSchool, board, classLevel, u1);

        // Unit II
        String u2 = "UNIT II – ALGORITHMIC PROBLEM SOLVING";
        createUnit(demoSchool, board, classLevel, 2, u2);
        seedChapter11_6(demoSchool, board, classLevel, u2);
        seedChapter11_7(demoSchool, board, classLevel, u2);
        seedChapter11_8(demoSchool, board, classLevel, u2);

        // Unit III
        String u3 = "UNIT III – INTRODUCTION TO C++";
        createUnit(demoSchool, board, classLevel, 3, u3);
        seedChapter11_9(demoSchool, board, classLevel, u3);
        seedChapter11_10(demoSchool, board, classLevel, u3);
        seedChapter11_11(demoSchool, board, classLevel, u3);
        seedChapter11_12(demoSchool, board, classLevel, u3);

        // Unit IV
        String u4 = "UNIT IV – OBJECT ORIENTED PROGRAMMING WITH C++";
        createUnit(demoSchool, board, classLevel, 4, u4);
        seedChapter11_13(demoSchool, board, classLevel, u4);
        seedChapter11_14(demoSchool, board, classLevel, u4);
        seedChapter11_15(demoSchool, board, classLevel, u4);
        seedChapter11_16(demoSchool, board, classLevel, u4);

        // Unit V
        String u5 = "UNIT V – COMPUTER ETHICS AND CYBER SECURITY";
        createUnit(demoSchool, board, classLevel, 5, u5);
        seedChapter11_17(demoSchool, board, classLevel, u5);
        seedChapter11_18(demoSchool, board, classLevel, u5);
    }

    private void seedClass12Syllabus(School demoSchool) {
        String board = "STATE_BOARD";
        int classLevel = 12;

        // Unit I
        String u1 = "UNIT I – PROBLEM SOLVING TECHNIQUES";
        createUnit(demoSchool, board, classLevel, 1, u1);
        seedChapter12_1(demoSchool, board, classLevel, u1);
        seedChapter12_2(demoSchool, board, classLevel, u1);
        seedChapter12_3(demoSchool, board, classLevel, u1);
        seedChapter12_4(demoSchool, board, classLevel, u1);

        // Unit II
        String u2 = "UNIT II – CORE PYTHON";
        createUnit(demoSchool, board, classLevel, 2, u2);
        seedChapter12_5(demoSchool, board, classLevel, u2);
        seedChapter12_6(demoSchool, board, classLevel, u2);
        seedChapter12_7(demoSchool, board, classLevel, u2);
        seedChapter12_8(demoSchool, board, classLevel, u2);

        // Unit III
        String u3 = "UNIT III – MODULARITY AND OOPS";
        createUnit(demoSchool, board, classLevel, 3, u3);
        seedChapter12_9(demoSchool, board, classLevel, u3);
        seedChapter12_10(demoSchool, board, classLevel, u3);

        // Unit IV
        String u4 = "UNIT IV – DATABASE CONCEPTS AND MYSQL";
        createUnit(demoSchool, board, classLevel, 4, u4);
        seedChapter12_11(demoSchool, board, classLevel, u4);
        seedChapter12_12(demoSchool, board, classLevel, u4);
        seedChapter12_13(demoSchool, board, classLevel, u4);

        // Unit V
        String u5 = "UNIT V – INTEGRATING PYTHON WITH MYSQL AND C++";
        createUnit(demoSchool, board, classLevel, 5, u5);
        seedChapter12_14(demoSchool, board, classLevel, u5);
        seedChapter12_15(demoSchool, board, classLevel, u5);
        seedChapter12_16(demoSchool, board, classLevel, u5);
    }

    private Unit createUnit(School school, String board, int classLevel, int unitNumber, String unitName) {
        Unit unit = new Unit(unitName, unitNumber, board, classLevel);
        unit.setSchool(school);
        return unitRepository.save(unit);
    }

    private Chapter createChapter(School school, String board, int classLevel, String unitName, int chNum, String chName) {
        Chapter ch = new Chapter();
        ch.setSchool(school);
        ch.setBoard(board);
        ch.setClassLevel(classLevel);
        ch.setUnit(unitName);
        ch.setChapterNumber(chNum);
        ch.setChapterName(chName);
        ch.setUnlocked(chNum == 1);
        return chapterRepository.save(ch);
    }

    private Mission createMission(School school, Chapter chapter, int missionNumber, String gameType) {
        Mission m = new Mission();
        m.setSchool(school);
        m.setChapter(chapter);
        m.setMissionNumber(missionNumber);
        m.setGameType(gameType);
        return missionRepository.save(m);
    }

    private void addMCQ(School school, String board, int classLevel, String unit, String chapter, int mission, String qText, String a, String b, String c, String d, String correct) {
        Question q = new Question();
        q.setSchool(school);
        q.setBoard(board);
        q.setClassLevel(classLevel);
        q.setUnit(unit);
        q.setChapter(chapter);
        q.setMission(mission);
        q.setQuestionType("MCQ");
        q.setQuestionText(qText);
        q.setOptionA(a);
        q.setOptionB(b);
        q.setOptionC(c);
        q.setOptionD(d);
        q.setCorrectAnswer(correct);
        questionRepository.save(q);
    }

    private void addFillBlank(School school, String board, int classLevel, String unit, String chapter, int mission, String qText, String correctAnswer) {
        Question q = new Question();
        q.setSchool(school);
        q.setBoard(board);
        q.setClassLevel(classLevel);
        q.setUnit(unit);
        q.setChapter(chapter);
        q.setMission(mission);
        q.setQuestionType("FILL_BLANK");
        q.setQuestionText(qText);
        q.setCorrectAnswer(correctAnswer);
        questionRepository.save(q);
    }

    private void addScenario(School school, String board, int classLevel, String unit, String chapter, int mission, String qText, String a, String b, String c, String d, String correct, String lang) {
        Question q = new Question();
        q.setSchool(school);
        q.setBoard(board);
        q.setClassLevel(classLevel);
        q.setUnit(unit);
        q.setChapter(chapter);
        q.setMission(mission);
        q.setQuestionType("SCENARIO");
        q.setQuestionText(qText);
        q.setOptionA(a);
        q.setOptionB(b);
        q.setOptionC(c);
        q.setOptionD(d);
        q.setCorrectAnswer(correct);
        q.setCodeLanguage(lang);
        questionRepository.save(q);
    }

    // Helper to build all 4 missions for a chapter automatically
    private Chapter buildChapterMissions(School school, String board, int classLevel, String unit, int chNum, String chName) {
        Chapter ch = createChapter(school, board, classLevel, unit, chNum, chName);
        createMission(school, ch, 1, "MCQ Quiz");
        createMission(school, ch, 2, "Fill in the Blank");
        createMission(school, ch, 3, "MCQ Quiz");
        createMission(school, ch, 4, "Scenario Challenge");
        return ch;
    }

    // ==========================================
    // CLASS 11 SEEDING METHODS
    // ==========================================

    private void seedChapter11_1(School school, String board, int classLevel, String unit) {
        String chName = "1. Introduction to Computers";
        buildChapterMissions(school, board, classLevel, unit, 1, chName);

        // M1: MCQ
        addMCQ(school, board, classLevel, unit, chName, 1, "Which generation of computers used vacuum tubes?", "First Generation", "Second Generation", "Third Generation", "Fourth Generation", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Who is known as the Father of Computers?", "Charles Babbage", "Alan Turing", "John von Neumann", "Blaise Pascal", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which unit performs arithmetic and logical operations?", "ALU", "Control Unit", "Memory Unit", "Output Unit", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which component holds data temporarily during processing?", "RAM", "ROM", "Hard Disk", "CD-ROM", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "First generation computer ENIAC stands for?", "Electronic Numerical Integrator and Computer", "Electrical Network Computer", "Engine Numerical Calculator", "Electronic Network Computing", "A");

        // M2: Fill Blank
        addFillBlank(school, board, classLevel, unit, chName, 2, "The main brain of the computer is the ____.", "CPU");
        addFillBlank(school, board, classLevel, unit, chName, 2, "First generation computers used ____ tubes.", "vacuum");
        addFillBlank(school, board, classLevel, unit, chName, 2, "____ is a volatile primary memory.", "RAM");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Integrated Circuits (ICs) were introduced in ____ generation.", "Third");
        addFillBlank(school, board, classLevel, unit, chName, 2, "The physical components of a computer are called ____.", "hardware");

        // M3: MCQ
        addMCQ(school, board, classLevel, unit, chName, 3, "Which device is used for output?", "Monitor", "Keyboard", "Mouse", "Scanner", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which of the following is non-volatile memory?", "ROM", "RAM", "Cache", "Register", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Microprocessors were introduced in which generation?", "Fourth Generation", "First Generation", "Second Generation", "Third Generation", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which memory is fastest in access time?", "Cache Memory", "RAM", "Hard Disk", "ROM", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "What does BIOS stand for?", "Basic Input Output System", "Binary Input Output System", "Basic Integrated Operating System", "Base Internal Operating System", "A");

        // M4: Scenario
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: An engineer needs to select a computer for heavy AI modeling. Which generation concept introduced Artificial Intelligence?", "Fifth Generation", "Fourth Generation", "Third Generation", "Second Generation", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A school library needs to preserve records permanently even when power turns off. Which memory type should store the firmware?", "ROM", "RAM", "Cache", "Registers", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A graphics application runs slowly due to low temporary storage. Upgrading which component will increase temporary memory speed?", "RAM", "ROM", "DVD Drive", "Power Supply", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A student types a document. What is the path of data processing in computer architecture?", "Input -> Processing -> Output", "Output -> Input -> Processing", "Processing -> Input -> Output", "Output -> Processing -> Input", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: An ancient calculation tool called Abacus was developed in which country?", "China", "Greece", "India", "Egypt", "A", null);
    }

    private void seedChapter11_2(School school, String board, int classLevel, String unit) {
        String chName = "2. Number Systems";
        buildChapterMissions(school, board, classLevel, unit, 2, chName);

        // M1: MCQ
        addMCQ(school, board, classLevel, unit, chName, 1, "What is the base of the Binary number system?", "2", "8", "10", "16", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "What is the base of the Hexadecimal number system?", "16", "10", "8", "2", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Binary 1010 in decimal equivalent is?", "10", "8", "12", "14", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "1 Byte equals how many Bits?", "8", "4", "16", "32", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "1 Nibble equals how many Bits?", "4", "8", "2", "16", "A");

        // M2: Fill Blank
        addFillBlank(school, board, classLevel, unit, chName, 2, "The base value of Octal number system is ____.", "8");
        addFillBlank(school, board, classLevel, unit, chName, 2, "1 Byte consists of ____ bits.", "8");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Hexadecimal digit A represents decimal value ____.", "10");
        addFillBlank(school, board, classLevel, unit, chName, 2, "ASCII code stands for American Standard Code for Information ____.", "Interchange");
        addFillBlank(school, board, classLevel, unit, chName, 2, "The 1's complement of 1010 is ____.", "0101");

        // M3: MCQ
        addMCQ(school, board, classLevel, unit, chName, 3, "Decimal number 15 in Hexadecimal is represented by?", "F", "E", "D", "A", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "What is the 1's complement of 1100?", "0011", "1111", "0000", "1001", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "2's complement is calculated as?", "1's complement + 1", "1's complement - 1", "Binary + 1", "Binary - 1", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which encoding scheme supports 65,536 characters (16-bit)?", "Unicode", "ASCII", "ISCII", "BCD", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Binary addition of 1 + 1 gives?", "Sum 0, Carry 1", "Sum 1, Carry 0", "Sum 1, Carry 1", "Sum 2, Carry 0", "A");

        // M4: Scenario
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A network router displays IP address in hexadecimal 0xC. What is its decimal value?", "12", "10", "14", "15", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: You convert binary 1111 to decimal for a memory calculation. What is the value?", "15", "16", "14", "8", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A 1's complement of 10101 is needed in digital logic. What is the inverted result?", "01010", "11111", "00000", "10101", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: 2's complement representation of -5 in 4-bit binary is?", "1011", "1100", "0101", "1111", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: How many distinct characters can standard 7-bit ASCII encode?", "128", "256", "64", "512", "A", null);
    }

    private void seedChapter11_3(School school, String board, int classLevel, String unit) {
        String chName = "3. Computer Organization";
        buildChapterMissions(school, board, classLevel, unit, 3, chName);

        addMCQ(school, board, classLevel, unit, chName, 1, "Which bus carries data between CPU and Memory?", "Data Bus", "Address Bus", "Control Bus", "PCI Bus", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which bus carries memory address location?", "Address Bus", "Data Bus", "Control Bus", "Expansion Bus", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "What does RAM stand for?", "Random Access Memory", "Read Access Memory", "Rapid Access Module", "Run All Memory", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which port is commonly used to connect display monitors?", "HDMI / VGA", "PS/2", "Audio Jack", "Ethernet", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "What does USB stand for?", "Universal Serial Bus", "United Service Bus", "Universal Storage Bus", "Unified System Bus", "A");

        addFillBlank(school, board, classLevel, unit, chName, 2, "The bus that specifies physical memory address is ____ bus.", "address");
        addFillBlank(school, board, classLevel, unit, chName, 2, "____ memory is a high-speed memory placed between CPU and main memory.", "Cache");
        addFillBlank(school, board, classLevel, unit, chName, 2, "SRAM stands for ____ RAM.", "Static");
        addFillBlank(school, board, classLevel, unit, chName, 2, "DRAM stands for ____ RAM.", "Dynamic");
        addFillBlank(school, board, classLevel, unit, chName, 2, "HDMI port transfers both video and ____ signals.", "audio");

        addMCQ(school, board, classLevel, unit, chName, 3, "Which memory needs continuous refreshing?", "DRAM", "SRAM", "ROM", "EEPROM", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which port connects to wired network cables?", "RJ-45 / Ethernet", "USB 2.0", "HDMI", "VGA", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which type of ROM can be erased using Ultraviolet light?", "EPROM", "PROM", "EEPROM", "Mask ROM", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which type of ROM can be erased electrically?", "EEPROM", "EPROM", "PROM", "ROM", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which register holds the address of the next instruction to execute?", "Program Counter (PC)", "Instruction Register", "Memory Data Register", "Accumulator", "A");

        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A PC gamer notices high frame drops. Which bus bandwidth expansion directly connects Graphics Card to CPU?", "PCIe", "USB", "SATA", "IDE", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A server technician needs zero-refresh memory for ultra-low latency cache. Which RAM technology should be chosen?", "SRAM", "DRAM", "SDRAM", "DDR4", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: An engineer plugs a high-definition monitor and speakers using a single cable. Which interface port is used?", "HDMI", "VGA", "DVI", "Serial Port", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is the main function of the Control Bus in microprocessors?", "Transmit control signals between components", "Store memory data", "Hold memory addresses", "Perform addition", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: Flashing a BIOS update uses electrical signals to overwrite firmware. Which memory chip is being flashed?", "EEPROM", "EPROM", "PROM", "SRAM", "A", null);
    }

    private void seedChapter11_4(School school, String board, int classLevel, String unit) {
        String chName = "4. Theoretical Concepts of Operating System";
        buildChapterMissions(school, board, classLevel, unit, 4, chName);

        addMCQ(school, board, classLevel, unit, chName, 1, "Which component acts as an interface between User and Hardware?", "Operating System", "Compiler", "Text Editor", "Database", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which of the following is an open-source Operating System?", "Linux", "Windows 11", "macOS", "MS-DOS", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "What is the core central program of an Operating System called?", "Kernel", "Shell", "GUI", "Driver", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which scheduling algorithm allocates fixed time CPU slots (quantum)?", "Round Robin", "FCFS", "SJF", "Priority", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "What is a state where processes wait indefinitely for resources held by each other?", "Deadlock", "Spooling", "Paging", "Caching", "A");

        addFillBlank(school, board, classLevel, unit, chName, 2, "The core part of the OS that manages system resources is the ____.", "Kernel");
        addFillBlank(school, board, classLevel, unit, chName, 2, "FCFS stands for First Come First ____.", "Served");
        addFillBlank(school, board, classLevel, unit, chName, 2, "____ GUI stands for Graphical User Interface.", "GUI");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Virtual memory uses ____ on hard disk when RAM is full.", "paging");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Linux is created under GNU ____ Public License.", "General");

        addMCQ(school, board, classLevel, unit, chName, 3, "Which process management technique loads active pages of process into RAM?", "Paging", "Compaction", "Formatting", "Defragmentation", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which operating system technique allows multiple users to access a system simultaneously?", "Multi-user OS", "Single-user OS", "Batch Processing OS", "Real-time OS", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which scheduling strategy executes the job with the shortest CPU burst first?", "SJF (Shortest Job First)", "FCFS", "Round Robin", "FIFO", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "What does GUI stand for?", "Graphical User Interface", "Global User Interface", "General Utility Interface", "Guided User Interaction", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which file management technique organizes files into hierarchical tree folders?", "Directory System", "Flat File System", "Sequential Access", "Binary Indexing", "A");

        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: An OS handles print jobs from 5 computers simultaneously without mixing pages. Which technique queues print data?", "Spooling", "Swapping", "Paging", "Multithreading", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: Two programs are blocked because Program A holds Resource 1 waiting for Resource 2, while Program B holds Resource 2 waiting for Resource 1. What is this condition?", "Deadlock", "Starvation", "Race Condition", "Context Switching", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A web server gives equal CPU time slices of 10ms to each client request. Which CPU scheduling algorithm is used?", "Round Robin", "FCFS", "Priority Scheduling", "Multilevel Queue", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: RAM capacity is 8GB but a video renderer needs 12GB. Which OS virtual memory mechanism transfers data between disk and RAM?", "Paging and Swapping", "Defragmentation", "Partitioning", "Bootstrapping", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: When you power on a computer, which initial boot program loads the operating system kernel into RAM?", "Bootstrap Loader / BIOS", "Command Prompt", "Shell Script", "Task Manager", "A", null);
    }

    private void seedChapter11_5(School school, String board, int classLevel, String unit) {
        String chName = "5. Working with Windows Operating System";
        buildChapterMissions(school, board, classLevel, unit, 5, chName);

        addMCQ(school, board, classLevel, unit, chName, 1, "Which bar is located at the bottom of Windows desktop screen?", "Taskbar", "Title Bar", "Menu Bar", "Status Bar", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which shortcut key is used to delete a file permanently without moving to Recycle Bin?", "Shift + Delete", "Ctrl + Delete", "Alt + Delete", "Tab + Delete", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which keyboard shortcut opens the Windows Start Menu?", "Ctrl + Esc", "Alt + Tab", "Ctrl + Alt + Del", "Shift + Esc", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which default Windows app is used to browse files and folders?", "File Explorer", "Control Panel", "Task Manager", "Device Manager", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which mouse click opens a file or folder in Windows?", "Double Left Click", "Single Right Click", "Scroll Click", "Middle Click", "A");

        addFillBlank(school, board, classLevel, unit, chName, 2, "Deleted files are temporarily stored in the ____ Bin.", "Recycle");
        addFillBlank(school, board, classLevel, unit, chName, 2, "The shortcut key to copy selected text is Ctrl + ____.", "C");
        addFillBlank(school, board, classLevel, unit, chName, 2, "The shortcut key to paste copied text is Ctrl + ____.", "V");
        addFillBlank(school, board, classLevel, unit, chName, 2, "The bar at the bottom of desktop containing Start button is the ____.", "Taskbar");
        addFillBlank(school, board, classLevel, unit, chName, 2, "The shortcut key to undo last action is Ctrl + ____.", "Z");

        addMCQ(school, board, classLevel, unit, chName, 3, "Which key shortcut switches between open applications in Windows?", "Alt + Tab", "Ctrl + Tab", "Shift + Tab", "Win + Tab", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which utility app manages hardware system devices in Windows?", "Device Manager", "Disk Cleanup", "Notepad", "Paint", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which utility removes temporary unneeded files to free space?", "Disk Cleanup", "Task Manager", "Registry Editor", "Command Prompt", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "What is the shortcut key to rename a selected file?", "F2", "F5", "F1", "F12", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "What is the shortcut key to refresh current active window?", "F5", "F2", "F8", "F11", "A");

        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A user accidentally deleted an important project file. Where can it be restored from?", "Recycle Bin", "Downloads Folder", "Control Panel", "System Volume Information", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: An application becomes unresponsive and freezes the screen. Which Windows utility should be opened to force quit it?", "Task Manager (Ctrl+Shift+Esc)", "File Explorer", "Disk Management", "Control Panel", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A student wants to take a screenshot of the active window and save it. Which key combination takes Print Screen?", "PrtScn / Win + Shift + S", "Ctrl + P", "Alt + F4", "Ctrl + S", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: You want to select all items inside a folder. What shortcut key is used?", "Ctrl + A", "Ctrl + S", "Ctrl + X", "Alt + A", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: To minimize all open windows and show Desktop immediately, which shortcut is used?", "Win + D", "Alt + F4", "Ctrl + W", "Shift + D", "A", null);
    }

    private void seedChapter11_6(School school, String board, int classLevel, String unit) {
        String chName = "6. Specification and Abstraction";
        buildChapterMissions(school, board, classLevel, unit, 6, chName);

        addMCQ(school, board, classLevel, unit, chName, 1, "What defines the relationship between input and output of an algorithm?", "Specification", "Abstraction", "Decomposition", "Iteration", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Hiding unnecessary details and showing only essential features is called?", "Abstraction", "Specification", "Composition", "Recursion", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "In algorithm specification, input properties are defined by?", "Pre-condition (Inputs)", "Post-condition (Outputs)", "Loop Invariant", "Variable Scope", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Output guarantees after algorithm execution are specified by?", "Post-condition", "Pre-condition", "State Space", "Assignment", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "A variable's current value in an algorithm represents its?", "State", "Abstraction", "Flow", "Signature", "A");

        addFillBlank(school, board, classLevel, unit, chName, 2, "Hiding implementation details is known as ____.", "abstraction");
        addFillBlank(school, board, classLevel, unit, chName, 2, "The condition required before executing a function is ____-condition.", "pre");
        addFillBlank(school, board, classLevel, unit, chName, 2, "The condition guaranteed after function execution is ____-condition.", "post");
        addFillBlank(school, board, classLevel, unit, chName, 2, "An algorithm's state is defined by the values of its ____.", "variables");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Specification uses inputs and ____ to state problem goal.", "outputs");

        addMCQ(school, board, classLevel, unit, chName, 3, "Which of the following describes algorithm state change?", "Assignment Statement", "Comment Line", "Function Header", "Variable Type", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "In algorithm notation, 'P -- inputs' and 'Q -- outputs' form the?", "Specification Contract", "Recurrence Relation", "Control Graph", "Paging Table", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Designing a driver dashboard that shows speed without internal engine mechanics is an example of?", "Abstraction", "Recursion", "Sorting", "Compilation", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "If a precondition is false before function execution, the postcondition is?", "Not Guaranteed", "Always True", "Always False", "Zero", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which mathematical property specifies algorithm correctness?", "Pre-condition and Post-condition", "Time Complexity", "Space Complexity", "Line Count", "A");

        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A square root function requires input x >= 0. What type of condition is x >= 0?", "Pre-condition", "Post-condition", "Loop Invariant", "Exception", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: An ATM user selects 'Withdraw Cash' without knowing database SQL commands. Which principle is applied?", "Abstraction", "Recursion", "Decomposition", "Iteration", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: Function divide(a, b) specifies b != 0. If caller passes b = 0, what is violated?", "Pre-condition", "Post-condition", "Variable Type", "Return Type", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A student models a student entity storing only Name and Age, ignoring height and eye color. This process is?", "Data Abstraction", "Control Flow", "Debugging", "Iteration", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: After executing sort(arr), arr is ordered in non-decreasing order. This guarantee is the?", "Post-condition", "Pre-condition", "State Space", "Loop Constant", "A", null);
    }

    private void seedChapter11_7(School school, String board, int classLevel, String unit) {
        String chName = "7. Composition and Decomposition";
        buildChapterMissions(school, board, classLevel, unit, 7, chName);

        addMCQ(school, board, classLevel, unit, chName, 1, "Breaking down a main problem into smaller sub-problems is called?", "Decomposition", "Composition", "Abstraction", "Recursion", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Combining simple statements or sub-problems into compound statements is called?", "Composition", "Decomposition", "Refactoring", "Parsing", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which control statement evaluates a condition and selects between execution paths?", "Conditional Statement (If-Else)", "Assignment", "Sequential", "Comment", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "A self-contained block of reusable code performing a sub-task is a?", "Function / Sub-program", "Variable", "Constant", "Operator", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "In flowcharts, a diamond symbol represents?", "Decision / Condition", "Process", "Input / Output", "Start / End", "A");

        addFillBlank(school, board, classLevel, unit, chName, 2, "Dividing a complex problem into smaller sub-tasks is called ____.", "decomposition");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Combining statements to build larger algorithms is called ____.", "composition");
        addFillBlank(school, board, classLevel, unit, chName, 2, "In flowcharts, rectangle shape represents ____ step.", "process");
        addFillBlank(school, board, classLevel, unit, chName, 2, "In flowcharts, parallelogram represents input and ____.", "output");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Functions allow code reuse through problem ____.", "decomposition");

        addMCQ(school, board, classLevel, unit, chName, 3, "Which statement executes actions one after another sequentially?", "Sequential Composition", "Iterative Loop", "Recursive Branch", "Exception Trap", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Flowchart oval symbol indicates?", "Start / Stop", "Decision", "Process", "Connector", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Modular programming uses which algorithmic principle?", "Decomposition", "Global State", "Unconditional Jump", "Linear Search", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Combining if-else inside another if-else statement is known as?", "Nested Conditional", "Nested Loop", "Tail Recursion", "Abstraction", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Inputs passed into sub-functions are called?", "Parameters / Arguments", "Return Values", "Constants", "Global Flags", "A");

        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: An e-commerce system divides ordering into Cart, Payment, and Shipping modules. What algorithmic technique is this?", "Decomposition", "Recursion", "Abstraction", "Paging", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A programmer combines input reading, calculation, and output display in 3 sequential steps. This is?", "Sequential Composition", "Recursive Call", "Asynchronous Loop", "Thread Deadlock", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A grade program checks if mark >= 50 print 'Pass' else 'Fail'. Which control structure is composed?", "Alternative / Conditional (If-Else)", "Iterative Loop", "Recursion", "GoTo Jump", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A developer writes calculateTax() once and calls it from 5 different billing programs. What is the main benefit?", "Code Reuse via Function Decomposition", "Faster RAM Speed", "Lower Disk Space", "Automatic Compilation", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A flowchart path branches into two arrows from a diamond box. What does the diamond contain?", "Condition Expression", "Variable Assignment", "Print Message", "End Token", "A", null);
    }

    private void seedChapter11_8(School school, String board, int classLevel, String unit) {
        String chName = "8. Iteration and recursion";
        buildChapterMissions(school, board, classLevel, unit, 8, chName);

        addMCQ(school, board, classLevel, unit, chName, 1, "Executing a set of statements repeatedly based on a condition is called?", "Iteration / Loop", "Abstraction", "Composition", "Specification", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "A function calling itself directly or indirectly is called?", "Recursion", "Iteration", "Decomposition", "Specification", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "The terminating condition in a recursive function is called?", "Base Case", "Iterative Step", "Loop Invariant", "Post-condition", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "What happens if a recursive function does NOT have a base case?", "Stack Overflow / Infinite Loop", "Instant Finish", "Syntax Error", "Zero Output", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "A condition that remains true before and after each iteration of a loop is called?", "Loop Invariant", "Base Case", "Pre-condition", "Recursion Step", "A");

        addFillBlank(school, board, classLevel, unit, chName, 2, "A function that calls itself is known as ____.", "recursion");
        addFillBlank(school, board, classLevel, unit, chName, 2, "The condition to stop recursive calls is the ____ case.", "base");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Repeating a set of statements is called ____.", "iteration");
        addFillBlank(school, board, classLevel, unit, chName, 2, "A loop that never terminates is an ____ loop.", "infinite");
        addFillBlank(school, board, classLevel, unit, chName, 2, "A property true at the start and end of every loop cycle is loop ____.", "invariant");

        addMCQ(school, board, classLevel, unit, chName, 3, "Factorial of n calculated as n * fact(n-1) is an example of?", "Recursion", "Iteration", "Abstraction", "Composition", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "In a while loop, when is the test condition evaluated?", "Before entering loop body (Entry-controlled)", "After executing loop body", "At compilation", "Never", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Fibonacci sequence defined as F(n) = F(n-1) + F(n-2) naturally uses?", "Recursion", "Flat Arrays", "Queue Spooling", "Paging", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which data structure is internally used by system memory during recursive function calls?", "Call Stack", "Queue", "Linked List", "Binary Tree", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "To calculate sum of numbers from 1 to N using for-loop uses?", "Iteration", "Recursion", "Decomposition", "Abstraction", "A");

        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: Function fact(n) returns 1 when n == 0. What role does n == 0 play?", "Base Case terminating recursion", "Recursive Step", "Loop Invariant", "Global State", "A", "C++");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: An iterative loop i=1; while(i<=5) i++ runs how many times?", "5 times", "4 times", "6 times", "Infinite times", "A", "C++");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A recursive program runs out of memory and crashes with StackOverflowError. What was missing?", "Proper Base Case condition", "Include statement", "Main function", "Return variable", "A", "C++");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: Counting countdown timer 10 down to 1 using for(int i=10; i>0; i--) is an example of?", "Iteration", "Recursion", "Abstraction", "Decomposition", "A", "C++");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: In loop invariant proof, invariant must hold in 3 steps: Initialization, Maintenance, and?", "Termination", "Compilation", "Decomposition", "Allocation", "A", null);
    }

    private void seedChapter11_9(School school, String board, int classLevel, String unit) {
        String chName = "9. Introduction to C++";
        buildChapterMissions(school, board, classLevel, unit, 9, chName);

        addMCQ(school, board, classLevel, unit, chName, 1, "Who developed the C++ programming language?", "Bjarne Stroustrup", "Dennis Ritchie", "James Gosling", "Guido van Rossum", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Every C++ statement must end with which character?", "Semicolon (;)", "Colon (:)", "Period (.)", "Comma (,)", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which header file is required for std::cout and std::cin in C++?", "<iostream>", "<stdio.h>", "<conio.h>", "<math.h>", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which operator is used with cout for output display?", "Insertion operator (<<)", "Extraction operator (>>)", "Dot operator (.)", "Scope operator (::)", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which operator is used with cin for taking user input?", "Extraction operator (>>)", "Insertion operator (<<)", "Address operator (&)", "Pointer operator (*)", "A");

        addFillBlank(school, board, classLevel, unit, chName, 2, "C++ was developed by Bjarne ____.", "Stroustrup");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Standard output object in C++ is ____.", "cout");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Standard input object in C++ is ____.", "cin");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Every statement in C++ ends with a ____.", "semicolon");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Header file for input output stream is ____.", "iostream");

        addMCQ(school, board, classLevel, unit, chName, 3, "Which of the following is a valid C++ identifier name?", "student_age", "123student", "int", "user-name", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which data type is used to store fractional decimal numbers in C++?", "float / double", "int", "char", "bool", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which keyword is used to declare a constant variable in C++?", "const", "final", "static", "define", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "What is the size of char data type in C++?", "1 Byte", "2 Bytes", "4 Bytes", "8 Bytes", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Single-line comments in C++ start with?", "//", "/*", "<!--", "#", "A");

        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is the output of the C++ code?\nint x = 5;\ncout << x + 3;", "8", "53", "5", "3", "A", "C++");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A developer writes `cin >> x;`. What operator is `>>`?", "Extraction Operator", "Insertion Operator", "Bitwise Shift", "Comparison", "A", "C++");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What will happen if you use `int float = 10;` in C++?", "Compiler Error (float is reserved keyword)", "Variable created successfully", "Warning only", "Runtime Exception", "A", "C++");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: Which escape sequence moves cursor to next line in cout?", "\\n or endl", "\\t", "\\b", "\\r", "A", "C++");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is the boolean result of expression `(5 > 3 && 2 < 4)` in C++?", "true (1)", "false (0)", "null", "error", "A", "C++");
    }

    private void seedChapter11_10(School school, String board, int classLevel, String unit) {
        String chName = "10. Flow of Control";
        buildChapterMissions(school, board, classLevel, unit, 10, chName);

        addMCQ(school, board, classLevel, unit, chName, 1, "Which selection statement tests multiple constant values against an expression?", "switch", "if-else", "while", "for", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which loop checks condition AFTER executing loop body at least once?", "do-while", "while", "for", "foreach", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which keyword terminates a loop or switch statement immediately?", "break", "continue", "return", "exit", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which keyword skips remaining statements in current loop iteration and starts next iteration?", "continue", "break", "goto", "skip", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which loop is best when exact number of iterations is known in advance?", "for loop", "do-while loop", "while loop", "infinite loop", "A");

        addFillBlank(school, board, classLevel, unit, chName, 2, "The loop that executes at least once is the ____-while loop.", "do");
        addFillBlank(school, board, classLevel, unit, chName, 2, "The statement to exit a switch case is ____.", "break");
        addFillBlank(school, board, classLevel, unit, chName, 2, "The statement to skip current loop iteration is ____.", "continue");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Default case in switch is executed when no case ____ matches.", "value");
        addFillBlank(school, board, classLevel, unit, chName, 2, "In for(init; cond; upd), the test condition is check before each ____.", "iteration");

        addMCQ(school, board, classLevel, unit, chName, 3, "What happens if break is omitted in a switch case?", "Fall-through to next case", "Syntax error", "Infinite loop", "Program crashes", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which of the following is an entry-controlled loop?", "while loop", "do-while loop", "exit-while", "post-test", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "What is the output of `for(int i=0; i<3; i++)` loop execution count?", "3 times", "2 times", "4 times", "0 times", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which statement allows unconditional jump to a labeled statement?", "goto", "break", "continue", "switch", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Ternary operator `?:` is a shorthand replacement for?", "if-else", "switch", "for loop", "while loop", "A");

        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is the output?\nint a = 2;\nswitch(a){\n  case 1: cout<<\"One\"; break;\n  case 2: cout<<\"Two\"; break;\n  default: cout<<\"Def\";\n}", "Two", "One", "Def", "OneTwo", "A", "C++");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: How many times will `int i=5; do{ cout<<i; i++; }while(i<5);` execute?", "1 time", "0 times", "5 times", "Infinite times", "A", "C++");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is printed?\nfor(int i=1; i<=5; i++){\n  if(i==3) continue;\n  cout<<i;\n}", "1245", "12345", "12", "3", "A", "C++");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is printed?\nint x = (10 > 20) ? 100 : 200;", "200", "100", "10", "20", "A", "C++");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A menu program needs to display options at least once before asking user to repeat. Which loop fits best?", "do-while loop", "while loop", "for loop", "nested if", "A", "C++");
    }

    private void seedChapter11_11(School school, String board, int classLevel, String unit) {
        String chName = "11. Functions";
        buildChapterMissions(school, board, classLevel, unit, 11, chName);

        addMCQ(school, board, classLevel, unit, chName, 1, "Which keyword indicates that a function does NOT return any value?", "void", "int", "static", "null", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Arguments passed in function call are called?", "Actual Arguments", "Formal Arguments", "Dummy Arguments", "Local Variables", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Parameters declared in function header definition are called?", "Formal Arguments", "Actual Arguments", "Global Constants", "Literal Values", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which parameter passing method passes copies of values?", "Call by Value", "Call by Reference", "Call by Address", "Call by Name", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which parameter passing method uses reference operator `&`?", "Call by Reference", "Call by Value", "Call by Value-Result", "Call by Pointer", "A");

        addFillBlank(school, board, classLevel, unit, chName, 2, "A function that returns no value has return type ____.", "void");
        addFillBlank(school, board, classLevel, unit, chName, 2, "The function entry point in every C++ program is ____().", "main");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Arguments in function call are ____ arguments.", "actual");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Parameters in function definition are ____ arguments.", "formal");
        addFillBlank(school, board, classLevel, unit, chName, 2, "The keyword to return a value from function is ____.", "return");

        addMCQ(school, board, classLevel, unit, chName, 3, "An inline function request in C++ is suggested using keyword?", "inline", "fast", "macro", "static", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "What happens to formal parameters in Call by Value when modified?", "Original actual arguments remain unchanged", "Original actual arguments change", "Compilation error", "Memory leaks", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "What happens to actual arguments in Call by Reference when formal parameter changes?", "Original actual arguments are updated", "No change in original arguments", "Syntax error", "Program crashes", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Scope of variables declared inside a function block is?", "Local Scope", "Global Scope", "File Scope", "Class Scope", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Default argument values in function prototype must be specified from?", "Right to Left", "Left to Right", "Middle to End", "Any order", "A");

        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is the output?\nint add(int a, int b=5){ return a+b; }\ncout<<add(10);", "15", "10", "5", "Error", "A", "C++");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: `void swap(int &x, int &y)` uses which passing mechanism?", "Call by Reference", "Call by Value", "Call by Register", "Call by Macro", "A", "C++");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What happens if `int square(int n)` forgets a `return` statement?", "Undefined value or compiler warning", "Returns 0 always", "Syntax error always", "Prints blank", "A", "C++");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: Function signature `int calc(double x)` vs `int calc(int x)` is an example of?", "Function Overloading", "Function Overriding", "Recursion", "Inline Inlining", "A", "C++");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: Small functions marked `inline` improve speed by doing what?", "Replacing function call with actual code body at compile time", "Making code run on GPU", "Eliminating variables", "Preventing recursion", "A", "C++");
    }

    private void seedChapter11_12(School school, String board, int classLevel, String unit) {
        String chName = "12. Arrays and Structures";
        buildChapterMissions(school, board, classLevel, unit, 12, chName);

        addMCQ(school, board, classLevel, unit, chName, 1, "An array is a collection of elements of?", "Same Data Type", "Different Data Types", "Only Integers", "Only Strings", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "What is the index of the first element in a C++ array?", "0", "1", "-1", "Depends on size", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "For an array `int arr[5]`, what is the valid index range?", "0 to 4", "1 to 5", "0 to 5", "1 to 4", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which keyword is used to declare a user-defined structure in C++?", "struct", "class", "union", "typedef", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which operator is used to access members of a structure variable?", "Dot operator (.)", "Arrow operator (->)", "Scope operator (::)", "Comma operator (,)", "A");

        addFillBlank(school, board, classLevel, unit, chName, 2, "Array elements are stored in ____ memory locations.", "contiguous");
        addFillBlank(school, board, classLevel, unit, chName, 2, "The index of the first array element is ____.", "0");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Keyword used to define a structure is ____.", "struct");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Structure member is accessed using the ____ operator.", "dot");
        addFillBlank(school, board, classLevel, unit, chName, 2, "A 2D array stores data in rows and ____.", "columns");

        addMCQ(school, board, classLevel, unit, chName, 3, "What is the total memory allocated for `int marks[10]` (assume 4 bytes per int)?", "40 Bytes", "10 Bytes", "20 Bytes", "80 Bytes", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "How is a two-dimensional array declared in C++?", "int arr[row][col];", "int arr(row, col);", "int arr[row, col];", "int arr{row}{col};", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "What is the end marker character of C-style strings in C++?", "Null character ('\\0')", "Newline ('\\n')", "Space (' ')", "Semicolon (';')", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Can a structure contain members of different data types?", "Yes", "No", "Only numeric types", "Only characters", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Array of structures allows storing?", "Multiple records of heterogeneous data", "Only single integer", "Only array indices", "Matrix determinant", "A");

        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is the output?\nint num[3] = {10, 20, 30};\ncout << num[1];", "20", "10", "30", "Garbage value", "A", "C++");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A structure `struct Student { int roll; float mark; }; Student s1 = {101, 95.5};` Accessing mark uses?", "s1.mark", "s1->mark", "Student.mark", "mark.s1", "A", "C++");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: Trying to access `arr[5]` for `int arr[5]` leads to?", "Array Index Out of Bounds (Garbage/Crash)", "Valid 5th item", "Automatic array expansion", "Compilation Error", "A", "C++");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is the size of `char name[20]` in memory?", "20 Bytes", "10 Bytes", "40 Bytes", "1 Byte", "A", "C++");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: To pass an array to a function, what is passed by default?", "Base address of the array (Pointer/Reference)", "Complete copy of all elements", "Array size only", "Null pointer", "A", "C++");
    }

    private void seedChapter11_13(School school, String board, int classLevel, String unit) {
        String chName = "13. Introduction to Object Oriented Programming Techniques";
        buildChapterMissions(school, board, classLevel, unit, 13, chName);

        addMCQ(school, board, classLevel, unit, chName, 1, "Which paradigm combines data and functions into a single unit?", "Object Oriented Programming (OOP)", "Procedural Programming", "Assembly Programming", "Functional Logic", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Wrapping up of data and functions into a single unit (Class) is called?", "Encapsulation", "Inheritance", "Polymorphism", "Abstraction", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Ability of a message/function to process data in more than one form is?", "Polymorphism", "Encapsulation", "Inheritance", "Modularity", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Process by which one class acquires properties of another class is?", "Inheritance", "Encapsulation", "Abstraction", "Overloading", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "An instance of a class is called an?", "Object", "Function", "Variable", "Structure", "A");

        addFillBlank(school, board, classLevel, unit, chName, 2, "Wrapping data and functions into a single unit is ____.", "encapsulation");
        addFillBlank(school, board, classLevel, unit, chName, 2, "An instance of a class is an ____.", "object");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Deriving new class from existing class is ____.", "inheritance");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Ability to take more than one form is ____.", "polymorphism");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Hiding internal implementation details is ____.", "abstraction");

        addMCQ(school, board, classLevel, unit, chName, 3, "Which OOP concept promotes code reusability?", "Inheritance", "Encapsulation", "Inline Functions", "Pointers", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which OOP concept protects data from outside unauthorized access?", "Encapsulation & Data Hiding", "Polymorphism", "Inheritance", "Dynamic Binding", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "A blueprint or template for creating objects is a?", "Class", "Function", "Array", "Module", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Procedural programming mainly focuses on?", "Functions / Algorithms", "Data Objects", "Classes", "Security", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Object-oriented programming mainly focuses on?", "Data Security and Objects", "Global Functions", "Line Numbers", "Assembly Directives", "A");

        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A Car blueprint defines color and speed, while a specific Red Sports Car is created from it. What is the Red Sports Car?", "An Object of Car Class", "A Class", "A Function", "A Macro", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: Bank Account balance is private and can only be modified via deposit() method. Which OOP pillar is enforced?", "Encapsulation", "Inheritance", "Polymorphism", "Abstraction", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: ElectricCar inherits features from Car class. What is Car class called?", "Base / Parent Class", "Derived Class", "Friend Class", "Abstract Object", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: The + operator adds numbers (5+3=8) and concatenates strings (\"A\"+\"B\"=\"AB\"). This is an example of?", "Polymorphism (Operator Overloading)", "Encapsulation", "Inheritance", "Data Hiding", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: Why is OOP preferred over procedural programming for large applications?", "Better Code Reuse, Security, and Maintainability", "Requires no compiler", "Uses less RAM", "Eliminates variables", "A", null);
    }

    private void seedChapter11_14(School school, String board, int classLevel, String unit) {
        String chName = "14. Classes and objects";
        buildChapterMissions(school, board, classLevel, unit, 14, chName);

        addMCQ(school, board, classLevel, unit, chName, 1, "Which keyword is used to define a class in C++?", "class", "struct", "object", "define", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "What is the default access specifier for class members in C++?", "private", "public", "protected", "global", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Members declared under which access specifier are accessible everywhere?", "public", "private", "protected", "internal", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "A special member function automatically executed when an object is created is?", "Constructor", "Destructor", "Inline function", "Friend function", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "A special member function automatically executed when an object goes out of scope is?", "Destructor", "Constructor", "Virtual function", "Operator", "A");

        addFillBlank(school, board, classLevel, unit, chName, 2, "Default access specifier in a C++ class is ____.", "private");
        addFillBlank(school, board, classLevel, unit, chName, 2, "The function with same name as class used for initialization is ____.", "constructor");
        addFillBlank(school, board, classLevel, unit, chName, 2, "A destructor name is preceded by a ____ (~) symbol.", "tilde");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Public members are accessed using the ____ operator.", "dot");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Class definition ends with a semicolon after closing ____.", "brace");

        addMCQ(school, board, classLevel, unit, chName, 3, "Does a constructor have a return type?", "No return type (not even void)", "void", "int", "bool", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "What symbol precedes the name of a Destructor in C++?", "Tilde (~)", "Hash (#)", "Asterisk (*)", "Ampersand (&)", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "A constructor that takes no arguments is called a?", "Default Constructor", "Parameterized Constructor", "Copy Constructor", "Inline Constructor", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which scope resolution operator is used to define class member functions outside the class?", ":: (Scope Resolution Operator)", ". (Dot Operator)", "-> (Arrow Operator)", "* (Pointer)", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "A non-member function granted special access to private members of a class is a?", "Friend Function", "Virtual Function", "Static Function", "Inline Function", "A");

        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is the output?\nclass Test { public: Test(){ cout<<\"A\"; } ~Test(){ cout<<\"B\"; } };\nint main(){ Test t; }", "AB", "BA", "A", "B", "A", "C++");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: `class Box { int w; }; Box b; b.w = 5;` What error will compile time give?", "w is private member of Box", "Box not found", "b is null", "Invalid syntax", "A", "C++");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: How many destructors can a class have?", "Only one destructor", "Multiple based on parameters", "Up to 5", "Unlimited", "A", "C++");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: `Box(const Box &b)` is what type of constructor?", "Copy Constructor", "Default Constructor", "Destructor", "Conversion Constructor", "A", "C++");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: Member functions defined inside class body are automatically treated as?", "Inline Functions", "Friend Functions", "Virtual Functions", "Global Functions", "A", "C++");
    }

    private void seedChapter11_15(School school, String board, int classLevel, String unit) {
        String chName = "15. Polymorphism";
        buildChapterMissions(school, board, classLevel, unit, 15, chName);

        addMCQ(school, board, classLevel, unit, chName, 1, "Which type of polymorphism is resolved at compile time?", "Compile-time / Static Polymorphism", "Run-time Polymorphism", "Dynamic Binding", "Late Binding", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Declaring multiple functions with same name but different parameter lists is called?", "Function Overloading", "Function Overriding", "Function Inlining", "Function Hiding", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Redefining a base class operator to work with user-defined class objects is called?", "Operator Overloading", "Operator Overriding", "Operator Casting", "Operator Extension", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which keyword is used to achieve run-time dynamic polymorphism in C++?", "virtual", "static", "friend", "inline", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which of the following operators CANNOT be overloaded in C++?", "Scope operator (::)", "+ operator", "- operator", "== operator", "A");

        addFillBlank(school, board, classLevel, unit, chName, 2, "Function overloading is resolved at ____ time.", "compile");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Virtual functions enable ____-time polymorphism.", "run");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Scope resolution operator :: ____ be overloaded.", "cannot");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Overloading requires functions to have different parameter ____.", "signatures");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Keyword used to declare dynamic binding function is ____.", "virtual");

        addMCQ(school, board, classLevel, unit, chName, 3, "A class containing at least one pure virtual function (= 0) is called?", "Abstract Class", "Concrete Class", "Derived Class", "Friend Class", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Can an Abstract Class be directly instantiated to create objects?", "No", "Yes", "Only inside main()", "Only if constructor is public", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Syntax for declaring a pure virtual function is?", "virtual void display() = 0;", "virtual void display() = null;", "void display() = pure;", "virtual display();", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which operator CANNOT be overloaded in C++?", "Sizeof operator (sizeof)", "Binary +", "Unary ++", "Assignment =", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Dynamic binding links function call to function body during?", "Program Execution (Run time)", "Compilation time", "Preprocessing", "Linking phase", "A");

        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: Function `area(int r)` and `area(int l, int b)` exist in same class. Which concept is used?", "Function Overloading", "Function Overriding", "Inheritance", "Abstraction", "A", "C++");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: Base class pointer `Shape* s` points to `Circle` object and calls virtual `s->draw()`. Which function executes?", "Circle's draw() function (Run-time polymorphism)", "Shape's draw() function", "Compilation error", "None", "A", "C++");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: Why does C++ prohibit overloading conditional operator `?:`?", "To preserve built-in control flow evaluation semantics", "Due to memory limits", "It has 3 operands", "It is reserved by OS", "A", "C++");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is the return type requirement for overloaded operator functions?", "Can return any valid type or class object", "Must return void always", "Must return int always", "Must return boolean", "A", "C++");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What happens if a derived class does not override a pure virtual function of its base class?", "Derived class also becomes an Abstract Class", "Program compiles and runs fine", "Base class function executes", "Destructor is deleted", "A", "C++");
    }

    private void seedChapter11_16(School school, String board, int classLevel, String unit) {
        String chName = "16. Inheritance";
        buildChapterMissions(school, board, classLevel, unit, 16, chName);

        addMCQ(school, board, classLevel, unit, chName, 1, "Deriving a new class from a single base class is called?", "Single Inheritance", "Multiple Inheritance", "Multilevel Inheritance", "Hierarchical Inheritance", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Deriving a class from MORE THAN ONE base class is called?", "Multiple Inheritance", "Single Inheritance", "Multilevel Inheritance", "Hybrid Inheritance", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Deriving Class C from Class B, which was derived from Class A is called?", "Multilevel Inheritance", "Multiple Inheritance", "Hierarchical Inheritance", "Single Inheritance", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which access specifier allows members to be accessible in derived classes but private outside?", "protected", "private", "public", "internal", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "In inheritance, which constructor is executed FIRST when a derived object is created?", "Base class constructor", "Derived class constructor", "Destructor", "Copy constructor", "A");

        addFillBlank(school, board, classLevel, unit, chName, 2, "Deriving from one base class is ____ inheritance.", "single");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Deriving from multiple base classes is ____ inheritance.", "multiple");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Members accessible to child class but hidden outside are ____.", "protected");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Base class constructor executes ____ derived class constructor.", "before");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Destructors execute in ____ order of constructors.", "reverse");

        addMCQ(school, board, classLevel, unit, chName, 3, "In inheritance, which destructor is executed FIRST when an object goes out of scope?", "Derived class destructor", "Base class destructor", "Default constructor", "Virtual table", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Multiple derived classes inheriting from a single base class is called?", "Hierarchical Inheritance", "Multiple Inheritance", "Multilevel Inheritance", "Hybrid Inheritance", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Combination of two or more types of inheritance is called?", "Hybrid Inheritance", "Single Inheritance", "Multilevel Inheritance", "Flat Inheritance", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which keyword is used in C++ class header to specify public inheritance?", "class Derived : public Base", "class Derived extends Base", "class Derived implements Base", "class Derived -> Base", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Diamond problem in multiple inheritance is resolved using?", "Virtual Base Class (virtual keyword)", "Inline Functions", "Static Members", "Friend Classes", "A");

        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: Class Car and Class House both inherit from Asset. Asset is inherited by two classes. What inheritance pattern is this?", "Hierarchical Inheritance", "Multiple Inheritance", "Multilevel Inheritance", "Single Inheritance", "A", "C++");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: Class SmartPhone inherits from Phone and Camera classes simultaneously. What inheritance pattern is this?", "Multiple Inheritance", "Single Inheritance", "Multilevel Inheritance", "Hierarchical Inheritance", "A", "C++");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: `class B : private A` How do public members of A behave in B?", "Become private members inside B", "Remain public", "Become protected", "Inaccessible", "A", "C++");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: Order of destructor calls for `class Child : public Parent` when Child object dies?", "Child Destructor first, then Parent Destructor", "Parent Destructor first, then Child", "Simultaneous", "Neither", "A", "C++");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: Why is Virtual Base Class used in `class A`, `class B: virtual public A`, `class C: virtual public A`, `class D: public B, C`?", "To prevent duplicate copies of A inside D", "To speed up compilation", "To make D abstract", "To hide constructors", "A", "C++");
    }

    private void seedChapter11_17(School school, String board, int classLevel, String unit) {
        String chName = "17. Computer Ethics and Cyber Security";
        buildChapterMissions(school, board, classLevel, unit, 17, chName);

        addMCQ(school, board, classLevel, unit, chName, 1, "Set of moral principles governing computer use is called?", "Computer Ethics", "Cyber Law", "Copyright", "Protocol", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Unauthorized copying and distribution of copyrighted software is called?", "Software Piracy", "Hacking", "Phishing", "Spamming", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Malicious software designed to damage or disrupt computers is?", "Malware", "Freeware", "Shareware", "Firmware", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Fraudulent attempt to obtain sensitive info (passwords, credit cards) via fake emails is?", "Phishing", "Snooping", "Spoofing", "Scamming", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "A network security system monitoring incoming and outgoing network traffic is a?", "Firewall", "Router", "Switch", "Hub", "A");

        addFillBlank(school, board, classLevel, unit, chName, 2, "Illegal copying of software is software ____.", "piracy");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Fraudulent emails stealing passwords is ____.", "phishing");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Malicious code self-replicating across networks is a ____.", "worm");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Security barrier filtering network traffic is a ____.", "firewall");
        addFillBlank(school, board, classLevel, unit, chName, 2, "India's Cyber Law Act is the IT Act ____.", "2000");

        addMCQ(school, board, classLevel, unit, chName, 3, "Which Act in India governs cybercrime and electronic commerce?", "IT Act 2000 (Information Technology Act)", "Cyber Act 1995", "Digital India Act 2015", "IPC Section 100", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Software that self-replicates across computer networks without human action is a?", "Worm", "Trojan Horse", "Adware", "Spyware", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Malware disguised as legitimate useful software is a?", "Trojan Horse", "Worm", "Ransomware", "Keylogger", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Malware that encrypts files and demands payment for decryption key is?", "Ransomware", "Spyware", "Adware", "Rootkit", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Stealing someone else's work or intellectual ideas and presenting them as one's own is?", "Plagiarism", "Piracy", "Phishing", "Spoofing", "A");

        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: An employee receives an email from 'Bank Admin' asking to click a link to verify password. What attack is this?", "Phishing Attack", "DDoS Attack", "Man-in-the-Middle", "SQL Injection", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A user's screen displays a message: 'All your files are encrypted. Pay $300 in Bitcoin to unlock'. What malware is this?", "Ransomware", "Trojan", "Adware", "Spyware", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A student copies paragraphs from a website directly into an assignment without citation. What violation is this?", "Plagiarism", "Software Piracy", "E-waste", "Hacking", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: To secure wireless router connections from unauthorized external access, what should be enabled?", "WPA2/WPA3 Encryption & Strong Password", "Disable Firewall", "Open Guest Mode", "HTTP Port 80", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: Ethical hackers who test system vulnerabilities legally with owner permission are called?", "White Hat Hackers", "Black Hat Hackers", "Crackers", "Script Kiddies", "A", null);
    }

    private void seedChapter11_18(School school, String board, int classLevel, String unit) {
        String chName = "18. Tamil Computing";
        buildChapterMissions(school, board, classLevel, unit, 18, chName);

        addMCQ(school, board, classLevel, unit, chName, 1, "Which encoding standard is widely used for digital representation of Tamil text?", "Unicode / TSCII / TAB", "ASCII", "EBCDIC", "ANSI", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which Tamil typing keyboard layout is officially approved by the Tamil Nadu Government?", "Tamil 99", "Phonetic", "Typewriter", "InScript", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "What does TSCII stand for?", "Tamil Script Code for Information Interchange", "Tamil System Code for Industry Integration", "Tamil Standard Software Code Interface", "Tamil Synchronous Communication Interchange", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which organization promotes Tamil computing research globally?", "INFITT (International Forum for Information Technology in Tamil)", "IEEE", "W3C", "ANSI", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "First Tamil interface software and search tools were developed for?", "Tamil text processing & localization", "3D Gaming", "Assembly Compilers", "Hardware BIOS", "A");

        addFillBlank(school, board, classLevel, unit, chName, 2, "The official Tamil keyboard layout approved by TN Govt is Tamil ____.", "99");
        addFillBlank(school, board, classLevel, unit, chName, 2, "TSCII stands for Tamil Script Code for Information ____.", "Interchange");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Unicode standard encodes characters for all world ____.", "languages");
        addFillBlank(school, board, classLevel, unit, chName, 2, "INFITT stands for International Forum for Information Technology in ____.", "Tamil");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Software converting spoken Tamil speech into text is Speech ____.", "Recognition");

        addMCQ(school, board, classLevel, unit, chName, 3, "Which operating systems support Tamil language localization?", "Windows, Linux, and macOS", "Windows only", "Linux only", "DOS only", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Tamil virtual keyboards enable typing Tamil characters using standard?", "QWERTY Keyboards", "Braille Boards", "Hex Pads", "Numeric Keypads only", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Text-to-Speech (TTS) tools in Tamil computing perform which function?", "Convert Tamil written text into audible speech", "Translate English to French", "Format SQL tables", "Compile C++ code", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Optical Character Recognition (OCR) for Tamil text accomplishes?", "Converting scanned image of Tamil text into editable digital text", "Editing MP3 audio", "Building web servers", "Compressing ZIP files", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which digital library portal preserves ancient Tamil literature online?", "Project Madurai", "Wikipedia", "GitHub", "StackOverflow", "A");

        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A government office needs to type Tamil official documents quickly. Which keyboard layout standard is recommended by TN Govt?", "Tamil 99 Keyboard Layout", "Standard US QWERTY without layout", "German QWERTZ", "French AZERTY", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: An archive digitizes printed Tamil palm leaf manuscripts using scanners. Which tool converts images to editable Tamil text?", "Tamil OCR (Optical Character Recognition)", "Tamil TTS", "TSCII Converter", "Tamil Compiler", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A visually impaired student wants to listen to Tamil news articles online. Which technology is used?", "Tamil Text-to-Speech (TTS)", "Tamil 99 Keyboard", "Font Converter", "Database Indexer", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: Why is Unicode preferred over old font-specific encodings like Tab/Tam?", "Unicode provides uniform global character representation independent of fonts", "Unicode uses less disk space", "Unicode doesn't need RAM", "Unicode only works in Tamil Nadu", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: Which open-source project provides a vast digital library of Tamil literary works free for public access?", "Project Madurai", "Project Gutenberg English", "OpenAI", "Linux Kernel", "A", null);
    }

    // ==========================================
    // CLASS 12 SEEDING METHODS
    // ==========================================

    private void seedChapter12_1(School school, String board, int classLevel, String unit) {
        String chName = "1. Function";
        buildChapterMissions(school, board, classLevel, unit, 1, chName);

        addMCQ(school, board, classLevel, unit, chName, 1, "Subroutines or building blocks of computer programs that take input and return output are?", "Functions", "Variables", "Constants", "Interfaces", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Variables defined in a function definition are called?", "Formal Parameters", "Actual Parameters", "Global Variables", "Literal Values", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Values passed into a function call are called?", "Actual Parameters / Arguments", "Formal Parameters", "Static Variables", "Macros", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "A function definition that does not depend on external state is a?", "Pure Function", "Impure Function", "Recursive Loop", "Global Function", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "A function that modifies state or variables outside its scope is a?", "Impure Function", "Pure Function", "Constant Function", "Lambda Function", "A");

        addFillBlank(school, board, classLevel, unit, chName, 2, "Parameters in function definition are ____ parameters.", "formal");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Arguments in function call are ____ parameters.", "actual");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Functions with no side effects are ____ functions.", "pure");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Functions modifying external state are ____ functions.", "impure");
        addFillBlank(school, board, classLevel, unit, chName, 2, "In Python, functions are defined using the ____ keyword.", "def");

        addMCQ(school, board, classLevel, unit, chName, 3, "Which of the following is an example of a Pure Function?", "sin(x) / abs(x)", "random()", "print()", "Date.now()", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which of the following is an Impure Function?", "random()", "sqrt(x)", "strlen(s)", "pow(x, y)", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "In Python, a function definition starts with which keyword?", "def", "func", "function", "define", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Evaluating a function with same arguments giving same result every time is a property of?", "Pure Functions", "Impure Functions", "Global State", "System I/O", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Functions in Python return values using which keyword?", "return", "send", "yield", "output", "A");

        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: `def square(x): return x * x` Is `square(x)` pure or impure?", "Pure Function (no side effects, deterministic output)", "Impure Function", "Recursive Loop", "Class Method", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: `total = 0; def addTotal(x): global total; total += x; return total;` What type of function is `addTotal`?", "Impure Function (modifies global variable total)", "Pure Function", "Base Function", "Static Class", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: `def greet(name='User'): print('Hello', name)` What type of parameter is `name='User'`?", "Default Parameter", "Keyword Parameter", "Positional Parameter", "Variable-length Parameter", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: Why are Pure Functions easier to test and debug?", "They have no side-effects and depend only on input parameters", "They run faster on CPU", "They use no memory", "They compile to C", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: In `def power(base, exp=2):`, what is the default exponent if `power(5)` is called?", "2 (Output is 25)", "5", "0", "1", "A", "Python");
    }

    private void seedChapter12_2(School school, String board, int classLevel, String unit) {
        String chName = "2. Data Abstraction";
        buildChapterMissions(school, board, classLevel, unit, 2, chName);

        addMCQ(school, board, classLevel, unit, chName, 1, "A program structure that hides internal details of data types and provides operations is?", "Abstract Data Type (ADT)", "Primitive Type", "Loop Control", "Control Graph", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Functions that build or construct the ADT are called?", "Constructors", "Selectors", "Destructors", "Mutators", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Functions that retrieve or extract information from an ADT are called?", "Selectors", "Constructors", "Modifiers", "Serializers", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "A compound data structure in Python that pairs elements together like `(10, 20)` is a?", "Tuple / Pair", "Integer", "Boolean", "Float", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Data abstraction creates a barrier between?", "Implementation and Representation (Interface & Implementation)", "CPU and RAM", "OS and Driver", "Keyboard and Screen", "A");

        addFillBlank(school, board, classLevel, unit, chName, 2, "ADT stands for Abstract Data ____.", "Type");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Functions that build the abstract data type are ____.", "constructors");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Functions that retrieve parts of ADT are ____.", "selectors");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Grouping two items together forms a ____.", "pair");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Abstraction hides internal ____ details.", "implementation");

        addMCQ(school, board, classLevel, unit, chName, 3, "In ADT representation, `make_point(x, y)` is a?", "Constructor", "Selector", "Operator", "Loop", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "In ADT representation, `get_x(point)` and `get_y(point)` are?", "Selectors", "Constructors", "Compilers", "Parsers", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Lists and Tuples in Python can be used to construct ADT representation of?", "Pairs and Complex Structures", "CPU Instructions", "Operating System Kernels", "Machine Code", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Data Abstraction ensures that changing internal implementation details does NOT break?", "Client Programs using the Interface", "CPU Clock Speed", "Hard Drive Storage", "Power Consumption", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Concrete data representation refers to?", "How data is actually stored in memory structures", "Abstract diagrams", "User manuals", "GUI buttons", "A");

        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: `def make_rat(n, d): return [n, d]` What role does `make_rat` play?", "Constructor for Rational Number ADT", "Selector", "Destructor", "Math library", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: `def numer(r): return r[0]` What role does `numer` play?", "Selector for numerator", "Constructor", "Formatter", "Serializer", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A programmer changes `make_rat(n, d)` from returning a list `[n, d]` to a tuple `(n, d)`. If selectors are updated accordingly, does client code using `numer(r)` break?", "No, because Abstraction Barrier insulates client code from implementation change", "Yes, client code crashes", "Compilation Error", "RAM corruption", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: `point = (3, 4); x = point[0]` Here `point[0]` acts as a raw?", "Concrete Representation Selector", "Abstract Interface", "Class Method", "Global Function", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: Why is Data Abstraction critical in large software teams?", "Enables modular team work by separating interface specifications from internal details", "Reduces compiler warnings", "Eliminates need for testing", "Saves screen pixels", "A", null);
    }

    private void seedChapter12_3(School school, String board, int classLevel, String unit) {
        String chName = "3. Scoping";
        buildChapterMissions(school, board, classLevel, unit, 3, chName);

        addMCQ(school, board, classLevel, unit, chName, 1, "The visibility and accessibility region of a variable in a program is called its?", "Scope", "Abstraction", "Lifetime", "Type", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "LEGB rule in Python variable scope stands for?", "Local, Enclosing, Global, Built-in", "Logical, External, Global, Base", "List, Element, Group, Block", "Linear, Execution, Graph, Binary", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Variables declared inside a function body have which scope?", "Local Scope", "Global Scope", "Enclosing Scope", "Built-in Scope", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Variables declared at top-level of a script outside all functions have which scope?", "Global Scope", "Local Scope", "Block Scope", "Loop Scope", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which keyword is used inside a function to modify a global variable in Python?", "global", "nonlocal", "public", "extern", "A");

        addFillBlank(school, board, classLevel, unit, chName, 2, "LEGB stands for Local, Enclosing, Global, and ____.", "Built-in");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Variables inside a function have ____ scope.", "local");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Variables at script top-level have ____ scope.", "global");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Keyword to modify global variable inside function is ____.", "global");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Keyword to modify enclosing variable in nested function is ____.", "nonlocal");

        addMCQ(school, board, classLevel, unit, chName, 3, "Scope of variables in nested inner functions accessing outer function variables is?", "Enclosing Scope", "Global Scope", "Built-in Scope", "Module Scope", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Keywords like `len()`, `range()`, `print()` belong to which scope in Python?", "Built-in Scope", "Local Scope", "Enclosing Scope", "Global Scope", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which keyword modifies an outer nested function variable in Python?", "nonlocal", "global", "static", "var", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "In LEGB rule, where does Python search for a variable name FIRST?", "Local Scope", "Enclosing Scope", "Global Scope", "Built-in Scope", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "In LEGB rule, where does Python search for a variable name LAST?", "Built-in Scope", "Global Scope", "Enclosing Scope", "Local Scope", "A");

        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is the output?\nx = 10\ndef test():\n  x = 5\ntest()\nprint(x)", "10", "5", "0", "Error", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is the output?\nx = 10\ndef test():\n  global x\n  x = 5\ntest()\nprint(x)", "5", "10", "0", "Error", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is the output?\ndef outer():\n  x = 'old'\n  def inner():\n    nonlocal x\n    x = 'new'\n  inner()\n  print(x)\nouter()", "new", "old", "None", "Error", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A variable name matches both a Local variable and a Global variable. Which one is used inside the local function body?", "Local Variable (Shadows Global)", "Global Variable", "Compilation Error", "Both combined", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What happens if you try to use `print = 5` in Python script?", "Shadows built-in print function (causes error when calling print())", "Works fine without affecting print()", "Syntax Error", "System crash", "A", "Python");
    }

    private void seedChapter12_4(School school, String board, int classLevel, String unit) {
        String chName = "4. Algorithmic Strategies";
        buildChapterMissions(school, board, classLevel, unit, 4, chName);

        addMCQ(school, board, classLevel, unit, chName, 1, "Big-O notation describes an algorithm's?", "Worst-case Time / Space Complexity", "Best-case execution", "Average line count", "Compiler speed", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which searching algorithm requires the input list to be SORTED?", "Binary Search", "Linear Search", "Sequential Search", "Hash Search", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "What is the time complexity of Linear Search in worst case?", "O(n)", "O(log n)", "O(n^2)", "O(1)", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "What is the time complexity of Binary Search in worst case?", "O(log n)", "O(n)", "O(n^2)", "O(1)", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which sorting algorithm repeatedly swaps adjacent out-of-order elements?", "Bubble Sort", "Selection Sort", "Insertion Sort", "Merge Sort", "A");

        addFillBlank(school, board, classLevel, unit, chName, 2, "Binary Search requires input list to be ____.", "sorted");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Time complexity of Linear Search is O(____).", "n");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Time complexity of Binary Search is O(log ____).", "n");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Repeatedly swapping adjacent elements is ____ Sort.", "Bubble");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Dynamic programming stores subproblem results using ____.", "memoization");

        addMCQ(school, board, classLevel, unit, chName, 3, "Which sorting algorithm picks smallest element from unsorted part and places it at beginning?", "Selection Sort", "Bubble Sort", "Quick Sort", "Heap Sort", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which sorting algorithm builds final sorted array one element at a time like card sorting?", "Insertion Sort", "Bubble Sort", "Merge Sort", "Radix Sort", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "What is the time complexity of Bubble Sort in worst case?", "O(n^2)", "O(n)", "O(log n)", "O(1)", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which algorithmic strategy makes greedy optimal choice at each local step?", "Greedy Approach", "Dynamic Programming", "Divide and Conquer", "Backtracking", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which algorithmic strategy breaks problem into overlapping subproblems and stores results (Memoization)?", "Dynamic Programming", "Greedy Approach", "Brute Force", "Random Search", "A");

        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: You search for target 70 in sorted list [10, 20, 30, 50, 70, 90] using Binary Search. What is mid element on first comparison?", "30 or 50 (middle element)", "10", "90", "70", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A list has 1,000,000 sorted records. Maximum comparisons needed for Binary Search?", "20 comparisons (2^20 > 1,000,000)", "1,000,000 comparisons", "500,000 comparisons", "100 comparisons", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: Computing Fibonacci(50) recursively takes hours, but using Dynamic Programming (Memoization) takes milliseconds. Why?", "Saves and reuses subproblem results instead of recalculating", "Uses faster GPU", "Deletes extra variables", "Compiles code", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: After Pass 1 of Bubble Sort on list [5, 1, 4, 2, 8], which element is guaranteed to be in correct final position?", "8 (largest element moves to end)", "1", "5", "2", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is space complexity O(1) commonly referred to as?", "Constant Space Complexity", "Linear Space", "Quadratic Space", "Infinite Space", "A", null);
    }

    private void seedChapter12_5(School school, String board, int classLevel, String unit) {
        String chName = "5. Python - Variables and Operators";
        buildChapterMissions(school, board, classLevel, unit, 5, chName);

        addMCQ(school, board, classLevel, unit, chName, 1, "Which character is used to start single-line comments in Python?", "# (Hash)", "//", "/*", "<!--", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which operator is used for exponentiation (power) in Python?", "**", "^", "pow", "//", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which operator performs floor (integer) division in Python?", "//", "/", "%", "**", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which operator returns the remainder of division in Python?", "% (Modulus)", "/", "//", "**", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "What is the return data type of `type(3.14)` in Python?", "float", "int", "str", "double", "A");

        addFillBlank(school, board, classLevel, unit, chName, 2, "Python single line comments start with ____.", "#");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Exponentiation operator in Python is ____.", "**");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Floor division operator in Python is ____.", "//");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Modulus operator returning remainder is ____.", "%");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Function to take user input as string is ____().", "input");

        addMCQ(school, board, classLevel, unit, chName, 3, "Which of the following is a valid Python variable name?", "_total_marks", "2nd_rank", "class", "user-name", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "What is the result of `10 / 4` in Python 3?", "2.5 (float)", "2 (int)", "2.0", "3", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "What is the result of `10 // 4` in Python?", "2 (floor integer)", "2.5", "2.0", "3", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which function converts a string to integer in Python?", "int()", "str()", "float()", "eval()", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which bitwise operator performs Bitwise AND in Python?", "&", "|", "^", "~", "A");

        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is the output?\nx = 2 ** 3 ** 2\nprint(x)", "512 (Right-to-left evaluation: 3**2=9, 2**9=512)", "64", "36", "12", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is the output?\na, b = 5, 10\na, b = b, a\nprint(a, b)", "10 5 (Swapped values)", "5 10", "10 10", "5 5", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is the result of `13 % 5`?", "3", "2", "2.6", "0", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: User inputs '25' via `val = input()`. What is `val + 5` error cause?", "Cannot concatenate str and int without int() conversion", "Syntax Error", "Invalid variable name", "System Timeout", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is the output of `bool('')` (empty string) in Python?", "False", "True", "None", "Error", "A", "Python");
    }

    private void seedChapter12_6(School school, String board, int classLevel, String unit) {
        String chName = "6. Control Structures";
        buildChapterMissions(school, board, classLevel, unit, 6, chName);

        addMCQ(school, board, classLevel, unit, chName, 1, "Which keyword is used for else-if conditional branching in Python?", "elif", "else if", "elseif", "switch", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "What replaces curly braces `{}` to define code blocks in Python?", "Indentation (Spaces / Tabs)", "Semicolons", "Parentheses", "Keywords", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which built-in function generates a sequence of numbers for loops?", "range()", "sequence()", "loop()", "list()", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "What does `range(1, 5)` generate in Python?", "[1, 2, 3, 4]", "[1, 2, 3, 4, 5]", "[0, 1, 2, 3, 4]", "[2, 3, 4, 5]", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which clause can be optionally attached to Python loops to execute when loop completes without break?", "else clause", "finally clause", "catch clause", "then clause", "A");

        addFillBlank(school, board, classLevel, unit, chName, 2, "Else-if in Python is written as ____.", "elif");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Python uses ____ to define code blocks instead of braces.", "indentation");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Function to generate number range is ____().", "range");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Statement to exit loop immediately is ____.", "break");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Statement acting as a placeholder doing nothing is ____.", "pass");

        addMCQ(school, board, classLevel, unit, chName, 3, "What does `pass` statement do in Python?", "Null operation (placeholder doing nothing)", "Exits loop", "Skips iteration", "Raises exception", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "What is generated by `range(5)`?", "[0, 1, 2, 3, 4]", "[1, 2, 3, 4, 5]", "[0, 1, 2, 3, 4, 5]", "[1, 4]", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "What is generated by `range(10, 2, -2)`?", "[10, 8, 6, 4]", "[10, 8, 6, 4, 2]", "[8, 6, 4, 2]", "[10, 2]", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which statement skips remaining statements in current loop cycle?", "continue", "break", "pass", "return", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "An entry-controlled loop in Python that checks condition first is?", "while loop", "do-while", "until loop", "repeat loop", "A");

        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is the output?\nfor i in range(1, 4):\n  print(i, end='')", "123", "1234", "0123", "1 2 3", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is the output?\nx = 0\nwhile x < 3:\n  x += 1\nelse:\n  print('End')", "1 2 3 then End", "Only End", "Infinite Loop", "Syntax Error", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is the output?\nfor i in range(5):\n  if i == 2: break\n  print(i, end='')", "01", "012", "01234", "2", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is the output?\nfor i in range(5):\n  if i == 2: continue\n  print(i, end='')", "0134", "01234", "01", "2", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A developer defines `if x > 10:` and leaves body for later without syntax error. What statement should be placed inside?", "pass", "break", "continue", "return", "A", "Python");
    }

    private void seedChapter12_7(School school, String board, int classLevel, String unit) {
        String chName = "7. Python functions";
        buildChapterMissions(school, board, classLevel, unit, 7, chName);

        addMCQ(school, board, classLevel, unit, chName, 1, "Anonymous single-line functions in Python are created using which keyword?", "lambda", "def", "anonymous", "inline", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which keyword passes variable number of non-keyword arguments into Python function?", "*args", "**kwargs", "*vars", "args[]", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which keyword passes variable number of keyword (dictionary) arguments into Python function?", "**kwargs", "*args", "dict[]", "**params", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Functions defined within other functions in Python are called?", "Nested / Inner Functions", "Lambda Functions", "Built-in Functions", "Global Functions", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Function parameters with assigned default values are called?", "Default Arguments", "Positional Arguments", "Required Arguments", "Keyword Arguments", "A");

        addFillBlank(school, board, classLevel, unit, chName, 2, "Anonymous functions in Python use the ____ keyword.", "lambda");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Arbitrary positional arguments use *____.", "args");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Arbitrary keyword arguments use **____.", "kwargs");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Function returning value uses the ____ keyword.", "return");
        addFillBlank(school, board, classLevel, unit, chName, 2, "A function calling itself is a ____ function.", "recursive");

        addMCQ(school, board, classLevel, unit, chName, 3, "Syntax for a lambda function adding two numbers is?", "lambda x, y: x + y", "def lambda(x, y): x + y", "lambda(x, y) => x + y", "func(x, y) -> x + y", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Can a Python function return multiple values?", "Yes (returns them as a tuple)", "No (only single value)", "Only if values are integers", "Only via global variables", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "What data type does `*args` receive inside function body?", "Tuple", "List", "Dictionary", "Set", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "What data type does `**kwargs` receive inside function body?", "Dictionary", "Tuple", "List", "String", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which built-in function applies a function to all items in an iterable?", "map()", "filter()", "reduce()", "zip()", "A");

        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is the output?\nsquare = lambda x: x * x\nprint(square(4))", "16", "8", "4", "Error", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is the output?\ndef calc(a, b):\n  return a+b, a-b\nx, y = calc(10, 4)\nprint(x, y)", "14 6", "14", "6", "(14, 6)", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: `def show(*nums): print(type(nums))` What type is printed?", "<class 'tuple'>", "<class 'list'>", "<class 'dict'>", "<class 'int'>", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: `res = list(filter(lambda x: x % 2 == 0, [1, 2, 3, 4]))` What is `res`?", "[2, 4]", "[1, 3]", "[1, 2, 3, 4]", "[True, False]", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: Function `def info(name, age=18):` Called as `info(age=20, name='John')`. What type of argument passing is used?", "Keyword Arguments (out of order)", "Positional Arguments", "Default Only", "Tuple Unpacking", "A", "Python");
    }

    private void seedChapter12_8(School school, String board, int classLevel, String unit) {
        String chName = "8. Strings and String manipulation";
        buildChapterMissions(school, board, classLevel, unit, 8, chName);

        addMCQ(school, board, classLevel, unit, chName, 1, "Are strings in Python mutable or immutable?", "Immutable (cannot be changed in-place)", "Mutable", "Dynamic", "Volatile", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which string slicing syntax extracts characters from index 1 to 4?", "s[1:5]", "s[1:4]", "s[0:4]", "s[1..5]", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which string operator concatenates two strings in Python?", "+ (Plus)", "* (Multiply)", "& (Ampersand)", ". (Dot)", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which string operator repeats a string N times in Python?", "* (Multiply)", "+", "**", "^", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which negative index refers to the last character of a Python string?", "-1", "0", "-0", "last", "A");

        addFillBlank(school, board, classLevel, unit, chName, 2, "Strings in Python are ____ (cannot be modified in-place).", "immutable");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Index of last character in string is -____.", "1");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Operator for string concatenation is ____.", "+");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Operator for string repetition is ____.", "*");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Function to find total length of string is ____().", "len");

        addMCQ(school, board, classLevel, unit, chName, 3, "What does `s[::-1]` do to a string in Python?", "Reverses the string", "Clears the string", "Capitalizes string", "Returns length", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which string method converts all characters to uppercase?", "upper()", "capitalize()", "title()", "toUpper()", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which string method splits a string into a list of words?", "split()", "join()", "strip()", "slice()", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which string method removes leading and trailing whitespaces?", "strip()", "clean()", "trim()", "cut()", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which string method joins elements of a list into a single string?", "join()", "split()", "concat()", "append()", "A");

        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is the output?\ns = 'PYTHON'\nprint(s[1:4])", "YTH", "PYTH", "YTHO", "PYS", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is the output?\ns = 'CS'\nprint(s * 3)", "CSCSCS", "CS3", "CS CS CS", "Error", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is the output?\ns = 'Hello World'\nprint(s.replace('World', 'Python'))", "Hello Python", "Hello World", "Python", "Error", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: `s = 'Python'; s[0] = 'J'` What happens?", "TypeError (Strings are immutable)", "s becomes 'Jython'", "s becomes 'J'", "Silent ignore", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is output of `'py' in 'python'`?", "True", "False", "1", "Error", "A", "Python");
    }

    private void seedChapter12_9(School school, String board, int classLevel, String unit) {
        String chName = "9. Lists, Tuples, Sets and Dictionary";
        buildChapterMissions(school, board, classLevel, unit, 9, chName);

        addMCQ(school, board, classLevel, unit, chName, 1, "Which data structure in Python is ordered, mutable, and defined with square brackets `[]`?", "List", "Tuple", "Set", "Dictionary", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which data structure in Python is ordered, IMMUTABLE, and defined with parentheses `()`?", "Tuple", "List", "Set", "Dictionary", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which data structure in Python is UNORDERED, contains NO DUPLICATES, defined with `{}`?", "Set", "List", "Tuple", "Dictionary", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which data structure stores key-value pairs defined as `{key: value}`?", "Dictionary", "Set", "List", "Tuple", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which method adds a single element to the end of a Python List?", "append()", "extend()", "insert()", "add()", "A");

        addFillBlank(school, board, classLevel, unit, chName, 2, "Lists are enclosed in ____ brackets.", "square");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Tuples are ____ (cannot be changed).", "immutable");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Sets do not allow duplicate ____.", "elements");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Dictionaries store data in key-____ pairs.", "value");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Method to add item to end of list is ____().", "append");

        addMCQ(school, board, classLevel, unit, chName, 3, "Which method removes and returns the last element of a List?", "pop()", "remove()", "del", "clear()", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which dictionary method returns all keys as a list-like view?", "keys()", "values()", "items()", "get()", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which set operation returns elements present in both sets?", "intersection()", "union()", "difference()", "symmetric_difference()", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "How to create a tuple with a single element `5`?", "(5, )", "(5)", "tuple(5)", "[5]", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "What happens if a duplicate element is added to a Set `s = {1, 2, 2, 3}`?", "Duplicates ignored, result is {1, 2, 3}", "Error raised", "Stored twice", "Set becomes list", "A");

        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is the output?\na = [1, 2, 3]\na.extend([4, 5])\nprint(len(a))", "5", "4", "3", "2", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is the output?\nt = (10, 20, 30)\nt[1] = 99", "TypeError (Tuples are immutable)", "t becomes (10, 99, 30)", "t becomes (99)", "Silent ignore", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is the output?\nd = {'name': 'Kumar', 'age': 17}\nprint(d.get('class', 11))", "11 (Default value returned since key absent)", "None", "Error", "17", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is output of `set([1, 2, 2, 3, 3, 3])`?", "{1, 2, 3}", "[1, 2, 3]", "{1, 2, 2, 3, 3, 3}", "(1, 2, 3)", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A list comprehension `[x**2 for x in range(4)]` produces?", "[0, 1, 4, 9]", "[1, 4, 9, 16]", "[0, 2, 4, 6]", "[0, 1, 2, 3]", "A", "Python");
    }

    private void seedChapter12_10(School school, String board, int classLevel, String unit) {
        String chName = "10. Python Classes and objects";
        buildChapterMissions(school, board, classLevel, unit, 10, chName);

        addMCQ(school, board, classLevel, unit, chName, 1, "Which keyword is used to define a class in Python?", "class", "def", "object", "struct", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "What is the special constructor method name in Python classes?", "__init__", "__main__", "constructor", "create", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which parameter must be the FIRST argument of any instance method in Python class?", "self", "this", "cls", "object", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "What does `self` represent inside a Python class method?", "The current instance of the object", "The class blueprint", "Global module", "Parent class", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Variables defined inside `__init__` prefixed with `self.` are?", "Instance Variables", "Class Variables", "Global Variables", "Private Constants", "A");

        addFillBlank(school, board, classLevel, unit, chName, 2, "Constructor method in Python class is ____.", "__init__");
        addFillBlank(school, board, classLevel, unit, chName, 2, "First parameter of instance method is ____.", "self");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Destructor method name in Python is ____.", "__del__");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Variables shared by all instances are ____ variables.", "class");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Private attributes in Python start with double ____.", "__");

        addMCQ(school, board, classLevel, unit, chName, 3, "What special destructor method is called when object is garbage collected in Python?", "__del__", "__init__", "__destruct__", "__stop__", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "How are private attributes declared in Python classes?", "Prefixing attribute name with double underscores `__`", "Using `private` keyword", "Prefixing with `#`", "Capitalizing name", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Variables defined directly in class body outside methods are?", "Class Variables (shared across instances)", "Instance Variables", "Local Variables", "Global Variables", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which built-in function checks if an object is an instance of a class?", "isinstance()", "issubclass()", "type()", "hasattr()", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Inheritance in Python class syntax is specified as?", "class Child(Parent):", "class Child extends Parent:", "class Child implements Parent:", "class Child -> Parent:", "A");

        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is the output?\nclass Student:\n  def __init__(self, name):\n    self.name = name\ns = Student('Kumar')\nprint(s.name)", "Kumar", "Student", "self.name", "Error", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: `class Circle:\n  pi = 3.14` Here `pi` is a?", "Class Variable shared by all Circle objects", "Instance Variable", "Global Variable", "Private Constant", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What happens if `self` is omitted from `def display():` inside a class?", "TypeError when called via object `obj.display()`", "Runs normally", "Prints self", "Creates global function", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: `class A:\n  def __init__(self):\n    self.__num = 10` Accessing `a.__num` outside class gives?", "AttributeError (Private variable name mangled as _A__num)", "10", "None", "0", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: `class B(A):` represents which OOP concept in Python?", "Inheritance (B inherits from A)", "Polymorphism", "Data Hiding", "Abstraction", "A", "Python");
    }

    private void seedChapter12_11(School school, String board, int classLevel, String unit) {
        String chName = "11. Database Concepts";
        buildChapterMissions(school, board, classLevel, unit, 11, chName);

        addMCQ(school, board, classLevel, unit, chName, 1, "What does DBMS stand for?", "Database Management System", "Data Binary Management Service", "Digital Base Memory System", "Direct Business Module System", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "What does RDBMS stand for?", "Relational Database Management System", "Rapid Data Base Module System", "Recorded Binary Data System", "Remote Database Main System", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "A column in a database table is also referred to as an?", "Attribute / Field", "Tuple / Record", "Relation", "Domain", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "A row in a database table is also referred to as a?", "Tuple / Record", "Attribute", "Field", "Schema", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "A field that uniquely identifies each record in a table is a?", "Primary Key", "Foreign Key", "Candidate Key", "Alternate Key", "A");

        addFillBlank(school, board, classLevel, unit, chName, 2, "DBMS stands for Database Management ____.", "System");
        addFillBlank(school, board, classLevel, unit, chName, 2, "A row in a relational table is called a ____.", "tuple");
        addFillBlank(school, board, classLevel, unit, chName, 2, "A column in a relational table is called an ____.", "attribute");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Unique key identifying each row is the ____ Key.", "Primary");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Key referencing Primary Key of another table is ____ Key.", "Foreign");

        addMCQ(school, board, classLevel, unit, chName, 3, "A primary key from one table referenced in another table to establish relationship is a?", "Foreign Key", "Candidate Key", "Super Key", "Composite Key", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "ACID properties in database transactions stand for?", "Atomicity, Consistency, Isolation, Durability", "Accuracy, Control, Indexing, Data", "Access, Code, Integration, Design", "Array, Column, Index, Directory", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which relational algebra operation selects rows satisfying a given condition?", "Selection (σ)", "Projection (π)", "Union (∪)", "Cartesian Product (×)", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which relational algebra operation selects specified columns from a table?", "Projection (π)", "Selection (σ)", "Intersection (∩)", "Join (⋈)", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Duplicate data redundancy across multiple files is minimized by using?", "Centralized RDBMS Database", "Spreadsheet CSV", "Flat Text Files", "Paper Registers", "A");

        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A school table `Students` has columns (AdmissionNo, Name, DOB). Which column is best chosen as Primary Key?", "AdmissionNo (unique for every student)", "Name", "DOB", "None", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: Table `Marks` includes `AdmissionNo` from `Students` table to link student details. What is `AdmissionNo` in `Marks` table?", "Foreign Key", "Primary Key", "Super Key", "Candidate Key", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: Bank transfer from Account A to Account B must fully complete both debit & credit or cancel completely. Which ACID property guarantees this?", "Atomicity", "Consistency", "Isolation", "Durability", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: You query a database table containing 10 columns to display ONLY Student Name and Grade. Which Relational Algebra operation is performed?", "Projection (π)", "Selection (σ)", "Cartesian Product", "Set Difference", "A", null);
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is the degree of a table with 5 columns and 100 rows?", "Degree = 5 (Number of attributes/columns)", "Degree = 100", "Degree = 500", "Degree = 1", "A", null);
    }

    private void seedChapter12_12(School school, String board, int classLevel, String unit) {
        String chName = "12. Structured Query Language (SQL)";
        buildChapterMissions(school, board, classLevel, unit, 12, chName);

        addMCQ(school, board, classLevel, unit, chName, 1, "Which SQL command is used to retrieve data from a database table?", "SELECT", "INSERT", "UPDATE", "DELETE", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which SQL category includes CREATE, ALTER, and DROP commands?", "DDL (Data Definition Language)", "DML (Data Manipulation Language)", "DCL (Data Control Language)", "TCL (Transaction Control Language)", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which SQL category includes INSERT, UPDATE, and DELETE commands?", "DML (Data Manipulation Language)", "DDL", "DCL", "TCL", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which clause is used in a SELECT statement to filter records based on a condition?", "WHERE", "ORDER BY", "GROUP BY", "HAVING", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which SQL clause is used to sort the result set in ascending or descending order?", "ORDER BY", "GROUP BY", "SORT BY", "ALIGN BY", "A");

        addFillBlank(school, board, classLevel, unit, chName, 2, "Command to fetch data from table is ____.", "SELECT");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Command to insert new row into table is ____.", "INSERT");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Command to modify existing records is ____.", "UPDATE");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Clause used to filter rows is ____.", "WHERE");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Clause used to sort result set is ORDER ____.", "BY");

        addMCQ(school, board, classLevel, unit, chName, 3, "Which SQL aggregate function calculates the total sum of values in a column?", "SUM()", "COUNT()", "AVG()", "TOTAL()", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which SQL aggregate function counts the total number of rows?", "COUNT()", "SUM()", "MAX()", "NUMBER()", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which SQL clause groups rows that have the same values in specified columns?", "GROUP BY", "ORDER BY", "HAVING", "COLLECT BY", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which clause filters groups created by GROUP BY?", "HAVING", "WHERE", "ORDER BY", "LIKE", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which wildcard character in SQL LIKE operator matches any sequence of zero or more characters?", "% (Percent)", "_ (Underscore)", "* (Asterisk)", "? (Question)", "A");

        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: `SELECT * FROM Students WHERE mark >= 90;` What does this SQL query return?", "All student records with marks 90 or above", "All students sorted by mark", "Only student names", "Deletes top marks", "A", "SQL");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: `UPDATE Students SET grade = 'A' WHERE mark >= 90;` What SQL category is UPDATE?", "DML (Data Manipulation Language)", "DDL", "DCL", "TCL", "A", "SQL");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: `SELECT city, COUNT(*) FROM Students GROUP BY city HAVING COUNT(*) > 5;` Why is HAVING used instead of WHERE?", "HAVING filters aggregated groups created by GROUP BY", "HAVING is faster than WHERE", "WHERE is invalid in SELECT", "HAVING sorts data", "A", "SQL");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: `SELECT * FROM Users WHERE name LIKE 'A%';` Which names match?", "Names starting with 'A' (e.g. Anand, Anita)", "Names ending with 'A'", "Names containing 'A' anywhere", "Names with exactly 1 letter 'A'", "A", "SQL");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: `DELETE FROM Students;` vs `DROP TABLE Students;` What is the difference?", "DELETE removes all rows keeping table structure; DROP deletes entire table structure", "Both do the exact same thing", "DROP removes rows; DELETE deletes table", "Neither works in SQL", "A", "SQL");
    }

    private void seedChapter12_13(School school, String board, int classLevel, String unit) {
        String chName = "13. Python and CSV files";
        buildChapterMissions(school, board, classLevel, unit, 13, chName);

        addMCQ(school, board, classLevel, unit, chName, 1, "What does CSV stand for?", "Comma Separated Values", "Character Storage Variable", "Computer System Verification", "Central Serial View", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which built-in Python module is used to read and write CSV files?", "csv", "sys", "os", "file", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which mode is used in `open()` function to open a CSV file for reading?", "'r'", "'w'", "'a'", "'x'", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which csv module class reads CSV rows as Python dictionaries using headers?", "csv.DictReader", "csv.reader", "csv.writer", "csv.DictWriter", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which parameter in `open()` prevents blank newline lines between rows when writing CSV in Python?", "newline=''", "encoding='utf-8'", "mode='w'", "buffering=0", "A");

        addFillBlank(school, board, classLevel, unit, chName, 2, "CSV stands for Comma Separated ____.", "Values");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Python module to process CSV files is ____.", "csv");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Function to read CSV file rows is csv.____().", "reader");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Function to write CSV file rows is csv.____().", "writer");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Method to write a single row in CSV writer is ____row().", "write");

        addMCQ(school, board, classLevel, unit, chName, 3, "Which method writes a single row of fields into a CSV file using writer object?", "writerow()", "writerows()", "write()", "dump()", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which method writes multiple rows (list of lists) into a CSV file?", "writerows()", "writerow()", "appendrows()", "dumpall()", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Default delimiter character in standard CSV files is?", "Comma (,)", "Tab (\\t)", "Semicolon (;)", "Pipe (|)", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which csv class writes dictionary data to CSV with header mapping?", "csv.DictWriter", "csv.writer", "csv.DictReader", "csv.dump", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which keyword statement ensures a CSV file is automatically closed after reading?", "with open(...) as f:", "try open(...) as f:", "close open(...) as f:", "file open(...) as f:", "A");

        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is printed?\nimport csv\nwith open('data.csv', 'r') as f:\n  r = csv.reader(f)\n  for row in r:\n    print(type(row))", "<class 'list'> (Each row is read as a list of string fields)", "<class 'dict'>", "<class 'str'>", "<class 'tuple'>", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: When creating `csv.DictWriter(f, fieldnames=['ID', 'Name'])`, which method writes the header row to file?", "writeheader()", "writerow()", "headers()", "create_header()", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A CSV file uses pipe `|` instead of comma as separator. What argument should be passed to `csv.reader`?", "delimiter='|'", "sep='|'", "split='|'", "comma='|'", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: Why is CSV format widely used for data exchange between applications?", "Plain text, human-readable, lightweight, and supported by all databases/spreadsheets", "Requires high encryption", "Uses binary machine code", "Only works on Windows", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: Opening CSV in write mode `open('data.csv', 'w')` will do what if file already exists?", "Overwrites existing file content completely", "Appends to existing file", "Raises FileExistsError", "Creates copy", "A", "Python");
    }

    private void seedChapter12_14(School school, String board, int classLevel, String unit) {
        String chName = "14. Importing C++ programs in Python";
        buildChapterMissions(school, board, classLevel, unit, 14, chName);

        addMCQ(school, board, classLevel, unit, chName, 1, "Which interface tool allows executing compiled C/C++ code inside Python programs?", "g++ Compiler with subprocess / SWIG / ctypes", "HTML Parser", "SQL Engine", "Pyplot", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which built-in Python module executes OS terminal shell commands like `g++` from Python script?", "subprocess / os", "sys", "math", "csv", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "What is the primary advantage of importing C++ code into Python?", "High Performance and Execution Speed for heavy computations", "Better GUI", "Smaller File Size", "Automatic Web Deployment", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which C++ compiler command compiles `test.cpp` into an executable `test.exe`?", "g++ test.cpp -o test.exe", "python test.cpp", "javac test.cpp", "sql test.cpp", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which command-line argument array holds input arguments passed to C++ main function `int main(int argc, char* argv[])`?", "argv[]", "argc", "args", "params", "A");

        addFillBlank(school, board, classLevel, unit, chName, 2, "Python module to run external system commands is ____.", "subprocess");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Compiler command to compile C++ code is ____++.", "g");
        addFillBlank(school, board, classLevel, unit, chName, 2, "C++ command line argument count parameter is ____.", "argc");
        addFillBlank(school, board, classLevel, unit, chName, 2, "C++ command line argument values array is ____.", "argv");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Importing C++ into Python combines Python simplicity with C++ ____.", "speed");

        addMCQ(school, board, classLevel, unit, chName, 3, "In `int main(int argc, char* argv[])`, what does `argc` represent?", "Count of command-line arguments passed", "Array of strings", "Memory address", "Return exit code", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "What is stored in `argv[0]` when executing a C++ binary program?", "Name / path of the executable program itself", "First user argument", "Second user argument", "Null pointer", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which function in C++ `<cstdlib>` converts command line string argument to integer?", "atoi()", "itoa()", "strtoint()", "cin", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which function in Python `subprocess` module executes command and waits for completion?", "subprocess.run() / Popen()", "subprocess.exit()", "subprocess.compile()", "subprocess.read()", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which wrapper generator tool automates connecting C++ libraries to Python C-API?", "SWIG (Simplified Wrapper and Interface Generator)", "GDB", "Make", "Pip", "A");

        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A data scientist prototypes an algorithm in Python but needs 100x faster matrix multiplication. How can C++ integration help?", "Implement heavy multiplication in C++ and call it from Python", "Rewrite Python in HTML", "Increase RAM voltage", "Use print statements", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: Python code executes `subprocess.run(['g++', 'cppfile.cpp', '-o', 'cppfile'])`. What does this line do?", "Compiles cppfile.cpp into executable named cppfile", "Deletes cppfile.cpp", "Executes Python code", "Clears terminal", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: If C++ program is invoked as `./myprogram 10 20`, what is `argv[1]`?", "\"10\" (as string)", "\"myprogram\"", "\"20\"", "30", "A", "C++");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: `int num = atoi(argv[1]);` What does `atoi` perform?", "Converts C-string argument to integer value", "Converts integer to string", "Prints argument", "Deletes argument", "A", "C++");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: Output from executed C++ subprocess is captured in Python using parameter `capture_output=True`. Where is output text stored?", "result.stdout", "result.stdin", "result.code", "result.env", "A", "Python");
    }

    private void seedChapter12_15(School school, String board, int classLevel, String unit) {
        String chName = "15. Data manipulation through SQL";
        buildChapterMissions(school, board, classLevel, unit, 15, chName);

        addMCQ(school, board, classLevel, unit, chName, 1, "Which Python module is built-in for connecting to SQLite relational databases?", "sqlite3", "mysql.connector", "psycopg2", "db", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which method establishes a connection to a database in `sqlite3`?", "sqlite3.connect()", "sqlite3.open()", "sqlite3.start()", "sqlite3.create()", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which database object is used to execute SQL statements and fetch query results?", "Cursor (cursor object)", "Connection object", "Statement object", "Table object", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which method saves changes permanently to the database file after INSERT/UPDATE?", "commit()", "save()", "push()", "flush()", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which method retrieves ALL rows from a query result set?", "fetchall()", "fetchone()", "fetchmany()", "getall()", "A");

        addFillBlank(school, board, classLevel, unit, chName, 2, "Built-in SQLite module in Python is ____3.", "sqlite");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Method to open database connection is ____().", "connect");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Object to execute SQL queries is a ____.", "cursor");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Method to save changes permanently is ____().", "commit");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Method to fetch single next row is ____().", "fetchone");

        addMCQ(school, board, classLevel, unit, chName, 3, "Which method retrieves next single row from a query result set?", "fetchone()", "fetchall()", "fetchmany()", "read()", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which method retrieves specified N number of rows from query result set?", "fetchmany(N)", "fetchone(N)", "fetchall(N)", "getmany(N)", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which cursor method executes an SQL query in Python?", "cursor.execute()", "cursor.run()", "cursor.query()", "cursor.call()", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which method closes an active database connection in Python?", "connection.close()", "connection.exit()", "connection.end()", "connection.stop()", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Parameterized SQL queries using `?` placeholder prevent which security vulnerability?", "SQL Injection Attack", "Cross Site Scripting", "Buffer Overflow", "Denial of Service", "A");

        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is the output?\nimport sqlite3\nconn = sqlite3.connect('test.db')\ncursor = conn.cursor()\ncursor.execute('SELECT COUNT(*) FROM Users')\nprint(type(cursor.fetchone()))", "<class 'tuple'> (Fetches row as tuple)", "<class 'list'>", "<class 'int'>", "<class 'dict'>", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A developer inserts 10 new student records into SQLite DB but forgets `conn.commit()`. What happens when program exits?", "Inserted records are NOT saved permanently (rolled back)", "Records saved automatically", "Database deleted", "Syntax Error", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: `cursor.execute('SELECT * FROM Students WHERE mark > ?', (80,))` Why is `(80,)` passed as tuple?", "Safe parameterized query to prevent SQL Injection", "Required by RAM", "SQL syntax rule", "Converts int to string", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is printed if `cursor.fetchall()` is called on an empty table?", "Empty List `[]`", "None", "Error", "0", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: `cursor.execute('CREATE TABLE IF NOT EXISTS Users (id INT, name TEXT)')` What does `IF NOT EXISTS` do?", "Prevents error if table is already created", "Deletes existing table", "Renames table", "Clears rows", "A", "SQL");
    }

    private void seedChapter12_16(School school, String board, int classLevel, String unit) {
        String chName = "16. Data visualization using pyplot: line chart, pie chart and bar chart";
        buildChapterMissions(school, board, classLevel, unit, 16, chName);

        addMCQ(school, board, classLevel, unit, chName, 1, "Which Python library module is widely used for creating 2D plots and charts?", "matplotlib.pyplot", "pandas", "numpy", "csv", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which pyplot function plots a Line Chart?", "plt.plot()", "plt.bar()", "plt.pie()", "plt.scatter()", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which pyplot function plots a Bar Chart?", "plt.bar()", "plt.plot()", "plt.pie()", "plt.hist()", "A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which pyplot function plots a Circular Pie Chart?", "plt.pie()", "plt.circle()", "plt.plot()", "plt.bar()", "plt.A");
        addMCQ(school, board, classLevel, unit, chName, 1, "Which pyplot function displays the rendered chart window on screen?", "plt.show()", "plt.display()", "plt.render()", "plt.view()", "A");

        addFillBlank(school, board, classLevel, unit, chName, 2, "Data visualization library module is matplotlib.____.", "pyplot");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Function to draw Line chart is plt.____().", "plot");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Function to draw Bar chart is plt.____().", "bar");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Function to draw Pie chart is plt.____().", "pie");
        addFillBlank(school, board, classLevel, unit, chName, 2, "Function to display plot on screen is plt.____().", "show");

        addMCQ(school, board, classLevel, unit, chName, 3, "Which pyplot function sets the title of the chart?", "plt.title()", "plt.label()", "plt.heading()", "plt.name()", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which pyplot function sets label for X-axis?", "plt.xlabel()", "plt.ylabel()", "plt.xtitle()", "plt.axis()", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which pyplot function sets label for Y-axis?", "plt.ylabel()", "plt.xlabel()", "plt.ytitle()", "plt.axis()", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which parameter in `plt.pie()` shows percentage values inside pie slices?", "autopct='%1.1f%%'", "pct=True", "percentage=1", "showpct=True", "A");
        addMCQ(school, board, classLevel, unit, chName, 3, "Which function saves created chart figure to an image file (e.g. PNG/JPEG)?", "plt.savefig()", "plt.save()", "plt.export()", "plt.write()", "A");

        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: What is the output?\nimport matplotlib.pyplot as plt\nplt.plot([1, 2, 3], [4, 5, 6])\nplt.savefig('line.png')", "Saves line chart as image file 'line.png'", "Displays pop-up window", "Prints numbers in console", "Error", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A teacher wants to visualize the percentage share of student grades (A, B, C, D) in a class. Which chart type fits best?", "Pie Chart (plt.pie())", "Line Chart", "Scatter Plot", "Histogram", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A analyst wants to compare average marks across 5 different subjects. Which chart type fits best?", "Bar Chart (plt.bar())", "Pie Chart", "Line Chart", "Box Plot", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: A meteorologist tracks temperature changes over 24 hours of a day. Which chart type fits best?", "Line Chart (plt.plot())", "Pie Chart", "Bar Chart", "Scatter Plot", "A", "Python");
        addScenario(school, board, classLevel, unit, chName, 4, "Scenario: `plt.legend()` function performs which task in pyplot?", "Displays legend box mapping colors to dataset labels", "Adds title", "Enables grid lines", "Rotates axis", "A", "Python");
    }
}
