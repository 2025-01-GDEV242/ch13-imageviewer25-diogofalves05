import java.awt.Color;

/**
 * A filter that turns the image into grayscale based on red intensity only.
 */
public class RedChannelFilter extends Filter
{
    public RedChannelFilter(String name) {
        super(name);
    }

    public void apply(OFImage image) {
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                Color color = image.getPixel(x, y);
                int red = color.getRed();
                Color grayRed = new Color(red, red, red);
                image.setPixel(x, y, grayRed);
            }
        }
    }
}