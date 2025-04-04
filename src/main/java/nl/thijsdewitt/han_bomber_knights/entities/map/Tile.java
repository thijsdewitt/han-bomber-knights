package nl.thijsdewitt.han_bomber_knights.entities.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public abstract class Tile extends SpriteEntity implements Collider {
    public Tile(Coordinate2D location, Size size, TileConfig config) {
        super(config.resource(), location, size, 3, 10);
        setCurrentFrameIndex(config.frameIndex());
    }
}
