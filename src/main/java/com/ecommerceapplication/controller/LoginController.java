package com.ecommerceapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerceapplication.dto.ResponseDto;
import com.ecommerceapplication.dto.UserDto;
import com.ecommerceapplication.exception.UserNotFoundException;
import com.ecommerceapplication.service.LoginService;

@RestController
public class LoginController {
	@Autowired
	LoginService loginService;

	private ResponseDto Responsedto = new ResponseDto();

	@PostMapping(value = "/login")
	public ResponseEntity<ResponseDto> login(@RequestBody UserDto userDto) throws UserNotFoundException {

		loginService.login(userDto);
		Responsedto.setMessage("user Sucessfully login");
		return new ResponseEntity<>(Responsedto, HttpStatus.OK);

	}
}
