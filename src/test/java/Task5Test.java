import org.example.task5.ConvertMatrixToList;
import org.example.task5.TopologicalSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Task5Test {
    @Test
    void convertMatrixToList() {
        var arr = new int[][]{
                {0, 1, 1, 0},
                {1, 0, 1, 1},
                {1, 1, 0, 0},
                {0, 0, 0, 0}
        };

        var expected = List.of(
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{1, 0},
                new int[]{1, 2},
                new int[]{1, 3},
                new int[]{2, 0},
                new int[]{2, 1});

        var converter = new ConvertMatrixToList();
        var result = converter.convert(arr);
        for (int i = 0; i < result.size(); i++) {
            Assertions.assertEquals(expected.get(i)[0], result.get(i)[0]);
            Assertions.assertEquals(expected.get(i)[1], result.get(i)[1]);
        }
    }

    @Test
    void topologicalSort() {
        TopologicalSort topologicalSort = new TopologicalSort();
        var arr = new int[][]{
                {0, 1, 0, 0, 1},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        var expected = new int[]{0, 4, 1, 2, 3};
        var result = topologicalSort.sort(arr);

        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }
}
