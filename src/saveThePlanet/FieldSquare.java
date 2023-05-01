package saveThePlanet;


public class FieldSquare extends Square {
    private Field field;
    private Area area;
    
    public FieldSquare(String name, Field field, Area area) {
        super(name);
        this.field = field;
        this.area = area;
    }

    @Override
    public void action(Player player) {
        System.out.println(player.getName() + " has landed on " + getName());
        if (field.isOwnedBy(player)) {
            if (field.canDevelop()) {
                Area areaToDevelop = field.getAreaToDevelop();
                player.acquireArea(areaToDevelop);
                field.developArea(areaToDevelop);
            } else {
                System.out.println("You cannot develop this field at the moment.");
            }
        } else {
            // Offer the field to the player if it is not owned by anyone
            if (!field.isOwned()) {
                player.acquireArea(field.getAreaToDevelop());
            } else {
                // Pay the field owner if the field is owned by another player
                int payment = field.getPayment();
                Player owner = field.getOwner();
                player.removeResources(payment);
                owner.addResources(payment);
                System.out.println(player.getName() + " paid " + payment + " resources to " + owner.getName());
            }
        }
    }
}