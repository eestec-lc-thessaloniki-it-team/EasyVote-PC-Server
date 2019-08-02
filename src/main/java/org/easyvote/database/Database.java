package org.easyvote.database;

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
		String createDatabase = "CREATE DATABASE IF NOT EXISTS eestec;";
		String useDatabase = "USE eestec";
		try {
			Statement statement = conn.createStatement();
			statement.executeUpdate(createDatabase);
			statement.executeUpdate(useDatabase);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Does what it says
	public void createTable() {
		// All members of the meeting
		String members = "CREATE TABLE IF NOT EXISTS members(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(20))";

		String allVotes = "CREATE TABLE IF NOT EXISTS all_votes ( id_vote INT AUTO_INCREMENT PRIMARY KEY, "
				+ "id_member INT, name_member VARCHAR(20), vote VARCHAR(20) NOT NULL, "
				+ "type_of_vote VARCHAR(10) NOT NULL, session VARCHAR(20) NOT NULL, topic VARCHAR(25) NOT NULL, "
				+ "FOREIGN KEY (id_member) REFERENCES members(id) )";

		try {
			Statement statement = conn.createStatement();
			statement.executeUpdate(members);
			statement.executeUpdate(allVotes);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void insertVote(String vote, String typeOfVote, String session, String topic) {

		try {

			String insertVote = "INSERT INTO all_votes(vote, type_of_vote, session, topic) VALUES(?, ?, ?, ?)";

			PreparedStatement statement = conn.prepareStatement(insertVote);
			statement.setString(1, vote);
			statement.setString(2, typeOfVote);
			statement.setString(3, session);
			statement.setString(4, topic);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void insertVote(int id, String vote, String typeOfVote, String session, String topic) {

		try {

			String insertVote = "INSERT INTO all_votes(id_member, name_member, vote, type_of_vote, session, topic) VALUES(?, (SELECT name FROM members WHERE members.id = ?), ?, ?, ?, ?)";

			PreparedStatement statement = conn.prepareStatement(insertVote);
			statement.setInt(1, id);
			statement.setInt(2, id);
			statement.setString(3, vote);
			statement.setString(4, typeOfVote);
			statement.setString(5, session);
			statement.setString(6, topic);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// Insert a new person in the database
	// This may require to return the id, so the member knows their id
	public void insertMember(String name) {
		String command = "INSERT INTO members(name) VALUES(?);";

		try {
			PreparedStatement prep = conn.prepareStatement(command);
			prep.setString(1, name);
			prep.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// When there is no specified vote, it means that it's a normal voting with
	// Positive, Negative and NotPresent answers
	public int[] countOfVote(String topic) {

		ResultSet rs = null;
		int[] result = new int[3];
		String commandCount = "SELECT COUNT(vote) as total FROM all_votes WHERE topic=? AND vote=?";

		try {
			PreparedStatement statement;
			statement = conn.prepareStatement(commandCount);
			statement.setString(1, topic);

			statement.setString(2, Answers.Positive.toString());
			rs = statement.executeQuery();
			rs.next();
			result[0] = rs.getInt("total");

			statement.setString(2, Answers.Negative.toString());
			rs = statement.executeQuery();
			rs.next();
			result[1] = rs.getInt("total");

			statement.setString(2, Answers.NotPresent.toString());
			statement.execute();
			rs = statement.executeQuery();
			rs.next();
			result[2] = rs.getInt("total");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	// When vote is specified, it means that the method will return ONLY this
	// specific vote and not Positive, Negative and NotPresent
	public int countOfVote(String topic, String vote) {

		int result = 0;
		ResultSet rs = null;
		String commandCount = "SELECT COUNT(vote) as total FROM all_votes WHERE topic=? AND vote=?";

		try {
			PreparedStatement statement;
			statement = conn.prepareStatement(commandCount);
			statement.setString(1, topic);

			statement.setString(2, vote);
			rs = statement.executeQuery();
			rs.next();
			result = rs.getInt("total");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	

	// Give an id and get the real name of the client
	public String getName(int id) {

		String command = "SELECT name FROM members WHERE id=" + id;

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

	public enum Answers {
		Positive, Negative, NotPresent;
	}

}