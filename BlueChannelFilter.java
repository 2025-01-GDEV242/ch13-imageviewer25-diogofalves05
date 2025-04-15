import java.awt.Color;

/**
 * A filter that turns the image into grayscale based on blue intensity only.
 */
public class BlueChannelFilter extends Filter
{
    public BlueChannelFilter(String name) {
        super(name);
    }

    public void apply(OFImage image) {
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                Color color = image.getPixel(x, y);
                int blue = color.getBlue();
                Color grayBlue = new Color(blue, blue, blue);
                image.setPixel(x, y, grayBlue);
            }
        }
    }
}