package template;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import app.TheApp;

import calculate.Flight;
import calculate.Places;

@SuppressWarnings("serial")
public class ResultPage extends JFrame{ 
	
	private JEditorPane informationLabel;
	private JEditorPane placesLable;
	private JButton nextStep;
	private JButton previousStep;
	private JButton home;
	private JPanel buttonPanel = new JPanel (new  GridLayout(1,3,40,20));
	private JPanel lablePanel = new JPanel (new GridLayout(1,2,2,2));
	private JPanel placesPanel = new JPanel (new GridLayout(1,2,2,2));
	private ImageIcon flightLogo;

	private JLabel flightLable;
	private ArrayList<Flight> resultFlights;
	private Integer page;
	
	
	public ResultPage(ArrayList<Flight> flights) throws IOException {
		
		//Creating All The Buttons
		//We Also Have The Flights ready so we just Start to Paging The ResultPage 
		page = 0;
		resultFlights = flights;

		nextStep = new JButton("NEXT");
		nextStep.setActionCommand("Next");
		nextStep.addActionListener(new MyActionListener());

		previousStep = new JButton("PREVIOUS");
		previousStep.setActionCommand("Previous");
		previousStep.addActionListener(new MyActionListener());
		
		home = new JButton("HOME");
		home.setActionCommand("Home");
		home.addActionListener(new MyActionListener());
		
		buttonPanel.add(previousStep, BorderLayout.LINE_START);
		buttonPanel.add(home, BorderLayout.CENTER);
		buttonPanel.add(nextStep,BorderLayout.LINE_END);
		
		informationLabel = new JEditorPane();
		informationLabel.setContentType("text/html");
		informationLabel.setBorder(new TitledBorder("Flight Information"));
		String thisPage = getFlightString(resultFlights.get(page));
		informationLabel.setText(thisPage);
		informationLabel.setEditable(false);
		informationLabel.setBackground(null);
		lablePanel.add(informationLabel , BorderLayout.WEST);

		
		placesLable = new JEditorPane();
		placesLable.setContentType("text/html");
		placesLable.setBorder(new TitledBorder("Places That You Can Meet"));
		String thisPagePlaces = getPlacesString(resultFlights.get(page).getPlaces());
		placesLable.setText(thisPagePlaces);
		placesLable.setEditable(false);
		placesLable.setBackground(null);
		placesLable.addHyperlinkListener(new MyHyperLinkListener());
		
		placesPanel.add(placesLable , BorderLayout.CENTER);
		
		String address = resultFlights.get(page).getImage();
		flightLogo = new ImageIcon("image/"+address+".gif");
		flightLable = new  JLabel(flightLogo);
		lablePanel.add(flightLable,  BorderLayout.EAST);
		
		
		// Position the panels
		
		add(lablePanel, BorderLayout.NORTH);
		add(placesPanel , BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		// Settings (size, position, title) for the page
		
		setTitle("Go to your dream destination");
		setSize(600,700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public class MyHyperLinkListener implements HyperlinkListener{
		//Just To Open The Links in New Pages!!
		@Override
		public void hyperlinkUpdate(HyperlinkEvent evt) {
	        if (evt.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
	            Desktop desktop = Desktop.getDesktop();
				String s = evt.getURL().toString();
				URI uri;
				try {
					uri = new java.net.URI( s);
					desktop.browse(uri);
				} catch (URISyntaxException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
		}
	}
	
	public class MyActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			//With The Home Button We Create The Whole Thing From Scratch
			
			if(e.getActionCommand().equals("Home")){
				setVisible(false);
				dispose();
				TheApp.main(null);
			}
			
			//We Go to the Next page So we get The New Flight and we show all the infos!!
			
			if(e.getActionCommand().equals("Next")){
				page++;
				if(page >= resultFlights.size()){
					String thisPage = "THANKS BYE\nEnjoy Your Flight!";
					lablePanel.setVisible(false);
					placesPanel.setVisible(false);
					informationLabel.setText(thisPage);
					page = resultFlights.size();
				}else{
					String thisPage = getFlightString(resultFlights.get(page));
					informationLabel.setText(thisPage);
					lablePanel.remove(flightLable);
					String address = resultFlights.get(page).getImage();
					flightLogo = new ImageIcon("image/"+address+".gif");
					JLabel l = new JLabel(flightLogo);
					flightLable = l;
					lablePanel.add(flightLable);
					
					String thisPagePlaces = getPlacesString(resultFlights.get(page).getPlaces());
					placesLable.setText(thisPagePlaces);
					lablePanel.setVisible(true);
					placesPanel.setVisible(true);
				}
				System.out.println(page);
			}
	
			//We Go to the Previous page So we get The New Flight and we show all the infos!!
			
			if(e.getActionCommand().equals("Previous")){
				page--;
				if(page < 0)
					page++;
				String thisPage = getFlightString(resultFlights.get(page));
				informationLabel.setText(thisPage);
				lablePanel.remove(flightLable);
				String address = resultFlights.get(page).getImage();
				flightLogo = new ImageIcon("image/"+address+".gif");
				JLabel l = new JLabel(flightLogo);
				flightLable = l;
				lablePanel.add(flightLable);
				
				String thisPagePlaces = getPlacesString(resultFlights.get(page).getPlaces());
				placesLable.setText(thisPagePlaces);
				lablePanel.setVisible(true);
				placesPanel.setVisible(true);
			}
		}
	}
	
	
	private String getFlightString(Flight flight) {
		
		//Showing flights information in the font of Helvetica, size 4
		
		String sum = "<html><pre>";
			
		sum += "<br/><FONT FACE=\"Helvetica\" SIZE=4><b>FROM: </b>" + flight.getFrom() + "</FONT><br/>"; 
		sum += "<FONT FACE=\"Helvetica\" SIZE=4><b>TO: </b>" + flight.getTo() + "</FONT><br/>";
		sum += "<FONT FACE=\"Helvetica\"><b>FLIGHT NUMBER: </b>" + flight.getFlightNo() + "<br/><b>BY: </b>" + flight.getAirLine() + "</FONT><br/>";
		sum += "<FONT FACE=\"Helvetica\"><b>DEPARTING: </b>" + flight.getDate() + " " + flight.getTime() + "<br/><b>DURATION: </b>" + flight.getDuration() + "</FONT><br/>";
		sum += "<FONT FACE=\"Helvetica\"><b>ENTRANCE: </b>" + flight.getGate() + "</FONT>\n\n";
		sum += "<FONT FACE=\"Helvetica\"><b>ECONOMY CLASS: </b>" + "<b>" + flight.getCost() + "</b>" + " <b>SEK</b><br/>" + "<b>BUSINESS CLASS: </b>" + "<b>" + flight.getBusinessCost() + "</b>" + " <b>SEK</b><br/></FONT>";
	
		sum += "</pre></html>";
		
		return sum;
		
	}
	
	
	private String getPlacesString(ArrayList<Places> places){
		
		//Creating a table and showing names of possible places belonged to its city
		
		String result = "<html>";
		result += "\n<body>\n";
		result += "<table cellpadding=\"5\" cellspacing=\"0\" border=\"1\" align=\"center\" width=\"100%\">\n";
		result += "<tr align=\"center\">\n";
		result += "<td><FONT FACE=\"Helvetica\" SIZE=3><b>Name</b></FONT></td>\n";
		result += "<td><FONT FACE=\"Helvetica\" SIZE=3><b>Type</b></FONT></td>\n";
		result += "<td><FONT FACE=\"Helvetica\" SIZE=3><b>Cost</b></FONT></td>\n";
		result += "</tr>\n";
		
		for (int i = 0; i < places.size(); i++) {
			result += "<tr align=\"center\">\n";
			result += "<td><a href=\""+places.get(i).getLink()+"\"><FONT FACE=\"Helvetica\" SIZE=3>"+places.get(i).getName()+"</FONT></a></td>\n";
			result += "<td><FONT FACE=\"Helvetica\" SIZE=3>"+places.get(i).getType()+"</FONT></td>\n";
			result += "<td><FONT FACE=\"Helvetica\" SIZE=3>"+places.get(i).getCost().toString()+"</FONT></td>\n";
			result += "</tr>\n";
		}
		
		result += "</table>\n";
		result += "</body>\n";
		result += "</html>\n";
		
		return result;
		
	}
	
}
