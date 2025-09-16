import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LastNameLengthValidatorTest {

    LastNameLengthValidator validator = new LastNameLengthValidator();

    @Test
    void validate() {
        User user = new User(
                "Kamil",
                "Bą",
                "kamil.bak@gmail.com",
                "kamil1234"
        );

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> validator.validate(user));
        assertEquals("Last name length must be between 3 and 15 characters.", exception.getMessage());
    }
}