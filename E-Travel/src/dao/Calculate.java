package dao;

/**
 * @author Khashayar
 */

import java.sql.Date;
import java.util.ArrayList;

import bean.Destination;
import bean.Flight;
import bean.Inner;
import bean.SelectedInformation;

public class Calculate {
	
	public ArrayList<Flight> calculate(SelectedInformation info) {
		
		SqlDAO sqlDAO = new SqlDAO();

		ArrayList<Flight> resultFlights = new ArrayList<Flight>();
		ArrayList<Long> resultFlightIds = new ArrayList<Long>();
		
		String departure = info.getSource();
		Date date = info.getDate();
		
		for (Destination d : info.getDestinations()) {

			ArrayList<Long> finalRoute = new ArrayList<Long>();
			
			ArrayList<Integer> source = sqlDAO.getAirports(departure);
			ArrayList<Integer > destination = sqlDAO.getAirports(d.getDestination());
			ArrayList<Integer> otherAirports = sqlDAO.getAirports(departure , d.getDestination());
			ArrayList<Inner> possibleFilghts = possibleFlight(otherAirports, source, destination);

			

			Integer bestDuration = Integer.MAX_VALUE;
			for (Inner inner : possibleFilghts) {
				ArrayList<Long> availablePath = sqlDAO.checkPath(inner.getInside() , date);
				
				//TODO We will have and if statement later for the cost or the duration!!
				
				Integer duration = sqlDAO.getDuration(availablePath);
				
				if(bestDuration > duration){
					bestDuration = duration;
					finalRoute = availablePath;
				}
				
			}
			
			for (Long flightId : finalRoute) {
				resultFlightIds.add(flightId);
				Flight flight = sqlDAO.getFlightInfo(flightId);
				flight.setDate(date);
				resultFlights.add(flight);
			}

			departure = d.getDestination();
			date = new Date(date.getTime() + (d.getDays() * 24*60*60*1000));
		}
		
		
		
		sqlDAO.setSearchedInfo(resultFlightIds);
		
		
		return resultFlights;
	}
	
	private ArrayList<Inner> possibleFlight(ArrayList<Integer> airport, ArrayList<Integer> source, ArrayList<Integer> destination){
		
		
		ArrayList<Inner> c = new ArrayList<Inner>();
		ArrayList<Integer> temp = new ArrayList<Integer>();

		
		if (!airport.isEmpty()){
			for (int i=0; i < source.size(); i++)
				for (int j = 0; j < destination.size(); j++)
					for (int k = 0; k<airport.size(); k++){
					
						temp = new ArrayList<Integer>();
						Inner inside = new Inner();
						
						temp.add(source.get(i));
						temp.add(airport.get(k));
						temp.add(destination.get(j));
						
						inside.setInside(temp);
						
						c.add(inside);
					}
		}
		for (int i =0; i < source.size(); i++)
			for (int j =0; j < destination.size(); j++){
				
				temp = new ArrayList<Integer>();
				Inner inside = new Inner();
				
				temp.add(source.get(i));
				temp.add(destination.get(j));

				inside.setInside(temp);
				
				c.add(inside);
			}
		return c;
	
	}

	
}
