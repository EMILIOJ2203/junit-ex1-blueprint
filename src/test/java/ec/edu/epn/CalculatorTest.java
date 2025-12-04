package ec.edu.epn;

import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        calculator = null;
    }

    // Metodo_parametros_resultadoEsperado
    @Test
    void add_TwoPositiveNumbers_ReturnsCorrectSum() {
        // Arange
        int a = 3;
        int b = 4;
        // Act
        int result = calculator.add(a, b);
        // Assert
        assertEquals(7, result);
    }

    @Test
    void subtract_TwoPositiveNumbers_ReturnsCorrectDifference() {
        // Arange
        int a = 10;
        int b = 4;
        // Act
        int result = calculator.subtract(a, b);
        // Assert
        assertEquals(6, result);
    }

    @Test
    void multiply_TwoPositiveNumbers_ReturnsCorrectProduct() {
        // Arange
        int a = 5;
        int b = 6;
        // Act
        int result = calculator.multiply(a, b);
        // Assert
        assertEquals(30, result);
    }

    @Test
    void divide_TwoPositiveNumbers_ReturnsCorrectQuotient() {
        // Arange
        int a = 20;
        int b = 4;
        // Act
        double result = calculator.divide(a, b);
        // Assert
        assertEquals(5.0, result);
    }

    @Test
    void isEven_EvenNumber_ReturnsTrue() {
        // Arange
        int number = 8;
        // Act
        boolean result = calculator.isEven(number);
        // Assert
        assertEquals(true, result);
    }

    //LABORATORIO 21/11/2025
    @ParameterizedTest
    @ValueSource(ints = { 2, 30, -6, 0 })
    void isEven_EvenNumbers_ShouldReturnTrue(int number) {
        assertTrue(calculator.isEven(number));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "5, 7, 12",
            "1, -2, -1"
    })
    void addMultipleValues_ReturnCorrectSum(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "11, 4, 7",
            "5, 3, 2",
            "1, -2, 3"
    })
    void subtractMultipleValues_ReturnCorrectDifference(int a, int b, int expected) {
        assertEquals(expected, calculator.subtract(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "2, 3, 6",
            "5, 0, 0",
            "-1, -4, 4"
    })
    void multiplyMultipleValues_ReturnCorrectProduct(int a, int b, int expected) {
        assertEquals(expected, calculator.multiply(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "20, 4, 5.0",
            "9, 2, 4.5",
            "-8, -2, 4.0"
    })
    void divideMultipleValues_ReturnCorrectQuotient(int a, int b, double expected) {
        assertEquals(expected, calculator.divide(a, b), 0.0001);
    }

    @Test
    void divide_PositiveNumbers_ReturnCorrectQuotient() {
        double result = calculator.divide(10, 4);
        assertAll(
            () -> assertTrue(result>0),
            () -> assertEquals(2.5, result, 0.0001, "10 dividido por 4 debe ser 2.5")
        );
    }

    @Test
    void divide_TwoPositiveNumbers_ReturnsCorrectQuotient2() {
        // Arange
        int a = 10;
        int b = 2;
        // Act
        double result = calculator.divide(a, b);
        // Assert
        assertAll(
            () -> assertTrue(result>0),
            () -> assertEquals(5.0, result, 0.0001, "10 dividido por 2 debe ser 5.0")
        );
    }

    @Test
    void divide_ByZero_ThrowsIllegalArgumentException() {
        int a = 3;
        int b = 0;
        assertThrows(IllegalArgumentException.class,
                () -> calculator.divide(a, b),
                "Dividir por cero debe lanzar una IllegalArgumentException");
    }

    @Test
    void divide_ByZero_AssertExceptionMessage() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> calculator.divide(3, 0));

        assertTrue(illegalArgumentException.getMessage().contains("The divisor cannot be zero"));
    }
    

}
