package nl.thijsdewitt.han_bomber_knights.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;

public class ImageButton extends Button {
    protected ImageButton(Coordinate2D initialLocation, String imagePath) {
        super(initialLocation);
    }

    @Override
    protected void setupEntities() {
    }
}
