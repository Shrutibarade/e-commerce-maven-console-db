package ecommerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ProductManagement {
    public static void productManagement() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/product_management";
        String username = "root";
        String password = "shruti9160";

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        Scanner scan = new Scanner(System.in);

        System.out.println("########### Welcome to Product Management #######");

        while (true) {
            System.out.println("\nWhat would you like to do today?");
            System.out.println("1. Add Product");
            System.out.println("2. Search Product");
            System.out.println("3. Remove Product");
            System.out.println("4. Display Products");
            System.out.println("5. Quit");

            int option = scan.nextInt();
            scan.nextLine(); // Consume newline character
            if (option == 1) {
                System.out.println("\tAdding Product");
                System.out.print("Enter Product ID: ");
                int id = scan.nextInt();
                System.out.print("Enter Product Name: ");
                String name = scan.next();
                System.out.print("Enter Product Price: ");
                int price = scan.nextInt();
                System.out.print("Enter Product Quantity: ");
                int quantity = scan.nextInt();

                String insertQuery = "INSERT INTO product (productid, name, price, quantity) " +
                        "VALUES (" + id + ", '" + name + "', " + price + ", " + quantity + ")";
                statement.executeUpdate(insertQuery);
                System.out.println("New Product Added\n");

            } else if (option == 2) {
                System.out.println("\tSearching Product");
                System.out.print("Enter Product Name: ");
                String searchName = scan.nextLine();

                String searchQuery = "SELECT * FROM product WHERE name = '" + searchName + "'";
                ResultSet searchResult = statement.executeQuery(searchQuery);

                if (searchResult.next()) {
                    System.out.println("Product ID: " + searchResult.getInt("productid"));
                    System.out.println("Name: " + searchResult.getString("name"));
                    System.out.println("Price: " + searchResult.getInt("price"));
                    System.out.println("Quantity: " + searchResult.getInt("quantity"));
                } else {
                    System.out.println("Product not found.");
                }
                searchResult.close();

            } else if (option == 3) {
                System.out.println("\tRemoving Product");
                System.out.print("Enter Product Name: ");
                String removeName = scan.nextLine();

                String deleteQuery = "DELETE FROM product WHERE name = '" + removeName + "'";
                int rowsAffected = statement.executeUpdate(deleteQuery);

                if (rowsAffected > 0) {
                    System.out.println("Product Removed Successfully\n");
                } else {
                    System.out.println("Product not found.");
                }

            } else if (option == 4) {
                System.out.println("\tDisplaying Products");
                String displayQuery = "SELECT * FROM product";
                ResultSet displayResult = statement.executeQuery(displayQuery);

                while (displayResult.next()) {
                    System.out.println("Product ID: " + displayResult.getInt("productid"));
                    System.out.println("Name: " + displayResult.getString("name"));
                    System.out.println("Price: " + displayResult.getInt("price"));
                    System.out.println("Quantity: " + displayResult.getInt("quantity"));
                    System.out.println("------------");
                }
                displayResult.close();

            } else if (option == 5) {
                System.out.println("Exiting Product Management.");
                statement.close();
                connection.close();
                
                return;

            } else {
                System.out.println("Invalid choice. Please select a valid option.\n");
            }
        }
    }
}