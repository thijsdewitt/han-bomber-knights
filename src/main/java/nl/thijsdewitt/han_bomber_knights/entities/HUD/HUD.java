package nl.thijsdewitt.han_bomber_knights.entities.HUD;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.CompositeEntity;
import nl.thijsdewitt.han_bomber_knights.entities.powerups.AbstractPowerUp;

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
    private int maxHealth;

    private SmallIcon[] healthIcons;

    public HUD(Coordinate2D initialLocation, int width, int height, String iconPath) {
        super(initialLocation);
        this.initialLocation = initialLocation;
        this.width = width;
        this.height = height;
        this.iconPath = iconPath;
    }

    @Override
    protected void setupEntities() {
        // add player icon
        PlayerIcon playerIcon = new PlayerIcon(iconPath, initialLocation);
        addEntity(playerIcon);
        // add health text and hearts
        Text health = new Text(new Coordinate2D(initialLocation.getX() + 100, initialLocation.getY()), "Health: ");
        addEntity(health);

        // add text power-ups
        Text powerUps = new Text(new Coordinate2D(initialLocation.getX() + 100, initialLocation.getY() + 60), "PowerUps: ");
        addEntity(powerUps);

        // add hearts
        for (int i = 0; i < healthIcons.length; i++) {
            var icon = healthIcons[i];
            Coordinate2D location = new Coordinate2D(initialLocation.getX() + 100 + (i * 35), initialLocation.getY() + 24);
            icon.setAnchorLocation(location);
            addEntity(icon);
        }
    }

    public void gainPowerUp(AbstractPowerUp powerUp) {
        PowerUpsLocation = new Coordinate2D(initialLocation.getX() + 100, initialLocation.getY() + 90);
        SmallIcon powerUpIcon = new SmallIcon(powerUp.getIconPath(), PowerUpsLocation);
        addEntity(powerUpIcon);
        PowerUpsLocation = new Coordinate2D(PowerUpsLocation.getX() + 35, PowerUpsLocation.getY() + 35);
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
        healthIcons = new SmallIcon[maxHealth];
        for (int i = 0; i < maxHealth; i++) {
            healthIcons[i] = new SmallIcon("sprites/hearth.png");
        }
    }

    public void setHealth(int health) {
        for (SmallIcon healthIcon : healthIcons) {
            healthIcon.setVisible(false);
        }

        for (int i = 0; i < health; i++) {
            healthIcons[i].setVisible(true);
        }
    }
}