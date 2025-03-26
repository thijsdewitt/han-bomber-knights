package nl.thijsdewitt.han_bomber_knights.entities.map;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.TileMap;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import static nl.thijsdewitt.han_bomber_knights.BomberKnights.SCREEN_SIZE;

public class WorldGenTileMap extends TileMap {
    public WorldGenTileMap() {
        super(new Coordinate2D(SCREEN_SIZE.width()/2, SCREEN_SIZE.height()/2), new Size(SCREEN_SIZE.height() - 32, SCREEN_SIZE.height() - 32));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    public void setupEntities() {
        addEntity(-1, FireZoneTile.class, 5);
        addEntity(0xFF000000, FireZoneTile.class, 7);
        addEntity(0xFF080808, FireZoneTile.class, 8);
        addEntity(0xFF101010, FireZoneTile.class, 9);
        addEntity(0xFF181818, FireZoneTile.class, 17);
        addEntity(0xFF202020, FireZoneTile.class, 15);
        addEntity(0xFF282828, FireZoneTile.class, 19);
        addEntity(0xFF303030, FireZoneTile.class, 27);
        addEntity(0xFF383838, FireZoneTile.class, 28);
        addEntity(0xFF404040, FireZoneTile.class, 29);
        addEntity(0xFFEEEEEE, FireZoneTile.class, 18);
        addEntity(0xFFDDDDDD, FireZoneTile.class, 25);
    }

    @Override
    public int[][] defineMap() {
        Image image = loadResource("tilemaps/test.png");
        int[][] map = image.getPixels2D();
        return map;
    }

    /**
     * Dit is source code van Processing
     * https://github.com/ruby-processing/processing-core/blob/7a46f4e20b3679b1696ae2b911f092f016f803b9/src/main/java/processing/core/util/image/load/ImageIoImageLoadStrategy.java#L95-L128
     *
     * @param filename
     * @return
     */
    private Image loadResource(String filename) {
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
}
