package service;

import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Payment;
import data.ExercException;
import data.PaymentData;
import org.eclipse.jetty.http.HttpStatus;
import util.JsonUtil;
import util.ValidationUtil;

import java.io.IOException;

public class PaymentService {

    public static Payment createPayment(PaymentData paymentData) throws MPException, IOException, ExercException {

        // create payment
        Payment payment = paymentData.getPayment();

        if (payment.getStatus() == null){
            String message = payment.getLastApiResponse() != null ?
                    JsonUtil.getParam(payment.getLastApiResponse().getStringResponse(), "message")
                    : ValidationUtil.INPUT_DATA_FAILED;
            throw new ExercException(message, HttpStatus.BAD_REQUEST_400);
        }
        payment.save();

        return payment;

    }

}
