package util;

import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;

public class EndpointUtil {

    public static String ACCESS_TOKEN = "TEST-8926252892289206-022422-9886aa6c1ad1765a3172628a300ea6cd-707280255";
    public static void setUserCredentials() throws MPException {
        MercadoPago.SDK.setAccessToken(EndpointUtil.ACCESS_TOKEN);
    };

}
