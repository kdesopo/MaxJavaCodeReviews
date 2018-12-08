import javax.swing.JOptionPane;

public class JOptionPanelIo implements UserIO {
	
	@Override
	public int getInt(String prompt) {
		String intString = "";
		Integer intgr = null;
		int i = 0;
		boolean isValid = false;
		while (!isValid) {
			try {
				intString = JOptionPane.showInputDialog(prompt);
				if (intString == null) {
					System.exit(0);
				} else {
					intgr = new Integer(intString);
					i = intgr.intValue();
					isValid = true;
				}
			} catch (NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Error! Invalid integer. Try again.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
			}
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
				JOptionPane.showMessageDialog(null, "Error! Number must be at least " + min + ".", 
						"Invalid Input", JOptionPane.ERROR_MESSAGE);
			} else if (i > max) {
				JOptionPane.showMessageDialog(null, "Error! Number must be at most " + max + ".", 
						"Invalid Input", JOptionPane.ERROR_MESSAGE);
			} else {
				isValid = true;
			}
			
		}
		return i;
	}
	
	@Override
	public double getDouble(String prompt) {
		String dblString = "";
		Double dbl = null;
		int d = 0;
		boolean isValid = false;
		while (!isValid) {
			try {
				dblString = JOptionPane.showInputDialog(prompt);
				if (dblString == null) {
					System.exit(0);
				} else {
					dbl = new Double(dblString);
					d = dbl.intValue();
					isValid = true;					
				}

			} catch (NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Error! Invalid double. Try again.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
			}
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
				JOptionPane.showMessageDialog(null, "Error! Number must be at least " + min + ".", 
						"Invalid Input", JOptionPane.ERROR_MESSAGE);
			} else if (d > max) {
				JOptionPane.showMessageDialog(null, "Error! Number must be at most " + max + ".", 
						"Invalid Input", JOptionPane.ERROR_MESSAGE);
			} else {
				isValid = true;
			}
			
		}
		return d;
	}

	@SuppressWarnings("unused")
	@Override
	public String getString(String prompt) {
		String s  = "";
		boolean isValid = false;
		while (!isValid) {
			s = JOptionPane.showInputDialog(prompt);
			if(s == null) {
				System.exit(0);
			} else if (s.equals("")) {
				JOptionPane.showMessageDialog(null, "Error! This entry is required. Try again.", 
						"Invalid input", JOptionPane.ERROR_MESSAGE);				
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
			s = JOptionPane.showInputDialog(prompt);
			if (s == null) {
				System.exit(0);
			} else if (s.equals(s1) || s.equals(s2)) {
				isValid = true;
			} else {
				JOptionPane.showMessageDialog(null, "Error! Entry must be '" + s1 + 
						"' or '" + s2 + "'. Try again.", "Invalid input", JOptionPane.ERROR_MESSAGE);
			}
		}
		return s;
	}

	@Override
	public void print(String s) {
		JOptionPane.showMessageDialog(null, s);

	}

	@Override
	public void println() {
		JOptionPane.showMessageDialog(null, "");

	}

	@Override
	public void println(String s) {
		JOptionPane.showMessageDialog(null, s);
	}

}
