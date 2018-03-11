import java.awt.Color;
import java.io.PrintStream;
import java.util.Random;

public class Hard
extends Critter {
    private boolean hungry;
    private Critter.Direction currentDirection;
    private int directionCount;
    private Random randGen;
    private int lifespan;
    private static int count = 0;
    private static int bearRecord = 1;
    private static int tigerRecord = 1;
    private static int lionRecord = 1;
    private static int otherRecord = 1;
    private static Critter.Attack otherAttack = Critter.Attack.SCRATCH;
    private int lastX = 0;
    private int lastY = 0;
    private boolean mating;
    private boolean sleeping;
    private String currOpponent;

    public Hard() {
        ++count;
        this.hungry = true;
        this.randGen = new Random();
        this.currentDirection = Critter.Direction.SOUTH;
        this.lifespan = 0;
        this.mating = false;
        this.sleeping = false;
        this.currOpponent = "";
    }

    public boolean eat() {
        if (this.hungry || this.lifespan > 200 && count > 5) {
            this.hungry = false;
            return true;
        }
        return false;
    }

    public Critter.Attack fight(String string) {
        boolean bl = false;
        this.currOpponent = string;
        int n = 1;
        try {
            n = Integer.parseInt(string);
            this.currOpponent = "T";
            bl = true;
        }
        catch (Exception var4_4) {
            bl = false;
        }
        int n2 = this.getRecord(this.currOpponent);
        Critter.Attack attack = Critter.Attack.ROAR;
        int n3 = this.randGen.nextInt(3);
        attack = n3 == 0 ? Critter.Attack.ROAR : (n3 == 1 ? Critter.Attack.SCRATCH : Critter.Attack.POUNCE);
        if (string.equals("B")) {
            if (n2 >= 0) {
                return Critter.Attack.ROAR;
            }
            return attack;
        }
        if (bl) {
            if (n2 >= 0) {
                if (n > 0) {
                    return Critter.Attack.ROAR;
                }
                return Critter.Attack.SCRATCH;
            }
            return attack;
        }
        if (string.equals("L")) {
            if (n2 >= 0) {
                if (this.toString().equals("B")) {
                    return Critter.Attack.POUNCE;
                }
                return Critter.Attack.SCRATCH;
            }
            return attack;
        }
        if (n2 >= 0) {
            return otherAttack;
        }
        otherAttack = attack;
        return attack;
    }

    public Color getColor() {
        return Color.RED;
    }

    public Critter.Direction getMove() {
        int n = this.getX();
        int n2 = this.getY();
        if (n == this.lastX && n2 == this.lastY) {
            this.lastX = n;
            this.lastY = n2;
            this.setRandomDirection();
            return this.currentDirection;
        }
        this.updateTime();
        this.lastX = n;
        this.lastY = n2;
        if (this.getNeighbor(Critter.Direction.SOUTH).equals(".") && count > 8 && (this.lifespan > 200 || this.hungry)) {
            return Critter.Direction.SOUTH;
        }
        if (this.getNeighbor(Critter.Direction.NORTH).equals(".") && count > 8 && (this.lifespan > 200 || this.hungry)) {
            return Critter.Direction.NORTH;
        }
        if (this.getNeighbor(Critter.Direction.WEST).equals(".") && count > 8 && (this.lifespan > 200 || this.hungry)) {
            return Critter.Direction.WEST;
        }
        if (this.getNeighbor(Critter.Direction.EAST).equals(".") && count > 8 && (this.lifespan > 200 || this.hungry)) {
            return Critter.Direction.EAST;
        }
        if (!this.getNeighbor(Critter.Direction.SOUTH).equals(" ") && !this.getNeighbor(Critter.Direction.SOUTH).equals(".")) {
            if (this.getRecord(this.getNeighbor(Critter.Direction.SOUTH)) > 0) {
                return Critter.Direction.SOUTH;
            }
            return Critter.Direction.NORTH;
        }
        if (!this.getNeighbor(Critter.Direction.NORTH).equals(" ") && !this.getNeighbor(Critter.Direction.NORTH).equals(".")) {
            if (this.getRecord(this.getNeighbor(Critter.Direction.NORTH)) > 0 && count > 4) {
                return Critter.Direction.NORTH;
            }
            return Critter.Direction.SOUTH;
        }
        if (!this.getNeighbor(Critter.Direction.EAST).equals(" ") && !this.getNeighbor(Critter.Direction.EAST).equals(".")) {
            if (this.getRecord(this.getNeighbor(Critter.Direction.EAST)) > 0 && count > 4) {
                return Critter.Direction.EAST;
            }
            return Critter.Direction.WEST;
        }
        if (!this.getNeighbor(Critter.Direction.WEST).equals(" ") && !this.getNeighbor(Critter.Direction.WEST).equals(".")) {
            if (this.getRecord(this.getNeighbor(Critter.Direction.WEST)) > 0 && count > 4) {
                return Critter.Direction.WEST;
            }
            return Critter.Direction.EAST;
        }
        if (this.lifespan % 20 == 0) {
            this.setRandomDirection();
        }
        return this.currentDirection;
    }

    public String toString() {
        if (this.lifespan % 4 > 0) {
            return "B";
        }
        if (this.lifespan % 4 < 2) {
            return "L";
        }
        return "" + this.lifespan % 10;
    }

    private void setRandomDirection() {
        int n = this.randGen.nextInt(4);
        this.currentDirection = n == 0 ? Critter.Direction.NORTH : (n == 1 ? Critter.Direction.EAST : (n == 2 ? Critter.Direction.SOUTH : Critter.Direction.WEST));
    }

    public void updateTime() {
        ++this.lifespan;
    }

    private int getRecord(String string) {
        if (string.equals("B")) {
            return bearRecord;
        }
        if (string.equals("T")) {
            return tigerRecord;
        }
        if (string.equals("L")) {
            return lionRecord;
        }
        return otherRecord;
    }

    private void setRecord(String string, boolean bl) {
        if (string.equals("B")) {
            if (bl && bearRecord < 3) {
                ++bearRecord;
            } else if (!bl && bearRecord > -2) {
                --bearRecord;
            }
        } else if (string.equals("T")) {
            if (bl && tigerRecord < 3) {
                ++tigerRecord;
            } else if (!bl && tigerRecord > -2) {
                --tigerRecord;
            }
        } else if (string.equals("L")) {
            if (bl && lionRecord < 3) {
                ++lionRecord;
            } else if (!bl && lionRecord > -2) {
                --lionRecord;
            }
        } else if (bl && otherRecord < 2) {
            ++otherRecord;
        } else if (!bl && tigerRecord > -2) {
            --otherRecord;
        }
    }

    public void win() {
        this.setRecord(this.currOpponent, true);
    }

    public void lose() {
        --count;
        if (!this.mating && this.isAwake()) {
            this.setRecord(this.currOpponent, false);
        }
    }

    public void printRecord() {
        System.out.println("B    L    T   O");
        System.out.println("" + bearRecord + "   " + lionRecord + "  " + tigerRecord + "  " + otherRecord);
    }

    public void mate() {
        this.mating = true;
    }

    public void endMate() {
        this.mating = false;
    }
}