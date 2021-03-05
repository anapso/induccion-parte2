package controller;

import data.ErrorResponse;
import data.ExercException;
import org.eclipse.jetty.http.HttpStatus;
import spark.Request;
import spark.Response;
import util.ResponseUtil;
import util.ValidationUtil;

public class ExceptionController {

    public static void exceptionHandler(ExercException exception, Request request, Response response){
        String message = ValidationUtil.hasValue(exception.getMessage()) ? exception.getMessage() : exception.toString();
        ResponseUtil.buidException(response, exception.getStatusCode(), message, exception.getError());
    }

    public static void defaultExceptionHandler(Exception exception, Request request, Response response){
        String message = ValidationUtil.hasValue(exception.getMessage()) ? exception.getMessage() : exception.toString();
        ResponseUtil.buildException(response, HttpStatus.INTERNAL_SERVER_ERROR_500, message);

    }
}
