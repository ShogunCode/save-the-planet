/**
 * 
 */
package saveThePlanet;

/**
 * @author
 *
 */
import java.util.Random;

public class Dice {
    private int sides;
    private int faceValue;
    private Random random;

    public Dice(int sides) {
        this.sides = sides;
        this.random = new Random();
        roll();
    }

    public int roll() {
        faceValue = random.nextInt(sides) + 1;
        return faceValue;
    }

    public int getFaceValue() {
        return faceValue;
    }
}
