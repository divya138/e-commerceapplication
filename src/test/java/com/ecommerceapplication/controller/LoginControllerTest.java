package com.ecommerceapplication.controller;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner.Silent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ecommerceapplication.dto.ResponseDto;
import com.ecommerceapplication.dto.UserDto;
import com.ecommerceapplication.exception.UserNotFoundException;
import com.ecommerceapplication.model.User;
import com.ecommerceapplication.service.LoginServiceImpl;

@RunWith(Silent.class)
public class LoginControllerTest {
	@InjectMocks
	LoginController logincontroller;
	@Mock
	LoginServiceImpl userloginService;
	private User user;
	static UserDto login = null;

	@BeforeClass
	public static void setUp() {
		login = new UserDto();
	}

	@Test
	public void testforUserLogin() throws UserNotFoundException {
		login.setEmail("divya@gmail.com");
		login.setPassword("sam");
		UserDto userDto = null;
		Mockito.when(userloginService.login(userDto)).thenReturn(user);
		ResponseEntity<ResponseDto> result = logincontroller.login(userDto);
		Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
	}
	@Test
	public void testforUserLoginNegi() throws UserNotFoundException {
		login.setEmail("divya");
		login.setPassword("sa222");
		UserDto userDto = null;
		Mockito.when(userloginService.login(userDto)).thenReturn(user);
		ResponseEntity<ResponseDto> result = logincontroller.login(userDto);
		Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
	}
	@Test
	public void testforUserLoginNegisa() throws UserNotFoundException {
		login.setEmail("-divya");
		login.setPassword("sa222");
		UserDto userDto = null;
		Mockito.when(userloginService.login(userDto)).thenReturn(user);
		ResponseEntity<ResponseDto> result = logincontroller.login(userDto);
		Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
	}
	@Test
	public void testforUserBothnegative() throws UserNotFoundException {
		login.setEmail("-divya");
		login.setPassword("-sa222");
		UserDto userDto = null;
		Mockito.when(userloginService.login(userDto)).thenReturn(user);
		ResponseEntity<ResponseDto> result = logincontroller.login(userDto);
		Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
	}

	@AfterClass
	public static void tearDown() {
		login = null;
	}

}
