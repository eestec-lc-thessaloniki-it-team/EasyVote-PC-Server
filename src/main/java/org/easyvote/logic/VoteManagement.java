package org.easyvote.logic;

import java.util.ArrayList;
import org.easyvote.logic.HandRules.HandRuleRequest;

public class VoteManagement {

  // Array with every hand rule request that is active
  private ArrayList<HandRuleRequest> requests = new ArrayList<>();
  private HandRules handRules = new HandRules();

  public void addVotingSession(String typeOfSession) {
    // typeOfSession determines the kind of voting that will take place during
    // the session. For example, ROP votes that require yes/no answers, Board
    // Elections
    // that require name answers etc.

  }

  // Add the new request and then sort them all again
  public void handRuleAdded(String handRule, int id) {
    requests.add(handRules.new HandRuleRequest(handRule, id));
    requests.sort(handRules.comparator);
  }

  // Delete this hand rule request
  // whenever the client thinks there's no need for it
  public void passHandRule(int id) {

    for (int i = 0; i < requests.size(); i++) {
      if (requests.get(i).getId() == id) {
        // Remove the requested element as desired
        requests.remove(i);
      }
    }
  }
}