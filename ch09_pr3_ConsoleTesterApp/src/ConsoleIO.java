import java.util.Scanner;

public class ConsoleIO implements UserIO {
	
	private Scanner sc = new Scanner(System.in);
	
	@Override
	public int getInt(String prompt) {
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

	@Override
	public int getInt(String prompt, int min, int max) {
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

	@Override
	public double getDouble(String prompt) {
		double d = 0.0;
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

	@Override
	public double getDouble(String prompt, double min, double max) {
		double d = 0;
		boolean isValid = false;
		while (!isValid) {
			d = getDouble(prompt);
			if (d < min) {
				System.out.println(
						"Error! Number must be at least " + min + ".");
			} else if (d > max) {
				System.out.println(
						"Error! Number must be no more than " + max + ".");
			} else {
				isValid = true;
			}
			
		}
		return d;
	}

	@Override
	public String getString(String prompt) {
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

	@Override
	public String getString(String prompt, String s1, String s2) {
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

	@Override
	public void print(String s) {
		System.out.print(s);

	}

	@Override
	public void println() {
		System.out.println();

	}

	@Override
	public void println(String s) {
		System.out.println(s);

	}

}
