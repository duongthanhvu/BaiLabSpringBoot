package com.fpoly.lab1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String loginProcess(ModelMap model, @RequestParam("username") String username, @RequestParam("password") String password) {
		if(username.equals("admin") && password.equals("123456")) {
			return "success";
		}else {
			model.addAttribute("message","Tên người dùng hoặc mật khẩu không chính xác");
			return "login";
		}
	}
}
