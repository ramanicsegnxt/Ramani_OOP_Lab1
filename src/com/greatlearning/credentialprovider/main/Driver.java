package com.greatlearning.credentialprovider.main;

import java.util.Scanner;

import com.greatlearning.credentialprovider.model.Employee;
import com.greatlearning.credentialprovider.services.CredentialService;

public class Driver {
	static Scanner sc = new Scanner(System.in);
	public static void displayMenu() {
		System.out.println("Please Enter the Department from the following");
		System.out.println("1. Technical");
		System.out.println("2. Admin");
		System.out.println("3. Human Resource");
		System.out.println("4. Legal");
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Credential Provider App");
		String[] departments = {"tech", "admin", "hr", "legal"};
		Employee emp = new Employee("Ramani","Muniyappan");
		CredentialService credentialService = new CredentialService();
		displayMenu();
		int choice = sc.nextInt();
		String email = credentialService.generateEmailAddress(emp, departments[choice -1]);
		String password = credentialService.generatePassword();
		emp.setEmail(email);
		emp.setPassword(password);
		credentialService.showCredentials(emp);
	}
}
