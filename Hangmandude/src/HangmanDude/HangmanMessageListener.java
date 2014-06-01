package HangmanDude;

import javax.jms.JMSException;

public interface HangmanMessageListener {
	public void challangeAccepted() throws JMSException;
	public void challangeRejected();
	public void playerQuit();
	public void playerGuessed(String guess);
}
