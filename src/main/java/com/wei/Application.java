package com.wei;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.wei.app.utils.application.ApplicationHelper;

@SpringBootApplication
public class Application {

	@Bean
	public Queue queue() {
		return new ActiveMQQueue("sample.queue");
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);

		String[] beanNames = context.getBeanDefinitionNames();
		for (String name : beanNames) {
			System.out.println("**************************");
			System.out.println(name);
			System.out.println("*****************************");
		}
		// context.getBean(ActiveMqProducer.class).send("This is a msg");

		String[] arrBeanNames = ApplicationHelper.getInstance().getContext().getBeanDefinitionNames();

		for (String name : arrBeanNames) {
			System.out.println("**************************");
			System.out.println(name);
			System.out.println("*****************************");
		}
	}

}
