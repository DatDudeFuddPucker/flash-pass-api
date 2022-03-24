package Service;

import util.ScannerFactory;

public class MenuService {
    // This is a static init block
    static {
        main = new Main();
        home = new Home();
    }

    public static Main main;
    public static Home home;


    public static class Main extends Menu{
        private final String[] menuOptions = {
                "1) Log In",
                "2) Register",
                "0) Exit"
        };

        private Main(){
            super(ScannerFactory.getScanner());
        }

        public int display(){
            System.out.println("\n-- Main Menu --");
            return super.display(this.menuOptions);
        }

    }

    public static class Home extends Menu{
        private final String[] menuOptions = {
                "1) Create a Flashcard",
                "2) Practice My Flashcards",
                "3) Practice All Flashcards",
                "0) Log Out"
        };

        private Home(){
            super(ScannerFactory.getScanner());
        }

        public int display(){
            System.out.println("\n-- Home Menu --");
            return super.display(this.menuOptions);
        }
    }
}
