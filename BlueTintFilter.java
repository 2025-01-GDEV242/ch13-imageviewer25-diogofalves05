import java.awt.Color;

/**
 * A filter that tints the image blue by keeping blue strong and reducing red/green.
 */
public class BlueTintFilter extends Filter
{
    public BlueTintFilter(String name) {
        super(name);
    }

    public void apply(OFImage image) {
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                Color color = image.getPixel(x, y);
                int red = color.getRed() / 3;
                int green = color.getGreen() / 3;
                int blue = color.getBlue();
                Color blueTint = new Color(red, green, blue);
                image.setPixel(x, y, blueTint);
            }
        }
    }
}