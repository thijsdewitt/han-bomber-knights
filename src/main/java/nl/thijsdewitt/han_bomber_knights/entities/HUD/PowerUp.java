package nl.thijsdewitt.han_bomber_knights.entities.HUD;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import nl.thijsdewitt.han_bomber_knights.entities.powerups.AbstractPowerUp;

public class PowerUp extends SpriteEntity {
    protected PowerUp(Coordinate2D initialLocation, AbstractPowerUp powerUp) {
        super(powerUp.getIconPath(), initialLocation, new Size(8, 8));
    }
}
