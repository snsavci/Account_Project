import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void testValidInput() {
        assertEquals("✅ Account created successfully!",
                Account.validateAccount("John", "Smith", "john@example.com", "123456", "123456", "01/01/2000"));
    }

    @Test
    public void testInvalidFirstNameSpecialCharacter() {
        assertEquals("❌ First name must be at least 2 letters and not contain special characters.",
                Account.validateAccount("John/*", "Smith", "john@example.com", "123456", "123456", "01/01/2000"));
    }

    @Test
    public void testInvalidLastNameSpecialCharacter() {
        assertEquals("❌ Last name must be at least 2 letters and not contain special characters.",
                Account.validateAccount("John", "Smith/*", "john@example.com", "123456", "123456", "01/01/2000"));
    }

    @Test
    public void testInvalidEmail() {
        assertEquals("❌ Email must contain '@' and a valid domain (e.g., user@site.com).",
                Account.validateAccount("John", "Smith", "johnexample.com", "123456", "123456", "01/01/2000"));
    }

    @Test
    public void testPasswordMismatch() {
        assertEquals("❌ Passwords do not match.",
                Account.validateAccount("John", "Smith", "john@example.com", "123456", "654321", "01/01/2000"));
    }

    @Test
    public void testShortPassword() {
        assertEquals("❌ Password must be at least 6 characters long.",
                Account.validateAccount("John", "Smith", "john@example.com", "123", "123", "01/01/2000"));
    }

    @Test
    public void testInvalidDOBFormat() {
        assertEquals("❌ Date of birth must be in the format dd/mm/yyyy.",
                Account.validateAccount("John", "Smith", "john@example.com", "123456", "123456", "2000-01-01"));
    }
}
