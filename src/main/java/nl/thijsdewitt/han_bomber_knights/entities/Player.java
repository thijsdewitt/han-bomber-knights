package nl.thijsdewitt.han_bomber_knights.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import nl.thijsdewitt.han_bomber_knights.entities.HUD.HUD;
import nl.thijsdewitt.han_bomber_knights.entities.map.UnderTheCastleWall;
import nl.thijsdewitt.han_bomber_knights.entities.powerups.AbstractPowerUp;
import nl.thijsdewitt.han_bomber_knights.entities.powerups.SpeedUpPowerUp;

import java.util.ArrayList;
import java.util.Set;

public class Player extends DynamicSpriteEntity implements Collider, KeyListener {
    private static final int MAX_HEALTH = 3;
    private String imagePathIcon = "sprites/BlueKnightIcon.png";
    private final ArrayList<AbstractPowerUp> powerUps = new ArrayList<>();
    private int health = 3;
    private int explosionRadius = 3;
    private int walkSpeed = 3;
    private HUD hud;

    public Player(Coordinate2D location, HUD hud) {
        super("sprites/blue_knight_16x17.png", location, new Size(56), 8, 8);
        setAutoCycle(100);
        setAutoCycleRow(4);
        this.hud = hud;
    }

    public void handleCollision(UnderTheCastleWall tile) {
        Direction direction = Direction.valueOf(getDirection());
        double centerX = this.getBoundingBox().getCenterX();
        double centerY = this.getBoundingBox().getCenterY();

        switch (direction) {
            case DOWN -> {
                setAnchorLocationY(tile.getBoundingBox().getMinY() - getHeight() - 1);
                nullifySpeedInDirection(Direction.DOWN);
                adjustHorizontalPosition(tile, centerX);
            }
            case RIGHT -> {
                setAnchorLocationX(tile.getBoundingBox().getMinX() - getWidth() - 1);
                nullifySpeedInDirection(Direction.RIGHT);
                adjustVerticalPosition(tile, centerY);
            }
            case UP -> {
                setAnchorLocationY(tile.getBoundingBox().getMaxY() + 1);
                nullifySpeedInDirection(Direction.UP);
                adjustHorizontalPosition(tile, centerX);
            }
            case LEFT -> {
                setAnchorLocationX(tile.getBoundingBox().getMaxX() + 1);
                nullifySpeedInDirection(Direction.LEFT);
                adjustVerticalPosition(tile, centerY);
            }
        }
    }

    private void adjustHorizontalPosition(UnderTheCastleWall tile, double centerX) {
        if (tile.getBoundingBox().getMinX() >= centerX) {
            setAnchorLocationX(getAnchorLocation().getX() - 1);
        }
        if (tile.getBoundingBox().getMaxX() <= centerX) {
            setAnchorLocationX(getAnchorLocation().getX() + 1);
        }
    }

    private void adjustVerticalPosition(UnderTheCastleWall tile, double centerY) {
        if (tile.getBoundingBox().getMinY() >= centerY) {
            setAnchorLocationY(getAnchorLocation().getY() - 1);
        }
        if (tile.getBoundingBox().getMaxY() <= centerY) {
            setAnchorLocationY(getAnchorLocation().getY() + 1);
        }
    }

    public void handleCollision(AbstractPowerUp powerUp) {
        powerUp.activate(this);
        powerUp.remove();
    }

    public void addPowerUpToHud(AbstractPowerUp powerUp) {
        powerUps.add(powerUp);
        hud.gainPowerUp(powerUp);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health > MAX_HEALTH) {
            health = MAX_HEALTH;
        } else if(health <= 0){
            health = 0;
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
        if (pressedKeys.isEmpty()) {
            setSpeed(0);
            setAutoCycleRow((getAutoCycleRow() % 4) + 4);
            return;
        }
        System.out.println(health);
        pressedKeys.forEach(keyCode -> {
            switch (keyCode) {
                case UP -> {
                    setAutoCycleRow(2);
                    setMotion(getWalkSpeed(), Direction.UP);
                }
                case DOWN -> {
                    setAutoCycleRow(0);
                    setMotion(getWalkSpeed(), Direction.DOWN);
                }
                case LEFT -> {
                    setAutoCycleRow(3);
                    setMotion(getWalkSpeed(), Direction.LEFT);
                }
                case RIGHT -> {
                    setAutoCycleRow(1);
                    setMotion(getWalkSpeed(), Direction.RIGHT);
                }
            }
        });
    }

    public int getWalkSpeed() {
        return walkSpeed;
    }

    public void setWalkSpeed(int walkSpeed) {
        this.walkSpeed = walkSpeed;
    }

    public String getIconPath() {
        return imagePathIcon;
    }

    public ArrayList<AbstractPowerUp> getPowerUps() {
        return powerUps;
    }
}
