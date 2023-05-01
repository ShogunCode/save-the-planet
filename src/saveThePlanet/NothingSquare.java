package saveThePlanet;

public class NothingSquare extends Square {
    public NothingSquare(String name) {
        super(name);
    }

    @Override
    public void action(Player player) {
        System.out.println(player.getName() + " has landed on " + getName() + ". Nothing happens.");
    }
}