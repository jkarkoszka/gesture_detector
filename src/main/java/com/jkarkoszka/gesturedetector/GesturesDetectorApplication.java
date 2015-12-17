package com.jkarkoszka.gesturedetector;

import com.jkarkoszka.gesturedetector.converter.MatToBufferedImageConverter;
import com.jkarkoszka.gesturedetector.model.DetectedPoint;
import com.jkarkoszka.gesturedetector.model.move.Move;
import com.jkarkoszka.gesturedetector.service.*;
import com.jkarkoszka.gesturedetector.window.Window;
import org.opencv.core.Mat;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GesturesDetectorApplication {

    private Window window;

    private Webcam webcam;

    private DetectedPoints detectedPoints;

    private GestureDetector gestureDetector;

    private Detector ballDetector;

    private KeyPointsDetector keyPointsDetector;

    private MoveDetector moveDetector;

    private MatToBufferedImageConverter matToBufferedImageConverter;

    public GesturesDetectorApplication(Window window, Webcam webcam, DetectedPoints detectedPoints, GestureDetector gestureDetector, Detector detector, KeyPointsDetector keyPointsDetector, MoveDetector moveDetector, MatToBufferedImageConverter matToBufferedImageConverter) {
        this.window = window;
        this.webcam = webcam;
        this.moveDetector = moveDetector;
        this.matToBufferedImageConverter = matToBufferedImageConverter;
        this.keyPointsDetector = keyPointsDetector;
        this.ballDetector = detector;
        this.detectedPoints = detectedPoints;
        this.gestureDetector = gestureDetector;
    }

    public void run() {
        while(true) {
            Mat currentFrame = webcam.getCurrentFrame();

            if (currentFrame == null) {
                continue;
            }

            DetectedPoint detectedPoint = ballDetector.detect(currentFrame);
            currentFrame = ballDetector.draw(currentFrame, detectedPoint);

            detectedPoints.add(detectedPoint);
            currentFrame = detectedPoints.draw(currentFrame);

            ArrayList<DetectedPoint> keyPoints = keyPointsDetector.detect(detectedPoints.get());
            currentFrame = keyPointsDetector.draw(currentFrame, keyPoints);

            ArrayList<Move> detectedMoves = moveDetector.detect(keyPoints);

            Boolean isGestureDetected = gestureDetector.isMatch(detectedMoves);
            gestureDetector.draw(currentFrame, isGestureDetected);

            renderWindow(currentFrame);
        }
    }

    private void renderWindow(Mat mat) {
        BufferedImage currentFrame =  matToBufferedImageConverter.convert(mat);
        window.setSize(currentFrame.getWidth() + 40, currentFrame.getHeight() + 60);
        window.setImage(currentFrame);
        window.repaint();
    }
}
