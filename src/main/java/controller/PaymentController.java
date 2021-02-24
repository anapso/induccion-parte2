package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Payment;
import data.ExercException;
import data.PaymentData;
import org.eclipse.jetty.http.HttpStatus;
import service.PaymentService;
import spark.Request;
import spark.Response;
import spark.Route;
import util.Path;
import util.RequestUtil;
import util.ViewUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PaymentController {

    private static Gson gson = new GsonBuilder().create();

    public static Route getFormulary = (Request request, Response response) -> {

        // view of formulary
        Map<String, Object> model = new HashMap<>();
        return ViewUtil.render(request, model, Path.Template.PROCESS_PAYMENT);

    };

    public static Object processPayment(Request request, Response response) throws MPException, IOException, ExercException {

        // map the data
        PaymentData paymentData = RequestUtil.getData(request, PaymentData.class);

        // create payment
        PaymentService paymentService = new PaymentService();
        Payment paymentSeved = paymentService.createPayment(paymentData);

        // Response
        HashMap<String, Object> model = new HashMap<>();
        model.put("status", paymentSeved.getStatus().name());
        model.put("statusDetail", paymentSeved.getStatusDetail());
        response.status(HttpStatus.OK_200);
        return model;

    };
}
