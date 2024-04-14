package com.buenoezandro.securepassword.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.buenoezandro.securepassword.service.PasswordService;

@Service
public class PasswordServiceImpl implements PasswordService {
	@Override
	public List<String> validatePassword(String password) {
		List<String> failures = new ArrayList<>();
		this.validateLength(password, failures);
		this.validateUpperCase(password, failures);
		this.validateLowerCase(password, failures);
		this.validateNumber(password, failures);
		this.validateSpecialCharacter(password, failures);
		return failures;
	}

	@Override
	public void validateLength(String password, List<String> failures) {
		if (password != null && password.length() < 8) {
			failures.add("The password must have at least 8 characters.");
		}
	}

	@Override
	public void validateUpperCase(String password, List<String> failures) {
		if (!Pattern.matches(".*[A-Z].*", password)) {
			failures.add("The password must have at least one uppercase letter.");
		}
	}

	@Override
	public void validateLowerCase(String password, List<String> failures) {
		if (!Pattern.matches(".*[a-z].*", password)) {
			failures.add("The password must have at least one lowercase letter.");
		}
	}

	@Override
	public void validateNumber(String password, List<String> failures) {
		if (!Pattern.matches(".*\\d.*", password)) {
			failures.add("The password must have at least one number.");
		}
	}

	@Override
	public void validateSpecialCharacter(String password, List<String> failures) {
		if (!Pattern.matches(".*[\\W].*", password)) {
			failures.add("The password must have at least one special character.");
		}
	}
}