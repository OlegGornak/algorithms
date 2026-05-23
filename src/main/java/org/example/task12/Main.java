package org.example.task12;

public class Main {
    static void main(String[] args) {
        var converter = new Converter();
        converter.addConverter(Integer.class, Integer::parseInt);
        converter.addConverter(String.class, x -> x);
        DataBase dataBase = new DataBase(converter);
        dataBase.add(4);

        String val1 = dataBase.get(0, String.class);
        Integer val2 = dataBase.get(0, Integer.class);
        System.out.println(val1);
        System.out.println(val2);
    }
}
