import java.util.*;
import java.awt.*;
/* 
 * Name: Jennifer Mei Yan Fung
 * Login: cs8bwanj 
 * Date: January 28th 2016
 * File:  Dragon.java
 * Sources of Help: Lab Tutor & Java textbook
 * 
 * 
 * This program creates a subclass of Critter.java called Dragon.
 * It has methods that determine the behavior of the animal. 
 * Dragon is displayed on the world as 'D' (toString()). 
 * The dragon is always hungry therefore
 * eat() will always return true.
 * it will randomly choose an attack via fight().
 * it will appear as black on the world if food consumed is even via getColor(),
 * otherwise it will be white if food consumed is odd.
 * It will move in a circle and repeat via method getMove().
 * */

public class Dragon extends Critter {
	private Random random;
	private int foodCount;
	private int move;
	
	
	
	/* Name: 
	 * Purpose:  
	 * Parameters:   
	 * Return:
	 */
	
	public Dragon() {
	this.move = move;
	this.foodCount = foodCount;
	this.random = new Random();
		
	}
	
	/* Name:  eat
	 * Purpose:  returns whet
	 * Parameters:   doesn't take in anything
	 * Return: a boolean
	 */
	public boolean eat() {
		boolean hungry = true;
		foodCount++;
		return hungry;
	}
	
	/* Name: fight
	 * Purpose:  doles out specific attacks (or not) if its a specific opponent
	 * Parameters:   takes in a string
	 * Return: the attack the critter doles out
	 */
	
	public Attack fight(String opponent) {
		if(!opponent.equals("D")){
			int randomAttack = random.nextInt(3);
			if(randomAttack == 0){
				return Attack.SCRATCH;
			}
			if(randomAttack == 1){
				return Attack.ROAR;
			}
			else{
				return Attack.POUNCE;
			}
		}
		else{
			return Attack.FORFEIT;
		}
	}
	
	/* Name: getColor
	 * Purpose:  returns the color of the critter for future use
	 * Parameters:   doesn't take in anything
	 * Return: the color of the critter
	 */
	public Color getColor() {
		if( foodCount %2 == 0){
			return Color.BLACK;
		}
		else{
			return Color.WHITE;
		}
	}

	/* Name: getMove()
	 * Purpose:  moves the critter
	 * Parameters:  n/a
	 * Return: returns an enum Direction
	 */
	
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
		/*int moveDragon = random.nextInt(4);
		move++;

		if(move>1) {
			move = 0;
		}
		if(moveTiger == 0 && move<1){
			return Direction.WEST;
		}
		else if(moveTiger == 1 && move<2) {
			return Direction.EAST;
		}
		else if(moveTiger == 2 && move<2) {
			return Direction.NORTH;
		}
		else{
			return Direction.SOUTH;
		}*/
	
	/* Name: toString()
	 * Purpose:  returns the icon displayed on the critters world
	 * Parameters:   doesn't take in anything
	 * Return: a string
	 */
	public String toString() {
		String dragon = new String("D");
		return dragon;
	}
	

	
}
