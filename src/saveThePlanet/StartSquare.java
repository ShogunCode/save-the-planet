package saveThePlanet;


public class StartSquare extends Square {
    public StartSquare(String name) {
        super(name);
    }

    @Override
    public void action(Player player) {
        // Code for  when a player lands on the StartSquare, for example, providing resources to the player
        int resourceAmount = 100;
        player.addResources(resourceAmount);
        System.out.println(player.getName() + " landed on " + getName() + " and received " + resourceAmount + " resources.");
    }
}

