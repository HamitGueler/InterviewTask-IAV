package classes;

public class Player {
    Frames[] frames;
    String name;

    /**
     * Konstruktor für die Klasse Player.
     */
    public Player(String name) {
        this.name = name;
        frames = new Frames[10];
        boolean isLastFrame = false;
        for (int i = 0; i < 10; i++) {
            if(i == 9){
                isLastFrame = true;
            }
            this.frames[i] = new Frames(isLastFrame);
        }
    }
}