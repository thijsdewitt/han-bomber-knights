package nl.thijsdewitt.han_bomber_knights.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import nl.thijsdewitt.han_bomber_knights.entities.powerups.AbstractPowerUp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Player extends DynamicSpriteEntity implements Collided, Collider, KeyListener {
    private static final int MAX_HEALTH = 3;

    private final ArrayList<AbstractPowerUp> powerUps = new ArrayList<>();
    private int health = 3;
    private int explosionRadius = 3;
    private int walkSpeed = 3;

    public Player(Coordinate2D location) {
        super("sprites/Blue Knight run Sprite-sheet 16x17.png", location, new Size(64), 4, 8);
        setAutoCycle(1000 / 8);
        setAutoCycleRow(0);
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

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.UP)) {
            setMotion(walkSpeed, Direction.UP);
            setAutoCycleRow(2);
        } else if (pressedKeys.contains(KeyCode.DOWN)) {
            setMotion(walkSpeed, Direction.DOWN);
            setAutoCycleRow(0);
        } else if (pressedKeys.contains(KeyCode.LEFT)) {
            setMotion(walkSpeed, Direction.LEFT);
            setAutoCycleRow(3);
        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
            setMotion(walkSpeed, Direction.RIGHT);
            setAutoCycleRow(1);
        } else {
            setSpeed(0);
        }
    }

    public int getWalkSpeed() {
        return walkSpeed;
    }

    public void setWalkSpeed(int walkSpeed) {
        this.walkSpeed = walkSpeed;
    }
}
