package com.jkarkoszka.gesturedetector.model.move;

import com.jkarkoszka.gesturedetector.service.GeometryService;
import org.opencv.core.Point;

public class MoveUp extends Move {

    private String id = "MOVE_UP";

    public MoveUp(GeometryService geometryService) {
        super(geometryService);
    }

    @Override
    public boolean isMatch(Point point1, Point point2) {
        if (point1.y < point2.y) {
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

        MoveUp moveUp = (MoveUp) o;

        return !(id != null ? !id.equals(moveUp.id) : moveUp.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
