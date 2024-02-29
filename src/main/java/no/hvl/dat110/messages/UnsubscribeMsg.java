package no.hvl.dat110.messages;

public class UnsubscribeMsg extends Message {

	// message sent from client to unsubscribe on a topic 

    public UnsubscribeMsg(String user, String topic) {
       super(MessageType.UNSUBSCRIBE, user);
       this.unsubscribe = topic;
    }

	private String unsubscribe;

	@Override
	public String toString() {
		return super.toString() + " [unsubscribe=" + unsubscribe + "]";
	}

	public String getUnsubscribe() {
		return unsubscribe;
	}

	public void setUnsubscribe(String unsubscribe) {
		this.unsubscribe = unsubscribe;
	}

	// TODO:
	// Implement object variables - a topic is required

	// Complete the constructor, get/set-methods, and toString method
	// as described in the project text
	
}
