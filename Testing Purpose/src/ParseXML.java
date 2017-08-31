
import java.io.*;
import java.util.Scanner;
import javax.swing.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import java.util.*;

public class ParseXML {
    int get = 0,min = Integer.MAX_VALUE,treecost = 0;
    int count=0,counter= 0;
    int[] num,historyID = new int[200],Historywheight = new int[200],
            final1 = new int[200],final2 = new int [200];

    String g = "",fast = "",cost = "";
    Node[] NodeLista;

    ArrayList<String> history = new ArrayList<String>();
    ArrayList<String> historyFinal = new ArrayList<String>();
    public void runParse(){
        String path =Chooser();
        buildObjects(path);
        search();


    }
    
   
  
private void buildObjects(String path){

    DocumentBuilderFactory dom = DocumentBuilderFactory.newInstance();
try {
     DocumentBuilder pellefant = dom.newDocumentBuilder();
     Document doc = pellefant.parse(new FileInputStream(path));
     Element root = doc.getDocumentElement();
   
     NodeList children = root.getChildNodes();
   
    NodeList nodenames = children.item(1).getChildNodes(); 
    NodeLista = new Node[100000];
   

for (int i = 1; i < nodenames.getLength();i+=2){
    NamedNodeMap duude = nodenames.item(i).getAttributes();
    try{
    int temp = Integer.parseInt(duude.item(0).getNodeValue().replaceAll("[^\\p{L}\\p{N}]", ""));
    NodeLista[temp] = new Node();
    NodeLista[temp].id = Integer.parseInt(duude.item(0).getNodeValue());
    NodeLista[temp].name = "WWW" + duude.item(0).getNodeValue(); 
    }catch (Exception er){
   
    }
    get++;
    }
    get= 0;
    
    NodeList edges = children.item(5).getChildNodes();
    Edge[] edgearray = new Edge[edges.getLength()];
    for (int t = 0 ; t< edges.getLength();t++)
        edgearray[t] = new Edge();
    System.out.println(edgearray.length);
    for(int g = 1 ; g < edges.getLength();g+=2){
    edgearray[get].name = edges.item(g).getAttributes().item(0).getNodeValue();
    edgearray[get].weight = Integer.parseInt(edges.item(g).getAttributes().item(1).getNodeValue());
   NodeList gg = edges.item(g).getChildNodes(); 
   NamedNodeMap test = gg.item(0).getAttributes();
   NamedNodeMap test2 = gg.item(1).getAttributes();
   
   NodeLista[Integer.parseInt(test.item(0).getNodeValue())].Children.add(edgearray[get]);
   NodeLista[Integer.parseInt(test2.item(0).getNodeValue())].Children.add(edgearray[get]);
   
   System.out.println(test.item(0).getNodeValue());
    System.out.println(test2.item(0).getNodeValue());
    edgearray[get].Nodes[0] = NodeLista[Integer.parseInt(test.item(0).getNodeValue())] ; // set node objects to edges
    edgearray[get].Nodes[1] = NodeLista[Integer.parseInt(test2.item(0).getNodeValue())];

    get++;
     }
    System.out.println(NodeLista[80].name +" " +NodeLista[80].Children.get(0).name );
  

} catch (ParserConfigurationException e) {
    e.printStackTrace();
}catch (SAXException e) {
    e.printStackTrace();
}catch (IOException e) {
    e.printStackTrace();
} catch (NumberFormatException er) {
System.out.println("Error");
System.exit(0);
   }

}
private void savePath (int id ,int wheight,int counter){

    for (int i = (counter) ; i < historyID.length;i++){
        historyID[i] = 0;
        Historywheight[i] = 0;

    }


historyID[counter] = id;
Historywheight[counter] = wheight;



}
private String Chooser(){

    JFileChooser fc = new JFileChooser();
    fc.setAcceptAllFileFilterUsed(false);
    fc.setDialogTitle("Select the XML file");
    fc.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("xml files", "xml"));
    int resultat = fc.showOpenDialog(null);
    if (resultat != JFileChooser.APPROVE_OPTION){
        JOptionPane.showMessageDialog(null, "please pick a file!!!!!");
        System.exit(0);
    }
   String filnamn = fc.getSelectedFile().getAbsolutePath();
return filnamn;
}
private void search(){

    Scanner scan = new Scanner(System.in);
    System.out.println(" startnode:");
    int start = Integer.parseInt(scan.next());
    if (NodeLista[start] == null){
        System.out.println("not exist");
        search();
    }

    System.out.println("endnode:");
    int end = Integer.parseInt(scan.next());
    if (NodeLista[end] == null){
        System.out.println("Node did not exist.. exit");
        search();
    }
    System.out.println("What algoritm do you whant to use?:\n"
            + "1 : Dijkstras algorithm\n"
            + "2 : Minimum Spanning Tree");
    int alg = Integer.parseInt(scan.next());
    scan.close();
    switch (alg){
        case 1:
         
            runDjikstra(start,end,0,0,counter);
            System.out.println("Fastest path .. adding the wheight to the goal:");
            for ( int i = 0 ; i < final1.length; i++){
                if (final1[i] != 0 && final2[i] <= min )
            System.out.println("NodeID: " + final1[i] + " wheight: " + final2[i]);
            }
            System.out.println("Best wheight is " + min);
            
            break;
        case 2:
shortestSpawn(start,end);
System.out.println("Cost of minimum spanning tree is " + treecost);
System.out.println(cost);
            break;

    



    }
}

public void shortestSpawn(int current,int End){
    if (current == End){
        cost = "Reached endnode with spanning thee cost " + treecost;
    }
System.out.println("Node " + NodeLista[current].name + " current cost: " +treecost );
NodeLista[current].visited = true;
int[] temp = new int[NodeLista[current].Children.size()];
for (int i = 0; i<NodeLista[current].Children.size();i++){
 temp[i] = NodeLista[current].Children.get(i).weight;
    }
Arrays.sort(temp);
for (int u = 0;u < NodeLista[current].Children.size();u++){
    for (int g = 0 ; g < temp.length;g++)
    if ( NodeLista[current].Children.get(u).weight == temp[g]){
        
        for (int gi= 0 ; gi < NodeLista[current].Children.get(u).Nodes.length;gi++ ){
            if ( NodeLista[current].Children.get(u).Nodes[gi].visited == false ){
                treecost += NodeLista[current].Children.get(u).weight;
        shortestSpawn(NodeLista[current].Children.get(u).Nodes[gi].id,End);
            }
        }

  }
}
}

private void runDjikstra(int current,int end,int wheight,int prev,int counter){

    if (current == end){
        if (wheight< min){
            min = wheight;
            savePath(current,wheight,counter);
            for (int i = 0 ; i < historyID.length;i++){
             final1[i] = historyID[i];
             final2[i] = Historywheight[i];
            }

            
        
        }
 }else{
   
   savePath(current,wheight,counter);
   NodeLista[current].visited = true;


   for (int i = 0 ; i < NodeLista[current].Children.size();i++){
       for (int u = 0 ; u < NodeLista[current].Children.get(i).Nodes.length;u++){
           
           if (NodeLista[current].Children.get(i).Nodes[u].id != NodeLista[current].id &&
                   NodeLista[current].Children.get(i).Nodes[u].id != prev &&
                   NodeLista[current].Children.get(i).Nodes[u].visited != true ){
savePath(current,wheight,counter);
               runDjikstra(NodeLista[current].Children.get(i).Nodes[u].id,end,wheight +=
                       NodeLista[current].Children.get(i).weight,prev = current,counter++);
               
           }
    
           }

   }
    }
}


}
