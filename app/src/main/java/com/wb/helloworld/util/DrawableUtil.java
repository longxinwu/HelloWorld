package com.wb.helloworld.util;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

public class DrawableUtil {
    /**
     * editView 0 left, 1 top, 2 right, 3 bottom
     */
    private final int LEFT = 0;
    private final int RIGHT = 2;

    private EditText mEditText;
    private OnDrawableListener mListener;

    public DrawableUtil(EditText editText, OnDrawableListener listener){
        this.mEditText = editText;
        mEditText.setOnTouchListener(myOnTouchListener);
        this.mListener = listener;
    }

    private View.OnTouchListener myOnTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()){
                case MotionEvent.ACTION_UP:
                    if(mListener != null){
                        Drawable drawableLeft = mEditText.getCompoundDrawables()[LEFT];
                        if (drawableLeft != null && motionEvent.getRawX() <= (mEditText.getLeft() + drawableLeft.getBounds().width())) {
                            mListener.onLeft(view, drawableLeft);
                            return true;
                        }

                        Drawable drawableRight = mEditText.getCompoundDrawables()[RIGHT];
                        if (drawableRight != null && motionEvent.getRawX() >= (mEditText.getRight() - drawableRight.getBounds().width())) {
                            mListener.onRight(view, drawableRight);
                            return true;
                        }
                    }
                    break;
            }
            return false;
        }
    };

    public interface OnDrawableListener {
        /**
         *
         * @param v
         * @param left
         */
         void onLeft(View v, Drawable left);

        /**
         *
         * @param v
         * @param right
         */

         void onRight(View v, Drawable right);
    }
}
