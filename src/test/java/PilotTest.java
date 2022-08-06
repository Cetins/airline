import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PilotTest {
    Pilot jarrod;

    @Before
    public void before() {
        jarrod = new Pilot("Jarrod", Rank.CAPTAIN, "CT345689");
    }

    @Test
    public void hasName() {
        assertEquals("Jarrod", jarrod.getName());
    }

    @Test
    public void hasRank() {
        assertEquals(Rank.CAPTAIN, jarrod.getRank());
    }

    @Test
    public void hasLicenceNo() {
        assertEquals("CT345689", jarrod.getLicenceNo());
    }
}
