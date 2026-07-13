import java.awt.image.BufferedImage;

public class RenderedImage extends BufferedImage {
    public RenderedImage(int width, int height, int imageType) {
        super(width, height, imageType);
    }

    @Override
    public void setRGB(int x, int y, int rgb) {
        super.setRGB(x, y, rgb);
    }
}
