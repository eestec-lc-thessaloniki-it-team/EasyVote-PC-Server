- A Request JSON messsage has the following form:
	{
		request : // (type of request is stated here, for example "INITIALIZE_NEW_CONNECTION")
		data : {
			// A JSON structure inside the request JSON message containing any necessary data for the request.
			// In the example of INITIALIZE_NEW_CONNECTION, such data, for example, would be the unique user identifier (USER_ID) 
		 }
	}
	
	
	
- A Response JSON message has the following form (taken from JSend protocol: https://github.com/omniti-labs/jsend):
	{
		status : // can be "success", "fail" or "error"
		data : {
			// A JSON structure inside the response JSON message containing any necessary data for the response.
		 }
	}



- Protocol for initializing a new connection from a Client to the Main Server:
	1) Client sends a JSON request:
		- Type of request: INITIALIZE_NEW_CONNECTION
		- Data: USER_ID

	2) Server sends a JSON response: 
		- Status is either "success", if the user identification is accepted, or fail, if the user identification is rejected



- Heartbeat protocol (A protocol used to check if a client is still alive, while at the same time keeping the socket open):
	1) Server sends a heartbeat request every X seconds to every client that has connected to it. X is a time interval set in
		the application's settings. The type of request that is used for this is "HEARTBEAT_CHECK". No data is required inside
		the message of a heartbeat request.
		
	2) If the client is still active and working normally, it will respond to the server's heartbeat request with a response.
		The response has a "success" status. No data is required inside the heartbeat check response.
		
	3) A timeout is set for the server. If the timeout expires and the server has not received a heartbeat response from a client, 
		the client is considered unavailable/unreachable and is immediately disconnected from the voting application.
		Otherwise, if a proper heartbeat response is received, the client is considered active and fully functional, thus no
		further action is taken.
		

