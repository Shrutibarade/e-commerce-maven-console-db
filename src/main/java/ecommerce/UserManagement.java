package ecommerce;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserManagement {
    public static void userManagement() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/user_management";
        String userName = "root";
        String password = "shruti9160";

        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement statement = connection.createStatement();
        Scanner scan = new Scanner(System.in);

        System.out.println("########### Welcome to User Management #######\n\n");

        while (true) {
            System.out.println("What would you like to do today?");
            System.out.println("1. Add User");
            System.out.println("2. Search User");
            System.out.println("3. Remove User");
            System.out.println("4. Display Users");
            System.out.println("5. Quit");

            int option = scan.nextInt();
            scan.nextLine();

            if (option == 1) {
                System.out.println("\tAdding User:");
                System.out.print("Enter User ID: ");
                int userId = scan.nextInt();
                scan.nextLine();
                System.out.print("Enter Username: ");
                String name = scan.nextLine();
                System.out.print("Enter Email: ");
                String email = scan.nextLine();
                System.out.print("Enter Mobile Number: ");
                String mobile = scan.nextLine();

                String insertQuery = "INSERT INTO user (id, user_name, email, mobile) VALUES (" +
                        userId + ", '" + name + "', '" + email + "', '" + mobile + "')";
                statement.executeUpdate(insertQuery);
                System.out.println("\tNew User Added\n");

            } else if (option == 2) {
                System.out.println("\tSearching User:");
                System.out.print("Enter Username: ");
                String search = scan.nextLine();

                String searchQuery = "SELECT * FROM user WHERE user_name = '" + search + "'";
                ResultSet searchResult = statement.executeQuery(searchQuery);

                if (searchResult.next()) {
                    System.out.println("User ID: " + searchResult.getInt("id"));
                    System.out.println("Username: " + searchResult.getString("user_name"));
                    System.out.println("Email: " + searchResult.getString("email"));
                    System.out.println("Mobile: " + searchResult.getString("mobile"));
                } else {
                    System.out.println("\tUser Not Found\n");
                }
                searchResult.close();

            } else if (option == 3) {
                System.out.println("\tRemoving User:");
                System.out.print("Enter Username: ");
                String removeName = scan.nextLine();

                String deleteQuery = "DELETE FROM user WHERE user_name = '" + removeName + "'";
                int rowsAffected = statement.executeUpdate(deleteQuery);

                if (rowsAffected > 0) {
                    System.out.println("\tUser Removed Successfully\n");
                } else {
                    System.out.println("\tUser Not Found\n");
                }

            } else if (option == 4) {
                System.out.println("\tDisplaying Users:");
                String displayQuery = "SELECT * FROM user";
                ResultSet displayResult = statement.executeQuery(displayQuery);

                while (displayResult.next()) {
                    System.out.println("User ID: " + displayResult.getInt("id"));
                    System.out.println("Username: " + displayResult.getString("user_name"));
                    System.out.println("Email: " + displayResult.getString("email"));
                    System.out.println("Mobile: " + displayResult.getString("mobile"));
                    System.out.println("............");
                }
                displayResult.close();

            } else if (option == 5) {
                System.out.println("**** Exiting User Management ****");
                statement.close();
                connection.close();
                
                return;

            } else {
                System.out.println("!!!!!! Invalid option selected");
            }
        }
    }
}
