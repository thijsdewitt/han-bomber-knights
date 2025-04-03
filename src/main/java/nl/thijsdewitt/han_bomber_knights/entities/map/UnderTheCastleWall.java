package nl.thijsdewitt.han_bomber_knights.entities.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class UnderTheCastleWall extends UnderTheCastleTile implements CollidedTile {
    public UnderTheCastleWall(Coordinate2D location, Size size, Integer frameIndex) {
        super(location, size, frameIndex);
    }
}
