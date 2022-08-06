import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    Passenger john;
    Flight flight;
    Pilot jarrod;
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

    @Before
    public void before() {
        john = new Passenger("John", 2);
        jarrod = new Pilot("Jarrod", Rank.CAPTAIN, "CT278739");
        tracey = new Pilot("Tracey", Rank.SECOND_OFFICER, "SO449826");
        pilots = new ArrayList<>(Arrays.asList(jarrod, tracey));
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
    public void hasName() {
        assertEquals("John", john.getName());
    }

    @Test
    public void hasNumOfBags() {
        assertEquals(2, john.getNumOfBags());
    }

    @Test
    public void canAssignToAFlight() {
        john.setFlight(flight.getFlightNo());
        assertEquals(flight.getFlightNo(), john.getFlight());
    }
}
