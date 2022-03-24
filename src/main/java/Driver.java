import model.java.User;

import java.util.ArrayList;
import java.util.Scanner;


public class Driver {


    public static void main(String[] args) {
        User user = new User();


       ArrayList<User> users = new ArrayList();

       Boolean programRunning = true;
       System.out.print("Welcome. ");
       User currentUser = new User();
       Scanner getInput = new Scanner(System.in);

       while(programRunning) {
           System.out.println("Please select an option below:");
           System.out.println("1) Register\n" + "2) Login\n" + "3) Logout\n" + "4) Who is logged in?\n" + "0) Exit");
           String decision = getInput.nextLine();
           switch (decision) {
                case "1":
                    boolean userTaken = false;
                    String username = "";
                    String password = "";
                    System.out.println("Please enter your username.");
                    username = getInput.nextLine();
                    for (User aUser : users) {
                        if (!userTaken && aUser.getUsername().equals(username)) {
                            System.out.println("This username is taken. Returning to menu...");
                            userTaken = true;
                        }
                    }

                    if (!userTaken)
                    {
                        // Assign Registration info
                        System.out.println("Please enter your password");
                        password = getInput.nextLine();

                        User newUser = new User(username, password);

                        // Add our user to our list of Users
                        users.add(newUser);

                        // Confirm registration is complete
                        System.out.println("Registration is Complete!");
                    }
                    break;


               case "2":
                    boolean loginSuccess = false;
                    System.out.println("Please enter your username");
                    username = getInput.nextLine();
                    System.out.println("Please enter your password");
                    password = getInput.nextLine();

                    for (User aUser : users)
                    {
                        System.out.println(aUser);
                        if (aUser.getUsername().equals(username) && aUser.getPassword().equals(password))
                        {
                            currentUser = aUser;
                            loginSuccess = true;
                            break;
                        }
                    }

                    if (!loginSuccess)
                    {
                        System.out.println("Your login information is incorrect.");
                    }
                    else
                    {
                        System.out.println("Welcome, " + currentUser.getUsername());
                    }
                    break;

                case "3":
                    // To Log out a user.
                    boolean loggedIn = false;
                    System.out.println("Please enter your Username.");
                    username = getInput.nextLine();
                    for (User aUser : users)
                    {
                        // System.out.println(aUser); - This is not needed, this unecessarilly display the logged in users.
                        if (aUser.getUsername().equals(username))
                        {
                            currentUser = aUser;
                            loggedIn = true;
                            break;
                        }
                    }
                    if(!loggedIn)
                    {
                        System.out.println("That Username is not logged in.");
                    }
                    else
                    {
                        System.out.println("Would you like to be logged out?");
                        System.out.println("1.) Yes\n" + "2.) No\n");
                        String decision2 = getInput.nextLine();
                        switch(decision2) {
                            case "1":
                                // loggedIn = true;
                                break;

                        }
                    }


                case "4":
                    // To do: print who is currently logged in
                    System.out.println(currentUser);
                    break;

                case "0":
                   System.out.println("You have been logged out. \nGoodbye!");
                   programRunning = false;
                   System.exit(1); // Exit Code 1
                   break;

                default:
                   System.out.println("Not an option. Please enter a valid number.");

            }
        }
    }
}
