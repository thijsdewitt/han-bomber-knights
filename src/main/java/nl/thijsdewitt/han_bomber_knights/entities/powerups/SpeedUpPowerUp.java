package nl.thijsdewitt.han_bomber_knights.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import nl.thijsdewitt.han_bomber_knights.entities.Player;
import org.jetbrains.annotations.NotNull;

public class SpeedUpPowerUp extends AbstractPowerUp {
    private String imagePath = "sprites/SpeedUp.png";
    protected SpeedUpPowerUp(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }

    @Override
    public void activate(@NotNull Player player) {
        player.addPowerUpToHud(this);
        // TODO: Play sound
        player.setSpeed(player.getSpeed() + 1);
    }

    @Override
    public String getImagePath() {
        return imagePath;
    }
}
