package Views;

import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("=== Contact Manager Menu ===");
        System.out.println("1. Add Contact");
        System.out.println("2. Find Contact");
        System.out.println("3. Delete Contact");
        System.out.println("4. Print");

        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    public String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
