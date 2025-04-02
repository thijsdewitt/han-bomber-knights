package nl.thijsdewitt.han_bomber_knights.entities.bomb;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.YaegerScene;
import nl.thijsdewitt.han_bomber_knights.entities.Player;

public class BombEntity extends DynamicSpriteEntity {
    private final int explosionRadius;
    private final YaegerScene scene;

    public BombEntity(YaegerScene scene, Coordinate2D initialLocation, int explosionRadius) {
        super("sprites/bomb.png", initialLocation, new Size(32), 1, 15);
        this.explosionRadius = explosionRadius;
        this.scene = scene;

        setAutoCycle(100);
    }

    public BombEntity(YaegerScene scene, Player player) {

        this(scene, player.getAnchorLocation(), player.getExplosionRadius());
    }
}
