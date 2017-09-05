
package menu;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

public class Menu {

    private static BufferedReader theirInput;
    private static List<GuiNode> theirNodelist = new ArrayList<GuiNode>();	
    private static JFrame theirFrame = new JFrame("Menu");

    /**
     * Read the file menu.txt and create the Tree node structure where
     * the nodes are instances of GuiNode
     */
    public static void Reader(){ 
        try {			
            theirInput = new BufferedReader(new FileReader("menu.txt"));
            String readLine ;		 
            // create GuiNode list
            while ((readLine = theirInput.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(readLine, ":");
                int id=0;
                int parentId=0;
                String nodeName = null;
                for (int i=0; i<3; i++) {
                    String ss = st.nextToken();
                    switch (i) {
                        case 0:
                            id = Integer.valueOf(ss);
                            break;
                        case 1:
                            parentId = Integer.valueOf(ss);
                            break;
                        case 2:
                            nodeName = ss;
                            break;
                        default: System.out.println("Error!!");
                    }
                }
                
                GuiNode gn = new GuiNode(nodeName, id);
                // add node to list
                if (!theirNodelist.contains(gn)) {
                    theirNodelist.add(gn);
                }
                if (parentId >= 0) {
                    // add node to parent
                    for (GuiNode node: theirNodelist) {
                        if (node.getId()==parentId) node.add(gn); 
                    }
                }


            }
            theirInput.close();
        }
		catch(IOException e)	{
            e.printStackTrace();
		}
		
        for (GuiNode node: theirNodelist) {
            System.out.println(node);
        }
	}

	/**
     * Read in the tree structure, install listener, 
     * build and show the app. Gui
     */
    public static void Tree() {

        Reader();
        
        //find root
        GuiNode root = null;

        for (GuiNode gn: theirNodelist) {
            if (gn.getId()==0) root = gn;
        }
        JTree tree = new JTree(root);
        // add a tree selection listener as an anonymous class,
        // common practice to do it this way.
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                //Object obj = e.getSource();
                Object obj = e.getPath().getLastPathComponent();
                if (obj instanceof GuiNode) {
                    GuiNode node = (GuiNode)obj;
                    if (node.isLeaf()) {
                        node.setNoOfMouseClicks(node.getNoOfMouseClicks()+1);
                        System.out.println(node);
                    }
                }
                else {
                    System.out.println("what did you click on ????");
                }
            }
        });

        theirFrame.add(tree);
        theirFrame.setUndecorated(true);
        theirFrame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        theirFrame.setSize(400,400);
        theirFrame.setVisible(true);
        theirFrame.setLocationRelativeTo(null);
        theirFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // handle close app event
        theirFrame.addWindowListener(new WindowAdapter(){
        @Override
        public void windowClosing(WindowEvent we){
            StringBuilder sb = new StringBuilder();
            // print total use of clicks on all nodes
            // only leafs should have value # 0
            // nb! the count is on node selection with the
            // left button, several times on the same node
            // is not counted. Seems hard to code using
            // an anonymous mouse listener !? And why ? These
            // are high level components not meant to be
            // used with java.awt listeners.
            sb.append("summary of mouse usage on leaf:\n");
            for (GuiNode node: theirNodelist) {
                sb.append(node+"\n");
            }
            JOptionPane.showMessageDialog(theirFrame,sb);
        }
        });
    }
	 
	/**
     * The main entry point of the application
     * @param args 
     */	
    public static void main(String[] args) {
        Tree();
    }

}
