package com.wb.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.wb.helloworld.myEditText.MyEditText;

/**
 * @Author   wang bo
 * @Description
 * @Parameter
 * @Date 2019-8-2
 */
public class MySelfEditTextActivity extends AppCompatActivity {

    private MyEditText myEditText1;
    private MyEditText myEditText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_self_edit_text);
        myEditText1 = findViewById(R.id.myselfET);
        myEditText2 = findViewById(R.id.myselfET2);
        myEditText1.setmClearBtnMode(MyEditText.ClearBtnMode.WHILEEDITING);
        myEditText2.setmClearBtnMode(MyEditText.ClearBtnMode.NEVER);
    }

    public void onclick(View view) {

    }
}
