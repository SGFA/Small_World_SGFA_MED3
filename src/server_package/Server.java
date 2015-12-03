package server_package;

import java.io.*;
import java.net.*;

import client_package.GameController;
import client_package.SerializationHandler;

public class Server {

	public volatile static boolean running;
	static public final int PORT = 5000;
	
	static ServerSocket serverSocket;
	public static Socket clientSocket;
	
	static Thread t1;
	public static ObjectOutputStream out;

	static public void stop() {
		if (t1 == null)
			return;
		running = false;
		try {
			if (serverSocket != null) {
				serverSocket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		t1 = null;
	}

	public static void listen() {
		GameController.CURRENT_PLAYER_ID = 1;

		t1 = new Thread(new Runnable() {

			public void run() {

				running = true;

				while (running) {

					try {
						System.out.println(InetAddress.getLocalHost());
					} catch (UnknownHostException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					try {
						serverSocket = new ServerSocket(PORT);
						clientSocket = serverSocket.accept();
						out = new ObjectOutputStream(clientSocket.getOutputStream());
						
						System.out.println("client connected");
						GameController.addPlayers(1);
						
						GameController.serializationHandler.serialize(Server.out);

						
						break;

					} catch (IOException e) {
						System.out.println("Could not listen on port: " + PORT);
						break;
					}
				}
			}
		});

		t1.start();

	}

}
