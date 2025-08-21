import java.util.Scanner;

public class InventorySystem {
    static int[] productIds = new int[100];
    static String[] productNames = new String[100];
    static int[] productQuantities = new int[100];
    static int productCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Inventory Management System =====");
            System.out.println("1. Add Product");
            System.out.println("2. Update Quantity");
            System.out.println("3. Search Product");
            System.out.println("4. Display All Products");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addProduct(sc);
                    break;
                case 2:
                    updateQuantity(sc);
                    break;
                case 3:
                    searchProduct(sc);
                    break;
                case 4:
                    displayProducts();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }

    // Add product
    public static void addProduct(Scanner sc) {
        if (productCount >= productIds.length) {
            System.out.println("Inventory is full!");
            return;
        }
        System.out.print("Enter Product ID: ");
        productIds[productCount] = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Product Name: ");
        productNames[productCount] = sc.nextLine();

        System.out.print("Enter Quantity: ");
        productQuantities[productCount] = sc.nextInt();

        productCount++;
        System.out.println("Product added successfully!");
    }

    // Update quantity
    public static void updateQuantity(Scanner sc) {
        System.out.print("Enter Product ID to update: ");
        int id = sc.nextInt();
        for (int i = 0; i < productCount; i++) {
            if (productIds[i] == id) {
                System.out.print("Enter new quantity: ");
                productQuantities[i] = sc.nextInt();
                System.out.println("Quantity updated successfully!");
                return;
            }
        }
        System.out.println("Product not found!");
    }

    // Search product
    public static void searchProduct(Scanner sc) {
        System.out.print("Enter Product ID to search: ");
        int id = sc.nextInt();
        for (int i = 0; i < productCount; i++) {
            if (productIds[i] == id) {
                System.out.println("Product Found -> ID: " + productIds[i] + ", Name: " + productNames[i] + ", Quantity: " + productQuantities[i]);
                return;
            }
        }
        System.out.println("Product not found!");
    }

    // Display all products
    public static void displayProducts() {
        if (productCount == 0) {
            System.out.println("No products in inventory.");
            return;
        }
        System.out.println("\n----- Inventory List -----");
        for (int i = 0; i < productCount; i++) {
            System.out.println("ID: " + productIds[i] + ", Name: " + productNames[i] + ", Quantity: " + productQuantities[i]);
        }
    }
}
