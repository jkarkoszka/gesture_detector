package com.jkarkoszka.opencv.example.window;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Window extends JFrame {

    private Panel panel;

    public Window(Panel panel) throws HeadlessException {
        super();
        this.panel = panel;
        this.setTitle("Gesture detector");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setContentPane(this.panel);
        this.setVisible(true);
    }

    public void setImage(BufferedImage frame) {
        panel.setImage(frame);
    }

    public void repaint() {
        panel.repaint();
    }
}
