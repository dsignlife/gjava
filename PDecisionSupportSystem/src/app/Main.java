package app;
import db.Anslut;
import gui.*;


public class Main {
	
	public static void main(String args[]) throws Exception{
		
		//run GUI
		Interface abo = new Interface();
		Anslut.dbconnection();
		abo.ui();
		
		
	}
}
