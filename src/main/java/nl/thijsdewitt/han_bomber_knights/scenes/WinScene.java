package nl.thijsdewitt.han_bomber_knights.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import nl.thijsdewitt.han_bomber_knights.BomberKnights;
import nl.thijsdewitt.han_bomber_knights.entities.buttons.text_button.TextButton;

public abstract class WinScene extends StaticScene {
    private final BomberKnights app;

    public WinScene(BomberKnights app) {
        this.app = app;
    }

    @Override
    public void setupEntities() {
        TextButton replay = new TextButton(new Coordinate2D(getWidth() / 2, getHeight() * 0.75), "Speel opnieuw", 220);
        replay.onClick(() -> app.setActiveScene(0));
        addEntity(replay);

        TextButton exitKnop = new TextButton(new Coordinate2D(getWidth() / 2, getHeight() * 0.85), "Exit");
        exitKnop.onClick(() -> app.quit());
        addEntity(exitKnop);
    }
}
