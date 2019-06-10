import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DIYarrayListTest {

    private List<Integer> list;

    @Before
    public void init() {
        list = new DIYarrayList<>();
    }

    @Test
    public void size() {
        list.add(1);
        list.add(10);
        assertEquals(2, list.size());
    }

    @Test
    public void isEmpty() {
        assertTrue(list.isEmpty());
        list.add(1);
        assertFalse(list.isEmpty());
    }

    @Test
    public void add() {
        assertTrue(list.add(1));
        assertEquals(1, list.size());
    }

    @Test
    public void addAll() {
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