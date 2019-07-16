import annotation.AfterAll;
import annotation.AfterEach;
import annotation.BeforeEach;
import annotation.BeforeAll;
import annotation.Test;

/**
 * @author V. Zinchenko
 */
public class RocketTest {
    private Rocket rocket;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("The very first method has been invoked.");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("The last one method has been invoked.");
    }

    @BeforeEach
    public void setUp() {
        rocket = new Rocket(0, 100, 30);
    }

    @AfterEach
    public void tearDown() {
        rocket = null;
    }

    @Test
    public void fillingTest() {
        int volume = 50;
        rocket.fillTank(volume);

    }

    @Test
    public void takeOffTest() {
        rocket.fillTank(80);
        rocket.takeOff();
    }

    @Test
    public void takeOffTestExceptionExpected() {
        rocket.fillTank(20);
        rocket.takeOff();
    }

    public void testShouldNotBeInvoked() {
        System.out.println("Not annotated method. If you see this message, this is an error.");
    }
}
