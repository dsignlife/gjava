import java.util.*;
import java.io.*;
import java.text.*;
import javax.swing.*;


public class assignment2 {


	static Scanner scanner;                                      	
	static PrintWriter wErrors;                   
	static PrintWriter wCorrect;               
	
	static ArrayList<String> BookList;  					
	static ArrayList<String> CorrectList;  			
	static ArrayList<String> ErrorsList; 																		
	static boolean ErrorFound;	
	
	public static void main(String[] args) {
		
			
		try{
			
			
			JFileChooser fc = new JFileChooser();
			fc.setCurrentDirectory(new java.io.File("."));		   
		    
		    String Filename1 = ""; //Filename for books.txt
		    
		    //Choose file to be read
		   if (fc.showDialog(null,"Choose") == JFileChooser.APPROVE_OPTION){ 
			   
			   Filename1 =  fc.getSelectedFile().toString();
			   
			}
		   else
		   {
			   //File not chosen
			   System.exit(1);
			   
		   }

			File Bookfile = new File(Filename1);
			File FileErr = new File("NewBooks.txt");
			File FileNewBk = new File("Errors.txt");
			scanner = new Scanner(Bookfile);
			
			ErrorsList = new ArrayList<String>();
			
			BookList = new ArrayList<String>();
			
			CorrectList = new ArrayList<String>();

			

			//if it does not exist, the file is created
			if(!FileErr.exists()){
				
				FileErr.createNewFile();    
				
			}
			
          wErrors = new PrintWriter(new FileWriter(FileErr));
            

          //if it does not exist, the file is created
			if(!FileNewBk.exists()){
			
				FileNewBk.createNewFile();
				
			}
			
            wCorrect = new PrintWriter(new FileWriter(FileNewBk));
			
			
		}
        catch(IOException error) {
            
            System.out.println("Error1: " + error);
        }

		

		//Reading file
		while(scanner.hasNextLine())
		{		
			BookList.add(scanner.nextLine());
		}	
		
		checkingBooks();
		CorrectList = sort(CorrectList);
		for(String s1 : CorrectList )
	    	wCorrect.println(s1);
		
		
		for(String s2 : ErrorsList)
	    	wErrors.println(s2);
		
		scanner.close();
		wCorrect.close();
		wErrors.close();
		
		
		
	}
	
	

	public static void checkingBooks()
	{
		
		String[] list;	
		
		  
		  
		for(int i = 0; i < BookList.size(); i++)
		{
			
			list = BookList.get(i).split("\\#",-1);
			ErrorFound = false;
		
			if( list.length-1 >= 7 && list.length-1 <= 9 )
			{
				
				System.out.println(list[0]);
				String book = "";
				String booktmp = list[0];
				//Removes '-' from the ISBN

				
				for(int j = 0; j < booktmp.length(); j++)
				{
					if(booktmp.charAt(j) != '-')
						book += booktmp.charAt(j);
					
				}
				if(isCorrectISBN(book))
				{
					
					CorrectList.add(book);
	
				}
				else
				{

					ErrorFound = true;
					ErrorsList.add("Wrong ISBN-number");
				}
				//////////////////////////////////////////////////////////////////////
				//Checks copy number
				book = list[1];
				CheckNumber(book);

				
				//Checks Title
				book = list[2];
				CheckString(book);
				
				//Checks Author
				book = list[3];
				CheckString(book);
				
				//Checks Publisher
				book = list[4];
				CheckString(book);
				//Checks year
				book = list[5];
				CheckNumber(book);
				
				//Checks statistics
				book = list[6];
				CheckNumber(book);
				
				
				//Checks Borrow Date
				book = list[7];
				CheckDate(book);


				if(list.length - 1 == 8){
					
					book = list[8];
					if(!checkDate(book))
					{
						
						if(!isCorrectNumber(book))
						{
							ErrorFound = true;
							ErrorsList.add("#Not a Valid Entry");
												
							
						}
						
					}

						
					
				}
				else
					if(list.length - 1 == 9){
						
						//Checks statistics
						book = list[8];
						CheckDate(book);
						
						//Checks statistics
						book = list[9];
						CheckNumber(book);
						
					}
					
				
			}
			else
			{
				ErrorsList.add("#ERROR!!#");
				ErrorFound = true;
				
			}


		}
		
	}
	
	public static boolean checkDate(String date)
	{
		
		
		 SimpleDateFormat sf = new SimpleDateFormat("yyMMdd");
		
		 if(date.length() != sf.toLocalizedPattern().length())
			 return false;
		 else{
		 try{
			 
         Date pardate = sf.parse(date);
			 
		 if(sf.format(pardate).equals(date))
			 return true;
		 else
			 return false;
						 
					 
		 }
		 catch (ParseException e)
		 {
			 
			 return false;
			 
		 }}
		 
		
	}


	public static boolean isCorrectNumber(String input)
	{
		
		try{
			
			Integer.parseInt(input);
			
			return true;
			
		}
		catch(Exception e){
			
			return false;
		}
	}

	
	
