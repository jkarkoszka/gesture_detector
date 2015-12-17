package com.jkarkoszka.gesturedetector.model.move;

import com.jkarkoszka.gesturedetector.service.GeometryService;
import org.opencv.core.Point;

public abstract class Move {

    protected GeometryService geometryService;

    private String id;

    public Move(GeometryService geometryService) {
        this.geometryService = geometryService;
    }

    public abstract boolean isMatch(Point point1, Point point2);

}
