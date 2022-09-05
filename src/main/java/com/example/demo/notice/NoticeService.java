package com.example.demo.notice;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.util.Pager;
import com.example.demo.notice.NoticeVO;
import com.example.demo.s1.dbtestVO;

@Service
@Transactional(rollbackFor = Exception.class)
public class NoticeService {
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	public List<NoticeVO> getList(Pager pager) throws Exception{
		pager.makeRow();
		pager.makeNum(noticeMapper.getTotalCount(pager)); //여기에 줄 개수 넣어주는거
		return noticeMapper.getList(pager);
	}
	public List<NoticeVO> getAdd() throws Exception{
		return noticeMapper.getAdd();
	}
	public int setAdd(NoticeVO noticeVO) throws Exception{
		return noticeMapper.setAdd(noticeVO);
	}
	public NoticeVO getDetail(NoticeVO chang) throws Exception{  //받아오는 값은 변수타입과 변수명을 적어줘야된다. 변수명은 아무거나 해줘도 된다.
		return noticeMapper.getDetail(chang);                    //여기 2개는 일치시켜줘야 함!
	}
	public NoticeVO getUpdate(NoticeVO lee) throws Exception{
		return noticeMapper.getUpdate(lee);
	}
	public int getGtl(NoticeVO noticeVO) throws Exception{
		int result = noticeMapper.getGtl(noticeVO); //java에서 페이지 처리를 한 방법
		result = result / 10 +1;
		System.out.println(result);
		return result;				
	}
	public int setUpdate(NoticeVO noticeVO) throws Exception{
		return noticeMapper.setUpdate(noticeVO);
	}
	public int getDelete(NoticeVO noticeVO) throws Exception{
		return noticeMapper.getDelete(noticeVO);
	}

}
