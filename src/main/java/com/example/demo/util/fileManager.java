package com.example.demo.util;

import java.io.File;
import java.util.UUID;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component  //독립된 모듈
public class fileManager {
	
	@Autowired
	private ServletContext servletContext;
	
	public String fileSave(MultipartFile mf, String path) throws Exception{ //noticeservice의 파일매니저에서 만들어준 부분 거기에 해당하는 부분
		path= servletContext.getRealPath(path);
		File file = new File(path);
		if(!file.exists()) { //경로설정의 파일이름이 없으면 만들어줘라.
			file.mkdirs();
		}
		String fileName = UUID.randomUUID().toString(); //파일이름을 랜덤으로 설정해주는 것
		fileName= fileName + "_" + mf.getOriginalFilename(); //오리지널이름까지 붙여주기
		file = new File(file, fileName); //파일에 파일이름을 붙여서 받아온 mf를 
		mf.transferTo(file); //저장시켜주기
		
		return fileName;	
	}
	
	public boolean remove(String fileName, String path) throws Exception{
		path = servletContext.getRealPath(path);
		File file = new File(path, fileName);
		return file.delete();
	}

}
