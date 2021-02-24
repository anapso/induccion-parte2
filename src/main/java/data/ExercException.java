package data;

import java.util.List;

public class ExercException extends Exception{

    private Integer statusCode;
    private List<String> errors;

    public ExercException(String message, Integer statusCode){
        super(message);
        this.statusCode = statusCode;
    }

}
