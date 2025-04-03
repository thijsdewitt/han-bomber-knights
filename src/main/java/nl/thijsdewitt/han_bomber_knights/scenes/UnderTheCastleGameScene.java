package nl.thijsdewitt.han_bomber_knights.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import javafx.scene.paint.Color;
import nl.thijsdewitt.han_bomber_knights.entities.HUD.HUD;
import nl.thijsdewitt.han_bomber_knights.entities.player.Player;
import nl.thijsdewitt.han_bomber_knights.entities.player.Controls;
import nl.thijsdewitt.han_bomber_knights.entities.player.Player;
import nl.thijsdewitt.han_bomber_knights.entities.map.CrateTileMap;
import nl.thijsdewitt.han_bomber_knights.entities.map.UnderTheCastleTile;
import nl.thijsdewitt.han_bomber_knights.entities.map.WorldGenTileMap;
import nl.thijsdewitt.han_bomber_knights.entities.powerups.HealthPowerUp;

public class UnderTheCastleGameScene extends DynamicScene implements TileMapContainer {
    @Override
    public void setupScene() {
        setBackgroundColor(Color.valueOf("#171424"));
    }

    @Override
    public void setupEntities() {
        HUD player1HUD = new HUD(new Coordinate2D(0, 0), 400, 400, "sprites/BlueKnightIcon.png");
        addEntity(player1HUD);
        Player player1 = new Player(new Coordinate2D(290, 82), player1HUD, Controls.WSAD);
        addEntity(player1);
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new WorldGenTileMap(UnderTheCastleTile.class));
        addTileMap(new CrateTileMap());
    }
}
