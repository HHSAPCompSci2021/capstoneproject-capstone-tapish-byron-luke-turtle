package sprites;
import java.util.*;

/**
 * This class represents the riddle bank where riddles are drawn from.
 * @version 5/9/22
 * @author Tapish Singh
 */
public class RiddleBank {
	private String riddle, answer, hint;
	private ArrayList<Trio<String, String, String>> riddleList = new ArrayList<>();
	
	/**
	 * Returns the contents of the riddle field in the form of a String
	 * @return String the riddle in question
	 */
	public String getRiddle() {
		return riddle;
	}
	
	/**
	 * Returns the contents of the answer field in the form of a String
	 * @return String the answer to the riddle in question
	 */
	public String getAnswer() {
		return answer;
	}
	
	/**
	 * Returns the contents of the hint field in the form of a String
	 * @return String the hint to the riddle in question
	 */
	public String getHint() {
		return hint;
	}
	/**
	 * Creates the selected riddle. 
	 * All riddles are pulled from https://parade.com/947956/parade/riddles/
	 * MLA citation: Parade. (2022, April 28). 101 riddles that will stump you every time (but don't worry-we'll give you the answers). Parade. Retrieved May 9, 2022, from https://parade.com/947956/parade/riddles/ 
	 * @param riddleNum the number for the riddle chosen(riddles are numbered)
	 */
	public RiddleBank(int riddleNum) {
		// why not just use an arrayList of tuples?
		if(riddleNum == 0) {
			riddle = "What is always in front of you but can't be seen?";
			answer = "future";
			hint = "You'll find out tomorrow.";
		}
		
		else if(riddleNum == 1) {
			riddle = "What goes up but never comes down?";
			answer = "age";
			hint = "Take a look back on your life.";
		}
		
		else if(riddleNum == 2) {
			riddle = "I shave every day, but my beard stays the same. What am I?";
			answer = "barber";
			hint = "Perhaps you might need to visit this thing soon.";
		}
		
		else if(riddleNum == 3) {
			riddle = "I have branches, but no fruit, trunk, or leaves. What am I?";
			answer = "bank";
			hint = "I do have quite a bit of greenery, though.";	
		}
		
		else if(riddleNum == 4) {
			riddle = "What can't talk but will reply when spoken to?";
			answer = "echo";
			hint = "Amazon also sells these.";
		}
		
		else if(riddleNum == 5) {
			riddle = "The more prominent I become, the less you see me. What am I?";
			answer = "darkness";
			hint = "Hello _______, my old friend...";	
		}
		
		else if(riddleNum == 6) {
			riddle = "David's parents have three sons: Snap, Crackle, and _______";
			answer = "david";
			hint = "The answer's not Pop.";
		}
		
		else if(riddleNum == 7) {
			riddle = "What has many keys but can't open a single lock?";
			answer = "piano";
			hint = "It's clearly not you, you don't have all the keys yet!";
		}
		
		else if(riddleNum == 8) {
			riddle = "What item lets you look right through a wall?";
			answer = "window";
			hint = "It's quite simple, actually.";
		}
		
		else if(riddleNum == 9) {
			riddle = "If another person shares me with you, and you share me with others, you're a bad person. What am I?";
			answer = "secret";
			hint = "I dunno, I'm quite secretive...";
		}
		
		else if(riddleNum == 10) {
			riddle = "I have one eye, but can't see. What am I?";
			answer = "needle";
			hint = "I may have an eye, but you really don't want me in your eye.";
		}
		
		else if(riddleNum == 11) {
			riddle = "What has hands, but can't clap?";
			answer = "clock";
			hint = "Wait, what's the time? Sorry I don't have much time to write these hints, I gotta study for AP exams.";
		}
		
		else if(riddleNum == 12) {
			riddle = "What has one head, one foot, and four legs?";
			answer = "bed";
			hint = "zzzzzzzzzzzzzzzzzzzzzzz";
		}
		
		else if(riddleNum == 13) {
			riddle = "What has many teeth, but can't bite?";
			answer = "comb";
			hint = "Despite its many teeth, it isn't scary tbh";
		}
		
		else if(riddleNum == 14) {
			riddle = "What begins with the letter \"e\" but only contains one letter?";
			answer = "envelope";
			hint = "Wait, do people still use these nowadays?";
		}
		
		else if(riddleNum == 15) {
			riddle = "I know a word that has 6 letters. If I remove one, 12 remain. What's the word?";
			answer = "dozens";
			hint = "Well it could be said that taking this hint added/subtracted ______ of seconds from your time.";
		}
		
		// catch-all in case if number called DOESN'T correspond to an actual riddle
		else {
			riddle = "What month of the year has 28 days?";
			answer = "all of them";
			hint = "how exactly did you get this riddle? call range is from 0-15";
		}
		
	
	}
	
	
	static class Trio <S1, S2, S3> {
		S1 first;
		S2 second;
		S3 third;

		public Trio(S1 first_value, S2 second_value, S3 third_value) {
			first = first_value;
			second = second_value;
			third = third_value;
		}
	}
	
}





