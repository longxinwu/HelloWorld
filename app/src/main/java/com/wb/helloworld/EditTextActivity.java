package com.wb.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wb.helloworld.util.DrawableUtil;

public class EditTextActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText editTextUser;
    //Icon
    private Drawable mIconUser;
    private Drawable mIconCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        InitIcon();
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EditTextActivity.this, "登录成功",Toast.LENGTH_LONG).show();
            }
        });

        editTextUser = findViewById(R.id.editText_1);

        editTextUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(final Editable editable) {
                editTextUser.setCompoundDrawables(mIconUser,null,mIconCancel,null);
            }
        });
        new DrawableUtil(editTextUser, new DrawableUtil.OnDrawableListener() {
            @Override
            public void onLeft(View v, Drawable left) {

            }

            @Override
            public void onRight(View v, Drawable right) {
                editTextUser.setText(null);
                editTextUser.setCompoundDrawables(mIconUser,null, null,null);
            }
        });
    }
    private void InitIcon(){
        mIconUser = getResources().getDrawable(R.drawable.user,null);
        mIconCancel = getResources().getDrawable(R.drawable.cancel,null);
        mIconUser.setBounds(1,1,60,60);
        mIconCancel.setBounds(1,1,60,60);
    }
}
