package com.jkarkoszka.opencv.example.service;

import com.jkarkoszka.opencv.example.model.DetectedPoint;
import org.opencv.core.Mat;

public interface Detector {

    DetectedPoint detect(Mat currentFrame);

    Mat draw(Mat currentFrame, DetectedPoint detectedPoint);
}
