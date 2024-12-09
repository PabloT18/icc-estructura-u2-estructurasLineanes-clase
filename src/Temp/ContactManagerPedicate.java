package Controllers;

import Models.Contact;
import Models.LinkedListPredicate;

public class ContactManagerPedicate {
    private LinkedListPredicate<Contact<?, ?>> contacts;

    public ContactManagerPedicate() {
        this.contacts = new LinkedListPredicate<>();
    }

    public void addContact(Contact<?, ?> contact) {
        contacts.add(contact);
    }

    public Contact<?, ?> findContactByName(String name) {
        return contacts.find(contact -> ((String) contact.getName()).equalsIgnoreCase(name));
    }

    public void deleteContactByName(String name) {
        contacts.remove(contact -> ((String) contact.getName()).equalsIgnoreCase(name));
    }
}
