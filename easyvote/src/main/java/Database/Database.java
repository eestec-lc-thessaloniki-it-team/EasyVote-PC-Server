package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Database {

  Connection conn;

  // Properties for connection
  Properties connProperties = new Properties();
  private String jdbcURL = "jdbc:mysql://localhost:3306?userTimezone=true&serverTimezone=UTC"; // Might need to change per OS

  private String username = "tutorialuser";
  private String password = "tutorialpassword";

  // Connect to the database
  public Connection getConnection() {

    connProperties.put("user", username);
    connProperties.put("password", password);
    try {
      conn = DriverManager.getConnection(jdbcURL, connProperties);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return conn;
  }

  public void createTable() throws SQLException {
    String sqlCreate =
        "CREATE TABLE IF NOT EXISTS " + "users" + "(id INT AUTO_INCREMENT," + "name VARCHAR(20))";

    Statement stmt = conn.createStatement();
    stmt.execute(sqlCreate);
  }
  
  

}
