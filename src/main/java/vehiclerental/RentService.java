package vehiclerental;

import java.time.LocalTime;
import java.util.*;

public class RentService {
    private Set<User> users = new HashSet<>();
    private Set<Rentable> rentables = new HashSet<>();
    private Map<Rentable, User> actualRenting = new TreeMap<>();

    public void registerUser(User user) {
        validateUser(user);
        if (users.contains(user)) {
            throw new UserNameIsAlreadyTakenException();
        }
        users.add(user);
    }

    public void addRentable(Rentable rentable) {
        validateRentable(rentable);
        rentables.add(rentable);
    }

    public void rent(User user, Rentable rentable, LocalTime time) {
        validateUser(user);
        validateRentable(rentable);
        if (rentable.getRentingTime() != null) {
            throw new IllegalStateException("Already rented!");
        }
        if (user.getBalance() < rentable.calculateSumPrice(180)) {
            throw new IllegalStateException("Low balance!");
        }
        rentable.rent(time);
        actualRenting.put(rentable, user);
    }

    public void closeRent(Rentable rentable, int minutes) {
        validateRentable(rentable);
        User user = actualRenting.get(rentable);
        if (user == null) {
            throw new IllegalStateException("No user found!");
        }
        user.minusBalance(rentable.calculateSumPrice(minutes));
        actualRenting.remove(rentable);
        rentable.closeRent();
    }

    public Set<User> getUsers() {
        return users;
    }

    public Set<Rentable> getRentables() {
        return rentables;
    }

    public Map<Rentable, User> getActualRenting() {
        return actualRenting;
    }

    private void validateUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User must not be null!");
        }
    }

    private void validateRentable(Rentable rentable) {
        if (rentable == null) {
            throw new IllegalArgumentException("Rentable must not be null!");
        }
    }
}
