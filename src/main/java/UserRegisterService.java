import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class UserRegisterService {

    private Map<UUID, User> db = new HashMap<>();

    private List<Validator> validators = List.of(
        new FirstNameLengthValidator(),
        new LastNameLengthValidator(),
        new EmailFormatValidator(),
        new PasswordStrengthValidator()
    );

    public UUID save(User user) {
        for (Validator validator : validators) {
            validator.validate(user);
        }
        UUID id = user.getId();
        db.put(id, user);
        return id;
    }
}
