import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailFormatValidatorTest {
    EmailFormatValidator validator = new EmailFormatValidator();

    @Test
    void validate() {
        User user = new User(
                "Ka",
                "Bąk",
                "kamil.bakgmail.com",
                "kamil1234"
        );

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> validator.validate(user));
        assertEquals("Invalid email format.", exception.getMessage());
    }
}