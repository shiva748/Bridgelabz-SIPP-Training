// Password Strength Validator with static interface methods
interface SecurityUtils {
    static boolean isStrongPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c))
                hasUpperCase = true;
            if (Character.isLowerCase(c))
                hasLowerCase = true;
            if (Character.isDigit(c))
                hasDigit = true;
            if (!Character.isLetterOrDigit(c))
                hasSpecialChar = true;
        }

        return hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar;
    }

    static String getPasswordStrength(String password) {
        if (isStrongPassword(password)) {
            return "STRONG";
        } else if (password != null && password.length() >= 6) {
            return "MEDIUM";
        } else {
            return "WEAK";
        }
    }
}

public class PasswordStrengthValidator {
    public static void main(String[] args) {
        String[] passwords = {
                "weak",
                "Medium123",
                "Strong@123",
                "noSpecialChar123",
                "OnlyUpperCaseANDLOWERCASE"
        };

        System.out.println("Password Strength Validation:");
        for (String password : passwords) {
            String strength = SecurityUtils.getPasswordStrength(password);
            System.out.println("Password: '" + password + "' -> Strength: " + strength);
        }
    }
}
