package vehiclerental;

import java.time.LocalTime;

public interface Rentable extends Comparable<Rentable> {
    int calculateSumPrice(long minutes);
    LocalTime getRentingTime();
    void rent(LocalTime time);
    void closeRent();

    @Override
    default int compareTo(Rentable o) {
        if (getRentingTime() == null && o.getRentingTime() == null) {
            return 0;
        }
        if (getRentingTime() == null) {
            return -o.getRentingTime().compareTo(getRentingTime());
        }
        return getRentingTime().compareTo(o.getRentingTime());
    }
}
