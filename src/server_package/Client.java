package server_package;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

	static Thread t1;
	
	public final static int PORT = 5000;
	public volatile static boolean running; 
	static Socket socket;

	
	static public void stop (){
        if (t1 == null) return;

        running = false;
        try{
            if (socket != null){
            	socket.close ();
            }
        }catch (IOException e){}

        t1 = null;
    }
	
	static public void connect(String IP_ADDRESS) {

		socket = new Socket();

		t1 = new Thread(new Runnable() {
			
			public void run() {
				
				while (true) {
					
					try {
						socket.connect(new InetSocketAddress(IP_ADDRESS, PORT), 1000);
						System.out.println("connected to host");
						break;

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		t1.start();
		
	}

}
