package data;

import util.ValidationUtil;

public class ExercException extends Exception{

    private Integer statusCode;
    private String error;

    public ExercException(String message,  String error, Integer statusCode){
        super(message);
        this.statusCode = statusCode;
        this.error = error;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder();
        message.append(super.toString());

        if (ValidationUtil.hasValue(statusCode)){
            message.append(" status_code: ");
            message.append(statusCode);
        }
        if (ValidationUtil.hasValue(error)){
            message.append(" errors: ");
            message.append(String.join(", ", error));
        }

        return message.toString();
    }
}
