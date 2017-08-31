import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Reader {
	
	public static String Chooser(){

	    JFileChooser getxml = new JFileChooser();
	    getxml.setAcceptAllFileFilterUsed(false);
	    getxml.setDialogTitle("Select XML filen");
	    getxml.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("xml", "xml"));
	    int cancel = getxml.showOpenDialog(null);
	    if (cancel != JFileChooser.APPROVE_OPTION){
	    	JOptionPane.showMessageDialog(null, "Session Terminated", "Closing", JOptionPane.INFORMATION_MESSAGE);
	        System.exit(0);
	    }
	    
	   String filepath = getxml.getSelectedFile().getAbsolutePath();
	return filepath;
	
	}
}
