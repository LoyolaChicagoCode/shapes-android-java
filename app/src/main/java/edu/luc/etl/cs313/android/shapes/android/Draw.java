package edu.luc.etl.cs313.android.shapes.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import edu.luc.etl.cs313.android.shapes.model.*;

/**
 * A Visitor for drawing a shape to an Android canvas.
 */
public class Draw implements Visitor<Void> {

    // TODO entirely your job (except onCircle)

    private final Canvas canvas;

    private final Paint paint;

    public Draw(final Canvas canvas, final Paint paint) {
        this.canvas = canvas; // FIXED CONSTRUCTOR TO PROVIDED CANVAS
        this.paint = paint; // FIXED CONSTRUCTOR TO PROVIDED PAINT
        paint.setStyle(Style.STROKE);
    }

    @Override
    public Void onCircle(final Circle c) {
        canvas.drawCircle(0, 0, c.getRadius(), paint);
        return null;
    }

    @Override
    public Void onStrokeColor(final StrokeColor c) {
        //canvas.draw
        return null;
    }

    @Override
    public Void onFill(final Fill f) {
        //canvas.draw
        return null;
    }

    @Override
    public Void onGroup(final Group g) {
        //canvas.draw
        return null;
    }

    @Override
    public Void onLocation(final Location l) {
        //canvas.draw
        return null;
    }

    @Override
    public Void onRectangle(final Rectangle r) {
        canvas.drawRect(0, 0 , r.getHeight(), r.getWidth(), paint);
        return null;
    }

    @Override
    public Void onOutline(Outline o) {
        //canvas.draw
        return null;
    }

    @Override
    public Void onPolygon(final Polygon s) {

        final float[] pts = null;

        canvas.drawLines(pts, paint);
        return null;
    }
}
