package com.example.mapping.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.mapping.helper.Helper;
import com.example.mapping.model.User;
import com.example.mapping.response.ResponseMessage;
import com.example.mapping.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService service;

	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> upload(@RequestParam("file") MultipartFile file) {
		String message = "";
		if (Helper.checkExcelFormat(file)) {
			// true
			try {
				this.service.save(file);

				message = "uploaded file sucessfully";
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			} catch (Exception e) {
				// TODO: handle exception
				message = "Could not upload the file: " + file.getOriginalFilename() + "!";
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
			}

		} message = "please upload an excel file";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllProduct() {
		try {
			List<User> users = this.service.getAllProducts();
			if(users.isEmpty()) {
				   return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(users, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}

}
