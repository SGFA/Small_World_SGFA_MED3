package server_package;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

	public final int PORT = 5000;
	Socket socket;

	public void connect(String IP_ADDRESS) {

		Thread t1 = new Thread(new Runnable() {

			public void run() {
				while (true) {

					socket = new Socket();
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
