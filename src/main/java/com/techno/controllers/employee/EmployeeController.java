package com.techno.controllers.employee;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	private Environment environment;
	
	@GetMapping("get")
	public String getDetails() throws UnknownHostException {
		StringBuilder details = new StringBuilder();
		
	//	String host = environment.getProperty("HOSTNAME");
		String port = environment.getProperty("local.server.port");
		//details.append(host).append(":").append(port);
		details.append("{HostName = ").append( InetAddress.getLocalHost().getHostName());
		details.append(" } { IP = ").append(InetAddress.getLocalHost().getHostAddress()).append(":").append(port).append("}");
		return details.toString();
	}
}
