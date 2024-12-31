package ecommerce;


public class Product {
	 public String productName;
	    public int price;
	    public int productQuantity;

	    public void printProductDetails() {
	        System.out.println("Product Name: " + productName);
	        System.out.println("Price: " + price);
	        System.out.println("Quantity: " + productQuantity);
	    }

}
