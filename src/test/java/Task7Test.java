import org.example.task7.IntersectionFinder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Task7Test {
    @Test
    void findIntersections_test() {
        var expectedList = List.of("DAFG", "AFRG", "AERG", "DFRG", "DERG", "DARG");
        var serv = new IntersectionFinder();
        var result = serv.findIntersections("ABDEFADRFG", "DAFERG");
        expectedList.forEach(exp -> {
            Assertions.assertTrue(result.contains(exp));
        });
    }
}
