package nl.thijsdewitt.han_bomber_knights.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import javafx.scene.paint.Color;
import nl.thijsdewitt.han_bomber_knights.entities.HUD.HUD;
import nl.thijsdewitt.han_bomber_knights.entities.bomb.BombEntity;
import nl.thijsdewitt.han_bomber_knights.entities.bomb.Explosion;
import nl.thijsdewitt.han_bomber_knights.entities.map.OverlayTileMap;
import nl.thijsdewitt.han_bomber_knights.entities.map.UnderTheCastleTile;
import nl.thijsdewitt.han_bomber_knights.entities.map.WorldGenTileMap;
import nl.thijsdewitt.han_bomber_knights.entities.player.Controls;
import nl.thijsdewitt.han_bomber_knights.entities.player.Player;

public class UnderTheCastleGameScene extends DynamicScene implements TileMapContainer {
    private final WorldGenTileMap tileMap = new WorldGenTileMap(UnderTheCastleTile.class);
    Player player1;
    Player player2;

    @Override
    public void setupScene() {
        setBackgroundColor(Color.valueOf("#171424"));
    }

    @Override
    public void setupEntities() {
        HUD player1HUD = new HUD(new Coordinate2D(0, 0), "sprites/BlueKnightIcon.png");
        player1 = new Player("sprites/blue_knight_16x17.png", player1HUD, Controls.WSAD);
        HUD player2HUD = new HUD(new Coordinate2D(0, 300), "sprites/GreenKnightIcon.png");
        player2 = new Player("sprites/green_knight_16x17.png", player2HUD, Controls.ARROWS);

        placeBomb(player1);
        placeBomb(player2);

        addEntity(player1HUD);
        addEntity(player1);
        addEntity(player2HUD);
        addEntity(player2);
    }

    private void placeBomb(Player player1) {
        player1.onBombPlace((player) -> {
            Coordinate2D bombLocation = getBombLocation(player);
            BombEntity bomb = new BombEntity(bombLocation, player.getExplosionRadius());
            bomb.onExploded(() -> {
                player.resetBombPlaced();

                Explosion explosion = bomb.getExplosion();
                addEntity(explosion);
            });
            addEntity(bomb);
        });
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
        addTileMap(new OverlayTileMap(player1, player2));
    }
}
