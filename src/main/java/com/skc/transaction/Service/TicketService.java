package com.skc.transaction.Service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.skc.transaction.Exception.ServiceException;

@Service
public interface TicketService {

	public Map<String, Object> getTicketAvailable() throws ServiceException;

}
