package Logic;

import java.util.PriorityQueue;

public class VoteManagement {
	
	private HandRules handRules = new HandRules();
	private PriorityQueue<HandRules.HandRuleRequest> queue = new PriorityQueue<>(handRules.getComparator());

	public void createVotingSession(String typeOfSession) {
		// typeOfSession determines the kind of voting that will take place during
		// the session. For example, ROP votes that require yes/no answers, Board
		// Elections
		// that require name answers etc.

	}
	
	public void handRuleAdded() {
		queue.add(handRules.new HandRuleRequest("New Topic", 234));
		
	}


}
