package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
	
	@GetMapping("/")
    public ModelAndView start()throws Exception{
        ModelAndView mv = new ModelAndView();

        mv.setViewName("index");

        return mv;
    }
	@GetMapping("/bootstrap")
    public ModelAndView bootstrap()throws Exception{ 
        ModelAndView mv = new ModelAndView();

        mv.setViewName("bootstrap");

        return mv;
    }
	//@GetMapping("/")
	public String home() {
		System.out.println("Home 실행");
		return "Hello boot";
	}

}
