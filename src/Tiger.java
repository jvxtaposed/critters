/* 
 * Name: Jennifer Mei Yan Fung
 * Login: cs8bwanj 
 * Date: January 28th 2016
 * File:  Tiger.java
 * Sources of Help: Lab Tutor & Java textbook
 * 
 * This program creates a subclass of Critter.java called Tiger.
 * It has methods that determine the behavior of the animal. 
 * Tiger is controlled by how hungry it is (int hunger), and is displayed
 * on the world as it's hunger int (toString()). If the tiger is hungry, it will scratch
 * when attacked, and if else, it'll pounce via method fight().
 * It will appear as yellow on the world via getColor().
 * It will choose a random direction and move 3 times in that direction
 * and repeat via method getMove().
 * 
 * */
import java.awt.*;
import java.util.*; 

/**
 * 
 */

public class Tiger extends Critter {
	private int hunger;
	private int eatFood;
	private Random random;
	private int move;

	/**
	 * 
	 */
	/* Name:  Tiger
	 * Purpose:  constructs the tiger
	 * Parameters:   takes in an int hunger that determines how many times to
	 * 					execute method eat()
	 * Return: it's a constructor, doesn't return anything
	 */
	public Tiger(int hunger) {
		//instantialises instance variables
		this.hunger = hunger;
		this.random = new Random();
		this.move = 0;
		this.eatFood = hunger;
	}

	/* Name:  eat
	 * Purpose:  returns whet
	 * Parameters:   doesn't take in anything
	 * Return: a boolean
	 */
	public boolean eat() {
		//if eatFood is less than zero, return
		if(eatFood < 0){
			eatFood =0;
		}
		//if eatFood is less than or equal to hunger, return true & decrement
		if(this.eatFood <= hunger) {
			this.eatFood--;
			return true;
		}
		//otherwise, eat returns false
		else {
			return false;
		}
	}
	
	/* Name: fight
	 * Purpose:  doles out specific attacks (or not) if its a specific opponent
	 * Parameters:   takes in a string
	 * Return: the attack the critter doles out
	 */
	
	public Attack fight(String opponent) {
		//if eatFood is not zero, scratch opponent
		if(eatFood != 0){
			return Attack.SCRATCH;
		}
		//otherwise, pounce on opponent
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
		//critter is yellow
		return Color.YELLOW;
	}

	/* Name: getMove()
	 * Purpose:  moves the critter
	 * Parameters:  n/a
	 * Return: returns an enum Direction
	 */
	public Direction getMove() {
		//moveTiger will generate a random # between 0-3
		int moveTiger = random.nextInt(4);
		//increment move
		move++;
		//if move is greater than 2; reset
		if(move>2) {
			move = 0;
		}
		//if random # is 0 & move is less than 2; return west
		if(moveTiger == 0 && move<2){
			return Direction.WEST;
		}
		//if random # is 1 & move is less than 2; return east
		else if(moveTiger == 1 && move<2) {
			return Direction.EAST;
		}
		//if random # is 2 & move is less than 2; return north
		else if(moveTiger == 2 && move<2) {
			return Direction.NORTH;
		}
		//otherwise return south
		else{
			return Direction.SOUTH;
		}
	
	}

	/* Name: toString()
	 * Purpose:  returns the icon displayed on the critters world
	 * Parameters:   doesn't take in anything
	 * Return: a string
	 */
	public String toString() {
		//returns int eatFood as a string
		return "" + eatFood;
	}
}
