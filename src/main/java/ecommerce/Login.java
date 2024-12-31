package ecommerce;


import java.util.Scanner;

public class Login {
public static void login() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("########### Welcome to E-Commerce #######\n\n");
		
		System.out.println("****** Login :\n");
		
		System.out.println("\tEnter User Name :");
		String userName =scan.next();
		
		System.out.println("\tEnter Password :");
		String password =scan.next();
		
		if (userName.equals("vzodge")) {
			if (password.equals("Test@123")) {
				System.out.println("Login Successful");
				return;
			}
		}
		System.out.println("!!! Login fail");
		System.exit(0);
	}
}	
		
		
		
		
		
		
		
		
		




