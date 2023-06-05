package com.greatlearning.app;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.greatlearning.model.EmployeeDetail;
import com.greatlearning.service.EmployeeServiceImpl;

public class DriverApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First Name ");
		String fName=sc.nextLine();
		System.out.println("Enter Last Name ");
		String lName=sc.nextLine();
		
		EmployeeDetail emp = new EmployeeDetail();
		emp.setFirstName(fName);
		emp.setLastName(lName);
		EmployeeServiceImpl esi = new EmployeeServiceImpl();
		
		System.out.println(" 1. Techniccal ");
		System.out.println(" 2. Admin ");
		System.out.println(" 3. Human resource ");
		System.out.println(" 4. Legal ");
		System.out.println(" Enter your Choice ");
		int choice = sc.nextInt();
		String gEmail = " ";
		String gPassword = " ";
		switch(choice)
		{
		case 1 :gEmail = esi.generateUserEmail(emp.getFirstName().toLowerCase(),emp.getLastName().toLowerCase(), "Tech ");
				break;
		case 2 :gEmail = esi.generateUserEmail(emp.getFirstName().toLowerCase(),emp.getLastName().toLowerCase(), "Admin ");
			break;
		case 3 :gEmail = esi.generateUserEmail(emp.getFirstName().toLowerCase(),emp.getLastName().toLowerCase(), "HR ");
			break;
		case 4 :gEmail = esi.generateUserEmail(emp.getFirstName().toLowerCase(),emp.getLastName().toLowerCase(), "Legal ");
			break;
		default:
			System.out.println("Please Enter valid input ");
		}
		gPassword = esi.generateUserPassword();
		emp.setUserEmail(gEmail);
		emp.setPassword(gPassword);
		esi.displayEmployeeDetail(emp);
		String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[-+_!@#$%^&*., ?]).{8,}$";
		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(gPassword);
		if (m.matches())
			System.out.println("Valid password");
		else 
			System.out.println("Invalid password");
		
	}

}
