package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.messages.PublishMsg;

public class DisplayDevice {
	
	private static final int COUNT = 10;
		
	public static void main (String[] args) {
		
		System.out.println("Display starting ...");
				
		// create a client object and use it to	
		// - connect to the broker - use "display" as the username
		// - create the temperature topic on the broker
		// - subscribe to the topic
		// - receive messages on the topic
		// - unsubscribe from the topic
		// - disconnect from the broker
		
	    Client displayClient = new Client("display", Common.BROKERHOST, Common.BROKERPORT);
		displayClient.connect();
		displayClient.createTopic("temperature");
		displayClient.subscribe("temperature");

		int i = 0;
		while (i < COUNT) {
		    PublishMsg message = (PublishMsg)displayClient.receive();
			System.out.println("DISPLAY: " + message.getMessage());
			i++;
		}

		displayClient.unsubscribe("temperature");
		displayClient.disconnect();
		
		System.out.println("Display stopping ... ");
		
	}
}
