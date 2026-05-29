package task14;

import org.example.task14.ClientType;
import org.example.task14.DiscountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DiscountServiceTest {

    DiscountService service = new DiscountService();

    @Test
    void apply_common() {
        var result = service.apply(300, ClientType.COMMON);

        Assertions.assertEquals(300d, result);
    }

    @Test
    void apply_vip() {
        var result = service.apply(300, ClientType.VIP);

        Assertions.assertEquals(270d, result);
    }

    @Test
    void apply_new() {
        var result = service.apply(300, ClientType.NEW);

        Assertions.assertEquals(285d, result);
    }

    @Test
    void apply_large() {
        var result = service.apply(1200, ClientType.COMMON);

        Assertions.assertEquals(1150d, result);
    }
}
