package edu.luc.etl.cs313.android.shapes.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static edu.luc.etl.cs313.android.shapes.model.Fixtures.*;

public class TestCount {

    protected Count v;

    @BeforeEach
    public void setUp() {
        v = new Count();
    }

    @AfterEach
    public void tearDown() {
        v = null;
    }

    @Test
    public void testCircle() {
        assertEquals(1, new Circle(50).accept(v).intValue());
    }

    @Test
    public void testRectangle() {
        assertEquals(1, new Rectangle(80, 120).accept(v).intValue());
    }

    @Test
    public void testLocation() {
        assertEquals(1, simpleLocation.accept(v).intValue());
    }

    @Test
    public void testFill() {
        assertEquals(1, simpleFill.accept(v).intValue());
    }

    @Test
    public void testStrokeColor() {
        assertEquals(1, simpleStrokeColor.accept(v).intValue());
    }

    @Test
    public void testGroupSimple() {
        assertEquals(2, simpleGroup.accept(v).intValue());
    }

    @Test
    public void testGroupMiddle() {
        assertEquals(3, middleGroup.accept(v).intValue());
    }

    @Test
    public void testGroupComplex() {
        assertEquals(6, complexGroup.accept(v).intValue());
    }

    @Test
    public void testOutline() {
        assertEquals(1, simpleOutline.accept(v).intValue());
    }

    @Test
    public void testPolygon() {
        assertEquals(1, simplePolygon.accept(v).intValue());
    }
}
