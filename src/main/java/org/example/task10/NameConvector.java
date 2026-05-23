package org.example.task10;

import java.util.List;
import java.util.stream.Collectors;

public class NameConvector {
    public static String convert(List<String> list) {
        return list.stream()
                .filter(item -> item.contains(" "))
                .distinct()
                .map(item -> item.substring(0, 1).toUpperCase() + item.substring(1).toLowerCase())
                .collect(Collectors.groupingBy(item -> item.substring(item.indexOf(" ") + 1),
                                Collectors.mapping(item -> item.substring(0, item.indexOf(" ")),
                                        Collectors.toList())))
                .toString();
    }
}
