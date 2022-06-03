package Project;

import java.time.LocalDateTime;

public class Project {
    public String title;
    public String author;
    private LocalDateTime created;
    private LocalDateTime lastEdited;

    /**
     * Class constructor to create a new project
     * @title a String to store the inputted title of a maze.
     * @author a String to store the inputted name of the author of a maze.
     * @created will use DateTimeFormatter to store the creation date and time of a maze.
     * @lastEdited will use DateTimeFormatter to store the date and time of the last edit of a maze.
     */
    public Project(String title, String author) {
        this.title = title;
        this.author = author;
    }

    private void open(){

    }

    private void save(){

    }

    private void edit(){

    }

    private void export(){

    }

    public String getTitle(String title) { return title; }

    public String setTitle(String title) {
        this.title = title;
        return title;
    }

    public String getAuthor(String author) {
        return author;
    }

    public String setAuthor(String author) {
        this.author = author;
        return author;
    }

    public String getCreationDate(){
        this.created = java.time.LocalDateTime.now();
        return String.valueOf(created);
    }

    public String getLastEdit(){
        this.lastEdited = java.time.LocalDateTime.now();
        return String.valueOf(lastEdited);
    }
}