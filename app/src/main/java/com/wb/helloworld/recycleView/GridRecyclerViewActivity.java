package com.wb.helloworld.recycleView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.wb.helloworld.R;

public class GridRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);
        mRecyclerView = findViewById(R.id.rv_grid);
        mRecyclerView.setLayoutManager(new GridLayoutManager(GridRecyclerViewActivity.this, 3));
        mRecyclerView.setAdapter(new GridRecycleAdapter(GridRecyclerViewActivity.this, new GridRecycleAdapter.OnClickItemListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(GridRecyclerViewActivity.this, "短按"+pos, Toast.LENGTH_SHORT).show();
            }
        }));

    }
}
