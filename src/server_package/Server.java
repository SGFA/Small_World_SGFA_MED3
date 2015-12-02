package server_package;

import java.io.*;
import java.net.*;

public class Server {

    public volatile static boolean running;
	static public final int PORT = 5000;
	static ServerSocket serverSocket;
	static Socket clientSocket;
	static Thread t1;
	
	static public void stop (){
        if (t1 == null) return;

        running = false;
        try{
            if (serverSocket != null){
            	serverSocket.close ();
            }
        }catch (IOException e){}

        t1 = null;
    }

	public static void listen() {

		t1 = new Thread(new Runnable() {

			public void run() {
				
				running = true; 
				
				while (running) {

					try {
						System.out.println("I'm running #2");

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
					}
				}
			}
		});

		t1.start();

	}

}
