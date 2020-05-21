package com.apap.finalprojectB6.rest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import com.apap.finalprojectB6.model.SuratModel;
import com.apap.finalprojectB6.model.UserModel;
import com.apap.finalprojectB6.model.UserWebServiceModel;
import com.apap.finalprojectB6.service.RoleService;
import com.apap.finalprojectB6.service.UserService;

//
//
@RestController
@RequestMapping("/perpustakaan")
@CrossOrigin(origins = "*")
public class TuRestController {
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "api/employees")
	private List<UserWebServiceModel> pengguna() {
		List<UserModel> user = userService.getAllUser();
		ArrayList<UserWebServiceModel> restUser = new ArrayList<UserWebServiceModel>();
			for(int i = 0; i<user.size(); i++) {
				UserWebServiceModel getuser = new UserWebServiceModel(user.get(i).getUsername(), user.get(i).getId_role());
				restUser.add(getuser);
			}
		return restUser;
	}
	
	 @PostMapping(value = "api/add-surat")
	 public SuratModel createSurat(@RequestBody SuratModel surat) 
	 {
		LocalDate today = LocalDate.now();
		Date date = Date.valueOf(today);
		surat.setId_jenis_surat(5);
		surat.setNomor_surat("-");
		surat.setStatus(0);
		surat.setKeterangan("Overdue Peminjaman Buku");
		//masih hardcode
		surat.setUuid_user("1");
		surat.setTanggal_pengajuan(date);
		
//		final String url = "https://backend-si.herokuapp.com/pengajuan-surat/add";
		final String url = "https://webservice-situ.free.beeceptor.com/tu/pengajuan-surat";

//		surat = new SuratModel("-", date, null, "Overdue Peminjaman Buku", 0, 5, "1");
	 
	  	RestTemplate restTemplate = new RestTemplate();
	 	SuratModel result = restTemplate.postForObject( url, surat, SuratModel.class);
	 
	    return result;
	 }

}