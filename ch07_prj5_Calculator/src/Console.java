import java.util.Scanner;

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
	
	public static double getDouble(String prompt) {
		double d = 0;
		boolean isValid = false;
		while (!isValid) {
			System.out.print(prompt);
			if (sc.hasNextDouble()) {
				d = sc.nextDouble();
				isValid = true;
			} else {
				System.out.println("Error! Invalid double. Try again.");
			}
			sc.nextLine();
		}
		return d;
	}
}

