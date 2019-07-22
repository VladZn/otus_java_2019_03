
public class Demo {
    public static void main(String[] args) {
        Calculator calculator = (Calculator) ProxyFactory.createClass(new CalculatorImpl());
        calculator.sum(2, 3);
        calculator.sub(5, 4);
        calculator.sub(3f, 1f);
    }
}
