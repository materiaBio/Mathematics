

public class Interval implements Comparable<Interval> {
    /**
     * The begining of the interval
     */
    protected double start;

    /**
     * The end of the interval
     */
    protected double end;

    /**
     * @param start begining of the interval
     * @param end end of the interval
     */
    public Interval(double start, double end){
        if (start > end) throw new RuntimeException(String.format("<%s, %s>", String.valueOf(start), String.valueOf(end)) + " interval start cannot be greater then it`s end");
        this.start = start;
        this.end = end;
    }

    public boolean contains(double number){
        return (number >= start && number <= end);
    }


    public Interval intersection(Interval that) {
        if (that == null) {
            return null;
        }
        if (!this.overlap(that)) {
            return null;
        }

        if (this.start <= that.start) {
            if (this.end <= that.end) {
                return new Interval(that.start, this.end);
            } else {
                return new Interval(that.start, that.end);
            }
        } else {
            if (this.end >= that.end) {
                return new Interval(this.start, that.end);
            } else {
                return new Interval(this.start, this.end);
            }
        }
    }

    public boolean overlap(Interval that){
        return !(end < that.start || start > that.end);
    }


    public Interval union(Interval that) {
        if (that == null) {
            return null;
        }
        if (!this.overlap(that)) {
            return null;
        }

        if (this.start <= that.start) {
            if (this.end <= that.end) {
                return new Interval(this.start, that.end);
            } else {
                return new Interval(this.start, this.end);
            }
        } else {
            if (this.end >= that.end) {
                return new Interval(that.start, this.end);
            } else {
                return new Interval(that.start, that.end);
            }
        }
    }

    public int compareTo(Interval that) {
        if (that == null) {
            return -1;
        }

        if (this.start == that.start && this.end == that.end) {
            return 0;
        }
        if (this.start > that.start || (this.start == that.start && this.end > that.end)) {
            return 1;
        }
        return -1;
    }

    public double getIntervalLength(Interval interval) {
        return interval.end - interval.start;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.start) ^ (Double.doubleToLongBits(this.start) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.end) ^ (Double.doubleToLongBits(this.end) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object druhy) {
        if (druhy instanceof Interval) return (start == ((Interval) druhy).start) && (end == ((Interval) druhy).end);
        else return false;
    }
}
