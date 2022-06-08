package Project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Project {
    /**
     * Project class fields:
     * <b>title</b> a String to store the inputted title of a maze.
     * <b>author</b> a String to store the inputted name of the author of a maze.
     * <b>created</b> will use DateTimeFormatter to store the creation date and time of a maze.
     * <b>lastEdited</b> will use DateTimeFormatter to store the date and time of the last edit of a maze.
     */
    private String title;
    private String author;

    /* public Project(String title, String author) {
        this.title = title;
        this.author = author;
    }*/

    /* GETTER & SETTER METHODS */

    /**
     * Getter method to get maze title
     * @return title the maze's title
     */
    public String getTitle() { return this.title; }

    /**
     * Setter method to set maze title
     * @param title the maze's title
     */
    public void setTitle(String title) { this.title = title; }

    /**
     * Getter method to get maze author
     * @return author the maze's author
     */
    public String getAuthor() { return this.author; }

    /**
     * Setter method to set maze author
     * @param author the maze's author
     */
    public void setAuthor(String author) { this.author = author; }

    /**
     * Setter method to set 'creation' dateTime of maze project
     * @return the maze project's creation dateTime
     */
    public String setCreationDate(){
        final LocalDateTime created = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return created.format(dtf);
    }

    /**
     * Setter method to set 'last edit' dateTime of maze project
     * @return the maze project's last edit dateTime
     */
    public String setLastEdit(){
        LocalDateTime lastEdited = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return lastEdited.format(dtf);
    }


    /* OTHER METHODS */

    private void open(){

    }

    private void save(){

    }

    private void edit(){

    }

    private void export(){

    }
}