	public static void CheckNumber(String value)
	{

		int indexErr = ErrorsList.size() ;
		int indexCorr = CorrectList.size() - 1;
		
		if(!isCorrectNumber(value))
		{
			
			if(ErrorFound)
			{

				ErrorsList.set( indexErr - 1, ErrorsList.get(indexErr - 1) + "####Not a Valid Number");
			}
			else{
				
				ErrorsList.add(CorrectList.get(indexCorr) + "####Not a Valid Number");
				
				
				CorrectList.remove(indexCorr);
			}
				
			ErrorFound = true;;
			
		}
		else
			if(ErrorFound)
			{
				ErrorsList.set( indexErr - 1, ErrorsList.get(indexErr - 1) + "#" + value);

			}
			else{
				
				CorrectList.set(indexCorr, CorrectList.get(indexCorr) + "#" + value);
			}


		
	}
	
	public static void CheckString(String value)
	{
		
		int indexErr = ErrorsList.size() ;
		int indexCorr = CorrectList.size() - 1;
		
		//If String is empty, the line contains an error
		if(value.equals(""))
		{
			
			if(ErrorFound)
			{
				ErrorsList.set( indexErr - 1, ErrorsList.get(indexErr - 1) + "####Missing Entry");

			}
			else{
				
				ErrorsList.add(CorrectList.get(indexCorr) + "####Missing Entry");
				CorrectList.remove(indexCorr);
			}
				
			ErrorFound = true;
		}
		else
			if(ErrorFound)
			{

				ErrorsList.set( indexErr - 1, ErrorsList.get(indexErr - 1) + "#" + value);
				
				
			}
			else{
				
				CorrectList.set( indexCorr, CorrectList.get(indexCorr) + "#" + value);
			}
	}
	

	public static void CheckDate(String value)
	{
		
		int indexErr = ErrorsList.size() ;
		int indexCorr = CorrectList.size() - 1;
		
		
		if(!checkDate(value))
		{
			
			if(ErrorFound)
			{
				ErrorsList.set( indexErr - 1, ErrorsList.get(indexErr - 1) + "####Incorrect Date Format");
				
			
			}
			else{
				
				ErrorsList.add(CorrectList.get(indexCorr) + "####Incorrect Date Format");
				CorrectList.remove(indexCorr);
			}
				
			ErrorFound = true;
			
		}
		else
			if(ErrorFound)
			{
				ErrorsList.set( indexErr - 1, ErrorsList.get(indexErr - 1) + "#" + value);

			}
			else{
				
				CorrectList.set( indexCorr, CorrectList.get(indexCorr) + "#" + value);
			}
		
		
	}
		


	public static boolean isCorrectISBN(String ISBN)
	{
		
		int DigitCheck = 0;
		
		
		//Checks if the ISBN is a valid ISBN13 (Current Standard - 2011)
		if(ISBN.length() == 13)
			{
			
				try{
				
				
				//Parsing the last value of the identifier into Int
				int LastDigit = Integer.parseInt("" + ISBN.charAt(12));
						
				for(int i = 0; i < 12; i++)
				{
					
					if( i % 2 == 0)
					{
						
						DigitCheck += Integer.parseInt("" + ISBN.charAt(i));
						
					}
					else
					{
						
						DigitCheck += Integer.parseInt("" + ISBN.charAt(i)) * 3;
						
					}
				}
				
					if ( 10 - DigitCheck % 10 == LastDigit)
					{
						
						return true;
					
					}
					else
						return false;
					
				
			}
			catch(Exception e)
			{
				//An error has occurred during the parsing, thus the ISBN is not valid
				return false;
				
			}		
		}
		else //It checks whether the ISBN is valid with the ISBN10 standards
			if(ISBN.length() == 10)
			{
				
				try{
					
										
					for(int i = 0; i < 10; i++)
					{
	
							DigitCheck += Integer.parseInt("" + ISBN.charAt(i)) * (10 - i);
							
	
					}
					
					if ( DigitCheck % 11 == 0)
					{
						
						return true;
					
					}
					else
						return false;
						
				
				}
				catch(Exception e)
				{
					//An error has occurred during the parsing, thus the ISBN is not valid
					return false;
					
				}	
				
				
			}
		
		//Its length is neither 13 nor 10
		else 
			return false;
		
	}


	public static ArrayList<String> sort(ArrayList<String> input){
		
		
		int numberOfbooks = input.size();
		String[] sortedList=new String[numberOfbooks];


		String[] tempValue;
		for (int i = 0; i < sortedList.length; i++)
		{
			tempValue = input.get(i).split("\\#",-1);
			
			sortedList[i] = tempValue[3];
			
			
		}

		String s;
		for( int i = 0; i <  input.size() - 1; i++)
		{
						
			for( int j = i + 1; j < input.size(); j++ )
			{
			
			if( sortedList[i].compareToIgnoreCase(sortedList[j]) > 0)
			{
				s = sortedList[i];
				sortedList[i] = sortedList[j];
				sortedList[j] = s;
				
				
				s = input.get(i);
				input.set(i, input.get(j));
				input.set(j, s);
				
			}
			}
			

			
		}
		
		return input;
	}

	
	
	
	
}
