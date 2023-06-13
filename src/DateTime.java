import java.util.Objects;

public class DateTime extends Date {
    private static final int HOUR_MIN_VALUE = 0;
    private static final int HOUR_MAX_VALUE = 23;
    private static final int HOUR_DEFAULT_VALUE = 0;
    private static final int MINUTE_MIN_VALUE = 0;
    private static final int MINUTE_MAX_VALUE = 59;
    private static final int MINUTE_DEFAULT_VALUE = 0;
    private int hour;
    private int minute;

    public DateTime(int day, int month, int year, int hour, int minute) {
        super(day, month, year);
        if (hour >= HOUR_MIN_VALUE && hour <= HOUR_MAX_VALUE)
            this.hour = hour;
        else
            this.hour = HOUR_DEFAULT_VALUE;
        if(minute >= MINUTE_MIN_VALUE && minute <= MINUTE_MAX_VALUE)
            this.minute = minute;
        else
            this.minute = MINUTE_DEFAULT_VALUE;
    }


    @Override
    public void setDay(int day) {
        super.setDay(day);
    }

    @Override
    public void setMonth(int month) {
        super.setMonth(month);
    }

    @Override
    public void setYear(int year) {
        super.setYear(year);
    }

    public void setHour(int hour) {
        if (hour >= HOUR_MIN_VALUE && hour <= HOUR_MAX_VALUE)
            this.hour = hour;
        else
            this.hour = HOUR_DEFAULT_VALUE;
    }

    public void setMinute(int minute) {
        if(minute >= MINUTE_MIN_VALUE && minute <= MINUTE_MAX_VALUE)
            this.minute = minute;
        else
            this.minute = MINUTE_DEFAULT_VALUE;
    }

    /**
     * Compares this DateTime object with the specified object for equality.
     * Returns true if the specified object is also a DateTime object and has the same hour and minute values,
     * in addition to satisfying the equality comparison defined in the superclass (Date).
     *
     * @param other the object to be compared for equality with this DateTime
     * @return true if the specified object is equal to this DateTime
     */
    @Override
    public boolean equals(Object other) {

        if (!super.equals(other))
            return false;
        if (other == null)
            return false;
        if (other instanceof DateTime) {
            DateTime dateTime = (DateTime) other;
            if (this.hour == dateTime.hour && this.minute == dateTime.minute)
                return true;
        }
        return false;
    }

    /**
     * Returns a hash code value for this DateTime object.
     * the hashcode number represents the amount of minutes relatively to the fake date: 00/00/0000,
     * as a point of preference
     *
     * @return a hash code value for this Date object
     */
    @Override
    public int hashCode() {
        int hashCode = super.hashCode();

        hashCode += this.hour*MINUTE_MAX_VALUE + this.minute;
        return hashCode;
    }

    @Override
    public String toString() {
        String date = super.toString();
        return date + " " + String.format("%02d", this.hour) + ":" +
                String.format("%02d", this.minute);

    }
}
