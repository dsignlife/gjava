import java.awt.*;
import java.sql.*;
import java.util.*;
import java.awt.event.*;

import javax.swing.*;

class Search{
public static void main(String[] args) {
final Vector columnNames = new Vector();
final Vector data = new Vector();

JLabel lab=new JLabel("Enter Name:");
final JTextField t=new JTextField(20);
JButton b = new JButton("Search");
JPanel p = new JPanel(new GridLayout(2,2));
p.add(lab);
p.add(t);
p.add(b);
JFrame f = new JFrame();
f.getContentPane().add(p);
f.pack();
f.setVisible(true);

b.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
String name=t.getText();
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://db.student.chalmers.se/kotpho","kotpho","3kh948T6");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from itname where name='"+name+"'");
ResultSetMetaData md = rs.getMetaData();
int columns = md.getColumnCount();
for (int i = 1; i <= columns; i++) {
columnNames.addElement( md.getColumnName(i) );
}
while (rs.next()) {
Vector row = new Vector(columns);
for (int i = 1; i <= columns; i++){
row.addElement( rs.getObject(i) );
}
data.addElement( row );
}
JFrame frame=new JFrame();
JTable table = new JTable(data, columnNames);

JScrollPane pane=new JScrollPane(table);

frame.add(pane);
frame.setVisible(true);
frame.pack();
}
catch(Exception ex){
System.out.println(e);
}
}
});
}
}



//another

/*


import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;

public class Search {
public static void main(String[] args) {
Vector columnNames = new Vector();
Vector data = new Vector();
JPanel p=new JPanel();
try {
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DSS","root","root");
String sql = "Select * from itname";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery( sql );
ResultSetMetaData md = rs.getMetaData();
int columns = md.getColumnCount();
for (int i = 1; i <= columns; i++) {
columnNames.addElement( md.getColumnName(i) );
}
while (rs.next()) {
Vector row = new Vector(columns);
for (int i = 1; i <= columns; i++){
row.addElement( rs.getObject(i) );
}
data.addElement( row );
}
rs.close();
stmt.close();
}
catch(Exception e){
System.out.println(e);
}
JTable table = new JTable(data, columnNames);
TableColumn col;
for (int i = 0; i < table.getColumnCount(); i++) {
col = table.getColumnModel().getColumn(i);
col.setMaxWidth(250);
}
JScrollPane scrollPane = new JScrollPane( table );
p.add( scrollPane );
JFrame f=new JFrame();
f.add(p);
f.setSize(600,400);
f.setVisible(true);
}
}

*/