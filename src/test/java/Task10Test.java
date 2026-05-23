import org.example.task10.NameConvector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Task10Test {
    @Test
    void convert_test() {
        var list = List.of("вася 5", "Петя 3", "АНЯ 5" , "Тото");
        var result = NameConvector.convert(list);
        Assertions.assertEquals("{3=[Петя], 5=[Вася, Аня]}", result);
    }
}
