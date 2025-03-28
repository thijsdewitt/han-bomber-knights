package nl.thijsdewitt.han_bomber_knights.entities.buttons.text_button;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TextButtonTitle extends TextEntity {
    public TextButtonTitle(Coordinate2D initialLocation, String text) {
        super(initialLocation, text);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
        setFill(Color.WHITE);
    }

    public void SetFill(Color color) {
        setFill(color);
    }
}
