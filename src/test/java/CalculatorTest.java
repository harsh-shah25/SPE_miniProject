import org.example.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {


    @Test
    public void squareRootNegativeNumberTest() {
        double result = Calculator.squareRoot(-5);

        Assertions.assertEquals(-1, result);

    }

    @Test
    public void squareRootPositiveNumberTest() {
        double result = Calculator.squareRoot(25);

        Assertions.assertEquals(5.0, result);

    }

    @Test
    public void squareRootZeroTest() {
        double result = Calculator.squareRoot(0);

        Assertions.assertEquals(0, result);

    }

    @Test
    public void factorialOfNegativeNumberTest() {
        double result = Calculator.factorialOf(-3);
        Assertions.assertEquals(-1, result);
    }

    @Test
    public void factorialOfNonIntegerNumberTest() {
        double result = Calculator.factorialOf(3.4);
        Assertions.assertEquals(-1, result);
    }

    @Test
    public void factorialOfPositiveNumberTest() {
        double result = Calculator.factorialOf(3);
        Assertions.assertEquals(6, result);
    }

    @Test
    public void naturalLogNegativeNumberTest() {
        double result = Calculator.naturalLog(-3);
        Assertions.assertEquals(-1, result);
    }

    @Test
    public void naturalLogZeroTest() {
        double result = Calculator.naturalLog(0);
        Assertions.assertEquals(-1, result);
    }

    @Test
    public void naturalLogPositiveNumberTest() {
        double result = Calculator.naturalLog(10);
        Assertions.assertEquals(Math.log(10), result);
    }

    @Test
    public void powerOfTest() {
        double result = Calculator.powerOf(10,3);
        Assertions.assertEquals(1000, result);
    }
}