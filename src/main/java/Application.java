package model.java

import Service.FlashcardService;
import Service.MenuService;
import Service.UserService;
import org.apache.logging.log4j.Logger;

public class Application {
    private static User currentUser;
    private static UserService userService;
    private static FlashcardService flashcardService;
    private static Logger logger;
    /**
     * @author Nivedh Ollakal
     *
     * run() is used to launch the application and initialize the application state
     */
    public static void run(){
        configure();
        System.out.println("--Welcome to Flash Pass--");

        while(true){
            if(currentUser == null){
                mainMenu()();
            } else {
                homeMenu();
            }
        }
    }

    private static void mainMenu(){
        switch(MenuService.main.display()){
            case 1: currentUser = userService.login();
                break;
            case 2: userService.register();
                break;
            case 0: System.exit(0);
                break;
            default:
                break;
        }
    }

    private static void homeMenu(){
        switch(MenuService.home.display()){
            case 1: flashcardService.createFlashcard();
                break;
            case 2: flashcardService.practiceMyFlashcards();
                break;
            case 3: flashcardService.practiceAllFlashcards();
                break;
            case 0: currentUser = null;
                break;
            default:
                break;
        }
    }

    private static void configure(){
        currentUser = null;
        logger = LogManager.getLogger(Application.class);

        try {
            userService = new UserService();
        } catch (NoSuchAlgorithmException e) {
            logger.warn(e.getMessage(), e);
        }

        flashcardService = new FlashcardService();
    }
}



