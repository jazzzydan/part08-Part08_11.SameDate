import java.util.Objects;

public class SimpleDate {

    private int day;
    private int month;
    private int year;

    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }

    public boolean earlier(SimpleDate other) {
        if (this.year < other.year) {
            return true;
        }

        if (this.year == other.year
                && this.month < other.month) {
            return true;
        }

        if (this.year == other.year
                && this.month == other.month
                && this.day < other.day) {
            return true;
        }

        return false;
    }

    public int differenceInYears(SimpleDate other) {
        if (earlier(other)) {
            return other.differenceInYears(this);
        }

        int yearRemoved = 0;

        if (this.month < other.month) {
            yearRemoved = 1;
        } else if (this.month == other.month && this.day < other.day) {
            yearRemoved = 1;
        }

        return this.year - other.year - yearRemoved;
    }

    @Override
    public boolean equals(Object object) {
        // if the variables are located in the same place, they're the same
        if (this == object) {
            return true;
        }
        // if comparedObject is not of type SimpleDate, the objects aren't the same
        if (!(object instanceof SimpleDate)) {
            return false;
        }
        // let's convert the object to a SimpleDate-object
        SimpleDate comparedDate = (SimpleDate) object;
        // if the instance variables of the objects are the same, so are the objects
        if (this.day == comparedDate.getDay() &&
                this.month == comparedDate.getMonth() &&
                this.year == comparedDate.getYear()) {
            return true;
        }
        // otherwise, the objects aren't the same
        return false;
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(day, month, year);
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof SimpleDate)) return false;
//        SimpleDate that = (SimpleDate) o;
//        return getDay() == that.getDay() && getMonth() == that.getMonth() && getYear() == that.getYear();
//    }
}
