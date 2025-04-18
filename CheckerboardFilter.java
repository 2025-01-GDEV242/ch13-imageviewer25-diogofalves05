import java.awt.Color;

/**
 * A filter that applies a checkerboard pattern of red, green, and blue tints.
 */
public class CheckerboardFilter extends Filter
{
    public CheckerboardFilter(String name) {
        super(name);
    }

    public void apply(OFImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        // Size of each square block (in pixels)
        int blockSize = 50;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // Determine which block this pixel is in
                int blockX = x / blockSize;
                int blockY = y / blockSize;

                // Choose tint based on checker pattern
                int tintType = (blockX + blockY) % 3; // 0 = red, 1 = green, 2 = blue

                Color pixel = image.getPixel(x, y);
                int red = pixel.getRed();
                int green = pixel.getGreen();
                int blue = pixel.getBlue();

                if (tintType == 0) {         // red tint
                    green /= 3;
                    blue /= 3;
                } else if (tintType == 1) {  // green tint
                    red /= 3;
                    blue /= 3;
                } else if (tintType == 2) {  // blue tint
                    red /= 3;
                    green /= 3;
                }

                image.setPixel(x, y, new Color(red, green, blue));
            }
        }
    }
}