package com.yash.aws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yash.aws.command.UserLoginCommand;
import com.yash.aws.command.UserRegistrationCommand;
import com.yash.aws.dao.UserDao;
import com.yash.aws.dao.UserDetailDao;
import com.yash.aws.exception.UserAuthenticationException;
import com.yash.aws.model.User;
import com.yash.aws.model.UserDetail;
import com.yash.aws.service.UserDetailService;
import com.yash.aws.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	UserDetailService userDetailService;
	
	@Autowired
	UserDao userDao;
	@Autowired
	UserDetailDao detailDao;
	
	@RequestMapping(value="/registration.htm")
	public String showUserRegistration(Model model) {
		
		model.addAttribute("command", new UserRegistrationCommand());
		
		return "util/register";
	}
	
	@RequestMapping(value="/processRegistration.htm", method=RequestMethod.POST)
	public String processUserRegistration(@ModelAttribute("command") UserRegistrationCommand userRegistrationCommand, Model model) {
		User user = new User();
		user.setEmail(userRegistrationCommand.getEmail());
		user.setUserName(userRegistrationCommand.getUserName());
		user.setPassword(userRegistrationCommand.getPassword());
		
		UserDetail userDetail = new UserDetail();
		userDetail.setUser(user);
		userDetail.setFirstName(userRegistrationCommand.getFirstName());
		userDetail.setLastName(userRegistrationCommand.getLastName());
		userDetail.setPhoneNumber(userRegistrationCommand.getPhoneNumber());
		userDetail.setAddress(userRegistrationCommand.getAddress());
		
		//User registeredUser = userService.registerUser(user);
		
		//userDetail.setUser(registeredUser);
		userDetailService.setUserDetail(userDetail);

		model.addAttribute("userDetail", userDetail);
		model.addAttribute("command",new UserLoginCommand());
		
		return "util/login";
	}
	
	@RequestMapping("/login.htm")
	public String loginUser(Model model) {
		model.addAttribute("command",new UserLoginCommand());
		return "util/login";
	}
	
	@RequestMapping(value="/loginUser.htm", method=RequestMethod.POST)
	public String loginUser(@ModelAttribute("command") UserLoginCommand userLoginCommand, Model model) {
		
		String redirect = "util/login";
		
		String userName = userLoginCommand.getUserName();
		String password = userLoginCommand.getPassword();
		
		try {
			User user = userService.authenticate(userName, password);
			UserDetail details = userDetailService.findUserInfo(user);
			
			model.addAttribute("user",user);
			model.addAttribute("details", details);
			redirect = "dashboard";
			
		} catch (UserAuthenticationException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return redirect;
	}
	
}
