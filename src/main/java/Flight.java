import java.time.LocalDateTime;
import java.util.ArrayList;


public class Flight {

    private ArrayList<Pilot> pilots;
    private ArrayList<CabinCrew> cabinCrew;
    private ArrayList<Passenger> passengers;
    private Plane plane;
    private String flightNo;
    private String destination;
    private String departureAirport;
    private LocalDateTime departureTime;

    public Flight(ArrayList<Pilot> pilots, ArrayList<CabinCrew> cabinCrew, Plane plane, String flightNo, String destination, String departureAirport, LocalDateTime departureTime) {
        this.pilots = pilots;
        this.cabinCrew = cabinCrew;
        this.passengers = new ArrayList<>();
        this.plane = plane;
        this.flightNo = flightNo;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public int getPilotsCount() {
        return this.pilots.size();
    }

    public int getCrewMembersCount() {
        return this.cabinCrew.size();
    }

    public int getPassengersCount() {
        return this.passengers.size();
    }

    public PlaneType getPlaneType() {
        return this.plane.getPlaneType();
    }

    public int getPlaneCapacity() {
        return this.plane.getCapacity();
    }

    public int getPlaneWeight() {
        return this.plane.getWeight();
    }

    public String getFlightNo() {
        return flightNo;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public int calculateNumOfSeatsAvailable() {
        return this.getPlaneCapacity() - this.passengers.size();
    }

    public void bookPassenger(Passenger passenger) {
        if (this.calculateNumOfSeatsAvailable() >= 1) {
            passenger.setSeatNo(this.generateRandomSeatNumber());
            passenger.setFlight(flightNo);
            this.passengers.add(passenger);
        }
    }
    public int generateRandomSeatNumber() {
        double doubleRandomNumber = Math.random() * this.getPlaneCapacity();
        int seatNo = (int)doubleRandomNumber;
        if (this.validateSeatNo(seatNo)) {
            return seatNo;
        } else  {
            return this.generateRandomSeatNumber(); // just for fun :)
        }
    }

    public ArrayList getSeatNumbers() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (Passenger person:
             this.getPassengers()){
            numbers.add(person.getSeatNo());
        }
        return numbers;
    }

    public Boolean validateSeatNo(Integer seatNumber) {
        ArrayList<Integer> numbers = this.getSeatNumbers();
        if (numbers.contains(seatNumber)) {
            return false;
        }
        return true;
    }
}