package ec.edu.espe.gpr.message;

public class FileMessage {
    private String message;

    public FileMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}