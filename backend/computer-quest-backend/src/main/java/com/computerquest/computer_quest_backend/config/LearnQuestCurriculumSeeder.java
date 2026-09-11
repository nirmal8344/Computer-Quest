package com.computerquest.computer_quest_backend.config;

import com.computerquest.computer_quest_backend.entity.Chapter;
import com.computerquest.computer_quest_backend.entity.Mission;
import com.computerquest.computer_quest_backend.entity.Question;
import com.computerquest.computer_quest_backend.entity.Subject;
import com.computerquest.computer_quest_backend.entity.Unit;
import com.computerquest.computer_quest_backend.repository.ChapterRepository;
import com.computerquest.computer_quest_backend.repository.MissionRepository;
import com.computerquest.computer_quest_backend.repository.QuestionRepository;
import com.computerquest.computer_quest_backend.repository.SubjectRepository;
import com.computerquest.computer_quest_backend.repository.UnitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(1)
public class LearnQuestCurriculumSeeder implements CommandLineRunner {

    private final SubjectRepository subjectRepository;
    private final UnitRepository unitRepository;
    private final ChapterRepository chapterRepository;
    private final MissionRepository missionRepository;
    private final QuestionRepository questionRepository;

    public LearnQuestCurriculumSeeder(
            SubjectRepository subjectRepository,
            UnitRepository unitRepository,
            ChapterRepository chapterRepository,
            MissionRepository missionRepository,
            QuestionRepository questionRepository) {
        this.subjectRepository = subjectRepository;
        this.unitRepository = unitRepository;
        this.chapterRepository = chapterRepository;
        this.missionRepository = missionRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public void run(String... args) {
        seedAllCurricula();
    }

    public void seedAllCurricula() {
        if (!subjectRepository.findBySchoolIsNull().isEmpty()) {
            System.out.println("Default curricula already seeded (" + subjectRepository.findBySchoolIsNull().size() + " base subjects found). Skipping re-seed.");
            return;
        }
        clearExistingDefaultCurricula();
        seed_CBSE_Class_4();
        seed_CBSE_Class_5();
        seed_CBSE_Class_6();
        seed_CBSE_Class_7();
        seed_CBSE_Class_8();
        seed_CBSE_Class_9();
        seed_CBSE_Class_10();
        seed_CBSE_Class_11();
        seed_CBSE_Class_12();
        seed_STATE_BOARD_Class_4();
        seed_STATE_BOARD_Class_5();
        seed_STATE_BOARD_Class_6();
        seed_STATE_BOARD_Class_7();
        seed_STATE_BOARD_Class_8();
        seed_STATE_BOARD_Class_9();
        seed_STATE_BOARD_Class_10();
        seed_STATE_BOARD_Class_11();
        seed_STATE_BOARD_Class_12();
    }

    private void clearExistingDefaultCurricula() {
        try {
            questionRepository.deleteAll(questionRepository.findBySchoolIsNull());
            missionRepository.deleteAll(missionRepository.findBySchoolIsNull());
            chapterRepository.deleteAll(chapterRepository.findBySchoolIsNull());
            unitRepository.deleteAll(unitRepository.findBySchoolIsNull());
            subjectRepository.deleteAll(subjectRepository.findBySchoolIsNull());
        } catch (Exception e) {
            System.err.println("Note on clearing default curricula: " + e.getMessage());
        }
    }

    private void seed_CBSE_Class_4() {
        String board = "CBSE";
        int classLevel = 4;

        // Subject: English
        Subject sub_ENG_4_1 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "English")
                .orElseGet(() -> subjectRepository.save(new Subject("English", "ENG", "📖", "#fa8231", board, classLevel)));

        // Unit: Unit 1: Stories of Fun & Adventure
        Unit u_ENG_4_1_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Stories of Fun & Adventure", 1, "English", board, classLevel)));

        // Chapter: Wake Up! & Neha's Alarm Clock (Class 4)
        Chapter ch_ENG_4_1_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 1: Stories of Fun & Adventure", 1, "Wake Up! & Neha's Alarm Clock (Class 4)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 1: Stories of Fun & Adventure", "Wake Up! & Neha's Alarm Clock (Class 4)", ch_ENG_4_1_1_1, "Morning Routine, Phonics & Sentences");

        // Chapter: The Little Fir Tree & Noses (Class 4)
        Chapter ch_ENG_4_1_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 1: Stories of Fun & Adventure", 2, "The Little Fir Tree & Noses (Class 4)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 1: Stories of Fun & Adventure", "The Little Fir Tree & Noses (Class 4)", ch_ENG_4_1_1_2, "Adjectives, Rhymes & Vocabulary");

        // Unit: Unit 2: Friendship & Nature
        Unit u_ENG_4_1_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Friendship & Nature", 2, "English", board, classLevel)));

        // Chapter: Run! & Nasiruddin's Aim (Class 4)
        Chapter ch_ENG_4_1_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 2: Friendship & Nature", 3, "Run! & Nasiruddin's Aim (Class 4)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 2: Friendship & Nature", "Run! & Nasiruddin's Aim (Class 4)", ch_ENG_4_1_2_3, "Sportsmanship, Action Words & Verbs");

        // Chapter: Why? & Alice in Wonderland (Class 4)
        Chapter ch_ENG_4_1_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 2: Friendship & Nature", 4, "Why? & Alice in Wonderland (Class 4)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 2: Friendship & Nature", "Why? & Alice in Wonderland (Class 4)", ch_ENG_4_1_2_4, "Curiosity, Prepositions & Storytelling");

        // Unit: Unit 3: Bravery & Helpful Hands
        Unit u_ENG_4_1_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Bravery & Helpful Hands", 3, "English", board, classLevel)));

        // Chapter: Don't be Afraid of the Dark & Helen Keller (Class 4)
        Chapter ch_ENG_4_1_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 3: Bravery & Helpful Hands", 5, "Don't be Afraid of the Dark & Helen Keller (Class 4)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 3: Bravery & Helpful Hands", "Don't be Afraid of the Dark & Helen Keller (Class 4)", ch_ENG_4_1_3_5, "Overcoming Fear, Braille & Determination");

        // Chapter: Hiawatha & The Scholar's Mother Tongue (Class 4)
        Chapter ch_ENG_4_1_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 3: Bravery & Helpful Hands", 6, "Hiawatha & The Scholar's Mother Tongue (Class 4)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 3: Bravery & Helpful Hands", "Hiawatha & The Scholar's Mother Tongue (Class 4)", ch_ENG_4_1_3_6, "Birbal Wit, Dialects & Nouns");

        // Unit: Unit 4: Magic & Imagination
        Unit u_ENG_4_1_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Magic & Imagination", 4, "English", board, classLevel)));

        // Chapter: A Watering Rhyme & The Giving Tree (Class 4)
        Chapter ch_ENG_4_1_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 4: Magic & Imagination", 7, "A Watering Rhyme & The Giving Tree (Class 4)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 4: Magic & Imagination", "A Watering Rhyme & The Giving Tree (Class 4)", ch_ENG_4_1_4_7, "Plant Care, Selfless Giving & Composition");

        // Chapter: Books & Going to Buy a Book (Class 4)
        Chapter ch_ENG_4_1_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 4: Magic & Imagination", 8, "Books & Going to Buy a Book (Class 4)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 4: Magic & Imagination", "Books & Going to Buy a Book (Class 4)", ch_ENG_4_1_4_8, "Reading Habits & Bookstores");

        // Unit: Unit 5: Travelling & Discovery
        Unit u_ENG_4_1_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 5: Travelling & Discovery", 5, "English", board, classLevel)));

        // Chapter: The Naughty Boy & Pinocchio (Class 4)
        Chapter ch_ENG_4_1_5_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 5: Travelling & Discovery", 9, "The Naughty Boy & Pinocchio (Class 4)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 5: Travelling & Discovery", "The Naughty Boy & Pinocchio (Class 4)", ch_ENG_4_1_5_9, "Honesty, Creative Writing & Opposites");

        // Subject: Mathematics
        Subject sub_MATH_4_2 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Mathematics")
                .orElseGet(() -> subjectRepository.save(new Subject("Mathematics", "MATH", "📐", "#4834d4", board, classLevel)));

        // Unit: Unit 1: Shapes, Geometry & Patterns
        Unit u_MATH_4_2_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Shapes, Geometry & Patterns", 1, "Mathematics", board, classLevel)));

        // Chapter: Building with Bricks & Shapes and Angles (Class 4)
        Chapter ch_MATH_4_2_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 1: Shapes, Geometry & Patterns", 1, "Building with Bricks & Shapes and Angles (Class 4)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 1: Shapes, Geometry & Patterns", "Building with Bricks & Shapes and Angles (Class 4)", ch_MATH_4_2_1_1, "Floor Patterns, Angles, Clock Hands");

        // Chapter: How many Squares? & Parts and Wholes (Class 4)
        Chapter ch_MATH_4_2_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 1: Shapes, Geometry & Patterns", 2, "How many Squares? & Parts and Wholes (Class 4)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 1: Shapes, Geometry & Patterns", "How many Squares? & Parts and Wholes (Class 4)", ch_MATH_4_2_1_2, "Area, Perimeter, Fractions & Shading");

        // Unit: Unit 2: Symmetry, Multiples & Operations
        Unit u_MATH_4_2_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Symmetry, Multiples & Operations", 2, "Mathematics", board, classLevel)));

        // Chapter: Does it look the same? & Be My Multiple, I'll be Your Factor (Class 4)
        Chapter ch_MATH_4_2_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 2: Symmetry, Multiples & Operations", 3, "Does it look the same? & Be My Multiple, I'll be Your Factor (Class 4)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 2: Symmetry, Multiples & Operations", "Does it look the same? & Be My Multiple, I'll be Your Factor (Class 4)", ch_MATH_4_2_2_3, "Rotational Symmetry, HCF, LCM & Multiples");

        // Chapter: Can You See the Pattern? & Boxes and Sketches (Class 4)
        Chapter ch_MATH_4_2_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 2: Symmetry, Multiples & Operations", 4, "Can You See the Pattern? & Boxes and Sketches (Class 4)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 2: Symmetry, Multiples & Operations", "Can You See the Pattern? & Boxes and Sketches (Class 4)", ch_MATH_4_2_2_4, "Number Sequences & 3D Cube Nets");

        // Unit: Unit 3: Decimal Numbers, Area & Mapping
        Unit u_MATH_4_2_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Decimal Numbers, Area & Mapping", 3, "Mathematics", board, classLevel)));

        // Chapter: Tenths and Hundredths & Mapping Your Way (Class 4)
        Chapter ch_MATH_4_2_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 3: Decimal Numbers, Area & Mapping", 5, "Tenths and Hundredths & Mapping Your Way (Class 4)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 3: Decimal Numbers, Area & Mapping", "Tenths and Hundredths & Mapping Your Way (Class 4)", ch_MATH_4_2_3_5, "Decimals, Money, Scale Maps & Directions");

        // Chapter: Area and its Boundary & Smart Charts (Class 4)
        Chapter ch_MATH_4_2_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 3: Decimal Numbers, Area & Mapping", 6, "Area and its Boundary & Smart Charts (Class 4)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 3: Decimal Numbers, Area & Mapping", "Area and its Boundary & Smart Charts (Class 4)", ch_MATH_4_2_3_6, "Square Grids, Bar Charts & Tallies");

        // Unit: Unit 4: Multiplication, Division & Volume
        Unit u_MATH_4_2_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Multiplication, Division & Volume", 4, "Mathematics", board, classLevel)));

        // Chapter: Ways to Multiply and Divide & How Big? How Heavy? (Class 4)
        Chapter ch_MATH_4_2_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 4: Multiplication, Division & Volume", 7, "Ways to Multiply and Divide & How Big? How Heavy? (Class 4)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 4: Multiplication, Division & Volume", "Ways to Multiply and Divide & How Big? How Heavy? (Class 4)", ch_MATH_4_2_4_7, "Long Division, Word Problems, Weight & Volume of Cubes");

        // Subject: EVS
        Subject sub_EVS_4_3 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "EVS")
                .orElseGet(() -> subjectRepository.save(new Subject("EVS", "EVS", "🌱", "#20bf6b", board, classLevel)));

        // Unit: Unit 1: Animals, Senses & Super Powers
        Unit u_EVS_4_3_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "EVS")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Animals, Senses & Super Powers", 1, "EVS", board, classLevel)));

        // Chapter: Super Senses & A Snake Charmer's Story (Class 4)
        Chapter ch_EVS_4_3_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "EVS", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("EVS", "Unit 1: Animals, Senses & Super Powers", 1, "Super Senses & A Snake Charmer's Story (Class 4)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "EVS", "Unit 1: Animals, Senses & Super Powers", "Super Senses & A Snake Charmer's Story (Class 4)", ch_EVS_4_3_1_1, "Sense of Smell, Sight, Sound & Wildlife Protection");

        // Chapter: From Tasting to Digesting & Mangoes Round the Year (Class 4)
        Chapter ch_EVS_4_3_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "EVS", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("EVS", "Unit 1: Animals, Senses & Super Powers", 2, "From Tasting to Digesting & Mangoes Round the Year (Class 4)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "EVS", "Unit 1: Animals, Senses & Super Powers", "From Tasting to Digesting & Mangoes Round the Year (Class 4)", ch_EVS_4_3_1_2, "Digestive System, Food Preservation & Mamidi Tandra");

        // Unit: Unit 2: Seeds, Plants & Water Resources
        Unit u_EVS_4_3_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "EVS")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Seeds, Plants & Water Resources", 2, "EVS", board, classLevel)));

        // Chapter: Seeds and Seeds & Every Drop Counts (Class 4)
        Chapter ch_EVS_4_3_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "EVS", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("EVS", "Unit 2: Seeds, Plants & Water Resources", 3, "Seeds and Seeds & Every Drop Counts (Class 4)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "EVS", "Unit 2: Seeds, Plants & Water Resources", "Seeds and Seeds & Every Drop Counts (Class 4)", ch_EVS_4_3_2_3, "Seed Dispersal, Ghadsisar Lake & Stepwells");

        // Chapter: Experiments with Water & A Treat for Mosquitoes (Class 4)
        Chapter ch_EVS_4_3_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "EVS", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("EVS", "Unit 2: Seeds, Plants & Water Resources", 4, "Experiments with Water & A Treat for Mosquitoes (Class 4)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "EVS", "Unit 2: Seeds, Plants & Water Resources", "Experiments with Water & A Treat for Mosquitoes (Class 4)", ch_EVS_4_3_2_4, "Floating/Sinking, Malaria, Dengue & Blood Tests");

        // Unit: Unit 3: Journeys, Shelters & Space Exploration
        Unit u_EVS_4_3_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "EVS")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Journeys, Shelters & Space Exploration", 3, "EVS", board, classLevel)));

        // Chapter: Up You Go! & Walls Tell Stories (Class 4)
        Chapter ch_EVS_4_3_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "EVS", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("EVS", "Unit 3: Journeys, Shelters & Space Exploration", 5, "Up You Go! & Walls Tell Stories (Class 4)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "EVS", "Unit 3: Journeys, Shelters & Space Exploration", "Up You Go! & Walls Tell Stories (Class 4)", ch_EVS_4_3_3_5, "Mountaineering, Golconda Fort & Historical Architecture");

        // Chapter: Sunita in Space & What if it Finishes...? (Class 4)
        Chapter ch_EVS_4_3_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "EVS", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("EVS", "Unit 3: Journeys, Shelters & Space Exploration", 6, "Sunita in Space & What if it Finishes...? (Class 4)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "EVS", "Unit 3: Journeys, Shelters & Space Exploration", "Sunita in Space & What if it Finishes...? (Class 4)", ch_EVS_4_3_3_6, "Zero Gravity, Astronaut Life, Petroleum & Fuel Conservation");

        // Unit: Unit 4: Society, Forests & Farmer Livelihoods
        Unit u_EVS_4_3_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "EVS")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Society, Forests & Farmer Livelihoods", 4, "EVS", board, classLevel)));

        // Chapter: A Shelter so High! & When the Earth Shook! (Class 4)
        Chapter ch_EVS_4_3_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "EVS", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("EVS", "Unit 4: Society, Forests & Farmer Livelihoods", 7, "A Shelter so High! & When the Earth Shook! (Class 4)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "EVS", "Unit 4: Society, Forests & Farmer Livelihoods", "A Shelter so High! & When the Earth Shook! (Class 4)", ch_EVS_4_3_4_7, "Ladakh Cold Desert, Changpa Tribe & Earthquakes");

        // Chapter: Blow Hot, Blow Cold & Who will do this Work? (Class 4)
        Chapter ch_EVS_4_3_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "EVS", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("EVS", "Unit 4: Society, Forests & Farmer Livelihoods", 8, "Blow Hot, Blow Cold & Who will do this Work? (Class 4)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "EVS", "Unit 4: Society, Forests & Farmer Livelihoods", "Blow Hot, Blow Cold & Who will do this Work? (Class 4)", ch_EVS_4_3_4_8, "Respiration, Dignity of Labour & Gandhiji's Ashram");

        // Chapter: Across the Wall & Whose Forests? (Class 4)
        Chapter ch_EVS_4_3_4_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "EVS", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("EVS", "Unit 4: Society, Forests & Farmer Livelihoods", 9, "Across the Wall & Whose Forests? (Class 4)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "EVS", "Unit 4: Society, Forests & Farmer Livelihoods", "Across the Wall & Whose Forests? (Class 4)", ch_EVS_4_3_4_9, "Gender Equality in Sports, Kuduk Tribe & Forest Rights Act");

    }

    private void seed_CBSE_Class_5() {
        String board = "CBSE";
        int classLevel = 5;

        // Subject: English
        Subject sub_ENG_5_1 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "English")
                .orElseGet(() -> subjectRepository.save(new Subject("English", "ENG", "📖", "#fa8231", board, classLevel)));

        // Unit: Unit 1: Stories of Fun & Adventure
        Unit u_ENG_5_1_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Stories of Fun & Adventure", 1, "English", board, classLevel)));

        // Chapter: Wake Up! & Neha's Alarm Clock (Class 5)
        Chapter ch_ENG_5_1_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 1: Stories of Fun & Adventure", 1, "Wake Up! & Neha's Alarm Clock (Class 5)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 1: Stories of Fun & Adventure", "Wake Up! & Neha's Alarm Clock (Class 5)", ch_ENG_5_1_1_1, "Morning Routine, Phonics & Sentences");

        // Chapter: The Little Fir Tree & Noses (Class 5)
        Chapter ch_ENG_5_1_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 1: Stories of Fun & Adventure", 2, "The Little Fir Tree & Noses (Class 5)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 1: Stories of Fun & Adventure", "The Little Fir Tree & Noses (Class 5)", ch_ENG_5_1_1_2, "Adjectives, Rhymes & Vocabulary");

        // Unit: Unit 2: Friendship & Nature
        Unit u_ENG_5_1_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Friendship & Nature", 2, "English", board, classLevel)));

        // Chapter: Run! & Nasiruddin's Aim (Class 5)
        Chapter ch_ENG_5_1_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 2: Friendship & Nature", 3, "Run! & Nasiruddin's Aim (Class 5)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 2: Friendship & Nature", "Run! & Nasiruddin's Aim (Class 5)", ch_ENG_5_1_2_3, "Sportsmanship, Action Words & Verbs");

        // Chapter: Why? & Alice in Wonderland (Class 5)
        Chapter ch_ENG_5_1_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 2: Friendship & Nature", 4, "Why? & Alice in Wonderland (Class 5)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 2: Friendship & Nature", "Why? & Alice in Wonderland (Class 5)", ch_ENG_5_1_2_4, "Curiosity, Prepositions & Storytelling");

        // Unit: Unit 3: Bravery & Helpful Hands
        Unit u_ENG_5_1_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Bravery & Helpful Hands", 3, "English", board, classLevel)));

        // Chapter: Don't be Afraid of the Dark & Helen Keller (Class 5)
        Chapter ch_ENG_5_1_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 3: Bravery & Helpful Hands", 5, "Don't be Afraid of the Dark & Helen Keller (Class 5)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 3: Bravery & Helpful Hands", "Don't be Afraid of the Dark & Helen Keller (Class 5)", ch_ENG_5_1_3_5, "Overcoming Fear, Braille & Determination");

        // Chapter: Hiawatha & The Scholar's Mother Tongue (Class 5)
        Chapter ch_ENG_5_1_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 3: Bravery & Helpful Hands", 6, "Hiawatha & The Scholar's Mother Tongue (Class 5)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 3: Bravery & Helpful Hands", "Hiawatha & The Scholar's Mother Tongue (Class 5)", ch_ENG_5_1_3_6, "Birbal Wit, Dialects & Nouns");

        // Unit: Unit 4: Magic & Imagination
        Unit u_ENG_5_1_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Magic & Imagination", 4, "English", board, classLevel)));

        // Chapter: A Watering Rhyme & The Giving Tree (Class 5)
        Chapter ch_ENG_5_1_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 4: Magic & Imagination", 7, "A Watering Rhyme & The Giving Tree (Class 5)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 4: Magic & Imagination", "A Watering Rhyme & The Giving Tree (Class 5)", ch_ENG_5_1_4_7, "Plant Care, Selfless Giving & Composition");

        // Chapter: Books & Going to Buy a Book (Class 5)
        Chapter ch_ENG_5_1_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 4: Magic & Imagination", 8, "Books & Going to Buy a Book (Class 5)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 4: Magic & Imagination", "Books & Going to Buy a Book (Class 5)", ch_ENG_5_1_4_8, "Reading Habits & Bookstores");

        // Unit: Unit 5: Travelling & Discovery
        Unit u_ENG_5_1_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 5: Travelling & Discovery", 5, "English", board, classLevel)));

        // Chapter: The Naughty Boy & Pinocchio (Class 5)
        Chapter ch_ENG_5_1_5_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 5: Travelling & Discovery", 9, "The Naughty Boy & Pinocchio (Class 5)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 5: Travelling & Discovery", "The Naughty Boy & Pinocchio (Class 5)", ch_ENG_5_1_5_9, "Honesty, Creative Writing & Opposites");

        // Subject: Mathematics
        Subject sub_MATH_5_2 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Mathematics")
                .orElseGet(() -> subjectRepository.save(new Subject("Mathematics", "MATH", "📐", "#4834d4", board, classLevel)));

        // Unit: Unit 1: Shapes, Geometry & Patterns
        Unit u_MATH_5_2_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Shapes, Geometry & Patterns", 1, "Mathematics", board, classLevel)));

        // Chapter: Building with Bricks & Shapes and Angles (Class 5)
        Chapter ch_MATH_5_2_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 1: Shapes, Geometry & Patterns", 1, "Building with Bricks & Shapes and Angles (Class 5)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 1: Shapes, Geometry & Patterns", "Building with Bricks & Shapes and Angles (Class 5)", ch_MATH_5_2_1_1, "Floor Patterns, Angles, Clock Hands");

        // Chapter: How many Squares? & Parts and Wholes (Class 5)
        Chapter ch_MATH_5_2_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 1: Shapes, Geometry & Patterns", 2, "How many Squares? & Parts and Wholes (Class 5)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 1: Shapes, Geometry & Patterns", "How many Squares? & Parts and Wholes (Class 5)", ch_MATH_5_2_1_2, "Area, Perimeter, Fractions & Shading");

        // Unit: Unit 2: Symmetry, Multiples & Operations
        Unit u_MATH_5_2_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Symmetry, Multiples & Operations", 2, "Mathematics", board, classLevel)));

        // Chapter: Does it look the same? & Be My Multiple, I'll be Your Factor (Class 5)
        Chapter ch_MATH_5_2_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 2: Symmetry, Multiples & Operations", 3, "Does it look the same? & Be My Multiple, I'll be Your Factor (Class 5)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 2: Symmetry, Multiples & Operations", "Does it look the same? & Be My Multiple, I'll be Your Factor (Class 5)", ch_MATH_5_2_2_3, "Rotational Symmetry, HCF, LCM & Multiples");

        // Chapter: Can You See the Pattern? & Boxes and Sketches (Class 5)
        Chapter ch_MATH_5_2_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 2: Symmetry, Multiples & Operations", 4, "Can You See the Pattern? & Boxes and Sketches (Class 5)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 2: Symmetry, Multiples & Operations", "Can You See the Pattern? & Boxes and Sketches (Class 5)", ch_MATH_5_2_2_4, "Number Sequences & 3D Cube Nets");

        // Unit: Unit 3: Decimal Numbers, Area & Mapping
        Unit u_MATH_5_2_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Decimal Numbers, Area & Mapping", 3, "Mathematics", board, classLevel)));

        // Chapter: Tenths and Hundredths & Mapping Your Way (Class 5)
        Chapter ch_MATH_5_2_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 3: Decimal Numbers, Area & Mapping", 5, "Tenths and Hundredths & Mapping Your Way (Class 5)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 3: Decimal Numbers, Area & Mapping", "Tenths and Hundredths & Mapping Your Way (Class 5)", ch_MATH_5_2_3_5, "Decimals, Money, Scale Maps & Directions");

        // Chapter: Area and its Boundary & Smart Charts (Class 5)
        Chapter ch_MATH_5_2_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 3: Decimal Numbers, Area & Mapping", 6, "Area and its Boundary & Smart Charts (Class 5)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 3: Decimal Numbers, Area & Mapping", "Area and its Boundary & Smart Charts (Class 5)", ch_MATH_5_2_3_6, "Square Grids, Bar Charts & Tallies");

        // Unit: Unit 4: Multiplication, Division & Volume
        Unit u_MATH_5_2_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Multiplication, Division & Volume", 4, "Mathematics", board, classLevel)));

        // Chapter: Ways to Multiply and Divide & How Big? How Heavy? (Class 5)
        Chapter ch_MATH_5_2_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 4: Multiplication, Division & Volume", 7, "Ways to Multiply and Divide & How Big? How Heavy? (Class 5)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 4: Multiplication, Division & Volume", "Ways to Multiply and Divide & How Big? How Heavy? (Class 5)", ch_MATH_5_2_4_7, "Long Division, Word Problems, Weight & Volume of Cubes");

        // Subject: EVS
        Subject sub_EVS_5_3 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "EVS")
                .orElseGet(() -> subjectRepository.save(new Subject("EVS", "EVS", "🌱", "#20bf6b", board, classLevel)));

        // Unit: Unit 1: Animals, Senses & Super Powers
        Unit u_EVS_5_3_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "EVS")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Animals, Senses & Super Powers", 1, "EVS", board, classLevel)));

        // Chapter: Super Senses & A Snake Charmer's Story (Class 5)
        Chapter ch_EVS_5_3_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "EVS", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("EVS", "Unit 1: Animals, Senses & Super Powers", 1, "Super Senses & A Snake Charmer's Story (Class 5)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "EVS", "Unit 1: Animals, Senses & Super Powers", "Super Senses & A Snake Charmer's Story (Class 5)", ch_EVS_5_3_1_1, "Sense of Smell, Sight, Sound & Wildlife Protection");

        // Chapter: From Tasting to Digesting & Mangoes Round the Year (Class 5)
        Chapter ch_EVS_5_3_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "EVS", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("EVS", "Unit 1: Animals, Senses & Super Powers", 2, "From Tasting to Digesting & Mangoes Round the Year (Class 5)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "EVS", "Unit 1: Animals, Senses & Super Powers", "From Tasting to Digesting & Mangoes Round the Year (Class 5)", ch_EVS_5_3_1_2, "Digestive System, Food Preservation & Mamidi Tandra");

        // Unit: Unit 2: Seeds, Plants & Water Resources
        Unit u_EVS_5_3_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "EVS")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Seeds, Plants & Water Resources", 2, "EVS", board, classLevel)));

        // Chapter: Seeds and Seeds & Every Drop Counts (Class 5)
        Chapter ch_EVS_5_3_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "EVS", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("EVS", "Unit 2: Seeds, Plants & Water Resources", 3, "Seeds and Seeds & Every Drop Counts (Class 5)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "EVS", "Unit 2: Seeds, Plants & Water Resources", "Seeds and Seeds & Every Drop Counts (Class 5)", ch_EVS_5_3_2_3, "Seed Dispersal, Ghadsisar Lake & Stepwells");

        // Chapter: Experiments with Water & A Treat for Mosquitoes (Class 5)
        Chapter ch_EVS_5_3_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "EVS", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("EVS", "Unit 2: Seeds, Plants & Water Resources", 4, "Experiments with Water & A Treat for Mosquitoes (Class 5)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "EVS", "Unit 2: Seeds, Plants & Water Resources", "Experiments with Water & A Treat for Mosquitoes (Class 5)", ch_EVS_5_3_2_4, "Floating/Sinking, Malaria, Dengue & Blood Tests");

        // Unit: Unit 3: Journeys, Shelters & Space Exploration
        Unit u_EVS_5_3_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "EVS")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Journeys, Shelters & Space Exploration", 3, "EVS", board, classLevel)));

        // Chapter: Up You Go! & Walls Tell Stories (Class 5)
        Chapter ch_EVS_5_3_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "EVS", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("EVS", "Unit 3: Journeys, Shelters & Space Exploration", 5, "Up You Go! & Walls Tell Stories (Class 5)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "EVS", "Unit 3: Journeys, Shelters & Space Exploration", "Up You Go! & Walls Tell Stories (Class 5)", ch_EVS_5_3_3_5, "Mountaineering, Golconda Fort & Historical Architecture");

        // Chapter: Sunita in Space & What if it Finishes...? (Class 5)
        Chapter ch_EVS_5_3_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "EVS", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("EVS", "Unit 3: Journeys, Shelters & Space Exploration", 6, "Sunita in Space & What if it Finishes...? (Class 5)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "EVS", "Unit 3: Journeys, Shelters & Space Exploration", "Sunita in Space & What if it Finishes...? (Class 5)", ch_EVS_5_3_3_6, "Zero Gravity, Astronaut Life, Petroleum & Fuel Conservation");

        // Unit: Unit 4: Society, Forests & Farmer Livelihoods
        Unit u_EVS_5_3_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "EVS")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Society, Forests & Farmer Livelihoods", 4, "EVS", board, classLevel)));

        // Chapter: A Shelter so High! & When the Earth Shook! (Class 5)
        Chapter ch_EVS_5_3_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "EVS", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("EVS", "Unit 4: Society, Forests & Farmer Livelihoods", 7, "A Shelter so High! & When the Earth Shook! (Class 5)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "EVS", "Unit 4: Society, Forests & Farmer Livelihoods", "A Shelter so High! & When the Earth Shook! (Class 5)", ch_EVS_5_3_4_7, "Ladakh Cold Desert, Changpa Tribe & Earthquakes");

        // Chapter: Blow Hot, Blow Cold & Who will do this Work? (Class 5)
        Chapter ch_EVS_5_3_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "EVS", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("EVS", "Unit 4: Society, Forests & Farmer Livelihoods", 8, "Blow Hot, Blow Cold & Who will do this Work? (Class 5)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "EVS", "Unit 4: Society, Forests & Farmer Livelihoods", "Blow Hot, Blow Cold & Who will do this Work? (Class 5)", ch_EVS_5_3_4_8, "Respiration, Dignity of Labour & Gandhiji's Ashram");

        // Chapter: Across the Wall & Whose Forests? (Class 5)
        Chapter ch_EVS_5_3_4_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "EVS", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("EVS", "Unit 4: Society, Forests & Farmer Livelihoods", 9, "Across the Wall & Whose Forests? (Class 5)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "EVS", "Unit 4: Society, Forests & Farmer Livelihoods", "Across the Wall & Whose Forests? (Class 5)", ch_EVS_5_3_4_9, "Gender Equality in Sports, Kuduk Tribe & Forest Rights Act");

    }

    private void seed_CBSE_Class_6() {
        String board = "CBSE";
        int classLevel = 6;

        // Subject: English
        Subject sub_ENG_6_1 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "English")
                .orElseGet(() -> subjectRepository.save(new Subject("English", "ENG", "📚", "#fa8231", board, classLevel)));

        // Unit: Unit 1: Main Course – Inspiring Lives & Adventure
        Unit u_ENG_6_1_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Main Course – Inspiring Lives & Adventure", 1, "English", board, classLevel)));

        // Chapter: Prose Lesson 1 (Class 6 NCERT)
        Chapter ch_ENG_6_1_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 1: Main Course – Inspiring Lives & Adventure", 1, "Prose Lesson 1 (Class 6 NCERT)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 1: Main Course – Inspiring Lives & Adventure", "Prose Lesson 1 (Class 6 NCERT)", ch_ENG_6_1_1_1, "Comprehension & Vocabulary Enrichment");

        // Chapter: Poem 1 (Class 6 NCERT)
        Chapter ch_ENG_6_1_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 1: Main Course – Inspiring Lives & Adventure", 2, "Poem 1 (Class 6 NCERT)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 1: Main Course – Inspiring Lives & Adventure", "Poem 1 (Class 6 NCERT)", ch_ENG_6_1_1_2, "Rhyme Scheme & Figures of Speech");

        // Unit: Unit 2: Main Course – Nature, Science & Values
        Unit u_ENG_6_1_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Main Course – Nature, Science & Values", 2, "English", board, classLevel)));

        // Chapter: Prose Lesson 2 (Class 6 NCERT)
        Chapter ch_ENG_6_1_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 2: Main Course – Nature, Science & Values", 3, "Prose Lesson 2 (Class 6 NCERT)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 2: Main Course – Nature, Science & Values", "Prose Lesson 2 (Class 6 NCERT)", ch_ENG_6_1_2_3, "Grammar, Reported Speech & Tenses");

        // Chapter: Poem 2 (Class 6 NCERT)
        Chapter ch_ENG_6_1_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 2: Main Course – Nature, Science & Values", 4, "Poem 2 (Class 6 NCERT)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 2: Main Course – Nature, Science & Values", "Poem 2 (Class 6 NCERT)", ch_ENG_6_1_2_4, "Imagery, Theme & Poetic Devices");

        // Unit: Unit 3: Supplementary Reader – Moments & Footprints
        Unit u_ENG_6_1_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Supplementary Reader – Moments & Footprints", 3, "English", board, classLevel)));

        // Chapter: Supplementary Fiction 1 (Class 6 NCERT)
        Chapter ch_ENG_6_1_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 3: Supplementary Reader – Moments & Footprints", 5, "Supplementary Fiction 1 (Class 6 NCERT)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 3: Supplementary Reader – Moments & Footprints", "Supplementary Fiction 1 (Class 6 NCERT)", ch_ENG_6_1_3_5, "Plot Structure & Character Analysis");

        // Chapter: Supplementary Fiction 2 (Class 6 NCERT)
        Chapter ch_ENG_6_1_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 3: Supplementary Reader – Moments & Footprints", 6, "Supplementary Fiction 2 (Class 6 NCERT)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 3: Supplementary Reader – Moments & Footprints", "Supplementary Fiction 2 (Class 6 NCERT)", ch_ENG_6_1_3_6, "Conflict, Moral & Critical Thinking");

        // Unit: Unit 4: Writing Skills & Applied Grammar
        Unit u_ENG_6_1_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Writing Skills & Applied Grammar", 4, "English", board, classLevel)));

        // Chapter: Formal Letter Writing & Analytical Paragraph (Class 6)
        Chapter ch_ENG_6_1_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 4: Writing Skills & Applied Grammar", 7, "Formal Letter Writing & Analytical Paragraph (Class 6)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 4: Writing Skills & Applied Grammar", "Formal Letter Writing & Analytical Paragraph (Class 6)", ch_ENG_6_1_4_7, "Letters of Complaint/Inquiry & Data Analysis");

        // Chapter: Integrated Grammar – Editing, Omission & Modals (Class 6)
        Chapter ch_ENG_6_1_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 4: Writing Skills & Applied Grammar", 8, "Integrated Grammar – Editing, Omission & Modals (Class 6)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 4: Writing Skills & Applied Grammar", "Integrated Grammar – Editing, Omission & Modals (Class 6)", ch_ENG_6_1_4_8, "Error Correction & Sentence Transformation");

        // Subject: Mathematics
        Subject sub_MATH_6_2 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Mathematics")
                .orElseGet(() -> subjectRepository.save(new Subject("Mathematics", "MATH", "📐", "#4834d4", board, classLevel)));

        // Unit: Unit 1: Number Systems & Whole Numbers
        Unit u_MATH_6_2_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Number Systems & Whole Numbers", 1, "Mathematics", board, classLevel)));

        // Chapter: Knowing Our Numbers & Playing with Numbers
        Chapter ch_MATH_6_2_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 1: Number Systems & Whole Numbers", 1, "Knowing Our Numbers & Playing with Numbers", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 1: Number Systems & Whole Numbers", "Knowing Our Numbers & Playing with Numbers", ch_MATH_6_2_1_1, "Place Value, Roman Numerals, Divisibility Rules, Prime/Composite, HCF & LCM");

        // Unit: Unit 2: Integers, Fractions & Decimals
        Unit u_MATH_6_2_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Integers, Fractions & Decimals", 2, "Mathematics", board, classLevel)));

        // Chapter: Integers & Operations
        Chapter ch_MATH_6_2_2_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 2: Integers, Fractions & Decimals", 2, "Integers & Operations", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 2: Integers, Fractions & Decimals", "Integers & Operations", ch_MATH_6_2_2_2, "Number Line, Negative Numbers, Addition/Subtraction");

        // Chapter: Fractions and Decimals
        Chapter ch_MATH_6_2_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 2: Integers, Fractions & Decimals", 3, "Fractions and Decimals", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 2: Integers, Fractions & Decimals", "Fractions and Decimals", ch_MATH_6_2_2_3, "Proper/Improper Fractions, Decimals Representation");

        // Unit: Unit 3: Algebra, Ratio & Proportion
        Unit u_MATH_6_2_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Algebra, Ratio & Proportion", 3, "Mathematics", board, classLevel)));

        // Chapter: Introduction to Algebra & Ratio-Proportion
        Chapter ch_MATH_6_2_3_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 3: Algebra, Ratio & Proportion", 4, "Introduction to Algebra & Ratio-Proportion", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 3: Algebra, Ratio & Proportion", "Introduction to Algebra & Ratio-Proportion", ch_MATH_6_2_3_4, "Variables, Algebraic Expressions, Unitary Method");

        // Unit: Unit 4: Geometry & Mensuration
        Unit u_MATH_6_2_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Geometry & Mensuration", 4, "Mathematics", board, classLevel)));

        // Chapter: Basic Geometrical Ideas & Elementary Shapes
        Chapter ch_MATH_6_2_4_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 4: Geometry & Mensuration", 5, "Basic Geometrical Ideas & Elementary Shapes", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 4: Geometry & Mensuration", "Basic Geometrical Ideas & Elementary Shapes", ch_MATH_6_2_4_5, "Points, Rays, Angles, Polygons, Triangles, 3D Shapes");

        // Chapter: Mensuration – Perimeter and Area
        Chapter ch_MATH_6_2_4_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 4: Geometry & Mensuration", 6, "Mensuration – Perimeter and Area", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 4: Geometry & Mensuration", "Mensuration – Perimeter and Area", ch_MATH_6_2_4_6, "Perimeter of Rectangle/Square & Area Calculations");

        // Unit: Unit 5: Data Handling & Symmetry
        Unit u_MATH_6_2_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 5: Data Handling & Symmetry", 5, "Mathematics", board, classLevel)));

        // Chapter: Data Handling & Symmetry
        Chapter ch_MATH_6_2_5_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 5: Data Handling & Symmetry", 7, "Data Handling & Symmetry", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 5: Data Handling & Symmetry", "Data Handling & Symmetry", ch_MATH_6_2_5_7, "Tally Marks, Bar Graphs & Line of Symmetry");

        // Subject: Science
        Subject sub_SCI_6_3 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Science")
                .orElseGet(() -> subjectRepository.save(new Subject("Science", "SCI", "🔬", "#eb4d4b", board, classLevel)));

        // Unit: Unit 1: Food, Components & Sorting Materials
        Unit u_SCI_6_3_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Food, Components & Sorting Materials", 1, "Science", board, classLevel)));

        // Chapter: Components of Food – Nutrients & Deficiency
        Chapter ch_SCI_6_3_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 1: Food, Components & Sorting Materials", 1, "Components of Food – Nutrients & Deficiency", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 1: Food, Components & Sorting Materials", "Components of Food – Nutrients & Deficiency", ch_SCI_6_3_1_1, "Carbohydrates, Fats, Proteins, Vitamins & Balanced Diet");

        // Chapter: Sorting Materials into Groups
        Chapter ch_SCI_6_3_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 1: Food, Components & Sorting Materials", 2, "Sorting Materials into Groups", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 1: Food, Components & Sorting Materials", "Sorting Materials into Groups", ch_SCI_6_3_1_2, "Solubility, Transparency, Density & Conduction");

        // Unit: Unit 2: Separation of Substances & Living World
        Unit u_SCI_6_3_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Separation of Substances & Living World", 2, "Science", board, classLevel)));

        // Chapter: Separation of Substances
        Chapter ch_SCI_6_3_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 2: Separation of Substances & Living World", 3, "Separation of Substances", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 2: Separation of Substances & Living World", "Separation of Substances", ch_SCI_6_3_2_3, "Sedimentation, Decantation, Filtration, Evaporation");

        // Chapter: Getting to Know Plants & Body Movements
        Chapter ch_SCI_6_3_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 2: Separation of Substances & Living World", 4, "Getting to Know Plants & Body Movements", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 2: Separation of Substances & Living World", "Getting to Know Plants & Body Movements", ch_SCI_6_3_2_4, "Herbs, Shrubs, Trees, Venation, Joints & Skeletal System");

        // Unit: Unit 3: Motion, Light, Electricity & Air
        Unit u_SCI_6_3_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Motion, Light, Electricity & Air", 3, "Science", board, classLevel)));

        // Chapter: The Living Organisms – Characteristics and Habitats
        Chapter ch_SCI_6_3_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 3: Motion, Light, Electricity & Air", 5, "The Living Organisms – Characteristics and Habitats", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 3: Motion, Light, Electricity & Air", "The Living Organisms – Characteristics and Habitats", ch_SCI_6_3_3_5, "Terrestrial, Aquatic, Adaptations, Respiration");

        // Chapter: Motion and Measurement of Distances
        Chapter ch_SCI_6_3_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 3: Motion, Light, Electricity & Air", 6, "Motion and Measurement of Distances", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 3: Motion, Light, Electricity & Air", "Motion and Measurement of Distances", ch_SCI_6_3_3_6, "Standard Units, SI Units, Rectilinear, Circular & Periodic Motion");

        // Chapter: Light, Shadows and Reflections
        Chapter ch_SCI_6_3_3_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 3: Motion, Light, Electricity & Air", 7, "Light, Shadows and Reflections", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 3: Motion, Light, Electricity & Air", "Light, Shadows and Reflections", ch_SCI_6_3_3_7, "Luminous, Opaque, Pin-hole Camera, Reflection");

        // Chapter: Electricity and Circuits & Air Around Us
        Chapter ch_SCI_6_3_3_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 3: Motion, Light, Electricity & Air", 8, "Electricity and Circuits & Air Around Us", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 3: Motion, Light, Electricity & Air", "Electricity and Circuits & Air Around Us", ch_SCI_6_3_3_8, "Electric Cell, Switch, Conductors, Insulators & Atmosphere");

        // Subject: Social Science
        Subject sub_SOC_6_4 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Social Science")
                .orElseGet(() -> subjectRepository.save(new Subject("Social Science", "SOC", "🌍", "#10ac84", board, classLevel)));

        // Unit: Unit 1: History – Our Pasts-I
        Unit u_SOC_6_4_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: History – Our Pasts-I", 1, "Social Science", board, classLevel)));

        // Chapter: What, Where, How and When? & From Hunting to Growing Food
        Chapter ch_SOC_6_4_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 1: History – Our Pasts-I", 1, "What, Where, How and When? & From Hunting to Growing Food", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 1: History – Our Pasts-I", "What, Where, How and When? & From Hunting to Growing Food", ch_SOC_6_4_1_1, "Archaeology, Manuscipts, Earliest Cities, Harappa & Mohenjodaro");

        // Chapter: Kingdoms, Kings and an Early Republic & New Questions and Ideas
        Chapter ch_SOC_6_4_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 1: History – Our Pasts-I", 2, "Kingdoms, Kings and an Early Republic & New Questions and Ideas", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 1: History – Our Pasts-I", "Kingdoms, Kings and an Early Republic & New Questions and Ideas", ch_SOC_6_4_1_2, "Vedas, Mahajanapadas, Magadha, Gautama Buddha & Upanishads");

        // Chapter: Ashoka, The Emperor & Villages, Towns and Trade
        Chapter ch_SOC_6_4_1_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 1: History – Our Pasts-I", 3, "Ashoka, The Emperor & Villages, Towns and Trade", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 1: History – Our Pasts-I", "Ashoka, The Emperor & Villages, Towns and Trade", ch_SOC_6_4_1_3, "Kalinga War, Dhamma, Inscriptions, Mathura & Sangam Poems");

        // Chapter: New Empires and Kingdoms & Buildings, Paintings and Books
        Chapter ch_SOC_6_4_1_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 1: History – Our Pasts-I", 4, "New Empires and Kingdoms & Buildings, Paintings and Books", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 1: History – Our Pasts-I", "New Empires and Kingdoms & Buildings, Paintings and Books", ch_SOC_6_4_1_4, "Samudragupta Prashasti, Harshavardhana, Iron Pillar & Stupas");

        // Unit: Unit 2: Geography – The Earth Our Habitat
        Unit u_SOC_6_4_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Geography – The Earth Our Habitat", 2, "Social Science", board, classLevel)));

        // Chapter: The Earth in the Solar System & Globe: Latitudes and Longitudes
        Chapter ch_SOC_6_4_2_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 2: Geography – The Earth Our Habitat", 5, "The Earth in the Solar System & Globe: Latitudes and Longitudes", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 2: Geography – The Earth Our Habitat", "The Earth in the Solar System & Globe: Latitudes and Longitudes", ch_SOC_6_4_2_5, "Planets, Sun, Equator, Prime Meridian, IST & Time Zones");

        // Chapter: Motions of the Earth, Maps & Major Domains of the Earth
        Chapter ch_SOC_6_4_2_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 2: Geography – The Earth Our Habitat", 6, "Motions of the Earth, Maps & Major Domains of the Earth", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 2: Geography – The Earth Our Habitat", "Motions of the Earth, Maps & Major Domains of the Earth", ch_SOC_6_4_2_6, "Rotation, Revolution, Solstices, Scales, Lithosphere, Hydrosphere, Atmosphere");

        // Unit: Unit 3: Civics – Social and Political Life-I
        Unit u_SOC_6_4_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Civics – Social and Political Life-I", 3, "Social Science", board, classLevel)));

        // Chapter: Understanding Diversity, Diversity and Discrimination
        Chapter ch_SOC_6_4_3_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 3: Civics – Social and Political Life-I", 7, "Understanding Diversity, Diversity and Discrimination", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 3: Civics – Social and Political Life-I", "Understanding Diversity, Diversity and Discrimination", ch_SOC_6_4_3_7, "Prejudice, Stereotypes, Dr. Ambedkar & Equality");

        // Chapter: What is Government?, Democratic Government & Panchayati Raj
        Chapter ch_SOC_6_4_3_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 3: Civics – Social and Political Life-I", 8, "What is Government?, Democratic Government & Panchayati Raj", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 3: Civics – Social and Political Life-I", "What is Government?, Democratic Government & Panchayati Raj", ch_SOC_6_4_3_8, "Universal Adult Franchise, Gram Panchayat, District Administration & Urban Livelihoods");

    }

    private void seed_CBSE_Class_7() {
        String board = "CBSE";
        int classLevel = 7;

        // Subject: English
        Subject sub_ENG_7_1 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "English")
                .orElseGet(() -> subjectRepository.save(new Subject("English", "ENG", "📚", "#fa8231", board, classLevel)));

        // Unit: Unit 1: Main Course – Inspiring Lives & Adventure
        Unit u_ENG_7_1_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Main Course – Inspiring Lives & Adventure", 1, "English", board, classLevel)));

        // Chapter: Prose Lesson 1 (Class 7 NCERT)
        Chapter ch_ENG_7_1_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 1: Main Course – Inspiring Lives & Adventure", 1, "Prose Lesson 1 (Class 7 NCERT)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 1: Main Course – Inspiring Lives & Adventure", "Prose Lesson 1 (Class 7 NCERT)", ch_ENG_7_1_1_1, "Comprehension & Vocabulary Enrichment");

        // Chapter: Poem 1 (Class 7 NCERT)
        Chapter ch_ENG_7_1_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 1: Main Course – Inspiring Lives & Adventure", 2, "Poem 1 (Class 7 NCERT)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 1: Main Course – Inspiring Lives & Adventure", "Poem 1 (Class 7 NCERT)", ch_ENG_7_1_1_2, "Rhyme Scheme & Figures of Speech");

        // Unit: Unit 2: Main Course – Nature, Science & Values
        Unit u_ENG_7_1_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Main Course – Nature, Science & Values", 2, "English", board, classLevel)));

        // Chapter: Prose Lesson 2 (Class 7 NCERT)
        Chapter ch_ENG_7_1_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 2: Main Course – Nature, Science & Values", 3, "Prose Lesson 2 (Class 7 NCERT)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 2: Main Course – Nature, Science & Values", "Prose Lesson 2 (Class 7 NCERT)", ch_ENG_7_1_2_3, "Grammar, Reported Speech & Tenses");

        // Chapter: Poem 2 (Class 7 NCERT)
        Chapter ch_ENG_7_1_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 2: Main Course – Nature, Science & Values", 4, "Poem 2 (Class 7 NCERT)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 2: Main Course – Nature, Science & Values", "Poem 2 (Class 7 NCERT)", ch_ENG_7_1_2_4, "Imagery, Theme & Poetic Devices");

        // Unit: Unit 3: Supplementary Reader – Moments & Footprints
        Unit u_ENG_7_1_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Supplementary Reader – Moments & Footprints", 3, "English", board, classLevel)));

        // Chapter: Supplementary Fiction 1 (Class 7 NCERT)
        Chapter ch_ENG_7_1_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 3: Supplementary Reader – Moments & Footprints", 5, "Supplementary Fiction 1 (Class 7 NCERT)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 3: Supplementary Reader – Moments & Footprints", "Supplementary Fiction 1 (Class 7 NCERT)", ch_ENG_7_1_3_5, "Plot Structure & Character Analysis");

        // Chapter: Supplementary Fiction 2 (Class 7 NCERT)
        Chapter ch_ENG_7_1_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 3: Supplementary Reader – Moments & Footprints", 6, "Supplementary Fiction 2 (Class 7 NCERT)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 3: Supplementary Reader – Moments & Footprints", "Supplementary Fiction 2 (Class 7 NCERT)", ch_ENG_7_1_3_6, "Conflict, Moral & Critical Thinking");

        // Unit: Unit 4: Writing Skills & Applied Grammar
        Unit u_ENG_7_1_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Writing Skills & Applied Grammar", 4, "English", board, classLevel)));

        // Chapter: Formal Letter Writing & Analytical Paragraph (Class 7)
        Chapter ch_ENG_7_1_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 4: Writing Skills & Applied Grammar", 7, "Formal Letter Writing & Analytical Paragraph (Class 7)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 4: Writing Skills & Applied Grammar", "Formal Letter Writing & Analytical Paragraph (Class 7)", ch_ENG_7_1_4_7, "Letters of Complaint/Inquiry & Data Analysis");

        // Chapter: Integrated Grammar – Editing, Omission & Modals (Class 7)
        Chapter ch_ENG_7_1_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 4: Writing Skills & Applied Grammar", 8, "Integrated Grammar – Editing, Omission & Modals (Class 7)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 4: Writing Skills & Applied Grammar", "Integrated Grammar – Editing, Omission & Modals (Class 7)", ch_ENG_7_1_4_8, "Error Correction & Sentence Transformation");

        // Subject: Mathematics
        Subject sub_MATH_7_2 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Mathematics")
                .orElseGet(() -> subjectRepository.save(new Subject("Mathematics", "MATH", "📐", "#4834d4", board, classLevel)));

        // Unit: Unit 1: Integers, Fractions & Decimals
        Unit u_MATH_7_2_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Integers, Fractions & Decimals", 1, "Mathematics", board, classLevel)));

        // Chapter: Integers & Rational Numbers
        Chapter ch_MATH_7_2_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 1: Integers, Fractions & Decimals", 1, "Integers & Rational Numbers", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 1: Integers, Fractions & Decimals", "Integers & Rational Numbers", ch_MATH_7_2_1_1, "Multiplication/Division of Integers & Standard Form");

        // Chapter: Fractions and Decimals Operations
        Chapter ch_MATH_7_2_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 1: Integers, Fractions & Decimals", 2, "Fractions and Decimals Operations", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 1: Integers, Fractions & Decimals", "Fractions and Decimals Operations", ch_MATH_7_2_1_2, "Multiplication/Division of Fractions & Decimals");

        // Unit: Unit 2: Data Handling & Simple Equations
        Unit u_MATH_7_2_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Data Handling & Simple Equations", 2, "Mathematics", board, classLevel)));

        // Chapter: Data Handling – Mean, Median, Mode & Bar Graphs
        Chapter ch_MATH_7_2_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 2: Data Handling & Simple Equations", 3, "Data Handling – Mean, Median, Mode & Bar Graphs", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 2: Data Handling & Simple Equations", "Data Handling – Mean, Median, Mode & Bar Graphs", ch_MATH_7_2_2_3, "Measures of Central Tendency & Probability");

        // Chapter: Simple Equations in One Variable
        Chapter ch_MATH_7_2_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 2: Data Handling & Simple Equations", 4, "Simple Equations in One Variable", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 2: Data Handling & Simple Equations", "Simple Equations in One Variable", ch_MATH_7_2_2_4, "Setting up Equations & Solving Linear Equations");

        // Unit: Unit 3: Lines, Angles & Triangles
        Unit u_MATH_7_2_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Lines, Angles & Triangles", 3, "Mathematics", board, classLevel)));

        // Chapter: Lines and Angles & Triangle Properties
        Chapter ch_MATH_7_2_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 3: Lines, Angles & Triangles", 5, "Lines and Angles & Triangle Properties", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 3: Lines, Angles & Triangles", "Lines and Angles & Triangle Properties", ch_MATH_7_2_3_5, "Complementary, Supplementary, Exterior Angle Theorem & Pythagoras");

        // Unit: Unit 4: Comparing Quantities & Algebraic Expressions
        Unit u_MATH_7_2_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Comparing Quantities & Algebraic Expressions", 4, "Mathematics", board, classLevel)));

        // Chapter: Comparing Quantities – Percentage & Profit/Loss
        Chapter ch_MATH_7_2_4_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 4: Comparing Quantities & Algebraic Expressions", 6, "Comparing Quantities – Percentage & Profit/Loss", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 4: Comparing Quantities & Algebraic Expressions", "Comparing Quantities – Percentage & Profit/Loss", ch_MATH_7_2_4_6, "Simple Interest (P*R*T/100) & Discount");

        // Chapter: Algebraic Expressions & Exponents/Powers
        Chapter ch_MATH_7_2_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 4: Comparing Quantities & Algebraic Expressions", 7, "Algebraic Expressions & Exponents/Powers", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 4: Comparing Quantities & Algebraic Expressions", "Algebraic Expressions & Exponents/Powers", ch_MATH_7_2_4_7, "Addition/Subtraction of Expressions & Laws of Exponents");

        // Unit: Unit 5: Mensuration & Visualising Solids
        Unit u_MATH_7_2_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 5: Mensuration & Visualising Solids", 5, "Mathematics", board, classLevel)));

        // Chapter: Perimeter and Area of Circle & Triangles
        Chapter ch_MATH_7_2_5_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 5: Mensuration & Visualising Solids", 8, "Perimeter and Area of Circle & Triangles", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 5: Mensuration & Visualising Solids", "Perimeter and Area of Circle & Triangles", ch_MATH_7_2_5_8, "Circumference, Area = pi*r^2 & Parallelogram Area");

        // Chapter: Symmetry & Visualising Solid Shapes
        Chapter ch_MATH_7_2_5_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 5: Mensuration & Visualising Solids", 9, "Symmetry & Visualising Solid Shapes", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 5: Mensuration & Visualising Solids", "Symmetry & Visualising Solid Shapes", ch_MATH_7_2_5_9, "Rotational Symmetry, Isometric Sketches");

        // Subject: Science
        Subject sub_SCI_7_3 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Science")
                .orElseGet(() -> subjectRepository.save(new Subject("Science", "SCI", "🔬", "#eb4d4b", board, classLevel)));

        // Unit: Unit 1: Nutrition in Plants and Animals
        Unit u_SCI_7_3_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Nutrition in Plants and Animals", 1, "Science", board, classLevel)));

        // Chapter: Nutrition in Plants – Autotrophic & Heterotrophic
        Chapter ch_SCI_7_3_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 1: Nutrition in Plants and Animals", 1, "Nutrition in Plants – Autotrophic & Heterotrophic", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 1: Nutrition in Plants and Animals", "Nutrition in Plants – Autotrophic & Heterotrophic", ch_SCI_7_3_1_1, "Photosynthesis, Stomata, Parasites & Saprotrophs");

        // Chapter: Nutrition in Animals – Human Digestion
        Chapter ch_SCI_7_3_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 1: Nutrition in Plants and Animals", 2, "Nutrition in Animals – Human Digestion", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 1: Nutrition in Plants and Animals", "Nutrition in Animals – Human Digestion", ch_SCI_7_3_1_2, "Buccal Cavity, Stomach, Small Intestine & Ruminants");

        // Unit: Unit 2: Heat, Acids, Bases and Salts
        Unit u_SCI_7_3_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Heat, Acids, Bases and Salts", 2, "Science", board, classLevel)));

        // Chapter: Heat – Temperature & Heat Transfer
        Chapter ch_SCI_7_3_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 2: Heat, Acids, Bases and Salts", 3, "Heat – Temperature & Heat Transfer", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 2: Heat, Acids, Bases and Salts", "Heat – Temperature & Heat Transfer", ch_SCI_7_3_2_3, "Clinical/Laboratory Thermometers, Conduction, Convection, Radiation");

        // Chapter: Acids, Bases and Salts & Physical/Chemical Changes
        Chapter ch_SCI_7_3_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 2: Heat, Acids, Bases and Salts", 4, "Acids, Bases and Salts & Physical/Chemical Changes", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 2: Heat, Acids, Bases and Salts", "Acids, Bases and Salts & Physical/Chemical Changes", ch_SCI_7_3_2_4, "Litmus, Phenolphthalein, Neutralisation & Rusting");

        // Unit: Unit 3: Respiration, Transportation & Plant Reproduction
        Unit u_SCI_7_3_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Respiration, Transportation & Plant Reproduction", 3, "Science", board, classLevel)));

        // Chapter: Respiration in Organisms
        Chapter ch_SCI_7_3_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 3: Respiration, Transportation & Plant Reproduction", 5, "Respiration in Organisms", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 3: Respiration, Transportation & Plant Reproduction", "Respiration in Organisms", ch_SCI_7_3_3_5, "Aerobic, Anaerobic, Breathing Mechanism & Cellular Respiration");

        // Chapter: Transportation in Animals and Plants
        Chapter ch_SCI_7_3_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 3: Respiration, Transportation & Plant Reproduction", 6, "Transportation in Animals and Plants", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 3: Respiration, Transportation & Plant Reproduction", "Transportation in Animals and Plants", ch_SCI_7_3_3_6, "Heart, Blood Vessels, Xylem, Phloem & Excretion");

        // Chapter: Reproduction in Plants
        Chapter ch_SCI_7_3_3_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 3: Respiration, Transportation & Plant Reproduction", 7, "Reproduction in Plants", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 3: Respiration, Transportation & Plant Reproduction", "Reproduction in Plants", ch_SCI_7_3_3_7, "Vegetative Propagation, Flowers, Pollination & Seed Dispersal");

        // Unit: Unit 4: Motion, Electric Current & Light
        Unit u_SCI_7_3_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Motion, Electric Current & Light", 4, "Science", board, classLevel)));

        // Chapter: Motion and Time – Speed & Simple Pendulum
        Chapter ch_SCI_7_3_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 4: Motion, Electric Current & Light", 8, "Motion and Time – Speed & Simple Pendulum", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 4: Motion, Electric Current & Light", "Motion and Time – Speed & Simple Pendulum", ch_SCI_7_3_4_8, "Distance-Time Graphs, Uniform/Non-uniform Motion");

        // Chapter: Electric Current and its Effects & Light
        Chapter ch_SCI_7_3_4_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 4: Motion, Electric Current & Light", 9, "Electric Current and its Effects & Light", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 4: Motion, Electric Current & Light", "Electric Current and its Effects & Light", ch_SCI_7_3_4_9, "Heating/Magnetic Effects, Electromagnets, Spherical Mirrors & Lenses");

        // Chapter: Forests: Our Lifeline & Wastewater Story
        Chapter ch_SCI_7_3_4_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 4: Motion, Electric Current & Light", 10, "Forests: Our Lifeline & Wastewater Story", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 4: Motion, Electric Current & Light", "Forests: Our Lifeline & Wastewater Story", ch_SCI_7_3_4_10, "Crown, Canopy, Decomposers & Sewage Treatment");

        // Subject: Social Science
        Subject sub_SOC_7_4 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Social Science")
                .orElseGet(() -> subjectRepository.save(new Subject("Social Science", "SOC", "🌍", "#10ac84", board, classLevel)));

        // Unit: Unit 1: History – Our Pasts-II
        Unit u_SOC_7_4_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: History – Our Pasts-II", 1, "Social Science", board, classLevel)));

        // Chapter: Tracing Changes Through a Thousand Years & Kings and Kingdoms
        Chapter ch_SOC_7_4_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 1: History – Our Pasts-II", 1, "Tracing Changes Through a Thousand Years & Kings and Kingdoms", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 1: History – Our Pasts-II", "Tracing Changes Through a Thousand Years & Kings and Kingdoms", ch_SOC_7_4_1_1, "Cartography, Cholas, Prashastis, Land Grants & Tripartite Struggle");

        // Chapter: The Delhi Sultans & The Mughal Empire
        Chapter ch_SOC_7_4_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 1: History – Our Pasts-II", 2, "The Delhi Sultans & The Mughal Empire", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 1: History – Our Pasts-II", "The Delhi Sultans & The Mughal Empire", ch_SOC_7_4_1_2, "Iltutmish, Raziyya, Alauddin, Akbar, Mansabdars, Sulh-i Kul");

        // Chapter: Tribes, Nomads and Settled Communities & Devotional Paths
        Chapter ch_SOC_7_4_1_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 1: History – Our Pasts-II", 3, "Tribes, Nomads and Settled Communities & Devotional Paths", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 1: History – Our Pasts-II", "Tribes, Nomads and Settled Communities & Devotional Paths", ch_SOC_7_4_1_3, "Ahom, Gonds, Bhakti Movement, Sufism, Kabir, Guru Nanak");

        // Chapter: The Making of Regional Cultures & 18th-Century Political Formations
        Chapter ch_SOC_7_4_1_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 1: History – Our Pasts-II", 4, "The Making of Regional Cultures & 18th-Century Political Formations", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 1: History – Our Pasts-II", "The Making of Regional Cultures & 18th-Century Political Formations", ch_SOC_7_4_1_4, "Kathak, Miniature Paintings, Marathas, Shivaji & Peshwas");

        // Unit: Unit 2: Geography – Our Environment
        Unit u_SOC_7_4_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Geography – Our Environment", 2, "Social Science", board, classLevel)));

        // Chapter: Environment, Inside Our Earth & Our Changing Earth
        Chapter ch_SOC_7_4_2_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 2: Geography – Our Environment", 5, "Environment, Inside Our Earth & Our Changing Earth", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 2: Geography – Our Environment", "Environment, Inside Our Earth & Our Changing Earth", ch_SOC_7_4_2_5, "Abiotic/Biotic, Crust/Mantle/Core, Igneous/Sedimentary, Plate Tectonics & Erosion");

        // Chapter: Air, Water, Human Environment & Life in the Deserts
        Chapter ch_SOC_7_4_2_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 2: Geography – Our Environment", 6, "Air, Water, Human Environment & Life in the Deserts", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 2: Geography – Our Environment", "Air, Water, Human Environment & Life in the Deserts", ch_SOC_7_4_2_6, "Atmosphere Layers, Ocean Currents, Amazon Basin, Sahara & Ladakh");

        // Unit: Unit 3: Civics – Social and Political Life-II
        Unit u_SOC_7_4_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Civics – Social and Political Life-II", 3, "Social Science", board, classLevel)));

        // Chapter: On Equality & Role of the Government in Health
        Chapter ch_SOC_7_4_3_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 3: Civics – Social and Political Life-II", 7, "On Equality & Role of the Government in Health", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 3: Civics – Social and Political Life-II", "On Equality & Role of the Government in Health", ch_SOC_7_4_3_7, "Article 15, Midday Meal Scheme, Public vs Private Healthcare");

        // Chapter: How the State Government Works & Growing up as Boys and Girls
        Chapter ch_SOC_7_4_3_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 3: Civics – Social and Political Life-II", 8, "How the State Government Works & Growing up as Boys and Girls", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 3: Civics – Social and Political Life-II", "How the State Government Works & Growing up as Boys and Girls", ch_SOC_7_4_3_8, "MLAs, Cabinet, Gender Roles & Domestic Work Recognition");

        // Chapter: Media, Advertising & Markets Around Us
        Chapter ch_SOC_7_4_3_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 3: Civics – Social and Political Life-II", 9, "Media, Advertising & Markets Around Us", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 3: Civics – Social and Political Life-II", "Media, Advertising & Markets Around Us", ch_SOC_7_4_3_9, "Media Censorship, Weekly Markets, Supply Chains & A Shirt in the Market");

    }

    private void seed_CBSE_Class_8() {
        String board = "CBSE";
        int classLevel = 8;

        // Subject: English
        Subject sub_ENG_8_1 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "English")
                .orElseGet(() -> subjectRepository.save(new Subject("English", "ENG", "📚", "#fa8231", board, classLevel)));

        // Unit: Unit 1: Main Course – Inspiring Lives & Adventure
        Unit u_ENG_8_1_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Main Course – Inspiring Lives & Adventure", 1, "English", board, classLevel)));

        // Chapter: Prose Lesson 1 (Class 8 NCERT)
        Chapter ch_ENG_8_1_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 1: Main Course – Inspiring Lives & Adventure", 1, "Prose Lesson 1 (Class 8 NCERT)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 1: Main Course – Inspiring Lives & Adventure", "Prose Lesson 1 (Class 8 NCERT)", ch_ENG_8_1_1_1, "Comprehension & Vocabulary Enrichment");

        // Chapter: Poem 1 (Class 8 NCERT)
        Chapter ch_ENG_8_1_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 1: Main Course – Inspiring Lives & Adventure", 2, "Poem 1 (Class 8 NCERT)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 1: Main Course – Inspiring Lives & Adventure", "Poem 1 (Class 8 NCERT)", ch_ENG_8_1_1_2, "Rhyme Scheme & Figures of Speech");

        // Unit: Unit 2: Main Course – Nature, Science & Values
        Unit u_ENG_8_1_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Main Course – Nature, Science & Values", 2, "English", board, classLevel)));

        // Chapter: Prose Lesson 2 (Class 8 NCERT)
        Chapter ch_ENG_8_1_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 2: Main Course – Nature, Science & Values", 3, "Prose Lesson 2 (Class 8 NCERT)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 2: Main Course – Nature, Science & Values", "Prose Lesson 2 (Class 8 NCERT)", ch_ENG_8_1_2_3, "Grammar, Reported Speech & Tenses");

        // Chapter: Poem 2 (Class 8 NCERT)
        Chapter ch_ENG_8_1_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 2: Main Course – Nature, Science & Values", 4, "Poem 2 (Class 8 NCERT)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 2: Main Course – Nature, Science & Values", "Poem 2 (Class 8 NCERT)", ch_ENG_8_1_2_4, "Imagery, Theme & Poetic Devices");

        // Unit: Unit 3: Supplementary Reader – Moments & Footprints
        Unit u_ENG_8_1_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Supplementary Reader – Moments & Footprints", 3, "English", board, classLevel)));

        // Chapter: Supplementary Fiction 1 (Class 8 NCERT)
        Chapter ch_ENG_8_1_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 3: Supplementary Reader – Moments & Footprints", 5, "Supplementary Fiction 1 (Class 8 NCERT)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 3: Supplementary Reader – Moments & Footprints", "Supplementary Fiction 1 (Class 8 NCERT)", ch_ENG_8_1_3_5, "Plot Structure & Character Analysis");

        // Chapter: Supplementary Fiction 2 (Class 8 NCERT)
        Chapter ch_ENG_8_1_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 3: Supplementary Reader – Moments & Footprints", 6, "Supplementary Fiction 2 (Class 8 NCERT)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 3: Supplementary Reader – Moments & Footprints", "Supplementary Fiction 2 (Class 8 NCERT)", ch_ENG_8_1_3_6, "Conflict, Moral & Critical Thinking");

        // Unit: Unit 4: Writing Skills & Applied Grammar
        Unit u_ENG_8_1_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Writing Skills & Applied Grammar", 4, "English", board, classLevel)));

        // Chapter: Formal Letter Writing & Analytical Paragraph (Class 8)
        Chapter ch_ENG_8_1_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 4: Writing Skills & Applied Grammar", 7, "Formal Letter Writing & Analytical Paragraph (Class 8)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 4: Writing Skills & Applied Grammar", "Formal Letter Writing & Analytical Paragraph (Class 8)", ch_ENG_8_1_4_7, "Letters of Complaint/Inquiry & Data Analysis");

        // Chapter: Integrated Grammar – Editing, Omission & Modals (Class 8)
        Chapter ch_ENG_8_1_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 4: Writing Skills & Applied Grammar", 8, "Integrated Grammar – Editing, Omission & Modals (Class 8)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 4: Writing Skills & Applied Grammar", "Integrated Grammar – Editing, Omission & Modals (Class 8)", ch_ENG_8_1_4_8, "Error Correction & Sentence Transformation");

        // Subject: Mathematics
        Subject sub_MATH_8_2 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Mathematics")
                .orElseGet(() -> subjectRepository.save(new Subject("Mathematics", "MATH", "📐", "#4834d4", board, classLevel)));

        // Unit: Unit 1: Rational Numbers & Linear Equations
        Unit u_MATH_8_2_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Rational Numbers & Linear Equations", 1, "Mathematics", board, classLevel)));

        // Chapter: Rational Numbers – Properties & Number Line
        Chapter ch_MATH_8_2_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 1: Rational Numbers & Linear Equations", 1, "Rational Numbers – Properties & Number Line", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 1: Rational Numbers & Linear Equations", "Rational Numbers – Properties & Number Line", ch_MATH_8_2_1_1, "Closure, Commutative, Associative & Distributive Laws");

        // Chapter: Linear Equations in One Variable
        Chapter ch_MATH_8_2_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 1: Rational Numbers & Linear Equations", 2, "Linear Equations in One Variable", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 1: Rational Numbers & Linear Equations", "Linear Equations in One Variable", ch_MATH_8_2_1_2, "Applications & Solving Equations with Variables on Both Sides");

        // Unit: Unit 2: Quadrilaterals & Data Handling
        Unit u_MATH_8_2_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Quadrilaterals & Data Handling", 2, "Mathematics", board, classLevel)));

        // Chapter: Understanding Quadrilaterals
        Chapter ch_MATH_8_2_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 2: Quadrilaterals & Data Handling", 3, "Understanding Quadrilaterals", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 2: Quadrilaterals & Data Handling", "Understanding Quadrilaterals", ch_MATH_8_2_2_3, "Angle Sum Property, Convex/Concave, Parallelograms");

        // Chapter: Data Handling & Probability
        Chapter ch_MATH_8_2_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 2: Quadrilaterals & Data Handling", 4, "Data Handling & Probability", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 2: Quadrilaterals & Data Handling", "Data Handling & Probability", ch_MATH_8_2_2_4, "Histograms, Pie Charts & Chance/Probability");

        // Unit: Unit 3: Squares, Cubes & Comparing Quantities
        Unit u_MATH_8_2_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Squares, Cubes & Comparing Quantities", 3, "Mathematics", board, classLevel)));

        // Chapter: Squares, Square Roots, Cubes & Cube Roots
        Chapter ch_MATH_8_2_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 3: Squares, Cubes & Comparing Quantities", 5, "Squares, Square Roots, Cubes & Cube Roots", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 3: Squares, Cubes & Comparing Quantities", "Squares, Square Roots, Cubes & Cube Roots", ch_MATH_8_2_3_5, "Prime Factorisation, Long Division Method & Cube Roots");

        // Chapter: Comparing Quantities – Compound Interest
        Chapter ch_MATH_8_2_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 3: Squares, Cubes & Comparing Quantities", 6, "Comparing Quantities – Compound Interest", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 3: Squares, Cubes & Comparing Quantities", "Comparing Quantities – Compound Interest", ch_MATH_8_2_3_6, "Profit/Loss, Tax, Compound Interest Formula");

        // Unit: Unit 4: Algebraic Expressions, Identities & Mensuration
        Unit u_MATH_8_2_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Algebraic Expressions, Identities & Mensuration", 4, "Mathematics", board, classLevel)));

        // Chapter: Algebraic Expressions and Identities
        Chapter ch_MATH_8_2_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 4: Algebraic Expressions, Identities & Mensuration", 7, "Algebraic Expressions and Identities", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 4: Algebraic Expressions, Identities & Mensuration", "Algebraic Expressions and Identities", ch_MATH_8_2_4_7, "Standard Identities (a+b)^2, (a-b)^2, a^2-b^2");

        // Chapter: Mensuration – Surface Area and Volume
        Chapter ch_MATH_8_2_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 4: Algebraic Expressions, Identities & Mensuration", 8, "Mensuration – Surface Area and Volume", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 4: Algebraic Expressions, Identities & Mensuration", "Mensuration – Surface Area and Volume", ch_MATH_8_2_4_8, "Area of Trapezium, Surface Area & Volume of Cylinder, Cube, Cuboid");

        // Unit: Unit 5: Exponents, Direct/Inverse Proportions & Factorisation
        Unit u_MATH_8_2_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 5: Exponents, Direct/Inverse Proportions & Factorisation", 5, "Mathematics", board, classLevel)));

        // Chapter: Exponents and Powers & Direct/Inverse Proportions
        Chapter ch_MATH_8_2_5_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 5: Exponents, Direct/Inverse Proportions & Factorisation", 9, "Exponents and Powers & Direct/Inverse Proportions", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 5: Exponents, Direct/Inverse Proportions & Factorisation", "Exponents and Powers & Direct/Inverse Proportions", ch_MATH_8_2_5_9, "Negative Exponents, Scientific Notation & Proportions");

        // Chapter: Factorisation & Introduction to Graphs
        Chapter ch_MATH_8_2_5_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 5: Exponents, Direct/Inverse Proportions & Factorisation", 10, "Factorisation & Introduction to Graphs", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 5: Exponents, Direct/Inverse Proportions & Factorisation", "Factorisation & Introduction to Graphs", ch_MATH_8_2_5_10, "Common Factors, Regrouping, Linear Graphs & Coordinates");

        // Subject: Science
        Subject sub_SCI_8_3 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Science")
                .orElseGet(() -> subjectRepository.save(new Subject("Science", "SCI", "🔬", "#eb4d4b", board, classLevel)));

        // Unit: Unit 1: Crop Production & Microorganisms
        Unit u_SCI_8_3_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Crop Production & Microorganisms", 1, "Science", board, classLevel)));

        // Chapter: Crop Production and Management
        Chapter ch_SCI_8_3_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 1: Crop Production & Microorganisms", 1, "Crop Production and Management", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 1: Crop Production & Microorganisms", "Crop Production and Management", ch_SCI_8_3_1_1, "Agricultural Practices, Kharif/Rabi Crops, Manure, Fertiliser, Irrigation");

        // Chapter: Microorganisms: Friend and Foe
        Chapter ch_SCI_8_3_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 1: Crop Production & Microorganisms", 2, "Microorganisms: Friend and Foe", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 1: Crop Production & Microorganisms", "Microorganisms: Friend and Foe", ch_SCI_8_3_1_2, "Commercial/Medicinal Uses, Vaccines, Nitrogen Fixation & Pathogens");

        // Unit: Unit 2: Coal, Petroleum & Combustion
        Unit u_SCI_8_3_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Coal, Petroleum & Combustion", 2, "Science", board, classLevel)));

        // Chapter: Coal and Petroleum – Fossil Fuels
        Chapter ch_SCI_8_3_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 2: Coal, Petroleum & Combustion", 3, "Coal and Petroleum – Fossil Fuels", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 2: Coal, Petroleum & Combustion", "Coal and Petroleum – Fossil Fuels", ch_SCI_8_3_2_3, "Carbonisation, Fractional Distillation & Petroleum Products");

        // Chapter: Combustion and Flame
        Chapter ch_SCI_8_3_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 2: Coal, Petroleum & Combustion", 4, "Combustion and Flame", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 2: Coal, Petroleum & Combustion", "Combustion and Flame", ch_SCI_8_3_2_4, "Ignition Temperature, Fire Extinguishers & Flame Zones");

        // Unit: Unit 3: Conservation & Reproduction in Animals
        Unit u_SCI_8_3_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Conservation & Reproduction in Animals", 3, "Science", board, classLevel)));

        // Chapter: Conservation of Plants and Animals
        Chapter ch_SCI_8_3_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 3: Conservation & Reproduction in Animals", 5, "Conservation of Plants and Animals", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 3: Conservation & Reproduction in Animals", "Conservation of Plants and Animals", ch_SCI_8_3_3_5, "Deforestation, Biosphere Reserves, Flora/Fauna & Red Data Book");

        // Chapter: Reproduction in Animals & Reaching Age of Adolescence
        Chapter ch_SCI_8_3_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 3: Conservation & Reproduction in Animals", 6, "Reproduction in Animals & Reaching Age of Adolescence", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 3: Conservation & Reproduction in Animals", "Reproduction in Animals & Reaching Age of Adolescence", ch_SCI_8_3_3_6, "Sexual/Asexual Reproduction, Cloning, Hormones & Target Organs");

        // Unit: Unit 4: Forces, Pressure, Friction & Sound
        Unit u_SCI_8_3_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Forces, Pressure, Friction & Sound", 4, "Science", board, classLevel)));

        // Chapter: Force and Pressure
        Chapter ch_SCI_8_3_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 4: Forces, Pressure, Friction & Sound", 7, "Force and Pressure", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 4: Forces, Pressure, Friction & Sound", "Force and Pressure", ch_SCI_8_3_4_7, "Contact/Non-contact forces, Pressure = Force/Area & Liquid Pressure");

        // Chapter: Friction – Advantages and Methods of Reduction
        Chapter ch_SCI_8_3_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 4: Forces, Pressure, Friction & Sound", 8, "Friction – Advantages and Methods of Reduction", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 4: Forces, Pressure, Friction & Sound", "Friction – Advantages and Methods of Reduction", ch_SCI_8_3_4_8, "Static, Sliding, Rolling Friction & Fluid Friction (Drag)");

        // Chapter: Sound – Propagation, Amplitude & Noise
        Chapter ch_SCI_8_3_4_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 4: Forces, Pressure, Friction & Sound", 9, "Sound – Propagation, Amplitude & Noise", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 4: Forces, Pressure, Friction & Sound", "Sound – Propagation, Amplitude & Noise", ch_SCI_8_3_4_9, "Vibrations, Audible Range (20 Hz - 20 kHz) & Ultrasound");

        // Unit: Unit 5: Chemical Effects of Current, Light & Natural Phenomena
        Unit u_SCI_8_3_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 5: Chemical Effects of Current, Light & Natural Phenomena", 5, "Science", board, classLevel)));

        // Chapter: Chemical Effects of Electric Current
        Chapter ch_SCI_8_3_5_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 5: Chemical Effects of Current, Light & Natural Phenomena", 10, "Chemical Effects of Electric Current", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 5: Chemical Effects of Current, Light & Natural Phenomena", "Chemical Effects of Electric Current", ch_SCI_8_3_5_10, "Electroplating, Electrolytes, LED Indicators");

        // Chapter: Some Natural Phenomena – Lightning & Earthquakes
        Chapter ch_SCI_8_3_5_11 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 11)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 5: Chemical Effects of Current, Light & Natural Phenomena", 11, "Some Natural Phenomena – Lightning & Earthquakes", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 5: Chemical Effects of Current, Light & Natural Phenomena", "Some Natural Phenomena – Lightning & Earthquakes", ch_SCI_8_3_5_11, "Electric Charges, Electroscope, Richter Scale & Seismograph");

        // Chapter: Light – Reflection Laws & Human Eye
        Chapter ch_SCI_8_3_5_12 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 12)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 5: Chemical Effects of Current, Light & Natural Phenomena", 12, "Light – Reflection Laws & Human Eye", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 5: Chemical Effects of Current, Light & Natural Phenomena", "Light – Reflection Laws & Human Eye", ch_SCI_8_3_5_12, "Regular/Diffused Reflection, Multiple Images, Kaleidoscopes & Eye Care");

        // Subject: Social Science
        Subject sub_SOC_8_4 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Social Science")
                .orElseGet(() -> subjectRepository.save(new Subject("Social Science", "SOC", "🌍", "#10ac84", board, classLevel)));

        // Unit: Unit 1: History – Our Pasts-III
        Unit u_SOC_8_4_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: History – Our Pasts-III", 1, "Social Science", board, classLevel)));

        // Chapter: How, When and Where & From Trade to Territory
        Chapter ch_SOC_8_4_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 1: History – Our Pasts-III", 1, "How, When and Where & From Trade to Territory", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 1: History – Our Pasts-III", "How, When and Where & From Trade to Territory", ch_SOC_8_4_1_1, "Periodisation, East India Company, Battle of Plassey 1757, Buxar & Doctrine of Lapse");

        // Chapter: Ruling the Countryside & Tribals, Dikus and the Golden Age
        Chapter ch_SOC_8_4_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 1: History – Our Pasts-III", 2, "Ruling the Countryside & Tribals, Dikus and the Golden Age", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 1: History – Our Pasts-III", "Ruling the Countryside & Tribals, Dikus and the Golden Age", ch_SOC_8_4_1_2, "Indigo Revolt, Permanent Settlement, Birsa Munda & Tribal Revolts");

        // Chapter: When People Rebel 1857 and After & Civilising the "Native"
        Chapter ch_SOC_8_4_1_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 1: History – Our Pasts-III", 3, "When People Rebel 1857 and After & Civilising the \"Native\"", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 1: History – Our Pasts-III", "When People Rebel 1857 and After & Civilising the \"Native\"", ch_SOC_8_4_1_3, "Mangal Pandey, Bahadur Shah Zafar, Queen's Proclamation, Macaulay Minute, Wood's Despatch");

        // Chapter: Women, Caste and Reform & The Making of the National Movement (1870s-1947)
        Chapter ch_SOC_8_4_1_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 1: History – Our Pasts-III", 4, "Women, Caste and Reform & The Making of the National Movement (1870s-1947)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 1: History – Our Pasts-III", "Women, Caste and Reform & The Making of the National Movement (1870s-1947)", ch_SOC_8_4_1_4, "Sati Abolition, Widow Remarriage, Jyotirao Phule, Non-Cooperation, Salt Satyagraha, Quit India");

        // Unit: Unit 2: Geography – Resources and Development
        Unit u_SOC_8_4_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Geography – Resources and Development", 2, "Social Science", board, classLevel)));

        // Chapter: Resources – Natural, Human-made and Human Resources
        Chapter ch_SOC_8_4_2_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 2: Geography – Resources and Development", 5, "Resources – Natural, Human-made and Human Resources", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 2: Geography – Resources and Development", "Resources – Natural, Human-made and Human Resources", ch_SOC_8_4_2_5, "Renewable/Non-renewable, Ubiquitous/Localised, Sustainable Development");

        // Chapter: Land, Soil, Water, Natural Vegetation and Wildlife Resources
        Chapter ch_SOC_8_4_2_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 2: Geography – Resources and Development", 6, "Land, Soil, Water, Natural Vegetation and Wildlife Resources", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 2: Geography – Resources and Development", "Land, Soil, Water, Natural Vegetation and Wildlife Resources", ch_SOC_8_4_2_6, "Soil Degradation, Multipurpose Projects, Rainwater Harvesting, CITES");

        // Chapter: Agriculture & Industries & Human Resources
        Chapter ch_SOC_8_4_2_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 2: Geography – Resources and Development", 7, "Agriculture & Industries & Human Resources", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 2: Geography – Resources and Development", "Agriculture & Industries & Human Resources", ch_SOC_8_4_2_7, "Subsistence/Commercial Farming, Iron & Steel (Jamshedpur/Pittsburgh), IT (Bengaluru/Silicon Valley), Population Pyramid");

        // Unit: Unit 3: Civics – Social and Political Life-III
        Unit u_SOC_8_4_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Civics – Social and Political Life-III", 3, "Social Science", board, classLevel)));

        // Chapter: The Indian Constitution & Understanding Secularism
        Chapter ch_SOC_8_4_3_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 3: Civics – Social and Political Life-III", 8, "The Indian Constitution & Understanding Secularism", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 3: Civics – Social and Political Life-III", "The Indian Constitution & Understanding Secularism", ch_SOC_8_4_3_8, "Federalism, Separation of Powers, Fundamental Rights, Secular State");

        // Chapter: Parliament and the Making of Laws & Judiciary
        Chapter ch_SOC_8_4_3_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 3: Civics – Social and Political Life-III", 9, "Parliament and the Making of Laws & Judiciary", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 3: Civics – Social and Political Life-III", "Parliament and the Making of Laws & Judiciary", ch_SOC_8_4_3_9, "Lok Sabha, Rajya Sabha, Role of MP, Judicial Review, Public Interest Litigation (PIL)");

        // Chapter: Understanding Marginalisation & Public Facilities / Law and Social Justice
        Chapter ch_SOC_8_4_3_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 3: Civics – Social and Political Life-III", 10, "Understanding Marginalisation & Public Facilities / Law and Social Justice", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 3: Civics – Social and Political Life-III", "Understanding Marginalisation & Public Facilities / Law and Social Justice", ch_SOC_8_4_3_10, "Adivasis, Minorities, Right to Water/Health, Bhopal Gas Tragedy & Enforcement of Labor Laws");

    }

    private void seed_CBSE_Class_9() {
        String board = "CBSE";
        int classLevel = 9;

        // Subject: English
        Subject sub_ENG_9_1 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "English")
                .orElseGet(() -> subjectRepository.save(new Subject("English", "ENG", "📚", "#fa8231", board, classLevel)));

        // Unit: Unit 1: Main Course – Inspiring Lives & Adventure
        Unit u_ENG_9_1_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Main Course – Inspiring Lives & Adventure", 1, "English", board, classLevel)));

        // Chapter: Prose Lesson 1 (Class 9 NCERT)
        Chapter ch_ENG_9_1_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 1: Main Course – Inspiring Lives & Adventure", 1, "Prose Lesson 1 (Class 9 NCERT)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 1: Main Course – Inspiring Lives & Adventure", "Prose Lesson 1 (Class 9 NCERT)", ch_ENG_9_1_1_1, "Comprehension & Vocabulary Enrichment");

        // Chapter: Poem 1 (Class 9 NCERT)
        Chapter ch_ENG_9_1_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 1: Main Course – Inspiring Lives & Adventure", 2, "Poem 1 (Class 9 NCERT)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 1: Main Course – Inspiring Lives & Adventure", "Poem 1 (Class 9 NCERT)", ch_ENG_9_1_1_2, "Rhyme Scheme & Figures of Speech");

        // Unit: Unit 2: Main Course – Nature, Science & Values
        Unit u_ENG_9_1_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Main Course – Nature, Science & Values", 2, "English", board, classLevel)));

        // Chapter: Prose Lesson 2 (Class 9 NCERT)
        Chapter ch_ENG_9_1_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 2: Main Course – Nature, Science & Values", 3, "Prose Lesson 2 (Class 9 NCERT)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 2: Main Course – Nature, Science & Values", "Prose Lesson 2 (Class 9 NCERT)", ch_ENG_9_1_2_3, "Grammar, Reported Speech & Tenses");

        // Chapter: Poem 2 (Class 9 NCERT)
        Chapter ch_ENG_9_1_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 2: Main Course – Nature, Science & Values", 4, "Poem 2 (Class 9 NCERT)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 2: Main Course – Nature, Science & Values", "Poem 2 (Class 9 NCERT)", ch_ENG_9_1_2_4, "Imagery, Theme & Poetic Devices");

        // Unit: Unit 3: Supplementary Reader – Moments & Footprints
        Unit u_ENG_9_1_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Supplementary Reader – Moments & Footprints", 3, "English", board, classLevel)));

        // Chapter: Supplementary Fiction 1 (Class 9 NCERT)
        Chapter ch_ENG_9_1_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 3: Supplementary Reader – Moments & Footprints", 5, "Supplementary Fiction 1 (Class 9 NCERT)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 3: Supplementary Reader – Moments & Footprints", "Supplementary Fiction 1 (Class 9 NCERT)", ch_ENG_9_1_3_5, "Plot Structure & Character Analysis");

        // Chapter: Supplementary Fiction 2 (Class 9 NCERT)
        Chapter ch_ENG_9_1_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 3: Supplementary Reader – Moments & Footprints", 6, "Supplementary Fiction 2 (Class 9 NCERT)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 3: Supplementary Reader – Moments & Footprints", "Supplementary Fiction 2 (Class 9 NCERT)", ch_ENG_9_1_3_6, "Conflict, Moral & Critical Thinking");

        // Unit: Unit 4: Writing Skills & Applied Grammar
        Unit u_ENG_9_1_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Writing Skills & Applied Grammar", 4, "English", board, classLevel)));

        // Chapter: Formal Letter Writing & Analytical Paragraph (Class 9)
        Chapter ch_ENG_9_1_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 4: Writing Skills & Applied Grammar", 7, "Formal Letter Writing & Analytical Paragraph (Class 9)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 4: Writing Skills & Applied Grammar", "Formal Letter Writing & Analytical Paragraph (Class 9)", ch_ENG_9_1_4_7, "Letters of Complaint/Inquiry & Data Analysis");

        // Chapter: Integrated Grammar – Editing, Omission & Modals (Class 9)
        Chapter ch_ENG_9_1_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 4: Writing Skills & Applied Grammar", 8, "Integrated Grammar – Editing, Omission & Modals (Class 9)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 4: Writing Skills & Applied Grammar", "Integrated Grammar – Editing, Omission & Modals (Class 9)", ch_ENG_9_1_4_8, "Error Correction & Sentence Transformation");

        // Subject: Mathematics
        Subject sub_MATH_9_2 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Mathematics")
                .orElseGet(() -> subjectRepository.save(new Subject("Mathematics", "MATH", "📐", "#4834d4", board, classLevel)));

        // Unit: Unit 1: Number Systems
        Unit u_MATH_9_2_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Number Systems", 1, "Mathematics", board, classLevel)));

        // Chapter: Real Numbers, Irrational Numbers & Laws of Exponents
        Chapter ch_MATH_9_2_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 1: Number Systems", 1, "Real Numbers, Irrational Numbers & Laws of Exponents", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 1: Number Systems", "Real Numbers, Irrational Numbers & Laws of Exponents", ch_MATH_9_2_1_1, "Rationalisation of Denominators & Real Number Line");

        // Unit: Unit 2: Algebra – Polynomials & Linear Equations
        Unit u_MATH_9_2_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Algebra – Polynomials & Linear Equations", 2, "Mathematics", board, classLevel)));

        // Chapter: Polynomials – Remainder & Factor Theorems
        Chapter ch_MATH_9_2_2_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 2: Algebra – Polynomials & Linear Equations", 2, "Polynomials – Remainder & Factor Theorems", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 2: Algebra – Polynomials & Linear Equations", "Polynomials – Remainder & Factor Theorems", ch_MATH_9_2_2_2, "Algebraic Identities, Zeros of Polynomials & Cubic Factorisation");

        // Chapter: Linear Equations in Two Variables
        Chapter ch_MATH_9_2_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 2: Algebra – Polynomials & Linear Equations", 3, "Linear Equations in Two Variables", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 2: Algebra – Polynomials & Linear Equations", "Linear Equations in Two Variables", ch_MATH_9_2_2_3, "Standard Form ax+by+c=0 & Graphical Solutions");

        // Unit: Unit 3: Coordinate Geometry & Euclid's Geometry
        Unit u_MATH_9_2_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Coordinate Geometry & Euclid's Geometry", 3, "Mathematics", board, classLevel)));

        // Chapter: Coordinate Geometry & Introduction to Euclid's Geometry
        Chapter ch_MATH_9_2_3_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 3: Coordinate Geometry & Euclid's Geometry", 4, "Coordinate Geometry & Introduction to Euclid's Geometry", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 3: Coordinate Geometry & Euclid's Geometry", "Coordinate Geometry & Introduction to Euclid's Geometry", ch_MATH_9_2_3_4, "Cartesian Plane, Quadrants, Axioms & Postulates");

        // Unit: Unit 4: Geometry – Lines, Triangles, Quads & Circles
        Unit u_MATH_9_2_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Geometry – Lines, Triangles, Quads & Circles", 4, "Mathematics", board, classLevel)));

        // Chapter: Lines and Angles & Triangles Congruence
        Chapter ch_MATH_9_2_4_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 4: Geometry – Lines, Triangles, Quads & Circles", 5, "Lines and Angles & Triangles Congruence", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 4: Geometry – Lines, Triangles, Quads & Circles", "Lines and Angles & Triangles Congruence", ch_MATH_9_2_4_5, "Linear Pair, Parallel Lines, SAS, ASA, AAS, SSS, RHS Congruence");

        // Chapter: Quadrilaterals & Circles
        Chapter ch_MATH_9_2_4_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 4: Geometry – Lines, Triangles, Quads & Circles", 6, "Quadrilaterals & Circles", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 4: Geometry – Lines, Triangles, Quads & Circles", "Quadrilaterals & Circles", ch_MATH_9_2_4_6, "Mid-point Theorem, Properties of Parallelograms, Cyclic Quadrilaterals");

        // Unit: Unit 5: Mensuration – Heron's Formula & Surface Areas
        Unit u_MATH_9_2_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 5: Mensuration – Heron's Formula & Surface Areas", 5, "Mathematics", board, classLevel)));

        // Chapter: Heron's Formula for Area of Triangles
        Chapter ch_MATH_9_2_5_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 5: Mensuration – Heron's Formula & Surface Areas", 7, "Heron's Formula for Area of Triangles", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 5: Mensuration – Heron's Formula & Surface Areas", "Heron's Formula for Area of Triangles", ch_MATH_9_2_5_7, "Area = sqrt(s(s-a)(s-b)(s-c))");

        // Chapter: Surface Areas and Volumes
        Chapter ch_MATH_9_2_5_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 5: Mensuration – Heron's Formula & Surface Areas", 8, "Surface Areas and Volumes", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 5: Mensuration – Heron's Formula & Surface Areas", "Surface Areas and Volumes", ch_MATH_9_2_5_8, "Sphere, Hemisphere, Right Circular Cone Surface Area & Volume");

        // Unit: Unit 6: Statistics
        Unit u_MATH_9_2_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 6: Statistics", 6, "Mathematics", board, classLevel)));

        // Chapter: Statistics – Graphical Representation of Data
        Chapter ch_MATH_9_2_6_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 6: Statistics", 9, "Statistics – Graphical Representation of Data", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 6: Statistics", "Statistics – Graphical Representation of Data", ch_MATH_9_2_6_9, "Bar Graphs, Histograms & Frequency Polygons");

        // Subject: Science
        Subject sub_SCI_9_3 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Science")
                .orElseGet(() -> subjectRepository.save(new Subject("Science", "SCI", "🔬", "#eb4d4b", board, classLevel)));

        // Unit: Unit 1: Matter in Our Surroundings & Pure Substances
        Unit u_SCI_9_3_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Matter in Our Surroundings & Pure Substances", 1, "Science", board, classLevel)));

        // Chapter: Matter in Our Surroundings
        Chapter ch_SCI_9_3_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 1: Matter in Our Surroundings & Pure Substances", 1, "Matter in Our Surroundings", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 1: Matter in Our Surroundings & Pure Substances", "Matter in Our Surroundings", ch_SCI_9_3_1_1, "States of Matter, Evaporation Factors, Latent Heat of Fusion/Vaporisation");

        // Chapter: Is Matter Around Us Pure?
        Chapter ch_SCI_9_3_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 1: Matter in Our Surroundings & Pure Substances", 2, "Is Matter Around Us Pure?", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 1: Matter in Our Surroundings & Pure Substances", "Is Matter Around Us Pure?", ch_SCI_9_3_1_2, "Homogeneous/Heterogeneous, Solutions, Colloids, Suspensions & Tyndall Effect");

        // Unit: Unit 2: Atoms, Molecules & Atomic Structure
        Unit u_SCI_9_3_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Atoms, Molecules & Atomic Structure", 2, "Science", board, classLevel)));

        // Chapter: Atoms and Molecules – Law of Conservation of Mass
        Chapter ch_SCI_9_3_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 2: Atoms, Molecules & Atomic Structure", 3, "Atoms and Molecules – Law of Conservation of Mass", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 2: Atoms, Molecules & Atomic Structure", "Atoms and Molecules – Law of Conservation of Mass", ch_SCI_9_3_2_3, "Law of Constant Proportions, Dalton Theory, Mole Concept & Valency");

        // Chapter: Structure of the Atom – Subatomic Models
        Chapter ch_SCI_9_3_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 2: Atoms, Molecules & Atomic Structure", 4, "Structure of the Atom – Subatomic Models", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 2: Atoms, Molecules & Atomic Structure", "Structure of the Atom – Subatomic Models", ch_SCI_9_3_2_4, "Thomson, Rutherford Alpha Scattering, Bohr Model, Isotopes & Isobars");

        // Unit: Unit 3: The Cell & Plant/Animal Tissues
        Unit u_SCI_9_3_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: The Cell & Plant/Animal Tissues", 3, "Science", board, classLevel)));

        // Chapter: The Fundamental Unit of Life (Cell)
        Chapter ch_SCI_9_3_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 3: The Cell & Plant/Animal Tissues", 5, "The Fundamental Unit of Life (Cell)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 3: The Cell & Plant/Animal Tissues", "The Fundamental Unit of Life (Cell)", ch_SCI_9_3_3_5, "Plasma Membrane, Osmosis, Nucleus, ER, Golgi, Mitochondria, Plastids");

        // Chapter: Tissues – Plant and Animal Tissues
        Chapter ch_SCI_9_3_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 3: The Cell & Plant/Animal Tissues", 6, "Tissues – Plant and Animal Tissues", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 3: The Cell & Plant/Animal Tissues", "Tissues – Plant and Animal Tissues", ch_SCI_9_3_3_6, "Meristematic, Parenchyma, Collenchyma, Sclerenchyma, Epithelial, Muscular, Nervous");

        // Unit: Unit 4: Motion, Force & Laws of Motion
        Unit u_SCI_9_3_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Motion, Force & Laws of Motion", 4, "Science", board, classLevel)));

        // Chapter: Motion – Velocity, Acceleration & Graphs
        Chapter ch_SCI_9_3_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 4: Motion, Force & Laws of Motion", 7, "Motion – Velocity, Acceleration & Graphs", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 4: Motion, Force & Laws of Motion", "Motion – Velocity, Acceleration & Graphs", ch_SCI_9_3_4_7, "Scalar/Vector, Uniform Acceleration Equations v=u+at, s=ut+1/2at^2");

        // Chapter: Force and Laws of Motion
        Chapter ch_SCI_9_3_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 4: Motion, Force & Laws of Motion", 8, "Force and Laws of Motion", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 4: Motion, Force & Laws of Motion", "Force and Laws of Motion", ch_SCI_9_3_4_8, "Newton's 1st, 2nd (F=ma), 3rd Law, Momentum & Conservation Law");

        // Unit: Unit 5: Gravitation, Work, Energy & Sound
        Unit u_SCI_9_3_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 5: Gravitation, Work, Energy & Sound", 5, "Science", board, classLevel)));

        // Chapter: Gravitation & Floatation
        Chapter ch_SCI_9_3_5_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 5: Gravitation, Work, Energy & Sound", 9, "Gravitation & Floatation", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 5: Gravitation, Work, Energy & Sound", "Gravitation & Floatation", ch_SCI_9_3_5_9, "Universal Law F=G(m1m2/r^2), Acceleration g=9.8m/s^2, Archimedes Principle");

        // Chapter: Work and Energy – Kinetic & Potential Energy
        Chapter ch_SCI_9_3_5_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 5: Gravitation, Work, Energy & Sound", 10, "Work and Energy – Kinetic & Potential Energy", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 5: Gravitation, Work, Energy & Sound", "Work and Energy – Kinetic & Potential Energy", ch_SCI_9_3_5_10, "Work Done W=F.s, KE=1/2mv^2, PE=mgh, Law of Conservation of Energy, Power");

        // Chapter: Sound – Wave Propagation, Echo & SONAR
        Chapter ch_SCI_9_3_5_11 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 11)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 5: Gravitation, Work, Energy & Sound", 11, "Sound – Wave Propagation, Echo & SONAR", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 5: Gravitation, Work, Energy & Sound", "Sound – Wave Propagation, Echo & SONAR", ch_SCI_9_3_5_11, "Longitudinal Waves, Frequency, Amplitude, Velocity v=lambda*f & Human Ear");

        // Chapter: Improvement in Food Resources
        Chapter ch_SCI_9_3_5_12 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 12)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 5: Gravitation, Work, Energy & Sound", 12, "Improvement in Food Resources", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 5: Gravitation, Work, Energy & Sound", "Improvement in Food Resources", ch_SCI_9_3_5_12, "Crop Variety Improvement, Nutrient Management, Manures & Animal Husbandry");

        // Subject: Social Science
        Subject sub_SOC_9_4 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Social Science")
                .orElseGet(() -> subjectRepository.save(new Subject("Social Science", "SOC", "🌍", "#10ac84", board, classLevel)));

        // Unit: Unit 1: History – India and the Contemporary World-I
        Unit u_SOC_9_4_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: History – India and the Contemporary World-I", 1, "Social Science", board, classLevel)));

        // Chapter: The French Revolution
        Chapter ch_SOC_9_4_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 1: History – India and the Contemporary World-I", 1, "The French Revolution", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 1: History – India and the Contemporary World-I", "The French Revolution", ch_SOC_9_4_1_1, "Estate System, Storming of Bastille, Jacobins, Robespierre Reign of Terror, Declaration of Rights");

        // Chapter: Socialism in Europe and the Russian Revolution
        Chapter ch_SOC_9_4_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 1: History – India and the Contemporary World-I", 2, "Socialism in Europe and the Russian Revolution", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 1: History – India and the Contemporary World-I", "Socialism in Europe and the Russian Revolution", ch_SOC_9_4_1_2, "Liberals/Radicals, Tsar Nicholas II, Bolsheviks, Vladimir Lenin, October Revolution 1917, Stalin Collectivisation");

        // Chapter: Nazism and the Rise of Hitler
        Chapter ch_SOC_9_4_1_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 1: History – India and the Contemporary World-I", 3, "Nazism and the Rise of Hitler", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 1: History – India and the Contemporary World-I", "Nazism and the Rise of Hitler", ch_SOC_9_4_1_3, "Weimar Republic, Hyperinflation, Hitler's Rise, Holocaust, Youth in Nazi Germany");

        // Unit: Unit 2: Geography – Contemporary India-I
        Unit u_SOC_9_4_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Geography – Contemporary India-I", 2, "Social Science", board, classLevel)));

        // Chapter: India – Size and Location & Physical Features of India
        Chapter ch_SOC_9_4_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 2: Geography – Contemporary India-I", 4, "India – Size and Location & Physical Features of India", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 2: Geography – Contemporary India-I", "India – Size and Location & Physical Features of India", ch_SOC_9_4_2_4, "82°30'E Standard Meridian, Northern Mountains, Northern Plains, Peninsular Plateau, Thar Desert, Coastal Plains, Islands");

        // Chapter: Drainage – Himalayan and Peninsular Rivers
        Chapter ch_SOC_9_4_2_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 2: Geography – Contemporary India-I", 5, "Drainage – Himalayan and Peninsular Rivers", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 2: Geography – Contemporary India-I", "Drainage – Himalayan and Peninsular Rivers", ch_SOC_9_4_2_5, "Indus, Ganga, Brahmaputra, Narmada, Tapi, Godavari, Krishna, Mahanadi, Kaveri");

        // Chapter: Climate & Natural Vegetation and Wildlife
        Chapter ch_SOC_9_4_2_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 2: Geography – Contemporary India-I", 6, "Climate & Natural Vegetation and Wildlife", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 2: Geography – Contemporary India-I", "Climate & Natural Vegetation and Wildlife", ch_SOC_9_4_2_6, "Monsoon Mechanism, Factors controlling climate, Tropical Evergreen, Deciduous, Mangroves");

        // Unit: Unit 3: Political Science – Democratic Politics-I
        Unit u_SOC_9_4_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Political Science – Democratic Politics-I", 3, "Social Science", board, classLevel)));

        // Chapter: What is Democracy? Why Democracy? & Constitutional Design
        Chapter ch_SOC_9_4_3_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 3: Political Science – Democratic Politics-I", 7, "What is Democracy? Why Democracy? & Constitutional Design", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 3: Political Science – Democratic Politics-I", "What is Democracy? Why Democracy? & Constitutional Design", ch_SOC_9_4_3_7, "Free & Fair Elections, Rule of Law, Nelson Mandela Apartheid, Drafting Indian Constitution");

        // Chapter: Electoral Politics & Working of Institutions
        Chapter ch_SOC_9_4_3_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 3: Political Science – Democratic Politics-I", 8, "Electoral Politics & Working of Institutions", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 3: Political Science – Democratic Politics-I", "Electoral Politics & Working of Institutions", ch_SOC_9_4_3_8, "Voter List, Universal Adult Suffrage, Model Code of Conduct, Parliament, Prime Minister & Supreme Court");

        // Chapter: Democratic Rights
        Chapter ch_SOC_9_4_3_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 3: Political Science – Democratic Politics-I", 9, "Democratic Rights", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 3: Political Science – Democratic Politics-I", "Democratic Rights", ch_SOC_9_4_3_9, "Right to Equality, Freedom, Religious Freedom, Cultural Rights, Constitutional Remedies Article 32");

        // Unit: Unit 4: Economics – Understanding Economic Development
        Unit u_SOC_9_4_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Economics – Understanding Economic Development", 4, "Social Science", board, classLevel)));

        // Chapter: The Story of Village Palampur & People as Resource
        Chapter ch_SOC_9_4_4_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 4: Economics – Understanding Economic Development", 10, "The Story of Village Palampur & People as Resource", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 4: Economics – Understanding Economic Development", "The Story of Village Palampur & People as Resource", ch_SOC_9_4_4_10, "Factors of Production (Land, Labor, Capital), Human Capital Formation, Health, Education, Unemployment Types");

        // Chapter: Poverty as a Challenge & Food Security in India
        Chapter ch_SOC_9_4_4_11 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 11)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 4: Economics – Understanding Economic Development", 11, "Poverty as a Challenge & Food Security in India", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 4: Economics – Understanding Economic Development", "Poverty as a Challenge & Food Security in India", ch_SOC_9_4_4_11, "Poverty Line, Causes, Anti-Poverty Programmes, Buffer Stock, Public Distribution System (PDS)");

    }

    private void seed_CBSE_Class_10() {
        String board = "CBSE";
        int classLevel = 10;

        // Subject: English
        Subject sub_ENG_10_1 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "English")
                .orElseGet(() -> subjectRepository.save(new Subject("English", "ENG", "📚", "#fa8231", board, classLevel)));

        // Unit: Unit 1: Main Course – Inspiring Lives & Adventure
        Unit u_ENG_10_1_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Main Course – Inspiring Lives & Adventure", 1, "English", board, classLevel)));

        // Chapter: Prose Lesson 1 (Class 10 NCERT)
        Chapter ch_ENG_10_1_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 1: Main Course – Inspiring Lives & Adventure", 1, "Prose Lesson 1 (Class 10 NCERT)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 1: Main Course – Inspiring Lives & Adventure", "Prose Lesson 1 (Class 10 NCERT)", ch_ENG_10_1_1_1, "Comprehension & Vocabulary Enrichment");

        // Chapter: Poem 1 (Class 10 NCERT)
        Chapter ch_ENG_10_1_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 1: Main Course – Inspiring Lives & Adventure", 2, "Poem 1 (Class 10 NCERT)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 1: Main Course – Inspiring Lives & Adventure", "Poem 1 (Class 10 NCERT)", ch_ENG_10_1_1_2, "Rhyme Scheme & Figures of Speech");

        // Unit: Unit 2: Main Course – Nature, Science & Values
        Unit u_ENG_10_1_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Main Course – Nature, Science & Values", 2, "English", board, classLevel)));

        // Chapter: Prose Lesson 2 (Class 10 NCERT)
        Chapter ch_ENG_10_1_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 2: Main Course – Nature, Science & Values", 3, "Prose Lesson 2 (Class 10 NCERT)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 2: Main Course – Nature, Science & Values", "Prose Lesson 2 (Class 10 NCERT)", ch_ENG_10_1_2_3, "Grammar, Reported Speech & Tenses");

        // Chapter: Poem 2 (Class 10 NCERT)
        Chapter ch_ENG_10_1_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 2: Main Course – Nature, Science & Values", 4, "Poem 2 (Class 10 NCERT)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 2: Main Course – Nature, Science & Values", "Poem 2 (Class 10 NCERT)", ch_ENG_10_1_2_4, "Imagery, Theme & Poetic Devices");

        // Unit: Unit 3: Supplementary Reader – Moments & Footprints
        Unit u_ENG_10_1_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Supplementary Reader – Moments & Footprints", 3, "English", board, classLevel)));

        // Chapter: Supplementary Fiction 1 (Class 10 NCERT)
        Chapter ch_ENG_10_1_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 3: Supplementary Reader – Moments & Footprints", 5, "Supplementary Fiction 1 (Class 10 NCERT)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 3: Supplementary Reader – Moments & Footprints", "Supplementary Fiction 1 (Class 10 NCERT)", ch_ENG_10_1_3_5, "Plot Structure & Character Analysis");

        // Chapter: Supplementary Fiction 2 (Class 10 NCERT)
        Chapter ch_ENG_10_1_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 3: Supplementary Reader – Moments & Footprints", 6, "Supplementary Fiction 2 (Class 10 NCERT)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 3: Supplementary Reader – Moments & Footprints", "Supplementary Fiction 2 (Class 10 NCERT)", ch_ENG_10_1_3_6, "Conflict, Moral & Critical Thinking");

        // Unit: Unit 4: Writing Skills & Applied Grammar
        Unit u_ENG_10_1_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Writing Skills & Applied Grammar", 4, "English", board, classLevel)));

        // Chapter: Formal Letter Writing & Analytical Paragraph (Class 10)
        Chapter ch_ENG_10_1_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 4: Writing Skills & Applied Grammar", 7, "Formal Letter Writing & Analytical Paragraph (Class 10)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 4: Writing Skills & Applied Grammar", "Formal Letter Writing & Analytical Paragraph (Class 10)", ch_ENG_10_1_4_7, "Letters of Complaint/Inquiry & Data Analysis");

        // Chapter: Integrated Grammar – Editing, Omission & Modals (Class 10)
        Chapter ch_ENG_10_1_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 4: Writing Skills & Applied Grammar", 8, "Integrated Grammar – Editing, Omission & Modals (Class 10)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 4: Writing Skills & Applied Grammar", "Integrated Grammar – Editing, Omission & Modals (Class 10)", ch_ENG_10_1_4_8, "Error Correction & Sentence Transformation");

        // Subject: Mathematics
        Subject sub_MATH_10_2 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Mathematics")
                .orElseGet(() -> subjectRepository.save(new Subject("Mathematics", "MATH", "📐", "#4834d4", board, classLevel)));

        // Unit: Unit 1: Number Systems – Real Numbers
        Unit u_MATH_10_2_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Number Systems – Real Numbers", 1, "Mathematics", board, classLevel)));

        // Chapter: Real Numbers – Fundamental Theorem of Arithmetic
        Chapter ch_MATH_10_2_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 1: Number Systems – Real Numbers", 1, "Real Numbers – Fundamental Theorem of Arithmetic", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 1: Number Systems – Real Numbers", "Real Numbers – Fundamental Theorem of Arithmetic", ch_MATH_10_2_1_1, "Irrationality Proofs (sqrt(2), sqrt(3), sqrt(5)) & Prime Factorisation");

        // Unit: Unit 2: Algebra – Polynomials & Equations
        Unit u_MATH_10_2_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Algebra – Polynomials & Equations", 2, "Mathematics", board, classLevel)));

        // Chapter: Polynomials – Zeros & Coefficients Relationship
        Chapter ch_MATH_10_2_2_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 2: Algebra – Polynomials & Equations", 2, "Polynomials – Zeros & Coefficients Relationship", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 2: Algebra – Polynomials & Equations", "Polynomials – Zeros & Coefficients Relationship", ch_MATH_10_2_2_2, "Quadratic Polynomials & Zeros sum -b/a, product c/a");

        // Chapter: Pair of Linear Equations in Two Variables
        Chapter ch_MATH_10_2_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 2: Algebra – Polynomials & Equations", 3, "Pair of Linear Equations in Two Variables", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 2: Algebra – Polynomials & Equations", "Pair of Linear Equations in Two Variables", ch_MATH_10_2_2_3, "Graphical, Substitution, Elimination & Consistency Conditions");

        // Chapter: Quadratic Equations – Nature of Roots
        Chapter ch_MATH_10_2_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 2: Algebra – Polynomials & Equations", 4, "Quadratic Equations – Nature of Roots", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 2: Algebra – Polynomials & Equations", "Quadratic Equations – Nature of Roots", ch_MATH_10_2_2_4, "Discriminant D=b^2-4ac, Quadratic Formula & Factorisation");

        // Chapter: Arithmetic Progressions (AP)
        Chapter ch_MATH_10_2_2_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 2: Algebra – Polynomials & Equations", 5, "Arithmetic Progressions (AP)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 2: Algebra – Polynomials & Equations", "Arithmetic Progressions (AP)", ch_MATH_10_2_2_5, "nth Term an = a + (n-1)d & Sum Sn = n/2[2a + (n-1)d]");

        // Unit: Unit 3: Coordinate Geometry
        Unit u_MATH_10_2_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Coordinate Geometry", 3, "Mathematics", board, classLevel)));

        // Chapter: Coordinate Geometry – Distance & Section Formula
        Chapter ch_MATH_10_2_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 3: Coordinate Geometry", 6, "Coordinate Geometry – Distance & Section Formula", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 3: Coordinate Geometry", "Coordinate Geometry – Distance & Section Formula", ch_MATH_10_2_3_6, "Distance Formula sqrt((x2-x1)^2+(y2-y1)^2), Midpoint & Section Formula");

        // Unit: Unit 4: Geometry – Triangles & Circles
        Unit u_MATH_10_2_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Geometry – Triangles & Circles", 4, "Mathematics", board, classLevel)));

        // Chapter: Triangles – Similarity Theorems
        Chapter ch_MATH_10_2_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 4: Geometry – Triangles & Circles", 7, "Triangles – Similarity Theorems", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 4: Geometry – Triangles & Circles", "Triangles – Similarity Theorems", ch_MATH_10_2_4_7, "Basic Proportionality Theorem (Thales) & AAA, SSS, SAS Criteria");

        // Chapter: Circles – Tangents from External Point
        Chapter ch_MATH_10_2_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 4: Geometry – Triangles & Circles", 8, "Circles – Tangents from External Point", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 4: Geometry – Triangles & Circles", "Circles – Tangents from External Point", ch_MATH_10_2_4_8, "Tangents perpendicular to radius & Tangents equal in length");

        // Unit: Unit 5: Trigonometry
        Unit u_MATH_10_2_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 5: Trigonometry", 5, "Mathematics", board, classLevel)));

        // Chapter: Introduction to Trigonometry & Trigonometric Identities
        Chapter ch_MATH_10_2_5_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 5: Trigonometry", 9, "Introduction to Trigonometry & Trigonometric Identities", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 5: Trigonometry", "Introduction to Trigonometry & Trigonometric Identities", ch_MATH_10_2_5_9, "Ratios of 0, 30, 45, 60, 90 deg & sin^2+cos^2=1");

        // Chapter: Some Applications of Trigonometry
        Chapter ch_MATH_10_2_5_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 5: Trigonometry", 10, "Some Applications of Trigonometry", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 5: Trigonometry", "Some Applications of Trigonometry", ch_MATH_10_2_5_10, "Heights and Distances, Angle of Elevation/Depression");

        // Unit: Unit 6: Mensuration – Areas Related to Circles & Volumes
        Unit u_MATH_10_2_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 6: Mensuration – Areas Related to Circles & Volumes", 6, "Mathematics", board, classLevel)));

        // Chapter: Areas Related to Circles
        Chapter ch_MATH_10_2_6_11 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 11)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 6: Mensuration – Areas Related to Circles & Volumes", 11, "Areas Related to Circles", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 6: Mensuration – Areas Related to Circles & Volumes", "Areas Related to Circles", ch_MATH_10_2_6_11, "Area of Sector and Segment of a Circle");

        // Chapter: Surface Areas and Volumes of Combinations
        Chapter ch_MATH_10_2_6_12 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 12)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 6: Mensuration – Areas Related to Circles & Volumes", 12, "Surface Areas and Volumes of Combinations", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 6: Mensuration – Areas Related to Circles & Volumes", "Surface Areas and Volumes of Combinations", ch_MATH_10_2_6_12, "Combinations of Cube, Cuboid, Sphere, Hemisphere, Cylinder, Cone");

        // Unit: Unit 7: Statistics and Probability
        Unit u_MATH_10_2_7 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 7).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 7: Statistics and Probability", 7, "Mathematics", board, classLevel)));

        // Chapter: Statistics – Mean, Median & Mode of Grouped Data
        Chapter ch_MATH_10_2_7_13 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 13)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 7: Statistics and Probability", 13, "Statistics – Mean, Median & Mode of Grouped Data", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 7: Statistics and Probability", "Statistics – Mean, Median & Mode of Grouped Data", ch_MATH_10_2_7_13, "Direct, Assumed Mean Method & Empirical Relation: 3 Median = Mode + 2 Mean");

        // Chapter: Probability – Classical Definition & Events
        Chapter ch_MATH_10_2_7_14 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 14)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 7: Statistics and Probability", 14, "Probability – Classical Definition & Events", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 7: Statistics and Probability", "Probability – Classical Definition & Events", ch_MATH_10_2_7_14, "P(E) = Outcomes favourable / Total outcomes, Complementary Events");

        // Subject: Science
        Subject sub_SCI_10_3 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Science")
                .orElseGet(() -> subjectRepository.save(new Subject("Science", "SCI", "🔬", "#eb4d4b", board, classLevel)));

        // Unit: Unit 1: Chemical Reactions, Acids, Bases & Metals
        Unit u_SCI_10_3_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Chemical Reactions, Acids, Bases & Metals", 1, "Science", board, classLevel)));

        // Chapter: Chemical Reactions and Equations
        Chapter ch_SCI_10_3_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 1: Chemical Reactions, Acids, Bases & Metals", 1, "Chemical Reactions and Equations", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 1: Chemical Reactions, Acids, Bases & Metals", "Chemical Reactions and Equations", ch_SCI_10_3_1_1, "Balancing Equations, Combination, Decomposition, Displacement, Redox, Corrosion, Rancidity");

        // Chapter: Acids, Bases and Salts
        Chapter ch_SCI_10_3_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 1: Chemical Reactions, Acids, Bases & Metals", 2, "Acids, Bases and Salts", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 1: Chemical Reactions, Acids, Bases & Metals", "Acids, Bases and Salts", ch_SCI_10_3_1_2, "Chemical Properties, pH in Everyday Life, Bleaching Powder, Baking Soda, Plaster of Paris");

        // Chapter: Metals and Non-metals
        Chapter ch_SCI_10_3_1_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 1: Chemical Reactions, Acids, Bases & Metals", 3, "Metals and Non-metals", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 1: Chemical Reactions, Acids, Bases & Metals", "Metals and Non-metals", ch_SCI_10_3_1_3, "Reactivity Series, Ionic Bonds, Metallurgy & Extraction of Metals");

        // Unit: Unit 2: Carbon Compounds & Life Processes
        Unit u_SCI_10_3_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Carbon Compounds & Life Processes", 2, "Science", board, classLevel)));

        // Chapter: Carbon and its Compounds
        Chapter ch_SCI_10_3_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 2: Carbon Compounds & Life Processes", 4, "Carbon and its Compounds", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 2: Carbon Compounds & Life Processes", "Carbon and its Compounds", ch_SCI_10_3_2_4, "Covalent Bonding, Versatile Nature, Homologous Series, Functional Groups, Ethanol, Ethanoic Acid");

        // Chapter: Life Processes – Nutrition, Respiration, Transport & Excretion
        Chapter ch_SCI_10_3_2_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 2: Carbon Compounds & Life Processes", 5, "Life Processes – Nutrition, Respiration, Transport & Excretion", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 2: Carbon Compounds & Life Processes", "Life Processes – Nutrition, Respiration, Transport & Excretion", ch_SCI_10_3_2_5, "Autotrophic/Heterotrophic, Aerobic/Anaerobic, Human Heart, Nephron Filtration");

        // Unit: Unit 3: Control & Coordination, Reproduction & Heredity
        Unit u_SCI_10_3_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Control & Coordination, Reproduction & Heredity", 3, "Science", board, classLevel)));

        // Chapter: Control and Coordination
        Chapter ch_SCI_10_3_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 3: Control & Coordination, Reproduction & Heredity", 6, "Control and Coordination", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 3: Control & Coordination, Reproduction & Heredity", "Control and Coordination", ch_SCI_10_3_3_6, "Neuron Structure, Reflex Arc, Brain Parts, Plant Hormones, Endocrine System");

        // Chapter: How do Organisms Reproduce?
        Chapter ch_SCI_10_3_3_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 3: Control & Coordination, Reproduction & Heredity", 7, "How do Organisms Reproduce?", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 3: Control & Coordination, Reproduction & Heredity", "How do Organisms Reproduce?", ch_SCI_10_3_3_7, "Asexual (Fission, Budding, Spores), Sexual in Flowering Plants & Humans, Contraception");

        // Chapter: Heredity and Evolution
        Chapter ch_SCI_10_3_3_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 3: Control & Coordination, Reproduction & Heredity", 8, "Heredity and Evolution", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 3: Control & Coordination, Reproduction & Heredity", "Heredity and Evolution", ch_SCI_10_3_3_8, "Mendel's Monohybrid/Dihybrid Crosses, Sex Determination in Humans (XX/XY)");

        // Unit: Unit 4: Light – Reflection, Refraction & Human Eye
        Unit u_SCI_10_3_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Light – Reflection, Refraction & Human Eye", 4, "Science", board, classLevel)));

        // Chapter: Light – Reflection and Refraction
        Chapter ch_SCI_10_3_4_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 4: Light – Reflection, Refraction & Human Eye", 9, "Light – Reflection and Refraction", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 4: Light – Reflection, Refraction & Human Eye", "Light – Reflection and Refraction", ch_SCI_10_3_4_9, "Spherical Mirrors, Mirror Formula 1/f=1/v+1/u, Snell's Law, Lens Formula, Power of Lens P=1/f");

        // Chapter: Human Eye and the Colourful World
        Chapter ch_SCI_10_3_4_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 4: Light – Reflection, Refraction & Human Eye", 10, "Human Eye and the Colourful World", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 4: Light – Reflection, Refraction & Human Eye", "Human Eye and the Colourful World", ch_SCI_10_3_4_10, "Myopia, Hypermetropia, Presbyopia, Dispersion through Prism, Atmospheric Refraction, Tyndall Effect");

        // Unit: Unit 5: Electricity, Magnetic Effects & Our Environment
        Unit u_SCI_10_3_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 5: Electricity, Magnetic Effects & Our Environment", 5, "Science", board, classLevel)));

        // Chapter: Electricity – Ohm's Law & Electric Power
        Chapter ch_SCI_10_3_5_11 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 11)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 5: Electricity, Magnetic Effects & Our Environment", 11, "Electricity – Ohm's Law & Electric Power", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 5: Electricity, Magnetic Effects & Our Environment", "Electricity – Ohm's Law & Electric Power", ch_SCI_10_3_5_11, "V=IR, Factors affecting Resistance, Series/Parallel Resistors, Joule Heating H=I^2Rt, Power P=VI");

        // Chapter: Magnetic Effects of Electric Current
        Chapter ch_SCI_10_3_5_12 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 12)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 5: Electricity, Magnetic Effects & Our Environment", 12, "Magnetic Effects of Electric Current", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 5: Electricity, Magnetic Effects & Our Environment", "Magnetic Effects of Electric Current", ch_SCI_10_3_5_12, "Magnetic Field Lines, Right Hand Thumb Rule, Solenoid, Fleming's Left Hand Rule, Domestic Circuits");

        // Chapter: Our Environment – Ecosystem & Ozone
        Chapter ch_SCI_10_3_5_13 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 13)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 5: Electricity, Magnetic Effects & Our Environment", 13, "Our Environment – Ecosystem & Ozone", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 5: Electricity, Magnetic Effects & Our Environment", "Our Environment – Ecosystem & Ozone", ch_SCI_10_3_5_13, "Trophic Levels, 10% Energy Law, Biological Magnification, Ozone Layer Depletion, Waste Management");

        // Subject: Social Science
        Subject sub_SOC_10_4 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Social Science")
                .orElseGet(() -> subjectRepository.save(new Subject("Social Science", "SOC", "🌍", "#10ac84", board, classLevel)));

        // Unit: Unit 1: History – India and the Contemporary World-II
        Unit u_SOC_10_4_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: History – India and the Contemporary World-II", 1, "Social Science", board, classLevel)));

        // Chapter: The Rise of Nationalism in Europe
        Chapter ch_SOC_10_4_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 1: History – India and the Contemporary World-II", 1, "The Rise of Nationalism in Europe", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 1: History – India and the Contemporary World-II", "The Rise of Nationalism in Europe", ch_SOC_10_4_1_1, "Frederic Sorrieu Vision, French Revolution Legacy, Mazzini, Cavour, Garibaldi, German & Italian Unification");

        // Chapter: Nationalism in India
        Chapter ch_SOC_10_4_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 1: History – India and the Contemporary World-II", 2, "Nationalism in India", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 1: History – India and the Contemporary World-II", "Nationalism in India", ch_SOC_10_4_1_2, "First World War Impact, Rowlatt Act, Jallianwala Bagh, Non-Cooperation, Civil Disobedience, Salt March, Poona Pact");

        // Chapter: The Making of a Global World & The Age of Industrialisation
        Chapter ch_SOC_10_4_1_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 1: History – India and the Contemporary World-II", 3, "The Making of a Global World & The Age of Industrialisation", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 1: History – India and the Contemporary World-II", "The Making of a Global World & The Age of Industrialisation", ch_SOC_10_4_1_3, "Silk Routes, Rinderpest, Great Depression 1929, Bretton Woods Institutions, Proto-industrialisation, Steam Power");

        // Chapter: Print Culture and the Modern World
        Chapter ch_SOC_10_4_1_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 1: History – India and the Contemporary World-II", 4, "Print Culture and the Modern World", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 1: History – India and the Contemporary World-II", "Print Culture and the Modern World", ch_SOC_10_4_1_4, "Gutenberg Press, Reformation, Print Revolution, Censorship & Vernacular Press Act");

        // Unit: Unit 2: Geography – Contemporary India-II
        Unit u_SOC_10_4_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Geography – Contemporary India-II", 2, "Social Science", board, classLevel)));

        // Chapter: Resources and Development & Forest and Wildlife Resources
        Chapter ch_SOC_10_4_2_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 2: Geography – Contemporary India-II", 5, "Resources and Development & Forest and Wildlife Resources", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 2: Geography – Contemporary India-II", "Resources and Development & Forest and Wildlife Resources", ch_SOC_10_4_2_5, "Resource Planning, Land Degradation, Sustainable Development, Sacred Groves, Project Tiger, Joint Forest Management");

        // Chapter: Water Resources & Agriculture
        Chapter ch_SOC_10_4_2_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 2: Geography – Contemporary India-II", 6, "Water Resources & Agriculture", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 2: Geography – Contemporary India-II", "Water Resources & Agriculture", ch_SOC_10_4_2_6, "Multipurpose Projects, Rainwater Harvesting, Kharif/Rabi/Zaid, Rice, Wheat, Cotton, Tea, Coffee, Bhoodan-Gramdan");

        // Chapter: Minerals, Energy Resources & Manufacturing Industries
        Chapter ch_SOC_10_4_2_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 2: Geography – Contemporary India-II", 7, "Minerals, Energy Resources & Manufacturing Industries", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 2: Geography – Contemporary India-II", "Minerals, Energy Resources & Manufacturing Industries", ch_SOC_10_4_2_7, "Metallic/Non-metallic minerals, Thermal/Hydro/Solar power, Textile, Iron-Steel, Chemical industries, Pollution Control");

        // Chapter: Lifelines of National Economy
        Chapter ch_SOC_10_4_2_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 2: Geography – Contemporary India-II", 8, "Lifelines of National Economy", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 2: Geography – Contemporary India-II", "Lifelines of National Economy", ch_SOC_10_4_2_8, "Golden Quadrilateral, Railways, Pipelines, Major Sea Ports, Air Transport & Communication");

        // Unit: Unit 3: Political Science – Democratic Politics-II
        Unit u_SOC_10_4_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Political Science – Democratic Politics-II", 3, "Social Science", board, classLevel)));

        // Chapter: Power Sharing & Federalism
        Chapter ch_SOC_10_4_3_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 3: Political Science – Democratic Politics-II", 9, "Power Sharing & Federalism", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 3: Political Science – Democratic Politics-II", "Power Sharing & Federalism", ch_SOC_10_4_3_9, "Belgium vs Sri Lanka models, Majoritarianism, Horizontal/Vertical Sharing, Union/State/Concurrent Lists, Decentralisation");

        // Chapter: Gender, Religion and Caste & Political Parties
        Chapter ch_SOC_10_4_3_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 3: Political Science – Democratic Politics-II", 10, "Gender, Religion and Caste & Political Parties", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 3: Political Science – Democratic Politics-II", "Gender, Religion and Caste & Political Parties", ch_SOC_10_4_3_10, "Feminist Movements, Secular State, Caste in Politics, National vs State Parties, Challenges to Parties & Electoral Reforms");

        // Chapter: Outcomes of Democracy
        Chapter ch_SOC_10_4_3_11 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 11)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 3: Political Science – Democratic Politics-II", 11, "Outcomes of Democracy", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 3: Political Science – Democratic Politics-II", "Outcomes of Democracy", ch_SOC_10_4_3_11, "Accountable, Responsive, Legitimate Government, Economic Growth, Reduction of Inequality & Dignity of Citizens");

        // Unit: Unit 4: Economics – Understanding Economic Development
        Unit u_SOC_10_4_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Economics – Understanding Economic Development", 4, "Social Science", board, classLevel)));

        // Chapter: Development & Sectors of the Indian Economy
        Chapter ch_SOC_10_4_4_12 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 12)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 4: Economics – Understanding Economic Development", 12, "Development & Sectors of the Indian Economy", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 4: Economics – Understanding Economic Development", "Development & Sectors of the Indian Economy", ch_SOC_10_4_4_12, "Per Capita Income, Human Development Index (HDI), Primary/Secondary/Tertiary Sectors, Disguised Unemployment, MGNREGA");

        // Chapter: Money and Credit & Globalisation and the Indian Economy
        Chapter ch_SOC_10_4_4_13 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 13)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 4: Economics – Understanding Economic Development", 13, "Money and Credit & Globalisation and the Indian Economy", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 4: Economics – Understanding Economic Development", "Money and Credit & Globalisation and the Indian Economy", ch_SOC_10_4_4_13, "Barter System, Modern Currency Forms, Formal vs Informal Credit, SHGs, MNCs, Foreign Investment, WTO Impact");

        // Chapter: Consumer Rights
        Chapter ch_SOC_10_4_4_14 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 14)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 4: Economics – Understanding Economic Development", 14, "Consumer Rights", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 4: Economics – Understanding Economic Development", "Consumer Rights", ch_SOC_10_4_4_14, "Consumer Exploitation, COPRA 1986, Right to Information (RTI), Consumer Protection Councils & Forums");

    }

    private void seed_CBSE_Class_11() {
        String board = "CBSE";
        int classLevel = 11;

        // Subject: English
        Subject sub_ENG_11_1 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "English")
                .orElseGet(() -> subjectRepository.save(new Subject("English", "ENG", "📚", "#fa8231", board, classLevel)));

        // Unit: Unit 1: Reading Comprehension & Analytical Essays
        Unit u_ENG_11_1_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Reading Comprehension & Analytical Essays", 1, "English", board, classLevel)));

        // Chapter: Unseen Passage Comprehension & Note Making (Class 11)
        Chapter ch_ENG_11_1_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 1: Reading Comprehension & Analytical Essays", 1, "Unseen Passage Comprehension & Note Making (Class 11)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 1: Reading Comprehension & Analytical Essays", "Unseen Passage Comprehension & Note Making (Class 11)", ch_ENG_11_1_1_1, "Inference, Vocabulary, Title & Sub-headings");

        // Unit: Unit 2: Advanced Writing Skills & Creative Composition
        Unit u_ENG_11_1_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Advanced Writing Skills & Creative Composition", 2, "English", board, classLevel)));

        // Chapter: Notice, Invitations, Formal Letters & Article Writing (Class 11)
        Chapter ch_ENG_11_1_2_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 2: Advanced Writing Skills & Creative Composition", 2, "Notice, Invitations, Formal Letters & Article Writing (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 2: Advanced Writing Skills & Creative Composition", "Notice, Invitations, Formal Letters & Article Writing (Class 11)", ch_ENG_11_1_2_2, "Official Correspondence, Job Applications & Editor Letters");

        // Unit: Unit 3: Literature Core Prose & Poetry
        Unit u_ENG_11_1_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Literature Core Prose & Poetry", 3, "English", board, classLevel)));

        // Chapter: Prescribed Prose Masterpieces (Class 11 NCERT)
        Chapter ch_ENG_11_1_3_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 3: Literature Core Prose & Poetry", 3, "Prescribed Prose Masterpieces (Class 11 NCERT)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 3: Literature Core Prose & Poetry", "Prescribed Prose Masterpieces (Class 11 NCERT)", ch_ENG_11_1_3_3, "Themes, Characterisation & Literary Irony");

        // Chapter: Prescribed Poetry & Poetic Devices (Class 11 NCERT)
        Chapter ch_ENG_11_1_3_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 3: Literature Core Prose & Poetry", 4, "Prescribed Poetry & Poetic Devices (Class 11 NCERT)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 3: Literature Core Prose & Poetry", "Prescribed Poetry & Poetic Devices (Class 11 NCERT)", ch_ENG_11_1_3_4, "Metaphors, Rhyme Scheme & Aesthetic Appreciation");

        // Unit: Unit 4: Supplementary Reader
        Unit u_ENG_11_1_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Supplementary Reader", 4, "English", board, classLevel)));

        // Chapter: Supplementary Masterpieces (Class 11 NCERT)
        Chapter ch_ENG_11_1_4_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 4: Supplementary Reader", 5, "Supplementary Masterpieces (Class 11 NCERT)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 4: Supplementary Reader", "Supplementary Masterpieces (Class 11 NCERT)", ch_ENG_11_1_4_5, "Plot Development, Themes & Philosophical Motifs");

        // Subject: Physics
        Subject sub_PHY_11_2 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Physics")
                .orElseGet(() -> subjectRepository.save(new Subject("Physics", "PHY", "⚡", "#3867d6", board, classLevel)));

        // Unit: Unit 1: Units, Measurements & Kinematics
        Unit u_PHY_11_2_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Physics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Units, Measurements & Kinematics", 1, "Physics", board, classLevel)));

        // Chapter: Units and Measurements
        Chapter ch_PHY_11_2_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Physics", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Physics", "Unit 1: Units, Measurements & Kinematics", 1, "Units and Measurements", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Physics", "Unit 1: Units, Measurements & Kinematics", "Units and Measurements", ch_PHY_11_2_1_1, "SI Base Units, Dimensional Analysis & Significant Figures");

        // Chapter: Motion in a Straight Line & Motion in a Plane
        Chapter ch_PHY_11_2_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Physics", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Physics", "Unit 1: Units, Measurements & Kinematics", 2, "Motion in a Straight Line & Motion in a Plane", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Physics", "Unit 1: Units, Measurements & Kinematics", "Motion in a Straight Line & Motion in a Plane", ch_PHY_11_2_1_2, "Vectors, Relative Velocity, Uniform Acceleration & Projectile Motion");

        // Unit: Unit 2: Laws of Motion, Work, Energy & Power
        Unit u_PHY_11_2_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Physics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Laws of Motion, Work, Energy & Power", 2, "Physics", board, classLevel)));

        // Chapter: Laws of Motion & Friction
        Chapter ch_PHY_11_2_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Physics", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Physics", "Unit 2: Laws of Motion, Work, Energy & Power", 3, "Laws of Motion & Friction", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Physics", "Unit 2: Laws of Motion, Work, Energy & Power", "Laws of Motion & Friction", ch_PHY_11_2_2_3, "Newton's Laws, Inertia, Momentum, Static/Kinetic Friction & Circular Dynamics");

        // Chapter: Work, Energy and Power & System of Particles
        Chapter ch_PHY_11_2_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Physics", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Physics", "Unit 2: Laws of Motion, Work, Energy & Power", 4, "Work, Energy and Power & System of Particles", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Physics", "Unit 2: Laws of Motion, Work, Energy & Power", "Work, Energy and Power & System of Particles", ch_PHY_11_2_2_4, "Work-Energy Theorem, Collisions, Center of Mass, Torque & Rotational Inertia");

        // Unit: Unit 3: Gravitation & Mechanical Properties of Matter
        Unit u_PHY_11_2_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Physics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Gravitation & Mechanical Properties of Matter", 3, "Physics", board, classLevel)));

        // Chapter: Gravitation – Kepler's Laws & Escape Speed
        Chapter ch_PHY_11_2_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Physics", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Physics", "Unit 3: Gravitation & Mechanical Properties of Matter", 5, "Gravitation – Kepler's Laws & Escape Speed", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Physics", "Unit 3: Gravitation & Mechanical Properties of Matter", "Gravitation – Kepler's Laws & Escape Speed", ch_PHY_11_2_3_5, "Universal Gravitation, Acceleration due to Gravity & Satellite Orbits");

        // Chapter: Mechanical Properties of Solids & Fluids
        Chapter ch_PHY_11_2_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Physics", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Physics", "Unit 3: Gravitation & Mechanical Properties of Matter", 6, "Mechanical Properties of Solids & Fluids", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Physics", "Unit 3: Gravitation & Mechanical Properties of Matter", "Mechanical Properties of Solids & Fluids", ch_PHY_11_2_3_6, "Hooke's Law, Young's Modulus, Pascal's Principle, Bernoulli's Equation & Viscosity");

        // Unit: Unit 4: Thermodynamics, Kinetic Theory & Oscillations
        Unit u_PHY_11_2_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Physics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Thermodynamics, Kinetic Theory & Oscillations", 4, "Physics", board, classLevel)));

        // Chapter: Thermal Properties & Thermodynamics
        Chapter ch_PHY_11_2_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Physics", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Physics", "Unit 4: Thermodynamics, Kinetic Theory & Oscillations", 7, "Thermal Properties & Thermodynamics", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Physics", "Unit 4: Thermodynamics, Kinetic Theory & Oscillations", "Thermal Properties & Thermodynamics", ch_PHY_11_2_4_7, "Specific Heat, Latent Heat, First & Second Laws of Thermodynamics");

        // Chapter: Kinetic Theory, Oscillations and Waves
        Chapter ch_PHY_11_2_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Physics", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Physics", "Unit 4: Thermodynamics, Kinetic Theory & Oscillations", 8, "Kinetic Theory, Oscillations and Waves", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Physics", "Unit 4: Thermodynamics, Kinetic Theory & Oscillations", "Kinetic Theory, Oscillations and Waves", ch_PHY_11_2_4_8, "RMS Speed, Degrees of Freedom, SHM, Simple Pendulum, Wave Equation & Doppler Effect");

        // Subject: Chemistry
        Subject sub_CHEM_11_3 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Chemistry")
                .orElseGet(() -> subjectRepository.save(new Subject("Chemistry", "CHEM", "🧪", "#8854d0", board, classLevel)));

        // Unit: Unit 1: Basic Concepts, Structure of Atom & Classification
        Unit u_CHEM_11_3_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Chemistry")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Basic Concepts, Structure of Atom & Classification", 1, "Chemistry", board, classLevel)));

        // Chapter: Some Basic Concepts of Chemistry
        Chapter ch_CHEM_11_3_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Chemistry", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Chemistry", "Unit 1: Basic Concepts, Structure of Atom & Classification", 1, "Some Basic Concepts of Chemistry", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Chemistry", "Unit 1: Basic Concepts, Structure of Atom & Classification", "Some Basic Concepts of Chemistry", ch_CHEM_11_3_1_1, "Mole Concept, Empirical Formula, Stoichiometry");

        // Chapter: Structure of Atom
        Chapter ch_CHEM_11_3_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Chemistry", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Chemistry", "Unit 1: Basic Concepts, Structure of Atom & Classification", 2, "Structure of Atom", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Chemistry", "Unit 1: Basic Concepts, Structure of Atom & Classification", "Structure of Atom", ch_CHEM_11_3_1_2, "Quantum Numbers, Orbitals, Aufbau, Pauli & Hund's Rule");

        // Chapter: Classification of Elements and Periodicity in Properties
        Chapter ch_CHEM_11_3_1_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Chemistry", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Chemistry", "Unit 1: Basic Concepts, Structure of Atom & Classification", 3, "Classification of Elements and Periodicity in Properties", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Chemistry", "Unit 1: Basic Concepts, Structure of Atom & Classification", "Classification of Elements and Periodicity in Properties", ch_CHEM_11_3_1_3, "Periodic Trends in Radii, Ionization Enthalpy & Electronegativity");

        // Unit: Unit 2: Chemical Bonding, Thermodynamics & Equilibrium
        Unit u_CHEM_11_3_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Chemistry")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Chemical Bonding, Thermodynamics & Equilibrium", 2, "Chemistry", board, classLevel)));

        // Chapter: Chemical Bonding and Molecular Structure
        Chapter ch_CHEM_11_3_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Chemistry", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Chemistry", "Unit 2: Chemical Bonding, Thermodynamics & Equilibrium", 4, "Chemical Bonding and Molecular Structure", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Chemistry", "Unit 2: Chemical Bonding, Thermodynamics & Equilibrium", "Chemical Bonding and Molecular Structure", ch_CHEM_11_3_2_4, "VSEPR Theory, Hybridisation (sp, sp2, sp3), MO Theory & Hydrogen Bond");

        // Chapter: Chemical Thermodynamics
        Chapter ch_CHEM_11_3_2_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Chemistry", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Chemistry", "Unit 2: Chemical Bonding, Thermodynamics & Equilibrium", 5, "Chemical Thermodynamics", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Chemistry", "Unit 2: Chemical Bonding, Thermodynamics & Equilibrium", "Chemical Thermodynamics", ch_CHEM_11_3_2_5, "State Functions, First Law, Enthalpy of Reactions, Hess's Law, Entropy, Gibbs Energy");

        // Chapter: Equilibrium & Redox Reactions
        Chapter ch_CHEM_11_3_2_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Chemistry", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Chemistry", "Unit 2: Chemical Bonding, Thermodynamics & Equilibrium", 6, "Equilibrium & Redox Reactions", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Chemistry", "Unit 2: Chemical Bonding, Thermodynamics & Equilibrium", "Equilibrium & Redox Reactions", ch_CHEM_11_3_2_6, "Le Chatelier Principle, pH, Buffer Solutions, Solubility Product & Oxidation Numbers");

        // Unit: Unit 3: Organic Chemistry Principles & Hydrocarbons
        Unit u_CHEM_11_3_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Chemistry")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Organic Chemistry Principles & Hydrocarbons", 3, "Chemistry", board, classLevel)));

        // Chapter: Organic Chemistry – Some Basic Principles and Techniques
        Chapter ch_CHEM_11_3_3_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Chemistry", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Chemistry", "Unit 3: Organic Chemistry Principles & Hydrocarbons", 7, "Organic Chemistry – Some Basic Principles and Techniques", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Chemistry", "Unit 3: Organic Chemistry Principles & Hydrocarbons", "Organic Chemistry – Some Basic Principles and Techniques", ch_CHEM_11_3_3_7, "IUPAC Nomenclature, Electronic Displacements, Inductive, Resonance, Hyperconjugation");

        // Chapter: Hydrocarbons
        Chapter ch_CHEM_11_3_3_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Chemistry", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Chemistry", "Unit 3: Organic Chemistry Principles & Hydrocarbons", 8, "Hydrocarbons", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Chemistry", "Unit 3: Organic Chemistry Principles & Hydrocarbons", "Hydrocarbons", ch_CHEM_11_3_3_8, "Alkanes, Alkenes, Alkynes, Benzene Aromaticity, Electrophilic Substitution");

        // Subject: Mathematics
        Subject sub_MATH_11_4 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Mathematics")
                .orElseGet(() -> subjectRepository.save(new Subject("Mathematics", "MATH", "📐", "#4834d4", board, classLevel)));

        // Unit: Unit 1: Sets, Relations, Functions & Trigonometry
        Unit u_MATH_11_4_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Sets, Relations, Functions & Trigonometry", 1, "Mathematics", board, classLevel)));

        // Chapter: Sets and Relations and Functions
        Chapter ch_MATH_11_4_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 1: Sets, Relations, Functions & Trigonometry", 1, "Sets and Relations and Functions", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 1: Sets, Relations, Functions & Trigonometry", "Sets and Relations and Functions", ch_MATH_11_4_1_1, "Cartesian Products, Injective/Surjective, Domain, Range");

        // Chapter: Trigonometric Functions
        Chapter ch_MATH_11_4_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 1: Sets, Relations, Functions & Trigonometry", 2, "Trigonometric Functions", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 1: Sets, Relations, Functions & Trigonometry", "Trigonometric Functions", ch_MATH_11_4_1_2, "Compound Angles, Multiple Angles & General Solutions");

        // Unit: Unit 2: Complex Numbers, Inequalities, Permutations & Binomial
        Unit u_MATH_11_4_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Complex Numbers, Inequalities, Permutations & Binomial", 2, "Mathematics", board, classLevel)));

        // Chapter: Complex Numbers, Quadratic Equations & Linear Inequalities
        Chapter ch_MATH_11_4_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 2: Complex Numbers, Inequalities, Permutations & Binomial", 3, "Complex Numbers, Quadratic Equations & Linear Inequalities", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 2: Complex Numbers, Inequalities, Permutations & Binomial", "Complex Numbers, Quadratic Equations & Linear Inequalities", ch_MATH_11_4_2_3, "Argand Plane, Modulus, Conjugate & Graphical Inequalities");

        // Chapter: Permutations, Combinations & Binomial Theorem
        Chapter ch_MATH_11_4_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 2: Complex Numbers, Inequalities, Permutations & Binomial", 4, "Permutations, Combinations & Binomial Theorem", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 2: Complex Numbers, Inequalities, Permutations & Binomial", "Permutations, Combinations & Binomial Theorem", ch_MATH_11_4_2_4, "Fundamental Principle of Counting, nPr, nCr & General Term Expansion");

        // Chapter: Sequences and Series (AP, GP)
        Chapter ch_MATH_11_4_2_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 2: Complex Numbers, Inequalities, Permutations & Binomial", 5, "Sequences and Series (AP, GP)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 2: Complex Numbers, Inequalities, Permutations & Binomial", "Sequences and Series (AP, GP)", ch_MATH_11_4_2_5, "Arithmetic Mean, Geometric Mean & Infinite GP Sum");

        // Unit: Unit 3: Coordinate Geometry & 3D Geometry
        Unit u_MATH_11_4_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Coordinate Geometry & 3D Geometry", 3, "Mathematics", board, classLevel)));

        // Chapter: Straight Lines & Conic Sections
        Chapter ch_MATH_11_4_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 3: Coordinate Geometry & 3D Geometry", 6, "Straight Lines & Conic Sections", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 3: Coordinate Geometry & 3D Geometry", "Straight Lines & Conic Sections", ch_MATH_11_4_3_6, "Slope, Normal Form, Parabola, Ellipse, Hyperbola Standard Equations");

        // Chapter: Introduction to Three Dimensional Geometry
        Chapter ch_MATH_11_4_3_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 3: Coordinate Geometry & 3D Geometry", 7, "Introduction to Three Dimensional Geometry", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 3: Coordinate Geometry & 3D Geometry", "Introduction to Three Dimensional Geometry", ch_MATH_11_4_3_7, "Coordinates in 3D, Distance Formula, Section Formula in Space");

        // Unit: Unit 4: Calculus, Statistics & Probability
        Unit u_MATH_11_4_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Calculus, Statistics & Probability", 4, "Mathematics", board, classLevel)));

        // Chapter: Limits and Derivatives
        Chapter ch_MATH_11_4_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 4: Calculus, Statistics & Probability", 8, "Limits and Derivatives", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 4: Calculus, Statistics & Probability", "Limits and Derivatives", ch_MATH_11_4_4_8, "Standard Limits, First Principle Differentiation & Derivative Rules");

        // Chapter: Statistics and Probability
        Chapter ch_MATH_11_4_4_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 4: Calculus, Statistics & Probability", 9, "Statistics and Probability", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 4: Calculus, Statistics & Probability", "Statistics and Probability", ch_MATH_11_4_4_9, "Mean Deviation, Variance, Standard Deviation & Axiomatic Probability");

        // Subject: Biology
        Subject sub_BIO_11_5 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Biology")
                .orElseGet(() -> subjectRepository.save(new Subject("Biology", "BIO", "🧬", "#20bf6b", board, classLevel)));

        // Unit: Unit 1: Diversity & Structural Organisation in Organisms
        Unit u_BIO_11_5_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Biology")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Diversity & Structural Organisation in Organisms", 1, "Biology", board, classLevel)));

        // Chapter: Biological Classification & Plant/Animal Kingdom (Class 11)
        Chapter ch_BIO_11_5_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Biology", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Biology", "Unit 1: Diversity & Structural Organisation in Organisms", 1, "Biological Classification & Plant/Animal Kingdom (Class 11)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Biology", "Unit 1: Diversity & Structural Organisation in Organisms", "Biological Classification & Plant/Animal Kingdom (Class 11)", ch_BIO_11_5_1_1, "Five Kingdom Classification, Gymnosperms, Angiosperms & Chordates");

        // Chapter: Morphology & Anatomy of Flowering Plants (Class 11)
        Chapter ch_BIO_11_5_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Biology", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Biology", "Unit 1: Diversity & Structural Organisation in Organisms", 2, "Morphology & Anatomy of Flowering Plants (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Biology", "Unit 1: Diversity & Structural Organisation in Organisms", "Morphology & Anatomy of Flowering Plants (Class 11)", ch_BIO_11_5_1_2, "Root, Stem, Leaf modifications, Tissues & Secondary Growth");

        // Unit: Unit 2: Cell Biology, Biomolecules & Human Physiology
        Unit u_BIO_11_5_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Biology")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Cell Biology, Biomolecules & Human Physiology", 2, "Biology", board, classLevel)));

        // Chapter: Cell Cycle, Mitosis, Meiosis & Biomolecules (Class 11)
        Chapter ch_BIO_11_5_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Biology", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Biology", "Unit 2: Cell Biology, Biomolecules & Human Physiology", 3, "Cell Cycle, Mitosis, Meiosis & Biomolecules (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Biology", "Unit 2: Cell Biology, Biomolecules & Human Physiology", "Cell Cycle, Mitosis, Meiosis & Biomolecules (Class 11)", ch_BIO_11_5_2_3, "Chromosomes, Enzymes, Activation Energy & Cell Division Stages");

        // Chapter: Human Respiration, Circulation & Neural Control (Class 11)
        Chapter ch_BIO_11_5_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Biology", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Biology", "Unit 2: Cell Biology, Biomolecules & Human Physiology", 4, "Human Respiration, Circulation & Neural Control (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Biology", "Unit 2: Cell Biology, Biomolecules & Human Physiology", "Human Respiration, Circulation & Neural Control (Class 11)", ch_BIO_11_5_2_4, "Gas Exchange, ECG, Cardiac Cycle, Action Potential & Synapse");

        // Unit: Unit 3: Genetics, Evolution, Biotechnology & Ecology
        Unit u_BIO_11_5_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Biology")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Genetics, Evolution, Biotechnology & Ecology", 3, "Biology", board, classLevel)));

        // Chapter: Mendelian Genetics, DNA Replication & Human Evolution (Class 11)
        Chapter ch_BIO_11_5_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Biology", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Biology", "Unit 3: Genetics, Evolution, Biotechnology & Ecology", 5, "Mendelian Genetics, DNA Replication & Human Evolution (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Biology", "Unit 3: Genetics, Evolution, Biotechnology & Ecology", "Mendelian Genetics, DNA Replication & Human Evolution (Class 11)", ch_BIO_11_5_3_5, "Pedigree Analysis, Lac Operon, Genetic Code & Hardy-Weinberg Equilibrium");

        // Chapter: Biotechnology Principles, Applications & Ecosystems (Class 11)
        Chapter ch_BIO_11_5_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Biology", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Biology", "Unit 3: Genetics, Evolution, Biotechnology & Ecology", 6, "Biotechnology Principles, Applications & Ecosystems (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Biology", "Unit 3: Genetics, Evolution, Biotechnology & Ecology", "Biotechnology Principles, Applications & Ecosystems (Class 11)", ch_BIO_11_5_3_6, "Restriction Enzymes, Gel Electrophoresis, Bt Crops, Bioreactors & Nutrient Cycling");

        // Subject: Computer Science
        Subject sub_CS_11_6 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Computer Science")
                .orElseGet(() -> subjectRepository.save(new Subject("Computer Science", "CS", "💻", "#2d98da", board, classLevel)));

        // Unit: Unit 1: Computational Thinking and Programming (Python)
        Unit u_CS_11_6_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Computer Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Computational Thinking and Programming (Python)", 1, "Computer Science", board, classLevel)));

        // Chapter: Python Syntax, Flow Control, Functions & Recursion (Class 11)
        Chapter ch_CS_11_6_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Computer Science", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Computer Science", "Unit 1: Computational Thinking and Programming (Python)", 1, "Python Syntax, Flow Control, Functions & Recursion (Class 11)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Computer Science", "Unit 1: Computational Thinking and Programming (Python)", "Python Syntax, Flow Control, Functions & Recursion (Class 11)", ch_CS_11_6_1_1, "Mutable vs Immutable, Scope, Default Parameters, Modules");

        // Chapter: File Handling, Text, Binary & CSV Files in Python (Class 11)
        Chapter ch_CS_11_6_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Computer Science", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Computer Science", "Unit 1: Computational Thinking and Programming (Python)", 2, "File Handling, Text, Binary & CSV Files in Python (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Computer Science", "Unit 1: Computational Thinking and Programming (Python)", "File Handling, Text, Binary & CSV Files in Python (Class 11)", ch_CS_11_6_1_2, "open(), read(), write(), pickle module, csv.reader/writer");

        // Chapter: Data Structures – Stack Implementation (Class 11)
        Chapter ch_CS_11_6_1_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Computer Science", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Computer Science", "Unit 1: Computational Thinking and Programming (Python)", 3, "Data Structures – Stack Implementation (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Computer Science", "Unit 1: Computational Thinking and Programming (Python)", "Data Structures – Stack Implementation (Class 11)", ch_CS_11_6_1_3, "LIFO, Push, Pop, Peak using Python Lists");

        // Unit: Unit 2: Computer Networks & Database Management (SQL)
        Unit u_CS_11_6_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Computer Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Computer Networks & Database Management (SQL)", 2, "Computer Science", board, classLevel)));

        // Chapter: Computer Networks – Topologies, Protocols & Network Devices (Class 11)
        Chapter ch_CS_11_6_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Computer Science", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Computer Science", "Unit 2: Computer Networks & Database Management (SQL)", 4, "Computer Networks – Topologies, Protocols & Network Devices (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Computer Science", "Unit 2: Computer Networks & Database Management (SQL)", "Computer Networks – Topologies, Protocols & Network Devices (Class 11)", ch_CS_11_6_2_4, "LAN/WAN, TCP/IP, DNS, HTTP/HTTPS, Router, Switch, Gateway");

        // Chapter: Relational Database Concepts, SQL Queries & Python-SQL Connectivity (Class 11)
        Chapter ch_CS_11_6_2_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Computer Science", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Computer Science", "Unit 2: Computer Networks & Database Management (SQL)", 5, "Relational Database Concepts, SQL Queries & Python-SQL Connectivity (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Computer Science", "Unit 2: Computer Networks & Database Management (SQL)", "Relational Database Concepts, SQL Queries & Python-SQL Connectivity (Class 11)", ch_CS_11_6_2_5, "Aggregate Functions, GROUP BY, HAVING, ORDER BY, Joins & mysql.connector");

        // Chapter: Societal Impacts, Cyber Crime & Cyber Ethics (Class 11)
        Chapter ch_CS_11_6_2_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Computer Science", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Computer Science", "Unit 2: Computer Networks & Database Management (SQL)", 6, "Societal Impacts, Cyber Crime & Cyber Ethics (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Computer Science", "Unit 2: Computer Networks & Database Management (SQL)", "Societal Impacts, Cyber Crime & Cyber Ethics (Class 11)", ch_CS_11_6_2_6, "Digital Footprint, Phishing, Ransomware, IT Act & Intellectual Property");

        // Subject: Informatics Practices
        Subject sub_IP_11_7 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Informatics Practices")
                .orElseGet(() -> subjectRepository.save(new Subject("Informatics Practices", "IP", "💻", "#3867d6", board, classLevel)));

        // Unit: Unit 1: Data Handling using Pandas and Matplotlib
        Unit u_IP_11_7_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Informatics Practices")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Data Handling using Pandas and Matplotlib", 1, "Informatics Practices", board, classLevel)));

        // Chapter: Python Pandas – Series, DataFrames & Data Analysis (Class 11)
        Chapter ch_IP_11_7_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Informatics Practices", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Informatics Practices", "Unit 1: Data Handling using Pandas and Matplotlib", 1, "Python Pandas – Series, DataFrames & Data Analysis (Class 11)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Informatics Practices", "Unit 1: Data Handling using Pandas and Matplotlib", "Python Pandas – Series, DataFrames & Data Analysis (Class 11)", ch_IP_11_7_1_1, "Creation, Slicing, Filtering, loc, iloc, Sorting & Aggregation");

        // Chapter: Data Visualisation using Pyplot (Class 11)
        Chapter ch_IP_11_7_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Informatics Practices", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Informatics Practices", "Unit 1: Data Handling using Pandas and Matplotlib", 2, "Data Visualisation using Pyplot (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Informatics Practices", "Unit 1: Data Handling using Pandas and Matplotlib", "Data Visualisation using Pyplot (Class 11)", ch_IP_11_7_1_2, "Line plots, Bar charts, Histograms, Customization & Legends");

        // Unit: Unit 2: Database Query using SQL & Societal Impacts
        Unit u_IP_11_7_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Informatics Practices")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Database Query using SQL & Societal Impacts", 2, "Informatics Practices", board, classLevel)));

        // Chapter: Advanced SQL Functions & Table Joins (Class 11)
        Chapter ch_IP_11_7_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Informatics Practices", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Informatics Practices", "Unit 2: Database Query using SQL & Societal Impacts", 3, "Advanced SQL Functions & Table Joins (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Informatics Practices", "Unit 2: Database Query using SQL & Societal Impacts", "Advanced SQL Functions & Table Joins (Class 11)", ch_IP_11_7_2_3, "Math, String, Date Functions, Group By & Natural Join");

        // Chapter: Emerging Trends, E-Waste Management & Cyber Law (Class 11)
        Chapter ch_IP_11_7_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Informatics Practices", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Informatics Practices", "Unit 2: Database Query using SQL & Societal Impacts", 4, "Emerging Trends, E-Waste Management & Cyber Law (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Informatics Practices", "Unit 2: Database Query using SQL & Societal Impacts", "Emerging Trends, E-Waste Management & Cyber Law (Class 11)", ch_IP_11_7_2_4, "AI, IoT, Cloud, E-Waste Recycling, Net Etiquettes & Data Privacy");

        // Subject: Accountancy
        Subject sub_ACC_11_8 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Accountancy")
                .orElseGet(() -> subjectRepository.save(new Subject("Accountancy", "ACC", "📋", "#2bcbba", board, classLevel)));

        // Unit: Unit 1: Financial Accounting – Principles & Final Accounts
        Unit u_ACC_11_8_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Accountancy")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Financial Accounting – Principles & Final Accounts", 1, "Accountancy", board, classLevel)));

        // Chapter: Theoretical Framework, Accounting Standards & GST (Class 11)
        Chapter ch_ACC_11_8_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Accountancy", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Accountancy", "Unit 1: Financial Accounting – Principles & Final Accounts", 1, "Theoretical Framework, Accounting Standards & GST (Class 11)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Accountancy", "Unit 1: Financial Accounting – Principles & Final Accounts", "Theoretical Framework, Accounting Standards & GST (Class 11)", ch_ACC_11_8_1_1, "Accrual Concept, Matching Principle, Dual Aspect & CGST/SGST/IGST");

        // Chapter: Recording Transactions, BRS, Depreciation & Trial Balance (Class 11)
        Chapter ch_ACC_11_8_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Accountancy", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Accountancy", "Unit 1: Financial Accounting – Principles & Final Accounts", 2, "Recording Transactions, BRS, Depreciation & Trial Balance (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Accountancy", "Unit 1: Financial Accounting – Principles & Final Accounts", "Recording Transactions, BRS, Depreciation & Trial Balance (Class 11)", ch_ACC_11_8_1_2, "Cash Book, Journal, Bank Reconciliation, SLM vs WDV Depreciation");

        // Unit: Unit 2: Accounting for Partnership Firms & Companies
        Unit u_ACC_11_8_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Accountancy")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Accounting for Partnership Firms & Companies", 2, "Accountancy", board, classLevel)));

        // Chapter: Partnership Fundamentals, Goodwill, Admission & Dissolution (Class 11)
        Chapter ch_ACC_11_8_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Accountancy", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Accountancy", "Unit 2: Accounting for Partnership Firms & Companies", 3, "Partnership Fundamentals, Goodwill, Admission & Dissolution (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Accountancy", "Unit 2: Accounting for Partnership Firms & Companies", "Partnership Fundamentals, Goodwill, Admission & Dissolution (Class 11)", ch_ACC_11_8_2_3, "P&L Appropriation, Fluctuating/Fixed Capital, Revaluation & Realisation Account");

        // Chapter: Accounting for Share Capital & Issue of Debentures (Class 11)
        Chapter ch_ACC_11_8_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Accountancy", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Accountancy", "Unit 2: Accounting for Partnership Firms & Companies", 4, "Accounting for Share Capital & Issue of Debentures (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Accountancy", "Unit 2: Accounting for Partnership Firms & Companies", "Accounting for Share Capital & Issue of Debentures (Class 11)", ch_ACC_11_8_2_4, "Calls in Arrears, Forfeiture, Reissue, Pro-rata Allotment & Debenture Redemption");

        // Unit: Unit 3: Financial Statement Analysis & Cash Flow
        Unit u_ACC_11_8_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Accountancy")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Financial Statement Analysis & Cash Flow", 3, "Accountancy", board, classLevel)));

        // Chapter: Comparative Statements, Common Size & Accounting Ratios (Class 11)
        Chapter ch_ACC_11_8_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Accountancy", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Accountancy", "Unit 3: Financial Statement Analysis & Cash Flow", 5, "Comparative Statements, Common Size & Accounting Ratios (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Accountancy", "Unit 3: Financial Statement Analysis & Cash Flow", "Comparative Statements, Common Size & Accounting Ratios (Class 11)", ch_ACC_11_8_3_5, "Liquidity, Solvency, Activity & Profitability Ratios");

        // Chapter: Cash Flow Statement (AS-3 Revised) (Class 11)
        Chapter ch_ACC_11_8_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Accountancy", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Accountancy", "Unit 3: Financial Statement Analysis & Cash Flow", 6, "Cash Flow Statement (AS-3 Revised) (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Accountancy", "Unit 3: Financial Statement Analysis & Cash Flow", "Cash Flow Statement (AS-3 Revised) (Class 11)", ch_ACC_11_8_3_6, "Operating, Investing & Financing Activities");

        // Subject: Business Studies
        Subject sub_BST_11_9 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Business Studies")
                .orElseGet(() -> subjectRepository.save(new Subject("Business Studies", "BST", "💼", "#ff9f43", board, classLevel)));

        // Unit: Unit 1: Foundations of Business & Principles of Management
        Unit u_BST_11_9_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Business Studies")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Foundations of Business & Principles of Management", 1, "Business Studies", board, classLevel)));

        // Chapter: Nature and Purpose of Business & Forms of Organisation (Class 11)
        Chapter ch_BST_11_9_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Business Studies", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Business Studies", "Unit 1: Foundations of Business & Principles of Management", 1, "Nature and Purpose of Business & Forms of Organisation (Class 11)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Business Studies", "Unit 1: Foundations of Business & Principles of Management", "Nature and Purpose of Business & Forms of Organisation (Class 11)", ch_BST_11_9_1_1, "Business vs Profession, Sole Proprietorship, Partnership, Company Incorporation");

        // Chapter: Principles and Functions of Management (Class 11)
        Chapter ch_BST_11_9_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Business Studies", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Business Studies", "Unit 1: Foundations of Business & Principles of Management", 2, "Principles and Functions of Management (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Business Studies", "Unit 1: Foundations of Business & Principles of Management", "Principles and Functions of Management (Class 11)", ch_BST_11_9_1_2, "Fayol's Principles, Taylor's Scientific Management, Planning & Organising");

        // Unit: Unit 2: Corporate Finance, Marketing & Consumer Protection
        Unit u_BST_11_9_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Business Studies")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Corporate Finance, Marketing & Consumer Protection", 2, "Business Studies", board, classLevel)));

        // Chapter: Financial Management, Financial Markets & Sources of Finance (Class 11)
        Chapter ch_BST_11_9_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Business Studies", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Business Studies", "Unit 2: Corporate Finance, Marketing & Consumer Protection", 3, "Financial Management, Financial Markets & Sources of Finance (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Business Studies", "Unit 2: Corporate Finance, Marketing & Consumer Protection", "Financial Management, Financial Markets & Sources of Finance (Class 11)", ch_BST_11_9_2_3, "Capital Structure, Working Capital, Money Market, Capital Market & SEBI");

        // Chapter: Marketing Management, 4Ps & Consumer Protection Act 2019 (Class 11)
        Chapter ch_BST_11_9_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Business Studies", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Business Studies", "Unit 2: Corporate Finance, Marketing & Consumer Protection", 4, "Marketing Management, 4Ps & Consumer Protection Act 2019 (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Business Studies", "Unit 2: Corporate Finance, Marketing & Consumer Protection", "Marketing Management, 4Ps & Consumer Protection Act 2019 (Class 11)", ch_BST_11_9_2_4, "Product, Price, Place, Promotion, Consumer Rights & Three-Tier Redressal");

        // Subject: Economics
        Subject sub_ECO_11_10 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Economics")
                .orElseGet(() -> subjectRepository.save(new Subject("Economics", "ECO", "📈", "#ee5253", board, classLevel)));

        // Unit: Unit 1: Microeconomics & Introductory Macroeconomics
        Unit u_ECO_11_10_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Economics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Microeconomics & Introductory Macroeconomics", 1, "Economics", board, classLevel)));

        // Chapter: Consumer Equilibrium, Demand, Cost & Revenue (Class 11)
        Chapter ch_ECO_11_10_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Economics", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Economics", "Unit 1: Microeconomics & Introductory Macroeconomics", 1, "Consumer Equilibrium, Demand, Cost & Revenue (Class 11)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Economics", "Unit 1: Microeconomics & Introductory Macroeconomics", "Consumer Equilibrium, Demand, Cost & Revenue (Class 11)", ch_ECO_11_10_1_1, "Marginal Utility, Law of Demand, Elasticity & Production Function");

        // Chapter: National Income Accounting, Money and Banking (Class 11)
        Chapter ch_ECO_11_10_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Economics", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Economics", "Unit 1: Microeconomics & Introductory Macroeconomics", 2, "National Income Accounting, Money and Banking (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Economics", "Unit 1: Microeconomics & Introductory Macroeconomics", "National Income Accounting, Money and Banking (Class 11)", ch_ECO_11_10_1_2, "GDP, GNP, Real/Nominal GDP, Money Creation, Central Bank Functions");

        // Unit: Unit 2: Government Budget & Indian Economic Development
        Unit u_ECO_11_10_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Economics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Government Budget & Indian Economic Development", 2, "Economics", board, classLevel)));

        // Chapter: Determination of Income, Government Budget & Balance of Payments (Class 11)
        Chapter ch_ECO_11_10_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Economics", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Economics", "Unit 2: Government Budget & Indian Economic Development", 3, "Determination of Income, Government Budget & Balance of Payments (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Economics", "Unit 2: Government Budget & Indian Economic Development", "Determination of Income, Government Budget & Balance of Payments (Class 11)", ch_ECO_11_10_2_3, "Aggregate Demand, Multiplier, Fiscal Deficit, Foreign Exchange Rates");

        // Chapter: Indian Economy on Eve of Independence & Economic Reforms 1991 (Class 11)
        Chapter ch_ECO_11_10_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Economics", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Economics", "Unit 2: Government Budget & Indian Economic Development", 4, "Indian Economy on Eve of Independence & Economic Reforms 1991 (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Economics", "Unit 2: Government Budget & Indian Economic Development", "Indian Economy on Eve of Independence & Economic Reforms 1991 (Class 11)", ch_ECO_11_10_2_4, "LPG Policies, Rural Development, Human Capital, Sustainable Development");

        // Subject: History
        Subject sub_HIST_11_11 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "History")
                .orElseGet(() -> subjectRepository.save(new Subject("History", "HIST", "🏛️", "#5f27cd", board, classLevel)));

        // Unit: Unit 1: Themes in Indian History – Part I (Ancient)
        Unit u_HIST_11_11_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "History")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Themes in Indian History – Part I (Ancient)", 1, "History", board, classLevel)));

        // Chapter: Bricks, Beads and Bones (The Harappan Civilisation) (Class 11)
        Chapter ch_HIST_11_11_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "History", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("History", "Unit 1: Themes in Indian History – Part I (Ancient)", 1, "Bricks, Beads and Bones (The Harappan Civilisation) (Class 11)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "History", "Unit 1: Themes in Indian History – Part I (Ancient)", "Bricks, Beads and Bones (The Harappan Civilisation) (Class 11)", ch_HIST_11_11_1_1, "Town Planning, Citadel, Great Bath, Seals, Script & Craft Production");

        // Chapter: Kings, Farmers and Towns & Kinship, Caste and Class (Class 11)
        Chapter ch_HIST_11_11_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "History", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("History", "Unit 1: Themes in Indian History – Part I (Ancient)", 2, "Kings, Farmers and Towns & Kinship, Caste and Class (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "History", "Unit 1: Themes in Indian History – Part I (Ancient)", "Kings, Farmers and Towns & Kinship, Caste and Class (Class 11)", ch_HIST_11_11_1_2, "Early States, 16 Mahajanapadas, Mauryan Empire, Mahabharata Social Patterns");

        // Chapter: Thinkers, Beliefs and Buildings (Cultural Developments) (Class 11)
        Chapter ch_HIST_11_11_1_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "History", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("History", "Unit 1: Themes in Indian History – Part I (Ancient)", 3, "Thinkers, Beliefs and Buildings (Cultural Developments) (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "History", "Unit 1: Themes in Indian History – Part I (Ancient)", "Thinkers, Beliefs and Buildings (Cultural Developments) (Class 11)", ch_HIST_11_11_1_3, "Vedic Traditions, Sanchi Stupa, Jainism, Buddhism & Temple Architecture");

        // Unit: Unit 2: Themes in Indian History – Part II & III (Medieval & Modern)
        Unit u_HIST_11_11_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "History")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Themes in Indian History – Part II & III (Medieval & Modern)", 2, "History", board, classLevel)));

        // Chapter: Through the Eyes of Travellers & Bhakti-Sufi Traditions (Class 11)
        Chapter ch_HIST_11_11_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "History", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("History", "Unit 2: Themes in Indian History – Part II & III (Medieval & Modern)", 4, "Through the Eyes of Travellers & Bhakti-Sufi Traditions (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "History", "Unit 2: Themes in Indian History – Part II & III (Medieval & Modern)", "Through the Eyes of Travellers & Bhakti-Sufi Traditions (Class 11)", ch_HIST_11_11_2_4, "Al-Biruni, Ibn Battuta, Francois Bernier, Kabir, Mirabai, Sufi Silsilas");

        // Chapter: An Imperial Capital: Vijayanagara & Peasants, Zamindars and State (Class 11)
        Chapter ch_HIST_11_11_2_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "History", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("History", "Unit 2: Themes in Indian History – Part II & III (Medieval & Modern)", 5, "An Imperial Capital: Vijayanagara & Peasants, Zamindars and State (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "History", "Unit 2: Themes in Indian History – Part II & III (Medieval & Modern)", "An Imperial Capital: Vijayanagara & Peasants, Zamindars and State (Class 11)", ch_HIST_11_11_2_5, "Hampi, Mahanavami Dibba, Ain-i-Akbari, Mughal Agrarian Relations");

        // Chapter: Colonialism, 1857 Revolt & Mahatma Gandhi and Nationalist Movement (Class 11)
        Chapter ch_HIST_11_11_2_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "History", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("History", "Unit 2: Themes in Indian History – Part II & III (Medieval & Modern)", 6, "Colonialism, 1857 Revolt & Mahatma Gandhi and Nationalist Movement (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "History", "Unit 2: Themes in Indian History – Part II & III (Medieval & Modern)", "Colonialism, 1857 Revolt & Mahatma Gandhi and Nationalist Movement (Class 11)", ch_HIST_11_11_2_6, "Santhal Rebellion, 1857 Revolt, Non-Cooperation, Salt March, Quit India & Partition");

        // Chapter: Framing the Constitution (The Beginning of a New Era) (Class 11)
        Chapter ch_HIST_11_11_2_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "History", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("History", "Unit 2: Themes in Indian History – Part II & III (Medieval & Modern)", 7, "Framing the Constitution (The Beginning of a New Era) (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "History", "Unit 2: Themes in Indian History – Part II & III (Medieval & Modern)", "Framing the Constitution (The Beginning of a New Era) (Class 11)", ch_HIST_11_11_2_7, "Constituent Assembly Debates, Drafting Committee & Preamble Objectives");

    }

    private void seed_CBSE_Class_12() {
        String board = "CBSE";
        int classLevel = 12;

        // Subject: English
        Subject sub_ENG_12_1 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "English")
                .orElseGet(() -> subjectRepository.save(new Subject("English", "ENG", "📚", "#fa8231", board, classLevel)));

        // Unit: Unit 1: Reading Comprehension & Analytical Essays
        Unit u_ENG_12_1_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Reading Comprehension & Analytical Essays", 1, "English", board, classLevel)));

        // Chapter: Unseen Passage Comprehension & Note Making (Class 12)
        Chapter ch_ENG_12_1_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 1: Reading Comprehension & Analytical Essays", 1, "Unseen Passage Comprehension & Note Making (Class 12)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 1: Reading Comprehension & Analytical Essays", "Unseen Passage Comprehension & Note Making (Class 12)", ch_ENG_12_1_1_1, "Inference, Vocabulary, Title & Sub-headings");

        // Unit: Unit 2: Advanced Writing Skills & Creative Composition
        Unit u_ENG_12_1_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Advanced Writing Skills & Creative Composition", 2, "English", board, classLevel)));

        // Chapter: Notice, Invitations, Formal Letters & Article Writing (Class 12)
        Chapter ch_ENG_12_1_2_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 2: Advanced Writing Skills & Creative Composition", 2, "Notice, Invitations, Formal Letters & Article Writing (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 2: Advanced Writing Skills & Creative Composition", "Notice, Invitations, Formal Letters & Article Writing (Class 12)", ch_ENG_12_1_2_2, "Official Correspondence, Job Applications & Editor Letters");

        // Unit: Unit 3: Literature Core Prose & Poetry
        Unit u_ENG_12_1_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Literature Core Prose & Poetry", 3, "English", board, classLevel)));

        // Chapter: Prescribed Prose Masterpieces (Class 12 NCERT)
        Chapter ch_ENG_12_1_3_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 3: Literature Core Prose & Poetry", 3, "Prescribed Prose Masterpieces (Class 12 NCERT)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 3: Literature Core Prose & Poetry", "Prescribed Prose Masterpieces (Class 12 NCERT)", ch_ENG_12_1_3_3, "Themes, Characterisation & Literary Irony");

        // Chapter: Prescribed Poetry & Poetic Devices (Class 12 NCERT)
        Chapter ch_ENG_12_1_3_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 3: Literature Core Prose & Poetry", 4, "Prescribed Poetry & Poetic Devices (Class 12 NCERT)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 3: Literature Core Prose & Poetry", "Prescribed Poetry & Poetic Devices (Class 12 NCERT)", ch_ENG_12_1_3_4, "Metaphors, Rhyme Scheme & Aesthetic Appreciation");

        // Unit: Unit 4: Supplementary Reader
        Unit u_ENG_12_1_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Supplementary Reader", 4, "English", board, classLevel)));

        // Chapter: Supplementary Masterpieces (Class 12 NCERT)
        Chapter ch_ENG_12_1_4_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 4: Supplementary Reader", 5, "Supplementary Masterpieces (Class 12 NCERT)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 4: Supplementary Reader", "Supplementary Masterpieces (Class 12 NCERT)", ch_ENG_12_1_4_5, "Plot Development, Themes & Philosophical Motifs");

        // Subject: Physics
        Subject sub_PHY_12_2 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Physics")
                .orElseGet(() -> subjectRepository.save(new Subject("Physics", "PHY", "⚡", "#3867d6", board, classLevel)));

        // Unit: Unit 1: Electrostatics & Current Electricity
        Unit u_PHY_12_2_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Physics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Electrostatics & Current Electricity", 1, "Physics", board, classLevel)));

        // Chapter: Electric Charges, Fields & Gauss's Law
        Chapter ch_PHY_12_2_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Physics", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Physics", "Unit 1: Electrostatics & Current Electricity", 1, "Electric Charges, Fields & Gauss's Law", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Physics", "Unit 1: Electrostatics & Current Electricity", "Electric Charges, Fields & Gauss's Law", ch_PHY_12_2_1_1, "Coulomb's Law, Dipole, Flux & Field Calculations");

        // Chapter: Electrostatic Potential, Capacitance & Current Electricity
        Chapter ch_PHY_12_2_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Physics", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Physics", "Unit 1: Electrostatics & Current Electricity", 2, "Electrostatic Potential, Capacitance & Current Electricity", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Physics", "Unit 1: Electrostatics & Current Electricity", "Electrostatic Potential, Capacitance & Current Electricity", ch_PHY_12_2_1_2, "Equipotential Surfaces, Capacitors in Series/Parallel, Ohm's Law, Kirchhoff's Rules & Potentiometer");

        // Unit: Unit 2: Magnetic Effects of Current & Magnetism
        Unit u_PHY_12_2_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Physics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Magnetic Effects of Current & Magnetism", 2, "Physics", board, classLevel)));

        // Chapter: Moving Charges, Magnetism and Matter
        Chapter ch_PHY_12_2_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Physics", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Physics", "Unit 2: Magnetic Effects of Current & Magnetism", 3, "Moving Charges, Magnetism and Matter", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Physics", "Unit 2: Magnetic Effects of Current & Magnetism", "Moving Charges, Magnetism and Matter", ch_PHY_12_2_2_3, "Biot-Savart Law, Ampere's Law, Lorentz Force, Cyclotron & Magnetic Dipole");

        // Unit: Unit 3: Electromagnetic Induction, AC & EM Waves
        Unit u_PHY_12_2_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Physics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Electromagnetic Induction, AC & EM Waves", 3, "Physics", board, classLevel)));

        // Chapter: Electromagnetic Induction & Alternating Currents
        Chapter ch_PHY_12_2_3_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Physics", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Physics", "Unit 3: Electromagnetic Induction, AC & EM Waves", 4, "Electromagnetic Induction & Alternating Currents", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Physics", "Unit 3: Electromagnetic Induction, AC & EM Waves", "Electromagnetic Induction & Alternating Currents", ch_PHY_12_2_3_4, "Faraday's Law, Lenz's Law, Mutual Inductance, LCR Series Circuit & Transformers");

        // Chapter: Electromagnetic Waves
        Chapter ch_PHY_12_2_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Physics", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Physics", "Unit 3: Electromagnetic Induction, AC & EM Waves", 5, "Electromagnetic Waves", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Physics", "Unit 3: Electromagnetic Induction, AC & EM Waves", "Electromagnetic Waves", ch_PHY_12_2_3_5, "Displacement Current & EM Spectrum Characteristics");

        // Unit: Unit 4: Optics & Modern Physics
        Unit u_PHY_12_2_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Physics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Optics & Modern Physics", 4, "Physics", board, classLevel)));

        // Chapter: Ray Optics and Wave Optics
        Chapter ch_PHY_12_2_4_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Physics", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Physics", "Unit 4: Optics & Modern Physics", 6, "Ray Optics and Wave Optics", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Physics", "Unit 4: Optics & Modern Physics", "Ray Optics and Wave Optics", ch_PHY_12_2_4_6, "Reflection, Refraction, Lens Maker Formula, Microscope, Telescope, Huygens' Principle, Interference & Diffraction");

        // Chapter: Dual Nature of Radiation, Atoms & Nuclei
        Chapter ch_PHY_12_2_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Physics", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Physics", "Unit 4: Optics & Modern Physics", 7, "Dual Nature of Radiation, Atoms & Nuclei", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Physics", "Unit 4: Optics & Modern Physics", "Dual Nature of Radiation, Atoms & Nuclei", ch_PHY_12_2_4_7, "Photoelectric Equation, de Broglie, Bohr Atom, Mass Defect, Radioactivity, Fission & Fusion");

        // Unit: Unit 5: Semiconductor Devices
        Unit u_PHY_12_2_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Physics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 5: Semiconductor Devices", 5, "Physics", board, classLevel)));

        // Chapter: Semiconductor Electronics – Materials, Devices and Simple Circuits
        Chapter ch_PHY_12_2_5_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Physics", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Physics", "Unit 5: Semiconductor Devices", 8, "Semiconductor Electronics – Materials, Devices and Simple Circuits", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Physics", "Unit 5: Semiconductor Devices", "Semiconductor Electronics – Materials, Devices and Simple Circuits", ch_PHY_12_2_5_8, "Intrinsic/Extrinsic Semiconductors, p-n Junction, Rectifiers, Zener Diode & Logic Gates");

        // Subject: Chemistry
        Subject sub_CHEM_12_3 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Chemistry")
                .orElseGet(() -> subjectRepository.save(new Subject("Chemistry", "CHEM", "🧪", "#8854d0", board, classLevel)));

        // Unit: Unit 1: Solutions, Electrochemistry & Chemical Kinetics
        Unit u_CHEM_12_3_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Chemistry")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Solutions, Electrochemistry & Chemical Kinetics", 1, "Chemistry", board, classLevel)));

        // Chapter: Solutions
        Chapter ch_CHEM_12_3_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Chemistry", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Chemistry", "Unit 1: Solutions, Electrochemistry & Chemical Kinetics", 1, "Solutions", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Chemistry", "Unit 1: Solutions, Electrochemistry & Chemical Kinetics", "Solutions", ch_CHEM_12_3_1_1, "Henry's Law, Raoult's Law, Colligative Properties, Van't Hoff Factor");

        // Chapter: Electrochemistry
        Chapter ch_CHEM_12_3_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Chemistry", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Chemistry", "Unit 1: Solutions, Electrochemistry & Chemical Kinetics", 2, "Electrochemistry", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Chemistry", "Unit 1: Solutions, Electrochemistry & Chemical Kinetics", "Electrochemistry", ch_CHEM_12_3_1_2, "Nernst Equation, Kohlrausch Law, Fuel Cells, Corrosion");

        // Chapter: Chemical Kinetics
        Chapter ch_CHEM_12_3_1_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Chemistry", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Chemistry", "Unit 1: Solutions, Electrochemistry & Chemical Kinetics", 3, "Chemical Kinetics", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Chemistry", "Unit 1: Solutions, Electrochemistry & Chemical Kinetics", "Chemical Kinetics", ch_CHEM_12_3_1_3, "Rate Law, Integrated Rate Equations, Arrhenius Equation, Activation Energy");

        // Unit: Unit 2: Inorganic Chemistry – d-Block, f-Block & Coordination
        Unit u_CHEM_12_3_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Chemistry")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Inorganic Chemistry – d-Block, f-Block & Coordination", 2, "Chemistry", board, classLevel)));

        // Chapter: The d- and f-Block Elements
        Chapter ch_CHEM_12_3_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Chemistry", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Chemistry", "Unit 2: Inorganic Chemistry – d-Block, f-Block & Coordination", 4, "The d- and f-Block Elements", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Chemistry", "Unit 2: Inorganic Chemistry – d-Block, f-Block & Coordination", "The d- and f-Block Elements", ch_CHEM_12_3_2_4, "Lanthanoid Contraction, Magnetic Properties, Catalytic Behavior");

        // Chapter: Coordination Compounds
        Chapter ch_CHEM_12_3_2_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Chemistry", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Chemistry", "Unit 2: Inorganic Chemistry – d-Block, f-Block & Coordination", 5, "Coordination Compounds", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Chemistry", "Unit 2: Inorganic Chemistry – d-Block, f-Block & Coordination", "Coordination Compounds", ch_CHEM_12_3_2_5, "Werner's Theory, IUPAC Naming, Crystal Field Theory, Isomerism");

        // Unit: Unit 3: Organic Chemistry – Haloalkanes, Alcohols, Carbonyls & Amines
        Unit u_CHEM_12_3_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Chemistry")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Organic Chemistry – Haloalkanes, Alcohols, Carbonyls & Amines", 3, "Chemistry", board, classLevel)));

        // Chapter: Haloalkanes and Haloarenes & Alcohols, Phenols and Ethers
        Chapter ch_CHEM_12_3_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Chemistry", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Chemistry", "Unit 3: Organic Chemistry – Haloalkanes, Alcohols, Carbonyls & Amines", 6, "Haloalkanes and Haloarenes & Alcohols, Phenols and Ethers", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Chemistry", "Unit 3: Organic Chemistry – Haloalkanes, Alcohols, Carbonyls & Amines", "Haloalkanes and Haloarenes & Alcohols, Phenols and Ethers", ch_CHEM_12_3_3_6, "SN1/SN2 Mechanisms, Kolbe Reaction, Reimer-Tiemann, Williamson Synthesis");

        // Chapter: Aldehydes, Ketones, Carboxylic Acids & Amines
        Chapter ch_CHEM_12_3_3_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Chemistry", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Chemistry", "Unit 3: Organic Chemistry – Haloalkanes, Alcohols, Carbonyls & Amines", 7, "Aldehydes, Ketones, Carboxylic Acids & Amines", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Chemistry", "Unit 3: Organic Chemistry – Haloalkanes, Alcohols, Carbonyls & Amines", "Aldehydes, Ketones, Carboxylic Acids & Amines", ch_CHEM_12_3_3_7, "Nucleophilic Addition, Aldol, Cannizzaro, Gabriel Phthalimide, Diazonium Salts");

        // Chapter: Biomolecules
        Chapter ch_CHEM_12_3_3_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Chemistry", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Chemistry", "Unit 3: Organic Chemistry – Haloalkanes, Alcohols, Carbonyls & Amines", 8, "Biomolecules", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Chemistry", "Unit 3: Organic Chemistry – Haloalkanes, Alcohols, Carbonyls & Amines", "Biomolecules", ch_CHEM_12_3_3_8, "Carbohydrates, Amino Acids, Peptide Bond, DNA/RNA Structure & Vitamins");

        // Subject: Mathematics
        Subject sub_MATH_12_4 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Mathematics")
                .orElseGet(() -> subjectRepository.save(new Subject("Mathematics", "MATH", "📐", "#4834d4", board, classLevel)));

        // Unit: Unit 1: Relations, Functions & Inverse Trigonometry
        Unit u_MATH_12_4_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Relations, Functions & Inverse Trigonometry", 1, "Mathematics", board, classLevel)));

        // Chapter: Relations and Functions & Inverse Trigonometric Functions
        Chapter ch_MATH_12_4_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 1: Relations, Functions & Inverse Trigonometry", 1, "Relations and Functions & Inverse Trigonometric Functions", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 1: Relations, Functions & Inverse Trigonometry", "Relations and Functions & Inverse Trigonometric Functions", ch_MATH_12_4_1_1, "Reflexive, Symmetric, Transitive, Principal Value Branches & Graph Properties");

        // Unit: Unit 2: Matrices and Determinants
        Unit u_MATH_12_4_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Matrices and Determinants", 2, "Mathematics", board, classLevel)));

        // Chapter: Matrices and Determinants
        Chapter ch_MATH_12_4_2_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 2: Matrices and Determinants", 2, "Matrices and Determinants", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 2: Matrices and Determinants", "Matrices and Determinants", ch_MATH_12_4_2_2, "Matrix Multiplication, Inverse, Adjoint, Area of Triangle, Matrix Method for System of Equations");

        // Unit: Unit 3: Calculus – Continuity, Differentiability, Integrals & Differential Equations
        Unit u_MATH_12_4_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Calculus – Continuity, Differentiability, Integrals & Differential Equations", 3, "Mathematics", board, classLevel)));

        // Chapter: Continuity, Differentiability & Applications of Derivatives
        Chapter ch_MATH_12_4_3_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 3: Calculus – Continuity, Differentiability, Integrals & Differential Equations", 3, "Continuity, Differentiability & Applications of Derivatives", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 3: Calculus – Continuity, Differentiability, Integrals & Differential Equations", "Continuity, Differentiability & Applications of Derivatives", ch_MATH_12_4_3_3, "Chain Rule, Logarithmic Differentiation, Rate of Change, Increasing/Decreasing, Maxima/Minima");

        // Chapter: Integrals & Applications of Integrals
        Chapter ch_MATH_12_4_3_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 3: Calculus – Continuity, Differentiability, Integrals & Differential Equations", 4, "Integrals & Applications of Integrals", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 3: Calculus – Continuity, Differentiability, Integrals & Differential Equations", "Integrals & Applications of Integrals", ch_MATH_12_4_3_4, "Substitution, Partial Fractions, By Parts, Definite Integral Properties, Area under Curves");

        // Chapter: Differential Equations
        Chapter ch_MATH_12_4_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 3: Calculus – Continuity, Differentiability, Integrals & Differential Equations", 5, "Differential Equations", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 3: Calculus – Continuity, Differentiability, Integrals & Differential Equations", "Differential Equations", ch_MATH_12_4_3_5, "Order, Degree, General Solution, Variable Separable, Homogeneous & Linear DEs");

        // Unit: Unit 4: Vectors, Three-Dimensional Geometry & Linear Programming
        Unit u_MATH_12_4_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Vectors, Three-Dimensional Geometry & Linear Programming", 4, "Mathematics", board, classLevel)));

        // Chapter: Vectors and Three Dimensional Geometry
        Chapter ch_MATH_12_4_4_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 4: Vectors, Three-Dimensional Geometry & Linear Programming", 6, "Vectors and Three Dimensional Geometry", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 4: Vectors, Three-Dimensional Geometry & Linear Programming", "Vectors and Three Dimensional Geometry", ch_MATH_12_4_4_6, "Dot/Cross Product, Direction Cosines, Equation of Line, Shortest Distance between Skew Lines");

        // Chapter: Linear Programming & Probability
        Chapter ch_MATH_12_4_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 4: Vectors, Three-Dimensional Geometry & Linear Programming", 7, "Linear Programming & Probability", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 4: Vectors, Three-Dimensional Geometry & Linear Programming", "Linear Programming & Probability", ch_MATH_12_4_4_7, "Graphical Optimization, Corner Point Method, Conditional Probability, Bayes' Theorem & Random Variables");

        // Subject: Biology
        Subject sub_BIO_12_5 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Biology")
                .orElseGet(() -> subjectRepository.save(new Subject("Biology", "BIO", "🧬", "#20bf6b", board, classLevel)));

        // Unit: Unit 1: Diversity & Structural Organisation in Organisms
        Unit u_BIO_12_5_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Biology")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Diversity & Structural Organisation in Organisms", 1, "Biology", board, classLevel)));

        // Chapter: Biological Classification & Plant/Animal Kingdom (Class 12)
        Chapter ch_BIO_12_5_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Biology", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Biology", "Unit 1: Diversity & Structural Organisation in Organisms", 1, "Biological Classification & Plant/Animal Kingdom (Class 12)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Biology", "Unit 1: Diversity & Structural Organisation in Organisms", "Biological Classification & Plant/Animal Kingdom (Class 12)", ch_BIO_12_5_1_1, "Five Kingdom Classification, Gymnosperms, Angiosperms & Chordates");

        // Chapter: Morphology & Anatomy of Flowering Plants (Class 12)
        Chapter ch_BIO_12_5_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Biology", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Biology", "Unit 1: Diversity & Structural Organisation in Organisms", 2, "Morphology & Anatomy of Flowering Plants (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Biology", "Unit 1: Diversity & Structural Organisation in Organisms", "Morphology & Anatomy of Flowering Plants (Class 12)", ch_BIO_12_5_1_2, "Root, Stem, Leaf modifications, Tissues & Secondary Growth");

        // Unit: Unit 2: Cell Biology, Biomolecules & Human Physiology
        Unit u_BIO_12_5_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Biology")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Cell Biology, Biomolecules & Human Physiology", 2, "Biology", board, classLevel)));

        // Chapter: Cell Cycle, Mitosis, Meiosis & Biomolecules (Class 12)
        Chapter ch_BIO_12_5_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Biology", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Biology", "Unit 2: Cell Biology, Biomolecules & Human Physiology", 3, "Cell Cycle, Mitosis, Meiosis & Biomolecules (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Biology", "Unit 2: Cell Biology, Biomolecules & Human Physiology", "Cell Cycle, Mitosis, Meiosis & Biomolecules (Class 12)", ch_BIO_12_5_2_3, "Chromosomes, Enzymes, Activation Energy & Cell Division Stages");

        // Chapter: Human Respiration, Circulation & Neural Control (Class 12)
        Chapter ch_BIO_12_5_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Biology", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Biology", "Unit 2: Cell Biology, Biomolecules & Human Physiology", 4, "Human Respiration, Circulation & Neural Control (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Biology", "Unit 2: Cell Biology, Biomolecules & Human Physiology", "Human Respiration, Circulation & Neural Control (Class 12)", ch_BIO_12_5_2_4, "Gas Exchange, ECG, Cardiac Cycle, Action Potential & Synapse");

        // Unit: Unit 3: Genetics, Evolution, Biotechnology & Ecology
        Unit u_BIO_12_5_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Biology")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Genetics, Evolution, Biotechnology & Ecology", 3, "Biology", board, classLevel)));

        // Chapter: Mendelian Genetics, DNA Replication & Human Evolution (Class 12)
        Chapter ch_BIO_12_5_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Biology", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Biology", "Unit 3: Genetics, Evolution, Biotechnology & Ecology", 5, "Mendelian Genetics, DNA Replication & Human Evolution (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Biology", "Unit 3: Genetics, Evolution, Biotechnology & Ecology", "Mendelian Genetics, DNA Replication & Human Evolution (Class 12)", ch_BIO_12_5_3_5, "Pedigree Analysis, Lac Operon, Genetic Code & Hardy-Weinberg Equilibrium");

        // Chapter: Biotechnology Principles, Applications & Ecosystems (Class 12)
        Chapter ch_BIO_12_5_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Biology", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Biology", "Unit 3: Genetics, Evolution, Biotechnology & Ecology", 6, "Biotechnology Principles, Applications & Ecosystems (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Biology", "Unit 3: Genetics, Evolution, Biotechnology & Ecology", "Biotechnology Principles, Applications & Ecosystems (Class 12)", ch_BIO_12_5_3_6, "Restriction Enzymes, Gel Electrophoresis, Bt Crops, Bioreactors & Nutrient Cycling");

        // Subject: Computer Science
        Subject sub_CS_12_6 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Computer Science")
                .orElseGet(() -> subjectRepository.save(new Subject("Computer Science", "CS", "💻", "#2d98da", board, classLevel)));

        // Unit: Unit 1: Computational Thinking and Programming (Python)
        Unit u_CS_12_6_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Computer Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Computational Thinking and Programming (Python)", 1, "Computer Science", board, classLevel)));

        // Chapter: Python Syntax, Flow Control, Functions & Recursion (Class 12)
        Chapter ch_CS_12_6_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Computer Science", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Computer Science", "Unit 1: Computational Thinking and Programming (Python)", 1, "Python Syntax, Flow Control, Functions & Recursion (Class 12)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Computer Science", "Unit 1: Computational Thinking and Programming (Python)", "Python Syntax, Flow Control, Functions & Recursion (Class 12)", ch_CS_12_6_1_1, "Mutable vs Immutable, Scope, Default Parameters, Modules");

        // Chapter: File Handling, Text, Binary & CSV Files in Python (Class 12)
        Chapter ch_CS_12_6_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Computer Science", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Computer Science", "Unit 1: Computational Thinking and Programming (Python)", 2, "File Handling, Text, Binary & CSV Files in Python (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Computer Science", "Unit 1: Computational Thinking and Programming (Python)", "File Handling, Text, Binary & CSV Files in Python (Class 12)", ch_CS_12_6_1_2, "open(), read(), write(), pickle module, csv.reader/writer");

        // Chapter: Data Structures – Stack Implementation (Class 12)
        Chapter ch_CS_12_6_1_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Computer Science", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Computer Science", "Unit 1: Computational Thinking and Programming (Python)", 3, "Data Structures – Stack Implementation (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Computer Science", "Unit 1: Computational Thinking and Programming (Python)", "Data Structures – Stack Implementation (Class 12)", ch_CS_12_6_1_3, "LIFO, Push, Pop, Peak using Python Lists");

        // Unit: Unit 2: Computer Networks & Database Management (SQL)
        Unit u_CS_12_6_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Computer Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Computer Networks & Database Management (SQL)", 2, "Computer Science", board, classLevel)));

        // Chapter: Computer Networks – Topologies, Protocols & Network Devices (Class 12)
        Chapter ch_CS_12_6_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Computer Science", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Computer Science", "Unit 2: Computer Networks & Database Management (SQL)", 4, "Computer Networks – Topologies, Protocols & Network Devices (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Computer Science", "Unit 2: Computer Networks & Database Management (SQL)", "Computer Networks – Topologies, Protocols & Network Devices (Class 12)", ch_CS_12_6_2_4, "LAN/WAN, TCP/IP, DNS, HTTP/HTTPS, Router, Switch, Gateway");

        // Chapter: Relational Database Concepts, SQL Queries & Python-SQL Connectivity (Class 12)
        Chapter ch_CS_12_6_2_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Computer Science", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Computer Science", "Unit 2: Computer Networks & Database Management (SQL)", 5, "Relational Database Concepts, SQL Queries & Python-SQL Connectivity (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Computer Science", "Unit 2: Computer Networks & Database Management (SQL)", "Relational Database Concepts, SQL Queries & Python-SQL Connectivity (Class 12)", ch_CS_12_6_2_5, "Aggregate Functions, GROUP BY, HAVING, ORDER BY, Joins & mysql.connector");

        // Chapter: Societal Impacts, Cyber Crime & Cyber Ethics (Class 12)
        Chapter ch_CS_12_6_2_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Computer Science", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Computer Science", "Unit 2: Computer Networks & Database Management (SQL)", 6, "Societal Impacts, Cyber Crime & Cyber Ethics (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Computer Science", "Unit 2: Computer Networks & Database Management (SQL)", "Societal Impacts, Cyber Crime & Cyber Ethics (Class 12)", ch_CS_12_6_2_6, "Digital Footprint, Phishing, Ransomware, IT Act & Intellectual Property");

        // Subject: Informatics Practices
        Subject sub_IP_12_7 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Informatics Practices")
                .orElseGet(() -> subjectRepository.save(new Subject("Informatics Practices", "IP", "💻", "#3867d6", board, classLevel)));

        // Unit: Unit 1: Data Handling using Pandas and Matplotlib
        Unit u_IP_12_7_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Informatics Practices")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Data Handling using Pandas and Matplotlib", 1, "Informatics Practices", board, classLevel)));

        // Chapter: Python Pandas – Series, DataFrames & Data Analysis (Class 12)
        Chapter ch_IP_12_7_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Informatics Practices", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Informatics Practices", "Unit 1: Data Handling using Pandas and Matplotlib", 1, "Python Pandas – Series, DataFrames & Data Analysis (Class 12)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Informatics Practices", "Unit 1: Data Handling using Pandas and Matplotlib", "Python Pandas – Series, DataFrames & Data Analysis (Class 12)", ch_IP_12_7_1_1, "Creation, Slicing, Filtering, loc, iloc, Sorting & Aggregation");

        // Chapter: Data Visualisation using Pyplot (Class 12)
        Chapter ch_IP_12_7_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Informatics Practices", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Informatics Practices", "Unit 1: Data Handling using Pandas and Matplotlib", 2, "Data Visualisation using Pyplot (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Informatics Practices", "Unit 1: Data Handling using Pandas and Matplotlib", "Data Visualisation using Pyplot (Class 12)", ch_IP_12_7_1_2, "Line plots, Bar charts, Histograms, Customization & Legends");

        // Unit: Unit 2: Database Query using SQL & Societal Impacts
        Unit u_IP_12_7_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Informatics Practices")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Database Query using SQL & Societal Impacts", 2, "Informatics Practices", board, classLevel)));

        // Chapter: Advanced SQL Functions & Table Joins (Class 12)
        Chapter ch_IP_12_7_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Informatics Practices", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Informatics Practices", "Unit 2: Database Query using SQL & Societal Impacts", 3, "Advanced SQL Functions & Table Joins (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Informatics Practices", "Unit 2: Database Query using SQL & Societal Impacts", "Advanced SQL Functions & Table Joins (Class 12)", ch_IP_12_7_2_3, "Math, String, Date Functions, Group By & Natural Join");

        // Chapter: Emerging Trends, E-Waste Management & Cyber Law (Class 12)
        Chapter ch_IP_12_7_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Informatics Practices", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Informatics Practices", "Unit 2: Database Query using SQL & Societal Impacts", 4, "Emerging Trends, E-Waste Management & Cyber Law (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Informatics Practices", "Unit 2: Database Query using SQL & Societal Impacts", "Emerging Trends, E-Waste Management & Cyber Law (Class 12)", ch_IP_12_7_2_4, "AI, IoT, Cloud, E-Waste Recycling, Net Etiquettes & Data Privacy");

        // Subject: Accountancy
        Subject sub_ACC_12_8 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Accountancy")
                .orElseGet(() -> subjectRepository.save(new Subject("Accountancy", "ACC", "📋", "#2bcbba", board, classLevel)));

        // Unit: Unit 1: Financial Accounting – Principles & Final Accounts
        Unit u_ACC_12_8_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Accountancy")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Financial Accounting – Principles & Final Accounts", 1, "Accountancy", board, classLevel)));

        // Chapter: Theoretical Framework, Accounting Standards & GST (Class 12)
        Chapter ch_ACC_12_8_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Accountancy", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Accountancy", "Unit 1: Financial Accounting – Principles & Final Accounts", 1, "Theoretical Framework, Accounting Standards & GST (Class 12)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Accountancy", "Unit 1: Financial Accounting – Principles & Final Accounts", "Theoretical Framework, Accounting Standards & GST (Class 12)", ch_ACC_12_8_1_1, "Accrual Concept, Matching Principle, Dual Aspect & CGST/SGST/IGST");

        // Chapter: Recording Transactions, BRS, Depreciation & Trial Balance (Class 12)
        Chapter ch_ACC_12_8_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Accountancy", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Accountancy", "Unit 1: Financial Accounting – Principles & Final Accounts", 2, "Recording Transactions, BRS, Depreciation & Trial Balance (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Accountancy", "Unit 1: Financial Accounting – Principles & Final Accounts", "Recording Transactions, BRS, Depreciation & Trial Balance (Class 12)", ch_ACC_12_8_1_2, "Cash Book, Journal, Bank Reconciliation, SLM vs WDV Depreciation");

        // Unit: Unit 2: Accounting for Partnership Firms & Companies
        Unit u_ACC_12_8_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Accountancy")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Accounting for Partnership Firms & Companies", 2, "Accountancy", board, classLevel)));

        // Chapter: Partnership Fundamentals, Goodwill, Admission & Dissolution (Class 12)
        Chapter ch_ACC_12_8_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Accountancy", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Accountancy", "Unit 2: Accounting for Partnership Firms & Companies", 3, "Partnership Fundamentals, Goodwill, Admission & Dissolution (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Accountancy", "Unit 2: Accounting for Partnership Firms & Companies", "Partnership Fundamentals, Goodwill, Admission & Dissolution (Class 12)", ch_ACC_12_8_2_3, "P&L Appropriation, Fluctuating/Fixed Capital, Revaluation & Realisation Account");

        // Chapter: Accounting for Share Capital & Issue of Debentures (Class 12)
        Chapter ch_ACC_12_8_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Accountancy", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Accountancy", "Unit 2: Accounting for Partnership Firms & Companies", 4, "Accounting for Share Capital & Issue of Debentures (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Accountancy", "Unit 2: Accounting for Partnership Firms & Companies", "Accounting for Share Capital & Issue of Debentures (Class 12)", ch_ACC_12_8_2_4, "Calls in Arrears, Forfeiture, Reissue, Pro-rata Allotment & Debenture Redemption");

        // Unit: Unit 3: Financial Statement Analysis & Cash Flow
        Unit u_ACC_12_8_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Accountancy")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Financial Statement Analysis & Cash Flow", 3, "Accountancy", board, classLevel)));

        // Chapter: Comparative Statements, Common Size & Accounting Ratios (Class 12)
        Chapter ch_ACC_12_8_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Accountancy", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Accountancy", "Unit 3: Financial Statement Analysis & Cash Flow", 5, "Comparative Statements, Common Size & Accounting Ratios (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Accountancy", "Unit 3: Financial Statement Analysis & Cash Flow", "Comparative Statements, Common Size & Accounting Ratios (Class 12)", ch_ACC_12_8_3_5, "Liquidity, Solvency, Activity & Profitability Ratios");

        // Chapter: Cash Flow Statement (AS-3 Revised) (Class 12)
        Chapter ch_ACC_12_8_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Accountancy", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Accountancy", "Unit 3: Financial Statement Analysis & Cash Flow", 6, "Cash Flow Statement (AS-3 Revised) (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Accountancy", "Unit 3: Financial Statement Analysis & Cash Flow", "Cash Flow Statement (AS-3 Revised) (Class 12)", ch_ACC_12_8_3_6, "Operating, Investing & Financing Activities");

        // Subject: Business Studies
        Subject sub_BST_12_9 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Business Studies")
                .orElseGet(() -> subjectRepository.save(new Subject("Business Studies", "BST", "💼", "#ff9f43", board, classLevel)));

        // Unit: Unit 1: Foundations of Business & Principles of Management
        Unit u_BST_12_9_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Business Studies")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Foundations of Business & Principles of Management", 1, "Business Studies", board, classLevel)));

        // Chapter: Nature and Purpose of Business & Forms of Organisation (Class 12)
        Chapter ch_BST_12_9_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Business Studies", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Business Studies", "Unit 1: Foundations of Business & Principles of Management", 1, "Nature and Purpose of Business & Forms of Organisation (Class 12)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Business Studies", "Unit 1: Foundations of Business & Principles of Management", "Nature and Purpose of Business & Forms of Organisation (Class 12)", ch_BST_12_9_1_1, "Business vs Profession, Sole Proprietorship, Partnership, Company Incorporation");

        // Chapter: Principles and Functions of Management (Class 12)
        Chapter ch_BST_12_9_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Business Studies", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Business Studies", "Unit 1: Foundations of Business & Principles of Management", 2, "Principles and Functions of Management (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Business Studies", "Unit 1: Foundations of Business & Principles of Management", "Principles and Functions of Management (Class 12)", ch_BST_12_9_1_2, "Fayol's Principles, Taylor's Scientific Management, Planning & Organising");

        // Unit: Unit 2: Corporate Finance, Marketing & Consumer Protection
        Unit u_BST_12_9_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Business Studies")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Corporate Finance, Marketing & Consumer Protection", 2, "Business Studies", board, classLevel)));

        // Chapter: Financial Management, Financial Markets & Sources of Finance (Class 12)
        Chapter ch_BST_12_9_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Business Studies", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Business Studies", "Unit 2: Corporate Finance, Marketing & Consumer Protection", 3, "Financial Management, Financial Markets & Sources of Finance (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Business Studies", "Unit 2: Corporate Finance, Marketing & Consumer Protection", "Financial Management, Financial Markets & Sources of Finance (Class 12)", ch_BST_12_9_2_3, "Capital Structure, Working Capital, Money Market, Capital Market & SEBI");

        // Chapter: Marketing Management, 4Ps & Consumer Protection Act 2019 (Class 12)
        Chapter ch_BST_12_9_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Business Studies", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Business Studies", "Unit 2: Corporate Finance, Marketing & Consumer Protection", 4, "Marketing Management, 4Ps & Consumer Protection Act 2019 (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Business Studies", "Unit 2: Corporate Finance, Marketing & Consumer Protection", "Marketing Management, 4Ps & Consumer Protection Act 2019 (Class 12)", ch_BST_12_9_2_4, "Product, Price, Place, Promotion, Consumer Rights & Three-Tier Redressal");

        // Subject: Economics
        Subject sub_ECO_12_10 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Economics")
                .orElseGet(() -> subjectRepository.save(new Subject("Economics", "ECO", "📈", "#ee5253", board, classLevel)));

        // Unit: Unit 1: Microeconomics & Introductory Macroeconomics
        Unit u_ECO_12_10_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Economics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Microeconomics & Introductory Macroeconomics", 1, "Economics", board, classLevel)));

        // Chapter: Consumer Equilibrium, Demand, Cost & Revenue (Class 12)
        Chapter ch_ECO_12_10_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Economics", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Economics", "Unit 1: Microeconomics & Introductory Macroeconomics", 1, "Consumer Equilibrium, Demand, Cost & Revenue (Class 12)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Economics", "Unit 1: Microeconomics & Introductory Macroeconomics", "Consumer Equilibrium, Demand, Cost & Revenue (Class 12)", ch_ECO_12_10_1_1, "Marginal Utility, Law of Demand, Elasticity & Production Function");

        // Chapter: National Income Accounting, Money and Banking (Class 12)
        Chapter ch_ECO_12_10_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Economics", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Economics", "Unit 1: Microeconomics & Introductory Macroeconomics", 2, "National Income Accounting, Money and Banking (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Economics", "Unit 1: Microeconomics & Introductory Macroeconomics", "National Income Accounting, Money and Banking (Class 12)", ch_ECO_12_10_1_2, "GDP, GNP, Real/Nominal GDP, Money Creation, Central Bank Functions");

        // Unit: Unit 2: Government Budget & Indian Economic Development
        Unit u_ECO_12_10_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Economics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Government Budget & Indian Economic Development", 2, "Economics", board, classLevel)));

        // Chapter: Determination of Income, Government Budget & Balance of Payments (Class 12)
        Chapter ch_ECO_12_10_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Economics", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Economics", "Unit 2: Government Budget & Indian Economic Development", 3, "Determination of Income, Government Budget & Balance of Payments (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Economics", "Unit 2: Government Budget & Indian Economic Development", "Determination of Income, Government Budget & Balance of Payments (Class 12)", ch_ECO_12_10_2_3, "Aggregate Demand, Multiplier, Fiscal Deficit, Foreign Exchange Rates");

        // Chapter: Indian Economy on Eve of Independence & Economic Reforms 1991 (Class 12)
        Chapter ch_ECO_12_10_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Economics", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Economics", "Unit 2: Government Budget & Indian Economic Development", 4, "Indian Economy on Eve of Independence & Economic Reforms 1991 (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Economics", "Unit 2: Government Budget & Indian Economic Development", "Indian Economy on Eve of Independence & Economic Reforms 1991 (Class 12)", ch_ECO_12_10_2_4, "LPG Policies, Rural Development, Human Capital, Sustainable Development");

        // Subject: History
        Subject sub_HIST_12_11 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "History")
                .orElseGet(() -> subjectRepository.save(new Subject("History", "HIST", "🏛️", "#5f27cd", board, classLevel)));

        // Unit: Unit 1: Themes in Indian History – Part I (Ancient)
        Unit u_HIST_12_11_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "History")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Themes in Indian History – Part I (Ancient)", 1, "History", board, classLevel)));

        // Chapter: Bricks, Beads and Bones (The Harappan Civilisation) (Class 12)
        Chapter ch_HIST_12_11_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "History", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("History", "Unit 1: Themes in Indian History – Part I (Ancient)", 1, "Bricks, Beads and Bones (The Harappan Civilisation) (Class 12)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "History", "Unit 1: Themes in Indian History – Part I (Ancient)", "Bricks, Beads and Bones (The Harappan Civilisation) (Class 12)", ch_HIST_12_11_1_1, "Town Planning, Citadel, Great Bath, Seals, Script & Craft Production");

        // Chapter: Kings, Farmers and Towns & Kinship, Caste and Class (Class 12)
        Chapter ch_HIST_12_11_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "History", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("History", "Unit 1: Themes in Indian History – Part I (Ancient)", 2, "Kings, Farmers and Towns & Kinship, Caste and Class (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "History", "Unit 1: Themes in Indian History – Part I (Ancient)", "Kings, Farmers and Towns & Kinship, Caste and Class (Class 12)", ch_HIST_12_11_1_2, "Early States, 16 Mahajanapadas, Mauryan Empire, Mahabharata Social Patterns");

        // Chapter: Thinkers, Beliefs and Buildings (Cultural Developments) (Class 12)
        Chapter ch_HIST_12_11_1_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "History", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("History", "Unit 1: Themes in Indian History – Part I (Ancient)", 3, "Thinkers, Beliefs and Buildings (Cultural Developments) (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "History", "Unit 1: Themes in Indian History – Part I (Ancient)", "Thinkers, Beliefs and Buildings (Cultural Developments) (Class 12)", ch_HIST_12_11_1_3, "Vedic Traditions, Sanchi Stupa, Jainism, Buddhism & Temple Architecture");

        // Unit: Unit 2: Themes in Indian History – Part II & III (Medieval & Modern)
        Unit u_HIST_12_11_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "History")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Themes in Indian History – Part II & III (Medieval & Modern)", 2, "History", board, classLevel)));

        // Chapter: Through the Eyes of Travellers & Bhakti-Sufi Traditions (Class 12)
        Chapter ch_HIST_12_11_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "History", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("History", "Unit 2: Themes in Indian History – Part II & III (Medieval & Modern)", 4, "Through the Eyes of Travellers & Bhakti-Sufi Traditions (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "History", "Unit 2: Themes in Indian History – Part II & III (Medieval & Modern)", "Through the Eyes of Travellers & Bhakti-Sufi Traditions (Class 12)", ch_HIST_12_11_2_4, "Al-Biruni, Ibn Battuta, Francois Bernier, Kabir, Mirabai, Sufi Silsilas");

        // Chapter: An Imperial Capital: Vijayanagara & Peasants, Zamindars and State (Class 12)
        Chapter ch_HIST_12_11_2_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "History", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("History", "Unit 2: Themes in Indian History – Part II & III (Medieval & Modern)", 5, "An Imperial Capital: Vijayanagara & Peasants, Zamindars and State (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "History", "Unit 2: Themes in Indian History – Part II & III (Medieval & Modern)", "An Imperial Capital: Vijayanagara & Peasants, Zamindars and State (Class 12)", ch_HIST_12_11_2_5, "Hampi, Mahanavami Dibba, Ain-i-Akbari, Mughal Agrarian Relations");

        // Chapter: Colonialism, 1857 Revolt & Mahatma Gandhi and Nationalist Movement (Class 12)
        Chapter ch_HIST_12_11_2_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "History", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("History", "Unit 2: Themes in Indian History – Part II & III (Medieval & Modern)", 6, "Colonialism, 1857 Revolt & Mahatma Gandhi and Nationalist Movement (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "History", "Unit 2: Themes in Indian History – Part II & III (Medieval & Modern)", "Colonialism, 1857 Revolt & Mahatma Gandhi and Nationalist Movement (Class 12)", ch_HIST_12_11_2_6, "Santhal Rebellion, 1857 Revolt, Non-Cooperation, Salt March, Quit India & Partition");

        // Chapter: Framing the Constitution (The Beginning of a New Era) (Class 12)
        Chapter ch_HIST_12_11_2_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "History", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("History", "Unit 2: Themes in Indian History – Part II & III (Medieval & Modern)", 7, "Framing the Constitution (The Beginning of a New Era) (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "History", "Unit 2: Themes in Indian History – Part II & III (Medieval & Modern)", "Framing the Constitution (The Beginning of a New Era) (Class 12)", ch_HIST_12_11_2_7, "Constituent Assembly Debates, Drafting Committee & Preamble Objectives");

    }

    private void seed_STATE_BOARD_Class_4() {
        String board = "STATE_BOARD";
        int classLevel = 4;

        // Subject: Tamil
        Subject sub_TAM_4_1 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Tamil")
                .orElseGet(() -> subjectRepository.save(new Subject("Tamil", "TAM", "📖", "#e84118", board, classLevel)));

        // Unit: பருவம் 1: அன்னைத் தமிழ்
        Unit u_TAM_4_1_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("பருவம் 1: அன்னைத் தமிழ்", 1, "Tamil", board, classLevel)));

        // Chapter: அன்னைத் தமிழே
        Chapter ch_TAM_4_1_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "பருவம் 1: அன்னைத் தமிழ்", 1, "அன்னைத் தமிழே", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "பருவம் 1: அன்னைத் தமிழ்", "அன்னைத் தமிழே", ch_TAM_4_1_1_1, "தாய்மொழிப் பற்று");

        // Chapter: பனைமரச் சிறப்பு
        Chapter ch_TAM_4_1_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "பருவம் 1: அன்னைத் தமிழ்", 2, "பனைமரச் சிறப்பு", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "பருவம் 1: அன்னைத் தமிழ்", "பனைமரச் சிறப்பு", ch_TAM_4_1_1_2, "மாநில மரம் பயன்கள்");

        // Unit: பருவம் 1: அறிவின் சிறப்பு
        Unit u_TAM_4_1_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("பருவம் 1: அறிவின் சிறப்பு", 2, "Tamil", board, classLevel)));

        // Chapter: ஏழு இறக்கைக் குருவி
        Chapter ch_TAM_4_1_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "பருவம் 1: அறிவின் சிறப்பு", 3, "ஏழு இறக்கைக் குருவி", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "பருவம் 1: அறிவின் சிறப்பு", "ஏழு இறக்கைக் குருவி", ch_TAM_4_1_2_3, "தெனாலிராமன் அறிவுக் கதை");

        // Chapter: முளைப்பாரி பாடல்
        Chapter ch_TAM_4_1_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "பருவம் 1: அறிவின் சிறப்பு", 4, "முளைப்பாரி பாடல்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "பருவம் 1: அறிவின் சிறப்பு", "முளைப்பாரி பாடல்", ch_TAM_4_1_2_4, "நாட்டுப்புறப் பாடல்");

        // Unit: பருவம் 1: ஒழுக்கம் & இலக்கணம்
        Unit u_TAM_4_1_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("பருவம் 1: ஒழுக்கம் & இலக்கணம்", 3, "Tamil", board, classLevel)));

        // Chapter: பண்படுத்தும் பழமொழிகள்
        Chapter ch_TAM_4_1_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "பருவம் 1: ஒழுக்கம் & இலக்கணம்", 5, "பண்படுத்தும் பழமொழிகள்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "பருவம் 1: ஒழுக்கம் & இலக்கணம்", "பண்படுத்தும் பழமொழிகள்", ch_TAM_4_1_3_5, "பழமொழிகள் விளக்கம்");

        // Chapter: கூட்டுப் பெயர் சொற்கள்
        Chapter ch_TAM_4_1_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "பருவம் 1: ஒழுக்கம் & இலக்கணம்", 6, "கூட்டுப் பெயர் சொற்கள்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "பருவம் 1: ஒழுக்கம் & இலக்கணம்", "கூட்டுப் பெயர் சொற்கள்", ch_TAM_4_1_3_6, "தமிழ் இலக்கணம்");

        // Unit: பருவம் 2: நன்னெறி
        Unit u_TAM_4_1_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("பருவம் 2: நன்னெறி", 4, "Tamil", board, classLevel)));

        // Chapter: நன்னெறி
        Chapter ch_TAM_4_1_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "பருவம் 2: நன்னெறி", 7, "நன்னெறி", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "பருவம் 2: நன்னெறி", "நன்னெறி", ch_TAM_4_1_4_7, "சிவப்பிரகாச சுவாமிகள் அறப்பாடல்");

        // Chapter: காவல் காப்பவர்
        Chapter ch_TAM_4_1_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "பருவம் 2: நன்னெறி", 8, "காவல் காப்பவர்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "பருவம் 2: நன்னெறி", "காவல் காப்பவர்", ch_TAM_4_1_4_8, "பொம்மை காவல்காரர்");

        // Unit: பருவம் 2: ஒற்றுமை & கல்வி
        Unit u_TAM_4_1_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("பருவம் 2: ஒற்றுமை & கல்வி", 5, "Tamil", board, classLevel)));

        // Chapter: ஒற்றுமையே வலிமை
        Chapter ch_TAM_4_1_5_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "பருவம் 2: ஒற்றுமை & கல்வி", 9, "ஒற்றுமையே வலிமை", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "பருவம் 2: ஒற்றுமை & கல்வி", "ஒற்றுமையே வலிமை", ch_TAM_4_1_5_9, "புறாக்கள் கதை");

        // Chapter: வெற்றி வேற்கை
        Chapter ch_TAM_4_1_5_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "பருவம் 2: ஒற்றுமை & கல்வி", 10, "வெற்றி வேற்கை", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "பருவம் 2: ஒற்றுமை & கல்வி", "வெற்றி வேற்கை", ch_TAM_4_1_5_10, "அதிவீரராம பாண்டியர் வாக்கு");

        // Unit: பருவம் 2: மொழிப்பயிற்சி
        Unit u_TAM_4_1_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("பருவம் 2: மொழிப்பயிற்சி", 6, "Tamil", board, classLevel)));

        // Chapter: வேற்றுமை உருபுகள்
        Chapter ch_TAM_4_1_6_11 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 11)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "பருவம் 2: மொழிப்பயிற்சி", 11, "வேற்றுமை உருபுகள்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "பருவம் 2: மொழிப்பயிற்சி", "வேற்றுமை உருபுகள்", ch_TAM_4_1_6_11, "தமிழ் இலக்கணம்");

        // Unit: பருவம் 3: இயற்கை வளம்
        Unit u_TAM_4_1_7 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 7).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("பருவம் 3: இயற்கை வளம்", 7, "Tamil", board, classLevel)));

        // Chapter: விடியும் வேளை
        Chapter ch_TAM_4_1_7_12 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 12)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "பருவம் 3: இயற்கை வளம்", 12, "விடியும் வேளை", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "பருவம் 3: இயற்கை வளம்", "விடியும் வேளை", ch_TAM_4_1_7_12, "கிராமத்து விடியல் இயற்கை");

        // Chapter: உலா வரும் செயற்கைக்கோள்
        Chapter ch_TAM_4_1_7_13 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 13)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "பருவம் 3: இயற்கை வளம்", 13, "உலா வரும் செயற்கைக்கோள்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "பருவம் 3: இயற்கை வளம்", "உலா வரும் செயற்கைக்கோள்", ch_TAM_4_1_7_13, "விண்வெளி அறிவியல்");

        // Unit: பருவம் 3: நீதிநெறி
        Unit u_TAM_4_1_8 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 8).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("பருவம் 3: நீதிநெறி", 8, "Tamil", board, classLevel)));

        // Chapter: நீதிநெறி விளக்கம்
        Chapter ch_TAM_4_1_8_14 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 14)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "பருவம் 3: நீதிநெறி", 14, "நீதிநெறி விளக்கம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "பருவம் 3: நீதிநெறி", "நீதிநெறி விளக்கம்", ch_TAM_4_1_8_14, "குமரகுருபரர் நற்பண்புகள்");

        // Chapter: அப்படியே நிற்கட்டும் அந்த மரம்
        Chapter ch_TAM_4_1_8_15 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 15)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "பருவம் 3: நீதிநெறி", 15, "அப்படியே நிற்கட்டும் அந்த மரம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "பருவம் 3: நீதிநெறி", "அப்படியே நிற்கட்டும் அந்த மரம்", ch_TAM_4_1_8_15, "இயற்கை பாதுகாப்பு");

        // Unit: பருவம் 3: நல்வழி
        Unit u_TAM_4_1_9 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 9).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("பருவம் 3: நல்வழி", 9, "Tamil", board, classLevel)));

        // Chapter: நல்வழி
        Chapter ch_TAM_4_1_9_16 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 16)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "பருவம் 3: நல்வழி", 16, "நல்வழி", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "பருவம் 3: நல்வழி", "நல்வழி", ch_TAM_4_1_9_16, "ஔவையார் அறப்பாடல்கள்");

        // Chapter: ஆகுபெயர் & சொல்வளம்
        Chapter ch_TAM_4_1_9_17 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 17)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "பருவம் 3: நல்வழி", 17, "ஆகுபெயர் & சொல்வளம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "பருவம் 3: நல்வழி", "ஆகுபெயர் & சொல்வளம்", ch_TAM_4_1_9_17, "இலக்கணப் பயிற்சி");

        // Subject: English
        Subject sub_ENG_4_2 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "English")
                .orElseGet(() -> subjectRepository.save(new Subject("English", "ENG", "📚", "#fa8231", board, classLevel)));

        // Unit: Term 1: Unit 1 – Learning & Adventure
        Unit u_ENG_4_2_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 1: Unit 1 – Learning & Adventure", 1, "English", board, classLevel)));

        // Chapter: Prose 1: Inspiring Journeys (Std 4)
        Chapter ch_ENG_4_2_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 1: Unit 1 – Learning & Adventure", 1, "Prose 1: Inspiring Journeys (Std 4)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 1: Unit 1 – Learning & Adventure", "Prose 1: Inspiring Journeys (Std 4)", ch_ENG_4_2_1_1, "Vocabulary & Reading");

        // Chapter: Poem 1: Nature's Melody (Std 4)
        Chapter ch_ENG_4_2_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 1: Unit 1 – Learning & Adventure", 2, "Poem 1: Nature's Melody (Std 4)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 1: Unit 1 – Learning & Adventure", "Poem 1: Nature's Melody (Std 4)", ch_ENG_4_2_1_2, "Rhyme Scheme & Figures of Speech");

        // Unit: Term 1: Unit 2 – Values & Courage
        Unit u_ENG_4_2_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 1: Unit 2 – Values & Courage", 2, "English", board, classLevel)));

        // Chapter: Prose 2: Acts of Bravery (Std 4)
        Chapter ch_ENG_4_2_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 1: Unit 2 – Values & Courage", 3, "Prose 2: Acts of Bravery (Std 4)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 1: Unit 2 – Values & Courage", "Prose 2: Acts of Bravery (Std 4)", ch_ENG_4_2_2_3, "Grammar & Direct Indirect Speech");

        // Chapter: Supplementary: Life Lessons (Std 4)
        Chapter ch_ENG_4_2_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 1: Unit 2 – Values & Courage", 4, "Supplementary: Life Lessons (Std 4)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 1: Unit 2 – Values & Courage", "Supplementary: Life Lessons (Std 4)", ch_ENG_4_2_2_4, "Character Sketches & Morals");

        // Unit: Term 2: Unit 3 – Art, Culture & Heritage
        Unit u_ENG_4_2_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 2: Unit 3 – Art, Culture & Heritage", 3, "English", board, classLevel)));

        // Chapter: Prose 3: Treasures of History (Std 4)
        Chapter ch_ENG_4_2_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 2: Unit 3 – Art, Culture & Heritage", 5, "Prose 3: Treasures of History (Std 4)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 2: Unit 3 – Art, Culture & Heritage", "Prose 3: Treasures of History (Std 4)", ch_ENG_4_2_3_5, "Comprehension & Essay Writing");

        // Chapter: Poem 2: Echoes of the Past (Std 4)
        Chapter ch_ENG_4_2_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 2: Unit 3 – Art, Culture & Heritage", 6, "Poem 2: Echoes of the Past (Std 4)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 2: Unit 3 – Art, Culture & Heritage", "Poem 2: Echoes of the Past (Std 4)", ch_ENG_4_2_3_6, "Metaphors & Imagery");

        // Unit: Term 2: Unit 4 – Science & Tomorrow
        Unit u_ENG_4_2_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 2: Unit 4 – Science & Tomorrow", 4, "English", board, classLevel)));

        // Chapter: Prose 4: Innovations Changing Lives (Std 4)
        Chapter ch_ENG_4_2_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 2: Unit 4 – Science & Tomorrow", 7, "Prose 4: Innovations Changing Lives (Std 4)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 2: Unit 4 – Science & Tomorrow", "Prose 4: Innovations Changing Lives (Std 4)", ch_ENG_4_2_4_7, "Active Passive Voice & Tenses");

        // Chapter: Supplementary: Dreams into Reality (Std 4)
        Chapter ch_ENG_4_2_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 2: Unit 4 – Science & Tomorrow", 8, "Supplementary: Dreams into Reality (Std 4)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 2: Unit 4 – Science & Tomorrow", "Supplementary: Dreams into Reality (Std 4)", ch_ENG_4_2_4_8, "Plot Summary & Analysis");

        // Unit: Term 3: Unit 5 – Environment & Harmony
        Unit u_ENG_4_2_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 3: Unit 5 – Environment & Harmony", 5, "English", board, classLevel)));

        // Chapter: Prose 5: Guardians of Nature (Std 4)
        Chapter ch_ENG_4_2_5_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 3: Unit 5 – Environment & Harmony", 9, "Prose 5: Guardians of Nature (Std 4)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 3: Unit 5 – Environment & Harmony", "Prose 5: Guardians of Nature (Std 4)", ch_ENG_4_2_5_9, "Clauses & Conjunctions");

        // Chapter: Poem 3: The Green Earth (Std 4)
        Chapter ch_ENG_4_2_5_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 3: Unit 5 – Environment & Harmony", 10, "Poem 3: The Green Earth (Std 4)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 3: Unit 5 – Environment & Harmony", "Poem 3: The Green Earth (Std 4)", ch_ENG_4_2_5_10, "Poetic Appreciation");

        // Unit: Term 3: Unit 6 – Humanity & Sports
        Unit u_ENG_4_2_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 3: Unit 6 – Humanity & Sports", 6, "English", board, classLevel)));

        // Chapter: Prose 6: Champions of the Game (Std 4)
        Chapter ch_ENG_4_2_6_11 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 11)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 3: Unit 6 – Humanity & Sports", 11, "Prose 6: Champions of the Game (Std 4)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 3: Unit 6 – Humanity & Sports", "Prose 6: Champions of the Game (Std 4)", ch_ENG_4_2_6_11, "Formal Letter & Report Writing");

        // Chapter: Supplementary: Triumph of Will (Std 4)
        Chapter ch_ENG_4_2_6_12 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 12)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 3: Unit 6 – Humanity & Sports", 12, "Supplementary: Triumph of Will (Std 4)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 3: Unit 6 – Humanity & Sports", "Supplementary: Triumph of Will (Std 4)", ch_ENG_4_2_6_12, "Theme & Message");

        // Subject: Mathematics
        Subject sub_MATH_4_3 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Mathematics")
                .orElseGet(() -> subjectRepository.save(new Subject("Mathematics", "MATH", "📐", "#4834d4", board, classLevel)));

        // Unit: Unit 1: Geometry & Shapes
        Unit u_MATH_4_3_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Geometry & Shapes", 1, "Mathematics", board, classLevel)));

        // Chapter: 2D and 3D Shapes & Angles
        Chapter ch_MATH_4_3_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 1: Geometry & Shapes", 1, "2D and 3D Shapes & Angles", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 1: Geometry & Shapes", "2D and 3D Shapes & Angles", ch_MATH_4_3_1_1, "Perimeter & Properties of Figures");

        // Unit: Unit 2: Numbers & Operations
        Unit u_MATH_4_3_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Numbers & Operations", 2, "Mathematics", board, classLevel)));

        // Chapter: Large Numbers, Addition & Subtraction
        Chapter ch_MATH_4_3_2_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 2: Numbers & Operations", 2, "Large Numbers, Addition & Subtraction", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 2: Numbers & Operations", "Large Numbers, Addition & Subtraction", ch_MATH_4_3_2_2, "Place Value & Arithmetic Operations");

        // Chapter: Multiplication & Division
        Chapter ch_MATH_4_3_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 2: Numbers & Operations", 3, "Multiplication & Division", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 2: Numbers & Operations", "Multiplication & Division", ch_MATH_4_3_2_3, "Word Problems & Estimation");

        // Unit: Unit 3: Patterns & Symmetry
        Unit u_MATH_4_3_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Patterns & Symmetry", 3, "Mathematics", board, classLevel)));

        // Chapter: Patterns in Shapes and Numbers
        Chapter ch_MATH_4_3_3_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 3: Patterns & Symmetry", 4, "Patterns in Shapes and Numbers", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 3: Patterns & Symmetry", "Patterns in Shapes and Numbers", ch_MATH_4_3_3_4, "Symmetry Lines & Sequences");

        // Unit: Unit 4: Measurements & Metric System
        Unit u_MATH_4_3_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Measurements & Metric System", 4, "Mathematics", board, classLevel)));

        // Chapter: Length, Weight & Capacity
        Chapter ch_MATH_4_3_4_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 4: Measurements & Metric System", 5, "Length, Weight & Capacity", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 4: Measurements & Metric System", "Length, Weight & Capacity", ch_MATH_4_3_4_5, "Metric Conversions & Real-life sums");

        // Unit: Unit 5: Time, Money & Fractions
        Unit u_MATH_4_3_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 5: Time, Money & Fractions", 5, "Mathematics", board, classLevel)));

        // Chapter: Time Calculation & Money Transactions
        Chapter ch_MATH_4_3_5_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 5: Time, Money & Fractions", 6, "Time Calculation & Money Transactions", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 5: Time, Money & Fractions", "Time Calculation & Money Transactions", ch_MATH_4_3_5_6, "Fractions & Basic Decimals");

        // Unit: Unit 6: Information Processing
        Unit u_MATH_4_3_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 6: Information Processing", 6, "Mathematics", board, classLevel)));

        // Chapter: Data Handling & Bar Charts
        Chapter ch_MATH_4_3_6_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 6: Information Processing", 7, "Data Handling & Bar Charts", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 6: Information Processing", "Data Handling & Bar Charts", ch_MATH_4_3_6_7, "Tables, Tally Marks & Representation");

        // Subject: Science
        Subject sub_SCI_4_4 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Science")
                .orElseGet(() -> subjectRepository.save(new Subject("Science", "SCI", "🔬", "#eb4d4b", board, classLevel)));

        // Unit: Unit 1: Living World – Plants & Animals
        Unit u_SCI_4_4_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Living World – Plants & Animals", 1, "Science", board, classLevel)));

        // Chapter: Plant Life, Flowers & Seeds
        Chapter ch_SCI_4_4_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 1: Living World – Plants & Animals", 1, "Plant Life, Flowers & Seeds", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 1: Living World – Plants & Animals", "Plant Life, Flowers & Seeds", ch_SCI_4_4_1_1, "Photosynthesis, Parts of Plants & Seed Germination");

        // Chapter: Animal Classification & Habitats
        Chapter ch_SCI_4_4_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 1: Living World – Plants & Animals", 2, "Animal Classification & Habitats", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 1: Living World – Plants & Animals", "Animal Classification & Habitats", ch_SCI_4_4_1_2, "Vertebrates, Invertebrates & Adaptation");

        // Unit: Unit 2: Human Body & Organ Systems
        Unit u_SCI_4_4_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Human Body & Organ Systems", 2, "Science", board, classLevel)));

        // Chapter: Internal Organs, Bones & Muscles
        Chapter ch_SCI_4_4_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 2: Human Body & Organ Systems", 3, "Internal Organs, Bones & Muscles", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 2: Human Body & Organ Systems", "Internal Organs, Bones & Muscles", ch_SCI_4_4_2_3, "Brain, Heart, Lungs, Stomach & Digestion");

        // Chapter: Sense Organs, Health & Hygiene
        Chapter ch_SCI_4_4_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 2: Human Body & Organ Systems", 4, "Sense Organs, Health & Hygiene", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 2: Human Body & Organ Systems", "Sense Organs, Health & Hygiene", ch_SCI_4_4_2_4, "Eyes, Ears, Skin care & Cleanliness");

        // Unit: Unit 3: Matter, Energy & Forces
        Unit u_SCI_4_4_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Matter, Energy & Forces", 3, "Science", board, classLevel)));

        // Chapter: States of Matter & Materials
        Chapter ch_SCI_4_4_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 3: Matter, Energy & Forces", 5, "States of Matter & Materials", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 3: Matter, Energy & Forces", "States of Matter & Materials", ch_SCI_4_4_3_5, "Solids, Liquids, Gases & Changes");

        // Chapter: Work, Energy & Simple Machines
        Chapter ch_SCI_4_4_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 3: Matter, Energy & Forces", 6, "Work, Energy & Simple Machines", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 3: Matter, Energy & Forces", "Work, Energy & Simple Machines", ch_SCI_4_4_3_6, "Lever, Pulley, Wheel & Energy Forms");

        // Unit: Unit 4: Air, Water & Environmental Care
        Unit u_SCI_4_4_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Air, Water & Environmental Care", 4, "Science", board, classLevel)));

        // Chapter: Air Composition & Properties
        Chapter ch_SCI_4_4_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 4: Air, Water & Environmental Care", 7, "Air Composition & Properties", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 4: Air, Water & Environmental Care", "Air Composition & Properties", ch_SCI_4_4_4_7, "Oxygen, Carbon Dioxide & Atmosphere");

        // Chapter: Water Cycle & Conservation
        Chapter ch_SCI_4_4_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 4: Air, Water & Environmental Care", 8, "Water Cycle & Conservation", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 4: Air, Water & Environmental Care", "Water Cycle & Conservation", ch_SCI_4_4_4_8, "Evaporation, Condensation & Rainwater Harvesting");

        // Unit: Unit 5: Science in Everyday Life
        Unit u_SCI_4_4_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 5: Science in Everyday Life", 5, "Science", board, classLevel)));

        // Chapter: Kitchen Science, Medicines & Clothes
        Chapter ch_SCI_4_4_5_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 5: Science in Everyday Life", 9, "Kitchen Science, Medicines & Clothes", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 5: Science in Everyday Life", "Kitchen Science, Medicines & Clothes", ch_SCI_4_4_5_9, "Natural Fibres, Hygiene & Home Remedies");

        // Subject: Social Science
        Subject sub_SOC_4_5 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Social Science")
                .orElseGet(() -> subjectRepository.save(new Subject("Social Science", "SOC", "🌍", "#10ac84", board, classLevel)));

        // Unit: Unit 1: Earth, Continents & Oceans
        Unit u_SOC_4_5_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Earth, Continents & Oceans", 1, "Social Science", board, classLevel)));

        // Chapter: Our Planet Earth, Continents & Oceans
        Chapter ch_SOC_4_5_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 1: Earth, Continents & Oceans", 1, "Our Planet Earth, Continents & Oceans", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 1: Earth, Continents & Oceans", "Our Planet Earth, Continents & Oceans", ch_SOC_4_5_1_1, "Globe, Equator, Continents & Oceans");

        // Unit: Unit 2: History – Ancient Tamil Civilisation
        Unit u_SOC_4_5_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: History – Ancient Tamil Civilisation", 2, "Social Science", board, classLevel)));

        // Chapter: Kingdoms of Rivers (Chera, Chola, Pandya, Pallava)
        Chapter ch_SOC_4_5_2_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 2: History – Ancient Tamil Civilisation", 2, "Kingdoms of Rivers (Chera, Chola, Pandya, Pallava)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 2: History – Ancient Tamil Civilisation", "Kingdoms of Rivers (Chera, Chola, Pandya, Pallava)", ch_SOC_4_5_2_2, "Kings, Emblems, Ports & Capital Cities");

        // Chapter: Philanthropists of Ancient Tamilagam (Kadai Ezhu Vallalgal)
        Chapter ch_SOC_4_5_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 2: History – Ancient Tamil Civilisation", 3, "Philanthropists of Ancient Tamilagam (Kadai Ezhu Vallalgal)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 2: History – Ancient Tamil Civilisation", "Philanthropists of Ancient Tamilagam (Kadai Ezhu Vallalgal)", ch_SOC_4_5_2_3, "Pari, Pegan, Kari, Ay, Adiyaman, Nalli, Ori");

        // Unit: Unit 3: Geography – Landforms & Resources
        Unit u_SOC_4_5_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Geography – Landforms & Resources", 3, "Social Science", board, classLevel)));

        // Chapter: Five Landforms of Ancient Tamil Country
        Chapter ch_SOC_4_5_3_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 3: Geography – Landforms & Resources", 4, "Five Landforms of Ancient Tamil Country", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 3: Geography – Landforms & Resources", "Five Landforms of Ancient Tamil Country", ch_SOC_4_5_3_4, "Kurinji, Mullai, Marutham, Neithal, Palai");

        // Chapter: Atmosphere, Weather & Water Wealth
        Chapter ch_SOC_4_5_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 3: Geography – Landforms & Resources", 5, "Atmosphere, Weather & Water Wealth", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 3: Geography – Landforms & Resources", "Atmosphere, Weather & Water Wealth", ch_SOC_4_5_3_5, "Monsoon, Rivers of Tamil Nadu & Rain");

        // Unit: Unit 4: Civics – Duties, Rights & Governance
        Unit u_SOC_4_5_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Civics – Duties, Rights & Governance", 4, "Social Science", board, classLevel)));

        // Chapter: Municipalities, Corporations & Local Governance
        Chapter ch_SOC_4_5_4_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 4: Civics – Duties, Rights & Governance", 6, "Municipalities, Corporations & Local Governance", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 4: Civics – Duties, Rights & Governance", "Municipalities, Corporations & Local Governance", ch_SOC_4_5_4_6, "Mayor, Commissioner, Wards & Citizen Duties");

        // Chapter: Rights and Duties of a Good Citizen
        Chapter ch_SOC_4_5_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 4: Civics – Duties, Rights & Governance", 7, "Rights and Duties of a Good Citizen", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 4: Civics – Duties, Rights & Governance", "Rights and Duties of a Good Citizen", ch_SOC_4_5_4_7, "Fundamental Duties, Traffic Safety & Harmony");

    }

    private void seed_STATE_BOARD_Class_5() {
        String board = "STATE_BOARD";
        int classLevel = 5;

        // Subject: Tamil
        Subject sub_TAM_5_1 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Tamil")
                .orElseGet(() -> subjectRepository.save(new Subject("Tamil", "TAM", "📖", "#e84118", board, classLevel)));

        // Unit: பருவம் 1: தமிழின் இனிமை
        Unit u_TAM_5_1_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("பருவம் 1: தமிழின் இனிமை", 1, "Tamil", board, classLevel)));

        // Chapter: தமிழின் இனிமை
        Chapter ch_TAM_5_1_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "பருவம் 1: தமிழின் இனிமை", 1, "தமிழின் இனிமை", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "பருவம் 1: தமிழின் இனிமை", "தமிழின் இனிமை", ch_TAM_5_1_1_1, "பாரதிதாசன் கவிதை");

        // Chapter: மரபுச் சொற்கள்
        Chapter ch_TAM_5_1_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "பருவம் 1: தமிழின் இனிமை", 2, "மரபுச் சொற்கள்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "பருவம் 1: தமிழின் இனிமை", "மரபுச் சொற்கள்", ch_TAM_5_1_1_2, "ஒலி & வினை மரபுகள்");

        // Unit: பருவம் 1: கவிதைப் பட்டிமன்றம்
        Unit u_TAM_5_1_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("பருவம் 1: கவிதைப் பட்டிமன்றம்", 2, "Tamil", board, classLevel)));

        // Chapter: அறிவா? பண்பா?
        Chapter ch_TAM_5_1_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "பருவம் 1: கவிதைப் பட்டிமன்றம்", 3, "அறிவா? பண்பா?", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "பருவம் 1: கவிதைப் பட்டிமன்றம்", "அறிவா? பண்பா?", ch_TAM_5_1_2_3, "பட்டிமன்ற வாதங்கள்");

        // Chapter: என்ன சத்தம்?
        Chapter ch_TAM_5_1_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "பருவம் 1: கவிதைப் பட்டிமன்றம்", 4, "என்ன சத்தம்?", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "பருவம் 1: கவிதைப் பட்டிமன்றம்", "என்ன சத்தம்?", ch_TAM_5_1_2_4, "விலங்கு பறவை ஒலி மரபு");

        // Unit: பருவம் 1: கல்விச் சிறப்பு
        Unit u_TAM_5_1_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("பருவம் 1: கல்விச் சிறப்பு", 3, "Tamil", board, classLevel)));

        // Chapter: கல்விச் செல்வம்
        Chapter ch_TAM_5_1_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "பருவம் 1: கல்விச் சிறப்பு", 5, "கல்விச் செல்வம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "பருவம் 1: கல்விச் சிறப்பு", "கல்விச் செல்வம்", ch_TAM_5_1_3_5, "பொருட்செல்வமும் கல்விச்செல்வமும்");

        // Chapter: வறுமையிலும் நேர்மை
        Chapter ch_TAM_5_1_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "பருவம் 1: கல்விச் சிறப்பு", 6, "வறுமையிலும் நேர்மை", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "பருவம் 1: கல்விச் சிறப்பு", "வறுமையிலும் நேர்மை", ch_TAM_5_1_3_6, "நற்குணக் கதை");

        // Unit: பருவம் 2: கடலின் பெருமை
        Unit u_TAM_5_1_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("பருவம் 2: கடலின் பெருமை", 4, "Tamil", board, classLevel)));

        // Chapter: கடல்
        Chapter ch_TAM_5_1_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "பருவம் 2: கடலின் பெருமை", 7, "கடல்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "பருவம் 2: கடலின் பெருமை", "கடல்", ch_TAM_5_1_4_7, "கவிமணி தேசிக விநாயகம் பிள்ளை");

        // Chapter: திருக்குறள் கதைகள்
        Chapter ch_TAM_5_1_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "பருவம் 2: கடலின் பெருமை", 8, "திருக்குறள் கதைகள்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "பருவம் 2: கடலின் பெருமை", "திருக்குறள் கதைகள்", ch_TAM_5_1_4_8, "அன்புடைமை & இனியவை கூறல்");

        // Unit: பருவம் 2: மூதுரை
        Unit u_TAM_5_1_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("பருவம் 2: மூதுரை", 5, "Tamil", board, classLevel)));

        // Chapter: மூதுரை
        Chapter ch_TAM_5_1_5_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "பருவம் 2: மூதுரை", 9, "மூதுரை", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "பருவம் 2: மூதுரை", "மூதுரை", ch_TAM_5_1_5_9, "ஔவையார் நல்வழிக் கருத்துகள்");

        // Chapter: கங்கை கொண்ட சோழபுரம்
        Chapter ch_TAM_5_1_5_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "பருவம் 2: மூதுரை", 10, "கங்கை கொண்ட சோழபுரம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "பருவம் 2: மூதுரை", "கங்கை கொண்ட சோழபுரம்", ch_TAM_5_1_5_10, "இராசேந்திர சோழன் வரலாறு");

        // Unit: பருவம் 2: தொடர் இலக்கணம்
        Unit u_TAM_5_1_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("பருவம் 2: தொடர் இலக்கணம்", 6, "Tamil", board, classLevel)));

        // Chapter: எழுவாய், பயனிலை, செயப்படுபொருள்
        Chapter ch_TAM_5_1_6_11 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 11)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "பருவம் 2: தொடர் இலக்கணம்", 11, "எழுவாய், பயனிலை, செயப்படுபொருள்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "பருவம் 2: தொடர் இலக்கணம்", "எழுவாய், பயனிலை, செயப்படுபொருள்", ch_TAM_5_1_6_11, "தமிழ் இலக்கண அமைப்பு");

        // Unit: பருவம் 3: தலைமைப் பண்பு
        Unit u_TAM_5_1_7 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 7).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("பருவம் 3: தலைமைப் பண்பு", 7, "Tamil", board, classLevel)));

        // Chapter: சிறுபஞ்சமூலம்
        Chapter ch_TAM_5_1_7_12 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 12)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "பருவம் 3: தலைமைப் பண்பு", 12, "சிறுபஞ்சமூலம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "பருவம் 3: தலைமைப் பண்பு", "சிறுபஞ்சமூலம்", ch_TAM_5_1_7_12, "காரியாசான் நீதிப்பாடல்");

        // Chapter: தலைமைப் பண்பு
        Chapter ch_TAM_5_1_7_13 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 13)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "பருவம் 3: தலைமைப் பண்பு", 13, "தலைமைப் பண்பு", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "பருவம் 3: தலைமைப் பண்பு", "தலைமைப் பண்பு", ch_TAM_5_1_7_13, "ஊர்த்தலைவர் தேர்வு");

        // Unit: பருவம் 3: அறநெறிச்சாரம்
        Unit u_TAM_5_1_8 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 8).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("பருவம் 3: அறநெறிச்சாரம்", 8, "Tamil", board, classLevel)));

        // Chapter: அறநெறிச்சாரம்
        Chapter ch_TAM_5_1_8_14 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 14)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "பருவம் 3: அறநெறிச்சாரம்", 14, "அறநெறிச்சாரம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "பருவம் 3: அறநெறிச்சாரம்", "அறநெறிச்சாரம்", ch_TAM_5_1_8_14, "முனைப்பாடியார் வாக்கு");

        // Chapter: நற்பண்பு
        Chapter ch_TAM_5_1_8_15 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 15)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "பருவம் 3: அறநெறிச்சாரம்", 15, "நற்பண்பு", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "பருவம் 3: அறநெறிச்சாரம்", "நற்பண்பு", ch_TAM_5_1_8_15, "வாழ்க்கை வழிகாட்டி");

        // Unit: பருவம் 3: மொழியோடு விளையாடு
        Unit u_TAM_5_1_9 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 9).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("பருவம் 3: மொழியோடு விளையாடு", 9, "Tamil", board, classLevel)));

        // Chapter: நீதிநெறி நன்மொழிகள்
        Chapter ch_TAM_5_1_9_16 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 16)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "பருவம் 3: மொழியோடு விளையாடு", 16, "நீதிநெறி நன்மொழிகள்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "பருவம் 3: மொழியோடு விளையாடு", "நீதிநெறி நன்மொழிகள்", ch_TAM_5_1_9_16, "நற்பண்புச் சுடர்");

        // Chapter: மயங்கொலிச் சொற்கள்
        Chapter ch_TAM_5_1_9_17 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 17)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "பருவம் 3: மொழியோடு விளையாடு", 17, "மயங்கொலிச் சொற்கள்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "பருவம் 3: மொழியோடு விளையாடு", "மயங்கொலிச் சொற்கள்", ch_TAM_5_1_9_17, "ர/ற, ல/ள/ழ, ந/ண/ன வேறுபாடுகள்");

        // Subject: English
        Subject sub_ENG_5_2 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "English")
                .orElseGet(() -> subjectRepository.save(new Subject("English", "ENG", "📚", "#fa8231", board, classLevel)));

        // Unit: Term 1: Unit 1 – Learning & Adventure
        Unit u_ENG_5_2_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 1: Unit 1 – Learning & Adventure", 1, "English", board, classLevel)));

        // Chapter: Prose 1: Inspiring Journeys (Std 5)
        Chapter ch_ENG_5_2_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 1: Unit 1 – Learning & Adventure", 1, "Prose 1: Inspiring Journeys (Std 5)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 1: Unit 1 – Learning & Adventure", "Prose 1: Inspiring Journeys (Std 5)", ch_ENG_5_2_1_1, "Vocabulary & Reading");

        // Chapter: Poem 1: Nature's Melody (Std 5)
        Chapter ch_ENG_5_2_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 1: Unit 1 – Learning & Adventure", 2, "Poem 1: Nature's Melody (Std 5)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 1: Unit 1 – Learning & Adventure", "Poem 1: Nature's Melody (Std 5)", ch_ENG_5_2_1_2, "Rhyme Scheme & Figures of Speech");

        // Unit: Term 1: Unit 2 – Values & Courage
        Unit u_ENG_5_2_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 1: Unit 2 – Values & Courage", 2, "English", board, classLevel)));

        // Chapter: Prose 2: Acts of Bravery (Std 5)
        Chapter ch_ENG_5_2_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 1: Unit 2 – Values & Courage", 3, "Prose 2: Acts of Bravery (Std 5)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 1: Unit 2 – Values & Courage", "Prose 2: Acts of Bravery (Std 5)", ch_ENG_5_2_2_3, "Grammar & Direct Indirect Speech");

        // Chapter: Supplementary: Life Lessons (Std 5)
        Chapter ch_ENG_5_2_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 1: Unit 2 – Values & Courage", 4, "Supplementary: Life Lessons (Std 5)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 1: Unit 2 – Values & Courage", "Supplementary: Life Lessons (Std 5)", ch_ENG_5_2_2_4, "Character Sketches & Morals");

        // Unit: Term 2: Unit 3 – Art, Culture & Heritage
        Unit u_ENG_5_2_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 2: Unit 3 – Art, Culture & Heritage", 3, "English", board, classLevel)));

        // Chapter: Prose 3: Treasures of History (Std 5)
        Chapter ch_ENG_5_2_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 2: Unit 3 – Art, Culture & Heritage", 5, "Prose 3: Treasures of History (Std 5)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 2: Unit 3 – Art, Culture & Heritage", "Prose 3: Treasures of History (Std 5)", ch_ENG_5_2_3_5, "Comprehension & Essay Writing");

        // Chapter: Poem 2: Echoes of the Past (Std 5)
        Chapter ch_ENG_5_2_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 2: Unit 3 – Art, Culture & Heritage", 6, "Poem 2: Echoes of the Past (Std 5)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 2: Unit 3 – Art, Culture & Heritage", "Poem 2: Echoes of the Past (Std 5)", ch_ENG_5_2_3_6, "Metaphors & Imagery");

        // Unit: Term 2: Unit 4 – Science & Tomorrow
        Unit u_ENG_5_2_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 2: Unit 4 – Science & Tomorrow", 4, "English", board, classLevel)));

        // Chapter: Prose 4: Innovations Changing Lives (Std 5)
        Chapter ch_ENG_5_2_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 2: Unit 4 – Science & Tomorrow", 7, "Prose 4: Innovations Changing Lives (Std 5)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 2: Unit 4 – Science & Tomorrow", "Prose 4: Innovations Changing Lives (Std 5)", ch_ENG_5_2_4_7, "Active Passive Voice & Tenses");

        // Chapter: Supplementary: Dreams into Reality (Std 5)
        Chapter ch_ENG_5_2_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 2: Unit 4 – Science & Tomorrow", 8, "Supplementary: Dreams into Reality (Std 5)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 2: Unit 4 – Science & Tomorrow", "Supplementary: Dreams into Reality (Std 5)", ch_ENG_5_2_4_8, "Plot Summary & Analysis");

        // Unit: Term 3: Unit 5 – Environment & Harmony
        Unit u_ENG_5_2_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 3: Unit 5 – Environment & Harmony", 5, "English", board, classLevel)));

        // Chapter: Prose 5: Guardians of Nature (Std 5)
        Chapter ch_ENG_5_2_5_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 3: Unit 5 – Environment & Harmony", 9, "Prose 5: Guardians of Nature (Std 5)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 3: Unit 5 – Environment & Harmony", "Prose 5: Guardians of Nature (Std 5)", ch_ENG_5_2_5_9, "Clauses & Conjunctions");

        // Chapter: Poem 3: The Green Earth (Std 5)
        Chapter ch_ENG_5_2_5_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 3: Unit 5 – Environment & Harmony", 10, "Poem 3: The Green Earth (Std 5)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 3: Unit 5 – Environment & Harmony", "Poem 3: The Green Earth (Std 5)", ch_ENG_5_2_5_10, "Poetic Appreciation");

        // Unit: Term 3: Unit 6 – Humanity & Sports
        Unit u_ENG_5_2_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 3: Unit 6 – Humanity & Sports", 6, "English", board, classLevel)));

        // Chapter: Prose 6: Champions of the Game (Std 5)
        Chapter ch_ENG_5_2_6_11 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 11)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 3: Unit 6 – Humanity & Sports", 11, "Prose 6: Champions of the Game (Std 5)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 3: Unit 6 – Humanity & Sports", "Prose 6: Champions of the Game (Std 5)", ch_ENG_5_2_6_11, "Formal Letter & Report Writing");

        // Chapter: Supplementary: Triumph of Will (Std 5)
        Chapter ch_ENG_5_2_6_12 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 12)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 3: Unit 6 – Humanity & Sports", 12, "Supplementary: Triumph of Will (Std 5)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 3: Unit 6 – Humanity & Sports", "Supplementary: Triumph of Will (Std 5)", ch_ENG_5_2_6_12, "Theme & Message");

        // Subject: Mathematics
        Subject sub_MATH_5_3 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Mathematics")
                .orElseGet(() -> subjectRepository.save(new Subject("Mathematics", "MATH", "📐", "#4834d4", board, classLevel)));

        // Unit: Unit 1: Geometry & Shapes
        Unit u_MATH_5_3_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Geometry & Shapes", 1, "Mathematics", board, classLevel)));

        // Chapter: 2D and 3D Shapes & Angles
        Chapter ch_MATH_5_3_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 1: Geometry & Shapes", 1, "2D and 3D Shapes & Angles", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 1: Geometry & Shapes", "2D and 3D Shapes & Angles", ch_MATH_5_3_1_1, "Perimeter & Properties of Figures");

        // Unit: Unit 2: Numbers & Operations
        Unit u_MATH_5_3_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Numbers & Operations", 2, "Mathematics", board, classLevel)));

        // Chapter: Large Numbers, Addition & Subtraction
        Chapter ch_MATH_5_3_2_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 2: Numbers & Operations", 2, "Large Numbers, Addition & Subtraction", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 2: Numbers & Operations", "Large Numbers, Addition & Subtraction", ch_MATH_5_3_2_2, "Place Value & Arithmetic Operations");

        // Chapter: Multiplication & Division
        Chapter ch_MATH_5_3_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 2: Numbers & Operations", 3, "Multiplication & Division", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 2: Numbers & Operations", "Multiplication & Division", ch_MATH_5_3_2_3, "Word Problems & Estimation");

        // Unit: Unit 3: Patterns & Symmetry
        Unit u_MATH_5_3_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Patterns & Symmetry", 3, "Mathematics", board, classLevel)));

        // Chapter: Patterns in Shapes and Numbers
        Chapter ch_MATH_5_3_3_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 3: Patterns & Symmetry", 4, "Patterns in Shapes and Numbers", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 3: Patterns & Symmetry", "Patterns in Shapes and Numbers", ch_MATH_5_3_3_4, "Symmetry Lines & Sequences");

        // Unit: Unit 4: Measurements & Metric System
        Unit u_MATH_5_3_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Measurements & Metric System", 4, "Mathematics", board, classLevel)));

        // Chapter: Length, Weight & Capacity
        Chapter ch_MATH_5_3_4_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 4: Measurements & Metric System", 5, "Length, Weight & Capacity", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 4: Measurements & Metric System", "Length, Weight & Capacity", ch_MATH_5_3_4_5, "Metric Conversions & Real-life sums");

        // Unit: Unit 5: Time, Money & Fractions
        Unit u_MATH_5_3_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 5: Time, Money & Fractions", 5, "Mathematics", board, classLevel)));

        // Chapter: Time Calculation & Money Transactions
        Chapter ch_MATH_5_3_5_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 5: Time, Money & Fractions", 6, "Time Calculation & Money Transactions", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 5: Time, Money & Fractions", "Time Calculation & Money Transactions", ch_MATH_5_3_5_6, "Fractions & Basic Decimals");

        // Unit: Unit 6: Information Processing
        Unit u_MATH_5_3_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 6: Information Processing", 6, "Mathematics", board, classLevel)));

        // Chapter: Data Handling & Bar Charts
        Chapter ch_MATH_5_3_6_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 6: Information Processing", 7, "Data Handling & Bar Charts", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 6: Information Processing", "Data Handling & Bar Charts", ch_MATH_5_3_6_7, "Tables, Tally Marks & Representation");

        // Subject: Science
        Subject sub_SCI_5_4 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Science")
                .orElseGet(() -> subjectRepository.save(new Subject("Science", "SCI", "🔬", "#eb4d4b", board, classLevel)));

        // Unit: Unit 1: Living World – Plants & Animals
        Unit u_SCI_5_4_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Living World – Plants & Animals", 1, "Science", board, classLevel)));

        // Chapter: Plant Life, Flowers & Seeds
        Chapter ch_SCI_5_4_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 1: Living World – Plants & Animals", 1, "Plant Life, Flowers & Seeds", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 1: Living World – Plants & Animals", "Plant Life, Flowers & Seeds", ch_SCI_5_4_1_1, "Photosynthesis, Parts of Plants & Seed Germination");

        // Chapter: Animal Classification & Habitats
        Chapter ch_SCI_5_4_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 1: Living World – Plants & Animals", 2, "Animal Classification & Habitats", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 1: Living World – Plants & Animals", "Animal Classification & Habitats", ch_SCI_5_4_1_2, "Vertebrates, Invertebrates & Adaptation");

        // Unit: Unit 2: Human Body & Organ Systems
        Unit u_SCI_5_4_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Human Body & Organ Systems", 2, "Science", board, classLevel)));

        // Chapter: Internal Organs, Bones & Muscles
        Chapter ch_SCI_5_4_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 2: Human Body & Organ Systems", 3, "Internal Organs, Bones & Muscles", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 2: Human Body & Organ Systems", "Internal Organs, Bones & Muscles", ch_SCI_5_4_2_3, "Brain, Heart, Lungs, Stomach & Digestion");

        // Chapter: Sense Organs, Health & Hygiene
        Chapter ch_SCI_5_4_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 2: Human Body & Organ Systems", 4, "Sense Organs, Health & Hygiene", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 2: Human Body & Organ Systems", "Sense Organs, Health & Hygiene", ch_SCI_5_4_2_4, "Eyes, Ears, Skin care & Cleanliness");

        // Unit: Unit 3: Matter, Energy & Forces
        Unit u_SCI_5_4_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Matter, Energy & Forces", 3, "Science", board, classLevel)));

        // Chapter: States of Matter & Materials
        Chapter ch_SCI_5_4_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 3: Matter, Energy & Forces", 5, "States of Matter & Materials", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 3: Matter, Energy & Forces", "States of Matter & Materials", ch_SCI_5_4_3_5, "Solids, Liquids, Gases & Changes");

        // Chapter: Work, Energy & Simple Machines
        Chapter ch_SCI_5_4_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 3: Matter, Energy & Forces", 6, "Work, Energy & Simple Machines", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 3: Matter, Energy & Forces", "Work, Energy & Simple Machines", ch_SCI_5_4_3_6, "Lever, Pulley, Wheel & Energy Forms");

        // Unit: Unit 4: Air, Water & Environmental Care
        Unit u_SCI_5_4_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Air, Water & Environmental Care", 4, "Science", board, classLevel)));

        // Chapter: Air Composition & Properties
        Chapter ch_SCI_5_4_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 4: Air, Water & Environmental Care", 7, "Air Composition & Properties", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 4: Air, Water & Environmental Care", "Air Composition & Properties", ch_SCI_5_4_4_7, "Oxygen, Carbon Dioxide & Atmosphere");

        // Chapter: Water Cycle & Conservation
        Chapter ch_SCI_5_4_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 4: Air, Water & Environmental Care", 8, "Water Cycle & Conservation", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 4: Air, Water & Environmental Care", "Water Cycle & Conservation", ch_SCI_5_4_4_8, "Evaporation, Condensation & Rainwater Harvesting");

        // Unit: Unit 5: Science in Everyday Life
        Unit u_SCI_5_4_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 5: Science in Everyday Life", 5, "Science", board, classLevel)));

        // Chapter: Kitchen Science, Medicines & Clothes
        Chapter ch_SCI_5_4_5_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 5: Science in Everyday Life", 9, "Kitchen Science, Medicines & Clothes", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 5: Science in Everyday Life", "Kitchen Science, Medicines & Clothes", ch_SCI_5_4_5_9, "Natural Fibres, Hygiene & Home Remedies");

        // Subject: Social Science
        Subject sub_SOC_5_5 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Social Science")
                .orElseGet(() -> subjectRepository.save(new Subject("Social Science", "SOC", "🌍", "#10ac84", board, classLevel)));

        // Unit: Unit 1: Earth, Continents & Oceans
        Unit u_SOC_5_5_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Earth, Continents & Oceans", 1, "Social Science", board, classLevel)));

        // Chapter: Our Planet Earth, Continents & Oceans
        Chapter ch_SOC_5_5_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 1: Earth, Continents & Oceans", 1, "Our Planet Earth, Continents & Oceans", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 1: Earth, Continents & Oceans", "Our Planet Earth, Continents & Oceans", ch_SOC_5_5_1_1, "Globe, Equator, Continents & Oceans");

        // Unit: Unit 2: History – Ancient Tamil Civilisation
        Unit u_SOC_5_5_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: History – Ancient Tamil Civilisation", 2, "Social Science", board, classLevel)));

        // Chapter: Kingdoms of Rivers (Chera, Chola, Pandya, Pallava)
        Chapter ch_SOC_5_5_2_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 2: History – Ancient Tamil Civilisation", 2, "Kingdoms of Rivers (Chera, Chola, Pandya, Pallava)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 2: History – Ancient Tamil Civilisation", "Kingdoms of Rivers (Chera, Chola, Pandya, Pallava)", ch_SOC_5_5_2_2, "Kings, Emblems, Ports & Capital Cities");

        // Chapter: Philanthropists of Ancient Tamilagam (Kadai Ezhu Vallalgal)
        Chapter ch_SOC_5_5_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 2: History – Ancient Tamil Civilisation", 3, "Philanthropists of Ancient Tamilagam (Kadai Ezhu Vallalgal)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 2: History – Ancient Tamil Civilisation", "Philanthropists of Ancient Tamilagam (Kadai Ezhu Vallalgal)", ch_SOC_5_5_2_3, "Pari, Pegan, Kari, Ay, Adiyaman, Nalli, Ori");

        // Unit: Unit 3: Geography – Landforms & Resources
        Unit u_SOC_5_5_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Geography – Landforms & Resources", 3, "Social Science", board, classLevel)));

        // Chapter: Five Landforms of Ancient Tamil Country
        Chapter ch_SOC_5_5_3_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 3: Geography – Landforms & Resources", 4, "Five Landforms of Ancient Tamil Country", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 3: Geography – Landforms & Resources", "Five Landforms of Ancient Tamil Country", ch_SOC_5_5_3_4, "Kurinji, Mullai, Marutham, Neithal, Palai");

        // Chapter: Atmosphere, Weather & Water Wealth
        Chapter ch_SOC_5_5_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 3: Geography – Landforms & Resources", 5, "Atmosphere, Weather & Water Wealth", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 3: Geography – Landforms & Resources", "Atmosphere, Weather & Water Wealth", ch_SOC_5_5_3_5, "Monsoon, Rivers of Tamil Nadu & Rain");

        // Unit: Unit 4: Civics – Duties, Rights & Governance
        Unit u_SOC_5_5_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Civics – Duties, Rights & Governance", 4, "Social Science", board, classLevel)));

        // Chapter: Municipalities, Corporations & Local Governance
        Chapter ch_SOC_5_5_4_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 4: Civics – Duties, Rights & Governance", 6, "Municipalities, Corporations & Local Governance", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 4: Civics – Duties, Rights & Governance", "Municipalities, Corporations & Local Governance", ch_SOC_5_5_4_6, "Mayor, Commissioner, Wards & Citizen Duties");

        // Chapter: Rights and Duties of a Good Citizen
        Chapter ch_SOC_5_5_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 4: Civics – Duties, Rights & Governance", 7, "Rights and Duties of a Good Citizen", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 4: Civics – Duties, Rights & Governance", "Rights and Duties of a Good Citizen", ch_SOC_5_5_4_7, "Fundamental Duties, Traffic Safety & Harmony");

    }

    private void seed_STATE_BOARD_Class_6() {
        String board = "STATE_BOARD";
        int classLevel = 6;

        // Subject: Tamil
        Subject sub_TAM_6_1 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Tamil")
                .orElseGet(() -> subjectRepository.save(new Subject("Tamil", "TAM", "📖", "#e84118", board, classLevel)));

        // Unit: இயல் 1: மொழி – இன்பத்தமிழ்
        Unit u_TAM_6_1_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 1: மொழி – இன்பத்தமிழ்", 1, "Tamil", board, classLevel)));

        // Chapter: இன்பத்தமிழ்
        Chapter ch_TAM_6_1_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 1: மொழி – இன்பத்தமிழ்", 1, "இன்பத்தமிழ்", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 1: மொழி – இன்பத்தமிழ்", "இன்பத்தமிழ்", ch_TAM_6_1_1_1, "பாரதிதாசன் தமிழ் வணக்கம்");

        // Chapter: தமிழ்க்கும்மி
        Chapter ch_TAM_6_1_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 1: மொழி – இன்பத்தமிழ்", 2, "தமிழ்க்கும்மி", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 1: மொழி – இன்பத்தமிழ்", "தமிழ்க்கும்மி", ch_TAM_6_1_1_2, "பெருஞ்சித்திரனார் பாடல்");

        // Chapter: வளர்தமிழ்
        Chapter ch_TAM_6_1_1_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 1: மொழி – இன்பத்தமிழ்", 3, "வளர்தமிழ்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 1: மொழி – இன்பத்தமிழ்", "வளர்தமிழ்", ch_TAM_6_1_1_3, "மூத்த தமிழ் மொழியின் மேன்மை");

        // Unit: இயல் 2: இயற்கை – சிலப்பதிகாரம்
        Unit u_TAM_6_1_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 2: இயற்கை – சிலப்பதிகாரம்", 2, "Tamil", board, classLevel)));

        // Chapter: சிலப்பதிகாரம்: திங்களைப் போற்றுதும்
        Chapter ch_TAM_6_1_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 2: இயற்கை – சிலப்பதிகாரம்", 4, "சிலப்பதிகாரம்: திங்களைப் போற்றுதும்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 2: இயற்கை – சிலப்பதிகாரம்", "சிலப்பதிகாரம்: திங்களைப் போற்றுதும்", ch_TAM_6_1_2_4, "இளங்கோவடிகள் இயற்கை வாழ்த்து");

        // Chapter: காணி நிலம்
        Chapter ch_TAM_6_1_2_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 2: இயற்கை – சிலப்பதிகாரம்", 5, "காணி நிலம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 2: இயற்கை – சிலப்பதிகாரம்", "காணி நிலம்", ch_TAM_6_1_2_5, "பாரதியார் கனவு இல்லம்");

        // Chapter: சிறகின் ஓசை
        Chapter ch_TAM_6_1_2_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 2: இயற்கை – சிலப்பதிகாரம்", 6, "சிறகின் ஓசை", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 2: இயற்கை – சிலப்பதிகாரம்", "சிறகின் ஓசை", ch_TAM_6_1_2_6, "பறவைகள் வலசை போதல்");

        // Unit: இயல் 3: அறிவியல் தொழில்நுட்பம்
        Unit u_TAM_6_1_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 3: அறிவியல் தொழில்நுட்பம்", 3, "Tamil", board, classLevel)));

        // Chapter: அறிவியல் ஆத்திசூடி
        Chapter ch_TAM_6_1_3_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 3: அறிவியல் தொழில்நுட்பம்", 7, "அறிவியல் ஆத்திசூடி", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 3: அறிவியல் தொழில்நுட்பம்", "அறிவியல் ஆத்திசூடி", ch_TAM_6_1_3_7, "நெல்லை சு. முத்து");

        // Chapter: கனியனின் நண்பன்
        Chapter ch_TAM_6_1_3_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 3: அறிவியல் தொழில்நுட்பம்", 8, "கனியனின் நண்பன்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 3: அறிவியல் தொழில்நுட்பம்", "கனியனின் நண்பன்", ch_TAM_6_1_3_8, "எந்திர மனிதன் & AI");

        // Chapter: ஒளி பிறந்தது
        Chapter ch_TAM_6_1_3_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 3: அறிவியல் தொழில்நுட்பம்", 9, "ஒளி பிறந்தது", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 3: அறிவியல் தொழில்நுட்பம்", "ஒளி பிறந்தது", ch_TAM_6_1_3_9, "அப்துல் கலாம் நேர்காணல்");

        // Unit: இயல் 4: கல்வி – மூதுரை
        Unit u_TAM_6_1_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 4: கல்வி – மூதுரை", 4, "Tamil", board, classLevel)));

        // Chapter: மூதுரை: மன்னனும் மாசறக் கற்றோனும்
        Chapter ch_TAM_6_1_4_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 4: கல்வி – மூதுரை", 10, "மூதுரை: மன்னனும் மாசறக் கற்றோனும்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 4: கல்வி – மூதுரை", "மூதுரை: மன்னனும் மாசறக் கற்றோனும்", ch_TAM_6_1_4_10, "ஔவையார் கல்வி அறம்");

        // Chapter: துன்பம் வெல்லும் கல்வி
        Chapter ch_TAM_6_1_4_11 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 11)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 4: கல்வி – மூதுரை", 11, "துன்பம் வெல்லும் கல்வி", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 4: கல்வி – மூதுரை", "துன்பம் வெல்லும் கல்வி", ch_TAM_6_1_4_11, "பட்டுக்கோட்டை கல்யாணசுந்தரம்");

        // Chapter: கல்விக் கண் திறந்த காமராசர்
        Chapter ch_TAM_6_1_4_12 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 12)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 4: கல்வி – மூதுரை", 12, "கல்விக் கண் திறந்த காமராசர்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 4: கல்வி – மூதுரை", "கல்விக் கண் திறந்த காமராசர்", ch_TAM_6_1_4_12, "காமராசர் கல்விப் புரட்சி");

        // Unit: இயல் 5: நாகரிகம் பண்பாடு
        Unit u_TAM_6_1_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 5: நாகரிகம் பண்பாடு", 5, "Tamil", board, classLevel)));

        // Chapter: ஆசாரக்கோவை
        Chapter ch_TAM_6_1_5_13 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 13)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 5: நாகரிகம் பண்பாடு", 13, "ஆசாரக்கோவை", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 5: நாகரிகம் பண்பாடு", "ஆசாரக்கோவை", ch_TAM_6_1_5_13, "பெருவாயின் முள்ளியார் ஒழுக்க நெறி");

        // Chapter: தமிழர் பெருவிழா
        Chapter ch_TAM_6_1_5_14 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 14)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 5: நாகரிகம் பண்பாடு", 14, "தமிழர் பெருவிழா", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 5: நாகரிகம் பண்பாடு", "தமிழர் பெருவிழா", ch_TAM_6_1_5_14, "உழவர் திருநாள் & பொங்கல்");

        // Chapter: மனம் கவரும் மாமல்லபுரம்
        Chapter ch_TAM_6_1_5_15 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 15)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 5: நாகரிகம் பண்பாடு", 15, "மனம் கவரும் மாமல்லபுரம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 5: நாகரிகம் பண்பாடு", "மனம் கவரும் மாமல்லபுரம்", ch_TAM_6_1_5_15, "பல்லவர் சிற்பக்கலை");

        // Unit: இயல் 6: தொழில் வணிகம்
        Unit u_TAM_6_1_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 6: தொழில் வணிகம்", 6, "Tamil", board, classLevel)));

        // Chapter: நானிலம் படைத்தவன்
        Chapter ch_TAM_6_1_6_16 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 16)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 6: தொழில் வணிகம்", 16, "நானிலம் படைத்தவன்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 6: தொழில் வணிகம்", "நானிலம் படைத்தவன்", ch_TAM_6_1_6_16, "முடியரசன் உழைப்பின் மேன்மை");

        // Chapter: கடலோடு விளையாடு
        Chapter ch_TAM_6_1_6_17 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 17)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 6: தொழில் வணிகம்", 17, "கடலோடு விளையாடு", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 6: தொழில் வணிகம்", "கடலோடு விளையாடு", ch_TAM_6_1_6_17, "நெய்தல் நில மீனவர் பாடல்");

        // Chapter: வளரும் வணிகம்
        Chapter ch_TAM_6_1_6_18 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 18)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 6: தொழில் வணிகம்", 18, "வளரும் வணிகம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 6: தொழில் வணிகம்", "வளரும் வணிகம்", ch_TAM_6_1_6_18, "பண்டமாற்று முதல் ஈ-காமர்ஸ் வரை");

        // Unit: இயல் 7: நாடு சமூகம் அரசு
        Unit u_TAM_6_1_7 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 7).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 7: நாடு சமூகம் அரசு", 7, "Tamil", board, classLevel)));

        // Chapter: பாரதம் அன்றைய நாற்றங்கால்
        Chapter ch_TAM_6_1_7_19 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 19)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 7: நாடு சமூகம் அரசு", 19, "பாரதம் அன்றைய நாற்றங்கால்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 7: நாடு சமூகம் அரசு", "பாரதம் அன்றைய நாற்றங்கால்", ch_TAM_6_1_7_19, "தாராபாரதி தேசிய ஒருமைப்பாடு");

        // Chapter: தமிழ்நாட்டில் காந்தி
        Chapter ch_TAM_6_1_7_20 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 20)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 7: நாடு சமூகம் அரசு", 20, "தமிழ்நாட்டில் காந்தி", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 7: நாடு சமூகம் அரசு", "தமிழ்நாட்டில் காந்தி", ch_TAM_6_1_7_20, "காந்தியடிகள் தமிழக வருகை");

        // Chapter: வேலுநாச்சியார்
        Chapter ch_TAM_6_1_7_21 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 21)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 7: நாடு சமூகம் அரசு", 21, "வேலுநாச்சியார்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 7: நாடு சமூகம் அரசு", "வேலுநாச்சியார்", ch_TAM_6_1_7_21, "சிவகங்கை வீர மங்கை");

        // Unit: இயல் 8: அறம் தத்துவம் மனிதநேயம்
        Unit u_TAM_6_1_8 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 8).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 8: அறம் தத்துவம் மனிதநேயம்", 8, "Tamil", board, classLevel)));

        // Chapter: பராபரக்கண்ணி
        Chapter ch_TAM_6_1_8_22 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 22)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 8: அறம் தத்துவம் மனிதநேயம்", 22, "பராபரக்கண்ணி", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 8: அறம் தத்துவம் மனிதநேயம்", "பராபரக்கண்ணி", ch_TAM_6_1_8_22, "தாயுமானவர் அருள்வாக்கு");

        // Chapter: நீங்கள் நல்லவர்
        Chapter ch_TAM_6_1_8_23 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 23)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 8: அறம் தத்துவம் மனிதநேயம்", 23, "நீங்கள் நல்லவர்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 8: அறம் தத்துவம் மனிதநேயம்", "நீங்கள் நல்லவர்", ch_TAM_6_1_8_23, "கலீல் ஜிப்ரான் கவிதை");

        // Chapter: பசிப்பிணி போக்கிய பாவை
        Chapter ch_TAM_6_1_8_24 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 24)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 8: அறம் தத்துவம் மனிதநேயம்", 24, "பசிப்பிணி போக்கிய பாவை", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 8: அறம் தத்துவம் மனிதநேயம்", "பசிப்பிணி போக்கிய பாவை", ch_TAM_6_1_8_24, "மணிமேகலை அமுதசுரபி");

        // Unit: இயல் 9: மனிதம் ஆளுமை
        Unit u_TAM_6_1_9 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 9).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 9: மனிதம் ஆளுமை", 9, "Tamil", board, classLevel)));

        // Chapter: ஆசிய ஜோதி
        Chapter ch_TAM_6_1_9_25 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 25)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 9: மனிதம் ஆளுமை", 25, "ஆசிய ஜோதி", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 9: மனிதம் ஆளுமை", "ஆசிய ஜோதி", ch_TAM_6_1_9_25, "கவிமணி புத்தர் அருள் வரலாறு");

        // Chapter: மனிதநேயம்
        Chapter ch_TAM_6_1_9_26 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 26)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 9: மனிதம் ஆளுமை", 26, "மனிதநேயம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 9: மனிதம் ஆளுமை", "மனிதநேயம்", ch_TAM_6_1_9_26, "அன்னை தெரசா & கைலாஷ் சத்யார்த்தி");

        // Chapter: அணி இலக்கணம்
        Chapter ch_TAM_6_1_9_27 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 27)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 9: மனிதம் ஆளுமை", 27, "அணி இலக்கணம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 9: மனிதம் ஆளுமை", "அணி இலக்கணம்", ch_TAM_6_1_9_27, "இயல்பு நவிற்சி & உயர்வு நவிற்சி அணி");

        // Subject: English
        Subject sub_ENG_6_2 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "English")
                .orElseGet(() -> subjectRepository.save(new Subject("English", "ENG", "📚", "#fa8231", board, classLevel)));

        // Unit: Term 1: Unit 1 – Learning & Adventure
        Unit u_ENG_6_2_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 1: Unit 1 – Learning & Adventure", 1, "English", board, classLevel)));

        // Chapter: Prose 1: Inspiring Journeys (Std 6)
        Chapter ch_ENG_6_2_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 1: Unit 1 – Learning & Adventure", 1, "Prose 1: Inspiring Journeys (Std 6)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 1: Unit 1 – Learning & Adventure", "Prose 1: Inspiring Journeys (Std 6)", ch_ENG_6_2_1_1, "Vocabulary & Reading");

        // Chapter: Poem 1: Nature's Melody (Std 6)
        Chapter ch_ENG_6_2_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 1: Unit 1 – Learning & Adventure", 2, "Poem 1: Nature's Melody (Std 6)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 1: Unit 1 – Learning & Adventure", "Poem 1: Nature's Melody (Std 6)", ch_ENG_6_2_1_2, "Rhyme Scheme & Figures of Speech");

        // Unit: Term 1: Unit 2 – Values & Courage
        Unit u_ENG_6_2_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 1: Unit 2 – Values & Courage", 2, "English", board, classLevel)));

        // Chapter: Prose 2: Acts of Bravery (Std 6)
        Chapter ch_ENG_6_2_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 1: Unit 2 – Values & Courage", 3, "Prose 2: Acts of Bravery (Std 6)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 1: Unit 2 – Values & Courage", "Prose 2: Acts of Bravery (Std 6)", ch_ENG_6_2_2_3, "Grammar & Direct Indirect Speech");

        // Chapter: Supplementary: Life Lessons (Std 6)
        Chapter ch_ENG_6_2_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 1: Unit 2 – Values & Courage", 4, "Supplementary: Life Lessons (Std 6)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 1: Unit 2 – Values & Courage", "Supplementary: Life Lessons (Std 6)", ch_ENG_6_2_2_4, "Character Sketches & Morals");

        // Unit: Term 2: Unit 3 – Art, Culture & Heritage
        Unit u_ENG_6_2_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 2: Unit 3 – Art, Culture & Heritage", 3, "English", board, classLevel)));

        // Chapter: Prose 3: Treasures of History (Std 6)
        Chapter ch_ENG_6_2_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 2: Unit 3 – Art, Culture & Heritage", 5, "Prose 3: Treasures of History (Std 6)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 2: Unit 3 – Art, Culture & Heritage", "Prose 3: Treasures of History (Std 6)", ch_ENG_6_2_3_5, "Comprehension & Essay Writing");

        // Chapter: Poem 2: Echoes of the Past (Std 6)
        Chapter ch_ENG_6_2_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 2: Unit 3 – Art, Culture & Heritage", 6, "Poem 2: Echoes of the Past (Std 6)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 2: Unit 3 – Art, Culture & Heritage", "Poem 2: Echoes of the Past (Std 6)", ch_ENG_6_2_3_6, "Metaphors & Imagery");

        // Unit: Term 2: Unit 4 – Science & Tomorrow
        Unit u_ENG_6_2_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 2: Unit 4 – Science & Tomorrow", 4, "English", board, classLevel)));

        // Chapter: Prose 4: Innovations Changing Lives (Std 6)
        Chapter ch_ENG_6_2_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 2: Unit 4 – Science & Tomorrow", 7, "Prose 4: Innovations Changing Lives (Std 6)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 2: Unit 4 – Science & Tomorrow", "Prose 4: Innovations Changing Lives (Std 6)", ch_ENG_6_2_4_7, "Active Passive Voice & Tenses");

        // Chapter: Supplementary: Dreams into Reality (Std 6)
        Chapter ch_ENG_6_2_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 2: Unit 4 – Science & Tomorrow", 8, "Supplementary: Dreams into Reality (Std 6)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 2: Unit 4 – Science & Tomorrow", "Supplementary: Dreams into Reality (Std 6)", ch_ENG_6_2_4_8, "Plot Summary & Analysis");

        // Unit: Term 3: Unit 5 – Environment & Harmony
        Unit u_ENG_6_2_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 3: Unit 5 – Environment & Harmony", 5, "English", board, classLevel)));

        // Chapter: Prose 5: Guardians of Nature (Std 6)
        Chapter ch_ENG_6_2_5_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 3: Unit 5 – Environment & Harmony", 9, "Prose 5: Guardians of Nature (Std 6)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 3: Unit 5 – Environment & Harmony", "Prose 5: Guardians of Nature (Std 6)", ch_ENG_6_2_5_9, "Clauses & Conjunctions");

        // Chapter: Poem 3: The Green Earth (Std 6)
        Chapter ch_ENG_6_2_5_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 3: Unit 5 – Environment & Harmony", 10, "Poem 3: The Green Earth (Std 6)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 3: Unit 5 – Environment & Harmony", "Poem 3: The Green Earth (Std 6)", ch_ENG_6_2_5_10, "Poetic Appreciation");

        // Unit: Term 3: Unit 6 – Humanity & Sports
        Unit u_ENG_6_2_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 3: Unit 6 – Humanity & Sports", 6, "English", board, classLevel)));

        // Chapter: Prose 6: Champions of the Game (Std 6)
        Chapter ch_ENG_6_2_6_11 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 11)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 3: Unit 6 – Humanity & Sports", 11, "Prose 6: Champions of the Game (Std 6)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 3: Unit 6 – Humanity & Sports", "Prose 6: Champions of the Game (Std 6)", ch_ENG_6_2_6_11, "Formal Letter & Report Writing");

        // Chapter: Supplementary: Triumph of Will (Std 6)
        Chapter ch_ENG_6_2_6_12 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 12)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 3: Unit 6 – Humanity & Sports", 12, "Supplementary: Triumph of Will (Std 6)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 3: Unit 6 – Humanity & Sports", "Supplementary: Triumph of Will (Std 6)", ch_ENG_6_2_6_12, "Theme & Message");

        // Subject: Mathematics
        Subject sub_MATH_6_3 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Mathematics")
                .orElseGet(() -> subjectRepository.save(new Subject("Mathematics", "MATH", "📐", "#4834d4", board, classLevel)));

        // Unit: Unit 1: Numbers & Whole Numbers
        Unit u_MATH_6_3_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Numbers & Whole Numbers", 1, "Mathematics", board, classLevel)));

        // Chapter: Numbers & Number Operations
        Chapter ch_MATH_6_3_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 1: Numbers & Whole Numbers", 1, "Numbers & Number Operations", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 1: Numbers & Whole Numbers", "Numbers & Number Operations", ch_MATH_6_3_1_1, "Large Numbers, Place Value, BODMAS");

        // Chapter: Whole Numbers & Prime Numbers
        Chapter ch_MATH_6_3_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 1: Numbers & Whole Numbers", 2, "Whole Numbers & Prime Numbers", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 1: Numbers & Whole Numbers", "Whole Numbers & Prime Numbers", ch_MATH_6_3_1_2, "Factors, Multiples, HCF & LCM");

        // Unit: Unit 2: Introduction to Algebra
        Unit u_MATH_6_3_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Introduction to Algebra", 2, "Mathematics", board, classLevel)));

        // Chapter: Algebraic Expressions & Variables
        Chapter ch_MATH_6_3_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 2: Introduction to Algebra", 3, "Algebraic Expressions & Variables", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 2: Introduction to Algebra", "Algebraic Expressions & Variables", ch_MATH_6_3_2_3, "Forming Expressions & Linear Equations");

        // Unit: Unit 3: Ratio and Proportion
        Unit u_MATH_6_3_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Ratio and Proportion", 3, "Mathematics", board, classLevel)));

        // Chapter: Ratio, Proportion & Unitary Method
        Chapter ch_MATH_6_3_3_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 3: Ratio and Proportion", 4, "Ratio, Proportion & Unitary Method", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 3: Ratio and Proportion", "Ratio, Proportion & Unitary Method", ch_MATH_6_3_3_4, "Equivalent Ratios & Applications");

        // Unit: Unit 4: Geometry & Angles
        Unit u_MATH_6_3_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Geometry & Angles", 4, "Mathematics", board, classLevel)));

        // Chapter: Lines, Angles & Triangles
        Chapter ch_MATH_6_3_4_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 4: Geometry & Angles", 5, "Lines, Angles & Triangles", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 4: Geometry & Angles", "Lines, Angles & Triangles", ch_MATH_6_3_4_5, "Types of Angles & Compass Constructions");

        // Unit: Unit 5: Statistics & Data Handling
        Unit u_MATH_6_3_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 5: Statistics & Data Handling", 5, "Mathematics", board, classLevel)));

        // Chapter: Data Collection, Tally & Graphs
        Chapter ch_MATH_6_3_5_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 5: Statistics & Data Handling", 6, "Data Collection, Tally & Graphs", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 5: Statistics & Data Handling", "Data Collection, Tally & Graphs", ch_MATH_6_3_5_6, "Pictographs & Bar Graphs");

        // Unit: Unit 6: Information Processing
        Unit u_MATH_6_3_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 6: Information Processing", 6, "Mathematics", board, classLevel)));

        // Chapter: Systematic Listing & Tree Diagrams
        Chapter ch_MATH_6_3_6_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 6: Information Processing", 7, "Systematic Listing & Tree Diagrams", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 6: Information Processing", "Systematic Listing & Tree Diagrams", ch_MATH_6_3_6_7, "Combinatorics Basics");

        // Subject: Science
        Subject sub_SCI_6_4 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Science")
                .orElseGet(() -> subjectRepository.save(new Subject("Science", "SCI", "🔬", "#eb4d4b", board, classLevel)));

        // Unit: Unit 1: Physics – Measurement & Motion
        Unit u_SCI_6_4_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Physics – Measurement & Motion", 1, "Science", board, classLevel)));

        // Chapter: Measurements & SI Units
        Chapter ch_SCI_6_4_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 1: Physics – Measurement & Motion", 1, "Measurements & SI Units", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 1: Physics – Measurement & Motion", "Measurements & SI Units", ch_SCI_6_4_1_1, "Length, Mass, Time & Error Minimisation");

        // Chapter: Forces and Motion
        Chapter ch_SCI_6_4_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 1: Physics – Measurement & Motion", 2, "Forces and Motion", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 1: Physics – Measurement & Motion", "Forces and Motion", ch_SCI_6_4_1_2, "Push, Pull, Contact / Non-contact forces");

        // Unit: Unit 2: Physics – Electricity & Magnetism
        Unit u_SCI_6_4_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Physics – Electricity & Magnetism", 2, "Science", board, classLevel)));

        // Chapter: Electricity & Circuits
        Chapter ch_SCI_6_4_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 2: Physics – Electricity & Magnetism", 3, "Electricity & Circuits", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 2: Physics – Electricity & Magnetism", "Electricity & Circuits", ch_SCI_6_4_2_3, "Conductors, Insulators, Cells & Switches");

        // Chapter: Magnetism & Magnetic Poles
        Chapter ch_SCI_6_4_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 2: Physics – Electricity & Magnetism", 4, "Magnetism & Magnetic Poles", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 2: Physics – Electricity & Magnetism", "Magnetism & Magnetic Poles", ch_SCI_6_4_2_4, "Magnetic Attraction, Compass & Care");

        // Unit: Unit 3: Chemistry – Matter & Changes
        Unit u_SCI_6_4_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Chemistry – Matter & Changes", 3, "Science", board, classLevel)));

        // Chapter: Matter Around Us
        Chapter ch_SCI_6_4_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 3: Chemistry – Matter & Changes", 5, "Matter Around Us", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 3: Chemistry – Matter & Changes", "Matter Around Us", ch_SCI_6_4_3_5, "Atoms, Molecules, Solids, Liquids, Gases");

        // Chapter: Changes Around Us
        Chapter ch_SCI_6_4_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 3: Chemistry – Matter & Changes", 6, "Changes Around Us", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 3: Chemistry – Matter & Changes", "Changes Around Us", ch_SCI_6_4_3_6, "Reversible, Irreversible, Physical & Chemical");

        // Unit: Unit 4: Chemistry – Water & Air
        Unit u_SCI_6_4_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Chemistry – Water & Air", 4, "Science", board, classLevel)));

        // Chapter: Water – Life Sustainer
        Chapter ch_SCI_6_4_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 4: Chemistry – Water & Air", 7, "Water – Life Sustainer", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 4: Chemistry – Water & Air", "Water – Life Sustainer", ch_SCI_6_4_4_7, "Water Sources, Water Cycle & Scarcity");

        // Chapter: Air Around Us
        Chapter ch_SCI_6_4_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 4: Chemistry – Water & Air", 8, "Air Around Us", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 4: Chemistry – Water & Air", "Air Around Us", ch_SCI_6_4_4_8, "Composition of Air, Burning & Respiration");

        // Unit: Unit 5: Biology – Plant & Animal World
        Unit u_SCI_6_4_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 5: Biology – Plant & Animal World", 5, "Science", board, classLevel)));

        // Chapter: The Living World of Plants
        Chapter ch_SCI_6_4_5_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 5: Biology – Plant & Animal World", 9, "The Living World of Plants", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 5: Biology – Plant & Animal World", "The Living World of Plants", ch_SCI_6_4_5_9, "Root & Shoot System, Photosynthesis");

        // Chapter: Living World of Animals
        Chapter ch_SCI_6_4_5_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 5: Biology – Plant & Animal World", 10, "Living World of Animals", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 5: Biology – Plant & Animal World", "Living World of Animals", ch_SCI_6_4_5_10, "Unicellular vs Multicellular, Habitats");

        // Unit: Unit 6: Biology – Health & Hygiene
        Unit u_SCI_6_4_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 6: Biology – Health & Hygiene", 6, "Science", board, classLevel)));

        // Chapter: Health, Nutrients & Diseases
        Chapter ch_SCI_6_4_6_11 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 11)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 6: Biology – Health & Hygiene", 11, "Health, Nutrients & Diseases", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 6: Biology – Health & Hygiene", "Health, Nutrients & Diseases", ch_SCI_6_4_6_11, "Carbohydrates, Proteins, Vitamins & Balanced Diet");

        // Unit: Unit 7: Computer Science Overview
        Unit u_SCI_6_4_7 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 7).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 7: Computer Science Overview", 7, "Science", board, classLevel)));

        // Chapter: Introduction to Computers & Hardware
        Chapter ch_SCI_6_4_7_12 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 12)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 7: Computer Science Overview", 12, "Introduction to Computers & Hardware", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 7: Computer Science Overview", "Introduction to Computers & Hardware", ch_SCI_6_4_7_12, "Input/Output devices, CPU & OS");

        // Subject: Social Science
        Subject sub_SOC_6_5 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Social Science")
                .orElseGet(() -> subjectRepository.save(new Subject("Social Science", "SOC", "🌍", "#10ac84", board, classLevel)));

        // Unit: Unit 1: History – Ancient Civilisations & Tamil Heritage
        Unit u_SOC_6_5_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: History – Ancient Civilisations & Tamil Heritage", 1, "Social Science", board, classLevel)));

        // Chapter: What is History? & Prehistoric Humans
        Chapter ch_SOC_6_5_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 1: History – Ancient Civilisations & Tamil Heritage", 1, "What is History? & Prehistoric Humans", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 1: History – Ancient Civilisations & Tamil Heritage", "What is History? & Prehistoric Humans", ch_SOC_6_5_1_1, "Archaeological Sources, Inscriptions & Evolution");

        // Chapter: Indus Civilisation & Ancient Cities of Tamilagam
        Chapter ch_SOC_6_5_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 1: History – Ancient Civilisations & Tamil Heritage", 2, "Indus Civilisation & Ancient Cities of Tamilagam", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 1: History – Ancient Civilisations & Tamil Heritage", "Indus Civilisation & Ancient Cities of Tamilagam", ch_SOC_6_5_1_2, "Harappa, Mohenjo-daro, Keezhadi, Korkai & Poompuhar");

        // Unit: Unit 2: History – Great Empires & Thinkers
        Unit u_SOC_6_5_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: History – Great Empires & Thinkers", 2, "Social Science", board, classLevel)));

        // Chapter: Vedic Culture, Jainism & Buddhism
        Chapter ch_SOC_6_5_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 2: History – Great Empires & Thinkers", 3, "Vedic Culture, Jainism & Buddhism", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 2: History – Great Empires & Thinkers", "Vedic Culture, Jainism & Buddhism", ch_SOC_6_5_2_3, "Mahavira, Gautama Buddha & Epics");

        // Chapter: From Chiefdoms to Empires – Maurya & Sangam Age
        Chapter ch_SOC_6_5_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 2: History – Great Empires & Thinkers", 4, "From Chiefdoms to Empires – Maurya & Sangam Age", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 2: History – Great Empires & Thinkers", "From Chiefdoms to Empires – Maurya & Sangam Age", ch_SOC_6_5_2_4, "Emperor Ashoka, Edicts & Tamil Sangam Literature");

        // Unit: Unit 3: Geography – Solar System & Globe
        Unit u_SOC_6_5_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Geography – Solar System & Globe", 3, "Social Science", board, classLevel)));

        // Chapter: The Universe and Solar System
        Chapter ch_SOC_6_5_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 3: Geography – Solar System & Globe", 5, "The Universe and Solar System", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 3: Geography – Solar System & Globe", "The Universe and Solar System", ch_SOC_6_5_3_5, "Sun, Planets, Satellites, Rotation & Revolution");

        // Chapter: Land and Oceans – Continents & Relief Features
        Chapter ch_SOC_6_5_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 3: Geography – Solar System & Globe", 6, "Land and Oceans – Continents & Relief Features", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 3: Geography – Solar System & Globe", "Land and Oceans – Continents & Relief Features", ch_SOC_6_5_3_6, "Plateaus, Plains, Mountains, Pacific & Indian Ocean");

        // Unit: Unit 4: Geography – Asia & Tamil Nadu Overview
        Unit u_SOC_6_5_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Geography – Asia & Tamil Nadu Overview", 4, "Social Science", board, classLevel)));

        // Chapter: Understanding Asia and Regional Geography
        Chapter ch_SOC_6_5_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 4: Geography – Asia & Tamil Nadu Overview", 7, "Understanding Asia and Regional Geography", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 4: Geography – Asia & Tamil Nadu Overview", "Understanding Asia and Regional Geography", ch_SOC_6_5_4_7, "Physical Features, Climate, Vegetation & Resources");

        // Unit: Unit 5: Civics – Diversity, Equality & Democracy
        Unit u_SOC_6_5_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 5: Civics – Diversity, Equality & Democracy", 5, "Social Science", board, classLevel)));

        // Chapter: Understanding Diversity & Achieving Equality
        Chapter ch_SOC_6_5_5_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 5: Civics – Diversity, Equality & Democracy", 8, "Understanding Diversity & Achieving Equality", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 5: Civics – Diversity, Equality & Democracy", "Understanding Diversity & Achieving Equality", ch_SOC_6_5_5_8, "Unity in Diversity, Constitution & Anti-discrimination");

        // Chapter: National Symbols & Indian Constitution Basics
        Chapter ch_SOC_6_5_5_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 5: Civics – Diversity, Equality & Democracy", 9, "National Symbols & Indian Constitution Basics", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 5: Civics – Diversity, Equality & Democracy", "National Symbols & Indian Constitution Basics", ch_SOC_6_5_5_9, "National Flag, Emblem, Anthem & Democratic Values");

        // Unit: Unit 6: Economics – Production & Livelihoods
        Unit u_SOC_6_5_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 6: Economics – Production & Livelihoods", 6, "Social Science", board, classLevel)));

        // Chapter: Economics – An Introduction to Goods & Services
        Chapter ch_SOC_6_5_6_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 6: Economics – Production & Livelihoods", 10, "Economics – An Introduction to Goods & Services", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 6: Economics – Production & Livelihoods", "Economics – An Introduction to Goods & Services", ch_SOC_6_5_6_10, "Primary, Secondary, Tertiary Sectors & Barter System");

    }

    private void seed_STATE_BOARD_Class_7() {
        String board = "STATE_BOARD";
        int classLevel = 7;

        // Subject: Tamil
        Subject sub_TAM_7_1 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Tamil")
                .orElseGet(() -> subjectRepository.save(new Subject("Tamil", "TAM", "📖", "#e84118", board, classLevel)));

        // Unit: இயல் 1: அமுதத்தமிழ்
        Unit u_TAM_7_1_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 1: அமுதத்தமிழ்", 1, "Tamil", board, classLevel)));

        // Chapter: எங்கள் தமிழ்
        Chapter ch_TAM_7_1_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 1: அமுதத்தமிழ்", 1, "எங்கள் தமிழ்", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 1: அமுதத்தமிழ்", "எங்கள் தமிழ்", ch_TAM_7_1_1_1, "நாமக்கல் கவிஞர்");

        // Chapter: ஒன்றல்ல இரண்டல்ல
        Chapter ch_TAM_7_1_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 1: அமுதத்தமிழ்", 2, "ஒன்றல்ல இரண்டல்ல", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 1: அமுதத்தமிழ்", "ஒன்றல்ல இரண்டல்ல", ch_TAM_7_1_1_2, "உடுமலை நாராயணகவி");

        // Unit: இயல் 2: அணிநிழல் காடு
        Unit u_TAM_7_1_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 2: அணிநிழல் காடு", 2, "Tamil", board, classLevel)));

        // Chapter: காடு
        Chapter ch_TAM_7_1_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 2: அணிநிழல் காடு", 3, "காடு", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 2: அணிநிழல் காடு", "காடு", ch_TAM_7_1_2_3, "சுரதா இயற்கை எழில்");

        // Chapter: விலங்குகள் உலகம்
        Chapter ch_TAM_7_1_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 2: அணிநிழல் காடு", 4, "விலங்குகள் உலகம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 2: அணிநிழல் காடு", "விலங்குகள் உலகம்", ch_TAM_7_1_2_4, "முண்டந்துறை சரணாலயம்");

        // Unit: இயல் 3: நாடு அதை நாடு
        Unit u_TAM_7_1_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 3: நாடு அதை நாடு", 3, "Tamil", board, classLevel)));

        // Chapter: புலி தங்கிய குகை
        Chapter ch_TAM_7_1_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 3: நாடு அதை நாடு", 5, "புலி தங்கிய குகை", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 3: நாடு அதை நாடு", "புலி தங்கிய குகை", ch_TAM_7_1_3_5, "காவற்பெண்டு புறநானூறு");

        // Chapter: பாஞ்சை வளம்
        Chapter ch_TAM_7_1_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 3: நாடு அதை நாடு", 6, "பாஞ்சை வளம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 3: நாடு அதை நாடு", "பாஞ்சை வளம்", ch_TAM_7_1_3_6, "வீரபாண்டிய கட்டபொம்மன்");

        // Unit: இயல் 4: கல்வி கரையில
        Unit u_TAM_7_1_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 4: கல்வி கரையில", 4, "Tamil", board, classLevel)));

        // Chapter: கற்றோர்க்குச் சென்ற இடமெல்லாம் சிறப்பு
        Chapter ch_TAM_7_1_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 4: கல்வி கரையில", 7, "கற்றோர்க்குச் சென்ற இடமெல்லாம் சிறப்பு", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 4: கல்வி கரையில", "கற்றோர்க்குச் சென்ற இடமெல்லாம் சிறப்பு", ch_TAM_7_1_4_7, "கல்விப் பெருமை");

        // Chapter: வாழ்விக்கும் கல்வி
        Chapter ch_TAM_7_1_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 4: கல்வி கரையில", 8, "வாழ்விக்கும் கல்வி", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 4: கல்வி கரையில", "வாழ்விக்கும் கல்வி", ch_TAM_7_1_4_8, "மு. முனிசாமி");

        // Unit: இயல் 5: ஓதுவது ஒழியேல்
        Unit u_TAM_7_1_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 5: ஓதுவது ஒழியேல்", 5, "Tamil", board, classLevel)));

        // Chapter: இன்பத்தமிழ்க் கல்வி
        Chapter ch_TAM_7_1_5_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 5: ஓதுவது ஒழியேல்", 9, "இன்பத்தமிழ்க் கல்வி", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 5: ஓதுவது ஒழியேல்", "இன்பத்தமிழ்க் கல்வி", ch_TAM_7_1_5_9, "பாரதிதாசன்");

        // Chapter: அழியாத செல்வம்
        Chapter ch_TAM_7_1_5_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 5: ஓதுவது ஒழியேல்", 10, "அழியாத செல்வம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 5: ஓதுவது ஒழியேல்", "அழியாத செல்வம்", ch_TAM_7_1_5_10, "நாலடியார்");

        // Unit: இயல் 6: கலை வண்ணம்
        Unit u_TAM_7_1_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 6: கலை வண்ணம்", 6, "Tamil", board, classLevel)));

        // Chapter: கலங்கரை விளக்கம்
        Chapter ch_TAM_7_1_6_11 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 11)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 6: கலை வண்ணம்", 11, "கலங்கரை விளக்கம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 6: கலை வண்ணம்", "கலங்கரை விளக்கம்", ch_TAM_7_1_6_11, "கடியலூர் உருத்திரங்கண்ணனார்");

        // Chapter: தமிழரின் கப்பற்கலை
        Chapter ch_TAM_7_1_6_12 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 12)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 6: கலை வண்ணம்", 12, "தமிழரின் கப்பற்கலை", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 6: கலை வண்ணம்", "தமிழரின் கப்பற்கலை", ch_TAM_7_1_6_12, "பண்டைத் தமிழர் கடல் வணிகம்");

        // Unit: இயல் 7: நாகரிகத் தொழில்
        Unit u_TAM_7_1_7 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 7).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 7: நாகரிகத் தொழில்", 7, "Tamil", board, classLevel)));

        // Chapter: விருந்தோம்பல்
        Chapter ch_TAM_7_1_7_13 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 13)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 7: நாகரிகத் தொழில்", 13, "விருந்தோம்பல்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 7: நாகரிகத் தொழில்", "விருந்தோம்பல்", ch_TAM_7_1_7_13, "பழமொழி நானூறு");

        // Chapter: வயலும் வாழ்வும்
        Chapter ch_TAM_7_1_7_14 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 14)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 7: நாகரிகத் தொழில்", 14, "வயலும் வாழ்வும்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 7: நாகரிகத் தொழில்", "வயலும் வாழ்வும்", ch_TAM_7_1_7_14, "உழவுத் தொழில் பாட்டு");

        // Unit: இயல் 8: அறநெறி
        Unit u_TAM_7_1_8 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 8).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 8: அறநெறி", 8, "Tamil", board, classLevel)));

        // Chapter: புதுமை விளக்கு
        Chapter ch_TAM_7_1_8_15 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 15)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 8: அறநெறி", 15, "புதுமை விளக்கு", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 8: அறநெறி", "புதுமை விளக்கு", ch_TAM_7_1_8_15, "பொய்கையாழ்வார் & பூதத்தாழ்வார்");

        // Chapter: ஒப்புரவு நெறி
        Chapter ch_TAM_7_1_8_16 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 16)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 8: அறநெறி", 16, "ஒப்புரவு நெறி", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 8: அறநெறி", "ஒப்புரவு நெறி", ch_TAM_7_1_8_16, "குன்றக்குடி அடிகளார்");

        // Unit: இயல் 9: மானுடம்
        Unit u_TAM_7_1_9 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 9).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 9: மானுடம்", 9, "Tamil", board, classLevel)));

        // Chapter: மலைப்பொழிவு
        Chapter ch_TAM_7_1_9_17 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 17)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 9: மானுடம்", 17, "மலைப்பொழிவு", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 9: மானுடம்", "மலைப்பொழிவு", ch_TAM_7_1_9_17, "கண்ணதாசன் இயேசு காவியம்");

        // Chapter: தன்னை அறிதல்
        Chapter ch_TAM_7_1_9_18 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 18)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 9: மானுடம்", 18, "தன்னை அறிதல்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 9: மானுடம்", "தன்னை அறிதல்", ch_TAM_7_1_9_18, "சே. பிருந்தா கவிதை");

        // Subject: English
        Subject sub_ENG_7_2 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "English")
                .orElseGet(() -> subjectRepository.save(new Subject("English", "ENG", "📚", "#fa8231", board, classLevel)));

        // Unit: Term 1: Unit 1 – Learning & Adventure
        Unit u_ENG_7_2_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 1: Unit 1 – Learning & Adventure", 1, "English", board, classLevel)));

        // Chapter: Prose 1: Inspiring Journeys (Std 7)
        Chapter ch_ENG_7_2_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 1: Unit 1 – Learning & Adventure", 1, "Prose 1: Inspiring Journeys (Std 7)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 1: Unit 1 – Learning & Adventure", "Prose 1: Inspiring Journeys (Std 7)", ch_ENG_7_2_1_1, "Vocabulary & Reading");

        // Chapter: Poem 1: Nature's Melody (Std 7)
        Chapter ch_ENG_7_2_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 1: Unit 1 – Learning & Adventure", 2, "Poem 1: Nature's Melody (Std 7)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 1: Unit 1 – Learning & Adventure", "Poem 1: Nature's Melody (Std 7)", ch_ENG_7_2_1_2, "Rhyme Scheme & Figures of Speech");

        // Unit: Term 1: Unit 2 – Values & Courage
        Unit u_ENG_7_2_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 1: Unit 2 – Values & Courage", 2, "English", board, classLevel)));

        // Chapter: Prose 2: Acts of Bravery (Std 7)
        Chapter ch_ENG_7_2_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 1: Unit 2 – Values & Courage", 3, "Prose 2: Acts of Bravery (Std 7)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 1: Unit 2 – Values & Courage", "Prose 2: Acts of Bravery (Std 7)", ch_ENG_7_2_2_3, "Grammar & Direct Indirect Speech");

        // Chapter: Supplementary: Life Lessons (Std 7)
        Chapter ch_ENG_7_2_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 1: Unit 2 – Values & Courage", 4, "Supplementary: Life Lessons (Std 7)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 1: Unit 2 – Values & Courage", "Supplementary: Life Lessons (Std 7)", ch_ENG_7_2_2_4, "Character Sketches & Morals");

        // Unit: Term 2: Unit 3 – Art, Culture & Heritage
        Unit u_ENG_7_2_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 2: Unit 3 – Art, Culture & Heritage", 3, "English", board, classLevel)));

        // Chapter: Prose 3: Treasures of History (Std 7)
        Chapter ch_ENG_7_2_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 2: Unit 3 – Art, Culture & Heritage", 5, "Prose 3: Treasures of History (Std 7)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 2: Unit 3 – Art, Culture & Heritage", "Prose 3: Treasures of History (Std 7)", ch_ENG_7_2_3_5, "Comprehension & Essay Writing");

        // Chapter: Poem 2: Echoes of the Past (Std 7)
        Chapter ch_ENG_7_2_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 2: Unit 3 – Art, Culture & Heritage", 6, "Poem 2: Echoes of the Past (Std 7)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 2: Unit 3 – Art, Culture & Heritage", "Poem 2: Echoes of the Past (Std 7)", ch_ENG_7_2_3_6, "Metaphors & Imagery");

        // Unit: Term 2: Unit 4 – Science & Tomorrow
        Unit u_ENG_7_2_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 2: Unit 4 – Science & Tomorrow", 4, "English", board, classLevel)));

        // Chapter: Prose 4: Innovations Changing Lives (Std 7)
        Chapter ch_ENG_7_2_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 2: Unit 4 – Science & Tomorrow", 7, "Prose 4: Innovations Changing Lives (Std 7)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 2: Unit 4 – Science & Tomorrow", "Prose 4: Innovations Changing Lives (Std 7)", ch_ENG_7_2_4_7, "Active Passive Voice & Tenses");

        // Chapter: Supplementary: Dreams into Reality (Std 7)
        Chapter ch_ENG_7_2_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 2: Unit 4 – Science & Tomorrow", 8, "Supplementary: Dreams into Reality (Std 7)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 2: Unit 4 – Science & Tomorrow", "Supplementary: Dreams into Reality (Std 7)", ch_ENG_7_2_4_8, "Plot Summary & Analysis");

        // Unit: Term 3: Unit 5 – Environment & Harmony
        Unit u_ENG_7_2_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 3: Unit 5 – Environment & Harmony", 5, "English", board, classLevel)));

        // Chapter: Prose 5: Guardians of Nature (Std 7)
        Chapter ch_ENG_7_2_5_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 3: Unit 5 – Environment & Harmony", 9, "Prose 5: Guardians of Nature (Std 7)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 3: Unit 5 – Environment & Harmony", "Prose 5: Guardians of Nature (Std 7)", ch_ENG_7_2_5_9, "Clauses & Conjunctions");

        // Chapter: Poem 3: The Green Earth (Std 7)
        Chapter ch_ENG_7_2_5_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 3: Unit 5 – Environment & Harmony", 10, "Poem 3: The Green Earth (Std 7)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 3: Unit 5 – Environment & Harmony", "Poem 3: The Green Earth (Std 7)", ch_ENG_7_2_5_10, "Poetic Appreciation");

        // Unit: Term 3: Unit 6 – Humanity & Sports
        Unit u_ENG_7_2_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 3: Unit 6 – Humanity & Sports", 6, "English", board, classLevel)));

        // Chapter: Prose 6: Champions of the Game (Std 7)
        Chapter ch_ENG_7_2_6_11 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 11)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 3: Unit 6 – Humanity & Sports", 11, "Prose 6: Champions of the Game (Std 7)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 3: Unit 6 – Humanity & Sports", "Prose 6: Champions of the Game (Std 7)", ch_ENG_7_2_6_11, "Formal Letter & Report Writing");

        // Chapter: Supplementary: Triumph of Will (Std 7)
        Chapter ch_ENG_7_2_6_12 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 12)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 3: Unit 6 – Humanity & Sports", 12, "Supplementary: Triumph of Will (Std 7)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 3: Unit 6 – Humanity & Sports", "Supplementary: Triumph of Will (Std 7)", ch_ENG_7_2_6_12, "Theme & Message");

        // Subject: Mathematics
        Subject sub_MATH_7_3 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Mathematics")
                .orElseGet(() -> subjectRepository.save(new Subject("Mathematics", "MATH", "📐", "#4834d4", board, classLevel)));

        // Unit: Unit 1: Number System (Integers)
        Unit u_MATH_7_3_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Number System (Integers)", 1, "Mathematics", board, classLevel)));

        // Chapter: Integers & Operations
        Chapter ch_MATH_7_3_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 1: Number System (Integers)", 1, "Integers & Operations", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 1: Number System (Integers)", "Integers & Operations", ch_MATH_7_3_1_1, "Properties of Addition & Multiplication");

        // Unit: Unit 2: Measurements & Area
        Unit u_MATH_7_3_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Measurements & Area", 2, "Mathematics", board, classLevel)));

        // Chapter: Area of Parallelogram, Rhombus & Trapezium
        Chapter ch_MATH_7_3_2_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 2: Measurements & Area", 2, "Area of Parallelogram, Rhombus & Trapezium", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 2: Measurements & Area", "Area of Parallelogram, Rhombus & Trapezium", ch_MATH_7_3_2_2, "Formulae & Problem Solving");

        // Unit: Unit 3: Algebra & Expressions
        Unit u_MATH_7_3_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Algebra & Expressions", 3, "Mathematics", board, classLevel)));

        // Chapter: Algebraic Terms, Degree & Operations
        Chapter ch_MATH_7_3_3_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 3: Algebra & Expressions", 3, "Algebraic Terms, Degree & Operations", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 3: Algebra & Expressions", "Algebraic Terms, Degree & Operations", ch_MATH_7_3_3_3, "Simplification & Evaluating Expressions");

        // Unit: Unit 4: Direct and Inverse Proportion
        Unit u_MATH_7_3_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Direct and Inverse Proportion", 4, "Mathematics", board, classLevel)));

        // Chapter: Direct Proportion & Inverse Proportion
        Chapter ch_MATH_7_3_4_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 4: Direct and Inverse Proportion", 4, "Direct Proportion & Inverse Proportion", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 4: Direct and Inverse Proportion", "Direct Proportion & Inverse Proportion", ch_MATH_7_3_4_4, "Unitary & Proportion Calculations");

        // Unit: Unit 5: Geometry & Congruence
        Unit u_MATH_7_3_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 5: Geometry & Congruence", 5, "Mathematics", board, classLevel)));

        // Chapter: Angles on Lines & Congruent Triangles
        Chapter ch_MATH_7_3_5_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 5: Geometry & Congruence", 5, "Angles on Lines & Congruent Triangles", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 5: Geometry & Congruence", "Angles on Lines & Congruent Triangles", ch_MATH_7_3_5_5, "Alternate & Corresponding Angles");

        // Unit: Unit 6: Information Processing
        Unit u_MATH_7_3_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 6: Information Processing", 6, "Mathematics", board, classLevel)));

        // Chapter: Graph Coloring & Route Finding
        Chapter ch_MATH_7_3_6_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 6: Information Processing", 6, "Graph Coloring & Route Finding", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 6: Information Processing", "Graph Coloring & Route Finding", ch_MATH_7_3_6_6, "Network Logic");

        // Subject: Science
        Subject sub_SCI_7_4 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Science")
                .orElseGet(() -> subjectRepository.save(new Subject("Science", "SCI", "🔬", "#eb4d4b", board, classLevel)));

        // Unit: Unit 1: Physics – Measurement & Motion
        Unit u_SCI_7_4_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Physics – Measurement & Motion", 1, "Science", board, classLevel)));

        // Chapter: Measurement of Derived Quantities
        Chapter ch_SCI_7_4_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 1: Physics – Measurement & Motion", 1, "Measurement of Derived Quantities", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 1: Physics – Measurement & Motion", "Measurement of Derived Quantities", ch_SCI_7_4_1_1, "Area, Volume, Density & Speed");

        // Chapter: Force and Motion – Types of Motion
        Chapter ch_SCI_7_4_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 1: Physics – Measurement & Motion", 2, "Force and Motion – Types of Motion", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 1: Physics – Measurement & Motion", "Force and Motion – Types of Motion", ch_SCI_7_4_1_2, "Linear, Circular, Rotational & Periodic");

        // Unit: Unit 2: Physics – Light & Heat
        Unit u_SCI_7_4_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Physics – Light & Heat", 2, "Science", board, classLevel)));

        // Chapter: Light – Reflection & Rectilinear Propagation
        Chapter ch_SCI_7_4_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 2: Physics – Light & Heat", 3, "Light – Reflection & Rectilinear Propagation", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 2: Physics – Light & Heat", "Light – Reflection & Rectilinear Propagation", ch_SCI_7_4_2_3, "Shadows, Mirrors, Reflection Laws & Spectrum");

        // Chapter: Heat and Temperature
        Chapter ch_SCI_7_4_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 2: Physics – Light & Heat", 4, "Heat and Temperature", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 2: Physics – Light & Heat", "Heat and Temperature", ch_SCI_7_4_2_4, "Conduction, Convection, Radiation & Thermometer");

        // Unit: Unit 3: Physics – Electricity
        Unit u_SCI_7_4_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Physics – Electricity", 3, "Science", board, classLevel)));

        // Chapter: Electric Current & Circuits
        Chapter ch_SCI_7_4_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 3: Physics – Electricity", 5, "Electric Current & Circuits", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 3: Physics – Electricity", "Electric Current & Circuits", ch_SCI_7_4_3_5, "Symbols, Simple Circuits & Effects of Current");

        // Unit: Unit 4: Chemistry – Matter & Atomic Structure
        Unit u_SCI_7_4_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Chemistry – Matter & Atomic Structure", 4, "Science", board, classLevel)));

        // Chapter: Matter Around Us – Elements & Compounds
        Chapter ch_SCI_7_4_4_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 4: Chemistry – Matter & Atomic Structure", 6, "Matter Around Us – Elements & Compounds", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 4: Chemistry – Matter & Atomic Structure", "Matter Around Us – Elements & Compounds", ch_SCI_7_4_4_6, "Symbols, Formulae & Atomicity");

        // Chapter: Atomic Structure
        Chapter ch_SCI_7_4_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 4: Chemistry – Matter & Atomic Structure", 7, "Atomic Structure", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 4: Chemistry – Matter & Atomic Structure", "Atomic Structure", ch_SCI_7_4_4_7, "Electrons, Protons, Neutrons & Valency");

        // Unit: Unit 5: Chemistry – Changes Around Us
        Unit u_SCI_7_4_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 5: Chemistry – Changes Around Us", 5, "Science", board, classLevel)));

        // Chapter: Physical & Chemical Changes
        Chapter ch_SCI_7_4_5_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 5: Chemistry – Changes Around Us", 8, "Physical & Chemical Changes", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 5: Chemistry – Changes Around Us", "Physical & Chemical Changes", ch_SCI_7_4_5_8, "Rusting, Crystallisation & Neutralisation");

        // Unit: Unit 6: Biology – Plants & Living Organisms
        Unit u_SCI_7_4_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 6: Biology – Plants & Living Organisms", 6, "Science", board, classLevel)));

        // Chapter: Reproduction & Modification in Plants
        Chapter ch_SCI_7_4_6_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 6: Biology – Plants & Living Organisms", 9, "Reproduction & Modification in Plants", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 6: Biology – Plants & Living Organisms", "Reproduction & Modification in Plants", ch_SCI_7_4_6_9, "Flowers, Pollination, Fertilisation & Root modifications");

        // Chapter: Cell Structure & Functions
        Chapter ch_SCI_7_4_6_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 6: Biology – Plants & Living Organisms", 10, "Cell Structure & Functions", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 6: Biology – Plants & Living Organisms", "Cell Structure & Functions", ch_SCI_7_4_6_10, "Plant vs Animal Cell, Organelles & Nucleus");

        // Unit: Unit 7: Biology – Health, Hygiene & Ecology
        Unit u_SCI_7_4_7 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 7).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 7: Biology – Health, Hygiene & Ecology", 7, "Science", board, classLevel)));

        // Chapter: Health and Hygiene – Microbes & Safety
        Chapter ch_SCI_7_4_7_11 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 11)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 7: Biology – Health, Hygiene & Ecology", 11, "Health and Hygiene – Microbes & Safety", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 7: Biology – Health, Hygiene & Ecology", "Health and Hygiene – Microbes & Safety", ch_SCI_7_4_7_11, "Bacterial/Viral Diseases & First Aid");

        // Chapter: Ecosystems and Environment
        Chapter ch_SCI_7_4_7_12 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 12)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 7: Biology – Health, Hygiene & Ecology", 12, "Ecosystems and Environment", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 7: Biology – Health, Hygiene & Ecology", "Ecosystems and Environment", ch_SCI_7_4_7_12, "Food Chains, Food Webs & Biodiversity");

        // Subject: Social Science
        Subject sub_SOC_7_5 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Social Science")
                .orElseGet(() -> subjectRepository.save(new Subject("Social Science", "SOC", "🌍", "#10ac84", board, classLevel)));

        // Unit: Unit 1: History – Medieval India & Southern Dynasties
        Unit u_SOC_7_5_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: History – Medieval India & Southern Dynasties", 1, "Social Science", board, classLevel)));

        // Chapter: Sources of Medieval India
        Chapter ch_SOC_7_5_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 1: History – Medieval India & Southern Dynasties", 1, "Sources of Medieval India", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 1: History – Medieval India & Southern Dynasties", "Sources of Medieval India", ch_SOC_7_5_1_1, "Inscriptions, Monuments, Coins & Travellers accounts");

        // Chapter: Emergence of New Kingdoms – Cholas and Pandyas
        Chapter ch_SOC_7_5_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 1: History – Medieval India & Southern Dynasties", 2, "Emergence of New Kingdoms – Cholas and Pandyas", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 1: History – Medieval India & Southern Dynasties", "Emergence of New Kingdoms – Cholas and Pandyas", ch_SOC_7_5_1_2, "Rajaraja Chola, Rajendra Chola & Temple Architecture");

        // Unit: Unit 2: History – Sultanates & Vijayanagar Empire
        Unit u_SOC_7_5_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: History – Sultanates & Vijayanagar Empire", 2, "Social Science", board, classLevel)));

        // Chapter: The Delhi Sultanate (Slave to Lodi Dynasties)
        Chapter ch_SOC_7_5_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 2: History – Sultanates & Vijayanagar Empire", 3, "The Delhi Sultanate (Slave to Lodi Dynasties)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 2: History – Sultanates & Vijayanagar Empire", "The Delhi Sultanate (Slave to Lodi Dynasties)", ch_SOC_7_5_2_3, "Qutb-ud-din, Alauddin Khalji & Muhammad bin Tughlaq");

        // Chapter: The Vijayanagar and Bahmani Kingdoms
        Chapter ch_SOC_7_5_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 2: History – Sultanates & Vijayanagar Empire", 4, "The Vijayanagar and Bahmani Kingdoms", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 2: History – Sultanates & Vijayanagar Empire", "The Vijayanagar and Bahmani Kingdoms", ch_SOC_7_5_2_4, "Harihara, Bukka, Krishnadevaraya & Administration");

        // Unit: Unit 3: Geography – Earth Interior, Resources & Weather
        Unit u_SOC_7_5_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Geography – Earth Interior, Resources & Weather", 3, "Social Science", board, classLevel)));

        // Chapter: Interior of the Earth & Plate Tectonics
        Chapter ch_SOC_7_5_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 3: Geography – Earth Interior, Resources & Weather", 5, "Interior of the Earth & Plate Tectonics", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 3: Geography – Earth Interior, Resources & Weather", "Interior of the Earth & Plate Tectonics", ch_SOC_7_5_3_5, "Crust, Mantle, Core, Earthquakes & Volcanoes");

        // Chapter: Weather and Climate – Wind & Humidity
        Chapter ch_SOC_7_5_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 3: Geography – Earth Interior, Resources & Weather", 6, "Weather and Climate – Wind & Humidity", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 3: Geography – Earth Interior, Resources & Weather", "Weather and Climate – Wind & Humidity", ch_SOC_7_5_3_6, "Atmospheric Pressure, Monsoons & Cyclones");

        // Unit: Unit 4: Geography – Population, Settlement & Tourism
        Unit u_SOC_7_5_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Geography – Population, Settlement & Tourism", 4, "Social Science", board, classLevel)));

        // Chapter: Human Settlements, Migration & Tourism
        Chapter ch_SOC_7_5_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 4: Geography – Population, Settlement & Tourism", 7, "Human Settlements, Migration & Tourism", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 4: Geography – Population, Settlement & Tourism", "Human Settlements, Migration & Tourism", ch_SOC_7_5_4_7, "Urbanisation, Cultural Tourism & World Heritage Sites");

        // Unit: Unit 5: Civics – State Government & Media
        Unit u_SOC_7_5_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 5: Civics – State Government & Media", 5, "Social Science", board, classLevel)));

        // Chapter: How the State Government Works
        Chapter ch_SOC_7_5_5_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 5: Civics – State Government & Media", 8, "How the State Government Works", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 5: Civics – State Government & Media", "How the State Government Works", ch_SOC_7_5_5_8, "Governor, Chief Minister, MLAs & Legislative Assembly");

        // Chapter: Media and Democracy & Women Empowerment
        Chapter ch_SOC_7_5_5_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 5: Civics – State Government & Media", 9, "Media and Democracy & Women Empowerment", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 5: Civics – State Government & Media", "Media and Democracy & Women Empowerment", ch_SOC_7_5_5_9, "Fourth Pillar of Democracy, Gender Equality");

        // Unit: Unit 6: Economics – Production, Tax & Markets
        Unit u_SOC_7_5_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 6: Economics – Production, Tax & Markets", 6, "Social Science", board, classLevel)));

        // Chapter: Production, Factors of Production & Taxes
        Chapter ch_SOC_7_5_6_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 6: Economics – Production, Tax & Markets", 10, "Production, Factors of Production & Taxes", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 6: Economics – Production, Tax & Markets", "Production, Factors of Production & Taxes", ch_SOC_7_5_6_10, "Land, Labour, Capital, Organization & Direct/Indirect Taxes");

    }

    private void seed_STATE_BOARD_Class_8() {
        String board = "STATE_BOARD";
        int classLevel = 8;

        // Subject: Tamil
        Subject sub_TAM_8_1 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Tamil")
                .orElseGet(() -> subjectRepository.save(new Subject("Tamil", "TAM", "📖", "#e84118", board, classLevel)));

        // Unit: இயல் 1: தமிழ் இன்பம்
        Unit u_TAM_8_1_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 1: தமிழ் இன்பம்", 1, "Tamil", board, classLevel)));

        // Chapter: தமிழ் மொழி வாழ்த்து
        Chapter ch_TAM_8_1_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 1: தமிழ் இன்பம்", 1, "தமிழ் மொழி வாழ்த்து", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 1: தமிழ் இன்பம்", "தமிழ் மொழி வாழ்த்து", ch_TAM_8_1_1_1, "பாரதியார் வாழ்த்து");

        // Chapter: தமிழ் வரிவடிவ வளர்ச்சி
        Chapter ch_TAM_8_1_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 1: தமிழ் இன்பம்", 2, "தமிழ் வரிவடிவ வளர்ச்சி", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 1: தமிழ் இன்பம்", "தமிழ் வரிவடிவ வளர்ச்சி", ch_TAM_8_1_1_2, "வட்டெழுத்து & தமிழ் எழுத்துகள்");

        // Unit: இயல் 2: ஈடிலா இயற்கை
        Unit u_TAM_8_1_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 2: ஈடிலா இயற்கை", 2, "Tamil", board, classLevel)));

        // Chapter: ஓடை
        Chapter ch_TAM_8_1_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 2: ஈடிலா இயற்கை", 3, "ஓடை", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 2: ஈடிலா இயற்கை", "ஓடை", ch_TAM_8_1_2_3, "வாணிதாசன் இயற்கை எழில்");

        // Chapter: கோணக்காத்துப் பாட்டு
        Chapter ch_TAM_8_1_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 2: ஈடிலா இயற்கை", 4, "கோணக்காத்துப் பாட்டு", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 2: ஈடிலா இயற்கை", "கோணக்காத்துப் பாட்டு", ch_TAM_8_1_2_4, "வெங்கம்பூர் சாமிநாதன்");

        // Unit: இயல் 3: உடலை ஓம்புமின்
        Unit u_TAM_8_1_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 3: உடலை ஓம்புமின்", 3, "Tamil", board, classLevel)));

        // Chapter: நோயும் மருந்தும்
        Chapter ch_TAM_8_1_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 3: உடலை ஓம்புமின்", 5, "நோயும் மருந்தும்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 3: உடலை ஓம்புமின்", "நோயும் மருந்தும்", ch_TAM_8_1_3_5, "நீலகேசி ஐஞ்சிறுங்காப்பியம்");

        // Chapter: தமிழர் மருத்துவம்
        Chapter ch_TAM_8_1_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 3: உடலை ஓம்புமின்", 6, "தமிழர் மருத்துவம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 3: உடலை ஓம்புமின்", "தமிழர் மருத்துவம்", ch_TAM_8_1_3_6, "சித்த மருத்துவம் & மூலிகைகள்");

        // Unit: இயல் 4: கல்வி கரையில
        Unit u_TAM_8_1_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 4: கல்வி கரையில", 4, "Tamil", board, classLevel)));

        // Chapter: கல்வி அழகே அழகு
        Chapter ch_TAM_8_1_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 4: கல்வி கரையில", 7, "கல்வி அழகே அழகு", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 4: கல்வி கரையில", "கல்வி அழகே அழகு", ch_TAM_8_1_4_7, "குமரகுருபரர் நீதிநெறி");

        // Chapter: புத்தியைத் தீட்டு
        Chapter ch_TAM_8_1_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 4: கல்வி கரையில", 8, "புத்தியைத் தீட்டு", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 4: கல்வி கரையில", "புத்தியைத் தீட்டு", ch_TAM_8_1_4_8, "ஆலங்குடி சோமு");

        // Unit: இயல் 5: கலை அழகு
        Unit u_TAM_8_1_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 5: கலை அழகு", 5, "Tamil", board, classLevel)));

        // Chapter: திருவாரூர் நான்மணிமாலை
        Chapter ch_TAM_8_1_5_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 5: கலை அழகு", 9, "திருவாரூர் நான்மணிமாலை", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 5: கலை அழகு", "திருவாரூர் நான்மணிமாலை", ch_TAM_8_1_5_9, "பக்திப் பாடல்");

        // Chapter: தமிழர் இசைக்கருவிகள்
        Chapter ch_TAM_8_1_5_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 5: கலை அழகு", 10, "தமிழர் இசைக்கருவிகள்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 5: கலை அழகு", "தமிழர் இசைக்கருவிகள்", ch_TAM_8_1_5_10, "தோல், துளை, நரம்புக் கருவிகள்");

        // Unit: இயல் 6: நாகரிகம் தொழில்
        Unit u_TAM_8_1_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 6: நாகரிகம் தொழில்", 6, "Tamil", board, classLevel)));

        // Chapter: வளம் பெருகுக
        Chapter ch_TAM_8_1_6_11 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 11)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 6: நாகரிகம் தொழில்", 11, "வளம் பெருகுக", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 6: நாகரிகம் தொழில்", "வளம் பெருகுக", ch_TAM_8_1_6_11, "தகடூர் யாத்திரை மழை வளம்");

        // Chapter: கொங்குநாட்டு வணிகம்
        Chapter ch_TAM_8_1_6_12 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 12)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 6: நாகரிகம் தொழில்", 12, "கொங்குநாட்டு வணிகம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 6: நாகரிகம் தொழில்", "கொங்குநாட்டு வணிகம்", ch_TAM_8_1_6_12, "பண்டைய வர்த்தகம்");

        // Unit: இயல் 7: பார் போற்றும் மனிதர்கள்
        Unit u_TAM_8_1_7 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 7).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 7: பார் போற்றும் மனிதர்கள்", 7, "Tamil", board, classLevel)));

        // Chapter: படை வேழம்
        Chapter ch_TAM_8_1_7_13 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 13)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 7: பார் போற்றும் மனிதர்கள்", 13, "படை வேழம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 7: பார் போற்றும் மனிதர்கள்", "படை வேழம்", ch_TAM_8_1_7_13, "செயங்கொண்டார் கலிங்கத்துப் பரணி");

        // Chapter: பாரத ரத்னா எம்.ஜி.ஆர்
        Chapter ch_TAM_8_1_7_14 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 14)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 7: பார் போற்றும் மனிதர்கள்", 14, "பாரத ரத்னா எம்.ஜி.ஆர்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 7: பார் போற்றும் மனிதர்கள்", "பாரத ரத்னா எம்.ஜி.ஆர்", ch_TAM_8_1_7_14, "சத்துணவு திட்டம் & சேவை");

        // Unit: இயல் 8: அறநெறிச்சாரம்
        Unit u_TAM_8_1_8 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 8).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 8: அறநெறிச்சாரம்", 8, "Tamil", board, classLevel)));

        // Chapter: ஒன்றே குலம்
        Chapter ch_TAM_8_1_8_15 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 15)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 8: அறநெறிச்சாரம்", 15, "ஒன்றே குலம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 8: அறநெறிச்சாரம்", "ஒன்றே குலம்", ch_TAM_8_1_8_15, "திருமூலர் திருமந்திரம்");

        // Chapter: சட்டமேதை அம்பேத்கர்
        Chapter ch_TAM_8_1_8_16 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 16)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 8: அறநெறிச்சாரம்", 16, "சட்டமேதை அம்பேத்கர்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 8: அறநெறிச்சாரம்", "சட்டமேதை அம்பேத்கர்", ch_TAM_8_1_8_16, "இந்திய அரசியல் சாசனம்");

        // Unit: இயல் 9: மனிதநேயம்
        Unit u_TAM_8_1_9 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 9).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 9: மனிதநேயம்", 9, "Tamil", board, classLevel)));

        // Chapter: உயிர் குணங்கள்
        Chapter ch_TAM_8_1_9_17 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 17)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 9: மனிதநேயம்", 17, "உயிர் குணங்கள்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 9: மனிதநேயம்", "உயிர் குணங்கள்", ch_TAM_8_1_9_17, "இறையரசன் பாமாலை");

        // Chapter: இளைய தோழனுக்கு
        Chapter ch_TAM_8_1_9_18 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 18)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 9: மனிதநேயம்", 18, "இளைய தோழனுக்கு", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 9: மனிதநேயம்", "இளைய தோழனுக்கு", ch_TAM_8_1_9_18, "மு. மேத்தா விழிப்புணர்வு");

        // Subject: English
        Subject sub_ENG_8_2 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "English")
                .orElseGet(() -> subjectRepository.save(new Subject("English", "ENG", "📚", "#fa8231", board, classLevel)));

        // Unit: Term 1: Unit 1 – Learning & Adventure
        Unit u_ENG_8_2_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 1: Unit 1 – Learning & Adventure", 1, "English", board, classLevel)));

        // Chapter: Prose 1: Inspiring Journeys (Std 8)
        Chapter ch_ENG_8_2_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 1: Unit 1 – Learning & Adventure", 1, "Prose 1: Inspiring Journeys (Std 8)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 1: Unit 1 – Learning & Adventure", "Prose 1: Inspiring Journeys (Std 8)", ch_ENG_8_2_1_1, "Vocabulary & Reading");

        // Chapter: Poem 1: Nature's Melody (Std 8)
        Chapter ch_ENG_8_2_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 1: Unit 1 – Learning & Adventure", 2, "Poem 1: Nature's Melody (Std 8)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 1: Unit 1 – Learning & Adventure", "Poem 1: Nature's Melody (Std 8)", ch_ENG_8_2_1_2, "Rhyme Scheme & Figures of Speech");

        // Unit: Term 1: Unit 2 – Values & Courage
        Unit u_ENG_8_2_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 1: Unit 2 – Values & Courage", 2, "English", board, classLevel)));

        // Chapter: Prose 2: Acts of Bravery (Std 8)
        Chapter ch_ENG_8_2_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 1: Unit 2 – Values & Courage", 3, "Prose 2: Acts of Bravery (Std 8)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 1: Unit 2 – Values & Courage", "Prose 2: Acts of Bravery (Std 8)", ch_ENG_8_2_2_3, "Grammar & Direct Indirect Speech");

        // Chapter: Supplementary: Life Lessons (Std 8)
        Chapter ch_ENG_8_2_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 1: Unit 2 – Values & Courage", 4, "Supplementary: Life Lessons (Std 8)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 1: Unit 2 – Values & Courage", "Supplementary: Life Lessons (Std 8)", ch_ENG_8_2_2_4, "Character Sketches & Morals");

        // Unit: Term 2: Unit 3 – Art, Culture & Heritage
        Unit u_ENG_8_2_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 2: Unit 3 – Art, Culture & Heritage", 3, "English", board, classLevel)));

        // Chapter: Prose 3: Treasures of History (Std 8)
        Chapter ch_ENG_8_2_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 2: Unit 3 – Art, Culture & Heritage", 5, "Prose 3: Treasures of History (Std 8)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 2: Unit 3 – Art, Culture & Heritage", "Prose 3: Treasures of History (Std 8)", ch_ENG_8_2_3_5, "Comprehension & Essay Writing");

        // Chapter: Poem 2: Echoes of the Past (Std 8)
        Chapter ch_ENG_8_2_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 2: Unit 3 – Art, Culture & Heritage", 6, "Poem 2: Echoes of the Past (Std 8)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 2: Unit 3 – Art, Culture & Heritage", "Poem 2: Echoes of the Past (Std 8)", ch_ENG_8_2_3_6, "Metaphors & Imagery");

        // Unit: Term 2: Unit 4 – Science & Tomorrow
        Unit u_ENG_8_2_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 2: Unit 4 – Science & Tomorrow", 4, "English", board, classLevel)));

        // Chapter: Prose 4: Innovations Changing Lives (Std 8)
        Chapter ch_ENG_8_2_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 2: Unit 4 – Science & Tomorrow", 7, "Prose 4: Innovations Changing Lives (Std 8)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 2: Unit 4 – Science & Tomorrow", "Prose 4: Innovations Changing Lives (Std 8)", ch_ENG_8_2_4_7, "Active Passive Voice & Tenses");

        // Chapter: Supplementary: Dreams into Reality (Std 8)
        Chapter ch_ENG_8_2_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 2: Unit 4 – Science & Tomorrow", 8, "Supplementary: Dreams into Reality (Std 8)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 2: Unit 4 – Science & Tomorrow", "Supplementary: Dreams into Reality (Std 8)", ch_ENG_8_2_4_8, "Plot Summary & Analysis");

        // Unit: Term 3: Unit 5 – Environment & Harmony
        Unit u_ENG_8_2_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 3: Unit 5 – Environment & Harmony", 5, "English", board, classLevel)));

        // Chapter: Prose 5: Guardians of Nature (Std 8)
        Chapter ch_ENG_8_2_5_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 3: Unit 5 – Environment & Harmony", 9, "Prose 5: Guardians of Nature (Std 8)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 3: Unit 5 – Environment & Harmony", "Prose 5: Guardians of Nature (Std 8)", ch_ENG_8_2_5_9, "Clauses & Conjunctions");

        // Chapter: Poem 3: The Green Earth (Std 8)
        Chapter ch_ENG_8_2_5_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 3: Unit 5 – Environment & Harmony", 10, "Poem 3: The Green Earth (Std 8)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 3: Unit 5 – Environment & Harmony", "Poem 3: The Green Earth (Std 8)", ch_ENG_8_2_5_10, "Poetic Appreciation");

        // Unit: Term 3: Unit 6 – Humanity & Sports
        Unit u_ENG_8_2_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 3: Unit 6 – Humanity & Sports", 6, "English", board, classLevel)));

        // Chapter: Prose 6: Champions of the Game (Std 8)
        Chapter ch_ENG_8_2_6_11 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 11)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 3: Unit 6 – Humanity & Sports", 11, "Prose 6: Champions of the Game (Std 8)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 3: Unit 6 – Humanity & Sports", "Prose 6: Champions of the Game (Std 8)", ch_ENG_8_2_6_11, "Formal Letter & Report Writing");

        // Chapter: Supplementary: Triumph of Will (Std 8)
        Chapter ch_ENG_8_2_6_12 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 12)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 3: Unit 6 – Humanity & Sports", 12, "Supplementary: Triumph of Will (Std 8)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 3: Unit 6 – Humanity & Sports", "Supplementary: Triumph of Will (Std 8)", ch_ENG_8_2_6_12, "Theme & Message");

        // Subject: Mathematics
        Subject sub_MATH_8_3 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Mathematics")
                .orElseGet(() -> subjectRepository.save(new Subject("Mathematics", "MATH", "📐", "#4834d4", board, classLevel)));

        // Unit: Unit 1: Rational Numbers & Exponents
        Unit u_MATH_8_3_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Rational Numbers & Exponents", 1, "Mathematics", board, classLevel)));

        // Chapter: Rational Numbers & Operations
        Chapter ch_MATH_8_3_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 1: Rational Numbers & Exponents", 1, "Rational Numbers & Operations", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 1: Rational Numbers & Exponents", "Rational Numbers & Operations", ch_MATH_8_3_1_1, "Closure, Commutative & Associative Laws");

        // Chapter: Square Roots, Cube Roots & Exponents
        Chapter ch_MATH_8_3_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 1: Rational Numbers & Exponents", 2, "Square Roots, Cube Roots & Exponents", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 1: Rational Numbers & Exponents", "Square Roots, Cube Roots & Exponents", ch_MATH_8_3_1_2, "Laws of Exponents & Prime Factorization");

        // Unit: Unit 2: Measurements & Circle Sectors
        Unit u_MATH_8_3_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Measurements & Circle Sectors", 2, "Mathematics", board, classLevel)));

        // Chapter: Length of Arc, Area of Sector & Perimeter
        Chapter ch_MATH_8_3_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 2: Measurements & Circle Sectors", 3, "Length of Arc, Area of Sector & Perimeter", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 2: Measurements & Circle Sectors", "Length of Arc, Area of Sector & Perimeter", ch_MATH_8_3_2_3, "Sector Formulas");

        // Unit: Unit 3: Algebra & Identities
        Unit u_MATH_8_3_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Algebra & Identities", 3, "Mathematics", board, classLevel)));

        // Chapter: Multiplication of Polynomials & Identities
        Chapter ch_MATH_8_3_3_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 3: Algebra & Identities", 4, "Multiplication of Polynomials & Identities", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 3: Algebra & Identities", "Multiplication of Polynomials & Identities", ch_MATH_8_3_3_4, "(a+b)^2, (a-b)^2, a^2-b^2");

        // Chapter: Factorisation & Linear Inequations
        Chapter ch_MATH_8_3_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 3: Algebra & Identities", 5, "Factorisation & Linear Inequations", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 3: Algebra & Identities", "Factorisation & Linear Inequations", ch_MATH_8_3_3_5, "Common Factors & Solving Inequations");

        // Unit: Unit 4: Life Mathematics
        Unit u_MATH_8_3_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Life Mathematics", 4, "Mathematics", board, classLevel)));

        // Chapter: Percentage, Profit, Loss & Discount
        Chapter ch_MATH_8_3_4_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 4: Life Mathematics", 6, "Percentage, Profit, Loss & Discount", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 4: Life Mathematics", "Percentage, Profit, Loss & Discount", ch_MATH_8_3_4_6, "Markup, Overhead Expenses & GST");

        // Chapter: Compound Interest & Depreciation
        Chapter ch_MATH_8_3_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 4: Life Mathematics", 7, "Compound Interest & Depreciation", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 4: Life Mathematics", "Compound Interest & Depreciation", ch_MATH_8_3_4_7, "Formula A = P(1 + r/100)^n");

        // Unit: Unit 5: Geometry & Quadrilaterals
        Unit u_MATH_8_3_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 5: Geometry & Quadrilaterals", 5, "Mathematics", board, classLevel)));

        // Chapter: Properties of Quadrilaterals & Construction
        Chapter ch_MATH_8_3_5_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 5: Geometry & Quadrilaterals", 8, "Properties of Quadrilaterals & Construction", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 5: Geometry & Quadrilaterals", "Properties of Quadrilaterals & Construction", ch_MATH_8_3_5_8, "Parallelogram & Rhombus Construction");

        // Unit: Unit 6: Statistics & Frequency Tables
        Unit u_MATH_8_3_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 6: Statistics & Frequency Tables", 6, "Mathematics", board, classLevel)));

        // Chapter: Grouped Frequency Tables & Histograms
        Chapter ch_MATH_8_3_6_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 6: Statistics & Frequency Tables", 9, "Grouped Frequency Tables & Histograms", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 6: Statistics & Frequency Tables", "Grouped Frequency Tables & Histograms", ch_MATH_8_3_6_9, "Histogram & Frequency Polygon");

        // Unit: Unit 7: Information Processing
        Unit u_MATH_8_3_7 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 7).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 7: Information Processing", 7, "Mathematics", board, classLevel)));

        // Chapter: Cryptology & Magic Squares
        Chapter ch_MATH_8_3_7_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 7: Information Processing", 10, "Cryptology & Magic Squares", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 7: Information Processing", "Cryptology & Magic Squares", ch_MATH_8_3_7_10, "Caesar Cipher & Encoding Methods");

        // Subject: Science
        Subject sub_SCI_8_4 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Science")
                .orElseGet(() -> subjectRepository.save(new Subject("Science", "SCI", "🔬", "#eb4d4b", board, classLevel)));

        // Unit: Unit 1: Physics – Mechanics & Pressure
        Unit u_SCI_8_4_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Physics – Mechanics & Pressure", 1, "Science", board, classLevel)));

        // Chapter: Measurement & Fundamental Quantities
        Chapter ch_SCI_8_4_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 1: Physics – Mechanics & Pressure", 1, "Measurement & Fundamental Quantities", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 1: Physics – Mechanics & Pressure", "Measurement & Fundamental Quantities", ch_SCI_8_4_1_1, "Vernier Calliper & Screw Gauge");

        // Chapter: Forces, Pressure & Friction
        Chapter ch_SCI_8_4_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 1: Physics – Mechanics & Pressure", 2, "Forces, Pressure & Friction", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 1: Physics – Mechanics & Pressure", "Forces, Pressure & Friction", ch_SCI_8_4_1_2, "Pascal's Law, Atmospheric Pressure & Friction Types");

        // Unit: Unit 2: Physics – Light, Sound & Heat
        Unit u_SCI_8_4_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Physics – Light, Sound & Heat", 2, "Science", board, classLevel)));

        // Chapter: Light – Spherical Mirrors & Refraction
        Chapter ch_SCI_8_4_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 2: Physics – Light, Sound & Heat", 3, "Light – Spherical Mirrors & Refraction", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 2: Physics – Light, Sound & Heat", "Light – Spherical Mirrors & Refraction", ch_SCI_8_4_2_3, "Concave/Convex Mirrors, Snell's Law");

        // Chapter: Sound – Waves, Speed & Noise Pollution
        Chapter ch_SCI_8_4_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 2: Physics – Light, Sound & Heat", 4, "Sound – Waves, Speed & Noise Pollution", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 2: Physics – Light, Sound & Heat", "Sound – Waves, Speed & Noise Pollution", ch_SCI_8_4_2_4, "Frequency, Pitch, Amplitude & Ultrasound");

        // Chapter: Heat – Thermal Expansion & Specific Heat
        Chapter ch_SCI_8_4_2_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 2: Physics – Light, Sound & Heat", 5, "Heat – Thermal Expansion & Specific Heat", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 2: Physics – Light, Sound & Heat", "Heat – Thermal Expansion & Specific Heat", ch_SCI_8_4_2_5, "Calorimetry & Greenhouse Effect");

        // Unit: Unit 3: Physics – Electricity & Magnetism
        Unit u_SCI_8_4_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Physics – Electricity & Magnetism", 3, "Science", board, classLevel)));

        // Chapter: Electricity – Static & Current
        Chapter ch_SCI_8_4_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 3: Physics – Electricity & Magnetism", 6, "Electricity – Static & Current", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 3: Physics – Electricity & Magnetism", "Electricity – Static & Current", ch_SCI_8_4_3_6, "Electroscope, Chemical Effects & Electroplating");

        // Chapter: Magnetism & Magnetic Fields
        Chapter ch_SCI_8_4_3_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 3: Physics – Electricity & Magnetism", 7, "Magnetism & Magnetic Fields", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 3: Physics – Electricity & Magnetism", "Magnetism & Magnetic Fields", ch_SCI_8_4_3_7, "Earth's Magnetism & Magnetic Lines of Force");

        // Chapter: Universe and Space Science
        Chapter ch_SCI_8_4_3_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 3: Physics – Electricity & Magnetism", 8, "Universe and Space Science", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 3: Physics – Electricity & Magnetism", "Universe and Space Science", ch_SCI_8_4_3_8, "Rockets, ISRO Satellites & Solar System");

        // Unit: Unit 4: Chemistry – Matter, Air & Water
        Unit u_SCI_8_4_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Chemistry – Matter, Air & Water", 4, "Science", board, classLevel)));

        // Chapter: Matter Around Us – Metals & Non-Metals
        Chapter ch_SCI_8_4_4_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 4: Chemistry – Matter, Air & Water", 9, "Matter Around Us – Metals & Non-Metals", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 4: Chemistry – Matter, Air & Water", "Matter Around Us – Metals & Non-Metals", ch_SCI_8_4_4_9, "Physical & Chemical Properties, Corrosion");

        // Chapter: Air & Oxygen Preparation
        Chapter ch_SCI_8_4_4_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 4: Chemistry – Matter, Air & Water", 10, "Air & Oxygen Preparation", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 4: Chemistry – Matter, Air & Water", "Air & Oxygen Preparation", ch_SCI_8_4_4_10, "Oxygen, Nitrogen, Carbon Dioxide properties");

        // Chapter: Water Purification & Hardness
        Chapter ch_SCI_8_4_4_11 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 11)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 4: Chemistry – Matter, Air & Water", 11, "Water Purification & Hardness", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 4: Chemistry – Matter, Air & Water", "Water Purification & Hardness", ch_SCI_8_4_4_11, "Temporary/Permanent Hardness & Softening");

        // Unit: Unit 5: Chemistry – Atomic Structure & Reactions
        Unit u_SCI_8_4_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 5: Chemistry – Atomic Structure & Reactions", 5, "Science", board, classLevel)));

        // Chapter: Atomic Structure & Chemical Bonding
        Chapter ch_SCI_8_4_5_12 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 12)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 5: Chemistry – Atomic Structure & Reactions", 12, "Atomic Structure & Chemical Bonding", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 5: Chemistry – Atomic Structure & Reactions", "Atomic Structure & Chemical Bonding", ch_SCI_8_4_5_12, "Dalton / Thomson / Rutherford Models & Covalent / Ionic Bonds");

        // Chapter: Acids, Bases and Salts
        Chapter ch_SCI_8_4_5_13 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 13)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 5: Chemistry – Atomic Structure & Reactions", 13, "Acids, Bases and Salts", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 5: Chemistry – Atomic Structure & Reactions", "Acids, Bases and Salts", ch_SCI_8_4_5_13, "pH Scale, Indicators & Industrial Uses");

        // Chapter: Chemistry in Everyday Life
        Chapter ch_SCI_8_4_5_14 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 14)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 5: Chemistry – Atomic Structure & Reactions", 14, "Chemistry in Everyday Life", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 5: Chemistry – Atomic Structure & Reactions", "Chemistry in Everyday Life", ch_SCI_8_4_5_14, "Polymers, Plastics, Glass, Dyes & Drugs");

        // Unit: Unit 6: Biology – Microorganisms & Plants
        Unit u_SCI_8_4_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 6: Biology – Microorganisms & Plants", 6, "Science", board, classLevel)));

        // Chapter: Microorganisms – Bacteria, Fungi, Viruses
        Chapter ch_SCI_8_4_6_15 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 15)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 6: Biology – Microorganisms & Plants", 15, "Microorganisms – Bacteria, Fungi, Viruses", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 6: Biology – Microorganisms & Plants", "Microorganisms – Bacteria, Fungi, Viruses", ch_SCI_8_4_6_15, "Beneficial & Harmful Microbes, Vaccines");

        // Chapter: Plant Kingdom – Cryptogams & Phanerogams
        Chapter ch_SCI_8_4_6_16 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 16)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 6: Biology – Microorganisms & Plants", 16, "Plant Kingdom – Cryptogams & Phanerogams", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 6: Biology – Microorganisms & Plants", "Plant Kingdom – Cryptogams & Phanerogams", ch_SCI_8_4_6_16, "Algae, Bryophytes, Pteridophytes & Gymnosperms");

        // Unit: Unit 7: Biology – Animal Systems & Adolescence
        Unit u_SCI_8_4_7 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 7).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 7: Biology – Animal Systems & Adolescence", 7, "Science", board, classLevel)));

        // Chapter: Organisation of Life & Tissues
        Chapter ch_SCI_8_4_7_17 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 17)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 7: Biology – Animal Systems & Adolescence", 17, "Organisation of Life & Tissues", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 7: Biology – Animal Systems & Adolescence", "Organisation of Life & Tissues", ch_SCI_8_4_7_17, "Epithelial, Muscular, Nervous Tissues");

        // Chapter: Movements in Animals – Skeleton & Joints
        Chapter ch_SCI_8_4_7_18 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 18)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 7: Biology – Animal Systems & Adolescence", 18, "Movements in Animals – Skeleton & Joints", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 7: Biology – Animal Systems & Adolescence", "Movements in Animals – Skeleton & Joints", ch_SCI_8_4_7_18, "Human Skeletal System & Locomotion");

        // Chapter: Reaching the Age of Adolescence
        Chapter ch_SCI_8_4_7_19 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 19)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 7: Biology – Animal Systems & Adolescence", 19, "Reaching the Age of Adolescence", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 7: Biology – Animal Systems & Adolescence", "Reaching the Age of Adolescence", ch_SCI_8_4_7_19, "Endocrine Glands, Hormones & Reproductive Health");

        // Unit: Unit 8: Biology – Agriculture & Conservation
        Unit u_SCI_8_4_8 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 8).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 8: Biology – Agriculture & Conservation", 8, "Science", board, classLevel)));

        // Chapter: Crop Production and Management
        Chapter ch_SCI_8_4_8_20 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 20)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 8: Biology – Agriculture & Conservation", 20, "Crop Production and Management", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 8: Biology – Agriculture & Conservation", "Crop Production and Management", ch_SCI_8_4_8_20, "Irrigation, Weeding, Harvesting & Storage");

        // Chapter: Conservation of Plants and Animals
        Chapter ch_SCI_8_4_8_21 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 21)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 8: Biology – Agriculture & Conservation", 21, "Conservation of Plants and Animals", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 8: Biology – Agriculture & Conservation", "Conservation of Plants and Animals", ch_SCI_8_4_8_21, "Deforestation, Red Data Book, National Parks");

        // Subject: Social Science
        Subject sub_SOC_8_5 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Social Science")
                .orElseGet(() -> subjectRepository.save(new Subject("Social Science", "SOC", "🌍", "#10ac84", board, classLevel)));

        // Unit: Unit 1: History – Colonialism & Rebellions in India
        Unit u_SOC_8_5_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: History – Colonialism & Rebellions in India", 1, "Social Science", board, classLevel)));

        // Chapter: Advent of the Europeans – Portuguese to British
        Chapter ch_SOC_8_5_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 1: History – Colonialism & Rebellions in India", 1, "Advent of the Europeans – Portuguese to British", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 1: History – Colonialism & Rebellions in India", "Advent of the Europeans – Portuguese to British", ch_SOC_8_5_1_1, "Vasco da Gama, Battle of Plassey 1757, Buxar 1764");

        // Chapter: From Trade to Territory – Subsidiary Alliance & Lapse
        Chapter ch_SOC_8_5_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 1: History – Colonialism & Rebellions in India", 2, "From Trade to Territory – Subsidiary Alliance & Lapse", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 1: History – Colonialism & Rebellions in India", "From Trade to Territory – Subsidiary Alliance & Lapse", ch_SOC_8_5_1_2, "Lord Wellesley & Dalhousie policies");

        // Chapter: Rural Life and Society – Permanent Settlement & Ryotwari
        Chapter ch_SOC_8_5_1_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 1: History – Colonialism & Rebellions in India", 3, "Rural Life and Society – Permanent Settlement & Ryotwari", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 1: History – Colonialism & Rebellions in India", "Rural Life and Society – Permanent Settlement & Ryotwari", ch_SOC_8_5_1_3, "Land Revenue Systems & Peasant Revolts");

        // Unit: Unit 2: History – Great Revolt of 1857 & Social Reforms
        Unit u_SOC_8_5_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: History – Great Revolt of 1857 & Social Reforms", 2, "Social Science", board, classLevel)));

        // Chapter: People's Revolt – South Indian Rebellion & 1857 Revolt
        Chapter ch_SOC_8_5_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 2: History – Great Revolt of 1857 & Social Reforms", 4, "People's Revolt – South Indian Rebellion & 1857 Revolt", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 2: History – Great Revolt of 1857 & Social Reforms", "People's Revolt – South Indian Rebellion & 1857 Revolt", ch_SOC_8_5_2_4, "Kattabomman, Maruthu Brothers, Mangal Pandey, Rani Lakshmibai");

        // Chapter: Educational Development & Social Reforms in India
        Chapter ch_SOC_8_5_2_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 2: History – Great Revolt of 1857 & Social Reforms", 5, "Educational Development & Social Reforms in India", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 2: History – Great Revolt of 1857 & Social Reforms", "Educational Development & Social Reforms in India", ch_SOC_8_5_2_5, "Wood's Despatch, Raja Ram Mohan Roy, Vidyasagar & Periyar");

        // Unit: Unit 3: Geography – Rocks, Soils, Weather & Hydrology
        Unit u_SOC_8_5_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Geography – Rocks, Soils, Weather & Hydrology", 3, "Social Science", board, classLevel)));

        // Chapter: Rocks and Soils – Types & Soil Conservation
        Chapter ch_SOC_8_5_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 3: Geography – Rocks, Soils, Weather & Hydrology", 6, "Rocks and Soils – Types & Soil Conservation", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 3: Geography – Rocks, Soils, Weather & Hydrology", "Rocks and Soils – Types & Soil Conservation", ch_SOC_8_5_3_6, "Igneous, Sedimentary, Metamorphic rocks & Soil Profiles");

        // Chapter: Weather, Climate & Hydrologic Cycle
        Chapter ch_SOC_8_5_3_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 3: Geography – Rocks, Soils, Weather & Hydrology", 7, "Weather, Climate & Hydrologic Cycle", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 3: Geography – Rocks, Soils, Weather & Hydrology", "Weather, Climate & Hydrologic Cycle", ch_SOC_8_5_3_7, "Precipitation, Infiltration & Evapotranspiration");

        // Unit: Unit 4: Geography – Hazards, Migration & Industries
        Unit u_SOC_8_5_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Geography – Hazards, Migration & Industries", 4, "Social Science", board, classLevel)));

        // Chapter: Hazards and Disaster Management
        Chapter ch_SOC_8_5_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 4: Geography – Hazards, Migration & Industries", 8, "Hazards and Disaster Management", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 4: Geography – Hazards, Migration & Industries", "Hazards and Disaster Management", ch_SOC_8_5_4_8, "Floods, Droughts, Tsunamis & Disaster Mitigation");

        // Chapter: Migration, Urbanisation & Industries Classification
        Chapter ch_SOC_8_5_4_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 4: Geography – Hazards, Migration & Industries", 9, "Migration, Urbanisation & Industries Classification", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 4: Geography – Hazards, Migration & Industries", "Migration, Urbanisation & Industries Classification", ch_SOC_8_5_4_9, "Push/Pull Factors, Agro/Mineral based Industries");

        // Unit: Unit 5: Civics – Constitution, Secularism & Rights
        Unit u_SOC_8_5_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 5: Civics – Constitution, Secularism & Rights", 5, "Social Science", board, classLevel)));

        // Chapter: Citizen and Citizenship – Indian Citizenship Act 1955
        Chapter ch_SOC_8_5_5_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 5: Civics – Constitution, Secularism & Rights", 10, "Citizen and Citizenship – Indian Citizenship Act 1955", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 5: Civics – Constitution, Secularism & Rights", "Citizen and Citizenship – Indian Citizenship Act 1955", ch_SOC_8_5_5_10, "Acquisition & Loss of Citizenship");

        // Chapter: Understanding Secularism & Human Rights / UNO
        Chapter ch_SOC_8_5_5_11 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 11)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 5: Civics – Constitution, Secularism & Rights", 11, "Understanding Secularism & Human Rights / UNO", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 5: Civics – Constitution, Secularism & Rights", "Understanding Secularism & Human Rights / UNO", ch_SOC_8_5_5_11, "Articles 25-28, UDHR 1948 & National Human Rights Commission");

        // Chapter: Road Safety Rules and Regulations
        Chapter ch_SOC_8_5_5_12 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 12)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 5: Civics – Constitution, Secularism & Rights", 12, "Road Safety Rules and Regulations", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 5: Civics – Constitution, Secularism & Rights", "Road Safety Rules and Regulations", ch_SOC_8_5_5_12, "Traffic Signs, Mandatory Rules & Road Safety Measures");

        // Unit: Unit 6: Economics – Money, Savings & Public Sector
        Unit u_SOC_8_5_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 6: Economics – Money, Savings & Public Sector", 6, "Social Science", board, classLevel)));

        // Chapter: Money, Savings and Investments
        Chapter ch_SOC_8_5_6_13 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 13)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 6: Economics – Money, Savings & Public Sector", 13, "Money, Savings and Investments", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 6: Economics – Money, Savings & Public Sector", "Money, Savings and Investments", ch_SOC_8_5_6_13, "Functions of Money, Plastic Money & Digital Payments");

        // Chapter: Public and Private Sectors in India
        Chapter ch_SOC_8_5_6_14 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 14)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 6: Economics – Money, Savings & Public Sector", 14, "Public and Private Sectors in India", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 6: Economics – Money, Savings & Public Sector", "Public and Private Sectors in India", ch_SOC_8_5_6_14, "PSUs, Mixed Economy & Socio-Economic Goals");

    }

    private void seed_STATE_BOARD_Class_9() {
        String board = "STATE_BOARD";
        int classLevel = 9;

        // Subject: Tamil
        Subject sub_TAM_9_1 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Tamil")
                .orElseGet(() -> subjectRepository.save(new Subject("Tamil", "TAM", "📖", "#e84118", board, classLevel)));

        // Unit: இயல் 1: அமுதென்று பேர்
        Unit u_TAM_9_1_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 1: அமுதென்று பேர்", 1, "Tamil", board, classLevel)));

        // Chapter: திராவிட மொழிக்குடும்பம்
        Chapter ch_TAM_9_1_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 1: அமுதென்று பேர்", 1, "திராவிட மொழிக்குடும்பம்", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 1: அமுதென்று பேர்", "திராவிட மொழிக்குடும்பம்", ch_TAM_9_1_1_1, "கால்டுவெல் திராவிட ஒப்பிலக்கணம்");

        // Chapter: தமிழ்த்தூது
        Chapter ch_TAM_9_1_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 1: அமுதென்று பேர்", 2, "தமிழ்த்தூது", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 1: அமுதென்று பேர்", "தமிழ்த்தூது", ch_TAM_9_1_1_2, "சிற்றிலக்கியச் சிறப்பு");

        // Unit: இயல் 2: உயிர்மூச்சு
        Unit u_TAM_9_1_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 2: உயிர்மூச்சு", 2, "Tamil", board, classLevel)));

        // Chapter: பட்டமரம்
        Chapter ch_TAM_9_1_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 2: உயிர்மூச்சு", 3, "பட்டமரம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 2: உயிர்மூச்சு", "பட்டமரம்", ch_TAM_9_1_2_3, "கவிஞர் தமிழ்ஒளி");

        // Chapter: பெரியபுராணம்
        Chapter ch_TAM_9_1_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 2: உயிர்மூச்சு", 4, "பெரியபுராணம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 2: உயிர்மூச்சு", "பெரியபுராணம்", ch_TAM_9_1_2_4, "சேக்கிழார் திருநாட்டுச் சிறப்பு");

        // Unit: இயல் 3: உள்ளத்தின் சீர்
        Unit u_TAM_9_1_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 3: உள்ளத்தின் சீர்", 3, "Tamil", board, classLevel)));

        // Chapter: ஏறு தழுவுதல்
        Chapter ch_TAM_9_1_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 3: உள்ளத்தின் சீர்", 5, "ஏறு தழுவுதல்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 3: உள்ளத்தின் சீர்", "ஏறு தழுவுதல்", ch_TAM_9_1_3_5, "ஜல்லிக்கட்டு சங்க மரபு");

        // Chapter: மணிமேகலை: விழாவறை காதை
        Chapter ch_TAM_9_1_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 3: உள்ளத்தின் சீர்", 6, "மணிமேகலை: விழாவறை காதை", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 3: உள்ளத்தின் சீர்", "மணிமேகலை: விழாவறை காதை", ch_TAM_9_1_3_6, "சீத்தலைச் சாத்தனார் இந்திர விழா");

        // Unit: இயல் 4: எட்டுத்திக்கும் சென்றிடுவீர்
        Unit u_TAM_9_1_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 4: எட்டுத்திக்கும் சென்றிடுவீர்", 4, "Tamil", board, classLevel)));

        // Chapter: விண்ணையும் சாடுவோம்
        Chapter ch_TAM_9_1_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 4: எட்டுத்திக்கும் சென்றிடுவீர்", 7, "விண்ணையும் சாடுவோம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 4: எட்டுத்திக்கும் சென்றிடுவீர்", "விண்ணையும் சாடுவோம்", ch_TAM_9_1_4_7, "இஸ்ரோ விண்வெளி சாதனை");

        // Chapter: சீவக சிந்தாமணி
        Chapter ch_TAM_9_1_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 4: எட்டுத்திக்கும் சென்றிடுவீர்", 8, "சீவக சிந்தாமணி", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 4: எட்டுத்திக்கும் சென்றிடுவீர்", "சீவக சிந்தாமணி", ch_TAM_9_1_4_8, "திருத்தக்கதேவர் காப்பியம்");

        // Unit: இயல் 5: கசடறக் கற்றல்
        Unit u_TAM_9_1_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 5: கசடறக் கற்றல்", 5, "Tamil", board, classLevel)));

        // Chapter: குடும்ப விளக்கு
        Chapter ch_TAM_9_1_5_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 5: கசடறக் கற்றல்", 9, "குடும்ப விளக்கு", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 5: கசடறக் கற்றல்", "குடும்ப விளக்கு", ch_TAM_9_1_5_9, "பாரதிதாசன் பெண் கல்வி");

        // Chapter: சிறுபஞ்சமூலம்
        Chapter ch_TAM_9_1_5_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 5: கசடறக் கற்றல்", 10, "சிறுபஞ்சமூலம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 5: கசடறக் கற்றல்", "சிறுபஞ்சமூலம்", ch_TAM_9_1_5_10, "காரியாசான் ஐந்தறக் கருத்துகள்");

        // Unit: இயல் 6: கலை பல வளர்த்தல்
        Unit u_TAM_9_1_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 6: கலை பல வளர்த்தல்", 6, "Tamil", board, classLevel)));

        // Chapter: சிற்பக்கலை
        Chapter ch_TAM_9_1_6_11 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 11)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 6: கலை பல வளர்த்தல்", 11, "சிற்பக்கலை", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 6: கலை பல வளர்த்தல்", "சிற்பக்கலை", ch_TAM_9_1_6_11, "மாமல்லபுரம் & சோழர் சிற்பங்கள்");

        // Chapter: நாச்சியார் திருமொழி
        Chapter ch_TAM_9_1_6_12 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 12)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 6: கலை பல வளர்த்தல்", 12, "நாச்சியார் திருமொழி", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 6: கலை பல வளர்த்தல்", "நாச்சியார் திருமொழி", ch_TAM_9_1_6_12, "ஆண்டாள் பக்திப் பாடல்");

        // Unit: இயல் 7: வாழிய நிலனே
        Unit u_TAM_9_1_7 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 7).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 7: வாழிய நிலனே", 7, "Tamil", board, classLevel)));

        // Chapter: இந்திய தேசிய இராணுவத்தில் தமிழர்
        Chapter ch_TAM_9_1_7_13 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 13)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 7: வாழிய நிலனே", 13, "இந்திய தேசிய இராணுவத்தில் தமிழர்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 7: வாழிய நிலனே", "இந்திய தேசிய இராணுவத்தில் தமிழர்", ch_TAM_9_1_7_13, "நேதாஜி & தமிழர் பங்கு");

        // Chapter: சீறாப்புராணம்
        Chapter ch_TAM_9_1_7_14 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 14)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 7: வாழிய நிலனே", 14, "சீறாப்புராணம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 7: வாழிய நிலனே", "சீறாப்புராணம்", ch_TAM_9_1_7_14, "உமறுப்புலவர் நபிகள் நாயகம்");

        // Unit: இயல் 8: எண்திக்கும் புகழ் மணக்க
        Unit u_TAM_9_1_8 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 8).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 8: எண்திக்கும் புகழ் மணக்க", 8, "Tamil", board, classLevel)));

        // Chapter: பெரியாரின் சிந்தனைகள்
        Chapter ch_TAM_9_1_8_15 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 15)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 8: எண்திக்கும் புகழ் மணக்க", 15, "பெரியாரின் சிந்தனைகள்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 8: எண்திக்கும் புகழ் மணக்க", "பெரியாரின் சிந்தனைகள்", ch_TAM_9_1_8_15, "சமூக நீதி & பகுத்தறிவு");

        // Chapter: ஒளியின் அழைப்பு
        Chapter ch_TAM_9_1_8_16 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 16)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 8: எண்திக்கும் புகழ் மணக்க", 16, "ஒளியின் அழைப்பு", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 8: எண்திக்கும் புகழ் மணக்க", "ஒளியின் அழைப்பு", ch_TAM_9_1_8_16, "ந. பிச்சமூர்த்தி புதுக்கவிதை");

        // Unit: இயல் 9: அன்பின் மொழி
        Unit u_TAM_9_1_9 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 9).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 9: அன்பின் மொழி", 9, "Tamil", board, classLevel)));

        // Chapter: விரிவாகும் ஆளுமை
        Chapter ch_TAM_9_1_9_17 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 17)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 9: அன்பின் மொழி", 17, "விரிவாகும் ஆளுமை", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 9: அன்பின் மொழி", "விரிவாகும் ஆளுமை", ch_TAM_9_1_9_17, "ஆல்பர்ட் சுவைட்சர் மனிதநேயம்");

        // Chapter: குறுந்தொகை: யாயும் ஞாயும்
        Chapter ch_TAM_9_1_9_18 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 18)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 9: அன்பின் மொழி", 18, "குறுந்தொகை: யாயும் ஞாயும்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 9: அன்பின் மொழி", "குறுந்தொகை: யாயும் ஞாயும்", ch_TAM_9_1_9_18, "செம்புலப் பெயல்நீரார் சங்கக் காதல்");

        // Subject: English
        Subject sub_ENG_9_2 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "English")
                .orElseGet(() -> subjectRepository.save(new Subject("English", "ENG", "📚", "#fa8231", board, classLevel)));

        // Unit: Term 1: Unit 1 – Learning & Adventure
        Unit u_ENG_9_2_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 1: Unit 1 – Learning & Adventure", 1, "English", board, classLevel)));

        // Chapter: Prose 1: Inspiring Journeys (Std 9)
        Chapter ch_ENG_9_2_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 1: Unit 1 – Learning & Adventure", 1, "Prose 1: Inspiring Journeys (Std 9)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 1: Unit 1 – Learning & Adventure", "Prose 1: Inspiring Journeys (Std 9)", ch_ENG_9_2_1_1, "Vocabulary & Reading");

        // Chapter: Poem 1: Nature's Melody (Std 9)
        Chapter ch_ENG_9_2_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 1: Unit 1 – Learning & Adventure", 2, "Poem 1: Nature's Melody (Std 9)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 1: Unit 1 – Learning & Adventure", "Poem 1: Nature's Melody (Std 9)", ch_ENG_9_2_1_2, "Rhyme Scheme & Figures of Speech");

        // Unit: Term 1: Unit 2 – Values & Courage
        Unit u_ENG_9_2_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 1: Unit 2 – Values & Courage", 2, "English", board, classLevel)));

        // Chapter: Prose 2: Acts of Bravery (Std 9)
        Chapter ch_ENG_9_2_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 1: Unit 2 – Values & Courage", 3, "Prose 2: Acts of Bravery (Std 9)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 1: Unit 2 – Values & Courage", "Prose 2: Acts of Bravery (Std 9)", ch_ENG_9_2_2_3, "Grammar & Direct Indirect Speech");

        // Chapter: Supplementary: Life Lessons (Std 9)
        Chapter ch_ENG_9_2_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 1: Unit 2 – Values & Courage", 4, "Supplementary: Life Lessons (Std 9)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 1: Unit 2 – Values & Courage", "Supplementary: Life Lessons (Std 9)", ch_ENG_9_2_2_4, "Character Sketches & Morals");

        // Unit: Term 2: Unit 3 – Art, Culture & Heritage
        Unit u_ENG_9_2_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 2: Unit 3 – Art, Culture & Heritage", 3, "English", board, classLevel)));

        // Chapter: Prose 3: Treasures of History (Std 9)
        Chapter ch_ENG_9_2_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 2: Unit 3 – Art, Culture & Heritage", 5, "Prose 3: Treasures of History (Std 9)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 2: Unit 3 – Art, Culture & Heritage", "Prose 3: Treasures of History (Std 9)", ch_ENG_9_2_3_5, "Comprehension & Essay Writing");

        // Chapter: Poem 2: Echoes of the Past (Std 9)
        Chapter ch_ENG_9_2_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 2: Unit 3 – Art, Culture & Heritage", 6, "Poem 2: Echoes of the Past (Std 9)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 2: Unit 3 – Art, Culture & Heritage", "Poem 2: Echoes of the Past (Std 9)", ch_ENG_9_2_3_6, "Metaphors & Imagery");

        // Unit: Term 2: Unit 4 – Science & Tomorrow
        Unit u_ENG_9_2_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 2: Unit 4 – Science & Tomorrow", 4, "English", board, classLevel)));

        // Chapter: Prose 4: Innovations Changing Lives (Std 9)
        Chapter ch_ENG_9_2_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 2: Unit 4 – Science & Tomorrow", 7, "Prose 4: Innovations Changing Lives (Std 9)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 2: Unit 4 – Science & Tomorrow", "Prose 4: Innovations Changing Lives (Std 9)", ch_ENG_9_2_4_7, "Active Passive Voice & Tenses");

        // Chapter: Supplementary: Dreams into Reality (Std 9)
        Chapter ch_ENG_9_2_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 2: Unit 4 – Science & Tomorrow", 8, "Supplementary: Dreams into Reality (Std 9)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 2: Unit 4 – Science & Tomorrow", "Supplementary: Dreams into Reality (Std 9)", ch_ENG_9_2_4_8, "Plot Summary & Analysis");

        // Unit: Term 3: Unit 5 – Environment & Harmony
        Unit u_ENG_9_2_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 3: Unit 5 – Environment & Harmony", 5, "English", board, classLevel)));

        // Chapter: Prose 5: Guardians of Nature (Std 9)
        Chapter ch_ENG_9_2_5_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 3: Unit 5 – Environment & Harmony", 9, "Prose 5: Guardians of Nature (Std 9)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 3: Unit 5 – Environment & Harmony", "Prose 5: Guardians of Nature (Std 9)", ch_ENG_9_2_5_9, "Clauses & Conjunctions");

        // Chapter: Poem 3: The Green Earth (Std 9)
        Chapter ch_ENG_9_2_5_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 3: Unit 5 – Environment & Harmony", 10, "Poem 3: The Green Earth (Std 9)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 3: Unit 5 – Environment & Harmony", "Poem 3: The Green Earth (Std 9)", ch_ENG_9_2_5_10, "Poetic Appreciation");

        // Unit: Term 3: Unit 6 – Humanity & Sports
        Unit u_ENG_9_2_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 3: Unit 6 – Humanity & Sports", 6, "English", board, classLevel)));

        // Chapter: Prose 6: Champions of the Game (Std 9)
        Chapter ch_ENG_9_2_6_11 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 11)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 3: Unit 6 – Humanity & Sports", 11, "Prose 6: Champions of the Game (Std 9)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 3: Unit 6 – Humanity & Sports", "Prose 6: Champions of the Game (Std 9)", ch_ENG_9_2_6_11, "Formal Letter & Report Writing");

        // Chapter: Supplementary: Triumph of Will (Std 9)
        Chapter ch_ENG_9_2_6_12 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 12)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 3: Unit 6 – Humanity & Sports", 12, "Supplementary: Triumph of Will (Std 9)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 3: Unit 6 – Humanity & Sports", "Supplementary: Triumph of Will (Std 9)", ch_ENG_9_2_6_12, "Theme & Message");

        // Subject: Mathematics
        Subject sub_MATH_9_3 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Mathematics")
                .orElseGet(() -> subjectRepository.save(new Subject("Mathematics", "MATH", "📐", "#4834d4", board, classLevel)));

        // Unit: Unit 1: Set Language
        Unit u_MATH_9_3_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Set Language", 1, "Mathematics", board, classLevel)));

        // Chapter: Set Operations & Venn Diagrams
        Chapter ch_MATH_9_3_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 1: Set Language", 1, "Set Operations & Venn Diagrams", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 1: Set Language", "Set Operations & Venn Diagrams", ch_MATH_9_3_1_1, "Union, Intersection, Complement & De Morgan Laws");

        // Unit: Unit 2: Real Numbers
        Unit u_MATH_9_3_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Real Numbers", 2, "Mathematics", board, classLevel)));

        // Chapter: Surds, Rationalisation & Scientific Notation
        Chapter ch_MATH_9_3_2_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 2: Real Numbers", 2, "Surds, Rationalisation & Scientific Notation", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 2: Real Numbers", "Surds, Rationalisation & Scientific Notation", ch_MATH_9_3_2_2, "Radicals & Properties of Real Numbers");

        // Unit: Unit 3: Algebra & Polynomials
        Unit u_MATH_9_3_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Algebra & Polynomials", 3, "Mathematics", board, classLevel)));

        // Chapter: Polynomials, Remainder Theorem & Factor Theorem
        Chapter ch_MATH_9_3_3_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 3: Algebra & Polynomials", 3, "Polynomials, Remainder Theorem & Factor Theorem", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 3: Algebra & Polynomials", "Polynomials, Remainder Theorem & Factor Theorem", ch_MATH_9_3_3_3, "Factorisation of Cubics & Synthetic Division");

        // Chapter: Linear Equations in Two Variables
        Chapter ch_MATH_9_3_3_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 3: Algebra & Polynomials", 4, "Linear Equations in Two Variables", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 3: Algebra & Polynomials", "Linear Equations in Two Variables", ch_MATH_9_3_3_4, "Simultaneous Equations & Elimination Method");

        // Unit: Unit 4: Geometry & Circles
        Unit u_MATH_9_3_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Geometry & Circles", 4, "Mathematics", board, classLevel)));

        // Chapter: Theorems on Triangles, Chords & Cyclic Quads
        Chapter ch_MATH_9_3_4_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 4: Geometry & Circles", 5, "Theorems on Triangles, Chords & Cyclic Quads", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 4: Geometry & Circles", "Theorems on Triangles, Chords & Cyclic Quads", ch_MATH_9_3_4_5, "Circumcentre, Incentre & Centroid");

        // Unit: Unit 5: Coordinate Geometry
        Unit u_MATH_9_3_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 5: Coordinate Geometry", 5, "Mathematics", board, classLevel)));

        // Chapter: Distance Formula & Section Formula
        Chapter ch_MATH_9_3_5_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 5: Coordinate Geometry", 6, "Distance Formula & Section Formula", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 5: Coordinate Geometry", "Distance Formula & Section Formula", ch_MATH_9_3_5_6, "Midpoint, Centroid & Area of Triangle");

        // Unit: Unit 6: Trigonometry
        Unit u_MATH_9_3_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 6: Trigonometry", 6, "Mathematics", board, classLevel)));

        // Chapter: Trigonometric Ratios & Complementary Angles
        Chapter ch_MATH_9_3_6_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 6: Trigonometry", 7, "Trigonometric Ratios & Complementary Angles", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 6: Trigonometry", "Trigonometric Ratios & Complementary Angles", ch_MATH_9_3_6_7, "sin, cos, tan 0, 30, 45, 60, 90 deg");

        // Unit: Unit 7: Mensuration
        Unit u_MATH_9_3_7 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 7).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 7: Mensuration", 7, "Mathematics", board, classLevel)));

        // Chapter: Surface Area & Volume of Cuboids & Cylinders
        Chapter ch_MATH_9_3_7_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 7: Mensuration", 8, "Surface Area & Volume of Cuboids & Cylinders", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 7: Mensuration", "Surface Area & Volume of Cuboids & Cylinders", ch_MATH_9_3_7_8, "TSA, CSA & Volume Calculations");

        // Unit: Unit 8: Statistics
        Unit u_MATH_9_3_8 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 8).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 8: Statistics", 8, "Mathematics", board, classLevel)));

        // Chapter: Mean, Median & Mode of Ungrouped & Grouped Data
        Chapter ch_MATH_9_3_8_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 8: Statistics", 9, "Mean, Median & Mode of Ungrouped & Grouped Data", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 8: Statistics", "Mean, Median & Mode of Ungrouped & Grouped Data", ch_MATH_9_3_8_9, "Measures of Central Tendency");

        // Unit: Unit 9: Probability
        Unit u_MATH_9_3_9 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 9).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 9: Probability", 9, "Mathematics", board, classLevel)));

        // Chapter: Empirical Probability & Events
        Chapter ch_MATH_9_3_9_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 9: Probability", 10, "Empirical Probability & Events", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 9: Probability", "Empirical Probability & Events", ch_MATH_9_3_9_10, "Coin Tossing, Dice Rolling & Card Problems");

        // Subject: Science
        Subject sub_SCI_9_4 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Science")
                .orElseGet(() -> subjectRepository.save(new Subject("Science", "SCI", "🔬", "#eb4d4b", board, classLevel)));

        // Unit: Unit 1: Physics – Measurement & Mechanics
        Unit u_SCI_9_4_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Physics – Measurement & Mechanics", 1, "Science", board, classLevel)));

        // Chapter: Measurement – Screw Gauge & Balance
        Chapter ch_SCI_9_4_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 1: Physics – Measurement & Mechanics", 1, "Measurement – Screw Gauge & Balance", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 1: Physics – Measurement & Mechanics", "Measurement – Screw Gauge & Balance", ch_SCI_9_4_1_1, "Zero Error & Least Count");

        // Chapter: Motion – Equations of Motion
        Chapter ch_SCI_9_4_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 1: Physics – Measurement & Mechanics", 2, "Motion – Equations of Motion", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 1: Physics – Measurement & Mechanics", "Motion – Equations of Motion", ch_SCI_9_4_1_2, "v = u + at, s = ut + 1/2at^2, v^2 = u^2 + 2as");

        // Chapter: Fluids – Archimedes Principle & Density
        Chapter ch_SCI_9_4_1_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 1: Physics – Measurement & Mechanics", 3, "Fluids – Archimedes Principle & Density", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 1: Physics – Measurement & Mechanics", "Fluids – Archimedes Principle & Density", ch_SCI_9_4_1_3, "Buoyancy, Pascal Law & Relative Density");

        // Unit: Unit 2: Physics – Electricity & Magnetism
        Unit u_SCI_9_4_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Physics – Electricity & Magnetism", 2, "Science", board, classLevel)));

        // Chapter: Electric Charge and Electric Current
        Chapter ch_SCI_9_4_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 2: Physics – Electricity & Magnetism", 4, "Electric Charge and Electric Current", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 2: Physics – Electricity & Magnetism", "Electric Charge and Electric Current", ch_SCI_9_4_2_4, "Ohm's Law, Resistance in Series/Parallel");

        // Chapter: Magnetism and Electromagnetism
        Chapter ch_SCI_9_4_2_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 2: Physics – Electricity & Magnetism", 5, "Magnetism and Electromagnetism", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 2: Physics – Electricity & Magnetism", "Magnetism and Electromagnetism", ch_SCI_9_4_2_5, "Magnetic Induction, Solenoid & Electric Motors");

        // Unit: Unit 3: Physics – Light, Sound & Heat
        Unit u_SCI_9_4_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Physics – Light, Sound & Heat", 3, "Science", board, classLevel)));

        // Chapter: Light – Reflection, Refraction & Lenses
        Chapter ch_SCI_9_4_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 3: Physics – Light, Sound & Heat", 6, "Light – Reflection, Refraction & Lenses", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 3: Physics – Light, Sound & Heat", "Light – Reflection, Refraction & Lenses", ch_SCI_9_4_3_6, "Lens Formula, Magnification & Power");

        // Chapter: Heat – Latent Heat & Thermodynamics Basics
        Chapter ch_SCI_9_4_3_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 3: Physics – Light, Sound & Heat", 7, "Heat – Latent Heat & Thermodynamics Basics", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 3: Physics – Light, Sound & Heat", "Heat – Latent Heat & Thermodynamics Basics", ch_SCI_9_4_3_7, "Specific Heat Capacity & Phase Transitions");

        // Chapter: Sound – SONAR, Echo & Ultrasonic Waves
        Chapter ch_SCI_9_4_3_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 3: Physics – Light, Sound & Heat", 8, "Sound – SONAR, Echo & Ultrasonic Waves", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 3: Physics – Light, Sound & Heat", "Sound – SONAR, Echo & Ultrasonic Waves", ch_SCI_9_4_3_8, "Echo Distance Calculation & Hearing Mechanism");

        // Chapter: Universe – Gravitation & Space Science
        Chapter ch_SCI_9_4_3_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 3: Physics – Light, Sound & Heat", 9, "Universe – Gravitation & Space Science", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 3: Physics – Light, Sound & Heat", "Universe – Gravitation & Space Science", ch_SCI_9_4_3_9, "Universal Law of Gravitation & Kepler's Laws");

        // Unit: Unit 4: Chemistry – Matter & Atomic Structure
        Unit u_SCI_9_4_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Chemistry – Matter & Atomic Structure", 4, "Science", board, classLevel)));

        // Chapter: Matter Around Us – Solutions & Colloids
        Chapter ch_SCI_9_4_4_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 4: Chemistry – Matter & Atomic Structure", 10, "Matter Around Us – Solutions & Colloids", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 4: Chemistry – Matter & Atomic Structure", "Matter Around Us – Solutions & Colloids", ch_SCI_9_4_4_10, "True Solution, Suspension, Tyndall Effect");

        // Chapter: Atomic Structure – Subatomic Particles
        Chapter ch_SCI_9_4_4_11 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 11)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 4: Chemistry – Matter & Atomic Structure", 11, "Atomic Structure – Subatomic Particles", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 4: Chemistry – Matter & Atomic Structure", "Atomic Structure – Subatomic Particles", ch_SCI_9_4_4_11, "Bohr's Model, Electronic Configuration & Isotopes");

        // Chapter: Periodic Classification of Elements
        Chapter ch_SCI_9_4_4_12 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 12)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 4: Chemistry – Matter & Atomic Structure", 12, "Periodic Classification of Elements", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 4: Chemistry – Matter & Atomic Structure", "Periodic Classification of Elements", ch_SCI_9_4_4_12, "Mendeleev & Modern Periodic Table, Trends");

        // Unit: Unit 5: Chemistry – Chemical Bonding & Acids
        Unit u_SCI_9_4_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 5: Chemistry – Chemical Bonding & Acids", 5, "Science", board, classLevel)));

        // Chapter: Chemical Bonding – Ionic & Covalent
        Chapter ch_SCI_9_4_5_13 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 13)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 5: Chemistry – Chemical Bonding & Acids", 13, "Chemical Bonding – Ionic & Covalent", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 5: Chemistry – Chemical Bonding & Acids", "Chemical Bonding – Ionic & Covalent", ch_SCI_9_4_5_13, "Lewis Dot Structures, Polar & Non-Polar");

        // Chapter: Acids, Bases and Salts – Indicators
        Chapter ch_SCI_9_4_5_14 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 14)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 5: Chemistry – Chemical Bonding & Acids", 14, "Acids, Bases and Salts – Indicators", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 5: Chemistry – Chemical Bonding & Acids", "Acids, Bases and Salts – Indicators", ch_SCI_9_4_5_14, "Arrhenius Concept, pH & Neutralisation");

        // Chapter: Carbon and its Compounds – Allotropes
        Chapter ch_SCI_9_4_5_15 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 15)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 5: Chemistry – Chemical Bonding & Acids", 15, "Carbon and its Compounds – Allotropes", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 5: Chemistry – Chemical Bonding & Acids", "Carbon and its Compounds – Allotropes", ch_SCI_9_4_5_15, "Diamond, Graphite, Fullerenes & Hydrocarbons");

        // Chapter: Applied Chemistry – Electrochemistry & Fertilisers
        Chapter ch_SCI_9_4_5_16 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 16)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 5: Chemistry – Chemical Bonding & Acids", 16, "Applied Chemistry – Electrochemistry & Fertilisers", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 5: Chemistry – Chemical Bonding & Acids", "Applied Chemistry – Electrochemistry & Fertilisers", ch_SCI_9_4_5_16, "Soaps, Detergents, Biofertilisers & Polymers");

        // Unit: Unit 6: Biology – Animal Kingdom & Tissues
        Unit u_SCI_9_4_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 6: Biology – Animal Kingdom & Tissues", 6, "Science", board, classLevel)));

        // Chapter: Animal Kingdom – Invertebrates & Chordates
        Chapter ch_SCI_9_4_6_17 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 17)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 6: Biology – Animal Kingdom & Tissues", 17, "Animal Kingdom – Invertebrates & Chordates", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 6: Biology – Animal Kingdom & Tissues", "Animal Kingdom – Invertebrates & Chordates", ch_SCI_9_4_6_17, "Porifera to Mammalia Classification");

        // Chapter: Organisation of Tissues – Meristematic & Permanent
        Chapter ch_SCI_9_4_6_18 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 18)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 6: Biology – Animal Kingdom & Tissues", 18, "Organisation of Tissues – Meristematic & Permanent", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 6: Biology – Animal Kingdom & Tissues", "Organisation of Tissues – Meristematic & Permanent", ch_SCI_9_4_6_18, "Xylem, Phloem, Connective Tissue & Blood");

        // Unit: Unit 7: Biology – Plant Physiology & Nutrition
        Unit u_SCI_9_4_7 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 7).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 7: Biology – Plant Physiology & Nutrition", 7, "Science", board, classLevel)));

        // Chapter: Plant Physiology – Tropism & Photosynthesis
        Chapter ch_SCI_9_4_7_19 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 19)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 7: Biology – Plant Physiology & Nutrition", 19, "Plant Physiology – Tropism & Photosynthesis", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 7: Biology – Plant Physiology & Nutrition", "Plant Physiology – Tropism & Photosynthesis", ch_SCI_9_4_7_19, "Phototropism, Transpiration & Respiration");

        // Chapter: Organ Systems in Animals – Excretion & Nervous
        Chapter ch_SCI_9_4_7_20 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 20)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 7: Biology – Plant Physiology & Nutrition", 20, "Organ Systems in Animals – Excretion & Nervous", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 7: Biology – Plant Physiology & Nutrition", "Organ Systems in Animals – Excretion & Nervous", ch_SCI_9_4_7_20, "Nephron Function, Brain Structure & Reflex Arc");

        // Chapter: Nutrition and Health – Food Adulteration
        Chapter ch_SCI_9_4_7_21 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 21)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 7: Biology – Plant Physiology & Nutrition", 21, "Nutrition and Health – Food Adulteration", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 7: Biology – Plant Physiology & Nutrition", "Nutrition and Health – Food Adulteration", ch_SCI_9_4_7_21, "Malnutrition, Vitamins & Deficiency Diseases");

        // Unit: Unit 8: Biology – Microbes & Environment
        Unit u_SCI_9_4_8 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 8).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 8: Biology – Microbes & Environment", 8, "Science", board, classLevel)));

        // Chapter: World of Microbes – Virology & Immunology
        Chapter ch_SCI_9_4_8_22 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 22)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 8: Biology – Microbes & Environment", 22, "World of Microbes – Virology & Immunology", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 8: Biology – Microbes & Environment", "World of Microbes – Virology & Immunology", ch_SCI_9_4_8_22, "Antigens, Antibodies & Antibiotics");

        // Chapter: Economic Biology – Floriculture, Dairy, Pisciculture
        Chapter ch_SCI_9_4_8_23 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 23)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 8: Biology – Microbes & Environment", 23, "Economic Biology – Floriculture, Dairy, Pisciculture", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 8: Biology – Microbes & Environment", "Economic Biology – Floriculture, Dairy, Pisciculture", ch_SCI_9_4_8_23, "Apiculture, Sericulture & Vermicomposting");

        // Chapter: Environmental Science – Biogeochemical Cycles
        Chapter ch_SCI_9_4_8_24 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 24)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 8: Biology – Microbes & Environment", 24, "Environmental Science – Biogeochemical Cycles", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 8: Biology – Microbes & Environment", "Environmental Science – Biogeochemical Cycles", ch_SCI_9_4_8_24, "Carbon Cycle, Nitrogen Cycle & Waste Management");

        // Subject: Social Science
        Subject sub_SOC_9_5 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Social Science")
                .orElseGet(() -> subjectRepository.save(new Subject("Social Science", "SOC", "🌍", "#10ac84", board, classLevel)));

        // Unit: Unit 1: History – Evolution of Humans & Early World
        Unit u_SOC_9_5_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: History – Evolution of Humans & Early World", 1, "Social Science", board, classLevel)));

        // Chapter: Evolution of Humans and Society – Prehistoric Period
        Chapter ch_SOC_9_5_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 1: History – Evolution of Humans & Early World", 1, "Evolution of Humans and Society – Prehistoric Period", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 1: History – Evolution of Humans & Early World", "Evolution of Humans and Society – Prehistoric Period", ch_SOC_9_5_1_1, "Palaeolithic, Mesolithic, Neolithic & Metal Ages");

        // Chapter: Early Civilisations of the Ancient World
        Chapter ch_SOC_9_5_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 1: History – Evolution of Humans & Early World", 2, "Early Civilisations of the Ancient World", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 1: History – Evolution of Humans & Early World", "Early Civilisations of the Ancient World", ch_SOC_9_5_1_2, "Mesopotamia, Egyptian, Indus & Chinese Civilisations");

        // Unit: Unit 2: History – Sangam Tamil Society & World Revolutions
        Unit u_SOC_9_5_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: History – Sangam Tamil Society & World Revolutions", 2, "Social Science", board, classLevel)));

        // Chapter: Early Tamil Society and Culture – Epigraphy & Trade
        Chapter ch_SOC_9_5_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 2: History – Sangam Tamil Society & World Revolutions", 3, "Early Tamil Society and Culture – Epigraphy & Trade", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 2: History – Sangam Tamil Society & World Revolutions", "Early Tamil Society and Culture – Epigraphy & Trade", ch_SOC_9_5_2_3, "Sangam Epics, Roman Trade, Arikamedu & Keezhadi");

        // Chapter: Age of Revolutions – American, French & Industrial
        Chapter ch_SOC_9_5_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 2: History – Sangam Tamil Society & World Revolutions", 4, "Age of Revolutions – American, French & Industrial", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 2: History – Sangam Tamil Society & World Revolutions", "Age of Revolutions – American, French & Industrial", ch_SOC_9_5_2_4, "Liberty, Equality, Fraternity & Industrial Transformation");

        // Unit: Unit 3: Geography – Lithosphere & Atmosphere
        Unit u_SOC_9_5_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Geography – Lithosphere & Atmosphere", 3, "Social Science", board, classLevel)));

        // Chapter: Lithosphere – Endogenic and Exogenic Processes
        Chapter ch_SOC_9_5_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 3: Geography – Lithosphere & Atmosphere", 5, "Lithosphere – Endogenic and Exogenic Processes", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 3: Geography – Lithosphere & Atmosphere", "Lithosphere – Endogenic and Exogenic Processes", ch_SOC_9_5_3_5, "Plate Tectonics, Weathering, Rivers & Glaciers");

        // Chapter: Atmosphere – Structure, Insolation & Winds
        Chapter ch_SOC_9_5_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 3: Geography – Lithosphere & Atmosphere", 6, "Atmosphere – Structure, Insolation & Winds", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 3: Geography – Lithosphere & Atmosphere", "Atmosphere – Structure, Insolation & Winds", ch_SOC_9_5_3_6, "Troposphere to Exosphere, Planetary Winds & Jet Streams");

        // Unit: Unit 4: Geography – Hydrosphere, Biosphere & Disaster Management
        Unit u_SOC_9_5_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Geography – Hydrosphere, Biosphere & Disaster Management", 4, "Social Science", board, classLevel)));

        // Chapter: Hydrosphere – Ocean Relief & Currents
        Chapter ch_SOC_9_5_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 4: Geography – Hydrosphere, Biosphere & Disaster Management", 7, "Hydrosphere – Ocean Relief & Currents", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 4: Geography – Hydrosphere, Biosphere & Disaster Management", "Hydrosphere – Ocean Relief & Currents", ch_SOC_9_5_4_7, "Continental Shelf, Ocean Trenches & Gulf Stream");

        // Chapter: Biosphere – Biomes & Environmental Conservation
        Chapter ch_SOC_9_5_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 4: Geography – Hydrosphere, Biosphere & Disaster Management", 8, "Biosphere – Biomes & Environmental Conservation", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 4: Geography – Hydrosphere, Biosphere & Disaster Management", "Biosphere – Biomes & Environmental Conservation", ch_SOC_9_5_4_8, "Tropical Rainforests, Savannas & Biodiversity Hotspots");

        // Unit: Unit 5: Civics – Democracy, Elections & Human Rights
        Unit u_SOC_9_5_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 5: Civics – Democracy, Elections & Human Rights", 5, "Social Science", board, classLevel)));

        // Chapter: Forms of Government and Democracy
        Chapter ch_SOC_9_5_5_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 5: Civics – Democracy, Elections & Human Rights", 9, "Forms of Government and Democracy", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 5: Civics – Democracy, Elections & Human Rights", "Forms of Government and Democracy", ch_SOC_9_5_5_9, "Direct vs Representative Democracy & Constitution");

        // Chapter: Election, Political Parties and Pressure Groups
        Chapter ch_SOC_9_5_5_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 5: Civics – Democracy, Elections & Human Rights", 10, "Election, Political Parties and Pressure Groups", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 5: Civics – Democracy, Elections & Human Rights", "Election, Political Parties and Pressure Groups", ch_SOC_9_5_5_10, "Election Commission of India & EVM voting system");

        // Chapter: Fundamental Rights, Duties & Local Self Government
        Chapter ch_SOC_9_5_5_11 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 11)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 5: Civics – Democracy, Elections & Human Rights", 11, "Fundamental Rights, Duties & Local Self Government", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 5: Civics – Democracy, Elections & Human Rights", "Fundamental Rights, Duties & Local Self Government", ch_SOC_9_5_5_11, "Panchayati Raj, 73rd/74th Constitutional Amendments");

        // Unit: Unit 6: Economics – Development, Money & Agriculture
        Unit u_SOC_9_5_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 6: Economics – Development, Money & Agriculture", 6, "Social Science", board, classLevel)));

        // Chapter: Understanding Development – Perspectives & Indicators
        Chapter ch_SOC_9_5_6_12 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 12)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 6: Economics – Development, Money & Agriculture", 12, "Understanding Development – Perspectives & Indicators", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 6: Economics – Development, Money & Agriculture", "Understanding Development – Perspectives & Indicators", ch_SOC_9_5_6_12, "PCI, HDI, Sustainable Development Goals");

        // Chapter: Employment in India and Tamil Nadu
        Chapter ch_SOC_9_5_6_13 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 13)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 6: Economics – Development, Money & Agriculture", 13, "Employment in India and Tamil Nadu", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 6: Economics – Development, Money & Agriculture", "Employment in India and Tamil Nadu", ch_SOC_9_5_6_13, "Organised vs Unorganised Sectors");

        // Chapter: Money, Credit & Agriculture in Tamil Nadu
        Chapter ch_SOC_9_5_6_14 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 14)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 6: Economics – Development, Money & Agriculture", 14, "Money, Credit & Agriculture in Tamil Nadu", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 6: Economics – Development, Money & Agriculture", "Money, Credit & Agriculture in Tamil Nadu", ch_SOC_9_5_6_14, "Banking, SHGs, Crop Patterns & Cauvery Delta");

    }

    private void seed_STATE_BOARD_Class_10() {
        String board = "STATE_BOARD";
        int classLevel = 10;

        // Subject: Tamil
        Subject sub_TAM_10_1 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Tamil")
                .orElseGet(() -> subjectRepository.save(new Subject("Tamil", "TAM", "📖", "#e84118", board, classLevel)));

        // Unit: இயல் 1: மொழி – அன்னை மொழியே
        Unit u_TAM_10_1_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 1: மொழி – அன்னை மொழியே", 1, "Tamil", board, classLevel)));

        // Chapter: அன்னை மொழியே
        Chapter ch_TAM_10_1_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 1: மொழி – அன்னை மொழியே", 1, "அன்னை மொழியே", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 1: மொழி – அன்னை மொழியே", "அன்னை மொழியே", ch_TAM_10_1_1_1, "பாவலேறேறு பெருஞ்சித்திரனார்");

        // Chapter: தமிழ்ச்சொல் வளம்
        Chapter ch_TAM_10_1_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 1: மொழி – அன்னை மொழியே", 2, "தமிழ்ச்சொல் வளம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 1: மொழி – அன்னை மொழியே", "தமிழ்ச்சொல் வளம்", ch_TAM_10_1_1_2, "மொழிஞாயிறு தேவநேயப் பாவாணர்");

        // Unit: இயல் 2: இயற்கை – காற்று வா
        Unit u_TAM_10_1_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 2: இயற்கை – காற்று வா", 2, "Tamil", board, classLevel)));

        // Chapter: காற்றே வா!
        Chapter ch_TAM_10_1_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 2: இயற்கை – காற்று வா", 3, "காற்றே வா!", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 2: இயற்கை – காற்று வா", "காற்றே வா!", ch_TAM_10_1_2_3, "மகாகவி பாரதியார் வசன கவிதை");

        // Chapter: முல்லைப்பாட்டு
        Chapter ch_TAM_10_1_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 2: இயற்கை – காற்று வா", 4, "முல்லைப்பாட்டு", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 2: இயற்கை – காற்று வா", "முல்லைப்பாட்டு", ch_TAM_10_1_2_4, "நப்பூதனார் கார்கால முல்லை");

        // Unit: இயல் 3: பண்பாடு – விருந்து போற்றுதும்
        Unit u_TAM_10_1_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 3: பண்பாடு – விருந்து போற்றுதும்", 3, "Tamil", board, classLevel)));

        // Chapter: விருந்து போற்றுதும்!
        Chapter ch_TAM_10_1_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 3: பண்பாடு – விருந்து போற்றுதும்", 5, "விருந்து போற்றுதும்!", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 3: பண்பாடு – விருந்து போற்றுதும்", "விருந்து போற்றுதும்!", ch_TAM_10_1_3_5, "தமிழர் விருந்தோம்பல் மரபு");

        // Chapter: காசி காண்டம்
        Chapter ch_TAM_10_1_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 3: பண்பாடு – விருந்து போற்றுதும்", 6, "காசி காண்டம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 3: பண்பாடு – விருந்து போற்றுதும்", "காசி காண்டம்", ch_TAM_10_1_3_6, "அதிவீரராம பாண்டியர் விருந்து நெறி");

        // Unit: இயல் 4: அறிவியல் – செயற்கை நுண்ணறிவு
        Unit u_TAM_10_1_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 4: அறிவியல் – செயற்கை நுண்ணறிவு", 4, "Tamil", board, classLevel)));

        // Chapter: செயற்கை நுண்ணறிவு
        Chapter ch_TAM_10_1_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 4: அறிவியல் – செயற்கை நுண்ணறிவு", 7, "செயற்கை நுண்ணறிவு", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 4: அறிவியல் – செயற்கை நுண்ணறிவு", "செயற்கை நுண்ணறிவு", ch_TAM_10_1_4_7, "AI தொழில்நுட்பம் & எதிர்காலம்");

        // Chapter: பெருமாள் திருமொழி
        Chapter ch_TAM_10_1_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 4: அறிவியல் – செயற்கை நுண்ணறிவு", 8, "பெருமாள் திருமொழி", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 4: அறிவியல் – செயற்கை நுண்ணறிவு", "பெருமாள் திருமொழி", ch_TAM_10_1_4_8, "குலசேகர ஆழ்வார் பக்தி");

        // Unit: இயல் 5: கல்வி – மணற்கேணி
        Unit u_TAM_10_1_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 5: கல்வி – மணற்கேணி", 5, "Tamil", board, classLevel)));

        // Chapter: மொழிபெயர்ப்புக் கல்வி
        Chapter ch_TAM_10_1_5_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 5: கல்வி – மணற்கேணி", 9, "மொழிபெயர்ப்புக் கல்வி", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 5: கல்வி – மணற்கேணி", "மொழிபெயர்ப்புக் கல்வி", ch_TAM_10_1_5_9, "மொழிபெயர்ப்பு வரலாறு & மேன்மை");

        // Chapter: நீதி வெண்பா
        Chapter ch_TAM_10_1_5_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 5: கல்வி – மணற்கேணி", 10, "நீதி வெண்பா", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 5: கல்வி – மணற்கேணி", "நீதி வெண்பா", ch_TAM_10_1_5_10, "செய்குதம்பி பாவலர் சதாவதானம்");

        // Unit: இயல் 6: கலை – நிகழ்கலை
        Unit u_TAM_10_1_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 6: கலை – நிகழ்கலை", 6, "Tamil", board, classLevel)));

        // Chapter: நிகழ்கலை
        Chapter ch_TAM_10_1_6_11 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 11)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 6: கலை – நிகழ்கலை", 11, "நிகழ்கலை", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 6: கலை – நிகழ்கலை", "நிகழ்கலை", ch_TAM_10_1_6_11, "நாட்டுப்புற நடனங்கள் & தெருக்கூத்து");

        // Chapter: முத்துக்குமாரசாமி பிள்ளைத்தமிழ்
        Chapter ch_TAM_10_1_6_12 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 12)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 6: கலை – நிகழ்கலை", 12, "முத்துக்குமாரசாமி பிள்ளைத்தமிழ்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 6: கலை – நிகழ்கலை", "முத்துக்குமாரசாமி பிள்ளைத்தமிழ்", ch_TAM_10_1_6_12, "குமரகுருபரர் செங்கீரைப் பருவம்");

        // Unit: இயல் 7: நாகரிகம் – சிற்றகல் ஒளி
        Unit u_TAM_10_1_7 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 7).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 7: நாகரிகம் – சிற்றகல் ஒளி", 7, "Tamil", board, classLevel)));

        // Chapter: சிற்றகல் ஒளி
        Chapter ch_TAM_10_1_7_13 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 13)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 7: நாகரிகம் – சிற்றகல் ஒளி", 13, "சிற்றகல் ஒளி", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 7: நாகரிகம் – சிற்றகல் ஒளி", "சிற்றகல் ஒளி", ch_TAM_10_1_7_13, "ம.பொ. சிவஞானம் எல்லைப் போராட்டம்");

        // Chapter: மெய்க்கீர்த்தி
        Chapter ch_TAM_10_1_7_14 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 14)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 7: நாகரிகம் – சிற்றகல் ஒளி", 14, "மெய்க்கீர்த்தி", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 7: நாகரிகம் – சிற்றகல் ஒளி", "மெய்க்கீர்த்தி", ch_TAM_10_1_7_14, "இரண்டாம் இராசராசன் சோழர் பெருமை");

        // Unit: இயல் 8: அறம் – காலக்கணிதம்
        Unit u_TAM_10_1_8 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 8).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 8: அறம் – காலக்கணிதம்", 8, "Tamil", board, classLevel)));

        // Chapter: சங்க இலக்கியத்தில் அறம்
        Chapter ch_TAM_10_1_8_15 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 15)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 8: அறம் – காலக்கணிதம்", 15, "சங்க இலக்கியத்தில் அறம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 8: அறம் – காலக்கணிதம்", "சங்க இலக்கியத்தில் அறம்", ch_TAM_10_1_8_15, "போர் அறம் & அரசியல் அறம்");

        // Chapter: காலக்கணிதம்
        Chapter ch_TAM_10_1_8_16 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 16)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 8: அறம் – காலக்கணிதம்", 16, "காலக்கணிதம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 8: அறம் – காலக்கணிதம்", "காலக்கணிதம்", ch_TAM_10_1_8_16, "கவிஞர் கண்ணதாசன் கவிதை ஆளுமை");

        // Unit: இயல் 9: மனிதம் – ஜெயகாந்தம்
        Unit u_TAM_10_1_9 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 9).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 9: மனிதம் – ஜெயகாந்தம்", 9, "Tamil", board, classLevel)));

        // Chapter: ஜெயகாந்தம் – நினைவுக் குறிப்புகள்
        Chapter ch_TAM_10_1_9_17 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 17)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 9: மனிதம் – ஜெயகாந்தம்", 17, "ஜெயகாந்தம் – நினைவுக் குறிப்புகள்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 9: மனிதம் – ஜெயகாந்தம்", "ஜெயகாந்தம் – நினைவுக் குறிப்புகள்", ch_TAM_10_1_9_17, "ஜெயகாந்தன் சிறுகதை ஆளுமை");

        // Chapter: தேம்பாவணி
        Chapter ch_TAM_10_1_9_18 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 18)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 9: மனிதம் – ஜெயகாந்தம்", 18, "தேம்பாவணி", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 9: மனிதம் – ஜெயகாந்தம்", "தேம்பாவணி", ch_TAM_10_1_9_18, "வீரமாமுனிவர் வளன் காப்பியம்");

        // Subject: English
        Subject sub_ENG_10_2 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "English")
                .orElseGet(() -> subjectRepository.save(new Subject("English", "ENG", "📚", "#fa8231", board, classLevel)));

        // Unit: Term 1: Unit 1 – Learning & Adventure
        Unit u_ENG_10_2_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 1: Unit 1 – Learning & Adventure", 1, "English", board, classLevel)));

        // Chapter: Prose 1: Inspiring Journeys (Std 10)
        Chapter ch_ENG_10_2_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 1: Unit 1 – Learning & Adventure", 1, "Prose 1: Inspiring Journeys (Std 10)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 1: Unit 1 – Learning & Adventure", "Prose 1: Inspiring Journeys (Std 10)", ch_ENG_10_2_1_1, "Vocabulary & Reading");

        // Chapter: Poem 1: Nature's Melody (Std 10)
        Chapter ch_ENG_10_2_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 1: Unit 1 – Learning & Adventure", 2, "Poem 1: Nature's Melody (Std 10)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 1: Unit 1 – Learning & Adventure", "Poem 1: Nature's Melody (Std 10)", ch_ENG_10_2_1_2, "Rhyme Scheme & Figures of Speech");

        // Unit: Term 1: Unit 2 – Values & Courage
        Unit u_ENG_10_2_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 1: Unit 2 – Values & Courage", 2, "English", board, classLevel)));

        // Chapter: Prose 2: Acts of Bravery (Std 10)
        Chapter ch_ENG_10_2_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 1: Unit 2 – Values & Courage", 3, "Prose 2: Acts of Bravery (Std 10)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 1: Unit 2 – Values & Courage", "Prose 2: Acts of Bravery (Std 10)", ch_ENG_10_2_2_3, "Grammar & Direct Indirect Speech");

        // Chapter: Supplementary: Life Lessons (Std 10)
        Chapter ch_ENG_10_2_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 1: Unit 2 – Values & Courage", 4, "Supplementary: Life Lessons (Std 10)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 1: Unit 2 – Values & Courage", "Supplementary: Life Lessons (Std 10)", ch_ENG_10_2_2_4, "Character Sketches & Morals");

        // Unit: Term 2: Unit 3 – Art, Culture & Heritage
        Unit u_ENG_10_2_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 2: Unit 3 – Art, Culture & Heritage", 3, "English", board, classLevel)));

        // Chapter: Prose 3: Treasures of History (Std 10)
        Chapter ch_ENG_10_2_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 2: Unit 3 – Art, Culture & Heritage", 5, "Prose 3: Treasures of History (Std 10)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 2: Unit 3 – Art, Culture & Heritage", "Prose 3: Treasures of History (Std 10)", ch_ENG_10_2_3_5, "Comprehension & Essay Writing");

        // Chapter: Poem 2: Echoes of the Past (Std 10)
        Chapter ch_ENG_10_2_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 2: Unit 3 – Art, Culture & Heritage", 6, "Poem 2: Echoes of the Past (Std 10)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 2: Unit 3 – Art, Culture & Heritage", "Poem 2: Echoes of the Past (Std 10)", ch_ENG_10_2_3_6, "Metaphors & Imagery");

        // Unit: Term 2: Unit 4 – Science & Tomorrow
        Unit u_ENG_10_2_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 2: Unit 4 – Science & Tomorrow", 4, "English", board, classLevel)));

        // Chapter: Prose 4: Innovations Changing Lives (Std 10)
        Chapter ch_ENG_10_2_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 2: Unit 4 – Science & Tomorrow", 7, "Prose 4: Innovations Changing Lives (Std 10)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 2: Unit 4 – Science & Tomorrow", "Prose 4: Innovations Changing Lives (Std 10)", ch_ENG_10_2_4_7, "Active Passive Voice & Tenses");

        // Chapter: Supplementary: Dreams into Reality (Std 10)
        Chapter ch_ENG_10_2_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 2: Unit 4 – Science & Tomorrow", 8, "Supplementary: Dreams into Reality (Std 10)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 2: Unit 4 – Science & Tomorrow", "Supplementary: Dreams into Reality (Std 10)", ch_ENG_10_2_4_8, "Plot Summary & Analysis");

        // Unit: Term 3: Unit 5 – Environment & Harmony
        Unit u_ENG_10_2_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 3: Unit 5 – Environment & Harmony", 5, "English", board, classLevel)));

        // Chapter: Prose 5: Guardians of Nature (Std 10)
        Chapter ch_ENG_10_2_5_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 3: Unit 5 – Environment & Harmony", 9, "Prose 5: Guardians of Nature (Std 10)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 3: Unit 5 – Environment & Harmony", "Prose 5: Guardians of Nature (Std 10)", ch_ENG_10_2_5_9, "Clauses & Conjunctions");

        // Chapter: Poem 3: The Green Earth (Std 10)
        Chapter ch_ENG_10_2_5_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 3: Unit 5 – Environment & Harmony", 10, "Poem 3: The Green Earth (Std 10)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 3: Unit 5 – Environment & Harmony", "Poem 3: The Green Earth (Std 10)", ch_ENG_10_2_5_10, "Poetic Appreciation");

        // Unit: Term 3: Unit 6 – Humanity & Sports
        Unit u_ENG_10_2_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Term 3: Unit 6 – Humanity & Sports", 6, "English", board, classLevel)));

        // Chapter: Prose 6: Champions of the Game (Std 10)
        Chapter ch_ENG_10_2_6_11 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 11)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 3: Unit 6 – Humanity & Sports", 11, "Prose 6: Champions of the Game (Std 10)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 3: Unit 6 – Humanity & Sports", "Prose 6: Champions of the Game (Std 10)", ch_ENG_10_2_6_11, "Formal Letter & Report Writing");

        // Chapter: Supplementary: Triumph of Will (Std 10)
        Chapter ch_ENG_10_2_6_12 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 12)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Term 3: Unit 6 – Humanity & Sports", 12, "Supplementary: Triumph of Will (Std 10)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Term 3: Unit 6 – Humanity & Sports", "Supplementary: Triumph of Will (Std 10)", ch_ENG_10_2_6_12, "Theme & Message");

        // Subject: Mathematics
        Subject sub_MATH_10_3 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Mathematics")
                .orElseGet(() -> subjectRepository.save(new Subject("Mathematics", "MATH", "📐", "#4834d4", board, classLevel)));

        // Unit: Unit 1: Relations and Functions
        Unit u_MATH_10_3_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Relations and Functions", 1, "Mathematics", board, classLevel)));

        // Chapter: Cartesian Products & Relations
        Chapter ch_MATH_10_3_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 1: Relations and Functions", 1, "Cartesian Products & Relations", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 1: Relations and Functions", "Cartesian Products & Relations", ch_MATH_10_3_1_1, "Domain, Co-domain, Range");

        // Chapter: Functions & Composition of Functions
        Chapter ch_MATH_10_3_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 1: Relations and Functions", 2, "Functions & Composition of Functions", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 1: Relations and Functions", "Functions & Composition of Functions", ch_MATH_10_3_1_2, "One-One, Onto, Bijection & f(g(x))");

        // Unit: Unit 2: Numbers and Sequences
        Unit u_MATH_10_3_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Numbers and Sequences", 2, "Mathematics", board, classLevel)));

        // Chapter: Euclid's Division Lemma & Fundamental Theorem
        Chapter ch_MATH_10_3_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 2: Numbers and Sequences", 3, "Euclid's Division Lemma & Fundamental Theorem", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 2: Numbers and Sequences", "Euclid's Division Lemma & Fundamental Theorem", ch_MATH_10_3_2_3, "HCF, LCM & Prime Factorisation");

        // Chapter: Arithmetic & Geometric Progressions (AP & GP)
        Chapter ch_MATH_10_3_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 2: Numbers and Sequences", 4, "Arithmetic & Geometric Progressions (AP & GP)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 2: Numbers and Sequences", "Arithmetic & Geometric Progressions (AP & GP)", ch_MATH_10_3_2_4, "nth Term, Sum to n Terms & Special Series");

        // Unit: Unit 3: Algebra
        Unit u_MATH_10_3_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Algebra", 3, "Mathematics", board, classLevel)));

        // Chapter: Linear System & Polynomial GCD/LCM
        Chapter ch_MATH_10_3_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 3: Algebra", 5, "Linear System & Polynomial GCD/LCM", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 3: Algebra", "Linear System & Polynomial GCD/LCM", ch_MATH_10_3_3_5, "Simultaneous 3-variable systems & Square Roots");

        // Chapter: Quadratic Equations & Matrices
        Chapter ch_MATH_10_3_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 3: Algebra", 6, "Quadratic Equations & Matrices", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 3: Algebra", "Quadratic Equations & Matrices", ch_MATH_10_3_3_6, "Roots Nature, Formula & Matrix Multiplication");

        // Unit: Unit 4: Geometry
        Unit u_MATH_10_3_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Geometry", 4, "Mathematics", board, classLevel)));

        // Chapter: Similarity Theorems & Basic Proportionality
        Chapter ch_MATH_10_3_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 4: Geometry", 7, "Similarity Theorems & Basic Proportionality", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 4: Geometry", "Similarity Theorems & Basic Proportionality", ch_MATH_10_3_4_7, "Thales Theorem, Angle Bisector & Pythagoras");

        // Chapter: Circles, Tangents & Ceva / Menelaus
        Chapter ch_MATH_10_3_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 4: Geometry", 8, "Circles, Tangents & Ceva / Menelaus", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 4: Geometry", "Circles, Tangents & Ceva / Menelaus", ch_MATH_10_3_4_8, "Tangent Chord Theorem & Geometry Proofs");

        // Unit: Unit 5: Coordinate Geometry
        Unit u_MATH_10_3_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 5: Coordinate Geometry", 5, "Mathematics", board, classLevel)));

        // Chapter: Area of Triangle & Quadrilateral
        Chapter ch_MATH_10_3_5_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 5: Coordinate Geometry", 9, "Area of Triangle & Quadrilateral", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 5: Coordinate Geometry", "Area of Triangle & Quadrilateral", ch_MATH_10_3_5_9, "Shoelace Formula & Collinearity");

        // Chapter: Slope of Straight Line & Equations of Lines
        Chapter ch_MATH_10_3_5_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 5: Coordinate Geometry", 10, "Slope of Straight Line & Equations of Lines", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 5: Coordinate Geometry", "Slope of Straight Line & Equations of Lines", ch_MATH_10_3_5_10, "y = mx + c, Point-Slope Form & Intercepts");

        // Unit: Unit 6: Trigonometry
        Unit u_MATH_10_3_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 6: Trigonometry", 6, "Mathematics", board, classLevel)));

        // Chapter: Trigonometric Identities
        Chapter ch_MATH_10_3_6_11 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 11)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 6: Trigonometry", 11, "Trigonometric Identities", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 6: Trigonometry", "Trigonometric Identities", ch_MATH_10_3_6_11, "sin^2 + cos^2 = 1 & Proofs");

        // Chapter: Heights and Distances
        Chapter ch_MATH_10_3_6_12 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 12)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 6: Trigonometry", 12, "Heights and Distances", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 6: Trigonometry", "Heights and Distances", ch_MATH_10_3_6_12, "Angle of Elevation & Angle of Depression");

        // Unit: Unit 7: Mensuration
        Unit u_MATH_10_3_7 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 7).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 7: Mensuration", 7, "Mathematics", board, classLevel)));

        // Chapter: Surface Area of Cone, Sphere, Hemisphere & Frustum
        Chapter ch_MATH_10_3_7_13 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 13)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 7: Mensuration", 13, "Surface Area of Cone, Sphere, Hemisphere & Frustum", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 7: Mensuration", "Surface Area of Cone, Sphere, Hemisphere & Frustum", ch_MATH_10_3_7_13, "TSA, CSA & Combined Solids");

        // Chapter: Volume of Solids & Conversion of Solids
        Chapter ch_MATH_10_3_7_14 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 14)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 7: Mensuration", 14, "Volume of Solids & Conversion of Solids", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 7: Mensuration", "Volume of Solids & Conversion of Solids", ch_MATH_10_3_7_14, "Volume Conservation & Frustum Volume");

        // Unit: Unit 8: Statistics and Probability
        Unit u_MATH_10_3_8 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 8).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 8: Statistics and Probability", 8, "Mathematics", board, classLevel)));

        // Chapter: Range, Variance & Standard Deviation
        Chapter ch_MATH_10_3_8_15 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 15)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 8: Statistics and Probability", 15, "Range, Variance & Standard Deviation", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 8: Statistics and Probability", "Range, Variance & Standard Deviation", ch_MATH_10_3_8_15, "Coefficient of Variation & Dispersion");

        // Chapter: Probability & Addition Theorem of Probability
        Chapter ch_MATH_10_3_8_16 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 16)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 8: Statistics and Probability", 16, "Probability & Addition Theorem of Probability", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 8: Statistics and Probability", "Probability & Addition Theorem of Probability", ch_MATH_10_3_8_16, "P(A U B) = P(A) + P(B) - P(A n B)");

        // Subject: Science
        Subject sub_SCI_10_4 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Science")
                .orElseGet(() -> subjectRepository.save(new Subject("Science", "SCI", "🔬", "#eb4d4b", board, classLevel)));

        // Unit: Unit 1: Physics – Laws of Motion & Gravitation
        Unit u_SCI_10_4_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Physics – Laws of Motion & Gravitation", 1, "Science", board, classLevel)));

        // Chapter: Laws of Motion & Inertia
        Chapter ch_SCI_10_4_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 1: Physics – Laws of Motion & Gravitation", 1, "Laws of Motion & Inertia", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 1: Physics – Laws of Motion & Gravitation", "Laws of Motion & Inertia", ch_SCI_10_4_1_1, "Newton's 1st, 2nd, 3rd Laws, Momentum & F=ma");

        // Chapter: Universal Gravitation & Weightlessness
        Chapter ch_SCI_10_4_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 1: Physics – Laws of Motion & Gravitation", 2, "Universal Gravitation & Weightlessness", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 1: Physics – Laws of Motion & Gravitation", "Universal Gravitation & Weightlessness", ch_SCI_10_4_1_2, "G Constant, Free Fall & Mass vs Weight");

        // Unit: Unit 2: Physics – Optics, Thermal & Sound
        Unit u_SCI_10_4_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Physics – Optics, Thermal & Sound", 2, "Science", board, classLevel)));

        // Chapter: Optics – Refraction, Lenses & Human Eye
        Chapter ch_SCI_10_4_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 2: Physics – Optics, Thermal & Sound", 3, "Optics – Refraction, Lenses & Human Eye", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 2: Physics – Optics, Thermal & Sound", "Optics – Refraction, Lenses & Human Eye", ch_SCI_10_4_2_3, "Snell's Law, Lens Formula, Dispersion & Eye defects");

        // Chapter: Thermal Physics – Gas Laws & Expansion
        Chapter ch_SCI_10_4_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 2: Physics – Optics, Thermal & Sound", 4, "Thermal Physics – Gas Laws & Expansion", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 2: Physics – Optics, Thermal & Sound", "Thermal Physics – Gas Laws & Expansion", ch_SCI_10_4_2_4, "Boyle's Law, Charles's Law & Ideal Gas PV=nRT");

        // Chapter: Acoustics – Velocity of Sound & Doppler Effect
        Chapter ch_SCI_10_4_2_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 2: Physics – Optics, Thermal & Sound", 5, "Acoustics – Velocity of Sound & Doppler Effect", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 2: Physics – Optics, Thermal & Sound", "Acoustics – Velocity of Sound & Doppler Effect", ch_SCI_10_4_2_5, "Laplace Correction & Frequency Shift");

        // Unit: Unit 3: Physics – Electricity & Nuclear Physics
        Unit u_SCI_10_4_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Physics – Electricity & Nuclear Physics", 3, "Science", board, classLevel)));

        // Chapter: Electricity – Ohm's Law & Joule's Heating
        Chapter ch_SCI_10_4_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 3: Physics – Electricity & Nuclear Physics", 6, "Electricity – Ohm's Law & Joule's Heating", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 3: Physics – Electricity & Nuclear Physics", "Electricity – Ohm's Law & Joule's Heating", ch_SCI_10_4_3_6, "V=IR, Resistivity, Electric Power & Fuse Wire");

        // Chapter: Nuclear Physics – Radioactivity & Nuclear Energy
        Chapter ch_SCI_10_4_3_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 3: Physics – Electricity & Nuclear Physics", 7, "Nuclear Physics – Radioactivity & Nuclear Energy", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 3: Physics – Electricity & Nuclear Physics", "Nuclear Physics – Radioactivity & Nuclear Energy", ch_SCI_10_4_3_7, "Alpha, Beta, Gamma rays, Fission & Fusion");

        // Unit: Unit 4: Chemistry – Atoms, Molecules & Periodic Table
        Unit u_SCI_10_4_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Chemistry – Atoms, Molecules & Periodic Table", 4, "Science", board, classLevel)));

        // Chapter: Atoms and Molecules – Mole Concept
        Chapter ch_SCI_10_4_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 4: Chemistry – Atoms, Molecules & Periodic Table", 8, "Atoms and Molecules – Mole Concept", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 4: Chemistry – Atoms, Molecules & Periodic Table", "Atoms and Molecules – Mole Concept", ch_SCI_10_4_4_8, "Avogadro's Number 6.023x10^23, Molar Mass");

        // Chapter: Periodic Classification of Elements
        Chapter ch_SCI_10_4_4_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 4: Chemistry – Atoms, Molecules & Periodic Table", 9, "Periodic Classification of Elements", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 4: Chemistry – Atoms, Molecules & Periodic Table", "Periodic Classification of Elements", ch_SCI_10_4_4_9, "Modern Periodic Law, Groups & Periods Trends");

        // Unit: Unit 5: Chemistry – Solutions & Chemical Reactions
        Unit u_SCI_10_4_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 5: Chemistry – Solutions & Chemical Reactions", 5, "Science", board, classLevel)));

        // Chapter: Solutions – Solubility & Concentration
        Chapter ch_SCI_10_4_5_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 5: Chemistry – Solutions & Chemical Reactions", 10, "Solutions – Solubility & Concentration", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 5: Chemistry – Solutions & Chemical Reactions", "Solutions – Solubility & Concentration", ch_SCI_10_4_5_10, "Solute, Solvent, Saturated & Mass Percentage");

        // Chapter: Types of Chemical Reactions – Equilibrium & pH
        Chapter ch_SCI_10_4_5_11 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 11)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 5: Chemistry – Solutions & Chemical Reactions", 11, "Types of Chemical Reactions – Equilibrium & pH", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 5: Chemistry – Solutions & Chemical Reactions", "Types of Chemical Reactions – Equilibrium & pH", ch_SCI_10_4_5_11, "Combination, Decomposition, Redox, pH Calculations");

        // Chapter: Carbon and its Compounds – IUPAC Nomenclature
        Chapter ch_SCI_10_4_5_12 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 12)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 5: Chemistry – Solutions & Chemical Reactions", 12, "Carbon and its Compounds – IUPAC Nomenclature", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 5: Chemistry – Solutions & Chemical Reactions", "Carbon and its Compounds – IUPAC Nomenclature", ch_SCI_10_4_5_12, "Functional Groups, Homologous Series & Ethanol");

        // Unit: Unit 6: Biology – Plant Anatomy & Animal Physiology
        Unit u_SCI_10_4_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 6: Biology – Plant Anatomy & Animal Physiology", 6, "Science", board, classLevel)));

        // Chapter: Plant Anatomy and Plant Physiology
        Chapter ch_SCI_10_4_6_13 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 13)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 6: Biology – Plant Anatomy & Animal Physiology", 13, "Plant Anatomy and Plant Physiology", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 6: Biology – Plant Anatomy & Animal Physiology", "Plant Anatomy and Plant Physiology", ch_SCI_10_4_6_13, "Root/Stem Anatomy, Chloroplast, Light/Dark Reactions");

        // Chapter: Structural Organisation of Animals – Leech & Rabbit
        Chapter ch_SCI_10_4_6_14 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 14)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 6: Biology – Plant Anatomy & Animal Physiology", 14, "Structural Organisation of Animals – Leech & Rabbit", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 6: Biology – Plant Anatomy & Animal Physiology", "Structural Organisation of Animals – Leech & Rabbit", ch_SCI_10_4_6_14, "Digestive, Circulatory & Reproductive Anatomy");

        // Chapter: Transportation in Plants & Circulation in Animals
        Chapter ch_SCI_10_4_6_15 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 15)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 6: Biology – Plant Anatomy & Animal Physiology", 15, "Transportation in Plants & Circulation in Animals", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 6: Biology – Plant Anatomy & Animal Physiology", "Transportation in Plants & Circulation in Animals", ch_SCI_10_4_6_15, "Ascent of Sap, Blood Components, Heart & Cardiac Cycle");

        // Unit: Unit 7: Biology – Nervous System, Hormones & Genetics
        Unit u_SCI_10_4_7 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 7).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 7: Biology – Nervous System, Hormones & Genetics", 7, "Science", board, classLevel)));

        // Chapter: Nervous System & Brain Function
        Chapter ch_SCI_10_4_7_16 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 16)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 7: Biology – Nervous System, Hormones & Genetics", 16, "Nervous System & Brain Function", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 7: Biology – Nervous System, Hormones & Genetics", "Nervous System & Brain Function", ch_SCI_10_4_7_16, "Neuron, Synapse, CNS, PNS & Reflex Action");

        // Chapter: Plant and Animal Hormones – Endocrine System
        Chapter ch_SCI_10_4_7_17 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 17)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 7: Biology – Nervous System, Hormones & Genetics", 17, "Plant and Animal Hormones – Endocrine System", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 7: Biology – Nervous System, Hormones & Genetics", "Plant and Animal Hormones – Endocrine System", ch_SCI_10_4_7_17, "Auxins, Gibberellins, Thyroid, Insulin & Adrenaline");

        // Chapter: Reproduction in Plants and Animals
        Chapter ch_SCI_10_4_7_18 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 18)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 7: Biology – Nervous System, Hormones & Genetics", 18, "Reproduction in Plants and Animals", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 7: Biology – Nervous System, Hormones & Genetics", "Reproduction in Plants and Animals", ch_SCI_10_4_7_18, "Pollination, Fertilisation, Human Reproduction & Hygiene");

        // Chapter: Heredity & Mendel's Laws
        Chapter ch_SCI_10_4_7_19 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 19)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 7: Biology – Nervous System, Hormones & Genetics", 19, "Heredity & Mendel's Laws", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 7: Biology – Nervous System, Hormones & Genetics", "Heredity & Mendel's Laws", ch_SCI_10_4_7_19, "Monohybrid / Dihybrid Cross, DNA Structure & Chromosomes");

        // Unit: Unit 8: Biology – Evolution, Biotechnology & Ecology
        Unit u_SCI_10_4_8 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 8).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 8: Biology – Evolution, Biotechnology & Ecology", 8, "Science", board, classLevel)));

        // Chapter: Origin and Evolution of Life
        Chapter ch_SCI_10_4_8_20 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 20)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 8: Biology – Evolution, Biotechnology & Ecology", 20, "Origin and Evolution of Life", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 8: Biology – Evolution, Biotechnology & Ecology", "Origin and Evolution of Life", ch_SCI_10_4_8_20, "Lamarckism, Darwinism & Speciation");

        // Chapter: Breeding and Biotechnology – Gene Therapy
        Chapter ch_SCI_10_4_8_21 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 21)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 8: Biology – Evolution, Biotechnology & Ecology", 21, "Breeding and Biotechnology – Gene Therapy", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 8: Biology – Evolution, Biotechnology & Ecology", "Breeding and Biotechnology – Gene Therapy", ch_SCI_10_4_8_21, "Hybridisation, Mutation Breeding & Recombinant DNA");

        // Chapter: Health and Diseases – Lifestyle & Infectious
        Chapter ch_SCI_10_4_8_22 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 22)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 8: Biology – Evolution, Biotechnology & Ecology", 22, "Health and Diseases – Lifestyle & Infectious", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 8: Biology – Evolution, Biotechnology & Ecology", "Health and Diseases – Lifestyle & Infectious", ch_SCI_10_4_8_22, "Diabetes, Cancer, AIDS & Immunisation");

        // Chapter: Environmental Management – Conservation & Energy
        Chapter ch_SCI_10_4_8_23 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Science", 23)
                .orElseGet(() -> chapterRepository.save(new Chapter("Science", "Unit 8: Biology – Evolution, Biotechnology & Ecology", 23, "Environmental Management – Conservation & Energy", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Science", "Unit 8: Biology – Evolution, Biotechnology & Ecology", "Environmental Management – Conservation & Energy", ch_SCI_10_4_8_23, "Renewable Energy, Rainwater Harvesting & Wildlife");

        // Subject: Social Science
        Subject sub_SOC_10_5 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Social Science")
                .orElseGet(() -> subjectRepository.save(new Subject("Social Science", "SOC", "🌍", "#10ac84", board, classLevel)));

        // Unit: Unit 1: History – Imperialism & World Wars
        Unit u_SOC_10_5_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: History – Imperialism & World Wars", 1, "Social Science", board, classLevel)));

        // Chapter: Outbreak of World War I and its Aftermath
        Chapter ch_SOC_10_5_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 1: History – Imperialism & World Wars", 1, "Outbreak of World War I and its Aftermath", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 1: History – Imperialism & World Wars", "Outbreak of World War I and its Aftermath", ch_SOC_10_5_1_1, "Causes, Battle of Marne, Treaty of Versailles 1919");

        // Chapter: World between Two World Wars – Great Depression & Fascism
        Chapter ch_SOC_10_5_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 1: History – Imperialism & World Wars", 2, "World between Two World Wars – Great Depression & Fascism", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 1: History – Imperialism & World Wars", "World between Two World Wars – Great Depression & Fascism", ch_SOC_10_5_1_2, "Wall Street Crash 1929, Mussolini & Hitler");

        // Chapter: World War II and Holocaust
        Chapter ch_SOC_10_5_1_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 1: History – Imperialism & World Wars", 3, "World War II and Holocaust", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 1: History – Imperialism & World Wars", "World War II and Holocaust", ch_SOC_10_5_1_3, "Axis vs Allies, Pearl Harbor, Hiroshima & UN Formation");

        // Unit: Unit 2: History – Reform Movements & Freedom Struggle
        Unit u_SOC_10_5_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: History – Reform Movements & Freedom Struggle", 2, "Social Science", board, classLevel)));

        // Chapter: Social and Religious Reform Movements in the 19th Century
        Chapter ch_SOC_10_5_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 2: History – Reform Movements & Freedom Struggle", 4, "Social and Religious Reform Movements in the 19th Century", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 2: History – Reform Movements & Freedom Struggle", "Social and Religious Reform Movements in the 19th Century", ch_SOC_10_5_2_4, "Brahmo Samaj, Arya Samaj, Ramakrishna Mission, Theosophical");

        // Chapter: Early Revolts against British Rule in Tamil Nadu
        Chapter ch_SOC_10_5_2_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 2: History – Reform Movements & Freedom Struggle", 5, "Early Revolts against British Rule in Tamil Nadu", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 2: History – Reform Movements & Freedom Struggle", "Early Revolts against British Rule in Tamil Nadu", ch_SOC_10_5_2_5, "Palayakkarars, Veerapandiya Kattabomman, Vellore Revolt 1806");

        // Chapter: Anti-Colonial Movements & Nationalism: Gandhian Phase
        Chapter ch_SOC_10_5_2_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 2: History – Reform Movements & Freedom Struggle", 6, "Anti-Colonial Movements & Nationalism: Gandhian Phase", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 2: History – Reform Movements & Freedom Struggle", "Anti-Colonial Movements & Nationalism: Gandhian Phase", ch_SOC_10_5_2_6, "Non-Cooperation, Civil Disobedience, Quit India 1942");

        // Chapter: Freedom Struggle & Social Transformation in Tamil Nadu
        Chapter ch_SOC_10_5_2_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 2: History – Reform Movements & Freedom Struggle", 7, "Freedom Struggle & Social Transformation in Tamil Nadu", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 2: History – Reform Movements & Freedom Struggle", "Freedom Struggle & Social Transformation in Tamil Nadu", ch_SOC_10_5_2_7, "V.O.C., Subramania Bharati, Rajaji, Periyar Self-Respect Movement");

        // Unit: Unit 3: Geography – Physical Geography of India
        Unit u_SOC_10_5_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Geography – Physical Geography of India", 3, "Social Science", board, classLevel)));

        // Chapter: India – Location, Relief and Drainage
        Chapter ch_SOC_10_5_3_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 3: Geography – Physical Geography of India", 8, "India – Location, Relief and Drainage", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 3: Geography – Physical Geography of India", "India – Location, Relief and Drainage", ch_SOC_10_5_3_8, "Himalayas, Northern Plains, Peninsular Plateau & River Systems");

        // Chapter: Climate and Natural Vegetation of India
        Chapter ch_SOC_10_5_3_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 3: Geography – Physical Geography of India", 9, "Climate and Natural Vegetation of India", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 3: Geography – Physical Geography of India", "Climate and Natural Vegetation of India", ch_SOC_10_5_3_9, "Southwest/Northeast Monsoons & Forest Types");

        // Unit: Unit 4: Geography – Agriculture, Resources & TN Geography
        Unit u_SOC_10_5_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Geography – Agriculture, Resources & TN Geography", 4, "Social Science", board, classLevel)));

        // Chapter: India – Agriculture & Irrigation
        Chapter ch_SOC_10_5_4_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 4: Geography – Agriculture, Resources & TN Geography", 10, "India – Agriculture & Irrigation", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 4: Geography – Agriculture, Resources & TN Geography", "India – Agriculture & Irrigation", ch_SOC_10_5_4_10, "Food Crops, Cash Crops, Green Revolution & Dam Projects");

        // Chapter: India – Resources, Industries, Transport & Trade
        Chapter ch_SOC_10_5_4_11 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 11)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 4: Geography – Agriculture, Resources & TN Geography", 11, "India – Resources, Industries, Transport & Trade", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 4: Geography – Agriculture, Resources & TN Geography", "India – Resources, Industries, Transport & Trade", ch_SOC_10_5_4_11, "Iron, Coal, Petroleum, Cotton Textiles, Railways & Ports");

        // Chapter: Physical & Human Geography of Tamil Nadu
        Chapter ch_SOC_10_5_4_12 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 12)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 4: Geography – Agriculture, Resources & TN Geography", 12, "Physical & Human Geography of Tamil Nadu", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 4: Geography – Agriculture, Resources & TN Geography", "Physical & Human Geography of Tamil Nadu", ch_SOC_10_5_4_12, "Western/Eastern Ghats, Soil, Industries & Smart Cities");

        // Unit: Unit 5: Civics – Indian Constitution & Governance
        Unit u_SOC_10_5_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 5: Civics – Indian Constitution & Governance", 5, "Social Science", board, classLevel)));

        // Chapter: Indian Constitution – Features, Preamble & Rights
        Chapter ch_SOC_10_5_5_13 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 13)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 5: Civics – Indian Constitution & Governance", 13, "Indian Constitution – Features, Preamble & Rights", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 5: Civics – Indian Constitution & Governance", "Indian Constitution – Features, Preamble & Rights", ch_SOC_10_5_5_13, "Fundamental Rights, DPSP, Fundamental Duties & Amendments");

        // Chapter: Central Government – President, Prime Minister & Parliament
        Chapter ch_SOC_10_5_5_14 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 14)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 5: Civics – Indian Constitution & Governance", 14, "Central Government – President, Prime Minister & Parliament", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 5: Civics – Indian Constitution & Governance", "Central Government – President, Prime Minister & Parliament", ch_SOC_10_5_5_14, "Lok Sabha, Rajya Sabha & Supreme Court of India");

        // Chapter: State Government – Governor, CM & High Court
        Chapter ch_SOC_10_5_5_15 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 15)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 5: Civics – Indian Constitution & Governance", 15, "State Government – Governor, CM & High Court", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 5: Civics – Indian Constitution & Governance", "State Government – Governor, CM & High Court", ch_SOC_10_5_5_15, "State Executive, Legislature & Judiciary");

        // Chapter: India's Foreign Policy and International Relations
        Chapter ch_SOC_10_5_5_16 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 16)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 5: Civics – Indian Constitution & Governance", 16, "India's Foreign Policy and International Relations", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 5: Civics – Indian Constitution & Governance", "India's Foreign Policy and International Relations", ch_SOC_10_5_5_16, "Panchsheel, Non-Alignment, SAARC & BRICS");

        // Unit: Unit 6: Economics – GDP, Globalisation & Taxes
        Unit u_SOC_10_5_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Social Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 6: Economics – GDP, Globalisation & Taxes", 6, "Social Science", board, classLevel)));

        // Chapter: Gross Domestic Product and its Growth – Sectors of Economy
        Chapter ch_SOC_10_5_6_17 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 17)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 6: Economics – GDP, Globalisation & Taxes", 17, "Gross Domestic Product and its Growth – Sectors of Economy", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 6: Economics – GDP, Globalisation & Taxes", "Gross Domestic Product and its Growth – Sectors of Economy", ch_SOC_10_5_6_17, "Primary, Secondary, Tertiary & National Income Methods");

        // Chapter: Globalisation and Trade – WTO & MNCs
        Chapter ch_SOC_10_5_6_18 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 18)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 6: Economics – GDP, Globalisation & Taxes", 18, "Globalisation and Trade – WTO & MNCs", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 6: Economics – GDP, Globalisation & Taxes", "Globalisation and Trade – WTO & MNCs", ch_SOC_10_5_6_18, "Foreign Trade Policy, Liberalisation & SEZs");

        // Chapter: Food Security, Nutrition, Government and Taxes
        Chapter ch_SOC_10_5_6_19 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Social Science", 19)
                .orElseGet(() -> chapterRepository.save(new Chapter("Social Science", "Unit 6: Economics – GDP, Globalisation & Taxes", 19, "Food Security, Nutrition, Government and Taxes", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Social Science", "Unit 6: Economics – GDP, Globalisation & Taxes", "Food Security, Nutrition, Government and Taxes", ch_SOC_10_5_6_19, "PDS System, Direct/Indirect Taxes, GST & Industrial Clusters");

    }

    private void seed_STATE_BOARD_Class_11() {
        String board = "STATE_BOARD";
        int classLevel = 11;

        // Subject: Tamil
        Subject sub_TAM_11_1 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Tamil")
                .orElseGet(() -> subjectRepository.save(new Subject("Tamil", "TAM", "📖", "#e84118", board, classLevel)));

        // Unit: இயல் 1: மொழி – யுகத்தின் பாடல்
        Unit u_TAM_11_1_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 1: மொழி – யுகத்தின் பாடல்", 1, "Tamil", board, classLevel)));

        // Chapter: யுகத்தின் பாடல்
        Chapter ch_TAM_11_1_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 1: மொழி – யுகத்தின் பாடல்", 1, "யுகத்தின் பாடல்", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 1: மொழி – யுகத்தின் பாடல்", "யுகத்தின் பாடல்", ch_TAM_11_1_1_1, "சு. வில்வரத்தினம்");

        // Chapter: பேச்சுமொழியும் கவிதைமொழியும்
        Chapter ch_TAM_11_1_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 1: மொழி – யுகத்தின் பாடல்", 2, "பேச்சுமொழியும் கவிதைமொழியும்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 1: மொழி – யுகத்தின் பாடல்", "பேச்சுமொழியும் கவிதைமொழியும்", ch_TAM_11_1_1_2, "இந்திரன் நவீன மொழியியல்");

        // Unit: இயல் 2: இயற்கை வேளாண்மை
        Unit u_TAM_11_1_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 2: இயற்கை வேளாண்மை", 2, "Tamil", board, classLevel)));

        // Chapter: ஏங்குது பார் உலகம்
        Chapter ch_TAM_11_1_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 2: இயற்கை வேளாண்மை", 3, "ஏங்குது பார் உலகம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 2: இயற்கை வேளாண்மை", "ஏங்குது பார் உலகம்", ch_TAM_11_1_2_3, "நம்மாழ்வார் இயற்கை உழவு");

        // Chapter: ஐங்குறுநூறு
        Chapter ch_TAM_11_1_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 2: இயற்கை வேளாண்மை", 4, "ஐங்குறுநூறு", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 2: இயற்கை வேளாண்மை", "ஐங்குறுநூறு", ch_TAM_11_1_2_4, "பேயனார் முல்லை நிலம்");

        // Unit: இயல் 3: பண்பாடு – காவடிச்சிந்து
        Unit u_TAM_11_1_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 3: பண்பாடு – காவடிச்சிந்து", 3, "Tamil", board, classLevel)));

        // Chapter: காவடிச்சிந்து
        Chapter ch_TAM_11_1_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 3: பண்பாடு – காவடிச்சிந்து", 5, "காவடிச்சிந்து", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 3: பண்பாடு – காவடிச்சிந்து", "காவடிச்சிந்து", ch_TAM_11_1_3_5, "அண்ணாமலையார் வழிநடைச் சிந்து");

        // Chapter: குறுந்தொகை
        Chapter ch_TAM_11_1_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 3: பண்பாடு – காவடிச்சிந்து", 6, "குறுந்தொகை", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 3: பண்பாடு – காவடிச்சிந்து", "குறுந்தொகை", ch_TAM_11_1_3_6, "வெள்ளிவீதியார்");

        // Unit: இயல் 4: கல்வி – பிள்ளைக் கூடம்
        Unit u_TAM_11_1_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 4: கல்வி – பிள்ளைக் கூடம்", 4, "Tamil", board, classLevel)));

        // Chapter: பிள்ளைக் கூடம்
        Chapter ch_TAM_11_1_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 4: கல்வி – பிள்ளைக் கூடம்", 7, "பிள்ளைக் கூடம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 4: கல்வி – பிள்ளைக் கூடம்", "பிள்ளைக் கூடம்", ch_TAM_11_1_4_7, "கல்யாண்ஜி குழந்தைமை புதுக்கவிதை");

        // Chapter: இதழாளர் பாரதி
        Chapter ch_TAM_11_1_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 4: கல்வி – பிள்ளைக் கூடம்", 8, "இதழாளர் பாரதி", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 4: கல்வி – பிள்ளைக் கூடம்", "இதழாளர் பாரதி", ch_TAM_11_1_4_8, "பாரதியார் இதழியல் பணி");

        // Unit: இயல் 5: நாகரிகம் – சீறாப்புராணம்
        Unit u_TAM_11_1_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 5: நாகரிகம் – சீறாப்புராணம்", 5, "Tamil", board, classLevel)));

        // Chapter: சீறாப்புராணம்
        Chapter ch_TAM_11_1_5_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 5: நாகரிகம் – சீறாப்புராணம்", 9, "சீறாப்புராணம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 5: நாகரிகம் – சீறாப்புராணம்", "சீறாப்புராணம்", ch_TAM_11_1_5_9, "உமறுப்புலவர் நபிகள் நாயகம்");

        // Chapter: அகநானூறு
        Chapter ch_TAM_11_1_5_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 5: நாகரிகம் – சீறாப்புராணம்", 10, "அகநானூறு", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 5: நாகரிகம் – சீறாப்புராணம்", "அகநானூறு", ch_TAM_11_1_5_10, "வீரை வெளியன் பாலை நிலம்");

        // Unit: இயல் 6: கலை – குற்றாலக் குறவஞ்சி
        Unit u_TAM_11_1_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 6: கலை – குற்றாலக் குறவஞ்சி", 6, "Tamil", board, classLevel)));

        // Chapter: குற்றாலக் குறவஞ்சி
        Chapter ch_TAM_11_1_6_11 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 11)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 6: கலை – குற்றாலக் குறவஞ்சி", 11, "குற்றாலக் குறவஞ்சி", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 6: கலை – குற்றாலக் குறவஞ்சி", "குற்றாலக் குறவஞ்சி", ch_TAM_11_1_6_11, "திரிகூடராசப்ப கவிராயர்");

        // Chapter: திருச்சாலல்
        Chapter ch_TAM_11_1_6_12 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 12)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 6: கலை – குற்றாலக் குறவஞ்சி", 12, "திருச்சாலல்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 6: கலை – குற்றாலக் குறவஞ்சி", "திருச்சாலல்", ch_TAM_11_1_6_12, "மாணிக்கவாசகர் திருவாசகம்");

        // Unit: இயல் 7: அறம் – புரட்சிக்கவி
        Unit u_TAM_11_1_7 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 7).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 7: அறம் – புரட்சிக்கவி", 7, "Tamil", board, classLevel)));

        // Chapter: புரட்சிக்கவி
        Chapter ch_TAM_11_1_7_13 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 13)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 7: அறம் – புரட்சிக்கவி", 13, "புரட்சிக்கவி", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 7: அறம் – புரட்சிக்கவி", "புரட்சிக்கவி", ch_TAM_11_1_7_13, "பாரதிதாசன் புரட்சிக் காவியம்");

        // Chapter: சிங்காரவேலர்
        Chapter ch_TAM_11_1_7_14 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 14)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 7: அறம் – புரட்சிக்கவி", 14, "சிங்காரவேலர்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 7: அறம் – புரட்சிக்கவி", "சிங்காரவேலர்", ch_TAM_11_1_7_14, "ம. சிங்காரவேலர் தொழிலாளர் மேன்மை");

        // Unit: இயல் 8: மனிதம் – மனோன்மணீயம்
        Unit u_TAM_11_1_8 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 8).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 8: மனிதம் – மனோன்மணீயம்", 8, "Tamil", board, classLevel)));

        // Chapter: மனோன்மணீயம்
        Chapter ch_TAM_11_1_8_15 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 15)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 8: மனிதம் – மனோன்மணீயம்", 15, "மனோன்மணீயம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 8: மனிதம் – மனோன்மணீயம்", "மனோன்மணீயம்", ch_TAM_11_1_8_15, "பேராசிரியர் சுந்தரனார்");

        // Chapter: தாகூர் சிறுகதைகள் – காபூலிவாலா
        Chapter ch_TAM_11_1_8_16 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 16)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 8: மனிதம் – மனோன்மணீயம்", 16, "தாகூர் சிறுகதைகள் – காபூலிவாலா", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 8: மனிதம் – மனோன்மணீயம்", "தாகூர் சிறுகதைகள் – காபூலிவாலா", ch_TAM_11_1_8_16, "ரவீந்திரநாத் தாகூர்");

        // Subject: English
        Subject sub_ENG_11_2 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "English")
                .orElseGet(() -> subjectRepository.save(new Subject("English", "ENG", "📚", "#fa8231", board, classLevel)));

        // Unit: Unit 1: Prose & Poetry Collection
        Unit u_ENG_11_2_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Prose & Poetry Collection", 1, "English", board, classLevel)));

        // Chapter: Prose Study (Class 11)
        Chapter ch_ENG_11_2_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 1: Prose & Poetry Collection", 1, "Prose Study (Class 11)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 1: Prose & Poetry Collection", "Prose Study (Class 11)", ch_ENG_11_2_1_1, "Advanced Vocabulary & Comprehension");

        // Chapter: Poetry Analysis (Class 11)
        Chapter ch_ENG_11_2_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 1: Prose & Poetry Collection", 2, "Poetry Analysis (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 1: Prose & Poetry Collection", "Poetry Analysis (Class 11)", ch_ENG_11_2_1_2, "Tone, Alliteration & Poetic Devices");

        // Unit: Unit 2: Short Stories & Supplementary Reader
        Unit u_ENG_11_2_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Short Stories & Supplementary Reader", 2, "English", board, classLevel)));

        // Chapter: Supplementary Fiction (Class 11)
        Chapter ch_ENG_11_2_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 2: Short Stories & Supplementary Reader", 3, "Supplementary Fiction (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 2: Short Stories & Supplementary Reader", "Supplementary Fiction (Class 11)", ch_ENG_11_2_2_3, "Plot Structure & Conflict");

        // Chapter: Drama & Dialogue (Class 11)
        Chapter ch_ENG_11_2_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 2: Short Stories & Supplementary Reader", 4, "Drama & Dialogue (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 2: Short Stories & Supplementary Reader", "Drama & Dialogue (Class 11)", ch_ENG_11_2_2_4, "Dramatic Irony & Staging");

        // Unit: Unit 3: Professional Communication & Writing Skills
        Unit u_ENG_11_2_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Professional Communication & Writing Skills", 3, "English", board, classLevel)));

        // Chapter: Formal Essays & Letter to Editor (Class 11)
        Chapter ch_ENG_11_2_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 3: Professional Communication & Writing Skills", 5, "Formal Essays & Letter to Editor (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 3: Professional Communication & Writing Skills", "Formal Essays & Letter to Editor (Class 11)", ch_ENG_11_2_3_5, "Cohesion, Modifiers & Argumentation");

        // Chapter: Report Writing & Summary Making (Class 11)
        Chapter ch_ENG_11_2_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 3: Professional Communication & Writing Skills", 6, "Report Writing & Summary Making (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 3: Professional Communication & Writing Skills", "Report Writing & Summary Making (Class 11)", ch_ENG_11_2_3_6, "Precision, Note-Making & Formatting");

        // Subject: Physics
        Subject sub_PHY_11_3 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Physics")
                .orElseGet(() -> subjectRepository.save(new Subject("Physics", "PHY", "⚡", "#3867d6", board, classLevel)));

        // Unit: Unit 1: Nature of Physical World and Measurement
        Unit u_PHY_11_3_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Physics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Nature of Physical World and Measurement", 1, "Physics", board, classLevel)));

        // Chapter: Physical World, Units and Dimensions
        Chapter ch_PHY_11_3_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Physics", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Physics", "Unit 1: Nature of Physical World and Measurement", 1, "Physical World, Units and Dimensions", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Physics", "Unit 1: Nature of Physical World and Measurement", "Physical World, Units and Dimensions", ch_PHY_11_3_1_1, "Dimensional Analysis, Errors & Significant Figures");

        // Unit: Unit 2: Kinematics
        Unit u_PHY_11_3_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Physics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Kinematics", 2, "Physics", board, classLevel)));

        // Chapter: Vectors, Projectile Motion & Uniform Motion
        Chapter ch_PHY_11_3_2_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Physics", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Physics", "Unit 2: Kinematics", 2, "Vectors, Projectile Motion & Uniform Motion", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Physics", "Unit 2: Kinematics", "Vectors, Projectile Motion & Uniform Motion", ch_PHY_11_3_2_2, "Equations of Motion & Relative Velocity");

        // Unit: Unit 3: Laws of Motion
        Unit u_PHY_11_3_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Physics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Laws of Motion", 3, "Physics", board, classLevel)));

        // Chapter: Newton's Laws, Friction & Circular Motion
        Chapter ch_PHY_11_3_3_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Physics", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Physics", "Unit 3: Laws of Motion", 3, "Newton's Laws, Friction & Circular Motion", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Physics", "Unit 3: Laws of Motion", "Newton's Laws, Friction & Circular Motion", ch_PHY_11_3_3_3, "Frictional Forces, Banking of Curves & Centripetal Acceleration");

        // Unit: Unit 4: Work, Energy and Power
        Unit u_PHY_11_3_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Physics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Work, Energy and Power", 4, "Physics", board, classLevel)));

        // Chapter: Work-Energy Theorem & Collisions
        Chapter ch_PHY_11_3_4_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Physics", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Physics", "Unit 4: Work, Energy and Power", 4, "Work-Energy Theorem & Collisions", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Physics", "Unit 4: Work, Energy and Power", "Work-Energy Theorem & Collisions", ch_PHY_11_3_4_4, "Conservative Forces, Elastic/Inelastic Collisions");

        // Unit: Unit 5: Motion of System of Particles & Rigid Bodies
        Unit u_PHY_11_3_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Physics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 5: Motion of System of Particles & Rigid Bodies", 5, "Physics", board, classLevel)));

        // Chapter: Centre of Mass, Torque & Moment of Inertia
        Chapter ch_PHY_11_3_5_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Physics", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Physics", "Unit 5: Motion of System of Particles & Rigid Bodies", 5, "Centre of Mass, Torque & Moment of Inertia", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Physics", "Unit 5: Motion of System of Particles & Rigid Bodies", "Centre of Mass, Torque & Moment of Inertia", ch_PHY_11_3_5_5, "Parallel & Perpendicular Axis Theorems");

        // Unit: Unit 6: Gravitation
        Unit u_PHY_11_3_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Physics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 6: Gravitation", 6, "Physics", board, classLevel)));

        // Chapter: Kepler's Laws, Gravitational Potential & Escape Velocity
        Chapter ch_PHY_11_3_6_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Physics", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Physics", "Unit 6: Gravitation", 6, "Kepler's Laws, Gravitational Potential & Escape Velocity", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Physics", "Unit 6: Gravitation", "Kepler's Laws, Gravitational Potential & Escape Velocity", ch_PHY_11_3_6_6, "Orbital Velocity & Geo-stationary Satellites");

        // Unit: Unit 7: Properties of Matter
        Unit u_PHY_11_3_7 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Physics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 7).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 7: Properties of Matter", 7, "Physics", board, classLevel)));

        // Chapter: Elasticity, Viscosity, Surface Tension & Fluids
        Chapter ch_PHY_11_3_7_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Physics", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Physics", "Unit 7: Properties of Matter", 7, "Elasticity, Viscosity, Surface Tension & Fluids", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Physics", "Unit 7: Properties of Matter", "Elasticity, Viscosity, Surface Tension & Fluids", ch_PHY_11_3_7_7, "Hooke's Law, Stokes' Law & Bernoulli's Theorem");

        // Unit: Unit 8: Heat and Thermodynamics
        Unit u_PHY_11_3_8 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Physics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 8).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 8: Heat and Thermodynamics", 8, "Physics", board, classLevel)));

        // Chapter: Thermodynamic Laws, Heat Engines & Carnot Cycle
        Chapter ch_PHY_11_3_8_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Physics", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Physics", "Unit 8: Heat and Thermodynamics", 8, "Thermodynamic Laws, Heat Engines & Carnot Cycle", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Physics", "Unit 8: Heat and Thermodynamics", "Thermodynamic Laws, Heat Engines & Carnot Cycle", ch_PHY_11_3_8_8, "First & Second Laws of Thermodynamics, Efficiency");

        // Unit: Unit 9: Kinetic Theory of Gases
        Unit u_PHY_11_3_9 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Physics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 9).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 9: Kinetic Theory of Gases", 9, "Physics", board, classLevel)));

        // Chapter: Ideal Gas Law, Degrees of Freedom & Equipartition
        Chapter ch_PHY_11_3_9_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Physics", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Physics", "Unit 9: Kinetic Theory of Gases", 9, "Ideal Gas Law, Degrees of Freedom & Equipartition", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Physics", "Unit 9: Kinetic Theory of Gases", "Ideal Gas Law, Degrees of Freedom & Equipartition", ch_PHY_11_3_9_9, "RMS Velocity & Specific Heat of Gases");

        // Unit: Unit 10: Oscillations & Waves
        Unit u_PHY_11_3_10 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Physics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 10).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 10: Oscillations & Waves", 10, "Physics", board, classLevel)));

        // Chapter: Simple Harmonic Motion, Pendulum & Wave Propagation
        Chapter ch_PHY_11_3_10_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Physics", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("Physics", "Unit 10: Oscillations & Waves", 10, "Simple Harmonic Motion, Pendulum & Wave Propagation", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Physics", "Unit 10: Oscillations & Waves", "Simple Harmonic Motion, Pendulum & Wave Propagation", ch_PHY_11_3_10_10, "Resonance, Beats, Standing Waves & Doppler Effect");

        // Subject: Chemistry
        Subject sub_CHEM_11_4 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Chemistry")
                .orElseGet(() -> subjectRepository.save(new Subject("Chemistry", "CHEM", "🧪", "#8854d0", board, classLevel)));

        // Unit: Unit 1: Basic Concepts of Chemistry & Calculations
        Unit u_CHEM_11_4_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Chemistry")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Basic Concepts of Chemistry & Calculations", 1, "Chemistry", board, classLevel)));

        // Chapter: Mole Concept, Stoichiometry & Redox Reactions
        Chapter ch_CHEM_11_4_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Chemistry", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Chemistry", "Unit 1: Basic Concepts of Chemistry & Calculations", 1, "Mole Concept, Stoichiometry & Redox Reactions", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Chemistry", "Unit 1: Basic Concepts of Chemistry & Calculations", "Mole Concept, Stoichiometry & Redox Reactions", ch_CHEM_11_4_1_1, "Oxidation Numbers & Balancing Equations");

        // Unit: Unit 2: Quantum Mechanical Model of Atom
        Unit u_CHEM_11_4_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Chemistry")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Quantum Mechanical Model of Atom", 2, "Chemistry", board, classLevel)));

        // Chapter: Quantum Numbers, Aufbau, Pauli & Hund's Rule
        Chapter ch_CHEM_11_4_2_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Chemistry", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Chemistry", "Unit 2: Quantum Mechanical Model of Atom", 2, "Quantum Numbers, Aufbau, Pauli & Hund's Rule", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Chemistry", "Unit 2: Quantum Mechanical Model of Atom", "Quantum Numbers, Aufbau, Pauli & Hund's Rule", ch_CHEM_11_4_2_2, "Schrodinger Wave Equation & Orbitals");

        // Unit: Unit 3: Periodic Classification & Chemical Bonding
        Unit u_CHEM_11_4_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Chemistry")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Periodic Classification & Chemical Bonding", 3, "Chemistry", board, classLevel)));

        // Chapter: Periodic Trends, VSEPR & Hybridisation
        Chapter ch_CHEM_11_4_3_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Chemistry", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Chemistry", "Unit 3: Periodic Classification & Chemical Bonding", 3, "Periodic Trends, VSEPR & Hybridisation", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Chemistry", "Unit 3: Periodic Classification & Chemical Bonding", "Periodic Trends, VSEPR & Hybridisation", ch_CHEM_11_4_3_3, "Electronegativity, Ionisation Energy & Molecular Orbitals");

        // Unit: Unit 4: States of Matter & Thermodynamics
        Unit u_CHEM_11_4_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Chemistry")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: States of Matter & Thermodynamics", 4, "Chemistry", board, classLevel)));

        // Chapter: Gaseous State, Van der Waals & Enthalpy/Entropy
        Chapter ch_CHEM_11_4_4_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Chemistry", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Chemistry", "Unit 4: States of Matter & Thermodynamics", 4, "Gaseous State, Van der Waals & Enthalpy/Entropy", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Chemistry", "Unit 4: States of Matter & Thermodynamics", "Gaseous State, Van der Waals & Enthalpy/Entropy", ch_CHEM_11_4_4_4, "First, Second Laws & Gibbs Free Energy");

        // Unit: Unit 5: Chemical Equilibrium & Solutions
        Unit u_CHEM_11_4_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Chemistry")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 5: Chemical Equilibrium & Solutions", 5, "Chemistry", board, classLevel)));

        // Chapter: Le Chatelier's Principle & Colligative Properties
        Chapter ch_CHEM_11_4_5_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Chemistry", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Chemistry", "Unit 5: Chemical Equilibrium & Solutions", 5, "Le Chatelier's Principle & Colligative Properties", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Chemistry", "Unit 5: Chemical Equilibrium & Solutions", "Le Chatelier's Principle & Colligative Properties", ch_CHEM_11_4_5_5, "Kc, Kp, Raoult's Law & Osmotic Pressure");

        // Unit: Unit 6: Fundamentals of Organic Chemistry & Hydrocarbons
        Unit u_CHEM_11_4_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Chemistry")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 6: Fundamentals of Organic Chemistry & Hydrocarbons", 6, "Chemistry", board, classLevel)));

        // Chapter: IUPAC Nomenclature, Isomerism & Reactions
        Chapter ch_CHEM_11_4_6_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Chemistry", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Chemistry", "Unit 6: Fundamentals of Organic Chemistry & Hydrocarbons", 6, "IUPAC Nomenclature, Isomerism & Reactions", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Chemistry", "Unit 6: Fundamentals of Organic Chemistry & Hydrocarbons", "IUPAC Nomenclature, Isomerism & Reactions", ch_CHEM_11_4_6_6, "Electrophiles, Nucleophiles, Alkanes, Alkenes, Alkynes & Benzene");

        // Subject: Mathematics
        Subject sub_MATH_11_5 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Mathematics")
                .orElseGet(() -> subjectRepository.save(new Subject("Mathematics", "MATH", "📐", "#4834d4", board, classLevel)));

        // Unit: Unit 1: Sets, Relations and Functions
        Unit u_MATH_11_5_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Sets, Relations and Functions", 1, "Mathematics", board, classLevel)));

        // Chapter: Set Operations & Composite Functions
        Chapter ch_MATH_11_5_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 1: Sets, Relations and Functions", 1, "Set Operations & Composite Functions", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 1: Sets, Relations and Functions", "Set Operations & Composite Functions", ch_MATH_11_5_1_1, "Equivalence Relations & Inverses");

        // Unit: Unit 2: Basic Algebra & Trigonometry
        Unit u_MATH_11_5_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Basic Algebra & Trigonometry", 2, "Mathematics", board, classLevel)));

        // Chapter: Inequalities, Logarithms & Compound Angles
        Chapter ch_MATH_11_5_2_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 2: Basic Algebra & Trigonometry", 2, "Inequalities, Logarithms & Compound Angles", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 2: Basic Algebra & Trigonometry", "Inequalities, Logarithms & Compound Angles", ch_MATH_11_5_2_2, "Partial Fractions & Trigonometric Equations");

        // Unit: Unit 3: Combinatorics & Binomial Theorem
        Unit u_MATH_11_5_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Combinatorics & Binomial Theorem", 3, "Mathematics", board, classLevel)));

        // Chapter: Permutations, Combinations & Mathematical Induction
        Chapter ch_MATH_11_5_3_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 3: Combinatorics & Binomial Theorem", 3, "Permutations, Combinations & Mathematical Induction", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 3: Combinatorics & Binomial Theorem", "Permutations, Combinations & Mathematical Induction", ch_MATH_11_5_3_3, "Binomial Expansion & Series Approximations");

        // Unit: Unit 4: 2D Analytical Geometry & Vectors
        Unit u_MATH_11_5_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: 2D Analytical Geometry & Vectors", 4, "Mathematics", board, classLevel)));

        // Chapter: Pair of Straight Lines & Vector Operations
        Chapter ch_MATH_11_5_4_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 4: 2D Analytical Geometry & Vectors", 4, "Pair of Straight Lines & Vector Operations", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 4: 2D Analytical Geometry & Vectors", "Pair of Straight Lines & Vector Operations", ch_MATH_11_5_4_4, "Dot/Cross Products & Section Formula");

        // Unit: Unit 5: Differential & Integral Calculus
        Unit u_MATH_11_5_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 5: Differential & Integral Calculus", 5, "Mathematics", board, classLevel)));

        // Chapter: Limits, Continuity, Derivatives & Integrals
        Chapter ch_MATH_11_5_5_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 5: Differential & Integral Calculus", 5, "Limits, Continuity, Derivatives & Integrals", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 5: Differential & Integral Calculus", "Limits, Continuity, Derivatives & Integrals", ch_MATH_11_5_5_5, "Chain Rule, Product Rule, Integration by Parts");

        // Unit: Unit 6: Probability Theory
        Unit u_MATH_11_5_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 6: Probability Theory", 6, "Mathematics", board, classLevel)));

        // Chapter: Conditional Probability & Bayes' Theorem
        Chapter ch_MATH_11_5_6_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 6: Probability Theory", 6, "Conditional Probability & Bayes' Theorem", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 6: Probability Theory", "Conditional Probability & Bayes' Theorem", ch_MATH_11_5_6_6, "Independent Events & Sample Spaces");

        // Subject: Biology
        Subject sub_BIO_11_6 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Biology")
                .orElseGet(() -> subjectRepository.save(new Subject("Biology", "BIO", "🧬", "#20bf6b", board, classLevel)));

        // Unit: Unit 1: Diversity & Plant Morphology
        Unit u_BIO_11_6_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Biology")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Diversity & Plant Morphology", 1, "Biology", board, classLevel)));

        // Chapter: Living World & Plant Anatomy (Class 11)
        Chapter ch_BIO_11_6_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Biology", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Biology", "Unit 1: Diversity & Plant Morphology", 1, "Living World & Plant Anatomy (Class 11)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Biology", "Unit 1: Diversity & Plant Morphology", "Living World & Plant Anatomy (Class 11)", ch_BIO_11_6_1_1, "Taxonomy, Floral Formulas & Meristems");

        // Chapter: Plant Physiology & Photosynthesis (Class 11)
        Chapter ch_BIO_11_6_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Biology", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Biology", "Unit 1: Diversity & Plant Morphology", 2, "Plant Physiology & Photosynthesis (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Biology", "Unit 1: Diversity & Plant Morphology", "Plant Physiology & Photosynthesis (Class 11)", ch_BIO_11_6_1_2, "C3/C4 Cycles, Respiration & Plant Hormones");

        // Unit: Unit 2: Animal Systems & Human Physiology
        Unit u_BIO_11_6_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Biology")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Animal Systems & Human Physiology", 2, "Biology", board, classLevel)));

        // Chapter: Human Digestion, Circulation & Excretion (Class 11)
        Chapter ch_BIO_11_6_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Biology", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Biology", "Unit 2: Animal Systems & Human Physiology", 3, "Human Digestion, Circulation & Excretion (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Biology", "Unit 2: Animal Systems & Human Physiology", "Human Digestion, Circulation & Excretion (Class 11)", ch_BIO_11_6_2_3, "Heart, Nephron & Neural Transmission");

        // Chapter: Endocrine Coordination & Reproduction (Class 11)
        Chapter ch_BIO_11_6_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Biology", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Biology", "Unit 2: Animal Systems & Human Physiology", 4, "Endocrine Coordination & Reproduction (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Biology", "Unit 2: Animal Systems & Human Physiology", "Endocrine Coordination & Reproduction (Class 11)", ch_BIO_11_6_2_4, "Hormonal Cascades & Gametogenesis");

        // Unit: Unit 3: Genetics, Biotechnology & Ecology
        Unit u_BIO_11_6_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Biology")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Genetics, Biotechnology & Ecology", 3, "Biology", board, classLevel)));

        // Chapter: Molecular Genetics & Gene Expression (Class 11)
        Chapter ch_BIO_11_6_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Biology", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Biology", "Unit 3: Genetics, Biotechnology & Ecology", 5, "Molecular Genetics & Gene Expression (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Biology", "Unit 3: Genetics, Biotechnology & Ecology", "Molecular Genetics & Gene Expression (Class 11)", ch_BIO_11_6_3_5, "DNA Replication, Transcription & Translation");

        // Chapter: Recombinant DNA & Environmental Conservation (Class 11)
        Chapter ch_BIO_11_6_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Biology", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Biology", "Unit 3: Genetics, Biotechnology & Ecology", 6, "Recombinant DNA & Environmental Conservation (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Biology", "Unit 3: Genetics, Biotechnology & Ecology", "Recombinant DNA & Environmental Conservation (Class 11)", ch_BIO_11_6_3_6, "PCR, Plasmids, Bioremediation & Ecosystems");

        // Subject: Botany
        Subject sub_BOT_11_7 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Botany")
                .orElseGet(() -> subjectRepository.save(new Subject("Botany", "BOT", "🌱", "#26de81", board, classLevel)));

        // Unit: Unit 1: Plant Taxonomy & Cell Biology
        Unit u_BOT_11_7_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Botany")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Plant Taxonomy & Cell Biology", 1, "Botany", board, classLevel)));

        // Chapter: Taxonomy of Angiosperms & Cell Structure (Class 11)
        Chapter ch_BOT_11_7_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Botany", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Botany", "Unit 1: Plant Taxonomy & Cell Biology", 1, "Taxonomy of Angiosperms & Cell Structure (Class 11)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Botany", "Unit 1: Plant Taxonomy & Cell Biology", "Taxonomy of Angiosperms & Cell Structure (Class 11)", ch_BOT_11_7_1_1, "Bentham & Hooker, Floral Anatomy & Organelles");

        // Unit: Unit 2: Plant Physiology & Plant Breeding
        Unit u_BOT_11_7_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Botany")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Plant Physiology & Plant Breeding", 2, "Botany", board, classLevel)));

        // Chapter: Mineral Nutrition, Photosynthesis & Hybridisation (Class 11)
        Chapter ch_BOT_11_7_2_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Botany", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Botany", "Unit 2: Plant Physiology & Plant Breeding", 2, "Mineral Nutrition, Photosynthesis & Hybridisation (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Botany", "Unit 2: Plant Physiology & Plant Breeding", "Mineral Nutrition, Photosynthesis & Hybridisation (Class 11)", ch_BOT_11_7_2_2, "Nitrogen Fixation, Calvin Cycle & Crop Improvement");

        // Unit: Unit 3: Plant Biotechnology & Ecology
        Unit u_BOT_11_7_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Botany")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Plant Biotechnology & Ecology", 3, "Botany", board, classLevel)));

        // Chapter: Tissue Culture, Genetic Engineering & Ecological Succession (Class 11)
        Chapter ch_BOT_11_7_3_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Botany", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Botany", "Unit 3: Plant Biotechnology & Ecology", 3, "Tissue Culture, Genetic Engineering & Ecological Succession (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Botany", "Unit 3: Plant Biotechnology & Ecology", "Tissue Culture, Genetic Engineering & Ecological Succession (Class 11)", ch_BOT_11_7_3_3, "Callus Culture, Vector Biology & Ecosystem Energy");

        // Subject: Zoology
        Subject sub_ZOO_11_8 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Zoology")
                .orElseGet(() -> subjectRepository.save(new Subject("Zoology", "ZOO", "🐾", "#fed330", board, classLevel)));

        // Unit: Unit 1: Animal Diversity & Human Systems
        Unit u_ZOO_11_8_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Zoology")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Animal Diversity & Human Systems", 1, "Zoology", board, classLevel)));

        // Chapter: Animal Classification & Human Organ Systems (Class 11)
        Chapter ch_ZOO_11_8_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Zoology", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Zoology", "Unit 1: Animal Diversity & Human Systems", 1, "Animal Classification & Human Organ Systems (Class 11)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Zoology", "Unit 1: Animal Diversity & Human Systems", "Animal Classification & Human Organ Systems (Class 11)", ch_ZOO_11_8_1_1, "Chordates, Nervous System & Cardio-vascular Dynamics");

        // Unit: Unit 2: Genetics, Immunology & Health
        Unit u_ZOO_11_8_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Zoology")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Genetics, Immunology & Health", 2, "Zoology", board, classLevel)));

        // Chapter: Mendelian Inheritance, Antibodies & Disease Prevention (Class 11)
        Chapter ch_ZOO_11_8_2_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Zoology", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Zoology", "Unit 2: Genetics, Immunology & Health", 2, "Mendelian Inheritance, Antibodies & Disease Prevention (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Zoology", "Unit 2: Genetics, Immunology & Health", "Mendelian Inheritance, Antibodies & Disease Prevention (Class 11)", ch_ZOO_11_8_2_2, "Chromosomal Aberrations, Vaccines & Autoimmunity");

        // Unit: Unit 3: Applied Zoology & Environmental Conservation
        Unit u_ZOO_11_8_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Zoology")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Applied Zoology & Environmental Conservation", 3, "Zoology", board, classLevel)));

        // Chapter: Sericulture, Aquaculture & Wildlife Preservation (Class 11)
        Chapter ch_ZOO_11_8_3_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Zoology", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Zoology", "Unit 3: Applied Zoology & Environmental Conservation", 3, "Sericulture, Aquaculture & Wildlife Preservation (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Zoology", "Unit 3: Applied Zoology & Environmental Conservation", "Sericulture, Aquaculture & Wildlife Preservation (Class 11)", ch_ZOO_11_8_3_3, "Economic Culture Methods & Endangered Species Protection");

        // Subject: Computer Science
        Subject sub_CS_11_9 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Computer Science")
                .orElseGet(() -> subjectRepository.save(new Subject("Computer Science", "CS", "💻", "#2d98da", board, classLevel)));

        // Unit: Unit 1: Computer Fundamentals & Programming in Python
        Unit u_CS_11_9_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Computer Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Computer Fundamentals & Programming in Python", 1, "Computer Science", board, classLevel)));

        // Chapter: Python Fundamentals, Data Types & Control Flow (Class 11)
        Chapter ch_CS_11_9_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Computer Science", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Computer Science", "Unit 1: Computer Fundamentals & Programming in Python", 1, "Python Fundamentals, Data Types & Control Flow (Class 11)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Computer Science", "Unit 1: Computer Fundamentals & Programming in Python", "Python Fundamentals, Data Types & Control Flow (Class 11)", ch_CS_11_9_1_1, "Variables, Loops, Functions & Recursion");

        // Chapter: Data Structures – Lists, Tuples, Sets, Dictionaries (Class 11)
        Chapter ch_CS_11_9_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Computer Science", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Computer Science", "Unit 1: Computer Fundamentals & Programming in Python", 2, "Data Structures – Lists, Tuples, Sets, Dictionaries (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Computer Science", "Unit 1: Computer Fundamentals & Programming in Python", "Data Structures – Lists, Tuples, Sets, Dictionaries (Class 11)", ch_CS_11_9_1_2, "Operations, Slicing & Comprehensions");

        // Unit: Unit 2: Object Oriented Programming & Algorithms
        Unit u_CS_11_9_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Computer Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Object Oriented Programming & Algorithms", 2, "Computer Science", board, classLevel)));

        // Chapter: Classes, Objects, Inheritance & Algorithmic Analysis (Class 11)
        Chapter ch_CS_11_9_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Computer Science", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Computer Science", "Unit 2: Object Oriented Programming & Algorithms", 3, "Classes, Objects, Inheritance & Algorithmic Analysis (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Computer Science", "Unit 2: Object Oriented Programming & Algorithms", "Classes, Objects, Inheritance & Algorithmic Analysis (Class 11)", ch_CS_11_9_2_3, "Encapsulation, Time Complexity & Searching/Sorting");

        // Unit: Unit 3: Database Concepts, SQL & Web Security
        Unit u_CS_11_9_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Computer Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Database Concepts, SQL & Web Security", 3, "Computer Science", board, classLevel)));

        // Chapter: RDBMS Concepts, SQL Queries & Python-DB Integration (Class 11)
        Chapter ch_CS_11_9_3_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Computer Science", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Computer Science", "Unit 3: Database Concepts, SQL & Web Security", 4, "RDBMS Concepts, SQL Queries & Python-DB Integration (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Computer Science", "Unit 3: Database Concepts, SQL & Web Security", "RDBMS Concepts, SQL Queries & Python-DB Integration (Class 11)", ch_CS_11_9_3_4, "DDL, DML, Joins, SQLite & MySQL Interface");

        // Chapter: Cyber Ethics, Cyber Security & Tamil Computing (Class 11)
        Chapter ch_CS_11_9_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Computer Science", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Computer Science", "Unit 3: Database Concepts, SQL & Web Security", 5, "Cyber Ethics, Cyber Security & Tamil Computing (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Computer Science", "Unit 3: Database Concepts, SQL & Web Security", "Cyber Ethics, Cyber Security & Tamil Computing (Class 11)", ch_CS_11_9_3_5, "Firewalls, Phishing, Unicode, Tamil Keyboards & Open Source");

        // Subject: Computer Applications
        Subject sub_CA_11_10 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Computer Applications")
                .orElseGet(() -> subjectRepository.save(new Subject("Computer Applications", "CA", "🖥️", "#4b6584", board, classLevel)));

        // Unit: Unit 1: Multimedia, Desktop Publishing & Web Design
        Unit u_CA_11_10_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Computer Applications")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Multimedia, Desktop Publishing & Web Design", 1, "Computer Applications", board, classLevel)));

        // Chapter: Adobe PageMaker & Multimedia Production (Class 11)
        Chapter ch_CA_11_10_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Computer Applications", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Computer Applications", "Unit 1: Multimedia, Desktop Publishing & Web Design", 1, "Adobe PageMaker & Multimedia Production (Class 11)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Computer Applications", "Unit 1: Multimedia, Desktop Publishing & Web Design", "Adobe PageMaker & Multimedia Production (Class 11)", ch_CA_11_10_1_1, "Page Layout, Typography, Audio/Video Integration");

        // Chapter: HTML5, CSS & JavaScript Fundamentals (Class 11)
        Chapter ch_CA_11_10_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Computer Applications", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Computer Applications", "Unit 1: Multimedia, Desktop Publishing & Web Design", 2, "HTML5, CSS & JavaScript Fundamentals (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Computer Applications", "Unit 1: Multimedia, Desktop Publishing & Web Design", "HTML5, CSS & JavaScript Fundamentals (Class 11)", ch_CA_11_10_1_2, "Forms, Styling, DOM Manipulation & Event Handlers");

        // Unit: Unit 2: Server-side Scripting with PHP & MySQL
        Unit u_CA_11_10_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Computer Applications")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Server-side Scripting with PHP & MySQL", 2, "Computer Applications", board, classLevel)));

        // Chapter: PHP Variables, Control Structures & MySQL Connectivity (Class 11)
        Chapter ch_CA_11_10_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Computer Applications", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Computer Applications", "Unit 2: Server-side Scripting with PHP & MySQL", 3, "PHP Variables, Control Structures & MySQL Connectivity (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Computer Applications", "Unit 2: Server-side Scripting with PHP & MySQL", "PHP Variables, Control Structures & MySQL Connectivity (Class 11)", ch_CA_11_10_2_3, "Session Handling, Form Validation & Database CRUD");

        // Unit: Unit 3: E-Commerce, Networks & Information Security
        Unit u_CA_11_10_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Computer Applications")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: E-Commerce, Networks & Information Security", 3, "Computer Applications", board, classLevel)));

        // Chapter: E-Commerce Models, Electronic Payment Systems & Cyber Law (Class 11)
        Chapter ch_CA_11_10_3_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Computer Applications", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Computer Applications", "Unit 3: E-Commerce, Networks & Information Security", 4, "E-Commerce Models, Electronic Payment Systems & Cyber Law (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Computer Applications", "Unit 3: E-Commerce, Networks & Information Security", "E-Commerce Models, Electronic Payment Systems & Cyber Law (Class 11)", ch_CA_11_10_3_4, "B2B, B2C, UPI, Payment Gateways & IT Act Provisions");

        // Subject: Accountancy
        Subject sub_ACC_11_11 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Accountancy")
                .orElseGet(() -> subjectRepository.save(new Subject("Accountancy", "ACC", "📋", "#2bcbba", board, classLevel)));

        // Unit: Unit 1: Financial Accounting Principles & Final Accounts
        Unit u_ACC_11_11_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Accountancy")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Financial Accounting Principles & Final Accounts", 1, "Accountancy", board, classLevel)));

        // Chapter: Accounting Concepts, Journal, Ledger & Trial Balance (Class 11)
        Chapter ch_ACC_11_11_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Accountancy", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Accountancy", "Unit 1: Financial Accounting Principles & Final Accounts", 1, "Accounting Concepts, Journal, Ledger & Trial Balance (Class 11)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Accountancy", "Unit 1: Financial Accounting Principles & Final Accounts", "Accounting Concepts, Journal, Ledger & Trial Balance (Class 11)", ch_ACC_11_11_1_1, "Double Entry System & Reconciliation");

        // Chapter: Final Accounts of Sole Proprietors & Incomplete Records (Class 11)
        Chapter ch_ACC_11_11_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Accountancy", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Accountancy", "Unit 1: Financial Accounting Principles & Final Accounts", 2, "Final Accounts of Sole Proprietors & Incomplete Records (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Accountancy", "Unit 1: Financial Accounting Principles & Final Accounts", "Final Accounts of Sole Proprietors & Incomplete Records (Class 11)", ch_ACC_11_11_1_2, "Trading, P&L Account, Balance Sheet & Single Entry Conversion");

        // Unit: Unit 2: Partnership Accounts & Company Accounts
        Unit u_ACC_11_11_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Accountancy")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Partnership Accounts & Company Accounts", 2, "Accountancy", board, classLevel)));

        // Chapter: Partnership Fundamentals, Admission, Retirement & Dissolution (Class 11)
        Chapter ch_ACC_11_11_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Accountancy", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Accountancy", "Unit 2: Partnership Accounts & Company Accounts", 3, "Partnership Fundamentals, Admission, Retirement & Dissolution (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Accountancy", "Unit 2: Partnership Accounts & Company Accounts", "Partnership Fundamentals, Admission, Retirement & Dissolution (Class 11)", ch_ACC_11_11_2_3, "Goodwill Valuation, Revaluation & Capital Adjustments");

        // Chapter: Issue of Shares, Debentures & Financial Statement Analysis (Class 11)
        Chapter ch_ACC_11_11_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Accountancy", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Accountancy", "Unit 2: Partnership Accounts & Company Accounts", 4, "Issue of Shares, Debentures & Financial Statement Analysis (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Accountancy", "Unit 2: Partnership Accounts & Company Accounts", "Issue of Shares, Debentures & Financial Statement Analysis (Class 11)", ch_ACC_11_11_2_4, "Forfeiture, Reissue, Comparative Statements & Accounting Ratios");

        // Unit: Unit 3: Computerised Accounting System
        Unit u_ACC_11_11_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Accountancy")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Computerised Accounting System", 3, "Accountancy", board, classLevel)));

        // Chapter: Computerised Accounting Software & Tally Configuration (Class 11)
        Chapter ch_ACC_11_11_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Accountancy", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Accountancy", "Unit 3: Computerised Accounting System", 5, "Computerised Accounting Software & Tally Configuration (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Accountancy", "Unit 3: Computerised Accounting System", "Computerised Accounting Software & Tally Configuration (Class 11)", ch_ACC_11_11_3_5, "Voucher Entry, Ledgers, Reports & GST Invoicing");

        // Subject: Commerce
        Subject sub_COMM_11_12 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Commerce")
                .orElseGet(() -> subjectRepository.save(new Subject("Commerce", "COMM", "💼", "#ff9f43", board, classLevel)));

        // Unit: Unit 1: Forms of Business Organisation & Management
        Unit u_COMM_11_12_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Commerce")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Forms of Business Organisation & Management", 1, "Commerce", board, classLevel)));

        // Chapter: Sole Proprietorship, Partnership & Joint Stock Companies (Class 11)
        Chapter ch_COMM_11_12_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Commerce", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Commerce", "Unit 1: Forms of Business Organisation & Management", 1, "Sole Proprietorship, Partnership & Joint Stock Companies (Class 11)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Commerce", "Unit 1: Forms of Business Organisation & Management", "Sole Proprietorship, Partnership & Joint Stock Companies (Class 11)", ch_COMM_11_12_1_1, "Formation, Memorandum, Articles & Management Principles");

        // Chapter: Principles of Scientific Management & Planning/Organising (Class 11)
        Chapter ch_COMM_11_12_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Commerce", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Commerce", "Unit 1: Forms of Business Organisation & Management", 2, "Principles of Scientific Management & Planning/Organising (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Commerce", "Unit 1: Forms of Business Organisation & Management", "Principles of Scientific Management & Planning/Organising (Class 11)", ch_COMM_11_12_1_2, "Fayol's 14 Principles, Taylor's Scientific Approach");

        // Unit: Unit 2: Financial Markets, Marketing & Consumer Protection
        Unit u_COMM_11_12_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Commerce")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Financial Markets, Marketing & Consumer Protection", 2, "Commerce", board, classLevel)));

        // Chapter: Capital Market, Money Market & SEBI Regulations (Class 11)
        Chapter ch_COMM_11_12_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Commerce", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Commerce", "Unit 2: Financial Markets, Marketing & Consumer Protection", 3, "Capital Market, Money Market & SEBI Regulations (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Commerce", "Unit 2: Financial Markets, Marketing & Consumer Protection", "Capital Market, Money Market & SEBI Regulations (Class 11)", ch_COMM_11_12_2_3, "Stock Exchanges, Treasury Bills, Primary/Secondary Markets");

        // Chapter: Modern Marketing, 4Ps, E-Commerce & Consumer Rights (Class 11)
        Chapter ch_COMM_11_12_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Commerce", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Commerce", "Unit 2: Financial Markets, Marketing & Consumer Protection", 4, "Modern Marketing, 4Ps, E-Commerce & Consumer Rights (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Commerce", "Unit 2: Financial Markets, Marketing & Consumer Protection", "Modern Marketing, 4Ps, E-Commerce & Consumer Rights (Class 11)", ch_COMM_11_12_2_4, "Consumer Protection Act, Redressal Forums & Marketing Ethics");

        // Subject: Economics
        Subject sub_ECO_11_13 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Economics")
                .orElseGet(() -> subjectRepository.save(new Subject("Economics", "ECO", "📈", "#ee5253", board, classLevel)));

        // Unit: Unit 1: Microeconomics & National Income
        Unit u_ECO_11_13_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Economics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Microeconomics & National Income", 1, "Economics", board, classLevel)));

        // Chapter: Consumer Behavior, Demand, Supply & Market Equilibrium (Class 11)
        Chapter ch_ECO_11_13_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Economics", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Economics", "Unit 1: Microeconomics & National Income", 1, "Consumer Behavior, Demand, Supply & Market Equilibrium (Class 11)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Economics", "Unit 1: Microeconomics & National Income", "Consumer Behavior, Demand, Supply & Market Equilibrium (Class 11)", ch_ECO_11_13_1_1, "Law of Demand, Elasticity, Indifference Curves & Cost/Revenue");

        // Chapter: National Income Accounting & Circular Flow of Income (Class 11)
        Chapter ch_ECO_11_13_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Economics", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Economics", "Unit 1: Microeconomics & National Income", 2, "National Income Accounting & Circular Flow of Income (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Economics", "Unit 1: Microeconomics & National Income", "National Income Accounting & Circular Flow of Income (Class 11)", ch_ECO_11_13_1_2, "GDP, GNP, NNP, Real vs Nominal GDP & Sectoral Output");

        // Unit: Unit 2: Monetary Policy, Public Finance & Tamil Nadu Economy
        Unit u_ECO_11_13_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Economics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Monetary Policy, Public Finance & Tamil Nadu Economy", 2, "Economics", board, classLevel)));

        // Chapter: Money, Banking, Inflation & RBI Monetary Policy (Class 11)
        Chapter ch_ECO_11_13_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Economics", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Economics", "Unit 2: Monetary Policy, Public Finance & Tamil Nadu Economy", 3, "Money, Banking, Inflation & RBI Monetary Policy (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Economics", "Unit 2: Monetary Policy, Public Finance & Tamil Nadu Economy", "Money, Banking, Inflation & RBI Monetary Policy (Class 11)", ch_ECO_11_13_2_3, "Repo Rate, CRR, Commercial Banks & Fiscal Deficit");

        // Chapter: International Trade, Fiscal Economics & Tamil Nadu Economy (Class 11)
        Chapter ch_ECO_11_13_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Economics", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Economics", "Unit 2: Monetary Policy, Public Finance & Tamil Nadu Economy", 4, "International Trade, Fiscal Economics & Tamil Nadu Economy (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Economics", "Unit 2: Monetary Policy, Public Finance & Tamil Nadu Economy", "International Trade, Fiscal Economics & Tamil Nadu Economy (Class 11)", ch_ECO_11_13_2_4, "Foreign Exchange, Budget, GST, NITI Aayog & TN Growth Model");

        // Subject: Business Mathematics
        Subject sub_BMATH_11_14 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Business Mathematics")
                .orElseGet(() -> subjectRepository.save(new Subject("Business Mathematics", "BMATH", "🔢", "#341f97", board, classLevel)));

        // Unit: Unit 1: Matrices, Determinants & Financial Mathematics
        Unit u_BMATH_11_14_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Business Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Matrices, Determinants & Financial Mathematics", 1, "Business Mathematics", board, classLevel)));

        // Chapter: Matrix Operations, Input-Output Analysis & Annuities (Class 11)
        Chapter ch_BMATH_11_14_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Business Mathematics", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Business Mathematics", "Unit 1: Matrices, Determinants & Financial Mathematics", 1, "Matrix Operations, Input-Output Analysis & Annuities (Class 11)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Business Mathematics", "Unit 1: Matrices, Determinants & Financial Mathematics", "Matrix Operations, Input-Output Analysis & Annuities (Class 11)", ch_BMATH_11_14_1_1, "Cramer's Rule, Leontief Model, Compound Interest & Sinking Funds");

        // Unit: Unit 2: Differential Calculus, Marginal Analysis & Linear Programming
        Unit u_BMATH_11_14_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Business Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Differential Calculus, Marginal Analysis & Linear Programming", 2, "Business Mathematics", board, classLevel)));

        // Chapter: Marginal Cost, Revenue Optimisation & Transportation Problems (Class 11)
        Chapter ch_BMATH_11_14_2_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Business Mathematics", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Business Mathematics", "Unit 2: Differential Calculus, Marginal Analysis & Linear Programming", 2, "Marginal Cost, Revenue Optimisation & Transportation Problems (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Business Mathematics", "Unit 2: Differential Calculus, Marginal Analysis & Linear Programming", "Marginal Cost, Revenue Optimisation & Transportation Problems (Class 11)", ch_BMATH_11_14_2_2, "Derivatives, Maxima/Minima, Simplex Method & Assignment");

        // Subject: Statistics
        Subject sub_STAT_11_15 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Statistics")
                .orElseGet(() -> subjectRepository.save(new Subject("Statistics", "STAT", "📊", "#0abde3", board, classLevel)));

        // Unit: Unit 1: Descriptive Statistics & Probability Distributions
        Unit u_STAT_11_15_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Statistics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Descriptive Statistics & Probability Distributions", 1, "Statistics", board, classLevel)));

        // Chapter: Measures of Central Tendency, Dispersion & Binomial/Normal Curve (Class 11)
        Chapter ch_STAT_11_15_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Statistics", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Statistics", "Unit 1: Descriptive Statistics & Probability Distributions", 1, "Measures of Central Tendency, Dispersion & Binomial/Normal Curve (Class 11)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Statistics", "Unit 1: Descriptive Statistics & Probability Distributions", "Measures of Central Tendency, Dispersion & Binomial/Normal Curve (Class 11)", ch_STAT_11_15_1_1, "Mean, SD, Skewness, Kurtosis & Normal Probabilities");

        // Unit: Unit 2: Statistical Inference, Time Series & Index Numbers
        Unit u_STAT_11_15_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Statistics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Statistical Inference, Time Series & Index Numbers", 2, "Statistics", board, classLevel)));

        // Chapter: Hypothesis Testing, Large/Small Sample Tests & Index Numbers (Class 11)
        Chapter ch_STAT_11_15_2_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Statistics", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Statistics", "Unit 2: Statistical Inference, Time Series & Index Numbers", 2, "Hypothesis Testing, Large/Small Sample Tests & Index Numbers (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Statistics", "Unit 2: Statistical Inference, Time Series & Index Numbers", "Hypothesis Testing, Large/Small Sample Tests & Index Numbers (Class 11)", ch_STAT_11_15_2_2, "Z-test, t-test, Chi-square, Moving Averages & Laspeyres/Paasche");

        // Subject: History
        Subject sub_HIST_11_16 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "History")
                .orElseGet(() -> subjectRepository.save(new Subject("History", "HIST", "🏛️", "#5f27cd", board, classLevel)));

        // Unit: Unit 1: Ancient & Medieval Indian History
        Unit u_HIST_11_16_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "History")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Ancient & Medieval Indian History", 1, "History", board, classLevel)));

        // Chapter: Indus Valley, Vedic Age, Mauryas, Guptas & Chola Empire (Class 11)
        Chapter ch_HIST_11_16_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "History", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("History", "Unit 1: Ancient & Medieval Indian History", 1, "Indus Valley, Vedic Age, Mauryas, Guptas & Chola Empire (Class 11)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "History", "Unit 1: Ancient & Medieval Indian History", "Indus Valley, Vedic Age, Mauryas, Guptas & Chola Empire (Class 11)", ch_HIST_11_16_1_1, "State Formation, Art, Architecture, Administration & Overseas Trade");

        // Chapter: Delhi Sultanate, Vijayanagar Kingdom & Mughal Empire (Class 11)
        Chapter ch_HIST_11_16_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "History", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("History", "Unit 1: Ancient & Medieval Indian History", 2, "Delhi Sultanate, Vijayanagar Kingdom & Mughal Empire (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "History", "Unit 1: Ancient & Medieval Indian History", "Delhi Sultanate, Vijayanagar Kingdom & Mughal Empire (Class 11)", ch_HIST_11_16_1_2, "Revenue Systems, Religious Policies, Literature & Architecture");

        // Unit: Unit 2: Modern Indian History & Tamil Nadu Freedom Struggle
        Unit u_HIST_11_16_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "History")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Modern Indian History & Tamil Nadu Freedom Struggle", 2, "History", board, classLevel)));

        // Chapter: British Colonial Consolidation, 1857 Revolt & Nationalist Upsurge (Class 11)
        Chapter ch_HIST_11_16_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "History", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("History", "Unit 2: Modern Indian History & Tamil Nadu Freedom Struggle", 3, "British Colonial Consolidation, 1857 Revolt & Nationalist Upsurge (Class 11)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "History", "Unit 2: Modern Indian History & Tamil Nadu Freedom Struggle", "British Colonial Consolidation, 1857 Revolt & Nationalist Upsurge (Class 11)", ch_HIST_11_16_2_3, "Economic Impact of British Rule, Gandhi & Mass Mobilisation");

        // Chapter: Freedom Struggle in Tamil Nadu & Social Transformation
        Chapter ch_HIST_11_16_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "History", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("History", "Unit 2: Modern Indian History & Tamil Nadu Freedom Struggle", 4, "Freedom Struggle in Tamil Nadu & Social Transformation", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "History", "Unit 2: Modern Indian History & Tamil Nadu Freedom Struggle", "Freedom Struggle in Tamil Nadu & Social Transformation", ch_HIST_11_16_2_4, "Self-Respect Movement, Periyar, Justice Party & Post-Independence Era");

    }

    private void seed_STATE_BOARD_Class_12() {
        String board = "STATE_BOARD";
        int classLevel = 12;

        // Subject: Tamil
        Subject sub_TAM_12_1 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Tamil")
                .orElseGet(() -> subjectRepository.save(new Subject("Tamil", "TAM", "📖", "#e84118", board, classLevel)));

        // Unit: இயல் 1: மொழி – இளந்தமிழே
        Unit u_TAM_12_1_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 1: மொழி – இளந்தமிழே", 1, "Tamil", board, classLevel)));

        // Chapter: இளந்தமிழே!
        Chapter ch_TAM_12_1_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 1: மொழி – இளந்தமிழே", 1, "இளந்தமிழே!", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 1: மொழி – இளந்தமிழே", "இளந்தமிழே!", ch_TAM_12_1_1_1, "சிற்பி பாலசுப்பிரமணியம்");

        // Chapter: தமிழாய் எழுதுவோம்
        Chapter ch_TAM_12_1_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 1: மொழி – இளந்தமிழே", 2, "தமிழாய் எழுதுவோம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 1: மொழி – இளந்தமிழே", "தமிழாய் எழுதுவோம்", ch_TAM_12_1_1_2, "தூய தமிழ் எழுதும் முறை");

        // Unit: இயல் 2: இயற்கை – நெடுநல்வாடை
        Unit u_TAM_12_1_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 2: இயற்கை – நெடுநல்வாடை", 2, "Tamil", board, classLevel)));

        // Chapter: நெடுநல்வாடை
        Chapter ch_TAM_12_1_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 2: இயற்கை – நெடுநல்வாடை", 3, "நெடுநல்வாடை", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 2: இயற்கை – நெடுநல்வாடை", "நெடுநல்வாடை", ch_TAM_12_1_2_3, "நக்கீரர் சங்க இலக்கியம்");

        // Chapter: நால்வகை பொருத்தங்கள்
        Chapter ch_TAM_12_1_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 2: இயற்கை – நெடுநல்வாடை", 4, "நால்வகை பொருத்தங்கள்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 2: இயற்கை – நெடுநல்வாடை", "நால்வகை பொருத்தங்கள்", ch_TAM_12_1_2_4, "திணை பால் எண் இடம்");

        // Unit: இயல் 3: பண்பாடு – கம்பராமாயணம்
        Unit u_TAM_12_1_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 3: பண்பாடு – கம்பராமாயணம்", 3, "Tamil", board, classLevel)));

        // Chapter: கம்பராமாயணம்
        Chapter ch_TAM_12_1_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 3: பண்பாடு – கம்பராமாயணம்", 5, "கம்பராமாயணம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 3: பண்பாடு – கம்பராமாயணம்", "கம்பராமாயணம்", ch_TAM_12_1_3_5, "கம்பர் காப்பிய நயம்");

        // Chapter: திருக்குறள்
        Chapter ch_TAM_12_1_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 3: பண்பாடு – கம்பராமாயணம்", 6, "திருக்குறள்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 3: பண்பாடு – கம்பராமாயணம்", "திருக்குறள்", ch_TAM_12_1_3_6, "இல்வாழ்க்கை & செய்ந்நன்றி");

        // Unit: இயல் 4: கல்வி – இதில் வெற்றி பெற
        Unit u_TAM_12_1_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 4: கல்வி – இதில் வெற்றி பெற", 4, "Tamil", board, classLevel)));

        // Chapter: இதில் வெற்றி பெற
        Chapter ch_TAM_12_1_4_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 4: கல்வி – இதில் வெற்றி பெற", 7, "இதில் வெற்றி பெற", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 4: கல்வி – இதில் வெற்றி பெற", "இதில் வெற்றி பெற", ch_TAM_12_1_4_7, "சுரதா கவிதை யாப்பு");

        // Chapter: பாதுகாப்போம் சுற்றுப்புறம்
        Chapter ch_TAM_12_1_4_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 4: கல்வி – இதில் வெற்றி பெற", 8, "பாதுகாப்போம் சுற்றுப்புறம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 4: கல்வி – இதில் வெற்றி பெற", "பாதுகாப்போம் சுற்றுப்புறம்", ch_TAM_12_1_4_8, "சுற்றுச்சூழல் விழிப்புணர்வு");

        // Unit: இயல் 5: நாகரிகம் – தெய்வமணிமாலை
        Unit u_TAM_12_1_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 5: நாகரிகம் – தெய்வமணிமாலை", 5, "Tamil", board, classLevel)));

        // Chapter: தெய்வமணிமாலை
        Chapter ch_TAM_12_1_5_9 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 9)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 5: நாகரிகம் – தெய்வமணிமாலை", 9, "தெய்வமணிமாலை", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 5: நாகரிகம் – தெய்வமணிமாலை", "தெய்வமணிமாலை", ch_TAM_12_1_5_9, "இராமலிங்க அடிகளார்");

        // Chapter: தேவாரம்
        Chapter ch_TAM_12_1_5_10 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 10)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 5: நாகரிகம் – தெய்வமணிமாலை", 10, "தேவாரம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 5: நாகரிகம் – தெய்வமணிமாலை", "தேவாரம்", ch_TAM_12_1_5_10, "திருஞானசம்பந்தர்");

        // Unit: இயல் 6: கலை – சிலப்பதிகாரம்
        Unit u_TAM_12_1_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 6: கலை – சிலப்பதிகாரம்", 6, "Tamil", board, classLevel)));

        // Chapter: சிலப்பதிகாரம்: காட்சிக் காதை
        Chapter ch_TAM_12_1_6_11 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 11)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 6: கலை – சிலப்பதிகாரம்", 11, "சிலப்பதிகாரம்: காட்சிக் காதை", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 6: கலை – சிலப்பதிகாரம்", "சிலப்பதிகாரம்: காட்சிக் காதை", ch_TAM_12_1_6_11, "சேரன் செங்குட்டுவன் கண்ணகி சிலை");

        // Chapter: மெய்ப்பாட்டியல்
        Chapter ch_TAM_12_1_6_12 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 12)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 6: கலை – சிலப்பதிகாரம்", 12, "மெய்ப்பாட்டியல்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 6: கலை – சிலப்பதிகாரம்", "மெய்ப்பாட்டியல்", ch_TAM_12_1_6_12, "தொல்காப்பியம் எண்வகை மெய்ப்பாடு");

        // Unit: இயல் 7: அறம் – இலக்கியத்தின் நோக்கம்
        Unit u_TAM_12_1_7 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 7).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 7: அறம் – இலக்கியத்தின் நோக்கம்", 7, "Tamil", board, classLevel)));

        // Chapter: இலக்கியத்தின் நோக்கம்
        Chapter ch_TAM_12_1_7_13 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 13)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 7: அறம் – இலக்கியத்தின் நோக்கம்", 13, "இலக்கியத்தின் நோக்கம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 7: அறம் – இலக்கியத்தின் நோக்கம்", "இலக்கியத்தின் நோக்கம்", ch_TAM_12_1_7_13, "மு. வரதராசனார் வாழ்வியல் நெறி");

        // Chapter: புறநானூறு
        Chapter ch_TAM_12_1_7_14 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 14)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 7: அறம் – இலக்கியத்தின் நோக்கம்", 14, "புறநானூறு", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 7: அறம் – இலக்கியத்தின் நோக்கம்", "புறநானூறு", ch_TAM_12_1_7_14, "பொன்முடியார் சங்க வீரம்");

        // Unit: இயல் 8: மனிதம் – ரட்சணிய யாத்ரிகம்
        Unit u_TAM_12_1_8 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Tamil")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 8).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("இயல் 8: மனிதம் – ரட்சணிய யாத்ரிகம்", 8, "Tamil", board, classLevel)));

        // Chapter: ரட்சணிய யாத்ரிகம்
        Chapter ch_TAM_12_1_8_15 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 15)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 8: மனிதம் – ரட்சணிய யாத்ரிகம்", 15, "ரட்சணிய யாத்ரிகம்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 8: மனிதம் – ரட்சணிய யாத்ரிகம்", "ரட்சணிய யாத்ரிகம்", ch_TAM_12_1_8_15, "எச்.ஏ. கிருஷ்ணபிள்ளை கிறித்தவ கம்பன்");

        // Chapter: கோபல்லபுரத்து மக்கள்
        Chapter ch_TAM_12_1_8_16 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Tamil", 16)
                .orElseGet(() -> chapterRepository.save(new Chapter("Tamil", "இயல் 8: மனிதம் – ரட்சணிய யாத்ரிகம்", 16, "கோபல்லபுரத்து மக்கள்", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Tamil", "இயல் 8: மனிதம் – ரட்சணிய யாத்ரிகம்", "கோபல்லபுரத்து மக்கள்", ch_TAM_12_1_8_16, "கி. ராஜநாராயணன் கரிசல் கதை");

        // Subject: English
        Subject sub_ENG_12_2 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "English")
                .orElseGet(() -> subjectRepository.save(new Subject("English", "ENG", "📚", "#fa8231", board, classLevel)));

        // Unit: Unit 1: Prose & Poetry Collection
        Unit u_ENG_12_2_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Prose & Poetry Collection", 1, "English", board, classLevel)));

        // Chapter: Prose Study (Class 12)
        Chapter ch_ENG_12_2_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 1: Prose & Poetry Collection", 1, "Prose Study (Class 12)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 1: Prose & Poetry Collection", "Prose Study (Class 12)", ch_ENG_12_2_1_1, "Advanced Vocabulary & Comprehension");

        // Chapter: Poetry Analysis (Class 12)
        Chapter ch_ENG_12_2_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 1: Prose & Poetry Collection", 2, "Poetry Analysis (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 1: Prose & Poetry Collection", "Poetry Analysis (Class 12)", ch_ENG_12_2_1_2, "Tone, Alliteration & Poetic Devices");

        // Unit: Unit 2: Short Stories & Supplementary Reader
        Unit u_ENG_12_2_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Short Stories & Supplementary Reader", 2, "English", board, classLevel)));

        // Chapter: Supplementary Fiction (Class 12)
        Chapter ch_ENG_12_2_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 2: Short Stories & Supplementary Reader", 3, "Supplementary Fiction (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 2: Short Stories & Supplementary Reader", "Supplementary Fiction (Class 12)", ch_ENG_12_2_2_3, "Plot Structure & Conflict");

        // Chapter: Drama & Dialogue (Class 12)
        Chapter ch_ENG_12_2_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 2: Short Stories & Supplementary Reader", 4, "Drama & Dialogue (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 2: Short Stories & Supplementary Reader", "Drama & Dialogue (Class 12)", ch_ENG_12_2_2_4, "Dramatic Irony & Staging");

        // Unit: Unit 3: Professional Communication & Writing Skills
        Unit u_ENG_12_2_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "English")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Professional Communication & Writing Skills", 3, "English", board, classLevel)));

        // Chapter: Formal Essays & Letter to Editor (Class 12)
        Chapter ch_ENG_12_2_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 3: Professional Communication & Writing Skills", 5, "Formal Essays & Letter to Editor (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 3: Professional Communication & Writing Skills", "Formal Essays & Letter to Editor (Class 12)", ch_ENG_12_2_3_5, "Cohesion, Modifiers & Argumentation");

        // Chapter: Report Writing & Summary Making (Class 12)
        Chapter ch_ENG_12_2_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "English", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("English", "Unit 3: Professional Communication & Writing Skills", 6, "Report Writing & Summary Making (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "English", "Unit 3: Professional Communication & Writing Skills", "Report Writing & Summary Making (Class 12)", ch_ENG_12_2_3_6, "Precision, Note-Making & Formatting");

        // Subject: Physics
        Subject sub_PHY_12_3 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Physics")
                .orElseGet(() -> subjectRepository.save(new Subject("Physics", "PHY", "⚡", "#3867d6", board, classLevel)));

        // Unit: Unit 1: Electrostatics
        Unit u_PHY_12_3_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Physics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Electrostatics", 1, "Physics", board, classLevel)));

        // Chapter: Coulomb's Law, Electric Field & Gauss's Law
        Chapter ch_PHY_12_3_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Physics", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Physics", "Unit 1: Electrostatics", 1, "Coulomb's Law, Electric Field & Gauss's Law", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Physics", "Unit 1: Electrostatics", "Coulomb's Law, Electric Field & Gauss's Law", ch_PHY_12_3_1_1, "Electric Dipole, Potential & Capacitance");

        // Unit: Unit 2: Current Electricity
        Unit u_PHY_12_3_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Physics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Current Electricity", 2, "Physics", board, classLevel)));

        // Chapter: Ohm's Law, Kirchhoff's Rules & Wheatstone Bridge
        Chapter ch_PHY_12_3_2_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Physics", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Physics", "Unit 2: Current Electricity", 2, "Ohm's Law, Kirchhoff's Rules & Wheatstone Bridge", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Physics", "Unit 2: Current Electricity", "Ohm's Law, Kirchhoff's Rules & Wheatstone Bridge", ch_PHY_12_3_2_2, "Potentiometer, Drift Velocity & Colour Code");

        // Unit: Unit 3: Magnetism & Magnetic Effects of Current
        Unit u_PHY_12_3_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Physics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Magnetism & Magnetic Effects of Current", 3, "Physics", board, classLevel)));

        // Chapter: Biot-Savart Law, Ampere's Law & Cyclotron
        Chapter ch_PHY_12_3_3_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Physics", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Physics", "Unit 3: Magnetism & Magnetic Effects of Current", 3, "Biot-Savart Law, Ampere's Law & Cyclotron", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Physics", "Unit 3: Magnetism & Magnetic Effects of Current", "Biot-Savart Law, Ampere's Law & Cyclotron", ch_PHY_12_3_3_3, "Lorentz Force, Moving Coil Galvanometer & Magnetic Dipole");

        // Unit: Unit 4: Electromagnetic Induction & Alternating Current
        Unit u_PHY_12_3_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Physics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Electromagnetic Induction & Alternating Current", 4, "Physics", board, classLevel)));

        // Chapter: Faraday's Laws, Lenz's Law, AC Generator & LCR Circuit
        Chapter ch_PHY_12_3_4_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Physics", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Physics", "Unit 4: Electromagnetic Induction & Alternating Current", 4, "Faraday's Laws, Lenz's Law, AC Generator & LCR Circuit", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Physics", "Unit 4: Electromagnetic Induction & Alternating Current", "Faraday's Laws, Lenz's Law, AC Generator & LCR Circuit", ch_PHY_12_3_4_4, "Self/Mutual Induction, Power Factor & Resonance");

        // Unit: Unit 5: Electromagnetic Waves & Optics
        Unit u_PHY_12_3_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Physics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 5: Electromagnetic Waves & Optics", 5, "Physics", board, classLevel)));

        // Chapter: EM Spectrum, Wave Optics & Ray Optics
        Chapter ch_PHY_12_3_5_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Physics", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Physics", "Unit 5: Electromagnetic Waves & Optics", 5, "EM Spectrum, Wave Optics & Ray Optics", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Physics", "Unit 5: Electromagnetic Waves & Optics", "EM Spectrum, Wave Optics & Ray Optics", ch_PHY_12_3_5_5, "Huygens' Principle, Interference, Diffraction, Polarization & Lenses");

        // Unit: Unit 6: Dual Nature of Radiation & Atomic Physics
        Unit u_PHY_12_3_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Physics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 6: Dual Nature of Radiation & Atomic Physics", 6, "Physics", board, classLevel)));

        // Chapter: Photoelectric Effect, Bohr Model & Hydrogen Spectrum
        Chapter ch_PHY_12_3_6_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Physics", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Physics", "Unit 6: Dual Nature of Radiation & Atomic Physics", 6, "Photoelectric Effect, Bohr Model & Hydrogen Spectrum", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Physics", "Unit 6: Dual Nature of Radiation & Atomic Physics", "Photoelectric Effect, Bohr Model & Hydrogen Spectrum", ch_PHY_12_3_6_6, "Einstein's Equation, de Broglie Wavelength & Energy Levels");

        // Unit: Unit 7: Nuclear Physics
        Unit u_PHY_12_3_7 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Physics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 7).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 7: Nuclear Physics", 7, "Physics", board, classLevel)));

        // Chapter: Radioactivity, Mass Defect, Fission & Fusion
        Chapter ch_PHY_12_3_7_7 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Physics", 7)
                .orElseGet(() -> chapterRepository.save(new Chapter("Physics", "Unit 7: Nuclear Physics", 7, "Radioactivity, Mass Defect, Fission & Fusion", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Physics", "Unit 7: Nuclear Physics", "Radioactivity, Mass Defect, Fission & Fusion", ch_PHY_12_3_7_7, "Half-life, Binding Energy Curve & Nuclear Reactors");

        // Unit: Unit 8: Semiconductor Electronics & Communication
        Unit u_PHY_12_3_8 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Physics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 8).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 8: Semiconductor Electronics & Communication", 8, "Physics", board, classLevel)));

        // Chapter: p-n Junction Diode, Transistors & Logic Gates
        Chapter ch_PHY_12_3_8_8 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Physics", 8)
                .orElseGet(() -> chapterRepository.save(new Chapter("Physics", "Unit 8: Semiconductor Electronics & Communication", 8, "p-n Junction Diode, Transistors & Logic Gates", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Physics", "Unit 8: Semiconductor Electronics & Communication", "p-n Junction Diode, Transistors & Logic Gates", ch_PHY_12_3_8_8, "Rectifiers, Amplifiers, AND/OR/NAND/NOR gates & Modulation");

        // Subject: Chemistry
        Subject sub_CHEM_12_4 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Chemistry")
                .orElseGet(() -> subjectRepository.save(new Subject("Chemistry", "CHEM", "🧪", "#8854d0", board, classLevel)));

        // Unit: Unit 1: Metallurgy & Solid State
        Unit u_CHEM_12_4_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Chemistry")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Metallurgy & Solid State", 1, "Chemistry", board, classLevel)));

        // Chapter: Extraction of Metals & Crystal Lattices
        Chapter ch_CHEM_12_4_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Chemistry", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Chemistry", "Unit 1: Metallurgy & Solid State", 1, "Extraction of Metals & Crystal Lattices", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Chemistry", "Unit 1: Metallurgy & Solid State", "Extraction of Metals & Crystal Lattices", ch_CHEM_12_4_1_1, "Ellingham Diagram, Unit Cells, Packing Efficiency & Defects");

        // Unit: Unit 2: p-Block, d-Block & Coordination Chemistry
        Unit u_CHEM_12_4_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Chemistry")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: p-Block, d-Block & Coordination Chemistry", 2, "Chemistry", board, classLevel)));

        // Chapter: Transition Elements, Lanthanoids & Coordination Complexes
        Chapter ch_CHEM_12_4_2_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Chemistry", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Chemistry", "Unit 2: p-Block, d-Block & Coordination Chemistry", 2, "Transition Elements, Lanthanoids & Coordination Complexes", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Chemistry", "Unit 2: p-Block, d-Block & Coordination Chemistry", "Transition Elements, Lanthanoids & Coordination Complexes", ch_CHEM_12_4_2_2, "Werner's Theory, Crystal Field Theory & Isomerism");

        // Unit: Unit 3: Chemical Kinetics & Electrochemistry
        Unit u_CHEM_12_4_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Chemistry")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Chemical Kinetics & Electrochemistry", 3, "Chemistry", board, classLevel)));

        // Chapter: Rate Laws, Arrhenius Equation & Nernst Equation
        Chapter ch_CHEM_12_4_3_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Chemistry", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Chemistry", "Unit 3: Chemical Kinetics & Electrochemistry", 3, "Rate Laws, Arrhenius Equation & Nernst Equation", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Chemistry", "Unit 3: Chemical Kinetics & Electrochemistry", "Rate Laws, Arrhenius Equation & Nernst Equation", ch_CHEM_12_4_3_3, "Order of Reaction, Galvanic Cells, Kohlrausch Law & Batteries");

        // Unit: Unit 4: Surface Chemistry & Ionic Equilibrium
        Unit u_CHEM_12_4_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Chemistry")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Surface Chemistry & Ionic Equilibrium", 4, "Chemistry", board, classLevel)));

        // Chapter: Adsorption, Colloids & Buffer Solutions
        Chapter ch_CHEM_12_4_4_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Chemistry", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Chemistry", "Unit 4: Surface Chemistry & Ionic Equilibrium", 4, "Adsorption, Colloids & Buffer Solutions", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Chemistry", "Unit 4: Surface Chemistry & Ionic Equilibrium", "Adsorption, Colloids & Buffer Solutions", ch_CHEM_12_4_4_4, "Freundlich Isotherm, Henderson Equation & Solubility Product");

        // Unit: Unit 5: Organic Compounds – Carbonyls, Amines & Biomolecules
        Unit u_CHEM_12_4_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Chemistry")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 5: Organic Compounds – Carbonyls, Amines & Biomolecules", 5, "Chemistry", board, classLevel)));

        // Chapter: Aldehydes, Ketones, Carboxylic Acids, Diazonium & Proteins
        Chapter ch_CHEM_12_4_5_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Chemistry", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Chemistry", "Unit 5: Organic Compounds – Carbonyls, Amines & Biomolecules", 5, "Aldehydes, Ketones, Carboxylic Acids, Diazonium & Proteins", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Chemistry", "Unit 5: Organic Compounds – Carbonyls, Amines & Biomolecules", "Aldehydes, Ketones, Carboxylic Acids, Diazonium & Proteins", ch_CHEM_12_4_5_5, "Cannizzaro, Aldol, Gabriel Phthalimide, Amino acids & Nucleic Acids");

        // Subject: Mathematics
        Subject sub_MATH_12_5 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Mathematics")
                .orElseGet(() -> subjectRepository.save(new Subject("Mathematics", "MATH", "📐", "#4834d4", board, classLevel)));

        // Unit: Unit 1: Applications of Matrices and Determinants
        Unit u_MATH_12_5_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Applications of Matrices and Determinants", 1, "Mathematics", board, classLevel)));

        // Chapter: Matrix Inverse, Rank & System of Equations
        Chapter ch_MATH_12_5_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 1: Applications of Matrices and Determinants", 1, "Matrix Inverse, Rank & System of Equations", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 1: Applications of Matrices and Determinants", "Matrix Inverse, Rank & System of Equations", ch_MATH_12_5_1_1, "Cramer's Rule & Gaussian Elimination");

        // Unit: Unit 2: Complex Numbers & Theory of Equations
        Unit u_MATH_12_5_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Complex Numbers & Theory of Equations", 2, "Mathematics", board, classLevel)));

        // Chapter: De Moivre's Theorem, Roots of Unity & Polynomial Roots
        Chapter ch_MATH_12_5_2_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 2: Complex Numbers & Theory of Equations", 2, "De Moivre's Theorem, Roots of Unity & Polynomial Roots", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 2: Complex Numbers & Theory of Equations", "De Moivre's Theorem, Roots of Unity & Polynomial Roots", ch_MATH_12_5_2_2, "Polar Form, Euler's Formula & Vieta's Relations");

        // Unit: Unit 3: 2D Analytical Geometry-II & Vector Applications
        Unit u_MATH_12_5_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: 2D Analytical Geometry-II & Vector Applications", 3, "Mathematics", board, classLevel)));

        // Chapter: Conic Sections (Parabola, Ellipse, Hyperbola) & 3D Vectors
        Chapter ch_MATH_12_5_3_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 3: 2D Analytical Geometry-II & Vector Applications", 3, "Conic Sections (Parabola, Ellipse, Hyperbola) & 3D Vectors", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 3: 2D Analytical Geometry-II & Vector Applications", "Conic Sections (Parabola, Ellipse, Hyperbola) & 3D Vectors", ch_MATH_12_5_3_3, "Skew Lines, Shortest Distance & Equation of Planes");

        // Unit: Unit 4: Differential Calculus & Integration Applications
        Unit u_MATH_12_5_4 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 4).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 4: Differential Calculus & Integration Applications", 4, "Mathematics", board, classLevel)));

        // Chapter: Tangents, Maxima/Minima & Definite Integrals
        Chapter ch_MATH_12_5_4_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 4: Differential Calculus & Integration Applications", 4, "Tangents, Maxima/Minima & Definite Integrals", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 4: Differential Calculus & Integration Applications", "Tangents, Maxima/Minima & Definite Integrals", ch_MATH_12_5_4_4, "Rolle's / Lagrange's Theorems, Area Under Curve");

        // Unit: Unit 5: Ordinary Differential Equations
        Unit u_MATH_12_5_5 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 5).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 5: Ordinary Differential Equations", 5, "Mathematics", board, classLevel)));

        // Chapter: First Order Linear DE & Variable Separable
        Chapter ch_MATH_12_5_5_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 5: Ordinary Differential Equations", 5, "First Order Linear DE & Variable Separable", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 5: Ordinary Differential Equations", "First Order Linear DE & Variable Separable", ch_MATH_12_5_5_5, "Integrating Factor & Application Models");

        // Unit: Unit 6: Probability Distributions & Discrete Mathematics
        Unit u_MATH_12_5_6 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 6).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 6: Probability Distributions & Discrete Mathematics", 6, "Mathematics", board, classLevel)));

        // Chapter: Binomial, Poisson Distributions & Boolean Logic
        Chapter ch_MATH_12_5_6_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Mathematics", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Mathematics", "Unit 6: Probability Distributions & Discrete Mathematics", 6, "Binomial, Poisson Distributions & Boolean Logic", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Mathematics", "Unit 6: Probability Distributions & Discrete Mathematics", "Binomial, Poisson Distributions & Boolean Logic", ch_MATH_12_5_6_6, "Expected Value, Variance, Truth Tables & Group Theory");

        // Subject: Biology
        Subject sub_BIO_12_6 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Biology")
                .orElseGet(() -> subjectRepository.save(new Subject("Biology", "BIO", "🧬", "#20bf6b", board, classLevel)));

        // Unit: Unit 1: Diversity & Plant Morphology
        Unit u_BIO_12_6_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Biology")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Diversity & Plant Morphology", 1, "Biology", board, classLevel)));

        // Chapter: Living World & Plant Anatomy (Class 12)
        Chapter ch_BIO_12_6_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Biology", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Biology", "Unit 1: Diversity & Plant Morphology", 1, "Living World & Plant Anatomy (Class 12)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Biology", "Unit 1: Diversity & Plant Morphology", "Living World & Plant Anatomy (Class 12)", ch_BIO_12_6_1_1, "Taxonomy, Floral Formulas & Meristems");

        // Chapter: Plant Physiology & Photosynthesis (Class 12)
        Chapter ch_BIO_12_6_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Biology", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Biology", "Unit 1: Diversity & Plant Morphology", 2, "Plant Physiology & Photosynthesis (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Biology", "Unit 1: Diversity & Plant Morphology", "Plant Physiology & Photosynthesis (Class 12)", ch_BIO_12_6_1_2, "C3/C4 Cycles, Respiration & Plant Hormones");

        // Unit: Unit 2: Animal Systems & Human Physiology
        Unit u_BIO_12_6_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Biology")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Animal Systems & Human Physiology", 2, "Biology", board, classLevel)));

        // Chapter: Human Digestion, Circulation & Excretion (Class 12)
        Chapter ch_BIO_12_6_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Biology", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Biology", "Unit 2: Animal Systems & Human Physiology", 3, "Human Digestion, Circulation & Excretion (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Biology", "Unit 2: Animal Systems & Human Physiology", "Human Digestion, Circulation & Excretion (Class 12)", ch_BIO_12_6_2_3, "Heart, Nephron & Neural Transmission");

        // Chapter: Endocrine Coordination & Reproduction (Class 12)
        Chapter ch_BIO_12_6_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Biology", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Biology", "Unit 2: Animal Systems & Human Physiology", 4, "Endocrine Coordination & Reproduction (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Biology", "Unit 2: Animal Systems & Human Physiology", "Endocrine Coordination & Reproduction (Class 12)", ch_BIO_12_6_2_4, "Hormonal Cascades & Gametogenesis");

        // Unit: Unit 3: Genetics, Biotechnology & Ecology
        Unit u_BIO_12_6_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Biology")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Genetics, Biotechnology & Ecology", 3, "Biology", board, classLevel)));

        // Chapter: Molecular Genetics & Gene Expression (Class 12)
        Chapter ch_BIO_12_6_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Biology", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Biology", "Unit 3: Genetics, Biotechnology & Ecology", 5, "Molecular Genetics & Gene Expression (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Biology", "Unit 3: Genetics, Biotechnology & Ecology", "Molecular Genetics & Gene Expression (Class 12)", ch_BIO_12_6_3_5, "DNA Replication, Transcription & Translation");

        // Chapter: Recombinant DNA & Environmental Conservation (Class 12)
        Chapter ch_BIO_12_6_3_6 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Biology", 6)
                .orElseGet(() -> chapterRepository.save(new Chapter("Biology", "Unit 3: Genetics, Biotechnology & Ecology", 6, "Recombinant DNA & Environmental Conservation (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Biology", "Unit 3: Genetics, Biotechnology & Ecology", "Recombinant DNA & Environmental Conservation (Class 12)", ch_BIO_12_6_3_6, "PCR, Plasmids, Bioremediation & Ecosystems");

        // Subject: Botany
        Subject sub_BOT_12_7 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Botany")
                .orElseGet(() -> subjectRepository.save(new Subject("Botany", "BOT", "🌱", "#26de81", board, classLevel)));

        // Unit: Unit 1: Plant Taxonomy & Cell Biology
        Unit u_BOT_12_7_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Botany")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Plant Taxonomy & Cell Biology", 1, "Botany", board, classLevel)));

        // Chapter: Taxonomy of Angiosperms & Cell Structure (Class 12)
        Chapter ch_BOT_12_7_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Botany", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Botany", "Unit 1: Plant Taxonomy & Cell Biology", 1, "Taxonomy of Angiosperms & Cell Structure (Class 12)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Botany", "Unit 1: Plant Taxonomy & Cell Biology", "Taxonomy of Angiosperms & Cell Structure (Class 12)", ch_BOT_12_7_1_1, "Bentham & Hooker, Floral Anatomy & Organelles");

        // Unit: Unit 2: Plant Physiology & Plant Breeding
        Unit u_BOT_12_7_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Botany")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Plant Physiology & Plant Breeding", 2, "Botany", board, classLevel)));

        // Chapter: Mineral Nutrition, Photosynthesis & Hybridisation (Class 12)
        Chapter ch_BOT_12_7_2_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Botany", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Botany", "Unit 2: Plant Physiology & Plant Breeding", 2, "Mineral Nutrition, Photosynthesis & Hybridisation (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Botany", "Unit 2: Plant Physiology & Plant Breeding", "Mineral Nutrition, Photosynthesis & Hybridisation (Class 12)", ch_BOT_12_7_2_2, "Nitrogen Fixation, Calvin Cycle & Crop Improvement");

        // Unit: Unit 3: Plant Biotechnology & Ecology
        Unit u_BOT_12_7_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Botany")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Plant Biotechnology & Ecology", 3, "Botany", board, classLevel)));

        // Chapter: Tissue Culture, Genetic Engineering & Ecological Succession (Class 12)
        Chapter ch_BOT_12_7_3_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Botany", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Botany", "Unit 3: Plant Biotechnology & Ecology", 3, "Tissue Culture, Genetic Engineering & Ecological Succession (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Botany", "Unit 3: Plant Biotechnology & Ecology", "Tissue Culture, Genetic Engineering & Ecological Succession (Class 12)", ch_BOT_12_7_3_3, "Callus Culture, Vector Biology & Ecosystem Energy");

        // Subject: Zoology
        Subject sub_ZOO_12_8 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Zoology")
                .orElseGet(() -> subjectRepository.save(new Subject("Zoology", "ZOO", "🐾", "#fed330", board, classLevel)));

        // Unit: Unit 1: Animal Diversity & Human Systems
        Unit u_ZOO_12_8_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Zoology")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Animal Diversity & Human Systems", 1, "Zoology", board, classLevel)));

        // Chapter: Animal Classification & Human Organ Systems (Class 12)
        Chapter ch_ZOO_12_8_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Zoology", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Zoology", "Unit 1: Animal Diversity & Human Systems", 1, "Animal Classification & Human Organ Systems (Class 12)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Zoology", "Unit 1: Animal Diversity & Human Systems", "Animal Classification & Human Organ Systems (Class 12)", ch_ZOO_12_8_1_1, "Chordates, Nervous System & Cardio-vascular Dynamics");

        // Unit: Unit 2: Genetics, Immunology & Health
        Unit u_ZOO_12_8_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Zoology")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Genetics, Immunology & Health", 2, "Zoology", board, classLevel)));

        // Chapter: Mendelian Inheritance, Antibodies & Disease Prevention (Class 12)
        Chapter ch_ZOO_12_8_2_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Zoology", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Zoology", "Unit 2: Genetics, Immunology & Health", 2, "Mendelian Inheritance, Antibodies & Disease Prevention (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Zoology", "Unit 2: Genetics, Immunology & Health", "Mendelian Inheritance, Antibodies & Disease Prevention (Class 12)", ch_ZOO_12_8_2_2, "Chromosomal Aberrations, Vaccines & Autoimmunity");

        // Unit: Unit 3: Applied Zoology & Environmental Conservation
        Unit u_ZOO_12_8_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Zoology")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Applied Zoology & Environmental Conservation", 3, "Zoology", board, classLevel)));

        // Chapter: Sericulture, Aquaculture & Wildlife Preservation (Class 12)
        Chapter ch_ZOO_12_8_3_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Zoology", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Zoology", "Unit 3: Applied Zoology & Environmental Conservation", 3, "Sericulture, Aquaculture & Wildlife Preservation (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Zoology", "Unit 3: Applied Zoology & Environmental Conservation", "Sericulture, Aquaculture & Wildlife Preservation (Class 12)", ch_ZOO_12_8_3_3, "Economic Culture Methods & Endangered Species Protection");

        // Subject: Computer Science
        Subject sub_CS_12_9 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Computer Science")
                .orElseGet(() -> subjectRepository.save(new Subject("Computer Science", "CS", "💻", "#2d98da", board, classLevel)));

        // Unit: Unit 1: Computer Fundamentals & Programming in Python
        Unit u_CS_12_9_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Computer Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Computer Fundamentals & Programming in Python", 1, "Computer Science", board, classLevel)));

        // Chapter: Python Fundamentals, Data Types & Control Flow (Class 12)
        Chapter ch_CS_12_9_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Computer Science", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Computer Science", "Unit 1: Computer Fundamentals & Programming in Python", 1, "Python Fundamentals, Data Types & Control Flow (Class 12)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Computer Science", "Unit 1: Computer Fundamentals & Programming in Python", "Python Fundamentals, Data Types & Control Flow (Class 12)", ch_CS_12_9_1_1, "Variables, Loops, Functions & Recursion");

        // Chapter: Data Structures – Lists, Tuples, Sets, Dictionaries (Class 12)
        Chapter ch_CS_12_9_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Computer Science", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Computer Science", "Unit 1: Computer Fundamentals & Programming in Python", 2, "Data Structures – Lists, Tuples, Sets, Dictionaries (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Computer Science", "Unit 1: Computer Fundamentals & Programming in Python", "Data Structures – Lists, Tuples, Sets, Dictionaries (Class 12)", ch_CS_12_9_1_2, "Operations, Slicing & Comprehensions");

        // Unit: Unit 2: Object Oriented Programming & Algorithms
        Unit u_CS_12_9_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Computer Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Object Oriented Programming & Algorithms", 2, "Computer Science", board, classLevel)));

        // Chapter: Classes, Objects, Inheritance & Algorithmic Analysis (Class 12)
        Chapter ch_CS_12_9_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Computer Science", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Computer Science", "Unit 2: Object Oriented Programming & Algorithms", 3, "Classes, Objects, Inheritance & Algorithmic Analysis (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Computer Science", "Unit 2: Object Oriented Programming & Algorithms", "Classes, Objects, Inheritance & Algorithmic Analysis (Class 12)", ch_CS_12_9_2_3, "Encapsulation, Time Complexity & Searching/Sorting");

        // Unit: Unit 3: Database Concepts, SQL & Web Security
        Unit u_CS_12_9_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Computer Science")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Database Concepts, SQL & Web Security", 3, "Computer Science", board, classLevel)));

        // Chapter: RDBMS Concepts, SQL Queries & Python-DB Integration (Class 12)
        Chapter ch_CS_12_9_3_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Computer Science", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Computer Science", "Unit 3: Database Concepts, SQL & Web Security", 4, "RDBMS Concepts, SQL Queries & Python-DB Integration (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Computer Science", "Unit 3: Database Concepts, SQL & Web Security", "RDBMS Concepts, SQL Queries & Python-DB Integration (Class 12)", ch_CS_12_9_3_4, "DDL, DML, Joins, SQLite & MySQL Interface");

        // Chapter: Cyber Ethics, Cyber Security & Tamil Computing (Class 12)
        Chapter ch_CS_12_9_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Computer Science", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Computer Science", "Unit 3: Database Concepts, SQL & Web Security", 5, "Cyber Ethics, Cyber Security & Tamil Computing (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Computer Science", "Unit 3: Database Concepts, SQL & Web Security", "Cyber Ethics, Cyber Security & Tamil Computing (Class 12)", ch_CS_12_9_3_5, "Firewalls, Phishing, Unicode, Tamil Keyboards & Open Source");

        // Subject: Computer Applications
        Subject sub_CA_12_10 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Computer Applications")
                .orElseGet(() -> subjectRepository.save(new Subject("Computer Applications", "CA", "🖥️", "#4b6584", board, classLevel)));

        // Unit: Unit 1: Multimedia, Desktop Publishing & Web Design
        Unit u_CA_12_10_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Computer Applications")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Multimedia, Desktop Publishing & Web Design", 1, "Computer Applications", board, classLevel)));

        // Chapter: Adobe PageMaker & Multimedia Production (Class 12)
        Chapter ch_CA_12_10_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Computer Applications", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Computer Applications", "Unit 1: Multimedia, Desktop Publishing & Web Design", 1, "Adobe PageMaker & Multimedia Production (Class 12)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Computer Applications", "Unit 1: Multimedia, Desktop Publishing & Web Design", "Adobe PageMaker & Multimedia Production (Class 12)", ch_CA_12_10_1_1, "Page Layout, Typography, Audio/Video Integration");

        // Chapter: HTML5, CSS & JavaScript Fundamentals (Class 12)
        Chapter ch_CA_12_10_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Computer Applications", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Computer Applications", "Unit 1: Multimedia, Desktop Publishing & Web Design", 2, "HTML5, CSS & JavaScript Fundamentals (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Computer Applications", "Unit 1: Multimedia, Desktop Publishing & Web Design", "HTML5, CSS & JavaScript Fundamentals (Class 12)", ch_CA_12_10_1_2, "Forms, Styling, DOM Manipulation & Event Handlers");

        // Unit: Unit 2: Server-side Scripting with PHP & MySQL
        Unit u_CA_12_10_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Computer Applications")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Server-side Scripting with PHP & MySQL", 2, "Computer Applications", board, classLevel)));

        // Chapter: PHP Variables, Control Structures & MySQL Connectivity (Class 12)
        Chapter ch_CA_12_10_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Computer Applications", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Computer Applications", "Unit 2: Server-side Scripting with PHP & MySQL", 3, "PHP Variables, Control Structures & MySQL Connectivity (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Computer Applications", "Unit 2: Server-side Scripting with PHP & MySQL", "PHP Variables, Control Structures & MySQL Connectivity (Class 12)", ch_CA_12_10_2_3, "Session Handling, Form Validation & Database CRUD");

        // Unit: Unit 3: E-Commerce, Networks & Information Security
        Unit u_CA_12_10_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Computer Applications")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: E-Commerce, Networks & Information Security", 3, "Computer Applications", board, classLevel)));

        // Chapter: E-Commerce Models, Electronic Payment Systems & Cyber Law (Class 12)
        Chapter ch_CA_12_10_3_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Computer Applications", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Computer Applications", "Unit 3: E-Commerce, Networks & Information Security", 4, "E-Commerce Models, Electronic Payment Systems & Cyber Law (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Computer Applications", "Unit 3: E-Commerce, Networks & Information Security", "E-Commerce Models, Electronic Payment Systems & Cyber Law (Class 12)", ch_CA_12_10_3_4, "B2B, B2C, UPI, Payment Gateways & IT Act Provisions");

        // Subject: Accountancy
        Subject sub_ACC_12_11 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Accountancy")
                .orElseGet(() -> subjectRepository.save(new Subject("Accountancy", "ACC", "📋", "#2bcbba", board, classLevel)));

        // Unit: Unit 1: Financial Accounting Principles & Final Accounts
        Unit u_ACC_12_11_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Accountancy")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Financial Accounting Principles & Final Accounts", 1, "Accountancy", board, classLevel)));

        // Chapter: Accounting Concepts, Journal, Ledger & Trial Balance (Class 12)
        Chapter ch_ACC_12_11_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Accountancy", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Accountancy", "Unit 1: Financial Accounting Principles & Final Accounts", 1, "Accounting Concepts, Journal, Ledger & Trial Balance (Class 12)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Accountancy", "Unit 1: Financial Accounting Principles & Final Accounts", "Accounting Concepts, Journal, Ledger & Trial Balance (Class 12)", ch_ACC_12_11_1_1, "Double Entry System & Reconciliation");

        // Chapter: Final Accounts of Sole Proprietors & Incomplete Records (Class 12)
        Chapter ch_ACC_12_11_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Accountancy", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Accountancy", "Unit 1: Financial Accounting Principles & Final Accounts", 2, "Final Accounts of Sole Proprietors & Incomplete Records (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Accountancy", "Unit 1: Financial Accounting Principles & Final Accounts", "Final Accounts of Sole Proprietors & Incomplete Records (Class 12)", ch_ACC_12_11_1_2, "Trading, P&L Account, Balance Sheet & Single Entry Conversion");

        // Unit: Unit 2: Partnership Accounts & Company Accounts
        Unit u_ACC_12_11_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Accountancy")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Partnership Accounts & Company Accounts", 2, "Accountancy", board, classLevel)));

        // Chapter: Partnership Fundamentals, Admission, Retirement & Dissolution (Class 12)
        Chapter ch_ACC_12_11_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Accountancy", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Accountancy", "Unit 2: Partnership Accounts & Company Accounts", 3, "Partnership Fundamentals, Admission, Retirement & Dissolution (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Accountancy", "Unit 2: Partnership Accounts & Company Accounts", "Partnership Fundamentals, Admission, Retirement & Dissolution (Class 12)", ch_ACC_12_11_2_3, "Goodwill Valuation, Revaluation & Capital Adjustments");

        // Chapter: Issue of Shares, Debentures & Financial Statement Analysis (Class 12)
        Chapter ch_ACC_12_11_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Accountancy", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Accountancy", "Unit 2: Partnership Accounts & Company Accounts", 4, "Issue of Shares, Debentures & Financial Statement Analysis (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Accountancy", "Unit 2: Partnership Accounts & Company Accounts", "Issue of Shares, Debentures & Financial Statement Analysis (Class 12)", ch_ACC_12_11_2_4, "Forfeiture, Reissue, Comparative Statements & Accounting Ratios");

        // Unit: Unit 3: Computerised Accounting System
        Unit u_ACC_12_11_3 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Accountancy")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 3).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 3: Computerised Accounting System", 3, "Accountancy", board, classLevel)));

        // Chapter: Computerised Accounting Software & Tally Configuration (Class 12)
        Chapter ch_ACC_12_11_3_5 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Accountancy", 5)
                .orElseGet(() -> chapterRepository.save(new Chapter("Accountancy", "Unit 3: Computerised Accounting System", 5, "Computerised Accounting Software & Tally Configuration (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Accountancy", "Unit 3: Computerised Accounting System", "Computerised Accounting Software & Tally Configuration (Class 12)", ch_ACC_12_11_3_5, "Voucher Entry, Ledgers, Reports & GST Invoicing");

        // Subject: Commerce
        Subject sub_COMM_12_12 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Commerce")
                .orElseGet(() -> subjectRepository.save(new Subject("Commerce", "COMM", "💼", "#ff9f43", board, classLevel)));

        // Unit: Unit 1: Forms of Business Organisation & Management
        Unit u_COMM_12_12_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Commerce")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Forms of Business Organisation & Management", 1, "Commerce", board, classLevel)));

        // Chapter: Sole Proprietorship, Partnership & Joint Stock Companies (Class 12)
        Chapter ch_COMM_12_12_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Commerce", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Commerce", "Unit 1: Forms of Business Organisation & Management", 1, "Sole Proprietorship, Partnership & Joint Stock Companies (Class 12)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Commerce", "Unit 1: Forms of Business Organisation & Management", "Sole Proprietorship, Partnership & Joint Stock Companies (Class 12)", ch_COMM_12_12_1_1, "Formation, Memorandum, Articles & Management Principles");

        // Chapter: Principles of Scientific Management & Planning/Organising (Class 12)
        Chapter ch_COMM_12_12_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Commerce", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Commerce", "Unit 1: Forms of Business Organisation & Management", 2, "Principles of Scientific Management & Planning/Organising (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Commerce", "Unit 1: Forms of Business Organisation & Management", "Principles of Scientific Management & Planning/Organising (Class 12)", ch_COMM_12_12_1_2, "Fayol's 14 Principles, Taylor's Scientific Approach");

        // Unit: Unit 2: Financial Markets, Marketing & Consumer Protection
        Unit u_COMM_12_12_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Commerce")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Financial Markets, Marketing & Consumer Protection", 2, "Commerce", board, classLevel)));

        // Chapter: Capital Market, Money Market & SEBI Regulations (Class 12)
        Chapter ch_COMM_12_12_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Commerce", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Commerce", "Unit 2: Financial Markets, Marketing & Consumer Protection", 3, "Capital Market, Money Market & SEBI Regulations (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Commerce", "Unit 2: Financial Markets, Marketing & Consumer Protection", "Capital Market, Money Market & SEBI Regulations (Class 12)", ch_COMM_12_12_2_3, "Stock Exchanges, Treasury Bills, Primary/Secondary Markets");

        // Chapter: Modern Marketing, 4Ps, E-Commerce & Consumer Rights (Class 12)
        Chapter ch_COMM_12_12_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Commerce", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Commerce", "Unit 2: Financial Markets, Marketing & Consumer Protection", 4, "Modern Marketing, 4Ps, E-Commerce & Consumer Rights (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Commerce", "Unit 2: Financial Markets, Marketing & Consumer Protection", "Modern Marketing, 4Ps, E-Commerce & Consumer Rights (Class 12)", ch_COMM_12_12_2_4, "Consumer Protection Act, Redressal Forums & Marketing Ethics");

        // Subject: Economics
        Subject sub_ECO_12_13 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Economics")
                .orElseGet(() -> subjectRepository.save(new Subject("Economics", "ECO", "📈", "#ee5253", board, classLevel)));

        // Unit: Unit 1: Microeconomics & National Income
        Unit u_ECO_12_13_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Economics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Microeconomics & National Income", 1, "Economics", board, classLevel)));

        // Chapter: Consumer Behavior, Demand, Supply & Market Equilibrium (Class 12)
        Chapter ch_ECO_12_13_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Economics", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Economics", "Unit 1: Microeconomics & National Income", 1, "Consumer Behavior, Demand, Supply & Market Equilibrium (Class 12)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Economics", "Unit 1: Microeconomics & National Income", "Consumer Behavior, Demand, Supply & Market Equilibrium (Class 12)", ch_ECO_12_13_1_1, "Law of Demand, Elasticity, Indifference Curves & Cost/Revenue");

        // Chapter: National Income Accounting & Circular Flow of Income (Class 12)
        Chapter ch_ECO_12_13_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Economics", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Economics", "Unit 1: Microeconomics & National Income", 2, "National Income Accounting & Circular Flow of Income (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Economics", "Unit 1: Microeconomics & National Income", "National Income Accounting & Circular Flow of Income (Class 12)", ch_ECO_12_13_1_2, "GDP, GNP, NNP, Real vs Nominal GDP & Sectoral Output");

        // Unit: Unit 2: Monetary Policy, Public Finance & Tamil Nadu Economy
        Unit u_ECO_12_13_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Economics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Monetary Policy, Public Finance & Tamil Nadu Economy", 2, "Economics", board, classLevel)));

        // Chapter: Money, Banking, Inflation & RBI Monetary Policy (Class 12)
        Chapter ch_ECO_12_13_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Economics", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("Economics", "Unit 2: Monetary Policy, Public Finance & Tamil Nadu Economy", 3, "Money, Banking, Inflation & RBI Monetary Policy (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Economics", "Unit 2: Monetary Policy, Public Finance & Tamil Nadu Economy", "Money, Banking, Inflation & RBI Monetary Policy (Class 12)", ch_ECO_12_13_2_3, "Repo Rate, CRR, Commercial Banks & Fiscal Deficit");

        // Chapter: International Trade, Fiscal Economics & Tamil Nadu Economy (Class 12)
        Chapter ch_ECO_12_13_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Economics", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("Economics", "Unit 2: Monetary Policy, Public Finance & Tamil Nadu Economy", 4, "International Trade, Fiscal Economics & Tamil Nadu Economy (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Economics", "Unit 2: Monetary Policy, Public Finance & Tamil Nadu Economy", "International Trade, Fiscal Economics & Tamil Nadu Economy (Class 12)", ch_ECO_12_13_2_4, "Foreign Exchange, Budget, GST, NITI Aayog & TN Growth Model");

        // Subject: Business Mathematics
        Subject sub_BMATH_12_14 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Business Mathematics")
                .orElseGet(() -> subjectRepository.save(new Subject("Business Mathematics", "BMATH", "🔢", "#341f97", board, classLevel)));

        // Unit: Unit 1: Matrices, Determinants & Financial Mathematics
        Unit u_BMATH_12_14_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Business Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Matrices, Determinants & Financial Mathematics", 1, "Business Mathematics", board, classLevel)));

        // Chapter: Matrix Operations, Input-Output Analysis & Annuities (Class 12)
        Chapter ch_BMATH_12_14_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Business Mathematics", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Business Mathematics", "Unit 1: Matrices, Determinants & Financial Mathematics", 1, "Matrix Operations, Input-Output Analysis & Annuities (Class 12)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Business Mathematics", "Unit 1: Matrices, Determinants & Financial Mathematics", "Matrix Operations, Input-Output Analysis & Annuities (Class 12)", ch_BMATH_12_14_1_1, "Cramer's Rule, Leontief Model, Compound Interest & Sinking Funds");

        // Unit: Unit 2: Differential Calculus, Marginal Analysis & Linear Programming
        Unit u_BMATH_12_14_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Business Mathematics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Differential Calculus, Marginal Analysis & Linear Programming", 2, "Business Mathematics", board, classLevel)));

        // Chapter: Marginal Cost, Revenue Optimisation & Transportation Problems (Class 12)
        Chapter ch_BMATH_12_14_2_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Business Mathematics", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Business Mathematics", "Unit 2: Differential Calculus, Marginal Analysis & Linear Programming", 2, "Marginal Cost, Revenue Optimisation & Transportation Problems (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Business Mathematics", "Unit 2: Differential Calculus, Marginal Analysis & Linear Programming", "Marginal Cost, Revenue Optimisation & Transportation Problems (Class 12)", ch_BMATH_12_14_2_2, "Derivatives, Maxima/Minima, Simplex Method & Assignment");

        // Subject: Statistics
        Subject sub_STAT_12_15 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "Statistics")
                .orElseGet(() -> subjectRepository.save(new Subject("Statistics", "STAT", "📊", "#0abde3", board, classLevel)));

        // Unit: Unit 1: Descriptive Statistics & Probability Distributions
        Unit u_STAT_12_15_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Statistics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Descriptive Statistics & Probability Distributions", 1, "Statistics", board, classLevel)));

        // Chapter: Measures of Central Tendency, Dispersion & Binomial/Normal Curve (Class 12)
        Chapter ch_STAT_12_15_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Statistics", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("Statistics", "Unit 1: Descriptive Statistics & Probability Distributions", 1, "Measures of Central Tendency, Dispersion & Binomial/Normal Curve (Class 12)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Statistics", "Unit 1: Descriptive Statistics & Probability Distributions", "Measures of Central Tendency, Dispersion & Binomial/Normal Curve (Class 12)", ch_STAT_12_15_1_1, "Mean, SD, Skewness, Kurtosis & Normal Probabilities");

        // Unit: Unit 2: Statistical Inference, Time Series & Index Numbers
        Unit u_STAT_12_15_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "Statistics")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Statistical Inference, Time Series & Index Numbers", 2, "Statistics", board, classLevel)));

        // Chapter: Hypothesis Testing, Large/Small Sample Tests & Index Numbers (Class 12)
        Chapter ch_STAT_12_15_2_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "Statistics", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("Statistics", "Unit 2: Statistical Inference, Time Series & Index Numbers", 2, "Hypothesis Testing, Large/Small Sample Tests & Index Numbers (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "Statistics", "Unit 2: Statistical Inference, Time Series & Index Numbers", "Hypothesis Testing, Large/Small Sample Tests & Index Numbers (Class 12)", ch_STAT_12_15_2_2, "Z-test, t-test, Chi-square, Moving Averages & Laspeyres/Paasche");

        // Subject: History
        Subject sub_HIST_12_16 = subjectRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectName(board, classLevel, "History")
                .orElseGet(() -> subjectRepository.save(new Subject("History", "HIST", "🏛️", "#5f27cd", board, classLevel)));

        // Unit: Unit 1: Ancient & Medieval Indian History
        Unit u_HIST_12_16_1 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "History")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 1).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 1: Ancient & Medieval Indian History", 1, "History", board, classLevel)));

        // Chapter: Indus Valley, Vedic Age, Mauryas, Guptas & Chola Empire (Class 12)
        Chapter ch_HIST_12_16_1_1 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "History", 1)
                .orElseGet(() -> chapterRepository.save(new Chapter("History", "Unit 1: Ancient & Medieval Indian History", 1, "Indus Valley, Vedic Age, Mauryas, Guptas & Chola Empire (Class 12)", true, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "History", "Unit 1: Ancient & Medieval Indian History", "Indus Valley, Vedic Age, Mauryas, Guptas & Chola Empire (Class 12)", ch_HIST_12_16_1_1, "State Formation, Art, Architecture, Administration & Overseas Trade");

        // Chapter: Delhi Sultanate, Vijayanagar Kingdom & Mughal Empire (Class 12)
        Chapter ch_HIST_12_16_1_2 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "History", 2)
                .orElseGet(() -> chapterRepository.save(new Chapter("History", "Unit 1: Ancient & Medieval Indian History", 2, "Delhi Sultanate, Vijayanagar Kingdom & Mughal Empire (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "History", "Unit 1: Ancient & Medieval Indian History", "Delhi Sultanate, Vijayanagar Kingdom & Mughal Empire (Class 12)", ch_HIST_12_16_1_2, "Revenue Systems, Religious Policies, Literature & Architecture");

        // Unit: Unit 2: Modern Indian History & Tamil Nadu Freedom Struggle
        Unit u_HIST_12_16_2 = unitRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubject(board, classLevel, "History")
                .stream().filter(unit -> unit.getUnitNumber() != null && unit.getUnitNumber() == 2).findFirst()
                .orElseGet(() -> unitRepository.save(new Unit("Unit 2: Modern Indian History & Tamil Nadu Freedom Struggle", 2, "History", board, classLevel)));

        // Chapter: British Colonial Consolidation, 1857 Revolt & Nationalist Upsurge (Class 12)
        Chapter ch_HIST_12_16_2_3 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "History", 3)
                .orElseGet(() -> chapterRepository.save(new Chapter("History", "Unit 2: Modern Indian History & Tamil Nadu Freedom Struggle", 3, "British Colonial Consolidation, 1857 Revolt & Nationalist Upsurge (Class 12)", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "History", "Unit 2: Modern Indian History & Tamil Nadu Freedom Struggle", "British Colonial Consolidation, 1857 Revolt & Nationalist Upsurge (Class 12)", ch_HIST_12_16_2_3, "Economic Impact of British Rule, Gandhi & Mass Mobilisation");

        // Chapter: Freedom Struggle in Tamil Nadu & Social Transformation
        Chapter ch_HIST_12_16_2_4 = chapterRepository
                .findBySchoolIsNullAndBoardAndClassLevelAndSubjectAndChapterNumber(board, classLevel, "History", 4)
                .orElseGet(() -> chapterRepository.save(new Chapter("History", "Unit 2: Modern Indian History & Tamil Nadu Freedom Struggle", 4, "Freedom Struggle in Tamil Nadu & Social Transformation", false, board, classLevel)));
        seedMissionsAndQuestions(board, classLevel, "History", "Unit 2: Modern Indian History & Tamil Nadu Freedom Struggle", "Freedom Struggle in Tamil Nadu & Social Transformation", ch_HIST_12_16_2_4, "Self-Respect Movement, Periyar, Justice Party & Post-Independence Era");

    }

    private void seedMissionsAndQuestions(String board, int classLevel, String subject, String unitName, String chapterName, Chapter chapter, String concept) {
        List<Mission> existingMissions = missionRepository.findByChapter_Id(chapter.getId());
        if (!existingMissions.isEmpty()) {
            return;
        }

        String[] mTypes = {"CONCEPT", "MCQ", "FILL_BLANK", "PROBLEM", "SCENARIO"};

        for (int m = 1; m <= 5; m++) {
            Mission mission = new Mission();
            mission.setChapter(chapter);
            mission.setMissionNumber(m);
            mission.setGameType(m == 3 ? "FILL_BLANK" : mTypes[m - 1]);
            mission = missionRepository.save(mission);

            for (int q = 1; q <= 5; q++) {
                Question question = new Question();
                question.setBoard(board);
                question.setClassLevel(classLevel);
                question.setSubject(subject);
                question.setUnit(unitName);
                question.setChapter(chapterName);
                question.setMission(m);
                question.setQuestionType(m == 3 ? "FILL_BLANK" : "MCQ");
                question.setQuestionText(generateQuestionText(board, classLevel, subject, chapterName, concept, m, q));
                
                String[] opts = generateOptions(board, classLevel, subject, chapterName, concept, m, q);
                question.setOptionA(opts[0]);
                question.setOptionB(opts[1]);
                question.setOptionC(opts[2]);
                question.setOptionD(opts[3]);
                question.setCorrectAnswer(m == 3 ? opts[0] : "A");
                questionRepository.save(question);
            }
        }
    }

    private String generateQuestionText(String board, int classLevel, String subject, String chapterName, String concept, int m, int q) {
        if ("Tamil".equalsIgnoreCase(subject)) {
            if (m == 1) return "'" + chapterName + "' பாடப்பகுதியில் சுட்டப்படும் முதன்மைக் கருத்து யாது? (வினா எண் " + q + ")";
            if (m == 2) return "'" + chapterName + "' பற்றிய பின்வரும் கூற்றுகளில் சரியானது எது? (வினா எண் " + q + ")";
            if (m == 3) return "'" + chapterName + "' பாடலில் இடம்பெற்றுள்ள மையச் சொல் _______ ஆகும்.";
            if (m == 4) return "'" + chapterName + "' உணர்த்தும் வாழ்வியல் அறநெறி மற்றும் இலக்கிய நயம் யாது?";
            return "'" + chapterName + "' பாடக்கருத்தை இன்றைய அன்றாட வாழ்வில் எவ்வாறு பின்பற்றலாம்?";
        }
        if (m == 1) return "In " + subject + " (" + board + " Class " + classLevel + "), what is the fundamental principle established in '" + chapterName + "'?";
        if (m == 2) return "Which of the following statements is scientifically and textually accurate regarding '" + chapterName + "'?";
        if (m == 3) return "In the study of '" + chapterName + "', the core concept governing " + concept + " is _______.";
        if (m == 4) return "Analyze the key relationship and problem-solving formulation in '" + chapterName + "' regarding " + concept + ":";
        return "How does the principle of '" + chapterName + "' apply to real-world practical scenarios?";
    }

    private String[] generateOptions(String board, int classLevel, String subject, String chapterName, String concept, int m, int q) {
        if ("Tamil".equalsIgnoreCase(subject)) {
            return new String[]{
                concept + " பற்றிய பாடநூல் சார்ந்த சரியான விளக்கம்",
                "பொருத்தமற்ற அல்லது பிழையான கருத்து",
                "பாடப்பகுதிக்குத் தொடர்பில்லாத கூற்று",
                "பொதுவான தவறான விடை"
            };
        }
        return new String[]{
            "Accurate textbook principle of " + concept + " for " + chapterName,
            "Opposing incorrect theoretical statement",
            "Alternative invalid mathematical or scientific misconception",
            "None of the above"
        };
    }
}
