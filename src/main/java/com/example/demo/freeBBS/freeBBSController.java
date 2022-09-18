package com.example.demo.freeBBS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.util.Pager;


@Controller
@RequestMapping("/freeBBS/*")  //주솟값(url에 표시되는)
public class freeBBSController { 
	
	@Autowired
	private freeBBSService freeBBSService; //필요한 의존 객체의 타입에 해당하는 빈을 찾아 주입해준다. (생성자, setter, 필드)
	
	@GetMapping("list") //getmapping은 메소드에만 적용
	public ModelAndView getList(Pager pager) throws Exception { //첫번째는 받아오는 메소드의 이름, 두번째는 내가 정하는 변수이름
		ModelAndView modelview = new ModelAndView(); //메소드는 객체의 기능!, 필드는 객체의 상태
		List<freeBBSVO> freeBBS = freeBBSService.getList(pager); 
		modelview.addObject("freeBBSDB", freeBBS);		 
		modelview.setViewName("freeBBS/list");
		return modelview;
	}
	@GetMapping("add") 
	public String getAdd(freeBBSVO freeBBSVO) throws Exception{		
		return "freeBBS/add";
	}
	@GetMapping("detail")
	public ModelAndView getDetail(freeBBSVO freeBBSVO) throws Exception{		
		ModelAndView modelview = new ModelAndView();
		freeBBSVO freeBBS = freeBBSService.getDetail(freeBBSVO); //VO타입, service에서 디테일을 받아온다. 
		
		
		
		modelview.addObject("VO", freeBBS);
		modelview.setViewName("freeBBS/detail");
		return modelview;
	}
	@GetMapping("update")
	 ModelAndView getUpdate(freeBBSVO freeBBSVO) throws Exception{		
		ModelAndView modelview = new ModelAndView();
		freeBBSVO freeBBS = freeBBSService.getUpdate(freeBBSVO); 
		modelview.addObject("VO", freeBBS);
		modelview.setViewName("freeBBS/update");
		return modelview;
	}
	@GetMapping("delete")
	public String getDelete(freeBBSVO freeBBSVO) throws Exception{
		int result = freeBBSService.getDelete(freeBBSVO); 
		return "redirect:./list";  //새로고침 역할
	}
	@GetMapping("gtl")
	public String getGtl(freeBBSVO freeBBSVO) throws Exception {	
		ModelAndView mv = new ModelAndView();
		int result = freeBBSService.getGtl(freeBBSVO);
		return "redirect:./list?pn=" + result;
	}
	@PostMapping("add")  //주소창에 파라미터가 노출되지 않는다.
	public ModelAndView setAdd(freeBBSVO freeBBSVO, MultipartFile file) throws Exception{  //사진을 받아오기 위해 multipartfile 추가로 사용
		ModelAndView mv = new ModelAndView(); // 사진 객체를 담아오기 위해 MV 사용
		int result = freeBBSService.setAdd(freeBBSVO, file); //위의 메소드 중 뒤의 2개를 서비스에 넘겨준다.
		System.out.println(result+"개 데이터 저장");
		mv.setViewName("redirect:./list");
		return mv;  //새로고침 역할
	}
	@PostMapping("update")
	public String setUpdate(freeBBSVO freeBBSVO) throws Exception{
		int result = freeBBSService.setUpdate(freeBBSVO);
		System.out.println();
		return "redirect:./list";  //새로고침 역할
	}
	
	@PostMapping("fileDelete")
	public ModelAndView setfileDelete(freeBBSFilesVO freeBBSFilesVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = 1;  //만약 사진이 삭제됐다면 html 창에서 f12로 확인할 시 1이 출력됨.
		mv.addObject("result", result);
		mv.setViewName("common/result");
		return mv;
	}
		
}
