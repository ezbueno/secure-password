package com.buenoezandro.securepassword.service;

import java.util.List;

public interface PasswordService {
	List<String> validatePassword(String password);
	void validateLength(String password, List<String> failures);
	void validateUpperCase(String password, List<String> failures);
	void validateLowerCase(String password, List<String> failures);
	void validateNumber(String password, List<String> failures);
	void validateSpecialCharacter(String password, List<String> failures);
}