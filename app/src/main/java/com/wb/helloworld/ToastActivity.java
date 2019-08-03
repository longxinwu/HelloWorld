package com.wb.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wb.helloworld.util.ToastUtil;

public class ToastActivity extends AppCompatActivity {

    private Button toast1,toast2,toast3,toast4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        toast1 = findViewById(R.id.btn_toast_1);
        toast2 = findViewById(R.id.btn_toast_2);
        toast3 = findViewById(R.id.btn_toast_3);
        toast4 = findViewById(R.id.btn_toast_4);
        OnClick mOnclick = new OnClick();
        toast1.setOnClickListener(mOnclick);
        toast2.setOnClickListener(mOnclick);
        toast3.setOnClickListener(mOnclick);
        toast4.setOnClickListener(mOnclick);

    }

    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_toast_1:
                    Toast.makeText(getApplicationContext(),"默认Toast", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_toast_2:
                    Toast midToast = Toast.makeText(getApplicationContext(), "居中Toast", Toast.LENGTH_SHORT);
                    midToast.setGravity(Gravity.CENTER, 0, 0);
                    midToast.show();
                    break;
                case R.id.btn_toast_3:
                    Toast toastCustom = new Toast(getApplicationContext());
                    LayoutInflater inflater = LayoutInflater.from(ToastActivity.this);
                    View view1 = inflater.inflate(R.layout.layout_toast, null);
                    ImageView imageView = view1.findViewById(R.id.iv_toast);
                    TextView textView = view1.findViewById(R.id.tv_toast);
                    textView.setText("自定义Toast");
                    imageView.setImageResource(R.drawable.phone);
                    toastCustom.setView(view1);
                    toastCustom.setDuration(Toast.LENGTH_LONG);
                    toastCustom.show();
                    break;
                case R.id.btn_toast_4:
                    ToastUtil.showMsg(getApplicationContext(),"封装ToastUtil");
                    break;
            }
        }
    }
}
