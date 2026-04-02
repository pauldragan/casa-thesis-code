package thesis;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TcpSocketServer {
	private static final Logger logger = LoggerFactory.getLogger(Thesis.class);
	
	private String ip;
	private int port;
	private Socket socket;
	private ServerSocket serverSocket;
	private List<TcpClientSubscriber> subscribers;
	private Thread receivingThread;
	private BufferedReader in;
	private BufferedWriter out;
	
	public enum STATUS {
		SUCCESS,
		INIT_ERROR,
		CLOSE_ERROR,
		SUBSCRIBE_ERROR
	}
	
	public TcpSocketServer(String ip, int port) {
		this.ip = ip;
		this.port = port;
		this.subscribers = new ArrayList<TcpClientSubscriber>();
	}
	
	public STATUS initialize() {
		STATUS status = STATUS.SUCCESS;
		
		try {
			this.serverSocket = new ServerSocket(this.port);
			logger.info("Server socket created on port " + this.port);
		} catch (IOException e2) {
			logger.error("Could not start server socket!");
			e2.printStackTrace();
			return STATUS.INIT_ERROR;
		} 
		
		try {
			this.socket = this.serverSocket.accept();
			logger.info("Client connected to server!");
		} catch (IOException e2) {
			logger.error("Could not start accept connection from client!");
			e2.printStackTrace();
			return STATUS.INIT_ERROR;
		}
			
		try {
			this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			this.out = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
		} catch (IOException e1) {
			logger.error("Could not get input/output client streams.");
			e1.printStackTrace();
			return STATUS.INIT_ERROR;
		}
					
		this.receivingThread = new Thread(() -> {
            try {
            	logger.info("Waiting from client...");
                String clientMessage;
                while ((clientMessage = in.readLine()) != null) {
                	logger.info("Message received from client: " + clientMessage);
                    // Parse the incoming JSON message
                    // Message serverMessage = objectMapper.readValue(jsonResponse, Message.class);
                	for (TcpClientSubscriber sub : this.subscribers) {
                		Optional<String> response = sub.processMessage(clientMessage);
                		if (response.isPresent()) {
                			logger.info("Sending response to client: " + response.get());
                			this.out.write(response.get());
                			this.out.flush();
                		}
                	}
                }
                logger.info("Connection over.");
            } catch (IOException e) {
            	logger.error("Error reading messages: " + e.getMessage());
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
			logger.error("Failed to close socket.");
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
