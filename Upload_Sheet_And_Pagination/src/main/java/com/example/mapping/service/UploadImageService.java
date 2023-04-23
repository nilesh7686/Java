package com.example.mapping.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadImageService {

	public final String upload_dir = "C:\\Users\\niles\\Documents\\workspace-spring-tool-suite-4-4.17.0.RELEASE\\Upload_Sheet_And_Pagination\\src\\main\\resources\\static\\Images";

	public boolean upload(MultipartFile file) {
		boolean f = false;
		try {
			//Files.copy(file.getInputStream(), upload_dir ,
					//StandardCopyOption.REPLACE_EXISTING);
			Files.copy(file.getInputStream(),Paths.get(upload_dir+File.separator+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		f = true;

		return f;
	}

}
