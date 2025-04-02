package nl.thijsdewitt.han_bomber_knights.entities.bomb;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.CompositeEntity;
import com.github.hanyaeger.api.scenes.YaegerScene;

public class Bomb extends CompositeEntity {
    private final YaegerScene scene;
    private final int explosionRadius;

    public Bomb(YaegerScene scene, Coordinate2D initialLocation, int explosionRadius) {
        super(initialLocation);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        this.scene = scene;
        this.explosionRadius = explosionRadius;
    }

    @Override
    protected void setupEntities() {
        Coordinate2D bombLocation = getAnchorLocation();
        BombEntity bombEntity = new BombEntity(scene, new Coordinate2D(), explosionRadius);
//        bombEntity.onExploded(() -> {
//
//        })

        addEntity(bombEntity);
    }
}
