package nl.thijsdewitt.han_bomber_knights.entities.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import nl.thijsdewitt.han_bomber_knights.entities.player.Player;

public class PlayerLocation extends SpriteEntity {
    public PlayerLocation(Coordinate2D location, Size size, Player player) {
        super("sprites/under_the_castle.png", location, size, 3, 10);
        setCurrentFrameIndex(5);

        player.setAnchorLocation(location.add(new Coordinate2D(2,2)));
        this.setVisible(false);
    }
}
