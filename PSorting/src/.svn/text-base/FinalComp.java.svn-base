import java.util.Arrays;
import javax.swing.JOptionPane;


public class FinalComp {
	
	/**
	 * @author ToMz
	 * @param args
	 */
	
public static void selections() {
	
	//Choices

    Object[] selectionValues = { "BubbleV1", "BubbleV2" , "Insertion", "Java built-in" };
    Object selection = JOptionPane.showInputDialog(null, "Sorting Types",
        "Java Sorting", JOptionPane.QUESTION_MESSAGE, null, selectionValues, null);
    
    if (selection != null) {
    //Start timing
	double startTime = System.currentTimeMillis();
	
	//Creating 10001 arrayIndexs 
	System.out.print("ArrayIndexes : their values \n\n");
    int[] arraysIndex = new int[10001]; 
   
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
    System.exit(0);
    
    }
    
    else {
    	System.exit(0);
    }
}

	
// Algorithms	
	
	//Bubble Sorting V1 which works perfectly
	
	public static void bubbleSortV1( int[] bubble ){
		
	      boolean swap = true;
	      int b = 0;
	      
	      if (swap) {
	            swap = false;
	            b++;

	            for (int a = 0; a < bubble.length - b; a++) {                                       
	            	if (bubble[a] > bubble[a + 1]) {                          
	                        int temp = bubble[a];
	                        bubble[a] = bubble[a + 1];
	                        bubble[a + 1] = temp;
	                        swap = true;
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

