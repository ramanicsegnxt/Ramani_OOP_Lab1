package com.greatlearning.credentialprovider.interfaces;

import com.greatlearning.credentialprovider.model.Employee;

public interface ICredentials {
	public String generatePassword();
	public String generateEmailAddress(Employee emp, String department);
	public 	void showCredentials(Employee emp);
}
