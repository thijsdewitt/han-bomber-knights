package nl.thijsdewitt.han_bomber_knights.entities.bomb;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class ExplosionSprite extends DynamicSpriteEntity {
    public ExplosionSprite() {
        this(1, new Coordinate2D());
        setVisible(true);
    }

    public ExplosionSprite(int frameIndex, Coordinate2D location) {
        super("sprites/explosion.png", location, new Size(64), 1, 4);
        setCurrentFrameIndex(frameIndex);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setVisible(false);
    }
}
