package com.jkarkoszka.gesturedetector.service;

import com.jkarkoszka.gesturedetector.model.DetectedPoint;
import org.opencv.core.Mat;

public interface Detector {

    DetectedPoint detect(Mat currentFrame);

    Mat draw(Mat currentFrame, DetectedPoint detectedPoint);
}
