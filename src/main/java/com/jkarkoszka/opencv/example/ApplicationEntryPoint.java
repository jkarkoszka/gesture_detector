package com.jkarkoszka.opencv.example;

import javax.swing.*;

import com.jkarkoszka.opencv.example.converter.MatToBufferedImageConverter;
import com.jkarkoszka.opencv.example.model.Move;
import com.jkarkoszka.opencv.example.service.*;
import com.jkarkoszka.opencv.example.window.Window;
import com.jkarkoszka.opencv.example.window.Panel;
import org.opencv.core.Core;
import org.opencv.highgui.VideoCapture;

import java.util.ArrayList;

public class ApplicationEntryPoint extends JPanel{

    public static void main(String arg[]){
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Window window = new Window(new Panel());

        Webcam webcam = new Webcam(new VideoCapture(0));

        Detector ballDetector = new MouseDetector();

        GeometryService geometryService = new GeometryService();

        KeyPointsDetector keyPointsDetector = new KeyPointsDetector(geometryService);

        MoveDetector moveDetector = new MoveDetector(new ArrayList<Move>());

        MatToBufferedImageConverter matToBufferedImageConverter = new MatToBufferedImageConverter();

        DetectedPoints detectedPoints = new DetectedPoints();

        GesturesDetectorApplication application = new GesturesDetectorApplication(window, webcam, detectedPoints, ballDetector, keyPointsDetector, moveDetector, matToBufferedImageConverter);
        application.run();
    }
}
