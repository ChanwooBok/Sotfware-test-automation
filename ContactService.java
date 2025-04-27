package com.contactservice;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();
    
    public boolean addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactID())) {
            return false;
        }
        contacts.put(contact.getContactID(), contact);
        return true;
    }
    
    public boolean deleteContact(String contactID) {
        return contacts.remove(contactID) != null;
    }
    
    public boolean updateContact(String contactID, String firstName, String lastName, String phone, String address) {
        Contact contact = contacts.get(contactID);
        if (contact == null) return false;
        
        if (firstName != null) contact.setFirstName(firstName);
        if (lastName != null) contact.setLastName(lastName);
        if (phone != null) contact.setPhone(phone);
        if (address != null) contact.setAddress(address);
        
        return true;
    }
}

