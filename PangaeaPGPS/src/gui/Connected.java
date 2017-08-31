package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class Connected extends JFrame {
	
	
	private ImageIcon icon = new ImageIcon("images/blinking-green-dot.gif");
	private JLabel centertext = new JLabel ("Connection Established!", icon, JLabel.CENTER);
	private JButton next = new JButton ("NEXT");
	
	
	public void second() {
		
		add(next, BorderLayout.SOUTH);
		next.setActionCommand("NEXT");
		next.addActionListener(new ButtonListener());
		getContentPane().add(centertext);
		setTitle("GPS");
		setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			
			
			
			if(e.getActionCommand().equals("NEXT")){
				setVisible(false);
				dispose();
				MainTest test1 = new MainTest();
				test1.test();
				
			}
		}
		
	}

	
}
