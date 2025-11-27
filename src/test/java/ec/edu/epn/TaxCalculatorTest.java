package ec.edu.epn;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TaxCalculatorTest {

    private final TaxCalculator calculator = new TaxCalculator();
    private static final double TAX_PERCENT = 10.0; // ejemplo: 10 significa 10%
    private static final double DELTA = 1e-9;

    @ParameterizedTest
    @ValueSource(doubles = {100.00, 0.00, 50.5, -20.0})
    void calculateTax_WithVariousValues_ReturnsExpectedTotal(double valor) {
        double expected = valor + (valor * TAX_PERCENT / 100.0);
        double actual = calculator.calculateTax(valor, TAX_PERCENT);
        assertEquals(expected, actual, DELTA, "Valor: " + valor + " Impuesto%: " + TAX_PERCENT);
    }
}