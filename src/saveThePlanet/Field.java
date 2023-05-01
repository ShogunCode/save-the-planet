/**
 * 
 */
package saveThePlanet;

/**
 * @author
 *
 */
public class Field {
    private String name;
    private Area[] areas;

    public Field(String name) {
        this.name = name;
        this.areas = new Area[4];
    }
    
    public void addArea(Area area) {
        for (int i = 0; i < areas.length; i++) {
            if (areas[i] == null) {
                areas[i] = area;
                break;
            }
        }
    }

    public boolean isOwnedBy(Player player) {
        for (Area area : areas) {
            if (!area.isOwnedBy(player)) {
                return false;
            }
        }
        return true;
    }
    
    public int getPayment() {
        // Calculating payment based on the development level of the areas in the field
        int payment = 0;
        for (Area area : areas) {
            payment += area.getCost() / 2;
        }
        return payment;
    }

    public Player getOwner() {
        // Returns the owner of the first area in the field
        // Assumes all areas in the field have the same owner
        return areas[0].isOwned() ? areas[0].getOwner() : null;
    }

    public boolean canDevelop() {
        for (Area area : areas) {
            if (!area.isFullyDeveloped()) {
                return true;
            }
        }
        return false;
    }

    public Area getAreaToDevelop() {
        for (Area area : areas) {
            if (!area.isFullyDeveloped()) {
                return area;
            }
        }
        return null;
    }

    public void developArea(Area area) {
        area.develop(null);
    }
    
    public boolean isOwned() {
        for (Area area : areas) {
            if (!area.isOwned()) {
                return false;
            }
        }
        return true;
    }
    
    public String getName() {
        return name;
    }

}
