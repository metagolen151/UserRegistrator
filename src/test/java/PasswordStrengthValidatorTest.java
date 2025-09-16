import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordStrengthValidatorTest {
    PasswordStrengthValidator validator = new PasswordStrengthValidator();

    @Test
    void shouldThrowExceptionWhenPasswordTooShort() {
        User user = new User(
                "Kamil",
                "Bąk",
                "kamil.bak@gmail.com",
                "kamil123"
        );

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> validator.validate(user));
        assertEquals("Password must be at least 8 characters.", exception.getMessage());
    }
}