package com.skc.transaction.Service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.skc.transaction.Exception.ServiceException;

@Service
public class TicketServiceImpl implements TicketService {

	public Map<String, Object> getTicketAvailable() throws ServiceException {
			throw new ServiceException("Ticket is not available", 1001);
	}

}
