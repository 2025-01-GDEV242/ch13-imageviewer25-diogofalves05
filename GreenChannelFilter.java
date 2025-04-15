import java.awt.Color;

/**
 * A filter that turns the image into grayscale based on green intensity only.
 */
public class GreenChannelFilter extends Filter
{
    public GreenChannelFilter(String name) {
        super(name);
    }

    public void apply(OFImage image) {
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                Color color = image.getPixel(x, y);
                int green = color.getGreen();
                Color grayGreen = new Color(green, green, green);
                image.setPixel(x, y, grayGreen);
            }
        }
    }
}