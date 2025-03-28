package nl.thijsdewitt.han_bomber_knights.entities.buttons.text_button;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class TextButtonBox extends RectangleEntity {
    protected TextButtonBox(Coordinate2D initialLocation, int width, int height) {
        super(initialLocation, new Size(width, height));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setFill(Color.BLACK);
    }
}
