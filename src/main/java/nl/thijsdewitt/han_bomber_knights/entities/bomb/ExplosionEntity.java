package nl.thijsdewitt.han_bomber_knights.entities.bomb;

import com.github.hanyaeger.api.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class ExplosionEntity extends DynamicSpriteEntity implements TimerContainer {
    public ExplosionEntity(Coordinate2D location, int frameIndex) {
        super("sprites/explosion.png", location, new Size(64), 1, 4);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setCurrentFrameIndex(frameIndex);
    }

    @Override
    public void setupTimers() {
        addTimer(new ExplosionTimer(this));
    }

    private static final class ExplosionTimer extends Timer {
        private final ExplosionEntity parent;

        public ExplosionTimer(ExplosionEntity parent) {
            super(100);
            this.parent = parent;
        }

        @Override
        public void onAnimationUpdate(long timestamp) {
            parent.remove();
        }
    }
}
