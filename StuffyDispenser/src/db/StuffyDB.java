package db;

import java.util.ArrayList;
import business.Stuffy;

public class StuffyDB {
	
	private ArrayList<Stuffy> stuffies = new ArrayList<>();
	private String[] types = {"bear", "cat", "Yoshi", "Pikachu", "Donald Trump"}; 
	private String[] sizes = {"small", "medium", "large", "mini"}; 
	private String[] colors = {"brown", "black", "white", "red", "green"};
	private int t;
	private int s;
	private int c;
	private int idcount = 10;
	
	
	public StuffyDB() {
		populateStuffies();
	}
	
	private void populateStuffies() {
		for(int i = 1; i <= idcount; i++) {
			t = (int)(Math.random() * types.length);
			s = (int)(Math.random() * sizes.length);
			c = (int)(Math.random() * colors.length);
			stuffies.add(new Stuffy(i, types[t], sizes[s], colors[c]));
		}
	}
	
	public Stuffy grabStuffy(int x) {
		Stuffy stuffy = null;
		for (Stuffy s : stuffies) {
			if (s.getId() == x) {
				stuffy = s;
				break;
			}		
		}
		stuffies.remove(stuffy);
		return stuffy;
	}
	
	public void addStuffy(Stuffy s) {
		stuffies.add(s);
		idcount++;
		
	}
	
	public int getIdCt() {
		return idcount;
	}
	
	
}
