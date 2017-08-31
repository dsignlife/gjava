package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import bean.City;
import bean.Destination;
import bean.Flight;
import bean.Hotel;
import bean.Package;
import bean.PackageCity;
import bean.PackageInner;
import bean.Place;
import bean.TopSearched;

public class SqlDAO {

	/**
	 * 
	 * @author Andreas
	 * 
	 */
	public ArrayList<City> getCitys() {

		ArrayList<City> cities = new ArrayList<City>();
		
		BaseDao dao = new BaseDao();
		try {
			Connection connection = dao.getConnection();
			Statement statement = connection.createStatement();
			
			ResultSet rs = statement.executeQuery("select city from tblcity");
			
			while (rs.next()) {
				
				String city = rs.getString(1);
				City c = new City();
				c.setCityName(city);
				cities.add(c);
				
			}
			rs.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cities;
	}

	public ArrayList<Hotel> getHotel(String hotelCity) {
		/**
		 * 
		 * @author Tomz & Khashayar
		 * 
		 */
		ArrayList<Hotel> hotel = new ArrayList<Hotel>();

		BaseDao dao = new BaseDao();

		try {
			Connection connection = dao.getConnection();

			String sql = "select * from tblhotel h , tblcity c where c.cityid = h.cityid and c.city = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, hotelCity);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				Hotel h = new Hotel();
				h.setHotelName(rs.getString("HOTELNAME"));
				h.setCity(rs.getString("CITY"));
				h.setRank(rs.getString("RANK"));
				h.setPrice(rs.getString("PRICE"));
				h.setPhone(rs.getString("PHONE"));
				h.setLink(rs.getString("LINK"));
				h.setImagepath(rs.getString("IMAGE"));
				h.setDescription(rs.getString("DESCRIPTION"));

				hotel.add(h);

			}
			rs.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return hotel;
	}

	/**
	 * @author Khashayar
	 */
	private String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(0);
		return dateFormat.format(date);
	}

	/**
	 * @author Andreas & Khashayar
	 */
	public Package getPackageInfo(String packageName) {

		BaseDao dao = new BaseDao();
		Package p = new Package();

		try {
			Connection connection = dao.getConnection();
			ArrayList<Flight> flights = new ArrayList<Flight>();
			ArrayList<Place> places = new ArrayList<Place>();
			ArrayList<Hotel> hotels = new ArrayList<Hotel>();

			String sql = "select * from tblpackage where packageName = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, packageName);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {

				Long id = rs.getLong(1);
				p.setPackageName(rs.getString(2));
				p.setPackageStartDate(rs.getDate(3));
				p.setPackageDiscription(rs.getString(4));
				p.setPackageDeparture(rs.getString(5));
				p.setPackagePrice(rs.getInt(6));
				
				String sqlStep = "select * from tblpackagesteps where packageid = ?";
				PreparedStatement pstStep = connection.prepareStatement(sqlStep);
				pstStep.setLong(1, id);
				ResultSet rsStep = pstStep.executeQuery();

				while (rsStep.next()) {
					Long fk = rsStep.getLong(5);
					
					if (rsStep.getString(4).equals("flight")) {

						Date date = rsStep.getDate(6);
						Flight flight = getFlightInfo(fk);
						flight.setDate(date);
						flight.setStep(rsStep.getInt(3));
						flights.add(flight);
					}
					
					if (rsStep.getString(4).equals("hotel")) {
						String sqlHotel = "select * from tblhotel where hotelid = ?";
						PreparedStatement pstHotel = connection
								.prepareStatement(sqlHotel);
						pstHotel.setLong(1, fk);
						ResultSet rsHotel = pstHotel.executeQuery();

						Hotel hotel = new Hotel();

						if(rsHotel.next()){
							
							hotel.setHotelName(rsHotel.getString(9));
							hotel.setCity(rsHotel.getString(2));
							hotel.setRank(rsHotel.getString(3));
							hotel.setPrice(rsHotel.getString(4));
							hotel.setPhone(rsHotel.getString(5));
							hotel.setLink(rsHotel.getString(6));
							hotel.setImagepath(rsHotel.getString(7));
							hotel.setDescription(rsHotel.getString(8));
							hotel.setDate(rsStep.getDate(6));
							hotel.setStep(rsStep.getInt(3));
							
						}
						hotels.add(hotel);
					}
					if (rsStep.getString(4).equals("place")) {
						String sqlPlace = "select * from tblplaces where placeid = ?";
						PreparedStatement pstPlace = connection
								.prepareStatement(sqlPlace);
						pstPlace.setLong(1, fk);
						ResultSet rsPlaces = pstPlace.executeQuery();

						Place place = new Place();

						if(rsPlaces.next()){
							place.setCost(rsPlaces.getString(3));
							place.setLink(rsPlaces.getString(7));
							place.setDescription(rsPlaces.getString(8));
							place.setName(rsPlaces.getString(6));
							place.setDate(rsStep.getDate(6));
							place.setStep(rsStep.getInt(3));
						}
						places.add(place);
					}
				}
			}

			p.setFlight(flights);
			p.setPlaces(places);
			p.setHotel(hotels);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}

