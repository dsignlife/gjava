package action;

/**
 * @author Khashayar
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.City;
import bean.Day;
import bean.Flight;
import bean.Place;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.SqlDAO;

public class ResultPage extends ActionSupport{


	private List<Flight> resultFlights;
	private List<Place> places;
	private Integer page;
	private Integer pageStatus;
	private Flight thisFlight;
	private String imagePath;
	private List<City> citys;
	private List<Day> days;
	private String[] destination = new String[5];
	private Integer destinationNumber;

	
	public String[] getDestination() {
		return destination;
	}

	public void setDestination(String[] destination) {
		this.destination = destination;
	}

	public Integer getDestinationNumber() {
		return destinationNumber;
	}

	public void setDestinationNumber(Integer destinationNumber) {
		this.destinationNumber = destinationNumber;
	}

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
	
	public List<Place> getPlaces() {
		return places;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public Flight getThisFlight() {
		return thisFlight;
	}

	public void setThisFlight(Flight thisFlight) {
		this.thisFlight = thisFlight;
	}

	public List<Flight> getResultFlights() {
		return resultFlights;
	}

	public void setResultFlights(List<Flight> resultFlights) {
		this.resultFlights = resultFlights;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	@Override
	public String execute(){


		return "success";
	}

	public String next(){
		
		page++;
		Map <String, Object> session = ActionContext.getContext().getSession();
		
		resultFlights = (ArrayList<Flight>) session.get("flight");

		if(page == resultFlights.size()-1){
			pageStatus = 1;
		}else{
			pageStatus = 0;
		}
		places = resultFlights.get(page).getPlaces();

		imagePath = "flash/"+resultFlights.get(page).getImage()+".swf";

		return "success";
	}

	public String back(){
		
		page--;
		if(page == 0 ){
			pageStatus = -1;
		}else{
			pageStatus = 0;
		}
		Map <String, Object> session = ActionContext.getContext().getSession();
		
		resultFlights = (ArrayList<Flight>) session.get("flight");
		
		places = resultFlights.get(page).getPlaces();
		
		imagePath = "flash/"+resultFlights.get(0).getImage()+".swf";

		return "success";
	}
	
	public String home(){

		SqlDAO sqlDAO = new SqlDAO();
		setCitys(sqlDAO.getCitys());
		
		days = new ArrayList<Day>();
		for (int i = 1; i <= 20; i++) {
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

	public Integer getPageStatus() {
		return pageStatus;
	}

	public void setPageStatus(Integer pageStatus) {
		this.pageStatus = pageStatus;
	}
	
}
