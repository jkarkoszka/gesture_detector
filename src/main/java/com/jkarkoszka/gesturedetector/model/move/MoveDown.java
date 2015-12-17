package com.jkarkoszka.gesturedetector.model.move;

import com.jkarkoszka.gesturedetector.service.GeometryService;
import org.opencv.core.Point;

public class MoveDown extends Move {

    private String id = "MOVE_DOWN";

    public MoveDown(GeometryService geometryService) {
        super(geometryService);
    }

    @Override
    public boolean isMatch(Point point1, Point point2) {
        if (point2.y < point1.y) {
            return false;
        }

        Integer angle = geometryService.getAngle(point1, point2);

        if (angle > -20 && angle < 20) {
            return true;
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MoveDown moveDown = (MoveDown) o;

        return !(id != null ? !id.equals(moveDown.id) : moveDown.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
