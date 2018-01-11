
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
        Interval interval = new Interval (-300, 17);

        //minimum extreme points
        assertTrue(interval.contains(-300.0));
        assertFalse(interval.contains(-300.0000001));
        assertTrue(interval.contains(-299.9999999));

        //maximum extreme points
        assertTrue(interval.contains(17.0));
        assertTrue(interval.contains(0));
        assertTrue(interval.contains(16.9999999999));
        assertFalse(interval.contains(17.00000000000001));

        //middle points
        assertTrue(interval.contains(16));
        assertTrue(interval.contains(0));
        assertTrue(interval.contains(-150));

        //out of the interval
        assertFalse(interval.contains(100));
        assertFalse(interval.contains(500));
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
