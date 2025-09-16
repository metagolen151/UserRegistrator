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
                "Kamil1@"
        );

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> validator.validate(user));
        assertEquals("Password must be at least 8 characters.", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenNoUppercase() {
        User user = new User(
                "Kamil",
                "Bąk",
                "kamil.bak@gmail.com",
                "kamil12@"
        );

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> validator.validate(user));
        assertEquals("Password must contain at least one uppercase letter.", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenNoNumber() {
        User user = new User(
                "Kamil",
                "Bąk",
                "kamil.bak@gmail.com",
                "Kamilzz@"
        );

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> validator.validate(user));
        assertEquals("Password must contain at least one number.", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenNoSpecialCharacter() {
        User user = new User(
                "Kamil",
                "Bąk",
                "kamil.bak@gmail.com",
                "Kamilzz1"
        );

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> validator.validate(user));
        assertEquals("Password must contain at least one special character.", exception.getMessage());
    }
}