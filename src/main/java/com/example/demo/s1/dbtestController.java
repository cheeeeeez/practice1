package com.example.demo.s1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/employee/*")
public class dbtestController { 
	
	@Autowired
	private dbtestService dbTestService;
	
	@GetMapping("list")
	public ModelAndView getList() throws Exception {
		ModelAndView mv = new ModelAndView();
		List<dbtestVO> employee = dbTestService.getList();
		mv.addObject("list", employee);
		mv.setViewName("index");
		return mv;
	}
}
