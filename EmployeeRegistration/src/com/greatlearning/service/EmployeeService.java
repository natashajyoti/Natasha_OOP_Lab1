package com.greatlearning.service;

import com.greatlearning.model.EmployeeDetail;

public interface EmployeeService {
	
	String generateUserEmail(String firstName, String lastName,String departmentName);
	String generateUserPassword();
	String displayEmployeeDetail(EmployeeDetail el);

}
