package nl.thijsdewitt.han_bomber_knights.entities.tilemap;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Wall extends SpriteEntity implements Collider {
    protected Wall(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }
}
