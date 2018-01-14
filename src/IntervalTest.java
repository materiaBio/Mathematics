
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * This exercise is taken from CTU class "Object Modeling"
 */
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

        Interval a = new Interval(0, 2);
        Interval b = new Interval(0, 3);
        Interval c = new Interval(2, 3);
        Interval d = new Interval(0.7, 2.7);
        Interval e = new Interval(3, 4);
        Interval f = new Interval(0, 5);

        // a:   0----1----2
        // a:   0----1----2
        assertEquals(a.intersection(a), new Interval(0, 2));

        // a:   0----1----2
        // b:   0----1----2----3
        assertEquals(a.intersection(b), new Interval(0, 2));


        // b:   0----1----2----3
        // a:   0----1----2
        assertEquals(b.intersection(a), new Interval(0, 2));


        // a:   0----1----2
        // c:             2----3
        assertEquals(a.intersection(c), new Interval(2, 2));


        // c:             2----3
        // a:   0----1----2
        assertEquals(c.intersection(a), new Interval(2, 2));


        // a:   0----1----2
        // d:     0.7-----2---2.7
        assertEquals(a.intersection(d), new Interval(0.7, 2));

        // d:     0.7-----2---2.7
        // a:   0----1----2
        assertEquals(d.intersection(a), new Interval(0.7, 2));


        // e:                  3----4
        // f:   0----1----2----3----4----5
        assertEquals(e.intersection(f), new Interval(3, 4));


        // f:   0----1----2----3----4----5
        // e:                  3----4
        assertEquals(f.intersection(e), new Interval(3, 4));


        // a:   0----1----2
        // e:                  3----4
        assertEquals(a.intersection(e), null);

        // e:                  3----4
        // a:   0----1----2
        assertEquals(e.intersection(a), null);

        //check null pointer
        assertEquals(e.intersection(null), null);

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
