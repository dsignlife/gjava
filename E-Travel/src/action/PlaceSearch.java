package action;

/**
 * @author Khashayar
 */

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.City;
import bean.Destination;
import bean.Flight;
import bean.Place;
import bean.SelectedInformation;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.Calculate;
import dao.SqlDAO;


public class PlaceSearch extends ActionSupport{

	private List<City> citys;
	private List<Place> places;
	private List<Flight> resultFlights;
	private Integer placesNumber;
	private String[] selectedPlaces = new String[20];
	private String sourcePlace;
	private String departureDate;
	private Integer page;
	private Integer pageStatus;
	private String imagePath;

	
	public List<Flight> getResultFlights() {
		return resultFlights;
	}

	public void setResultFlights(List<Flight> resultFlights) {
		this.resultFlights = resultFlights;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
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

	public List<City> getCitys() {
		return citys;
	}

	public void setCitys(List<City> citys) {
		this.citys = citys;
	}

	public List<Place> getPlaces() {
		return places;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
	}

	public Integer getPlacesNumber() {
		return placesNumber;
	}

	public void setPlacesNumber(Integer placesNumber) {
		this.placesNumber = placesNumber;
	}

	public String[] getSelectedPlaces() {
		return selectedPlaces;
	}

	public void setSelectedPlaces(String[] selectedPlaces) {
		this.selectedPlaces = selectedPlaces;
	}

	@Override
	public String execute(){
		SqlDAO sqlDAO = new SqlDAO();
		setCitys(sqlDAO.getCitys());
		places = sqlDAO.getPlaces();
		
		placesNumber = 1;
		for (int i = placesNumber-1; i < selectedPlaces.length; i++) {
			selectedPlaces[i] = "Liseberg";
		}

		return "place";
	}

	public String more(){
		SqlDAO sqlDAO = new SqlDAO();
		setCitys(sqlDAO.getCitys());
		places = sqlDAO.getPlaces();

		placesNumber++;
		for (int i = placesNumber-1; i < selectedPlaces.length; i++) {
			selectedPlaces[i] = "Liseberg";
		}
		return "place";
	}

	public String less(){
		SqlDAO sqlDAO = new SqlDAO();
		setCitys(sqlDAO.getCitys());
		places = sqlDAO.getPlaces();
		
		for (int i = placesNumber-1; i < selectedPlaces.length; i++) {
			selectedPlaces[i] = "Liseberg";
		}
		placesNumber--;
		return "place";
	}

	public String search(){
		
		SqlDAO sqlDAO = new SqlDAO();
		
		SelectedInformation information = new SelectedInformation();
		information.setSource(sourcePlace);
		information.setDate(getDate(departureDate));
		
		ArrayList<Destination> destinations = new ArrayList<Destination>();
		
		ArrayList<String> tempPlaces = new ArrayList<String>();
		for (int i = 0; i < placesNumber; i++) {
			tempPlaces.add(selectedPlaces[i]);
		}
		
		destinations = sqlDAO.getCitysFromPlaces(sourcePlace, tempPlaces); 
		
		
		Destination d = new Destination();
		d.setDestination(sourcePlace);
		d.setDays(0);

		destinations.add(d);

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
