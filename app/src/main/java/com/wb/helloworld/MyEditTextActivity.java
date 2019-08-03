package com.wb.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.optimus.edittextfield.EditTextField;

import static com.optimus.edittextfield.EditTextField.ClearButtonMode.ALWAYS;
import static com.optimus.edittextfield.EditTextField.ClearButtonMode.NEVER;
import static com.optimus.edittextfield.EditTextField.ClearButtonMode.UNLESSEDITING;
import static com.optimus.edittextfield.EditTextField.ClearButtonMode.WHILEEDITING;


/**
 * @author wang bo
 * @Date 2019-8-1
 * @description 自定义editText
 */
public class MyEditTextActivity extends AppCompatActivity {

    private EditTextField userEditTextField;
    private EditTextField passEditTextField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_edit_text);
        userEditTextField = findViewById(R.id.my_editTextUser);
        passEditTextField = findViewById(R.id.my_editTextPass);
        userEditTextField.setClearButtonMode(UNLESSEDITING);
        passEditTextField.setClearButtonMode(WHILEEDITING);
    }
}
