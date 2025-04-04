package nl.thijsdewitt.han_bomber_knights.scenes;

import nl.thijsdewitt.han_bomber_knights.BomberKnights;

public class Player1WinScreen extends WinScene {
    public Player1WinScreen(BomberKnights app) {
        super(app);
    }

    @Override
    public void setupScene() {
        setBackgroundImage("sprites/player1_win_background.png");
    }
}
