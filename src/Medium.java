import java.awt.Color;
import java.util.Random;

public class Medium
extends Critter {
    private int getRand;
    private static int ally = 0;
    private static boolean ultimate;
    private Random randGen;
    private boolean matingSleeping;
    private static String s;

    public Medium() {
        ultimate = false;
        ++ally;
        this.randGen = new Random();
        this.getRand = this.randGen.nextInt(3);
        s = this.getRand == 1 ? "B" : (this.getRand == 2 ? "L" : "" + this.randGen.nextInt(10));
        this.matingSleeping = false;
    }

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
        return s;
    }

    public Color getColor() {
        int n = ally / 25;
        return new Color(255 * n, 255 * n, 255 * n);
    }

    public boolean eat() {
        if (ally > 15 || ally < 5) {
            return true;
        }
        return false;
    }

    public void lose() {
        if (!this.matingSleeping && !this.matingSleeping) {
            ultimate = true;
        }
        --ally;
    }

    public void win() {
        ultimate = false;
    }

    public void mate() {
        this.matingSleeping = true;
    }

    public void mateEnd() {
        this.matingSleeping = false;
    }

    public void sleep() {
        this.matingSleeping = true;
    }

    public void wakeup() {
        this.matingSleeping = false;
    }

    public Critter.Attack fight(String string) {
        if (!ultimate) {
            String string2 = string;
            if (string.equals("B")) {
                return Critter.Attack.ROAR;
            }
            if (string.equals("L")) {
                return Critter.Attack.POUNCE;
            }
            if (string2.equals("9") || string2.equals("8") || string2.equals("7") || string2.equals("6") || string2.equals("5") || string2.equals("4") || string2.equals("3") || string2.equals("2") || string2.equals("1")) {
                return Critter.Attack.ROAR;
            }
            if (string.equals("0")) {
                return Critter.Attack.SCRATCH;
            }
            this.getRand = this.randGen.nextInt(3);
            if (this.getRand == 1) {
                return Critter.Attack.ROAR;
            }
            if (this.getRand == 2) {
                return Critter.Attack.POUNCE;
            }
            return Critter.Attack.SCRATCH;
        }
        if (string.equals("B")) {
            return Critter.Attack.ROAR;
        }
        if (string.equals("L")) {
            return Critter.Attack.POUNCE;
        }
        if (string.equals("0")) {
            return Critter.Attack.ROAR;
        }
        if (string.equals("0") || string.equals("1") || string.equals("2") || string.equals("2") || string.equals("3") || string.equals("4") || string.equals("5") || string.equals("6") || string.equals("7") || string.equals("8") || string.equals("9")) {
            return Critter.Attack.POUNCE;
        }
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