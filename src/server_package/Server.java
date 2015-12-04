package server_package;

import java.io.*;
import java.net.*;

import client_package.GameController;
import client_package.SerializationHandler;

public class Server {
	
	private Socket socket;
	private ServerSocket serverSocket;
	private final int PORT = 5000;
	public boolean running;


	/**
	 * Server class that will called by the host upon entering the lobby
	 * The server is set to listen on port 5000 on the local IP address
	 */
	
	public void init() {
		try {			
			serverSocket = new ServerSocket(PORT);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public void listen() {
		running = true;
		
		GameController.addPlayers(1);
		GameController.PLAYER_ID = GameController.players.size();

		System.out.println("Waiting for client ...");
		

		/**
		 * The server does a loop here to accept clients who initiate a
		 * connection from the client lobby.
		 */
		
		Thread t = new Thread(new Runnable() {

			public void run() {

				while (running) {			
					try {
						socket = serverSocket.accept();

						new ConnectionHandler();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});

		t.start();
	}

	public void stop() {
		running = false;

		try {
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	class ConnectionHandler implements Runnable {

		SerializationHandler serializationHandler = new SerializationHandler();

		public ConnectionHandler() {
			/**
			 * Start the server in a separate thread so that it will not
			 * interfere with the Main thread.
			 */
			
			Thread t = new Thread(this);
			t.start();
			
		}

		@Override
		public void run() {
			try {
				/**
				 * Send serialized objects to client
				 */
								
				GameController.addPlayers(1);
				
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
				//ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

				serializationHandler.serialize(out);

				while (!GameController.launched.get()) {
					serializationHandler.serialize(out);
				}			
				
				while (GameController.launched.get()) {
					
					game(out);
				}		
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
			public void game(ObjectOutputStream out) {
				
			if (GameController.PLAYER_ID == GameController.CURRENT_ACTIVE_PLAYER) {

				System.out.println("I'm active");
				serializationHandler.serialize(out);
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				//GameController.serializationHandler.deserialize(in);
				//GameController.serializationHandler.apply();
			}

		}
	}
}
