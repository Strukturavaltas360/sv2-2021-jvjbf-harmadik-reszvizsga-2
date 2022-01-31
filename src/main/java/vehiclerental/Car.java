package vehiclerental;

import java.time.LocalTime;

public class Car implements Rentable {
    private final String id;
    private final int pricePerMinute;
    private LocalTime rentingTime;

    public Car(String id, int pricePerMinute) {
        RentableValidator rentableValidator = new RentableValidator();
        rentableValidator.validateId(id, "Registration plate id");
        rentableValidator.validatePricePerMinute(pricePerMinute);
        this.id = id;
        this.pricePerMinute = pricePerMinute;
    }

    @Override
    public int calculateSumPrice(long minutes) {
        return (int) minutes * pricePerMinute;
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
    public void closeRent() {
        rentingTime = null;
    }

    public String getId() {
        return id;
    }

    public int getPricePerMinute() {
        return pricePerMinute;
    }
}
