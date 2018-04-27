package com.myboard.web.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myboard.aop.AOPMapper;
import com.myboard.aop.AOPModel;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private AOPMapper aopMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping
	public String getHomeView(HttpServletRequest request) {
		logger.info("GET: " + request.getRequestURI());
		return "home";
	}
	
	@GetMapping("/AOP")
	public ModelAndView getAOPView() {
		ArrayList<AOPModel> aopresult = aopMapper.selectAll();
		ModelAndView view = new ModelAndView();
		view.setViewName("AOPview");
		view.addObject("aopresult", aopresult);	
		return view;
	}
	
	@GetMapping("/404.html")
	public String get404View() {
		return "error/404";
	}
	
	@GetMapping("/throw")
	public String testControllerAdvice() {
		throw new RuntimeException("Error Test In Controller.");
	}
}
