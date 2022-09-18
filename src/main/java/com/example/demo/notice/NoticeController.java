package com.example.demo.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.util.Pager;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/notice/*")  //주솟값(url에 표시되는)
public class NoticeController { 
	
	@Autowired
	private NoticeService NoticeService;
	
	@GetMapping("list")
	public ModelAndView getList(Pager pager) throws Exception { //뒤에 pager가 변수이름 첫번째는 정해져있는 이름
		ModelAndView mv = new ModelAndView();
		List<NoticeVO> notice = NoticeService.getList(pager); 
		/*
		 * if(notice.get(0) == null) System.out.println("null이구나"); else
		 * System.out.println("잘있네");
		 */
		System.out.println(pager.getPerPage());  //ㅍ
		System.out.println(pager.getPn());
		System.out.println(pager.getStartNum());
		System.out.println(pager.getLastNum());
		
		
		mv.addObject("noticeDB", notice);		 //list는 이름 원하는 대로 막 해도됨, notice에서 객체를 가져온다.
		mv.setViewName("notice/list");
		return mv;
	}
	@GetMapping("add")
	public String getAdd(NoticeVO noticeVO) throws Exception{		
		return "notice/add";
	}
	@GetMapping("detail")
	public ModelAndView getDetail(NoticeVO noticeVO) throws Exception{		
		ModelAndView mv = new ModelAndView();
		NoticeVO notice = NoticeService.getDetail(noticeVO); 
		
		//System.out.println(notice.getNoticeFilesVO().getOriName() + "<<<");   //getNoticeFilesVO거를 불러주는 거
	    //System.out.println(notice.getContent() + "<<<");
		mv.addObject("VO", notice);
		mv.setViewName("notice/detail");
		return mv;
	}
	@GetMapping("update")
	 ModelAndView getUpdate(NoticeVO noticeVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		NoticeVO notice = NoticeService.getUpdate(noticeVO); 
		//System.out.println(notice.getNoticeFilesVO().getOriName() + "<<<");
		mv.addObject("VO", notice);
		mv.setViewName("notice/update");
		return mv;
	}
	@GetMapping("delete")
	public String getDelete(NoticeVO noticeVO) throws Exception{
		int notice = NoticeService.getDelete(noticeVO); 
		return "redirect:./list";
	}
	@GetMapping("gtl")
	public String getGtl(NoticeVO noticeVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int notice = NoticeService.getGtl(noticeVO);
		/*mv.addObject("VO", notice);
		mv.setViewName("notice/list"); */
		return "redirect:./list?pn=" + notice;
	}
	/*public String getGtl(NoticeVO noticeVO) throws Exception{
		NoticeVO notice = NoticeService.getGtl(noticeVO);
		return "redirect:./gtl"; //redirect하니까 처음 getmapping:list로 돌아가라는 뜻
	} */
	
	@PostMapping("add")
	public ModelAndView setAdd(NoticeVO noticeVO , MultipartFile file) throws Exception{ //multipartfile은 사진을 받아올때 쓰는 거
		ModelAndView mv = new ModelAndView();
		/*
		 * System.out.println("OriFileName: "+file.getOriginalFilename()); //여기서 받는 이름과
		 * jsp add파일의 이름을 일치시켜줘야한다. System.out.println("size : "+file.getSize());
		 */	
		int result = NoticeService.setAdd(noticeVO, file);  //file을 추가해서 서비스에 넘겨줌.
		System.out.println(result+"개 데이터 저장");
		
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	@PostMapping("update")
	public String setUpdate(NoticeVO noticeVO) throws Exception{
		int result = NoticeService.setUpdate(noticeVO);   //나중에 사용할일이 있음. 카테고리에서 여러개를 바꾼다치면 몇개가 변경됐는지 보여줘야 하므로
		System.out.println();
		return "redirect:./list";  //새로고침 역할
	}
	
	@PostMapping("fileDelete")
	public ModelAndView setfileDelete(NoticeFilesVO noticeFilesVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = 1;
		mv.addObject("result", result);
		mv.setViewName("common/result");
		return mv;
	}
	
}

