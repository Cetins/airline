import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {
    FlightManager flightManager;
    Flight flight;
    Pilot john;
    Pilot tracey;
    ArrayList<Pilot> pilots;
    CabinCrew mary;
    CabinCrew scott;
    CabinCrew margaret;
    ArrayList<CabinCrew> cabinCrew;
    Passenger elaina;
    Passenger kat;
    Passenger sandy;
    Passenger cetin;
    ArrayList<Passenger> passengers;
    Plane plane;
    Plane jet;

    @Before
    public void before() throws ParseException {
        flightManager = new FlightManager();
        john = new Pilot("John", Rank.CAPTAIN, "CT278739");
        tracey = new Pilot("Tracey", Rank.SECOND_OFFICER, "SO449826");
        pilots = new ArrayList<>(Arrays.asList(john, tracey));
        mary= new CabinCrew("Mary", Rank.CABIN_CHIEF);
        scott = new CabinCrew("Scott", Rank.STEWARD);
        margaret = new CabinCrew("Margaret", Rank.HOSTESS);
        cabinCrew = new ArrayList<>(Arrays.asList(mary, scott, margaret));
        elaina = new Passenger("Elaina", 1);
        kat = new Passenger("Kat", 0);
        sandy = new Passenger("Sandy", 0);
        cetin = new Passenger("Cetin", 1);
        passengers = new ArrayList<>(Arrays.asList(elaina, kat, sandy, cetin));
        plane = new Plane(PlaneType.BOEING747);
        jet = new Plane(PlaneType.PRIVATE_JET);
        flight = new Flight(
                pilots,
                cabinCrew,
                plane,
                "TK4320",
                "JFK",
                "LHR",
                LocalDateTime.parse("2022-11-01T11:50:55"));
    }

    @Test
    public void canCalculateReservedBaggagePerPassenger() {
        assertEquals(30, flightManager.calculateBaggageReservedPerPassenger(flight));
    }

    @Test
    public void canCalculateTotalBaggageReserved() {
        flight.bookPassenger(elaina);
        flight.bookPassenger(kat);
        flight.bookPassenger(sandy);
        flight.bookPassenger(cetin);
        assertEquals(60, flightManager.calculateTotalBaggageReserved(flight));
    }

    @Test
    public void canCalculateTotalBaggageWeightRemains() {
        flight.bookPassenger(elaina);
        flight.bookPassenger(kat);
        flight.bookPassenger(sandy);
        flight.bookPassenger(cetin);
        assertEquals(4410, flightManager.calculateTotalBaggageWeightRemains(flight));
    }

}
