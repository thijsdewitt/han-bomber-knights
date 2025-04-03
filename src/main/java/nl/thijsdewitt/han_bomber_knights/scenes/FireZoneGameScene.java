package nl.thijsdewitt.han_bomber_knights.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import javafx.scene.paint.Color;
import nl.thijsdewitt.han_bomber_knights.entities.player.Player;
import nl.thijsdewitt.han_bomber_knights.entities.map.FireZoneTile;
import nl.thijsdewitt.han_bomber_knights.entities.map.WorldGenTileMap;

import static nl.thijsdewitt.han_bomber_knights.entities.player.Controls.WSAD;

public class FireZoneGameScene extends DynamicScene implements TileMapContainer {
    @Override
    public void setupScene() {
        setBackgroundColor(Color.valueOf("#352021"));
    }

    @Override
    public void setupEntities() {
        Player player1 = new Player(new Coordinate2D(10, 10), WSAD);
        addEntity(player1);
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new WorldGenTileMap(FireZoneTile.class));
    }
}
