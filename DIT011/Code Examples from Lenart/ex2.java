import java.awt.*;
import javax.swing.*;

public class ex2 extends JFrame {
    JButton b1 = new JButton("No 1");
    JLabel t1 = new JLabel("TeXt");
    JButton b2 = new JButton("THR33");
    JButton b3 = new JButton("Four");
    JButton b4 = new JButton("FIVE");
    JPanel p1 = new JPanel();

    public ex2() {
		GridBagLayout m = new GridBagLayout();
		Container c = (Container) getContentPane();
	
		p1.setBackground(Color.white);
		p1.setPreferredSize(new Dimension(100, 50));
		
		c.setLayout(m);
		GridBagConstraints g1 = new GridBagConstraints();
	
		g1.gridx = 0; g1.gridy = 0;
		g1.insets = new Insets(0, 0, 5, 10);
		c.add(b1, g1);
		
		g1.gridx = 0; g1.gridy = 1;
		g1.insets = new Insets(5, 0, 5, 10);
		c.add(t1, g1);
	
		g1.gridx = 1; g1.gridy = 0;
		g1.gridwidth = 1; g1.gridheight = 2;
		g1.fill = GridBagConstraints.BOTH;
		c.add(p1, g1);
		
		g1.gridwidth = 1; g1.gridheight = 1;
		g1.gridx = 0; g1.gridy = 2;
		g1.insets = new Insets(0, 0, 5, 10);
		c.add(b2, g1);

		g1.gridx = 1; g1.gridy = 2;
		c.add(b3, g1);
	
		g1.gridx = 0; g1.gridy = 3;
		g1.insets = new Insets(0, 0, 5, 10);
		c.add(b4, g1);
		
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
		ex2 e2 = new ex2();
    } // end of main()
}
