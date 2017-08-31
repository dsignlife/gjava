package bean;

/**
 * @author Khashayar
 */

import java.sql.Date;
import java.util.ArrayList;

public class SelectedInformation {
	
	private String source;
	private Date date;
	
	private ArrayList<Destination> destinations;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public ArrayList<Destination> getDestinations() {
		return destinations;
	}

	public void setDestinations(ArrayList<Destination> destinations) {
		this.destinations = destinations;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void print() {
		
		System.out.println(source);
		System.out.println(getDate());
		
		for (Destination d : destinations) {
			System.out.println(d.getDestination());
			System.out.println(d.getDays());
		}
	}
	
}
