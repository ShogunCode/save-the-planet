package saveThePlanet;

public class Main {
    public static void main(String[] args) {
        // Create areas for each field
        Area area1 = new Area("Hydroelectricity", 100);
        Area area2 = new Area("Solar Power", 100);
        Area area3 = new Area("Wind Power", 100);
        Area area4 = new Area("Recycling", 50);
        Area area5 = new Area("Composting", 50);

        // Create fields
        Field field1 = new Field("Renewable Energy");
        Field field2 = new Field("Waste Management");

        // Create squares for the board
        StartSquare startSquare = new StartSquare("Collect Resources");
        Square nothingSquare = new NothingSquare("Nothing Happens");
        FieldSquare fieldSquare1 = new FieldSquare("test", field1, area5);
        FieldSquare fieldSquare2 = new FieldSquare("test", field2, area5);

        Square[] squares = new Square[]{startSquare, nothingSquare, fieldSquare1, fieldSquare2};

        // Create the board
        Board board = new Board();

        // Create players
        Player[] players = new Player[]{
                new Player("Alice", 500),
                new Player("Bob", 500),
                new Player("Charlie", 500),
                new Player("David", 500),
        };

        // Create dice
        Dice[] dice = new Dice[]{new Dice(6), new Dice(6)};

        // Initialize and start the game
        Game game = new Game(players, board, dice);
        game.startGame();

        // Simulate a few turns for each player
        for (int i = 0; i < 5; i++) {
            for (Player player : players) {
                game.playTurn();
            }
        }

        // End the game
        game.endGame();
    }
}
