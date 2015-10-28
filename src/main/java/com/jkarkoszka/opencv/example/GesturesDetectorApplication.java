package com.jkarkoszka.opencv.example;

import com.jkarkoszka.opencv.example.service.Webcam;
import com.jkarkoszka.opencv.example.window.Window;

import java.awt.image.BufferedImage;

public class GesturesDetectorApplication {

    private Window window;

    private Webcam webcam;

    public GesturesDetectorApplication(Window window, Webcam webcam) {
        this.window = window;
        this.webcam = webcam;
    }

    public void run() {
        while(true) {
            BufferedImage currentFrame = webcam.getCurrentFrameBufferedImage();
            window.setSize(currentFrame.getWidth() + 40, currentFrame.getHeight() + 60);
            window.setImage(currentFrame);
            window.repaint();
        }
    }
}
