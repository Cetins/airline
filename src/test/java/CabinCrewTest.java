import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CabinCrewTest {

    CabinCrew mary;

    @Before
    public void before() {
        mary = new CabinCrew("Mary", Rank.HOSTESS);
    }

    @Test
    public void hasName() {
        assertEquals("Mary", mary.getName());
    }

    @Test
    public void hasRank() {
        assertEquals(Rank.HOSTESS, mary.getRank());
    }
}
