import model.java.User;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
       // User newUser =  new User(); // Here we are creating a new "User()" called "newUser.
       // User user2 = new User(); // On this line, we are setting the "User" called "user2" equal to the user created
                                // on the above line (line 9) which we called "newUser".
                                // In essense now "user2" has now been set to point at "newUser".

        //System.out.println(newUser);// These 2 lines should print out the same hashcode, because above we have set them
                                    // to be equal or rather they are "pointing" to one another from a value standpoint.
        //System.out.println(user2);

        Scanner scanner = new Scanner(System.in);// System.in is an input stream to configure the scanner.
                                                 // This is a way for the application to pay attention to what
                                                 // a user is inputing via the keyboard in this case.

        List<User> users =  new ArrayList<>(); // This is an empty "list" that we have called Users. We created this
                                               // "list" to store the "users" that are created through the "Registration"
                                               // option of our application.
        // User user = new User();
        System.out.println("Welcome to Flash Pass!");
        while(true) {
            System.out.println("What would you like to do?");
            System.out.println("1) Register");
            System.out.println("2) Login");
            System.out.println("0) Exit");

            String userInput = scanner.nextLine();
            // With an "if statement" its pretty binary.
            // If true do this
            // If else do this other thing.
            // Essentially we have 2 options. We are testing if something is true.

            // A switch statement allows us to provide individual cases, where if this is this, do this.
            switch(userInput) {
                case "1":
                    System.out.println("Enter your Username.");
                    String username = scanner.nextLine();
                    System.out.println("Enter your Password.");
                    String password = scanner.nextLine();
                    System.out.println("Printing case 1");

                    User user = new User(); // Here we are initializing the "User".
                    user.username = username;
                    user.password = password;
                    users.add(user); // After the user has given their username and password, we are adding this new
                                     // user to the "List<users> users = new ArrayList<>();" from above. This will
                                     // allow us to store new users as they are created through the "Registration"
                                     // option.
                    break;
                case "2":
                    System.out.println("User Information:");
                    System.out.println(users);
                    break;
                case "0":
                    System.out.println("Exiting the App");
                    System.exit(1);
                    break;
                default:    // If an option is chosen that is not a selectable option it will default to this case.
                    System.out.println("Please only choose from the available menu options.");
            }
        }

//        //--------------------------------------Basic Registration----------------------------------------------------//
//        System.out.println("Enter your Username.");
//        String username = scanner.nextLine();
//
//        System.out.println("Enter your Password.");
//        String password = scanner.nextLine();
//
//        // String userInput = scanner.nextLine();    // This method returns the rest of the current line, excluding any
//        // line seperator at the end. The position is set to the beginning
//        // of the next line.
//
//        // System.out.println(userInput);
//        /*
//        User u1 = new User(); // declaring the new object as u1.
//                              // Essentially a User object called u1 will be a instance of the class User.
//                              // This class is defined in the User.java file
//        u1.username = "nollakal"; // These lines are defining the parameters given to the User class in the
//        u1.password = "1234";     // User file.
//
//                              // wherever I take this "u1" object, it is going to contain that state. It is going to be:
//                              // nollakal - user
//                              // 1234 - password
//                              // This is an example of us hardcoding the user registration information.
//        */
//
//
//        System.out.println("Registration Complete");
//        User user = new User();
//        user.username = username;  // The "user.username" here belongs to the User object in the User.java file.
//                                  // We are saying:
//                                  // Take the data or state thats on the user object, and change it to what I have
//                                  // just collected.
//        user.password = password; // The "user.username" here belongs to the User object in the User.java file.
//                                  // We are saying:
//                                  // Take the data or state thats on the user object, and change it to what I have
//                                  // just collected.
//        System.out.println(user.username);
//        System.out.println(user.password);
//
//        //--------------------------------------Basic Registration End------------------------------------------------//

        /*
        System.out.println(u1.username);
        System.out.println(u1.password);
        */

    }
}
