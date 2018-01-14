
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

        Interval a = new Interval(0, 2);
        Interval b = new Interval(0, 3);
        Interval c = new Interval(2, 3);
        Interval d = new Interval(0.7, 2.7);
        Interval e = new Interval(3, 4);
        Interval f = new Interval(0, 5);

        // a:   0----1----2
        // b:   0----1----2----3
        assertEquals(a.overlap(b), true);


        // b:   0----1----2----3
        // a:   0----1----2
        assertEquals(b.overlap(a), true);


        // a:   0----1----2
        // c:             2----3
        assertEquals(a.overlap(c), true);


        // c:             2----3
        // a:   0----1----2
        assertEquals(c.overlap(a), true);


        // a:   0----1----2
        // d:     0.7-----2---2.7
        assertEquals(a.overlap(d), true);


        // d:     0.7-----2---2.7
        // a:   0----1----2
        assertEquals(d.overlap(a), true);


        // e:                  3----4
        // f:   0----1----2----3----4----5
        assertEquals(e.overlap(f), true);


        // f:   0----1----2----3----4----5
        // e:                  3----4
        assertEquals(f.overlap(e), true);


        // a:   0----1----2
        // e:                  3----4
        assertEquals(a.overlap(e), false);


        // e:                  3----4
        // a:   0----1----2
        assertEquals(e.overlap(a), false);
    }

    @Test
    public void testUnion() {

        Interval a = new Interval(0, 2);
        Interval b = new Interval(2, 3);
        Interval c = new Interval(1.7, 2.7);
        Interval d = new Interval(2.0001, 3);


        // a:   0----1----2
        // b:             2----3
        assertEquals(a.union(b), new Interval(0, 3));


        // b:             2----3
        // a:   0----1----2
        assertEquals(b.union(a), new Interval(0, 3));


        // a:   0----1----2
        // c:          1.7----2.7
        assertEquals(a.union(c), new Interval(0, 2.7));


        // c:          1.7----2.7
        // a:   0----1----2
        assertEquals(c.union(a), new Interval(0, 2.7));


        // b:            2----3
        // c:      1.5----2.5
        assertEquals(b.union(c), new Interval(1.7, 3));


        // c:      1.5----2.5
        // b:            2----3
        assertEquals(c.union(b), new Interval(1.7, 3));


        // a:   0----1----2
        // d:              2.1----3
        assertEquals(a.union(d), null);


        // d:              2.1----3
        // a:   0----1----2
        assertEquals(d.union(a), null);
    }

    @Test
    public void testEquals() {
        Interval a = new Interval(0, 2);
        Interval b = new Interval(0, 2);
        Interval c = new Interval(0, 3);
        Interval d = new Interval(1.5, 2);

        // a:   0----1----2
        // b:   0----1----2
        assertEquals(a, b);


        // b:   0----1----2
        // a:   0----1----2
        assertEquals(b, a);


        // a:   0----1----2
        // c:   0----1----2----3
        assertFalse(a.equals(c));


        // c:   0----1----2----3
        // d:         1.5---2.5
        assertFalse(c.equals(d));


        // a:   0----1----2
        // d:         1.5---2.5
        assertFalse(a.equals(d));


        //check null pointer exception
        assertFalse(a.equals(null));
    }
}
