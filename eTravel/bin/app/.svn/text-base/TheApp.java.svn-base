package app;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import template.Destinations;
import template.MainPage;
import template.ResultPage;
import template.SelectedInformation;

import calculate.*;
import dao.SqlDAO;

public class TheApp {
	
	public static void main(String[] args) {
		
		SqlDAO sqlDAO = new SqlDAO();
		String[] citys = sqlDAO.getCitys();
		new MainPage(citys);
		
	}
	
	public void calculate(SelectedInformation info) {
		
		SqlDAO sqlDAO = new SqlDAO();
		shortPath path =  new shortPath();

		ArrayList<Flight> resultFlights = new ArrayList<Flight>();

		String departure = info.getSource();
		Date date = info.getDate();
		
		for (Destinations d : info.getDestinations()) {

			ArrayList<Long> finalRoute = new ArrayList<Long>();
			
			ArrayList<Integer> source = sqlDAO.getAirports(departure);
			ArrayList<Integer > destination = sqlDAO.getAirports(d.getDestination());
			ArrayList<Integer> otherAirports = sqlDAO.getAirports(departure , d.getDestination());
			ArrayList<Inner> possibleFilghts = path.possibleFlight(otherAirports, source, destination);

			System.out.println(" Source " + departure + " Destination " + d.getDestination() + " Date " + date);
			System.out.println(" ----------------------------------------------");
			for (Inner inner : possibleFilghts) {
				System.out.println(inner.getInside());
			}
			System.out.println("Inner End");
			Integer bestDuration = Integer.MAX_VALUE;
			for (Inner inner : possibleFilghts) {
				ArrayList<Long> availablePath = path.checkPath(inner.getInside() , date);
				for (Long l : availablePath) {
					System.out.print("---" + l );
				}
				System.out.println();
				//TODO We will have and if statement later for the cost or the duration!!
				
				Integer duration = sqlDAO.getDuration(availablePath);
				System.out.println("*******************" + duration);
				if(bestDuration > duration){
					bestDuration = duration;
					finalRoute = availablePath;
				}
				
			}
			
			for (Long flightId : finalRoute) {
				Flight flight = sqlDAO.getFlightInfo(flightId);
				resultFlights.add(flight);
			}

			departure = d.getDestination();
			date = new Date(date.getTime() + (d.getDays() * 24*60*60*1000));
		}
		
		

			try {
				new ResultPage(resultFlights);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		
	
	}
	
}
