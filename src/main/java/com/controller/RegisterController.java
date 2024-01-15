package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.entity.Register;
import com.service.RegisterService;
@RestController
public class RegisterController {

	@Autowired
	private RegisterService registerService;
	@PostMapping("/register")
	public ResponseEntity<Register> register(@RequestBody Register register){
		Register r=this.registerService.register(register);
		if(r==null) {
			return new ResponseEntity<Register>(HttpStatus.ALREADY_REPORTED);
		}
		return new ResponseEntity<>(r,HttpStatus.ACCEPTED);
	}
}
