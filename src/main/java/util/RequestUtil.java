package util;

import com.google.common.net.MediaType;
import spark.Request;

import java.io.IOException;

public class RequestUtil {

    public static<T> T getData(Request request, Class<T> tClass) throws IOException {

        String body = request.body();

        // Content-type: application/x-www-urlencoded'(estrutura dos dados
        // enviados/recebidos string de chave=valor separado por &)
        if (request.contentType().equals(MediaType.FORM_DATA.toString())){
            body = JsonUtil.INSTANCE.decodeMessage(body);
        }

        return JsonUtil.INSTANCE.mapToData(body, tClass);

    }
}
