import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import javax.swing.tree.*;

public class Menu {

	/**
	 * @author ToMz
	 * @param args
	 */

private static BufferedReader input;

private static String[] store;	

private static JFrame frame = new JFrame("Menu");

	public static void Reader(){ 

			
		String thisLine = "";
		int i = 0;
		store = new String[20];
		
		try {
			
		input = new BufferedReader(new FileReader("menu.txt"));
		 
		 while ((thisLine = input.readLine()) != null)    {
			  
			  
			  store[i] = thisLine;
			  i++;
			  System.out.println (thisLine);
			  
		 }
		input.close();
			}
		
		catch(IOException e)	{		
		System.err.println("There was a problem:" + e);	
		}
		
		System.out.println("Those in arrays");
		
        for (i = 0; i < store.length; i++)
            System.out.println("ArrayIndex[" +(i) + "] has " + store[i]);
	}

	
	public static void Tree() {
		Reader();
	
	DefaultMutableTreeNode root = new DefaultMutableTreeNode(store[0], true);
	DefaultMutableTreeNode Self = new DefaultMutableTreeNode(store[1], true);
	DefaultMutableTreeNode Per = new DefaultMutableTreeNode(store[2], true);
	DefaultMutableTreeNode Dis = new DefaultMutableTreeNode(store[3], true);
	DefaultMutableTreeNode Stock = new DefaultMutableTreeNode(store[4], true);
	DefaultMutableTreeNode Acc = new DefaultMutableTreeNode(store[7], true);	
	DefaultMutableTreeNode Buy = new DefaultMutableTreeNode(store[5], true);
	DefaultMutableTreeNode Sell = new DefaultMutableTreeNode(store[6], true);
	DefaultMutableTreeNode Current = new DefaultMutableTreeNode(store[8], true);
	DefaultMutableTreeNode Savings = new DefaultMutableTreeNode(store[9], true);
	DefaultMutableTreeNode Saldo = new DefaultMutableTreeNode(store[10], true);
	DefaultMutableTreeNode Trans = new DefaultMutableTreeNode(store[11], true);
	DefaultMutableTreeNode Saldo2 = new DefaultMutableTreeNode(store[12], true);
	DefaultMutableTreeNode Trans2 = new DefaultMutableTreeNode(store[13], true);
	DefaultMutableTreeNode Transfer = new DefaultMutableTreeNode(store[14], true);
	DefaultMutableTreeNode Withdraw = new DefaultMutableTreeNode(store[15], true);
	DefaultMutableTreeNode Deposit = new DefaultMutableTreeNode(store[16], true);
	DefaultMutableTreeNode Loans = new DefaultMutableTreeNode(store[17], true);
	DefaultMutableTreeNode Overview = new DefaultMutableTreeNode(store[18], true);
	DefaultMutableTreeNode Take = new DefaultMutableTreeNode(store[19], true);
	

	
	root.add(Self);
	root.add(Per);
	root.add(Dis);
	Self.add(Stock);
	Self.add(Acc);
	Acc.add(Current);
	Acc.add(Savings);
	Acc.add(Transfer);
	Acc.add(Withdraw);
	Acc.add(Deposit);
	Acc.add(Loans);
	Current.add(Saldo);
	Current.add(Trans);
	Savings.add(Saldo2);
	Savings.add(Trans2);
	Loans.add(Overview);
	Loans.add(Take);
	Stock.add(Buy);
	Stock.add(Sell);

	JTree tree = new JTree(root);
	
	frame.add(tree);
	frame.setUndecorated(true);
	frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
	frame.setSize(400,450);
	frame.setVisible(true);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	

	 frame.addWindowListener(new WindowAdapter(){
		  public void windowClosing(WindowEvent we){
			  JOptionPane.showMessageDialog(frame,"Saldo: " /*+ [its array]*/ 
					  + /*[its array] +*/ "\nOverview: " 
					  + /*[its array] +*/ "\nSelf Service: ", "Overview", JOptionPane.PLAIN_MESSAGE);
			  System.exit(0);
		  }
		  });
		  }
	 
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Tree();
	}

}
