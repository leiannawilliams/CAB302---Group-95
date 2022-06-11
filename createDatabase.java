import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

    public class createDatabase {
    public static void createTable() throws SQLException {

        String mazeListTable = "CREATE TABLE IF NOT EXISTS mazeList ("
                + " title varchar(25),"
                + " author varchar(25),"
                + " dateCreated varchar(25),"
                + " dateEdited varchar(25)"
                + ");";


        Connection connection = DriverManager.getConnection("jdbc:sqlite:mazeCreator.db");
        Statement statement = connection.createStatement();
        statement.execute(mazeListTable);

    }


    public static void main(String[] args) {
        try {
            createTable();
        } catch (SQLException e) {
            return;
        }
    }
    }
