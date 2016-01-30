package com.jkarkoszka.gesturedetector.service;


import com.jkarkoszka.gesturedetector.model.DetectedPoint;
import com.jkarkoszka.gesturedetector.window.ConfigurationPanel;
import org.opencv.core.Mat;
import org.opencv.core.Point;

import java.awt.*;

public class MouseDetector extends BallDetector {

    public MouseDetector(ConfigurationPanel configurationPanel) {
        super(configurationPanel);
    }

    public DetectedPoint detect(Mat currentFrame) {
        detectionFrame = currentFrame;
        Long currentTimestamp = System.currentTimeMillis() / 1000L;
        PointerInfo pointerInfo = MouseInfo.getPointerInfo();
        return new DetectedPoint(currentTimestamp, new Point(pointerInfo.getLocation().getX(), pointerInfo.getLocation().getY()), null);
    }

}
