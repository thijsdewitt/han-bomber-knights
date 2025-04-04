package nl.thijsdewitt.han_bomber_knights.entities.map.crate;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import nl.thijsdewitt.han_bomber_knights.entities.map.CollidedTile;

public class Crate extends SpriteEntity implements CollidedTile, Collider {
    private final CrateEntity parent;

    protected Crate(CrateEntity parent) {
        super("sprites/crate.png", new Coordinate2D(0, 0), parent.getSize());
        this.parent = parent;
    }

    public void destroy() {
        parent.destroy();
    }
}
