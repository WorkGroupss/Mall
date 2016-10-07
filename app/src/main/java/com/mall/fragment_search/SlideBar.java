package com.mall.fragment_search;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Lin on 2016/10/7 0007.
 * A-Z
 */

public class SlideBar extends View{
    private Paint paint = new Paint();

    public static String[] letters = { "#", "A", "B", "C", "D", "E", "F", "G",
            "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z" };

    public SlideBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight()-30;
        //每个字母的高度
        int singleHeight = height/letters.length;
        canvas.drawColor(0X00000000);
        for (int i = 0; i < letters.length; i++) {
            paint.setColor(0XFF666666);
            paint.setTypeface(Typeface.DEFAULT);
            paint.setAntiAlias(true);
            paint.setTextSize(30f);

            float posx = width/2 - paint.measureText(letters[i])/2;
            float posy = i*singleHeight+singleHeight;
            //画出字母
            canvas.drawText(letters[i],posx,posy,paint);

            paint.reset();
        }

    }
}
