/**
 *
 * @author ToMz
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class GuessGame {

	// create arrays
	
static ArrayList<Integer> score = new ArrayList<Integer>();
static ArrayList<String> playern = new ArrayList<String>();


public static void main(String[] args) {

    // create a random number

int number = (int)(Math.random() * 1000 + 1);

Scanner input = new Scanner(System.in);

System.out.println("Try guessing a number between 1 and 1000");

int guess = -1; 
int tries = 0;


    // where the loop starts

do {

tries++;

    // the user's number input

System.out.println("Enter your guess: ");

    // try and catch illegal inputs

try {
guess = input.nextInt();

    // conditions

if (guess < 1 || guess > 1000) {
System.out.println(guess + " is not what the system's expected, try again."); 
}
else if (guess == number) {
System.out.println(number + " is correct!");
}
else if (guess > number) {
System.out.println(guess + " is too high. Try again!");
}
else if (guess < number) {
System.out.println(guess + " is too low. Better luck next time!");
}

}

catch (InputMismatchException e) {
if ("quit".equals(input.next())) {
		System.out.print("You've chosen to quit.");
		System.exit(0);
}
else {
System.out.println("The guess should be numerical values only!");
}
}

    // where the loop ends

} while (guess != number);

System.out.println("You have guessed " + tries + " time(s)");

    // asking for the user's name

System.out.println("Please enter your name: ");
String name = input.next();

    // inputting and sorting the high score

score.add(tries) ;
playern.add(name);

int sort1 = 0;
String sort2 = " ";
for (int i = 0; i < score.size(); i++) {
for (int o = 0; o < score.size() - 1; o++) {
if (score.get(o) > score.get(o + 1)) {
sort1 = score.get(o);
score.set(o, score.get(o + 1));
score.set(o + 1, sort1);
sort2 = playern.get(o);
playern.set(o, playern.get(o + 1));
playern.set(o + 1, sort2);

}
}
}

    //show the scores and names

System.out.println("#######" + " High Score Board " + "#######");
System.out.println("Try(s)" + "\t\t\t" + " Player(s)");

for (int j = 0; j < score.size(); j++) {
System.out.println(score.get(j) + "\t\t\t " + playern.get(j));
System.out.println("################################");
} 


    // continue or out

System.out.println("Do you want to try again? (y/n)");
System.out.println("################################");
String answer = input.next();

    // conditions for y and n/quit

if ("y".equals(answer)) { 
main(null);
}
else if ("n".equals(answer)) {
System.out.println("Session Terminated");
System.exit(0);
}
else if ("quit".equals(answer)) {
System.out.println("Session Terminated");
System.exit(0);
}
else {
System.out.println("GET THE HELL OUT, TROLL");
}
    // conditions end

}

}