package com.jkarkoszka.gesturedetector.window;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ConfigurationWindow extends JFrame {

    private ConfigurationPanel panel;

    public ConfigurationWindow(ConfigurationPanel panel) throws HeadlessException {
        super();
        this.panel = panel;
        this.setTitle("Calibration");
        this.setSize(400, 400);
        this.setContentPane(this.panel);
        this.setVisible(true);
    }

    public boolean isDebugMode() {
        return panel.isDebugMode();
    }
}
