/**
 * 
 */
package saveThePlanet;

/**
 * @author
 *
 */
public class Player {
    private String name;
    private int position;
    private int resources;

    public Player(String name, int initialResources) {
        this.name = name;
        this.position = 0;
        this.resources = initialResources;
    }

    public void takeTurn(Board board, Dice[] dice) {
        int diceSum = 0;
        for (Dice die : dice) {
            die.roll();
            diceSum += die.getFaceValue();
        }

        int newPosition = (position + diceSum) % board.getSize();
        setPosition(newPosition);

        Square currentSquare = board.getSquare(newPosition);
        currentSquare.action(this);
    }

    public void acquireArea(Area area) {
        if (!area.isOwned() && resources >= area.getCost()) {
            resources -= area.getCost();
            area.setOwner(this);
            System.out.println(name + " has acquired area " + area.getName() + " for " + area.getCost() + " resources.");
        } else {
            System.out.println(name + " cannot acquire area " + area.getName() + ".");
        }
    }

    public int getResourceBalance() {
        return resources;
    }

    public void addResources(int amount) {
        resources += amount;
    }

    public void removeResources(int amount) {
        resources -= amount;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}