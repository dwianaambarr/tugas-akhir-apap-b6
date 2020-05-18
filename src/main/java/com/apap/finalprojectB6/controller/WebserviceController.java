package com.apap.finalprojectB6.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
import com.apap.finalprojectB6.model.UserWebServiceModel;
import com.apap.finalprojectB6.service.RoleService;
import com.apap.finalprojectB6.service.UserService;

//
//
@RestController
@RequestMapping("/perpustakaan")
@CrossOrigin(origins = "*")
public class WebserviceController {
	@Autowired
	private UserService userService;

	
//	@GetMapping(value = "/getuser")
//	public String getAllUser(Model model) 
//	{
//		String url = "https://webservice-situ.free.beeceptor.com/perpustakaan/user/viewall";
//	    RestTemplate restTemplate = new RestTemplate();
//	    String result = restTemplate.getForObject(url, String.class);
//	     
//	    return result;
//	}
	
	@GetMapping(value = "/user/viewall")
	private List<UserWebServiceModel> pengguna() {
		List<UserModel> user = userService.getAllUser();
		ArrayList<UserWebServiceModel> restUser = new ArrayList<UserWebServiceModel>();
			for(int i = 0; i<user.size(); i++) {
				UserWebServiceModel getuser = new UserWebServiceModel(user.get(i).getUsername(), user.get(i).getId_role());
				restUser.add(getuser);
			}
		return restUser;
	}

}
