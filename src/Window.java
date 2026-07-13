import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

class Window extends JPanel {
    BufferedImage myImage;
    private int solvedHeight;
    private int solvedWidth;


    Window(int width, int height, BufferedImage image) {
        myImage = image;
        setSize(width, height);
        setPreferredSize(new Dimension(width, height));
        MouseInputs mouseListener = new MouseInputs();
        this.addMouseListener(mouseListener);
        this.addMouseMotionListener(mouseListener);

    }

    @Override
    public void paintComponent(Graphics pen) {
        int panelHeight = getHeight();
        int panelWidth = getWidth();
        double panelRatio = (double) panelWidth / panelHeight;

        int imageHeight = myImage.getHeight();
        int imageWidth = myImage.getWidth();
        double imageRatio = (double) imageWidth / imageHeight;

        solvedHeight = panelHeight;
        solvedWidth = panelWidth;

        if (panelRatio > imageRatio) {
            solvedWidth = (int) (imageRatio * solvedHeight);
        } else if (panelRatio < imageRatio) {
            solvedHeight = (int) (solvedWidth / imageRatio);
        }

        pen.drawImage(myImage, 0, 0, solvedWidth, solvedHeight, null);
    }

}