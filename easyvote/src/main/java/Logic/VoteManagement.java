package Logic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Properties;

public class VoteManagement {
	
	public ArrayList<Integer> repeatedRules = new ArrayList<Integer>();
	private final byte technicalLimit = 7;
	private final byte responeLimit = 4;
	private final byte questionLimit = 2;
	private final byte topicLimit = 1;

	public void createVotingSession(String typeOfSession) {
		// typeOfSession determines the kind of voting that will take place during
		// the session. For example, ROP votes that require yes/no answers, Board
		// Elections
		// that require name answers etc.

	}
	

	private class HandRulesManagement {


		// εχουμενε αqueue, οπυ θα κραταει τα αποτελεσματα απο το τσεκ
		
		private class RequestComparator implements Comparator<HandRuleRequest>{

			@Override
			public int compare(HandRuleRequest req1, HandRuleRequest req2) {

					
				return 0;
			}
			
			
		}//The real shit:	2, 3, 3, 3, 3, 2
		// Queue: 			2, 3, 3, 3, 3, 2, 3, 3, 3, 3, 3, 3
		// RepeatedRules :	3, 3, 3, 3, 3, 3, 3
		
	}

	private class HandRuleRequest {

		private int priority;
		private int id;
		private boolean repeatedRule;
		
		public HandRuleRequest(String handRule, int id) {
			
			switch (handRule) {
				case "Technical":
					priority = 4;
					repetitive(priority, technicalLimit);
					break;
				case "Respone":
					priority = 3;
					repetitive(priority, responeLimit);
					break;
				case "Question":
					priority = 2;
					repetitive(priority, questionLimit);
					break;
				case "New Topic":
					priority = 1;
					repetitive(priority, topicLimit);

			}
			
			this.id = id;
			
			
		}
		
		private void repetitive(int priority, int limit) {
			if(repeatedRules.get(0) == priority && repeatedRules.size() == limit) {
				repeatedRule = true;
			} else {
				repeatedRules.clear();
				repeatedRules.add(priority);
				repeatedRule = false;

			}

		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public int getPriority() {
			return priority;
		}
		
		
		Properties prop = new Properties();
		

	}
	
	

}
