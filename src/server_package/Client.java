package server_package;

import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;

import client_package.GameController;
import client_package.SerializationHandler;

public class Client {

	private static Socket socket;

	private final int PORT = 5000;
	public boolean running;
	private String ip_address;

	public void connect(String ip_address) {
		running = true;

		Thread t = new Thread(new ConnectionHandler());
		t.start();
	}

	class ConnectionHandler implements Runnable {

		@Override
		public void run() {
			try {
				/**
				 * Create a connection to the server socket on the host
				 */
				Socket socket = new Socket(ip_address, 5000);

				ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

				while (true) {
					GameController.serializationHandler.deserialize(in);
					GameController.serializationHandler.apply();
					Thread.sleep(1000);
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

		}

	}

}
