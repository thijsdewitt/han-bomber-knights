package nl.thijsdewitt.han_bomber_knights.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import nl.thijsdewitt.han_bomber_knights.entities.Player;

import java.util.List;

public abstract class AbstractPowerUp extends SpriteEntity implements Collided {

    protected AbstractPowerUp(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
        if (getShowInHud()) {
            // TODO: Add to HUD
        }
    }

    public boolean getShowInHud() {
        return true;
    }

    public abstract void activate(Player player);
    public abstract String getImagePath();

    @Override
    public void onCollision(List<Collider> collidingObjects) {
        collidingObjects.forEach(collidingObject -> {
            if (collidingObject instanceof Player player) {
                activate(player);
                remove();
            }
        });
    }
}
