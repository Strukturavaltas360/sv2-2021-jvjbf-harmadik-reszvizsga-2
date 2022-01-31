package vehiclerental;

import java.time.LocalTime;
import java.util.Objects;

public class Bike implements Rentable {
    private final String id;
    private LocalTime rentingTime;

    public Bike(String id) {
        new RentableValidator().validateId(id, "Registration id");
        this.id = id;
    }

    @Override
    public int calculateSumPrice(long minutes) {
        return (int) minutes * 15;
    }

    @Override
    public LocalTime getRentingTime() {
        return rentingTime;
    }

    @Override
    public void rent(LocalTime time) {
        new RentableValidator().validateRent(time);
        rentingTime = LocalTime.of(time.getHour(), time.getMinute());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bike bike = (Bike) o;
        return Objects.equals(id, bike.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public void closeRent() {
        rentingTime = null;
    }

    public String getId() {
        return id;
    }
}
