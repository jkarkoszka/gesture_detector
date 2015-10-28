package com.jkarkoszka.opencv.example;

import javax.swing.*;

import com.jkarkoszka.opencv.example.converter.MatToBufferedImageConverter;
import com.jkarkoszka.opencv.example.service.Webcam;
import com.jkarkoszka.opencv.example.window.Window;
import com.jkarkoszka.opencv.example.window.Panel;
import org.opencv.core.Core;
import org.opencv.highgui.VideoCapture;

public class ApplicationEntryPoint extends JPanel{

    public static void main(String arg[]){
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Window window = new Window(new Panel());

        Webcam webcam = new Webcam(new VideoCapture(0), new MatToBufferedImageConverter());

        GesturesDetectorApplication application = new GesturesDetectorApplication(window, webcam);
        application.run();
    }
}
