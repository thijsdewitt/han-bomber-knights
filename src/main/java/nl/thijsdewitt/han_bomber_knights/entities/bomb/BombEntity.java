package nl.thijsdewitt.han_bomber_knights.entities.bomb;

import com.github.hanyaeger.api.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;

public class BombEntity extends DynamicSpriteEntity implements TimerContainer {
    private final int explosionRadius;
    private OnExplodedListener onExplodedListener;

    public BombEntity(Coordinate2D initialLocation, int explosionRadius) {
        super("sprites/bomb.png", initialLocation, new Size(32), 1, 15);
        this.explosionRadius = explosionRadius;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setAutoCycle(100);
    }

    public void explode() {
        var explosion = new SoundClip("audio/explosion.wav");
        explosion.play();
        this.remove();
    }

    @Override
    public void setupTimers() {
        addTimer(new BombTimer(this));
    }

    public void onExploded(OnExplodedListener listener) {
        this.onExplodedListener = listener;
    }

    public Explosion getExplosion() {
        return new Explosion(getAnchorLocation(), explosionRadius);
    }

    public interface OnExplodedListener {
        void onExploded();
    }

    private static final class BombTimer extends Timer {
        private final BombEntity parent;

        public BombTimer(BombEntity parent) {
            super(3000);
            this.parent = parent;
        }

        @Override
        public void onAnimationUpdate(long timestamp) {
            parent.explode();
            parent.onExplodedListener.onExploded();
            this.remove();
        }
    }
}
