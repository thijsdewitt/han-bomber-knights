package nl.thijsdewitt.han_bomber_knights.entities.bomb;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

public class Explosion extends DynamicCompositeEntity implements TimerContainer {
    private final int explosionRadius;

    protected Explosion(Coordinate2D location, int explosionRadius) {
        super(location);
        this.explosionRadius = explosionRadius;
    }

    @Override
    protected void setupEntities() {
        addEntity(new ExplosionBox());
        addEntity(new ExplosionSprite());

        int[][] directions = {{0, -64}, {64, 0}, {0, 64}, {-64, 0},};
        for (int i = 0; i < directions.length; i++) {
            int[] direction = directions[i];
            ExplosionBox parentBox = null;
            for (int j = 1; j < explosionRadius; j++) {
                var location = new Coordinate2D(direction[0] * j, direction[1] * j);

                var sprite = new ExplosionSprite(i % 2 + 2, location);
                var explosionBox = new ExplosionBox(location);
                explosionBox.setParent(parentBox);
                explosionBox.setSprite(sprite);
                addEntity(explosionBox);
                addEntity(sprite);

                parentBox = explosionBox;
            }
        }
    }

    @Override
    public void setupTimers() {
        addTimer(new ExplosionTimer(this));
    }

    private static final class ExplosionTimer extends Timer {
        private final Explosion parent;

        public ExplosionTimer(Explosion parent) {
            super(100);
            this.parent = parent;
        }

        @Override
        public void onAnimationUpdate(long timestamp) {
            parent.remove();
        }
    }
}
