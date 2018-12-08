
public class ConsoleTesterApp {

	public static void main(String[] args) {
		UserIO userIO = IOFactory.getUserIO("Console");
		
		userIO.println("Welcome to the Console Tester application");
		
		userIO.println("\nInt Test");
		userIO.getInt("Enter an integer between -100 and 100: ", -100, 100);
		
		userIO.println("\nDouble Test");
		userIO.getDouble("Enter any number between -100 and 100: ", -100, 100);
		
		userIO.println("\nRequired String Test");
		userIO.getString("Enter your email address: ");
		
		userIO.println("\nString Choice Test");
		userIO.getString("Select one (x/y): ", "x", "y");
	}

}
