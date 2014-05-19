package HangmanDude;
import java.net.URISyntaxException;
import java.util.Random;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;





public class PlayerChallenger {
	public static String ACTIVEMQ_URL = "tcp://mmenarini.ucsd.edu:61616";
	public static String USERNAME = "student";	
	public static String PASSWORD = "cse110";	
	public static String QUEUEPREFIX = "TEAM.17.";
	public static String  WORD_GAME_QUEUE = "WORD_QUEUE";
	
	
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
	
	public static char randomLetter() {
		return  ((char)('a'+ (new Random()).nextInt(26)));
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
	
	
	
	public static void main(String[] args) throws JMSException, URISyntaxException {
	    
	    // Comment the following line after configured.
	    //org.apache.log4j.BasicConfigurator.configure();
	    
	    final Session session = createSession();
	    final String queue_name = ""+randomLetter()+randomLetter()+randomLetter(); 
		 addWordToQueue("SomeWord,"+queue_name,QUEUEPREFIX+WORD_GAME_QUEUE, session);
		new Thread(new Runnable(){

			@Override
			public void run() {
				while(true){
					try {
						String item = getItemFromWordQueue(QUEUEPREFIX+queue_name, session);
						if(item != null) {
							System.out.println("User typed item: " + item);
						}
					} catch (JMSException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
		}).start();
	}

}
