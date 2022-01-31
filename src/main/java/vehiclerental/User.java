package vehiclerental;

import java.util.Objects;

public class User {
    private final String userName;
    private final String email;
    private int balance;

    public User(String userName, String email, int balance) {
        if (userName == null || userName.isBlank() ||
                email == null || email.isBlank()
                || balance < 0) {
            throw new IllegalArgumentException("Invalid parameters while creating new user!");
        }
        this.userName = userName;
        this.email = email;
        this.balance = balance;
    }

    public void minusBalance(int amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Amount must not be greater than balance!");
        }
        balance -= amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public int getBalance() {
        return balance;
    }
}
