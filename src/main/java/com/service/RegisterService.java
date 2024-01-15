package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.RegisterDao;
import com.entity.Register;

@Service
public class RegisterService {
	@Autowired
	private RegisterDao registerDao;
	
	public Register register(Register register) {
		try {
			Optional<Register> r=this.registerDao.findById(register.getEmail());
			if(r.isPresent()) {
				return null;
			}
			return this.registerDao.save(register);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception Occured");
			return null;
		}
	}

}
