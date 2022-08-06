import java.util.ArrayList;

public class FlightManager {

    public int calculateBaggageReservedPerPassenger(Flight flight) {
        return flight.getPlaneWeight() / 2 / flight.getPlaneCapacity();
    }

    public int calculateTotalBaggageReserved(Flight flight) {
        int bagAllowance = calculateBaggageReservedPerPassenger(flight);
        int totalWeight = 0;
        for (Passenger passenger :
                flight.getPassengers()) {
            totalWeight += passenger.getNumOfBags() * bagAllowance;
        }
        return totalWeight;
    }

    public int calculateTotalBaggageWeightRemains(Flight flight) {
        return flight.getPlaneWeight() / 2 - calculateTotalBaggageReserved(flight);
    }
}
