package server_package;

import java.io.*;
import java.net.*;

public class Server {

	public final int PORT = 5000;
	ServerSocket serverSocket;
	Socket clientSocket;
	Thread t1;
	
	public void stop() {
		
	}


	public void listen() {

		t1 = new Thread(new Runnable() {

			public void run() {
				while (true) {

					try {
						System.out.println(InetAddress.getLocalHost());
					} catch (UnknownHostException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					try {
						serverSocket = new ServerSocket(PORT);
						clientSocket = serverSocket.accept();
						System.out.println("client connected");
						break;

					} catch (IOException e) {
						System.out.println("Could not listen on port: " + PORT);
						System.exit(-1);
					}
				}
			}
		});

		t1.start();

	}

}
