package task14;

import org.example.task14.ClientType;
import org.example.task14.DiscountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DiscountServiceTest {

    DiscountService service = new DiscountService();

    @Test
    void apply_common() {
        var result = service.apply(300, 2, ClientType.COMMON);

        Assertions.assertEquals(300d, result);
    }

    @Test
    void apply_vip() {
        var result = service.apply(300, 1, ClientType.VIP);

        Assertions.assertEquals(270d, result);
    }

    @Test
    void apply_new() {
        var result = service.apply(300, 5, ClientType.NEW);

        Assertions.assertEquals(285d, result);
    }

    @Test
    void apply_large() {
        var result = service.apply(1200, 4, ClientType.COMMON);

        Assertions.assertEquals(1150d, result);
    }

    @Test
    void apply_amount_more_then_ten() {
        var result = service.apply(100, 15, ClientType.COMMON);

        Assertions.assertEquals(99d, result);
    }
}
