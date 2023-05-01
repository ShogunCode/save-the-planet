/**
 * 
 */
package saveThePlanet;

/**
 * @author
 *
 */
import java.util.Scanner;


public class Game {
    private Player[] players;
    private Board board;
    private int currentPlayerIndex;
    private Dice[] dice;

    public Game(Player[] players, Board board, Dice[] dice) {
        this.players = players;
        this.board = board;
        this.currentPlayerIndex = 0;
        this.dice = dice;
    }
    
    /*public Game(int numberOfPlayers) {
        players = new Player[numberOfPlayers];
        board = new Board();
        currentPlayerIndex = 0;
        dice = new Dice[]{new Dice(6), new Dice(6)};
    }*/

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < players.length; i++) {
            System.out.println("Enter name for player " + (i + 1) + ": ");
            String playerName = scanner.nextLine();
            players[i] = new Player(playerName, currentPlayerIndex);
        }
    }

    public void playTurn() {
        int roll = dice[0].roll() + dice[1].roll();
        Player currentPlayer = players[currentPlayerIndex];
        currentPlayer.setPosition((currentPlayer.getPosition() + roll) % board.getSize());
        Square currentSquare = board.getSquare(currentPlayer.getPosition());
        currentSquare.action(currentPlayer);
        currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
    }

    public void displayGameState() {
        System.out.println("Current game state:");
        for (Player player : players) {
            System.out.println(player.getName() + " has " + player.getResourceBalance() + " resources.");
        }
    }

    public void endGame() {
        System.out.println("The game has ended. Thank you for playing!");
    }
}
