package com.wb.helloworld.myEditText;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.appcompat.widget.AppCompatEditText;

import com.wb.helloworld.R;

/**
 * @Author bowang
 * @Description 自定义UpEditView
 * @Date 2019/8/2 14:57
 */
public class UpEditText extends AppCompatEditText {

    //setCompoundDrawable() 0 left, 1 top, 2 right, 3 bottom

    private static int LEFT = 0;
    private static int RIGHT= 2;
    private Context context;
    //EditText的显示模式 0 从不显示，1 当编辑的时候显示
    private ClearDrawMode clearDrawMode;
    private int picId = R.drawable.cancel;

    public UpEditText(Context context) {
        super(context);
        init(context, null, 0);
    }

    public UpEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public UpEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);

    }

    private void init(Context context, AttributeSet attributeSet,int defStyleAttr){
        this.context = context;
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.UpEditText);
        int attr = typedArray.getInteger(R.styleable.UpEditText_clearDrawMode,picId);
        typedArray.recycle();
        switch (attr){
            case 1:
                clearDrawMode = ClearDrawMode.WHILEEDITING;
                break;
            default:
                clearDrawMode = ClearDrawMode.NEVER;
                break;
        }
        this.setCompoundDrawables(null,null,null,null);
    }

    public enum ClearDrawMode{
        NEVER, WHILEEDITING
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        buttonManager();
        canvas.restore();
    }

    public void buttonManager(){
        switch (clearDrawMode){
            case WHILEEDITING:
                if(hasFocus() && getText().length() > 0){
                    Drawable drawPicRight = getResources().getDrawable(R.drawable.cancel,null);
                    drawPicRight.setBounds(1,1,60,60);
                    this.setCompoundDrawables(null,null,drawPicRight,null);
                }else if(getText().length() == 0){
                    this.setCompoundDrawables(null,null,null,null);
                }
                break;
            default:
                this.setCompoundDrawables(null,null,null,null);
                break;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_UP:
                Drawable drawableRight = this.getCompoundDrawables()[RIGHT];
                if (drawableRight != null && event.getRawX() >= (this.getRight() - (drawableRight.getBounds().width()) - getPaddingRight())){
                    this.setText(null);
                    this.setCompoundDrawables(null,null,null,null);
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    public void setClearDrawMode(ClearDrawMode clearDrawMode) {
        this.clearDrawMode = clearDrawMode;
    }

    public void setPicId(int picId) {
        this.picId = picId;
    }
}
