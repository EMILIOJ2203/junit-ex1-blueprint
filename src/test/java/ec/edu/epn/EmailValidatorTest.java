package ec.edu.epn;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


public class EmailValidatorTest {

    private EmailValidator emailValidator;

    static Stream<Arguments> emailValidatorData() {
        return Stream.of(
            Arguments.of("emilio.quinga@gmail.com", true),
            Arguments.of("emilio.quinga22@gmail.com", true),
            Arguments.of("correo.invalido", false),
            Arguments.of(null, false)
        );
    }

    @BeforeEach
    public void setUp() {
        emailValidator = new EmailValidator();
    }

    @ParameterizedTest
    @MethodSource("emailValidatorData")
    void isValid_MultipleEmails_ShouldReturnExpected(String email, boolean expected) {
        boolean result = emailValidator.isValid(email);
        assertEquals(expected, result, "Email: " + email + " should be " + expected);
    }
}

