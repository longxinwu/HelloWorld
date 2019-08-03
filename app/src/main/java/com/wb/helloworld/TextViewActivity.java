package com.wb.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.widget.TextView;

public class TextViewActivity extends AppCompatActivity {

    private TextView textView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        textView4 = findViewById(R.id.textView_4);
        textView4.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中划线
        textView4.getPaint().setAntiAlias(true);//去锯齿
    }
}
