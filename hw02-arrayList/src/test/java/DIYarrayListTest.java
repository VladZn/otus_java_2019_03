import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DIYarrayListTest {

    @Test
    public void size() {
        List<Integer> list = new DIYarrayList<>();
        list.add(1);
        list.add(10);
        assertEquals(2, list.size());
    }

    @Test
    public void isEmpty() {
        List<Integer> list = new DIYarrayList<>();
        assertTrue(list.isEmpty());
        list.add(1);
        assertFalse(list.isEmpty());
    }

    @Test
    public void add() {
        List<Integer> list = new DIYarrayList<>();
        final int size = 30;
        for (int i = 0; i < size; i++) {
            assertTrue(list.add(i));
        }
        assertEquals(size, list.size());
    }

    @Test
    public void addAll() {
        int size = 31;
        DIYarrayList<Integer> list = new DIYarrayList<>();
        Integer[] arr = new Integer[size];

        for (int i = 0; i < 25; i++) {
            list.add(i);
            arr[i] = i;
        }

        for (int i = 25; i < size; i++) {
            arr[i] = i;
        }

        Collections.addAll(list, 25, 26, 27, 28, 29, 30);

        assertArrayEquals(list.toArray(), arr);
    }

    @Test
    public void copy() {
        List<String> dest = new DIYarrayList<>();
        dest.add("ab");
        dest.add("cd");
        dest.add("ef");
        dest.add("gh");
        dest.add("ij");
        dest.add("kl");
        dest.add("mn");
        dest.add("op");
        dest.add("qr");
        dest.add("st");
        dest.add("uv");
        dest.add("wx");
        dest.add("yz");

        dest.addAll(List.of("12", "34", "56", "78", "90", "ABC", "DEF", "GHI", "!"));

        List<String> src = new DIYarrayList<>();
        Collections.copy(dest, src);
        assertIterableEquals(src, dest);
    }

    @Test
    public void sort() {

    }
}