package nl.thijsdewitt.han_bomber_knights.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import nl.thijsdewitt.han_bomber_knights.entities.player.Player;
import org.jetbrains.annotations.NotNull;

public class BiggerExplosionPowerUp extends AbstractPowerUp {
    private String iconPath = "sprites/ExplosionRadiusUp.png";

    public BiggerExplosionPowerUp(Size size) {
        super("sprites/ExplosionRadiusUp.png", new Coordinate2D(), size);
    }

    @Override
    public void activate(@NotNull Player player) {
        player.addPowerUpToHud(this);
        playSound();
        player.setExplosionRadius(player.getExplosionRadius() + 1);
    }

    @Override
    public String getIconPath() {
        return iconPath;
    }

}
