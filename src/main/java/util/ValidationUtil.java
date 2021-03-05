package util;

import java.util.Date;
import java.util.List;

public class ValidationUtil {

    public static String INPUT_DATA_FAILED = "Input data failed";

    public static boolean hasValue(String value){
        return value != null && !value.isEmpty();
    }

    public static boolean hasValue(Integer value){
        return value != null && value > 0;
    }

    public static boolean hasValue(Float value){
        return value != null && value > 0;
    }

    public static <E> boolean hasValue(List<E> value){
        return value != null && !value.isEmpty();
    }

}
