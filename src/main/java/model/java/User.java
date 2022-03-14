package model.java;

public class User {
    public String username;
    public String password;

    // no argument constructor
    public User() {

    }

    // This is a 2 argument constructor
    public User(String u, String p){
        this.username = u;
        this.password = p;
    }

    // Example of use of Polymorphism: Overloading
    public void overloadingExample(){
        System.out.println("Hello");
    }

    public void overloadingExample(String input){
        System.out.println(input);
    }

    public void overloadingExample(String name, String location){

    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
