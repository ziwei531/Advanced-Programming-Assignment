package projectpartbprogram_group9;

public class CandidateDetails {

    private static String candidateName;
    private String candidateNationality;
    private String candidateGender;

    public String getCandidateNationality() {
        return candidateNationality;
    }

    public void setCandidateNationality(String candidateNationality) {
        this.candidateNationality = candidateNationality;
    }

    public String getCandidateGender() {
        return candidateGender;
    }

    public void setCandidateGender(String candidateGender) {
        this.candidateGender = candidateGender;
    }

    public static String getCandidateName() {
        return candidateName;
    }

    public static void setCandidateName(String n) {
        candidateName = n;
    }

}
