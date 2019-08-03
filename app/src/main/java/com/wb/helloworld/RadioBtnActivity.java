package com.wb.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioBtnActivity extends AppCompatActivity {

    private RadioGroup radioGroup1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_btn);
        radioGroup1 = findViewById(R.id.rg_1);
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton rBtn = radioGroup.findViewById(i);
                Toast.makeText(RadioBtnActivity.this,rBtn.getText(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
