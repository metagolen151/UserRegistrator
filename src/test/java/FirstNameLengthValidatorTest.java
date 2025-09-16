import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstNameLengthValidatorTest {
    FirstNameLengthValidator validator = new FirstNameLengthValidator();

    @Test
    void validate() {
        User user = new User(
                "Ka",
                "Bąk",
                "kamil.bak@gmail.com",
                "kamil1234"
        );

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> validator.validate(user));
        assertEquals("First name length must be between 3 and 15 characters.", exception.getMessage());
    }
}