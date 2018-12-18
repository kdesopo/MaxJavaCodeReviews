package ui;

import db.StuffyDB;
import business.Stuffy;
public class StuffyDispenserApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Stuffy Dispenser App!!");
		
		int choice = 0;
		StuffyDB machine = new StuffyDB();
		int x = 0;
		int newid = 0;
		String newtype = "";
		String newsize = "";
		String newcolor = "";
		
		while (choice != 3) {
			choice = Console.getInt("\nMenu\n"
					+ "1 - Try to grab stuffy\n"
					+ "2 - Add stuffy\n"
					+ "3 - Exit\n\n"
					+ "Enter Option: ", 1, 3);
			
			if (choice == 1) {
				x = (int)(Math.random() * machine.getIdCt());
				Stuffy prize = machine.grabStuffy(x);
				Console.displayStuffy(prize);
			} else if (choice == 2) {
				newid = machine.getIdCt() + 1;
				newtype = Console.getString("Enter the new plush type: ");
				newsize = Console.getString("Enter the new plush size: ");
				newcolor = Console.getString("Enter the new plush color: ");
				machine.addStuffy(new Stuffy(newid, newtype, newsize, newcolor));
				System.out.println("You added a " + newsize + " " + newcolor + " " 
				+ newtype + " stuffy into the machine.");
			}
			
		}
	}

}
