import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class DIYarrayListTest {

    @Test
    public void size() {
        List<Integer> list = new DIYarrayList<>();
        list.add(1);
        list.add(10);
        assertTrue(list.size() == 2);
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
    }

    @Test
    public void addAll() {
        DIYarrayList<Integer> list = new DIYarrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Collections.addAll(list, 4, 5, 6);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
//        assertArrayEquals();
    }

    @Test
    public void copy() {
//        Collections
    }

    @Test
    public void sort() {

    }
}