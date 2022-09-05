package com.example.demo.freeBBS;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.util.Pager;

@Service
@Transactional(rollbackFor = Exception.class)
public class freeBBSService {
	
	@Autowired
	private freeBBSMapper freeBBSMapper;
	
	public List<freeBBSVO> getList(Pager pager) throws Exception{
		pager.makeRow();
		pager.makeNum(freeBBSMapper.getTotalCount(pager)); 
		
		return freeBBSMapper.getList(pager); 
	}
	public List<freeBBSVO> getAdd() throws Exception{  ////get은 리턴값을 받아야하는 경우에 사용
		return freeBBSMapper.getAdd();
	}
	public int setAdd(freeBBSVO freeBBSVO) throws Exception{
		return freeBBSMapper.setAdd(freeBBSVO);
	}
	public freeBBSVO getDetail(freeBBSVO chai) throws Exception{  //받아오는 값은 변수타입과 변수명을 적어줘야된다. 변수명은 아무거나 해줘도 된다.
		return freeBBSMapper.getDetail(chai);                    //여기 2개는 일치시켜줘야 함!
	}
	
	public freeBBSVO getUpdate(freeBBSVO lee) throws Exception{
		return freeBBSMapper.getUpdate(lee);
	}
	public int setUpdate(freeBBSVO freeBBSVO) throws Exception{  //set은 값을 저장하게 유도하는 메소드
		return freeBBSMapper.setUpdate(freeBBSVO);
	}
	public int getDelete(freeBBSVO freeBBSVO) throws Exception{
		return freeBBSMapper.getDelete(freeBBSVO);
	}

}