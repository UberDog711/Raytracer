import Buttons.BlurButton;
import Buttons.InvertButton;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.security.Timestamp;


class Main {

    JFrame frame;
    Window window;
    RenderedImage myImage;


    JPanel mainPanel;
    JPanel buttonPanel;

    InvertButton invertButton;
    BlurButton blurButton;

    long currentTime;
    long lastTime;
    long count;
    public void main() {
        invertButton = new InvertButton("Invert Image");
        blurButton = new BlurButton("Blur Image");

        myImage = new RenderedImage(1280, 720, BufferedImage.TYPE_INT_RGB);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));    // try Y_AXIS


        window = new Window(1280, 720, myImage);


        buttonPanel.add(invertButton);
        buttonPanel.add(blurButton);

        mainPanel.add(buttonPanel, BorderLayout.WEST);
        mainPanel.add(window, BorderLayout.CENTER);


        frame = new JFrame("Raytracing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(mainPanel);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        loop();
    }
    private void loop() {
        currentTime = System.currentTimeMillis();
        count = 0;
        int width = myImage.getWidth();
        int height = myImage.getHeight();
        int size = width * height;
        int[] pixels = new int[size];

        int red = new Color(255, 255, 255).getRGB();
        int blue = new Color(255, 0, 0).getRGB();

        for (int i = 0; i < size; i++) {
                if (i % 2 > 0) {
                    pixels[i] = blue;
                } else {
                    pixels[i] = red;
                }

        }
        while (count < 1000) {
            myImage.setRGB(0,0,width,height,
                    pixels,0,0);
            count++;
            window.repaint();
        }
        lastTime = System.currentTimeMillis();
        System.out.println((double) 1000 / ((double) (lastTime - currentTime) /1000));
    }
}