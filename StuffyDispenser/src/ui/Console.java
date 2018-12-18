package ui;

import java.util.Scanner;

import business.Stuffy;

public class Console {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static int getInt(String prompt) {
		int i = 0;
		boolean isValid = false;
		while (!isValid) {
			System.out.print(prompt);
			if (sc.hasNextInt()) {
				i = sc.nextInt();
				isValid = true;
			} else {
				System.out.println("Error! Invalid integer. Try again.");
			}
			sc.nextLine();
		}
		return i;
	}

	public static int getInt(String prompt, int min, int max) {
		int i = 0;
		boolean isValid = false;
		while (!isValid) {
			i = getInt(prompt);
			if (i < min) {
				System.out.println(
						"Error! Number must be at least " + min + ".");
			} else if (i > max) {
				System.out.println(
						"Error! Number must be no more than " + max + ".");
			} else {
				isValid = true;
			}
			
		}
		return i;
	}
	
	public static String getString(String prompt) {
		String s  = null;
		boolean isValid = false;
		while (!isValid) {
			System.out.print(prompt);
			s = sc.nextLine();
			if (s.equals("")) {
				System.out.println("Error! This entry is required. Try again.");				
			} else {
				isValid = true;
			}
		}
		return s;
	}
	
	public static void displayStuffy(Stuffy s) {
		if (s == null) {
			System.out.println("Sorry, you didn't get a stuffy.");
		} else {
			System.out.println("Yay! You got a " + s.getSize() + " " +
					s.getColor() + " " + s.getType() + " stuffy!");
		}
	}
}
