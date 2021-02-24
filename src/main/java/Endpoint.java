import controller.PaymentController;
import spark.Spark;
import spark.servlet.SparkApplication;
import util.Constants;
import util.Path;


public class Endpoint implements SparkApplication {

    @Override
    public void init() {

        Spark.secure(Constants.keystoreFile, Constants.keystorePassword, Constants.truststoreFile, Constants.truststorePassword);

        Spark.get(Path.Web.PROCESS_PAYMENT, PaymentController.getFormulary);

        Spark.post(Path.Web.PROCESS_PAYMENT, PaymentController::processPayment);

    }
}
