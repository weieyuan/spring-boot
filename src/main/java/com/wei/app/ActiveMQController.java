package com.wei.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wei.app.utils.activemq.ActiveMqProducer;

@RestController
public class ActiveMQController {

	@Autowired
	private ActiveMqProducer activeMqProducer;

	// @GetMapping()
	@RequestMapping(value = "/active/send", method = RequestMethod.GET)
	public void send() {
		this.activeMqProducer.send("This is a message");
	}

}
