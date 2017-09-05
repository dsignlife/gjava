/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * A TreeNode that has a node name, id, and
 * a field to save the number of mouse clicks
 */
public class GuiNode 
    extends DefaultMutableTreeNode {
    
    private String itsNodeName = "".intern();
    private int itsId;
    private int itsNoOfMouseClicks = 0;
    
    /**
     * Constructor
     * @param pName
     * @param pId 
     */
    public GuiNode(String pName, int pId) {
        itsNodeName = pName;
        itsId = pId;
    }
    
    /**
     * Get the Id
     * @return the node's Id
     */
    public int getId() {return itsId;}
    
    /**
     * Get the Node Name
     * @return the node's name
     */
    public String getNodeName() { return itsNodeName; }
    
    /**
     * Get no of mouse clicks
     * @return the no of mouse clicks
     */
    public int getNoOfMouseClicks() {
        
        return itsNoOfMouseClicks; 
    }
    
    /**
     * Set the no of mouse clicks
     * @param pNoOfClicks the no of mouse clicks
     */
    public void setNoOfMouseClicks(int pNoOfClicks) { 
        itsNoOfMouseClicks = pNoOfClicks;
    }
    
    /**
     * Override to print a String suitable for this exercise
     * @return the String representation of the GuiNode
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("nodeName: ").append(itsNodeName).append(" id: ").
                append(String.valueOf(itsId)).append(" # mouse clicks:").
                append(String.valueOf(getNoOfMouseClicks()));
        return sb.toString();
    }
}
