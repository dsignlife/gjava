package dao;

import java.sql.*;
import java.util.ArrayList;

import calculate.Flight;
import calculate.Places;


public class SqlDAO {

	//Get The City Names From DB to Show in The Selection Part
	public String[] getCitys() {
		
		BaseDao dao = new BaseDao();
		String[] citys = null;
		try {
			Connection connection = dao.getConnection();
			Statement statement = connection.createStatement();
			
			ResultSet rsCityCount = statement.executeQuery("select count(*)  from tblcity");
			int cityCount = 0;
			while(rsCityCount.next()){
				cityCount = rsCityCount.getInt(1);
			}
			citys = new String[cityCount];
			
			ResultSet rs = statement.executeQuery("select city from tblcity");
			
			int count =0 ;
			while(rs.next()){
				
				String city = rs.getString(1);
				citys[count] = city;
				count++;
			}
			rs.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return citys;
	}
	
	//All The Available Airports in One City
	public ArrayList<Integer> getAirports(String city) {
		
		BaseDao dao = new BaseDao();
		ArrayList<Integer> airports = new ArrayList<Integer>();
		try {
			Connection connection = dao.getConnection();
			String sql ="select cityid from tblcity where city = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, city);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				Long id = rs.getLong(1);
				sql = "select airportid from tblairport where cityid = ? ";
				PreparedStatement pst2 = connection.prepareStatement(sql);
				pst2.setLong(1, id);
				ResultSet rs2 = pst2.executeQuery();
				while(rs2.next()){
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

	//Get All The Available Airports Beside The Source And Destination City
	public ArrayList<Integer> getAirports(String source , String destination) {
		
		BaseDao dao = new BaseDao();
		ArrayList<Integer> airports = new ArrayList<Integer>();
		try {
			Connection connection = dao.getConnection();
			String sql ="select cityid from tblcity where city != ? and city != ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, source);
			pst.setString(2, destination);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				Long id = rs.getLong(1);
				sql = "select airportid from tblairport where cityid = ? ";
				PreparedStatement pst2 = connection.prepareStatement(sql);
				pst2.setLong(1, id);
				ResultSet rs2 = pst2.executeQuery();
				
				while(rs2.next()){
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

	
	
	@SuppressWarnings("unused")
	public String getCitysFromPlaces (String cityCoordinate1, String cityCoordinate2, ArrayList<String> Places){
		//this method isent used in the beta version but it will be implemented in the finished product.
		//the function this method will server is that it will find places and citys out of the parameters you enter.
		//you will be able to say what places you want to visit and this method will fix that.
		BaseDao dao = new BaseDao();
		
		String cityId = null;
		ArrayList<String> cityName = new ArrayList<String>();
		String destCoordinate1 = null;
		String destCoordinate2 = null;
		ArrayList<Double> distance = new ArrayList<Double>();
		
		try {
			Connection connection = dao.getConnection();
			
			
				String sql ="select distinct cityid from tblplaces where placename = ?";
				PreparedStatement pstCityId = connection.prepareStatement(sql);
				pstCityId.setString(1, Places.get(0));
				ResultSet rs = pstCityId.executeQuery();
				
				cityId = rs.getString(1);
				
				if (rs.next()){
					String sql2 = "Select distinct city,longitude, latitude from tblcity where cityid = ?";
					PreparedStatement pstCityName = connection.prepareStatement(sql2);
					pstCityId.setString(1, Places.get(0));
					ResultSet rsCityName = pstCityName.executeQuery();
					
					while(rsCityName.next()){
						cityName.add(rs.getString(1));
					}
					cityCoordinate1 = rs.getString(2);
					cityCoordinate2 = rs.getString(3);
					
					
					pstCityName.close();
				}
				
				rs.close();
				pstCityId.close();
				
				
				ArrayList<Double> destCoordinate = convertCoordinate(destCoordinate1, destCoordinate2);
				ArrayList<Double> cityCoordinate = convertCoordinate(cityCoordinate1, cityCoordinate2);
				for(int a = 0; a < destCoordinate.size(); a++){
				//TODO
				if (destCoordinate.get(0) != null){
					
					distance.add((Math.sqrt(Math.pow((((destCoordinate.get(1))) - (destCoordinate.get(0))), 2) + (Math.sqrt(Math.pow((((cityCoordinate.get(1))) - (cityCoordinate.get(0))), 2))))));
					
					for (int i = 0; i < 3; i++){	            
						 for (int j = 3 - 1; j >= i; j--){	                
							 if (distance.get(i) < 0){
								 //LABLAB
								 		 
				               }
				           }
						}
				}
				}
				
				
				
			} catch (SQLException e) {
			}
		
		
			
		
		return null;
	}
	
	
	public ArrayList<Double> convertCoordinate(String longitu, String lat){
		//this is a small method for converting the coordinates to double to be able to calculate the distance
		//in another method with the distance formula ((x2-x1)^2) + ((y2-y1)^2).
		
		ArrayList<Double> converted = new ArrayList<Double>();
		
		converted.add(Double.parseDouble(lat));
		converted.add(Double.parseDouble(longitu));
		
		
		return converted;
	}

	
	
	public Integer getCost(ArrayList<Long> flights){
		//getting the cost for the flight from the database and calculates the cost if the path is taking more then
		//one plane and stuff like that.
		
		BaseDao dao = new BaseDao();
		Integer cost = 0; 
		try {
			Connection connection = dao.getConnection();
			if(flights.size() == 0){
				return Integer.MAX_VALUE;
			}
			
			if(flights.size() == 1){
				String sql ="select cost from tblflight where flightid = ?";
				PreparedStatement pst = connection.prepareStatement(sql);
				pst.setLong(1, flights.get(0));
				ResultSet rs = pst.executeQuery();
				
				cost += rs.getInt(1);
			}
			
			if(flights.size() == 2){
				String sql ="select cost from tblflight where flightid = ?";
				PreparedStatement pst = connection.prepareStatement(sql);
				pst.setLong(1, flights.get(0));
				ResultSet rs = pst.executeQuery();
				
				if(rs.next()){
					cost += rs.getInt(1);
					
					sql = "select cost from tblflight where flightid = ?";
					PreparedStatement pst2 = connection.prepareStatement(sql);
					pst2.setLong(1, flights.get(1));
					ResultSet rs2 = pst2.executeQuery();
					if(rs2.next()){
						cost += rs.getInt(1);
						
					}
				}
				
				rs.close();
				pst.close();
			}
		
		
		
		
		}
		catch (SQLException e) {
		}
		
		
		return cost;
	}
	
	
	@SuppressWarnings("deprecation")
	public Integer getDuration(ArrayList<Long> flights) {
		BaseDao dao = new BaseDao();
		Integer min = Integer.MAX_VALUE ;
		try {
			Connection connection = dao.getConnection();
			if(flights.size() == 0){
				return Integer.MAX_VALUE;
			}
			if(flights.size() == 1){
				String sql ="select duration from tblflight where flightid = ?";
				PreparedStatement pst = connection.prepareStatement(sql);
				pst.setLong(1, flights.get(0));
				ResultSet rs = pst.executeQuery();
				
				if(rs.next()){
					Time t = rs.getTime(1);
					min = t.getHours() * 60;
					min += t.getMinutes();
				}
					
				rs.close();
				pst.close();
			}

			if(flights.size() == 2){
				String sql ="select date , time  , duration from tblflight where flightid = ?";
				PreparedStatement pst = connection.prepareStatement(sql);
				pst.setLong(1, flights.get(0));
				ResultSet rs = pst.executeQuery();
				
				if(rs.next()){
					Date startDate = rs.getDate(1);
					Time startTime = rs.getTime(2);
					Time deadline = new Time(startTime.getTime() + rs.getTime(3).getTime());
					
					sql = "select date , time , duration from tblflight where flightid = ? and date >= ? and time > ?";
					PreparedStatement pst2 = connection.prepareStatement(sql);
					pst2.setLong(1, flights.get(1));
					pst2.setDate(2, startDate);
					pst2.setTime(3, deadline);
					ResultSet rs2 = pst2.executeQuery();
					if(rs2.next()){
						Date endDate = rs2.getDate(1);
						Time endTime = rs2.getTime(2);
						
						int day = endDate.compareTo(startDate);
						min = day * 60 * 24;
						Integer duration = (int) ((endTime.getTime() - startTime.getTime()) / 1000 / 60);
						
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
	
	public Flight getFlightInfo (Long flightID){
		//this methods helps us getting all the information we need from the database,
		//its getting city and what airline and airplane you have to take to get there from the airport
		// you are going from so that we can later on print the information with the right parameters like what airline
		//airplane, airport, city and duration.
		
		
		BaseDao dao = new BaseDao();
		Connection connection = dao.getConnection();
		Flight flight = new Flight();
		Long FAPID;
		Long TAPID;
		Long ALID;
		
		try {
			String sql ="select * from tblflight where FLIGHTID = ? ";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setLong(1, flightID);
			ResultSet rs = pst.executeQuery();
			if (rs.next()){
				
				
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
				PreparedStatement pstFromAirport = connection.prepareStatement(sqlFromAirport);
				pstFromAirport.setLong(1, FAPID);
				ResultSet rsFromAirport = pstFromAirport.executeQuery();
				if (rsFromAirport.next())
					flight.setFrom(rsFromAirport.getString(1));
				
				String sqlToAirport = "select airportname, cityid from tblairport where AIRPORTID = ?";
				PreparedStatement pstToAirport = connection.prepareStatement(sqlToAirport);
				pstToAirport.setLong(1, TAPID);
				ResultSet rsToAirport = pstToAirport.executeQuery();
				if (rsToAirport.next()){
					flight.setTo(rsToAirport.getString(1));
					Long cityID = rsToAirport.getLong(2);
					
					String sqlPlaces = "select * from tblplaces where cityid = ?";
					PreparedStatement pstPlace = connection.prepareStatement(sqlPlaces);
					pstPlace.setLong(1, cityID);
					ResultSet rsPlaces = pstPlace.executeQuery();
					
					ArrayList<Places> places = new ArrayList<Places>();
					
					while (rsPlaces.next()){
						Places p = new Places();
						p.setCost(rsPlaces.getString(4));
						p.setType(rsPlaces.getString(5));
						p.setName(rsPlaces.getString(6));
						p.setLink(rsPlaces.getString(7));
						places.add(p);
					}
					flight.setPlaces(places);
				}
				
				String sqlAirline = "select AIRLINENAME from tblairline where AIRLINEID = ?";
				PreparedStatement pstAirline = connection.prepareStatement(sqlAirline);
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
	
}
