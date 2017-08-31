package template;

import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import app.TheApp;

@SuppressWarnings({ "unused", "serial" ,"rawtypes" , "unchecked" })
public class MainPage extends JFrame{
	
	//Array for departures, will be replaced in the future
	private String [] departure = {"<Choose departure>"};
	
	
	//Array for destinations, will be replaced in the future
	private String [] destination = {"<Choose destination>", "Amsterdamn", "Berlin",
			"Gothenburg", "Madrid", "Paris", "Rome"};
	
	
	
	/*Array for travel days, so user can select how long they will be away on their trip */
	private String [] days = new String [101]; {
	
		for (Integer i = 1; i < days.length; i++) {
			days[i] = i.toString();
		}
	}
	
	
	//Variables for retrieving info from GUI
	private Object departureInput;
	private String departingString; 
	private Object destinationInput;
	private Object daysInput;
	private int quickOrCheap = 0;
	
	
	//Variables for keeping track of which "more" and "remove" button is active
	private int moreCounter = 0;
	private int more2Counter = 0;
	private int more3Counter = 0;
	private int more4Counter = 0;
	private int more5Counter = 0;
	
	
	//Main panel for the "Add more stops to the trip" panel
	private JPanel placesPanelMain = new JPanel(new GridLayout(1,2,1,1));

	//Panels that allow more cities and "more" inputs to be entered in the
	//"Add more stops to the trip" panel
	private JPanel morePanel = new JPanel (new GridLayout(5,1,1,1));
	private JPanel morePanelA = new JPanel (new FlowLayout(FlowLayout.LEFT, 50,10));
	private JPanel morePanelB = new JPanel (new FlowLayout(FlowLayout.LEFT, 50,10));
	private JPanel morePanelC = new JPanel (new FlowLayout(FlowLayout.LEFT, 50,10));
	private JPanel morePanelD = new JPanel (new FlowLayout(FlowLayout.LEFT, 50,10));
	private JPanel morePanelE = new JPanel (new FlowLayout(FlowLayout.LEFT, 50,10));
	
	//Panels that allow days to be added in "Add more stops to the trip" panel, and for
	//placement of the "remove" buttons
	private JPanel removePanel = new JPanel (new GridLayout(5,1,1,1));
	private JPanel removePanelA = new JPanel (new FlowLayout(FlowLayout.CENTER, 50,10));
	private JPanel removePanelB = new JPanel (new FlowLayout(FlowLayout.CENTER, 50,10));
	private JPanel removePanelC = new JPanel (new FlowLayout(FlowLayout.CENTER, 50,10));
	private JPanel removePanelD = new JPanel (new FlowLayout(FlowLayout.CENTER, 50,10));
	private JPanel removePanelE = new JPanel (new FlowLayout(FlowLayout.CENTER, 50,10));
	
	//main panel for the submit button
	private JPanel submitPanelMain = new JPanel (new GridLayout(1,2,1,1));
	
	//panel for the radio buttons quickest and fastest route
	private JPanel travelRadio = new JPanel(new FlowLayout(FlowLayout.CENTER, 50,20));
 	
	//Logo for the GUI
	private ImageIcon logo = new ImageIcon("image/e-travel-guide.jpg");
	
	//Combo box for choosing a departure city
	private JComboBox departureBox; 
	
	//Combo boxes for choosing destination cities
	private JComboBox destinationBox;
	private JComboBox destinationBox2;
	private JComboBox destinationBox3;
	private JComboBox destinationBox4;
	private JComboBox destinationBox5;
	private JComboBox destinationBox6;
	
	//Combo boxes for selecting the # of days on additional travel cities
	private JComboBox daysComboBox = new JComboBox(days);
	private JComboBox daysComboBox2 = new JComboBox(days);
	private JComboBox daysComboBox3 = new JComboBox(days);
	private JComboBox daysComboBox4 = new JComboBox(days);
	private JComboBox daysComboBox5 = new JComboBox(days);
	private JComboBox daysComboBox6 = new JComboBox(days);
	
	//Labels that will help users make decisions
	private JLabel pickDeparture = new JLabel ("Departure from:");
	private JLabel pickDepartureDate = new JLabel("    Departing:");
	private JLabel pickDestination = new JLabel ("        Destination To:");
	private JTextField departureText;
	private JLabel stayFor = new JLabel("How many days?:");
	
