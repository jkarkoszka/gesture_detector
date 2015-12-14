package com.jkarkoszka.gesturedetector.service;

import com.jkarkoszka.gesturedetector.model.DetectedPoint;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;

import java.util.ArrayList;

public class DetectedPoints {

    final private static Integer GESTURE_LENGTH = 5;

    private ArrayList<DetectedPoint> detectedPoints = new ArrayList<>();

    public void add(DetectedPoint detectedPoint) {
        if (detectedPoint != null) {
            detectedPoints.add(detectedPoint);
        }
        clean();
    }

    public void clean() {
        Long currentTimestamp = System.currentTimeMillis() / 1000L;
        ArrayList<DetectedPoint> newDetectedPoints = new ArrayList<>();
        for (DetectedPoint detectedPoint: detectedPoints) {
            if (detectedPoint.getTimestamp() > currentTimestamp-GESTURE_LENGTH) {
                newDetectedPoints.add(detectedPoint);
            }
        }
        detectedPoints = newDetectedPoints;
    }

    public ArrayList<DetectedPoint> get() {
        return detectedPoints;
    }

    public Mat draw(Mat currentFrame) {
        if (detectedPoints.size() >= 2) {
            for (int i = 1; i < detectedPoints.size(); i++) {
                Core.line(currentFrame, detectedPoints.get(i - 1).getPoint(), detectedPoints.get(i).getPoint(), new Scalar(0D, 0D, 0D));
            }
        }
        return currentFrame;
    }
}
