package za.co.mhi.service.sphere.service.exception;

public class InvalidEmailOrPasswordException extends ApplicationException{
    public InvalidEmailOrPasswordException() {
        super("Invalid email/password");
    }
}
