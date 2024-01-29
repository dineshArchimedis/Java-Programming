package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.UserDAO;
import com.example.demo.model.AddUser;

@Controller
public class UserController {
	
	@Autowired
	UserDAO userdao;
	
	@RequestMapping("index")
	public String user() {
		return "index.jsp";
	}
	@RequestMapping("addUser")
	public String addUser(AddUser user) {
		userdao.save(user);
		return "index.jsp";
	}
	
	@RequestMapping("getUser")
	public ModelAndView getUser(@RequestParam int id) {
		ModelAndView mav = new ModelAndView("showUser.jsp");
		AddUser addUser=userdao.findById(id).orElse(new AddUser());
		mav.addObject(addUser);
		return mav;
	}
	
	@RequestMapping("deleteUser")
	public ModelAndView deleteUser(@RequestParam int id) {
		ModelAndView mav = new ModelAndView("deleteUser.jsp");
		AddUser addUser=userdao.findById(id).orElse(new AddUser());
		userdao.deleteById(id);
		mav.addObject(addUser);
		return mav;
	}
	
	@RequestMapping("updateUser")
	public ModelAndView updateUser(AddUser user) {
		ModelAndView mav = new ModelAndView("updateUser.jsp");
		AddUser addUser=userdao.findById(user.getId()).orElse(new AddUser());
		userdao.deleteById(user.getId());
		mav.addObject(addUser);
		return mav;
	}
	
	
	
}
