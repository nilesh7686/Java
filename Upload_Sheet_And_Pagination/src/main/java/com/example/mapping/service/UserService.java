package com.example.mapping.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.mapping.helper.Helper;
import com.example.mapping.model.User;
import com.example.mapping.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired UserRepository repo;
	

    public void save(MultipartFile file) {

        try {
            List<User> users = Helper.convertExcelToListOfUsers(file.getInputStream());
            this.repo.saveAll(users);
        } catch (IOException e) {
        	 throw new RuntimeException("fail to store excel data: " + e.getMessage());
            
        }

    }

    public List<User> getAllProducts() {
        return this.repo.findAll();
    }


}
