package nl.thijsdewitt.han_bomber_knights.entities.map;

import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import nl.thijsdewitt.han_bomber_knights.entities.player.Player;

import java.util.List;

public interface CollidedTile extends Collided {

    default void onCollision(List<Collider> collidingObjects) {
        collidingObjects.forEach(collider -> {
            if (collider instanceof Player player) {
                player.handleCollision(this);
            }
        });
    }
}
