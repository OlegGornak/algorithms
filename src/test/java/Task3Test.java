import org.example.task3.LinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task3Test {
    @Test
    void test() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        var node = list.addLast(5);
        list.addLast(3);
        list.addFirst(7);
        node = list.insertAfter(node, 9);
        node = list.insertAfter(node, 80);
        list.set(node, 8);
        node = list.insertAfter(node, 80);
        list.addFirst(100);
        list.addLast(100);
        list.removeFirst();
        list.removeLast();
        list.remove(node);

        Assertions.assertEquals("7, 1, 5, 9, 8, 3", list.getValues());
        Assertions.assertEquals(-1, list.indexOf(4));
        Assertions.assertEquals(2, list.indexOf(1));
        Assertions.assertTrue(list.isExist(5));
        Assertions.assertFalse(list.isExist(50));
    }
}
