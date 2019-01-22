package com.prs;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prs.business.PrDB;
import com.prs.business.PrliDB;
import com.prs.business.Product;
import com.prs.business.ProductDB;
import com.prs.business.PurchaseRequest;
import com.prs.business.PurchaseRequestLineItem;
import com.prs.business.User;
import com.prs.business.UserDB;
import com.prs.business.Vendor;
import com.prs.business.VendorDB;
import com.prs.util.Console;

@SpringBootApplication
public class PrsJpaDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(PrsJpaDemo1Application.class, args);
		System.out.println("Hello Springboot World!"); 
		
		displayMenu();
		int o = 0;
		while(o!=11) {
			o = Console.getInt("Enter Option: ", 1, 11);
			if(o==1) {
				List<User> users = UserDB.getAll();
				for(User u: users) {
					System.out.println(u);
				}
			} else if(o==2) {
				String username = Console.getString("\nEnter username: ");
				String password = Console.getString("\nEnter password: ");
				String firstName = Console.getString("\nEnter first name: ");
				String lastName = Console.getString("\nEnter last name: ");
				String phoneNumber = Console.getString("\nEnter phone number: ");
				String email = Console.getString("\nEnter email: ");
				
				User user = new User(username, password, firstName, lastName, phoneNumber,
									 email);
				if(UserDB.insert(user)) {
					System.out.println(firstName + " " + lastName + " was added.");
				}
				else {
					System.out.println("Error! " + firstName + " " + lastName + " wasn't added.");
				}
			} else if (o==3) {
				int userID = Console.getInt("\nEnter userID of user you want to delete: ");
				User u = UserDB.getUserById(userID);
				if(u == null) {
					System.out.println("No user found for id: " + userID);
				} else {
					
					if(UserDB.delete(u)) {
						System.out.println("User " + userID +" was deleted.");
					}
					else {
						System.out.println("Error! User " + userID + " wasn't deleted.");
					}
					
				}
				
			} else if (o==4) {
				int userID = Console.getInt("\nEnter userID of user you want to update: ");
				User u = UserDB.getUserById(userID);
				if(u == null) {
					System.out.println("\nNo user found for id: " + userID);
				} else {
					String newPswd = Console.getString("\nEnter new password: ");
					u.setPassword(newPswd);
					
					if(UserDB.update(u)) {
						System.out.println("User " + userID +" was updated.");
					}
					else {
						System.out.println("Error! User " + userID + " wasn't updated.");
					}
				}
				
			} else if (o==5) {
				List<Vendor> vendors = VendorDB.getAll();
				for(Vendor v: vendors) {
					System.out.println(v);	
				}
			} else if (o==6) {
				List<Product> products = ProductDB.getAll();
				for(Product p: products) {
					System.out.println(p);
				}

			} else if(o==7) {
				List<PurchaseRequest> prs = PrDB.getAll();
				for(PurchaseRequest pr: prs) {
					System.out.println(pr);	
				}
			} else if(o==8) {
			List<PurchaseRequestLineItem> prli = PrliDB.getAll();
			for(PurchaseRequestLineItem li : prli) {
				System.out.println(li);
			}
		} else if(o==9) {
			int vid = Console.getInt("\nEnter vendor id: ");
			List<Product> products = ProductDB.getAllProductsByVendorID(vid);
			for(Product p: products) {
				System.out.println(p);
			}
		} else if(o==10) {
			int requestID = Console.getInt("\nEnter purchase request id: ");
			PurchaseRequest request = PrDB.getPrById(requestID);
			int productID = Console.getInt("\nEnter product id: ");
			Product p = ProductDB.getProductById(productID);
			int quantity = Console.getInt("\nEnter quantity: ");
			
			PurchaseRequestLineItem prli = 
					new PurchaseRequestLineItem(request, p, quantity);
			
			if(PrliDB.insert(prli)) {
				System.out.println("New purchase request line items added successfully.");
			}
			else {
				System.out.println("Error! New purchase request line items weren't added.");
			}
			
		}
	}
}
	private static void displayMenu() {
		System.out.println("Table Options:");
		System.out.println("1 - List Users");
		System.out.println("2 - Insert a User");
		System.out.println("3 - Delete a User");
		System.out.println("4 - Update a User");
		System.out.println("5 - List Vendors");
		System.out.println("6 - List Products");
		System.out.println("7 - List Purchase Requests");
		System.out.println("8 - List Purchase Request Line Items");
		System.out.println("9 - List Products by Vendor Id");
		System.out.println("10 - Insert new Purchase Request Line Item");
		System.out.println("11 - Exit");
	}
}

