package com.skc.transaction.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
