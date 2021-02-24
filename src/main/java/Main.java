import com.mercadopago.exceptions.MPException;
import util.EndpointUtil;

import static spark.Spark.port;

public class Main {

    public static void main(String[] args) throws MPException {

        // configure
        port(4567);

        // Credentials
        EndpointUtil.setUserCredentials();

        // endpoint spark
        new Endpoint().init();
    }
}
