package nl.thijsdewitt.han_bomber_knights;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import nl.thijsdewitt.han_bomber_knights.scenes.*;

public class BomberKnights extends YaegerGame {
    public static final Size SCREEN_SIZE = new Size(1248, 832);

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
        addScene(0, new StartScene());
        addScene(1, new MapSelectorScene());
        addScene(2, new FireZoneGameScene());
        addScene(3, new UnderTheCastleGameScene());
        addScene(4, new WinScene());

        setActiveScene(2);
    }
}
