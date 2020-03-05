package com.example.thefourthproject;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomCircleView extends View {

    private static final int SQUARE_SIZE_DEF = 200;
    private Paint mPaintSquare;
    private int mSquareColor;
    private int mSquareSize;
    private int circle;

    @Override
    protected void onDraw(Canvas canvas) {
        int width = this.getWidth();
        int height = this.getHeight();
        canvas.drawCircle(width / 2, height / 2, circle, mPaintSquare);
    }

    public CustomCircleView(Context context) {
        super(context);
        init(null);
    }

    public CustomCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(@Nullable AttributeSet set) {

        mPaintSquare = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintSquare.setTextAlign(Paint.Align.CENTER);
        if (set == null) return;
        TypedArray ta = getContext().obtainStyledAttributes(set, R.styleable.CustomCircleView);
        mSquareColor = ta.getColor(R.styleable.CustomCircleView_square_color, Color.BLUE);
        circle = ta.getDimensionPixelSize(R.styleable.CustomCircleView_circleRadius, 30);
        mPaintSquare.setColor(mSquareColor);
        ta.recycle();
    }
}
