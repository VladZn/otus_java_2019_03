import java.io.Serializable;

public class CalculatorImpl implements Calculator, Serializable {

    @Override
    public int sum(int a, int b) {
        return a + b;
    }

    @Log
    @Override
    public int sub(int a, int b) {
        return a - b;
    }

    @Override
    public float sub(float a, float b) {
        return a - b;
    }

}
