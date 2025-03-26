package nl.thijsdewitt.han_bomber_knights.entities.map;

import org.jetbrains.annotations.NotNull;

public record Image(int width, int height, int[] pixels) {
    public Image(int width, int height, int[] pixels) {
        this.width = width;
        this.height = height;
        this.pixels = pixels;
    }

    public int[][] getPixels2D() {
        int[][] pixel2D = new int[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pixel2D[y][x] = pixels[x + y * width];
            }
        }
        return pixel2D;
    }
}
