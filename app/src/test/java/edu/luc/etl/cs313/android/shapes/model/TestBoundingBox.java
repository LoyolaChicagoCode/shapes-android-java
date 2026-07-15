package edu.luc.etl.cs313.android.shapes.model;

import static edu.luc.etl.cs313.android.shapes.model.Fixtures.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestBoundingBox {

    protected BoundingBox v;

    @BeforeEach
    public void setUp() {
        v = new BoundingBox();
    }

    @AfterEach
    public void tearDown() {
        v = null;
    }

    @Test
    public void testCircle() {
        final var b = new Circle(50).accept(v);
        final var r = (Rectangle) b.getShape();
        assertEquals(-50, b.getX());
        assertEquals(-50, b.getY());
        assertEquals(100, r.getWidth());
        assertEquals(100, r.getHeight());
    }

    @Test
    public void testRectangle() {
        final var b = new Rectangle(80, 120).accept(v);
        final var r = (Rectangle) b.getShape();
        assertEquals(0, b.getX());
        assertEquals(0, b.getY());
        assertEquals(80, r.getWidth());
        assertEquals(120, r.getHeight());
    }

    @Test
    public void testLocation() {
        final var b = simpleLocation.accept(v);
        final var r = (Rectangle) b.getShape();
        assertEquals(70, b.getX());
        assertEquals(30, b.getY());
        assertEquals(80, r.getWidth());
        assertEquals(120, r.getHeight());
    }

    @Test
    public void testFilled() {
        final var b = simpleFill.accept(v);
        final var r = (Rectangle) b.getShape();
        assertEquals(0, b.getX());
        assertEquals(0, b.getY());
        assertEquals(80, r.getWidth());
        assertEquals(120, r.getHeight());
    }

    @Test
    public void testStrokeColor() {
        final var b = simpleStrokeColor.accept(v);
        final var r = (Rectangle) b.getShape();
        assertEquals(0, b.getX());
        assertEquals(0, b.getY());
        assertEquals(80, r.getWidth());
        assertEquals(120, r.getHeight());
    }

    @Test
    public void testGroupSimple() {
        final var b = simpleGroup.accept(v);
        final var r = (Rectangle) b.getShape();
        assertEquals(150, b.getX());
        assertEquals(50, b.getY());
        assertEquals(350, r.getWidth());
        assertEquals(300, r.getHeight());
    }

    @Test
    public void testGroupComplex() {
        final var b = complexGroup.accept(v);
        final var r = (Rectangle) b.getShape();
        assertEquals(30, b.getX());
        assertEquals(80, b.getY());
        assertEquals(470, r.getWidth());
        assertEquals(320, r.getHeight());
    }

    @Test
    public void testOutline() {
        final var b = simpleOutline.accept(v);
        final var r = (Rectangle) b.getShape();
        assertEquals(0, b.getX());
        assertEquals(0, b.getY());
        assertEquals(80, r.getWidth());
        assertEquals(120, r.getHeight());
    }

    @Test
    public void testPolygon() {
        final var b = simplePolygon.accept(v);
        final var r = (Rectangle) b.getShape();
        assertEquals(50, b.getX());
        assertEquals(50, b.getY());
        assertEquals(70, r.getWidth());
        assertEquals(60, r.getHeight());
    }
}
