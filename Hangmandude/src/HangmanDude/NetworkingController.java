package HangmanDude;
import java.util.ArrayList;
import java.util.Random;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;

@Configuration
@ComponentScan
public class NetworkingController implements MessageListener {
	Connection connection = null;
	HangmanMessageListener listener = null;
	Session session = null;
	ArrayList<MessageConsumer> consumers = new ArrayList<MessageConsumer>();
	private String game_challange_queue_name = null;
	
	public NetworkingController() {}
	public NetworkingController(HangmanMessageListener msg_listener) throws JMSException {
		@SuppressWarnings("resource")
		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Networking.class);
		//ConnectionFactory factory =  context.getBean(CachingConnectionFactory.class);
		ConnectionFactory factory = connectionFactory();
		listener = msg_listener;
	
		connection = factory.createConnection();
		connection.start();
		session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
	}
	
	
	public String randomString(int size) {
		String s = "abcdefghijklmnopqrstuvwxyz";
		Random r = new Random();
		String randomStr = "";
		for(int i = 0; i < size; i++)
			randomStr += s.charAt(r.nextInt(s.length()));
		return randomStr;
	}
	
	
	public void end() throws JMSException {
		if(game_challange_queue_name != null) {
			queueMessage(game_challange_queue_name, NetworkingConstants.PLAYER_QUIT);
		}
		for(MessageConsumer consumer : consumers)
			consumer.close();
		session.close();
		connection.close();
		System.err.println("ENDED ALL CONNECTIONS");
	}
	
	
	//@Bean
	ConnectionFactory connectionFactory() {
		return new CachingConnectionFactory(new ActiveMQConnectionFactory(
				NetworkingConstants.USERNAME, NetworkingConstants.PASSWORD, NetworkingConstants.ACTIVEMQ_URL));
	}
	
	private String readQueueSync(String queue_name) throws JMSException {
		Queue queue = session.createQueue(NetworkingConstants.QUEUE_PREFIX + queue_name);
		MessageConsumer consumer = session.createConsumer(queue);
		String word = ((TextMessage) consumer.receive()).getText();
		consumer.close();
		System.err.println("READ QUEUE " + queue_name + " synchronously. Got item: " + word);
		return word;
	}
	
	private void readQueueAsync(String queue_name) throws JMSException {
		Queue queue = session.createQueue(NetworkingConstants.QUEUE_PREFIX + queue_name);
		MessageConsumer consumer = session.createConsumer(queue);
		consumers.add(consumer);
		consumer.setMessageListener(this);
		System.err.println("READING " +  queue_name + " asynchronously");
		
	}
	
	private void queueMessage(String queue_name, String message) throws JMSException {
		Queue queue = session.createQueue(NetworkingConstants.QUEUE_PREFIX +  queue_name);
		MessageProducer producer = session.createProducer(queue);
		producer.send(session.createTextMessage(message));
		producer.close();
		System.err.println(message + " added to " + queue_name);
	}
	
	public void GamerAcceptChallange() throws Exception {
		if(game_challange_queue_name == null)
			throw new Exception("No challange available. Did you forget to call GetGameChallangeWord?");
		else {
			queueMessage(game_challange_queue_name, NetworkingConstants.ChallangeAccepted);
			System.err.println("ACCEPTING CHALLANGE");
		}
		
	}
	
	public void GamerRejectChallange() throws Exception {
		if(game_challange_queue_name == null)
			throw new Exception("No challange available. Did you forget to call GetGameChallangeWord?");
		else {
			queueMessage(game_challange_queue_name, NetworkingConstants.ChallangeRejected);
			System.err.println("REJECTING CHALLANGE");
		}
	}
	
	
	public String GamerGetGameChallangeWord() throws JMSException, InterruptedException {
		String word = null;
		while(true) {
			word = readQueueSync(NetworkingConstants.GAMEQUEUE);
			if(word != null) {
				game_challange_queue_name = word;
				return word.substring(0, word.indexOf('-'));
			}
			else
				Thread.sleep(500);
		}
		
	}
	
	public void ChallangerCreateGame(String word) throws JMSException {
		String random_hash = randomString(5);
		game_challange_queue_name = word+"-"+random_hash;
		queueMessage(NetworkingConstants.GAMEQUEUE, game_challange_queue_name );
		readQueueAsync(game_challange_queue_name);
		
	}
	
	public void GamerGuessLetter(String guess) throws Exception {
		if(game_challange_queue_name == null)
			throw new Exception("No challange available. Did you forget to call GetGameChallangeWord?");
		queueMessage(game_challange_queue_name, NetworkingConstants.GUESS_PREFIX + guess);
	}


	public void onMessage(Message msg) {
		System.err.println("THIS HAPPENED!");
		try {
			String text = ((TextMessage) msg).getText();
			System.err.println("Received Message: " + text);
				
			
			if(text == NetworkingConstants.ChallangeAccepted) {
				listener.challangeAccepted();
			}
			else if(text == NetworkingConstants.ChallangeRejected) {
				listener.challangeRejected();
			}
			else if(text == NetworkingConstants.PLAYER_QUIT) {
				listener.playerQuit();
			}
			else if(text.contains(NetworkingConstants.GUESS_PREFIX)) {
				listener.playerGuessed(text.substring(NetworkingConstants.GUESS_PREFIX.length()));
			}
				
			
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}
	
}
