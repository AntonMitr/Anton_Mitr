package com.cat.home;

public class ConfigConvert {

    public static Object convertValue(String str, Class<?> type) {
        if (type == int.class) {
            return Integer.parseInt(str);
        } else if (type == double.class) {
            return Double.parseDouble(str);
        } else if (type == float.class) {
            return Float.parseFloat(str);
        } else if (type == long.class) {
            return Long.parseLong(str);
        } else if (type == boolean.class) {
            return Boolean.parseBoolean(str);
        } else {
            return str;
        }
    }

}
