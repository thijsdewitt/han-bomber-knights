package nl.thijsdewitt.han_bomber_knights.entities.tilemap;

import com.github.hanyaeger.api.scenes.TileMap;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class WorldGen extends TileMap {
    @Override
    public void setupEntities() {
    }

    @Override
    public int[][] defineMap() {
        var test = loadResource("src/main/resources/tilemaps/test.png");
        return new int[0][0];
    }

    private int[] loadResource(String filename) {
        try {
            File initialFile = new File(filename);
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
            return pixels;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
