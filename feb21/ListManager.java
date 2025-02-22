import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class ListManagerTest {

    @Test
    void testAddElement() {
        List<Integer> list = new ArrayList<>();
        ListManager.addElement(list, 5);
        assertEquals(1, list.size());
        assertTrue(list.contains(5));
    }

    @Test
    void testRemoveElement() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        ListManager.removeElement(list, 10);
        assertFalse(list.contains(10));
    }

    @Test
    void testGetSize() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        assertEquals(2, ListManager.getSize(list));
    }
}

public class ListManager {
    public static void addElement(List<Integer> list, int element) {
        list.add(element);
    }

    public static void removeElement(List<Integer> list, int element) {
        list.remove(Integer.valueOf(element));
    }

    public static int getSize(List<Integer> list) {
        return list.size();
    }
}