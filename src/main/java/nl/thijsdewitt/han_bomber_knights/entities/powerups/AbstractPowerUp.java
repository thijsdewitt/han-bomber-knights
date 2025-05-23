package nl.thijsdewitt.han_bomber_knights.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import nl.thijsdewitt.han_bomber_knights.entities.player.Player;

import java.util.List;

public abstract class AbstractPowerUp extends SpriteEntity implements Collided {

    public AbstractPowerUp(String resource, Coordinate2D initialLocation, Size size) {
        super(resource, initialLocation, size);
    }

    public abstract void activate(Player player);

    @Override
    public void onCollision(List<Collider> collidingObjects) {
        collidingObjects.forEach(collidingObject -> {
            if (collidingObject instanceof Player player) {
                activate(player);
                remove();
            }
        });
    }

    public void playSound() {
        var popSound = new SoundClip("audio/power_up.wav");
        popSound.play();
    }
}
