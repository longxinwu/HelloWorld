package com.wb.helloworld.recycleView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wb.helloworld.R;

public class RecyclerViewActivity extends AppCompatActivity {

    private Button btnLiner;
    private Button btnHor;
    private Button btnGrid;
    private Button btnPu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        btnLiner = findViewById(R.id.btn_liner);
        btnHor = findViewById(R.id.btn_hor);
        btnGrid = findViewById(R.id.btn_grid);
        btnPu = findViewById(R.id.btn_pu);
        btnLiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecyclerViewActivity.this,LinerRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
        btnHor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecyclerViewActivity.this, HorRecycleViewActivity.class);
                startActivity(intent);
            }
        });
        btnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecyclerViewActivity.this,GridRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
        btnPu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecyclerViewActivity.this,PuRecyclerViewActicity.class);
                startActivity(intent);
            }
        });

    }
}
