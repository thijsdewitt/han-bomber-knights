package nl.thijsdewitt.han_bomber_knights;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import nl.thijsdewitt.han_bomber_knights.scenes.GameScene;
import nl.thijsdewitt.han_bomber_knights.scenes.MapSelectorScene;
import nl.thijsdewitt.han_bomber_knights.scenes.StartScene;
import nl.thijsdewitt.han_bomber_knights.scenes.WinScene;

public class BomberKnights extends YaegerGame {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Bomber Knights");
        setSize(new Size(1200, 800));
    }

    @Override
    public void setupScenes() {
        addScene(0, new StartScene(this));
        addScene(1, new MapSelectorScene(this));
        addScene(2, new GameScene());
        addScene(3, new WinScene());
        setActiveScene(0);
    }
}
