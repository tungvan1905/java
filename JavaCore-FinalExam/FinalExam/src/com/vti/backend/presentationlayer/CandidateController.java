package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.bussinesslayer.CandidateService;
import com.vti.entity.FresherCandidate.GraduationRank;

public class CandidateController implements ICandidateController {
	private CandidateService candidateService;
	
	public CandidateController() throws FileNotFoundException, IOException {
		// TODO Auto-generated constructor stub
		candidateService = new CandidateService();
	}
	
	@Override
	public boolean isEmailIfExists(String email) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return candidateService.isEmailIfExists(email);
	}

	@Override
	public boolean createExperienceCandidate(String firstName, String lastName, String phone, String email,
			String password, int expInYear, String proSkill) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return candidateService.createExperienceCandidate(firstName, lastName, phone, email, password, expInYear, proSkill);
	}

	@Override
	public boolean createFresherCandidate(String firstName, String lastName, String phone, String email,
			String password, GraduationRank graduationRank) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return candidateService.createFresherCandidate(firstName, lastName, phone, email, password, graduationRank);
	}

	@Override
	public boolean isLogin(String email, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return candidateService.isLogin(email, password);
	}

}
