import java.awt.Color;
//import java.util.Random;
/* 
 * Name: Jennifer Mei Yan Fung
 * Login: cs8bwanj 
 * Date: Feb 17th 2016
 * File:  myCritter.java
 * Sources of Help: Java textbook
 * 
 *  This program creates a subclass of Critter.java called myCritter.
 * It has methods that determine the behavior of the animal. 
 * myCritter is displayed on the world as '[=◈︿◈=]' (toString()). 
 * The critter is hungry after it has fought, therefore
 * eat() will return true when fight() has been executed once.
 *  it will roar when against a Bear, scratch when against a Lion, 
 *  and if the tiger is hungry, scratch otherwise, roar.
 * it will appear as purple on the world via getColor(),
 * It will go 5 steps south, west, north and then east
 * and repeat via method getMove().
 * */



public class MyCritter extends Critter {
	//private Random random;
	private int move;
	private static int porters = 0;
	private int foodCount;
	
	/* Name: myCritter
	 * Purpose:  constructs the critter
	 * Parameters:   doesnt take in anything
	 * Return:doesnt return anything
	 */
	
	public MyCritter() {
		//move is set to 0
		this.move = 0;
		//foodCount is set to 0
		this.foodCount = 0;
		//this.random = new Random();
		//counts how many myCritters there are
		//every time this constructor is accessed, it will up the count of critters
		porters++;
	}
	
	/* Name:  eat
	 * Purpose:  returns whether or not the critter will eat
	 * Parameters:   doesn't take in anything
	 * Return: a boolean
	 */
	public boolean eat() {
		//counts how many food eaten
		foodCount++;
		
		//boolean hungry = true;
		//return hungry;
		//if there are more than 8 critters, eat is true
		if(porters > 8) {
			return true;
		}
		//returns false if less than 8 critters
		return false;
	}
	
	/* Name: fight
	 * Purpose:  doles out specific attacks for a specific opponent
	 * Parameters:   takes in a string
	 * Return: the attack the critter doles out
	 */
	public Attack fight(String opponent) {
		//if opponent is bear, roar to win
		if(opponent.equals("B")) {
			return Attack.ROAR;
		}
		//if opponent is lion, scratch to win
		else if(opponent.equals("L")){
			return Attack.SCRATCH;
		}
		//if opponent is tiger & hungry, scratch to win
		else if(opponent.equals("0")){
			return Attack.SCRATCH;
		}
		//if opponent is tiger & not hungry, roar to win
		else if(opponent.equals("9")){
			return Attack.ROAR;
		}
		else if(opponent.equals("8")){
			return Attack.ROAR;
		}
		else if(opponent.equals("7")){
			return Attack.ROAR;
		}
		else if(opponent.equals("6")){
			return Attack.ROAR;
		}
		else if(opponent.equals("5")){
			return Attack.ROAR;
		}
		else if(opponent.equals("4")){
			return Attack.ROAR;
		}
		else if(opponent.equals("3")){
			return Attack.ROAR;
		}
		else if(opponent.equals("2")){
			return Attack.ROAR;
		}
		else{
			return Attack.ROAR;
		}
	}
	
	/* Name: getColor
	 * Purpose:  returns the color of the critter for future use
	 * Parameters:   doesn't take in anything
	 * Return: the color of the critter
	 */
	public Color getColor() {
		//if even amount of food eaten, its this color
		if( foodCount %2 == 0){
			return new Color(123,104,238);
		}
		//otherwise will return this color
		else{
			return new Color(218,112,214);
		}
	}
	
	/* Name: getMove()
	 * Purpose:  moves the critter
	 * Parameters:  n/a
	 * Return: returns an enum Direction
	 */
	public Direction getMove() {
//if have time, try diamond movement
		//if move is greater than 80, resets to 0
		if(this.move > 80) {
			this.move = 0;
		}
		//increments move everytime going through this code
		this.move++;
		//return south 20 times
		if (this.move <= 20){
			Direction s = Direction.SOUTH;
			return s;
		}
		//after south, return west 20 times
		else if (this.move <= 40){
			Direction w = Direction.WEST;
			return w;
		}
		//after west, return north 20 times
		else if (this.move <= 60){
			Direction n = Direction.NORTH;
			return n;
		}
		//else, return east 20 times
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
		//creates new string object and returns it
		String porter = new String("[=◈︿◈=]");
		return porter;
	}
}
