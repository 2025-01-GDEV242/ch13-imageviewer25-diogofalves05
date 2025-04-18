import java.awt.Color;

/**
 * A filter that creates a Warhol-style 2x2 image with color tints.
 */
public class WarholFilter extends Filter
{
    public WarholFilter(String name) {
        super(name);
    }

    public void apply(OFImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        // Create full 2x2 Warhol collage
        OFImage warhol = new OFImage(width * 2, height * 2);

        copy(image, warhol, 0, 0); // top-left original
        copyWithTint(image, warhol, width, 0, "red"); // top-right
        copyWithTint(image, warhol, 0, height, "green"); // bottom-left
        copyWithTint(image, warhol, width, height, "blue"); // bottom-right

        // Set each pixel in the original image with a scaled-down version of Warhol
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

    private void copyWithTint(OFImage src, OFImage dest, int dx, int dy, String color) {
        for (int y = 0; y < src.getHeight(); y++) {
            for (int x = 0; x < src.getWidth(); x++) {
                Color pixel = src.getPixel(x, y);
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