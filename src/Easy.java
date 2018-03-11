import java.awt.Color;
import java.util.Random;

public class Easy
extends Critter {
    private int getRand;
    private Random randGen = new Random();

    public Critter.Direction getMove() {
        this.getRand = this.randGen.nextInt(4);
        if (this.getRand == 1) {
            return Critter.Direction.WEST;
        }
        if (this.getRand == 2) {
            return Critter.Direction.EAST;
        }
        if (this.getRand == 3) {
            return Critter.Direction.SOUTH;
        }
        return Critter.Direction.NORTH;
    }

    public String toString() {
        return "E";
    }

    public Color getColor() {
        return new Color(0, 255, 0);
    }

    public boolean eat() {
        return true;
    }

    public Critter.Attack fight(String string) {
        this.getRand = this.randGen.nextInt(3);
        if (this.getRand == 1) {
            return Critter.Attack.ROAR;
        }
        if (this.getRand == 2) {
            return Critter.Attack.POUNCE;
        }
        return Critter.Attack.SCRATCH;
    }
}