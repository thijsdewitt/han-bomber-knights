package nl.thijsdewitt.han_bomber_knights.entities.map;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.TileMap;
import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import static nl.thijsdewitt.han_bomber_knights.BomberKnights.SCREEN_SIZE;

public class WorldGenTileMap extends TileMap {
    public static final Coordinate2D LOCATION = new Coordinate2D(SCREEN_SIZE.width() / 2, SCREEN_SIZE.height() / 2);
    public static final Size SIZE = new Size(SCREEN_SIZE.height() - 32, SCREEN_SIZE.height() - 32);
    private int rows;
    private int columns;

    public WorldGenTileMap() {
        super(LOCATION, SIZE);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    public void setupEntities() {
        String spritesheet = "sprites/under_the_castle.png";

        addEntity(-1, Path.class, new TileConfig(spritesheet, 5));
        addEntity(0xFF000000, UnbreakableWall.class, new TileConfig(spritesheet, 7));
        addEntity(0xFF080808, UnbreakableWall.class, new TileConfig(spritesheet, 8));
        addEntity(0xFF101010, UnbreakableWall.class, new TileConfig(spritesheet, 9));
        addEntity(0xFF181818, UnbreakableWall.class, new TileConfig(spritesheet, 17));
        addEntity(0xFF202020, UnbreakableWall.class, new TileConfig(spritesheet, 15));
        addEntity(0xFF282828, UnbreakableWall.class, new TileConfig(spritesheet, 19));
        addEntity(0xFF303030, UnbreakableWall.class, new TileConfig(spritesheet, 27));
        addEntity(0xFF383838, UnbreakableWall.class, new TileConfig(spritesheet, 28));
        addEntity(0xFF404040, UnbreakableWall.class, new TileConfig(spritesheet, 29));
        addEntity(0xFFEEEEEE, Path.class, new TileConfig(spritesheet, 18));
        addEntity(0xFFDDDDDD, Path.class, new TileConfig(spritesheet, 25));
    }

    @Override
    public int[][] defineMap() {
        Image image = loadResource("sprites/world_map.png");
        rows = image.height();
        columns = image.width();
        return image.getPixels2D();
    }

    /**
     * Dit is source code van Processing
     * https://github.com/ruby-processing/processing-core/blob/7a46f4e20b3679b1696ae2b911f092f016f803b9/src/main/java/processing/core/util/image/load/ImageIoImageLoadStrategy.java#L95-L128
     */
    private @NotNull Image loadResource(String filename) {
        try {
            // get absolute path to the resource
            var absolutePath = getClass().getResource("/" + filename).getPath();

            File initialFile = new File(absolutePath);
            InputStream stream = new FileInputStream(initialFile);
            BufferedImage bi = ImageIO.read(stream);

            int width = bi.getWidth();
            int height = bi.getHeight();
            int[] pixels = new int[width * height];

            bi.getRGB(0, 0, width, height, pixels, 0, width);

            // check the alpha for this image
            // was gonna call getType() on the image to see if RGB or ARGB,
            // but it's not actually useful, since gif images will come through
            // as TYPE_BYTE_INDEXED, which means it'll still have to check for
            // the transparency. also, would have to iterate through all the other
            // types and guess whether alpha was in there, so.. just gonna stick
            // with the old method.

            stream.close();
            // return the image
            return new Image(width, height, pixels);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
