import annotation.After;
import annotation.Before;
import annotation.Test;

/**
 * @author V. Zinchenko
 */
public class RocketTest {
    private Rocket rocket;

    @Before
    public void setUp() {
        rocket = new Rocket(0, 100, 30);
        System.out.println("A rocket initialization");
    }

    @After
    public void tearDown() {
        rocket = null;
        System.out.println("A rocket utilization");
    }

    @Test
    public void fillingTest() {
        int volume = 50;
        rocket.fillTank(volume);

    }

    @Test
    public void takeOffTestExceptionExpected() {
        rocket.fillTank(20);
        rocket.takeOff();
    }
}
