package com.example.demo.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.notice.NoticeVO;
import com.example.demo.util.Pager;
import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/notice/*")  //주솟값(url에 표시되는)
public class NoticeController { 
	
	@Autowired
	private NoticeService NoticeService;
	
	@GetMapping("list")
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<NoticeVO> notice = NoticeService.getList(pager); 
		/*
		 * if(notice.get(0) == null) System.out.println("null이구나"); else
		 * System.out.println("잘있네");
		 */
		System.out.println(pager.getPerPage());
		System.out.println(pager.getPn());
		System.out.println(pager.getStartNum());
		System.out.println(pager.getLastNum());
		
		
		mv.addObject("noticeDB", notice);		 //list는 이름 원하는 대로 막 해도됨
		mv.setViewName("notice/list");
		return mv;
	}
	@GetMapping("write")
	public ModelAndView getList() throws Exception {
		ModelAndView mv = new ModelAndView();
		List<NoticeVO> notice = NoticeService.getList();
		mv.addObject("listt", notice);
		mv.setViewName("notice/list/write");
		return mv;
	}
}
