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
        paint.setColor(0XFFFF8181);
        paint.setStrokeWidth(3);
        canvas.drawLine(3,3,this.getWidth()-3,3,paint);
        canvas.drawLine(3,3,3,this.getHeight()-3,paint);
        canvas.drawLine(this.getWidth()-3,3,this.getWidth()-3,this.getHeight()-3,paint);
        canvas.drawLine(3,this.getHeight()-3,this.getWidth()-3,this.getHeight()-3,paint);

    }
}
