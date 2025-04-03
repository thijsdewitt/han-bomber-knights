package nl.thijsdewitt.han_bomber_knights.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import javafx.scene.paint.Color;
import nl.thijsdewitt.han_bomber_knights.entities.HUD.HUD;
import nl.thijsdewitt.han_bomber_knights.entities.Player;
import nl.thijsdewitt.han_bomber_knights.entities.bomb.Bomb;
import nl.thijsdewitt.han_bomber_knights.entities.bomb.ExplosionEntity;
import nl.thijsdewitt.han_bomber_knights.entities.map.UnderTheCastleTile;
import nl.thijsdewitt.han_bomber_knights.entities.map.WorldGenTileMap;
import nl.thijsdewitt.han_bomber_knights.entities.powerups.HealthPowerUp;

import java.util.ArrayList;

public class UnderTheCastleGameScene extends DynamicScene implements TileMapContainer {
    private final WorldGenTileMap tileMap = new WorldGenTileMap(UnderTheCastleTile.class);

    @Override
    public void setupScene() {
        setBackgroundColor(Color.valueOf("#171424"));
    }

    @Override
    public void setupEntities() {
        HUD player1HUD = new HUD(new Coordinate2D(0, 0), 400, 400, "sprites/BlueKnightIcon.png");
        Player player1 = new Player(new Coordinate2D(290, 82), player1HUD);

        player1.onBombPlace((player) -> {
            Coordinate2D bombLocation = getBombLocation(player);
            Bomb bomb = new Bomb(bombLocation, player.getExplosionRadius());
            bomb.onExploded(() -> {
                player.resetBombPlaced();

                Size mapSize = WorldGenTileMap.SIZE;
                double tileSize = mapSize.width() / tileMap.getColumns();

                ArrayList<ExplosionEntity> explosions = bomb.getExplosionEntities(bombLocation, tileSize);
                explosions.forEach(this::addEntity);
            });
            addEntity(bomb);
        });

        addEntity(player1HUD);
        addEntity(player1);
    }

    private Coordinate2D getBombLocation(Player player) {
        // Get the player's current center position
        double xPos = player.getBoundingBox().getCenterX();
        double yPos = player.getBoundingBox().getCenterY();
        Coordinate2D playerLocation = new Coordinate2D(xPos, yPos);

        // Calculate the center of the screen
        Coordinate2D center = new Coordinate2D(getWidth() / 2, getHeight() / 2);

        // Calculate the tile width and height based on the tile map size
        Size size = WorldGenTileMap.SIZE;
        double tileWidth = size.width() / tileMap.getColumns();
        double tileHeight = size.height() / tileMap.getRows();

        // Calculate the relative position of the player to the center of the screen
        Coordinate2D relativePlayerLocation = playerLocation.subtract(center);

        // Round the relative position to the nearest tile and add the center position
        return new Coordinate2D(
                Math.round(relativePlayerLocation.getX() / tileWidth) * tileWidth,
                Math.round(relativePlayerLocation.getY() / tileHeight) * tileHeight
        ).add(center);
    }

    @Override
    public void setupTileMaps() {
        addTileMap(tileMap);
    }
}
