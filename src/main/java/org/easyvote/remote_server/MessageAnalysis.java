package org.easyvote.remote_server;

import org.json.JSONObject;

/*
 * A class that analyzes a JSON message
 */
public class MessageAnalysis {

    private JSONObject json_message;

    /***
     * @param message The JSON message the class has to analyze
     * */
    public MessageAnalysis(String message){
        json_message = new JSONObject(message);
    }

    //Determines if the message is a request or a response and calls the necessary functions
    public String analyseMessage(){

        if(json_message.has("request")){
            //It's a request JSON Message
            return analyseRequest();
            
        }else if(json_message.has("status")){
            //It's a response JSON Message
            return analyzeResponse();
        }else {
            //TODO: Handle wrong JSON message
        	return "error";
        }
    }

    //Analyzes a request message
    private String analyseRequest(){
        String request = json_message.get("request").toString();
        switch (request){
        
        /*
            case "INITIALIZE_NEW_CONNECTION":
                System.err.println("NEW CONNECTION");
                //TODO: Initialize new connection
                  
         */
            case "REGISTER_VOTE":
                System.err.println("Register vote");
                //TODO: call a function to register vote and return status
                //Example
                JSONObject jo = new JSONObject();
                jo.put("status", "success");
                return jo.toString(1);
                
         /*       
            case "TERMINATE_CONNECTION":
                System.err.println("Terminate");
                //TODO: Close clients connection
                 
          */
            default:
                //TODO: Handle wrong JSON message
            	return "error";
        }
    }
    

    //Analyzes a response Message
    private String analyzeResponse(){
        String status = json_message.get("status").toString();
        switch (status){
            case "success":
                System.err.println("SUCCESS");
                //TODO: Action in case of success
                return "success";
            case "fail":
                System.err.println("FAILURE");
                //TODO: Action in case of failure
                return "error";
            case "error":
                System.err.println("ERROR");
                //TODO: Action in case of failure
                return "error";
            default:
                System.err.println("worng message");
                //TODO: Handle wrong JSON message
                return "error";
        }
    }
}