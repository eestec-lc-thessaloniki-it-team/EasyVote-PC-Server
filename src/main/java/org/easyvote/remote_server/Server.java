package org.easyvote.remote_server;

import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server{
	
	private HandshakeListener listener;
	
	class ClientHandler implements Runnable{
		
		private boolean cont;
		private int id;
		private DataInputStream input;
		private DataOutputStream output;
		
		public ClientHandler(Socket socket, int id) throws Exception{
			this.id = id;
			cont = true;
			input = new DataInputStream(socket.getInputStream());
			output = new DataOutputStream(socket.getOutputStream());
		}
		
		public void send(byte[] data, int length) throws Exception{
			output.writeInt(length);
			output.flush();
			output.write(data, 0, length);
			output.flush();
		}
		
		public byte[] receive() throws Exception{
			int length = input.readInt();
			byte[] data = new byte[length];
			int bytesReceived = 0;
			while(bytesReceived<length) {
				bytesReceived+= input.read(data, bytesReceived, length-bytesReceived);
			}
			return data;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				while (cont) {
					if(input.available()>0) {
						byte[] data = receive();
						String message = new String(data);
						MessageAnalysis messageAnalysis = new MessageAnalysis(message);
						//TODO: call message analysis
					}
				}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
		}
		
		public void stop() throws Exception{
			cont = false;
			input.close();
			output.close();
			
		}
		
	}
	
	class HandshakeListener implements Runnable{
		
		private int port;
		private boolean cont;
		private ArrayList<ClientHandler> connections;
		
		
		public HandshakeListener(int port){
			this.port = port;
	    	this.cont = true;
	    	connections = new ArrayList<>();
		}
		
		public void sentToAll(byte[] data) throws Exception{
			for(ClientHandler client : connections) {
				client.send(data, data.length);
			}
		}

		@Override
		public void run() {
			int counter = 0;
			try {
				ServerSocket server = new ServerSocket(port);
				while(cont) {
					Socket client = server.accept();
					ClientHandler clientHandler = new ClientHandler(client, counter);
					counter++;
					connections.add(clientHandler);
					clientHandler.run();
				}
				server.close();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
		public void stop() throws Exception{
			for(ClientHandler client: connections) {
				client.stop();
			}
			this.cont = false;
		}
	}
    
	//Starts listening for handshakes
    public void startListener(int port) {
    	listener = new HandshakeListener(port);
    	new Thread(listener).run();
    }
	
	//Stop server loop
	public void stopListener() throws Exception{
		listener.stop();
	}
	
	public void broadcast(String message) throws Exception{
		byte[] data = message.getBytes();
		listener.sentToAll(data);
	}
}
