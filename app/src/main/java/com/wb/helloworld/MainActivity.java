package com.wb.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private Button btnTextView;
    private Button btn;
    private Button btnEditText;
    private Button btnMyEditText;
    private Button btnMySelfEditText;
    private Button btnUpEditText;
    private Button btnRadioBtn;
    private Button btnCheckBox;
    private Button btnImageView;
    private Button btnListView;
    private Button btnGridView;
    private Button btnRecyclerView;
    private Button btnWebView;
    private Button btnToast;
    private Button btnDialog;
    private Button btnProgress;
    private Button btnDialog2;
    private Button btnPop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTextView = findViewById(R.id.btn_textView_1);
        btn = findViewById(R.id.btn_1);
        btnEditText = findViewById(R.id.btn_editText_1);
        btnMyEditText = findViewById(R.id.btn_myEditText);
        btnMySelfEditText = findViewById(R.id.btn_myselfEditText);
        btnUpEditText = findViewById(R.id.btn_upEditText);
        btnRadioBtn = findViewById(R.id.btn_radio_1);
        btnCheckBox = findViewById(R.id.btn_checkBox_1);
        btnImageView = findViewById(R.id.btn_imageView_1);
        btnListView = findViewById(R.id.btn_listView_1);
        btnGridView = findViewById(R.id.btn_gridView_1);
        btnRecyclerView = findViewById(R.id.btn_RV_1);
        btnWebView = findViewById(R.id.btn_WV_1);
        btnToast = findViewById(R.id.btn_toast);
        btnDialog = findViewById(R.id.btn_dialog);
        btnProgress = findViewById(R.id.btn_progress);
        btnDialog2 = findViewById(R.id.btn_dialog2);
        btnPop = findViewById(R.id.btn_pop);
        setListener();
    }


    private void setListener(){
        Onclick onclick = new Onclick(MainActivity.this);
        btnTextView.setOnClickListener(onclick);
        btn.setOnClickListener(onclick);
        btnEditText.setOnClickListener(onclick);
        btnMyEditText.setOnClickListener(onclick);
        btnMySelfEditText.setOnClickListener(onclick);
        btnUpEditText.setOnClickListener(onclick);
        btnRadioBtn.setOnClickListener(onclick);
        btnCheckBox.setOnClickListener(onclick);
        btnImageView.setOnClickListener(onclick);
        btnListView.setOnClickListener(onclick);
        btnGridView.setOnClickListener(onclick);
        btnRecyclerView.setOnClickListener(onclick);
        btnWebView.setOnClickListener(onclick);
        btnToast.setOnClickListener(onclick);
        btnDialog.setOnClickListener(onclick);
        btnProgress.setOnClickListener(onclick);
        btnDialog2.setOnClickListener(onclick);
        btnPop.setOnClickListener(onclick);

    }
}
