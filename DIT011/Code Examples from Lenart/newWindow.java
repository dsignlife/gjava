import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class newWindow extends JFrame {
    JButton b1 = new JButton("Show");
    JButton b2 = new JButton("Hide");
    JTextField txt = new JTextField(10);
  
    JFrame win2 = new JFrame();

    // Anonymous inner class
    ActionListener bl = new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		if (((JButton)e.getSource()).getText().equals("Show")) {
		    win2.setVisible(true);
		    txt.setText("Showing window 2");
		} else {
		    win2.setVisible(false);	
		    txt.setText("Hiding window 2");
		} // end of else
	    }
	};
    
    public newWindow() {
		b1.addActionListener(bl);
		b2.addActionListener(bl);
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(b1); cp.add(b2);	cp.add(txt); pack();
		setVisible(true);
		setTitle("newWindow");

		win2.setPreferredSize(new Dimension(350, 100)); win2.pack();
		win2.setTitle("myNewWindow");
		win2.setVisible(false);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
	newWindow e1 = new newWindow();
    }
}
