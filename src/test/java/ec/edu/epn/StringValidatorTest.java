package ec.edu.epn;

import java.util.List;
import java.util.Collection;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.DynamicTest;

import static org.junit.jupiter.api.Assertions.*;

public class StringValidatorTest {

    private final StringValidator stringValidator = new StringValidator();

    @Test
    void validateNotEmpty_NullInput_ThrowsException() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
            () -> stringValidator.validateNotEmpty(null));
        assertEquals("Input cannot be null.", ex.getMessage());
    }

    @Test
    void validateNotEmpty_EmptyInput_ThrowsException() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
            () -> stringValidator.validateNotEmpty("   "));
        assertEquals("Input cannot be empty.", ex.getMessage());
    }

    private static class TestData {
        final String text;
        final boolean expectedResult;

        TestData(String text, boolean expectedResult) {
            this.text = text;
            this.expectedResult = expectedResult;
        }
    }

    @TestFactory
    Collection<DynamicTest> dynamicPalindromeTests() {
        List<TestData> testDataList = List.of(
            new TestData("reconocer", true),
            new TestData("oso", true),
            new TestData("hola", false),
            new TestData("", true),
            new TestData(null, false)
        );

        return testDataList.stream()
            .map(data -> DynamicTest.dynamicTest("Testing palindrome for: " + data.text,
                () -> {
                    boolean methodResult = stringValidator.isPalindrome(data.text);
                    if (data.expectedResult) {
                        assertTrue(methodResult, "Expected palindrome for: " + data.text);
                    } else {
                        assertFalse(methodResult, "Expected non-palindrome for: " + data.text);
                    }
                }))
            .collect(Collectors.toList());
    }
}