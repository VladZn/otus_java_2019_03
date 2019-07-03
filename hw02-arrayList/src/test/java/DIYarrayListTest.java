import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DIYarrayListTest {
    private static final int INITIAL_SIZE = 25;

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
        final int size = INITIAL_SIZE;
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

        for (int i = 0; i < INITIAL_SIZE; i++) {
            list.add(i);
            arr[i] = i;
        }

        for (int i = INITIAL_SIZE; i < size; i++) {
            arr[i] = i;
        }

        Collections.addAll(list, 25, 26, 27, 28, 29, 30);

        assertArrayEquals(list.toArray(), arr);
    }

    @Test
    public void copyShouldThrowException() {
        List<String> src = new DIYarrayList<>();
        src.add("A");
        src.add("B");
        src.add("C");

        List<String> dest = new DIYarrayList<>();
        dest.addAll(List.of("1", "2"));
        assertThrows(IndexOutOfBoundsException.class, () -> Collections.copy(dest, src));
    }

    @Test
    public void copy() {
        List<String> src = new DIYarrayList<>();
        src.add("ab");
        src.add("cd");
        src.add("ef");
        src.add("gh");
        src.add("ij");
        src.add("kl");
        src.add("mn");
        src.add("op");
        src.add("qr");
        src.add("st");
        src.add("uv");
        src.add("wx");
        src.add("yz");
        src.addAll(List.of("12", "34", "56", "78", "90", "ABC", "DEF", "GHI", "!"));

        List<String> dest = new DIYarrayList<>();
        for (int i = 0; i < src.size(); i++) {
            dest.add(String.valueOf(i));
        }

        Collections.copy(dest, src);
        assertIterableEquals(src, dest);
    }

    @Test
    public void sort() {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < INITIAL_SIZE; i++) {
            list.add(random.nextInt(INITIAL_SIZE * 3));
        }
        Collections.sort(list);
        for (int i = 0; i < INITIAL_SIZE - 1; i++) {
            assertTrue(list.get(i).compareTo(list.get(i + 1)) <= 0);
        }
    }
}