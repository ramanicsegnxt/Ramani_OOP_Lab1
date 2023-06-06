package com.greatlearning.credentialprovider.services;

import java.util.Random;

import com.greatlearning.credentialprovider.interfaces.ICredentials;
import com.greatlearning.credentialprovider.model.Employee;

public class CredentialService implements ICredentials {
	final private int passwordLength = 8;

	@Override
	public String generatePassword() {
		String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String smallLetters = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String specialCharacters = "!@#$%^&*()_=+-/.?<>";
		String values = capitalLetters + smallLetters + numbers + specialCharacters;
		char[] password = new char[passwordLength];
		Random random = new Random();
		
		password[0] = capitalLetters.charAt(random.nextInt(capitalLetters.length()));
		password[1] = smallLetters.charAt(random.nextInt(smallLetters.length()));
		password[2] = numbers.charAt(random.nextInt(numbers.length()));
		password[3] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
		for (int idx = 4; idx < passwordLength; idx++) {
			password[idx] = values.charAt(random.nextInt(values.length()));
		}
		return String.valueOf(password);
	}
	
	@Override
	public String generateEmailAddress(Employee emp, String department) {
		return emp.getFirstName() + emp.getLastName() + "@" + department + ".gl.com";
	}

	@Override
	public void showCredentials(Employee emp) {
		System.out.println("Dear " + emp.getFirstName()+ " your generated credentials are as follows");
		System.out.println("Email ----------> " + emp.getEmail());
		System.out.println("Password -------> " + emp.getPassword());
	}
}
