package com.example.santos.beizerline;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

public class MyView extends View {

    float mProgress = 0f;
    private Paint mPaint;
    private ArrayList<Point> list;
    private float step;
    //    private float step = 0.01f;
    private long drawInterval;
//    private long drawInterval = 100;

    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeWidth(10);
        mPaint.setColor(Color.RED);

        list = new ArrayList<>();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        float progress = 0.6f;
        float tempProgress = mProgress;
        int xs[] = {100, 400, 700};
        int ys[] = {0, 700, 0};

        int x = Calculator.getTargetCoordinate(tempProgress, xs);
        int y = Calculator.getTargetCoordinate(tempProgress, ys);

        savePoints(x, y);

        for (Point point : list) {
            canvas.drawPoint(point.x, point.y, mPaint);
        }

        canvas.drawPoint(x, y, mPaint);
    }

    private ArrayList<Point> savePoints(int x, int y) {
        list.add(new Point(x, y));
        return list;
    }

    public void setStep(float step1) {
        this.step = step1;
    }

    public void setDrawInterval(long interval) {
        this.drawInterval = interval;
    }

    public void startAnim() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                while (true) {

                    if (mProgress >= 1) {
                        return;
                    }

                    postInvalidate();
                    mProgress += step;
                    try {
                        Thread.sleep(drawInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

}
