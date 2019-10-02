package by.intexsoft.demo.util;

public class Validator {
    public static boolean isValidName(String name) {
        String regular = "^[A-Z][a-z]{1,44}";
        if (name == null) {
            return false;
        }
        return name.matches(regular);
    }

    public static boolean isValidId(Long id) {
        return id != null && id >= 0;
    }

    public static boolean isValidBookName(String name) {
        return name != null && name.trim().length() != 0;
    }
}
