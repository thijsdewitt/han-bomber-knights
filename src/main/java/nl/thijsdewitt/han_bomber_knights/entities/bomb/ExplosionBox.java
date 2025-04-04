package nl.thijsdewitt.han_bomber_knights.entities.bomb;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import nl.thijsdewitt.han_bomber_knights.entities.map.Crate;
import nl.thijsdewitt.han_bomber_knights.entities.map.UnbreakableWall;

import java.util.List;

public class ExplosionBox extends DynamicRectangleEntity implements Collided, UpdateExposer {
    private ExplosionBox parent;
    private ExplosionSprite sprite;

    public ExplosionBox() {
        this(new Coordinate2D());
    }

    public ExplosionBox(Coordinate2D location) {
        super(location, new Size(40, 40));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
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
                crate.remove();
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
