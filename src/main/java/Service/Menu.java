package Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

public abstract class Menu {

    private final Logger logger;
    private final Scanner scanner;

    public Menu(Scanner scanner){
        this.logger = LogManager.getLogger(Menu.class);
        this.scanner = scanner;
    }

    protected int display(String[] menuOptions){
        for(String option : menuOptions){
            System.out.println(option);
        }

        return getInput(menuOptions.length - 1);
    }

    private int getInput(int options){
        int userInput = -1;
        int attempts = 0;

        do{
            System.out.print("Please enter a valid menu option: ");
            try{
                userInput = Integer.parseInt(scanner.nextLine());
            } catch(Exception e){
                logger.warn(e.getMessage());
            } finally {
                attempts++;
            }
        } while((userInput < 0 || userInput > options) && attempts < 3);

        return userInput;
    }
}
