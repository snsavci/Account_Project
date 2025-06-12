public class Account {
    public static String validateAccount(String firstName, String lastName, String email, String password, String confirmPassword, String dob) {
        if (firstName == null || !firstName.matches("^[a-zA-ZçÇğĞıİöÖşŞüÜ\\s]{2,}$")) {
            return "❌ First name must be at least 2 letters and not contain special characters.";
        }
        if (lastName == null || !lastName.matches("^[a-zA-ZçÇğĞıİöÖşŞüÜ\\s]{2,}$")) {
            return "❌ Last name must be at least 2 letters and not contain special characters.";
        }
        if (email == null || !email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
            return "❌ Email must contain '@' and a valid domain (e.g., user@site.com).";
        }
        if (password == null || password.length() < 6) {
            return "❌ Password must be at least 6 characters long.";
        }
        if (!password.equals(confirmPassword)) {
            return "❌ Passwords do not match.";
        }
        if (dob == null || !dob.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
            return "❌ Date of birth must be in the format dd/mm/yyyy.";
        }
        return "✅ Account created successfully!";
    }
}
