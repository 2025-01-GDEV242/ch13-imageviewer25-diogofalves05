import java.awt.Color;

/**
 * A filter that tints the image green by keeping green strong and reducing red/blue.
 */
public class GreenTintFilter extends Filter
{
    public GreenTintFilter(String name) {
        super(name);
    }

    public void apply(OFImage image) {
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                Color color = image.getPixel(x, y);
                int red = color.getRed() / 3;
                int green = color.getGreen();
                int blue = color.getBlue() / 3;
                Color greenTint = new Color(red, green, blue);
                image.setPixel(x, y, greenTint);
            }
        }
    }
}