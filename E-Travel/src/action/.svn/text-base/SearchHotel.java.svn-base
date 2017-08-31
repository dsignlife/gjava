package action;
import java.util.List;
import java.util.Map;

import bean.City;
import bean.Hotel;
import bean.SelectedInformation;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.SqlDAO;


public class SearchHotel extends ActionSupport{

	/**
	 *@author Tomz & Khashayar
	 */
	
	private List<City> citys;
	private List<Hotel> hotels;
	private String[] selectedPlaces = new String[20];
	private Integer hotelNumber;
	private String sourcePlace;
	private String imagePath;
	private String hotelName;
	
	@Override
	public String execute(){
		SqlDAO sqlDAO = new SqlDAO();
		citys = sqlDAO.getCitys();
		
		return "hotel";
	}


	public String search(){
		
		SqlDAO sqlDAO = new SqlDAO();
		
		SelectedInformation information = new SelectedInformation();
		information.setSource(sourcePlace);
		
		hotels = sqlDAO.getHotel(sourcePlace);
		
		Map <String, Object> session = ActionContext.getContext().getSession();
		
		session.put("Hotel", hotels);
		return "success";
	}


	public List<City> getCitys() {
		return citys;
	}


	public void setCitys(List<City> citys) {
		this.citys = citys;
	}


	public List<Hotel> getHotels() {
		return hotels;
	}


	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}


	public String[] getSelectedPlaces() {
		return selectedPlaces;
	}


	public void setSelectedPlaces(String[] selectedPlaces) {
		this.selectedPlaces = selectedPlaces;
	}


	public Integer getHotelNumber() {
		return hotelNumber;
	}


	public void setHotelNumber(Integer hotelNumber) {
		this.hotelNumber = hotelNumber;
	}


	public String getSourcePlace() {
		return sourcePlace;
	}


	public void setSourcePlace(String sourcePlace) {
		this.sourcePlace = sourcePlace;
	}


	public String getImagePath() {
		return imagePath;
	}


	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


	public String getHotelName() {
		return hotelName;
	}


	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
	

}

