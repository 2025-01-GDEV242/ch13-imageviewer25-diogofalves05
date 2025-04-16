import java.awt.Color;

/**
 * A filter that tints the image red by keeping red strong and reducing green/blue.
 */
public class RedTintFilter extends Filter
{
    public RedTintFilter(String name) {
        super(name);
    }

    public void apply(OFImage image) {
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                Color color = image.getPixel(x, y);
                int red = color.getRed();
                int green = color.getGreen() / 3;
                int blue = color.getBlue() / 3;
                Color redTint = new Color(red, green, blue);
                image.setPixel(x, y, redTint);
            }
        }
    }
}