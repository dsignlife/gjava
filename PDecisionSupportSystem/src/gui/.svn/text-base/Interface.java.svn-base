package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import db.*;

@SuppressWarnings("serial")
public class Interface extends JFrame {

	Anslut db = new Anslut();

	// First Box
	String[] pre = { "<Programme Area>", "IT", "Engineering", "Medicin",
			"Languages" };
	JComboBox preferences = new JComboBox(pre);
	// First Box ends

	public static JComboBox itbox = new JComboBox();
	public static JComboBox mdbox = new JComboBox();
	public static JComboBox langbox = new JComboBox();
	public static JComboBox enginbox = new JComboBox();

	JLabel prefer = new JLabel("Choose your preference:");

	JPanel panelTop = new JPanel();
	JPanel panelBottom = new JPanel();
	JPanel panelCenter = new JPanel();

	JButton submit = new JButton("Submit");
	JButton statistic = new JButton("View Statistics");

	public static int id;

	public static String name;
	public static String reviews;
	public static String place;
	public static String qualification;
	public static String link;
	public static String searches;
	public static String submits;

	public static boolean stats = false;
	public static boolean submitted = false;

	Statistics statspage = new Statistics();

	// JUST IN ONE PAGE, WILL CHANGE LATER

	public void ui() {

		panelTop.add(prefer);
		panelTop.add(preferences);

		submit.addActionListener(new SubmitButton());

		statistic.addActionListener(new showStats());
		statistic.setActionCommand("Showstats");

		panelCenter.add(submit);
		panelBottom.add(statistic);

		// Add panelTop to JFrame
		add(panelTop, BorderLayout.NORTH);
		add(panelCenter, BorderLayout.CENTER);
		add(panelBottom, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("DDS");
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
	}

	// actions for each submitted

	private class SubmitButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			submitted = false;

			// action for not choosing

			if (preferences.getSelectedItem() == "<Programme Area>") {

				JOptionPane.showMessageDialog(null,
						"Please choose your interested Area", "Warning",
						JOptionPane.WARNING_MESSAGE);
			}

			// action for IT
			if (preferences.getSelectedItem() == "IT") {

				JOptionPane.showMessageDialog(null, itbox, "IT PROGRAMMES",
						JOptionPane.QUESTION_MESSAGE);

				if (itbox.getSelectedItem().equals(
						"Software Engineering and Management, 180 hp")) {
					id = 1;
					method();

				} else if (itbox
						.getSelectedItem()
						.equals("Systemvetenskap: IT, Människa och Organisation, 180 hp")) {
					id = 2;
					method();
				} else if (itbox
						.getSelectedItem()
						.equals("Data- och systemvetenskapligt kandidatprogram, 180 hp")) {
					id = 3;
					method();
				} else if (itbox.getSelectedItem().equals(
						"Civilingenjör Informationsteknik 300 hp")) {
					id = 4;
					method();
				} else if (itbox.getSelectedItem().equals(
						"Civilingenjör Teknisk design 300 hp")) {
					id = 5;
					method();
				}

			}

			// action for MD
			if (preferences.getSelectedItem() == "Medicin") {

				JOptionPane.showMessageDialog(null, mdbox, "IT PROGRAMMES",
						JOptionPane.QUESTION_MESSAGE);

				if (mdbox.getSelectedItem().equals("Läkarprogrammet, 330 hp")) {
					id = 6;
					method();
				} else if (mdbox.getSelectedItem().equals(
						"Arbetsterapeutprogrammet, 180 hp")) {
					id = 7;
					method();
				} else if (mdbox
						.getSelectedItem()
						.equals("Kandidatprogrammet Personal, arbete och organisation, 180 hp")) {
					id = 8;
					method();
				} else if (mdbox.getSelectedItem().equals(
						"Tandläkarprogrammet, 300 hp")) {
					id = 9;
					method();
				} else if (mdbox.getSelectedItem().equals(
						"Sjuksköterskeprogrammet, 180 hp")) {
					id = 10;
					method();
				}
			}
			// action for Engineering
			if (preferences.getSelectedItem() == "Engineering") {

				JOptionPane.showMessageDialog(null, enginbox, "IT PROGRAMMES",
						JOptionPane.QUESTION_MESSAGE);

				if (enginbox.getSelectedItem().equals(
						"Arkitektur och teknik 300 hp")) {
					id = 11;
					method();
				} else if (enginbox.getSelectedItem().equals(
						"Maskinteknik 300 hp")) {
					id = 12;
					method();
				} else if (enginbox.getSelectedItem().equals(
						"Arkitektur 300 hp")) {
					id = 13;
					method();
				} else if (enginbox.getSelectedItem().equals(
						"Civilingenjör Bioteknik 300 hp")) {
					id = 14;
					method();
				} else if (enginbox.getSelectedItem().equals(
						"Civilingenjör Farkostteknik 300 hp")) {
					id = 15;
					method();
				}

			}
			// action for Languages
			if (preferences.getSelectedItem() == "Languages") {

				JOptionPane.showMessageDialog(null, langbox, "IT PROGRAMMES",
						JOptionPane.QUESTION_MESSAGE);

				if (langbox.getSelectedItem().equals(
						"Spanska, språk och litteratur I, 30 hp")) {
					id = 16;
					method();
				} else if (langbox
						.getSelectedItem()
						.equals("Svenska som främmande språk - Förberedande kurs, 30 hp")) {
					id = 17;
					method();
				} else if (langbox.getSelectedItem().equals(
						"Tyska, Grundkurs, 30 hp")) {
					id = 18;
					method();
				} else if (langbox.getSelectedItem().equals(
						"Japanska, grundkurs 1, 15 hp")) {
					id = 19;
					method();
				} else if (langbox.getSelectedItem().equals(
						"Franska: Grundkurs II, 30 hp")) {
					id = 20;
					method();
				}
			}

		}

	}

	private class showStats implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getActionCommand().equals("Showstats")) {

				statspage.dispose();
				id = 0;
				submitted = false;
				gostats();

			}

		}
	}

	private void method() {

		try {
			Anslut.dbconnection();
			ResultPage go = new ResultPage();
			go.results();

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void gostats() {

		try {

			db.bbb = "";
			db.ccc = "";
			db.ddd = "";

			Anslut.getStats();
			statspage.stats();

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
