package com.vti.entity;

public class Candidate {
	private int id;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String password;
	private Category category;
	
	public enum Category {
		EEXPERIENCECANDIDATE, FRESHERCANDIDATE
	}
}
