import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Parse {

	static int count = 0, 
			cal = 0,
			get = 0, 
			total = Integer.MAX_VALUE,
			tCost = 0,
			start,
			end;
	
    static int[]
    		nodeID = new int[500],
    		Pweight = new int[500],
            newNode = new int[500], 
            newPweight = new int [500];
    
	static Node[] NodeList;

    
    static String 
    		startinput, 
    		endinput, 
    		choice;

    
    
	public static void objectsBuilder(String path){

	    DocumentBuilderFactory dom = DocumentBuilderFactory.newInstance();
	try {
	     DocumentBuilder mapdata = dom.newDocumentBuilder();
	     Document doc = mapdata.parse(new FileInputStream(path));
	     Element root = doc.getDocumentElement();
	   
	     NodeList children = root.getChildNodes();
	   
	    NodeList nodes = children.item(1).getChildNodes(); 
	    NodeList = new Node[100000];
	   

	for (int i = 1; i < nodes.getLength();i+=2){
	    NamedNodeMap news = nodes.item(i).getAttributes();
	    
	    try{
	    	
	    	//nullify all (Unicode) characters that are neither letters nor numbers
	    	
	    int temp = Integer.parseInt(news.item(0).getNodeValue().replaceAll("[^\\p{L}\\p{N}]", ""));
	    NodeList[temp] = new Node();
	    NodeList[temp].id = Integer.parseInt(news.item(0).getNodeValue());
	    NodeList[temp].name = news.item(0).getNodeValue(); 
	    }catch (Exception er){
	   
	    }
	    get++;
	    }
	    get= 0;
	    
	    NodeList edges = children.item(5).getChildNodes();
	    Edge[] eArrays = new Edge[edges.getLength()];
	    for (int p = 0 ; p < edges.getLength();p++)
	        eArrays[p] = new Edge();
	    for(int q = 1 ; q < edges.getLength(); q += 2 ){
	    	
	    eArrays[get].name = edges.item(q).getAttributes().item(0).getNodeValue();
	    eArrays[get].weight = Integer.parseInt(edges.item(q).getAttributes().item(1).getNodeValue());
	   
	   NodeList a = edges.item(q).getChildNodes(); 
	   NamedNodeMap aList = a.item(0).getAttributes();
	   NamedNodeMap bList = a.item(1).getAttributes();
	   
	   NodeList
	   [Integer.parseInt(aList.item(0).getNodeValue())].Children.add(eArrays[get]);
	   NodeList
	   [Integer.parseInt(bList.item(0).getNodeValue())].Children.add(eArrays[get]);
	   
	// node the objects to edges
	   
	    eArrays[get].Nodes[0] = 
	    		NodeList[Integer.parseInt(aList.item(0).getNodeValue())] ;
	    eArrays[get].Nodes[1] = 
	    		NodeList[Integer.parseInt(bList.item(0).getNodeValue())];

	    get++;
	     }
	  

	}catch (ParserConfigurationException e) {
	    e.printStackTrace();
	}catch (SAXException e) {
	    e.printStackTrace();
	}catch (IOException e) {
	    e.printStackTrace();
	}catch (NumberFormatException nfe ) {
	   }
	
return;

	}
	private static void savePath (int n ,int w,int cal){

	    for (int i = (cal) ; i < nodeID.length;i++){
	        nodeID[i] = 0;
	        Pweight[i] = 0;

	    }


	nodeID[cal] = n;
	Pweight[cal] = w;

	}
	
	// USER INPUTS
	
		static void startInput(){

		startinput = (String) JOptionPane.showInputDialog(null, "ENTER STARTNODE", "NODE", JOptionPane.OK_CANCEL_OPTION);

	    if (startinput != null) {
	    	
	    	try {
	    		 start = Integer.parseInt(startinput);
	    	}
	    	
		    catch(NumberFormatException nFE) {
		        JOptionPane.showMessageDialog(null, "Only numbers allowed!", "ERROR", JOptionPane.ERROR_MESSAGE);
		        System.exit(0);
		    }
	    }
	      
	    if (NodeList[start] == null){
	    	JOptionPane.showMessageDialog(null, "THE STARTNODE DOESN'T EXIST", "ERROR", JOptionPane.ERROR_MESSAGE);
	    	System.exit(0);
	    }
	    
	    endInput();
}
	
		static void endInput(){
	

	    endinput = (String) JOptionPane.showInputDialog(null, "ENTER ENDNODE", "NODE", JOptionPane.OK_CANCEL_OPTION);   
	    
	    
	    if (startinput != null) {
	    	
	    	try {
	    		end = Integer.parseInt(endinput);
	    	}
	    	
		    catch(NumberFormatException nFE) {
		        JOptionPane.showMessageDialog(null, "Only numbers allowed!", "ERROR", JOptionPane.ERROR_MESSAGE);
		        System.exit(0);
		        
		    }
	    }
	       
	    if (NodeList[end] == null){
	    	JOptionPane.showMessageDialog(null, "THE ENDNOTE DOESN'T EXIST", "ERROR", JOptionPane.ERROR_MESSAGE);
	    	System.exit(0);
	        
	    }
	    
	    aChoices();
}

		static void aChoices(){
	

	    Object[] selectionValues = { "Dijkstra", "Minimum Spanning Tree"};
	    Object selection = JOptionPane.showInputDialog(null, "Choose Algorithms", "NODE", JOptionPane.QUESTION_MESSAGE, null, selectionValues, null);
	    
	    if (selection == "Dijkstra" ) {
    	
            Djikstra(start, end, 0, 0, cal);
            for ( int i = 0 ; i < newNode.length; i++){
                if (newNode[i] != 0 && newPweight[i] <= total )
                	

                	JOptionPane.showMessageDialog(null, "TO Node: " + newNode[i] + " UP TO: " + newPweight[i] + " MS", "Djikstra", JOptionPane.INFORMATION_MESSAGE);
                
            }
            JOptionPane.showMessageDialog(null,"TOTAL OF " + total + " MS", "Djikstra", JOptionPane.INFORMATION_MESSAGE);
            
	    }    
	    
	    else if (selection == "Minimum Spanning Tree" ) {

	    	mst(start,end);
	    	System.out.println("Cost of minimum spanning tree is " + tCost);
	    }  
	    
	    else {
	    	System.exit(0);
	    }
	
}


	// ALGORITHMS
	
	public static void mst(int c,int endNode){
	    if (c == endNode){
	        
	        JOptionPane.showMessageDialog(null,"TOTAL OF " + tCost + " MS", "MST", JOptionPane.INFORMATION_MESSAGE);        
	    }
	    
	System.out.println("AS" + NodeList[c].name + " current cost: " + tCost );
	NodeList[c].visited = true;
	int[] temp = new int[NodeList[c].Children.size()];
	for (int i = 0; i<NodeList[c].Children.size();i++){
	 temp[i] = NodeList[c].Children.get(i).weight;
	    }
	
	insertionSort(temp);
	
	for (int u = 0;u < NodeList[c].Children.size();u++){
	    for (int g = 0 ; g < temp.length;g++)
	    if ( NodeList[c].Children.get(u).weight == temp[g]){
	        
	        for (int gi= 0 ; gi < NodeList[c].Children.get(u).Nodes.length;gi++ ){
	            if ( NodeList[c].Children.get(u).Nodes[gi].visited == false ){
	            	tCost += NodeList[c].Children.get(u).weight;
	        mst(NodeList[c].Children.get(u).Nodes[gi].id,endNode);
	            }
	        }

	  }
	}
	}

	private static void insertionSort(int[] insert){

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
	
	private static void Djikstra(int curr,int end,int weight,int prev, int cal){ 

	    if (curr == end){
	        if (weight< total){
	            total = weight;
	            savePath(curr,weight,cal);
	            for (int i = 0 ; i < nodeID.length;i++){
	             newNode[i] = nodeID[i];
	             newPweight[i] = Pweight[i];
	            }

	            
	        
	        }
	 }
	    else	{
	   
	   savePath(curr,weight,cal);
	   NodeList[curr].visited = true;


	   for (int i = 0 ; i < NodeList[curr].Children.size();i++){
	       for (int u = 0 ; u < NodeList[curr].Children.get(i).Nodes.length;u++){
	           
	           if (NodeList[curr].Children.get(i).Nodes[u].id != NodeList[curr].id &&
	                   NodeList[curr].Children.get(i).Nodes[u].id != prev &&
	                   NodeList[curr].Children.get(i).Nodes[u].visited != true ){
	savePath(curr,weight,cal);
	               Djikstra(NodeList[curr].Children.get(i).Nodes[u].id, end, weight +=
	                       NodeList[curr].Children.get(i).weight,prev = curr, cal++);
	           }
	    	           }
	   }
	  }
}
}
