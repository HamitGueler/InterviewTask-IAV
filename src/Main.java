import classes.BowlingGame;
import classes.Player;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Max Mustermann");
        BowlingGame game = new BowlingGame(player1);
        game.runGame();
    }
}