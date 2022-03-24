package Service;

import .model.Flashcard;
import com.revature.repository.FlashcardRepository;
import util.ScannerFactory;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Scanner;

public class FlashcardService {
    private final Logger logger;
    private final Scanner scanner;
    private final FlashcardRepository flashcardRepository;
    private final int FLASHCARD_WIDTH;
    private final String CARD_LINE;
    private final String CARD_GAP;

    public FlashcardService(){
        this.logger = LogManager.getLogger(FlashcardService.class);
        this.scanner = ScannerFactory.getScanner();
        this.flashcardRepository = new FlashcardRepository();
        this.FLASHCARD_WIDTH = 80;
        this.CARD_LINE = buildLine();
        this.CARD_GAP = buildGap();
    }

    public void createFlashcard(){
        System.out.println("\n-- Create Flashcard --");
        flashcardRepository.create(buildFlashcard());
    }

    public void practiceAllFlashcards(){
        practiceFlashcards(flashcardRepository.getAll());
    }

    public void practiceMyFlashcards(){
        practiceFlashcards(flashcardRepository.getAllByUserId(UserService.getCurrentUser().getId()));
    }

    private void practiceFlashcards(List<Flashcard> flashcards){
        for(Flashcard flashcard : flashcards){
            printAsCard(flashcard.getTitle());
            System.out.print("Press ENTER to FLIP");
            scanner.nextLine();
            printAsCard(flashcard.getSolution());
            System.out.print("Press ENTER to CONTINUE");
            scanner.nextLine();
        }
    }

    private void printAsCard(String content){
        System.out.println(CARD_LINE);
        System.out.println(CARD_GAP);
        System.out.println(centerContent(content));
        System.out.println(CARD_GAP);
        System.out.println(CARD_LINE);
    }

    private String centerContent(String content){
        return "|" +
                StringUtils.center(content, FLASHCARD_WIDTH)
                + "|";
    }

    private List<Flashcard> getAllFlashcards(){
        return flashcardRepository.getAll();
    }

    private Flashcard buildFlashcard(){
        return new Flashcard(
                getTitle(),
                getSolution(),
                UserService.getCurrentUser().getId()
        );
    }

    private String getTitle(){
        String title = "";
        boolean valid = false;

        while(!valid){
            System.out.println("Title: ");
            title = scanner.nextLine();

            //TODO: title validation
            if(title.length() > 7){
                valid = true;
            } else{
                System.out.println("Title must be longer than 7 characters.");
            }
        }
        return title;
    }

    private String getSolution(){
        String solution = "";
        boolean valid = false;

        while(!valid){
            System.out.println("Solution: ");
            solution = scanner.nextLine();

            //TODO: title validation
            if(!solution.equals("")){
                valid = true;
            } else{
                System.out.println("You must enter a solution.");
            }
        }

        return solution;
    }

    private String buildLine() {
        StringBuilder builder = new StringBuilder("|");
        for(int i = 0; i < FLASHCARD_WIDTH; i++){
            builder.append("-");
        }
        builder.append("|");

        return builder.toString();
    }

    private String buildGap() {
        StringBuilder builder = new StringBuilder("| ");
        for(int i = 0; i < FLASHCARD_WIDTH / 4; i++){
            builder.append("\t");
        }
        builder.append(" |");

        return builder.toString();
    }
}