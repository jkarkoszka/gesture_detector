package com.jkarkoszka.gesturedetector.model;

import com.jkarkoszka.gesturedetector.service.GeometryService;
import org.opencv.core.Point;

public class MoveUp extends Move {
    public MoveUp(GeometryService geometryService) {
        super(geometryService);
    }

    @Override
    public boolean isMatch(Point point1, Point point2) {
        if (point2.y <= point1.y) {
            return false;
        }
        //point2 obliczamy miejsce 0
        // i nizej jako point2 używamy tego nowego punktu do wyliczenia kątu

        System.out.println(geometryService.getAngle(new Point(0D, 0D), point2, point1));
        return false;
    }
}
