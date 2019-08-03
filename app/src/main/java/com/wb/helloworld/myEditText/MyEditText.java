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
 * @Description 自定义editText
 * @Date 2019/8/1 16:21
 */
public class MyEditText extends AppCompatEditText {

    private Context mContext;
    private ClearBtnMode mClearBtnMode;
    private Drawable drawPicRight;
    private static int RIGHT = 2;
    /**
     * @Author   wang bo
     * @Description  按钮显示的方式  never 从不显示 whileEditing 编辑时显示
     *
     * @Parameter
     */
    public enum ClearBtnMode {
        NEVER, WHILEEDITING
    }

    public MyEditText(Context context) {
        super(context);

        init(context, null, 0);
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    public void init(Context context, AttributeSet attributeSet,int defStyleAttr){
        this.mContext = context;
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.overrideEditText);
        int mode = typedArray.getInteger(R.styleable.overrideEditText_clearBtnMode,R.drawable.cancel);
        typedArray.recycle();
        switch (mode){
            case 1:
                mClearBtnMode = ClearBtnMode.WHILEEDITING;
                break;
            default:
                mClearBtnMode = ClearBtnMode.NEVER;
                break;
        }
        this.setCompoundDrawables(null,null,null,null);
    }

    private void buttonManager(){
        switch (mClearBtnMode){
            case WHILEEDITING:
                if(hasFocus() && getText().length() > 0){
                    drawPicRight = getResources().getDrawable(R.drawable.cancel,null);
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
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();

        buttonManager();

        canvas.restore();

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

    public void setmClearBtnMode(ClearBtnMode mClearBtnMode) {
        this.mClearBtnMode = mClearBtnMode;
    }

    public void setDrawPicRight(Drawable drawPicRight) {
        this.drawPicRight = drawPicRight;
    }
}
