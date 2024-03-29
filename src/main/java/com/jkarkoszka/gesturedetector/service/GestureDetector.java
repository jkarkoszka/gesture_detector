package com.jkarkoszka.gesturedetector.service;

import com.jkarkoszka.gesturedetector.model.move.Move;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;

import java.util.ArrayList;
import java.util.List;

public class GestureDetector {

    private ArrayList<Move> gestureMoves = new ArrayList<>();

    public GestureDetector(ArrayList<Move> gestureMoves) {
        this.gestureMoves = gestureMoves;
    }

    public boolean isMatch(ArrayList<Move> detectedMoves) {
        if (detectedMoves.size() < gestureMoves.size()) {
            return false;
        }
        Integer from = detectedMoves.size()-gestureMoves.size();
        Integer to = detectedMoves.size();
        List<Move> detectedGestureMoves = detectedMoves.subList(from, to);
        System.out.println("detectedGestureMoves = "+detectedGestureMoves.size());
        if (!detectedGestureMoves.equals(gestureMoves)) {
            return false;
        }
        return true;
    }

    public void draw(Mat currentFrame, Boolean isGestureDetected) {
        if (isGestureDetected) {
            Point point = new Point(100, 100);
            Double fontScale = 2.0D;
            Core.putText(currentFrame, "GEST WYKRYTY", point, Core.FONT_HERSHEY_TRIPLEX, fontScale, new Scalar(255, 0, 255));
        }
    }
}
