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
	private boolean waiting = true;

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
				
				GameController.serializationHandler.deserialize(in);
				GameController.serializationHandler.apply();

					GameController.PLAYER_ID = GameController.players.size();

					while(!GameController.launched.get()) {
						GameController.serializationHandler.deserialize(in);
						GameController.serializationHandler.apply();
					}					
					
					while(GameController.launched.get()) {
																	
						if (GameController.PLAYER_ID == GameController.CURRENT_ACTIVE_PLAYER.get()) {
							
							waiting = false;
									
							//System.out.println("I'm active");
							GameController.serializationHandler.serialize(out);
							
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						} else if (waiting == false) {
							GameController.serializationHandler.serialize(out);
							waiting = true;
						} else if (waiting == true) {
							GameController.serializationHandler.deserialize(in);
							GameController.serializationHandler.apply();
						}

						
					}
				

			} catch (Exception e) {
				// TODO: handle exception
			}

		}

	}

}
