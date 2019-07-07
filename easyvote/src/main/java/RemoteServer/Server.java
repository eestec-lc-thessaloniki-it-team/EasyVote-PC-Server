package RemoteServer;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    void sendMessage() {
        // TODO: implement me!
    }

    void receiveMessage() {
        //TODO: implement me!
    }

    /**
     * A method that starts the server loop
     * @param serverPort The port number the server will use
     * */
    public void startServer(int serverPort){
        try{
            ServerSocket server = new ServerSocket(serverPort);
            while (true){
                //Accept incoming connections
                Socket client = server.accept();
                //TODO: Start new Thread
            }
        }catch(Exception ex) {
        	ex.printStackTrace();
        }
    }
}
