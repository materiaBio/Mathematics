
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IntervalTest {

    @Test
    public void testCompareTo() {
        Interval a = new Interval (2,3);
        Interval b = new Interval (2,3);
        Interval c = new Interval (3,4);
        Interval d = new Interval (2,4);
        assertEquals("has to be equal", a.compareTo(b), 0);
        assertEquals("has to be equal", b.compareTo(a), 0);
        assertTrue ("D has to be greater then A", a.compareTo(d) < 0);
        assertTrue ("D has to be greater then A", d.compareTo(a) > 0);
        assertTrue ("C has to be greater then D", d.compareTo(c) < 0);
        assertTrue ("C has to be greater then D", c.compareTo(d) > 0);
        assertTrue ("C has to be greater then A", a.compareTo(c) < 0);
        assertTrue ("C has to be greater then A", c.compareTo(a) > 0);

    }

    @Test
    public void testContains() {

    }

    @Test
    public void testIntersection() {

    }

    @Test
    public void testOverlap() {

    }

    @Test
    public void testUnion() {

    }

    @Test
    public void testEquals() {

    }
}
