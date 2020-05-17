package com.apap.finalprojectB6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.apap.finalprojectB6.model.RoleModel;
import com.apap.finalprojectB6.model.UserModel;
import com.apap.finalprojectB6.service.RoleService;
import com.apap.finalprojectB6.service.UserService;

//
//
@RestController
@RequestMapping("/pengguna")
@CrossOrigin(origins = "*")
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	//
	// @RequestMapping(value = "/profile", method = RequestMethod.GET)
	// private String profil(Model model) {
	// UserModel detailUser =
	// userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
	// model.addAttribute("detailUser", detailUser);
	// return "profil/index";
	// }
	//
	@GetMapping(value = "/viewall")
	private List<UserModel> pengguna(Model model) {
		List<UserModel> user = userService.getAllUser();
		return user;
	}
	
	@GetMapping(value = "/detail/{id}")
	private UserModel detail(@PathVariable int id){
		UserModel pengguna = userService.getUserById(id);
		return pengguna;
	}

	@PostMapping(value = "/add")
	private UserModel addSubmit(@RequestBody UserModel pengguna) {
		pengguna.setId_role(5);
		return userService.addUser(pengguna);
	}
}
