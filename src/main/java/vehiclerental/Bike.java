package vehiclerental;

import java.time.LocalTime;

public class Bike implements Rentable {
    private final String id;
    private int rentingTime;

    public Bike(String id) {
        this.id = id;
    }

    @Override
    public int calculateSumPrice(long minutes) {
        return 0;
    }

    @Override
    public LocalTime getRentingTime() {
        return null;
    }

    @Override
    public void rent(LocalTime time) {

    }

    @Override
    public void closeRent() {

    }

    public String getId() {
        return id;
    }
}
