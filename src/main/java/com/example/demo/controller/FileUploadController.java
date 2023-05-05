package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.ApiResponse;
import com.example.demo.helper.FileUploadHelper;
import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;



import org.springframework.http.MediaType;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.apache.commons.io.FileUtils;

@RestController
public class FileUploadController {
	@Autowired
	private FileUploadHelper fileUploadHelper;

	@Autowired
	private MovieService movieService;

	private String FILE_PATH_ROOT = "C:\\\\Users\\\\ADMIN\\\\Downloads\\\\demo\\\\demo\\\\src\\\\main\\\\resources\\\\static\\\\image\\";
	// @PostMapping("/upload-file")
	// public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
	// 	try {
	// 		if (file.isEmpty()) {
	// 			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");

	// 		}
	// 		boolean f = fileUploadHelper.uploadFile(file);
	// 		if (f) {
	// 			return ResponseEntity.ok(file.getOriginalFilename());
	// 		}
	// 	} catch (Exception e) {
	// 		// TODO: handle exception
	// 		e.printStackTrace();
	// 	}
	// 	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some error");
	// }

	@PostMapping("/uploadImageToString")
	public ResponseEntity<Object> uploadImagetoString(@RequestParam("file") MultipartFile file) throws IOException {
	
		if (file.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");

		}
		byte[] bytes = file.getBytes();
		String base64String = Base64.getEncoder().encodeToString(bytes);
		return ResponseEntity.ok(base64String);
	}

	// @GetMapping("image/{fileName}")
	// public ResponseEntity<byte[]> showImage(@PathVariable String fileName) {
	// 	byte[] image = new byte[0];
	// 	try {
	// 		image = FileUtils.readFileToByteArray(new File(FILE_PATH_ROOT + fileName));
	// 	} catch (Exception e) {
	// 		e.printStackTrace();
	// 	}
	// 	return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
	// }


	@PostMapping("/uploadImage")
	public ResponseEntity<Object> uploadImage(@RequestParam("file") MultipartFile file) {
		try {
			if (file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");

			}
			boolean f = fileUploadHelper.uploadFile(file);
			if (f) {
				return ResponseEntity.ok(file.getOriginalFilename());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some error");
	}


	private byte[] getImage(String nameImage) throws IOException {
		byte[] image = new byte[0];
		image = FileUtils.readFileToByteArray(new File(FileUploadHelper.UPLOAD_DIR + nameImage));

		return image;
	}

	@GetMapping("largeImage/{idMovie}")
	public ResponseEntity<byte[]> showImageMovie(@PathVariable int idMovie) throws IOException {

		Movie movieExisting = movieService.FindById(idMovie);
		if (movieExisting == null) {
			ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(HttpStatus.NOT_FOUND.value(), "Movie not found", null));
		}
		String largeImage = movieExisting.getLargeImageURL();
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(getImage(largeImage));
	}

	@GetMapping("smallImage/{idMovie}")
	public ResponseEntity<byte[]> showSmallImageMovie(@PathVariable int idMovie) throws IOException {

		Movie movieExisting = movieService.FindById(idMovie);
		if (movieExisting == null) {
			ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(HttpStatus.NOT_FOUND.value(), "Movie not found", null));
		}
		String smallImage = movieExisting.getSmallImageURl();

		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(getImage(smallImage));
	}

}
