package com.prs;

import java.sql.Date;
import java.time.LocalDate;
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
		
		int o = 0;
		while(o!=22) {
			displayMenu();
			o = Console.getInt("Enter Option: ", 1, 22);
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
			} else if(o==6) {
				String code = Console.getString("\nEnter vendor code: ");
				String name = Console.getString("\nEnter vendor name: ");
				String address = Console.getString("\nEnter vendor address: ");
				String city = Console.getString("\nEnter vendor city: ");
				String state = Console.getString("\nEnter vendor state: ");
				String zip = Console.getString("\nEnter vendor zip: ");
				String phoneNumber = Console.getString("\nEnter phone number: ");
				String email = Console.getString("\nEnter email: ");
				
				Vendor vendor = new Vendor(code, name, address, city, state,
						zip, phoneNumber,email);
				if(VendorDB.insert(vendor)) {
					System.out.println(name + " was added.");
				}
				else {
					System.out.println("Error! " + name + " wasn't added.");
				}
			
			} else if (o==7) {
				int vendorID = Console.getInt("\nEnter id of vendor you want to delete: ");
				Vendor v = VendorDB.getVendorById(vendorID);
				if(v == null) {
					System.out.println("No vendor found for id: " + vendorID);
				} else {
					
					if(VendorDB.delete(v)) {
						System.out.println("Vendor " + vendorID +" was deleted.");
					}
					else {
						System.out.println("Error! Vendor " + vendorID + " wasn't deleted.");
					}
					
				}
				
			} else if (o==8) {
				Console.println("\nVendor update not supported yet");
			
			} else if (o==9) {
				List<Product> products = ProductDB.getAll();
				for(Product p: products) {
					System.out.println(p);
				}

			} else if(o==10) {
				String partNum = Console.getString("\nEnter part number: ");
				String name = Console.getString("\nEnter product name: ");
				double price = Console.getDouble("\nEnter price: ", 0);
				String unit = Console.getString("\nEnter units: ");
				int vendorID = Console.getInt("\nEnter vendor id: ");
				Vendor v = VendorDB.getVendorById(vendorID);
				
				Product product = new Product(v, partNum, name, price, unit);
				if(ProductDB.insert(product)) {
					System.out.println(name + " was added.");
				}
				else {
					System.out.println("Error! " + name + " wasn't added.");
				}
			
			} else if (o==11) {
				int productID = Console.getInt("\nEnter id of product you want to delete: ");
				Product p = ProductDB.getProductById(productID);
				if(p == null) {
					System.out.println("No product found for id: " + productID);
				} else {
					
					if(ProductDB.delete(p)) {
						System.out.println("Product " + productID +" was deleted.");
					}
					else {
						System.out.println("Error! Product " + productID + " wasn't deleted.");
					}
					
				}
				
			} else if(o==12) {
				Console.println("\nProduct update not supported yet.");
				
			} else if(o==13) {
				List<PurchaseRequest> prs = PrDB.getAll();
				for(PurchaseRequest pr: prs) {
					System.out.println(pr);	
				}
			} else if(o==14) {
				int userID = Console.getInt("\nEnter user ID: ");
				String description = Console.getString("\nEnter description: ");
				String justification = Console.getString("\nEnter justification: ");
				String strDtNeeded = Console.getString("\nEnter date needed: ");
				LocalDate ld = LocalDate.parse(strDtNeeded);
				Date dtNeeded = new Date(ld.toEpochDay());
				String deliveryMode = Console.getString("\nEnter delivery mode: ");
				double total = Console.getInt("\nEnter total: ");
				User u = UserDB.getUserById(userID);
				
				PurchaseRequest pr = new PurchaseRequest(u, description, justification, 
						dtNeeded, deliveryMode, total);
				if(PrDB.insert(pr)) {
					System.out.println("Purchase request  was added.");
				}
				else {
					System.out.println("Error! " + " purchase request wasn't added.");
				}
			
			} else if (o==15) {
				int prID = Console.getInt("\nEnter id of purchase request you want to delete: ");
				PurchaseRequest pr = PrDB.getPrById(prID);
				if(pr == null) {
					System.out.println("No purchase request found for id: " + prID);
				} else {
					
					if(PrDB.delete(pr)) {
						System.out.println("Purchase Request " + prID +" was deleted.");
					}
					else {
						System.out.println("Error! Purchase Request " + prID + " wasn't deleted.");
					}
					
				}
				
			} else if (o==16) {
				Console.println("\nPurchase Request update not supported yet.");
				
			} else if(o==17) {
				List<PurchaseRequestLineItem> prli = PrliDB.getAll();
				for(PurchaseRequestLineItem li : prli) {
					System.out.println(li);
				}
				
			} else if(o==18) {
				int prID = Console.getInt("\nEnter Purchase Request ID: ");
				int productID = Console.getInt("\nEnter Product ID: ");
				int quantity = Console.getInt("\nEnter quantity: ");
				
				PurchaseRequest pr = PrDB.getPrById(prID);
				Product product = ProductDB.getProductById(productID);
				
				PurchaseRequestLineItem prli = new PurchaseRequestLineItem(pr, product, 
												   quantity);
				if(PrliDB.insert(prli)) {
					System.out.println("Purchase Request Line Item was added.");
				}
				else {
					System.out.println("Error! Purchase Request Line Item wasn't added.");
				}
				
			} else if (o==19) {
					int prliID = Console.getInt("\nEnter id of purchase request line item you want to delete: ");
					PurchaseRequestLineItem prli = PrliDB.getPrliById(prliID);
					if(prli == null) {
						System.out.println("No product found for id: " + prliID);
					} else {
						
						if(PrliDB.delete(prli)) {
							System.out.println("Purchase Request Line Item " + prliID +" was deleted.");
						}
						else {
							System.out.println("Error! Purchase Request Line Item " + prliID + " wasn't deleted.");
						}
						
					}
					
			} else if (o==20) {
				Console.println("\nPurchase Request Line Item update not supported yet.");
		
			} else if(o==21) {
				int vid = Console.getInt("\nEnter vendor id: ");
				List<Product> products = ProductDB.getAllProductsByVendorID(vid);
				for(Product p: products) {
					System.out.println(p);
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
		System.out.println("6 - Insert a Vendor");
		System.out.println("7 - Delete a Vendor");
		System.out.println("8 - Update a Vendor");
		System.out.println("9 - List Products");
		System.out.println("10 - Insert a Product");
		System.out.println("11 - Delete a Product");
		System.out.println("12 - Update a Product");
		System.out.println("13 - List Purchase Requests");
		System.out.println("14 - Insert a Purchase Request");
		System.out.println("15 - Delete a Purchase Request");
		System.out.println("16 - Update a Purchase Request");		
		System.out.println("17 - List Purchase Request Line Items");
		System.out.println("18 - Insert a Purchase Request Line Item"); //was option 10
		System.out.println("19 - Delete a Purchase Request Line Item");
		System.out.println("20 - Update a Purchase Request Line Item");
		System.out.println("21 - List Products by Vendor Id");
		System.out.println("22 - Exit");
	}
}

