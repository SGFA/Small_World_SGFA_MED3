package server_package;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

import client_package.GameController;
import client_package.SerializationHandler;

public class Client {

	static Thread t1;
	
	public final static int PORT = 5000;
	public volatile static boolean running; 
	static Socket socket;
	public static ObjectInputStream in;
	
	static public void stop (){
        if (t1 == null) return;

        running = false;
        try{
            if (socket != null){
            	socket.close ();
            }
        } catch (IOException e){}

        t1 = null;
    }
		
	static public void connect(String IP_ADDRESS) {

		t1 = new Thread(new Runnable() {
			
			public void run() {
				
				running = true;
				System.out.println("Trying to connect");
				
				while (running) {
					
					try {
						
						if (socket == null) {
							socket = new Socket();
							
						}
						
						if (socket != null) {
							socket.connect(new InetSocketAddress("82.211.210.205", PORT), 5000);
							GameController.CURRENT_PLAYER_ID = 2;

							in = new ObjectInputStream(socket.getInputStream());

							System.out.println("Connected to host");
							GameController.serializationHandler.deserialize();
							GameController.serializationHandler.apply();
							

						}
						
						break;

					} catch (SocketTimeoutException e) {
						e.printStackTrace();

					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});

		t1.start();
		
	}

}
