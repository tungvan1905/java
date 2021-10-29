package com.vti.backend.presentationlayer;

import java.sql.SQLException;

import com.vti.entity.FresherCandidate.GraduationRank;

public interface ICandidateController {
	public boolean isEmailIfExists(String email) throws ClassNotFoundException, SQLException;

	public boolean createExperienceCandidate(String firstName, String lastName, String phone, String email,
			String password, int expInYear, String proSkill) throws ClassNotFoundException, SQLException;

	public boolean createFresherCandidate(String firstName, String lastName, String phone, String email,
			String password, GraduationRank graduationRank) throws ClassNotFoundException, SQLException;

	public boolean isLogin(String email, String password) throws ClassNotFoundException, SQLException;
}
