package com.jkarkoszka.gesturedetector.service;

import com.jkarkoszka.gesturedetector.model.DetectedPoint;
import com.jkarkoszka.gesturedetector.model.Move;

import java.util.ArrayList;

public class MoveDetector {

    private ArrayList<Move> availableMoves = new ArrayList<>();

    public MoveDetector( ArrayList<Move> availableMoves) {
        this.availableMoves = availableMoves;

    }

    public void detect(ArrayList<DetectedPoint> keyPoints) {

        //return lista movów
    }
}
