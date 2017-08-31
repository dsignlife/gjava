package action;

/**
 * @author Khashayar
 */

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.City;
import bean.Day;
import bean.Destination;
import bean.Flight;
import bean.Place;
import bean.SelectedInformation;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.Calculate;
import dao.SqlDAO;

public class MainPage extends ActionSupport{

	private List<City> citys;
	private List<Day> days;
	private List<Flight> resultFlights;
	private List<Place> places;
	
	private String sourcePlace;
	private String departureDate;
	private String[] destination = new String[5];
	private String[] stayingDays = new String[5];
	private String imagePath;
	
	private Integer destinationNumber;
	private Integer page;
	private Integer pageStatus;
	private String test;

	public List<City> getCitys() {
		return citys;
	}

	public void setCitys(List<City> citys) {
		this.citys = citys;
	}

	public List<Day> getDays() {
		return days;
	}

	public void setDays(List<Day> days) {
		this.days = days;
	}

	public List<Flight> getResultFlights() {
		return resultFlights;
	}

	public void setResultFlights(List<Flight> resultFlights) {
		this.resultFlights = resultFlights;
	}

	public List<Place> getPlaces() {
		return places;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
	}

	public String getSourcePlace() {
		return sourcePlace;
	}

	public void setSourcePlace(String sourcePlace) {
		this.sourcePlace = sourcePlace;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String[] getDestination() {
		return destination;
	}

	public void setDestination(String[] destination) {
		this.destination = destination;
	}

	public String[] getStayingDays() {
		return stayingDays;
	}

	public void setStayingDays(String[] stayingDays) {
		this.stayingDays = stayingDays;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Integer getDestinationNumber() {
		return destinationNumber;
	}

	public void setDestinationNumber(Integer destinationNumber) {
		this.destinationNumber = destinationNumber;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageStatus() {
		return pageStatus;
	}

	public void setPageStatus(Integer pageStatus) {
		this.pageStatus = pageStatus;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	@Override
	public String execute(){
		SqlDAO sqlDAO = new SqlDAO();
		setCitys(sqlDAO.getCitys());
		
		days = new ArrayList<Day>();
		for (int i = 1; i <= 10; i++) {
			Day d =  new Day();
			d.setNumber(""+i);
			days.add(d);
		}		
		
		destinationNumber = 1;
		for (int i = destinationNumber-1; i < destination.length; i++) {
			destination[i] = "Gothenburg";
		}
		
		
		return "city";
	}

	public String more(){
		SqlDAO sqlDAO = new SqlDAO();
		setCitys(sqlDAO.getCitys());
		
		days = new ArrayList<Day>();
		for (int i = 1; i <= 20; i++) {
			Day d =  new Day();
			d.setNumber(""+i);
			days.add(d);
		}		
		
		destinationNumber++;
		for (int i = destinationNumber-1; i < destination.length; i++) {
			destination[i] = "Gothenburg";
		}
		
		return "city";
	}

	public String less(){
		SqlDAO sqlDAO = new SqlDAO();
		setCitys(sqlDAO.getCitys());
		
		days = new ArrayList<Day>();
		for (int i = 1; i <= 20; i++) {
			Day d =  new Day();
			d.setNumber(""+i);
			days.add(d);
		}		
		
		for (int i = destinationNumber-1; i < destination.length; i++) {
			destination[i] = "Gothenburg";
		}
		destinationNumber--;
		
		return "city";
	}

	public String search(){
		
		SelectedInformation information = new SelectedInformation();
		information.setSource(sourcePlace);
		information.setDate(getDate(departureDate));
		
		ArrayList<Destination> destinations = new ArrayList<Destination>();
		
		Destination d;
		
		for (int i = 0; i < destinationNumber; i++) {
			d = new Destination();
			d.setDestination(destination[i]);
			d.setDays(Integer.parseInt(stayingDays[i]));
			destinations.add(d);
		}
		
		
		d = new Destination();
		d.setDestination(sourcePlace);
		d.setDays(0);
		
		destinations.add(d);

		for (Destination ddd : destinations) {
			System.out.println(ddd.getDestination());
		}
		information.setDestinations(destinations);
		
		Calculate calculate = new Calculate();
		
		resultFlights = calculate.calculate(information);
		places = resultFlights.get(0).getPlaces();
		imagePath = "flash/"+resultFlights.get(0).getImage()+".swf";
		page = 0; 
		pageStatus = -1;
		
		Map <String, Object> session = ActionContext.getContext().getSession();
		
		session.put("flight", resultFlights);
		
		return "success";
	}
	
	private Date getDate(String s){

		String year = s.substring(0, 4);
		String month = s.substring(5, 7);
		String day = s.substring(8,10);
		int x = Integer.parseInt(year);
		int y = Integer.parseInt(month);
		int z = Integer.parseInt(day);
		
		Date d = new Date(x-1900, y-1, z);
		return d;
		
	}


}
