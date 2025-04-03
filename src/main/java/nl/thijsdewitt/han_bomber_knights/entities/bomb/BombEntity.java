package nl.thijsdewitt.han_bomber_knights.entities.bomb;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;

public class BombEntity extends DynamicSpriteEntity {
    public BombEntity() {
        super("sprites/bomb.png", new Coordinate2D(), new Size(32), 1, 15);
        setAutoCycle(100);
    }

    public void explode() {
        var explosion = new SoundClip("audio/explosion.wav");
        explosion.play();
        this.remove();
    }
}
