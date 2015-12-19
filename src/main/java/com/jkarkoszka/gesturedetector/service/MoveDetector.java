package com.jkarkoszka.gesturedetector.service;

import com.jkarkoszka.gesturedetector.model.DetectedPoint;
import com.jkarkoszka.gesturedetector.model.move.Move;

import java.util.ArrayList;

public class MoveDetector {

    private ArrayList<Move> availableMoves = new ArrayList<>();

    public MoveDetector( ArrayList<Move> availableMoves) {
        this.availableMoves = availableMoves;

    }

    public ArrayList<Move> detect(ArrayList<DetectedPoint> keyPoints) {
        ArrayList<Move> detectedMoves = new ArrayList<>();
        if (keyPoints.size() < 2) {
            return detectedMoves;
        }
        for (int i = 1; i < keyPoints.size(); i++) {
            for (Move availableMove : availableMoves) {
                if (availableMove.isMatch(keyPoints.get(i-1).getPoint(), keyPoints.get(i).getPoint())) {
                    detectedMoves.add(availableMove);
                    continue;
                }
            }
        }
        System.out.println("detectedMoves = "+detectedMoves.size());
        return detectedMoves;
    }
}
