package com.jkarkoszka.gesturedetector.model;

import com.jkarkoszka.gesturedetector.service.GeometryService;
import org.opencv.core.Point;

abstract class Move {

    protected GeometryService geometryService;

    public Move(GeometryService geometryService) {
        this.geometryService = geometryService;
    }

    abstract boolean isMatch(Point point1, Point point2);

}
