package com.example.demo.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.aspectj.weaver.StandardAnnotation;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	public static final String UPLOAD_DIR=".\\src\\main\\resources\\static\\image\\";
	public boolean uploadFile(MultipartFile multipartFile) {
		boolean f=false;
		try {
//		InputStream	is= multipartFile.getInputStream();
//		byte data[]=new byte[is.available()];
//		is.read(data);
//		FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+"\\"+multipartFile.getOriginalFilename());
//		fos.write(data);
//		fos.flush();
//		fos.close();
		Files.copy(multipartFile.getInputStream(),Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
		f=true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}
}
