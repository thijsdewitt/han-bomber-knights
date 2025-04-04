package nl.thijsdewitt.han_bomber_knights.scenes;

import nl.thijsdewitt.han_bomber_knights.BomberKnights;

public class Player2WinScreen extends WinScene {
    public Player2WinScreen(BomberKnights app) {
        super(app);
    }

    @Override
    public void setupScene() {
        setBackgroundImage("sprites/player2_win_background.png");
    }
}
