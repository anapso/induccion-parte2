package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import spark.ResponseTransformer;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public enum JsonUtil implements ResponseTransformer {

    INSTANCE;

    public static final ObjectMapper mapper = new ObjectMapper();

    // Map a json string to a data model of the class
    public static <T> T mapToData(String str, Class<T> tClass) throws IOException {

        try {
            return mapper.readValue(str, tClass);
        }
        catch (IOException e) {
            throw new IOException(e.getMessage().replace('"','\''));
        }
    }

    // Get the value of a field
    public static String getParam(String json, String field) throws IOException {
        return mapper.readTree(json).get(field).asText();
    }

    public static <T> String errorDataToJson(T errorResponse){

        try{
            return mapper.writeValueAsString(errorResponse);
        } catch (IOException e) {
            return "{ " +
                    "\"error\":\", " +
                    "\"message\":\" " + e.getMessage() + " \" " +
                    "}";
        }
    }

    // Render the model in a string with json format
    @Override
    public String render(Object model) throws IOException {
        return mapper.writeValueAsString(model);
    }

    // decode a string to UTF-8
    public static String decodeMessage(String paramIn) throws UnsupportedEncodingException {
        String data = URLDecoder.decode(paramIn, StandardCharsets.UTF_8.name());
        data = data.replaceAll("=", "\":\"");
        data = data.replaceAll("&", "\",\"");
        return "{\"" + data + "\"}";
    }

}
