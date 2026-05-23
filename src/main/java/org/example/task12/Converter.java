package org.example.task12;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Converter {
    private Map<Class, Function<String, Object>> converters = new HashMap<>();

    public void addConverter(Class clz, Function<String, Object> function) {
        converters.put(clz, function);
    }

    public <T> T convert(String str, Class<T> clz) {
        return (T) converters.get(clz).apply(str);
    }
}
