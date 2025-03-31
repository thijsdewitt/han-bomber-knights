package nl.thijsdewitt.han_bomber_knights.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import javafx.scene.paint.Color;
import nl.thijsdewitt.han_bomber_knights.entities.Player;
import nl.thijsdewitt.han_bomber_knights.entities.map.UnderTheCastleTile;
import nl.thijsdewitt.han_bomber_knights.entities.map.WorldGenTileMap;

public class UnderTheCastleGameScene extends DynamicScene implements TileMapContainer {
    @Override
    public void setupScene() {
        setBackgroundColor(Color.valueOf("#171424"));
    }

    @Override
    public void setupEntities() {
        Player player1 = new Player(new Coordinate2D(290, 82));
        addEntity(player1);
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new WorldGenTileMap(UnderTheCastleTile.class));
    }
}
