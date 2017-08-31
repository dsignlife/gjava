import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Serpinski extends JComponent {  
	
	/**
	 * @author ToMz&LB
	 * @param args
	 */
	private static ImageIcon icon = new ImageIcon("images/Serpinski.gif");
	private static String uinput;
	private static int recurs;
	
	
    public static void main(String[] args) {
    	
    	// Create a JFrame
    	
    	JFrame main = new JFrame();
    	
    	// USER's input
 
    	uinput = (String) JOptionPane.showInputDialog(null, "How many recursions should the program make?", "Serpinski Creator", JOptionPane.OK_CANCEL_OPTION, icon, null, null);
    	
    	// Check the user's input
    	if (uinput != null) {
    		
	    try {
	        recurs = Integer.parseInt(uinput);
	        System.out.println(uinput + " Recursions it is!");
	        if(recurs > 8){
	    		JOptionPane.showMessageDialog(null, "To high amount of recursions, try a number below 9", "ERROR", JOptionPane.ERROR_MESSAGE);
		        main(null);
		        return;
	    	}
	    }
	    
	    // illegal input found;
	    catch(NumberFormatException nFE) {
	        JOptionPane.showMessageDialog(null, "Only numbers allowed!", "ERROR", JOptionPane.ERROR_MESSAGE);
	        main(null);
	        return;
	    }
	    
    	}
    	
    	// cancel button = exit
	    else {
	    	System.exit(0);
	    }
    	
    	// JFrames specifications
        main.setSize(530, 428);
        main.getContentPane().add(new Serpinski());
        main.setTitle("Serpinski Creator");
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);
        main.setLocationRelativeTo(null);
    }
    
    

    // 
    Polygon poly = new Polygon();
    public void drawTriangle(Graphics u, int x1, int y1, int x2, int y2, int x3, int y3, int r)  {
    	
    	boolean check = true;	
    	
    	if(r > 0) {
    		
    		check = false;
    		
    	} 
    		
    	while (check){ // If r = 0, Creates the Base5 triangle, with the values that the paint methods have.
    		
         u.drawLine(x1, y1, x2, y2); //The first line
         u.drawLine(x2, y2, x3, y3); //The Second line
         u.drawLine(x3, y3, x1, y1); //The third line 
         	

            return;
            

       }
    	
    
      //Creates three smaller triangles by finding the midpoints from the previous triangle.
  
      //First small triangle
      int topX = (x1 + x2) / 2;  // The midpoint of the line between coordinates x1 and x2
      int topY = (y1 + y2) / 2;  // The midpoint of the line between coordinates y1 and y2
      // Second small triangle  
      int leftX = (x1 + x3) / 2;  // The midpoint of the line between coordinates x1 and x3
      int leftY = (y1 + y3) / 2;  // The midpoint of the line between coordinates y1 and x3
      // Third small triangle
      int rightX = (x2 + x3) / 2;  // The midpoint of the line between coordinates x2 and x3
      int rightY = (y2 + y3) / 2;  // The midpoint of the line between coordinates y2 and y3
      
      //Draw 3 new Triangles, starting at the midpoints of the previous triangle, the r - 1 is to prevent the stackOverflow exception caused when only writing "r".
      
      drawTriangle(u, x1, y1, topX, topY, leftX, leftY, r - 1); // Drawing TOP Triangle(s)
      
      drawTriangle(u, topX, topY, x2, y2, rightX, rightY, r - 1); // Drawing Bottom Left Triangle(s)
      
      drawTriangle(u, leftX, leftY, rightX, rightY, x3, y3, r - 1); // Drawing Bottom Right Triangle(s)
     
    }

    public void paint(Graphics c)       {
 
        // size of the base triangle and plus its recursions
        drawTriangle(c, 255, 0, 0, 383, 511, 383, recurs);
        
     }    
    
}        