	/**
	 * @author Andreas
	 */
	public ArrayList<Package> upcomingPackages() {

		BaseDao dao = new BaseDao();
		String packageName = null;
		ArrayList<Package> threeP = new ArrayList<Package>();

		String cd = getDateTime();

		try {
			
			Connection connection = dao.getConnection();
			String sql = "SELECT packagename FROM tblpackage t order by packagedate limit 3";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				packageName = (rs.getString(1));
				Package p = getPackageInfo(packageName);
				threeP.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return threeP;
	}

	/**
	 * @author Khashayar
	 */
	public ArrayList<TopSearched> getTopSearched() {
		BaseDao dao = new BaseDao();
		ArrayList<TopSearched> topSearcheds = new ArrayList<TopSearched>();

		try {
			Connection connection = dao.getConnection();
			String sql = "select searchedid from tblsearched order by times desc limit 3";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Long searchedId = rs.getLong(1);
				String name = "";
				TopSearched searched = new TopSearched();
				
				String sqlSumbit = "SELECT flightid FROM tblsubmit where searchedid = ? order by step";
				PreparedStatement pstSumbit = connection.prepareStatement(sqlSumbit);
				pstSumbit.setLong(1, searchedId);
				ResultSet rsSumbit = pstSumbit.executeQuery();

				while (rsSumbit.next()) {
					Long flightId = rsSumbit.getLong(1);
					
					String sqlFlight = "SELECT c.city  FROM tblflight f, tblcity c, tblairport a where a.cityid = c.cityid and a.airportid = f.toapid and f.flightid = ?";
					PreparedStatement pstFlight = connection.prepareStatement(sqlFlight);
					pstFlight.setLong(1, flightId);
					ResultSet rsFlight = pstFlight.executeQuery();
					
					if(rsFlight.next()){
						name += rsFlight.getString(1) + " - ";
					}
				}
				
				searched.setName(name);
				searched.setSearchedId(searchedId);
				
				topSearcheds.add(searched);
				
			}

			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return topSearcheds;
	}

	/**
	 * 
	 * @author Andreas
	 * 
	 */
	public ArrayList<Place> getPlaces() {

		BaseDao dao = new BaseDao();
		ArrayList<Place> places = new ArrayList<Place>();

		try {
			Connection connection = dao.getConnection();
			String sql = "select placename from tblplaces";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Place p = new Place();
				p.setName(rs.getString(1));
				places.add(p);
			}
			rs.close();
		} catch (SQLException e) {

		}

		return places;
	}

