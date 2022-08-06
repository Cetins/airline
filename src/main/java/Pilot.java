public class Pilot extends Crew {
    private String licenceNo;

    public Pilot(String name, Rank rank, String licenceNo) {
        super(name, rank);
        this.licenceNo = licenceNo;
    }

    public String getLicenceNo() {
        return licenceNo;
    }
}
