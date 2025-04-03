package nl.thijsdewitt.han_bomber_knights.entities.bomb;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

import java.util.ArrayList;
import java.util.Arrays;

public class Bomb extends DynamicCompositeEntity implements TimerContainer {
    private final int explosionRadius;

    private final BombEntity bombEntity;
    private OnExplodedListener onExplodedListener;

    public Bomb(Coordinate2D initialLocation, int explosionRadius) {
        super(initialLocation);
        this.explosionRadius = explosionRadius;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);

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

    public ArrayList<ExplosionEntity> getExplosionEntities(Coordinate2D location, double tileSize) {
        ArrayList<ExplosionEntity> explosions = new ArrayList<>();

        explosions.add(new ExplosionEntity(location, 1));
        explosions.add(new ExplosionEntity(location.add(new Coordinate2D(0, tileSize)), 2));
        explosions.add(new ExplosionEntity(location.add(new Coordinate2D(0, -tileSize)), 2));
        explosions.add(new ExplosionEntity(location.add(new Coordinate2D(tileSize, 0)), 3));
        explosions.add(new ExplosionEntity(location.add(new Coordinate2D(-tileSize, 0)), 3));

        return explosions;
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
            this.remove();
        }
    }
}
