package nl.thijsdewitt.han_bomber_knights.entities.bomb;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class ExplosionEntity extends DynamicSpriteEntity {
    protected ExplosionEntity(String resource, Coordinate2D initialLocation, Size size, int rows, int columns) {
        super(resource, initialLocation, size, rows, columns);
    }
}
