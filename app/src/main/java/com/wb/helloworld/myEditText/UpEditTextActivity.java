package com.wb.helloworld.myEditText;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.wb.helloworld.R;

public class UpEditTextActivity extends AppCompatActivity {

    private UpEditText upEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_edit_text);
        upEditText = findViewById(R.id.upET1);
    }
}
