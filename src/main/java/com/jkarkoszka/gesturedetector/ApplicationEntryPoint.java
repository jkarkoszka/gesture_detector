package com.jkarkoszka.gesturedetector;

import javax.swing.*;

import com.jkarkoszka.gesturedetector.model.move.*;
import com.jkarkoszka.gesturedetector.service.*;
import com.jkarkoszka.gesturedetector.window.Window;
import com.jkarkoszka.gesturedetector.converter.MatToBufferedImageConverter;
import com.jkarkoszka.gesturedetector.window.Panel;
import org.opencv.core.Core;
import org.opencv.highgui.VideoCapture;

import java.util.ArrayList;

public class ApplicationEntryPoint extends JPanel{

    public static void main(String arg[]){
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Window window = new Window(new Panel());

        Webcam webcam = new Webcam(new VideoCapture(0));

        Detector ballDetector = new BallDetector();

        GeometryService geometryService = new GeometryService();

        KeyPointsDetector keyPointsDetector = new KeyPointsDetector(geometryService);

        ArrayList<Move> availableMoves = new ArrayList<>();
        availableMoves.add(new MoveUp(geometryService));
        availableMoves.add(new MoveDown(geometryService));
        availableMoves.add(new MoveDownRight(geometryService));
        availableMoves.add(new MoveUpRight(geometryService));
        MoveDetector moveDetector = new MoveDetector(availableMoves);

        ArrayList<Move> gestureMoves = new ArrayList<>();
        gestureMoves.add(new MoveUp(geometryService));
        gestureMoves.add(new MoveDownRight(geometryService));
        gestureMoves.add(new MoveUpRight(geometryService));
        gestureMoves.add(new MoveDown(geometryService));

        GestureDetector gestureDetector = new GestureDetector(gestureMoves);

        MatToBufferedImageConverter matToBufferedImageConverter = new MatToBufferedImageConverter();

        DetectedPoints detectedPoints = new DetectedPoints();

        GesturesDetectorApplication application = new GesturesDetectorApplication(window, webcam, detectedPoints, gestureDetector, ballDetector, keyPointsDetector, moveDetector, matToBufferedImageConverter);
        application.run();
    }
}
