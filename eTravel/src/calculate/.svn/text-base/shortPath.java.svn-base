package calculate;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.BaseDao;

public class shortPath {
		
	
	public ArrayList<Long> checkPath(ArrayList<Integer> flights , Date date){
		//this method will find all the paths from one place to the next one and how many 
		//stop this flight will have, we will use a maximum of 3 flights to get from one place to another.
		// we will later see what paths are possible or not to actualy use with the parameters we use.
		BaseDao db = new BaseDao();
		Connection connection = db.getConnection();
		ArrayList<Long> flight = new ArrayList<Long>();
		 
		 try{
			 if (flights.size() == 2){
				String sql = "SELECT * FROM tblflight where FromAPID = ? and ToAPID = ? and date = ?";
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
				String sql = "SELECT * FROM tblflight where FromAPID = ? and ToAPID = ? and date = ?";
				PreparedStatement st = connection.prepareStatement(sql);
				st.setInt(1, flights.get(0));
				st.setInt(2, flights.get(1));
				st.setDate(3, date);
				ResultSet rs = st.executeQuery();
				if (rs.next()){
					String sql2 = "SELECT * FROM tblflight where FromAPID = ? and ToAPID = ? and date = ?";
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
	

	public ArrayList<Inner> possibleFlight(ArrayList<Integer> airport, ArrayList<Integer> source, ArrayList<Integer> desti){
		//this method will see if the path is possible or not. it will check from the arraylist<inner> wich is a arraylist of arraylists
		//it will add to temp and calculate the shortest out of the different possible paths later in anotehr method.
		
		ArrayList<Inner> c = new ArrayList<Inner>();
		ArrayList<Integer> temp = new ArrayList<Integer>();

		
		if (!airport.isEmpty()){
			for (int i=0; i < source.size(); i++)
				for (int j = 0; j < desti.size(); j++)
					for (int k = 0; k<airport.size(); k++){
					
						temp = new ArrayList<Integer>();
						Inner inside = new Inner();
						
						temp.add(source.get(i));
						temp.add(airport.get(k));
						temp.add(desti.get(j));
						
						inside.setInside(temp);
						
						c.add(inside);
					}
		}
		for (int i =0; i < source.size(); i++)
			for (int j =0; j < desti.size(); j++){
				
				temp = new ArrayList<Integer>();
				Inner inside = new Inner();
				
				temp.add(source.get(i));
				temp.add(desti.get(j));

				inside.setInside(temp);
				
				c.add(inside);
			}
		return c;
	
	}
}	
