package com.jkarkoszka.gesturedetector.service;

import org.junit.Before;
import org.junit.Test;
import org.opencv.core.Point;
import static org.junit.Assert.*;

public class GeometryServiceTest {

    private GeometryService geometryService;

    @Before
    public void setUp() {
        geometryService = new GeometryService();
    }

    @Test
    public void shouldReturnCorrectRootPoint() {
        //given
        Point point1 = new Point(2, 2);
        Point point2 = new Point(-2, -2);
        Integer expectedAngle = 45;

        //when
        Integer angle = geometryService.getAngle(point1, point2);

        //then
        assertEquals(expectedAngle, angle);
    }

    @Test
    public void shouldReturnCorrectRootPoint_2() {
        //given
        Point point1 = new Point(100, 100);
        Point point2 = new Point(100, 20);
        Integer expectedAngle = 0;

        //when
        Integer angle = geometryService.getAngle(point1, point2);

        //then
        assertEquals(expectedAngle, angle);
    }

    @Test
    public void shouldReturnCorrectRootPoint_3() {
        //given
        Point point1 = new Point(100, 100);
        Point point2 = new Point(120, 20);
        Integer expectedAngle = -14;

        //when
        Integer angle = geometryService.getAngle(point1, point2);

        //then
        assertEquals(expectedAngle, angle);
    }

    @Test
    public void shouldReturnCorrectRootPoint_4() {
        //given
        Point point1 = new Point(100, 100);
        Point point2 = new Point(80, 20);
        Integer expectedAngle = 14;

        //when
        Integer angle = geometryService.getAngle(point1, point2);

        //then
        assertEquals(expectedAngle, angle);
    }

    @Test
    public void shouldReturnCorrectRootPoint_5() {
        //given
        Point point1 = new Point(100, 100);
        Point point2 = new Point(200, 150);
        Integer expectedAngle = 63;

        //when
        Integer angle = geometryService.getAngle(point1, point2);

        //then
        assertEquals(expectedAngle, angle);
    }


    @Test
    public void shouldReturnCorrectRootPoint_6() {
        //given
        Point point1 = new Point(100, 100);
        Point point2 = new Point(200, 0);
        Integer expectedAngle = 63;

        //when
        Integer angle = geometryService.getAngle(point1, point2);

        //then
        assertEquals(expectedAngle, angle);
    }

    @Test
    public void shouldReturnCorrectRootPoint_7() {
        //given
        Point point1 = new Point(50, 200);
        Point point2 = new Point(160, 50);
        Integer expectedAngle = -36;

        //when
        Integer angle = geometryService.getAngle(point1, point2);

        //then
        assertEquals(expectedAngle, angle);
    }

    @Test
    public void shouldReturnCorrectRootPoint_8() {
        //given
        Point point1 = new Point(50, 200);
        Point point2 = new Point(200, 50);
        Integer expectedAngle = -45;

        //when
        Integer angle = geometryService.getAngle(point1, point2);

        //then
        assertEquals(expectedAngle, angle);
    }
}
