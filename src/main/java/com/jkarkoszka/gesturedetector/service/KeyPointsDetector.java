package com.jkarkoszka.gesturedetector.service;

import com.jkarkoszka.gesturedetector.model.DetectedPoint;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;

import java.util.ArrayList;

public class KeyPointsDetector {

    private GeometryService geometryService;

    public KeyPointsDetector(GeometryService geometryService) {
        this.geometryService = geometryService;
    }

    public ArrayList<DetectedPoint> detect(ArrayList<DetectedPoint> detectedPoints) {
        if (detectedPoints.size() < 3) {
            return detectedPoints;
        }
        ArrayList<DetectedPoint> keyPoints = new ArrayList<>();
        keyPoints.add(detectedPoints.get(0));
        for (int i = 1; i < detectedPoints.size()-1; i++) {
            DetectedPoint lastKeyPoint = keyPoints.get(keyPoints.size()-1);
            DetectedPoint currentPoint = detectedPoints.get(i);
            DetectedPoint nextPoint = detectedPoints.get(i+1);
            if (ifDistanceIsEnough(lastKeyPoint, currentPoint) && ifAngleIsEnough(lastKeyPoint, currentPoint, nextPoint)) {
                keyPoints.add(detectedPoints.get(i));
            }
        }
        keyPoints.add(detectedPoints.get(detectedPoints.size()-1));
        if (keyPoints.size() == 2) {
            keyPoints.clear();
        }
        //System.out.println("waznych punktow = " + keyPoints.size());
        return keyPoints;
    }

    private boolean ifAngleIsEnough(DetectedPoint lastKeyPoint, DetectedPoint currentPoint, DetectedPoint nextPoint) {
        Integer angle = geometryService.getAngle(lastKeyPoint.getPoint(), currentPoint.getPoint(), nextPoint.getPoint());
        //System.out.println("kąt = " + angle);
        return angle < 120;
    }

    private boolean ifDistanceIsEnough(DetectedPoint lastKeyPoint, DetectedPoint currentPoint) {
        double distance = geometryService.getDistance(lastKeyPoint.getPoint(), currentPoint.getPoint());
        // System.out.println("dystans = " + distance);
        return distance > 100;
    }

    public Mat draw(Mat currentFrame, ArrayList<DetectedPoint> points) {
        if (points.size() >= 2) {
            Core.circle(currentFrame, points.get(0).getPoint(), 10, new Scalar(42D, 112D, 12D));
            for (int i = 1; i < points.size(); i++) {
                Core.circle(currentFrame, points.get(i).getPoint(), 10, new Scalar(42D, 112D, 12D));
                Core.line(currentFrame, points.get(i - 1).getPoint(), points.get(i).getPoint(), new Scalar(60D, 182D, 7D));
            }
        }
        return currentFrame;
    }

}
