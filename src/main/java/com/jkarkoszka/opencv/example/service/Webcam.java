package com.jkarkoszka.opencv.example.service;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.VideoCapture;

public class Webcam {

    private VideoCapture videoCapture;

    public Webcam(VideoCapture videoCapture) {
        this.videoCapture = videoCapture;
    }

    public Mat getCurrentFrame() {
        Mat currentFrame = new Mat();
        if (videoCapture.isOpened()) {
            videoCapture.read(currentFrame);
        }
        Core.flip(currentFrame, currentFrame, 1);
        return currentFrame;
    }
}
