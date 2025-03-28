package nl.thijsdewitt.han_bomber_knights.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import nl.thijsdewitt.han_bomber_knights.BomberKnights;
import nl.thijsdewitt.han_bomber_knights.entities.buttons.image_button.ImageButton;
import nl.thijsdewitt.han_bomber_knights.entities.buttons.text_button.TextButton;

public class MapSelectorScene extends StaticScene {
    private BomberKnights app;

    public MapSelectorScene(BomberKnights app) {
        this.app = app;
    }


    @Override
    public void setupScene() {

    }

    @Override
    public void setupEntities() {
        ImageButton test = new ImageButton(new Coordinate2D(100,100), "sprites/bomberman.png", 100, 100);
        test.onClick(() -> app.setActiveScene(2));
        addEntity(test);
    }
}
