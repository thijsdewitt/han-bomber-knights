package nl.thijsdewitt.han_bomber_knights.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

public abstract class Button extends DynamicCompositeEntity {
    protected Button(Coordinate2D initialLocation) {
        super(initialLocation);
    }
}
