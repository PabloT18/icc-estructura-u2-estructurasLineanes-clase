package Controllers;

import Materia.Models.NodeGeneric;
import Models.Contact;
import Models.LinkedList;

public class ContactManager {
    private LinkedList<Contact<?, ?>> contacts;

    public ContactManager() {
        this.contacts = new LinkedList<>();
    }

    // Agregar un contacto a la lista
    public void addContact(Contact<?, ?> contact) {
        contacts.appendToTail(contact);
    }

    // Buscar un contacto por nombre
    public Contact<?, ?> findContactByName(String name) {
        NodeGeneric<Contact<?, ?>> current = contacts.getHead(); // Iteramos desde el head
        while (current != null) {
            if (((String) current.getValue().getName()).equalsIgnoreCase(name)) {
                return current.getValue();
            }
            current = current.getNext();
        }
        return null; // No se encontró el contacto
    }

    // Eliminar un contacto por nombre
    public void deleteContactByName(String name) {
        NodeGeneric<Contact<?, ?>> current = contacts.getHead();
        if (current == null)
            return;

        // Caso especial: si la cabeza es el contacto a eliminar
        if (((String) current.getValue().getName()).equalsIgnoreCase(name)) {
            contacts.setHead(contacts.getHead().getNext());
            contacts.setSize(contacts.getSize() - 1);
            return;
        }

        // Recorremos buscando el contacto
        while (current.getNext() != null) {
            if (((String) current.getNext().getValue().getName()).equalsIgnoreCase(name)) {
                current.setNext(current.getNext().getNext());
                contacts.setSize(contacts.getSize() - 1);
                return;
            }
            current = current.getNext();
        }
    }

    public void printList() {
        contacts.print();
    }
}
