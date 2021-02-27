package data;

import java.util.List;

public class ExercException extends Exception{

    private Integer statusCode;
    private List<String> errors;

    public ExercException(String message, Integer statusCode){
        super(message);
        this.statusCode = statusCode;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
