package nl.thijsdewitt.han_bomber_knights.entities.HUD;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Text extends TextEntity {
    public Text(Coordinate2D initialLocation, String text) {
        super(initialLocation, text);
        setFont(Font.font("Roboto", FontWeight.BOLD, 18));
        setFill(Color.WHITE);
    }
}
