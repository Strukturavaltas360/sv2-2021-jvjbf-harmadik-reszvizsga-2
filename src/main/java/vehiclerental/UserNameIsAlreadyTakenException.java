package vehiclerental;

public class UserNameIsAlreadyTakenException extends RuntimeException {
    public UserNameIsAlreadyTakenException() {
        super("Username is taken!");
    }
}
