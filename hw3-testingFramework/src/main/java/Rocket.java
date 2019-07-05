/**
 * @author V. Zinchenko
 */
public class Rocket {
    private static final String INSUFFICIENT_FUEL_MSG = "Can not take off because of the insufficient fuel (%d/%d).";

    private int fuel;
    private int tankCapacity;
    private int minVolume;

    public boolean isFlightMode() {
        return flightMode;
    }

    private boolean flightMode;

    public Rocket(int fuel, int tankCapacity, int minVolume) {
        this.fuel = fuel;
        this.tankCapacity = tankCapacity;
        this.minVolume = minVolume;
        flightMode = false;
    }

    public boolean fillTank(int volume) {
        if (fuel + volume > tankCapacity) {
            System.out.println("Too much fuel");
        }
        fuel += volume;
        return true;
    }

    public void takeOff() {
        if (fuel < minVolume) {
            throw new InsufficientFuelException(String.format(INSUFFICIENT_FUEL_MSG, fuel, minVolume));
        }
        System.out.println("Ignition. We'are taking off.");
        flightMode = true;
    }
}
