/**
 * 
 */
package saveThePlanet;

/**
 * @author
 *
 */
public abstract class Square {
    private String name;
    private Player owner;

    public Square(String name) {
        this.name = name;
        this.owner = null;
    }

    public abstract void action(Player player);

    public void setOwner(Player player) {
        this.owner = player;
    }

    public Player getOwner() {
        return this.owner;
    }

    public String getName() {
        return this.name;
    }
}
