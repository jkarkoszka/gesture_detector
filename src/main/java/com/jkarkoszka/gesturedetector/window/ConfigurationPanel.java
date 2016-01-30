package com.jkarkoszka.gesturedetector.window;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class ConfigurationPanel extends JPanel {

    private JSlider lowH;
    private JSlider highH;

    private JSlider lowS;
    private JSlider highS;

    private JSlider lowV;
    private JSlider highV;

    private JCheckBox debugMode;

    public ConfigurationPanel() {
        super();

        lowH = new JSlider();
        lowH.setMinimum(0);
        lowH.setMaximum(255);
        lowH.setValue(7);

        highH = new JSlider();
        highH.setMinimum(0);
        highH.setMaximum(255);
        highH.setValue(18);

        lowS = new JSlider();
        lowS.setMinimum(4);
        lowS.setMaximum(255);
        lowS.setValue(49);

        highS = new JSlider();
        highS.setMinimum(0);
        highS.setMaximum(255);
        highS.setValue(255);

        lowV = new JSlider();
        lowV.setMinimum(0);
        lowV.setMaximum(255);
        lowV.setValue(171);

        highV = new JSlider();
        highV.setMinimum(0);
        highV.setMaximum(255);
        highV.setValue(255);

        debugMode = new JCheckBox();
        debugMode.setText("debug mode");
        debugMode.setSelected(false);

        JPanel hLow = new JPanel();
        hLow.add(new JLabel("Low H"));
        hLow.add(lowH);

        JPanel hHigh = new JPanel();
        hHigh.add(new JLabel("High H"));
        hHigh.add(highH);

        JPanel sLow = new JPanel();
        sLow.add(new JLabel("Low S"));
        sLow.add(lowS);

        JPanel sHigh = new JPanel();
        sHigh.add(new JLabel("High S"));
        sHigh.add(highS);

        JPanel vLow = new JPanel();
        vLow.add(new JLabel("Low V"));
        vLow.add(lowV);

        JPanel vHigh = new JPanel();
        vHigh.add(new JLabel("High V"));
        vHigh.add(highV);

        JPanel debugPanel = new JPanel();
        debugPanel.setSize(400, 30);
        debugPanel.add(new JLabel("Options"));
        debugPanel.add(debugMode);

        this.add(hLow);
        this.add(hHigh);
        this.add(sLow);
        this.add(sHigh);
        this.add(vLow);
        this.add(vHigh);
        this.add(debugPanel);
    }
    
    public Integer getCurrentLowH() {
        return lowH.getValue();
    }

    public Integer getCurrentLowS() {
        return lowS.getValue();
    }

    public Integer getCurrentLowV() {
        return lowV.getValue();
    }

    public Integer getCurrentHighH() {
        return highH.getValue();
    }

    public Integer getCurrentHighS() {
        return highS.getValue();
    }

    public Integer getCurrentHighV() {
        return highV.getValue();
    }

    public boolean isDebugMode() {
        return debugMode.isSelected();
    }
    
}
