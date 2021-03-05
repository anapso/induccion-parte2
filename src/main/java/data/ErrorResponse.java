package data;

public class ErrorResponse {

    private final Integer httpStatus;
    private final String error;
    private final String message;

    public ErrorResponse(Integer httpStatus, String error, String message) {
        this.httpStatus = httpStatus;
        this.error = error;
        this.message = message;
    }


    public Integer getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public String getError() {
        return error;
    }
}
