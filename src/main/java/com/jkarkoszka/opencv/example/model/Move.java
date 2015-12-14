package com.jkarkoszka.opencv.example.model;

import com.jkarkoszka.opencv.example.service.GeometryService;
import org.opencv.core.Point;

abstract class Move {

    protected GeometryService geometryService;

    public Move(GeometryService geometryService) {
        this.geometryService = geometryService;
    }

    abstract boolean isMatch(Point point1, Point point2);

}
