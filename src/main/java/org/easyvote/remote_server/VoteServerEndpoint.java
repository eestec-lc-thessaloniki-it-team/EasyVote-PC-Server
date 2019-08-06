package org.easyvote.remote_server;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint( value = "/vote")
public class VoteServerEndpoint {
	
	//A container that stores each open connection
	private static Queue<Session> connections = new ConcurrentLinkedQueue<>();


    @OnOpen
    public void onOpen(Session session){
    	//Add connection to queue
    	connections.add(session);
    }

    @OnMessage
    public void onMessage(String message, Session session) throws Exception{
    	MessageAnalysis messageAnalysis = new MessageAnalysis(message);
    	String responce = messageAnalysis.analyseMessage();
    	switch(responce) {
    		case "error":
    			closeConnection(session);
    			break;
    		case "success":
    			//Do nothing
    			break;
    		default:
    			//Send message
    			session.getBasicRemote().sendText(responce);	
    	}
    }

    @OnClose
    public void onClose(Session session) {
    	//Remove connection from queue
    	connections.remove(session);
    }

    //TODO: Implement better error handling
    @OnError
    public void onError(Session session, Throwable t){
    	closeConnection(session);
    	t.printStackTrace();
    }

    //Send a message to all open connections
    public static void broadcast(String json_string) throws Exception{
        for(Session session: connections) {
        	session.getBasicRemote().sendText(json_string);
        }
    }
    
    //Returns all active connections
    public static Queue<Session> getConnections(){
    	return connections;
    }
    
    private void closeConnection(Session session) {
    	try {
    		//Close the connection
    		session.close();
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
    	//Remove connection from queue
    	connections.remove(session);
    }
} 
