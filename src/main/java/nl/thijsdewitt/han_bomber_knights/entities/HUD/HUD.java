package nl.thijsdewitt.han_bomber_knights.entities.HUD;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.CompositeEntity;

public class HUD extends CompositeEntity {
    private final Coordinate2D initialLocation;
    private final String iconPath;

    private SmallIcon[] healthIcons;

    public HUD(Coordinate2D initialLocation, String iconPath) {
        super(initialLocation);
        this.initialLocation = initialLocation;
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

        // add hearts
        for (int i = 0; i < healthIcons.length; i++) {
            var icon = healthIcons[i];
            Coordinate2D location = new Coordinate2D(initialLocation.getX() + 100 + (i * 35), initialLocation.getY() + 24);
            icon.setAnchorLocation(location);
            addEntity(icon);
        }
    }

    public void setMaxHealth(int maxHealth) {
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