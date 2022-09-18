package com.example.demo.freeBBS;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.util.Pager;
import com.example.demo.util.fileManager;

@Service
@Transactional(rollbackFor = Exception.class)
public class freeBBSService {
	
	@Autowired
	private freeBBSMapper freeBBSMapper;
	
	@Autowired
	private fileManager fileManager;
	
	public List<freeBBSVO> getList(Pager pager) throws Exception{
		pager.makeRow();
		pager.makeNum(freeBBSMapper.getTotalCount(pager)); 
		
		return freeBBSMapper.getList(pager); 
	}
	public List<freeBBSVO> getAdd() throws Exception{  ////get은 리턴값을 받아야하는 경우에 사용
		return freeBBSMapper.getAdd();
	}
	public int setAdd(freeBBSVO freeBBSVO, MultipartFile file) throws Exception{
		int result =  freeBBSMapper.setAdd(freeBBSVO); //multi파일을 추가하기 위한 코드
		
		if(file != null && result >0) {  //file이 null이아니고 결과가 0이 아니어야 한다. 그래서 파일을 하나이상 추가할때! 조건문임
			//1. File을 HDD에 저장, 컴퓨터 내 파일에 저장되는 이름 설정
			String fileName = fileManager.fileSave(file, "resources/upload/freebbs/");
			System.out.println(fileName);
			//2. 저장된 정보를 DB에 저장
			freeBBSFilesVO freeBBSFilesVO = new freeBBSFilesVO();
			Long num = Long.valueOf(freeBBSVO.getNum()); 
			freeBBSFilesVO.setFreeBBSNum(num);
			freeBBSFilesVO.setFileName(fileName); 
			freeBBSFilesVO.setOriName(file.getOriginalFilename()); 
			result = freeBBSMapper.setFileAdd(freeBBSFilesVO);
			
			if(result < 1) {
				//notice table insert한 것도 rollback
				throw new SQLException();
			}
			
		}
		
		return result;
	}
	public freeBBSVO getDetail(freeBBSVO chai) throws Exception{  //받아오는 값은 변수타입과 변수명을 적어줘야된다. 변수명은 아무거나 해줘도 된다.
		return freeBBSMapper.getDetail(chai);                    //여기 2개는 일치시켜줘야 함!
	}
	
	public freeBBSVO getUpdate(freeBBSVO lee) throws Exception{
		return freeBBSMapper.getUpdate(lee);
	}
	public int getGtl(freeBBSVO freeBBSVO) throws Exception{
		int result = freeBBSMapper.getGtl(freeBBSVO);
		result = result /10 + 1;
		System.out.println(result);
		return result;
	}
	public int setUpdate(freeBBSVO freeBBSVO) throws Exception{  //set은 값을 저장하게 유도하는 메소드
		return freeBBSMapper.setUpdate(freeBBSVO);
	}
	public int getDelete(freeBBSVO freeBBSVO) throws Exception{
		return freeBBSMapper.getDelete(freeBBSVO);
	}

}