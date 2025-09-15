public class FirstNameLengthValidator implements Validator {

    private static final int MIN_LENGTH = 3;

    private static final int MAX_LENGTH = 15;

    @Override
    public void validate(User user) {
        String firstName = user.getFirstName();
        if (firstName.length() < MIN_LENGTH || firstName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(
                    "First name length must be between " + MIN_LENGTH + " and " + MAX_LENGTH + " characters."
            );
        }
    }
}
