package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vti.entity.FresherCandidate.GraduationRank;
import com.vti.ultis.jdbcUltis;

public class CandidateRepository implements ICandidateRepository {
	private jdbcUltis jdbc;
	
	public CandidateRepository() throws FileNotFoundException, IOException {
		// TODO Auto-generated constructor stub
		jdbc = new jdbcUltis();
	}
	
	@Override
	public boolean isEmailIfExists(String email) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Candidate WHERE Email = ?;";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setString(1, email);
		ResultSet resultSet = preStatement.executeQuery();
		if (resultSet.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	@Override
	public boolean createExperienceCandidate(String firstName, String lastName, String phone, String email,
			String password, int expInYear, String proSkill) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Candidate (FirstName, LastName, Phone, Email, `Password`, ExpInYear, ProSkill, Category)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, 'EXPERIENCECANDIDATE')";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setNString(1, firstName);
		preStatement.setNString(2, lastName);
		preStatement.setString(3, phone);
		preStatement.setString(4, email);
		preStatement.setString(5, password);
		preStatement.setInt(6, expInYear);
		preStatement.setNString(7, proSkill);
		if (preStatement.executeUpdate() == 1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	@Override
	public boolean createFresherCandidate(String firstName, String lastName, String phone, String email,
			String password, GraduationRank graduationRank) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Candidate (FirstName, LastName, Phone, Email, `Password`, GraduationRank, Category)"
				+ "VALUES (?, ?, ?, ?, ?, ?, 'FRESHERCANDIDATE')";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setNString(1, firstName);
		preStatement.setNString(2, lastName);
		preStatement.setString(3, phone);
		preStatement.setString(4, email);
		preStatement.setString(5, password);
		preStatement.setString(6, graduationRank.toString());
		if (preStatement.executeUpdate() == 1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	@Override
	public boolean isLogin(String email, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Candidate WHERE Email = ? AND Password = ?;";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setString(1, email);
		preStatement.setString(2, password);
		ResultSet resultSet = preStatement.executeQuery();
		if (resultSet.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}
	
}
