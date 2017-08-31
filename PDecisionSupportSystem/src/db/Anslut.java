package db;

import gui.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;

public class Anslut {

	public static Interface in = new Interface();

	public static String bbb;
	public static String ccc;
	public static String ddd;

	public static String name;
	public static String search;
	public static String submit;

	public static ResultSet result;
	public static Statement statement;

	public static int stop = 1;

	public static void dbconnection() throws Exception {

		int id = in.id;
		JComboBox itbox = in.itbox;
		JComboBox mdbox = in.mdbox;
		JComboBox langbox = in.langbox;
		JComboBox enginbox = in.enginbox;

		boolean submitted = in.submitted;

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:sqlserver://localhost:1433; databaseName=Ezlib;user=sa;password=tomz;");

		// import names for the boxes

		String it = "select * from itname";
		String md = "select * from mdname";
		String engin = "select * from enginname";
		String lang = "select * from langname";

		// import information from a row determined by id

		String rowIT = "select * from itname where id = " + id;
		String rowMED = "select * from mdname where id = " + id;
		String rowENGIN = "select * from enginname where id = " + id;
		String rowLANG = "select * from langname where id = " + id;

		statement = con.createStatement();

		if (in.id == 0) {

			result = statement.executeQuery(it);

			while (result.next()) {
				itbox.addItem(result.getString(2));
			}

			result = statement.executeQuery(md);

			while (result.next()) {
				mdbox.addItem(result.getString(2));
			}

			result = statement.executeQuery(engin);

			while (result.next()) {
				enginbox.addItem(result.getString(2));
			}

			result = statement.executeQuery(lang);

			while (result.next()) {
				langbox.addItem(result.getString(2));
			}
			result.close();
		}

		else if (id > 0 && id <= 5) {
			result = statement.executeQuery(rowIT);

			while (result.next()) {
				in.name = result.getString(2);
				in.place = result.getString(3);
				in.reviews = result.getString(4);
				in.qualification = result.getString(5);
				in.link = result.getString(6);
				in.searches = result.getString(7);
				in.submits = result.getString(8);
			}

			if (submitted == true) {
				int submits = Integer.parseInt(in.submits);
				int submitsADD = submits + 1;
				int update = statement
						.executeUpdate("UPDATE itname SET submit = "
								+ submitsADD + " WHERE id = " + id);
			}

			else {

				int searches = Integer.parseInt(in.searches);
				int searchesADD = searches + 1;
				int update = statement
						.executeUpdate("UPDATE itname SET search = "
								+ searchesADD + " WHERE id = " + id);

			}
			result.close();
		}

		else if (id > 5 && id <= 10) {
			result = statement.executeQuery(rowMED);

			while (result.next()) {
				in.name = result.getString(2);
				in.place = result.getString(3);
				in.reviews = result.getString(4);
				in.qualification = result.getString(5);
				in.link = result.getString(6);
				in.searches = result.getString(7);
				in.submits = result.getString(8);
			}

			if (submitted == true) {
				int submits = Integer.parseInt(in.submits);
				int submitsADD = submits + 1;
				int update = statement
						.executeUpdate("UPDATE mdname SET submit = "
								+ submitsADD + " WHERE id = " + id);

			}

			else {

				int searches = Integer.parseInt(in.searches);
				int searchesADD = searches + 1;
				int update = statement
						.executeUpdate("UPDATE mdname SET search = "
								+ searchesADD + " WHERE id = " + id);

			}
			result.close();
		}

		else if (id > 10 && id <= 15) {
			result = statement.executeQuery(rowENGIN);

			while (result.next()) {
				in.name = result.getString(2);
				in.place = result.getString(3);
				in.reviews = result.getString(4);
				in.qualification = result.getString(5);
				in.link = result.getString(6);
				in.searches = result.getString(7);
				in.submits = result.getString(8);
			}

			if (submitted == true) {
				int submits = Integer.parseInt(in.submits);
				int submitsADD = submits + 1;
				int update = statement
						.executeUpdate("UPDATE enginname SET submit = "
								+ submitsADD + " WHERE id = " + id);

			}

			else {

				int searches = Integer.parseInt(in.searches);
				int searchesADD = searches + 1;
				int update = statement
						.executeUpdate("UPDATE enginname SET search = "
								+ searchesADD + " WHERE id = " + id);

			}
			result.close();
		}

		else if (id > 15 && id <= 20) {
			result = statement.executeQuery(rowLANG);

			while (result.next()) {
				in.name = result.getString(2);
				in.place = result.getString(3);
				in.reviews = result.getString(4);
				in.qualification = result.getString(5);
				in.link = result.getString(6);
				in.searches = result.getString(7);
				in.submits = result.getString(8);
			}

			if (submitted == true) {
				int submits = Integer.parseInt(in.submits);
				int submitsADD = submits + 1;
				int update = statement
						.executeUpdate("UPDATE langname SET submit = "
								+ submitsADD + " WHERE id = " + id);

			}

			else {

				int searches = Integer.parseInt(in.searches);
				int searchesADD = searches + 1;
				int update = statement
						.executeUpdate("UPDATE langname SET search = "
								+ searchesADD + " WHERE id = " + id);

			}
			result.close();
		}

	}

	public static void getStats() throws SQLException {

		// this query will import names, searches and submits from database

		String query1 = "select * from itname";
		String query2 = "select * from mdname";
		String query3 = "select * from enginname";
		String query4 = "select * from langname";

		result = statement.executeQuery(query4);

		while (result.next()) {
			String aaa = result.getString(2);
			String aa = result.getString(7);
			String a = result.getString(8);

			bbb = aaa + "\n" + bbb;
			ccc = aa + "\n" + ccc;
			ddd = a + "\n" + ddd;

		}
		result = statement.executeQuery(query3);

		while (result.next()) {
			String aaa = result.getString(2);
			String aa = result.getString(7);
			String a = result.getString(8);

			bbb = aaa + "\n" + bbb;
			ccc = aa + "\n" + ccc;
			ddd = a + "\n" + ddd;

		}
		result = statement.executeQuery(query2);

		while (result.next()) {
			String aaa = result.getString(2);
			String aa = result.getString(7);
			String a = result.getString(8);

			bbb = aaa + "\n" + bbb;
			ccc = aa + "\n" + ccc;
			ddd = a + "\n" + ddd;

		}
		result = statement.executeQuery(query1);

		while (result.next()) {
			String aaa = result.getString(2);
			String aa = result.getString(7);
			String a = result.getString(8);

			bbb = aaa + "\n" + bbb;
			ccc = aa + "\n" + ccc;
			ddd = a + "\n" + ddd;

		}

		name = "Programme\n\n" + bbb;
		search = "Search\n\n" + ccc;
		submit = "Submit\n\n" + ddd;

		name = name.replace("null", "");
		search = search.replace("null", "");
		submit = submit.replace("null", "");

		result.close();

	}

}
