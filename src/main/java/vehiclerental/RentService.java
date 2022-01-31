package vehiclerental;

import java.time.LocalTime;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class RentService {
    private Set<User> users = new TreeSet<>();
    private Set<Rentable> rentables = new TreeSet<>();
    private Map<Rentable, User> actualRenting = new TreeMap<>();

    public void registerUser(User user) {

    }

    public void addRentable(Rentable rentable) {

    }

    public void rent(User user, Rentable rentable, LocalTime time) {

    }

    public void closeRent(Rentable rentable, int minutes) {

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
}
