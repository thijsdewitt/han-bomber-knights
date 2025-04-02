package nl.thijsdewitt.han_bomber_knights.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import nl.thijsdewitt.han_bomber_knights.entities.Player;
import org.jetbrains.annotations.NotNull;

public class BiggerExplosionPowerUp extends AbstractPowerUp {
    private String imagePath = "sprites/ExplosionRadiusUp.png";

    protected BiggerExplosionPowerUp(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }

    @Override
    public void activate(@NotNull Player player) {
        player.addPowerUpToHud(this);
        // TODO: Play sound
        player.setExplosionRadius(player.getExplosionRadius() + 1);
    }

    @Override
    public String getImagePath() {
        return imagePath;
    }
}
