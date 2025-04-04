package nl.thijsdewitt.han_bomber_knights.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import nl.thijsdewitt.han_bomber_knights.entities.player.Player;
import org.jetbrains.annotations.NotNull;

public class SpeedUpPowerUp extends AbstractPowerUp {
    public SpeedUpPowerUp(Size size) {
        super("sprites/tiles/SpeedUp.png", new Coordinate2D(), size);
    }

    @Override
    public void activate(@NotNull Player player) {
        playSound();
        player.setWalkSpeed(player.getWalkSpeed() + 1);
    }
}
