
public class CalculatorApp {

	public static void main(String[] args) {
		System.out.println("Calculator App");
		
		String prompt = "Menu:\n" + 
				"1 - add 2 ints\n" + 
				"2 - add 3 ints\n" +
				"3 - add 2 dbls\n" +
				"4 - add 3 dbls\n" +
				"5 - exit\n\n";
		
		int choice = Console.getInt(prompt, 1, 5);
		
		while (choice != 5) {
		
			if (choice == 1 ){
				int num1 = Console.getInt("Enter 1st integer: ");
				int num2 = Console.getInt("Enter 2nd integer: ");
				System.out.println("Sum: " + Calculator.sum(num1, num2) + "\n");
					
			} else if (choice == 2) {
				int num1 = Console.getInt("Enter 1st integer: ");
				int num2 = Console.getInt("Enter 2nd integer: ");
				int num3 = Console.getInt("Enter 3rd integer: ");
				System.out.println("Sum: " + Calculator.sum(num1, num2, num3) + "\n");
				
			} else if (choice == 3) {
				double dbl1 = Console.getDouble("Enter 1st double: ");
				double dbl2 = Console.getDouble("Enter 2nd double: ");
				System.out.println("Sum: " + Calculator.sum(dbl1, dbl2) + "\n");

			} else if (choice == 4) {
				double dbl1 = Console.getDouble("Enter 1st double: ");
				double dbl2 = Console.getDouble("Enter 2nd double: ");
				double dbl3 = Console.getDouble("Enter 3rd double: ");
				System.out.println("Sum: " + Calculator.sum(dbl1, dbl2, dbl3) + "\n");
			}
			
			choice = Console.getInt(prompt, 1, 5);
		}
	}

}
