import model.java.User;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       List<User> users =  new ArrayList<>();

       System.out.println("Welcome to Flash Pass!");
       while(true) {
           System.out.println("What would you like to do?");
           System.out.println("1) Register");
           System.out.println("2) Login");
           System.out.println("0) Exit");

           String userInput = scanner.nextLine();
           int x = 5;

            switch(userInput) {
                case "1":
                    System.out.println("Enter your Username.");
                    String username = scanner.nextLine();
                    System.out.println("Enter your Password.");
                    String password = scanner.nextLine();
                    System.out.println("Printing case 1");

                    User user = new User();
                    user.username = username;
                    user.password = password;
                    users.add(user);
                case "2":
                    System.out.println("User Information:");
                    System.out.println(users);
                    break;
                case "0":
                    System.out.println("Exiting the App");
                    System.exit(1);
                    break;
                default:
                    System.out.println("Please only choose from the available menu options.");
            }
        }
    }
}
