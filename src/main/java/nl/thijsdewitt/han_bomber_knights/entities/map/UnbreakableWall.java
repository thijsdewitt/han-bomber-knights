package nl.thijsdewitt.han_bomber_knights.entities.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class UnbreakableWall extends Tile implements CollidedTile {
    public UnbreakableWall(Coordinate2D location, Size size, TileConfig config) {
        super(location, size, config);
    }
}
