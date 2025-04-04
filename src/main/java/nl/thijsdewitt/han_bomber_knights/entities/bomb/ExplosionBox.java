package nl.thijsdewitt.han_bomber_knights.entities.bomb;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import nl.thijsdewitt.han_bomber_knights.entities.map.UnbreakableWall;
import nl.thijsdewitt.han_bomber_knights.entities.map.crate.Crate;
import nl.thijsdewitt.han_bomber_knights.entities.player.Player;

import java.util.List;

public class ExplosionBox extends DynamicRectangleEntity implements Collided, UpdateExposer {
    private ExplosionBox parent;
    private ExplosionSprite sprite;
    private final Explosion compositeEntity;

    public ExplosionBox(Explosion compositeEntity) {
        this(compositeEntity, new Coordinate2D());
    }

    public ExplosionBox(Explosion compositeEntity, Coordinate2D location) {
        super(location, new Size(40, 40));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        this.compositeEntity = compositeEntity;
    }

    @Override
    public void onCollision(List<Collider> collidingObjects) {
        if (parent != null && !parent.isVisible()) {
            this.remove();
            return;
        }

        for (Collider collider : collidingObjects) {
            if (collider instanceof UnbreakableWall) {
                this.remove();
                return;
            }

            if (collider instanceof Crate crate) {
                crate.destroy();
            }

            if (collider instanceof Player player) {
                player.hit(compositeEntity);
            }
        }

        if (sprite != null) {
            sprite.setVisible(true);
        }
    }

    public void setParent(ExplosionBox parent) {
        this.parent = parent;
    }

    @Override
    public void explicitUpdate(long timestamp) {
        if (parent != null && !parent.isVisible()) {
            this.remove();
        }
    }

    public void setSprite(ExplosionSprite sprite) {
        this.sprite = sprite;
    }
}
