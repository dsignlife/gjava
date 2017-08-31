package template;

import java.sql.Date;
import java.util.ArrayList;

public class SelectedInformation {
	
	private String source;
	private Date date;
	
	private ArrayList<Destinations> destinations;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public ArrayList<Destinations> getDestinations() {
		return destinations;
	}

	public void setDestinations(ArrayList<Destinations> destinations) {
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
		
		for (Destinations d : destinations) {
			System.out.println(d.getDestination());
			System.out.println(d.getDays());
		}
	}
	
}
