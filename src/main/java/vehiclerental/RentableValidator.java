package vehiclerental;

import java.time.LocalTime;

public class RentableValidator {
    public void validateRent(LocalTime time) {
        if (time == null) {
            throw new IllegalArgumentException("Rent time must not be null!");
        }
    }

    public void validateId(String id, String title) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException(String.format("%s must not be null or blank!", title));
        }
    }

    public void validatePricePerMinute(int pricePerMinute) {
        if (pricePerMinute <= 0) {
            throw new IllegalArgumentException(String.format("Invalid price per minute (%d)!", pricePerMinute));
        }
    }
}
