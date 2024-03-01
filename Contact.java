import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNumber;
    }
}

public class ContactManagementSystem {
    private static ArrayList<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Contact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Search Contacts");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    contacts.add(new Contact(name, phoneNumber));
                    System.out.println("Contact added successfully!");
                    break;
                case 2:
                    System.out.println("Contacts:");
                    for (Contact contact : contacts) {
                        System.out.println(contact);
                    }
                    break;
                case 3:
                    System.out.print("Enter name or phone number to search: ");
                    String query = scanner.nextLine();
                    boolean found = false;
                    for (Contact contact : contacts) {
                        if (contact.getName().equalsIgnoreCase(query) || contact.getPhoneNumber().equals(query)) {
                            System.out.println("Contact found: " + contact);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("No contact found with the given name or phone number.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 4.");
            }
            System.out.println();
        }
    }
}
