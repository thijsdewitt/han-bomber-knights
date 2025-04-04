package nl.thijsdewitt.han_bomber_knights.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import nl.thijsdewitt.han_bomber_knights.entities.player.Player;
import org.jetbrains.annotations.NotNull;

public class HealthPowerUp extends AbstractPowerUp {
    public HealthPowerUp(Size size) {
        super("sprites/HealthUp.png", new Coordinate2D(), size);
    }

    @Override
    public void activate(@NotNull Player player) {
        playSound();
        player.setHealth(player.getHealth() + 1);
    }
}
