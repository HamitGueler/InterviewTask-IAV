package classes;

public class BowlingGame {
    private Player player;

    /**
     * Konstruktor für die Klasse BowlingGame.
     */
    public BowlingGame(Player player) {
        this.player = player;
    }

    public void runGame() {
        System.out.print("Bowling wird gespielt...");
    }
}