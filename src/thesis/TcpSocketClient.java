package thesis;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TcpSocketClient {
	private String ip;
	private int port;
	private Socket socket;
	private List<TcpClientSubscriber> subscribers;
	private Thread receivingThread;
	private BufferedReader in;
	private BufferedWriter out;
	
	enum STATUS {
		SUCCESS,
		INIT_ERROR,
		CLOSE_ERROR,
		SUBSCRIBE_ERROR
	}
	
	public TcpSocketClient(String ip, int port) {
		this.ip = ip;
		this.port = port;
		this.subscribers = new ArrayList<TcpClientSubscriber>();
	}
	
	public STATUS initialize() {
		STATUS status = STATUS.SUCCESS;
		while (this.socket == null) {
			try {
				this.socket = new Socket(this.ip, this.port);
				System.out.println("Connected to server!");
			} catch (IOException e) {	
                System.out.println("Server not available. Retrying in 5 seconds...");
                try {
                    TimeUnit.SECONDS.sleep(5); // Wait 5 seconds before retrying
                } catch (InterruptedException ie) {
    				status = STATUS.INIT_ERROR;
                    System.err.println("Retry interrupted. Exiting...");
                    return status;
                }
             
			}
		}
		
		try {
			this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			this.out = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
		} catch (IOException e1) {
			System.out.println("Could not get input/output server streams.");
			e1.printStackTrace();
			return STATUS.INIT_ERROR;
		}
					
		this.receivingThread = new Thread(() -> {
            try {
                System.out.println("Waiting from server...");
                String serverMessage;
                while ((serverMessage = in.readLine()) != null) {
                    // Parse the incoming JSON message
                    // Message serverMessage = objectMapper.readValue(jsonResponse, Message.class);
                    System.out.println("Received from server: " + serverMessage);
                }
                System.out.println("Connection over.");
            } catch (IOException e) {
                System.err.println("Error reading messages: " + e.getMessage());
            }
        });
		receivingThread.start();
		
		return status;
	}
	
	public STATUS close() {
		STATUS status = STATUS.CLOSE_ERROR;
		try {
			try {
				receivingThread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.socket.close();
		} catch (IOException e) {
			System.out.println("Failed to close socket.");
			status = STATUS.CLOSE_ERROR;
			e.printStackTrace();
		}
		return status;
	}
	
	public STATUS subscribe(TcpClientSubscriber subscriber) {
		if (!this.subscribers.add(subscriber)) {
			return STATUS.SUBSCRIBE_ERROR;
		} 
		return STATUS.SUCCESS;
	}
	
	
}
