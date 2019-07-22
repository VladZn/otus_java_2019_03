import java.util.HashMap;
import java.util.Map;

/**
 * @author V. Zinchenko
 */
public class MemoryLeakDemo {
    public static void main(String[] args) throws InterruptedException {
        Map<Person, Integer> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {

            for (int j = 0; j < 100_000; j++) {
                map.put(new Person("John Doe"), 1);
            }
            Thread.sleep(5000);
        }

        System.out.println("Map size:" + map.size());
    }
}
