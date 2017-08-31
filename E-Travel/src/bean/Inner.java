package bean;

/**
 * @author Khashayar
 */

import java.util.ArrayList;

public class Inner {
	
	private ArrayList<Integer> inside;

	public ArrayList<Integer> getInside() {
		return inside;
	}

	public void setInside(ArrayList<Integer> inside) {
		this.inside = inside;
	}
	
	public String print() {
		
		String s = "";
		
		for (Integer t : inside) {
			s+= t.toString();
		}
		return s;
		
	}
	

}
