package action;

/**
 * @author Khashayar
 */

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.Flight;
import bean.Hotel;
import bean.PackageCity;
import bean.PackageInner;
import bean.Place;
import bean.TopSearched;
import bean.Package;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.SqlDAO;

public class HomePage extends ActionSupport {

	private List<Package> packages;
	private List<TopSearched> topSearcheds;
	private String value_to_submit;
	private List<Flight> resultFlights;
	private List<Place> places;
	private Integer page;
	private Integer pageStatus;
	private String imagePath;
	private List<PackageCity> packageCities;
	private List<PackageInner> packageInners;
	private Package mainPackage;
	
	@Override
	public String execute() {

		SqlDAO sqlDAO = new SqlDAO();
		packages = sqlDAO.upcomingPackages();
		topSearcheds = sqlDAO.getTopSearched();
		
		return "success";
	}
	
	public String packageDetail() {
		
		SqlDAO sqlDAO = new SqlDAO();

		mainPackage = sqlDAO.getPackageInfo(value_to_submit);

		Map <String, Object> session = ActionContext.getContext().getSession();
		
		packageCities = sqlDAO.getPackageCityInfo(mainPackage);

		session.put("PackageCities", packageCities);
		
		packageInners = sqlDAO.getPackageInnerInfo(mainPackage);

		session.put("PackageInner", packageInners);

		return "package";
	}

	public String flightsDetail() {
		
		System.out.println(value_to_submit);
		SqlDAO sqlDAO = new SqlDAO();
		
		resultFlights = sqlDAO.getSearchedFlightInfo(Long.parseLong(value_to_submit));
		
		places = resultFlights.get(0).getPlaces();
		imagePath = "flash/"+resultFlights.get(0).getImage()+".swf";
		page = 0; 
		pageStatus = -1;
		
		Map <String, Object> session = ActionContext.getContext().getSession();
		
		session.put("flight", resultFlights);

		return "flight";
	}

	
	public List<PackageCity> getPackageCities() {
		return packageCities;
	}

	public void setPackageCities(List<PackageCity> packageCities) {
		this.packageCities = packageCities;
	}

	public List<PackageInner> getPackageInners() {
		return packageInners;
	}

	public void setPackageInners(List<PackageInner> packageInners) {
		this.packageInners = packageInners;
	}

	public Package getMainPackage() {
		return mainPackage;
	}

	public void setMainPackage(Package mainPackage) {
		this.mainPackage = mainPackage;
	}

	public List<Package> getPackages() {
		return packages;
	}

	public void setPackages(List<Package> packages) {
		this.packages = packages;
	}

	public List<TopSearched> getTopSearcheds() {
		return topSearcheds;
	}

	public void setTopSearcheds(List<TopSearched> topSearcheds) {
		this.topSearcheds = topSearcheds;
	}

	public String getValue_to_submit() {
		return value_to_submit;
	}

	public void setValue_to_submit(String value_to_submit) {
		this.value_to_submit = value_to_submit;
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

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	
}
