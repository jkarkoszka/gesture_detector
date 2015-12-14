package com.jkarkoszka.gesturedetector.window;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Panel extends JPanel {

    private BufferedImage image;

    public Panel() {
        super();
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage frame) {
        this.image = frame;
    }

    public void paintComponent(Graphics g){
        if (image instanceof BufferedImage) {
            g.drawImage(getImage(), 10, 10, getImage().getWidth(), getImage().getHeight(), this);
        }
    }
}
