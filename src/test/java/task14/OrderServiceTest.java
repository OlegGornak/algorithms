package task14;

import org.example.task14.ClientType;
import org.example.task14.DiscountService;
import org.example.task14.Item;
import org.example.task14.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class OrderServiceTest {

    OrderService service = new OrderService(new DiscountService());

    @Test
    void calc() {
        var items = List.of(new Item("table", 100, 1),
                new Item("chair", 50 , 4));

        var result = service.calc(items, ClientType.COMMON);

        Assertions.assertEquals(300d, result);
    }

    @Test
    void calc_empty() {
        List<Item> items = List.of();

        var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> service.calc(items, ClientType.VIP));

        Assertions.assertEquals("Список товаров не может быть пустым", exception.getMessage());
    }

    @Test
    void calc_null() {
        List<Item> items = List.of();

        var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> service.calc(null, ClientType.VIP));

        Assertions.assertEquals("Список товаров не может быть пустым", exception.getMessage());
    }
}
