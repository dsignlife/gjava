import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class newWindowVer2 extends JFrame {
    JButton b1 = new JButton("Show");
    JButton b2 = new JButton("Hide");
    JTextField txt = new JTextField(10);
 
 // Here is the reference to the new window
    win2 w2 = new win2();

 // A new class that is used to describe a new
 // independent window
 	private class win2 extends JFrame{
	
		JPanel wp2 = new JPanel();
		JPanel wp3 = new JPanel();
		
		JLabel wl1 = new JLabel("Name:");
		JLabel wl2 = new JLabel("Address:");
		JTextField wf1 = new JTextField(10);
		JTextField wf2 = new JTextField(10);
		
		JButton wb1 = new JButton("Back");
		JButton wb2 = new JButton("Erase");
		JButton wb3 = new JButton("Save");
		
		ActionListener wbl = new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
				if (e.getSource() == wb1) {
		    		w2.setVisible(false);
				} else if (((JButton)e.getSource()).getText().equals("Erase")) {
		    		wf1.setText("");	
		    		wf2.setText("");	
				} else if (((JButton)e.getSource()).getText().equals("Save")) {
					System.out.println("Name = " + wf1.getText());
					System.out.println("Address = " + wf2.getText());
				} else {
					// Impossible alternative
				}
	    	}
		};
		
		private win2() {
			setTitle("myLatestWindow");
			setLayout(new GridLayout(2, 1, 0, 10));

			wp2.setLayout(new GridLayout(2, 2));
			wp2.setPreferredSize(new Dimension(300, 50));
			wp2.setBackground(Color.white);
			wp2.add(wl1); wp2.add(wf1); wp2.add(wl2); wp2.add(wf2);
			add(wp2);

			wp3.setPreferredSize(new Dimension(300, 50));
			wp3.setBackground(Color.gray);
			wp3.add(wb1); wp3.add(wb2); wp3.add(wb3);
			wb1.addActionListener(wbl);
			wb2.addActionListener(wbl);
			wb3.addActionListener(wbl);

			add(wp2); add(wp3);
			pack();
		}
	} // End of win2



    // Anonymous inner class for the "outer" window
    ActionListener bl = new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		if (((JButton)e.getSource()).getText().equals("Show")) {
		    w2.setVisible(true);
		    txt.setText("Showing window 2");
		} else {
		    w2.setVisible(false);	
		    txt.setText("Hiding window 2");
		} // end of else
	    }
	};
    
    public newWindowVer2() {
		b1.addActionListener(bl);
		b2.addActionListener(bl);
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(b1); cp.add(b2);	cp.add(txt); pack();
		setVisible(true);
		setTitle("newWindow");

		w2.setVisible(false);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

		newWindowVer2 e1 = new newWindowVer2();
    }
}
