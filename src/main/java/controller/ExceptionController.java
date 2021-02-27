package controller;

import data.ExercException;
import spark.Request;
import spark.Response;

public class ExceptionController {

    public static void exceptionHandler(ExercException exception, Request request, Response response){
        response.status(exception.getStatusCode());
        response.body(exception.getMessage());
    }
}
