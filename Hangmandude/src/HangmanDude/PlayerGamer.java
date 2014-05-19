package HangmanDude;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.Random;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.listener.SimpleMessageListenerContainer;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;



public class PlayerGamer {
	public static String ACTIVEMQ_URL = "tcp://mmenarini.ucsd.edu:61616";
	public static String USERNAME = "student";	
	public static String PASSWORD = "cse110";	
	/* 
	 * All Topics and Queues must start with TEAM.XX. 
	 * where you should change XX with your team number.
	*/
	public static String QUEUEPREFIX = "TEAM.17.";
	public static String WORD_QUEUE = "TEAM.17.WORD_QUEUE";
	
	
	static private class CloseHook extends Thread {
		ActiveMQConnection connection;
		private CloseHook(ActiveMQConnection connection) {
			this.connection = connection;
		}
		
		public static Thread registerCloseHook(ActiveMQConnection connection) {
			Thread ret = new CloseHook(connection);
			Runtime.getRuntime().addShutdownHook(ret);
			return ret;
		}
		
		public void run() {
			try {
				System.out.println("Closing ActiveMQ connection");
				connection.close();
			} catch (JMSException e) {
				/* 
				 * This means that the connection was already closed or got 
				 * some error while closing. Given that we are closing the
				 * client we can safely ignore this.
				*/
			}
		}
	}
	public static Session createSession() throws JMSException {
		 ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
					USERNAME, PASSWORD, ACTIVEMQ_URL);
		 Connection connection = connectionFactory.createConnection();
		 connection.start();
		 Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		 return session;
		
	}
	
	
	public static String getItemFromWordQueue(String queue_name, Session session) throws JMSException {
    Destination destination = session.createQueue(queue_name);
    MessageConsumer consumer = session.createConsumer(destination);
    TextMessage message = (TextMessage) consumer.receive();
    consumer.close();
    return message.getText();
	}
	//Returns new queue name
	public static void addWordToQueue(final String word, String queue, Session session) throws JMSException, URISyntaxException {
       Queue destQueue = session.createQueue(queue);
       MessageProducer producer = session.createProducer(destQueue);
       producer.send(session.createTextMessage((word)));
		producer.close();
	}
	
	
	
	
	public static void main(String...args) throws InterruptedException, JMSException, IOException, URISyntaxException {
	    
		Session session = createSession();
	    // Comment the following line after configured.
        //org.apache.log4j.BasicConfigurator.configure();
	    
	    
	    String word = null;
		while(true) {
			word = getItemFromWordQueue(WORD_QUEUE, session);
			if(word != null)
				break;
			Thread.sleep(1000);
				
		}
		int index = word.indexOf(",");
		
		String queue_name = word.substring(index+1,word.length());
		while(true) {
			System.out.print("Make a guess: ");
			BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
			String read = in.readLine();
			if(read.equalsIgnoreCase("quit")) {
				break;
			}
			addWordToQueue(read, QUEUEPREFIX+queue_name, session);
		}
		session.close();

	}
}
