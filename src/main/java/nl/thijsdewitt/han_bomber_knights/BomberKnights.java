package nl.thijsdewitt.han_bomber_knights;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;

public class BomberKnights extends YaegerGame {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Bomber Knights");
        setSize(new Size(800, 600));
    }

    @Override
    public void setupScenes() {

    }
}
