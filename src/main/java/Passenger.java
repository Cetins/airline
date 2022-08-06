public class Passenger {

    private String name;
    private int numOfBags;
    private String flight;
    private Integer seatNo;

    public Passenger(String name, int numOfBags) {
        this.name = name;
        this.numOfBags = numOfBags;
        this.flight = new String();
        this.seatNo = 0;
    }

    public Integer getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(Integer seatNo) {
        this.seatNo = seatNo;
    }

    public String getName() {
        return name;
    }

    public int getNumOfBags() {
        return numOfBags;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }
}
