package com.jkarkoszka.gesturedetector.model;

import org.opencv.core.Point;
import org.opencv.core.Size;

public class DetectedPoint {

    private Point point;

    private Size axes;

    private Long timestamp;

    public DetectedPoint(Long timestamp, Point point, Size axes) {
        this.point = point;
        this.timestamp = timestamp;
        this.axes = axes;
    }

    public Point getPoint() {
        return point;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public Size getAxes() {
        return axes;
    }
}
