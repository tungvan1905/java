package com.vti.backend.bussinesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.datalayer.CandidateRepository;
import com.vti.entity.FresherCandidate.GraduationRank;

public class CandidateService implements ICandidateService {
	private CandidateRepository candidateRepository;
	
	public CandidateService() throws FileNotFoundException, IOException {
		// TODO Auto-generated constructor stub
		candidateRepository = new CandidateRepository();
	}
	
	@Override
	public boolean isEmailIfExists(String email) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return candidateRepository.isEmailIfExists(email);
	}

	@Override
	public boolean createExperienceCandidate(String firstName, String lastName, String phone, String email,
			String password, int expInYear, String proSkill) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return candidateRepository.createExperienceCandidate(firstName, lastName, phone, email, password, expInYear, proSkill);
	}

	@Override
	public boolean createFresherCandidate(String firstName, String lastName, String phone, String email,
			String password, GraduationRank graduationRank) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return candidateRepository.createFresherCandidate(firstName, lastName, phone, email, password, graduationRank);
	}

	@Override
	public boolean isLogin(String email, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return candidateRepository.isLogin(email, password);
	}
}
