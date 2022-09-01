package com.example.demo.notice;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.util.Pager;
import com.example.demo.notice.NoticeDAO;
import com.example.demo.notice.NoticeVO;

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

}
