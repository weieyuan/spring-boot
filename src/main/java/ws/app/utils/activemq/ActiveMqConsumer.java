package ws.app.utils.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqConsumer {

	@JmsListener(destination = "sample.queue")
	public void receiveQueue(String msg) {
		System.out.println("Reveive msg is " + msg);
	}

}
