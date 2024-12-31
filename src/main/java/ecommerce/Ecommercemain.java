package ecommerce;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Ecommercemain {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner scan = new Scanner(System.in);

        System.out.println("########### Welcome to E-Commerce #######\n");
        Login.login();
        while (true) {
            System.out.println("What would you like to do today?");
            System.out.println("1. User Management");
            System.out.println("2. Product Management");
            System.out.println("3. Quit");

            int option = scan.nextInt();

            if (option == 1) {
                UserManagement.userManagement();
            } else if (option == 2) {
                ProductManagement.productManagement();
            } else if (option == 3) {
                System.out.println("\nExiting Program");
                scan.close();
                return;
            } else {
                System.out.println("Invalid choice. Please select a valid option.\n");
            }
        }
    }
}
