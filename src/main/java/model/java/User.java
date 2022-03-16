package model.java;

// Encapsulation is a way to protect your data from unwanted access.
// Access-Modifiers
//  Access-Modifier:        In the Class:       In the same package(not in subclass):   In a Subclass(different package):       Anywhere:
//  - public                x                   x                                       x                                       x
//  - protected             x                   x                                       x                                       N
//  - default               x                   x                                       N                                       N
//  - private               x                   N                                       N                                       N
public class User {
    private String username;
    private String password;

    // no argument constructor
    public User() {

    }

    // This is a 2 argument constructor
    public User(String u, String p){
        this.username = u;
        this.password = p;
    }

    // This is a method.
    public String getUsername() { // Industry standard to be naming your "getters and setters" in this way.
        return username;
    }
    // Since we are using "setUsername" we need to pass in the "username" that we want to set it to.
    // with the "setUsername" we are taking the "string" that is username and we are taking what is given to us by the
    // user and we are replacing the existing value of "username" with the now new obtained value retrieved by
    // "setUsername".
    public void setUsername(String username) { // Industry standard to be naming your "getters and setters" in this way.
        this.username = username;
    }

    // This is another method "getter" for the "password value"
    public String getPassword(){ // Industry standard to be naming your "getters and setters" in this way.
        return password;
    }

    // This is another method "setter" for the "password value"
    public void setPassword(String password) { // Industry standard to be naming your "getters and setters" in this way.
        this.username = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
