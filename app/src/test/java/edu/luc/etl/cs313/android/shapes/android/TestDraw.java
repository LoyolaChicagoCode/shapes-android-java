package edu.luc.etl.cs313.android.shapes.android;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import android.graphics.*;
import android.graphics.Paint.Style;
/*
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
 */

import edu.luc.etl.cs313.android.shapes.model.Fixtures;
import edu.luc.etl.cs313.android.shapes.model.Visitor;

@ExtendWith(MockitoExtension.class)
public class TestDraw {

    @Mock private Canvas canvas;
    @Mock private Paint paint;
    private InOrder inOrder;

    private Visitor<Void> draw;

    @BeforeEach
    public void setUp() {
        inOrder = inOrder(canvas, paint);
        draw = new Draw(canvas, paint);
    }

    @AfterEach
    public void tearDown() {
        draw = null;
        inOrder = null;
        paint = null;
        canvas = null;
    }

    @Test
    public void testSimpleLocation() {
        Fixtures.simpleLocation.accept(draw);
        inOrder.verify(canvas).translate(70, 30);
        inOrder.verify(canvas).drawRect(0, 0, 80, 120, paint);
        inOrder.verify(canvas).translate(-70, -30);
    }

    @Test
    public void testSimpleGroup() {
        Fixtures.simpleGroup.accept(draw);
        inOrder.verify(canvas).translate(200, 100);
        inOrder.verify(canvas).drawCircle(0, 0, 50, paint);
        inOrder.verify(canvas).translate(-200, -100);
        inOrder.verify(canvas).translate(400, 300);
        inOrder.verify(canvas).drawRect(0, 0, 100, 50, paint);
        inOrder.verify(canvas).translate(-400, -300);
    }

    @Test
    public void testComplexGroup() {
        Fixtures.complexGroup.accept(draw);
        inOrder.verify(canvas).translate(50, 100);
        inOrder.verify(canvas).drawCircle(0, 0, 20, paint);
        inOrder.verify(canvas).drawRect(0, 0, 100, 200, paint);
        inOrder.verify(canvas).translate(150, 50);
        inOrder.verify(paint).setColor(Color.RED);
        inOrder.verify(paint).setStyle(Style.FILL_AND_STROKE);
        inOrder.verify(canvas).drawRect(0, 0, 50, 30, paint);
        inOrder.verify(paint).setStyle(Style.STROKE);
        inOrder.verify(canvas).drawRect(0, 0, 300, 60, paint);
        inOrder.verify(paint).setStyle(nullable(Style.class));
        inOrder.verify(paint).setColor(Color.BLUE);
        inOrder.verify(canvas).drawLines((float[]) any(), eq(paint));
        inOrder.verify(paint).setColor(anyInt());
        inOrder.verify(canvas).translate(100, 200);
        inOrder.verify(paint).setColor(Color.MAGENTA);
        inOrder.verify(paint).setStyle(Style.STROKE);
        inOrder.verify(canvas).drawCircle(0, 0, 50, paint);
        inOrder.verify(paint).setStyle(nullable(Style.class));
        inOrder.verify(paint).setColor(anyInt());
        inOrder.verify(canvas).translate(-100, -200);
        inOrder.verify(paint).setStyle(nullable(Style.class));
        inOrder.verify(paint).setColor(anyInt());
        inOrder.verify(canvas).translate(-150, -50);
        inOrder.verify(canvas).translate(-50, -100);
    }
}