	//Labels that appear when a "more" button is clicked, guiding the user in 
	//choosing additional cities
	private JLabel extraCity1 = new JLabel("The 2nd City on Your Trip:");
	private JLabel extraCity2 = new JLabel("The 3rd City on Your Trip:");
	private JLabel extraCity3 = new JLabel("The 4th City on Your Trip:");
	private JLabel extraCity4 = new JLabel("The 5th City on Your Trip:");
	private JLabel extraCity5 = new JLabel("The 6th City on Your Trip:");
	
	//labels that appear next to the daysComboBox(es)
	private JLabel extraDays = new JLabel("   More days");
	private JLabel extraDays2 = new JLabel("   More days");
	private JLabel extraDays3 = new JLabel("   More days");
	private JLabel extraDays4 = new JLabel("   More days");
	private JLabel extraDays5 = new JLabel("   More days");
	private JLabel moreDays = new JLabel("More days: ");
	
	//Submit button
	private JButton submit = new JButton("Submit for your travel options!");
	
	//Radio buttons for deciding search query style
	JRadioButton quick = new JRadioButton("Quickest Routes");
	JRadioButton cheap = new JRadioButton("Cheapest Routes");
	
	
	//Buttons for more destination options
	private JButton more = new JButton("More destinations");
	private JButton more2 = new JButton("More destinations");
	private JButton more3 = new JButton("More destinations");
	private JButton more4 = new JButton("More destinations");
	private JButton more5 = new JButton("More destinations");
	
	//Buttons for removing destination options
	private JButton remove = new JButton("Remove");
	private JButton remove2 = new JButton("Remove");
	private JButton remove3 = new JButton("Remove");
	private JButton remove4 = new JButton("Remove");
	private JButton remove5 = new JButton("Remove");
	
