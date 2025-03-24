package nl.thijsdewitt.han_bomber_knights.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;

public class TextButton extends Button {
    protected TextButton(Coordinate2D initialLocation, String title) {
        super(initialLocation);
    }

    @Override
    protected void setupEntities() {
    }
}
