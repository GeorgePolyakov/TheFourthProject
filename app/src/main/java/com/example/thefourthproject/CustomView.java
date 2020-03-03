package com.example.thefourthproject;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;

import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class CustomView extends View {

    private static final int SQUARE_SIZE_DEF = 200;

    private Rect mRectSquare;
    private Paint mPaintSquare;
    private int mSquareColor;
    private int mSquareSize;
    private int circle;

    public CustomView(Context context) {
        super(context);

        init(null);
        Toast toast = Toast.makeText(getContext(),
                "Вызван первый конструктор", Toast.LENGTH_SHORT);
        toast.show();
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(attrs);

    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
        Toast toast = Toast.makeText(getContext(),
                "Вызван первый конструктор3", Toast.LENGTH_SHORT);
        toast.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init(attrs);
    }

    private void init(@Nullable AttributeSet set) {

        mPaintSquare = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintSquare.setTextAlign(Paint.Align.CENTER);

        if (set == null)
            return;

        TypedArray ta = getContext().obtainStyledAttributes(set, R.styleable.CustomView);

        mSquareColor = ta.getColor(R.styleable.CustomView_square_color, Color.BLUE);
        mSquareSize = ta.getDimensionPixelSize(R.styleable.CustomView_square_size, SQUARE_SIZE_DEF);

        circle = ta.getDimensionPixelSize(R.styleable.CustomView_mradius, 30);


        Toast toast = Toast.makeText(getContext(),
                circle + "", Toast.LENGTH_SHORT);
        toast.show();

        mPaintSquare.setColor(mSquareColor);

        ta.recycle();
    }

    public void swapColor() {
        mPaintSquare.setColor(mPaintSquare.getColor() == mSquareColor ? Color.RED : mSquareColor);

        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int width = this.getWidth();
        int height = this.getHeight();


        canvas.drawCircle(width / 2, height / 2, circle, mPaintSquare);


        Toast toast = Toast.makeText(getContext(),
                canvas.getHeight() + " " + width, Toast.LENGTH_SHORT);
        toast.show();
    }
}
