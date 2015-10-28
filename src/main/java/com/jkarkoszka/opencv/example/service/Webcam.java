package com.jkarkoszka.opencv.example.service;


import com.jkarkoszka.opencv.example.converter.MatToBufferedImageConverter;
import org.opencv.core.Mat;
import org.opencv.highgui.VideoCapture;

import java.awt.image.BufferedImage;

public class Webcam {

    private VideoCapture videoCapture;

    private MatToBufferedImageConverter matToBufferedImageConverter;

    public Webcam(VideoCapture videoCapture, MatToBufferedImageConverter matToBufferedImageConverter) {
        this.videoCapture = videoCapture;
        this.matToBufferedImageConverter = matToBufferedImageConverter;
    }

    public BufferedImage getCurrentFrameBufferedImage() {
        Mat currentFrameMat = getCurrentFrameMat();
        BufferedImage bufferedImage = matToBufferedImageConverter.convert(currentFrameMat);
        return bufferedImage;
    }

    private Mat getCurrentFrameMat() {
        Mat matFrame = new Mat();
        if (videoCapture.isOpened()) {
            videoCapture.read(matFrame);
        }
        return matFrame;
    }
}
