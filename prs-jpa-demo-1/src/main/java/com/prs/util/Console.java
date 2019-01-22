package com.prs.util;

import java.util.Scanner;

public class Console {

	private static Scanner sc = new Scanner(System.in);
	
    public static int getInt(String prompt) {
        boolean isValid = false;
        int i = 0;
        while (!isValid) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                isValid = true;
            } else {
                sc.next();  // discard invalid data
                System.out.println("Error! Invalid integer value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return i;
    }

    public static int getInt(String prompt, int min, int max) {
        int i = 0;
        boolean isValid = false;
        while (!isValid) {
            i = Console.getInt(prompt);
            if (i < min) {
                System.out.println(
                        "Error! Number must be at least " + min + ".");
            } else if (i > max) {
                System.out.println(
                        "Error! Number must be at most " + max + ".");
            } else {
                isValid = true;
            }
        }
        return i;
    }

    public static double getDouble(String prompt) {
        boolean isValid = false;
        double d = 0.0;
        while (!isValid) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                d = sc.nextDouble();
                isValid = true;
            } else {
                sc.next();  // discard invalid data
                System.out.println("Error! Invalid double value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return d;
    }
    
    public static double getDouble(String prompt, double min) {
        double d = 0.0;
        boolean isValid = false;
        while (!isValid) {
            d = Console.getDouble(prompt);
            if (d < min) {
                System.out.println(
                        "Error! Number must be at least " + min + ".");
            } else {
                isValid = true;
            }
        }
        return d;
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
	
	public static String getString(String prompt, String s1, String s2) {
		String s = null;
		boolean isValid = false;
		while(!isValid) {
			System.out.print(prompt);
			s = sc.next();
			if (s.equals(s1) || s.equals(s2)) {
				isValid = true;
			} else {
				System.out.println("Error! Entry must be '" + s1 + 
						"' or '" + s2 + "'. Try again.");
				sc.nextLine();
			}
		}
		return s;
	}
	
	public static void print(String message) {
		System.out.print(message);
	}
	public static void println(String message) {
		System.out.println(message);
	}
}
