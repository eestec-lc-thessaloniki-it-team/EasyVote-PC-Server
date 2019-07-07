package RemoteServer;

//A library for JSON from http://www.java2s.com/Code/Jar/j/Downloadjsonsimple111jar.htm
import org.json.JSONObject;


/*
 * A class that analyzes a JSON message
 */
public class MessageAnalysis {

    private JSONObject message;

    /***
     * @param message The JSON message the class has to analyse
     * */
    public MessageAnalysis(JSONObject message){
        this.message = message;
    }

    //Determines if the message is a request or a response and calls the necessary functions
    /*
    public void analyseMessage(){

        if(message.containsKey("request")){
            //It's a request JSON Message
            analyseRequest();

        }else if(message.containsKey("status")){
            //It's a response JSON Message
            analyseResponse();
        }else {
            //TODO: Handle wrong JSON message
        }
    }
    */

    //Analyses a request message
    private void analyseRequest(){
        String request = message.get("request").toString();
        switch (request){
            case "INITIALIZE_NEW_CONNECTION":
                System.err.println("NEW CONNECTION");
                //TODO: Initialize new connection
            case "REGISTER_VOTE":
                System.err.println("Register vote");
                //TODO: Register clients vote
            case "TERMINATE_CONNECTION":
                System.err.println("Terminate");
                //TODO: Close clients connection
            default:
                //TODO: Handle wrong JSON message
        }
    }
    

    //Analyses a response Message
    private void analyeResponse(){
        String status = message.get("status").toString();
        switch (status){
            case "success":
                System.err.println("SUCCESS");
                //TODO: Action in case of success
                break;
            case "fail":
                System.err.println("FAILURE");
                //TODO: Action in case of failure
                break;
            case "error":
                System.err.println("ERROR");
                //TODO: Action in case of failure
                break;
            default:
                System.err.println("worng message");
                //TODO: Handle wrong JSON message
                break;
        }
    }
}