	/**
	 * 
	 * @author Andreas
	 * 
	 */
	// All The Available Airports in One City
	public ArrayList<Integer> getAirports(String city) {

		BaseDao dao = new BaseDao();
		ArrayList<Integer> airports = new ArrayList<Integer>();
		try {
			Connection connection = dao.getConnection();
			String sql = "select cityid from tblcity where city = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, city);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Long id = rs.getLong(1);
				sql = "select airportid from tblairport where cityid = ? ";
				PreparedStatement pst2 = connection.prepareStatement(sql);
				pst2.setLong(1, id);
				ResultSet rs2 = pst2.executeQuery();
				while (rs2.next()) {
					airports.add(rs2.getInt(1));
				}
				rs2.close();
				pst2.close();

			}
			rs.close();
			pst.close();

		} catch (SQLException e) {
		}
		return airports;
	}

	/**
	 * 
	 * @author Andreas
	 * 
	 */
	// Get All The Available Airports Beside The Source And Destination City
	public ArrayList<Integer> getAirports(String source, String destination) {

		BaseDao dao = new BaseDao();
		ArrayList<Integer> airports = new ArrayList<Integer>();
		try {
			Connection connection = dao.getConnection();
			String sql = "select cityid from tblcity where city != ? and city != ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, source);
			pst.setString(2, destination);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				Long id = rs.getLong(1);
				sql = "select airportid from tblairport where cityid = ? ";
				PreparedStatement pst2 = connection.prepareStatement(sql);
				pst2.setLong(1, id);
				ResultSet rs2 = pst2.executeQuery();

				while (rs2.next()) {
					airports.add(rs2.getInt(1));
				}
				rs2.close();
				pst2.close();

			}
			rs.close();
			pst.close();

		} catch (SQLException e) {
		}
		return airports;
	}

	/**
	 * 
	 * @author Khashayar
	 * 
	 */
	@SuppressWarnings("unused")
	public ArrayList<Destination> getCitysFromPlaces(String source,
			ArrayList<String> Places) {
		// this method isent used in the beta version but it will be implemented
		// in the finished product.
		// the function this method will server is that it will find places and
		// citys out of the parameters you enter.
		// you will be able to say what places you want to visit and this method
		// will fix that.

		BaseDao dao = new BaseDao();

		int cityId = 0;
		ArrayList<Destination> destinations = new ArrayList<Destination>();
		ArrayList<String> cityName = new ArrayList<String>();
		ArrayList<Double> latitude = new ArrayList<Double>();
		ArrayList<Double> longitude = new ArrayList<Double>();
		Double distance;
		Connection connection = dao.getConnection();

		try {
			for (String place : Places) {

				String sql = "select cityid from tblplaces where placename = ?";
				PreparedStatement pstCityId = connection.prepareStatement(sql);
				pstCityId.setString(1, place);
				ResultSet rs = pstCityId.executeQuery();

				if (rs.next()) {
					cityId = rs.getInt(1);
					String sql2 = "Select city from tblcity where cityid = ?";
					PreparedStatement pstCityName = connection
							.prepareStatement(sql2);
					pstCityName.setInt(1, cityId);
					ResultSet rsCityName = pstCityName.executeQuery();

					while (rsCityName.next()) {
						cityName.add(rsCityName.getString(1));
					}

					pstCityName.close();
				}

				rs.close();
				pstCityId.close();
			}

		} catch (SQLException e) {
			System.out.println("EEEEEEXXXXXPPPP");
		}

		for (String string : cityName) {
			System.out.println(string);
		}
		System.out.println("´--------------------------");
		for (int i = 0; i < cityName.size(); i++) {
			boolean flag = false;
			for (Destination d : destinations) {
				if (d.getDestination().equals(cityName.get(i))) {
					flag = true;
					d.setDays(d.getDays() + 1);
				}

			}
			if (!flag) {
				Destination dd = new Destination();
				dd.setDestination(cityName.get(i));
				dd.setDays(1);
				destinations.add(dd);
			}
		}

		try {

			double longitudeSource = 0.0;
			double latitudeSource = 0.0;

			for (int i = 0; i < destinations.size(); i++) {
				Statement stSource = connection.createStatement();
				String sqlSource = "select longitude , latitude from tblcity where city = '"
						+ source + "'";
				ResultSet rsSource = stSource.executeQuery(sqlSource);
				if (rsSource.next()) {
					longitudeSource = rsSource.getDouble(1);
					latitudeSource = rsSource.getDouble(2);
				}
				double minDistance = Double.MAX_VALUE;
				int minIndex = i;

				for (int j = i; j < destinations.size(); j++) {

					double longitudeTemp = 0.0;
					double latitudeTemp = 0.0;

					Statement stNext = connection.createStatement();
					String sqlNext = "select longitude , latitude from tblcity where city = '"
							+ destinations.get(j).getDestination() + "'";
					ResultSet rsNext = stNext.executeQuery(sqlNext);
					if (rsNext.next()) {
						longitudeTemp = rsNext.getDouble(1);
						latitudeTemp = rsNext.getDouble(2);
					}

					distance = Math.sqrt(((Math.pow(
							(longitudeSource - longitudeTemp), 2)) + (Math.pow(
							latitudeSource - latitudeTemp, 2))));

					System.out.println(source + "-----"
							+ destinations.get(j).getDestination() + "----->"
							+ distance);
					if (distance < minDistance) {
						minDistance = distance;
						minIndex = j;
					}

				}

				Destination t = destinations.get(i);
				destinations.set(i, destinations.get(minIndex));
				destinations.set(minIndex, t);

				source = destinations.get(i).getDestination();

			}
		} catch (SQLException e) {
		}

		return destinations;
	}

	/**
	 * 
	 * @author Khashayar & Andreas
	 * 
	 */
	public Integer getCost(ArrayList<Long> flights) {
		// getting the cost for the flight from the database and calculates the
		// cost if the path is taking more then
		// one plane and stuff like that.

		BaseDao dao = new BaseDao();
		Integer cost = 0;
		try {
			Connection connection = dao.getConnection();
			if (flights.size() == 0) {
				return Integer.MAX_VALUE;
			}

			if (flights.size() == 1) {
				String sql = "select cost from tblflight where flightid = ?";
				PreparedStatement pst = connection.prepareStatement(sql);
				pst.setLong(1, flights.get(0));
				ResultSet rs = pst.executeQuery();

				cost += rs.getInt(1);
			}

			if (flights.size() == 2) {
				String sql = "select cost from tblflight where flightid = ?";
				PreparedStatement pst = connection.prepareStatement(sql);
				pst.setLong(1, flights.get(0));
				ResultSet rs = pst.executeQuery();

				if (rs.next()) {
					cost += rs.getInt(1);

					sql = "select cost from tblflight where flightid = ?";
					PreparedStatement pst2 = connection.prepareStatement(sql);
					pst2.setLong(1, flights.get(1));
					ResultSet rs2 = pst2.executeQuery();
					if (rs2.next()) {
						cost += rs.getInt(1);

					} else {
						cost = Integer.MAX_VALUE;
					}
				} else {
					cost = Integer.MAX_VALUE;
				}

				rs.close();
				pst.close();
			}
		} catch (SQLException e) {
			cost = Integer.MAX_VALUE;
		}
		return cost;
	}

	/**
	 * 
	 * @author Khashayar
	 * 
	 */
	@SuppressWarnings("deprecation")
	public Integer getDuration(ArrayList<Long> flights) {
		BaseDao dao = new BaseDao();
		Integer min = Integer.MAX_VALUE;
		try {
			Connection connection = dao.getConnection();
			if (flights.size() == 0) {
				return Integer.MAX_VALUE;
			}
			if (flights.size() == 1) {
				String sql = "select duration from tblflight where flightid = ?";
				PreparedStatement pst = connection.prepareStatement(sql);
				pst.setLong(1, flights.get(0));
				ResultSet rs = pst.executeQuery();

				if (rs.next()) {
					Time t = rs.getTime(1);
					min = t.getHours() * 60;
					min += t.getMinutes();
				}

				rs.close();
				pst.close();
			}

			if (flights.size() == 2) {
				String sql = "select date , time  , duration from tblflight where flightid = ?";
				PreparedStatement pst = connection.prepareStatement(sql);
				pst.setLong(1, flights.get(0));
				ResultSet rs = pst.executeQuery();

				if (rs.next()) {
					Date startDate = rs.getDate(1);
					Time startTime = rs.getTime(2);
					Time deadline = new Time(startTime.getTime()
							+ rs.getTime(3).getTime());

					sql = "select date , time , duration from tblflight where flightid = ? and date >= ? and time > ?";
					PreparedStatement pst2 = connection.prepareStatement(sql);
					pst2.setLong(1, flights.get(1));
					pst2.setDate(2, startDate);
					pst2.setTime(3, deadline);
					ResultSet rs2 = pst2.executeQuery();
					if (rs2.next()) {
						Date endDate = rs2.getDate(1);
						Time endTime = rs2.getTime(2);

						int day = endDate.compareTo(startDate);
						min = day * 60 * 24;
						Integer duration = (int) ((endTime.getTime() - startTime
								.getTime()) / 1000 / 60);

						min += duration;
						Time t = rs2.getTime(3);
						min += t.getHours() * 60;
						min += t.getMinutes();

					}
				}

				rs.close();
				pst.close();
			}

		} catch (SQLException e) {
		}

		return min;

	}

	/**
	 * 
	 * @author Andreas
	 * 
	 */
	public Flight getFlightInfo(Long flightID) {
		// this methods helps us getting all the information we need from the
		// database,
		// its getting city and what airline and airplane you have to take to
		// get there from the airport
		// you are going from so that we can later on print the information with
		// the right parameters like what airline
		// airplane, airport, city and duration.

		BaseDao dao = new BaseDao();
		Connection connection = dao.getConnection();
		Flight flight = new Flight();
		Long FAPID;
		Long TAPID;
		Long ALID;

		try {
			String sql = "select * from tblflight where FLIGHTID = ? ";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setLong(1, flightID);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {

				FAPID = rs.getLong(2);
				TAPID = rs.getLong(3);
				flight.setFlightNo(rs.getString(4));
				ALID = rs.getLong(5);
				flight.setDate(rs.getDate(6));
				flight.setTime(rs.getTime(7));
				flight.setDuration(rs.getTime(8));
				flight.setDelayed(rs.getTime(9));
				flight.setCost(rs.getInt(10));
				flight.setBusinessCost(rs.getInt(11));
				flight.setGate(rs.getString(12));
				flight.setImage(rs.getString(13));

				String sqlFromAirport = "select airportname from tblairport where AIRPORTID = ?";
				PreparedStatement pstFromAirport = connection
						.prepareStatement(sqlFromAirport);
				pstFromAirport.setLong(1, FAPID);
				ResultSet rsFromAirport = pstFromAirport.executeQuery();
				if (rsFromAirport.next())
					flight.setFrom(rsFromAirport.getString(1));

				String sqlToAirport = "select airportname, cityid from tblairport where AIRPORTID = ?";
				PreparedStatement pstToAirport = connection
						.prepareStatement(sqlToAirport);
				pstToAirport.setLong(1, TAPID);
				ResultSet rsToAirport = pstToAirport.executeQuery();
				if (rsToAirport.next()) {
					flight.setTo(rsToAirport.getString(1));
					Long cityID = rsToAirport.getLong(2);

					String sqlPlaces = "select * from tblplaces where cityid = ?";
					PreparedStatement pstPlace = connection
							.prepareStatement(sqlPlaces);
					pstPlace.setLong(1, cityID);
					ResultSet rsPlaces = pstPlace.executeQuery();

					ArrayList<Place> places = new ArrayList<Place>();

					while (rsPlaces.next()) {
						Place p = new Place();
						p.setCost(rsPlaces.getString(4));
						p.setType(rsPlaces.getString(5));
						p.setName(rsPlaces.getString(6));
						p.setLink(rsPlaces.getString(7));
						places.add(p);
					}
					flight.setPlaces(places);
				}

				String sqlAirline = "select AIRLINENAME from tblairline where AIRLINEID = ?";
				PreparedStatement pstAirline = connection
						.prepareStatement(sqlAirline);
				pstAirline.setLong(1, ALID);
				ResultSet rsAirline = pstAirline.executeQuery();
				if (rsAirline.next())
					flight.setAirLine(rsAirline.getString(1));

			}

		} catch (SQLException e) {
			// TODO: handle exception
		}
		return flight;
	}

	/**
	 * 
	 * @author Khashayar
	 * 
	 */
	public void setSearchedInfo(ArrayList<Long> resultFlightIds) {

		BaseDao dao = new BaseDao();
		try {
			Connection connection = dao.getConnection();

			ArrayList<Long> result = new ArrayList<Long>();
			ArrayList<Long> temp;
			ArrayList<Long> newFlight;

			String sqlFirst = "select searchedid from tblsubmit where step = ? and flightid = ?";
			PreparedStatement pstFirst = connection.prepareStatement(sqlFirst);
			pstFirst.setInt(1, 1);
			pstFirst.setLong(2, resultFlightIds.get(0));
			ResultSet rsFirst = pstFirst.executeQuery();

			while (rsFirst.next()) {
				result.add(rsFirst.getLong(1));
			}
			rsFirst.close();

			for (int i = 1; i < resultFlightIds.size(); i++) {
				temp = new ArrayList<Long>();
				temp.addAll(result);
				result = new ArrayList<Long>();
				newFlight = new ArrayList<Long>();

				String sqlNew = "select searchedid from tblsubmit where step = ? and flightid = ?";
				PreparedStatement pstNew = connection.prepareStatement(sqlNew);
				pstNew.setInt(1, i + 1);
				pstNew.setLong(2, resultFlightIds.get(i));
				ResultSet rsNew = pstNew.executeQuery();

				while (rsNew.next()) {
					newFlight.add(rsNew.getLong(1));
				}

				for (int j = 0; j < temp.size(); j++) {
					for (int k = 0; k < newFlight.size(); k++) {
						if (temp.get(j) == newFlight.get(k)) {
							result.add(temp.get(j));
						}
					}
				}
			}

			if (result.size() > 0) {

				String sqlCount = "select times from tblsearched where searchedid = ?";
				PreparedStatement pstCount = connection
						.prepareStatement(sqlCount);
				pstCount.setLong(1, result.get(0));
				ResultSet rsCount = pstCount.executeQuery();
				int count = 0;
				if (rsCount.next()) {
					count = rsCount.getInt(1);
				}
				count++;

				String sqlSet = "UPDATE tblsearched set times = ?  where searchedid = ?";
				PreparedStatement pstSet = connection.prepareStatement(sqlSet);
				pstSet.setInt(1, count);
				pstSet.setLong(2, result.get(0));
				pstSet.execute();

			} else {
				System.out
						.println("NEW SEARCH!!! **************************************************");

				String sqlCount = "select max(searchedid) from tblsearched ";
				PreparedStatement pstCount = connection
						.prepareStatement(sqlCount);
				ResultSet rsCount = pstCount.executeQuery();
				Long searchId = 0l;
				if (rsCount.next()) {
					searchId = rsCount.getLong(1);
				}
				searchId++;
				String sqlSet = "insert into tblsearched (searchedid , times) values ( ? , ?)";
				PreparedStatement pstSet = connection.prepareStatement(sqlSet);
				pstSet.setLong(1, searchId);
				pstSet.setInt(2, 1);
				pstSet.execute();

				String sqlMax = "select max(id) from tblsubmit ";
				PreparedStatement pstMax = connection.prepareStatement(sqlMax);
				ResultSet rsMax = pstMax.executeQuery();
				Long id = 0l;
				if (rsMax.next()) {
					id = rsMax.getLong(1);
				}

				for (int i = 0; i < resultFlightIds.size(); i++) {
					String sqlSet2 = "insert into tblsubmit (id , searchedid , step , flightid) values ( ? , ? , ? , ?)";
					PreparedStatement pstSet2 = connection
							.prepareStatement(sqlSet2);
					pstSet2.setLong(1, id + i + 1);
					pstSet2.setLong(2, searchId);
					pstSet2.setInt(3, i + 1);
					pstSet2.setLong(4, resultFlightIds.get(i));
					pstSet2.execute();

				}

			}

			connection.close();
		} catch (SQLException e) {
			System.out.println("EEEXXXXXEEEEEP HERE!!");
			e.printStackTrace();
		}

	}
	
	public ArrayList<Long> checkPath(ArrayList<Integer> flights , Date date){
		
		BaseDao db = new BaseDao();
		Connection connection = db.getConnection();
		ArrayList<Long> flight = new ArrayList<Long>();
		 
		 try{
			 if (flights.size() == 2){
				String sql = "SELECT * FROM tblflight where FromAPID = ? and ToAPID = ? and DATE_FORMAT(date,'%d') = DATE_FORMAT(?,'%d')";
				PreparedStatement st = connection.prepareStatement(sql);
				st.setInt(1, flights.get(0));
				st.setInt(2, flights.get(1));
				st.setDate(3, date);
				ResultSet rs = st.executeQuery();
				if (rs.next())
					flight.add(rs.getLong(1));
				rs.close();
				st.close();
			 }
			
			 
	
			if (flights.size()== 3){
				String sql = "SELECT * FROM tblflight where FromAPID = ? and ToAPID = ? and DATE_FORMAT(date,'%d') = DATE_FORMAT(?,'%d')";
				PreparedStatement st = connection.prepareStatement(sql);
				st.setInt(1, flights.get(0));
				st.setInt(2, flights.get(1));
				st.setDate(3, date);
				ResultSet rs = st.executeQuery();
				if (rs.next()){
					String sql2 = "SELECT * FROM tblflight where FromAPID = ? and ToAPID = ? and DATE_FORMAT(date,'%d') = DATE_FORMAT(?,'%d')";
					PreparedStatement st2 = connection.prepareStatement(sql2);
					st2.setInt(1, flights.get(1));
					st2.setInt(2, flights.get(2));
					st2.setDate(3, date);
					ResultSet rs2 = st2.executeQuery();
					
					if(rs2.next()){
						flight.add(rs.getLong(1));
						flight.add(rs2.getLong(1));
					}
					rs2.close();
					st2.close();
				}
				rs.close();
				st.close();
			}
			
			
	} catch (Exception e) {
		   System.out.println("SQL problem when trying to get the resultSet");
	    e.printStackTrace();
	   }
		
			
		
		return flight;
	}

	public ArrayList<Flight> getSearchedFlightInfo(Long searchedId){
		
		BaseDao db = new BaseDao();
		Connection connection = db.getConnection();

		ArrayList<Flight> resultFlights = new ArrayList<Flight>();
		
		try {

			String sqlSumbit = "SELECT flightid FROM tblsubmit where searchedid = ? order by step";
			PreparedStatement pstSumbit = connection.prepareStatement(sqlSumbit);
			pstSumbit.setLong(1, searchedId);
			ResultSet rsSumbit = pstSumbit.executeQuery();
	
			while (rsSumbit.next()) {
				Long flightId = rsSumbit.getLong(1);
				Flight flight = getFlightInfo(flightId);
				resultFlights.add(flight);
			}
			
			String sqlCount = "select times from tblsearched where searchedid = ?";
			PreparedStatement pstCount = connection
					.prepareStatement(sqlCount);
			pstCount.setLong(1, searchedId);
			ResultSet rsCount = pstCount.executeQuery();
			int count = 0;
			if (rsCount.next()) {
				count = rsCount.getInt(1);
			}
			count++;

			String sqlSet = "UPDATE tblsearched set times = ?  where searchedid = ?";
			PreparedStatement pstSet = connection.prepareStatement(sqlSet);
			pstSet.setInt(1, count);
			pstSet.setLong(2, searchedId);
			pstSet.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultFlights;
	}
	
	public ArrayList<PackageCity> getPackageCityInfo(Package mainPackage) {
		
		ArrayList<PackageCity> packageCities = new ArrayList<PackageCity>();
		
		for (int i=0 ; i < mainPackage.getFlight().size() ; i++) {
			PackageCity pc = new PackageCity();
			pc.setCityName(mainPackage.getFlight().get(i).getTo());
			pc.setFrom(mainPackage.getFlight().get(i).getStep());
			pc.setStatus(0);
			packageCities.add(pc);
		}
		
		for (int i = 0; i < packageCities.size()-1; i++) {
			packageCities.get(i).setTo(packageCities.get(i+1).getFrom() - 1);
		}
		
		packageCities.get(packageCities.size()-1).setTo(100);

		return packageCities;
	}
	
	public ArrayList<PackageInner>	getPackageInnerInfo(Package mainPackage) {

		ArrayList<PackageInner> packageInners = new ArrayList<PackageInner>();
		
		int lenght = mainPackage.getFlight().size() + mainPackage.getHotel().size() + mainPackage.getPlaces().size();
		
		for (int i = 0; i < lenght + 1 ; i++) {
			PackageInner element = new PackageInner();
			packageInners.add(element);
		}
		
		for (Flight f : mainPackage.getFlight()) {
			PackageInner element = new PackageInner();
			element.setDate(f.getDate());
			element.setTitle(f.getAirLine());
			element.setImagePath("image/flight_icon.png");
			element.setType("flight");
			element.setStep(f.getStep());

			element.setFlightAirLine(f.getAirLine());
			element.setFlightCost(f.getCost());
			element.setFlightDate(f.getDate());
			element.setFlightTime(f.getTime());
			element.setFlightNo(f.getFlightNo());
			element.setFlightImagePath("image/airlines/" +f.getAirLine() +".jpg");
			element.setFlightFrom(f.getFrom());
			element.setFlightTo(f.getTo());

			packageInners.set(f.getStep() , element);
		}
		for (Hotel h : mainPackage.getHotel()) {
			PackageInner element = new PackageInner();
			element.setDate(new Date(System.currentTimeMillis()));
			element.setTitle(h.getHotelName());
			element.setType("hotel");
			element.setStep(h.getStep());
			element.setImagePath("image/hotel_icon.png");
			
			element.setHotelName(h.getHotelName()) ;
			element.setHotelCity(h.getCity()) ;
			element.setHotelRank(h.getRank()) ;
			element.setHotelPrice(h.getPrice()) ;
			element.setHotelPhone(h.getPhone()) ;
			element.setHotelImagePath("image/hotels/" + h.getHotelName()+".jpg") ;
			element.setHotelLink(h.getLink()) ;
			element.setHotelDescription(h.getDescription()) ;
			
			packageInners.set(h.getStep(), element);
		}
		for (Place p : mainPackage.getPlaces()) {
			PackageInner element = new PackageInner();
			element.setDate(new Date(System.currentTimeMillis()));
			element.setTitle(p.getName());
			element.setType("place");
			element.setStep(p.getStep());
			element.setImagePath("image/places_icon.png");
			
			element.setPlaceName(p.getName());
			element.setPlaceDescription(p.getDescription());
			element.setPlaceLink(p.getLink());
			element.setPlaceImagePath("image/places/" +p.getName()+"B.jpg");
			element.setPlaceCost(p.getCost());
			
			packageInners.set(p.getStep(), element);
		}
		
		return packageInners;
	}
	
	public ArrayList<Package> getPackages() {
		
		ArrayList<Package> packages = new ArrayList<Package>();
		
		BaseDao dao = new BaseDao();
		try {
			Connection connection = dao.getConnection();
			Statement statement = connection.createStatement();
			
			ResultSet rs = statement.executeQuery("select * from tblpackage order by packagedate limit 5");
			
			while (rs.next()) {
				Package p = new Package();
				p.setPackageName(rs.getString(2));
				p.setPackageStartDate(rs.getDate(3));
				p.setPackageDiscription(rs.getString(4));
				p.setPackageDeparture(rs.getString(5));
				p.setPackagePrice(rs.getInt(6));

				packages.add(p);
			}
			rs.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return packages;
		
	}
	
}