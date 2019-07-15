package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Database {

  private Connection conn;

  // Might need to change per OS
  private String jdbcURL = "jdbc:mysql://localhost:3306?userTimezone=true&serverTimezone=UTC";

  // Connect to the database
  public Connection getConnection() {

    try {
      conn = DriverManager.getConnection(jdbcURL, "root", "");
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return conn;
  }

  public void createTable() {
    String command = "CREATE TABLE IF NOT EXISTS eestecUsers(id INT AUTO_INCREMENT PRIMARY KEY,"
        + "name VARCHAR(20))";

    try {
      Statement statement = conn.createStatement();
      statement.executeUpdate(command);
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  public void insertIntoDatabase(String name) {
    String command = "INSERT INTO eestecUsers(name) VALUES('" + name + "');";

    try {
      Statement statement = conn.createStatement();
      statement.executeUpdate(command);
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }
  
  public String getName(int id) {
    
    String command = "SELECT name FROM eestecUsers WHERE id=" + id;
    
    try {
      Statement statement = conn.createStatement();
      ResultSet rs = statement.executeQuery(command);
      rs.next();
      
      return rs.getString("name");
      
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    return null;

  }

}
