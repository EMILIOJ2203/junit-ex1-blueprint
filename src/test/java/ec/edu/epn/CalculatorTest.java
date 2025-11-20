package ec.edu.epn;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private Calculator calculator = new Calculator();

    //Metodo_parametros_resultadoEsperado
    @Test
    void add_TwoPositiveNumbers_ReturnsCorrectSum() {
        //Arange
        int a = 3;
        int b = 4;
        //Act
        int result = calculator.add(a, b);
        //Assert
        assertEquals(7, result);

        //is even
        assertTrue(calculator.isEven(result));
    }

    @Test
    void subtract_TwoPositiveNumbers_ReturnsCorrectDifference() {
        //Arange
        int a = 10;
        int b = 4;
        //Act
        int result = calculator.subtract(a, b);
        //Assert
        assertEquals(6, result);
    }

    @Test
    void multiply_TwoPositiveNumbers_ReturnsCorrectProduct() {
        //Arange
        int a = 5;
        int b = 6;
        //Act
        int result = calculator.multiply(a, b);
        //Assert
        assertEquals(30, result);
    }

    @Test
    void divide_TwoPositiveNumbers_ReturnsCorrectQuotient() {
        //Arange
        int a = 20;
        int b = 4;
        //Act
        double result = calculator.divide(a, b);
        //Assert
        assertEquals(5.0, result);
    }

    @Test
    void isEven_EvenNumber_ReturnsTrue() {  
        //Arange
        int number = 8;
        //Act
        boolean result = calculator.isEven(number);
        //Assert
        assertEquals(true, result);
    }

}
