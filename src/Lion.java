import java.awt.*;
/* 
 * Name: Jennifer Mei Yan Fung
 * Login: cs8bwanj 
 * Date: January 28th 2016
 * File:  Lion.java
 * Sources of Help: Lab Tutor & Java textbook
 * 
 *  *  This program creates a subclass of Critter.java called Lion.
 * It has methods that determine the behavior of the animal. 
 * Lion is displayed on the world as 'L' (toString()). 
 * The bear is hungry after it has fought, therefore
 * eat() will return true when fight() has been executed once.
 *  it will roar when against a Bear, otherwise, it will pounce via fight()
 * it will appear as red on the world via getColor(),
 * It will go 5 steps south, west, north and then east
 * and repeat via method getMove().
 * */

public class Lion extends Critter {
	private boolean fight;
	private int move;
	
	
	
	/* Name:  Lion
	 * Purpose:  constructs the lion object
	 * Parameters: n/a  
	 * Return: it's a constructor, doesn't return anything
	 */
	public Lion() {
		this.fight = false;
		this.move = 0;
	}

	/* Name:  eat
	 * Purpose:  returns whether or not the critter will eat
	 * Parameters:   doesn't take in anything
	 * Return: a boolean
	 */
	public boolean eat() {
		if(!this.fight){
			return true;
		}
		else{
			return false;
		}
	}
	
	/* Name: fight
	 * Purpose:  doles out specific attacks (or not) if its a specific opponent
	 * Parameters:   takes in a string
	 * Return: the attack the critter doles out
	 */
	
	public Attack fight(String opponent) {
		this.fight = true;
		if(opponent.equals("B")) {
			return Attack.ROAR;
		}
		else{
			return Attack.POUNCE;
		}
	}
	
	/* Name: getColor
	 * Purpose:  returns the color of the critter for future use
	 * Parameters:   doesn't take in anything
	 * Return: the color of the critter
	 */
	public Color getColor() {
		return Color.RED;
	}

	/* Name: getMove()
	 * Purpose:  moves the critter
	 * Parameters:  n/a
	 * Return: returns an enum Direction
	 */
		//i have the exact same method implemented in Dragon that works in dragon
		//but refuses to work in Lion
		//moves dragon in a square
	public Direction getMove() {
		if(this.move > 20) {
			this.move = 0;
		}
		this.move++;
		if (this.move <= 5){
			Direction s = Direction.SOUTH;
			return s;
		}
		else if (this.move <= 10){
			Direction w = Direction.WEST;
			return w;
		}
		else if (this.move <= 15){
			Direction n = Direction.NORTH;
			return n;
		}
		else {
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
		String lion = new String("L");
		return lion;
	}
}
