package task14;

import org.example.task14.Item;
import org.example.task14.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class OrderServiceTest {

    OrderService service = new OrderService();

    @Test
    void calc_common() {
        var items = List.of(new Item("table", 100, 1),
                new Item("chair", 50 , 4));

        var result = service.calc(items, "COMMON");

        Assertions.assertEquals(300d, result);
    }

    @Test
    void calc_vip() {
        var items = List.of(new Item("table", 100, 1),
                new Item("chair", 50 , 4));

        var result = service.calc(items, "VIP");

        Assertions.assertEquals(270d, result);
    }

    @Test
    void calc_new() {
        var items = List.of(new Item("table", 100, 1),
                new Item("chair", 50 , 4));

        var result = service.calc(items, "NEW");

        Assertions.assertEquals(285d, result);
    }

    @Test
    void calc_large() {
        var items = List.of(new Item("table", 100, 10),
                new Item("chair", 50 , 4));

        var result = service.calc(items, "COMMON");

        Assertions.assertEquals(1150d, result);
    }
}
