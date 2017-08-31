import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import javax.swing.tree.*;

public class Menu {

	/**
	 * @param args
	 */
static int SelfService  = 0;
static int countBuy = 0;
static int countSell = 0;
static int countTransfer = 0;
static int countWithdraw = 0;
static int countDeposit = 0;
static int countSaldo1 = 0;
static int countTransaction1 = 0;
static int countSaldo2 = 0;
static int countTransaction2 = 0;
static int countOverview = 0;
static int countTakeNew = 0;

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
		 }
		input.close();
			}
		
		catch(IOException e)	{		
		System.err.println("There was a problem:" + e);	
		}
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

	final JTree tree = new JTree(root);

	frame.add(tree);
	frame.setUndecorated(true);
	frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
	frame.setSize(400,450);
	frame.setVisible(true);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
	
	MouseListener ml = new MouseAdapter() {
	     public void mousePressed(MouseEvent e) {
	         int selRow = tree.getRowForLocation(e.getX(), e.getY());
	         TreePath selPath = tree.getPathForLocation(e.getX(), e.getY());
	         if(selRow != -1) {
	             if(e.getClickCount() == 1) {
	                 mySingleClick(selRow, selPath);
	                
	             }
	             else if(e.getClickCount() == 2) {
	                 myDoubleClick(selRow, selPath);
	             }
	         }
	     }

		private void mySingleClick(int selRow, TreePath selPath) {
			
			String checkPath = "";
			checkPath = selPath.toString();
			
    if(checkPath.contains("5:4:Buy (leaf)")){
		countBuy++;
	}
			
	if(checkPath.contains("6:4:Sell (leaf)")){
		countSell++;
	}

	if (checkPath.contains ("10:8:Saldo (leaf)")){
		countSaldo1++;
	}

	if (checkPath.contains("11:8:Transactions (leaf)")){
		countTransaction1++;
	}
	
	if (checkPath.contains("12:9:Saldo (leaf")){
		countSaldo2 ++;
	}
	
	if (checkPath.contains ("13:9:Transactions (leaf)")){
		countTransaction2++;
	}

	if (checkPath.contains("14:7:Transfer (leaf)")){
		countTransfer++;
	}

	if (checkPath.contains("15:7:Withdraw (leaf)" )){
		countWithdraw ++;
	}

	if (checkPath.contains("16:7:Deposit (leaf)")){
        countDeposit ++;		
	}
	
	if (checkPath.contains("18:17:Overview (leaf)")){
		countOverview++;
	}
	
	if (checkPath.contains("19:17:Take new (leaf)")){
		countTakeNew++;
	}
	
	SelfService = countBuy + countSell + countTransfer + countTransfer + countDeposit + countSaldo1 + countTransaction1 + countSaldo2 + countTransaction2 + countOverview + countTakeNew;

		}

		private void myDoubleClick(int selRow, TreePath selPath) {
		}
	 };
	 tree.addMouseListener(ml);
	 

	 frame.addWindowListener(new WindowAdapter(){
		  public void windowClosing(WindowEvent we){
			  JOptionPane.showMessageDialog(frame,"Self Services was clicked: " + SelfService + " times"
					  + "\n\nStockmarket/Buy: " + countBuy
					  + "\nStockmarket/Sell: " + countSell
					  + "\nAccounts/Current/Saldo: " + countSaldo1
					  + "\nAccounts/Current/Transactions: " + countTransaction1
					  + "\nAccounts/Savings/Saldo: " + countSaldo2
					  + "\nAccounts/Savings/Transactions: " + countTransaction2
					  + "\nAccounts/Transfer: " + countTransfer
					  + "\nAccounts/Withdraw: " + countWithdraw
					  + "\nAccounts/Deposit: " + countDeposit
					  + "\nLoans/Overview: " + countOverview
					  + "\nLoans/Takenew: " + countTakeNew

					  , "Overview", JOptionPane.PLAIN_MESSAGE);
			  System.exit(0);
				   } 
	 
		  });
		  }

	
	public static void main(String[] args) {
		Tree();
	}
		
}
	
	

