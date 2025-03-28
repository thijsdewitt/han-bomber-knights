package nl.thijsdewitt.han_bomber_knights.scenes;

import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import javafx.scene.paint.Color;
import nl.thijsdewitt.han_bomber_knights.entities.map.FireZoneTile;
import nl.thijsdewitt.han_bomber_knights.entities.map.WorldGenTileMap;

public class FireZoneGameScene extends DynamicScene implements TileMapContainer {
    @Override
    public void setupScene() {
        setBackgroundColor(Color.valueOf("#352021"));
    }

    @Override
    public void setupEntities() {
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new WorldGenTileMap(FireZoneTile.class));
    }
}
