package nl.thijsdewitt.han_bomber_knights.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import nl.thijsdewitt.han_bomber_knights.entities.player.Player;
import org.jetbrains.annotations.NotNull;

public class HealthPowerUp extends AbstractPowerUp {
    private String iconPath = "sprites/HealthUp.png";
    public HealthPowerUp(Size size) {
        super("sprites/HealthUp.png", new Coordinate2D(), size);
    }

    @Override
    public boolean getShowInHud() {
        return false;
    }

    @Override
    public void activate(@NotNull Player player) {
        playSound();
        player.setHealth(player.getHealth() + 1);
    }

    @Override
    public String getIconPath() {
        return iconPath;
    }
}
