import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Expense {
    private String category;
    private double amount;

    public Expense(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }
}

public class ExpenseTracker {
    private static ArrayList<Expense> expenses = new ArrayList<>();
    private static Map<String, Double> categoryTotals = new HashMap<>();
    private static double totalExpense = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Expense Tracker");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Statistics");
            System.out.println("4. Set Budget");
            System.out.println("5. Generate Report");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter expense category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter expense amount: ");
                    double amount = scanner.nextDouble();
                    expenses.add(new Expense(category, amount));
                    updateTotals(category, amount);
                    totalExpense += amount;
                    System.out.println("Expense added successfully!");
                    break;
                case 2:
                    System.out.println("Expenses:");
                    for (Expense expense : expenses) {
                        System.out.println("Category: " + expense.getCategory() + ", Amount: $" + expense.getAmount());
                    }
                    break;
                case 3:
                    System.out.println("Statistics:");
                    System.out.println("Total Expense: $" + totalExpense);
                    System.out.println("Category-wise Expense:");
                    for (Map.Entry<String, Double> entry : categoryTotals.entrySet()) {
                        System.out.println(entry.getKey() + ": $" + entry.getValue());
                    }
                    break;
                case 4:
                    System.out.print("Enter budget amount: ");
                    double budget = scanner.nextDouble();
                    // You can implement budget setting functionality here
                    System.out.println("Budget set successfully!");
                    break;
                case 5:
                    // You can implement report generation functionality here
                    System.out.println("Report generation feature coming soon!");
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 6.");
            }
            System.out.println();
        }
    }

    private static void updateTotals(String category, double amount) {
        categoryTotals.put(category, categoryTotals.getOrDefault(category, 0.0) + amount);
    }
}
