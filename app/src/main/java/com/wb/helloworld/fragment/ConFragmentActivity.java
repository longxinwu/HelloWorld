package com.wb.helloworld.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.wb.helloworld.R;

public class ConFragmentActivity extends AppCompatActivity {


    private Button btnChangeFg;
    private AFragment aFragment;
    private BFragment bFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_con_fragment);
        btnChangeFg = findViewById(R.id.change_Fragment);
        btnChangeFg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bFragment == null){
                    bFragment = new BFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_layout, bFragment).commitAllowingStateLoss();
            }
        });
        aFragment = new AFragment("我来自远方");
        getSupportFragmentManager().beginTransaction().add(R.id.fl_layout, aFragment).commitAllowingStateLoss();
    }
}
