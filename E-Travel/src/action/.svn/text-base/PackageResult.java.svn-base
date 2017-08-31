package action;

/**
 * @author Khashayar
 */

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.Flight;
import bean.Hotel;
import bean.Package;
import bean.PackageCity;
import bean.PackageInner;
import bean.Place;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class PackageResult extends ActionSupport{

	private List<PackageCity> packageCities;
	private List<PackageInner> packageInners;
	private Package mainPackage;
	private String value_to_submit;


	@Override
	public String execute(){
		
//		Map <String, Object> session = ActionContext.getContext().getSession();
//		session.remove("PackageInner");
//		session.remove("PackageCities");
//		
//		mainPackage = new Package();
//		
//		ArrayList<Flight> flights = new ArrayList<Flight>();
//		
//		Flight flight = new Flight();
//		flight.setAirLine("SAS");
//		flight.setCost(1000);
//		flight.setFlightNo("FLIGHT 193");
//		flight.setImage("image/SAS_Logo2.jpg");
//		flight.setFrom("Gothenburg");
//		flight.setTime(new Time(10, 0, 0));
//		flight.setDate(new Date(System.currentTimeMillis()));
//		flight.setTo("Paris");
//		flight.setStep(1);
//		flights.add(flight);
//		
//		flight = new Flight();
//		flight.setAirLine("TTT");
//		flight.setDate(new Date(System.currentTimeMillis()));
//		flight.setTo("Madrid");
//		flight.setStep(4);
//		flights.add(flight);
//		
//		ArrayList<Place> places = new ArrayList<Place>();
//		
//		Place place = new Place();
//		place.setName("Eiffel Tower");
//		place.setDescription("The structure was built between 1887 and 1889 as the entrance arch for the Exposition Universelle, a World Fair marking the centennial celebration of the French Revolution. Three hundred workers joined together 18,038 pieces of wrought iron using two and a half million rivets, in a structural design by Maurice Koechlin. Eiffel was assisted in the design by engineers Emile Nouguier and Maurice Koechlin and architect Stephen Sauvestre");
//		place.setCost("10 $");
//		place.setLink("http://en.wikipedia.org/wiki/Eiffel_Tower");
//		place.setStep(3);
//		places.add(place);
//		
//		place = new Place();
//		place.setName("REAL");
//		place.setStep(6);
//		places.add(place);
//
//		place = new Place();
//		place.setName("SOMEWHERE");
//		place.setStep(7);
//		places.add(place);
//		
//		place = new Place();
//		place.setName("SOMEWHERE2");
//		place.setStep(8);
//		places.add(place);
//		
//		place = new Place();
//		place.setName("SOMEWHERE3");
//		place.setStep(9);
//		places.add(place);
//		
//		place = new Place();
//		place.setName("SOMEWHERE4");
//		place.setStep(10);
//		places.add(place);
//		place = new Place();
//		place.setName("SOMEWHERE5");
//		place.setStep(11);
//		places.add(place);
//		place = new Place();
//		place.setName("SOMEWHERE6");
//		place.setStep(12);
//		places.add(place);
//		place = new Place();
//		place.setName("SOMEWHERE7");
//		place.setStep(13);
//		places.add(place);
//		
//		ArrayList<Hotel> hotels = new ArrayList<Hotel>();
//		
//		Hotel hotel = new Hotel();
//		hotel.setHotelName("HILTON");
//		hotel.setCity("Paris");
//		hotel.setDescription("Hilton Hotels & Resorts[1] (formerly known as Hilton Hotels) is an international hotel chain which includes many luxury hotels and resorts as well as select service hotels. It was founded by Conrad Hilton and now owned by Hilton Worldwide Hilton hotels are either owned by, managed by, or franchised to independent operators by Hilton Worldwide. Hilton Hotels became the first coast-to-coast hotel chain of the United States in 1943. As of 2010, there are now over 530 Hilton branded hotels across the world in 78 countries across six continents.");
//		hotel.setLink("http://www.hilton.com");
//		hotel.setPhone("697452184512135");
//		hotel.setPrice("1000 $");
//		hotel.setRank("*****");
//		hotel.setImagepath("image/hotels/hilton.jpg");
//		hotel.setStep(2);
//		hotels.add(hotel);
//		
//		hotel = new Hotel();
//		hotel.setHotelName("HIGHT");
//		hotel.setStep(5);
//		hotels.add(hotel);
//		
//		mainPackage.setFlight(flights);
//		mainPackage.setHotel(hotels);
//		mainPackage.setPlaces(places);
//		
//		
//		packageCities = new ArrayList<PackageCity>();
//		
//		for (int i=0 ; i < mainPackage.getFlight().size() ; i++) {
//			PackageCity pc = new PackageCity();
//			pc.setCityName(mainPackage.getFlight().get(i).getTo());
//			pc.setFrom(mainPackage.getFlight().get(i).getStep());
//			pc.setStatus(0);
//			packageCities.add(pc);
//		}
//		
//		for (int i = 0; i < packageCities.size()-1; i++) {
//			packageCities.get(i).setTo(packageCities.get(i+1).getFrom() - 1);
//		}
//		
//		packageCities.get(packageCities.size()-1).setTo(100);
//
//		session.put("PackageCities", packageCities);
//		
//		packageInners = new ArrayList<PackageInner>();
//		
//		int lenght = mainPackage.getFlight().size() + mainPackage.getHotel().size() + mainPackage.getPlaces().size();
//		
//		for (int i = 0; i < lenght + 1 ; i++) {
//			PackageInner element = new PackageInner();
//			packageInners.add(element);
//		}
//		
//		for (Flight f : mainPackage.getFlight()) {
//			PackageInner element = new PackageInner();
//			element.setDate(f.getDate());
//			element.setTitle(f.getAirLine());
//			element.setImagePath("image/flight_icon.png");
//			element.setType("flight");
//			element.setStep(f.getStep());
//
//			element.setFlightAirLine(f.getAirLine());
//			element.setFlightCost(f.getCost());
//			element.setFlightDate(f.getDate());
//			element.setFlightTime(f.getTime());
//			element.setFlightNo(f.getFlightNo());
//			element.setFlightImagePath(f.getImage());
//			element.setFlightFrom(f.getFrom());
//			element.setFlightTo(f.getTo());
//
//			packageInners.set(f.getStep() , element);
//		}
//		for (Hotel h : mainPackage.getHotel()) {
//			PackageInner element = new PackageInner();
//			element.setDate(new Date(System.currentTimeMillis()));
//			element.setTitle(h.getHotelName());
//			element.setType("hotel");
//			element.setStep(h.getStep());
//			element.setImagePath("image/hotel_icon.png");
//			
//			element.setHotelName(h.getHotelName()) ;
//			element.setHotelCity(h.getCity()) ;
//			element.setHotelRank(h.getRank()) ;
//			element.setHotelPrice(h.getPrice()) ;
//			element.setHotelPhone(h.getPhone()) ;
//			element.setHotelImagePath(h.getImagepath()) ;
//			element.setHotelLink(h.getLink()) ;
//			element.setHotelDescription(h.getDescription()) ;
//			
//			packageInners.set(h.getStep(), element);
//		}
//		for (Place p : mainPackage.getPlaces()) {
//			PackageInner element = new PackageInner();
//			element.setDate(new Date(System.currentTimeMillis()));
//			element.setTitle(p.getName());
//			element.setType("place");
//			element.setStep(p.getStep());
//			element.setImagePath("image/places_icon.png");
//			
//			element.setPlaceName(p.getName());
//			element.setPlaceDescription(p.getDescription());
//			element.setPlaceLink(p.getLink());
//			element.setPlaceImagePath("image/places/Eiffel Tower.jpg");
//			element.setPlaceCost(p.getCost());
//			
//			packageInners.set(p.getStep(), element);
//		}
//		
//		for (PackageCity p : packageCities) {
//			System.out.println(p.getCityName() + " : " + p.getFrom() + " --> " + p.getTo());
//		}
//		System.out.println("---------------------------");
//		for (PackageInner inner : packageInners) {
//			System.out.println(inner.getTitle() + " : " + inner.getDate() + "  --  " + inner.getStep());
//		}
//		
//		session.put("PackageInner", packageInners);

		return "success";
	}

	public String open(){

		Map <String, Object> session = ActionContext.getContext().getSession();
		
		System.out.println(value_to_submit);
		
		packageInners = (List<PackageInner>) session.get("PackageInner");
		packageCities = (List<PackageCity>) session.get("PackageCities");
		
		for (PackageCity p : packageCities) {
			if(p.getCityName().equals(value_to_submit)){
				p.setStatus(1);
			}
		}
		return "success";
	}

	public String close(){
		
		Map <String, Object> session = ActionContext.getContext().getSession();
		
		String x =  (String) session.get("button");
		
		System.out.println(value_to_submit);
		
		packageInners = (List<PackageInner>) session.get("PackageInner");
		packageCities = (List<PackageCity>) session.get("PackageCities");
		
		for (PackageCity p : packageCities) {
			if(p.getCityName().equals(value_to_submit)){
				p.setStatus(0);
			}
		}
		return "success";
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

	public String getValue_to_submit() {
		return value_to_submit;
	}

	public void setValue_to_submit(String value_to_submit) {
		this.value_to_submit = value_to_submit;
	}


}
