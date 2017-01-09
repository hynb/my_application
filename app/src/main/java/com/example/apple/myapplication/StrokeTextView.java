package com.example.apple.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

import java.lang.reflect.Field;

/**
 * Created by apple on 16/5/26.
 */
public class StrokeTextView extends TextView {

    private boolean isStroke = true;
    private TextPaint m_TextPaint = this.getPaint();
    private int strokeColor = 0;
    private int textColor = 0;
    private int strokeWidth = 0;
    public StrokeTextView(Context context, int strokeColor, int strokeWidth){
        super(context);
        init(strokeColor,strokeWidth);
    }
    public StrokeTextView(Context context, AttributeSet attrs, int strokeColor, int strokeWidth) {
        super(context, attrs);
        init(strokeColor,strokeWidth);
    }

    private void init(int strokeColor,int strokeWidth){
        this.strokeColor = strokeColor;
        this.textColor = 0xFF000000;
        this.strokeWidth = strokeWidth;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (isStroke) {
            // 描外层
            //super.setTextColor(Color.BLUE); // 不能直接这么设，如此会导致递归
            setTextColorUseReflection(strokeColor);
            m_TextPaint.setStrokeWidth(strokeWidth);  // 描边宽度
            m_TextPaint.setStyle(Paint.Style.FILL_AND_STROKE); //描边种类
            m_TextPaint.setFakeBoldText(true); // 外层text采用粗体
            m_TextPaint.setShadowLayer(1, 0, 0, 0); //字体的阴影效果，可以忽略
            super.onDraw(canvas);


            // 描内层，恢复原先的画笔

            //super.setTextColor(Color.BLUE); // 不能直接这么设，如此会导致递归
            setTextColorUseReflection(textColor);
            m_TextPaint.setStrokeWidth(0);
            m_TextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            m_TextPaint.setFakeBoldText(false);
            m_TextPaint.setShadowLayer(0, 0, 0, 0);
        }
        super.onDraw(canvas);
    }

    private void setTextColorUseReflection(int color) {
        Field textColorField;
        try {
            textColorField = TextView.class.getDeclaredField("mCurTextColor");
            textColorField.setAccessible(true);
            textColorField.set(this,color);
            textColorField.setAccessible(false);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        m_TextPaint.setColor(color);
    }

    @Override
    public void setTextColor(int color) {
        textColor = color;
    }
}
