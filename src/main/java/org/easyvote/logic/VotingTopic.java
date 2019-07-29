package main.java.org.easyvote.logic;

import java.util.ArrayList;
import java.util.List;

public class VotingTopic {

  private String topicDescription;

  // Open ballot field?

  // Determines the type of vote that will be used for the topic,
  // for example: "YES/NO"
  private String typeOfVote;

  // List containing the "IndividualVote" objects of all the voters that have
  // participated in this topic voting procedure
  private List<IndividualVote> votes = new ArrayList<IndividualVote>();

  // Used to determine if the topic passed or not, according to the votes
  private boolean passed;

  //An example for the enum
  //This can be used instead of the String typeOfVote
  //String type = TypeOfVote.ROP.toString();
  
  private enum TypeOfVote{
	  ROP, ELECTION;
  }

}
