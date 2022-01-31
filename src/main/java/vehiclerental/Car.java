package vehiclerental;

import java.time.LocalTime;

public class Car implements Rentable {
    private final String id;
    private final int pricePerMinute;
    private int rentingTime;

    public Car(String id, int pricePerMinute) {
        this.id = id;
        this.pricePerMinute = pricePerMinute;
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

    public int getPricePerMinute() {
        return pricePerMinute;
    }
}
