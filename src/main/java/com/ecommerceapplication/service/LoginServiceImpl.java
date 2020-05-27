package com.ecommerceapplication.service;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerceapplication.dto.UserDto;
import com.ecommerceapplication.exception.UserNotFoundException;
import com.ecommerceapplication.model.User;
import com.ecommerceapplication.repositroy.UserRepository;
@Service
@Transactional
public class LoginServiceImpl implements LoginService{
	@Autowired
	UserRepository loginRepository;
	private User user = new User();
	@Override
	public User login( @Valid UserDto userDto) throws UserNotFoundException {
		
		BeanUtils.copyProperties(userDto, user);

		User login = loginRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
		if (login == null) {
			throw new UserNotFoundException("plase enter user name and password");
		}
		
		return login;
	}
}


