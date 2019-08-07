package org.easyvote.remote_server;

import org.glassfish.tyrus.server.Server;

public class WebsocketServer {

    private Server server;

    public WebsocketServer(int port) {
        server = new Server("localhost", port, "/websockets", null, VoteServerEndpoint.class);
    }

    //Starts the server
    public void startServer() throws Exception{
        server.start();
    }

    //Stops the server
    public void stopServer() throws Exception{
        server.stop();
    }
    
    //Broadcasts a message to all open connections
    public void broadcast(String json_string) throws Exception{
    	VoteServerEndpoint.broadcast(json_string);
    }
}