	public MainPage(String[] citys) {
		
		//departure and destination boxes, using the "cities" array
		departureBox  = new JComboBox(citys);
		destinationBox  = new JComboBox(citys);
		
		//Combo boxes used for selecting additional cities in the
		//"Add more stops to the trip" panel
		destinationBox2  = new JComboBox(citys);
		destinationBox3  = new JComboBox(citys);
		destinationBox4  = new JComboBox(citys);
		destinationBox5  = new JComboBox(citys);
		destinationBox6  = new JComboBox(citys);
		
		
		//action commands for the submit and more buttons
		submit.setActionCommand("Submit");
		more.setActionCommand("More");
		more2.setActionCommand("More2");
		more3.setActionCommand("More3");
		more4.setActionCommand("More4");
		more5.setActionCommand("More5");
		
		//action commands for the remove button
		remove.setActionCommand("Remove");
		remove2.setActionCommand("Remove2");
		remove3.setActionCommand("Remove3");
		remove4.setActionCommand("Remove4");
		remove5.setActionCommand("Remove5");
		
		//action commands for the cheap and quick radio buttons
		cheap.setActionCommand("Cheap");
		quick.setActionCommand("Quick");

		//********************PANELS FOR THE COMBO BOX & PANELS********************
		
		//Create panel for storing the logo
		JPanel logoPanel = new JPanel (new GridLayout(1,1,0,0));
		
		//The left side of the "Travel Selection" panel 
		JPanel travelPanelLeft = new JPanel(new GridLayout(2,1,0,0));
		
		//The right side of the "Travel Selection" panel 
		JPanel travelPanelRight = new JPanel(new GridLayout(2,1,0,20));
		
		//The 2 sub-panels of travelPanelLeft. One for the top, the other for the
		//bottom half
		JPanel travelPanelLeftTop = new JPanel (new FlowLayout(FlowLayout.CENTER, 10,10));
		JPanel travelPanelLeftBottom = new JPanel (new FlowLayout(FlowLayout.CENTER, 10,5));
		
		//The 2 sub-panels of travelPanelRight. One for the top,the other for the bottom
		//half
		JPanel travelPanelRightTop = new JPanel (new FlowLayout(FlowLayout.CENTER,10,5));
		JPanel travelPanelRightBottom = new JPanel (new FlowLayout(FlowLayout.CENTER,10,0));
		
		
		//The panel for the submit button
		JPanel submitButtonPanel = new JPanel (new FlowLayout(FlowLayout.CENTER, 1,20));
		
		//The main panel that combines travelPanelLeft and travelPanelRight
		JPanel travelPanelLeftAndRight = new JPanel (new GridLayout(1,2,0,0));
		
		//The panel that combines travelPanelLeftandRight and the more and remove panels
		JPanel travelPanelTotal = new JPanel (new GridLayout(2,1,0,0));
		
		
		//***********TITLES FOR THE PANELS***************
		
		//title that designates the "Travel Selection" panel
		travelPanelLeftAndRight.setBorder (new TitledBorder("Travel Selection"));

		//title that destinates the "Add More Stops to the Trip" panel
		placesPanelMain.setBorder(new TitledBorder("Add More Stops To The Trip"));
		
		
		//**************ADDING OF COMBO BOXES, LABELS, FIELDS TO travelPanelLeft PANEL
		//AND ITS SUBPANELS (travelPanelLeft and travelPanelRIGHT)****************
		
		//Add pickDeparture label and departureBox comboBox to travelPanelLeftTop
		travelPanelLeftTop.add(pickDeparture, new FlowLayout(FlowLayout.LEFT, 10,10));
		travelPanelLeftTop.add(departureBox, new FlowLayout(FlowLayout.RIGHT, 10,10));
		
		//add travelPanelLeftTop to travelPanelLeft
		travelPanelLeft.add(travelPanelLeftTop, BorderLayout.NORTH);
		
		//add pickDestionation label to travelPanelLeftBottom
		travelPanelLeftBottom.add(pickDestination, new FlowLayout(FlowLayout.LEFT, 1,1));
		
		//Date constructor shows the current date in the departureText box
		Date currentDate = new Date(System.currentTimeMillis());
		
		//Add departureText to travelPanelLeftBottom
		departureText = new JTextField(currentDate.toString(), 10);
		travelPanelLeftBottom.add(destinationBox, new FlowLayout(FlowLayout.RIGHT, 1,1));
		
		//add travelPaneLeftBottom to travelPanelLeft
		travelPanelLeft.add(travelPanelLeftBottom, BorderLayout.NORTH);
		
		
		//**************ADDING COMBO BOXES, LABELS, FIELDS TO travelPanelRight PANEL
		//AND ITS SUBPANELS (travelPanelRightTop and travelPanelRightBottom)*************
		
		//Add the pickDeartureDate label to travelPanelRightTop
		travelPanelRightTop.add(pickDepartureDate, new FlowLayout(FlowLayout.LEFT, 1,1));
		
		//Add the departureText field for the departure date to travelPanelRightTop
		travelPanelRightTop.add(departureText, new FlowLayout(FlowLayout.RIGHT, 1,1));
		
		//add travelPanelRightTop to travelPanelRight
		travelPanelRight.add(travelPanelRightTop, BorderLayout.NORTH);
		
		//Add the stayFor label to the travelPanelRightBottom panel
		travelPanelRightBottom.add(stayFor, new FlowLayout(FlowLayout.CENTER, 1,1));
		
		//add the daysComboBox (how many days the travel will be) to the
		//travelPanelRightBottom
		travelPanelRightBottom.add(daysComboBox, new FlowLayout(FlowLayout.CENTER, 1,1));
		
		//Sets the default for days selected in the daysComboBox, to "1";
		daysComboBox.setSelectedItem("1");
		
		//add travelPanelRightBottom to travelPanelRight
		travelPanelRight.add(travelPanelRightBottom, BorderLayout.SOUTH);
		
		
		//***************SUBMIT BUTTON PANEL**************************
		
		//add the submit button to the submitButtonPanel
		submitButtonPanel.add(submit, new FlowLayout(FlowLayout.CENTER));
		
		//adding the subpanels that contain the radio buttons and submit button
		submitPanelMain.add(travelRadio, BorderLayout.WEST);
		submitPanelMain.add(submitButtonPanel, BorderLayout.EAST);
		
		//adding the quick and cheap radioButtons to the travelRadio panel
		travelRadio.add(quick, new FlowLayout(FlowLayout.LEFT));
		travelRadio.add(cheap, new FlowLayout(FlowLayout.RIGHT));
		quick.setSelected(true);
		
		//adding the quick and cheap radio buttons to a button group, making them
		//mutually exclusive 
		ButtonGroup group = new ButtonGroup();
		group.add(quick);
		group.add(cheap);
		
		//*******************LOGO PANEL**********************
		
		//add logo to the logoPanel
		logoPanel.add(new JLabel(logo));
		
		
		//****************TravelPanelLeftAndRight (LARGE PANEL)**************
		
		//add travelPanelLeft to the bigger panel, travelPanelLeftAndRight
		travelPanelLeftAndRight.add(travelPanelLeft, new FlowLayout(FlowLayout.CENTER, 1,1));
		
		//add travelPanelRight to the bigger panel, travelPanelLeftAndRight
		travelPanelLeftAndRight.add(travelPanelRight, new FlowLayout(FlowLayout.CENTER, 1,1));
		
		
		//******************travelPanelTotal PANEL**********************
		
		//add the travelPanelLeftAndRight to the travelPanelTotal
		travelPanelTotal.add(travelPanelLeftAndRight,
				BorderLayout.NORTH);
		
		//add placesPanelMain to the travelPanelTotal panel
		travelPanelTotal.add(placesPanelMain, BorderLayout.SOUTH);
		
		
		//**************************PLACES PANEL*************************************
		placesPanelMain.add(morePanel, BorderLayout.WEST);
		
		//Adding the various sub panels to the morePanel, located within 
		//"Add more stops to the trip" panel
		morePanel.add(morePanelA);
		morePanel.add(morePanelB);
		morePanel.add(morePanelC);
		morePanel.add(morePanelD);
		morePanel.add(morePanelE);
		morePanelA.add(more, new FlowLayout(FlowLayout.LEFT, 1,1) );
		
		placesPanelMain.add(removePanel, BorderLayout.EAST);
		
		//Adding the various sub panels to the removePanel, located within
		//"Add more stops to the trip" panel
		removePanel.add(removePanelA);
		removePanel.add(removePanelB);
		removePanel.add(removePanelC);
		removePanel.add(removePanelD);
		removePanel.add(removePanelE);
	
		//*****************MAIN JFRAME*********************************
		
		//Main frame that will hold the logo panel, travelPanelTotal and
		//submit button panel
		JPanel mainFrame = new JPanel(new BorderLayout(1,1));
	
		//Adding the frames to the mainFrame
		mainFrame.add(logoPanel, BorderLayout.NORTH);
		mainFrame.add(travelPanelTotal, BorderLayout.CENTER);
		mainFrame.add(submitPanelMain, BorderLayout.SOUTH);
		
		//Add scroll bars to the entire GUI	
		JScrollPane scrollBar = new JScrollPane(mainFrame,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
						JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		scrollBar.setPreferredSize(new Dimension(900, 700));
		
		//add scrollbar frame to JFrame 		
		add(scrollBar);
	
		
		//**********************MAIN JFRAME SETTINGS**********************
		setTitle("Select your destinations");
		pack();
		setLocationRelativeTo(null); //Frame placed at the Center
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		//Register the listeners for the buttons
		submit.addActionListener(new ButtonListener());
		more.addActionListener(new ButtonListener());
		more2.addActionListener(new ButtonListener());
		more3.addActionListener(new ButtonListener());
		more4.addActionListener(new ButtonListener());
		more5.addActionListener(new ButtonListener());
		remove.addActionListener(new ButtonListener());
		remove2.addActionListener(new ButtonListener());
		remove3.addActionListener(new ButtonListener());
		remove4.addActionListener(new ButtonListener());
		remove5.addActionListener(new ButtonListener());
		quick.addActionListener(new ButtonListener());
		cheap.addActionListener(new ButtonListener());
		
	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			
		//When submit button is pressed, info from GUI is gathered
			if(e.getActionCommand().equals("Submit")){
				
			//Get values from the departure city combo box
			departureInput = departureBox.getSelectedItem();
				
			//Get values from departure date, convert it to a date variable
			departingString = departureText.getText(); 
				
			//Get values from the destination comboBox
			destinationInput = destinationBox.getSelectedItem();
				
			//Get values from the stayFor comboBox (# of days)
			daysInput = daysComboBox.getSelectedItem();
				
				
			
			//After the submit button is clicked, the frame disappears
			setVisible(false);
			dispose();

			//Information to be sent to be stored in arrays, and allows them to be called
			//to be used in database queries
				
			SelectedInformation information = new SelectedInformation();
			information.setSource((String) departureInput);
				
			
			information.setDate(getDate(departingString));
			ArrayList<Destinations> list = new ArrayList<Destinations>();

			Destinations d = new Destinations();
			d.setDestination((String) destinationInput);
			d.setDays(Integer.parseInt((String)daysInput));	
			list.add(d);	 
			
			//collects info made available by clicking the "more" button. If
			//data on additional cities is present, it is added to the "list"
			//array
			if (daysComboBox2.getSelectedItem() != null) {
				Destinations city2 = new Destinations();
				Object destinationInput = destinationBox2.getSelectedItem();
				Object daysInput = daysComboBox2.getSelectedItem();
	
				city2.setDestination((String) destinationInput);
				city2.setDays(Integer.parseInt((String)daysInput));	
				list.add(city2);
			}
			
			//collects info from an add destination line, if it is present
			if (daysComboBox3.getSelectedItem() != null) {
				Destinations city3 = new Destinations();
				Object destinationInput = destinationBox3.getSelectedItem();
				Object daysInput = daysComboBox3.getSelectedItem();
	
				city3.setDestination((String) destinationInput);
				city3.setDays(Integer.parseInt((String)daysInput));	
				list.add(city3);
			}
			//collects info from an add destination line, if it is present
			if (daysComboBox4.getSelectedItem() != null) {
				Destinations city4 = new Destinations();
				Object destinationInput = destinationBox4.getSelectedItem();
				Object daysInput = daysComboBox4.getSelectedItem();
	
				city4.setDestination((String) destinationInput);
				city4.setDays(Integer.parseInt((String)daysInput));	
				list.add(city4);
			}
			
			//collects info from an add destination line, if it is present
			if (daysComboBox5.getSelectedItem() != null) {
				Destinations city5 = new Destinations();
				Object destinationInput = destinationBox5.getSelectedItem();
				Object daysInput = daysComboBox5.getSelectedItem();
	
				city5.setDestination((String) destinationInput);
				city5.setDays(Integer.parseInt((String)daysInput));	
				list.add(city5);
			}
			
			//collects info from an add destination line, if it is present
			if (daysComboBox6.getSelectedItem() != null) {
				Destinations city6 = new Destinations();
				Object destinationInput = destinationBox6.getSelectedItem();
				Object daysInput = daysComboBox6.getSelectedItem();
	
				city6.setDestination((String) destinationInput);
				city6.setDays(Integer.parseInt((String)daysInput));	
				list.add(city6);
			}
			
			d = new Destinations();	
			d.setDestination((String) departureInput);
			d.setDays(0);
			list.add(d);
				
			information.setDestinations(list);
			TheApp app = new TheApp();
			app.calculate(information);
			}
			
			//if more button is pressed, adding another another destination and days is
			//possible
			if(e.getActionCommand().equals("More") && (moreCounter != 1)){
				moreCounter ++;
				morePanelA.add(destinationBox2, new FlowLayout(FlowLayout.RIGHT));
				morePanelB.add(more2, new FlowLayout(FlowLayout.LEFT));
				morePanelA.remove(more);
				morePanelA.remove(destinationBox2);
				morePanelA.add(extraCity1, new FlowLayout(FlowLayout.LEFT));
				morePanelA.add(destinationBox2, new FlowLayout(FlowLayout.RIGHT));
				morePanel.updateUI();
		
				removePanelA.add(moreDays);
				removePanelA.add(daysComboBox2, BorderLayout.WEST);
				daysComboBox2.setSelectedItem("1");
				removePanelA.add(remove, BorderLayout.EAST);
				removePanel.updateUI();
				
			}
			
			//if more button is pressed, adding another another destination and days is
			//possible
			if(e.getActionCommand().equals("More2") && (more2Counter != 1)){
				more2Counter ++;
				removePanelA.remove(moreDays);
				morePanelB.remove(more2);
				morePanelB.add(extraCity2, new FlowLayout(FlowLayout.LEFT));
				morePanelB.add(destinationBox3, new FlowLayout(FlowLayout.RIGHT,1,1));
				morePanelC.add(more3, new FlowLayout(FlowLayout.LEFT,1,1));
				morePanel.updateUI(); 	
		
				removePanelB.add(daysComboBox3, new FlowLayout(FlowLayout.LEFT));
				daysComboBox3.setSelectedItem("1");
				removePanelA.remove(remove);
				removePanelA.add(extraDays, new FlowLayout (FlowLayout.RIGHT));
				removePanelB.add(remove2, new FlowLayout(FlowLayout.RIGHT));
				removePanel.updateUI();
			}
			
			//if more button is pressed, adding another another destination and days is
			//possible
			if(e.getActionCommand().equals("More3") && (more3Counter != 1)){
				more3Counter ++;
				morePanelC.remove(more3);
				morePanelC.add(extraCity3, new FlowLayout(FlowLayout.LEFT));
				morePanelC.add(destinationBox4, new FlowLayout(FlowLayout.RIGHT,1,1));
				morePanelD.add(more4, new FlowLayout(FlowLayout.LEFT,1,1));
				morePanel.updateUI(); 	
		
				removePanelC.add(daysComboBox4, new FlowLayout(FlowLayout.LEFT));
				removePanelB.remove(remove2);
				removePanelB.add(extraDays2, new FlowLayout(FlowLayout.RIGHT));
				daysComboBox4.setSelectedItem("1");
				removePanelC.add(remove3, new FlowLayout(FlowLayout.RIGHT));
				removePanel.updateUI();
			}
			
			//if more button is pressed, adding another another destination and days is
			//possible
			if(e.getActionCommand().equals("More4") && (more4Counter != 1)){
				more4Counter ++;
				morePanelD.remove(more4);
				morePanelD.add(extraCity4, new FlowLayout(FlowLayout.LEFT,1,1));
				morePanelD.add(destinationBox5, new FlowLayout(FlowLayout.RIGHT,1,1));
				morePanelE.add(more5, new FlowLayout(FlowLayout.LEFT,1,1));
				morePanel.updateUI(); 	
				
				removePanelD.add(daysComboBox5, new FlowLayout(FlowLayout.LEFT));
				removePanelC.remove(remove3);
				removePanelC.add(extraDays3);
				daysComboBox5.setSelectedItem("1");
				removePanelD.add(remove4, new FlowLayout(FlowLayout.RIGHT));
				removePanel.updateUI();
		
			}
			
			//if more button is pressed, adding another another destination and days is
			//possible
			if(e.getActionCommand().equals("More5") && (more5Counter != 1)){
				more5Counter ++;
				morePanelE.remove(more5);
				morePanelE.add(extraCity5, new FlowLayout(FlowLayout.LEFT,1,1));
				morePanelE.add(destinationBox6, new FlowLayout(FlowLayout.RIGHT,1,1));
				morePanel.updateUI(); 	
				
				removePanelD.remove(remove4);
				removePanelD.add(extraDays4, new FlowLayout(FlowLayout.RIGHT));
				removePanelE.add(daysComboBox6, new FlowLayout(FlowLayout.LEFT));
				daysComboBox6.setSelectedItem("1");
				removePanelE.add(remove5, new FlowLayout(FlowLayout.RIGHT));
				removePanel.updateUI();
		
			}
			
			//if "remove" button is selected, add a destination row is removed
			if(e.getActionCommand().equals("Remove5") && (moreCounter == 1) 
					&& (more2Counter == 1) && (more3Counter == 1)
					&& (more4Counter == 1) && (more5Counter == 1)){
				
				more5Counter --;
				morePanelE.remove(destinationBox6);
				morePanelE.remove(extraCity5);
				morePanelE.add(more5);
				morePanel.updateUI(); 	
				
				removePanelE.remove(daysComboBox6);
				daysComboBox6.setSelectedItem(null);
				removePanelE.remove(remove5);
				removePanelD.remove(extraDays4);
				removePanelD.add(remove4);
				removePanel.updateUI();
			}
		
			//if "remove" button is selected, add a destination row is removed
		if(e.getActionCommand().equals("Remove4") && (moreCounter == 1) 
				&& (more2Counter == 1) && (more3Counter == 1)
				&& (more4Counter == 1) && (more5Counter == 0)){
			
			more4Counter --;
			removePanelD.remove(daysComboBox5);
			daysComboBox5.setSelectedItem(null);
			removePanelD.remove(remove4);
			removePanelC.remove(extraDays3);
			removePanelC.add(remove3);
			removePanel.updateUI();
			
			morePanelE.remove(more5);
			morePanelD.remove(destinationBox5);
			morePanelD.remove(extraCity4);
			morePanelD.add(more4);
			morePanel.updateUI(); 	
		}
		
		//if "remove" button is selected, add a destination row is removed
		if(e.getActionCommand().equals("Remove3") && (moreCounter == 1) 
				&& (more2Counter == 1) && (more3Counter == 1)
				&& (more4Counter == 0) && (more5Counter == 0)){
			
			more3Counter --;
			removePanelC.remove(daysComboBox4);
			daysComboBox4.setSelectedItem(null);
			removePanelC.remove(remove3);
			removePanelB.remove(extraDays2);
			removePanelB.add(remove2);
			removePanel.updateUI();
			
			morePanelD.remove(more4);
			morePanelC.remove(extraCity3);
			morePanelC.add(more3);
			morePanelC.remove(destinationBox4);
			morePanel.updateUI(); 	
		}
		
		//if "remove" button is selected, add a destination row is removed
		if(e.getActionCommand().equals("Remove2") && (moreCounter == 1) 
				&& (more2Counter == 1) && (more3Counter == 0)
				&& (more4Counter == 0) && (more5Counter == 0)){
			
			more2Counter --;
			removePanelB.remove(daysComboBox3);
			daysComboBox3.setSelectedItem(null);
			removePanelB.remove(remove2);
			//removePanelA.remove(daysComboBox2);
			removePanelA.add(remove);
			removePanel.updateUI();
			
			morePanelC.remove(more3);
			morePanelB.remove(destinationBox3);
			morePanelB.remove(extraCity2);
			morePanelB.add(more2);
			morePanel.updateUI(); 	
		}
		
		//if "remove" button is selected, add a destination row is removed
		if(e.getActionCommand().equals("Remove") && (moreCounter == 1) 
				&& (more2Counter == 0) && (more3Counter == 0)
				&& (more4Counter == 0) && (more5Counter == 0)){
			
			moreCounter --;
			removePanelA.remove(daysComboBox2);
			daysComboBox2.setSelectedItem(null);
			removePanelA.remove(remove);
			removePanelA.remove(extraDays);
			removePanel.updateUI();
			
			morePanelB.remove(more2);
			morePanelA.remove(destinationBox2);
			morePanelA.remove(extraCity1);
			morePanelA.add(more, new FlowLayout(FlowLayout.LEFT,1,1) );
			morePanel.updateUI(); 	
		}
		
		//sets quickOrCheap to 1 if quick is selected
		if(e.getActionCommand().equals("Quick")) {
			quickOrCheap = 1;
		}
		
		//sets quickOrCheap to 2 if cheap is selected
		if(e.getActionCommand().equals("Cheap")) {
			quickOrCheap = 2;
		}
		
		
			
		}
		
		
		}
	
	
		
		public String getDepartingString () {
			return departingString;
		}
		
		public Object getDepartureInput () {
			return departureInput;
		}
		
		public Object getDestinationInput (){
			return destinationInput;
		}
		
		public Object getDaysInput () {
			return daysInput;
		}

		@SuppressWarnings("deprecation")
		private static Date getDate(String s){

			String year = s.substring(0, 4);
			String month = s.substring(5, 7);
			String day = s.substring(8,10);
			int x = Integer.parseInt(year);
			int y = Integer.parseInt(month);
			int z = Integer.parseInt(day);
			
			Date d = new Date(x-1900, y-1, z);
			return d;
			
		}
}
