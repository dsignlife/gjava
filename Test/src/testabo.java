
import java.awt.FlowLayout;

import javax.swing.*;


public class testabo extends JFrame {

	public static void main(String[] args)  {
		
		testabo in = new testabo();
		in.abo();
		// TODO Auto-generated method stub


	    
	    
	}
	
	public void abo(){
		JPanel p = new JPanel();

	    JLabel lab1 = new JLabel("User Name", JLabel.LEFT);
	    p.setLayout(new FlowLayout()); 
	    p.add(lab1 = new JLabel("add JLabel"));
	    
	    add(p);
	    
	    setTitle("DSS");
		setSize(900,800);
		setVisible(true);
		setLocationRelativeTo(null);
	}

}
