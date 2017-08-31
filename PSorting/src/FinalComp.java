import java.io.PrintStream;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class FinalComp {
	
	
public static void selections() {
	
	
	//userinput
	int userinput = 0;
	String uinput;
	
	
	uinput = (String) JOptionPane.showInputDialog(null, "How many instances should the program sort?", "Java Sorting", JOptionPane.OK_CANCEL_OPTION, null, null, null);
	// Check the user's input
	
	if (uinput != null) 
		
    try {
    	userinput = Integer.parseInt(uinput);
        System.out.println(userinput + " instances it is!");
    }
    
    // illegal input found;
    catch(NumberFormatException nFE) {
        JOptionPane.showMessageDialog(null, "Only numbers allowed!", "ERROR", JOptionPane.ERROR_MESSAGE);
        main(null);
        return;
    }

	
	//Choices

    Object[] selectionValues = { "BubbleV1", "BubbleV2" , "Insertion", "Java built-in" };
    Object selection = JOptionPane.showInputDialog(null, "Sorting Types",
        "Java Sorting", JOptionPane.QUESTION_MESSAGE, null, selectionValues, null);
    
    //text gui
    
 
    JTextArea textArea = new JTextArea(20, 50);
    PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
    JFrame f = new JFrame("Output");
    JPanel center = new JPanel();
    f.getContentPane().add(center);
    JScrollPane scrollPane = new JScrollPane(textArea);
    center.add(scrollPane);
    System.setOut(printStream);
    System.setErr(printStream);
   // f.pack();
    f.setSize(600, 400);
    f.setVisible(true);
    
    
    
    if (selection != null) {
    //Start timing
	double startTime = System.currentTimeMillis();
	
	//Creating 10001 arrayIndexs 
	System.out.print("ArrayIndexes : their values \n\n");
    int[] arraysIndex = new int[userinput]; 
   
    for(int a = 0; a < arraysIndex.length; a++){
    
    //Give the created arrayIndexs random numbers upto 50000
        arraysIndex[a] = (int)(Math.random() * 50000);
        System.out.print("ArrayIndex[" +(a) + "]"+ " : " + arraysIndex[a] + "\n");
    }
    
    System.out.print("\nArrayIndexes : their values after sorted\n\n");
    
    
    for(int a = 0; a < arraysIndex.length; a++){            
    	
    
    if (selection == "Insertion" ) {
    	insertionSort(arraysIndex);
    	System.out.print("ArrayIndex[" +(a) + "]"+ " : " + arraysIndex[a] + "\n");      	
    }       
    else if (selection == "BubbleV1" ) {
    	bubbleSortV1(arraysIndex);
    	System.out.print("ArrayIndex[" +(a) + "]"+ " : " + arraysIndex[a] + "\n");
    }   
    else if (selection == "BubbleV2" ) {
    	bubbleSortV2(arraysIndex, arraysIndex.length);
    	System.out.print("ArrayIndex[" +(a) + "]"+ " : " + arraysIndex[a] + "\n");
    } 
    else if (selection == "Java built-in" ) {
    	Arrays.sort(arraysIndex);
    	System.out.print("ArrayIndex[" +(a) + "]"+ " : " + arraysIndex[a] + "\n");
    }      
    
    }
    

    
    
    
    
    Object a = "Elasped time: " + ((System.currentTimeMillis()-startTime))+" ms or " + ((System.currentTimeMillis()-startTime)) / 1000 + " s";    
    JOptionPane.showMessageDialog(null, a, "Elasped time", JOptionPane.INFORMATION_MESSAGE);
    //System.exit(0);
    
    }
    
    else {
    	System.exit(0);
    }
}


	
// Algorithms	
	
	//Bubble Sorting V1 which works perfectly
	
	public static void bubbleSortV1( int[] num ){
		
		int j;
	     boolean flag = true;   // set flag to true to begin first pass
	     int temp;   //holding variable

	     while ( flag )
	     {
	            flag= false;    //set flag to false awaiting a possible swap
	            for( j=0;  j < num.length -1;  j++ )
	            {
	                   if ( num[ j ] < num[j+1] )   // change to > for ascending sort
	                   {
	                           temp = num[ j ];                //swap elements
	                           num[ j ] = num[ j+1 ];
	                           num[ j+1 ] = temp;
	                          flag = true;              //shows a swap occurred  
	                  } 
	            } 
	      } 
}
	
	
	//Bubble Sorting V2
	//For this version, the difference between sorting 1000 arrays and 10000 arrays is enormous.
	// 1000 = up to 0,5 seconds
	// 10000 = up to 6 minutes

public static void bubbleSortV2( int a[], int b){	  
	
	int temp = 0; 
    for(int c = 0; c < b; c++){
    for(int d = 1; d < (b -c); d++){
    if( a[d - 1] > a[d]){
    temp = a[d - 1];
    a[d - 1] = a[d];
    a[d]=temp;
    
       }
     }
}
}

	//Insertion Sorting

	public static void insertionSort(int[] insert){

        for (int i = 1; i < insert.length; i++) {
              int newV = insert[i];
              int temp = i;

              while (temp > 0 && insert[temp - 1] > newV) {
                    insert[temp] = insert[temp - 1];
                    temp--;
              }
              insert[temp] = newV;
        }     
	}
	
	//First Interaction
	
	public static void main(String[] args) {
    selections();

    }
}

