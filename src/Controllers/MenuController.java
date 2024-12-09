package Controllers;

import Models.Contact;
import Views.ConsoleView;

public class MenuController {
    private ContactManager contactManager;
    private ConsoleView consoleView;

    public MenuController() {
        this.contactManager = new ContactManager();
        this.consoleView = new ConsoleView();
    }

    public void showMenu() {
        boolean exit = false;
        while (!exit) {
            consoleView.displayMenu();
            String option = consoleView.getInput("");
            switch (option) {
                case "1":
                    addContact();
                    break;
                case "2":
                    findContact();
                    break;
                case "3":
                    deleteContact();
                    break;
                case "4":
                    printList();
                    break;
                case "5":
                    exit = true;
                    consoleView.showMessage("Exiting program. Goodbye!");
                    break;
                default:
                    consoleView.showMessage("Invalid option. Try again.");
            }
        }
    }

    private void addContact() {
        String name = consoleView.getInput("Enter name: ");
        String phone = consoleView.getInput("Enter phone: ");
        Contact<String, String> contact = new Contact<>(name, phone);
        contactManager.addContact(contact);
        consoleView.showMessage("Contact added successfully!");
    }

    private void findContact() {
        String name = consoleView.getInput("Enter name to search: ");
        Contact<?, ?> contact = contactManager.findContactByName(name);
        if (contact != null) {
            consoleView.showMessage("Contact found: " + contact);
        } else {
            consoleView.showMessage("Contact not found.");
        }
    }

    private void deleteContact() {
        String name = consoleView.getInput("Enter name to delete: ");
        contactManager.deleteContactByName(name);
        consoleView.showMessage("Contact deleted if it existed.");
    }

    private void printList() {
        consoleView.showMessage("Lista:");

        contactManager.printList();
        consoleView.showMessage("========");
    }
}
