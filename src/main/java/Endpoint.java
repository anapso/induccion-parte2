import controller.ExceptionController;
import controller.PaymentController;
import data.ExercException;
import spark.Spark;
import spark.servlet.SparkApplication;
import util.Constants;
import util.Path;

import static spark.Spark.exception;


public class Endpoint implements SparkApplication {

    @Override
    public void init() {

        //Spark.secure(Constants.keystoreFile, Constants.keystorePassword, Constants.truststoreFile, Constants.truststorePassword);

        Spark.get(Path.Web.PROCESS_PAYMENT, PaymentController.getFormulary);

        Spark.post(Path.Web.PROCESS_PAYMENT, PaymentController::processPayment);

        exception(ExercException.class, ExceptionController::exceptionHandler);

        exception(Exception.class, ExceptionController::defaultExceptionHandler);

    }
}

