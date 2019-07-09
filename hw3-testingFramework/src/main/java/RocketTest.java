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
        System.out.println("BeforeEach all method");
    }

    @BeforeEach
    public void setUp() {
        rocket = new Rocket(0, 100, 30);
//        System.out.println("A rocket initialization");
    }

    @AfterEach
    public void tearDown() {
        rocket = null;
//        System.out.println("A rocket utilization");
    }

    @Test
    public void fillingTest() {
        int volume = 50;
        rocket.fillTank(volume);

    }

//    @Test
    public void takeOffTestExceptionExpected() {
        rocket.fillTank(20);
        rocket.takeOff();
    }

    public void shouldNotBeInvoked() {
        System.out.println("Not annotated method");
    }
}
