package nl.thijsdewitt.han_bomber_knights;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import nl.thijsdewitt.han_bomber_knights.scenes.*;

public class BomberKnights extends YaegerGame {
    public static final Size SCREEN_SIZE = new Size(1280, 864);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Bomber Knights");
        setSize(SCREEN_SIZE);
    }

    @Override
    public void setupScenes() {
        addScene(0, new StartScene(this));
        addScene(1, new GameScene(this));
        addScene(2, new Player1WinScreen(this));
        addScene(3, new Player2WinScreen(this));

        setActiveScene(0);
    }
}
