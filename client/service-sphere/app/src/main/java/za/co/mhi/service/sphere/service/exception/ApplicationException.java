package za.co.mhi.service.sphere.service.exception;

import androidx.annotation.NonNull;

public class ApplicationException extends RuntimeException{
    private String message = "Application Exception";

    public ApplicationException() {
    }

    public ApplicationException(String message) {
        this.message = message;
    }

    @NonNull
    @Override
    public String toString() {
        return message;
    }
}
