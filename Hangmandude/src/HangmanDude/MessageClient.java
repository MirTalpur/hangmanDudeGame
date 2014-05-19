package HangmanDude;

import javax.jms.MessageProducer;
import javax.jms.Session;

public class MessageClient {
	public Session session;
	public MessageProducer producer;
	
	public MessageClient(Session session, MessageProducer producer) {
		this.session = session;
		this.producer = producer;
	}
}
