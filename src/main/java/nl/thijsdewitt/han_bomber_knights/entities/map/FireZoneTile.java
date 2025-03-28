package nl.thijsdewitt.han_bomber_knights.entities.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class FireZoneTile extends SpriteEntity {
    public FireZoneTile(Coordinate2D location, Size size, Integer frameIndex) {
        super("sprites/fire_zone.png", location, size, 3, 10);
        setCurrentFrameIndex(frameIndex);
    }
}
