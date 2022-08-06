import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    Passenger john;

    @Before
    public void before() {
        john = new Passenger("John", 2);
    }

    @Test
    public void hasName() {
        assertEquals("John", john.getName());
    }

    @Test
    public void hasNumOfBags() {
        assertEquals(2, john.getNumOfBags());
    }
}
