package Logic;

import java.util.ArrayList;

import Logic.HandRules.HandRuleRequest;

public class VoteManagement {
	
	private ArrayList<HandRuleRequest> requests = new ArrayList<>();
	private HandRules handRules = new HandRules();

	public void createVotingSession(String typeOfSession) {
		// typeOfSession determines the kind of voting that will take place during
		// the session. For example, ROP votes that require yes/no answers, Board
		// Elections
		// that require name answers etc.

	}
	
	//Add the new request and then sort them all again
	public void handRuleAdded(String handRule, int id) {
		requests.add(handRules.new HandRuleRequest(handRule, id));
		requests.sort(handRules.comparator);
		
	}
	
	
	public void changeHandRuleAttribute(String newAttr, int id) {
		
		switch (newAttr) {
		case "FINISH_SPEAKING_TURN":
			//Remove the first element
			requests.remove(0);
			break;
		case "PASS_SPEAKING_TURN":
			for(HandRuleRequest request : requests) {
				if(request.getId() == id) {
					request.setPass(false);
				}
			}
		default:
			System.out.println("Something went wrong.");
			break;
		}
	}


}
