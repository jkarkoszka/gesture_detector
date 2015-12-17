package com.jkarkoszka.gesturedetector.service;

import org.apache.commons.math3.linear.*;
import org.opencv.core.Mat;
import org.opencv.core.Point;

public class GeometryService {

    public Integer getAngle(Point lastImportantPoint, Point currentPoint, Point nextPoint) {
        Double distanceBetweenCurrentPointAndLastImportantPoint = getDistance(currentPoint, lastImportantPoint);
        Double distanceBetweenCurrentPointAndNextPoint = getDistance(currentPoint, nextPoint);
        Double distanceBetweenLastImportantPointAndNextPoint = getDistance(lastImportantPoint, nextPoint);
        Double resultInRadians = Math.acos(
                (
                        Math.pow(distanceBetweenCurrentPointAndLastImportantPoint, 2)
                                +
                                Math.pow(distanceBetweenCurrentPointAndNextPoint, 2)
                                -
                                Math.pow(distanceBetweenLastImportantPointAndNextPoint, 2)
                )
                        /
                        (2*distanceBetweenCurrentPointAndLastImportantPoint*distanceBetweenCurrentPointAndNextPoint)
        )/6.28;
        return new Double(360*resultInRadians).intValue();
    }

    public Double getDistance(Point point1, Point point2) {
        return Math.sqrt(
                Math.pow(point1.x-point2.x, 2)
                        +
                        Math.pow(point1.y-point2.y, 2)
        );
    }

    public Integer getAngle(Point point1, Point point2) {
        if (point1.x == point2.x) {
            return 0;
        }
        if (point1.y == point2.y) {
            return 90;
        }
        return new Double(360*Math.atan((point1.x - point2.x)/(point1.y - point2.y))/6.28).intValue();
    }
}
