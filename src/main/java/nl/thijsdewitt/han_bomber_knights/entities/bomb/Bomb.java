package nl.thijsdewitt.han_bomber_knights.entities.bomb;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

public class Bomb extends DynamicCompositeEntity implements TimerContainer {
    private final int explosionRadius;

    private final BombEntity bombEntity;
    private OnExplodedListener onExplodedListener;

    public Bomb(Coordinate2D initialLocation, int explosionRadius) {
        super(initialLocation);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        this.explosionRadius = explosionRadius;

        this.bombEntity = new BombEntity();
    }

    @Override
    protected void setupEntities() {
        addEntity(bombEntity);
    }

    @Override
    public void setupTimers() {
        addTimer(new BombTimer(this, bombEntity));
    }

    public void onExploded(OnExplodedListener listener) {
        this.onExplodedListener = listener;
    }

    public interface OnExplodedListener {
        void onExploded();
    }

    private static final class BombTimer extends Timer {
        private final Bomb parent;
        private final BombEntity bombEntity;

        public BombTimer(Bomb parent, BombEntity bombEntity) {
            super(3000);
            this.parent = parent;
            this.bombEntity = bombEntity;
        }

        @Override
        public void onAnimationUpdate(long timestamp) {
            bombEntity.explode();
            parent.onExplodedListener.onExploded();
            // TODO: add explosion entity
            parent.remove();
        }
    }
}
