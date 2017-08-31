package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MainTest extends JFrame {
	
	private JLabel centertext = new JLabel ("THIS IS A TEST PAGE", JLabel.CENTER);
	
	public void test() {
		
		getContentPane().add(centertext);
		setTitle("GPS");
		setSize(700,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	

}
