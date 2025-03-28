package nl.thijsdewitt.han_bomber_knights.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import nl.thijsdewitt.han_bomber_knights.entities.powerups.AbstractPowerUp;

import java.util.ArrayList;
import java.util.List;

public class Player extends DynamicSpriteEntity implements Collided, Collider {
    private static final int MAX_HEALTH = 3;

    private final ArrayList<AbstractPowerUp> powerUps = new ArrayList<>();
    private int health = 3;
    private int explosionRadius = 3;

    protected Player(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }

    @Override
    public void onCollision(List<Collider> collidingObjects) {
        collidingObjects.forEach(collidingObject -> {
            if (collidingObject instanceof AbstractPowerUp powerUp) {
                powerUp.activate(this);
                powerUp.remove();
            }
        });
    }

    public void addPowerUpToHud(AbstractPowerUp powerUp) {
        powerUps.add(powerUp);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health > MAX_HEALTH) {
            health = MAX_HEALTH;
        }
        this.health = health;
    }

    public int getExplosionRadius() {
        return explosionRadius;
    }

    public void setExplosionRadius(int explosionRadius) {
        this.explosionRadius = explosionRadius;
    }
}
