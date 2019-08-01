package org.easyvote.logic;

import java.util.Comparator;

public class HandRules {

  // Functional Interface of Comparator
  Comparator<HandRuleRequest> comparator = new Comparator<HandRules.HandRuleRequest>() {

    @Override
    public int compare(HandRuleRequest req1, HandRuleRequest req2) {
      //Greater priority equals to smaller index in the array
      if (req1.getPriority() < req2.getPriority()) {
        return -1;
      }

      return 1;
    }
  };

  public Comparator<HandRuleRequest> getComparator() {
    return comparator;
  }

  // Every hand rule request is an instance of this class
  public class HandRuleRequest {

    private int priority;
    private int id;

    public HandRuleRequest(String handRule, int id) {

      switch (handRule) {
        case "Technical":
          priority = 4;
          break;
        case "Respone":
          priority = 3;
          break;
        case "Question":
          priority = 2;
          break;
        case "New Topic":
          priority = 1;

      }

      this.id = id;

    }


    public int getPriority() {
      return priority;
    }

    public int getId() {
      return id;
    }

  }

}
