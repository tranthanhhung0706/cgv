package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.helper.FileUploadHelper;
import org.springframework.http.MediaType;
import java.io.File;

import org.apache.commons.io.FileUtils;
@RestController
public class FileUploadController {
	@Autowired
	private FileUploadHelper fileUploadHelper;
	
	private String FILE_PATH_ROOT = "C:\\\\Users\\\\ADMIN\\\\Downloads\\\\demo\\\\demo\\\\src\\\\main\\\\resources\\\\static\\\\image\\";
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
		try {
			if (file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
				
			}
			boolean f= fileUploadHelper.uploadFile(file);
			if (f) {
				return ResponseEntity.ok("File is successfully upload ");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some error");
	}
	@GetMapping("image/{fileName}")
	public ResponseEntity<byte[]> showImage(@PathVariable String fileName){
		byte[] image = new byte[0];
        try {
        	image = FileUtils.readFileToByteArray(new File(FILE_PATH_ROOT+fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
	}

}
