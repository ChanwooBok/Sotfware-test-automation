
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    @Test
    public void testAddAndDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Street");
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact));
        service.deleteContact("1");
    }

    @Test
    public void testUpdateFields() {
        ContactService service = new ContactService();
        Contact contact = new Contact("2", "Jane", "Doe", "0987654321", "456 Avenue");
        service.addContact(contact);
        service.updateFirstName("2", "Janet");
        service.updateLastName("2", "Smith");
        service.updatePhone("2", "1122334455");
        service.updateAddress("2", "789 Road");
        assertEquals("Janet", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("1122334455", contact.getPhone());
        assertEquals("789 Road", contact.getAddress());
    }
}
