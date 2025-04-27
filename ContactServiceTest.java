package com.contactservice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class ContactServiceTest {
    @Test
    void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertTrue(service.addContact(contact));
        assertFalse(service.addContact(contact)); // Duplicate ID should fail
    }
    
    @Test
    void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        assertTrue(service.deleteContact("12345"));
        assertFalse(service.deleteContact("67890")); // Nonexistent ID should fail
    }
    
    @Test
    void testUpdateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        assertTrue(service.updateContact("12345", "Jane", "Smith", "0987654321", "456 Elm St"));
        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Elm St", contact.getAddress());
    }
}

