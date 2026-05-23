package org.example.task12;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private final Converter converter;
    private List<String> data = new ArrayList<>();

    public DataBase(Converter converter) {
        this.converter = converter;
    }

    public void add(Object ob) {
        data.add(ob.toString());
    }

    public <T> T get(int indx, Class<T> clz) {
        return converter.convert(data.get(indx), clz);
    }
}
