package util;

import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;

public class EndpointUtil {

    public static String ACCESS_TOKEN = "TEST-8926252892289206-022421-851ec6d040ccd7efbdd83274f56bdb35-707280255";
    //public static String ACCESS_TOKEN = "APP_USR-8926252892289206-021820-6eed30f4a1e0d1a824644fa71ad68489-707280255";
    public static void setUserCredentials() throws MPException {
        MercadoPago.SDK.setAccessToken(EndpointUtil.ACCESS_TOKEN);
    };

}
