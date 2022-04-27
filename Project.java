import java.time.format.DateTimeFormatter;

public class Project {
    private String title;
    private String creator;
    private DateTimeFormatter created;
    private DateTimeFormatter lastEdited;

    /**
     * Class constructor to create project
     * @param title project title
     * @param creator project creator
     */
    private void newProject(String title, String creator) {
        this.title = title;
        this.creator = creator;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
