import java.awt.Color;

/**
 * A filter that splits the image into thirds and applies red, green, and blue tints.
 */
public class VerticalSplitFilter extends Filter
{
    public VerticalSplitFilter(String name) {
        super(name);
    }

    public void apply(OFImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        int third = width / 3;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color pixel = image.getPixel(x, y);
                int red = pixel.getRed();
                int green = pixel.getGreen();
                int blue = pixel.getBlue();

                if (x < third) {
                    // Red tint
                    green /= 3;
                    blue /= 3;
                } else if (x < 2 * third) {
                    // Green tint
                    red /= 3;
                    blue /= 3;
                } else {
                    // Blue tint
                    red /= 3;
                    green /= 3;
                }

                image.setPixel(x, y, new Color(red, green, blue));
            }
        }
    }
}