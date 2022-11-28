package com.epam.rd.java.basic.task7.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.epam.rd.java.basic.task7.db.entity.*;


public class DBManager {

    FileInputStream fis;
	Connection con;
	Properties prop;

    private static final Lock CONNECTION_LOCK = new ReentrantLock();
	private static final String FIND_ALL_USERS = "SELECT * FROM users";
	private static final String INSERT_USER = "INSERT INTO users VALUES (DEFAULT ,?)";
	private static final String FIND_ALL_TEAM = "SELECT * FROM teams";
	private static final String INSERT_TEAM = "INSERT INTO teams VALUES (DEFAULT ,?)";
	private static final String INSERT_USER_TO_TEAM = "INSERT INTO users_teams VALUES (? ,?)";
	private static final String FIND_USER_BY_LOGIN = "SELECT * FROM users WHERE login=?";
	private static final String FIND_TEAM_BY_NAME = "SELECT * FROM teams WHERE name=?";
	private static final String FIND_ALL_USER_TEAMS =
			"SELECT teams.id, teams.name FROM users_teams\n" +
			"JOIN teams ON teams.id = users_teams.team_id\n" +
			"WHERE users_teams.user_id = ?";
	private static final String DELETE_TEAM = "DELETE FROM teams WHERE id = ?";
	private static final String UPDATE_TEAM = "UPDATE teams SET name = ? WHERE id=?";
	private static final String DELETE_USERS = "DELETE FROM users WHERE id = ?";


	private static DBManager instance;

	public static synchronized DBManager getInstance() {
		if(instance == null){
            instance = new DBManager();
        }
        return instance;
	}

	private DBManager(){
		try {
			fis = new FileInputStream("app.properties");
			prop = new Properties();
			prop.load(fis);
			con = DriverManager.getConnection(prop.getProperty("connection.url"));
		}
		catch (IOException | SQLException e){
			e.printStackTrace();
		}
	}

	public List<User> findAllUsers() throws DBException {

		try(PreparedStatement ps = con.prepareStatement(FIND_ALL_USERS);
			ResultSet rs = ps.executeQuery()){
			CONNECTION_LOCK.lock();
			List<User> users = new ArrayList<>();
			while(rs.next()){
				User user = new User();
				users.add(user);
				user.setId(rs.getInt(1));
				user.setLogin(rs.getString(2));
			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
		finally{
			CONNECTION_LOCK.unlock();
		}
	}

	public boolean insertUser(User user) throws DBException {
		try(PreparedStatement ps = con.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS)) {
			CONNECTION_LOCK.lock();
			ps.setString(1, user.getLogin());
			if(ps.executeUpdate() != 1){
				return false;
			}
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()){
				int idField = rs.getInt(1);
				user.setId(idField);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			CONNECTION_LOCK.unlock();
		}
		return true;
	}

	public boolean deleteUsers(User... users) throws DBException {
		try(PreparedStatement ps = con.prepareStatement(DELETE_USERS)){
			CONNECTION_LOCK.lock();
			for (User user: users) {
				ps.setInt(1, user.getId());
				if(ps.executeUpdate() != 1){
					return false;
				}
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			CONNECTION_LOCK.unlock();
		}
	}

	public User getUser(String login) throws DBException {

		try(PreparedStatement ps = con.prepareStatement(FIND_USER_BY_LOGIN)){
			CONNECTION_LOCK.lock();
			ps.setString(1, login);
			ResultSet rs = ps.executeQuery();
			User user = null;
			while(rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setLogin(rs.getString(2));
			}
			return user;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		finally {
			CONNECTION_LOCK.unlock();
		}
	}

	public Team getTeam(String name) throws DBException {
		Team team = null;
		try(PreparedStatement ps = con.prepareStatement(FIND_TEAM_BY_NAME)){
			CONNECTION_LOCK.lock();
			ps.setString(1,name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				team = new Team();
				team.setId(rs.getInt(1));
				team.setName(rs.getString(2));
			}
			return team;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		finally {
			CONNECTION_LOCK.unlock();
		}

	}

	public List<Team> findAllTeams() throws DBException {
		try(PreparedStatement ps = con.prepareStatement(FIND_ALL_TEAM);
		ResultSet rs = ps.executeQuery()){
			CONNECTION_LOCK.lock();
			List<Team> teams = new ArrayList<>();
			while(rs.next()){
				Team team = new Team();
				teams.add(team);
				team.setId(rs.getInt(1));
				team.setName(rs.getString(2));
			}
			return teams;
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
		finally {
			CONNECTION_LOCK.unlock();
		}
	}

	public boolean insertTeam(Team team) throws DBException {
		try(PreparedStatement ps = con.prepareStatement(INSERT_TEAM, Statement.RETURN_GENERATED_KEYS)) {
			CONNECTION_LOCK.lock();
			ps.setString(1, team.getName());
			if(ps.executeUpdate() != 1){
				return false;
			}
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()){
				int idField = rs.getInt(1);
				team.setId(idField);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			CONNECTION_LOCK.unlock();
		}
		return true;
	}

	public boolean setTeamsForUser(User user, Team... teams) throws DBException {
		try(PreparedStatement ps = con.prepareStatement(INSERT_USER_TO_TEAM)){
			CONNECTION_LOCK.lock();
            if(user == null){
                throw new DBException("Thrown exception musb be a DBException", new Throwable());
            }
			con.setAutoCommit(false);
			for (Team t : teams) {
                if(t == null){
					throw new DBException("Thrown exception musb be a DBException", new Throwable());
                }
				ps.setInt(1, user.getId());
				ps.setInt(2, t.getId());
				ps.addBatch();
			}
			int[] userTeams = ps.executeBatch();
			for (int u: userTeams) {
				if(u != 1){
					return false;
				}
			}
			con.commit();

		} catch (SQLException e) {
			try {
				con.rollback();
			}
			catch (SQLException ex) {
				ex.printStackTrace();
				throw new DBException("Thrown exception musb be a DBException", ex);
			}
			e.printStackTrace();
			throw new DBException("Thrown exception musb be a DBException", e);
		}
		finally {
			CONNECTION_LOCK.unlock();
			try {
				con.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
        return true;

	}

	public List<Team> getUserTeams(User user) throws DBException {
		try (PreparedStatement ps = con.prepareStatement(FIND_ALL_USER_TEAMS)){
			CONNECTION_LOCK.lock();
			ps.setInt(1, user.getId());
			List<Team> teams = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Team team = new Team();
				teams.add(team);
				team.setId(rs.getInt(1));
				team.setName(rs.getString(2));
			}
			return teams;
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
		finally {
			CONNECTION_LOCK.unlock();
		}
	}

	public boolean deleteTeam(Team team) throws DBException {
		try(PreparedStatement ps = con.prepareStatement(DELETE_TEAM)){
			CONNECTION_LOCK.lock();
			ps.setInt(1, team.getId());
			if(ps.executeUpdate() != 1){
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			CONNECTION_LOCK.unlock();
		}
		return false;
	}

	public boolean updateTeam(Team team) throws DBException {
		try(PreparedStatement ps = con.prepareStatement(UPDATE_TEAM)){
			CONNECTION_LOCK.lock();
			ps.setString(1, team.getName());
			ps.setInt(2, team.getId());
			if(ps.executeUpdate() != 1){
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			CONNECTION_LOCK.unlock();
		}
		return false;
	}

}
