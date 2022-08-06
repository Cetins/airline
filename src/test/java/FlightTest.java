import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FlightTest {
    Flight flight;
    Flight privateFlight;
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
    public void before() {
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
                "12:00");
        privateFlight = new Flight(
                pilots,
                cabinCrew,
                jet,
                "JT2350",
                "JFK",
                "LHR",
                "12:00");
    }

    @Test
    public void hasAtLeastOnePilot() {
        assertTrue(flight.getPilotsCount() >= 1);
    }

    @Test
    public void hasCrewMembers() {
        assertEquals(3, flight.getCrewMembersCount());
    }

    @Test
    public void hasEmptyListOfBookedPassengers() {
        assertEquals(0, flight.getPassengersCount());
    }

    @Test
    public void hasPlane() {
        assertEquals(PlaneType.BOEING747, flight.getPlaneType());
        assertEquals(PlaneType.BOEING747.getCapacity(), flight.getPlaneCapacity());
        assertEquals(PlaneType.BOEING747.getWeight(), flight.getPlaneWeight());
    }

    @Test
    public void hasFlightNumber() {
        assertEquals("TK4320", flight.getFlightNo());
    }

    @Test
    public void hasDestination() {
        assertEquals("JFK", flight.getDestination());
    }

    @Test
    public void hasDepartureAirport() {
        assertEquals("LHR", flight.getDepartureAirport());
    }

    @Test
    public void hasDepartureTime() {
        assertEquals("12:00", flight.getDepartureTime());
    }

    @Test
    public void canReturnNumOfSeatsAvailable() {
        flight.bookPassenger(elaina);
        assertEquals(148, flight.calculateNumOfSeatsAvailable());
    }

    @Test
    public void canBookPassengerIfSeatAvailable() {
        flight.bookPassenger(kat);
        assertEquals(1, flight.getPassengersCount());
    }

    @Test
    public void canNotBookPassengerIfNoSeatAvailable() {
        privateFlight.bookPassenger(sandy);
        privateFlight.bookPassenger(kat);
        privateFlight.bookPassenger(elaina);
        assertEquals(2, privateFlight.getPassengersCount());
    }

}
