package nl.thijsdewitt.han_bomber_knights.entities.map.crate;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import nl.thijsdewitt.han_bomber_knights.entities.map.CollidedTile;

public class Crate extends SpriteEntity implements CollidedTile {
    protected Crate(Coordinate2D location, Size size) {
        super("sprites/crate.png", new Coordinate2D(0,0), size);
    }


}
