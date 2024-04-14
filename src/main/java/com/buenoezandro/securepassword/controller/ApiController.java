package com.buenoezandro.securepassword.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.buenoezandro.securepassword.service.PasswordService;

@RestController
public class ApiController {
	private final PasswordService passwordService;

	public ApiController(PasswordService passwordService) {
		this.passwordService = passwordService;
	}

	@PostMapping(value = "/validate-password")
	public ResponseEntity<FailureResponse> validatePassword(@RequestBody Request request) {
		var failures = this.passwordService.validatePassword(request.password());
		return failures.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.badRequest().body(new FailureResponse(failures));
	}
}