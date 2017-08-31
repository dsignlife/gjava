package gui;

import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

import db.Anslut;

public class Statistics extends JFrame {

	Anslut db = new Anslut();

	JTextArea textArea1 = new JTextArea(11, 40);
	JTextArea textArea2 = new JTextArea(11, 15);
	JTextArea textArea3 = new JTextArea(11, 15);

	JPanel panelWest = new JPanel();
	JPanel panelCenter = new JPanel();
	JPanel panelEast = new JPanel();

	public void stats() throws SQLException {

		panelWest.add(textArea1);
		panelCenter.add(textArea2);
		panelEast.add(textArea3);

		if (db.stop == 1) {

			textArea1.setText(db.name);
			textArea2.setText(db.search);
			textArea3.setText(db.submit);

			db.stop++;

		}

		add(panelWest, BorderLayout.WEST);
		add(panelCenter, BorderLayout.CENTER);
		add(panelEast, BorderLayout.EAST);

		textArea1.setEditable(false);
		textArea1.setLineWrap(true);
		textArea1.setWrapStyleWord(true);

		textArea2.setEditable(false);
		textArea2.setLineWrap(true);
		textArea2.setWrapStyleWord(true);

		textArea3.setEditable(false);
		textArea3.setLineWrap(true);
		textArea3.setWrapStyleWord(true);

		setTitle("Statistics Page");
		setSize(900, 800);
		setVisible(true);
		setLocationRelativeTo(null);

	}

}
