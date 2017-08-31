package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import db.Anslut;

public class ResultPage extends JFrame {

	JPanel panelTop = new JPanel();
	JPanel panelBottom = new JPanel();
	JTextArea textArea = new JTextArea(11, 60);
	JButton apply = new JButton("Anmäl");
	Interface abo = new Interface();
	Anslut db = new Anslut();

	public void results() throws Exception {

		db.stop = 1;

		// Get texts

		textArea.setText("\n" + abo.name + "\n\nPlats:  " + abo.place
				+ "\n\nReviews:\n\n" + abo.reviews + "\n\nFörkunskapskrav:  "
				+ abo.qualification + "\n\nLänk:  " + abo.link);
		panelTop.add(textArea);
		add(panelTop, BorderLayout.NORTH);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);

		// apply button

		apply.addActionListener(new SubmitButton());
		apply.setActionCommand("Apply");
		panelBottom.add(apply);
		add(panelBottom, BorderLayout.SOUTH);

		setTitle("DSS");
		setSize(900, 800);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	private class SubmitButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getActionCommand().equals("Apply")) {

				abo.submitted = true;
				try {
					Anslut.dbconnection();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Anmälan för " + abo.name
						+ " har skickats", "Application",
						JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
				dispose();

			}
		}

	}
}
