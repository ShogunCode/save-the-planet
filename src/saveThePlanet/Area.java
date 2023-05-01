/**
 * 
 */
package saveThePlanet;

/**
 * @author
 *
 */
public class Area {
    private String name;
    private int cost;
    private int developmentLevel;
    private boolean majorDevelopment;
    private Player owner;

    public Area(String name, int cost) {
        this.name = name;
        this.cost = cost;
        this.developmentLevel = 0;
        this.majorDevelopment = false;
    }

    public void develop(Player player) {
        // Code to be added for developing the area
    }

    public void payFee(Player player) {
        // Code for paying a fee when landing on square
    }

    public boolean isOwnedBy(Player player) {
        return this.owner == player;
    }

    public int getCost() {
        return cost;
    }
    
    public boolean isOwned() {
        return this.owner != null;
    }

    public boolean isFullyDeveloped() {
        return majorDevelopment;
    }


    public void setOwner(Player player) {
        this.owner = player;
    }

    public Player getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }
}