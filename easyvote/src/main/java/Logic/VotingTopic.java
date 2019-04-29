package Logic;

import java.util.ArrayList;
import java.util.List;

public class VotingTopic {

    private String topicDescription;

    // Open ballot field?

    // Determines the type of vote that will be used for the topic,
    // for example: "YES/NO"
    private String typeOfVote;
    private List<IndividualVote> votes = new ArrayList<IndividualVote>();


}
