import org.example.task2.Result;
import org.example.task2.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Task2Test {
    @Test
    public void mainTest() {
        List<Integer> lst = List.of(1, 12, 6, 7, 12, 15, 2, 3, 4, 5);
        Result res = Solution.findMinMaxCompact(lst);
        Assertions.assertEquals(1, res.min());
        Assertions.assertEquals(15, res.max());
    }
}
