package nl.thijsdewitt.han_bomber_knights.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import nl.thijsdewitt.han_bomber_knights.BomberKnights;
import nl.thijsdewitt.han_bomber_knights.entities.buttons.text_button.TextButton;

public class StartScene extends StaticScene {
    private final BomberKnights app;

    public StartScene(BomberKnights app) {
        this.app = app;
    }

    @Override
    public void setupScene() {

    }

    @Override
    public void setupEntities() {
        TextButton startKnop = new TextButton(new Coordinate2D(getWidth() / 2, getHeight() * 0.7), "Start");
        startKnop.onClick(() -> app.setActiveScene(1));
        addEntity(startKnop);

        TextButton exitKnop = new TextButton(new Coordinate2D(getWidth() / 2, getHeight() * 0.8), "Exit");
        exitKnop.onClick(() -> app.quit());
        addEntity(exitKnop);
    }
}
