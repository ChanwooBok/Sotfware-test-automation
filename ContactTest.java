
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    @Test
    public void testValidContactCreation() {
        Contact c = new Contact("123", "John", "Doe", "0123456789", "123 Elm St");
        assertEquals("John", c.getFirstName());
        assertEquals("Doe", c.getLastName());
    }

    @Test
    public void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "0123456789", "123 Elm St");
        });
    }
}
