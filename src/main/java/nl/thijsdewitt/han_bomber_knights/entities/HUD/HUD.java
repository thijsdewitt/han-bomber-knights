package nl.thijsdewitt.han_bomber_knights.entities.HUD;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.CompositeEntity;
import nl.thijsdewitt.han_bomber_knights.entities.Player;
import nl.thijsdewitt.han_bomber_knights.entities.powerups.AbstractPowerUp;

import java.util.ArrayList;

public class HUD extends CompositeEntity {
    private Coordinate2D initialLocation;
    private int width;
    private int height;
    private String iconPath;
    private Coordinate2D hartje1Location;
    private Coordinate2D hartje2Location;
    private Coordinate2D hartje3Location;
    private SmallIcon hartje1;
    private SmallIcon hartje2;
    private SmallIcon hartje3;
    private Coordinate2D PowerUpsLocation;

    public HUD(Coordinate2D initialLocation, int width, int height, String iconPath) {
        super(initialLocation);
        this.initialLocation = initialLocation;
        this.width = width;
        this.height = height;
        this.iconPath = iconPath;
        hartje1Location = new Coordinate2D(initialLocation.getX() + 100, initialLocation.getY() + 35);
        hartje2Location = new Coordinate2D(initialLocation.getX() + 135, initialLocation.getY() + 35);
        hartje3Location = new Coordinate2D(initialLocation.getX() + 170, initialLocation.getY() + 35);
    }

    @Override
    protected void setupEntities() {
        // add player icon
        PlayerIcon playerIcon = new PlayerIcon(iconPath, initialLocation);
        addEntity(playerIcon);
        // add health text and hearts
        Text health = new Text(new Coordinate2D(initialLocation.getX() + 100, initialLocation.getY()), "Health: ");
        addEntity(health);
        hartje1 = new SmallIcon("sprites/Hartje.png", hartje1Location);
        addEntity(hartje1);
        hartje2 = new SmallIcon("sprites/Hartje.png", hartje2Location);
        addEntity(hartje2);
        hartje3 = new SmallIcon("sprites/Hartje.png", hartje3Location);
        addEntity(hartje3);
        // add text power-ups
        Text powerUps = new Text(new Coordinate2D(initialLocation.getX() + 100, initialLocation.getY() + 60), "PowerUps: ");
        addEntity(powerUps);
    }

    public void gainHartje(int health) {
        switch (health) {
            case 2:
                hartje2 = new SmallIcon("sprites/Hartje.png", hartje2Location);
                addEntity(hartje2);
                break;
            case 3:
                hartje3 = new SmallIcon("sprites/Hartje.png", hartje3Location);
                addEntity(hartje3);
                break;
            default:
                break;
        }
    }

    public void loseHartje(int health) {
        switch (health) {
            case 0:
                hartje2.remove();
                break;
            case 1:
                hartje2.remove();
                break;
            case 2:
                hartje3.remove();
                break;
            default:
                break;
        }
    }

    public void gainPowerUp(AbstractPowerUp powerUp) {
        PowerUpsLocation = new Coordinate2D(initialLocation.getX() + 100, initialLocation.getY() + 90);
        SmallIcon powerUpIcon = new SmallIcon(powerUp.getImagePath(), PowerUpsLocation);
        addEntity(powerUpIcon);
        PowerUpsLocation = new Coordinate2D(PowerUpsLocation.getX() + 35, PowerUpsLocation.getY() + 35);
    }
}