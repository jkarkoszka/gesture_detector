package com.jkarkoszka.opencv.example.service;

import com.jkarkoszka.opencv.example.model.DetectedPoint;
import com.jkarkoszka.opencv.example.model.Move;

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
