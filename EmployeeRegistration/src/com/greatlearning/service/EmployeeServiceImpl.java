package com.greatlearning.service;

import java.util.Random;

import com.greatlearning.model.EmployeeDetail;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public String generateUserEmail(String firstName, String lastName, String departmentName) {
	
		return firstName + lastName+ "@" + departmentName + "gl.com" ;
		
	}

	@Override
	public String generateUserPassword() {
		String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lower = "abcdefghijklmnopqrstuvwxyz";
		String nums = "0123456789";
		String spnChar = "!@#$%^&*()";
		String combined = caps+nums+lower+spnChar;
		//System.out.println(combined.length());
		String genPass= " ";
		Random random = new Random();
		for (int i=1;i<9;i++)
		{
			 genPass = genPass + String.valueOf(combined.charAt(random.nextInt(combined.length())));
		}  
		
		return genPass;
	}

	@Override
	public String displayEmployeeDetail(EmployeeDetail el) {
		System.out.println("Employee First name is: " +el.getFirstName());
		System.out.println("Employee Last name is: " +el.getLastName());
		System.out.println("Employee Email id is: " +el.getUserEmail());
		System.out.println("Employee password is: " +el.getPassword());
	
		return null;
	}

}
