package nl.thijsdewitt.han_bomber_knights.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import nl.thijsdewitt.han_bomber_knights.entities.Player;
import org.jetbrains.annotations.NotNull;

public class HealthPowerUp extends AbstractPowerUp {
    protected HealthPowerUp(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }

    @Override
    public boolean getShowInHud() {
        return false;
    }

    @Override
    public void activate(@NotNull Player player) {
        play_sound();
        player.setHealth(player.getHealth() + 1);
    }
}
