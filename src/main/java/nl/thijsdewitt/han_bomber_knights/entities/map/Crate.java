package nl.thijsdewitt.han_bomber_knights.entities.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Crate extends SpriteEntity implements CollidedTile {
    public Crate(Coordinate2D location, Size size) {
        super("sprites/crate.png", location, size);
    }
}
