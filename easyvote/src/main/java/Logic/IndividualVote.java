package Logic;

public class IndividualVote {

    private int voterId;
    private String voterName;
    private String voterSurname;
    private String vote;

    public IndividualVote(int voterId, String voterName, String voterSurname, String vote) {
        this.voterId = voterId;
        this.voterName = voterName;
        this.voterSurname = voterSurname;
        this.vote = vote;
    }

    public int getVoterId() {
        return voterId;
    }

    public String getVoterName() {
        return voterName;
    }

    public String getVoterSurname() {
        return voterSurname;
    }

    public String getVote() {
        return vote;
    }
}
