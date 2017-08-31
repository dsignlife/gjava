import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Serpinski extends JComponent {  
	
	
	private static ImageIcon icon = new ImageIcon("images/Serpinski.gif");
	private static String uinput;
	private static String uinputsize;
	private static int recurs;
	private static double size;
	

    
    public static void inputRe() {
    	
       	// USER's input
    	 
    	uinput = (String) JOptionPane.showInputDialog(null, "How many recursions should the program make?", "Serpinski Creator", JOptionPane.OK_CANCEL_OPTION, icon, null, null);
    	// Check the user's input
    	
    	if (uinput != null) 
    		
	    try {
	        recurs = Integer.parseInt(uinput);
	        System.out.println(uinput + " Recursions it is!");
	    }
	    
	    // illegal input found;
	    catch(NumberFormatException nFE) {
	        JOptionPane.showMessageDialog(null, "Only numbers allowed!", "ERROR", JOptionPane.ERROR_MESSAGE);
	        main(null);
	        return;
	    }

	    else {
	    	System.exit(0);
	    }
    	
    	inputSize();
    }
    
    
    public static void inputSize() {
    	
    	uinputsize = (String) JOptionPane.showInputDialog(null, "How large should it be in percentage (Example: 100)", "Serpinski Creator", JOptionPane.OK_CANCEL_OPTION, icon, null, null);
    	
    		if (uinputsize != null)
    		
	    try {
	        size = Double.parseDouble(uinputsize);
	        System.out.println(uinputsize + " % it is!");
	    }
	    catch(NumberFormatException nFE) {
	        JOptionPane.showMessageDialog(null, "Only numbers allowed!", "ERROR", JOptionPane.ERROR_MESSAGE);
	        inputSize();
	        return;
	    }  	
    		
	    else {
	    	System.exit(0);
	    }
    		}
    

    // 
    public void CSerpinski(Graphics u, int a, int b, int c, int d, int e, int f, int g)  {
    	
    	boolean check = true;	
    	
    	if(g > 0) {
    		
    		check = false;
    		
    	}
    	
    	while (check){ // If r = 0, Creates the First triangle, with the values that the paint methods have.
       
         u.drawLine(a, b, c, d); //The first line    
         u.drawLine(c, d, e, f); //The Second line
         u.drawLine(e, f, a, b); //The third line 
         	
            return;

       }
    	
    
    	//Creates three smaller triangles by finding the midpoints from the previous triangle.
        
      //First small triangle
      int xa = (a + c) / 2;  // The midpoint of the line between coordinates x1 and x2
      int ya = (b + d) / 2;  // The midpoint of the line between coordinates y1 and y2
      
      
      // Second small triangle  
      int xb = (a + e) / 2;  // The midpoint of the line between coordinates x1 and x3
      int yb = (b + f) / 2;  // The midpoint of the line between coordinates y1 and x3
      // Third small triangle
      int xc = (c + e) / 2;  // The midpoint of the line between coordinates x2 and x3
      int yc = (d + f) / 2;  // The midpoint of the line between coordinates y2 and y3
      
      //Draw 3 new Triangles, starting at the midpoints of the previous triangle, the g - 1 is to prevent the stackOverflow exception caused when only writing "g".
      
      CSerpinski(u, a, b, xa, ya, xb, yb, g - 1); // Drawing TOP Triangle(s)
      CSerpinski(u, xa, ya, c, d, xc, yc, g - 1); // Drawing Buttom Left Triangle(s)
      CSerpinski(u, xb, yb, xc, yc, e, f, g - 1); // Drawing Buttom Right Triangle(s)
    }

    public void paint(Graphics c)       {
 
    	double aa = 255*(size/100);
    	double bb = 383*(size/100);
    	double cc = 511*(size/100);
    	double dd = 383*(size/100);
    	
    	 int aaa = (int)aa;
    	 int bbb = (int)bb;
    	 int ccc = (int)cc;
    	 int ddd = (int)dd;
    	 
        // the size of the triangle and plus its recursions
    	c.setColor(Color.RED);
        CSerpinski(c, aaa, 0, 0, bbb, ccc, ddd, recurs);
        //CSerpinski(c, 255, 0, 0, 383, 511, 383, recurs);
        
     }

	
    public static void main(String[] args) {	
    	// Create a JFrame
    	inputRe();
    	
    	JFrame main = new JFrame();

    	// JFrames specifications
    	

    	// Not effective but it's good for now.
    	double y = (530*size)/100;
    	double x = (428*size)/100;
    	
    	int yy = (int)y;
    	int xx = (int)x;   	
        main.setSize(yy, xx);
    	
        main.getContentPane().add(new Serpinski());
        main.setTitle("Serpinski Creator");
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);
        main.setLocationRelativeTo(null);
    }
}        