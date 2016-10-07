package com.mall.fragment_search;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Lin on 2016/10/7 0007.
 * 带边框的textview
 */

public class MyBorderTextView extends TextView{
    public MyBorderTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(0xff8181);
        canvas.drawLine(0,0,this.getWidth()-1,0,paint);
        canvas.drawLine(0,0,0,this.getHeight()-1,paint);
        canvas.drawLine(this.getWidth()-1,0,this.getWidth()-1,this.getHeight()-1,paint);
        canvas.drawLine(0,this.getHeight()-1,this.getWidth()-1,this.getHeight()-1,paint);

    }
}
