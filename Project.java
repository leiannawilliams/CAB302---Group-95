import java.time.format.DateTimeFormatter;

public class Project {
    private String title;
    private String author;
    private DateTimeFormatter created;
    private DateTimeFormatter lastEdited;

    /**
     * Class constructor to create a new project
     * @title a String to store the inputted title of a maze.
     * @author a String to store the inputted name of the author of a maze.
     * @created will use DateTimeFormatter to store the creation date and time of a maze.
     * @lastEdit will use DateTimeFormatter to store the date and time of the last edit of a maze.
     */
    private void newProject(String title, String author) {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
