public class Date {
    private static final int DAY_MIN_VALUE = 1;
    private static final int DAY_MAX_VALUE = 31;
    private static final int DAY_DEFAULT_VALUE = 1;
    private static final int MONTH_MIN_VALUE = 1;
    private static final int MONTH_MAX_VALUE = 12;
    private static final int MONTH_DEFAULT_VALUE = 1;
    private static final int YEAR_MIN_VALUE = -3999;
    private static final int YEAR_MAX_VALUE = 3999;
    private static final int YEAR_DEFAULT_VALUE = 0;
    private static final int DAYS_A_YEAR = 365;


    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        if (day >= DAY_MIN_VALUE && day <= DAY_MAX_VALUE)
            this.day = day;
        else
            this.day = DAY_DEFAULT_VALUE;
        if (month >= MONTH_MIN_VALUE && month <= MONTH_MAX_VALUE)
            this.month = month;
        else
            this.month = MONTH_DEFAULT_VALUE;
        if (year >= YEAR_MIN_VALUE && year <= YEAR_MAX_VALUE)
            this.year = year;
        else
            this.year = YEAR_DEFAULT_VALUE;
    }

    public void setDay(int day) {
        if (day >= DAY_MIN_VALUE && day <= DAY_MAX_VALUE)
            this.day = day;
        else
            this.day = DAY_DEFAULT_VALUE;
    }

    public void setMonth(int month) {
        if (month >= MONTH_MIN_VALUE && month <= MONTH_MAX_VALUE)
            this.month = month;
        else
            this.month = MONTH_DEFAULT_VALUE;
    }

    public void setYear(int year) {
        if (year >= YEAR_MIN_VALUE && year <= YEAR_MAX_VALUE)
            this.year = year;
        else
            this.year = YEAR_DEFAULT_VALUE;
    }

    /**
     * Compares this Date object with the specified object for equality.
     * Returns true if the specified object is also a Date object
     * and has the same day, month, and year values.
     *
     * @param other the object to be compared for equality with this Date
     * @return true if the specified object is equal to this Date
     */
    @Override
    public boolean equals(Object other){
        if (other == null)
            return false;
        if (other instanceof DateTime && !(this instanceof DateTime) || this instanceof DateTime && !(other instanceof DateTime))
            return false;
        if (other instanceof Date) {
            Date date = (Date) other;
            if (this.day == date.day && this.month == date.month && this.year == date.year)
                return true;
        }
        return false;
    }

    /**
     * Returns a hash code value for this Date object.
     * the hashcode number represents the amount of days relatively to the fake date: 00/00/0000,
     * as a point of preference
     *
     * @return a hash code value for this Date object
     */
    @Override
    public int hashCode(){
        return this.year*DAYS_A_YEAR + this.month*DAY_MAX_VALUE + this.day;
    }

    @Override
    public String toString(){
        return String.format("%02d", this.day) + "/" +
                String.format("%02d", this.month) + "/" +
                String.format("%04d", this.year);
    }

}
