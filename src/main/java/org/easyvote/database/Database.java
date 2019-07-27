package Database;

import java.sql.*;

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

  // Does what it says
  public void createDatabase() {
    String command = "CREATE DATABASE IF NOT EXISTS eestec;";
    try {
      Statement statement = conn.createStatement();
      statement.executeUpdate(command);
      statement.executeUpdate("USE eestec;");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


  // Does what it says
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

  // Insert a new person in the database
  public void insertIntoDatabase(String name) {
    String command = "INSERT INTO eestecUsers(name) VALUES('" + name + "');";

    try {
      Statement statement = conn.createStatement();
      statement.executeUpdate(command);
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  // Give an id and get the real name of the client
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
