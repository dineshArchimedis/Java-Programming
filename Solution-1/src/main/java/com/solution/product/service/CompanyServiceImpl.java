package com.solution.product.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
//import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//import com.solution.product.config.MailConfig;
import com.solution.product.model.Company;
import com.solution.product.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
//	@Autowired
//	private MailConfig mailConfig;
	
	@Autowired
    private JavaMailSender emailSender;
	
	// Inject BCryptPasswordEncoder
//	@Autowired
//    private final BCryptPasswordEncoder passwordEncoder;
//
//    // Constructor injection for BCryptPasswordEncoder
//    public CompanyServiceImpl(BCryptPasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	// Method to register a new company
	@Override
	public Company registerCompany(Company company) throws Exception {
		// Check if the company object or its mandatory fields are null
		if (company == null || company.getCompanyName() == null || company.getCompanyType() == null
				|| company.getCompanyEmail() == null) {
			throw new IllegalArgumentException("Company object or its mandatory fields are null.");
		}

		// Generate username
		String username = generateUsername(company.getCompanyName());
		company.setUsername(username);

		// Generate password
		String password = generatePassword();
//		company.setPassword(password);
		
		String hashedPassword = this.passwordEncoder.encode(password);
		company.setPassword(hashedPassword);
		
		
		
//		// Hash the password using bcrypt
//        String hashedPassword = passwordEncoder.encode(password);
//        company.setPassword(hashedPassword);

		// Save company to the database
		Company savedCompany = companyRepository.save(company);

		// Send email with username and password (Implement email sending logic here)
		sendEmail(company.getCompanyEmail(), username, password);

		return savedCompany;
	}

	// Method to generate a username based on company details
//	private String generateUsername(String companyName) {
//		// Extracting first 3 letters of company name
//		String companyInitials = companyName.substring(0, Math.min(companyName.length(), 5)).toLowerCase();
//
//		// Extracting first letter of company type
//		// String typeInitial = companyType.substring(0, 1).toLowerCase();
//
//		// Extracting first 3 letters of company email (excluding domain)
//		// int atIndex = companyEmail.indexOf('@');
//		// String emailInitials = companyEmail.substring(0, Math.min(atIndex,
//		// 3)).toLowerCase();
//
//		// Combining initials to generate username
//		// String username = companyInitials + typeInitial + emailInitials +
//		// generateRandomNumbers();
//		String username = companyInitials + generateRandomNumbers();
//
//		return username;
//	}

	private String generateUsername(String companyName) {
		// Extracting first 3 letters of company name while ignoring spaces
		StringBuilder initialsBuilder = new StringBuilder();
		int count = 0;
		for (int i = 0; i < companyName.length() && count < 5; i++) {
			char ch = companyName.charAt(i);
			if (!Character.isWhitespace(ch)) { // Ignore spaces
				initialsBuilder.append(Character.toLowerCase(ch));
				count++;
			}
		}
		String companyInitials = initialsBuilder.toString();

		// Generating random numbers
		String randomNumbers = generateRandomNumbers();

		// Combining initials and random numbers to generate username
		String username = "admin_"+companyInitials + randomNumbers;

		return username;
	}

	// Method to generate a random string of numbers
//    private String generateRandomNumbers() {
//        Random random = new Random();
//        int randomNumber = random.nextInt(1000); // Generating a random number between 0 and 999
//        return String.format("%03d", randomNumber); // Formatting the number to have 3 digits
//    }

	// Method to generate a random string of numbers with only 2 digits changing
	private String generateRandomNumbers() {
		Random random = new Random();
		int randomNumber1 = random.nextInt(10); // Generating a random number between 0 and 9 for the first digit
		int randomNumber2 = random.nextInt(10); // Generating a random number between 0 and 9 for the second digit
		return String.format("%d%d", randomNumber1, randomNumber2); // Formatting the numbers to have 1 digit each
	}

	// Method to generate a random password
	private String generatePassword() {
		// Defining the characters to be used in the password
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
		StringBuilder password = new StringBuilder();
		Random random = new Random();

		// Generating password of length 8
		for (int i = 0; i < 8; i++) {
			int index = random.nextInt(characters.length());
			password.append(characters.charAt(index));
		}

		return password.toString();
	}

	// Placeholder method for sending an email with username and password
	
	//correct code 
//	private void sendEmail(String recipientEmail, String username, String password) {
//		// Implement email sending logic here
//		System.out.println("Email sent to: " + recipientEmail);
//		System.out.println("Username: " + username);
//		System.out.println("Password: " + password);
//	}
	
    // Placeholder method for sending an email with username and password
    private void sendEmail(String recipientEmail, String username, String password) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Your Account Information");
        message.setText("Dear User,\n\nYour account credentials are as follows:\n\nUsername: " + username + "\nPassword: " + password);

        try {
        	emailSender.send(message);
            System.out.println("Email sent successfully to: " + recipientEmail);
        } catch (MailException ex) {
            // Handle exception properly
            ex.printStackTrace();
        }
    }
}


