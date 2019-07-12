package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Database { 

    Connection conn;

    //Properties for connection
    Properties connProperties = new Properties();
    private String jdbcURL = "jdbc:mysql://localhost:3306"; //Might need to change per OS
    
    private String username;
    private String password;

    public Database(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //Connect to the database
    private Connection getConnection() {

        connProperties.put("user", username);
        connProperties.put("password", password);
        try {
            conn = DriverManager.getConnection(jdbcURL, connProperties);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return conn;
    }
    
    private void createTable() throws SQLException {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + "onoma"
                + "  (brand           VARCHAR(10),"
                + "   year            INTEGER,"
                + "   number          INTEGER,"
                + "   value           INTEGER,"
                + "   card_count           INTEGER,"
                + "   player_name     VARCHAR(50),"
                + "   player_position VARCHAR(20))";

        Statement stmt = conn.createStatement();
        stmt.execute(sqlCreate);
    }

}
