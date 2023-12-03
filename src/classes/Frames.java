package classes;

public class Frames {
    private int[] bowlingThrows;
    private int strikeBonus;
    private int spareBonus;
    private boolean isStrike;
    private boolean isSpare;
    private int score;

    /**
     * Konstruktor für die Klasse Frame.
     */
    public Frames(boolean isLastFrame) {
        int maxThrows = 2;
        if(isLastFrame == true){
            maxThrows = 3;
        }

        this.bowlingThrows = new int[maxThrows];
        for(int i = 0; i < maxThrows; i++){
            this.bowlingThrows[i] = -1;
        }
        this.strikeBonus = 0;
        this.spareBonus = 0;
        this.isStrike = false;
        this.isSpare = false;
        this.score = 0;
    }

    /**
     * Gibt den Wert des ersten Wurfs zurück.
     */
    public int getThrow(int index) {
        return this.bowlingThrows[index];
    }

     /**
     * Setzt den Wert des ersten Wurfs.
     * 
     * @param firstThrow Der Wert des ersten Wurfs.
     */
    public void setThrow(int bowlingThrow, int index) {
        this.bowlingThrows[index] = bowlingThrow;
    }

    /**
     * Gibt den Zählerwert, falls ein Strike geworfen wurde zurück.
     */
    public int getStrikeBonus() {
        return strikeBonus;
    }

    /**
     * Setzt den Zählerwert für den Bonus eines Strikes.
     * 
     * @param bonus Der Wert des Zählers für Strikebonus.
     */
    public void setStrikeBonus(int bonus) {
        this.strikeBonus = bonus;
    }

    /**
     * Gibt den Zählerwert, falls ein Spare geworfen wurde zurück.
     */
    public int getSpareBonus() {
        return spareBonus;
    }

    /**
     * Setzt den Zählerwert für den Bonus eines Strikes.
     * 
     * @param bonus Der Wert des Zählers für Sparebonus.
     */
    public void setSpareBonus(int bonus) {
        this.spareBonus = bonus;
    }

    /**
     * Gibt den Wert zurück, ob ein Strike geworfen wurde.
     */
    public boolean getIsStrike() {
        return isStrike;
    }

    /**
     * Setzt den Wert, ob ein Strike geworfen wurde.
     * 
     * @param isStrike Der Wert ob es ein Strike ist oder nicht.
     */
    public void setIsStrike(boolean isStrike) {
        this.isStrike = isStrike;
    }

    /**
     * Gibt den Wert zurück, ob ein Spare geworfen wurde.
     */
    public boolean getIsSpare() {
        return isSpare;
    }

    /**
     * Setzt den Wert, ob ein Stpare geworfen wurde.
     * 
     * @param isStrike Der Wert ob es ein Spare ist oder nicht.
     */
    public void setIsSpare(boolean isSpare) {
        this.isSpare = isSpare;
    }

    /**
     * Gibt den Punktestand des aktuellen Frames zurück.
     */
    public int getScore() {
        return score;
    }

    /**
     * Setzt den Wert des Punktestandes.
     * 
     * @param isStrike Der Wert des Punktestandes.
     */
    public void setScore(int score) {
        this.score = score;
    }
}
