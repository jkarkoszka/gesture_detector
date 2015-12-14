package com.jkarkoszka.opencv.example.service;


import com.jkarkoszka.opencv.example.model.DetectedPoint;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Size;

import java.awt.*;

public class MouseDetector extends BallDetector {

    public DetectedPoint detect(Mat currentFrame) {
        Long currentTimestamp = System.currentTimeMillis() / 1000L;
        PointerInfo pointerInfo = MouseInfo.getPointerInfo();
        return new DetectedPoint(currentTimestamp, new Point(pointerInfo.getLocation().getX(), pointerInfo.getLocation().getY()), null);
    }

}
