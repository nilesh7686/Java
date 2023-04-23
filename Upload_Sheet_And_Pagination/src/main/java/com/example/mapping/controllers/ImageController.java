package com.example.mapping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.mapping.model.User;
import com.example.mapping.service.UploadImageService;

@RestController
public class ImageController {
	@Autowired
	UploadImageService service;
	
	  @RequestMapping(value = "/Image", method = RequestMethod.POST)
	    public ResponseEntity<String> imageUpload(@RequestParam("file") MultipartFile file){
		  if (file.isEmpty()) {
			  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("file is empty");
			  
			
		}
		  if (!file.getContentType().equals("image/jpeg")) {
			  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("file is empty");
		}
		  try {
		  boolean f = service.upload(file);
			  if(f) {
				 return ResponseEntity.ok("upload sucessfully"); 
			  }
		  }catch (Exception e) {
			// TODO: handle exception
			  e.printStackTrace();
		}
		  

	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");
	    }
	  

}
