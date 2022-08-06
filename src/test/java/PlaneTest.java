import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    Plane plane;

    @Before
    public void before() {
        plane = new Plane(PlaneType.BOEING747);
    }

    @Test
    public void hasType() {
        assertEquals(PlaneType.BOEING747, plane.getPlaneType());
    }

    @Test
    public void canGetCapacity() {
        assertEquals(149, plane.getCapacity());
    }

    @Test
    public void canGetWeight() {
        assertEquals(8940, plane.getWeight());
    }
}
