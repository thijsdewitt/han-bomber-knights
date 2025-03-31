package nl.thijsdewitt.han_bomber_knights.entities.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import nl.thijsdewitt.han_bomber_knights.entities.Player;

import java.util.List;

public class UnderTheCastleWall extends UnderTheCastleTile implements Collided {
    public UnderTheCastleWall(Coordinate2D location, Size size, Integer frameIndex) {
        super(location, size, frameIndex);
    }

    @Override
    public void onCollision(List<Collider> collidingObjects) {
        collidingObjects.forEach(collider -> {
            if (collider instanceof Player player) {
                player.handleCollision(this);
            }
        });
    }
}
