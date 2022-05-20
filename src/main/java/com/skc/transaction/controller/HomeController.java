package com.skc.transaction.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

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
	
}
