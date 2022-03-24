package model.java;

public class Flashcard {
    private int id;
    private String title;
    private String solution;
    private int userId; // -> stores the userId of who created it

    public Flashcard() {
    }

    public Flashcard(String title, String solution) {
        this.title = title;
        this.solution = solution;
    }

    public Flashcard(String title, String solution, int userId) {
        this.title = title;
        this.solution = solution;
        this.userId = userId;
    }

    public Flashcard(int id, String title, String solution) {
        this.id = id;
        this.title = title;
        this.solution = solution;
    }

    public Flashcard(int id, String title, String solution, int userId) {
        this.id = id;
        this.title = title;
        this.solution = solution;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Flashcard{" +
                "title='" + title + '\'' +
                ", solution='" + solution + '\'' +
                '}';
    }
}
