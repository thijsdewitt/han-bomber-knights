package nl.thijsdewitt.han_bomber_knights.entities.HUD;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class SmallIcon extends SpriteEntity {
    protected SmallIcon(String resource) {
        this(resource, new Coordinate2D());
    }

    protected SmallIcon(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation, new Size(32, 32));
    }
}
