package ge.mais.api.dto;

public class ErrorMessage {

    private String message;

    public ErrorMessage () {};

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorMessage(String message) {
        this.message = message;
    }
}
