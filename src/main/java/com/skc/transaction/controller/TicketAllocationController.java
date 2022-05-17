package com.skc.transaction.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skc.transaction.Exception.ServiceException;
import com.skc.transaction.Service.TicketService;
import com.skc.transaction.model.ResponseResultBody;
import com.skc.transaction.utils.Constant;

@RestController
@RequestMapping(value = "/api/v")
public class TicketAllocationController {

	@Autowired
	TicketService ticketService;

	@GetMapping(value = "/ticket")
	public @ResponseBody ResponseResultBody getTickeAvailability() throws ServiceException {		
	//	this.ticketService.getTicketAvailable();		
		return new ResponseResultBody(Constant.SUCCESS, HttpStatus.OK.value(), new HashMap<String, Object>());
	}

	

}
