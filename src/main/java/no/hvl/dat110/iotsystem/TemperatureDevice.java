package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();	

		// create a client object and use it to
		// - connect to the broker - user "sensor" as the user name
		// - publish the temperature(s)
		// - disconnect from the broker

		Client tempClient = new Client("sensor", Common.BROKERHOST, Common.BROKERPORT);
		tempClient.connect();

        int i = 0;
		while (i < COUNT) {
			tempClient.publish("temperature","Temperature: " + sn.read() + "C");
			i++;
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			};
		}
		tempClient.disconnect();
		System.out.println("Temperature device stopping ... ");
	}
}
