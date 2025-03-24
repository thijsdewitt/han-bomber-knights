package nl.thijsdewitt.han_bomber_knights.entities.tilemap;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Crate extends SpriteEntity implements Collider {
    protected Crate(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }
}
