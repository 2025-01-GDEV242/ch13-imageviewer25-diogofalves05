import java.awt.Color;

/**
 * A filter that creates a Warhol-style 2x2 image with flipped color tints.
 */
public class FlippedWarholFilter extends Filter
{
    public FlippedWarholFilter(String name) {
        super(name);
    }

    public void apply(OFImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        OFImage warhol = new OFImage(width * 2, height * 2);

        // Top-left: original
        copy(image, warhol, 0, 0);

        // Top-right: red tint, flipped horizontally
        copyWithTintAndFlip(image, warhol, width, 0, "red", true, false);

        // Bottom-left: green tint, flipped vertically
        copyWithTintAndFlip(image, warhol, 0, height, "green", false, true);

        // Bottom-right: blue tint, flipped both horizontally and vertically
        copyWithTintAndFlip(image, warhol, width, height, "blue", true, true);

        // Shrink final image into original size
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int wx = x * 2;
                int wy = y * 2;
                image.setPixel(x, y, warhol.getPixel(wx, wy));
            }
        }
    }

    private void copy(OFImage src, OFImage dest, int dx, int dy) {
        for (int y = 0; y < src.getHeight(); y++) {
            for (int x = 0; x < src.getWidth(); x++) {
                dest.setPixel(x + dx, y + dy, src.getPixel(x, y));
            }
        }
    }

    private void copyWithTintAndFlip(OFImage src, OFImage dest, int dx, int dy, String color, boolean flipH, boolean flipV) {
        int height = src.getHeight();
        int width = src.getWidth();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int srcX = flipH ? (width - 1 - x) : x;
                int srcY = flipV ? (height - 1 - y) : y;

                Color pixel = src.getPixel(srcX, srcY);
                int red = pixel.getRed();
                int green = pixel.getGreen();
                int blue = pixel.getBlue();

                if (color.equals("red")) {
                    green /= 3;
                    blue /= 3;
                } else if (color.equals("green")) {
                    red /= 3;
                    blue /= 3;
                } else if (color.equals("blue")) {
                    red /= 3;
                    green /= 3;
                }

                Color tinted = new Color(red, green, blue);
                dest.setPixel(x + dx, y + dy, tinted);
            }
        }
    }
}