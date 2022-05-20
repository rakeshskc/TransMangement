package com.skc.transaction.controller;

import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skc.transaction.model.FormModel;

@Controller
@RequestMapping("/")
public class HomeController {

	private static Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/")
	public String index(Map<String, Object> model) {
		model.putIfAbsent("message", "Welcome to my page");
		return "index";
	}

	@GetMapping("/download/{fileName}")
	public void download(@PathVariable String fileName, HttpServletRequest request, HttpServletResponse resp) {
		try {
			resp.addHeader("Content-Type", MediaType.APPLICATION_PDF_VALUE);
			resp.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".pdf");
			IOUtils.copy(new ClassPathResource("temp/sample.pdf").getInputStream(), resp.getOutputStream());
			resp.flushBuffer();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	// Path Variable example
	@GetMapping("/page/{pageNumber}")
	public @ResponseBody String getPageNumber(@PathVariable int pageNumber) {
		return "Hi, you are at page " + pageNumber;
	}
	
	// Redirect to view page example.
	@GetMapping("/helloview")
	public String helloView(Model m) {		
		m.addAttribute("msg", "Welcome to my page!!!");
		return "helloview";
	}
	
	// Form Post example.
	@PostMapping(path = "/form-post",
			consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE
				}
	)
	public String login(HttpServletRequest req, HttpServletResponse resp,Model model) {
		String userName = req.getParameter("userName");
		String passWord = req.getParameter("password");
		if( Objects.nonNull(userName)) {
			if(userName.equalsIgnoreCase("rakesh")) {
				model.addAttribute("msg", userName);
				return "home";
			}
		}		
		return "index";
	}
	
	// Form Post to JAVA Object.
	// https://www.baeldung.com/spring-request-response-body
	// PRG Flow
	// As we're accepting user input through the browser feedback form,
	// we must implement the POST/REDIRECT/GET (PRG) submission workflow to avoid duplicate 
	// submissions.
	@PostMapping(path="/form-post-java-model",
			 consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public @ResponseBody String login2(FormModel model) {
		logger.debug("UserName:\t" + model.getUserName() );
		return "Data Posted "+ model;		
	}
	
}
