
public class IOFactory {
	public static UserIO getUserIO(String s) {
		if (s.equalsIgnoreCase("Console")) {
			return new ConsoleIO();
		} else {
		return new JOptionPanelIo();
		}
	}
}
