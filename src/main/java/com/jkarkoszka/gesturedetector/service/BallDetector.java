package com.jkarkoszka.gesturedetector.service;

import com.jkarkoszka.gesturedetector.model.DetectedPoint;
import com.jkarkoszka.gesturedetector.window.ConfigurationPanel;
import org.opencv.core.*;
import org.opencv.core.Point;
import org.opencv.imgproc.Imgproc;

public class BallDetector implements Detector {

    protected Mat detectionFrame;

    protected ConfigurationPanel configurationPanel;

    public BallDetector(ConfigurationPanel configurationPanel) {
        this.configurationPanel = configurationPanel;
    }

    public Mat getDetectionFrame() {
        return detectionFrame;
    }

    public DetectedPoint detect(Mat currentFrame) {
        Mat detectedCircles = detectedCirclesFromCurrentFrame(currentFrame);
        DetectedPoint detectedPoint = null;
        int rows = detectedCircles.rows();
        int elemSize = (int)detectedCircles.elemSize();
        float[] data2 = new float[rows * elemSize/4];
        if (data2.length>0) {
            detectedCircles.get(0, 0, data2);
            for(int i=0; i<data2.length; i=i+3) {
                Long currentTimestamp = System.currentTimeMillis() / 1000L;
                Point center = new Point(data2[i], data2[i+1]);
                detectedPoint = new DetectedPoint(currentTimestamp, center, new Size((double)data2[i+2], (double)data2[i+2]));
                break;
            }
        }
        return detectedPoint;
    }

    private Mat detectedCirclesFromCurrentFrame(Mat currentFrame) {
        Mat hsvFrame = new Mat();
        Mat thresholdedFrame1 =  new Mat();
        Imgproc.cvtColor(currentFrame, hsvFrame, Imgproc.COLOR_BGR2HSV);
        System.out.println(
                "H <"+ configurationPanel.getCurrentLowH() +"," + configurationPanel.getCurrentHighH()+"> " +
                "S <"+ configurationPanel.getCurrentLowS() +"," + configurationPanel.getCurrentHighV()+"> " +
                "V <"+ configurationPanel.getCurrentLowV() +"," + configurationPanel.getCurrentHighV()+"> "

        );
        Core.inRange(hsvFrame, new Scalar(
                configurationPanel.getCurrentLowH(), configurationPanel.getCurrentLowS(), configurationPanel.getCurrentLowV()),
                new Scalar(configurationPanel.getCurrentHighH(), configurationPanel.getCurrentHighS(), configurationPanel.getCurrentHighV()), thresholdedFrame1);
        Imgproc.GaussianBlur(thresholdedFrame1, thresholdedFrame1, new Size(9,9),0,0);
        detectionFrame = thresholdedFrame1.clone();
        Mat detectedCircles = new Mat();
        Imgproc.HoughCircles(thresholdedFrame1, detectedCircles, Imgproc.CV_HOUGH_GRADIENT, 2, currentFrame.height()/4, 500, 50, 0, 0);
        return detectedCircles;
    }

    public Mat draw(Mat currentFrame, DetectedPoint detectedPoint) {
        if (detectedPoint != null && detectedPoint.getAxes() != null) {
            Core.ellipse(currentFrame, detectedPoint.getPoint(), detectedPoint.getAxes(), 0, 0, 360, new Scalar(255, 0, 255), 4, 8, 0);
        }
        return currentFrame;
    }
}
