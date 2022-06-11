import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

    public class createDatabase {

        private static Connection instance = null;

        public void DBConnection() {
            Properties props = new Properties();
            FileInputStream in = null;
            try {
                in = new FileInputStream("./db.props");
                props.load(in);
                in.close();

                // specify the data source, username and password
                String url = props.getProperty("jdbc.url");
                String username = props.getProperty("jdbc.username");
                String password = props.getProperty("jdbc.password");

                // get a connection
                instance = DriverManager.getConnection(url, username,
                        password);
            } catch (SQLException sqle) {
                System.err.println(sqle);
            } catch (FileNotFoundException fnfe) {
                System.err.println(fnfe);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }


    public static void createTable() throws SQLException {

        String mazeListTable = "CREATE TABLE IF NOT EXISTS mazeList ("
                + " title varchar(25),"
                + " author varchar(25),"
                + " dateCreated varchar(25),"
                + " dateEdited varchar(25),"
                + " mazeImage LONGBLOB"
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
