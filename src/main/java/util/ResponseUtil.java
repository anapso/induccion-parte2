package util;

import com.google.common.net.MediaType;
import data.ErrorResponse;
import org.eclipse.jetty.http.HttpStatus;
import spark.Response;

import java.util.HashMap;

public class ResponseUtil {

    public static void buidException(Response response, Integer httpStatus, String message, String error){
        buildException(response, httpStatus, message, error);
    }

    public static void buildException(Response response, Integer httpStatus, String message) {
        buildException(response, httpStatus, message, null);
    }

    public static void buildException(Response response, Integer httpStatus, String message, String error){
        String responseBody = buildError(httpStatus, message, error);
        response.body(responseBody);
        response.status(httpStatus);
        response.header("Content-Type", MediaType.JSON_UTF_8.toString());
    }

    // Build
    public static String buildError(Integer httpStatus, String message, String error){

        if (error != null && error != ""){
            ErrorResponse errorResponse = new ErrorResponse(httpStatus, message, error);
            return JsonUtil.INSTANCE.errorDataToJson(errorResponse);
        }

        HashMap<String, Object> model = new HashMap<>();
        model.put("httpStatus", HttpStatus.getMessage(HttpStatus.BAD_REQUEST_400));
        model.put("message", message);
        model.put("errors", error);
        return JsonUtil.INSTANCE.errorDataToJson(model);
    }

}
