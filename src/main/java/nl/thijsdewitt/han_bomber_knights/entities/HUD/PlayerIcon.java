package nl.thijsdewitt.han_bomber_knights.entities.HUD;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class PlayerIcon extends SpriteEntity {

    protected PlayerIcon(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation, new Size(96, 96));
    }
}
