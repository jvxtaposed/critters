import java.awt.*;
/* 
 * Name: Jennifer Mei Yan Fung
 * Login: cs8bwanj 
 * Date: January 28th 2016
 * File:  Bear.java
 * Sources of Help: Lab Tutor & Java textbook
 * 
 *  This program creates a subclass of Critter.java called Bear.
 * It has methods that determine the behavior of the animal. 
 * Bear is controlled by a boolean (grizzly), and is displayed
 * on the world as 'B' (toString()). The bear is always hungry, therefore
 * 
 * 
 * eat() will always return true.
 *  it will always scratch when attacked via fight()
 * If boolean grizzly returns true,
 * it will appear as brown on the world via getColor(),
 * if grizzly == false, it will return white.
 * It will alternate between south and east direction
 * and repeat via method getMove().
 * */



public class Bear extends Critter {
	private boolean grizzly;
	private int move;
	
	

	
	/* Name:  Bear
	 * Purpose:  constructs the bear object
	 * Parameters: takes in a boolean   
	 * Return: it's a constructor, doesn't return anything
	 */
	public Bear(boolean grizzly) {
			this.grizzly = grizzly;
			this.move = 0;
		}
		
	
	/* Name:  eat
	 * Purpose:  returns whet
	 * Parameters:   doesn't take in anything
	 * Return: a boolean
	 */
	public boolean eat() {
		//always hungry, always return true
		boolean hungry = true;
		return hungry;
	}
	
	/* Name: fight
	 * Purpose:  doles out specific attacks (or not) if its a specific opponent
	 * Parameters:   takes in a string
	 * Return: the attack the critter doles out
	 */
	public Attack fight(String opponent) {
		//always attack by scratching
		return Attack.SCRATCH;
	}
	
	/* Name: getColor
	 * Purpose:  returns the color of the critter for future use
	 * Parameters:   doesn't take in anything
	 * Return: the color of the critter
	 */
	
	public Color getColor() {
		//if boolean grizzly is true, return brown
		if(this.grizzly == true){
			return new Color(190,110,50);
		}
		//else return white for polar bear
		else {
			return Color.WHITE;
		}
	}

	/* Name: getMove()
	 * Purpose:  moves the critter
	 * Parameters:  n/a
	 * Return: returns an enum Direction
	 */
	public Direction getMove() {
		//creates new local variable and iterates it
		move++;
		//if move's remainder is 1, return south
		if (move % 2==1){
			Direction s = Direction.SOUTH;
			return s;
		}
		//else return east
		else{
			Direction e = Direction.EAST;
			return e;
		}
	}

	/* Name: toString()
	 * Purpose:  returns the icon displayed on the critters world
	 * Parameters:   doesn't take in anything
	 * Return: a string
	 */
	public String toString() {
		//returns string "B" 
		String bear = new String("B");
		return bear;
	}
	

	
}
