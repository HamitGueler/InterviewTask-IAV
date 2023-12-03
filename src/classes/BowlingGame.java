package classes;

import java.util.Scanner;

public class BowlingGame {
    private Player player;

    /**
     * Konstruktor für die Klasse BowlingGame.
     */
    public BowlingGame(Player player) {
        this.player = player;
    }

    /**
     * Kontrolliert ob es sich bei dem aktuellen Frame um einen Strike handelt oder
     * nicht.
     * 
     * @param currentFrame    Der Index des aktuellen Frames.
     * @param knockedDownPins Umgeworfene Pins des ersten Wurfes.
     */
    public boolean checkStrike(int currentFrame, int knockedDownPins) {
        this.player.frames[currentFrame].setIsStrike(knockedDownPins == 10 ? true : false);
        return this.player.frames[currentFrame].getIsStrike();
    }

    /**
     * Kontrolliert ob es sich bei dem aktuellen Frame um einen Spare handelt oder
     * nicht.
     * 
     * @param currentFrame    Der Index des aktuellen Frames.
     * @param knockedDownPins Umgeworfene Pins des zweiten Wurfes.
     */
    public boolean checkSpare(int currentFrame, int knockedDownPins) {
        int sumofThrowedPins = this.player.frames[currentFrame].getThrow(0) + knockedDownPins;
        this.player.frames[currentFrame].setIsSpare(sumofThrowedPins == 10 ? true : false);
        return this.player.frames[currentFrame].getIsSpare();
    }

    /**
     * Printed das Scoreboard des Spieles, mithilfe der Werte aus den Frames.
     */
    public void printScoringBoard() {
        System.out.print("------------------------------------------------------------\n");
        for (int j = 0; j < 10; j++) {
            int firstThrow = this.player.frames[j].getThrow(0);
            String firstThrowDisplay = (this.player.frames[j].getThrow(0) == 10) ? "X" : String.valueOf(firstThrow);

            int secondThrow = this.player.frames[j].getThrow(1);
            String secondThrowDisplay = (firstThrow + secondThrow == 10) ? "/" : String.valueOf(secondThrow);

            String scoreDisplay = String.valueOf(this.player.frames[j].getScore());
            System.out.printf("%-8s|%-10s|%-10s|%-10s|\n",
                    (j + 1) + ".FRAME", "1.Wurf: " + firstThrowDisplay, "2.Wurf: " + secondThrowDisplay, "SCORE: " + scoreDisplay);
        }
        System.out.print("------------------------------------------------------------\n");
    }

    public boolean calculateScore(int currentFrame, int pins) {
        int prevScore = 0;
        if (currentFrame > 0) {
            prevScore = this.player.frames[currentFrame - 1].getScore();
        }

        if (this.player.frames[currentFrame].getThrow(0) == -1) {
            if (checkStrike(currentFrame, pins) == true) {
                System.out.println("GLÜCKWUNSCH DU HAST EINEN STRIKE!!!");
                this.player.frames[currentFrame].setStrikeBonus(2);
                this.player.frames[currentFrame].setThrow(pins, 0);
                this.player.frames[currentFrame].setScore(prevScore + this.player.frames[currentFrame].getThrow(0));
                return true;
            }
            this.player.frames[currentFrame].setThrow(pins, 0);
            this.player.frames[currentFrame].setScore(prevScore + this.player.frames[currentFrame].getThrow(0));
        } else if (this.player.frames[currentFrame].getThrow(1) == -1) {
            if (checkSpare(currentFrame, pins) == true) {
                System.out.println("GUT GEMACHT DU HAST EINEN SPARE!!!");
                this.player.frames[currentFrame].setSpareBonus(1);
            }
            this.player.frames[currentFrame].setThrow(pins, 1);
            this.player.frames[currentFrame].setScore(prevScore + this.player.frames[currentFrame].getThrow(0)
                    + this.player.frames[currentFrame].getThrow(1));
        }
        return false;
    }

    public void runGame() {
        Scanner scanner = new Scanner(System.in);
        for (int currentFrame = 0; currentFrame < this.player.frames.length; currentFrame++) {
            System.out.print("------------------------------------------------------------\n");
            System.out.print((currentFrame + 1) + ".Runde: \n");

            for (int bowlingThrows = 0; bowlingThrows < 2; bowlingThrows++) {
                System.out.print((bowlingThrows + 1)
                        + ".Wurf - Wie viele Kegel hast du umgestoßen (|1|2]3|4|5|6|7|8|9|10|): \n");
                int throwedPins = Integer.parseInt(scanner.nextLine());

                boolean isStrike = calculateScore(currentFrame, throwedPins);
                if (isStrike == true && currentFrame + 1 != 10) {
                    break;
                }
            }

            printScoringBoard();
        }
    }

}